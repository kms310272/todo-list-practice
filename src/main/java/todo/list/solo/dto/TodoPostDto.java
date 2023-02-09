package todo.list.solo.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class TodoPostDto {
    @NotBlank
    private String title;
    private int todoOrder;
    private boolean completed;
}
