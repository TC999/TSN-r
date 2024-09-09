package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.LinkedHashMap;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bs implements ExpressResponse {

    /* renamed from: a  reason: collision with root package name */
    private Context f12531a;

    /* renamed from: b  reason: collision with root package name */
    private int f12532b = 1;

    /* renamed from: c  reason: collision with root package name */
    private ExpressResponse.ExpressInteractionListener f12533c;

    /* renamed from: d  reason: collision with root package name */
    private ExpressResponse.ExpressAdDownloadWindowListener f12534d;

    /* renamed from: e  reason: collision with root package name */
    private ExpressResponse.ExpressDislikeListener f12535e;

    /* renamed from: f  reason: collision with root package name */
    private ExpressResponse.ExpressCloseListener f12536f;

    /* renamed from: g  reason: collision with root package name */
    private final dm f12537g;

    /* renamed from: h  reason: collision with root package name */
    private final a f12538h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f12539i;

    /* renamed from: j  reason: collision with root package name */
    private ExpressAdData f12540j;

    public bs(Context context, dm dmVar, a aVar) {
        this.f12531a = context;
        this.f12537g = dmVar;
        this.f12538h = aVar;
    }

    public void a(int i4) {
        this.f12532b = i4;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12533c;
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
        biddingSuccess(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dm dmVar = this.f12537g;
        if (dmVar != null) {
            dmVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12533c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12535e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12535e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12533c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12534d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f12532b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f12540j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.f12538h != null) {
            if (ConstantAd.KEY_CACHE_AD.equals(str)) {
                return this.f12538h.U();
            }
            return this.f12538h.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f12538h;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f12539i == null && (aVar = this.f12538h) != null) {
            this.f12539i = this.f12537g.a(aVar);
        }
        return this.f12539i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f12538h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12534d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f12538h != null && System.currentTimeMillis() - this.f12538h.y() <= this.f12538h.F();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dm dmVar = this.f12537g;
        if (dmVar == null || (aVar = this.f12538h) == null) {
            return;
        }
        if (this.f12539i == null) {
            this.f12539i = dmVar.a(aVar);
        }
        this.f12537g.a(this.f12539i, this.f12538h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f12536f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f12535e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f12534d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f12533c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i4) {
        dm dmVar = this.f12537g;
        if (dmVar != null) {
            return dmVar.a(this.f12539i, this.f12538h, i4);
        }
        return false;
    }

    public String a() {
        a aVar = this.f12538h;
        return aVar != null ? aVar.H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.f12538h;
        if (aVar == null || (dmVar = this.f12537g) == null) {
            return;
        }
        dmVar.a(aVar.H(), false, str, linkedHashMap);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.f12538h;
        if (aVar == null || (dmVar = this.f12537g) == null) {
            return;
        }
        dmVar.a(aVar.H(), true, str, linkedHashMap);
    }

    public void b(boolean z3) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12534d;
        if (expressAdDownloadWindowListener != null) {
            if (z3) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i4, int i5) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12533c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i4, i5);
        }
    }

    public void a(View view, String str, int i4) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f12533c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i4);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f12536f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(String str) {
        dm dmVar;
        a aVar = this.f12538h;
        if (aVar != null && (dmVar = this.f12537g) != null) {
            this.f12540j = new ExpressAdData(aVar, dmVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f12535e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z3) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f12534d;
        if (expressAdDownloadWindowListener != null) {
            if (z3) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
