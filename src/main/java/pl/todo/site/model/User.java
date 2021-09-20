package pl.todo.site.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Pattern(regexp="[A-Za-z]")
    private String name;

    @NotBlank
    @Pattern(regexp="[_a-zA-Z0-9-]+(\\\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*\\\\.([a-zA-Z]{2,})")
    private String email;

    @NotBlank
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,32}$") //duza litera mala litera znak specjalny cyfra 8-32 znaki
    private String password;

    @ManyToMany
    @JoinTable
    private List<Task> taskList = new ArrayList<>();

    public User(String name,
                String email,
                String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }
}
