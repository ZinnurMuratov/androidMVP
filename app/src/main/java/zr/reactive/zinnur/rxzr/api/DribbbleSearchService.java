package zr.reactive.zinnur.rxzr.api;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;

/**
 * Created by Zinnur on 31.10.16.
 */

public interface DribbbleSearchService {
    String ENDPOINT = "https://dribbble.com/";
    int PER_PAGE_DEFAULT = 12;

    @GET("search")
    Observable<List<Shot>> search(@Query("q") String query);

}
