package com.bxkj.student.p094v2.retrofit;

import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.http.SSLSocketClient;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import p641s.HttpLogInterceptor;
import p641s.HttpTimeoutInterceptor;
import p641s.RequestInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\n\u0010\u0011¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/student/v2/retrofit/b;", "", "Lkotlin/f1;", "a", "Lokhttp3/OkHttpClient;", "b", "Lokhttp3/OkHttpClient;", "okHttpClient", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "c", "Lretrofit2/Retrofit;", "retrofit", "Lcom/bxkj/student/v2/retrofit/a;", "d", "Lcom/bxkj/student/v2/retrofit/a;", "()Lcom/bxkj/student/v2/retrofit/a;", "(Lcom/bxkj/student/v2/retrofit/a;)V", "apiService", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.retrofit.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RetrofitClient {
    @NotNull

    /* renamed from: a */
    public static final RetrofitClient f20337a = new RetrofitClient();
    @NotNull

    /* renamed from: b */
    private static final OkHttpClient f20338b;

    /* renamed from: c */
    private static Retrofit f20339c;
    @NotNull

    /* renamed from: d */
    private static ApiService f20340d;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = builder.readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).addInterceptor(new RequestInterceptor()).addInterceptor(new HttpLogInterceptor()).addInterceptor(new HttpTimeoutInterceptor());
        SSLSocketFactory m43539b = SSLSocketClient.m43539b();
        C14342f0.m8185o(m43539b, "getSSLSocketFactory()");
        TrustManager trustManager = SSLSocketClient.m43538c()[0];
        if (trustManager != null) {
            OkHttpClient.Builder sslSocketFactory = addInterceptor.sslSocketFactory(m43539b, (X509TrustManager) trustManager);
            HostnameVerifier m43540a = SSLSocketClient.m43540a();
            C14342f0.m8185o(m43540a, "getHostnameVerifier()");
            OkHttpClient build = sslSocketFactory.hostnameVerifier(m43540a).build();
            f20338b = build;
            Retrofit build2 = new Retrofit.Builder().client(build).baseUrl(LoggedInUser.f15182b.m43634a().m43644r()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
            f20339c = build2;
            Object create = build2.create(ApiService.class);
            C14342f0.m8185o(create, "retrofit.create(ApiService::class.java)");
            f20340d = (ApiService) create;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    private RetrofitClient() {
    }

    /* renamed from: a */
    public final void m38889a() {
        Retrofit build = new Retrofit.Builder().client(f20338b).baseUrl(LoggedInUser.f15182b.m43634a().m43644r()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        f20339c = build;
        Object create = build.create(ApiService.class);
        C14342f0.m8185o(create, "retrofit.create(ApiService::class.java)");
        f20340d = (ApiService) create;
    }

    @NotNull
    /* renamed from: b */
    public final ApiService m38888b() {
        return f20340d;
    }

    /* renamed from: c */
    public final void m38887c(@NotNull ApiService apiService) {
        C14342f0.m8184p(apiService, "<set-?>");
        f20340d = apiService;
    }
}
