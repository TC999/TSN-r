package com.acse.ottn;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.acse.ottn.widget.CustomWebView;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class t3 {

    /* renamed from: o  reason: collision with root package name */
    public static t3 f6608o;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f6609a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6610b;

    /* renamed from: c  reason: collision with root package name */
    public CustomWebView f6611c;

    /* renamed from: e  reason: collision with root package name */
    public String f6613e;

    /* renamed from: f  reason: collision with root package name */
    public String f6614f;

    /* renamed from: g  reason: collision with root package name */
    public String f6615g;

    /* renamed from: h  reason: collision with root package name */
    public String f6616h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f6617i;

    /* renamed from: j  reason: collision with root package name */
    public g f6618j;

    /* renamed from: k  reason: collision with root package name */
    public Activity f6619k;

    /* renamed from: l  reason: collision with root package name */
    public String f6620l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f6621m;

    /* renamed from: d  reason: collision with root package name */
    public String[] f6612d = {".", "..", "..."};

    /* renamed from: n  reason: collision with root package name */
    public Handler f6622n = new e();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6625a;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(t3.this.f6620l)) {
                    return;
                }
                z1.a("SeedingLoadingActivity", "write code = " + t3.this.f6620l);
                n.a().a(t3.this.f6619k, t3.this.f6620l);
            }
        }

        public c(String str) {
            this.f6625a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            t3.this.f6620l = "";
            try {
                JSONObject jSONObject = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f6625a).build()).execute().body().string());
                t3.this.f6620l = jSONObject.getString("content");
                try {
                    String string = jSONObject.getString("origin_url");
                    if (!TextUtils.isEmpty(string)) {
                        t3.this.f6615g = string;
                    }
                } catch (Throwable unused) {
                }
                t3.this.f6619k.runOnUiThread(new a());
            } catch (Exception e4) {
                t3.this.f6620l = "";
                t3.this.e();
                e4.printStackTrace();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            t3.this.f6617i.setText(t3.this.f6612d[((Integer) valueAnimator.getAnimatedValue()).intValue() % t3.this.f6612d.length]);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 == 10010) {
                ValueAnimator valueAnimator = t3.this.f6621m;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    t3.this.f6621m = null;
                }
                if (n.a().f6024s0.equals(t3.this.f6613e)) {
                    t3.this.f6609a.setImageResource(R.mipmap.jd_one);
                } else {
                    t3.this.f6609a.setImageResource(R.mipmap.loading_one);
                }
                t3.this.f6617i.setText("");
                if ("1".equals(t3.this.f6616h) || "2".equals(t3.this.f6616h) || "3".equals(t3.this.f6616h)) {
                    t3.this.f6610b.setText("\u751f\u6210\u4e13\u5c5e\u793c\u91d1...ok");
                } else {
                    t3.this.f6610b.setText("\u751f\u6210\u4e13\u5c5e\u4f18\u60e0\u5238...ok");
                }
                if (!TextUtils.isEmpty(t3.this.f6614f)) {
                    try {
                        t3 t3Var = t3.this;
                        t3Var.b(t3Var.f6614f);
                    } catch (Exception unused) {
                    }
                }
                t3.this.a(10011, 2000);
            } else if (i4 != 10011) {
                if (i4 == 10012) {
                    ValueAnimator valueAnimator2 = t3.this.f6621m;
                    if (valueAnimator2 != null) {
                        valueAnimator2.cancel();
                        t3.this.f6621m = null;
                    }
                    t3.this.e();
                }
            } else {
                t3.this.b();
                if (n.a().f6024s0.equals(t3.this.f6613e)) {
                    t3.this.f6609a.setImageResource(R.mipmap.jd_two);
                } else {
                    t3.this.f6609a.setImageResource(R.mipmap.loading_two);
                }
                if ("1".equals(t3.this.f6616h) || "2".equals(t3.this.f6616h) || "3".equals(t3.this.f6616h)) {
                    t3.this.f6610b.setText("\u590d\u5236\u793c\u91d1\u53e3\u4ee4");
                } else {
                    t3.this.f6610b.setText("\u590d\u5236\u4f18\u60e0\u5238\u53e3\u4ee4");
                }
                t3.this.f6617i.setText("...");
                t3.this.a(10012, 2000);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class f extends FrameLayout {
        public f(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g extends WebChromeClient {
        public g() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
        }

        public /* synthetic */ g(t3 t3Var, a aVar) {
            this();
        }
    }

    public final Object d() throws ObjectStreamException {
        return f6608o;
    }

    public final void e() {
        z1.a("SeedingLoadingActivity", "write code = " + this.f6620l);
        try {
            if (!TextUtils.isEmpty(this.f6615g)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f6615g));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                this.f6619k.startActivity(intent);
            }
        } catch (Throwable unused) {
        }
        this.f6619k.finish();
    }

    public final void b(String str) {
        new Thread(new c(str)).start();
    }

    public void c() {
        try {
            i2.a().a("loading_comeback");
            this.f6622n.removeMessages(10010);
            this.f6622n.removeMessages(10011);
            this.f6622n.removeMessages(10012);
        } catch (Throwable th) {
            z1.a("SeedingLoadingActivity", "onBackPressed error e = " + th.getMessage());
        }
    }

    public static t3 a() {
        if (f6608o == null) {
            synchronized (t3.class) {
                if (f6608o == null) {
                    f6608o = new t3();
                }
            }
        }
        return f6608o;
    }

    public final void b() {
        if (this.f6621m == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 3).setDuration(1000L);
            this.f6621m = duration;
            duration.setRepeatCount(-1);
            this.f6621m.addUpdateListener(new d());
        }
        this.f6621m.start();
    }

    public void a(Activity activity) {
        this.f6619k = activity;
        this.f6609a = (ImageView) activity.findViewById(R.id.loading_icon);
        if (n.a().f6024s0.equals(this.f6613e)) {
            this.f6609a.setImageResource(R.mipmap.jd_one);
        } else {
            this.f6609a.setImageResource(R.mipmap.loading_one);
        }
        this.f6610b = (TextView) activity.findViewById(R.id.tv_loading_text);
        this.f6617i = (TextView) activity.findViewById(R.id.tv_loading_animation);
        activity.findViewById(R.id.re_loading).setOnClickListener(new a());
        String stringExtra = activity.getIntent().getStringExtra("link");
        this.f6613e = activity.getIntent().getStringExtra("packagename");
        this.f6614f = activity.getIntent().getStringExtra("tkl_turn_url");
        this.f6615g = activity.getIntent().getStringExtra("origin_url");
        String stringExtra2 = activity.getIntent().getStringExtra("pic_type");
        this.f6616h = stringExtra2;
        if (!"1".equals(stringExtra2) && !"2".equals(this.f6616h) && !"3".equals(this.f6616h)) {
            this.f6610b.setText("\u751f\u6210\u4e13\u5c5e\u4f18\u60e0\u5238");
        } else {
            this.f6610b.setText("\u751f\u6210\u4e13\u5c5e\u793c\u91d1");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            a(stringExtra);
        } else {
            activity.finish();
        }
        a(10010, 2000);
        b();
    }

    public final void a(String str) {
        z1.b("LoadingActivity ", "loadH5Url = " + str);
        try {
            CustomWebView customWebView = (CustomWebView) this.f6619k.findViewById(R.id.dwebView);
            this.f6611c = customWebView;
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
            g gVar = new g(this, null);
            this.f6618j = gVar;
            this.f6611c.setWebChromeClient(gVar);
            Method method = this.f6611c.getSettings().getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(this.f6611c.getSettings(), Boolean.TRUE);
            }
            this.f6611c.setWebViewClient(new b());
            this.f6611c.loadUrl(str);
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i4, int i5) {
        Message message = new Message();
        message.what = i4;
        this.f6622n.sendMessageDelayed(message, i5);
    }
}
