package com.vikshen.sportservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comment")
@Getter @Setter @NoArgsConstructor @ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Date date;


    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "id_post")
    private int idPost;

}
