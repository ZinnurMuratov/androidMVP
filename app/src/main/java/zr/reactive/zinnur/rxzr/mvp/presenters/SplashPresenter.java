package zr.reactive.zinnur.rxzr.mvp.presenters;

import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import rx.Observable;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.utils.AuthUtils;
import zr.reactive.zinnur.rxzr.mvp.views.SplashView;

/**
 * Created by Zinnur on 21.10.16.
 */

public class SplashPresenter extends BasePresenter {

    private SplashView view;

    @Inject
    public SplashPresenter(){

    }

    public SplashPresenter(SplashView view){
        App.getComponent().inject(this);
        this.view = view;
    }

    @Override
    public SplashView getView() {
        return view;
    }

    public void checkAuthorized() {
        final Observable<String> getTokenObservable = Observable.create(subscriber -> subscriber.onNext(AuthUtils.getToken()));
        getTokenObservable.subscribe(token -> {
            view.setAuthorized(!TextUtils.isEmpty(token));
        });
    }
}
