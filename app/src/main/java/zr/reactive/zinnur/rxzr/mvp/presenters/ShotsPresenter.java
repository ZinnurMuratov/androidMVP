package zr.reactive.zinnur.rxzr.mvp.presenters;

import android.util.Log;

import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.other.utils.PageUtil;
import zr.reactive.zinnur.rxzr.other.utils.prefs.ShotsPrefs;
import zr.reactive.zinnur.rxzr.mvp.views.ShotsView;
import zr.reactive.zinnur.rxzr.mvp.views.View;

/**
 * Created by Zinnur on 31.10.16.
 */

public class ShotsPresenter extends BasePresenter {

    private ShotsView view;

    @Override
    protected View getView() {
        return view;
    }


    @Inject
    public ShotsPresenter(){}

    public void onCreate(ShotsView view) {
        App.getComponent().inject(this);
        this.view = view;

    }

    public void request(){
        getView().showLoading();
        Subscription subscription = model.getShots(getPage(),"popular")
                .subscribe(this::onNextGetShots, this::onError, () -> getView().hideLoading());
        addSubscription(subscription);
    }

    public void searchRequest(){
        getView().showLoading();
        Subscription subscription = model.search("rockylabs")
                .subscribe(this::onNextRefreshShots, this::onError, () -> getView().hideLoading());
        addSubscription(subscription);
    }

    public void onRefresh(){
        getView().showLoading();
        Subscription subscription = model.getShots(getPage(),"popular")
                .subscribe(this::onNextRefreshShots, this::onError, () -> getView().hideLoading());
        addSubscription(subscription);
    }

    public int getPage(){
        int page = PageUtil.getPage(view.getShotsCount());
        Log.d("page ", " "+page);
        return page;
    }

    public void onError(Throwable e){
        getView().hideLoading();
        e.printStackTrace();
        if(e instanceof UnknownHostException) {
            view.showError("Network connection unavailable");
        }
    }

    public void onNextRefreshShots(List<Shot> shots){
        view.clearAdapter();
        view.updateAdapter(shots);
    }

    public void onNextGetShots(List<Shot> shots){
        view.updateAdapter(shots);
        ShotsPrefs.setShots(shots);
    }


    public void showCachedShots(){
        List<Shot> shots = ShotsPrefs.getShots();
        if (shots != null){
            view.updateAdapter(shots);
        }
    }

}
