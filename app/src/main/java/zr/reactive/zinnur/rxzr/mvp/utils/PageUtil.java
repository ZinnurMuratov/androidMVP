package zr.reactive.zinnur.rxzr.mvp.utils;

import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 31.10.16.
 */

public class PageUtil {

    public static int getPage(int shotCounts){
        int page = 0;
        page = shotCounts / Const.PAGE;
        return page + 1;
    }
}
