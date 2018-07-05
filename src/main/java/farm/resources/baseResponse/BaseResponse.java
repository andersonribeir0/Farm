package farm.resources.baseResponse;

import lombok.Data;

@Data
public class BaseResponse {
    private final Object data;
    private final Boolean success;

    public BaseResponse() {
        this(null, false);
    }

    public BaseResponse(Object data, Boolean success) {
        this.data = data;
        this.success = success;
    }

}
