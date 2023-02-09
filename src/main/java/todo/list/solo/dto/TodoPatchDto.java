package todo.list.solo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class TodoPatchDto {

    @NotBlank
    private String title;
    private int todoOrder;
    private boolean completed;
}
