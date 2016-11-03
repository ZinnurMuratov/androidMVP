package zr.reactive.zinnur.rxzr.other.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.annimon.stream.function.Function;

import zr.reactive.zinnur.rxzr.di.App;

/**
 * Created by Zinnur on 21.10.16.
 */

public class PrefUtils {

    private static final String PREF_NAME = "zr";
    private static SharedPreferences preferences;

    public static SharedPreferences getPrefs() {
        preferences = App.getComponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences;
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }

    public static void clear(){
        getEditor().clear().commit();
    }


    public static void transact(Function<SharedPreferences.Editor, SharedPreferences.Editor> action) {
        action.apply(getEditor()).apply();
    }


}
