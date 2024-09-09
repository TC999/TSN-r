package com.bytedance.sdk.component.adexpress.ux;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.adexpress.w.ev;
import com.bytedance.sdk.component.adexpress.w.k;
import com.bytedance.sdk.component.adexpress.w.r;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements com.bytedance.sdk.component.adexpress.c, com.bytedance.sdk.component.adexpress.theme.c, k, com.bytedance.sdk.component.adexpress.w.sr<SSWebView> {

    /* renamed from: a  reason: collision with root package name */
    private ev f29397a;
    private bk bk;

    /* renamed from: c  reason: collision with root package name */
    protected JSONObject f29398c;
    private String ev;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29400k;

    /* renamed from: p  reason: collision with root package name */
    private volatile r f29401p;

    /* renamed from: r  reason: collision with root package name */
    private Context f29402r;

    /* renamed from: t  reason: collision with root package name */
    private boolean f29403t;
    protected com.bytedance.sdk.component.adexpress.c.xv.w ux;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f29404w;
    protected SSWebView xv;
    private int ys;
    protected int sr = 8;

    /* renamed from: f  reason: collision with root package name */
    protected AtomicBoolean f29399f = new AtomicBoolean(false);
    private boolean fp = false;

    public c(Context context, bk bkVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.f29400k = false;
        this.f29402r = context;
        this.bk = bkVar;
        this.ev = bkVar.sr();
        themeStatusBroadcastReceiver.c(this);
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            k();
            return;
        }
        SSWebView a4 = a();
        this.xv = a4;
        if (a4 == null) {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (com.bytedance.sdk.component.adexpress.sr.getContext() != null) {
                this.xv = new SSWebView(com.bytedance.sdk.component.adexpress.sr.getContext());
                return;
            }
            return;
        }
        this.f29400k = true;
        Log.d("WebViewRender", "initWebView: reuse WebView");
    }

    private SSWebView a() {
        if (this.bk.i()) {
            return ux.c().c(this.f29402r, this.ev);
        }
        return ux.c().w(this.f29402r, this.ev);
    }

    private void bk() {
        if (this.bk.i()) {
            ux.c().w(this.xv);
        } else {
            ux.c().xv(this.xv);
        }
    }

    private void k() {
        if (this.f29402r == null && com.bytedance.sdk.component.adexpress.sr.getContext() != null) {
            this.f29402r = com.bytedance.sdk.component.adexpress.sr.getContext();
        }
        if (this.f29402r != null) {
            SSWebView a4 = a();
            this.xv = a4;
            if (a4 == null) {
                Log.d("WebViewRender", "initWebView: create WebView by act");
                this.xv = new SSWebView(new MutableContextWrapper(StubApp.getOrigApplicationContext(this.f29402r.getApplicationContext())));
                return;
            }
            this.f29400k = true;
            Log.d("WebViewRender", "initWebView: reuse WebView");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z3, int i4) {
    }

    public void ev() {
        gd();
        Activity c4 = com.bytedance.sdk.component.utils.w.c(this.xv);
        if (c4 != null) {
            this.ys = w(c4);
        }
    }

    public abstract void f();

    protected void gd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
    }

    public void sr() {
        if (this.f29399f.get()) {
            return;
        }
        this.f29399f.set(true);
        f();
        if (this.xv.getParent() != null) {
            ((ViewGroup) this.xv.getParent()).removeView(this.xv);
        }
        if (this.f29404w) {
            bk();
        } else {
            ux.c().ux(this.xv);
        }
    }

    public void ux() {
        if (c() == null) {
            return;
        }
        try {
            c().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    /* renamed from: w */
    public SSWebView r() {
        return c();
    }

    public abstract void w(int i4);

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public int xv() {
        return 0;
    }

    private int w(Activity activity) {
        return activity.hashCode();
    }

    public void c(String str) {
        this.gd = str;
    }

    public SSWebView c() {
        return this.xv;
    }

    public void c(ev evVar) {
        this.f29397a = evVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public void c(r rVar) {
        this.f29401p = rVar;
        if (c() != null && c().getWebView() != null) {
            if (TextUtils.isEmpty(this.gd)) {
                this.f29401p.c(102, "url is empty");
                return;
            } else if (!this.fp && !com.bytedance.sdk.component.adexpress.c.w.w.c(this.f29398c)) {
                r rVar2 = this.f29401p;
                StringBuilder sb = new StringBuilder();
                sb.append("data null is ");
                sb.append(this.f29398c == null);
                rVar2.c(103, sb.toString());
                return;
            } else if (this.fp && !com.bytedance.sdk.component.adexpress.c.w.w.w(this.f29398c)) {
                r rVar3 = this.f29401p;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("choice ad data null is ");
                sb2.append(this.f29398c == null);
                rVar3.c(103, sb2.toString());
                return;
            } else {
                this.bk.ux().c(this.f29400k);
                if (this.f29400k) {
                    try {
                        this.xv.p();
                        this.bk.ux().a();
                        com.bytedance.sdk.component.utils.k.c(this.xv.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                        return;
                    } catch (Exception e4) {
                        a.w("WebViewRender", "reuse webview load fail ");
                        ux.c().ux(this.xv);
                        r rVar4 = this.f29401p;
                        rVar4.c(102, "load exception is " + e4.getMessage());
                        return;
                    }
                }
                SSWebView c4 = c();
                c4.p();
                this.bk.ux().a();
                c4.c(this.gd);
                return;
            }
        }
        r rVar5 = this.f29401p;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SSWebview null is ");
        sb3.append(c() == null);
        sb3.append(" or Webview is null");
        rVar5.c(102, sb3.toString());
    }

    public void c(boolean z3) {
        this.f29403t = z3;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(final t tVar) {
        if (tVar == null) {
            if (this.f29401p != null) {
                this.f29401p.c(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean xv = tVar.xv();
        final float sr = (float) tVar.sr();
        final float ux = (float) tVar.ux();
        if (sr > 0.0f && ux > 0.0f) {
            this.f29404w = xv;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(tVar, sr, ux);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ux.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c(tVar, sr, ux);
                    }
                });
            }
        } else if (this.f29401p != null) {
            r rVar = this.f29401p;
            rVar.c(105, "width is " + sr + "height is " + ux);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(t tVar, float f4, float f5) {
        c(this.f29404w, tVar.k());
        boolean z3 = this.f29404w;
        if (!z3 || this.f29403t) {
            if (!z3) {
                ux.c().ux(this.xv);
                return;
            } else {
                c(tVar.k(), tVar.p());
                return;
            }
        }
        c(f4, f5);
        w(this.sr);
        if (this.f29401p != null) {
            this.f29401p.c(c(), tVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar) {
        ev evVar = this.f29397a;
        if (evVar != null) {
            evVar.c(view, i4, xvVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar, int i5) {
        ev evVar = this.f29397a;
        if (evVar != null) {
            evVar.c(view, i4, xvVar, i5);
        }
    }

    @UiThread
    private void c(float f4, float f5) {
        this.bk.ux().bk();
        int c4 = (int) f.c(this.f29402r, f4);
        int c5 = (int) f.c(this.f29402r, f5);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(c4, c5);
        }
        layoutParams.width = c4;
        layoutParams.height = c5;
        c().setLayoutParams(layoutParams);
    }

    private void c(int i4, String str) {
        if (this.f29401p != null) {
            this.f29401p.c(i4, str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.c
    public void c(Activity activity) {
        if (this.ys == 0 || activity == null || activity.hashCode() != this.ys) {
            return;
        }
        a.w("WebViewRender", "release from activity onDestroy");
        sr();
        p();
    }
}
