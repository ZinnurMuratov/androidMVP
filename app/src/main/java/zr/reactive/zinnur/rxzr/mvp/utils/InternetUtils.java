package zr.reactive.zinnur.rxzr.mvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import rx.Observable;
import zr.reactive.zinnur.rxzr.di.App;

/**
 * Created by Zinnur on 02.11.16.
 */

public class InternetUtils {

    @NonNull
    public static Observable<Boolean> isInternetOn() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) App.getComponent().getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }
}
