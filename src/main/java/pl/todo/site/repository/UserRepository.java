package pl.todo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.todo.site.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,  Long> {
    Optional<User> findByEmail(String email);

}