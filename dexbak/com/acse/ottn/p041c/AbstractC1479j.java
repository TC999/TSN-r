package com.acse.ottn.p041c;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* renamed from: com.acse.ottn.c.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1479j {

    /* renamed from: a */
    private static final String f2714a = "RetrofitServiceManager";

    /* renamed from: b */
    private static final String f2715b = "";

    /* renamed from: c */
    private String[] f2716c = {"1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", C7304t.f25048d, "m", "n", "o", "p", CampaignEx.JSON_KEY_AD_Q, "r", "s", UMCommonContent.f37782aL, "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", UMCommonContent.f37777aG};

    /* renamed from: d */
    private final HttpLoggingInterceptor f2717d;

    /* renamed from: e */
    private final Interceptor f2718e;

    /* renamed from: f */
    private final OkHttpClient f2719f;

    public AbstractC1479j() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new C1476g(this));
        this.f2717d = httpLoggingInterceptor;
        C1477h c1477h = new C1477h(this);
        this.f2718e = c1477h;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(c1477h).addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f2719f = addInterceptor.connectTimeout(10L, timeUnit).readTimeout(20L, timeUnit).retryOnConnectionFailure(true).sslSocketFactory(C1483n.m56682b(), C1483n.m56681c()).hostnameVerifier(new C1478i(this)).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Retrofit m56685a() {
        this.f2717d.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder().client(this.f2719f).addConverterFactory(C1470a.m56694a()).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.m12671io())).baseUrl(mo56684b() == null ? "" : mo56684b()).build();
    }

    /* renamed from: b */
    protected abstract String mo56684b();
}
