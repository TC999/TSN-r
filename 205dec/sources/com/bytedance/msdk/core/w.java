package com.bytedance.msdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.pangle_csjm.PluginInitConfig;
import com.bytedance.msdk.api.sr.bk;
import com.bytedance.msdk.api.sr.f;
import com.bytedance.msdk.core.p.ux;
import com.bytedance.msdk.f.ba;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.f.m;
import com.bytedance.msdk.f.wv;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private static final w gw = new w();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f28258a;
    private String ba;
    private String bk;
    private long bw;
    private JSONObject ck;
    private boolean eq;
    private boolean gb;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f28263k;
    private List<String> ls;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Float> f28264m;
    private String me;

    /* renamed from: n  reason: collision with root package name */
    private boolean f28265n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f28266p;
    private PluginInitConfig pr;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private String f28270t;

    /* renamed from: u  reason: collision with root package name */
    private f f28271u;
    private bk up;
    private String ux;
    private int[] vc;
    private com.bytedance.msdk.api.sr.c.gd.c wv;

    /* renamed from: x  reason: collision with root package name */
    private final Map<String, Integer> f28273x;
    private boolean xk;
    private String[] xv;

    /* renamed from: y  reason: collision with root package name */
    private boolean f28274y;
    private ValueSet yu;

    /* renamed from: z  reason: collision with root package name */
    private boolean f28275z;

    /* renamed from: c  reason: collision with root package name */
    private int f28259c = 0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f28272w = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28260f = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28268r = false;
    private boolean ev = false;
    private Set<String> ys = new HashSet();
    private Map<String, Map<String, String>> fp = new HashMap();
    private Map<String, Map<String, String>> ia = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private boolean f28269s = false;
    private final Map<String, Object> fz = new j();

    /* renamed from: i  reason: collision with root package name */
    private long f28261i = -1;

    /* renamed from: q  reason: collision with root package name */
    private Map<String, Object> f28267q = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f28262j = new ConcurrentHashMap();
    private int wx = -1;

    private w() {
        HashMap hashMap = new HashMap();
        this.f28273x = hashMap;
        this.f28264m = new ConcurrentHashMap();
        if (c.w().me()) {
            hashMap.put("adGap", 1);
            hashMap.put("adLoad", 1);
            hashMap.put("sectionId", 1);
            hashMap.put("pageId", 1);
            hashMap.put("custom", 1);
        }
    }

    public static w k() {
        return gw;
    }

    public String a() {
        return this.sr;
    }

    public f ba() {
        return this.f28271u;
    }

    public boolean bk() {
        return this.xk;
    }

    public boolean bw() {
        return this.f28275z;
    }

    public void c(boolean z3) {
        this.f28269s = z3;
    }

    public boolean ck() {
        String c4 = m.c();
        return "com.header.app.untext".equals(c4) || "com.bytedance.mediation_demo".equals(c4) || "com.msdk.qa.monkey".equals(c4);
    }

    public void eq() {
        this.up = bk.c(k().w());
    }

    public String ev() {
        if (("com.header.app.untext".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) || ("com.bytedance.mediation_demo".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr))) {
            try {
                return wv.c("tt_mediation_ppe_info", c.getContext()).w("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String f() {
        return this.me;
    }

    public String fp() {
        return this.f28263k;
    }

    public int[] fz() {
        return this.vc;
    }

    public String gb() {
        if (!TextUtils.isEmpty(this.f28270t)) {
            return this.f28270t;
        }
        String c4 = wv.c((String) null, c.getContext()).c();
        this.f28270t = c4;
        if (!TextUtils.isEmpty(c4)) {
            return this.f28270t;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        wv.c((String) null, c.getContext()).c(valueOf);
        this.f28270t = valueOf;
        return valueOf;
    }

    public boolean gd() {
        return "com.bytedance.mediation_demo_csj".equals(c.getContext().getPackageName()) && p();
    }

    public boolean gw() {
        return this.eq;
    }

    public String i() {
        return this.ux;
    }

    public Map<String, String> ia() {
        return this.f28258a;
    }

    public boolean j() {
        return this.f28272w;
    }

    public String[] ls() {
        return this.xv;
    }

    public boolean m() {
        return this.f28274y;
    }

    public Map<String, Object> me() {
        return this.f28267q;
    }

    public com.bytedance.msdk.api.sr.c.gd.c mt() {
        return this.wv;
    }

    public boolean n() {
        if ("com.header.app.untext".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if ("com.bytedance.gromore_demo".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if ("com.pangolin_demo.toutiao".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if ("com.bytedance.mediation_demo".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if ("com.msdk.qa.monkey".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if ("com.bytedance.gromore_demo".equals(c.getContext().getPackageName()) && "5001121".equals(this.sr)) {
            return true;
        }
        if (c.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
            if ("5001121".equals(this.sr)) {
                return true;
            }
        }
        return false;
    }

    public boolean p() {
        String path = com.bytedance.sdk.openadsdk.api.plugin.w.xv(c.getContext()).getPath();
        if (this.wx < 0) {
            if (new File(path + "/e2e.text").exists()) {
                this.wx = 1;
            } else {
                this.wx = 0;
            }
        }
        return this.wx > 0;
    }

    public JSONObject pr() {
        return this.ck;
    }

    public int q() {
        return this.f28259c;
    }

    public boolean r() {
        return this.f28266p;
    }

    public String s() {
        return this.gd;
    }

    public Map<String, Integer> sr() {
        return this.f28273x;
    }

    public boolean t() {
        return this.f28260f;
    }

    public boolean u() {
        return this.f28268r;
    }

    public ValueSet up() {
        return this.yu;
    }

    public long ux() {
        return this.bw;
    }

    public Map<String, Object> vc() {
        this.fz.put("gm_usb", ux.ux());
        return this.fz;
    }

    public PluginInitConfig w() {
        if (this.pr == null) {
            b a4 = b.a();
            com.bytedance.msdk.sr.w.ux.c(a4);
            this.pr = PluginInitConfig.create(a4.l());
        }
        return this.pr;
    }

    public Map<String, Object> wv() {
        return this.f28262j;
    }

    public boolean wx() {
        return this.f28265n;
    }

    public String x() {
        return this.ba;
    }

    public List<String> xk() {
        return this.ls;
    }

    public long xv() {
        long j4 = this.f28261i;
        if (j4 != -1) {
            return j4;
        }
        long sr = com.bytedance.msdk.ux.xv.c.c().sr();
        this.f28261i = sr;
        return sr;
    }

    public bk y() {
        if (this.up == null) {
            this.up = bk.c(k().w());
        }
        return this.up;
    }

    public boolean ys() {
        return this.ev;
    }

    public boolean yu() {
        return this.gb;
    }

    public String z() {
        return this.bk;
    }

    private static void gd(String str) {
        ba.c(str, "appid\u4e0d\u80fd\u4e3a\u7a7a");
    }

    public void a(boolean z3) {
        this.eq = z3;
    }

    public boolean c() {
        return this.f28269s;
    }

    public void f(boolean z3) {
        this.f28268r = z3;
    }

    public void k(boolean z3) {
        this.f28274y = z3;
    }

    public void r(boolean z3) {
        this.f28272w = z3;
    }

    public void sr(boolean z3) {
        this.ev = z3;
    }

    public void ux(String str) {
        this.f28263k = str;
    }

    public void c(String str, float f4) {
        this.f28264m.put(str, Float.valueOf(f4));
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c(c.getContext());
        }
        this.ux = str;
    }

    public void gd(boolean z3) {
        this.f28265n = z3;
        if (z3) {
            try {
                Class.forName("com.bykv.vk.openvk.TTVfSdk");
            } catch (ClassNotFoundException e4) {
                this.f28265n = false;
                e4.printStackTrace();
            }
        }
    }

    public void r(String str) {
        this.bk = str;
    }

    public void sr(String str) {
        this.gd = str;
    }

    public void ux(boolean z3) {
        this.f28260f = z3;
    }

    public void xv(String str) {
        gd(str);
        this.sr = str;
    }

    public float c(String str) {
        return this.f28264m.get(str).floatValue();
    }

    public void ev(boolean z3) {
        this.gb = z3;
    }

    public void c(long j4) {
        com.bytedance.msdk.ux.xv.c.c().c(j4);
    }

    public void ev(String str) {
        this.ba = str;
    }

    public void xv(boolean z3) {
        this.xk = z3;
    }

    public void c(Map<String, String> map) {
        this.f28258a = map;
    }

    public void w(long j4) {
        this.bw = j4;
    }

    public void xv(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f28262j.putAll(map);
    }

    public void c(int... iArr) {
        this.vc = iArr;
    }

    public void w(String str) {
        this.me = str;
    }

    public static String c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public void p(boolean z3) {
        this.f28275z = z3;
    }

    public void w(boolean z3) {
        this.f28266p = z3;
    }

    public void w(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.f28267q.putAll(map);
    }

    public void c(int i4) {
        this.f28259c = i4;
    }

    public void c(String[] strArr) {
        this.xv = strArr;
    }

    public void c(f fVar, boolean z3) {
        boolean equals;
        if (!z3) {
            f fVar2 = this.f28271u;
            if (fVar2 == null && fVar == null) {
                equals = true;
            } else {
                equals = (fVar2 == null || fVar == null) ? false : fVar2.equals(fVar);
            }
            this.f28271u = fVar;
            if (equals) {
                return;
            }
            com.bytedance.msdk.core.fp.w.c(c.w()).c().c(3);
            return;
        }
        this.f28271u = fVar;
    }

    public void c(List<String> list) {
        this.ls = list;
    }

    public void c(JSONObject jSONObject) {
        this.ck = jSONObject;
    }

    public void c(ValueSet valueSet) {
        this.yu = valueSet;
    }

    public void c(com.bytedance.msdk.api.sr.c.gd.c cVar) {
        this.wv = cVar;
    }
}
