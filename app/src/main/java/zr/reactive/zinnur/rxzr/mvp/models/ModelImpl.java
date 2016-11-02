package zr.reactive.zinnur.rxzr.mvp.models;

import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import zr.reactive.zinnur.rxzr.api.ApiInterface;
import zr.reactive.zinnur.rxzr.api.DribbbleSearchService;
import zr.reactive.zinnur.rxzr.api.DribbbleServices;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.mvp.models.dto.UserLoginResponseEntity;
import zr.reactive.zinnur.rxzr.mvp.utils.InternetUtils;
import zr.reactive.zinnur.rxzr.mvp.utils.prefs.AuthPrefs;
import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 28.10.16.
 */

public class ModelImpl implements Model {

    private final Observable.Transformer schedulersTransformer;

    @Inject
    protected ApiInterface apiInterface;

    @Inject
    protected DribbbleServices dribbbleServices;

    @Inject
    protected DribbbleSearchService dribbbleSearchService;

    @Inject
    @Named(Const.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(Const.IO_THREAD)
    Scheduler ioThread;

    public ModelImpl() {
        App.getComponent().inject(this);
        schedulersTransformer = o -> ((Observable) o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @Override
    public Observable<UserLoginResponseEntity> signIn(String login, String password) {
        return apiInterface
                .signIn(login,password)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<Shot>> getShots(int page, String sort) {
        NullPointerException e = new NullPointerException();
        return dribbbleServices
                .getShots(page, Const.PAGE, sort)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<Shot>> search(String query) {
        return dribbbleSearchService
                .search(query)
                .compose(applySchedulers());
    }

    @Override
    public void storeToken(String token) {
        AuthPrefs.setToken(token);
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

}
