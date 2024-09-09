package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.bk.ev;
import com.bytedance.sdk.openadsdk.core.eq.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.wx;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls extends com.bytedance.sdk.component.adexpress.ux.c implements a, bk {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.a.sr f34103a;
    private final Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> bk;
    private String ev;
    private int fp;
    private r fz;
    private me gd;

    /* renamed from: i  reason: collision with root package name */
    private long f34104i;
    private com.bytedance.sdk.openadsdk.core.eq.c ia;

    /* renamed from: k  reason: collision with root package name */
    private String f34105k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ux.c f34106p;

    /* renamed from: r  reason: collision with root package name */
    private Context f34107r;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.bk.ev f34108s;

    /* renamed from: t  reason: collision with root package name */
    private xk f34109t;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.w.gd f34110u;
    private me.c ys;

    public ls(Context context, com.bytedance.sdk.component.adexpress.w.bk bkVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.ux.c cVar, me meVar, com.bytedance.sdk.component.adexpress.w.gd gdVar) {
        super(context, bkVar, themeStatusBroadcastReceiver);
        this.bk = Collections.synchronizedMap(new HashMap());
        this.fp = 8;
        this.f34104i = -1L;
        this.f34107r = context;
        this.ev = bkVar.sr();
        this.gd = meVar;
        this.f34106p = cVar;
        this.f29398c = bkVar.xv();
        String c4 = c(meVar);
        this.f34105k = c4;
        this.f34110u = gdVar;
        c(com.bytedance.sdk.openadsdk.core.eq.me.w(c4));
        themeStatusBroadcastReceiver.c(this);
        a();
        k();
        bk();
        t();
    }

    private boolean fp() {
        return !TextUtils.isEmpty(this.ev) && this.ev.equals("splash_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ia() {
        return wx.c(this.xv, 50, wv.ev(this.gd));
    }

    private void s() {
        ViewGroup viewGroup;
        if (this.f34109t == null || (viewGroup = (ViewGroup) this.xv.getParent()) == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(viewGroup);
        this.f34109t.c(new SSWebView.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ls.3
            @Override // com.bytedance.sdk.component.widget.SSWebView.w
            public void c(final int i4) {
                boolean ia = ls.this.ia();
                com.bytedance.sdk.component.utils.a.sr("xsha", "wv:" + ia);
                if (ia) {
                    if (!com.bytedance.sdk.openadsdk.core.ls.w().f()) {
                        if (ls.this.f34109t != null) {
                            ls.this.f34109t.c(i4);
                            return;
                        }
                        return;
                    }
                    WeakReference weakReference2 = weakReference;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        return;
                    }
                    eq.c(weakReference, new com.bytedance.sdk.openadsdk.core.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ls.3.1
                        @Override // com.bytedance.sdk.openadsdk.core.w.xv
                        public void c() {
                            if (ls.this.f34109t != null) {
                                ls.this.f34109t.c(i4);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.bk
    public xk R_() {
        return this.f34109t;
    }

    public void a() {
        if ("feed_video_middle_page".equals(this.ev)) {
            me meVar = this.gd;
            if (meVar == null || meVar.qy() == null) {
                return;
            }
            this.ux = com.bytedance.sdk.component.adexpress.c.w.w.w(this.gd.qy().w());
            this.ys = this.gd.qy();
            return;
        }
        me meVar2 = this.gd;
        if (meVar2 == null || meVar2.rh() == null) {
            return;
        }
        this.ux = com.bytedance.sdk.component.adexpress.c.w.w.c(this.gd.rh().w());
        this.ys = this.gd.rh();
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.c
    public void b_(int i4) {
        if (this.f34109t == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f34109t.c("themeChange", jSONObject);
    }

    public void bk() {
        SSWebView sSWebView = this.xv;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        this.xv.setBackgroundColor(0);
        this.xv.setBackgroundResource(17170445);
        c(this.xv);
        if (c() != null) {
            this.f34103a = new com.bytedance.sdk.openadsdk.core.a.sr(this.gd, c().getWebView()).w(false);
        }
        this.f34103a.c(this.f34106p);
        this.xv.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.c.xv(this.f34109t, this.f34103a));
        this.xv.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ls.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
                if (ls.this.bk.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = (com.bytedance.sdk.openadsdk.core.p.w.xv) ls.this.bk.get(str);
                    if (xvVar != null) {
                        xvVar.c(me.ux(ls.this.gd));
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(ls.this.f34107r, str, ls.this.gd, ls.this.ev);
                ls.this.bk.put(str, c4);
                c4.c(me.ux(ls.this.gd));
            }
        });
        if ("rewarded_video".equals(this.ev) || "fullscreen_interstitial_ad".equals(this.ev)) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c(this.xv.getWebView());
        }
        com.bytedance.sdk.component.adexpress.ux.ux.c().c(this.xv, this.f34109t);
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c, com.bytedance.sdk.openadsdk.core.nativeexpress.a
    public void ev() {
        super.ev();
        if (this.f34109t == null) {
            return;
        }
        s();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.f34109t.c("expressShow", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c
    protected void gd() {
        com.bytedance.sdk.openadsdk.core.eq.c xv = com.bytedance.sdk.openadsdk.core.k.sr().xv();
        this.ia = xv;
        xv.c(this);
    }

    public void k() {
        SSWebView sSWebView = this.xv;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        xk xkVar = new xk(this.f34107r);
        this.f34109t = xkVar;
        xkVar.w(this.xv).c(this.gd).w(this.gd.jr()).xv(this.gd.cf()).c(this.ev).xv(wv.c(this.ev)).sr(wv.t(this.gd)).c(this).f(this.f29398c).c(this.xv).c(this.f34106p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public void p() {
        super.p();
        com.bytedance.sdk.openadsdk.core.eq.c cVar = this.ia;
        if (cVar != null) {
            cVar.w(this);
        }
    }

    public void t() {
        WebView webView;
        SSWebView sSWebView = this.xv;
        if (sSWebView == null || this.f34108s != null || (webView = sSWebView.getWebView()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.xv xvVar = new com.bytedance.sdk.openadsdk.core.s.xv();
        com.bytedance.sdk.openadsdk.core.s.sr srVar = new com.bytedance.sdk.openadsdk.core.s.sr();
        com.bytedance.sdk.openadsdk.core.s.ux uxVar = new com.bytedance.sdk.openadsdk.core.s.ux(this.f34109t);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.gd.jr());
            jSONObject.put("log_extra", this.gd.cf());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        this.f34108s = xvVar.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), webView, uxVar, srVar, hashSet, "embeded_ad".equals(this.ev) ? ev.c.FEED : ev.c.OTHER).f(this.f34105k).ux(com.bytedance.sdk.openadsdk.core.r.c.r()).c(com.bytedance.sdk.openadsdk.core.r.c.c()).ux(jSONObject).c("sdkEdition", com.bytedance.sdk.openadsdk.core.r.c.xv()).w(com.bytedance.sdk.openadsdk.core.r.c.ux()).sr(com.bytedance.sdk.openadsdk.core.r.c.sr()).c(com.bytedance.sdk.openadsdk.core.u.wx.bk(this.gd)).w(com.bytedance.sdk.openadsdk.core.u.wx.t(this.gd)).sr(false);
        r rVar = new r(this.f34107r, this.f34109t, this.gd, this.f34103a, fp(), this.f34108s);
        this.fz = rVar;
        this.xv.setWebViewClient(rVar);
        com.bytedance.sdk.component.adexpress.w.gd gdVar = this.f34110u;
        if (gdVar instanceof gd) {
            ((gd) gdVar).c(this.f34108s);
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.u.wx.w(this.gd))) {
            this.f34108s.xv(com.bytedance.sdk.openadsdk.core.u.wx.w(this.gd));
        }
        Set<String> p3 = this.f34108s.p();
        if (this.f34109t == null || p3 == null || p3.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.f34108s);
        for (String str : p3) {
            this.f34109t.xv().c(str, (com.bytedance.sdk.component.c.ux<?, ?>) new com.bytedance.sdk.component.c.ux<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ls.2
                @Override // com.bytedance.sdk.component.c.ux
                public JSONObject c(JSONObject jSONObject2, com.bytedance.sdk.component.c.f fVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.bk.ev evVar = (com.bytedance.sdk.openadsdk.bk.ev) weakReference.get();
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

    public r ys() {
        return this.fz;
    }

    public static String c(me meVar) {
        me.c rh;
        return com.bytedance.sdk.component.adexpress.c.w.w.xv((meVar == null || (rh = meVar.rh()) == null) ? null : rh.k());
    }

    private void xv(int i4) {
        com.bytedance.sdk.openadsdk.bk.ev evVar = this.f34108s;
        if (evVar == null) {
            return;
        }
        if (i4 == 0) {
            evVar.xv(true);
            this.f34108s.c(false);
            return;
        }
        evVar.xv(false);
        this.f34108s.c(true);
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public void f() {
        xk xkVar = this.f34109t;
        if (xkVar == null) {
            return;
        }
        xkVar.c("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public void sr() {
        if (this.f29399f.get()) {
            return;
        }
        SSWebView sSWebView = this.xv;
        if (sSWebView != null) {
            sSWebView.a();
            this.xv.setOnShakeListener(null);
        }
        xk xkVar = this.f34109t;
        if (xkVar != null) {
            xkVar.w();
        }
        super.sr();
        this.bk.clear();
        this.f34109t = null;
        com.bytedance.sdk.openadsdk.bk.ev evVar = this.f34108s;
        if (evVar == null) {
            return;
        }
        evVar.wx();
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.f34103a;
        if (srVar != null) {
            srVar.ux();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public void ux() {
        if (c() != null && c().getWebView() != null) {
            try {
                c().getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c, com.bytedance.sdk.openadsdk.core.nativeexpress.a
    public void w(int i4) {
        xv(i4);
        sr(i4);
        if (i4 == this.fp) {
            return;
        }
        this.fp = i4;
        w(i4 == 0);
    }

    public static void c(Map<String, Object> map, me meVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            com.bytedance.sdk.component.utils.a.w("engine", "show engine_type " + renderEngineCacheType);
            if (meVar != null && meVar.rh() != null && !TextUtils.isEmpty(meVar.rh().k())) {
                map.put("engine_version", meVar.rh().k());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.w("WebViewRender", "exception:" + e4.getMessage());
        }
    }

    private void w(boolean z3) {
        if (this.f34109t == null || this.xv == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z3);
            this.f34109t.c("expressAdShow", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.c.w.c(this.f34107r).c(false).c(sSWebView.getWebView());
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.c(true);
            sSWebView.r();
            sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.core.eq.fz.c(sSWebView.getWebView(), com.bytedance.sdk.openadsdk.core.eq.f33190w, me.f(this.gd)));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("WebViewRender", e4.toString());
        }
    }

    private void sr(int i4) {
        try {
            if (com.bytedance.sdk.openadsdk.core.eq.c() && i4 == 0) {
                long mu = com.bytedance.sdk.openadsdk.core.ls.w().mu();
                if (this.f34104i != -1 && System.currentTimeMillis() - this.f34104i > mu) {
                    SSWebView c4 = c();
                    WebView webView = c4.getWebView();
                    c4.removeView(webView);
                    c4.addView(webView);
                }
                this.f34104i = -1L;
                return;
            }
            this.f34104i = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public SSWebView c() {
        return this.xv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.ux.c
    public void c(boolean z3, int i4) {
        super.c(z3, i4);
        com.bytedance.sdk.openadsdk.ux.c cVar = this.f34106p;
        if (cVar != null) {
            cVar.c(z3, i4);
            this.f34106p.w(false);
        }
    }
}
