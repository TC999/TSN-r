package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cu extends bj {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f12717a;

    /* renamed from: q  reason: collision with root package name */
    private String f12718q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12719r;

    /* renamed from: s  reason: collision with root package name */
    private AdViewListener f12720s;

    /* renamed from: t  reason: collision with root package name */
    private int f12721t;

    /* renamed from: u  reason: collision with root package name */
    private int f12722u;

    /* renamed from: v  reason: collision with root package name */
    private AdView f12723v;

    /* renamed from: w  reason: collision with root package name */
    private RequestParameters f12724w;

    public cu(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z3) {
        super(context);
        this.f12723v = adView;
        this.f12717a = relativeLayout;
        this.f12718q = str;
        this.f12719r = z3;
    }

    public void a(int i4) {
        this.f12721t = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        AdViewListener adViewListener = this.f12720s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i4) {
        this.f12722u = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.f12720s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f12720s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        AdViewListener adViewListener = this.f12720s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.f12720s.onAdShow(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        this.f12720s = adViewListener;
    }

    public void a(RequestParameters requestParameters) {
        this.f12724w = requestParameters;
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
            jSONObject3.put("prod", "banner");
            this.f12484k.createProdHandler(jSONObject3);
            this.f12484k.setAdContainer(this.f12717a);
            n();
            jSONObject.put("prod", "banner");
            jSONObject.put("apid", this.f12718q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.f12719r);
            jSONObject.put("w", "" + this.f12721t);
            jSONObject.put("h", "" + this.f12722u);
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            RequestParameters requestParameters = this.f12724w;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            jSONObject2 = b(this.f12486m);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f12484k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f12720s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.f12723v);
        }
    }
}
