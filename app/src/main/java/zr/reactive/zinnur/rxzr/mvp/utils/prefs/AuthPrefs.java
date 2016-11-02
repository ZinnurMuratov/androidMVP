package zr.reactive.zinnur.rxzr.mvp.utils.prefs;

import android.support.annotation.Nullable;

/**
 * Created by Zinnur on 21.10.16.
 */

public class AuthPrefs {

    private static final String TOKEN = "token";

    public static @Nullable String getToken() {
        return PrefUtils.getPrefs().getString(TOKEN, null);
    }

    public static void setToken(String token) {
        PrefUtils.transact( p -> p.putString(TOKEN,token));
    }
}
