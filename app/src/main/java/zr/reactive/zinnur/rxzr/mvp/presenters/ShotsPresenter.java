package zr.reactive.zinnur.rxzr.mvp.presenters;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.mvp.utils.PageUtil;
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
                .subscribe(shots -> view.updateAdapter(shots), e -> {
                    getView().hideLoading();
                    e.printStackTrace();
                }, () -> {
                    Log.d("dribbble", " success");
                    getView().hideLoading();
                });
        addSubscription(subscription);
    }

    public void searchRequest(){
        Subscription subscription = model.search("rockylabs")
                .subscribe(shots -> {
                    view.clearAdapter();
                    view.updateAdapter(shots);
                    Log.d("shot - ", " " + shots.get(0).getTitle());
                }, e -> {
                    getView().hideLoading();
                    e.printStackTrace();
                }, () -> {
                    Log.d("dribbble", " success");
                    getView().hideLoading();
        });
        addSubscription(subscription);
    }

    public void onRefresh(){
        view.clearAdapter();
        request();
    }

    public int getPage(){
        int page = PageUtil.getPage(view.getShotsCount());
        Log.d("page ", " "+page);
        return page;
    }
}
