package pl.todo.site.controller;


import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import pl.todo.site.model.Task;
import pl.todo.site.service.TaskService;



@RestController
@AllArgsConstructor
@RequestMapping("/users/{id}/tasks")
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public Iterable<Task> getAll(@PathVariable long id){
    return taskService.getUserTasks(id);
    }

    @PostMapping
    public Task add(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping
    public void deleteTask  (@RequestParam long id){
        taskService.deleteTask(id);
    }
}

