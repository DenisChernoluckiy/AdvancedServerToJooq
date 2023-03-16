package advanced_server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomSuccessResponse<T> {

    private T data;
    private Integer statusCode;
    private Boolean success;
    private Integer error;
    private T codes;

    public static <T> ResponseEntity<CustomSuccessResponse> getSuccessWithData(T data) {
        return ResponseEntity.ok().body(new CustomSuccessResponse()
                .setData(data)
                .setSuccess(true)
                .setStatusCode(1));
    }

    public static <T> ResponseEntity<CustomSuccessResponse> handleException(Integer error,
                                                                            T errors,
                                                                            HttpStatus httpStatus) {
        return new ResponseEntity<>(
                new CustomSuccessResponse<>()
                        .setStatusCode(error)
                        .setSuccess(true)
                        .setCodes(errors), httpStatus);
    }

    public static <T> ResponseEntity<CustomSuccessResponse> handleException(Integer[] errors,
                                                                            HttpStatus httpStatus) {
        return new ResponseEntity(
                new CustomSuccessResponse<T>()
                        .setStatusCode(errors[0])
                        .setSuccess(true)
                        .setCodes((T) errors), httpStatus);
    }

    public static <T> CustomSuccessResponse<T> handleException(Integer[] errors) {
        return new CustomSuccessResponse<T>()
                .setStatusCode(errors[0])
                .setSuccess(true)
                .setCodes((T) errors);
    }
}