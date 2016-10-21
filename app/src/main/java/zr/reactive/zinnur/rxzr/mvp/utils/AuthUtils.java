package zr.reactive.zinnur.rxzr.mvp.utils;

/**
 * Created by Zinnur on 21.10.16.
 */

public class AuthUtils {

    private static final String TOKEN = "token";

    public static String getToken() {
        return PrefUtils.getPrefs().getString(TOKEN, "");
    }

    public static void setToken(String token) {
        PrefUtils.getEditor().putString(TOKEN, token).commit();
    }
}
