package com.vikshen.sportservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "matches")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private int id;


    @NotBlank(message = "Url video is mandatroy")
    @Column(name = "video")
    private String video;


    @NotNull(message = "Category is mandatory")

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_category")
    private Category category;

}
