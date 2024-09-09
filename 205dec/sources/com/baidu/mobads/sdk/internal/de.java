package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class de extends bj {
    private static final String G = de.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static final String f12746a = "enter_refresh_bookstore";

    /* renamed from: q  reason: collision with root package name */
    public static final String f12747q = "enter_reader";

    /* renamed from: r  reason: collision with root package name */
    public static final String f12748r = "notify_impression";

    /* renamed from: s  reason: collision with root package name */
    public static final String f12749s = "request_int_ad_view";

    /* renamed from: t  reason: collision with root package name */
    public static final String f12750t = "request_banner_ad_view";

    /* renamed from: u  reason: collision with root package name */
    public static final String f12751u = "request_bookstore_bottom_view";

    /* renamed from: v  reason: collision with root package name */
    public static final String f12752v = "request_shelf_ad_view";

    /* renamed from: w  reason: collision with root package name */
    public static final String f12753w = "reader_background_status_change";

    /* renamed from: x  reason: collision with root package name */
    public static final String f12754x = "pre_chapter_adstart_countdown";

    /* renamed from: y  reason: collision with root package name */
    public static final String f12755y = "try_get_cuid";
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    private CPUNovelAd.CpuNovelListener H;
    private SoftReference<RelativeLayout> I;

    /* renamed from: z  reason: collision with root package name */
    public HashMap<String, Object> f12756z;

    public de(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.B = 5;
        this.C = 60;
        this.D = 0;
        this.E = 10006;
        this.F = "";
        this.A = str;
        this.f12756z = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ao.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public void f() {
        ao.a(this.B);
        ao.b(this.C);
        ao.a(new dh(this));
    }

    public Activity g() {
        return ao.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public View w() {
        View a4 = ao.a(this.f12481h);
        if (a4 instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f12481h);
            this.I = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, bb.a(this.f12481h, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) a4).addView(relativeLayout, layoutParams);
            if (bn.a((Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new di(this, relativeLayout));
            }
        }
        return a4;
    }

    public boolean x() {
        return ao.e();
    }

    public void y() {
        ao.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                ao.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                ao.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                ao.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                ao.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        f();
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("prod", "novel");
            this.f12484k.createProdHandler(jSONObject);
            n();
            this.f12484k.addEventListener("Update_fbReader_Setting", new df(this));
            this.f12484k.addEventListener("closeInterstitialAd", new dg(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject2.put("appid", this.A);
            }
            jSONObject2.put("prod", "novel");
            this.f12484k.loadAd(jSONObject2, k.a(this.f12756z));
        } catch (Throwable th) {
            this.f12482i.c(G, th);
        }
    }

    public boolean h() {
        return ao.d();
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.H = cpuNovelListener;
    }
}
