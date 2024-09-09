package com.bytedance.msdk.sr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.f.ls;
import com.bytedance.msdk.f.wv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static Context f28395c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile c f28396w;
    private static volatile c xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: f  reason: collision with root package name */
        private final int f28398f;

        /* renamed from: p  reason: collision with root package name */
        private Map<String, Object> f28399p;

        /* renamed from: r  reason: collision with root package name */
        private final JSONObject f28400r;
        private final long sr;
        private final int ux;
        private final String xv;

        /* renamed from: w  reason: collision with root package name */
        private volatile boolean f28401w = false;
        private int gd = 0;
        private final long ev = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        private final Handler f28397c = new Handler(Looper.getMainLooper());

        public c(String str, long j4, int i4, int i5, JSONObject jSONObject, Map<String, Object> map) {
            this.xv = str;
            this.sr = j4;
            this.ux = i4;
            this.f28398f = i5;
            this.f28400r = jSONObject;
            this.f28399p = map;
        }

        static /* synthetic */ int xv(c cVar) {
            int i4 = cVar.gd;
            cVar.gd = i4 + 1;
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f28397c.postDelayed(new Runnable() { // from class: com.bytedance.msdk.sr.sr.c.1
                @Override // java.lang.Runnable
                public void run() {
                    sr.w(ls.c(com.bytedance.msdk.core.c.getContext()));
                    c.xv(c.this);
                    if (c.this.gd >= 5 || sr.sr()) {
                        c.this.c(1);
                        return;
                    }
                    com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- \u91cd\u8bd5\u4e00\u6b21 eventType:" + c.this.xv + ", \u91cd\u8bd5\u6b21\u6570\uff1a" + c.this.gd);
                    c.this.c();
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
            if (r1 == 1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
            com.bytedance.msdk.xv.r.c(r10.sr, r10.ux, r10.f28398f, r10.ev, r10.f28400r, r10.f28399p);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void c(int r11) {
            /*
                r10 = this;
                monitor-enter(r10)
                android.os.Handler r0 = r10.f28397c     // Catch: java.lang.Throwable -> La9
                r1 = 0
                r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> La9
                boolean r0 = r10.f28401w     // Catch: java.lang.Throwable -> La9
                if (r0 == 0) goto Ld
                monitor-exit(r10)
                return
            Ld:
                r0 = 1
                r10.f28401w = r0     // Catch: java.lang.Throwable -> La9
                if (r11 != r0) goto L41
                java.lang.String r11 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La9
                r1.<init>()     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = "--==-- \u6700\u7ec8\u4e0a\u62a5\uff1aeventType:"
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = r10.xv     // Catch: java.lang.Throwable -> La9
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = ", \u91cd\u8bd5\u6b21\u6570\uff1a"
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                int r2 = r10.gd     // Catch: java.lang.Throwable -> La9
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = ", did: "
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = com.bytedance.msdk.sr.sr.ux()     // Catch: java.lang.Throwable -> La9
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La9
                com.bytedance.msdk.adapter.sr.xv.c(r11, r1)     // Catch: java.lang.Throwable -> La9
                goto L68
            L41:
                r1 = 2
                if (r11 != r1) goto L68
                java.lang.String r11 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La9
                r1.<init>()     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = "--==-- \u6700\u7ec8\u4e0a\u62a5\uff1aeventType:"
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = r10.xv     // Catch: java.lang.Throwable -> La9
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = ", \u4eceapplog\u56de\u8c03\u4e2d\u4e0a\u62a5, did: "
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r2 = com.bytedance.msdk.sr.sr.ux()     // Catch: java.lang.Throwable -> La9
                r1.append(r2)     // Catch: java.lang.Throwable -> La9
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La9
                com.bytedance.msdk.adapter.sr.xv.c(r11, r1)     // Catch: java.lang.Throwable -> La9
            L68:
                java.lang.String r11 = r10.xv     // Catch: java.lang.Throwable -> La9
                r1 = -1
                int r2 = r11.hashCode()     // Catch: java.lang.Throwable -> La9
                r3 = -834688111(0xffffffffce3fab91, float:-8.03923E8)
                if (r2 == r3) goto L84
                r3 = 270071285(0x1018f5f5, float:3.0166193E-29)
                if (r2 == r3) goto L7a
                goto L8d
            L7a:
                java.lang.String r2 = "sdk_init"
                boolean r11 = r11.equals(r2)     // Catch: java.lang.Throwable -> La9
                if (r11 == 0) goto L8d
                r1 = 0
                goto L8d
            L84:
                java.lang.String r2 = "sdk_init_end"
                boolean r11 = r11.equals(r2)     // Catch: java.lang.Throwable -> La9
                if (r11 == 0) goto L8d
                r1 = 1
            L8d:
                if (r1 == 0) goto La2
                if (r1 == r0) goto L92
                goto La7
            L92:
                long r2 = r10.sr     // Catch: java.lang.Throwable -> La9
                int r4 = r10.ux     // Catch: java.lang.Throwable -> La9
                int r5 = r10.f28398f     // Catch: java.lang.Throwable -> La9
                long r6 = r10.ev     // Catch: java.lang.Throwable -> La9
                org.json.JSONObject r8 = r10.f28400r     // Catch: java.lang.Throwable -> La9
                java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f28399p     // Catch: java.lang.Throwable -> La9
                com.bytedance.msdk.xv.r.c(r2, r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> La9
                goto La7
            La2:
                long r0 = r10.ev     // Catch: java.lang.Throwable -> La9
                com.bytedance.msdk.xv.r.c(r0)     // Catch: java.lang.Throwable -> La9
            La7:
                monitor-exit(r10)
                return
            La9:
                r11 = move-exception
                monitor-exit(r10)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.sr.sr.c.c(int):void");
        }
    }

    private static Context f() {
        Context context = f28395c;
        return context != null ? context : com.bytedance.msdk.core.c.getContext();
    }

    private static String r() {
        return wv.c("tt_device_info", f()).w("did", "");
    }

    public static boolean sr() {
        return !TextUtils.isEmpty(wv.c("tt_device_info", f()).w("did", ""));
    }

    static /* synthetic */ String ux() {
        return r();
    }

    public static void w() {
        f28396w = new c("sdk_init", 0L, 0, 0, null, null);
        f28396w.c();
    }

    public static synchronized void xv() {
        synchronized (sr.class) {
            if (xv == null) {
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- sdkInitEnd\u57cb\u70b9\u8fd8\u672a\u4ea7\u751f\uff0capplog\u56de\u8c03\u5df2\u89e6\u53d1\uff0c\u76f4\u63a5return");
            } else if (xv != null && xv.f28401w) {
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- applog\u56de\u8c03\u89e6\u53d1\u65f6\uff0csdkInitEnd\u57cb\u70b9\u5df2\u7ecf\u4e0a\u62a5\uff0c\u76f4\u63a5return");
                xv = null;
            } else {
                if (xv != null) {
                    xv.c(2);
                }
                xv = null;
            }
        }
    }

    public static void c(Context context) {
        f28395c = context;
    }

    public static synchronized void c() {
        synchronized (sr.class) {
            if (f28396w == null) {
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- sdkInit\u57cb\u70b9\u8fd8\u672a\u4ea7\u751f\uff0capplog\u56de\u8c03\u5df2\u89e6\u53d1\uff0c\u76f4\u63a5return");
            } else if (f28396w != null && f28396w.f28401w) {
                com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==-- applog\u56de\u8c03\u89e6\u53d1\u65f6\uff0csdkInit\u57cb\u70b9\u5df2\u7ecf\u4e0a\u62a5\uff0c\u76f4\u63a5return");
                f28396w = null;
            } else {
                if (f28396w != null) {
                    f28396w.c(2);
                }
                f28396w = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        wv.c("tt_device_info", f()).c("did", str);
    }

    public static void c(long j4, int i4, int i5, JSONObject jSONObject, Map<String, Object> map) {
        xv = new c("sdk_init_end", j4, i4, i5, jSONObject, map);
        xv.c();
    }
}
