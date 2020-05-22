package com.vikshen.sportservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Getter @Setter @NoArgsConstructor @ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private int id;

    @NotBlank(message = "Posts name is mandatory")
    @Column(name = "name_post")
    private String namePost;

    @NotBlank(message = "Posts image is mandatory")
    @Column(name="img")
    private String image;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;

    @Column(name="date")
    private String date;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_match")
    private Match match;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "id_post")
    private List<Comment> comments;

}
