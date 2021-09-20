package pl.todo.site.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.todo.site.model.Task;
import pl.todo.site.repository.TaskRepository;


@Slf4j
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Iterable<Task> getUserTasks(long id) {
        return taskRepository.findTasksByUserId(id);
    }


    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
