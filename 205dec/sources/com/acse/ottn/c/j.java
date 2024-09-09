package com.acse.ottn.c;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5327a = "RetrofitServiceManager";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5328b = "";

    /* renamed from: c  reason: collision with root package name */
    private String[] f5329c = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", CampaignEx.JSON_KEY_AD_Q, "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /* renamed from: d  reason: collision with root package name */
    private final HttpLoggingInterceptor f5330d;

    /* renamed from: e  reason: collision with root package name */
    private final Interceptor f5331e;

    /* renamed from: f  reason: collision with root package name */
    private final OkHttpClient f5332f;

    public j() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new g(this));
        this.f5330d = httpLoggingInterceptor;
        h hVar = new h(this);
        this.f5331e = hVar;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(hVar).addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f5332f = addInterceptor.connectTimeout(10L, timeUnit).readTimeout(20L, timeUnit).retryOnConnectionFailure(true).sslSocketFactory(n.b(), n.c()).hostnameVerifier(new i(this)).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Retrofit a() {
        this.f5330d.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder().client(this.f5332f).addConverterFactory(a.a()).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).baseUrl(b() == null ? "" : b()).build();
    }

    protected abstract String b();
}
