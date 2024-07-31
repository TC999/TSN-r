package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.ds */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2701ds extends AbstractC2619bg {

    /* renamed from: a */
    private boolean f9025a;

    /* renamed from: q */
    private int f9026q;

    /* renamed from: r */
    private String f9027r;

    /* renamed from: s */
    private ScreenVideoAdListener f9028s;

    /* renamed from: t */
    private final String f9029t;

    /* renamed from: u */
    private int f9030u;

    /* renamed from: v */
    private int f9031v;

    /* renamed from: w */
    private String f9032w;

    /* renamed from: x */
    private String f9033x;

    /* renamed from: y */
    private C2573a f9034y;

    /* renamed from: z */
    private RequestParameters f9035z;

    public C2701ds(Context context, String str, boolean z) {
        this(context, str, z, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    /* renamed from: a */
    public void m50475a(Context context) {
        if (this.f8666k != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put("context", context);
            } catch (JSONException e) {
                C2634bs.m50744a().m50738a(e);
            }
            m50818a(jSONObject, hashMap);
            this.f8666k.showAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        super.mo50442b(str, i);
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b_ */
    public void mo50440b_() {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c_ */
    public void mo50437c_() {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    /* renamed from: f */
    public void m50467f() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    /* renamed from: g */
    public boolean m50466g() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    /* renamed from: j */
    public void m50463j(String str) {
        this.f9033x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: k */
    public JSONObject mo50425k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f9029t);
            this.f8666k.createProdHandler(jSONObject2);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f9029t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f9027r);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            Rect m50855a = C2610ay.m50855a(this.f8663h);
            this.f9030u = m50855a.width();
            this.f9031v = m50855a.height();
            if (this.f8663h.getResources().getConfiguration().orientation == 2) {
                this.f9030u = m50855a.height();
                this.f9031v = m50855a.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f9030u);
            jSONObject.put("h", "" + this.f9031v);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.f9029t)) {
                jSONObject.put("msa", 5285);
            }
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
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.f9025a);
            jSONObject.put("downloadConfirmPolicy", this.f9026q);
            jSONObject.put("userid", this.f9032w);
            jSONObject.put("extra", this.f9033x);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    public void mo50422q() {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: s */
    public void mo50461s() {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public C2701ds(Context context, String str, boolean z, String str2) {
        super(context);
        this.f9026q = 3;
        this.f9027r = str;
        this.f9025a = z;
        this.f9029t = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        super.mo50429g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    /* renamed from: h */
    public String m50464h() {
        C2573a c2573a = this.f9034y;
        return c2573a != null ? c2573a.m51077z() : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50468b(boolean z) {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50465g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    /* renamed from: a */
    public void m50476a(int i) {
        this.f9026q = i;
    }

    /* renamed from: a */
    public void m50472a(String str) {
        this.f9032w = str;
    }

    /* renamed from: a */
    public void mo50473a(ScreenVideoAdListener screenVideoAdListener) {
        this.f9028s = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        iAdInterListener.loadAd(mo50425k(), mo50423l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        List<C2573a> m50843a;
        if (iOAdEvent != null && (m50843a = C2612b.m50842a(iOAdEvent.getMessage()).m50843a()) != null && m50843a.size() > 0) {
            this.f9034y = m50843a.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        super.mo50459a(i, str);
        ScreenVideoAdListener screenVideoAdListener = this.f9028s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    /* renamed from: a */
    public void m50470a(boolean z, String str) {
        m50469a(z, str, (HashMap<String, Object>) null);
    }

    /* renamed from: a */
    public void m50469a(boolean z, String str, HashMap<String, Object> hashMap) {
        C2573a c2573a = this.f9034y;
        if (c2573a != null) {
            m50820a(c2573a.m51122H(), z, str, hashMap);
        }
    }

    /* renamed from: a */
    public void m50474a(RequestParameters requestParameters) {
        this.f9035z = requestParameters;
        mo50471a(requestParameters.getExt());
    }

    /* renamed from: k */
    public Object m50462k(String str) {
        if (this.f9034y != null) {
            if ("request_id".equals(str)) {
                return this.f9034y.m51109U();
            }
            return this.f9034y.m51105a(str);
        }
        return null;
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
}
