package conference.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorValid>> handleError(MethodArgumentNotValidException ex) {

        var err = ex.getBindingResult().getFieldErrors().stream().map(
                it -> new ErrorValid(it.getField(), it.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    class ErrorValid {
        private String path;
        private String message;
    }
}
