package zr.reactive.zinnur.rxzr.mvp.presenters;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.Model;
import zr.reactive.zinnur.rxzr.mvp.views.View;

/**
 * Created by Zinnur on 21.10.16.
 */

public abstract class BasePresenter implements Presenter {

    @Inject
    protected Model model;

    @Inject
    protected CompositeSubscription compositeSubscription;

    public BasePresenter() {
        App.getComponent().inject(this);
    }

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

    protected abstract View getView();

    protected void showLoadingState() {
        getView().showLoading();
    }

    protected void hideLoadingState() {
        getView().hideLoading();
    }

}
