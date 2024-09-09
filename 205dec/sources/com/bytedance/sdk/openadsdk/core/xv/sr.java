package com.bytedance.sdk.openadsdk.core.xv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.eq.gb;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.eq.q;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: w  reason: collision with root package name */
    private static volatile sr f35604w;
    private volatile boolean ev;

    /* renamed from: p  reason: collision with root package name */
    private SharedPreferences f35609p;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f35606c = new AtomicBoolean(false);
    private AtomicBoolean xv = new AtomicBoolean(false);
    private AtomicInteger sr = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger ux = new AtomicInteger(Integer.MAX_VALUE);

    /* renamed from: f  reason: collision with root package name */
    private volatile String f35607f = null;

    /* renamed from: r  reason: collision with root package name */
    private AtomicInteger f35610r = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger gd = new AtomicInteger(Integer.MAX_VALUE);

    /* renamed from: k  reason: collision with root package name */
    private volatile JSONObject f35608k = null;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f35605a = new AtomicInteger(Integer.MAX_VALUE);

    private sr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        boolean xv = xv();
        if (xv) {
            com.bytedance.sdk.openadsdk.core.component.splash.xv.c();
            ux.c();
            w.c();
        }
        try {
            if (!f.c()) {
                xv.c(0);
            }
        } catch (Throwable unused) {
        }
        if (xv) {
            gd.w(3);
            c.c(ls.getContext(), 3);
            q.sr();
            int i4 = com.bytedance.sdk.openadsdk.core.a.xv.f31762c;
            LogAdapter logAdapter = LogAdapter.sAdapter;
            bk();
            gb.c(259200000L);
        }
    }

    private void bk() {
        com.bytedance.sdk.openadsdk.core.j.c cVar = new com.bytedance.sdk.openadsdk.core.j.c();
        i.c(cVar);
        i.ux();
        i.xv(cVar);
        i.sr(cVar);
        i.w(cVar);
        i.ux(cVar);
        i.ys();
    }

    private boolean c(int i4, int i5) {
        if (i5 == 0) {
            return false;
        }
        if (i5 == 1) {
            return true;
        }
        return i5 == 2 ? i4 == 3 || i4 == 4 : i5 == 3 && i4 != 5;
    }

    private SharedPreferences k() {
        return com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "sp_bidding_opt_libra", 0);
    }

    public JSONObject ev() {
        String string;
        try {
            if (this.f35608k == null) {
                JSONObject jSONObject = null;
                if (this.f35606c.get()) {
                    string = com.bytedance.sdk.component.f.xv.c.w.w("sp_bidding_opt_libra", "key_net_connpool", (String) null);
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    string = this.f35609p.getString("key_net_connpool", null);
                }
                if (!TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject(string);
                }
                this.f35608k = jSONObject;
            }
        } catch (Exception unused) {
        }
        return this.f35608k;
    }

    public int f() {
        try {
            if (this.f35610r.get() == Integer.MAX_VALUE) {
                if (this.f35606c.get()) {
                    this.f35610r.set(com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    this.f35610r.set(this.f35609p.getInt("key_network_module", 1));
                }
            }
            return this.f35610r.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public void gd() {
        try {
            com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra");
            SharedPreferences.Editor edit = k().edit();
            edit.clear();
            edit.apply();
            this.sr.set(0);
            this.ux.set(7);
            this.gd.set(0);
        } catch (Throwable unused) {
        }
    }

    public void p() {
        ev.c(new p("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.xv.sr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (sr.this.xv.get()) {
                        return;
                    }
                    sr.this.xv.set(true);
                    sr.this.a();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    public int r() {
        try {
            if (this.gd.get() == Integer.MAX_VALUE) {
                if (this.f35606c.get()) {
                    this.gd.set(com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", "key_req_build_opt", 0));
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    this.gd.set(this.f35609p.getInt("key_req_build_opt", 0));
                }
            }
            return this.gd.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String sr() {
        try {
            if (TextUtils.isEmpty(this.f35607f)) {
                if (this.f35606c.get()) {
                    this.f35607f = com.bytedance.sdk.component.f.xv.c.w.w("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    this.f35607f = this.f35609p.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.f35607f = TextUtils.isEmpty(this.f35607f) ? "api-access.pangolin-sdk-toutiao.com" : this.f35607f;
        return this.f35607f;
    }

    public int ux() {
        try {
            if (this.ux.get() == Integer.MAX_VALUE) {
                if (this.f35606c.get()) {
                    this.ux.set(com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    this.ux.set(this.f35609p.getInt("key_net_queue_limit", 7));
                }
            }
            return this.ux.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public boolean xv() {
        try {
            if (this.sr.get() == Integer.MAX_VALUE) {
                if (this.f35606c.get()) {
                    this.sr.set(com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.f35609p == null) {
                        this.f35609p = k();
                    }
                    this.sr.set(this.f35609p.getInt("key_req_body_opt", 1));
                }
            }
            return this.sr.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static sr c() {
        if (f35604w == null) {
            synchronized (sr.class) {
                if (f35604w == null) {
                    f35604w = new sr();
                }
            }
        }
        return f35604w;
    }

    public boolean w() {
        if (!this.ev) {
            this.f35606c.set(com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.ev = true;
        }
        return this.f35606c.get();
    }

    public void w(int i4) {
        c("key_net_queue_limit", i4);
        this.ux.set(i4);
    }

    public void c(boolean z3) {
        this.f35606c.set(z3);
        if (z3) {
            c("key_support_multiprocess", 1);
        }
    }

    public boolean f(int i4) {
        if (i4 <= 0) {
            return false;
        }
        return c(i4, r());
    }

    public void ux(int i4) {
        if (this.f35605a.get() == i4) {
            return;
        }
        c("_use_pl_", i4);
        this.f35605a.set(i4);
    }

    public void xv(int i4) {
        c("key_network_module", i4);
    }

    public static String w(String str) {
        String sr = c().sr();
        if (TextUtils.isEmpty(sr)) {
            return null;
        }
        return String.format("https://%s%s", sr, str);
    }

    public void sr(int i4) {
        c("key_req_build_opt", i4);
        this.gd.set(i4);
    }

    public void c(int i4) {
        c("key_req_body_opt", i4);
        this.sr.set(i4);
    }

    public void c(String str) {
        c("key_url_ads", str);
        this.f35607f = str;
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i4 = 1;
                xv(jSONObject.optInt("network_module", 1));
                c(jSONObject.optInt("if_req_body_opt", 1));
                w(jSONObject.optInt("net_queue_limit", 7));
                sr(jSONObject.optInt("req_build_opt", 0));
                c(jSONObject.optJSONObject("net_conn_conf"));
                if (!jSONObject.optBoolean("_use_pl_", false)) {
                    i4 = 0;
                }
                ux(i4);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(JSONObject jSONObject) {
        String jSONObject2 = jSONObject == null ? null : jSONObject.toString();
        if (jSONObject2 == null || this.f35608k == null || !jSONObject2.equals(this.f35608k.toString())) {
            if (this.f35608k == null && jSONObject2 == null) {
                return;
            }
            c("key_net_connpool", jSONObject2);
        }
    }

    private void c(String str, int i4) {
        try {
            if (this.f35606c.get()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", str, Integer.valueOf(i4));
                return;
            }
            if (this.f35609p == null) {
                this.f35609p = k();
            }
            SharedPreferences.Editor edit = this.f35609p.edit();
            edit.putInt(str, i4);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    private void c(String str, String str2) {
        try {
            if (this.f35606c.get()) {
                com.bytedance.sdk.component.f.xv.c.w.c("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.f35609p == null) {
                this.f35609p = k();
            }
            SharedPreferences.Editor edit = this.f35609p.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
