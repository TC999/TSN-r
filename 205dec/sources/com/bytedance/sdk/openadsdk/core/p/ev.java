package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {
    private static void w(final me meVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.eq.c xv;
        if (c(meVar) || (xv = k.sr().xv()) == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        xv.c(new c.InterfaceC0491c() { // from class: com.bytedance.sdk.openadsdk.core.p.ev.1
            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void c() {
                if (!xk.c()) {
                    a.w("TTDownload-Util", "\u9501\u5c4f\u4e0d\u6267\u884c\u81ea\u542f\u52a8\u8c03\u8d77");
                    com.bytedance.sdk.openadsdk.core.eq.c cVar = com.bytedance.sdk.openadsdk.core.eq.c.this;
                    if (cVar != null) {
                        cVar.w();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.t.c.c(str)) {
                    ev.w(meVar, currentTimeMillis, com.bytedance.sdk.openadsdk.core.eq.c.this, str);
                }
                com.bytedance.sdk.openadsdk.core.eq.c cVar2 = com.bytedance.sdk.openadsdk.core.eq.c.this;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void f() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void sr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void ux() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void xv() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(me meVar, String str) {
        if (meVar != null && wv.c(ls.getContext(), str)) {
            a.w("TTDownload-Util", "\u901a\u8fc7\u5305\u540d\u8c03\u8d77 " + str);
        }
    }

    public static void c(String str, me meVar) {
        boolean ux;
        try {
            if (ls.getContext() == null || TextUtils.isEmpty(str) || !(ux = ia.ux(meVar))) {
                return;
            }
            ys qu = meVar.qu();
            if (qu != null && !TextUtils.isEmpty(qu.c())) {
                a.f("TTDownload-Util", "\u542b\u6709deepLink");
                if (ia.w(meVar) != 0) {
                    a.f("TTDownload-Util", "deepLink\u8fc7\u6ee4 DownConfig.getDownConfigAutoOpen(materialMeta) " + ia.w(meVar));
                    return;
                }
            }
            if (ux) {
                if (com.bytedance.sdk.openadsdk.t.c.c(str)) {
                    a.f("TTDownload-Util", "\u8be5app\u5df2\u88ab\u6fc0\u6d3b pkgName " + str);
                } else if (!ia.f(meVar)) {
                    w(meVar, str);
                } else {
                    c(ls.getContext(), meVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(final com.bytedance.sdk.openadsdk.core.eq.c cVar, final me meVar, String str, String str2, final String str3) {
        if (cVar == null) {
            return;
        }
        if (!wv.xv(ls.getContext(), str3)) {
            a.w("TTDownload-Util", "\u8be5app\u672a\u5b89\u88c5 packageName " + str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String jr = meVar.jr();
        com.bytedance.sdk.openadsdk.core.eq.f.c(ls.getContext(), jr, str, str2, "\u7acb\u5373\u6253\u5f00", "\u9000\u51fa", new f.c() { // from class: com.bytedance.sdk.openadsdk.core.p.ev.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                ev.xv(me.this, str3);
                com.bytedance.sdk.openadsdk.core.eq.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                com.bytedance.sdk.openadsdk.core.eq.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                com.bytedance.sdk.openadsdk.core.eq.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }
        });
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT >= 23) {
            return com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(me meVar, long j4, com.bytedance.sdk.openadsdk.core.eq.c cVar, String str) {
        if (meVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j4 >= ia.r(meVar) * 1000) {
            String xv = meVar.ix() != null ? meVar.ix().xv() : "";
            w(cVar, meVar, xv, TextUtils.isEmpty(xv) ? "\u5e94\u7528\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00 \uff1f" : "\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00 \uff1f", str);
            return;
        }
        xv(meVar, str);
    }

    private static void c(Context context, final me meVar, final String str) {
        if (context == null || meVar == null || c(meVar)) {
            return;
        }
        final String xv = meVar.ix() != null ? meVar.ix().xv() : "";
        final String str2 = TextUtils.isEmpty(xv) ? "\u5e94\u7528\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00 \uff1f" : "\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u7acb\u5373\u6253\u5f00 \uff1f";
        final com.bytedance.sdk.openadsdk.core.eq.c xv2 = k.sr().xv();
        if (xv2 == null) {
            return;
        }
        xv2.c(new c.InterfaceC0491c() { // from class: com.bytedance.sdk.openadsdk.core.p.ev.2
            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void c() {
                try {
                    if (!xk.c()) {
                        a.w("TTDownload-Util", "\u9501\u5c4f\u4e0d\u6267\u884c\u81ea\u542f\u52a8\u8c03\u8d77");
                        com.bytedance.sdk.openadsdk.core.eq.c cVar = com.bytedance.sdk.openadsdk.core.eq.c.this;
                        if (cVar != null) {
                            cVar.w();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.t.c.c(str)) {
                        ev.w(com.bytedance.sdk.openadsdk.core.eq.c.this, meVar, xv, str2, str);
                    }
                    com.bytedance.sdk.openadsdk.core.eq.c cVar2 = com.bytedance.sdk.openadsdk.core.eq.c.this;
                    if (cVar2 != null) {
                        cVar2.w();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void f() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void sr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void ux() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void xv() {
            }
        });
    }

    private static boolean c(me meVar) {
        if (meVar != null && c(c())) {
            int v3 = meVar.v();
            String ib = meVar.ib();
            com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
            if ((TextUtils.isEmpty(ib) || v3 != 4) && !c4.w("is_landing_page_open_market", false)) {
                return false;
            }
            c4.c("is_landing_page_open_market", false);
            return true;
        }
        return false;
    }

    public static JSONObject c() {
        com.bytedance.sdk.openadsdk.core.z.r w3 = ls.w();
        if (w3 != null && w3.m() != null) {
            return w3.m();
        }
        return new JSONObject();
    }

    private static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0021, B:10:0x0027, B:12:0x0033, B:14:0x003f, B:15:0x0043, B:17:0x0049, B:18:0x005f, B:20:0x0065, B:22:0x006a), top: B:25:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0021, B:10:0x0027, B:12:0x0033, B:14:0x003f, B:15:0x0043, B:17:0x0049, B:18:0x005f, B:20:0x0065, B:22:0x006a), top: B:25:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            boolean r4 = w()     // Catch: java.lang.Throwable -> L81
            if (r4 != 0) goto L20
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L81
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.ls.getContext()     // Catch: java.lang.Throwable -> L81
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.w.w(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L81
            r4.<init>(r1, r2)     // Catch: java.lang.Throwable -> L81
            r4.mkdirs()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Throwable -> L81
            goto L21
        L20:
            r4 = r0
        L21:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L5f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.n.xv.c()     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L43
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.ls.getContext()     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L81
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.w.c(r1, r2)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L43
            java.lang.String r4 = r1.getPath()     // Catch: java.lang.Throwable -> L81
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L5f
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.ls.getContext()     // Catch: java.lang.Throwable -> L81
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(r4)     // Catch: java.lang.Throwable -> L81
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L81
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L81
            r1.mkdirs()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r1.getPath()     // Catch: java.lang.Throwable -> L81
        L5f:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L81
            if (r1 != 0) goto L69
            com.bytedance.sdk.openadsdk.core.eq.p.c()     // Catch: java.lang.Throwable -> L81
            goto L6a
        L69:
            r4 = r0
        L6a:
            java.lang.String r1 = "TTDownload-Util"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "path: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L81
            r2.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L81
            com.bytedance.sdk.component.utils.a.w(r1, r2)     // Catch: java.lang.Throwable -> L81
            return r4
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p.ev.c(boolean):java.lang.String");
    }

    public static void c(Runnable runnable, me meVar) {
        if (meVar == null || runnable == null) {
            return;
        }
        if (ia.ys(meVar)) {
            com.bytedance.sdk.openadsdk.n.f.c((Runnable) new p("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.p.ev.4
                @Override // java.lang.Runnable
                public void run() {
                    Toast makeText = Toast.makeText(ls.getContext(), "", 1);
                    makeText.setText("\u5373\u5c06\u8df3\u8f6c\u5230\u5e94\u7528\u5546\u5e97...");
                    makeText.show();
                }
            });
            q.f().postDelayed(runnable, 500L);
            return;
        }
        com.bytedance.sdk.openadsdk.n.f.c(runnable);
    }
}
