package todo.list.solo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import todo.list.solo.dto.TodoPatchDto;
import todo.list.solo.dto.TodoPostDto;
import todo.list.solo.dto.TodoResponseDto;
import todo.list.solo.entity.Todo;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
    Todo todoPostDtoToTodos(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodos(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    List<TodoResponseDto> todosToTodoResponseDto(List<Todo> todos);
}
