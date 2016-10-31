package zr.reactive.zinnur.rxzr.ui.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.ui.Fragments.ShotsFragment;
import zr.reactive.zinnur.rxzr.ui.Fragments.StartFragment;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private FragmentManager fragmentManager;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("Design");
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new ShotsFragment(), false);
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
}
