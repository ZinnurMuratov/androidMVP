package zr.reactive.zinnur.rxzr.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import zr.reactive.zinnur.rxzr.di.modules.ContextModule;
import zr.reactive.zinnur.rxzr.di.modules.PresenterModule;
import zr.reactive.zinnur.rxzr.di.modules.SplashViewModule;
import zr.reactive.zinnur.rxzr.mvp.presenters.SplashPresenter;

/**
 * Created by Zinnur on 21.10.16.
 */
@Singleton
@Component(modules = {PresenterModule.class, ContextModule.class, SplashViewModule.class})
public interface AppComponent {

    Context getContext();

    void inject(SplashPresenter splashPresenter);


}
