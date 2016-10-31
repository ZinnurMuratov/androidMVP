package zr.reactive.zinnur.rxzr.ui.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.presenters.BasePresenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.Presenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.SignInPresenter;
import zr.reactive.zinnur.rxzr.mvp.views.SignInView;
import zr.reactive.zinnur.rxzr.ui.Activities.StartActivityCallback;

/**
 * Created by Zinnur on 21.10.16.
 */

public class SignInFragment extends BaseFragment implements SignInView {

    @Bind(R.id.sign_in_btn)
    protected Button signInBtn;

    @Bind(R.id.login_input)
    protected EditText loginEt;

    @Bind(R.id.pass_input)
    protected EditText passwordEt;

    @Inject SignInPresenter presenter;

    private  ProgressDialog progressDialog;

    private StartActivityCallback activityCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            activityCallback = (StartActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement activityCallback");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.onCreate(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        initProgressDialog();
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.sign_in_btn)
    public void onClickSignIn(){
        if (presenter != null){
            presenter.onSignBtnClick();
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {
        progressDialog.show();;
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(signInBtn, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }

    @Override
    public void startMainActivity() {
        activityCallback.startMainActivity();
    }

    public void initProgressDialog(){
        progressDialog = new ProgressDialog(getActivity(), R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
    }






}
