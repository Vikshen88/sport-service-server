package com.vikshen.sportservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int id;

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name="url")
    private String url;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.REFRESH}, mappedBy = "category")
    public List<Match> matches;

}
