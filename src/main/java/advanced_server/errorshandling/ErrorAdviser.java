package advanced_server.errorshandling;

import advanced_server.dto.CustomSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
@Component
public class ErrorAdviser {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity customException(CustomException ex) {
        return CustomSuccessResponse.handleException(new Integer[]{
                (ex.getError().getCode())
        }, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomSuccessResponse> handleException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        Integer[] code = {ErrorEnum
                .getCodes(message)
                .getCode()};
        return CustomSuccessResponse.handleException(code[0], code, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomSuccessResponse> nullPointerException(NullPointerException ex) {
        Integer[] code = {ErrorEnum
                .getCodes(ValidationConstants.UNAUTHORIZED)
                .getCode()};
        return CustomSuccessResponse.handleException(code, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IOException.class)
    ResponseEntity<CustomSuccessResponse> ioException(IOException ex) {
        String message = ex.getMessage();
        Integer[] code = {ErrorEnum
                .getCodes(ValidationConstants.UNKNOWN)
                .getCode()};
        return CustomSuccessResponse.handleException(code, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    ResponseEntity<CustomSuccessResponse> fileNotFoundException(FileNotFoundException ex) {
        String message = ex.getMessage();
        Integer[] code = {ErrorEnum
                .getCodes(ValidationConstants.EXCEPTION_HANDLER_NOT_PROVIDED)
                .getCode()};
        return CustomSuccessResponse.handleException(code, HttpStatus.BAD_REQUEST);
    }
}
