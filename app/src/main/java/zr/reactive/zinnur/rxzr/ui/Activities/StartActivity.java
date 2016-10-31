package zr.reactive.zinnur.rxzr.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.ui.Fragments.SignInFragment;
import zr.reactive.zinnur.rxzr.ui.Fragments.StartFragment;

/**
 * Created by Zinnur on 21.10.16.
 */

public class StartActivity extends AppCompatActivity implements StartActivityCallback{

    private static String TAG = "TAG";
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new StartFragment(), false);
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void startSignInFragment() {
        replaceFragment(new SignInFragment(), true);
    }

    @Override
    public void startSignUpFragment() {

    }

    @Override
    public void startMainActivity() {
        startActivityForResult(new Intent(this, MainActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }


}
