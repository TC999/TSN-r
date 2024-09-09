package com.bytedance.sdk.openadsdk.core.xv;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements c.w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f35634c;

    /* renamed from: w  reason: collision with root package name */
    private static long f35635w;
    private static boolean xv;

    public static void f() {
        try {
            com.bytedance.sdk.openadsdk.core.eq.c xv2 = k.sr().xv();
            if (xv2 != null) {
                xv2.w(xv());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean sr() {
        JSONObject ev = sr.c().ev();
        return (ev == null ? 0 : ev.optInt("klive_conf", 0)) == 1;
    }

    public static void ux() {
        com.bytedance.sdk.openadsdk.core.eq.c xv2;
        try {
            if (sr.c().f() == 1 && (xv2 = k.sr().xv()) != null) {
                xv2.c(xv());
            }
        } catch (Exception unused) {
        }
    }

    public static xv xv() {
        if (f35634c == null) {
            synchronized (xv.class) {
                if (f35634c == null) {
                    f35634c = new xv();
                }
            }
        }
        return f35634c;
    }

    public static void c(final int i4) {
        final String w3 = sr.w("/api/ad/union/ping");
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        f35635w = System.currentTimeMillis();
        com.bytedance.sdk.component.ev.w.w xv2 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
        xv2.c(w3);
        xv2.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.xv.xv.1
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (i4 == 0) {
                    xv.xv(w3);
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                if (i4 == 0) {
                    xv.xv(w3);
                }
            }
        });
        if (i4 == 0 && sr()) {
            ux();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, int i4, long j4, int i5) {
        if (ys.xv(ls.getContext()) == 0 || com.bytedance.sdk.openadsdk.core.q.ux.c().w().c(str, false)) {
            return;
        }
        c(i4 == 1 ? "connect_regular_time" : "connect_regular_point", j4, i5 + 1);
        c(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void w() {
        try {
            if (k.sr().ia()) {
                f();
                return;
            }
            xv = false;
            c(2, sr.w("/api/ad/union/ping"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(final String str) {
        ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xv.xv.2
            @Override // java.lang.Runnable
            public void run() {
                if (xv.xv) {
                    xv.xv(str);
                } else {
                    xv.c(1, str);
                }
            }
        }, 90000L);
    }

    public static void c(int i4, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (sr() && sr.c().f() == 1) {
                if (i4 == 1) {
                    c(i4, str, c("connect_regular_time"));
                }
                if (i4 == 2) {
                    c(i4, str, c("connect_regular_point"));
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:2:0x0000, B:4:0x0009, B:9:0x0026, B:20:0x0047, B:24:0x004f, B:29:0x005c, B:32:0x006f, B:30:0x006a), top: B:35:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:2:0x0000, B:4:0x0009, B:9:0x0026, B:20:0x0047, B:24:0x004f, B:29:0x005c, B:32:0x006f, B:30:0x006a), top: B:35:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #0 {Exception -> 0x0072, blocks: (B:2:0x0000, B:4:0x0009, B:9:0x0026, B:20:0x0047, B:24:0x004f, B:29:0x005c, B:32:0x006f, B:30:0x006a), top: B:35:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(final int r13, final java.lang.String r14, org.json.JSONObject r15) {
        /*
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L72
            r2 = 2
            r3 = 1
            r4 = 0
            if (r15 == 0) goto L58
            java.lang.String r0 = "time"
            long r0 = r15.getLong(r0)     // Catch: java.lang.Exception -> L72
            java.lang.String r5 = "value"
            int r15 = r15.getInt(r5)     // Catch: java.lang.Exception -> L72
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L72
            long r5 = r5 - r0
            r7 = 60000(0xea60, double:2.9644E-319)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L23
            r7 = 1
            goto L24
        L23:
            r7 = 0
        L24:
            if (r13 != r3) goto L36
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L72
            long r10 = com.bytedance.sdk.openadsdk.core.xv.xv.f35635w     // Catch: java.lang.Exception -> L72
            long r8 = r8 - r10
            r10 = 360000(0x57e40, double:1.778636E-318)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 < 0) goto L36
            r8 = 1
            goto L37
        L36:
            r8 = 0
        L37:
            if (r7 != 0) goto L57
            if (r8 == 0) goto L3c
            goto L57
        L3c:
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L4b
            if (r15 < r2) goto L4b
            if (r13 != r2) goto L4a
            f()     // Catch: java.lang.Exception -> L72
        L4a:
            return
        L4b:
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L54
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L72
            goto L58
        L54:
            r11 = r15
            r9 = r0
            goto L5a
        L57:
            return
        L58:
            r9 = r0
            r11 = 0
        L5a:
            if (r13 != r2) goto L6a
            com.bytedance.sdk.openadsdk.core.xv.xv$3 r15 = new com.bytedance.sdk.openadsdk.core.xv.xv$3     // Catch: java.lang.Exception -> L72
            java.lang.String r6 = "bpreconn"
            r5 = r15
            r7 = r14
            r8 = r13
            r5.<init>(r6)     // Catch: java.lang.Exception -> L72
            com.bytedance.sdk.component.gd.ev.w(r15)     // Catch: java.lang.Exception -> L72
            goto L6d
        L6a:
            w(r14, r13, r9, r11)     // Catch: java.lang.Exception -> L72
        L6d:
            if (r13 != r3) goto L72
            xv(r14)     // Catch: java.lang.Exception -> L72
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.xv.xv.c(int, java.lang.String, org.json.JSONObject):void");
    }

    public static void c(String str, long j4, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", i4);
            jSONObject.put("time", j4);
            k.w.f33845c.c(str, jSONObject.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static JSONObject c(String str) {
        try {
            String w3 = k.w.f33845c.w(str, "");
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            return new JSONObject(w3);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void c() {
        xv = true;
    }
}
