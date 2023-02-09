package todo.list.solo.service;

import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import todo.list.solo.entity.Todo;
import todo.list.solo.exception.BusinessLogicException;
import todo.list.solo.exception.ExceptionCode;
import todo.list.solo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public Todo createTodoList(Todo todo) {

        verifiedTodo(todo.getTodoId());

        return todoRepository.save(todo);
    }

    public Todo updateTodoList(Todo todo) {

        Todo findTodo = findVerifiedTodo(todo.getTodoId());

        Optional.ofNullable(todo.getTitle()).ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder()).ifPresent(order -> findTodo.setTodoOrder(order));
        Optional.ofNullable(todo.isCompleted()).ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }
    public Todo readTodoList(long todoId) {

        return findVerifiedTodo(todoId);
    }

    public List<Todo> readTodoLists() {

        return todoRepository.findAll();
    }

    public void deleteTodoList(long todoId) {
        Todo findTodo = findVerifiedTodo(todoId);
        todoRepository.delete(findTodo);
    }

    public void deleteTodoLists() {
        todoRepository.deleteAll();
    }

    /* todo의 값이 있는지 검증 */
    public Todo findVerifiedTodo(long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        return optionalTodo.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
    }

    /* todo에 이미 있는 값인지 검증 */
    public void verifiedTodo(long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if(optionalTodo.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.TODO_EXISTS);
        }
    }
}
