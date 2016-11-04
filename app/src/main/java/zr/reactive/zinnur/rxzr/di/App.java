package zr.reactive.zinnur.rxzr.di;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;


import com.squareup.leakcanary.LeakCanary;

import zr.reactive.zinnur.rxzr.di.modules.ContextModule;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

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
        initLeakCanary();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    private void initLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        enabledStrictMode();
        LeakCanary.install(this);
    }
    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }

}
