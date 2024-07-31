package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: com.baidu.mobads.sdk.internal.db */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2684db extends AbstractC2619bg {

    /* renamed from: G */
    private static final String f8926G = C2684db.class.getSimpleName();

    /* renamed from: a */
    public static final String f8927a = "enter_refresh_bookstore";

    /* renamed from: q */
    public static final String f8928q = "enter_reader";

    /* renamed from: r */
    public static final String f8929r = "notify_impression";

    /* renamed from: s */
    public static final String f8930s = "request_int_ad_view";

    /* renamed from: t */
    public static final String f8931t = "request_banner_ad_view";

    /* renamed from: u */
    public static final String f8932u = "request_bookstore_bottom_view";

    /* renamed from: v */
    public static final String f8933v = "request_shelf_ad_view";

    /* renamed from: w */
    public static final String f8934w = "reader_background_status_change";

    /* renamed from: x */
    public static final String f8935x = "pre_chapter_adstart_countdown";

    /* renamed from: y */
    public static final String f8936y = "try_get_cuid";

    /* renamed from: A */
    public String f8937A;

    /* renamed from: B */
    public int f8938B;

    /* renamed from: C */
    public int f8939C;

    /* renamed from: D */
    public int f8940D;

    /* renamed from: E */
    public int f8941E;

    /* renamed from: F */
    public String f8942F;

    /* renamed from: H */
    private CPUNovelAd.CpuNovelListener f8943H;

    /* renamed from: I */
    private SoftReference<RelativeLayout> f8944I;

    /* renamed from: z */
    public HashMap<String, Object> f8945z;

    public C2684db(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f8938B = 5;
        this.f8939C = 60;
        this.f8940D = 0;
        this.f8941E = IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO;
        this.f8942F = "";
        this.f8937A = str;
        this.f8945z = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m50554z() {
        C2598ao.m50984b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.f8943H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    /* renamed from: f */
    public void m50560f() {
        C2598ao.m50994a(this.f8938B);
        C2598ao.m50983b(this.f8939C);
        C2598ao.m50988a(new C2687de(this));
    }

    /* renamed from: g */
    public Activity m50559g() {
        return C2598ao.m50981c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.f8943H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: w */
    public View mo50557w() {
        View m50991a = C2598ao.m50991a(this.f8663h);
        if (m50991a instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f8663h);
            this.f8944I = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, C2610ay.m50854a(this.f8663h, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) m50991a).addView(relativeLayout, layoutParams);
            if (C2624bk.m50799a((Context) null).m50800a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver$OnWindowFocusChangeListenerC2688df(this, relativeLayout));
            }
        }
        return m50991a;
    }

    /* renamed from: x */
    public boolean m50556x() {
        return C2598ao.m50979e();
    }

    /* renamed from: y */
    public void m50555y() {
        C2598ao.m50977g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m50561c(Map<String, Object> map) {
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
                C2598ao.m50994a(((Integer) obj).intValue());
                C2598ao.m50983b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                C2598ao.m50992a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                C2598ao.m50986a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                C2598ao.m50993a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                C2598ao.m50985a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                C2598ao.m50976h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                C2598ao.m50982b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                C2598ao.m50982b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        m50560f();
        if (this.f8666k == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f8666k.createProdHandler(jSONObject);
            m50805n();
            this.f8666k.addEventListener("Update_fbReader_Setting", new C2685dc(this));
            this.f8666k.addEventListener("closeInterstitialAd", new C2686dd(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.f8937A)) {
                jSONObject2.put("appid", this.f8937A);
            }
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f8666k.loadAd(jSONObject2, C2714k.m50367a(this.f8945z));
        } catch (Throwable th) {
            this.f8664i.m50730c(f8926G, th);
        }
    }

    /* renamed from: h */
    public boolean m50558h() {
        return C2598ao.m50980d();
    }

    /* renamed from: a */
    public void m50566a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.f8943H = cpuNovelListener;
    }
}
