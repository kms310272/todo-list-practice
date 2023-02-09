package todo.list.solo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.list.solo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
