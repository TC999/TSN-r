package com.acse.ottn;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class g3 {

    /* renamed from: e  reason: collision with root package name */
    public static final String f5672e = "RetrofitServiceManager";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5673f = "";

    /* renamed from: a  reason: collision with root package name */
    public String[] f5674a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", CampaignEx.JSON_KEY_AD_Q, "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /* renamed from: b  reason: collision with root package name */
    public final HttpLoggingInterceptor f5675b;

    /* renamed from: c  reason: collision with root package name */
    public final Interceptor f5676c;

    /* renamed from: d  reason: collision with root package name */
    public final OkHttpClient f5677d;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements HttpLoggingInterceptor.Logger {
        public a() {
        }

        @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
        public void log(String str) {
            z1.a(g3.f5672e, str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Interceptor {
        public b() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder newBuilder = chain.request().newBuilder();
            newBuilder.addHeader("Accept", "application/json,utf-8");
            newBuilder.addHeader("Content-Type", "application/json;utf-8");
            return chain.proceed(newBuilder.build());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements HostnameVerifier {
        public c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public g3() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a());
        this.f5675b = httpLoggingInterceptor;
        b bVar = new b();
        this.f5676c = bVar;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(bVar).addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f5677d = addInterceptor.connectTimeout(10L, timeUnit).readTimeout(20L, timeUnit).retryOnConnectionFailure(true).sslSocketFactory(n3.b(), n3.d()).hostnameVerifier(new c()).build();
    }

    public Retrofit a() {
        this.f5675b.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder().client(this.f5677d).addConverterFactory(x0.a()).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).baseUrl(b() == null ? "" : b()).build();
    }

    public abstract String b();
}
