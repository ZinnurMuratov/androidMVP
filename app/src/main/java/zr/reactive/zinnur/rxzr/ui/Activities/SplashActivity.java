package zr.reactive.zinnur.rxzr.ui.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
;
import zr.reactive.zinnur.rxzr.di.modules.DaggerSplashViewComponent;
import zr.reactive.zinnur.rxzr.di.modules.SplashViewComponent;
import zr.reactive.zinnur.rxzr.di.modules.SplashViewModule;
import zr.reactive.zinnur.rxzr.mvp.presenters.SplashPresenter;
import zr.reactive.zinnur.rxzr.mvp.views.SplashView;

public class SplashActivity extends AppCompatActivity implements SplashView {


    @Inject
    protected SplashPresenter presenter;

    private SplashViewComponent viewComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (viewComponent == null){
            viewComponent = DaggerSplashViewComponent.builder()
                    .splashViewModule( new SplashViewModule(this))
                    .build();
        }
        if (viewComponent != null){
            viewComponent.inject(this);
        }


        presenter.checkAuthorized();
    }

    @Override
    public void setAuthorized(boolean isAuthorized) {
        startActivityForResult(new Intent(this, isAuthorized ? MainActivity.class : StartActivity.class), 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
