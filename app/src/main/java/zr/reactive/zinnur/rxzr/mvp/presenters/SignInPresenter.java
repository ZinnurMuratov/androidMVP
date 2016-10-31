package zr.reactive.zinnur.rxzr.mvp.presenters;

import android.app.Activity;
import android.text.style.SubscriptSpan;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;
import javax.security.auth.callback.Callback;

import rx.Observer;
import rx.Subscription;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.AbsDTO;
import zr.reactive.zinnur.rxzr.mvp.models.dto.UserLoginResponseEntity;
import zr.reactive.zinnur.rxzr.mvp.presenters.mappers.AbsMapper;
import zr.reactive.zinnur.rxzr.mvp.presenters.vo.AbsVO;
import zr.reactive.zinnur.rxzr.mvp.utils.AuthUtils;
import zr.reactive.zinnur.rxzr.mvp.views.SignInView;
import zr.reactive.zinnur.rxzr.mvp.views.View;
import zr.reactive.zinnur.rxzr.other.Const;
import zr.reactive.zinnur.rxzr.ui.Activities.StartActivityCallback;

/**
 * Created by Zinnur on 24.10.16.
 */

public class SignInPresenter extends BasePresenter {

    @Inject
    protected AbsMapper absMapper;

    private static String TAG = SignInPresenter.class.getSimpleName();

    private SignInView view;

    @Inject
    public SignInPresenter(){}

    public void onCreate(SignInView view) {
        App.getComponent().inject(this);
        this.view = view;
    }

    @Override
    protected View getView() {
        return view;
    }

    public void onSignBtnClick(){
        getView().showLoading();
        Subscription subscription = model.signIn(Const.LOGIN,Const.PASSWORD)
                .subscribe(new Observer<UserLoginResponseEntity>() {

                    @Override
                    public void onCompleted() {
                        getView().hideLoading();
                        view.startMainActivity();
                    }

                    @Override
                    public void onError(Throwable e) {
                       e.printStackTrace();
                        getView().hideLoading();
                    }

                    @Override
                    public void onNext(UserLoginResponseEntity user) {
                        if (user != null && user.getUser().getId() != null){
                            model.storeToken(user.getUser().getId());
                        }
                    }


                });
        addSubscription(subscription);
    }




}
