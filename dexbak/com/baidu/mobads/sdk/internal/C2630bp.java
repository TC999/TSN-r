package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.bp */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2630bp implements ExpressResponse {

    /* renamed from: a */
    private Context f8711a;

    /* renamed from: b */
    private int f8712b = 1;

    /* renamed from: c */
    private ExpressResponse.ExpressInteractionListener f8713c;

    /* renamed from: d */
    private ExpressResponse.ExpressAdDownloadWindowListener f8714d;

    /* renamed from: e */
    private ExpressResponse.ExpressDislikeListener f8715e;

    /* renamed from: f */
    private ExpressResponse.ExpressCloseListener f8716f;

    /* renamed from: g */
    private final C2692dj f8717g;

    /* renamed from: h */
    private final C2573a f8718h;

    /* renamed from: i */
    private ViewGroup f8719i;

    /* renamed from: j */
    private ExpressAdData f8720j;

    public C2630bp(Context context, C2692dj c2692dj, C2573a c2573a) {
        this.f8711a = context;
        this.f8717g = c2692dj;
        this.f8718h = c2573a;
    }

    /* renamed from: a */
    public void m50773a(int i) {
        this.f8712b = i;
    }

    /* renamed from: b */
    public void m50767b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f8713c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        C2692dj c2692dj;
        C2573a c2573a = this.f8718h;
        if (c2573a == null || (c2692dj = this.f8717g) == null) {
            return;
        }
        c2692dj.m50821a(c2573a.m51122H(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        C2692dj c2692dj = this.f8717g;
        if (c2692dj != null) {
            c2692dj.m50517b(activity);
        }
    }

    /* renamed from: c */
    public void m50765c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f8713c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    /* renamed from: d */
    public void m50764d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f8715e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    /* renamed from: e */
    public void m50763e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f8715e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    /* renamed from: f */
    public void m50762f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f8713c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    /* renamed from: g */
    public void m50761g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f8714d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f8712b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f8720j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.f8718h != null) {
            if ("request_id".equals(str)) {
                return this.f8718h.m51109U();
            }
            return this.f8718h.m51105a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        C2573a c2573a = this.f8718h;
        return c2573a != null ? c2573a.m51077z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        C2573a c2573a;
        if (this.f8719i == null && (c2573a = this.f8718h) != null) {
            this.f8719i = this.f8717g.m50520a(c2573a);
        }
        return this.f8719i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        C2573a c2573a = this.f8718h;
        if (c2573a != null) {
            return c2573a.m51081v();
        }
        return 0;
    }

    /* renamed from: h */
    public void m50760h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f8714d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f8718h != null && System.currentTimeMillis() - this.f8718h.m51078y() <= this.f8718h.m51124F();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        C2573a c2573a;
        C2692dj c2692dj = this.f8717g;
        if (c2692dj == null || (c2573a = this.f8718h) == null) {
            return;
        }
        if (this.f8719i == null) {
            this.f8719i = c2692dj.m50520a(c2573a);
        }
        this.f8717g.m50524a(this.f8719i, this.f8718h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f8716f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f8715e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f8714d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f8713c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i) {
        C2692dj c2692dj = this.f8717g;
        if (c2692dj != null) {
            return c2692dj.m50525a(this.f8719i, this.f8718h, i);
        }
        return false;
    }

    /* renamed from: a */
    public String m50774a() {
        C2573a c2573a = this.f8718h;
        return c2573a != null ? c2573a.m51122H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2692dj c2692dj;
        C2573a c2573a = this.f8718h;
        if (c2573a == null || (c2692dj = this.f8717g) == null) {
            return;
        }
        c2692dj.m50820a(c2573a.m51122H(), false, str, hashMap);
    }

    /* renamed from: b */
    public void m50766b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f8714d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    /* renamed from: a */
    public void m50772a(View view, int i, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f8713c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i, i2);
        }
    }

    /* renamed from: a */
    public void m50771a(View view, String str, int i) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f8713c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i);
        }
    }

    /* renamed from: a */
    public void m50770a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f8716f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    /* renamed from: a */
    public void m50769a(String str) {
        C2692dj c2692dj;
        C2573a c2573a = this.f8718h;
        if (c2573a != null && (c2692dj = this.f8717g) != null) {
            this.f8720j = new ExpressAdData(c2573a, c2692dj.m50507h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f8715e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    /* renamed from: a */
    public void m50768a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f8714d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
