package zr.reactive.zinnur.rxzr.mvp.presenters;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.UserLoginResponseEntity;
import zr.reactive.zinnur.rxzr.mvp.views.SignInView;
import zr.reactive.zinnur.rxzr.mvp.views.View;
import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 24.10.16.
 */

public class SignInPresenter extends BasePresenter {


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
