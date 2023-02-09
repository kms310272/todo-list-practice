package todo.list.solo.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import todo.list.solo.exception.BusinessLogicException;
import todo.list.solo.response.Error;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    public Error handleException(MethodArgumentNotValidException e) {
        return Error.of(e.getBindingResult());
    }
    @ExceptionHandler
    public Error handleBusinessLogicException(BusinessLogicException e){
        return Error.of(e.getExceptionCode());
    }
}
