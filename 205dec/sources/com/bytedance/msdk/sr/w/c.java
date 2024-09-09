package com.bytedance.msdk.sr.w;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.sr.c.a;
import com.bytedance.msdk.sr.c.bk;
import com.bytedance.msdk.sr.c.p;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    private boolean ev;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28407r;
    protected com.bytedance.msdk.core.f.w xv;
    private static final com.bytedance.msdk.core.f.c sr = new com.bytedance.msdk.core.f.c();
    private static Map<String, Pair<Boolean, String>> ux = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, com.bytedance.msdk.sr.c.xv> f28405f = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicBoolean f28406c = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    protected final AtomicBoolean f28408w = new AtomicBoolean(false);

    public static void c(String str, Pair<Boolean, String> pair) {
        ux.put(str, pair);
    }

    public static com.bytedance.msdk.core.f.c sr() {
        return sr;
    }

    public static void t() {
        com.bytedance.msdk.sr.c.xv w3 = w("unity");
        if (w3 != null) {
            w3.f();
        }
    }

    public static String ux() {
        com.bytedance.msdk.core.k.c c4 = com.bytedance.msdk.core.c.w().c("pangle");
        String c5 = c4 != null ? c4.c() : null;
        return TextUtils.isEmpty(c5) ? com.bytedance.msdk.core.w.k().a() : c5;
    }

    public static c w() {
        int w3 = com.bytedance.msdk.ux.xv.c.c().w();
        if (w3 == 1) {
            return new com.bytedance.msdk.sr.w.c.c();
        }
        if (w3 == 2) {
            return new com.bytedance.msdk.sr.w.c.w();
        }
        return new c();
    }

    public static synchronized void xv() {
        synchronized (c.class) {
            com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u652f\u6301ADN\u521d\u59cb\u5316\u4fe1\u606f start ---------------------");
                    for (Map.Entry entry : c.ux.entrySet()) {
                        if (entry.getValue() != null) {
                            if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " \u521d\u59cb\u5316\u5931\u8d25 " + ((String) ((Pair) entry.getValue()).second));
                            } else if (com.bytedance.msdk.core.c.w().xv((String) entry.getKey())) {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " \u81ea\u5b9a\u4e49ADN\u8c03\u7528\u521d\u59cb\u5316\u65b9\u6cd5\u6210\u529f\uff0c\u8bf7\u5f00\u53d1\u8005\u786e\u4fdd\u63a5\u5165\u7684\u81ea\u5b9a\u4e49ADN\u521d\u59cb\u5316\u7ed3\u679c");
                            } else {
                                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " \u521d\u59cb\u5316\u6210\u529f");
                            }
                        }
                    }
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK_SDK_Init", "------------------ GroMore \u652f\u6301ADN\u521d\u59cb\u5316\u4fe1\u606f end ---------------------");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        com.bytedance.msdk.sr.c.xv w3 = w("sigmob");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bk() {
        com.bytedance.msdk.sr.c.xv w3 = w("ks");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ev() {
        com.bytedance.msdk.sr.c.xv w3 = w("baidu");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        com.bytedance.msdk.sr.c.xv w3 = w("klevin");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fp() {
        if (!this.f28407r && this.ev && this.f28406c.get() && this.f28408w.get()) {
            com.bytedance.msdk.sr.c.c();
            xv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gd() {
        com.bytedance.msdk.sr.c.xv w3 = w("pangle");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        com.bytedance.msdk.sr.c.xv w3 = w("gdt");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        com.bytedance.msdk.sr.c.xv w3 = w("admob");
        if (w3 != null) {
            w3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        com.bytedance.msdk.sr.c.xv w3 = w("mintegral");
        if (w3 != null) {
            w3.f();
        }
    }

    protected void ys() {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.core.f.w wVar;
                if (c.this.f28406c.get() && c.this.f28408w.get() && (wVar = c.this.xv) != null) {
                    wVar.c();
                }
            }
        });
    }

    public static int c() {
        return ux.size();
    }

    public static String c(Map<String, Object> map, String str) {
        return sr.c(com.bytedance.msdk.core.c.getContext(), map, str);
    }

    protected void xv(final Context context) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(context);
                c.this.w(context);
            }
        });
    }

    public static com.bytedance.msdk.api.sr.c.w.f.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sr.c(str);
    }

    public static Map<String, Object> w(Map<String, Object> map, String str) {
        return sr.w(com.bytedance.msdk.core.c.getContext(), map, str);
    }

    protected void c(Context context) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.sr.w.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.gd();
                c.this.f();
                c.this.r();
                c.this.f28406c.set(true);
                c.this.ys();
                c.this.fp();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.bytedance.msdk.adapter.sr.f.xv(runnable);
        }
    }

    protected void w(final Context context) {
        com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.ev();
                c.this.p();
                c.this.k();
                c.this.a();
                c.this.bk();
                c.t();
                com.bytedance.msdk.sr.w.c(context);
                c.this.f28408w.set(true);
                c.this.ys();
                c.this.fp();
            }
        });
    }

    private static synchronized com.bytedance.msdk.sr.c.xv w(String str) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            com.bytedance.msdk.sr.c.xv xvVar = f28405f.get(str);
            if (xvVar == null) {
                char c4 = '\uffff';
                switch (str.hashCode()) {
                    case -1128782217:
                        if (str.equals("klevin")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case -995541405:
                        if (str.equals("pangle")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -902468465:
                        if (str.equals("sigmob")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 3432:
                        if (str.equals("ks")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 102199:
                        if (str.equals("gdt")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 92668925:
                        if (str.equals("admob")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 93498907:
                        if (str.equals("baidu")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 111433589:
                        if (str.equals("unity")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                    case 1126045977:
                        if (str.equals("mintegral")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 1630528717:
                        if (str.equals("pangle_custom")) {
                            c4 = 1;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                    case 1:
                        xvVar = p.gd();
                        break;
                    case 2:
                        xvVar = new com.bytedance.msdk.sr.c.ux();
                        break;
                    case 3:
                        xvVar = new com.bytedance.msdk.sr.c.w();
                        break;
                    case 4:
                        xvVar = new com.bytedance.msdk.sr.c.r();
                        break;
                    case 5:
                        xvVar = new com.bytedance.msdk.sr.c.f();
                        break;
                    case 6:
                        xvVar = new com.bytedance.msdk.sr.c.ev();
                        break;
                    case 7:
                        xvVar = new com.bytedance.msdk.sr.c.c();
                        break;
                    case '\b':
                        xvVar = new a();
                        break;
                    case '\t':
                        xvVar = new bk();
                        break;
                }
                if (xvVar != null) {
                    f28405f.put(str, xvVar);
                }
            }
            return xvVar;
        }
    }

    public void c(Context context, boolean z3, boolean z4, com.bytedance.msdk.core.f.w wVar) {
        this.xv = wVar;
        this.f28406c.set(false);
        this.f28408w.set(false);
        this.f28407r = z3;
        this.ev = z4;
        xv(context);
    }

    public static void c(Context context, String str) {
        final com.bytedance.msdk.sr.c.xv w3;
        if (TextUtils.equals("pangle", str) || (w3 = w(str)) == null) {
            return;
        }
        if ((TextUtils.equals("mintegral", str) || TextUtils.equals("klevin", str)) && !com.bytedance.msdk.adapter.sr.f.ux()) {
            if (w3.ux()) {
                return;
            }
            com.bytedance.msdk.adapter.sr.f.w(new Runnable() { // from class: com.bytedance.msdk.sr.w.c.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.sr.c.xv.this.ev();
                }
            });
            return;
        }
        w3.ev();
    }
}
