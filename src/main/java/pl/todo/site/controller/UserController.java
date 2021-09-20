package pl.todo.site.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.todo.site.model.User;
import pl.todo.site.service.UserService;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

}
