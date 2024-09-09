package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.u.u;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView;
import com.bytedance.sdk.openadsdk.core.w.sr;
import com.bytedance.sdk.openadsdk.core.widget.ev;
import com.bytedance.sdk.openadsdk.core.ys.c;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xk implements com.bytedance.sdk.component.adexpress.ux.w, n.c, com.bytedance.sdk.openadsdk.core.ys.w {
    private static volatile boolean xu;
    private static final Map<String, Boolean> xv;

    /* renamed from: a  reason: collision with root package name */
    private String f35557a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f35558b;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.w> ba;
    private ev.c bj;
    private com.bytedance.sdk.openadsdk.core.ugeno.w bm;
    private com.bytedance.sdk.openadsdk.core.widget.c.c bw;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, Object> f35559c;
    private JSONObject ck;
    private List<com.bytedance.sdk.openadsdk.core.u.me> eq;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Context> f35560f;
    private SoftReference<com.bytedance.sdk.component.adexpress.w.k> fz;
    private WeakReference<com.bytedance.sdk.openadsdk.gd.c> gb;
    private WeakReference<View> gd;
    private boolean gw;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35561h;

    /* renamed from: i  reason: collision with root package name */
    private JSONObject f35562i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.c> f35563j;

    /* renamed from: k  reason: collision with root package name */
    private int f35564k;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.ux> ls;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35565m;
    private HashMap<String, a> me;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.sr> f35566n;
    private boolean ng;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.f> ok;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.r.w> ox;

    /* renamed from: p  reason: collision with root package name */
    private String f35567p;
    private String pr;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ys.sr> f35568q;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ys.xv f35569r;
    private WeakReference<SSWebView> sr;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f35571t;

    /* renamed from: u  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> f35572u;
    private boolean vc;
    private List<JSONObject> wo;
    private com.bytedance.sdk.component.c.s wx;

    /* renamed from: y  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ia.gd> f35575y;
    private com.bytedance.sdk.openadsdk.ux.c yu;

    /* renamed from: z  reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.ux> f35576z;

    /* renamed from: w  reason: collision with root package name */
    boolean f35573w = false;
    private boolean bk = false;
    private boolean ys = false;
    private boolean fp = true;
    private boolean ia = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f35570s = true;
    private boolean wv = false;
    private boolean xk = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f35574x = false;
    private boolean up = false;
    private boolean mt = false;
    private boolean oo = false;
    private boolean au = false;
    private com.bytedance.sdk.component.utils.n ux = new com.bytedance.sdk.component.utils.n(Looper.getMainLooper(), this);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public String f35598c;
        public JSONObject sr;
        public int ux;

        /* renamed from: w  reason: collision with root package name */
        public String f35599w;
        public String xv;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        xv = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
        xu = false;
    }

    public xk(Context context) {
        this.f35560f = new WeakReference<>(context);
    }

    private List<String> bw() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fz(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private JSONObject gw() {
        return w(this.f35571t);
    }

    private void ia(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.ia.w> weakReference = this.ba;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.ba.get().c(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    private void m() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ia.gd> weakReference = this.f35575y;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35575y.get().w();
    }

    private boolean mt() {
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        if (meVar == null || meVar.ya() == null || com.bytedance.sdk.openadsdk.core.eq.u.xv(this.f35571t) || this.wv || this.f35571t.ya().optInt("parent_type") != 2) {
            return false;
        }
        int ev = com.bytedance.sdk.openadsdk.core.eq.wv.ev(this.f35571t);
        if (ev == 8 || ev == 7) {
            this.wv = true;
            return true;
        }
        return false;
    }

    private void oo() {
        if (this.f35569r == null) {
            this.f35569r = com.bytedance.sdk.openadsdk.core.ys.c.c(this, this.f35571t, this.up);
        }
    }

    private JSONObject pr() {
        try {
            View view = this.gd.get();
            SSWebView sSWebView = this.sr.get();
            if (view != null && sSWebView != null) {
                int[] w3 = com.bytedance.sdk.openadsdk.core.eq.xk.w(view);
                int[] w4 = com.bytedance.sdk.openadsdk.core.eq.xk.w(sSWebView);
                if (w3 != null && w4 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", com.bytedance.sdk.openadsdk.core.eq.xk.sr(ls.getContext(), w3[0] - w4[0]));
                    jSONObject.put("y", com.bytedance.sdk.openadsdk.core.eq.xk.sr(ls.getContext(), w3[1] - w4[1]));
                    jSONObject.put("w", com.bytedance.sdk.openadsdk.core.eq.xk.sr(ls.getContext(), view.getWidth()));
                    jSONObject.put("h", com.bytedance.sdk.openadsdk.core.eq.xk.sr(ls.getContext(), view.getHeight()));
                    jSONObject.put("isExist", true);
                    return jSONObject;
                }
                com.bytedance.sdk.component.utils.a.f("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                return null;
            }
            com.bytedance.sdk.component.utils.a.f("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.c("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    private void u(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.ys.sr> weakReference;
        com.bytedance.sdk.openadsdk.core.ys.sr srVar;
        if (jSONObject == null || (weakReference = this.f35568q) == null || (srVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                srVar.c(true, optJSONArray);
            } else {
                srVar.c(false, null);
            }
        } catch (Exception unused) {
            srVar.c(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        Context context;
        List<com.bytedance.sdk.openadsdk.core.u.me> list = this.eq;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.me = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.sr;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f35560f;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.u.me meVar : this.eq) {
            this.me.put(meVar.jr(), new a(context, meVar, sSWebView, this.pr));
        }
    }

    private void vc() {
        ok si;
        Context context;
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        if (meVar != null && (si = meVar.si()) != null && si.w() == 1 && si.f() == 1) {
            oo();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.f35560f;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.f35569r.c(context, jSONObject, this.f35567p, this.f35564k, this.ys, true);
            c(jSONObject, false);
        }
    }

    private WebView wx() {
        WeakReference<SSWebView> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.sr.get().getWebView();
    }

    private void x() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ia.gd> weakReference = this.f35575y;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35575y.get().c();
    }

    private void yu() {
        com.bytedance.sdk.openadsdk.core.u.me meVar;
        WeakReference<SSWebView> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null || (meVar = this.f35571t) == null) {
            return;
        }
        int mc = meVar.mc();
        int co = this.f35571t.co();
        int za = this.f35571t.za();
        int g4 = this.f35571t.g();
        int bs = this.f35571t.bs();
        JSONObject jk = this.f35571t.jk();
        this.sr.get().setShakeValue(mc);
        this.sr.get().setDeepShakeValue(co);
        this.sr.get().setWriggleValue(za);
        this.sr.get().setTwistConfig(jk);
        this.sr.get().setCalculationMethod(g4);
        this.sr.get().setCalculationTwistMethod(bs);
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = this.f35562i;
            if (jSONObject != null && this.f35571t != null) {
                jSONObject.put("setting", gw());
                this.f35562i.put("extension", this.f35571t.l());
            }
        } catch (Exception unused) {
        }
        return this.f35562i;
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void adAnalysisData(String str) {
        try {
            k(new JSONObject(str).getBoolean("openPlayableLandingPage"));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            xv(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public void ba() {
        com.bytedance.sdk.openadsdk.core.ys.xv xvVar = this.f35569r;
        if (xvVar != null) {
            xvVar.w();
        }
    }

    public void bk() {
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.f35571t, "stats_reward_full_deal_skip_video");
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().X_();
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xk.this.ev(new JSONObject(str));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public String ck() {
        return com.bytedance.sdk.openadsdk.core.eq.wv.c(this.f35564k);
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xk.this.k(new JSONObject(str));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            bk(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public void eq() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ia.ux> weakReference = this.ls;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ls.get().w();
    }

    public void ev(boolean z3) {
        this.oo = z3;
    }

    public int f(boolean z3) {
        if (com.bytedance.sdk.openadsdk.core.u.n.c(this.f35571t) != 0 && z3) {
            return this.vc ? 3 : 2;
        } else if (this.f35565m) {
            return 1;
        } else {
            if (this.gw) {
                return com.bytedance.sdk.openadsdk.core.u.n.c(this.f35571t) == 2 ? 2 : 1;
            } else if (this.vc) {
                return 3;
            } else {
                return com.bytedance.sdk.openadsdk.core.u.n.c(this.f35571t) == 0 ? 1 : 2;
            }
        }
    }

    public void fp() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().V_();
    }

    public void gb() {
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        if (meVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.w(meVar, this.f35560f.get(), ck());
    }

    public void gd(boolean z3) {
        this.au = z3;
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        s(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public String getTemplateInfo() {
        w("getTemplateInfo", true);
        try {
            a();
            w("getTemplateInfo", false);
            return this.f35562i.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", c(this.eq));
            c("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "initRenderFinish");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.10
            @Override // java.lang.Runnable
            public void run() {
                if (xk.this.bw != null) {
                    xk.this.bw.c();
                }
            }
        });
    }

    boolean j() {
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        return meVar != null && com.bytedance.sdk.openadsdk.core.u.ia.gd(meVar) == 1;
    }

    public JSONObject k() {
        return this.f35558b;
    }

    public void ls() {
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        if (meVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(meVar, this.f35560f.get(), ck());
    }

    public int me() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.f35572u.get().T_();
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xk.this.r(new JSONObject(str));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        if (meVar == null) {
            return jSONObject;
        }
        String o4 = meVar.o();
        if (TextUtils.isEmpty(o4)) {
            return jSONObject;
        }
        try {
            return new JSONObject(o4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }

    public boolean p() {
        return this.f35573w;
    }

    public boolean q() {
        return this.f35574x;
    }

    public xk r(boolean z3) {
        this.xk = z3;
        return this;
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "requestPauseVideo: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "requestPauseVideo: pauseInfo = " + jSONObject.toString());
            int optInt = jSONObject.optInt("time");
            String optString = jSONObject.optString("flag");
            WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f35572u.get().c(optInt, optString);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void s() {
        WeakReference<com.bytedance.sdk.openadsdk.gd.c> weakReference = this.gb;
        if (weakReference != null && weakReference.get() != null) {
            this.gb.get().c();
            return;
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference2 = this.f35572u;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        this.f35572u.get().ev();
    }

    @Override // com.bytedance.sdk.component.adexpress.ux.w
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.f35571t, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.9
            @Override // java.lang.Runnable
            public void run() {
                xk.this.bk();
            }
        });
    }

    public void sr(boolean z3) {
        this.gw = z3;
    }

    public void t() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().Y_();
    }

    public void ux(boolean z3) {
        this.vc = z3;
    }

    public boolean wv() {
        return this.ng;
    }

    public void xk() {
        this.ng = true;
        WeakReference<com.bytedance.sdk.openadsdk.core.ia.f> weakReference = this.ok;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ok.get().c();
    }

    public void y() {
        com.bytedance.sdk.openadsdk.core.ys.xv xvVar = this.f35569r;
        if (xvVar != null) {
            xvVar.xv();
        }
    }

    public void ys() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().U_();
    }

    public void z() {
        com.bytedance.sdk.openadsdk.core.ys.xv xvVar = this.f35569r;
        if (xvVar != null) {
            xvVar.c();
        }
        if (mt()) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject) {
        WebView wx = wx();
        if (wx != null) {
            String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
            com.bytedance.sdk.component.utils.k.c(wx, str);
            if (com.bytedance.sdk.component.utils.a.c()) {
                com.bytedance.sdk.component.utils.a.c("TTAndroidObject", "js_msg " + str);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.w.ux ev() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.ux> weakReference = this.f35576z;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public xk gd() {
        this.ia = true;
        return this;
    }

    public void k(JSONObject jSONObject) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        JSONObject jSONObject2;
        double d12;
        SoftReference<com.bytedance.sdk.component.adexpress.w.k> softReference;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "TTAndroidObject handleClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            String optString3 = jSONObject.optString("clickAreaId");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            String optString4 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.u.ys.c(jSONObject.optString("clickScene"));
            jSONObject3.put("openPlayableLandingPage", jSONObject.optBoolean("openPlayableLandingPage"));
            jSONObject3.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject3.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject3.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d13 = -1.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", -1.0d);
                double optDouble2 = optJSONObject.optDouble("down_y", -1.0d);
                double optDouble3 = optJSONObject.optDouble("up_x", -1.0d);
                double optDouble4 = optJSONObject.optDouble("up_y", -1.0d);
                double optDouble5 = optJSONObject.optDouble("down_time", -1.0d);
                double optDouble6 = optJSONObject.optDouble("up_time", -1.0d);
                double optDouble7 = optJSONObject.optDouble("button_x", -1.0d);
                double optDouble8 = optJSONObject.optDouble("button_y", -1.0d);
                double optDouble9 = optJSONObject.optDouble("button_width", -1.0d);
                d11 = optJSONObject.optDouble("button_height", -1.0d);
                d13 = optDouble;
                jSONObject2 = jSONObject3;
                d4 = optDouble2;
                d12 = optDouble3;
                d5 = optDouble4;
                d6 = optDouble5;
                d7 = optDouble6;
                d8 = optDouble7;
                d9 = optDouble8;
                d10 = optDouble9;
            } else {
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
                d9 = -1.0d;
                d10 = -1.0d;
                d11 = -1.0d;
                jSONObject2 = jSONObject3;
                d12 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.u.u c4 = new u.c().sr((float) d13).xv((float) d4).w((float) d12).c((float) d5).w((long) d6).c((long) d7).c((int) d8).w((int) d9).xv((int) d10).sr((int) d11).c(optString2).w(optString3).c(true).c((SparseArray<sr.c>) null).c(jSONObject2).ux(optString4).ux(optInt2).c();
            if (!c(optString, optInt, c4) && (softReference = this.fz) != null && softReference.get() != null) {
                this.fz.get().c(null, optInt, c4);
            } else {
                vc();
            }
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.w.k> softReference2 = this.fz;
            if (softReference2 != null && softReference2.get() != null) {
                this.fz.get().c(null, -1, null);
            } else {
                vc();
            }
        }
    }

    public void p(boolean z3) {
        this.f35573w = z3;
    }

    public boolean r() {
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
        return meVar != null && meVar.me();
    }

    public boolean sr() {
        return this.oo;
    }

    public void ux() {
        WeakReference<Context> weakReference = this.f35560f;
        if (weakReference == null || weakReference.get() == null || !(this.f35560f.get() instanceof TTMiddlePageActivity)) {
            return;
        }
        ((Activity) this.f35560f.get()).finish();
    }

    public void xv(boolean z3) {
        this.f35565m = z3;
    }

    private JSONObject j(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo;
        if (this.f35559c != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                if (eq.sr()) {
                    try {
                        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f35571t;
                        if (meVar != null && (oo = meVar.oo()) != null) {
                            String ys = oo.ys();
                            if (!TextUtils.isEmpty(ys)) {
                                jSONObject2.putOpt("media_extra", ys);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.f35559c.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e4) {
                com.bytedance.sdk.component.utils.a.xv(e4.toString());
            }
        }
        return jSONObject;
    }

    public static void w(boolean z3) {
        xu = z3;
    }

    public void fp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ev = jSONObject.optString(BidResponsedEx.KEY_CID);
        this.f35567p = jSONObject.optString("log_extra");
    }

    public int gd(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.f35571t.c(true);
            return 2;
        } else if (jSONObject.optInt("downloadDialogStatus") == 1) {
            if (this.f35571t.iw().c() == 2) {
                this.f35571t.c(true);
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void p(JSONObject jSONObject) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        String str;
        String str2;
        double d11;
        double d12;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "TTAndroidObject handleNewClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            String optString3 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d13 = -1.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", -1.0d);
                double optDouble2 = optJSONObject.optDouble("down_y", -1.0d);
                double optDouble3 = optJSONObject.optDouble("up_x", -1.0d);
                double optDouble4 = optJSONObject.optDouble("up_y", -1.0d);
                double optDouble5 = optJSONObject.optDouble("down_time", -1.0d);
                double optDouble6 = optJSONObject.optDouble("up_time", -1.0d);
                double optDouble7 = optJSONObject.optDouble("button_x", -1.0d);
                double optDouble8 = optJSONObject.optDouble("button_y", -1.0d);
                double optDouble9 = optJSONObject.optDouble("button_width", -1.0d);
                d10 = optJSONObject.optDouble("button_height", -1.0d);
                str = optString;
                d13 = optDouble;
                d4 = optDouble2;
                d11 = optDouble3;
                d5 = optDouble5;
                d6 = optDouble6;
                d7 = optDouble7;
                d8 = optDouble8;
                d9 = optDouble9;
                str2 = optString2;
                d12 = optDouble4;
            } else {
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
                d9 = -1.0d;
                d10 = -1.0d;
                str = optString;
                str2 = optString2;
                d11 = -1.0d;
                d12 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.u.u c4 = new u.c().sr((int) d13).xv((int) d4).w((int) d11).c((int) d12).w((long) d5).c((long) d6).c((int) d7).w((int) d8).xv((int) d9).sr((int) d10).c(optString3).c(true).c(jSONObject2).c((SparseArray<sr.c>) null).ux(str2).ux(optInt2).c();
            SoftReference<com.bytedance.sdk.component.adexpress.w.k> softReference = this.fz;
            if (softReference != null && softReference.get() != null) {
                this.fz.get().c(null, optInt, c4, gd(jSONObject));
            }
            c(str, optInt, c4);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.w.k> softReference2 = this.fz;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.fz.get().c(null, -1, null, 0);
        }
    }

    public void r(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference != null && weakReference.get() != null && jSONObject != null) {
            try {
                this.f35572u.get().a_(jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false));
            } catch (Exception unused) {
            }
        }
    }

    public xk sr(String str) {
        this.f35557a = str;
        return this;
    }

    public boolean t(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", c(this.eq));
        } catch (Exception unused) {
        }
        return true;
    }

    public com.bytedance.sdk.component.c.s xv() {
        return this.wx;
    }

    public void ys(JSONObject jSONObject) {
        try {
            jSONObject.put("isPrePlayable", this.mt);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void bk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "TTAndroidObject handlerDynamicTrack");
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.eq.fz.c(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    public void ev(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference != null && weakReference.get() != null && jSONObject != null) {
            try {
                this.f35572u.get().c(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    public void sr(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.u.wx.w(this.f35571t))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.u.wx.w(this.f35571t));
    }

    public void w() {
        com.bytedance.sdk.component.c.s sVar = this.wx;
        if (sVar == null) {
            return;
        }
        sVar.c();
        this.wx = null;
    }

    public xk xv(String str) {
        this.f35567p = str;
        return this;
    }

    private void i(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            q(jSONObject);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.3
                @Override // java.lang.Runnable
                public void run() {
                    xk.this.q(jSONObject);
                }
            });
        }
    }

    private boolean s(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference != null && weakReference.get() != null && jSONObject != null) {
            double xv2 = this.f35572u.get().xv();
            int S_ = this.f35572u.get().S_();
            Double.isNaN(xv2);
            try {
                jSONObject.put("currentTime", xv2 / 1000.0d);
                jSONObject.put("state", S_);
                com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "hlt currentTime,state:" + xv2 + "," + S_);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void fp(boolean z3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z3 ? 0 : 1);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("TTAndroidObject", e4.getMessage());
        }
        sr("visibleStateChange", jSONObject);
    }

    public boolean fz() {
        return this.bk;
    }

    public void t(boolean z3) {
        this.f35570s = z3;
        if (z3) {
            return;
        }
        this.f35571t.c(true);
    }

    public void ux(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.ux.c cVar;
        if (jSONObject == null || (cVar = this.yu) == null) {
            return;
        }
        cVar.w(jSONObject);
    }

    public xk xv(int i4) {
        this.f35564k = i4;
        return this;
    }

    public void ys(boolean z3) {
        this.fp = z3;
        if (z3) {
            return;
        }
        this.f35571t.c(true);
    }

    public static JSONArray c(List<com.bytedance.sdk.openadsdk.core.u.me> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            jSONArray.put(list.get(i4).mo());
        }
        return jSONArray;
    }

    private String r(String str) {
        return (this.fz != null || this.f35561h) ? str : com.bytedance.sdk.openadsdk.core.eq.wv.c(this.f35564k);
    }

    public void a(final JSONObject jSONObject) {
        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.xk.11
            @Override // java.lang.Runnable
            public void run() {
                double d4;
                boolean z3;
                double d5;
                if (xk.this.fz == null || xk.this.fz.get() == null || jSONObject == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.w.t tVar = new com.bytedance.sdk.component.adexpress.w.t();
                tVar.c(1);
                try {
                    boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
                    double d6 = 0.0d;
                    if (optJSONObject != null) {
                        d6 = optJSONObject.optDouble("width");
                        d4 = optJSONObject.optDouble("height");
                    } else {
                        d4 = 0.0d;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (optJSONObject2 != null) {
                        double optDouble = optJSONObject2.optDouble("x");
                        double optDouble2 = optJSONObject2.optDouble("y");
                        z3 = optBoolean;
                        double optDouble3 = optJSONObject2.optDouble("width");
                        double optDouble4 = optJSONObject2.optDouble("height");
                        if (xk.this.fz(optJSONObject2)) {
                            d5 = d4;
                            tVar.c((float) optJSONObject2.optDouble("borderRadiusTopLeft"));
                            tVar.w((float) optJSONObject2.optDouble("borderRadiusTopRight"));
                            tVar.xv((float) optJSONObject2.optDouble("borderRadiusBottomLeft"));
                            tVar.sr((float) optJSONObject2.optDouble("borderRadiusBottomRight"));
                        } else {
                            d5 = d4;
                        }
                        tVar.xv(optDouble);
                        tVar.sr(optDouble2);
                        tVar.ux(optDouble3);
                        tVar.f(optDouble4);
                    } else {
                        z3 = optBoolean;
                        d5 = d4;
                    }
                    String optString = jSONObject.optString("message", p.c(101));
                    int optInt = jSONObject.optInt("code", 101);
                    tVar.c(z3);
                    tVar.c(d6);
                    tVar.w(d5);
                    tVar.c(optString);
                    tVar.w(optInt);
                    ((com.bytedance.sdk.component.adexpress.w.k) xk.this.fz.get()).c(tVar);
                } catch (Exception unused) {
                    tVar.w(101);
                    tVar.c(p.c(101));
                    ((com.bytedance.sdk.component.adexpress.w.k) xk.this.fz.get()).c(tVar);
                }
            }
        });
    }

    public void sr(int i4) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().w(i4);
    }

    public xk xv(List<com.bytedance.sdk.openadsdk.core.u.me> list) {
        this.eq = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView wx = wx();
                    if (wx != null) {
                        com.bytedance.sdk.component.utils.k.c(wx, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int indexOf = str.indexOf(38, 30);
                    if (indexOf <= 0) {
                        return;
                    }
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        ux(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void ux(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.component.utils.a.w("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                c cVar = new c();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        cVar.f35598c = optJSONObject.optString("__msg_type", null);
                        cVar.f35599w = optJSONObject.optString("__callback_id", null);
                        cVar.xv = optJSONObject.optString("func");
                        cVar.sr = optJSONObject.optJSONObject(EventMonitor.V3_PARAMS);
                        cVar.ux = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(cVar.f35598c) && !TextUtils.isEmpty(cVar.xv)) {
                    Message obtainMessage = this.ux.obtainMessage(11);
                    obtainMessage.obj = cVar;
                    this.ux.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.a.c()) {
                com.bytedance.sdk.component.utils.a.sr("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.component.utils.a.sr("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    public void a(boolean z3) {
        this.mt = z3;
    }

    public xk w(SSWebView sSWebView) {
        this.sr = new WeakReference<>(sSWebView);
        return this;
    }

    public void xv(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.ev)) {
            jSONObject.put(BidResponsedEx.KEY_CID, this.ev);
        }
        if (!TextUtils.isEmpty(this.f35567p)) {
            jSONObject.put("log_extra", this.f35567p);
        }
        if (!TextUtils.isEmpty(this.f35557a)) {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, this.f35557a);
        }
        if (com.bytedance.sdk.openadsdk.core.u.fp.k(this.f35571t)) {
            jSONObject.put("voice_btn_position", com.bytedance.sdk.openadsdk.core.u.fp.t(this.f35571t));
        }
    }

    private void sr(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            i(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.openadsdk.core.u.me f() {
        return this.f35571t;
    }

    public void ia() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().W_();
    }

    public void u() {
        c((JSONObject) null, new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.xk.13
            @Override // com.bytedance.sdk.openadsdk.core.ia.xv
            public void c(boolean z3, List<com.bytedance.sdk.openadsdk.core.u.me> list, boolean z4) {
                xk.this.eq = list;
                xk.this.up();
                xk.this.i();
            }
        });
    }

    public xk w(String str) {
        this.ev = str;
        return this;
    }

    public xk f(JSONObject jSONObject) {
        this.f35562i = jSONObject;
        return this;
    }

    public xk w(List<JSONObject> list) {
        this.wo = list;
        return this;
    }

    private boolean f(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || j();
    }

    public void bk(boolean z3) {
        this.f35574x = z3;
    }

    public xk c(String str) {
        this.pr = str;
        return this;
    }

    public xk ia(boolean z3) {
        this.f35561h = z3;
        return this;
    }

    public xk w(int i4) {
        this.ys = true;
        return this;
    }

    public xk c(boolean z3) {
        this.up = z3;
        return this;
    }

    public void w(JSONObject jSONObject) {
        this.f35558b = jSONObject;
    }

    private void w(String str, boolean z3) {
        if (this.yu == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z3) {
            this.yu.f(str);
        } else {
            this.yu.r(str);
        }
    }

    public xk c(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.a.f("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        com.bytedance.sdk.component.c.s w3 = com.bytedance.sdk.component.c.s.c(sSWebView.getWebView()).c(new com.bytedance.sdk.openadsdk.ev.c()).c("ToutiaoJSBridge").c(new com.bytedance.sdk.component.c.a() { // from class: com.bytedance.sdk.openadsdk.core.xk.1
            @Override // com.bytedance.sdk.component.c.a
            public <T> T c(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.c.a
            public <T> String c(T t3) {
                return null;
            }
        }).c(k.sr().z()).w(true).c().w();
        this.wx = w3;
        com.bytedance.sdk.openadsdk.core.fp.c.fp.c(w3, this);
        com.bytedance.sdk.openadsdk.core.fp.c.xv.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.ux.c(this.wx, this, this.f35571t);
        com.bytedance.sdk.openadsdk.core.fp.c.j.c(this.wx, this.f35571t);
        com.bytedance.sdk.openadsdk.core.fp.c.p.c(this.wx);
        com.bytedance.sdk.openadsdk.core.fp.c.fz.c(this.wx, sSWebView);
        com.bytedance.sdk.openadsdk.core.fp.c.f.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.gd.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.z.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.sr.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.ux.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.w.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.t.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.ys.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.bk.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.sr.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.c.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.f.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.r.c(this.wx, this);
        com.bytedance.sdk.openadsdk.ev.c.xv.c(this.wx, this);
        yu();
        com.bytedance.sdk.openadsdk.core.fp.c.w.c(this.wx, this.sr.get(), this.ev);
        com.bytedance.sdk.openadsdk.core.fp.c.i.c(this.wx, this.sr.get(), this.ev);
        com.bytedance.sdk.openadsdk.core.fp.c.c.c(this.wx, this.sr.get(), this.ev);
        com.bytedance.sdk.openadsdk.core.fp.c.u.c(this.wx, this.sr.get(), this.ev);
        com.bytedance.sdk.openadsdk.core.fp.c.n.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.ck.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.eq.c(this.wx, this, this.f35571t);
        com.bytedance.sdk.openadsdk.core.fp.c.a.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.r.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.k.c(this.wx, this.f35560f.get(), this.f35571t);
        com.bytedance.sdk.openadsdk.core.fp.c.ia.c(this.wx, this.f35560f.get(), this.f35571t);
        com.bytedance.sdk.openadsdk.core.fp.c.ev.c(this.wx, this.f35571t, this.wo);
        com.bytedance.sdk.openadsdk.core.fp.c.s.c(this.wx, this, this.ox);
        com.bytedance.sdk.openadsdk.core.fp.c.gb.c(this.wx, this, this.ox);
        com.bytedance.sdk.openadsdk.core.fp.c.me.c(this.wx, sSWebView, this.ox, this);
        com.bytedance.sdk.openadsdk.core.fp.c.y.c(this.wx, this.bj);
        com.bytedance.sdk.openadsdk.core.fp.c.ba.c(this.wx, this);
        com.bytedance.sdk.openadsdk.core.fp.c.q.c(this.wx, this.bm);
        com.bytedance.sdk.openadsdk.core.fp.c.ls.c(this.wx, this, this.f35571t);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:4:0x000b, B:8:0x002c, B:13:0x0040, B:15:0x0051, B:17:0x0069, B:21:0x0072, B:23:0x0079, B:24:0x007d, B:14:0x0049, B:7:0x0024), top: B:27:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject w(com.bytedance.sdk.openadsdk.core.u.me r8) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.z.r r1 = com.bytedance.sdk.openadsdk.core.ls.w()
            if (r1 == 0) goto L80
            int r1 = com.bytedance.sdk.openadsdk.core.eq.wv.gd(r8)     // Catch: java.lang.Exception -> L80
            int r2 = com.bytedance.sdk.openadsdk.core.eq.wv.ev(r8)     // Catch: java.lang.Exception -> L80
            com.bytedance.sdk.openadsdk.core.z.r r3 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Exception -> L80
            int r3 = r3.ux(r1)     // Catch: java.lang.Exception -> L80
            boolean r4 = c(r2, r8)     // Catch: java.lang.Exception -> L80
            r5 = 0
            if (r4 == 0) goto L24
            r4 = 0
            goto L2c
        L24:
            com.bytedance.sdk.openadsdk.core.z.r r4 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Exception -> L80
            int r4 = r4.f(r1)     // Catch: java.lang.Exception -> L80
        L2c:
            com.bytedance.sdk.openadsdk.core.z.r r6 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Exception -> L80
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L80
            boolean r6 = r6.f(r7)     // Catch: java.lang.Exception -> L80
            r7 = 7
            if (r2 == r7) goto L49
            r7 = 8
            if (r2 != r7) goto L40
            goto L49
        L40:
            com.bytedance.sdk.openadsdk.core.z.r r2 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Exception -> L80
            boolean r1 = r2.sr(r1)     // Catch: java.lang.Exception -> L80
            goto L51
        L49:
            com.bytedance.sdk.openadsdk.core.z.r r2 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Exception -> L80
            boolean r1 = r2.c(r8, r1)     // Catch: java.lang.Exception -> L80
        L51:
            java.lang.String r2 = "voice_control"
            r0.put(r2, r1)     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "rv_skip_time"
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "fv_skip_show"
            r0.put(r1, r6)     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "iv_skip_time"
            r0.put(r1, r4)     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "show_dislike"
            if (r8 == 0) goto L71
            boolean r2 = r8.bx()     // Catch: java.lang.Exception -> L80
            if (r2 == 0) goto L71
            r2 = 1
            goto L72
        L71:
            r2 = 0
        L72:
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "video_adaptation"
            if (r8 == 0) goto L7d
            int r5 = r8.gw()     // Catch: java.lang.Exception -> L80
        L7d:
            r0.put(r1, r5)     // Catch: java.lang.Exception -> L80
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.xk.w(com.bytedance.sdk.openadsdk.core.u.me):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            i(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void w(final Uri uri) {
        long j4;
        JSONObject jSONObject;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.a.sr("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.bytedance.sdk.component.utils.ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xk.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xk.this.ev(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (f(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.u.ck.w(this.f35571t) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j5 = 0;
                try {
                    j4 = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j4 = 0;
                }
                try {
                    j5 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j6 = j5;
                JSONObject jSONObject2 = new JSONObject();
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject2 = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                if ("click".equals(queryParameter3)) {
                    jSONObject = j(jSONObject2);
                    WeakReference<com.bytedance.sdk.openadsdk.core.ia.ux> weakReference = this.ls;
                    if (weakReference != null && weakReference.get() != null) {
                        this.ls.get().xv();
                    }
                } else {
                    jSONObject = jSONObject2;
                }
                com.bytedance.sdk.openadsdk.core.a.xv.c(queryParameter, r(queryParameter2), queryParameter3, j4, j6, jSONObject);
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.w("TTAndroidObject", "handleUri exception: ", e4);
        }
    }

    public void w(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.c.s sVar = this.wx;
            if (sVar != null) {
                sVar.c(str, (String) jSONObject);
            }
        } catch (Throwable th) {
            Log.e("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void k(boolean z3) {
        this.bk = z3;
    }

    public void c(SSWebView.w wVar) {
        WeakReference<SSWebView> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null || wVar == null) {
            return;
        }
        this.sr.get().setOnShakeListener(wVar);
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ugeno.r.w wVar) {
        this.ox = new WeakReference<>(wVar);
        return this;
    }

    public boolean c() {
        WeakReference<SSWebView> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.sr.get().w();
    }

    public void c(int i4) {
        if (xu) {
            com.bytedance.sdk.component.utils.a.sr("TTAndroidObject", "blocked Twist");
        } else if (i4 != 1) {
            if (i4 == 2) {
                c("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.f35571t != null && c()) {
                com.bytedance.sdk.openadsdk.core.p.xv.xv.f.sr = true;
            }
            c("wobble_callback", (JSONObject) null);
        }
    }

    public xk c(com.bytedance.sdk.openadsdk.ux.c cVar) {
        this.yu = cVar;
        return this;
    }

    public xk c(View view) {
        this.gd = new WeakReference<>(view);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ia.w wVar) {
        this.ba = new WeakReference<>(wVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ia.gd gdVar) {
        this.f35575y = new WeakReference<>(gdVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f35571t = meVar;
        return this;
    }

    public xk c(com.bytedance.sdk.component.adexpress.w.k kVar) {
        this.fz = new SoftReference<>(kVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.nativeexpress.p pVar) {
        this.f35572u = new WeakReference<>(pVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ys.sr srVar) {
        this.f35568q = new WeakReference<>(srVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.w.ux uxVar) {
        this.f35576z = new WeakReference<>(uxVar);
        return this;
    }

    public xk c(JSONObject jSONObject) {
        this.ck = jSONObject;
        return this;
    }

    public xk c(Map<String, Object> map) {
        this.f35559c = map;
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ia.c cVar) {
        this.f35563j = new WeakReference<>(cVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ia.ux uxVar) {
        this.ls = new WeakReference<>(uxVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.gd.c cVar) {
        this.gb = new WeakReference<>(cVar);
        return this;
    }

    public xk c(com.bytedance.sdk.openadsdk.core.ia.sr srVar) {
        this.f35566n = new WeakReference<>(srVar);
        return this;
    }

    public void c(ev.c cVar) {
        this.bj = cVar;
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.w wVar) {
        this.bm = wVar;
    }

    public void c(JSONObject jSONObject, int i4) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : bw()) {
            jSONArray.put(str);
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.core.r.c.c());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.r.c.ux());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.core.r.c.w());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.r.c.xv());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.r.c.sr());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.core.r.c.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.r.c.r());
        jSONObject.put("themeStatus", k.sr().me());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02dd, code lost:
        if (r4 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0324, code lost:
        if (r4 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0326, code lost:
        r3 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject c(com.bytedance.sdk.openadsdk.core.xk.c r20, int r21) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.xk.c(com.bytedance.sdk.openadsdk.core.xk$c, int):org.json.JSONObject");
    }

    public void c(float f4) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference != null && weakReference.get() != null) {
            try {
                this.f35572u.get().c(f4);
            } catch (Exception unused) {
            }
        }
    }

    public void c(float f4, float f5, float f6, float f7, int i4) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.p> weakReference = this.f35572u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35572u.get().c(f4, f5, f6, f7, i4);
    }

    public static boolean c(int i4, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        com.bytedance.sdk.openadsdk.core.u.ls dc;
        if (i4 == 8 && com.bytedance.sdk.openadsdk.core.u.ls.c(meVar) && (dc = meVar.dc()) != null) {
            return dc.sr();
        }
        return false;
    }

    private void c(final c cVar, final JSONObject jSONObject) {
        if (cVar == null) {
            return;
        }
        try {
            c(cVar.sr, new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.xk.12
                @Override // com.bytedance.sdk.openadsdk.core.ia.xv
                public void c(boolean z3, List<com.bytedance.sdk.openadsdk.core.u.me> list, boolean z4) {
                    if (z3) {
                        try {
                            jSONObject.put("creatives", xk.c(list));
                            xk.this.xv(cVar.f35599w, jSONObject);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    xk.this.xv(cVar.f35599w, jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean c(String str, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
        HashMap<String, a> hashMap;
        a aVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.me) == null || (aVar = hashMap.get(str)) == null) {
            return false;
        }
        aVar.c(i4, uVar);
        return true;
    }

    public void c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ia.xv xvVar) {
        com.bytedance.sdk.openadsdk.core.q.w.c(this.f35571t, jSONObject, xvVar, (com.bytedance.sdk.openadsdk.ys.w.xv.w) null);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        com.bytedance.sdk.openadsdk.core.q.w.c(this.f35571t, (JSONObject) null, new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.xk.2
            @Override // com.bytedance.sdk.openadsdk.core.ia.xv
            public void c(boolean z3, List<com.bytedance.sdk.openadsdk.core.u.me> list, boolean z4) {
                xk.this.eq = list;
                xk.this.up();
                xk.this.i();
            }
        }, wVar);
    }

    public boolean c(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return xv.containsKey(uri.getHost());
        }
        return false;
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.me meVar, int i4) {
        WeakReference<Context> weakReference = this.f35560f;
        if (weakReference == null || meVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.f35560f.get();
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(context, meVar, this.pr, this.f35564k);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(true);
        ((com.bytedance.sdk.openadsdk.core.w.c.w.f) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.w.f.class)).c(i4);
        final String jr = meVar.jr();
        com.bytedance.sdk.openadsdk.core.p.w.sr w3 = com.bytedance.sdk.openadsdk.core.p.xv.w(context, meVar, this.pr);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c((com.bytedance.sdk.openadsdk.core.p.w.xv) w3);
        cVar.c(null, new com.bytedance.sdk.openadsdk.core.u.gd());
        if (w3 != null) {
            w3.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.xk.5
                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c() {
                    c.C0525c.c(jr, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void w(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void xv(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 3, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, String str, String str2) {
                    c.C0525c.c(jr, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(String str, String str2) {
                    c.C0525c.c(jr, 6, 100);
                }
            });
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.r.w) {
            ((com.bytedance.sdk.openadsdk.core.r.w) context).c(1);
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof c) {
                try {
                    c((c) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void c(String str, boolean z3) {
        com.bytedance.sdk.openadsdk.core.ys.xv xvVar = this.f35569r;
        if (xvVar != null) {
            xvVar.c(str, z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.w
    public void c(String str, JSONObject jSONObject) {
        sr(str, jSONObject);
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.me meVar, boolean z3) {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.ux> weakReference = this.f35576z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35576z.get().c(meVar, z3);
    }

    public void c(JSONObject jSONObject, boolean z3) {
        WeakReference<Context> weakReference;
        if (this.f35569r == null || (weakReference = this.f35560f) == null || weakReference.get() == null) {
            return;
        }
        this.f35569r.c(this.f35570s && this.fp);
        this.f35569r.w(z3);
        this.f35569r.c(this.f35560f.get(), jSONObject, this.pr, this.f35567p);
    }

    public void c(com.bytedance.sdk.openadsdk.core.ia.f fVar) {
        this.ok = new WeakReference<>(fVar);
    }

    public void c(int i4, int i5) {
        SSWebView sSWebView = this.sr.get();
        if (sSWebView instanceof PlayableFeedWebView) {
            ((PlayableFeedWebView) sSWebView).c(com.bytedance.sdk.openadsdk.core.eq.xk.ux(ls.getContext(), i4), com.bytedance.sdk.openadsdk.core.eq.xk.ux(ls.getContext(), i5));
        }
    }
}
