package zr.reactive.zinnur.rxzr.mvp.models.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zinnur on 28.10.16.
 */

public class AbsDTO {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
