package zr.reactive.zinnur.rxzr.di;

import android.app.Application;
import android.util.Log;


import zr.reactive.zinnur.rxzr.di.modules.ContextModule;

/**
 * Created by Zinnur on 21.10.16.
 */

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

}
