package com.vikshen.sportservice.repository;

import com.vikshen.sportservice.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select * " +
            "from post p join matches m on p.id_match=m.id_match join category c on c.id_category=m.id_category" +
            " where c.url = :name ",
            nativeQuery = true)
    Page<Post> findByCategory(@Param("name")String name, Pageable pageable);

    @Query(value = "select count(*) from post",
            nativeQuery = true)
    int countPosts();

    //END THIS
//    @Query()
//    List<Post> findByName(String name);



}
