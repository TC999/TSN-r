package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.c.f;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.bk.ev;
import com.bytedance.sdk.openadsdk.bk.r;
import com.bytedance.sdk.openadsdk.core.a.sr;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.gd;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.component.reward.w.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ia.ux;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.widget.PlayableLoadingView;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.c implements n.c, sr.w {
    private static final r.c bj = new r.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.4
        @Override // com.bytedance.sdk.openadsdk.bk.r.c
        public void c(String str, String str2) {
            a.w(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.bk.r.c
        public void c(String str, String str2, Throwable th) {
            a.xv(str, str2, th);
        }
    };
    private w.c au;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ia.w f32350b;
    final n ba;
    private final ux bm;
    private w.InterfaceC0484w bw;
    protected final AtomicBoolean ck;
    private final AtomicBoolean eq;
    private RewardLpBottomView gw;

    /* renamed from: m  reason: collision with root package name */
    private PlayableEndcardFrameLayout f32351m;
    private FrameLayout me;
    private com.bytedance.sdk.openadsdk.core.multipro.w.c mt;

    /* renamed from: n  reason: collision with root package name */
    protected final AtomicBoolean f32352n;
    private final com.bytedance.sdk.openadsdk.core.ia.sr ng;
    private final c oo;
    private com.bytedance.sdk.openadsdk.core.w.w ox;
    private boolean pr;
    private final com.bytedance.sdk.openadsdk.core.playable.r up;
    private boolean vc;
    private DownloadListener wo;
    private com.bytedance.sdk.openadsdk.core.ugeno.xv.xv wv;
    private final com.bytedance.sdk.openadsdk.core.playable.xv wx;

    /* renamed from: x  reason: collision with root package name */
    private final LinearLayout f32353x;
    private com.bytedance.sdk.openadsdk.core.a.ux xk;
    private String xu;

    /* renamed from: y  reason: collision with root package name */
    long f32354y;
    private ev yu;

    /* renamed from: z  reason: collision with root package name */
    protected final AtomicBoolean f32355z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(WebView webView, int i4);

        void c(WebView webView, String str);

        void c(WebView webView, String str, Bitmap bitmap);
    }

    public xv(TTBaseVideoActivity tTBaseVideoActivity, me meVar, String str, int i4, int i5, boolean z3, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, meVar, str, i4, i5, z3);
        this.f32352n = new AtomicBoolean(false);
        this.ck = new AtomicBoolean(false);
        this.f32355z = new AtomicBoolean(false);
        this.eq = new AtomicBoolean(false);
        this.ba = new n(Looper.getMainLooper(), this);
        this.vc = true;
        this.f32354y = 0L;
        this.oo = new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.c
            public void c(WebView webView, String str2) {
                if (xv.this.f32313c.b() instanceof gd) {
                    return;
                }
                xv.this.ba.removeMessages(101);
                if (xv.this.f32352n.getAndSet(true)) {
                    return;
                }
                if (u.ux(xv.this.f32324w) || xv.this.pr) {
                    if (!xv.this.q()) {
                        if (xv.this.au != null) {
                            xv.this.au.c();
                        }
                    } else {
                        xv.this.c(0);
                    }
                }
                xv.this.ng.w();
                xv xvVar = xv.this;
                com.bytedance.sdk.openadsdk.core.a.xv.sr(xvVar.f32324w, xvVar.xv, "py_loading_success", (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.c
            public void c(WebView webView, String str2, Bitmap bitmap) {
                if (u.ux(xv.this.f32324w)) {
                    if (xv.this.f32324w.ms() == 1 || fp.k(xv.this.f32324w)) {
                        xv.this.ba.sendEmptyMessageDelayed(101, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    }
                    if (xv.this.ck.getAndSet(true)) {
                        return;
                    }
                    xv.this.f32354y = System.currentTimeMillis();
                    xv.this.bw.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.c
            public void c(WebView webView, int i6) {
                xv.this.ng.c(i6);
            }
        };
        this.bm = new ux() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.5
            @Override // com.bytedance.sdk.openadsdk.core.ia.ux
            public void c() {
                xv.this.gd.p(true);
                if (fp.k(xv.this.f32324w)) {
                    xv.this.bw.w();
                }
                xv.this.f32313c.xv(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia.ux
            public void w() {
                if (m.k(xv.this.f32324w)) {
                    xv.this.f32313c.sr(3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia.ux
            public void xv() {
                if (!fp.c(xv.this.f32324w) || fp.k(xv.this.f32324w)) {
                    return;
                }
                xv.this.f32313c.c(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia.ux
            public void c(int i6, String str2) {
                a.c("Playable Plugin notify failed! : code:" + str2 + "; msg:" + str2);
                if (wx.a(xv.this.f32324w)) {
                    xv xvVar = xv.this;
                    xvVar.ia = false;
                    xvVar.f32321s.set(false);
                    xv.this.m();
                }
            }
        };
        this.f32350b = new com.bytedance.sdk.openadsdk.core.ia.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.6
            @Override // com.bytedance.sdk.openadsdk.core.ia.w
            public void c(boolean z4, int i6, String str2) {
                a.w("end card load finish: ", "code=" + i6 + " msg=" + str2 + " isRenderSuc=" + z4);
                if (z4) {
                    xv.this.ia = true;
                }
            }
        };
        this.ng = new com.bytedance.sdk.openadsdk.core.ia.sr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.3
            @Override // com.bytedance.sdk.openadsdk.core.ia.sr
            public void c() {
                if (!xv.this.f32313c.isFinishing() && wx.gd(xv.this.f32324w)) {
                    xv.this.ba.removeMessages(102);
                    xv xvVar = xv.this;
                    xvVar.ba.sendMessage(xvVar.w(1));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia.sr
            public void w() {
                if (xv.this.f32313c.isFinishing()) {
                    return;
                }
                if ((u.ux(xv.this.f32324w) || xv.this.pr) && wx.ev(xv.this.f32324w)) {
                    xv xvVar = xv.this;
                    xvVar.ba.sendMessage(xvVar.w(0));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia.sr
            public void c(int i6) {
                if (!wx.r(xv.this.f32324w) || xv.this.f32313c.isFinishing()) {
                    return;
                }
                xv.this.wx.c(i6);
            }
        };
        this.ev = abstractEndCardFrameLayout.getPlayableWebView();
        this.me = (FrameLayout) this.f32313c.findViewById(2114387924);
        this.f32351m = (PlayableEndcardFrameLayout) this.f32313c.findViewById(2114387674);
        this.gw = (RewardLpBottomView) this.f32313c.findViewById(2114387827);
        this.f32353x = (LinearLayout) this.f32313c.findViewById(2114387721);
        this.wx = new com.bytedance.sdk.openadsdk.core.playable.xv((PlayableLoadingView) this.f32313c.findViewById(2114387927), meVar);
        this.up = new com.bytedance.sdk.openadsdk.core.playable.r(this.xv, tTBaseVideoActivity, meVar, u.ux(this.f32324w) ? 2 : 1, tTBaseVideoActivity.b().wv(), abstractEndCardFrameLayout.getVideoArea());
        c();
    }

    private void bw() {
        this.f32317k = u.c(this.f32324w);
        a.w("PlayableEndCard", "endcardUrl=" + this.f32317k);
        float yx = this.f32324w.yx();
        if (TextUtils.isEmpty(this.f32317k)) {
            return;
        }
        if (this.f32323u == 1) {
            if (this.f32317k.contains("?")) {
                this.f32317k += "&orientation=portrait";
            } else {
                this.f32317k += "?orientation=portrait";
            }
        }
        if (this.f32317k.contains("?")) {
            this.f32317k += "&height=" + this.f32319q + "&width=" + this.f32315i + "&aspect_ratio=" + yx;
            return;
        }
        this.f32317k += "?height=" + this.f32319q + "&width=" + this.f32315i + "&aspect_ratio=" + yx;
    }

    private void gw() {
        if (this.f32313c.bj() == null) {
            return;
        }
        long ia = !this.f32313c.bj().c() ? this.f32313c.bj().ia() : 0L;
        boolean t3 = this.f32313c.bj().t();
        if (!(this.f32313c.b() instanceof gd)) {
            ev evVar = this.yu;
            t3 = evVar != null && evVar.r();
        }
        this.up.c(ia, t3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.ba.sendMessage(w(3));
        w.c cVar = this.au;
        if (cVar != null) {
            cVar.c();
        }
        this.f32313c.xv(0);
    }

    private void pr() {
        RewardLpBottomView rewardLpBottomView;
        if (!u.gd(this.f32324w)) {
            this.gw = null;
        } else if (fp.sr(this.f32324w)) {
            this.gw = null;
        } else if (!fp.ux(this.f32324w)) {
            this.gw = null;
        } else if (this.f32351m == null || (rewardLpBottomView = this.gw) == null) {
        } else {
            rewardLpBottomView.c(this.f32324w, this.xv);
            this.f32351m.c(new PlayableEndcardFrameLayout.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.8
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.c
                public void c() {
                    if (xv.this.gw != null) {
                        xv.this.gw.w();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = xv.this.f32313c;
                    if (tTBaseVideoActivity != null) {
                        tTBaseVideoActivity.p(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        this.ia = true;
        this.f32355z.set(true);
        this.ba.sendMessage(w(4));
        TTBaseVideoActivity tTBaseVideoActivity = this.f32313c;
        if (tTBaseVideoActivity != null) {
            tTBaseVideoActivity.a(8);
        }
        w.InterfaceC0484w interfaceC0484w = this.bw;
        if (interfaceC0484w != null) {
            interfaceC0484w.c();
        }
    }

    private void x() {
        SSWebView sSWebView;
        Bitmap w3;
        if (Looper.getMainLooper() != Looper.myLooper() || !ls.w().pb() || this.f32324w == null || (sSWebView = this.ev) == null || sSWebView.getWebView() == null || !wx.c(this.f32324w) || (w3 = xk.w(this.ev.getWebView())) == null) {
            return;
        }
        xk.c(ls.getContext(), this.f32324w, this.xv, "playable_show_status", w3, false, 1);
    }

    public long ba() {
        return System.currentTimeMillis() - this.f32354y;
    }

    public void ck() {
        SSWebView sSWebView;
        if (this.fp || (sSWebView = this.ev) == null) {
            return;
        }
        sSWebView.c(this.f32317k);
        this.fp = true;
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.r(this.f32317k);
        }
    }

    public com.bytedance.sdk.openadsdk.core.xk eq() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void gb() {
        super.gb();
        this.up.xv();
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = this.wv;
        if (xvVar != null) {
            xvVar.xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public String ls() {
        return "playable";
    }

    public boolean me() {
        return !this.f32355z.get();
    }

    public boolean n() {
        return this.f32352n.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void t() {
        super.t();
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = this.xk;
        if (uxVar != null) {
            uxVar.c(0);
        }
    }

    public void wv() {
        WebView webView;
        SSWebView sSWebView = this.ev;
        if (sSWebView == null || this.yu != null || (webView = sSWebView.getWebView()) == null) {
            return;
        }
        if (k.sr().z()) {
            r.c(bj);
        }
        com.bytedance.sdk.openadsdk.core.s.xv xvVar = new com.bytedance.sdk.openadsdk.core.s.xv();
        sr srVar = new sr(this.f32324w, this.xv, this.bm);
        com.bytedance.sdk.openadsdk.core.s.ux uxVar = new com.bytedance.sdk.openadsdk.core.s.ux(this.gd);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.f32324w.jr());
            jSONObject.put("log_extra", this.f32324w.cf());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        this.yu = xvVar.c(ls.getContext(), webView, uxVar, srVar, hashSet, ev.c.LAND_PAGE).f(this.f32317k).ux(com.bytedance.sdk.openadsdk.core.r.c.r()).c(com.bytedance.sdk.openadsdk.core.r.c.c()).ux(jSONObject).c("sdkEdition", com.bytedance.sdk.openadsdk.core.r.c.xv()).w(com.bytedance.sdk.openadsdk.core.r.c.ux()).sr(com.bytedance.sdk.openadsdk.core.r.c.sr()).c(wx.bk(this.f32324w)).w(wx.t(this.f32324w)).sr(false).c(false);
        if (!TextUtils.isEmpty(wx.w(this.f32324w))) {
            this.yu.xv(wx.w(this.f32324w));
        }
        Set<String> p3 = this.yu.p();
        if (this.gd == null || p3 == null || p3.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.yu);
        for (String str : p3) {
            this.gd.xv().c(str, (com.bytedance.sdk.component.c.ux<?, ?>) new com.bytedance.sdk.component.c.ux<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.2
                @Override // com.bytedance.sdk.component.c.ux
                public JSONObject c(JSONObject jSONObject2, f fVar) throws Exception {
                    try {
                        ev evVar = (ev) weakReference.get();
                        if (evVar == null) {
                            return null;
                        }
                        return evVar.sr(c(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public void xk() {
        if (wx.r(this.f32324w)) {
            this.wx.xv();
            this.wx.c(this.f32324w, this.xv);
            if (wx.gd(this.f32324w)) {
                this.ba.sendMessageDelayed(w(2), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
            f();
        } else {
            c(0);
            this.wx.w();
            this.f32313c.ox();
        }
        ux(true);
    }

    public boolean y() {
        com.bytedance.sdk.openadsdk.core.xk xkVar = this.gd;
        if (xkVar != null) {
            return xkVar.p();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void ys() {
        super.ys();
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.wx();
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.bk;
        if (srVar != null) {
            srVar.c((sr.w) null);
        }
        this.up.sr();
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = this.wv;
        if (xvVar != null) {
            xvVar.sr();
        }
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = this.xk;
        if (uxVar != null) {
            uxVar.sr();
        }
    }

    public void yu() {
        this.wx.w();
    }

    public void z() {
        c(true);
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.xv(true);
        }
        xv(true);
        c(false, true);
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = this.f32312a;
        if (srVar != null) {
            srVar.xv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z3) {
        this.f32313c.xv(z3);
        com.bytedance.sdk.openadsdk.core.xk xkVar = this.gd;
        if (xkVar != null) {
            xkVar.ys(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void a() {
        super.a();
        if (this.yu != null && xk.sr(this.ev)) {
            this.yu.xv(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = this.wv;
        if (xvVar != null) {
            xvVar.xv();
        }
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = this.xk;
        if (uxVar != null) {
            uxVar.xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void bk() {
        super.bk();
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.xv(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = this.wv;
        if (xvVar != null) {
            xvVar.w();
        }
    }

    public void f(boolean z3) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            this.gd.ev(z3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z3);
            this.gd.c("isVerifyReward", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void r(boolean z3) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        this.pr = z3;
        this.gd.a(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void sr(boolean z3) {
        super.sr(z3);
        if (!z3) {
            this.up.w();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = this.wv;
        if (xvVar != null) {
            xvVar.w();
        }
    }

    public void ux(boolean z3) {
        LinearLayout linearLayout = this.f32353x;
        if (linearLayout == null) {
            return;
        }
        if (z3) {
            if (this.vc) {
                com.bytedance.sdk.openadsdk.core.p.xv.k.c(this.f32324w, (ViewGroup) linearLayout, (Context) this.f32313c, this.xv, true, new com.bytedance.sdk.openadsdk.core.w.f() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.11
                    @Override // com.bytedance.sdk.openadsdk.core.w.f
                    public void c() {
                        xv.this.ev(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.w.f
                    public void w() {
                        xv.this.vc = false;
                        xv.this.ev(false);
                    }
                }, false);
                return;
            }
            xk.c((View) linearLayout, 0);
            ev(false);
            return;
        }
        xk.c((View) linearLayout, 8);
        ev(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z3, Map<String, Object> map, View view) {
        SSWebView sSWebView = this.ev;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.sr w3 = new com.bytedance.sdk.openadsdk.core.a.sr(this.f32324w, this.ev.getWebView()).w(true);
        this.bk = w3;
        w3.c(this);
        this.bk.c(true);
        this.bk.c(z3 ? "reward_endcard" : "fullscreen_endcard");
        com.bytedance.sdk.openadsdk.core.xk xkVar = new com.bytedance.sdk.openadsdk.core.xk(this.f32313c);
        this.gd = xkVar;
        xkVar.w(this.ev).c(this.f32324w).w(this.f32324w.jr()).xv(this.f32324w.cf()).xv(z3 ? 7 : 5).c(this.ls).sr(wv.t(this.f32324w)).c(this.ev).w(com.bytedance.sdk.openadsdk.core.p.xv.k.c(this.f32324w)).c(this.xv).c(map).c(this.gb).c(view).c(this.bm);
        if (!u.ux(this.f32324w)) {
            this.gd.gd(true);
        }
        this.gd.c(this.f32350b);
        this.gd.c(this.ng);
        pr();
        bw();
        wv();
    }

    public void c(com.bytedance.sdk.openadsdk.core.multipro.w.c cVar) {
        this.mt = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(boolean z3, Map<String, Object> map, View view) {
        if (wv.ia(this.f32324w) && this.me != null) {
            c(map, view);
        } else {
            w(z3, map, view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void f() {
        SSWebView sSWebView = this.ev;
        if (sSWebView != null && sSWebView.getVisibility() == 0) {
            this.bw.xv().c(true);
        }
        super.f();
        this.up.c();
        ux(false);
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.xv(false);
        }
        c(true, false);
    }

    private void c(final Map<String, Object> map, final View view) {
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = new com.bytedance.sdk.openadsdk.core.a.ux(this.f32324w);
        this.xk = uxVar;
        uxVar.c(true);
        this.xk.c();
        this.me.setVisibility(0);
        TTBaseVideoActivity tTBaseVideoActivity = this.f32313c;
        FrameLayout frameLayout = this.me;
        com.bytedance.sdk.openadsdk.core.a.ux uxVar2 = this.xk;
        me meVar = this.f32324w;
        String str = this.xv;
        com.bytedance.sdk.openadsdk.core.ugeno.xv.xv xvVar = new com.bytedance.sdk.openadsdk.core.ugeno.xv.xv(tTBaseVideoActivity, frameLayout, uxVar2, meVar, str, wv.c(str), this.mt);
        this.wv = xvVar;
        xvVar.c();
        this.wv.c(new com.bytedance.sdk.openadsdk.core.ugeno.sr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.7
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(View view2) {
                xv.this.wx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(int i4) {
                xv.this.wv = null;
                com.bytedance.sdk.component.utils.ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xv.this.me != null) {
                            xv.this.me.setVisibility(8);
                        }
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        xv xvVar2 = xv.this;
                        xvVar2.fp = false;
                        xvVar2.w(xvVar2.sr, map, view);
                        xv xvVar3 = xv.this;
                        xvVar3.w(xvVar3.wo, xv.this.ox);
                        xv.this.ck();
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.wo = downloadListener;
        this.ox = wVar;
        w(downloadListener, wVar);
    }

    private void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!u.gd(this.f32324w) || (rewardLpBottomView = this.gw) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(int i4) {
        super.c(i4);
        if (!this.wx.sr()) {
            z();
        }
        ux(true);
        gw();
    }

    public void c(w.InterfaceC0484w interfaceC0484w) {
        this.bw = interfaceC0484w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.w.w wVar) {
        if (this.ev == null) {
            return;
        }
        this.wo = null;
        this.ox = null;
        this.ux = com.bytedance.sdk.openadsdk.core.t.c.c().c(this.f32324w);
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f32313c, this.gd, this.f32324w.jr(), this.bk) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (xv.this.yu != null && str != null && !str.contains("about:blank")) {
                    xv.this.yu.ev(str);
                }
                super.onPageFinished(webView, str);
                xv.this.oo.c(webView, str);
                if (xv.this.gw != null) {
                    xv.this.gw.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                xv.this.f32355z.set(true);
                xv.this.oo.c(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i4, String str, String str2) {
                xv.this.f32321s.set(false);
                xv.this.fz = this.ev;
                xv xvVar = xv.this;
                xvVar.f32322t = i4;
                xvVar.ys = str;
                if (xvVar.yu != null) {
                    xv.this.yu.c(i4, str, str2);
                }
                super.onReceivedError(webView, i4, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (xv.this.yu != null) {
                    try {
                        xv.this.yu.c(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (xv.this.f32317k.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        xv.this.f32321s.set(false);
                        xv.this.fz = this.ev;
                    }
                    if (webResourceResponse != null) {
                        xv.this.f32322t = webResourceResponse.getStatusCode();
                        xv.this.ys = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (u.xv(xv.this.f32324w) && ng.bk(xv.this.f32324w) != null) {
                    String c4 = u.c(xv.this.f32324w);
                    return com.bytedance.sdk.openadsdk.core.playable.c.c().c(wx.f(xv.this.f32324w), c4, str);
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    me meVar = xv.this.f32324w;
                    if (meVar == null) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    if (TextUtils.isEmpty(meVar.jd())) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    xv.this.f32314f++;
                    com.bytedance.sdk.openadsdk.core.t.c c4 = com.bytedance.sdk.openadsdk.core.t.c.c();
                    xv xvVar = xv.this;
                    WebResourceResponse c5 = c4.c(xvVar.ux, xvVar.f32324w, uri);
                    if (c5 != null) {
                        xv.this.f32320r++;
                        return c5;
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    a.xv("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    xv.this.f32321s.set(false);
                    xv.this.fz = this.ev;
                }
                xv.this.f32322t = webResourceError.getErrorCode();
                xv.this.ys = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.f32312a = srVar;
        this.ev.setWebViewClient(srVar);
        c(this.ev);
        this.ev.setBackgroundColor(-16777216);
        this.ev.setDisplayZoomControls(false);
        this.ev.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.c.xv(this.gd, this.bk) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv.10
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i4) {
                super.onProgressChanged(webView, i4);
                xv.this.oo.c(webView, i4);
            }
        });
        this.ev.setDownloadListener(downloadListener);
        this.wx.c(wVar);
        c(wVar);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        if (i4 == 101) {
            m();
        } else if (i4 != 102) {
        } else {
            if (!this.eq.getAndSet(true)) {
                this.wx.c(this.xv, message.arg1, ng.bk(this.f32324w) != null ? u.c(this.f32324w) : null);
                this.wx.w(this.f32324w, this.xv);
            }
            this.ba.removeMessages(102);
            this.bw.xv().c(true);
            this.f32313c.ox();
            this.wx.w();
            int i5 = message.arg1;
            if (i5 == 2) {
                w.c cVar = this.au;
                if (cVar != null) {
                    cVar.c();
                }
            } else if (i5 == 0 || i5 == 1) {
                z();
            }
        }
    }

    public void w(int i4, int i5) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i4);
            if (this.sr) {
                jSONObject.put("reward_remain_time", i5);
            }
            this.gd.c("reward_button_status", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.sr.w
    public void c(String str) {
        if (TextUtils.isEmpty(this.xu)) {
            this.xu = str;
        }
        if (TextUtils.equals(this.xu, str)) {
            return;
        }
        this.xu = str;
        this.f32313c.p(1);
    }

    public void c(w.c cVar) {
        this.au = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void w(boolean z3) {
        ev evVar = this.yu;
        if (evVar != null) {
            evVar.c(z3);
        }
        this.up.c(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f32318p;
        if (rVar != null) {
            rVar.p();
        }
        if (map != null && u.ux(this.f32324w)) {
            map.put("duration", Long.valueOf(ba()));
        }
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message w(int i4) {
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.arg1 = i4;
        return obtain;
    }
}
