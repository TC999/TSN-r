package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.vc;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {
    public static void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final boolean z3, final long j4, final long j5) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().r(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.p.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                int i4 = z3 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i4));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j5));
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(4).xv(wVar.f()).w((int) j4).w(jSONObject.toString());
            }
        });
    }

    public static int w(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        if (cVar != null) {
            return cVar.c();
        }
        return 0;
    }

    public static void c(long j4, boolean z3, boolean z4, me meVar, long j5, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
        String str2 = z3 ? z4 ? "load_video_success" : "load_video_error" : z4 ? "download_video_image_success" : "download_video_image_fail";
        if (z3) {
            Map<String, Object> c4 = wv.c(z4, meVar, elapsedRealtime, j5, str);
            c4.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.a.xv.ux(meVar, "splash_ad", str2, c4);
            return;
        }
        Map<String, Object> w3 = wv.w(z4, meVar, elapsedRealtime, j5, str);
        w3.put("splash_show_type", 2);
        com.bytedance.sdk.openadsdk.core.a.xv.sr(meVar, "splash_ad", str2, w3);
    }

    public static boolean w(me meVar) {
        if (meVar == null || meVar.b() == 1 || ng.bk(meVar) == null || TextUtils.isEmpty(ng.c(meVar))) {
            return true;
        }
        meVar.r(true);
        return false;
    }

    public static void c(xv xvVar, com.bytedance.sdk.openadsdk.core.u.c cVar) {
        com.bykv.vk.openvk.component.video.api.xv.sr c4;
        if (c(cVar)) {
            me meVar = cVar.w().get(0);
            int gd = wv.gd(meVar);
            com.bykv.vk.openvk.component.video.api.xv.xv bk = ng.bk(meVar);
            if (bk != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String a4 = bk.a();
                if (TextUtils.isEmpty(a4)) {
                    c(elapsedRealtime, true, false, meVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(bk.ys())) {
                    com.bytedance.sdk.component.utils.ux.w(a4);
                }
                if (meVar.ps()) {
                    c4 = ng.c(2, meVar);
                } else {
                    c4 = ng.c(3, meVar);
                }
                c4.c("material_meta", meVar);
                if (!ls.w().gd(String.valueOf(gd)) || ys.sr(ls.getContext())) {
                    bk.ux(0);
                    com.bykv.vk.openvk.component.video.c.c.c();
                    com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, new com.bykv.vk.openvk.component.video.api.ux.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.p.2
                        @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
                        public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, int i4) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
                        public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, int i4, String str) {
                        }
                    });
                }
            }
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        return (cVar == null || cVar.w() == null || cVar.w().isEmpty() || cVar.w().get(0) == null) ? false : true;
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        com.bytedance.sdk.component.f.c c4;
        if (wVar == null) {
            return;
        }
        try {
            String f4 = wVar.f();
            if (TextUtils.isEmpty(f4) || (c4 = ba.c("tt_splash")) == null) {
                return;
            }
            c4.c("has_ad_cache" + f4);
            c4.c("has_video_ad_cache" + f4);
            c4.c("expiration" + f4);
            com.bytedance.sdk.component.f.c c5 = ba.c("tt_materialMeta");
            c5.c("materialMeta" + f4);
            com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "removeNetAdPreLoadAd...  \u6e05\u6389\u7f13\u5b58: " + f4);
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        try {
            ba.c("tt_materialMeta").w();
            ba.c("tt_splash").w();
        } catch (Throwable unused) {
        }
    }

    public static String c(int i4) {
        return com.bytedance.sdk.openadsdk.n.ev.c(i4).xv();
    }

    public static int c(vc vcVar) {
        if (vcVar != null) {
            int w3 = w(vcVar.w());
            return w3 <= 0 ? c(vcVar.c()) : w3;
        }
        return 0;
    }

    public static int c(me meVar) {
        if (meVar != null) {
            return wv.gd(meVar);
        }
        return 0;
    }
}
