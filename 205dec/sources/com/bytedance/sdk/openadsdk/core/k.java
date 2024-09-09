package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.ys.w.xv.sr;
import com.bytedance.sdk.openadsdk.ys.w.xv.xv;
import com.stub.StubApp;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.openadsdk.ys.w.xv.sr f33817c = new c();
    private static volatile k yu;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f33818a;
    private int ba;
    private volatile boolean bk;
    private boolean ck;
    private int eq;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f33819f;
    private volatile TTDownloadEventLogger fp;
    private String fz;
    private HashMap<String, Object> gb;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f33820i;
    private volatile com.bytedance.sdk.openadsdk.ys.w.xv.sr ia;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f33821j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<Integer> f33822k;
    private volatile JSONObject ls;
    private long me;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33823n;
    private Bridge pr;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f33825q;

    /* renamed from: r  reason: collision with root package name */
    private volatile String f33826r;

    /* renamed from: s  reason: collision with root package name */
    private String f33827s;
    private volatile boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private Bitmap f33828t;

    /* renamed from: u  reason: collision with root package name */
    private volatile boolean f33829u;
    private volatile String ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile String f33830w;
    private f wv;
    private com.bytedance.sdk.openadsdk.core.playable.ev wx;
    private boolean xk;
    private volatile String xv;

    /* renamed from: y  reason: collision with root package name */
    private int f33831y;
    private final com.bytedance.sdk.openadsdk.core.eq.c ys;

    /* renamed from: z  reason: collision with root package name */
    private Bridge f33832z;
    private volatile com.bytedance.sdk.openadsdk.core.gb.c ev = new com.bytedance.sdk.openadsdk.core.gb.c(2);
    private volatile int gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f33824p = true;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c extends com.bytedance.sdk.openadsdk.ys.w.xv.sr {
        public c() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean c() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public com.bytedance.sdk.openadsdk.ys.w.xv.xv ev() {
            String[] split;
            String c4 = com.bytedance.sdk.openadsdk.tools.w.c(8, "");
            if (TextUtils.isEmpty(c4) || (split = c4.split(",")) == null) {
                return null;
            }
            String str = split.length > 0 ? split[0] : "";
            String str2 = split.length > 1 ? split[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new xv.c().c(Double.valueOf(str).doubleValue()).w(Double.valueOf(str2).doubleValue()).c();
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean f() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(22, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public String gd() {
            return com.bytedance.sdk.openadsdk.tools.w.c(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public String k() {
            return com.bytedance.sdk.openadsdk.tools.w.c(13, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public String p() {
            return com.bytedance.sdk.openadsdk.tools.w.c(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean r() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean sr() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean ux() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean w() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(17, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
        public boolean xv() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.w.c(9, "1"));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        public static final com.bytedance.sdk.component.f.c f33845c = com.bytedance.sdk.openadsdk.core.eq.ba.c("sp_global_info");
    }

    private k() {
        Set<Integer> synchronizedSet = Collections.synchronizedSet(new HashSet());
        this.f33822k = synchronizedSet;
        this.f33818a = true;
        this.bk = false;
        this.f33828t = null;
        com.bytedance.sdk.openadsdk.core.eq.c cVar = new com.bytedance.sdk.openadsdk.core.eq.c();
        this.ys = cVar;
        this.f33829u = false;
        this.f33820i = true;
        this.f33825q = true;
        this.f33821j = 0;
        this.ls = new JSONObject();
        this.gb = new HashMap<>();
        this.f33823n = false;
        this.ck = false;
        this.f33832z = null;
        this.ba = -1;
        this.f33831y = -1;
        this.eq = -1;
        this.me = -1L;
        Context context = ls.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.f.c.c(context);
        }
        synchronizedSet.add(4);
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(cVar);
        } else if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
        } else {
            ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(cVar);
        }
    }

    private void bw() {
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.r.w.c().w(0.0d);
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
    }

    public static k sr() {
        if (yu == null) {
            synchronized (k.class) {
                if (yu == null) {
                    yu = new k();
                }
            }
        }
        return yu;
    }

    private static com.bytedance.sdk.openadsdk.ys.w.xv.sr x() {
        return new sr.c().w(true).c(true).c((com.bytedance.sdk.openadsdk.ys.w.xv.xv) null).xv(true).c((String) null).sr(true).w((String) null).ux(true).xv((String) null).f(true).sr((String) null).r(false).c();
    }

    public com.bytedance.sdk.openadsdk.core.gb.c a() {
        return this.ev;
    }

    public boolean ba() {
        return "5001121".equals(this.f33830w);
    }

    public String bk() {
        if (!TextUtils.isEmpty(this.f33819f)) {
            return this.f33819f;
        }
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().p("");
    }

    public String ck() {
        if (!com.bytedance.sdk.openadsdk.core.xv.sr.c().w()) {
            return TextUtils.isEmpty(this.f33827s) ? "" : this.f33827s;
        }
        String w3 = w.f33845c.w("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(w3) ? "" : w3;
    }

    public boolean eq() {
        return this.f33820i;
    }

    public String ev() {
        if (!TextUtils.isEmpty(this.f33830w)) {
            return this.f33830w;
        }
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().f();
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.sr f() {
        if (this.ia == null) {
            this.ia = z() ? f33817c : x();
        }
        return this.ia;
    }

    public boolean fp() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            return w.f33845c.w("allow_show_notify", true);
        }
        return this.f33824p;
    }

    public JSONObject fz() {
        return this.ls;
    }

    public Bitmap gb() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            return com.bytedance.sdk.component.utils.sr.c(w.f33845c.w("pause_icon", ""));
        }
        return this.f33828t;
    }

    public String gd() {
        if (!TextUtils.isEmpty(this.xv)) {
            return this.xv;
        }
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().r();
    }

    public TTDownloadEventLogger i() {
        return this.fp;
    }

    public boolean ia() {
        return this.f33829u;
    }

    public boolean j() {
        if (com.bytedance.sdk.openadsdk.core.xv.sr.c().w()) {
            return com.bytedance.sdk.openadsdk.core.xv.ux.c().xv(false);
        }
        return this.bk;
    }

    public String k() {
        if (!TextUtils.isEmpty(this.ux)) {
            return this.ux;
        }
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().ev("");
    }

    public boolean ls() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            return w.f33845c.w("is_use_texture", true);
        }
        return this.f33818a;
    }

    public int me() {
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().r(0);
    }

    public int n() {
        if (com.bytedance.sdk.openadsdk.core.xv.sr.c().w()) {
            int ev = com.bytedance.sdk.openadsdk.core.xv.ux.c().ev();
            return ev == Integer.MIN_VALUE ? this.f33821j : ev;
        }
        return this.f33821j;
    }

    public boolean p() {
        if (com.bytedance.sdk.openadsdk.core.xv.sr.c().w()) {
            return com.bytedance.sdk.openadsdk.core.xv.ux.c().c(this.sr);
        }
        return this.sr;
    }

    public long pr() {
        return this.me;
    }

    public com.bytedance.sdk.openadsdk.core.playable.ev q() {
        if (this.wx == null) {
            this.wx = new com.bytedance.sdk.openadsdk.core.playable.ev(10, 8);
        }
        return this.wx;
    }

    public boolean r() {
        return w.f33845c.w("sdk_activate_init", true);
    }

    public void s() {
        com.bytedance.sdk.openadsdk.core.xv.ux.c().ux(this.f33821j);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().xv(this.f33830w);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().sr(this.xv);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().w(this.sr);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().r(this.ux);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().gd(this.f33819f);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().k(c(this.gb));
        com.bytedance.sdk.component.f.c cVar = w.f33845c;
        cVar.c("title_bar_theme", this.gd);
        cVar.c("allow_show_notify", this.f33824p);
        cVar.c("is_use_texture", this.f33818a);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().sr(this.bk);
        Set<Integer> set = this.f33822k;
        if (set != null && !set.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : this.f33822k) {
                sb.append(num);
                sb.append(",");
            }
            w.f33845c.c("network_state", sb.toString());
            return;
        }
        cVar.c("network_state");
    }

    public Map<String, Object> t() {
        if (!this.gb.isEmpty()) {
            return this.gb;
        }
        String a4 = com.bytedance.sdk.openadsdk.core.xv.ux.c().a("");
        this.gb.putAll(TextUtils.isEmpty(a4) ? gd(a4) : new HashMap<>());
        return this.gb;
    }

    public Bridge u() {
        Bridge bridge = this.pr;
        if (bridge != null) {
            return bridge;
        }
        if (eq.f33190w >= 5500) {
            this.pr = f(3);
        } else if (!AdSdkInitializerHolder.isSdkInitSuccess()) {
            return null;
        } else {
            try {
                this.pr = (Bridge) DownloadBridgeFactory.class.getDeclaredMethod("getDownloadBridge", Context.class).invoke(null, ls.getContext());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("TTDownload", "Init download bridge failed: " + th.getMessage());
            }
        }
        return this.pr;
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.sr ux() {
        return new ba(f());
    }

    public boolean w() {
        if (!this.ck && Build.VERSION.SDK_INT >= 26) {
            this.ck = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) ls.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.f33823n = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.f33823n;
    }

    public Bridge wv() {
        return this.f33832z;
    }

    public int wx() {
        return this.eq;
    }

    public boolean xk() {
        return this.xk;
    }

    public com.bytedance.sdk.openadsdk.core.eq.c xv() {
        return this.ys;
    }

    public String y() {
        if (!TextUtils.isEmpty(this.fz)) {
            return this.fz;
        }
        com.bytedance.sdk.component.f.c c4 = xv.c();
        String w3 = c4.w("any_door_id", (String) null);
        this.fz = w3;
        if (!TextUtils.isEmpty(w3)) {
            return this.fz;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        c4.c("any_door_id", valueOf);
        this.fz = valueOf;
        return valueOf;
    }

    public int ys() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            return w.f33845c.w("title_bar_theme", 0);
        }
        return this.gd;
    }

    public String yu() {
        return this.f33826r;
    }

    public boolean z() {
        return "5001121".equals(this.f33830w) && "com.union_test.toutiao".equals(com.bytedance.sdk.openadsdk.core.eq.wv.ev());
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ia.c(str.length() <= 1000, "keyword\u8d85\u957f, \u6700\u957f\u4e3a1000");
    }

    public boolean c() {
        return this.ys.c();
    }

    public void r(boolean z3) {
        eq.f33189r = z3;
        this.bk = z3;
    }

    public void ux(boolean z3) {
        xv(z3);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().w(z3);
    }

    public void xv(boolean z3) {
        this.sr = z3;
    }

    public boolean c(boolean z3) {
        return this.ys.c(z3);
    }

    public void xv(String str) {
        a(str);
        this.ux = str;
    }

    private static void bk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ia.c(str.length() <= 20000, "data\u8d85\u957f, \u6700\u957f\u4e3a20000");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap hashMap = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z3 = false;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                if (!optJSONObject.isNull("__name__")) {
                    String optString = optJSONObject.optString("__name__");
                    String optString2 = optJSONObject.optString("value");
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, optString2);
                    }
                } else if ("csj_rit_list".equals(optJSONObject.optString("name"))) {
                    r(optJSONObject.optString("value"));
                    jSONArray.remove(i4);
                    z3 = true;
                } else {
                    jSONArray2.put(optJSONObject);
                }
            }
        }
        if (z3) {
            this.f33819f = jSONArray.toString();
        } else {
            this.f33819f = str;
        }
        if ((jSONArray2.length() == 0 && hashMap.isEmpty()) || jSONArray2.length() != 0) {
            this.f33819f = jSONArray2.toString();
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.gb.putAll(hashMap);
    }

    private static final HashMap<String, Object> gd(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    private static void k(String str) {
        com.bytedance.sdk.component.utils.ia.c(str, "name\u4e0d\u80fd\u4e3a\u7a7a");
    }

    private static void p(String str) {
        com.bytedance.sdk.component.utils.ia.c(str, "appid\u4e0d\u80fd\u4e3a\u7a7a");
    }

    public boolean c(Activity activity) {
        return this.ys.c(activity);
    }

    public void f(String str) {
        xv(str);
        com.bytedance.sdk.openadsdk.core.xv.ux.c().r(str);
    }

    public void r(String str) {
        this.f33826r = str;
        com.bytedance.sdk.openadsdk.core.z.ux.c((com.bytedance.sdk.openadsdk.core.z.sr) null).c(true);
    }

    public void ux(String str) {
        sr(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().gd(str);
            com.bytedance.sdk.openadsdk.core.xv.ux.c().k(c(this.gb));
        }
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        this.ia = srVar;
    }

    public void p(boolean z3) {
        this.xk = z3;
    }

    public boolean xv(int i4) {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            String w3 = w.f33845c.w("network_state", "");
            if (TextUtils.isEmpty(w3)) {
                return false;
            }
            String[] split = w3.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && String.valueOf(i4).equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return this.f33822k.contains(Integer.valueOf(i4));
    }

    public void c(String str) {
        p(str);
        this.f33830w = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put("plugin_version", "6.1.0.6");
            jSONObject.put("sdk_version", eq.xv);
            this.ls.put("com.byted.pangle", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void f(boolean z3) {
        com.bytedance.sdk.component.utils.a.w("_tt_ad_sdk_", "quit work");
        this.f33829u = z3;
        bw();
    }

    public void r(int i4) {
        this.eq = i4;
    }

    public void w(boolean z3) {
        w.f33845c.c("sdk_activate_init", z3);
    }

    public void sr(final String str) {
        bk(str);
        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.ev(str);
            }
        });
    }

    public void w(String str) {
        k(str);
        this.xv = str;
    }

    public void ux(int i4) {
        com.bytedance.sdk.openadsdk.core.xv.ux.c().f(i4);
    }

    public Bridge f(int i4) {
        Bridge bridge = this.f33832z;
        if (bridge == null) {
            return null;
        }
        return (Bridge) bridge.call(10, b.b(1).e(0, i4).l(), Bridge.class);
    }

    public void sr(boolean z3) {
        this.f33824p = z3;
    }

    public void w(int i4) {
        this.gd = i4;
    }

    public void sr(int i4) {
        try {
            this.f33821j = (i4 < 0 || i4 > 2) ? 0 : 0;
        } catch (Throwable unused) {
        }
    }

    public boolean w(Context context) {
        if (this.f33831y == -1) {
            if (com.bytedance.sdk.component.utils.q.w(context)) {
                this.f33831y = 1;
            } else {
                this.f33831y = 2;
            }
        }
        return this.f33831y == 1;
    }

    public void c(int i4) {
        this.ev = new com.bytedance.sdk.openadsdk.core.gb.c(i4, true);
    }

    public void gd(boolean z3) {
        this.f33820i = z3;
    }

    public void c(String str, String str2) {
        try {
            JSONObject optJSONObject = this.ls.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject.putOpt("plugin_version", str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.a.f("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void c(String str, String str2, String str3, String str4) {
        try {
            JSONObject optJSONObject = this.ls.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.f33830w;
            }
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put("app_id", str4);
            optJSONObject.put("plugin_version", str3);
            optJSONObject.put("sdk_version", str2);
            this.ls.put(str, optJSONObject);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.a.sr("GlobalInfo", "addPluginConfig for " + str + " failed: " + e4.getMessage());
        }
    }

    public void ev(boolean z3) {
        this.f33818a = z3;
    }

    public void c(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() < 1) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.f33830w);
                    c(str, bundle2.getString("sdk_version"), bundle2.getString("plugin_version"), string);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void c(TTDownloadEventLogger tTDownloadEventLogger) {
        this.fp = tTDownloadEventLogger;
    }

    public void c(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.f33822k.clear();
            for (int i4 : iArr) {
                this.f33822k.add(Integer.valueOf(i4));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static final String c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public void c(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            String c4 = com.bytedance.sdk.component.utils.sr.c(bitmap);
            if (!TextUtils.isEmpty(c4)) {
                w.f33845c.c("pause_icon", c4);
            }
        }
        this.f33828t = bitmap;
    }

    public void c(Bridge bridge) {
        if (this.f33832z != null) {
            return;
        }
        this.f33832z = new com.bytedance.sdk.openadsdk.ys.c(bridge);
    }

    public boolean c(Context context) {
        if (this.ba == -1) {
            if (com.bytedance.sdk.component.utils.q.c(context)) {
                this.ba = 1;
            } else {
                this.ba = 2;
            }
        }
        return this.ba == 1;
    }

    public void c(long j4) {
        this.me = j4;
    }

    public void c(c.w wVar) {
        if (this.f33832z != null) {
            if (this.wv == null) {
                f fVar = new f();
                this.wv = fVar;
                fVar.c(this.f33832z);
            }
            this.wv.c(wVar);
        }
    }
}
