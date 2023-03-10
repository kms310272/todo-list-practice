package todo.list.solo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TODOS")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoId;

    @Column(nullable = false, length = 30)
    private String title;

    @Column
    private int todoOrder;

    @Column
    private boolean completed;

    private String uri;
}
