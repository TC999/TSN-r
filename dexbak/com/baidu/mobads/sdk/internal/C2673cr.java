package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.cr */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2673cr extends AbstractC2619bg {

    /* renamed from: a */
    private RelativeLayout f8897a;

    /* renamed from: q */
    private String f8898q;

    /* renamed from: r */
    private boolean f8899r;

    /* renamed from: s */
    private AdViewListener f8900s;

    /* renamed from: t */
    private int f8901t;

    /* renamed from: u */
    private int f8902u;

    /* renamed from: v */
    private AdView f8903v;

    /* renamed from: w */
    private RequestParameters f8904w;

    public C2673cr(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        this.f8903v = adView;
        this.f8897a = relativeLayout;
        this.f8898q = str;
        this.f8899r = z;
    }

    /* renamed from: a */
    public void m50590a(int i) {
        this.f8901t = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        AdViewListener adViewListener = this.f8900s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    /* renamed from: c */
    public void m50587c(int i) {
        this.f8902u = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        super.mo50429g(iOAdEvent);
        AdViewListener adViewListener = this.f8900s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f8900s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    public void mo50422q() {
        AdViewListener adViewListener = this.f8900s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.f8900s.onAdShow(new JSONObject());
        }
    }

    /* renamed from: a */
    public void m50589a(AdViewListener adViewListener) {
        this.f8900s = adViewListener;
    }

    /* renamed from: a */
    public void m50588a(RequestParameters requestParameters) {
        this.f8904w = requestParameters;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
            this.f8666k.createProdHandler(jSONObject3);
            this.f8666k.setAdContainer(this.f8897a);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f8898q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.f8899r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f8901t);
            jSONObject.put("h", "" + this.f8902u);
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            RequestParameters requestParameters = this.f8904w;
            if (requestParameters != null) {
                mo50471a(requestParameters.getExtras());
            }
            jSONObject2 = m50813b(this.f8668m);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f8666k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f8900s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.f8903v);
        }
    }
}
