package com.vikshen.sportservice.repository;

import com.vikshen.sportservice.entity.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select c.* " +
            "from comment c join post p on c.id_post=p.id_post " +
            "where p.id_post = :idPost order by c.id_comment desc",
    nativeQuery = true)
    List<Comment> findByPost(@Value("idPost") int idPost);



}
