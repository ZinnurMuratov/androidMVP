package zr.reactive.zinnur.rxzr.di.modules;

import javax.inject.Singleton;

import dagger.Component;
import zr.reactive.zinnur.rxzr.ui.Activities.SplashActivity;

/**
 * Created by Zinnur on 21.10.16.
 */

@Singleton
@Component(modules = {SplashViewModule.class})
public interface SplashViewComponent {
    void inject (SplashActivity splashActivity);
}
