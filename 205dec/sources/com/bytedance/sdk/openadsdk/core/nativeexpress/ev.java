package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {
    public static void c(final String str, final String str2, final me meVar) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ev.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(ev.c(str)).xv(str2).f(wv.a(meVar)).c("dynamic_backup_render_new");
                c4.c(currentTimeMillis);
                return c4;
            }
        }, "dynamic_backup_render_new");
    }

    public static void c(final int i4, final String str, final String str2, final me meVar) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().ux(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ev.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(ev.c(str)).xv(str2).f(wv.a(meVar)).w(i4).r(com.bytedance.sdk.openadsdk.core.p.c(i4));
            }
        });
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c4 = 1;
                    break;
                }
                break;
            case -891990144:
                if (str.equals("stream")) {
                    c4 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c4 = 3;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 8;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 9;
            default:
                return 5;
        }
    }
}
