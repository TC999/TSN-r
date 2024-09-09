package com.qq.e.comm.plugin.q0;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Pair;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.s1;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends WebViewClient {

    /* renamed from: f  reason: collision with root package name */
    private static int f45468f;

    /* renamed from: g  reason: collision with root package name */
    private static int f45469g = com.qq.e.comm.plugin.d0.a.d().f().a("wvpgit", 2);

    /* renamed from: h  reason: collision with root package name */
    private static boolean f45470h;

    /* renamed from: a  reason: collision with root package name */
    private boolean f45471a;

    /* renamed from: b  reason: collision with root package name */
    private final n f45472b = new n();

    /* renamed from: c  reason: collision with root package name */
    private f f45473c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.s.g f45474d;

    /* renamed from: e  reason: collision with root package name */
    private h f45475e;

    static {
        f45470h = com.qq.e.comm.plugin.d0.a.d().f().a("wvpgrt", 0) == 1;
    }

    public void a(f fVar) {
        this.f45473c = fVar;
    }

    public void b(boolean z3) {
        this.f45471a = z3;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z3) {
        super.doUpdateVisitedHistory(webView, str, z3);
        this.f45472b.a(this.f45475e, str, z3);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        f fVar = this.f45473c;
        if (fVar != null) {
            fVar.c(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        f fVar = this.f45473c;
        if (fVar != null) {
            fVar.a(str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        super.onReceivedError(webView, i4, str, str2);
        f fVar = this.f45473c;
        if (fVar != null) {
            fVar.a(i4, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        f fVar = this.f45473c;
        if (fVar == null || !(fVar instanceof f.a)) {
            return;
        }
        ((f.a) fVar).a(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        if (sslError == null || !s1.b()) {
            return;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("sslError", sslError.toString());
        v.b(90032, null, 0, dVar);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (f45470h) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) {
            f45468f++;
            v.a(9130001, null, 2, Integer.valueOf(f45468f), null);
            if (f45468f <= f45469g) {
                return true;
            }
        } else {
            v.a(9130001, null, 3, Integer.valueOf(f45468f), null);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InputStream inputStream;
        Pair<? extends InputStream, i2.a> a4 = this.f45472b.a(this.f45471a, webResourceRequest.getUrl());
        if (a4 != null && (inputStream = (InputStream) a4.first) != null) {
            return new WebResourceResponse(((i2.a) a4.second).a(), "UTF-8", inputStream);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        d1.a("UnJsAndroidWebViewClient shouldOverrideUrlLoading, url : " + str, new Object[0]);
        boolean b4 = this.f45472b.b(str);
        f fVar = this.f45473c;
        if (fVar != null) {
            if (b4) {
                fVar.a();
            }
            this.f45473c.a(str);
        }
        com.qq.e.comm.plugin.q0.s.g gVar = this.f45474d;
        if (gVar != null) {
            gVar.b(str);
        }
        return b4;
    }

    public void a(h hVar) {
        this.f45475e = hVar;
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45472b.a(eVar);
    }

    public void a(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45474d = gVar;
    }

    public void a(boolean z3) {
        this.f45472b.a(z3);
    }

    public void a(int i4) {
        this.f45472b.a(i4);
    }
}
