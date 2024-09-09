package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dl extends bj {
    private boolean A;
    private BaiduNativeAdPlacement B;

    /* renamed from: a  reason: collision with root package name */
    a f12777a;

    /* renamed from: q  reason: collision with root package name */
    private String f12778q;

    /* renamed from: r  reason: collision with root package name */
    private String f12779r;

    /* renamed from: s  reason: collision with root package name */
    private int f12780s;

    /* renamed from: t  reason: collision with root package name */
    private int f12781t;

    /* renamed from: u  reason: collision with root package name */
    private BaiduNativeH5AdView f12782u;

    /* renamed from: v  reason: collision with root package name */
    private int f12783v;

    /* renamed from: w  reason: collision with root package name */
    private int f12784w;

    /* renamed from: x  reason: collision with root package name */
    private int f12785x;

    /* renamed from: y  reason: collision with root package name */
    private BaiduNativeH5AdView.BaiduNativeH5EventListner f12786y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12787z;

    public dl(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.f12783v = 1;
        this.f12784w = 1;
        this.f12785x = 1;
        this.f12787z = false;
        this.f12777a = null;
        this.A = false;
        this.f12782u = baiduNativeH5AdView;
        this.f12779r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.f12778q = str;
        this.f12480g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.f12786y = baiduNativeH5EventListner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f12786y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(boolean z3) {
        this.f12787z = z3;
    }

    public void d(int i4) {
        this.f12785x = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.f12787z;
    }

    public boolean g() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f12786y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        this.f12787z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f12786y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f12780s = width;
        this.f12781t = height;
    }

    public void c(int i4) {
        this.f12784w = i4;
    }

    public void a(int i4) {
        this.f12783v = i4;
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
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
            jSONObject3.put("prod", this.f12778q);
            this.f12484k.createProdHandler(jSONObject3);
            this.f12484k.setAdContainer(this.f12480g);
            n();
            jSONObject.put("prod", this.f12778q);
            jSONObject.put("apid", this.f12779r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            jSONObject.put("at", "2");
            jSONObject.put("w", "" + this.f12780s);
            jSONObject.put("h", "" + this.f12781t);
            jSONObject = k.a(jSONObject, b(this.f12486m));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f12484k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.f12782u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f12786y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f12786y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
