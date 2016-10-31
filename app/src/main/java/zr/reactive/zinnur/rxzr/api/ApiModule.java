package zr.reactive.zinnur.rxzr.api;




import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zr.reactive.zinnur.rxzr.mvp.utils.OkHttpUtil;
import zr.reactive.zinnur.rxzr.other.Const;

/**
 * Created by Zinnur on 28.10.16.
 */

public final class ApiModule {
    private static final boolean ENABLE_LOG = true;
    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***";

    private ApiModule(){}

    public static ApiInterface getApiInterface(String url){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .hostnameVerifier((hostname, session) -> true)
                .addInterceptor(interceptor)
                .build();


        if (ENABLE_AUTH){
            httpClient.interceptors().add(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Basic " + AUTH_64)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            });
        }



        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        builder.client(httpClient);

        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
    }

    public static DribbbleServices getDribbbleApi(String baseurl){
        DribbbleServices sApiService = null;
        Retrofit sRetrofit = null;
        OkHttpClient sOkHttpClient = null;

        OkHttpClient.Builder builder = OkHttpUtil.generateOkHttpClient();
        builder.addInterceptor(chain -> {
            Request request = chain.request();
            HttpUrl originUrl = request.url();
            HttpUrl url = originUrl.newBuilder().addQueryParameter("access_token", Const.ClientAccessToken).build();
            return chain.proceed(request.newBuilder().url(url).addHeader("Connection", "close").build());
        });
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        sOkHttpClient = builder.build();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        DribbbleServices dribbbleServices = sRetrofit.create(DribbbleServices.class);
        return  dribbbleServices;
    }

    public static DribbbleSearchService getDribbbleSearchApi(){
        DribbbleSearchService dribbbleSearchApi = new Retrofit.Builder()
                .baseUrl(DribbbleSearchService.ENDPOINT)
                .addConverterFactory(new DribbbleSearchConverter.Factory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create((DribbbleSearchService.class));
        return dribbbleSearchApi;
    }

}
