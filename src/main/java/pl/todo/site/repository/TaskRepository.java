package pl.todo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.todo.site.model.Task;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Iterable<Task> findTasksByUserId(long id);
}
