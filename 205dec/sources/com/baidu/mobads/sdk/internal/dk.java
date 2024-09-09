package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dk extends bj {
    private a A;
    private boolean B;
    private boolean C;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f12766a;

    /* renamed from: q  reason: collision with root package name */
    public boolean f12767q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f12768r;

    /* renamed from: s  reason: collision with root package name */
    private int f12769s;

    /* renamed from: t  reason: collision with root package name */
    private String f12770t;

    /* renamed from: u  reason: collision with root package name */
    private String f12771u;

    /* renamed from: v  reason: collision with root package name */
    private int f12772v;

    /* renamed from: w  reason: collision with root package name */
    private int f12773w;

    /* renamed from: x  reason: collision with root package name */
    private ExpressInterstitialListener f12774x;

    /* renamed from: y  reason: collision with root package name */
    private ExpressInterstitialAd.InterAdDownloadWindowListener f12775y;

    /* renamed from: z  reason: collision with root package name */
    private ExpressInterstitialAd.InterstitialAdDislikeListener f12776z;

    public dk(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f12769s = AVMDLDataLoader.KeyIsLiveSetLoaderType;
        this.f12770t = "int";
        this.f12772v = 600;
        this.f12773w = 500;
        this.B = false;
        this.f12766a = relativeLayout;
        this.f12771u = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.f12775y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i4, str);
        }
        super.b(str, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.f12774x.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z3) {
        this.B = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.f12774x.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(String str) {
    }

    public void d(boolean z3) {
        this.C = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        this.f12768r = false;
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public String f() {
        return this.f12770t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
    }

    public boolean g() {
        return this.f12768r;
    }

    public void h() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", this.f12770t);
            jSONObject2.put("isNewInterstitial", true);
            this.f12484k.createProdHandler(jSONObject2);
            this.f12484k.setAdContainer(this.f12766a);
            n();
            jSONObject.put("prod", this.f12770t);
            jSONObject.put("apid", this.f12771u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            if (cs.a().b()) {
                jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put("w", "" + bb.b(this.f12481h));
            jSONObject.put("h", "" + bb.c(this.f12481h));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = k.a(jSONObject, b(this.f12486m));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.f12767q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put("use_dialog_frame", this.B);
            jSONObject.put("use_dialog_container", this.C);
            jSONObject.put("timeout", this.f12769s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f12775y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void v() {
    }

    public a x() {
        return this.A;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.f12776z = interstitialAdDislikeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.f12776z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(int i4) {
        this.f12769s = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.f12774x = expressInterstitialListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z3) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f12775y;
        if (interAdDownloadWindowListener != null) {
            if (z3) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f12775y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener == null) {
            this.f12485l = false;
            return;
        }
        this.f12768r = false;
        this.f12485l = true;
        iAdInterListener.loadAd(k(), l());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f12772v = width;
            this.f12773w = height;
        }
        a(requestParameters.getExt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i4, str);
        }
        super.a(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z3) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f12775y;
        if (interAdDownloadWindowListener != null) {
            if (z3) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a4;
        if (iOAdEvent != null && (a4 = b.a(iOAdEvent.getMessage()).a()) != null && a4.size() > 0) {
            this.A = a4.get(0);
        }
        this.f12768r = true;
        ExpressInterstitialListener expressInterstitialListener = this.f12774x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(boolean z3, String str) {
        a(z3, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z3, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.A;
        if (aVar != null) {
            a(aVar.H(), z3, str, linkedHashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.f12486m = k.a(map);
        } catch (Throwable unused) {
            this.f12486m = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.A != null) {
            if (ConstantAd.KEY_CACHE_AD.equals(str)) {
                return this.A.U();
            }
            return this.A.a(str);
        }
        return null;
    }
}
