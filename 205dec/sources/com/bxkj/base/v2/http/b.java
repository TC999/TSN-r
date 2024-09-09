package com.bxkj.base.v2.http;

import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: BaseRetrofitClient.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/base/v2/http/b;", "", "Lkotlin/f1;", "a", "Lokhttp3/OkHttpClient;", "b", "Lokhttp3/OkHttpClient;", "okHttpClient", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "c", "Lretrofit2/Retrofit;", "retrofit", "Lcom/bxkj/base/v2/http/a;", "d", "Lcom/bxkj/base/v2/http/a;", "()Lcom/bxkj/base/v2/http/a;", "(Lcom/bxkj/base/v2/http/a;)V", "apiService", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f18727a = new b();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final OkHttpClient f18728b;

    /* renamed from: c  reason: collision with root package name */
    private static Retrofit f18729c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static a f18730d;

    /* JADX WARN: Type inference failed for: r1v2, types: [okhttp3.Interceptor, r.a] */
    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = builder.readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).addInterceptor(new r.c()).addInterceptor(new r.a()).addInterceptor(new r.b());
        SSLSocketFactory b4 = c.b();
        f0.o(b4, "getSSLSocketFactory()");
        TrustManager trustManager = c.c()[0];
        if (trustManager != null) {
            OkHttpClient.Builder sslSocketFactory = addInterceptor.sslSocketFactory(b4, (X509TrustManager) trustManager);
            HostnameVerifier a4 = c.a();
            f0.o(a4, "getHostnameVerifier()");
            OkHttpClient build = sslSocketFactory.hostnameVerifier(a4).build();
            f18728b = build;
            Retrofit build2 = new Retrofit.Builder().client(build).baseUrl(com.bxkj.base.v2.data.a.f18673h.a().y()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
            f18729c = build2;
            Object create = build2.create(a.class);
            f0.o(create, "retrofit.create(BaseApiService::class.java)");
            f18730d = (a) create;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    private b() {
    }

    public final void a() {
        Retrofit build = new Retrofit.Builder().client(f18728b).baseUrl(com.bxkj.base.v2.data.a.f18673h.a().y()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        f18729c = build;
        Object create = build.create(a.class);
        f0.o(create, "retrofit.create(BaseApiService::class.java)");
        f18730d = (a) create;
    }

    @NotNull
    public final a b() {
        return f18730d;
    }

    public final void c(@NotNull a aVar) {
        f0.p(aVar, "<set-?>");
        f18730d = aVar;
    }
}
