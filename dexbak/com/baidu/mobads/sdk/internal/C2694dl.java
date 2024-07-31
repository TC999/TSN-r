package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import com.clj.fastble.BleManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.dl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2694dl extends AbstractC2619bg {

    /* renamed from: a */
    private WebView f8999a;

    /* renamed from: q */
    private BaiduHybridAdViewListener f9000q;

    /* renamed from: r */
    private IXHybridAdRenderer f9001r;

    public C2694dl(WebView webView) {
        super(webView.getContext());
        this.f8999a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f8999a.removeJavascriptInterface("accessibility");
        this.f8999a.removeJavascriptInterface("accessibilityTraversal");
        this.f8999a.getSettings().setAllowContentAccess(false);
        this.f8999a.getSettings().setSavePassword(false);
        this.f8999a.getSettings().setAllowFileAccess(false);
    }

    /* renamed from: a */
    public void m50499a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f9000q = baiduHybridAdViewListener;
    }

    /* renamed from: b */
    public boolean m50498b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f9001r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        super.mo50427h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f9000q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: i */
    public void mo50497i() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) C2603as.m50950a(C2736x.f9312j, C2632br.m50753a(this.f8663h), new Class[]{Context.class}, this.f8663h);
        this.f9001r = iXHybridAdRenderer;
        this.f8666k = iXHybridAdRenderer;
        if (this.f8667l) {
            return;
        }
        mo50356a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    public void mo50422q() {
        super.mo50422q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f9000q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    /* renamed from: a */
    public void m50500a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f9001r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        super.mo50442b(str, i);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f9000q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    /* renamed from: a */
    public void m50501a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f9001r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    /* renamed from: a */
    public void m50503a(WebView webView, int i, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f9001r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i, str, str2);
        }
    }

    /* renamed from: a */
    public void m50502a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f9001r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        if (this.f9001r == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.f9001r.createProdHandler(jSONObject3);
            m50805n();
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", BleManager.f22896l);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f9001r.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        this.f9001r.setCustomerWebView(this.f8999a);
    }
}
