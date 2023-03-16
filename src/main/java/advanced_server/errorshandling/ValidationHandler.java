package advanced_server.errorshandling;

import advanced_server.dto.CustomSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Component
@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<Integer> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((someError) -> {
            String errorMessage = someError.getDefaultMessage();
            errors.add(ErrorEnum.getCodes(errorMessage).getCode());
        });
        return new ResponseEntity<>(new CustomSuccessResponse<>()
                .setStatusCode(errors.get(0))
                .setSuccess(true)
                .setCodes(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity handleConstraintViolation(ConstraintViolationException ex) {
        List<Integer> errors = new ArrayList<>();
        errors.add(ErrorEnum.getCodes(ex.getConstraintViolations().toString()).getCode());
        return new ResponseEntity<>(new CustomSuccessResponse<>()
                .setStatusCode(errors.get(0))
                .setSuccess(true)
                .setCodes(errors), HttpStatus.BAD_REQUEST);
    }
}

