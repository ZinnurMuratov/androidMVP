package zr.reactive.zinnur.rxzr.ui.Fragments;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.di.App;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.mvp.presenters.Presenter;
import zr.reactive.zinnur.rxzr.mvp.presenters.ShotsPresenter;
import zr.reactive.zinnur.rxzr.mvp.views.ShotsView;
import zr.reactive.zinnur.rxzr.ui.adapters.OnLoadMoreListener;
import zr.reactive.zinnur.rxzr.ui.adapters.ShotsAdapter;

/**
 * Created by Zinnur on 31.10.16.
 */

public class ShotsFragment extends BaseFragment implements ShotsView{

    @Bind(R.id.shotsRV)
    protected RecyclerView recyclerViewShots;
    @Bind(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout swipeRefreshLayout;

    private ShotsAdapter adapter;

    @Inject
    ShotsPresenter presenter;


    @Override
    protected Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.onCreate(this);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shots, container, false);
        ButterKnife.bind(this,view);
        recyclerViewShots.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.onRefresh());
        presenter.request();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        searchItem.setOnMenuItemClickListener(menuItem -> {
            presenter.searchRequest();
            return false;
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean adapterIsNull() {
        boolean res;
        if (adapter != null){
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    @Override
    public void initAdapter(List<Shot> shots) {
        adapter = new ShotsAdapter(shots);
        recyclerViewShots.setAdapter(adapter);
        adapter.setLoadMoreListener(() -> {
            presenter.request();
        });
    }

    @Override
    public int getShotsCount() {
        if (!adapterIsNull()){
            return adapter.getItemCount();
        } else{
            return 0;
        }
    }

    @Override
    public void showShots(List<Shot> shots) {
    }

    @Override
    public void clearAdapter() {
        if (!adapterIsNull()) {
            adapter.clear();
        }
    }

    @Override
    public void updateAdapter(List<Shot> shots) {
        if (adapterIsNull()){
            initAdapter(shots);
        } else{
            adapter.update(shots);
        }
    }

}
