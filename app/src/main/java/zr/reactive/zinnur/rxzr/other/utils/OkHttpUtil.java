package zr.reactive.zinnur.rxzr.other.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Created by Zinnur on 31.10.16.
 */

public class OkHttpUtil {

    public static OkHttpClient.Builder generateOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3, TimeUnit.SECONDS);
        builder.readTimeout(3, TimeUnit.SECONDS);
        builder.writeTimeout(3, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        initHttps(builder);
        return builder;
    }

    private static void initHttps(OkHttpClient.Builder builder) {
        try {
            SSLSocketFactory sslSocketFactory;
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            sslSocketFactory = sslContext.getSocketFactory();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}