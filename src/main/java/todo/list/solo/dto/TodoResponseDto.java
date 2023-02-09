package todo.list.solo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TodoResponseDto {
    private long todoId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
