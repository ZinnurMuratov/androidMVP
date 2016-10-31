package zr.reactive.zinnur.rxzr.mvp.models.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zinnur on 29.10.16.
 */

public class UserLoginResponseEntity extends AbsResponseEntity {
    private  @SerializedName("user") List<UserEntity> user;


    public UserLoginResponseEntity(String status, String message, List<UserEntity> user) {
        super(status,message);
        this.user = user;
    }

    public UserLoginResponseEntity(String status, String message) {
        super(status,message);

    }


    public UserEntity getUser() {
        return user.isEmpty() ? null : user.get(0);
    }



}
