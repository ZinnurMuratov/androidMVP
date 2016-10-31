package zr.reactive.zinnur.rxzr.mvp.models.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Zinnur on 29.10.16.
 */

public class AbsResponseEntity implements Serializable {
    private final @SerializedName("status") String status;
    private final @SerializedName("description") String message;

    public AbsResponseEntity(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public boolean statusOk() {
        return "ok".equalsIgnoreCase(status);
    }

    public String getMessage() {
        return message;
    }


}
