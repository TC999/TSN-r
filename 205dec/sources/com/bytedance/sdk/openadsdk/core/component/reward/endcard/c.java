package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.bw;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ia.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.widget.c.sr f32312a;
    com.bytedance.sdk.openadsdk.core.a.sr bk;

    /* renamed from: c  reason: collision with root package name */
    protected TTBaseVideoActivity f32313c;
    protected SSWebView ev;
    protected AtomicInteger fz;
    protected xk gd;

    /* renamed from: i  reason: collision with root package name */
    protected int f32315i;

    /* renamed from: k  reason: collision with root package name */
    protected String f32317k;

    /* renamed from: p  reason: collision with root package name */
    protected r f32318p;

    /* renamed from: q  reason: collision with root package name */
    protected int f32319q;
    protected boolean sr;

    /* renamed from: u  reason: collision with root package name */
    protected int f32323u;
    Object ux;

    /* renamed from: w  reason: collision with root package name */
    protected me f32324w;
    protected String xv;

    /* renamed from: f  reason: collision with root package name */
    int f32314f = 0;

    /* renamed from: r  reason: collision with root package name */
    int f32320r = 0;

    /* renamed from: t  reason: collision with root package name */
    int f32322t = 0;
    String ys = "";
    protected boolean fp = false;
    protected boolean ia = false;

    /* renamed from: s  reason: collision with root package name */
    protected final AtomicBoolean f32321s = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    protected AtomicBoolean f32316j = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.ia.c ls = new com.bytedance.sdk.openadsdk.core.ia.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.1
        @Override // com.bytedance.sdk.openadsdk.core.ia.c
        public int c() {
            SSWebView sSWebView = c.this.ev;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            a.xv("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
            return measuredHeight <= 0 ? com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) c.this.f32313c) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ia.c
        public int w() {
            SSWebView sSWebView = c.this.ev;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            a.xv("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
            return measuredWidth <= 0 ? com.bytedance.sdk.openadsdk.core.eq.xk.sr((Context) c.this.f32313c) : measuredWidth;
        }
    };
    protected gd gb = new gd() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.2
        @Override // com.bytedance.sdk.openadsdk.core.ia.gd
        public void c() {
            SSWebView sSWebView = c.this.ev;
            if (sSWebView == null) {
                a.w("BaseEndCard", "webView has destroy when onPauseWebView");
                return;
            }
            sSWebView.ab_();
            a.w("BaseEndCard", "js make webView onPause OK");
        }

        @Override // com.bytedance.sdk.openadsdk.core.ia.gd
        public void w() {
            SSWebView sSWebView = c.this.ev;
            if (sSWebView == null) {
                a.w("BaseEndCard", "webView has destroy when onPauseWebViewTimers");
                return;
            }
            sSWebView.k();
            a.w("BaseEndCard", "js make webView pauseTimers OK");
        }
    };

    public c(TTBaseVideoActivity tTBaseVideoActivity, me meVar, String str, int i4, int i5, boolean z3) {
        this.f32313c = tTBaseVideoActivity;
        this.f32324w = meVar;
        this.xv = str;
        this.f32323u = meVar.fh();
        this.f32315i = i4;
        this.f32319q = i5;
        this.sr = z3;
    }

    private void ck() {
        if (this.f32316j.getAndSet(true)) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ev, "translationY", 0.0f, com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) this.f32313c));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.bytedance.sdk.openadsdk.core.eq.xk.c((View) c.this.ev, 8);
                c.this.f32316j.set(false);
            }
        });
        ofFloat.start();
    }

    private void n() {
        if (this.f32316j.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ev, "translationY", com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) this.f32313c), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.f32316j.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4, int i5) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i4);
            jSONObject.put("height", i5);
            this.gd.c("resize", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void z() {
        xk xkVar = this.gd;
        if (xkVar == null) {
            return;
        }
        xkVar.c(new SSWebView.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.w
            public void c(int i4) {
                xk xkVar2 = c.this.gd;
                if (xkVar2 != null) {
                    xkVar2.c(i4);
                }
            }
        });
    }

    public void a() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            sSWebView.aa_();
        }
        xk xkVar = this.gd;
        if (xkVar != null) {
            xkVar.z();
            SSWebView sSWebView2 = this.ev;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.gd.r(true);
                    c(true);
                    c(false, true);
                } else {
                    this.gd.r(false);
                    c(false);
                    c(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.bk;
        if (srVar != null) {
            srVar.xv();
        }
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar2 = this.f32312a;
        if (srVar2 != null) {
            srVar2.xv();
        }
    }

    public void bk() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            sSWebView.ab_();
        }
        xk xkVar = this.gd;
        if (xkVar != null) {
            xkVar.ba();
            this.gd.r(false);
            c(false);
            c(true, false);
        }
    }

    public abstract void c(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.w.w wVar);

    public abstract void c(boolean z3, Map<String, Object> map, View view);

    public void ev() {
        SSWebView sSWebView = this.ev;
        if (sSWebView == null || !sSWebView.sr()) {
            return;
        }
        this.ev.ux();
    }

    public void f() {
        if (this.f32313c.b() instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd) {
            ck();
        } else {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ev, 8);
        }
    }

    public void fp() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            sSWebView.aa_();
            this.ev.getWebView().resumeTimers();
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ev.getWebView(), 1.0f);
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ev, 1.0f);
            z();
        }
    }

    public void fz() {
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.a();
        }
    }

    public void gb() {
    }

    public void gd() {
        this.f32318p = null;
    }

    public boolean i() {
        xk xkVar = this.gd;
        if (xkVar == null) {
            return false;
        }
        return xkVar.q();
    }

    public void ia() {
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.gd();
        }
    }

    public void j() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            sSWebView.c("about:blank");
        }
    }

    public String k() {
        return this.ys;
    }

    public abstract String ls();

    public int p() {
        return this.f32322t;
    }

    public boolean q() {
        return c(this.f32317k);
    }

    public boolean r() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            return sSWebView.sr();
        }
        return false;
    }

    public void s() {
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.k();
        }
    }

    public void sr(boolean z3) {
    }

    public boolean sr() {
        return this.fp;
    }

    public void t() {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.bk;
        if (srVar != null) {
            srVar.sr();
        }
    }

    public void u() {
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.xv();
            this.f32318p.sr();
        }
    }

    public void ux() {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.bk;
        if (srVar != null) {
            srVar.c(System.currentTimeMillis());
        }
    }

    public void xv(boolean z3) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            this.gd.r(z3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void ys() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            bw.c(this.f32313c, sSWebView.getWebView());
            bw.c(this.ev.getWebView());
            this.ev.gd();
        }
        this.ev = null;
        xk xkVar = this.gd;
        if (xkVar != null) {
            xkVar.y();
        }
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.c(true);
            this.f32318p.fp();
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.bk;
        if (srVar != null) {
            srVar.ux();
        }
        me meVar = this.f32324w;
        if (meVar != null && !TextUtils.isEmpty(meVar.jd())) {
            xv.c.c(this.f32320r, this.f32314f, this.f32324w);
        }
        com.bytedance.sdk.openadsdk.core.t.c.c().c(this.ux);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.c.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SSWebView sSWebView2 = c.this.ev;
                    if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                        return;
                    }
                    c.this.ev.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = c.this.ev.getMeasuredWidth();
                    int measuredHeight = c.this.ev.getMeasuredHeight();
                    if (c.this.ev.getVisibility() == 0) {
                        c.this.w(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    public boolean xv() {
        if (q()) {
            AtomicInteger atomicInteger = this.fz;
            if (atomicInteger == null || atomicInteger.get() == 0) {
                return this.f32321s.get();
            }
            return true;
        }
        return false;
    }

    public void c(boolean z3) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z3 ? 1 : 0);
            this.gd.c("viewableChange", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void w(boolean z3) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z3);
            this.gd.c("volumeChange", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(boolean z3, boolean z4) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z3);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z4);
            this.gd.c("endcard_control_event", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean w() {
        return this.ia;
    }

    public void c(int i4, int i5) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i4);
            jSONObject.put("downloadProcessRate", i5);
            this.gd.w("showDownloadStatus", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(long j4, long j5, int i4) {
        if (j5 > 0) {
            c(i4, (int) ((j4 * 100) / j5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        WebView webView = sSWebView.getWebView();
        com.bytedance.sdk.openadsdk.core.widget.c.w.c(this.f32313c).c(false).w(false).c(webView);
        sSWebView.setUserAgentString(fz.c(webView, eq.f33190w, me.f(this.f32324w)));
        com.bytedance.sdk.openadsdk.core.eq.xk.c(webView);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            sSWebView.setMixedContentMode(0);
        }
        if (i4 < 24) {
            this.ev.setLayerType(0, null);
        }
    }

    public void c(int i4) {
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ev, 0);
        SSWebView sSWebView = this.ev;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView.getWebView(), 0);
        }
        if (i4 == 1) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) this.ev, 0.0f);
            SSWebView sSWebView2 = this.ev;
            if (sSWebView2 != null) {
                com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView2.getWebView(), 0.0f);
            }
        }
        if (i4 == 2) {
            n();
        }
        xk xkVar = this.gd;
        if (xkVar != null) {
            xkVar.c(wv.t(this.f32324w), false);
        }
    }

    public void c(Map<String, Object> map) {
        r rVar = this.f32318p;
        if (rVar != null) {
            rVar.p();
        }
    }

    public void c(boolean z3, int i4, String str) {
        r rVar = this.f32318p;
        if (rVar == null) {
            return;
        }
        if (z3) {
            rVar.w();
        } else {
            rVar.c(i4, str);
        }
    }

    private boolean c(String str) {
        try {
            new URL(str);
            if (URLUtil.isValidUrl(str)) {
                return Patterns.WEB_URL.matcher(str).matches();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void c(JSONObject jSONObject) {
        xk xkVar = this.gd;
        if (xkVar == null) {
            a.f("BaseEndCard", "mJsObject is null!");
        } else {
            xkVar.c("showPlayAgainEntrance", jSONObject);
        }
    }

    public void c(me meVar) {
        this.f32324w = meVar;
        this.fp = false;
    }
}
