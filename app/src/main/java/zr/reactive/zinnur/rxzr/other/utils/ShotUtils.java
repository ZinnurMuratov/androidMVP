package zr.reactive.zinnur.rxzr.other.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Zinnur on 04.11.16.
 */

public class ShotUtils {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}
