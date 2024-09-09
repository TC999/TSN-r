package cn.jpush.android.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.ad.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.webview.bridge.HostJsScope;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f extends b {

    /* renamed from: f  reason: collision with root package name */
    private WebView f4422f;

    /* renamed from: g  reason: collision with root package name */
    private cn.jpush.android.webview.bridge.d f4423g;

    public f(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        super(context, aVar, dVar, i4);
    }

    private void a() {
        try {
            k.a(this.f4422f, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{this.f4423g, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("BaseInAppWrapper", "addJavascriptInterface failed:" + th.toString());
        }
    }

    @Override // cn.jpush.android.u.b
    public void c() {
        try {
            WebView webView = this.f4422f;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent != null) {
                    Logger.d("BaseInAppWrapper", "wb parent view " + parent);
                    ((ViewGroup) parent).removeView(this.f4422f);
                }
                this.f4422f.getSettings().setJavaScriptEnabled(false);
                this.f4422f.clearCache(true);
                this.f4422f.clearHistory();
                this.f4422f.clearView();
                this.f4422f.removeAllViews();
                this.f4422f.clearSslPreferences();
                this.f4422f.destroy();
                this.f4422f = null;
            }
            i();
            Logger.d("BaseInAppWrapper", "wb release completed.");
        } catch (Throwable th) {
            Logger.w("BaseInAppWrapper", "wb destroy failed. error: " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.u.b
    public void d() {
    }

    @Override // cn.jpush.android.u.b
    public View e() {
        return this.f4422f;
    }

    @Override // cn.jpush.android.u.b
    public boolean f() {
        String str;
        cn.jpush.android.d.d dVar;
        if (this.f4384d == null || (dVar = this.f4382b) == null) {
            str = "unexpected error param is null";
        } else {
            try {
                String str2 = dVar.bd;
                if (TextUtils.isEmpty(str2)) {
                    Logger.w("BaseInAppWrapper", "url is empty, wb inflate failed.");
                    return false;
                }
                if (this.f4422f == null) {
                    WebView webView = new WebView(this.f4384d);
                    this.f4422f = webView;
                    webView.setBackgroundColor(this.f4384d.getResources().getColor(17170445));
                }
                this.f4422f.setHorizontalScrollBarEnabled(false);
                this.f4422f.setVerticalScrollBarEnabled(false);
                this.f4422f.setScrollbarFadingEnabled(true);
                this.f4422f.setScrollBarStyle(33554432);
                WebSettings settings = this.f4422f.getSettings();
                cn.jpush.android.ad.a.c(settings);
                cn.jpush.android.ad.a.a(this.f4422f);
                cn.jpush.android.ad.a.a(settings);
                cn.jpush.android.webview.bridge.d dVar2 = new cn.jpush.android.webview.bridge.d(cn.jpush.android.s.a.a(this.f4384d), this.f4382b);
                this.f4423g = dVar2;
                HostJsScope.setWebViewHelper(dVar2);
                Logger.d("BaseInAppWrapper", "Android sdk version greater than or equal to 17, Java\u2014Js interact by annotation!");
                a();
                this.f4422f.setWebViewClient(new WebViewClient());
                this.f4422f.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                this.f4422f.loadUrl(str2);
                Logger.d("BaseInAppWrapper", "wb inflate completed, url: " + str2);
                return true;
            } catch (Throwable th) {
                str = "wb inflate failed, " + th.getMessage();
            }
        }
        Logger.w("BaseInAppWrapper", str);
        return false;
    }

    @Override // cn.jpush.android.u.b
    public void g() {
    }
}
