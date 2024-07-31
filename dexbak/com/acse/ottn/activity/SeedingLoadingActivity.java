package com.acse.ottn.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1618Aa;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.widget.CustomWebView;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SeedingLoadingActivity extends ActivityC1305w {

    /* renamed from: d */
    private ImageView f2142d;

    /* renamed from: e */
    private TextView f2143e;

    /* renamed from: f */
    CustomWebView f2144f;

    /* renamed from: h */
    private C1282b f2146h;

    /* renamed from: i */
    private String f2147i;

    /* renamed from: j */
    private String f2148j;

    /* renamed from: k */
    private String f2149k;

    /* renamed from: l */
    private String f2150l;

    /* renamed from: m */
    private TextView f2151m;

    /* renamed from: o */
    private String f2153o;

    /* renamed from: p */
    ValueAnimator f2154p;

    /* renamed from: q */
    private long f2155q;

    /* renamed from: r */
    private long f2156r;

    /* renamed from: g */
    private String[] f2145g = {".", "..", "..."};

    /* renamed from: n */
    Handler f2152n = new HandlerC1269G(this);

    /* renamed from: s */
    int f2157s = 0;

    /* renamed from: com.acse.ottn.activity.SeedingLoadingActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1281a extends FrameLayout {
        public C1281a(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.acse.ottn.activity.SeedingLoadingActivity$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1282b extends WebChromeClient {
        private C1282b() {
        }

        /* synthetic */ C1282b(SeedingLoadingActivity seedingLoadingActivity, View$OnClickListenerC1265D view$OnClickListenerC1265D) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    static {
        StubApp.interface11(4174);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m57295a(int i, int i2) {
        Message message = new Message();
        message.what = i;
        this.f2152n.sendMessageDelayed(message, i2);
    }

    /* renamed from: a */
    private void m57291a(String str) {
        C1694ra.m55915b("LoadingActivity ", "loadH5Url = " + str);
        try {
            CustomWebView customWebView = (CustomWebView) findViewById(C1239R.C1242id.dwebView);
            this.f2144f = customWebView;
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            C1282b c1282b = new C1282b(this, null);
            this.f2146h = c1282b;
            this.f2144f.setWebChromeClient(c1282b);
            Method method = this.f2144f.getSettings().getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(this.f2144f.getSettings(), Boolean.TRUE);
            }
            this.f2144f.setWebViewClient(new C1270H(this));
            this.f2144f.loadUrl(str);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m57289b(String str) {
        new Thread(new RunnableC1271I(this, str)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m57288c() {
        if (this.f2154p == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 3).setDuration(1000L);
            this.f2154p = duration;
            duration.setRepeatCount(-1);
            this.f2154p.addUpdateListener(new C1272J(this));
        }
        this.f2154p.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m57286d() {
        int i = this.f2157s + 1;
        this.f2157s = i;
        if (i == 1) {
            this.f2155q = System.currentTimeMillis();
        }
        if (this.f2157s == 5) {
            this.f2156r = System.currentTimeMillis();
        }
        if (this.f2157s >= 5) {
            try {
                if (this.f2156r - this.f2155q < 3000) {
                    if (C1618Aa.m56307b(this).m56303d()) {
                        Toast.makeText(this, "debug模式已关闭 false", 0).show();
                        C1618Aa.m56307b(this).m56305b(false);
                    } else {
                        C1618Aa.m56307b(this).m56305b(true);
                        Toast.makeText(this, "debug模式已开启 true", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
            this.f2157s = 0;
        }
        if (System.currentTimeMillis() - this.f2155q > 3000) {
            this.f2157s = 0;
            this.f2155q = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m57284e() {
        if (!TextUtils.isEmpty(this.f2149k)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f2149k));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.addFlags(268435456);
            startActivity(intent);
        }
        finish();
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onPause() {
        super.onPause();
        finishAndRemoveTask();
        finish();
    }
}
