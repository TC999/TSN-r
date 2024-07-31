package com.bxkj.base.p085v2.p086h5;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m12616d2 = {"Lcom/bxkj/base/v2/h5/d;", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "Landroid/webkit/WebView;", "webView", "", "url", "", "shouldOverrideUrlLoading", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lkotlin/f1;", "onPageFinished", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "c", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "d", "()Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "e", "(Lcn/bluemobi/dylan/smartwebview/SmartWebView;)V", "smartWebView", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.h5.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class H5BaseWebViewClient extends SmartWebView.C1225c {
    @NotNull

    /* renamed from: c */
    private SmartWebView f15229c;

    public H5BaseWebViewClient(@NotNull SmartWebView smartWebView) {
        C14342f0.m8184p(smartWebView, "smartWebView");
        this.f15229c = smartWebView;
        smartWebView.setErrorPage(new ErrorPageView(this.f15229c.getContext(), this.f15229c));
    }

    @NotNull
    /* renamed from: d */
    public final SmartWebView m43542d() {
        return this.f15229c;
    }

    /* renamed from: e */
    public final void m43541e(@NotNull SmartWebView smartWebView) {
        C14342f0.m8184p(smartWebView, "<set-?>");
        this.f15229c = smartWebView;
    }

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.C1225c, android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        View childAt = this.f15229c.getChildAt(1);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        String m43646p = c3984b.m43634a().m43646p();
        String m43662b = c3984b.m43634a().m43662b();
        String m43642t = c3984b.m43634a().m43642t();
        String m43641u = c3984b.m43634a().m43641u();
        String m43656f = c3984b.m43634a().m43656f();
        String str2 = "window.localStorage.setItem('uniIdToken','" + m43662b + "');window.localStorage.setItem('userid','" + m43642t + "');window.localStorage.setItem('school','" + m43646p + "');window.localStorage.setItem('username','" + m43641u + "');window.localStorage.setItem('login_type','online');window.localStorage.setItem('category','" + m43656f + "');";
        String str3 = "javascript:(function({ var localStorage = window.localStorage;localStorage.setItem('uniIdToken','" + m43662b + "');localStorage.setItem('userid','" + m43642t + "');localStorage.setItem('school','" + m43646p + "');localStorage.setItem('username','" + m43641u + "');localStorage.setItem('login_type','online');localStorage.setItem('category','" + m43656f + "'); })()";
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

    @Override // cn.bluemobi.dylan.smartwebview.SmartWebView.C1225c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String url) {
        boolean m6548u2;
        C14342f0.m8184p(webView, "webView");
        C14342f0.m8184p(url, "url");
        m6548u2 = StringsJVM.m6548u2(url, "tel:", false, 2, null);
        if (m6548u2) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268435456);
            BaseApp.m44341b().startActivity(intent);
            return true;
        }
        super.shouldOverrideUrlLoading(webView, url);
        return false;
    }
}
