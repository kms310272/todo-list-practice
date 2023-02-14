package todo.list.solo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoPatchDto {

    private long todoId;

    @NotBlank
    private String title;
    private int todoOrder;
    private boolean completed;
}
