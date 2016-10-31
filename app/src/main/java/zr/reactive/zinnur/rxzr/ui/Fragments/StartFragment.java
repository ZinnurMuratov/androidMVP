package zr.reactive.zinnur.rxzr.ui.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.ui.Activities.StartActivity;
import zr.reactive.zinnur.rxzr.ui.Activities.StartActivityCallback;

/**
 * Created by Zinnur on 22.10.16.
 */

public class StartFragment extends Fragment {
    @Bind(R.id.sign_in_btn)
    protected Button signInBtn;

    @Bind(R.id.sign_up_btn)
    protected Button signUpBtn;

    private StartActivityCallback startActivityCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            startActivityCallback = (StartActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement activityCallback");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.sign_in_btn)
    public void onSignBtnClick(View v){
        startActivityCallback.startSignInFragment();
    }
}
