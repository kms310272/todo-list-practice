package todo.list.solo.exception;

import lombok.Getter;

public enum ExceptionCode {

    TODO_NOT_FOUND(404, "There is no todo"),
    TODO_EXISTS(409, "already exist" );

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
