package zr.reactive.zinnur.rxzr.mvp.presenters;

import zr.reactive.zinnur.rxzr.mvp.views.View;

/**
 * Created by Zinnur on 21.10.16.
 */

public abstract class BasePresenter implements Presenter {
    @Override
    public void onStop() {

    }

    protected abstract View getView();
}
