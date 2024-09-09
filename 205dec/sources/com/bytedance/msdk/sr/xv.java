package com.bytedance.msdk.sr;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.api.sr.fp;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.c;
import com.bytedance.msdk.f.eq;
import com.bytedance.msdk.f.ev;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.k;
import com.bytedance.msdk.f.ls;
import com.bytedance.msdk.f.m;
import com.bytedance.msdk.f.pr;
import com.bytedance.msdk.xv.p;
import com.bytedance.msdk.xv.r;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: f  reason: collision with root package name */
    private static long f28434f;

    /* renamed from: r  reason: collision with root package name */
    private static k f28435r;

    /* renamed from: w  reason: collision with root package name */
    private static long f28436w;
    private static boolean xv;
    private static AtomicBoolean sr = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    static Runnable f28433c = new Runnable() { // from class: com.bytedance.msdk.sr.xv.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) f.f()).getQueue().size());
            f.c(xv.f28433c, 5000L);
        }
    };
    private static final ComponentCallbacks ux = new ComponentCallbacks() { // from class: com.bytedance.msdk.sr.xv.2
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.bytedance.msdk.core.ux.c.c.c().w();
        }
    };
    private static long ev = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (eq.c(context)) {
                        p.w();
                    } else {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {

        /* renamed from: c  reason: collision with root package name */
        public static final String f28438c = m.c() + ".openadsdk.permission.TT_PANGOLIN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        if (com.bytedance.msdk.core.c.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(m.c());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.bytedance.msdk.core.c.getContext().sendBroadcast(intent, w.f28438c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void bk() {
        try {
            com.bytedance.msdk.core.c.w().c(true);
        } catch (Throwable th) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    private static void gd() {
        com.bytedance.msdk.api.sr.c.gd.c mt;
        if (!xv || (mt = com.bytedance.msdk.core.w.k().mt()) == null) {
            return;
        }
        mt.c();
        com.bytedance.msdk.core.w.k().c((com.bytedance.msdk.api.sr.c.gd.c) null);
    }

    private static void k() {
        Application c4 = c.C0415c.c();
        if (c4 == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "AppStateListener\u6ce8\u518c\u5931\u8d25, app = null");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "AppStateListener\u6ce8\u518c\u6210\u529f");
        k kVar = f28435r;
        if (kVar != null) {
            kVar.c(c4);
        }
        k kVar2 = new k();
        f28435r = kVar2;
        kVar2.c(c4, new k.c() { // from class: com.bytedance.msdk.sr.xv.3
            @Override // com.bytedance.msdk.f.k.c
            public void c() {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- AppStateListener on foreground");
                long unused = xv.f28434f = SystemClock.elapsedRealtime();
                com.bytedance.msdk.core.w.c.xv();
            }

            @Override // com.bytedance.msdk.f.k.c
            public void w() {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- AppStateListener on background");
                if (xv.ev == -1) {
                    long unused = xv.ev = System.currentTimeMillis();
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- AppStateListener on background bgTime: " + xv.ev);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - xv.f28434f;
                r.w(elapsedRealtime);
                com.bytedance.msdk.core.w.k().w(elapsedRealtime);
                com.bytedance.msdk.xv.w.w.f28585c = true;
                com.bytedance.msdk.xv.w.w.f28586w = true;
                if (com.bytedance.msdk.xv.xv.w()) {
                    if (eq.c(com.bytedance.msdk.core.c.getContext())) {
                        p.w();
                    } else {
                        xv.a();
                    }
                }
            }
        });
        if (com.bytedance.msdk.core.w.k().bk()) {
            try {
                com.bytedance.msdk.core.c.getContext().registerReceiver(new c(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), w.f28438c, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void p() {
        Application c4 = c.C0415c.c();
        if (c4 == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "lowMemoryListener\u6ce8\u518c\u5931\u8d25, app = null");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "lowMemoryListener\u6ce8\u518c\u6210\u529f");
        ComponentCallbacks componentCallbacks = ux;
        c4.unregisterComponentCallbacks(componentCallbacks);
        c4.registerComponentCallbacks(componentCallbacks);
    }

    private static void sr(Context context) {
        if (!sr.sr()) {
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "-----==---- \u5ef6\u65f6\u4e0a\u62a5sdk_init");
            sr.w();
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TMe", "-----==---- \u6b63\u5e38\u4e0a\u62a5sdk_init");
        r.c(-1L);
    }

    private static void t() {
        com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w()).c(0);
    }

    public static void ux() {
        com.bytedance.msdk.core.c.w().c(1);
        if (!sr.get()) {
            sr();
        }
        Context context = com.bytedance.msdk.core.c.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.msdk.adapter.sr.xv.w("TNCManager_GroMore", "\u5c1d\u8bd5\u5237\u65b0TNC tryRefreshTNCConfig");
            com.bytedance.msdk.w.w.c().w().c(context, false);
        } catch (Exception unused) {
        }
    }

    private static void xv(Context context) {
        p.c(context);
        com.bytedance.msdk.xv.xv.c();
    }

    private static void ys() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (com.bytedance.msdk.core.c.w().j()) {
            w(stackTrace);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.sr.xv.4
                @Override // java.lang.Runnable
                public void run() {
                    xv.w(stackTrace);
                }
            }, 2000L);
        }
    }

    public static boolean w() {
        return xv;
    }

    public static long c() {
        return f28436w;
    }

    private static void w(Context context) {
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        c(true);
        f28436w = SystemClock.elapsedRealtime();
        k();
        p();
        pr.c();
        sr.c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        ls.p(context);
        ev.c().xv();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bg_ts", ev);
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- init bg_ts: " + ev);
            jSONObject.put("pre_time", elapsedRealtime - f28436w);
        } catch (Throwable unused) {
        }
        bk();
        try {
            jSONObject.put("cfg_time", SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Throwable unused2) {
        }
        xv(context);
        com.bytedance.msdk.core.c.w().c(true, jSONObject);
        t();
        sr(context);
        ys();
        if (com.bytedance.msdk.adapter.sr.xv.w()) {
            f.c(f28433c);
        }
    }

    public static String xv() {
        try {
            com.bytedance.msdk.adapter.c.xv c4 = com.bytedance.msdk.sr.w.w.c().c("pangle");
            return c4 != null ? c4.xv() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void c(boolean z3) {
        xv = z3;
        gd();
    }

    public static void c(@NonNull com.bytedance.msdk.api.sr.c cVar, Context context) {
        c(context);
        c(cVar);
        w(context);
    }

    public static void sr() {
        Context context;
        if (sr.get()) {
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TNCManager_GroMore", "\u521d\u59cb\u5316TNC initTTAdNetTNC\uff1asupportTNC\uff1a" + com.bytedance.msdk.core.c.w().gb());
        if (com.bytedance.msdk.core.c.w().gb() && (context = com.bytedance.msdk.core.c.getContext()) != null) {
            try {
                com.bytedance.msdk.w.w.c().w().c(context, true, new com.bytedance.msdk.w.c(context));
            } catch (Exception unused) {
            }
            sr.set(true);
        }
    }

    @SuppressLint({"WrongConstant"})
    private static void c(com.bytedance.msdk.api.sr.c cVar) {
        com.bytedance.msdk.core.w.k().c(cVar.fp());
        com.bytedance.msdk.core.w.k().c(System.currentTimeMillis());
        com.bytedance.msdk.core.w.k().xv(cVar.c());
        com.bytedance.msdk.core.w.k().f(cVar.w());
        com.bytedance.msdk.core.w.k().xv(cVar.ia());
        com.bytedance.msdk.core.w.k().ux(cVar.f().xv());
        com.bytedance.msdk.core.w.k().f(cVar.f().sr());
        com.bytedance.msdk.core.w.k().c(cVar.f().w());
        com.bytedance.msdk.core.w.k().c(cVar.f().ux());
        com.bytedance.msdk.core.w.k().c(cVar.f().r());
        com.bytedance.msdk.core.w.k().r(cVar.f().f());
        com.bytedance.msdk.core.w.k().sr(cVar.f().c());
        com.bytedance.msdk.core.w.k().sr(cVar.sr());
        com.bytedance.msdk.core.w.k().w(cVar.ux());
        com.bytedance.msdk.core.w.k().ux(cVar.f().ev());
        com.bytedance.msdk.core.w.k().c(cVar.f().gd());
        com.bytedance.msdk.core.w.k().c(cVar.gd(), true);
        com.bytedance.msdk.core.w.k().r(cVar.f().p());
        com.bytedance.msdk.core.w.k().w(cVar.p());
        com.bytedance.msdk.core.w.k().xv(cVar.ys());
        com.bytedance.msdk.core.w.k().ev(cVar.k());
        com.bytedance.msdk.core.w.k().gd(cVar.a());
        com.bytedance.msdk.core.w.k().c(cVar.bk());
        com.bytedance.msdk.core.w.k().p(cVar.r().w());
        com.bytedance.msdk.core.w.k().ev(cVar.r().c());
        com.bytedance.msdk.core.w.k().k(cVar.r().xv());
        com.bytedance.msdk.core.w.k().a(cVar.r().sr());
        if (cVar.ys() != null) {
            try {
                com.bytedance.msdk.core.w.k().c((List) cVar.ys().get("primeRitList"));
            } catch (Throwable unused) {
            }
        }
        if (cVar.ev() != null) {
            com.bytedance.msdk.core.w.k().w(cVar.ev().c());
        }
        c(cVar.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(StackTraceElement[] stackTraceElementArr) {
        if (com.bytedance.msdk.core.c.w().ck()) {
            Map<String, String> z3 = com.bytedance.msdk.core.c.w().z();
            r.c((ux) null, (com.bytedance.msdk.api.c.w) null, i.c(stackTraceElementArr), 1);
            r.c(i.c(z3));
        }
    }

    public static void c(ValueSet valueSet) {
        for (com.bytedance.msdk.adapter.c.xv xvVar : com.bytedance.msdk.sr.w.w.c().xv()) {
            if (xvVar != null) {
                try {
                    xvVar.c(com.bytedance.msdk.core.w.k().y(), valueSet);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void c(fp fpVar) {
        try {
            com.bytedance.msdk.adapter.c.xv c4 = com.bytedance.msdk.sr.w.w.c().c("pangle");
            if (c4 != null) {
                c4.c(fpVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        if (context != null) {
            com.bytedance.msdk.core.c.c(context);
        }
    }
}
