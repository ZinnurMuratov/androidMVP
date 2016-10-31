package zr.reactive.zinnur.rxzr.mvp.models.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zinnur on 29.10.16.
 */

public class UserEntity {

    private final
    @SerializedName("id")
    String id;

    public UserEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}