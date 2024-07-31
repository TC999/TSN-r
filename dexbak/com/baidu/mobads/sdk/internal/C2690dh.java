package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.dh */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2690dh extends AbstractC2619bg {

    /* renamed from: A */
    private C2573a f8955A;

    /* renamed from: B */
    private boolean f8956B;

    /* renamed from: C */
    private boolean f8957C;

    /* renamed from: a */
    RelativeLayout f8958a;

    /* renamed from: q */
    public boolean f8959q;

    /* renamed from: r */
    public boolean f8960r;

    /* renamed from: s */
    private int f8961s;

    /* renamed from: t */
    private String f8962t;

    /* renamed from: u */
    private String f8963u;

    /* renamed from: v */
    private int f8964v;

    /* renamed from: w */
    private int f8965w;

    /* renamed from: x */
    private ExpressInterstitialListener f8966x;

    /* renamed from: y */
    private ExpressInterstitialAd.InterAdDownloadWindowListener f8967y;

    /* renamed from: z */
    private ExpressInterstitialAd.InterstitialAdDislikeListener f8968z;

    public C2690dh(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f8961s = 8000;
        this.f8962t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.f8964v = 600;
        this.f8965w = 500;
        this.f8956B = false;
        this.f8958a = relativeLayout;
        this.f8963u = str;
    }

    /* renamed from: a */
    public void m50548a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.f8967y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i, str);
        }
        super.mo50442b(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b_ */
    public void mo50440b_() {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.f8966x.onVideoDownloadSuccess();
        }
    }

    /* renamed from: c */
    public void m50541c(boolean z) {
        this.f8956B = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c_ */
    public void mo50437c_() {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.f8966x.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50512d(String str) {
    }

    /* renamed from: d */
    public void m50540d(boolean z) {
        this.f8957C = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        this.f8960r = false;
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    /* renamed from: f */
    public String m50539f() {
        return this.f8962t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50431f(String str) {
    }

    /* renamed from: g */
    public boolean m50538g() {
        return this.f8960r;
    }

    /* renamed from: h */
    public void m50537h() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: k */
    public JSONObject mo50425k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f8962t);
            jSONObject2.put("isNewInterstitial", true);
            this.f8666k.createProdHandler(jSONObject2);
            this.f8666k.setAdContainer(this.f8958a);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f8962t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f8963u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            if (C2670cp.m50608a().m50601b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + C2610ay.m50852b(this.f8663h));
            jSONObject.put("h", "" + C2610ay.m50849c(this.f8663h));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = C2714k.m50362a(jSONObject, m50813b(this.f8668m));
            m50812b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: l */
    public JSONObject mo50423l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.f8959q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.f8956B);
            jSONObject.put("use_dialog_container", this.f8957C);
            jSONObject.put("timeout", this.f8961s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: u */
    public void mo50420u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f8967y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: v */
    public void mo50419v() {
    }

    /* renamed from: x */
    public C2573a m50536x() {
        return this.f8955A;
    }

    /* renamed from: a */
    public void m50547a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.f8968z = interstitialAdDislikeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c */
    public void mo50515c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.f8968z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50509f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        super.mo50429g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    /* renamed from: a */
    public void m50549a(int i) {
        this.f8961s = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    /* renamed from: a */
    public void m50546a(ExpressInterstitialListener expressInterstitialListener) {
        this.f8966x = expressInterstitialListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50441b(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f8967y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50433e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f8967y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener == null) {
            this.f8667l = false;
            return;
        }
        this.f8960r = false;
        this.f8667l = true;
        iAdInterListener.loadAd(mo50425k(), mo50423l());
    }

    /* renamed from: a */
    public void m50545a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f8964v = width;
            this.f8965w = height;
        }
        mo50471a(requestParameters.getExt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i, str);
        }
        super.mo50459a(i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50447a(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f8967y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        List<C2573a> m50843a;
        if (iOAdEvent != null && (m50843a = C2612b.m50842a(iOAdEvent.getMessage()).m50843a()) != null && m50843a.size() > 0) {
            this.f8955A = m50843a.get(0);
        }
        this.f8960r = true;
        ExpressInterstitialListener expressInterstitialListener = this.f8966x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    /* renamed from: a */
    public void m50543a(boolean z, String str) {
        m50542a(z, str, (HashMap<String, Object>) null);
    }

    /* renamed from: a */
    public void m50542a(boolean z, String str, HashMap<String, Object> hashMap) {
        C2573a c2573a = this.f8955A;
        if (c2573a != null) {
            m50820a(c2573a.m51122H(), z, str, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50471a(Map<String, String> map) {
        try {
            this.f8668m = C2714k.m50365a(map);
        } catch (Throwable unused) {
            this.f8668m = new HashMap<>();
        }
    }

    /* renamed from: a */
    public Object m50544a(String str) {
        if (this.f8955A != null) {
            if ("request_id".equals(str)) {
                return this.f8955A.m51109U();
            }
            return this.f8955A.m51105a(str);
        }
        return null;
    }
}
