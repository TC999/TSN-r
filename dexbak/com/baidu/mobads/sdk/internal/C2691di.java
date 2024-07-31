package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.di */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2691di extends AbstractC2619bg {

    /* renamed from: A */
    private boolean f8969A;

    /* renamed from: B */
    private BaiduNativeAdPlacement f8970B;

    /* renamed from: a */
    C2573a f8971a;

    /* renamed from: q */
    private String f8972q;

    /* renamed from: r */
    private String f8973r;

    /* renamed from: s */
    private int f8974s;

    /* renamed from: t */
    private int f8975t;

    /* renamed from: u */
    private BaiduNativeH5AdView f8976u;

    /* renamed from: v */
    private int f8977v;

    /* renamed from: w */
    private int f8978w;

    /* renamed from: x */
    private int f8979x;

    /* renamed from: y */
    private BaiduNativeH5AdView.BaiduNativeH5EventListner f8980y;

    /* renamed from: z */
    private boolean f8981z;

    public C2691di(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.f8977v = 1;
        this.f8978w = 1;
        this.f8979x = 1;
        this.f8981z = false;
        this.f8971a = null;
        this.f8969A = false;
        this.f8976u = baiduNativeH5AdView;
        this.f8973r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.f8972q = str;
        this.f8662g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    /* renamed from: a */
    public void m50533a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.f8980y = baiduNativeH5EventListner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        this.f8970B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f8980y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    /* renamed from: c */
    public void m50530c(boolean z) {
        this.f8981z = z;
    }

    /* renamed from: d */
    public void m50529d(int i) {
        this.f8979x = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        this.f8970B.setWinSended(true);
    }

    /* renamed from: f */
    public boolean m50528f() {
        return this.f8981z;
    }

    /* renamed from: g */
    public boolean m50527g() {
        return this.f8969A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        this.f8970B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f8980y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    public void mo50422q() {
        this.f8981z = true;
        this.f8970B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f8980y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    /* renamed from: a */
    public void m50532a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f8974s = width;
        this.f8975t = height;
    }

    /* renamed from: c */
    public void m50531c(int i) {
        this.f8978w = i;
    }

    /* renamed from: a */
    public void m50535a(int i) {
        this.f8977v = i;
    }

    /* renamed from: a */
    public void m50534a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.f8970B = baiduNativeAdPlacement;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.f8972q);
            this.f8666k.createProdHandler(jSONObject3);
            this.f8666k.setAdContainer(this.f8662g);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f8972q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f8973r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f8974s);
            jSONObject.put("h", "" + this.f8975t);
            jSONObject = C2714k.m50362a(jSONObject, m50813b(this.f8668m));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f8666k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        this.f8969A = true;
        this.f8976u.getAdPlacement().setAdResponse(C2612b.m50842a(iOAdEvent.getMessage()).m50843a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f8980y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        m50802r();
        this.f8970B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f8980y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
