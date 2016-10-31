package zr.reactive.zinnur.rxzr.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zr.reactive.zinnur.rxzr.api.ApiInterface;
import zr.reactive.zinnur.rxzr.api.ApiModule;
import zr.reactive.zinnur.rxzr.api.DribbbleSearchService;
import zr.reactive.zinnur.rxzr.api.DribbbleServices;
import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 29.10.16.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    ApiInterface provideApiInterface() {
        return ApiModule.getApiInterface(Const.BASE_URL);
    }

    @Provides
    @Singleton
    DribbbleServices provideDribbbleServices() {
        return ApiModule.getDribbbleApi(Const.DRIBBBLE_URL);
    }

    @Provides
    @Singleton
    DribbbleSearchService provideDribbbleSearchService() {
        return ApiModule.getDribbbleSearchApi();
    }

    @Provides
    @Singleton
    @Named(Const.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(Const.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }
}
