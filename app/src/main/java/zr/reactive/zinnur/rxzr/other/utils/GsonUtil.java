package zr.reactive.zinnur.rxzr.other.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 02.11.16.
 */

public class GsonUtil {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null)
            gson = new GsonBuilder()
                    .setDateFormat(Const.JSON_DATE_FORMAT) // 2016-05-31 05:41:48
                    .create();
        return gson;
    }




}
