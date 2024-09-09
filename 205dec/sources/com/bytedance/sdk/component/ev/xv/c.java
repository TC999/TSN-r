package com.bytedance.sdk.component.ev.xv;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.ev.c;
import com.bytedance.sdk.component.gd.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.s;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements n.c {
    private static boolean ev;
    private static ThreadPoolExecutor gd;
    private com.bytedance.sdk.component.ev.c bk;

    /* renamed from: k  reason: collision with root package name */
    private final Context f29754k;

    /* renamed from: t  reason: collision with root package name */
    private int f29757t;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f29758w;
    private volatile boolean xv = false;
    private boolean sr = true;
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private long f29753f = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f29756r = 0;

    /* renamed from: p  reason: collision with root package name */
    private AtomicBoolean f29755p = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f29751a = false;

    /* renamed from: c  reason: collision with root package name */
    final n f29752c = com.bytedance.sdk.component.gd.w.c.c().c(this, "tt-net");

    public c(Context context, int i4) {
        this.f29754k = context;
        this.f29758w = s.c(context);
        this.f29757t = i4;
    }

    private boolean ev() {
        String[] f4 = f();
        if (f4 != null && f4.length != 0) {
            c(0);
        }
        return false;
    }

    private com.bytedance.sdk.component.ev.c gd() {
        if (this.bk == null) {
            c.C0445c c0445c = new c.C0445c();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.bk = c0445c.c(10L, timeUnit).w(10L, timeUnit).xv(10L, timeUnit).c();
        }
        return this.bk;
    }

    public static ThreadPoolExecutor r() {
        if (gd == null) {
            synchronized (c.class) {
                if (gd == null) {
                    com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k("tnc/AppConfig"));
                    gd = srVar;
                    srVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return gd;
    }

    private void sr(boolean z3) {
        if (this.ux) {
            return;
        }
        if (this.sr) {
            this.sr = false;
            this.f29753f = 0L;
            this.f29756r = 0L;
        }
        long j4 = z3 ? 360000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f29753f > j4) {
            if (currentTimeMillis - this.f29756r > PolicyConfig.THREAD_BLOCK_TIMEOUT || !this.f29751a) {
                xv();
            }
        }
    }

    public String[] f() {
        String[] f4 = r.c().c(this.f29757t).sr() != null ? r.c().c(this.f29757t).sr().f() : null;
        return (f4 == null || f4.length <= 0) ? new String[0] : f4;
    }

    public Context getContext() {
        return this.f29754k;
    }

    public void ux() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.f29758w) {
                sr();
            } else {
                w();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean xv() {
        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doRefresh: updating state " + this.f29755p.get());
        r().execute(new Runnable() { // from class: com.bytedance.sdk.component.ev.xv.c.2
            @Override // java.lang.Runnable
            public void run() {
                boolean c4 = com.bytedance.sdk.component.ev.sr.f.c(c.this.f29754k);
                if (c4) {
                    c.this.f29756r = System.currentTimeMillis();
                    if (!c.this.f29755p.compareAndSet(false, true)) {
                        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doRefresh, already running");
                    } else {
                        c.this.xv(c4);
                    }
                }
            }
        });
        return true;
    }

    public static void w(boolean z3) {
        ev = z3;
    }

    void xv(boolean z3) {
        com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doRefresh, actual request");
        sr();
        this.ux = true;
        if (!z3) {
            this.f29752c.sendEmptyMessage(102);
            return;
        }
        try {
            ev();
        } catch (Exception unused) {
            this.f29755p.set(false);
        }
    }

    synchronized void w() {
        if (System.currentTimeMillis() - this.f29753f > 3600000) {
            this.f29753f = System.currentTimeMillis();
            try {
                if (r.c().c(this.f29757t).ev() != null) {
                    r.c().c(this.f29757t).ev().w();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        c(false);
    }

    public synchronized void c(boolean z3) {
        if (this.f29758w) {
            sr(z3);
        } else if (this.f29753f <= 0) {
            try {
                r().execute(new Runnable() { // from class: com.bytedance.sdk.component.ev.xv.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.w();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4) {
        n nVar = this.f29752c;
        if (nVar != null) {
            nVar.sendEmptyMessage(i4);
        }
    }

    public synchronized void sr() {
        if (this.f29751a) {
            return;
        }
        this.f29751a = true;
        long j4 = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29754k, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j4 > currentTimeMillis) {
            j4 = currentTimeMillis;
        }
        this.f29753f = j4;
        try {
            if (r.c().c(this.f29757t).ev() != null) {
                r.c().c(this.f29757t).ev().c();
            }
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, int i4) {
        c c4;
        if (ev && (c4 = r.c().c(i4, context)) != null) {
            if (s.c(context)) {
                c4.c(true);
            } else {
                c4.c();
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        if (i4 == 101) {
            this.ux = false;
            this.f29753f = System.currentTimeMillis();
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doRefresh, succ");
            if (this.sr) {
                c();
            }
            this.f29755p.set(false);
        } else if (i4 != 102) {
        } else {
            this.ux = false;
            if (this.sr) {
                c();
            }
            com.bytedance.sdk.component.ev.sr.xv.xv("TNCManager", "doRefresh, error");
            this.f29755p.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f29754k, "ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (r.c().c(this.f29757t).ev() != null) {
            r.c().c(this.f29757t).ev().c(jSONObject2);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i4) {
        String[] f4 = f();
        if (f4 != null && f4.length > i4) {
            String str = f4[i4];
            if (TextUtils.isEmpty(str)) {
                w(102);
                return;
            }
            try {
                String c4 = c(str);
                if (TextUtils.isEmpty(c4)) {
                    w(102);
                    return;
                }
                com.bytedance.sdk.component.ev.w.w xv = gd().xv();
                xv.c(c4);
                c(xv);
                xv.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.component.ev.xv.c.3
                    @Override // com.bytedance.sdk.component.ev.c.c
                    public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                        JSONObject jSONObject;
                        if (wVar != null && wVar.ev()) {
                            String str2 = null;
                            try {
                                jSONObject = new JSONObject(wVar.sr());
                            } catch (Exception unused) {
                                jSONObject = null;
                            }
                            if (jSONObject == null) {
                                c.this.c(i4 + 1);
                                return;
                            }
                            try {
                                str2 = jSONObject.getString("message");
                            } catch (Exception unused2) {
                            }
                            if (!"success".equals(str2)) {
                                c.this.c(i4 + 1);
                                return;
                            }
                            try {
                                if (c.this.c(jSONObject)) {
                                    c.this.w(101);
                                } else {
                                    c.this.c(i4 + 1);
                                }
                                return;
                            } catch (Exception unused3) {
                                return;
                            }
                        }
                        c.this.c(i4 + 1);
                    }

                    @Override // com.bytedance.sdk.component.ev.c.c
                    public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                        c.this.c(i4 + 1);
                    }
                });
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.ev.sr.xv.xv("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        w(102);
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JPushConstants.HTTPS_PRE + str + "/get_domains/v4/";
    }

    private void c(com.bytedance.sdk.component.ev.w.w wVar) {
        String str;
        if (wVar == null) {
            return;
        }
        Address c4 = r.c().c(this.f29757t).sr() != null ? r.c().c(this.f29757t).sr().c(this.f29754k) : null;
        if (c4 != null && c4.hasLatitude() && c4.hasLongitude()) {
            wVar.c("latitude", c4.getLatitude() + "");
            wVar.c("longitude", c4.getLongitude() + "");
            String locality = c4.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                wVar.c("city", Uri.encode(locality));
            }
        }
        if (this.xv) {
            wVar.c("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            wVar.c("abi", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (r.c().c(this.f29757t).sr() != null) {
            wVar.c("aid", r.c().c(this.f29757t).sr().c() + "");
            wVar.c("device_platform", r.c().c(this.f29757t).sr().xv());
            wVar.c("channel", r.c().c(this.f29757t).sr().w());
            wVar.c("version_code", r.c().c(this.f29757t).sr().sr() + "");
            wVar.c("custom_info_1", r.c().c(this.f29757t).sr().ux());
        }
    }

    public static void c(ThreadPoolExecutor threadPoolExecutor) {
        gd = threadPoolExecutor;
    }
}
