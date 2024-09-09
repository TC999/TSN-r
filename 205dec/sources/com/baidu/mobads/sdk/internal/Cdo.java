package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* renamed from: com.baidu.mobads.sdk.internal.do  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Cdo extends bj {

    /* renamed from: a  reason: collision with root package name */
    private WebView f12800a;

    /* renamed from: q  reason: collision with root package name */
    private BaiduHybridAdViewListener f12801q;

    /* renamed from: r  reason: collision with root package name */
    private IXHybridAdRenderer f12802r;

    public Cdo(WebView webView) {
        super(webView.getContext());
        this.f12800a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f12800a.removeJavascriptInterface("accessibility");
        this.f12800a.removeJavascriptInterface("accessibilityTraversal");
        this.f12800a.getSettings().setAllowContentAccess(false);
        this.f12800a.getSettings().setSavePassword(false);
        this.f12800a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f12801q = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f12802r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f12801q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void i() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) av.a(x.f13029j, bu.a(this.f12481h), new Class[]{Context.class}, this.f12481h);
        this.f12802r = iXHybridAdRenderer;
        this.f12484k = iXHybridAdRenderer;
        if (this.f12485l) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f12801q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f12802r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        super.b(str, i4);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f12801q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f12802r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i4, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f12802r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i4, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f12802r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12802r == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "jssdk");
            this.f12802r.createProdHandler(jSONObject3);
            n();
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            jSONObject.put("prod", "jssdk");
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f12802r.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        this.f12802r.setCustomerWebView(this.f12800a);
    }
}
