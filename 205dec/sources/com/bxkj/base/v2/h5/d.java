package com.bxkj.base.v2.h5;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.data.a;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: H5BaseWebViewClient.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/bxkj/base/v2/h5/d;", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "Landroid/webkit/WebView;", "webView", "", "url", "", "shouldOverrideUrlLoading", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lkotlin/f1;", "onPageFinished", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "c", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "d", "()Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "e", "(Lcn/bluemobi/dylan/smartwebview/SmartWebView;)V", "smartWebView", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class d extends SmartWebView.c {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private SmartWebView f18726c;

    public d(@NotNull SmartWebView smartWebView) {
        f0.p(smartWebView, "smartWebView");
        this.f18726c = smartWebView;
        smartWebView.setErrorPage(new ErrorPageView(this.f18726c.getContext(), this.f18726c));
    }

    @NotNull
    public final SmartWebView d() {
        return this.f18726c;
    }

    public final void e(@NotNull SmartWebView smartWebView) {
        f0.p(smartWebView, "<set-?>");
        this.f18726c = smartWebView;
    }

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.c, android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        View childAt = this.f18726c.getChildAt(1);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
        a.b bVar = com.bxkj.base.v2.data.a.b;
        String p3 = bVar.a().p();
        String b4 = bVar.a().b();
        String t3 = bVar.a().t();
        String u3 = bVar.a().u();
        String f4 = bVar.a().f();
        String str2 = "window.localStorage.setItem('uniIdToken','" + b4 + "');window.localStorage.setItem('userid','" + t3 + "');window.localStorage.setItem('school','" + p3 + "');window.localStorage.setItem('username','" + u3 + "');window.localStorage.setItem('login_type','online');window.localStorage.setItem('category','" + f4 + "');";
        String str3 = "javascript:(function({ var localStorage = window.localStorage;localStorage.setItem('uniIdToken','" + b4 + "');localStorage.setItem('userid','" + t3 + "');localStorage.setItem('school','" + p3 + "');localStorage.setItem('username','" + u3 + "');localStorage.setItem('login_type','online');localStorage.setItem('category','" + f4 + "'); })()";
        if (Build.VERSION.SDK_INT >= 19) {
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str2, null);
            return;
        }
        if (webView != null) {
            webView.loadUrl(str3);
        }
        if (webView == null) {
            return;
        }
        webView.reload();
    }

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String url) {
        boolean u22;
        f0.p(webView, "webView");
        f0.p(url, "url");
        u22 = w.u2(url, "tel:", false, 2, null);
        if (u22) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268435456);
            BaseApp.b().startActivity(intent);
            return true;
        }
        super.shouldOverrideUrlLoading(webView, url);
        return false;
    }
}
