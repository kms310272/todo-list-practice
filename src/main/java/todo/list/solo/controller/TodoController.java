package todo.list.solo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todo.list.solo.dto.TodoPatchDto;
import todo.list.solo.dto.TodoPostDto;
import todo.list.solo.entity.Todo;
import todo.list.solo.mapper.TodoMapper;
import todo.list.solo.service.TodoService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
@Validated
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity createTodoList(@Valid @RequestBody TodoPostDto todoPostDto) {

        Todo todo = mapper.todoPostDtoToTodos(todoPostDto);
        Todo response = todoService.createTodoList(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodoList(@PathVariable("todo-id") @Positive long todoId) {

        Todo response = todoService.readTodoList(todoId);
        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodoLists() {

        List<Todo> response =  todoService.readTodoLists();

        return new ResponseEntity<>(mapper.todosToTodoResponseDto(response), HttpStatus.OK);
    }

    @PatchMapping("{todo-id}")
    public ResponseEntity patchTodoList (@PathVariable("todo-id") @Positive long todoId,
                                         @Valid @RequestBody TodoPatchDto todoPatchDto) {

        Todo todo = mapper.todoPatchDtoToTodos(todoPatchDto);
        Todo response = todoService.updateTodoList(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @DeleteMapping("{todo-id}")
    public ResponseEntity deleteTodoList (@PathVariable("todo-id") @Positive long todoId) {
        todoService.deleteTodoList(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodoLists () {
        todoService.deleteTodoLists();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
