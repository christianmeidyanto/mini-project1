package com.miniproject.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
    @Query(value = "Select * from User where username = :username AND password = :password ", nativeQuery = true)
    User getUser(@Param("username") String username, @Param("password") String password);
}
