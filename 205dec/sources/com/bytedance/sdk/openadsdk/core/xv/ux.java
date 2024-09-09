package com.bytedance.sdk.openadsdk.core.xv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.api.AdError;
import com.bytedance.sdk.openadsdk.core.ls;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ux f35612c;

    /* renamed from: a  reason: collision with root package name */
    private volatile String f35613a;
    private volatile String ba;
    private volatile String bk;
    private volatile String bw;
    private volatile String ck;
    private volatile JSONArray eq;
    private volatile String ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f35614f;
    private volatile String fp;
    private volatile String fz;
    private volatile String gb;
    private volatile String gd;

    /* renamed from: i  reason: collision with root package name */
    private volatile String f35615i;
    private volatile String ia;
    private volatile String ls;
    private volatile String me;

    /* renamed from: n  reason: collision with root package name */
    private volatile String f35619n;

    /* renamed from: q  reason: collision with root package name */
    private volatile String f35621q;

    /* renamed from: s  reason: collision with root package name */
    private volatile String f35623s;

    /* renamed from: u  reason: collision with root package name */
    private volatile String f35625u;
    private volatile String ux;
    private volatile String wv;

    /* renamed from: x  reason: collision with root package name */
    private volatile String f35627x;

    /* renamed from: y  reason: collision with root package name */
    private volatile String f35628y;
    private volatile String yu;

    /* renamed from: z  reason: collision with root package name */
    private volatile String f35629z;
    private volatile int xv = -1;
    private volatile long sr = -1;

    /* renamed from: r  reason: collision with root package name */
    private volatile int f35622r = -1;

    /* renamed from: p  reason: collision with root package name */
    private volatile int f35620p = -1;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f35617k = -1;

    /* renamed from: t  reason: collision with root package name */
    private volatile int f35624t = -1;
    private volatile int ys = -1;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f35616j = -1;
    private volatile int xk = -1;
    private volatile int wx = -1;
    private volatile int pr = -1;

    /* renamed from: m  reason: collision with root package name */
    private volatile int f35618m = -1;

    /* renamed from: w  reason: collision with root package name */
    private volatile SharedPreferences f35626w = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "sp_exec_getad_config", 0);

    public static ux c() {
        if (f35612c == null) {
            synchronized (ux.class) {
                if (f35612c == null) {
                    f35612c = new ux();
                }
            }
        }
        return f35612c;
    }

    private SharedPreferences eq() {
        return this.f35626w;
    }

    private void me() {
        try {
            this.f35623s = com.bytedance.sdk.openadsdk.core.r.c().sr();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plugin_version", 6106);
            jSONObject.put("log_version", this.f35623s);
            xv("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public String a(String str) {
        if (this.ia == null) {
            this.ia = sr("extra_internal_data", str);
        }
        return this.ia;
    }

    public String ba() {
        if (this.bw == null) {
            this.bw = sr("net_qty", "");
        }
        return this.bw;
    }

    public void bk(String str) {
        if (str == null || str.equals(this.fz)) {
            return;
        }
        this.fz = str;
        xv("dev01", str);
    }

    public void ck(String str) {
        if (str == null || !str.equals(this.yu)) {
            this.yu = str;
            xv("dev16", str);
        }
    }

    public String ev(String str) {
        if (this.bk == null) {
            this.bk = sr("keywords", str);
        }
        return this.bk;
    }

    public String f() {
        if (this.ev == null) {
            this.ev = sr("app_id", "");
        }
        return this.ev;
    }

    public void fp(String str) {
        if (str == null || str.equals(this.f35615i)) {
            return;
        }
        this.f35615i = str;
        xv("dev04", str);
    }

    public void fz(String str) {
        if (str == null || str.equals(this.gb)) {
            return;
        }
        this.gb = str;
        xv("dev08", str);
    }

    public void gb(String str) {
        if (str == null || str.equals(this.me)) {
            return;
        }
        this.me = str;
        ux("dev13", str);
    }

    public void gd(String str) {
        if (str == null || !str.equals(this.fp)) {
            this.fp = str;
            xv("extra_data", str);
        }
    }

    public void i(String str) {
        if (str == null || str.equals(this.ck)) {
            return;
        }
        this.ck = str;
        xv("dev18", str);
    }

    public void ia(String str) {
        if (str == null || str.equals(this.f35621q)) {
            return;
        }
        this.f35621q = str;
        xv("dev05", str);
    }

    public void j(String str) {
        if (str == null || str.equals(this.ba)) {
            return;
        }
        this.ba = str;
        xv("dev10", str);
    }

    public void k(String str) {
        if (str == null || !str.equals(this.ia)) {
            this.ia = str;
            xv("extra_internal_data", str);
        }
    }

    public void ls(String str) {
        if (str == null || str.equals(this.f35628y)) {
            return;
        }
        this.f35628y = str;
        xv("dev11", str);
    }

    public void n(String str) {
        if (str == null || str.equals(this.wv)) {
            return;
        }
        this.wv = str;
        ux("dev15", str);
    }

    public String p(String str) {
        if (this.fp == null) {
            this.fp = sr("extra_data", str);
        }
        return this.fp;
    }

    public void q(String str) {
        if (str == null || str.equals(this.f35629z)) {
            return;
        }
        this.f35629z = str;
        xv("dev09", str);
    }

    public String r() {
        if (this.gd == null) {
            this.gd = sr("app_name", "");
        }
        return this.gd;
    }

    public void s(String str) {
        if (str == null || str.equals(this.ls)) {
            return;
        }
        this.ls = str;
        xv("dev07", str);
    }

    public void sr() {
        this.f35614f = "";
        this.ux = "";
        xv("ab_test_version", "");
        xv("ab_test_param", "");
    }

    public String t(String str) {
        if (this.fz == null) {
            this.fz = sr("dev01", str);
        }
        return this.fz;
    }

    public void u(String str) {
        if (str == null || str.equals(this.f35619n)) {
            return;
        }
        this.f35619n = str;
        xv("dev17", str);
    }

    public int ux() {
        if (this.f35622r == -1) {
            this.f35622r = w("live_ad_clk_cnt", 0);
        }
        return this.f35622r;
    }

    public long w() {
        if (this.sr == -1) {
            this.sr = w("duration", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return this.sr;
    }

    public int xv() {
        if (this.xv == -1) {
            this.xv = w("max", 50);
        }
        return this.xv;
    }

    public String y() {
        if (this.f35627x == null) {
            this.f35627x = sr("spl_strategy", "");
        }
        return this.f35627x;
    }

    public void ys(String str) {
        if (str == null || str.equals(this.f35625u)) {
            return;
        }
        this.f35625u = str;
        xv("dev02", com.bytedance.sdk.component.utils.c.w(str));
    }

    public int z() {
        if (this.pr == -1) {
            this.pr = w("dev_level", -1000);
        }
        return this.pr;
    }

    public boolean a() {
        if (this.f35616j == -1) {
            this.f35616j = w("dl_storage_internal", 1);
        }
        return this.f35616j == 1;
    }

    public void ba(String str) {
        if (str == null || !str.equals(this.f35627x)) {
            this.f35627x = str;
            xv("spl_strategy", this.f35627x);
        }
    }

    public String bk() {
        if (this.ls == null) {
            this.ls = sr("dev07", null);
        }
        return this.ls;
    }

    public int ck() {
        if (this.wx == -1) {
            this.wx = w("splash_policy", 0);
        }
        return this.wx;
    }

    public int ev() {
        if (this.f35624t == -1) {
            this.f35624t = w("age_group", Integer.MIN_VALUE);
        }
        return this.f35624t;
    }

    public void f(String str) {
        this.f35613a = str;
        xv("dev03", str);
    }

    public String fp() {
        if (this.ck == null) {
            this.ck = sr("dev18", null);
        }
        return this.ck;
    }

    public String fz() {
        if (this.f35628y == null) {
            this.f35628y = sr("dev11", null);
        }
        return this.f35628y;
    }

    public boolean gb() {
        if (this.f35618m == -1) {
            this.f35618m = w("spl_cache_conf", 0);
        }
        return (this.f35618m & 1) == 1;
    }

    public String gd() {
        if (this.f35625u == null) {
            this.f35625u = com.bytedance.sdk.component.utils.c.xv(sr("dev02", null));
        }
        return this.f35625u;
    }

    public String i() {
        if (this.me == null) {
            this.me = sr("dev13", null);
        }
        return this.me;
    }

    public String ia() {
        if (this.f35629z == null) {
            this.f35629z = sr("dev09", null);
        }
        return this.f35629z;
    }

    public int j() {
        if (this.xk == -1) {
            this.xk = w("cypher_version", AdError.ERROR_CODE_REQUEST_PB_ERROR);
        }
        return this.xk;
    }

    public String k() {
        if (this.f35621q == null) {
            this.f35621q = sr("dev05", null);
        }
        return this.f35621q;
    }

    public String ls() {
        if (this.yu == null) {
            this.yu = sr("dev16", "");
        }
        return this.yu;
    }

    public boolean n() {
        if (this.f35618m == -1) {
            this.f35618m = w("spl_cache_conf", 0);
        }
        return (this.f35618m & 2) == 2;
    }

    public String p() {
        if (this.f35615i == null) {
            this.f35615i = sr("dev04", null);
        }
        return this.f35615i;
    }

    public String q() {
        if (this.wv == null) {
            this.wv = sr("dev15", null);
        }
        return this.wv;
    }

    public void r(String str) {
        if (str == null || !str.equals(this.bk)) {
            this.bk = str;
            xv("keywords", str);
        }
    }

    public String s() {
        if (this.ba == null) {
            this.ba = sr("dev10", null);
        }
        return this.ba;
    }

    public void sr(int i4) {
        if (this.f35622r == i4) {
            return;
        }
        this.f35622r = i4;
        c("live_ad_clk_cnt", i4);
    }

    public String t() {
        if (this.gb == null) {
            this.gb = sr("dev08", null);
        }
        return this.gb;
    }

    public JSONArray u() {
        String sr;
        if (this.eq == null && (sr = sr("dev12", null)) != null) {
            try {
                this.eq = new JSONArray(sr);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return this.eq;
    }

    public String ux(String str) {
        if (this.f35613a == null) {
            this.f35613a = sr("dev03", str);
        }
        return this.f35613a;
    }

    public String w(int i4) {
        if (this.ux == null) {
            this.ux = sr("ab_test_version", "");
        }
        return this.ux;
    }

    public String xv(int i4) {
        if (this.f35614f == null) {
            this.f35614f = sr("ab_test_param", "");
        }
        return this.f35614f;
    }

    public String ys() {
        if (this.f35619n == null) {
            this.f35619n = sr("dev17", null);
        }
        return this.f35619n;
    }

    public void z(String str) {
        if (str == null || !str.equals(this.bw)) {
            this.bw = str;
            xv("net_qty", str);
        }
    }

    public void f(int i4) {
        if (i4 == this.ys) {
            return;
        }
        this.ys = i4;
        c("sdk_theme_status", i4);
    }

    public void a(int i4) {
        if (this.f35618m == i4) {
            return;
        }
        this.f35618m = i4;
        c("spl_cache_conf", i4);
    }

    public void bk(int i4) {
        if (this.pr == i4) {
            return;
        }
        this.pr = i4;
        c("dev_level", i4);
    }

    public void c(long j4) {
        if (this.sr == j4) {
            return;
        }
        this.sr = j4;
        c("duration", j4);
    }

    public String ev(int i4) {
        if (TextUtils.isEmpty(this.f35623s)) {
            try {
                String sr = sr("logsdk_version", "");
                if (!TextUtils.isEmpty(sr)) {
                    JSONObject jSONObject = new JSONObject(sr);
                    int optInt = jSONObject.optInt("plugin_version");
                    this.f35623s = jSONObject.optString("log_version");
                    if (optInt != 6106 || TextUtils.isEmpty(this.f35623s)) {
                        me();
                    }
                } else {
                    me();
                }
            } catch (Exception unused) {
            }
        }
        return this.f35623s;
    }

    public boolean k(int i4) {
        return (i4 == 3 || i4 == 4) && sr.c().f(i4);
    }

    public void p(int i4) {
        if (this.xk == i4) {
            return;
        }
        this.xk = i4;
        c("cypher_version", i4);
    }

    public int r(int i4) {
        if (this.ys == -1) {
            this.ys = w("sdk_theme_status", i4);
        }
        return this.ys;
    }

    public void sr(String str) {
        if (str == null || !str.equals(this.gd)) {
            this.gd = str;
            xv("app_name", str);
        }
    }

    public void ux(int i4) {
        if (i4 == this.f35624t) {
            return;
        }
        this.f35624t = i4;
        c("age_group", i4);
    }

    public void w(String str) {
        if (str == null || !str.equals(this.f35614f)) {
            this.f35614f = str;
            xv("ab_test_param", str);
        }
    }

    public void xv(String str) {
        if (str == null || !str.equals(this.ev)) {
            this.ev = str;
            xv("app_id", str);
        }
    }

    public void gd(int i4) {
        this.f35616j = i4;
        c("dl_storage_internal", i4);
    }

    public void c(int i4) {
        if (this.xv == i4) {
            return;
        }
        this.xv = i4;
        c("max", i4);
    }

    public void sr(boolean z3) {
        int i4 = z3 ? 1 : 2;
        if (this.f35617k != i4) {
            this.f35617k = i4;
            c("is_use_mediation", i4);
        }
    }

    public void ux(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            xv(str, jSONObject.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void w(boolean z3) {
        this.f35620p = z3 ? 1 : 2;
        c("is_paid", this.f35620p);
    }

    public boolean xv(boolean z3) {
        if (this.f35617k == -1) {
            this.f35617k = w("is_use_mediation", z3 ? 1 : 2);
        }
        return this.f35617k == 1;
    }

    public String w(String str, String str2) {
        return sr("code_group_rit_" + str, str2);
    }

    public void c(String str) {
        if (str == null || !str.equals(this.ux)) {
            this.ux = str;
            xv("ab_test_version", str);
        }
    }

    public String sr(String str, String str2) {
        try {
            if (sr.c().w()) {
                return com.bytedance.sdk.component.f.xv.c.w.w("sp_exec_getad_config", str, str2);
            }
            return eq().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public long w(String str, long j4) {
        try {
            if (sr.c().w()) {
                return com.bytedance.sdk.component.f.xv.c.w.c("sp_exec_getad_config", str, j4);
            }
            return eq().getLong(str, j4);
        } catch (Throwable unused) {
            return j4;
        }
    }

    public void xv(String str, String str2) {
        try {
            if (sr.c().w()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_exec_getad_config", str, str2);
            } else {
                SharedPreferences.Editor edit = eq().edit();
                edit.putString(str, str2);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean c(boolean z3) {
        if (this.f35620p == -1) {
            this.f35620p = w("is_paid", z3 ? 1 : 2);
        }
        return this.f35620p == 1;
    }

    public int w(String str, int i4) {
        try {
            if (sr.c().w()) {
                return com.bytedance.sdk.component.f.xv.c.w.c("sp_exec_getad_config", str, i4);
            }
            return eq().getInt(str, i4);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public String xv(String str, long j4) {
        String sr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            sr = sr(str, "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(sr)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(sr);
        if (System.currentTimeMillis() - jSONObject.getLong("time") <= j4) {
            return jSONObject.getString("value");
        }
        return null;
    }

    public void c(String str, String str2) {
        xv("code_group_rit_" + str, str2);
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.eq == null ? null : this.eq.toString())) {
            return;
        }
        this.eq = jSONArray;
        xv("dev12", jSONArray.toString());
    }

    public void c(JSONObject jSONObject) {
        int optInt;
        if (jSONObject == null || this.wx == (optInt = jSONObject.optInt("splash_policy", 0))) {
            return;
        }
        this.wx = optInt;
        c("splash_policy", optInt);
    }

    public void c(String str, long j4) {
        try {
            if (sr.c().w()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_exec_getad_config", str, Long.valueOf(j4));
            } else {
                SharedPreferences.Editor edit = eq().edit();
                edit.putLong(str, j4);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void c(String str, int i4) {
        try {
            if (sr.c().w()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_exec_getad_config", str, Integer.valueOf(i4));
            } else {
                SharedPreferences.Editor edit = eq().edit();
                edit.putInt(str, i4);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }
}
