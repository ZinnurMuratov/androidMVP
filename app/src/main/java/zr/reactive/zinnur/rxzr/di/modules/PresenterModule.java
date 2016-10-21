package zr.reactive.zinnur.rxzr.di.modules;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Zinnur on 21.10.16.
 */
@Module

public class PresenterModule {

    @Provides
    CompositeSubscription provideCompositeSubscription() { return new CompositeSubscription();}
}
