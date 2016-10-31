package zr.reactive.zinnur.rxzr.mvp.models;

import java.util.List;

import retrofit2.Callback;
import rx.Observable;
import zr.reactive.zinnur.rxzr.mvp.models.dto.AbsDTO;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.mvp.models.dto.UserLoginResponseEntity;

/**
 * Created by Zinnur on 28.10.16.
 */

public interface Model {

    Observable<UserLoginResponseEntity> signIn(String login, String password);

    Observable<List<Shot>> getShots(int page, String sort);

    Observable<List<Shot>> search(String query);

    void storeToken(String token);

}
