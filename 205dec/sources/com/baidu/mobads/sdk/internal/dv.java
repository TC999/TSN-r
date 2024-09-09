package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dv extends bj {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12826a;

    /* renamed from: q  reason: collision with root package name */
    private int f12827q;

    /* renamed from: r  reason: collision with root package name */
    private String f12828r;

    /* renamed from: s  reason: collision with root package name */
    private ScreenVideoAdListener f12829s;

    /* renamed from: t  reason: collision with root package name */
    private final String f12830t;

    /* renamed from: u  reason: collision with root package name */
    private int f12831u;

    /* renamed from: v  reason: collision with root package name */
    private int f12832v;

    /* renamed from: w  reason: collision with root package name */
    private String f12833w;

    /* renamed from: x  reason: collision with root package name */
    private String f12834x;

    /* renamed from: y  reason: collision with root package name */
    private a f12835y;

    /* renamed from: z  reason: collision with root package name */
    private RequestParameters f12836z;

    public dv(Context context, String str, boolean z3) {
        this(context, str, z3, "rvideo");
    }

    public void a(Context context) {
        if (this.f12484k != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put("context", context);
            } catch (JSONException e4) {
                bv.a().a(e4);
            }
            a(jSONObject, hashMap);
            this.f12484k.showAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        super.b(str, i4);
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean g() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void j(String str) {
        this.f12834x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", this.f12830t);
            this.f12484k.createProdHandler(jSONObject2);
            n();
            jSONObject.put("prod", this.f12830t);
            jSONObject.put("apid", this.f12828r);
            jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            Rect a4 = bb.a(this.f12481h);
            this.f12831u = a4.width();
            this.f12832v = a4.height();
            if (this.f12481h.getResources().getConfiguration().orientation == 2) {
                this.f12831u = a4.height();
                this.f12832v = a4.width();
            }
            jSONObject.put("w", "" + this.f12831u);
            jSONObject.put("h", "" + this.f12832v);
            jSONObject.put("opt", 1);
            if ("rvideo".equals(this.f12830t)) {
                jSONObject.put("msa", 5285);
            }
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
            jSONObject.put("timeout", AVMDLDataLoader.KeyIsLiveSetLoaderType);
            jSONObject.put("useSurfaceView", this.f12826a);
            jSONObject.put("downloadConfirmPolicy", this.f12827q);
            jSONObject.put("userid", this.f12833w);
            jSONObject.put("extra", this.f12834x);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void s() {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public dv(Context context, String str, boolean z3, String str2) {
        super(context);
        this.f12827q = 3;
        this.f12828r = str;
        this.f12826a = z3;
        this.f12830t = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    public String h() {
        a aVar = this.f12835y;
        return aVar != null ? aVar.z() : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(boolean z3) {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    public void a(int i4) {
        this.f12827q = i4;
    }

    public void a(String str) {
        this.f12833w = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.f12829s = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        iAdInterListener.loadAd(k(), l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a4;
        if (iOAdEvent != null && (a4 = b.a(iOAdEvent.getMessage()).a()) != null && a4.size() > 0) {
            this.f12835y = a4.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        super.a(i4, str);
        ScreenVideoAdListener screenVideoAdListener = this.f12829s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z3, String str) {
        a(z3, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z3, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.f12835y;
        if (aVar != null) {
            a(aVar.H(), z3, str, linkedHashMap);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.f12836z = requestParameters;
        a(requestParameters.getExt());
    }

    public Object k(String str) {
        if (this.f12835y != null) {
            if (ConstantAd.KEY_CACHE_AD.equals(str)) {
                return this.f12835y.U();
            }
            return this.f12835y.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.f12486m = k.a(map);
        } catch (Throwable unused) {
            this.f12486m = new HashMap<>();
        }
    }
}
