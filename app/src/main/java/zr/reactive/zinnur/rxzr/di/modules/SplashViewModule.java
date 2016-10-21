package zr.reactive.zinnur.rxzr.di.modules;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import zr.reactive.zinnur.rxzr.mvp.presenters.SplashPresenter;
import zr.reactive.zinnur.rxzr.mvp.views.SplashView;

/**
 * Created by Zinnur on 21.10.16.
 */

@Module
public class SplashViewModule {

    private SplashView view;

    public SplashViewModule(SplashView view) {
        this.view = view;
    }

    @Provides
    SplashPresenter provideSplashPresenter(){
        return new SplashPresenter(view);
    }
}
