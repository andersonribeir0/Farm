package farm.resources.baseResponse;

public class BaseResponse {
    private Object data;
    private Boolean success;

    public BaseResponse() {
    }

    public BaseResponse(Object data, Boolean success) {
        this.data = data;
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data='" + data + '\'' +
                ", success=" + success +
                '}';
    }
}
