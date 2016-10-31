package zr.reactive.zinnur.rxzr.api;

import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Images;
import zr.reactive.zinnur.rxzr.mvp.models.dto.Shot;


public class DribbbleSearchConverter implements Converter<ResponseBody, List<Shot>> {

    public static final class Factory extends Converter.Factory {

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                                Annotation[] annotations,
                                                                Retrofit retrofit) {
            return INSTANCE;
        }

    }

    private DribbbleSearchConverter() { }
    static final DribbbleSearchConverter INSTANCE = new DribbbleSearchConverter();

    private static final String HOST = "https://dribbble.com";

    @Override
    public List<Shot> convert(ResponseBody value) throws IOException {
        final Elements shotElements =
                Jsoup.parse(value.string(), HOST).select("li[id^=screenshot]");
        final List<Shot> shots = new ArrayList<>(shotElements.size());
        for (Element element : shotElements) {
            final Shot shot = parseShot(element);
            if (shot != null) {
                shots.add(shot);
            }
        }
        return shots;
    }

    private static Shot parseShot(Element element) {
        final Element descriptionBlock = element.select("a.dribbble-over").first();
        String description = descriptionBlock.select("span.comment").text().trim();
        if (!TextUtils.isEmpty(description)) {
            description = "<p>" + description + "</p>";
        }
        String imgUrl = element.select("img").first().attr("src");
        if (imgUrl.contains("_teaser.")) {
            imgUrl = imgUrl.replace("_teaser.", ".");
        }

        Shot shot = new Shot();
        shot.setId(Long.parseLong(element.id().replace("screenshot-", "")));
        shot.setDescription(description);
        shot.setImages(new Images(null, null, imgUrl));
        shot.setTitle(descriptionBlock.select("strong").first().text());
        return shot;
    }


}
