package zr.reactive.zinnur.rxzr.mvp.views;

import java.util.List;

import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;

/**
 * Created by Zinnur on 31.10.16.
 */

public interface ShotsView extends View {

    void showShots(List<Shot> shots);

    void clearAdapter();

    void updateAdapter(List<Shot> shots);

    boolean adapterIsNull();

    void initAdapter(List<Shot> shots);

    int getShotsCount();
}
