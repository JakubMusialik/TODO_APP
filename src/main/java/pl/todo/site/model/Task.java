package pl.todo.site.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max=255)
    private String description;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    private boolean isImportant;

    @Future
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public Task(String description,
                User user,
                boolean isImportant,
                Date dueDate) {
        this.description = description;
        this.user = user;
        this.isImportant = isImportant;
        this.dueDate = dueDate;
    }
}
