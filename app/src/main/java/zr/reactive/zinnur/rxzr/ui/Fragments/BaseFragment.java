package zr.reactive.zinnur.rxzr.ui.Fragments;

import android.support.v4.app.Fragment;

import zr.reactive.zinnur.rxzr.mvp.presenters.Presenter;

/**
 * Created by Zinnur on 24.10.16.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract Presenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}
