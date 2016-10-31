package zr.reactive.zinnur.rxzr.mvp.models.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Zinnur on 31.10.16.
 */

public class Images implements Serializable {
    @SerializedName("hidpi") private String hidpi;
    @SerializedName("teaser") private String teaser;
    @SerializedName("normal") private String normal;

    public Images(String hidpi, String teaser, String normal) {
        this.hidpi = hidpi;
        this.teaser = teaser;
        this.normal = normal;
    }

    public String getHidpi() {
        return hidpi;
    }

    public String getTeaser() {
        return teaser;
    }

    public String getNormal() {
        return normal;
    }
}
