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
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.socialize.utils.ContextUtil;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class H5Fragment extends BaseFragment {

    /* renamed from: h */
    private String f17447h;

    /* renamed from: i */
    private SmartWebView f17448i;

    /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.H5Fragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4669a extends WebViewClient {

        /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.H5Fragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4670a implements ValueCallback<String> {
            C4670a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String value) {
            }
        }

        C4669a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            view.evaluateJavascript("(function(){var meta = document.createElement('meta');meta.content = 'width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=no';meta.name = 'viewport';document.getElementsByTagName('head')[0].appendChild(meta);var body = document.getElementsByTagName('body')[0];body.style.cssText = 'width:100%;overflow-x:hidden;font-size:14px;margin:0;padding:10px;box-sizing:border-box;';var tb = document.getElementsByTagName('table');for (var k = 0; k < tb.length; k++){var nd = tb[k];nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';};var ps = document.getElementsByTagName('p');for (var j = 0; j < ps.length; j++){var nd = ps[j];var str = nd.innerHTML;str = str.replace(/&nbsp;/g, '');nd.innerHTML = str;nd.style.cssText += ';color:#101010;font-size: 14px;width:100%;overflow-x:hidden;';}})()", new C4670a());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                return "bilibili".equalsIgnoreCase(Uri.parse(url).getScheme());
            }
            view.loadUrl(url);
            return true;
        }
    }

    /* renamed from: N */
    private int m41667N() {
        try {
            return this.f1678e.getPackageManager().getPackageInfo(ContextUtil.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        if (getArguments().containsKey("url")) {
            this.f17447h = getArguments().getString("url");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BidResponsed.KEY_TOKEN, LoginUser.getLoginUser().getToken());
        hashMap.put("channel", "Android");
        hashMap.put(ConstantHelper.LOG_VS, String.valueOf(m41667N()));
        hashMap.put("type", LoginUser.getLoginUser().getUserType() == 2 ? "1" : "0");
        if (this.f17447h.startsWith("https://player.bilibili.com/player.html")) {
            this.f17448i.getWebView().getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        }
        this.f17448i.getWebView().loadUrl(this.f17447h, hashMap);
        this.f17448i.getWebView().setWebViewClient(new C4669a());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17448i = (SmartWebView) m57916c(2131232631);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.ac_learn_h5;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
