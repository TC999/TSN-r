package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.dq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2699dq extends AbstractC2619bg implements InterfaceC2738z {

    /* renamed from: a */
    private static final String f9016a = "preload_end";

    /* renamed from: q */
    private AdSize f9017q;

    /* renamed from: r */
    private String f9018r;

    /* renamed from: s */
    private boolean f9019s;

    /* renamed from: t */
    private boolean f9020t;

    /* renamed from: u */
    private RelativeLayout f9021u;

    /* renamed from: v */
    private InterstitialAd f9022v;

    /* renamed from: w */
    private InterstitialAdListener f9023w;

    public C2699dq(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: a */
    public void mo50221a(String str) {
        super.m50809h(str);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: a_ */
    public void mo50220a_() {
        boolean z = this.f9019s;
        if (z && !this.f9020t) {
            this.f9020t = true;
            this.f9019s = false;
            IAdInterListener iAdInterListener = this.f8666k;
            if (iAdInterListener != null) {
                iAdInterListener.showAd();
            }
        } else if (this.f9020t) {
            this.f8664i.m50736b("interstitial ad is showing now");
        } else if (z) {
        } else {
            this.f8664i.m50736b("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: b */
    public void mo50219b() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: c */
    public boolean mo50218c() {
        return this.f9019s;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: f */
    public void mo50216f() {
        mo50356a();
    }

    /* renamed from: g */
    public void m50480g() {
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    protected void mo50429g(IOAdEvent iOAdEvent) {
        this.f9020t = false;
        InterstitialAdListener interstitialAdListener = this.f9023w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    protected void mo50427h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.f9023w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.f9022v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    protected void mo50422q() {
        InterstitialAdListener interstitialAdListener = this.f9023w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    public C2699dq(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.f9019s = false;
        this.f9020t = false;
        this.f9022v = interstitialAd;
        this.f9021u = relativeLayout;
        this.f9017q = adSize;
        this.f9018r = str;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        if (this.f8666k == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            this.f8666k.createProdHandler(jSONObject3);
            this.f8666k.setAdContainer(this.f9021u);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f9018r);
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            if (AdSize.InterstitialGame.equals(this.f9017q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.f9017q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f8666k.loadAd(jSONObject, jSONObject2);
    }

    @Deprecated
    /* renamed from: b */
    public void m50481b(Activity activity) {
        mo50220a_();
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    protected void mo50442b(String str, int i) {
        InterstitialAdListener interstitialAdListener = this.f9023w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: a */
    public void mo50225a(int i, int i2) {
        if (this.f8666k == null || this.f9019s || this.f9020t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put("h", i2);
        } catch (JSONException unused) {
        }
        m50819a(jSONObject);
        this.f8666k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: a */
    public void mo50223a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            hashMap.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
        mo50220a_();
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2738z
    /* renamed from: a */
    public void mo50222a(InterstitialAdListener interstitialAdListener) {
        this.f9023w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    protected void mo50455a(IOAdEvent iOAdEvent) {
        if (f9016a.equals(iOAdEvent.getMessage())) {
            this.f9019s = true;
            InterstitialAdListener interstitialAdListener = this.f9023w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }
}
