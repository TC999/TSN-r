package com.bxkj.student.home.teaching.learning.detail.type;

import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import cn.jpush.android.local.JPushConstants;
import com.bxkj.base.user.LoginUser;
import com.umeng.socialize.utils.ContextUtil;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class H5Fragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private String f20790h;

    /* renamed from: i  reason: collision with root package name */
    private SmartWebView f20791i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends WebViewClient {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.H5Fragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0239a implements ValueCallback<String> {
            C0239a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String value) {
            }
        }

        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            view.evaluateJavascript("(function(){var meta = document.createElement('meta');meta.content = 'width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=no';meta.name = 'viewport';document.getElementsByTagName('head')[0].appendChild(meta);var body = document.getElementsByTagName('body')[0];body.style.cssText = 'width:100%;overflow-x:hidden;font-size:14px;margin:0;padding:10px;box-sizing:border-box;';var tb = document.getElementsByTagName('table');for (var k = 0; k < tb.length; k++){var nd = tb[k];nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';};var ps = document.getElementsByTagName('p');for (var j = 0; j < ps.length; j++){var nd = ps[j];var str = nd.innerHTML;str = str.replace(/&nbsp;/g, '');nd.innerHTML = str;nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';}})()", new C0239a());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!url.startsWith(JPushConstants.HTTP_PRE) && !url.startsWith(JPushConstants.HTTPS_PRE)) {
                return "bilibili".equalsIgnoreCase(Uri.parse(url).getScheme());
            }
            view.loadUrl(url);
            return true;
        }
    }

    private int N() {
        try {
            return this.f1665e.getPackageManager().getPackageInfo(ContextUtil.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey("url")) {
            this.f20790h = getArguments().getString("url");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", LoginUser.getLoginUser().getToken());
        hashMap.put("channel", "Android");
        hashMap.put("version", String.valueOf(N()));
        hashMap.put("type", LoginUser.getLoginUser().getUserType() == 2 ? "1" : "0");
        if (this.f20790h.startsWith("https://player.bilibili.com/player.html")) {
            this.f20791i.getWebView().getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        }
        this.f20791i.getWebView().loadUrl(this.f20790h, hashMap);
        this.f20791i.getWebView().setWebViewClient(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20791i = (SmartWebView) c(2131232631);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427422;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
