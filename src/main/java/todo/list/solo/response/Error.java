package todo.list.solo.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import todo.list.solo.exception.ExceptionCode;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Error {
    private int status;
    private String message;
    private List<FieldError> fieldErrors;

    public Error(int status, String message, List<FieldError> fieldErrors) {
        this.status = status;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public static Error of(BindingResult bindingResult) {
        return new Error(HttpStatus.BAD_REQUEST.value(), null, FieldError.of(bindingResult));
    }

    public static Error of(ExceptionCode exceptionCode) {
        return new Error(exceptionCode.getStatus(), exceptionCode.getMessage(), null);
    }
    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String message;

        private FieldError(String field, Object rejectedValue, String message) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.message = message;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
