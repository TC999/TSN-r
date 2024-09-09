package com.bytedance.sdk.openadsdk.bk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f31508a;
    private boolean ab;
    private int au;

    /* renamed from: b  reason: collision with root package name */
    private int f31509b;
    private int ba;
    private c be;
    private int bj;
    private Runnable bk;
    private int bm;
    private WebView bs;
    private long bw;

    /* renamed from: c  reason: collision with root package name */
    public final String f31510c;
    private String cf;
    private long ck;

    /* renamed from: d  reason: collision with root package name */
    private String f31511d;
    private String db;
    private boolean dk;

    /* renamed from: e  reason: collision with root package name */
    private xv f31512e;
    private String eb;
    private long eq;
    private int eu;
    private final Handler ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f31513f;
    private long fm;
    private boolean fp;
    private Set<String> fz;

    /* renamed from: g  reason: collision with root package name */
    private Context f31514g;
    private boolean gb;
    private Runnable gd;
    private JSONObject ge;
    private String gp;
    private String gw;

    /* renamed from: h  reason: collision with root package name */
    private int f31515h;

    /* renamed from: i  reason: collision with root package name */
    private String f31516i;
    private boolean ia;
    private String iw;
    private String ix;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31517j;
    private int jd;
    private boolean jr;
    private boolean ju;
    private float jv;

    /* renamed from: k  reason: collision with root package name */
    private Runnable f31518k;
    private int kk;
    private JSONObject kn;
    private int kr;
    private int ky;

    /* renamed from: l  reason: collision with root package name */
    private int f31519l;
    private WeakReference<View> lf;
    private boolean ls;
    private Map<String, String> lw;

    /* renamed from: m  reason: collision with root package name */
    private String f31520m;
    private long me;
    private float mk;
    private int mt;
    private com.bytedance.sdk.openadsdk.bk.c mu;

    /* renamed from: n  reason: collision with root package name */
    private String f31521n;
    private int nc;
    private boolean nd;
    private int ng;
    private boolean ny;

    /* renamed from: o  reason: collision with root package name */
    private JSONObject f31522o;
    private int oh;
    private int ok;
    private boolean oo;
    private String ox;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f31523p;
    private int pb;
    private long pr;
    private int pu;

    /* renamed from: q  reason: collision with root package name */
    private boolean f31524q;
    private String qu;
    private String qy;

    /* renamed from: r  reason: collision with root package name */
    private final String f31525r;
    private float rd;
    private String rh;

    /* renamed from: s  reason: collision with root package name */
    private boolean f31526s;
    public final String sr;

    /* renamed from: t  reason: collision with root package name */
    private Runnable f31527t;
    private int ta;
    private long te;
    private int tl;
    private boolean tx;

    /* renamed from: u  reason: collision with root package name */
    private String f31528u;
    private int up;
    public final String ux;

    /* renamed from: v  reason: collision with root package name */
    private int f31529v;
    private String vc;

    /* renamed from: w  reason: collision with root package name */
    public final String f31530w;
    private int wo;
    private long wv;
    private long wx;

    /* renamed from: x  reason: collision with root package name */
    private String f31531x;
    private f xg;
    private long xk;
    private List<JSONObject> xq;
    private boolean xu;
    public final String xv;

    /* renamed from: y  reason: collision with root package name */
    private long f31532y;
    private int yh;
    private int yn;
    private w ys;
    private long yu;

    /* renamed from: z  reason: collision with root package name */
    private long f31533z;
    private ViewTreeObserver.OnGlobalLayoutListener zb;
    private String zg;
    private JSONObject zr;
    private String zt;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private ev(Context context, WebView webView, xv xvVar, com.bytedance.sdk.openadsdk.bk.c cVar, c cVar2, boolean z3) {
        this.f31513f = "playable_stuck_check_ping";
        this.f31525r = "playable_apply_media_permission_callback";
        this.ev = new Handler(Looper.getMainLooper());
        this.f31508a = new Handler(Looper.getMainLooper());
        this.fp = true;
        this.ia = true;
        this.f31526s = true;
        this.f31510c = "PL_sdk_playable_global_viewable";
        this.f31530w = "PL_sdk_page_screen_blank";
        this.xv = "PL_sdk_playable_destroy_analyze_summary";
        this.sr = "PL_sdk_playable_hardware_dialog_cancel";
        this.ux = "PL_sdk_playable_hardware_dialog_setting";
        this.fz = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.f31528u = null;
        this.f31516i = "embeded_ad";
        this.f31524q = true;
        this.f31517j = true;
        this.ls = true;
        this.gb = false;
        this.f31521n = "";
        this.ck = 10L;
        this.f31533z = 10L;
        this.ba = 700;
        this.f31532y = 0L;
        this.eq = 0L;
        this.me = -1L;
        this.wv = -1L;
        this.xk = -1L;
        this.yu = -1L;
        this.wx = -1L;
        this.pr = -1L;
        this.bw = -1L;
        this.f31531x = "";
        this.f31520m = "";
        this.gw = "";
        this.vc = "";
        this.up = 0;
        this.mt = 0;
        this.oo = false;
        this.au = 0;
        this.bj = -1;
        this.bm = 0;
        this.f31509b = 0;
        this.wo = 0;
        this.ox = null;
        this.xu = false;
        this.ng = 0;
        this.ok = 0;
        this.f31515h = 0;
        this.oh = 0;
        this.fm = 0L;
        this.te = 0L;
        this.ta = -2;
        this.eu = 0;
        this.tl = 0;
        this.kk = 0;
        this.zr = new JSONObject();
        this.lw = new HashMap();
        this.kn = new JSONObject();
        this.zg = "";
        this.rd = 0.0f;
        this.jv = 0.0f;
        this.tx = false;
        this.jr = false;
        this.ab = false;
        this.xq = new ArrayList();
        this.zb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.bk.ev.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) ev.this.lf.get();
                    if (view == null) {
                        return;
                    }
                    ev.this.w(view);
                } catch (Throwable th) {
                    r.c("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.ta = 0;
        this.be = cVar2;
        this.bs = webView;
        gd.c(webView);
        if (!z3) {
            c(webView);
        }
        c(context, xvVar, cVar);
    }

    static /* synthetic */ int a(ev evVar) {
        int i4 = evVar.up;
        evVar.up = i4 + 1;
        return i4;
    }

    static /* synthetic */ int bk(ev evVar) {
        int i4 = evVar.mt;
        evVar.mt = i4 + 1;
        return i4;
    }

    private void bw() {
        this.ys = new w(this, this.ba);
        this.gd = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.3
            @Override // java.lang.Runnable
            public void run() {
                if (ev.this.f31517j) {
                    ev.this.f31517j = false;
                    ev.this.ev.removeCallbacks(ev.this.f31523p);
                    ev.this.c(2, "\u5bb9\u5668\u52a0\u8f7d\u8d85\u65f6");
                }
            }
        };
        this.f31523p = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.4
            @Override // java.lang.Runnable
            public void run() {
                if (ev.this.f31517j) {
                    ev.this.f31517j = false;
                    ev.this.ev.removeCallbacks(ev.this.gd);
                    ev.this.c(3, "JSSDK\u52a0\u8f7d\u8d85\u65f6");
                }
            }
        };
        this.bk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.5
            @Override // java.lang.Runnable
            public void run() {
                r.c("mCheckJSRunnable", " ====\u5b9a\u65f6\u4efb\u52a1=== " + System.currentTimeMillis());
                if (Build.VERSION.SDK_INT >= 19 && ev.this.bs != null) {
                    ev.this.bs.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bk.ev.5.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: c */
                        public void onReceiveValue(String str) {
                            if (ev.this.ys != null) {
                                ev.this.ys.c(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (ev.this.f31508a != null) {
                    ev.this.f31508a.postDelayed(this, 500L);
                }
            }
        };
        this.f31527t = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.6
            @Override // java.lang.Runnable
            public void run() {
                r.c("mCheckJSRunnable", " ====Lynx\u68c0\u6d4b\u5b9a\u65f6\u4efb\u52a1=== " + System.currentTimeMillis());
                ev.this.c("playable_stuck_check_ping", new JSONObject());
                if (ev.this.f31508a != null) {
                    ev.this.f31508a.postDelayed(this, 500L);
                }
            }
        };
        this.f31518k = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.7
            @Override // java.lang.Runnable
            public void run() {
                if (ev.this.te > 0) {
                    if (ev.this.te - ev.this.fm <= ev.this.ba) {
                        ev.this.wv();
                        ev.this.fm = 0L;
                        ev.this.te = 0L;
                        return;
                    }
                    ev.this.w(1, "\u70b9\u51fb\u70ed\u533a\u5361\u6b7b");
                    return;
                }
                ev.this.w(1, "\u70b9\u51fb\u70ed\u533a\u5361\u6b7b");
            }
        };
    }

    private void m() {
        Runnable runnable;
        Runnable runnable2;
        this.ys.c(System.currentTimeMillis());
        Handler handler = this.f31508a;
        if (handler != null) {
            int i4 = this.ta;
            if (i4 == 0 && (runnable2 = this.bk) != null) {
                handler.post(runnable2);
            } else if ((i4 == 1 || i4 == 2) && (runnable = this.f31527t) != null) {
                handler.post(runnable);
            }
            this.ys.c(500);
        }
    }

    private void x() {
        String str;
        if (this.kn == null || (str = this.qy) == null || str.contains("/cid_")) {
            return;
        }
        String optString = this.kn.optString(BidResponsedEx.KEY_CID);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String host = Uri.parse(this.qy).getHost();
        if (TextUtils.isEmpty(host)) {
            this.qy += "/cid_" + optString;
            return;
        }
        this.qy = this.qy.replace(host, host + "/cid_" + optString);
    }

    public void ba() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.gd();
        }
    }

    public void ck() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.r();
        }
    }

    public void eq() {
        w wVar;
        this.te = System.currentTimeMillis();
        int i4 = this.ta;
        if ((i4 == 1 || i4 == 2) && (wVar = this.ys) != null) {
            wVar.c(System.currentTimeMillis());
        }
    }

    public String fp() {
        com.bytedance.sdk.openadsdk.bk.c cVar;
        if (TextUtils.isEmpty(this.gw) && (cVar = this.mu) != null) {
            this.gw = cVar.w().toString();
        }
        return this.gw;
    }

    public JSONObject fz() {
        return this.kn;
    }

    public void gb() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            if (this.be == c.FEED_AWEME) {
                int i4 = this.bj;
                if (i4 == 0 || i4 == 1) {
                    return;
                }
                cVar.ux();
                return;
            }
            cVar.ux();
        }
    }

    public Context getContext() {
        return this.f31514g;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.c();
        }
    }

    public com.bytedance.sdk.openadsdk.bk.c ia() {
        return this.mu;
    }

    public void j() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.sr();
        }
        this.bj = 2;
    }

    public void ls() {
        this.xu = true;
    }

    public void me() {
        this.ev.removeCallbacks(this.gd);
        this.ev.removeCallbacks(this.f31523p);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.xk > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.xk);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            xv("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.xv();
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            if (this.be == c.FEED_AWEME) {
                int i4 = this.bj;
                if (i4 == 0 || i4 == 1) {
                    return;
                }
                cVar.f();
                return;
            }
            cVar.f();
        }
    }

    public String pr() {
        return "function playable_callJS(){return \"Android\u8c03\u7528\u4e86JS\u7684callJS\u65b9\u6cd5\";}";
    }

    public void q() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.w(true);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.wx > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.wx);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.xk > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.xk;
                this.bw = currentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", currentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            xv("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject s() {
        if (this.zr.isNull("width")) {
            View view = this.lf.get();
            if (view == null) {
                return this.zr;
            }
            w(view);
        }
        return this.zr;
    }

    public JSONObject t() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.be.ordinal());
            jSONObject.put("safe_area_top_height", this.rd);
            jSONObject.put("safe_area_bottom_height", this.jv);
            jSONObject.put("playable_enter_from", this.f31509b);
            jSONObject.put("playable_retry_count", this.bm);
            jSONObject.put("playable_card_session", this.f31531x);
            jSONObject.put("playable_video_session", this.f31520m);
            jSONObject.put("playable_network_type", fp());
            jSONObject.put("aweme_id", this.vc);
            return jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.mk);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.yn);
            jSONObject2.put("height", this.yh);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.kr);
            jSONObject3.put("y", this.f31529v);
            jSONObject3.put("width", this.pu);
            jSONObject3.put("height", this.pb);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.f31519l);
            jSONObject4.put("y", this.jd);
            jSONObject4.put("width", this.nc);
            jSONObject4.put("height", this.ky);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void wv() {
        if (this.ls) {
            this.pr = System.currentTimeMillis();
            if (this.be == c.FEED_AWEME) {
                if (this.ny && this.eu == 3) {
                    w wVar = this.ys;
                    if (wVar != null && wVar.w()) {
                        m();
                    } else if (this.ys == null) {
                        this.ys = new w(this, this.ba);
                        m();
                    }
                }
            } else if (this.ny && this.eu == 2) {
                w wVar2 = this.ys;
                if (wVar2 != null && wVar2.w()) {
                    m();
                } else if (this.ys == null) {
                    this.ys = new w(this, this.ba);
                    m();
                }
            }
        }
    }

    public void wx() {
        if (this.ab) {
            return;
        }
        this.ab = true;
        this.eq = 0L;
        this.ia = true;
        yu();
        try {
            View view = this.lf.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.zb);
            }
        } catch (Throwable unused) {
        }
        try {
            this.xg.w();
        } catch (Throwable unused2) {
        }
        try {
            w wVar = this.ys;
            if (wVar != null) {
                wVar.c();
                this.ys = null;
            }
            Handler handler = this.f31508a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            r.c("Playable_CrashMonitor", "\u53d1\u751fcrash -- " + th);
        }
        try {
            if (!TextUtils.isEmpty(this.qy)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.up);
                jSONObject.put("playable_hit_times", this.mt);
                int i4 = this.up;
                if (i4 > 0) {
                    double d4 = this.mt;
                    double d5 = i4;
                    Double.isNaN(d5);
                    Double.isNaN(d4);
                    jSONObject.put("playable_hit_ratio", d4 / (d5 * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                xv("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.qy)) {
                if (this.me != -1) {
                    long currentTimeMillis = System.currentTimeMillis() - this.me;
                    r.c("PlayablePlugin", "playable show time +" + currentTimeMillis);
                    this.f31532y = this.f31532y + currentTimeMillis;
                    this.me = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.f31532y);
                xv("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.ev.removeCallbacks(this.gd);
        this.ev.removeCallbacks(this.f31523p);
        this.ev.removeCallbacksAndMessages(null);
    }

    public void xk() {
        try {
            w wVar = this.ys;
            if (wVar != null) {
                wVar.c();
            }
            Handler handler = this.f31508a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            r.c("Playable_CrashMonitor", "\u6682\u505c\u5361\u987f\u68c0\u6d4b\u53d1\u751fcrash -- " + th);
        }
    }

    public void y() {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.p();
        }
    }

    public Intent ys() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File c4 = ux.c();
        if (c4 == null) {
            return null;
        }
        Context context = this.f31514g;
        intent.putExtra("output", FileProvider.getUriForFile(context, this.f31514g.getPackageName() + ".playable.fileProvider", c4));
        return intent;
    }

    public void yu() {
        this.tl = 0;
        this.kk = 0;
        this.mk = 0.0f;
        this.yn = 0;
        this.yh = 0;
        this.f31529v = 0;
        this.kr = 0;
        this.pu = 0;
        this.pb = 0;
        this.jd = 0;
        this.f31519l = 0;
        this.nc = 0;
        this.ky = 0;
    }

    public void z() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.wx > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.wx);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.xk > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.xk);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            xv("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public JSONObject a() {
        try {
            boolean c4 = ux.c(this.f31514g, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", c4);
            return jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject bk() {
        boolean c4;
        boolean c5;
        try {
            boolean z3 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                c4 = ux.c(this.f31514g, "android.permission.READ_MEDIA_IMAGES");
                c5 = true;
            } else {
                c4 = ux.c(this.f31514g, "android.permission.READ_EXTERNAL_STORAGE");
                c5 = ux.c(this.f31514g, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", c4);
            jSONObject.put("isHasWrite", c5);
            if (!c4 || !c5) {
                z3 = false;
            }
            jSONObject.put("result", z3);
            return jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public boolean ev() {
        return this.ny;
    }

    public String f() {
        return this.db;
    }

    public JSONObject gd() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ju);
            return jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ia(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.f(jSONObject);
        }
    }

    public Set<String> p() {
        Set<String> c4 = this.xg.c();
        Set<String> set = this.fz;
        if (set == null || set.size() <= 0) {
            return c4;
        }
        HashSet hashSet = new HashSet();
        for (String str : c4) {
            if (!this.fz.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public boolean r() {
        return this.nd;
    }

    public String sr() {
        return this.zt;
    }

    public String ux() {
        return this.rh;
    }

    public ev xv(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.f31522o = jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.tl == view.getWidth() && this.kk == view.getHeight()) {
                return;
            }
            this.tl = view.getWidth();
            this.kk = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.tl);
            jSONObject.put("height", this.kk);
            c("resize", jSONObject);
            this.zr = jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void ev(JSONObject jSONObject) {
        WebView webView;
        this.ge = jSONObject;
        this.wo++;
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.k(jSONObject);
        }
        xk();
        this.ev.removeCallbacks(this.f31518k);
        if (this.ls) {
            this.pr = System.currentTimeMillis();
            this.fm = System.currentTimeMillis();
            this.te = 0L;
            int i4 = this.ta;
            if (i4 == 0) {
                if (Build.VERSION.SDK_INT >= 19 && (webView = this.bs) != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bk.ev.8
                        @Override // android.webkit.ValueCallback
                        /* renamed from: c */
                        public void onReceiveValue(String str) {
                            ev.this.te = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i4 == 1 || i4 == 2) {
                c("playable_stuck_check_ping", new JSONObject());
            }
            this.ev.postDelayed(this.f31518k, this.ba);
        }
    }

    public ev f(String str) {
        Uri parse;
        String scheme;
        int indexOf;
        String decode;
        this.zg = str;
        try {
            parse = Uri.parse(str);
            scheme = parse.getScheme();
        } catch (Throwable unused) {
        }
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            String host = parse.getHost();
            if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.ta == -1) {
                        w(2);
                    } else {
                        w(1);
                    }
                }
                this.qy = str;
                return this;
            }
            w(0);
            String queryParameter = parse.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter) && (decode = Uri.decode(queryParameter)) != null) {
                int indexOf2 = decode.indexOf("?");
                str = indexOf2 != -1 ? decode.substring(0, indexOf2) : decode;
            }
            this.qy = str;
            return this;
        }
        w(0);
        if (str != null && (indexOf = str.indexOf("?")) != -1) {
            str = str.substring(0, indexOf);
        }
        this.qy = str;
        return this;
    }

    public JSONObject k() {
        try {
            boolean c4 = ux.c(this.f31514g, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", c4);
            return jSONObject;
        } catch (Throwable th) {
            r.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void r(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.p(jSONObject);
        }
    }

    public ev sr(String str) {
        this.rh = str;
        return this;
    }

    public ev ux(String str) {
        this.db = str;
        return this;
    }

    public ev sr(boolean z3) {
        this.ju = z3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ju);
            c("change_playable_click", jSONObject);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public ev ux(JSONObject jSONObject) {
        this.kn = jSONObject;
        return this;
    }

    private void c(Context context, xv xvVar, com.bytedance.sdk.openadsdk.bk.c cVar) {
        this.f31528u = UUID.randomUUID().toString();
        this.f31514g = context;
        this.mu = cVar;
        this.f31512e = xvVar;
        p.c(cVar);
        this.xg = new f(this);
        bw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fp(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.ux(jSONObject);
        }
    }

    public void r(String str) {
        int i4;
        int i5;
        this.eu = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.xk = currentTimeMillis;
            long j4 = this.wv;
            jSONObject.put("playable_page_show_duration", j4 != -1 ? currentTimeMillis - j4 : 0L);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        xv("PL_sdk_html_load_start", jSONObject);
        if (this.f31524q && ((i4 = this.ta) == 0 || i4 == 1 || i4 == 2)) {
            this.ev.postDelayed(this.gd, this.ck * 1000);
            if (k(this.qy) || (i5 = this.ta) == 1 || i5 == 2) {
                this.ev.postDelayed(this.f31523p, this.f31533z * 1000);
            }
            this.f31524q = false;
        }
        if (this.ia) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ux.c(this.f31514g, ux.f31622a)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ux.w(this.f31514g, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ux.c(this.f31514g, ux.f31625k)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ux.c(this.f31514g, ux.f31626p)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ux.c(this.f31514g, ux.gd)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ux.c(this.f31514g, ux.ev)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ux.w(this.f31514g, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ux.c(this.f31514g, ux.f31627r)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ux.c(this.f31514g)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                xv("PL_sdk_hardware_detect", jSONObject2);
                this.ia = false;
            } catch (Throwable th2) {
                r.c("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public ev ux(boolean z3) {
        this.ls = z3;
        return this;
    }

    private String ux(String str, String str2) {
        String format = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.qy = format;
        return format;
    }

    public void gd(JSONObject jSONObject) {
        w(2, jSONObject != null ? jSONObject.optString("error_msg", "\u7d20\u6750\u76f4\u63a5\u8c03\u7528\u7aef\u4e0a\u5f02\u5e38\u515c\u5e95\u8499\u5c42") : "\u7d20\u6750\u76f4\u63a5\u8c03\u7528\u7aef\u4e0a\u5f02\u5e38\u515c\u5e95\u8499\u5c42");
    }

    public String xv() {
        return this.eb;
    }

    private void ux(String str, JSONObject jSONObject) {
        try {
            int i4 = this.ta;
            if (i4 == 0) {
                if (this.be != c.LAND_PAGE && !k(this.qy)) {
                    x();
                }
                jSONObject.put("playable_url", this.qy);
            } else {
                if (i4 != 3 && i4 != 4) {
                    if (i4 == 1 || i4 == 2) {
                        jSONObject.put("playable_url", sr(this.ix, this.f31511d));
                    }
                }
                jSONObject.put("playable_url", ux(this.qu, this.cf));
            }
            jSONObject.put("playable_render_type", this.ta);
            if (this.mu != null) {
                if (this.ta == 0 && (this.be != c.LAND_PAGE || k(this.qy))) {
                    r.c("PlayablePlugin", "reportJSSDKEvent by ActionProxy");
                    this.mu.c(jSONObject);
                } else if (this.ta != 0) {
                    r.c("PlayablePlugin", "reportJSSDKEvent by ActionProxy");
                    this.mu.c(jSONObject);
                } else {
                    r.c("PlayablePlugin", "reportJSSDKEvent error no not playable url");
                }
            }
        } catch (JSONException unused) {
        }
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt != 1) {
            if (optInt != 2) {
                return optInt != 3 ? jSONObject2 : bk();
            }
            return a();
        }
        return k();
    }

    public ev xv(boolean z3) {
        int i4;
        int i5;
        if (this.ny == z3) {
            return this;
        }
        this.ny = z3;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.ny) {
                jSONObject.put("playable_background_show_type", this.ok);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        xv(this.ny ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.wv == -1 && this.ny) {
            this.wv = System.currentTimeMillis();
            xv("PL_sdk_page_show", (JSONObject) null);
            com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
            if (cVar != null && (((i5 = this.ta) == 0 || i5 == 1 || i5 == 2) && this.gb)) {
                cVar.c(0);
            }
        }
        if (this.wv != -1 && !this.ny && !this.tx) {
            this.tx = true;
            com.bytedance.sdk.openadsdk.bk.c cVar2 = this.mu;
            if (cVar2 != null && (((i4 = this.ta) == 0 || i4 == 1 || i4 == 2) && this.gb)) {
                cVar2.c(1);
            }
        }
        if (this.ny) {
            this.me = System.currentTimeMillis();
        } else if (this.me != -1) {
            long currentTimeMillis = System.currentTimeMillis() - this.me;
            r.c("PlayablePlugin", "playable show time +" + currentTimeMillis);
            this.f31532y = this.f31532y + currentTimeMillis;
            this.me = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.ny);
            c("viewableChange", jSONObject2);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "setViewable error", th);
        }
        if (this.ny) {
            wv();
        } else {
            xk();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ys(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.sr(jSONObject);
        }
    }

    public void gd(String str) {
        this.ev.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.10
            @Override // java.lang.Runnable
            public void run() {
                ev.a(ev.this);
            }
        });
    }

    public void k(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.bk(jSONObject);
        }
    }

    public void p(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.a(jSONObject);
        }
    }

    public void sr(JSONObject jSONObject) {
        if (this.mu != null) {
            try {
                this.mu.c(jSONObject.optBoolean("isPrevent", false));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void p(String str) {
        this.ev.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.ev.2
            @Override // java.lang.Runnable
            public void run() {
                ev.bk(ev.this);
            }
        });
    }

    public JSONObject bk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt != 1) {
            if (optInt != 2) {
                if (optInt == 3) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", ux.c(this.f31514g));
                    } else {
                        jSONObject2.put("result", false);
                    }
                }
                return jSONObject2;
            } else if (Build.VERSION.SDK_INT >= 23) {
                jSONObject2.put("result", ux.w(this.f31514g, "android.permission.CAMERA"));
            } else {
                jSONObject2.put("result", false);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            jSONObject2.put("result", ux.w(this.f31514g, "android.permission.RECORD_AUDIO"));
        } else {
            jSONObject2.put("result", false);
        }
        return jSONObject2;
    }

    public void c(View view) {
        if (view == null) {
            return;
        }
        try {
            this.lf = new WeakReference<>(view);
            w(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.zb);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public ev w(String str) {
        this.eb = str;
        return this;
    }

    private String sr(String str, String str2) {
        String queryParameter;
        if (TextUtils.isEmpty(this.gp) && !TextUtils.isEmpty(this.zg)) {
            Uri parse = Uri.parse(this.zg);
            String host = parse.getHost();
            String str3 = "";
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                str3 = parse.getQueryParameter("surl");
                queryParameter = parse.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(parse.getScheme()).authority(host).appendQueryParameter("surl", str3);
            if (!TextUtils.isEmpty(queryParameter)) {
                appendQueryParameter.appendQueryParameter("playable_hash", queryParameter);
            }
            this.gp = appendQueryParameter.toString();
        }
        return this.gp;
    }

    public void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("success", true);
            if (optBoolean) {
                this.eu = 3;
                wv();
            } else {
                this.eu = -2;
                com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
                if (cVar != null) {
                    cVar.w(false);
                }
            }
            if (optBoolean || !this.f31517j) {
                return;
            }
            this.f31517j = false;
            this.ev.removeCallbacks(this.gd);
            this.ev.removeCallbacks(this.f31523p);
            c(4, "\u7d20\u6750\u6e32\u67d3\u5931\u8d25");
        }
    }

    public JSONObject w() {
        return this.f31522o;
    }

    public ev w(boolean z3) {
        this.dk = z3;
        return this;
    }

    public ev w(long j4) {
        if (j4 <= 0) {
            this.f31533z = 10L;
        } else {
            this.f31533z = j4;
        }
        return this;
    }

    public ev c(String str, String str2) {
        this.lw.put(str, str2);
        return this;
    }

    public Map<String, String> c() {
        return this.lw;
    }

    public void w(JSONObject jSONObject) {
        int i4 = 0;
        if (jSONObject != null) {
            i4 = jSONObject.optInt("resource_type", 0);
            ux.xv = jSONObject.optInt("video_min_duration", 1);
            ux.sr = jSONObject.optInt("video_max_duration", 20);
            ux.ux = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.w(c(i4));
        }
    }

    public ev c(String str) {
        this.zt = str;
        return this;
    }

    public void ev(String str) {
        WebView webView;
        this.eu = 2;
        this.iw = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.yu = currentTimeMillis;
            long j4 = this.xk;
            jSONObject.put("playable_html_load_start_duration", j4 != -1 ? currentTimeMillis - j4 : 0L);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        xv("PL_sdk_html_load_finish", jSONObject);
        this.ev.removeCallbacks(this.gd);
        try {
            if (this.ta == 0) {
                if (Build.VERSION.SDK_INT >= 19 && this.fp && (webView = this.bs) != null) {
                    this.fp = false;
                    webView.evaluateJavascript(pr(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bk.ev.9
                        @Override // android.webkit.ValueCallback
                        /* renamed from: c */
                        public void onReceiveValue(String str2) {
                            r.c("Playable_CrashMonitor", "\u52a0\u8f7d\u6ce8\u5165js=" + str2);
                        }
                    });
                }
                wv();
            }
        } catch (Throwable th2) {
            r.c("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public ev c(boolean z3) {
        this.nd = z3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.nd);
            c("volumeChange", jSONObject);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ox = jSONObject.optString("section");
        }
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.gd(jSONObject);
        }
    }

    public ev c(long j4) {
        if (j4 <= 0) {
            this.ck = 10L;
        } else {
            this.ck = j4;
        }
        return this;
    }

    public JSONObject sr(String str, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (r.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PlayablePlugin JSB-REQ [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            r.c("PlayablePlugin", sb.toString());
        }
        JSONObject c4 = this.xg.c(str, jSONObject);
        if (r.c()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PlayablePlugin JSB-RSP [");
            sb2.append(str);
            sb2.append("] time:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append(" ");
            sb2.append(c4 != null ? c4.toString() : "");
            r.c("PlayablePlugin", sb2.toString());
        }
        return c4;
    }

    public void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.f31514g, "\u7167\u7247\u4fdd\u5b58\u5931\u8d25", 0).show();
            return;
        }
        Bitmap w3 = ux.w(str2);
        if (w3 != null) {
            MediaStore.Images.Media.insertImage(this.f31514g.getContentResolver(), w3, str, "");
            Toast.makeText(this.f31514g, "\u7167\u7247\u5df2\u4fdd\u5b58\u5230\u76f8\u518c", 0).show();
            return;
        }
        Toast.makeText(this.f31514g, "\u7167\u7247\u4fdd\u5b58\u5931\u8d25", 0).show();
    }

    public void c(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.c(ys());
        }
    }

    public Intent c(int i4) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i4 == 0) {
            intent.setType(Headers.VALUE_ACCEPT_ALL);
        } else if (i4 == 1) {
            intent.setType("image/*");
        } else if (i4 == 2) {
            intent.setType("video/mp4");
        } else {
            intent.setType(Headers.VALUE_ACCEPT_ALL);
        }
        return intent;
    }

    public ev w(int i4) {
        this.ta = i4;
        return this;
    }

    public void w(int i4, String str) {
        r.c("Playable_CrashMonitor", "-- \u68c0\u6d4b\u5230\u9875\u9762\u5361\u987f \u9700\u8981\u4e0a\u62a5 \u5361\u987f\u7c7b\u578b\uff1a" + i4);
        this.bj = i4;
        if (this.ge == null) {
            this.ge = new JSONObject();
        }
        try {
            this.ge.put("playable_stuck_type", i4);
            this.ge.put("playable_stuck_reason", str);
            if (this.pr > 0) {
                this.ge.put("playable_stuck_duration", System.currentTimeMillis() - this.pr);
            } else {
                this.ge.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        xv("PL_sdk_page_stuck", this.ge);
        xk();
        if (this.mu != null) {
            if (i4 == 2) {
                this.ge = new JSONObject();
            }
            this.mu.ev(this.ge);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        if (r.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CALL JS [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            r.c("PlayablePlugin", sb.toString());
        }
        xv xvVar = this.f31512e;
        if (xvVar != null) {
            xvVar.c(str, jSONObject);
        }
    }

    protected void c(int i4, String str) {
        xk();
        xv(i4, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i4);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "reportRenderFatal error", th);
        }
        xv("PL_sdk_global_faild", jSONObject);
    }

    public void xv(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar == null || cVar.r(jSONObject) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = jSONObject.optInt("resource_type", -1);
        String optString2 = jSONObject.optString("resource_name", "playable_media");
        if (optInt == 1) {
            w(optString2, optString);
        } else if (optInt == 2) {
            xv(optString2, optString);
        }
    }

    public void c(int i4, String str, String str2) {
        this.eu = -1;
        this.iw = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i4);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "onWebReceivedError error", th);
        }
        xv("PL_sdk_html_load_error", jSONObject);
        if (this.f31517j) {
            this.f31517j = false;
            this.ev.removeCallbacks(this.gd);
            this.ev.removeCallbacks(this.f31523p);
            c(1, "\u5bb9\u5668\u52a0\u8f7d\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ux(str, jSONObject);
    }

    public void xv(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.f31514g, "\u89c6\u9891\u4fdd\u5b58\u5931\u8d25", 0).show();
            return;
        }
        File c4 = ux.c(str, str2);
        if (c4 != null && c4.exists()) {
            Uri fromFile = Uri.fromFile(c4);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile);
            this.f31514g.sendBroadcast(intent);
            Toast.makeText(this.f31514g, "\u89c6\u9891\u5df2\u4fdd\u5b58\u5230\u76f8\u518c", 0).show();
            return;
        }
        Toast.makeText(this.f31514g, "\u89c6\u9891\u4fdd\u5b58\u5931\u8d25", 0).show();
    }

    private void xv(int i4, String str) {
        com.bytedance.sdk.openadsdk.bk.c cVar = this.mu;
        if (cVar != null) {
            cVar.c(i4, str);
        }
    }

    public void c(boolean z3, String str, int i4) {
        if (z3) {
            this.eu = -1;
            this.iw = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i4);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                r.c("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            xv("PL_sdk_html_load_error", jSONObject);
            if (this.f31517j) {
                this.f31517j = false;
                this.ev.removeCallbacks(this.gd);
                this.ev.removeCallbacks(this.f31523p);
                c(1, "\u5bb9\u5668\u52a0\u8f7d\u5931\u8d25");
            }
        }
    }

    public void xv(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.oo && this.mt > 0) {
                this.oo = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.ny);
            jSONObject.put("playable_session_id", this.f31528u);
            int i4 = this.ta;
            if (i4 == 0) {
                if (this.be != c.LAND_PAGE && !k(this.qy)) {
                    x();
                }
                jSONObject.put("playable_url", this.qy);
            } else {
                if (i4 != 3 && i4 != 4) {
                    if (i4 == 1 || i4 == 2) {
                        jSONObject.put("playable_url", sr(this.ix, this.f31511d));
                    }
                }
                jSONObject.put("playable_url", ux(this.qu, this.cf));
            }
            jSONObject.put("playable_full_url", this.zg);
            jSONObject.put("playable_replay_count", this.au);
            jSONObject.put("playable_is_prerender", this.dk);
            jSONObject.put("playable_is_preload", this.oo);
            jSONObject.put("playable_render_type", this.ta);
            jSONObject.put("playable_scenes_type", this.be.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.ix) ? "" : this.ix);
            if (!TextUtils.isEmpty(this.f31511d)) {
                str2 = this.f31511d;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.qu);
            jSONObject.put("playable_minigamelite_schema", this.cf);
            jSONObject.put("playable_is_debug", this.jr);
            jSONObject.put("playable_retry_count", this.bm);
            jSONObject.put("playable_enter_from", this.f31509b);
            jSONObject.put("playable_sequence", this.wo);
            jSONObject.put("playable_current_section", this.ox);
            jSONObject.put("is_playable_finish", this.xu);
            jSONObject.put("playable_card_session", this.f31531x);
            jSONObject.put("playable_video_session", this.f31520m);
            jSONObject.put("playable_network_type", fp());
            jSONObject.put("playable_lynx_version", this.f31521n);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.f31516i);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.kn.opt(BidResponsedEx.KEY_CID));
            jSONObject2.put("log_extra", this.kn.opt("log_extra"));
            int i5 = this.ta;
            if (i5 != -1 && i5 != -2) {
                if (this.mu != null) {
                    List<JSONObject> list = this.xq;
                    if (list != null && !list.isEmpty()) {
                        for (JSONObject jSONObject3 : this.xq) {
                            JSONObject optJSONObject = jSONObject3.optJSONObject("ad_extra_data");
                            if (optJSONObject != null) {
                                optJSONObject.put("playable_render_type", this.ta);
                                optJSONObject.put("playable_url", this.qy);
                            }
                            this.mu.c(optJSONObject);
                        }
                        this.xq.clear();
                    }
                    if (this.ta == 0 && (this.be != c.LAND_PAGE || k(this.qy))) {
                        r.c("PlayablePlugin", "reportEvent by ActionProxy");
                        this.mu.c(jSONObject);
                        return;
                    } else if (this.ta != 0) {
                        r.c("PlayablePlugin", "reportEvent by ActionProxy");
                        this.mu.c(jSONObject);
                        return;
                    } else {
                        r.c("PlayablePlugin", "reportEvent error no not playable url");
                        return;
                    }
                }
                r.c("PlayablePlugin", "reportEvent error no impl");
                return;
            }
            if (this.xq == null) {
                this.xq = new ArrayList();
            }
            this.xq.add(jSONObject2);
        } catch (Throwable th) {
            r.c("PlayablePlugin", "reportEvent error", th);
        }
    }

    public static ev c(Context context, WebView webView, xv xvVar, com.bytedance.sdk.openadsdk.bk.c cVar, Set<String> set, c cVar2, boolean z3) {
        if (webView == null || xvVar == null || cVar == null) {
            return null;
        }
        return new ev(context, webView, xvVar, cVar, set, cVar2, z3);
    }

    private ev(Context context, WebView webView, xv xvVar, com.bytedance.sdk.openadsdk.bk.c cVar, Set<String> set, c cVar2, boolean z3) {
        this(context, webView, xvVar, cVar, cVar2, z3);
        this.fz = set;
    }
}
