package ru.denfad.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.healthcare.models.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.login = :login and u.password = :password")
    User findUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

}
