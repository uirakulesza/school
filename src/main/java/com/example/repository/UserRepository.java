package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.User;
@Repository

public interface UserRepository extends JpaRepository<User, Integer>{
	
	/*@Query("select u from User u where u.enabled = true")
    public List<User> findAllByEnabledIsTrue();

    @Query("select u from User u left join fetch u.roles where lower(u.username) like lower(:username) and u.enabled = true")
    public User findByUsernameAndEnabled(@Param("username") String username);

    @Query("select u from User u left join fetch u.roles where u.id = :id")
    public Optional<User> findUserById(@Param("id") Integer id);

    @Modifying
    @Query("update User u set u.enabled = false where u.id = :id")
    public void deleteUserById(@Param("id") Integer id);

    @Query("select count(u) > 0 from User u where lower(u.username) like lower(:username)")
    public boolean existsByUsernameLike(@Param("username") String username); */
}
