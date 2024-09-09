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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dt extends bj implements z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12817a = "preload_end";

    /* renamed from: q  reason: collision with root package name */
    private AdSize f12818q;

    /* renamed from: r  reason: collision with root package name */
    private String f12819r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12820s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12821t;

    /* renamed from: u  reason: collision with root package name */
    private RelativeLayout f12822u;

    /* renamed from: v  reason: collision with root package name */
    private InterstitialAd f12823v;

    /* renamed from: w  reason: collision with root package name */
    private InterstitialAdListener f12824w;

    public dt(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(String str) {
        super.h(str);
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a_() {
        boolean z3 = this.f12820s;
        if (z3 && !this.f12821t) {
            this.f12821t = true;
            this.f12820s = false;
            IAdInterListener iAdInterListener = this.f12484k;
            if (iAdInterListener != null) {
                iAdInterListener.showAd();
            }
        } else if (this.f12821t) {
            this.f12482i.b("interstitial ad is showing now");
        } else if (z3) {
        } else {
            this.f12482i.b("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void b() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public boolean c() {
        return this.f12820s;
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void f() {
        a();
    }

    public void g() {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        this.f12821t = false;
        InterstitialAdListener interstitialAdListener = this.f12824w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.f12824w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.f12823v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        InterstitialAdListener interstitialAdListener = this.f12824w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    public dt(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.f12820s = false;
        this.f12821t = false;
        this.f12823v = interstitialAd;
        this.f12822u = relativeLayout;
        this.f12818q = adSize;
        this.f12819r = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "int");
            this.f12484k.createProdHandler(jSONObject3);
            this.f12484k.setAdContainer(this.f12822u);
            n();
            jSONObject.put("prod", "int");
            jSONObject.put("apid", this.f12819r);
            jSONObject.put("at", "2");
            jSONObject.put("w", "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            if (AdSize.InterstitialGame.equals(this.f12818q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.f12818q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f12484k.loadAd(jSONObject, jSONObject2);
    }

    @Deprecated
    public void b(Activity activity) {
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, int i4) {
        InterstitialAdListener interstitialAdListener = this.f12824w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(int i4, int i5) {
        if (this.f12484k == null || this.f12820s || this.f12821t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("w", i4);
            jSONObject.put("h", i5);
        } catch (JSONException unused) {
        }
        a(jSONObject);
        this.f12484k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            hashMap.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(InterstitialAdListener interstitialAdListener) {
        this.f12824w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        if (f12817a.equals(iOAdEvent.getMessage())) {
            this.f12820s = true;
            InterstitialAdListener interstitialAdListener = this.f12824w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }
}
