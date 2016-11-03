package zr.reactive.zinnur.rxzr.other.utils.prefs;

import android.support.annotation.Nullable;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;
import zr.reactive.zinnur.rxzr.other.utils.GsonUtil;

/**
 * Created by Zinnur on 02.11.16.
 */

public class ShotsPrefs {
    private static final String SHOTS = "shots";

    public static @Nullable List<Shot> getShots() {
        return GsonUtil.getGson().fromJson(PrefUtils.getPrefs().getString(SHOTS, null), getType());
    }

    public static void setShots(List<Shot> shots) {
        PrefUtils.transact(prefs -> prefs.putString(SHOTS, GsonUtil.getGson().toJson(shots)));
    }

    private static Type getType(){
        return new TypeToken<List<Shot>>() {}.getType();
    }
}
