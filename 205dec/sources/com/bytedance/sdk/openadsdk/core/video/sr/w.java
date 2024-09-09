package com.bytedance.sdk.openadsdk.core.video.sr;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.bk;
import com.bytedance.sdk.openadsdk.core.ls.ev;
import com.bytedance.sdk.openadsdk.core.ls.p;
import com.bytedance.sdk.openadsdk.core.ls.r;
import com.bytedance.sdk.openadsdk.core.ls.xv;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.ux.xv.k;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile com.bykv.vk.openvk.component.video.api.ux.c f35238c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile com.bykv.vk.openvk.component.video.api.ux.c f35239w;

    private static boolean c(int i4) {
        return i4 == 3 || i4 == 4;
    }

    private static void sr(final sr srVar, final c.InterfaceC0336c interfaceC0336c, final me meVar) {
        srVar.f(6000);
        srVar.r(6000);
        srVar.ev(6000);
        if (meVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
                return;
            }
            if (srVar.xv() == 400) {
                xv(srVar, meVar);
                return;
            }
            w(srVar, meVar);
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        c.InterfaceC0336c interfaceC0336c2 = new c.InterfaceC0336c() { // from class: com.bytedance.sdk.openadsdk.core.video.sr.w.3
            @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
            public void c(sr srVar2, int i4) {
                c.InterfaceC0336c interfaceC0336c3 = c.InterfaceC0336c.this;
                if (interfaceC0336c3 != null) {
                    interfaceC0336c3.c(srVar2, i4);
                }
                if (meVar != null) {
                    w.c(srVar, meVar, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                a.w("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", srVar.ia());
            }

            @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
            public void w(sr srVar2, int i4) {
                c.InterfaceC0336c interfaceC0336c3 = c.InterfaceC0336c.this;
                if (interfaceC0336c3 != null) {
                    interfaceC0336c3.c(srVar2, i4);
                }
                me meVar2 = meVar;
                if (meVar2 != null) {
                    w.xv(srVar, meVar2);
                }
                a.w("VideoPreloadUtils", "pit cancel: ", srVar.ia());
            }

            @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
            public void c(sr srVar2, int i4, String str) {
                c.InterfaceC0336c interfaceC0336c3 = c.InterfaceC0336c.this;
                if (interfaceC0336c3 != null) {
                    interfaceC0336c3.c(srVar2, i4, str);
                }
                if (meVar != null) {
                    w.w(srVar, meVar, SystemClock.elapsedRealtime() - elapsedRealtime, i4, str);
                }
                a.w("VideoPreloadUtils", "pit onVideoPreloadFail: ", srVar.ia());
            }
        };
        try {
            if (srVar.s() == 0 && Build.VERSION.SDK_INT < 23) {
                com.bykv.vk.openvk.component.video.c.w.f.c.c().c(srVar);
            } else {
                w(srVar).c(ls.getContext(), srVar, interfaceC0336c2);
            }
        } catch (Exception e4) {
            if (interfaceC0336c != null) {
                a.w("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", srVar.ia());
                interfaceC0336c.c(srVar, -1, e4.getMessage());
            }
            if (meVar != null) {
                w(srVar, meVar, SystemClock.elapsedRealtime() - elapsedRealtime, -1, e4.getMessage());
            }
            e4.printStackTrace();
        }
    }

    private static com.bykv.vk.openvk.component.video.api.ux.c w(sr srVar) {
        if (srVar.s() == 1) {
            if (f35239w == null) {
                synchronized (w.class) {
                    if (f35239w == null) {
                        f35239w = new com.bytedance.sdk.component.k.w.w.c();
                    }
                }
            }
            return f35239w;
        }
        if (f35238c == null) {
            synchronized (w.class) {
                if (f35238c == null) {
                    f35238c = new com.bykv.vk.openvk.component.video.c.c.w.c();
                }
            }
        }
        return f35238c;
    }

    private static boolean w(int i4) {
        return i4 == 8 || i4 == 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(final sr srVar, final c.InterfaceC0336c interfaceC0336c, final me meVar) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            int ev = meVar != null ? wv.ev(meVar) : 0;
            boolean c4 = p.c();
            if (w(ev) && c4) {
                if (ls.c(10003) == null) {
                    a.w("pit", "is service false");
                    c(srVar, interfaceC0336c, meVar, currentTimeMillis, c4);
                    return;
                }
                xv xvVar = (xv) AutoService.c(xv.class);
                if (xvVar != null && xvVar.sr()) {
                    final JSONObject c5 = new bk().c(srVar);
                    xvVar.c("video_cache", c5, new r() { // from class: com.bytedance.sdk.openadsdk.core.video.sr.w.2
                        @Override // com.bytedance.sdk.openadsdk.core.ls.r
                        protected ValueSet c(int i4, ev evVar) {
                            com.bytedance.sdk.openadsdk.core.fz.a.c();
                            com.bytedance.sdk.openadsdk.core.fz.a.c(evVar == null ? null : evVar.xv(), c5);
                            return w.w(i4, evVar, srVar, interfaceC0336c, currentTimeMillis, meVar);
                        }
                    });
                    return;
                }
                c(srVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - currentTimeMillis);
                sr(srVar, interfaceC0336c, meVar);
                return;
            }
            a.w("pit", "is other ad");
            c(srVar, interfaceC0336c, meVar, currentTimeMillis, c4);
        } catch (Exception e4) {
            a.xv("pit predict error:" + e4.getMessage());
        }
    }

    public static void c(final sr srVar, final c.InterfaceC0336c interfaceC0336c) {
        if (srVar == null) {
            w(null, interfaceC0336c, null);
            return;
        }
        a.w("pitaya_ext_plugin", "preloadVideo " + srVar.f() + " " + srVar.bk());
        final me c4 = c(srVar);
        if (srVar.f() <= 0 && !srVar.bk()) {
            w(srVar, interfaceC0336c, c4);
        } else if (f.c()) {
            f.c(new com.bytedance.sdk.component.gd.p("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.sr.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.xv(srVar, interfaceC0336c, c4);
                }
            });
        } else {
            xv(srVar, interfaceC0336c, c4);
        }
    }

    private static void c(sr srVar, c.InterfaceC0336c interfaceC0336c, me meVar, long j4, boolean z3) {
        c(srVar, -1000, z3 ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j4);
        sr(srVar, interfaceC0336c, meVar);
    }

    private static void w(sr srVar, c.InterfaceC0336c interfaceC0336c, me meVar) {
        if (interfaceC0336c != null) {
            interfaceC0336c.c(srVar, -100);
        }
        if (meVar != null) {
            if (w(wv.ev(meVar)) || c(wv.ev(meVar))) {
                c(srVar, meVar, 0L);
            }
        }
    }

    private static void c(sr srVar, int i4, int i5, String str, JSONObject jSONObject, long j4) {
        JSONObject c4 = srVar.c();
        try {
            c4.put("pitaya_cache_size", i4);
            c4.put("pitaya_code", i5);
            c4.put("pitaya_msg", str);
            c4.put("ext_plugin_code", yu.w());
            c4.put("package", jSONObject);
            c4.put("run_task_mills", j4);
        } catch (Exception e4) {
            a.c("pit: add:" + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueSet w(int i4, ev evVar, sr srVar, c.InterfaceC0336c interfaceC0336c, long j4, me meVar) {
        String str;
        int i5;
        int i6;
        try {
        } catch (Exception e4) {
            a.c("pit: error:" + e4.getMessage());
        }
        if (evVar == null) {
            c(srVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j4);
            sr(srVar, interfaceC0336c, meVar);
            return null;
        }
        Result xv = evVar.xv();
        if (xv == null) {
            c(srVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j4);
            sr(srVar, interfaceC0336c, meVar);
            return null;
        }
        ValueSet values = xv.values();
        if (values == null) {
            c(srVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j4);
            sr(srVar, interfaceC0336c, meVar);
            return null;
        }
        JSONObject jSONObject = (JSONObject) values.objectValue(2, JSONObject.class);
        String stringValue = values.stringValue(5);
        JSONObject jSONObject2 = (JSONObject) values.objectValue(3, JSONObject.class);
        JSONObject jSONObject3 = (JSONObject) values.objectValue(4, JSONObject.class);
        if (!xv.isSuccess() || jSONObject == null) {
            str = null;
            i5 = -5;
            i6 = -1000;
        } else {
            a.c("pit task:" + jSONObject + " busi:" + stringValue);
            i6 = jSONObject.optInt("pitaya_cache_size", -1);
            int optInt = jSONObject.optInt("pitaya_code", 200);
            str = "success";
            bk.c(srVar, jSONObject, i6, optInt);
            i5 = optInt;
        }
        if (!xv.isSuccess()) {
            a.c("pit:" + jSONObject2 + " error:" + jSONObject3);
            if (jSONObject3 != null) {
                str = jSONObject3.toString();
            }
        }
        c(srVar, i6, i5, str, jSONObject2, System.currentTimeMillis() - j4);
        sr(srVar, interfaceC0336c, meVar);
        return null;
    }

    private static boolean xv(sr srVar) {
        return Build.VERSION.SDK_INT >= 23 || srVar.s() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(sr srVar, me meVar) {
        if (xv(srVar)) {
            String c4 = wv.c(meVar);
            JSONObject c5 = com.bytedance.sdk.openadsdk.ux.w.w.c(srVar, null, -1, srVar.s(), meVar);
            com.bytedance.sdk.openadsdk.ux.xv.p pVar = new com.bytedance.sdk.openadsdk.ux.xv.p(srVar.fp(), srVar.f());
            pVar.c(srVar);
            com.bytedance.sdk.openadsdk.ux.w.w.sr(new com.bytedance.sdk.openadsdk.ux.xv.w(meVar, c4, c5, pVar));
        }
    }

    public static me c(sr srVar) {
        if (srVar == null) {
            return null;
        }
        Object ux = srVar.ux("material_meta");
        if (ux instanceof me) {
            return (me) ux;
        }
        return null;
    }

    public static void c(sr srVar, me meVar, long j4) {
        if (xv(srVar)) {
            String c4 = wv.c(meVar);
            JSONObject c5 = com.bytedance.sdk.openadsdk.ux.w.w.c(srVar, null, -1, srVar.s(), meVar);
            com.bytedance.sdk.openadsdk.ux.xv.bk bkVar = new com.bytedance.sdk.openadsdk.ux.xv.bk();
            bkVar.c(srVar.fp());
            bkVar.c(srVar.f());
            bkVar.w(j4);
            bkVar.c(srVar);
            if (srVar.q() == 1) {
                bkVar.xv(1L);
            } else {
                bkVar.xv(0L);
            }
            a.w("pit", "local_cache:" + bkVar.w());
            com.bytedance.sdk.openadsdk.ux.w.w.w(new com.bytedance.sdk.openadsdk.ux.xv.w(meVar, c4, c5, bkVar));
        }
    }

    private static void w(sr srVar, me meVar) {
        if (xv(srVar)) {
            long a4 = srVar.bk() ? srVar.a() : srVar.f();
            String c4 = wv.c(meVar);
            JSONObject c5 = com.bytedance.sdk.openadsdk.ux.w.w.c(srVar, null, -1, srVar.s(), meVar);
            com.bytedance.sdk.openadsdk.ux.xv.a aVar = new com.bytedance.sdk.openadsdk.ux.xv.a(srVar.fp(), a4);
            aVar.c(srVar);
            com.bytedance.sdk.openadsdk.ux.w.w.c(new com.bytedance.sdk.openadsdk.ux.xv.w(meVar, c4, c5, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(sr srVar, me meVar, long j4, int i4, String str) {
        if (xv(srVar)) {
            String c4 = wv.c(meVar);
            JSONObject c5 = com.bytedance.sdk.openadsdk.ux.w.w.c(srVar, null, -1, srVar.s(), meVar);
            k kVar = new k();
            kVar.c(srVar.fp());
            kVar.c(srVar.f());
            kVar.w(j4);
            kVar.c(i4);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            kVar.w(str);
            kVar.xv("");
            kVar.c(srVar);
            com.bytedance.sdk.openadsdk.ux.w.w.xv(new com.bytedance.sdk.openadsdk.ux.xv.w(meVar, c4, c5, kVar));
        }
    }
}
