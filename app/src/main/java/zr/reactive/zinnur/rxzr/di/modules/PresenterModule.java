package zr.reactive.zinnur.rxzr.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import zr.reactive.zinnur.rxzr.mvp.models.Model;
import zr.reactive.zinnur.rxzr.mvp.models.ModelImpl;

/**
 * Created by Zinnur on 21.10.16.
 */
@Module

public class PresenterModule {

    @Provides
    @Singleton
    Model provideModel() {
        return new ModelImpl();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() { return new CompositeSubscription();}
}
