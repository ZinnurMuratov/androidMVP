package zr.reactive.zinnur.rxzr.mvp.models.dto;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Html;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.text.Html.FROM_HTML_MODE_LEGACY;

/**
 * Created by Zinnur on 30.10.16.
 */

public class Shot implements Serializable {

    @SerializedName("id") private long id;
    @SerializedName("title") private String title;
    @SerializedName("description") private String description;
    @SerializedName("images") private Images images;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }


}
