package zr.reactive.zinnur.rxzr.other.utils;

import zr.reactive.zinnur.rxzr.other.utils.prefs.ShotsPrefs;
import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 31.10.16.
 */

public class PageUtil {

    public static int getPage(int shotCounts){
        int page = 0;
        int cachedPages = 0;
        if (ShotsPrefs.getShots() != null){
            cachedPages = 10;
        }
        page = (shotCounts - cachedPages) / Const.PAGE;
        return page + 1;
    }
}
