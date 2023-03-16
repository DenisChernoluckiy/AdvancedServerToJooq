package advanced_server.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseSuccessResponse {

    private Integer statusCode;
    private Boolean success;

    public static BaseSuccessResponse ok() {
        return new BaseSuccessResponse()
                .setSuccess(true)
                .setStatusCode(1);
    }

    public static BaseSuccessResponse fail() {
        return new BaseSuccessResponse()
                .setSuccess(true)
                .setStatusCode(1);
    }
}
