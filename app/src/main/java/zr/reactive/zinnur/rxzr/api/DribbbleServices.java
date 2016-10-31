package zr.reactive.zinnur.rxzr.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;

/**
 * Created by Zinnur on 30.10.16.
 */

public interface DribbbleServices {

    @GET("shots")
    Observable<List<Shot>> getShots(@Query("page") int page, @Query("per_page") int number, @Query("sort") String sort);
}
