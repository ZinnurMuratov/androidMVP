package zr.reactive.zinnur.rxzr.api;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zr.reactive.zinnur.rxzr.mvp.models.dto.AbsDTO;
import zr.reactive.zinnur.rxzr.mvp.models.dto.UserLoginResponseEntity;

/**
 * Created by Zinnur on 28.10.16.
 */

public interface ApiInterface {

    @POST("api/signin")
    Observable<UserLoginResponseEntity> signIn(@Query("login") String login,
                                                         @Query("password") String password);

}
