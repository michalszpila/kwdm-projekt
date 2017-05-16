package eszpila.org.kwdm_projekt.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Michał on 2017-05-16.
 */

public class SuccessResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private Integer code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
