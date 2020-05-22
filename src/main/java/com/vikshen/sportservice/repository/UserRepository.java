package com.vikshen.sportservice.repository;

import com.vikshen.sportservice.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select *" +
            "from users " +
            "where users.username = :username and users.password = :password ",
            nativeQuery = true)
    User authority(@Param("username") String username, @Param("password") String password);

}
