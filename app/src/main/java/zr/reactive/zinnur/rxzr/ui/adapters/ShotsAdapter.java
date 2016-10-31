package zr.reactive.zinnur.rxzr.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
import zr.reactive.zinnur.rxzr.R;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;

/**
 * Created by Zinnur on 31.10.16.
 */

public class ShotsAdapter extends RecyclerView.Adapter<ShotsAdapter.ViewHolder> {



    protected List<Shot> list = null;
    OnLoadMoreListener loadMoreListener;
    boolean isLoading = false, isMoreDataAvailable = true;

    public ShotsAdapter(List<Shot> lists) {
        this.list = lists;
    }

    public void update(final List<Shot> shots){
        list.addAll(shots);
        notifyDataSetChanged();
        isLoading = false;
    }


    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public ShotsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shots_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ShotsAdapter.ViewHolder holder, int position) {
        holder.populate(list.get(position));
        if( position >= getItemCount()-1 && isMoreDataAvailable && !isLoading && loadMoreListener!=null){
            isLoading = true;
            loadMoreListener.onLoadMore();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.shot_image_view)
        protected ImageView shotsImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void populate(Shot shot){
            Glide.with(itemView.getContext())
                    .load(shot.getImages().getNormal())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .crossFade()
                    .into(shotsImageView);
        }
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }
}
