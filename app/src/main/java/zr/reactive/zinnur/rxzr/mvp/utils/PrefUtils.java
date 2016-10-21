package zr.reactive.zinnur.rxzr.mvp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import zr.reactive.zinnur.rxzr.di.App;

/**
 * Created by Zinnur on 21.10.16.
 */

public class PrefUtils {

    private static final String PREF_NAME = "zr";

    public static SharedPreferences getPrefs() {
        return App.getComponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }
}
