package zr.reactive.zinnur.rxzr.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import zr.reactive.zinnur.rxzr.di.modules.ContextModule;
import zr.reactive.zinnur.rxzr.di.modules.ModelModule;
import zr.reactive.zinnur.rxzr.di.modules.PresenterModule;
import zr.reactive.zinnur.rxzr.di.modules.SplashViewModule;
import zr.reactive.zinnur.rxzr.mvp.models.ModelImpl;
import zr.reactive.zinnur.rxzr.mvp.presenters.BasePresenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.ShotsPresenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.SignInPresenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.SplashPresenter;
import zr.reactive.zinnur.rxzr.ui.Fragments.ShotsFragment;
import zr.reactive.zinnur.rxzr.ui.Fragments.SignInFragment;
import zr.reactive.zinnur.rxzr.ui.adapters.ShotsAdapter;

/**
 * Created by Zinnur on 21.10.16.
 */
@Singleton
@Component(modules = {PresenterModule.class, ContextModule.class, SplashViewModule.class, ModelModule.class})
public interface AppComponent {

    Context getContext();

    void inject(SplashPresenter splashPresenter);

    void inject(SignInPresenter signInPresenter);

    void inject(SignInFragment signInFragment);

    void inject(BasePresenter basePresenter);

    void inject(ModelImpl model);

    void inject(ShotsFragment shotsFragment);

    void inject(ShotsPresenter shotsPresenter);


}
