package com.bytedance.sdk.openadsdk.core.eq;

import android.os.Looper;
import android.text.TextUtils;
import java.net.URLEncoder;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ck {
    public static void c(final com.bytedance.sdk.openadsdk.core.u.me meVar, final Double d4) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("win") { // from class: com.bytedance.sdk.openadsdk.core.eq.ck.1
                @Override // java.lang.Runnable
                public void run() {
                    ck.xv(meVar, d4);
                }
            });
        } else {
            xv(meVar, d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(com.bytedance.sdk.openadsdk.core.u.me meVar, Double d4) {
        if (meVar == null || meVar.tc() == null) {
            return;
        }
        try {
            Object obj = meVar.tc().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str = (String) meVar.tc().get("nurl");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (d4 != null) {
                    str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d4));
                }
                com.bytedance.sdk.openadsdk.core.ls.c().c(c(meVar, str, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final com.bytedance.sdk.openadsdk.core.u.me meVar, final Double d4, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("loss") { // from class: com.bytedance.sdk.openadsdk.core.eq.ck.2
                @Override // java.lang.Runnable
                public void run() {
                    ck.xv(meVar, d4, str, str2);
                }
            });
        } else {
            xv(meVar, d4, str, str2);
        }
    }

    private static String c(com.bytedance.sdk.openadsdk.core.u.me meVar, String str, String str2) throws Exception {
        return (meVar == null || str == null || !str.contains(str2)) ? str : str.replace(str2, URLEncoder.encode(com.bytedance.sdk.component.utils.c.w(meVar.cf()), "UTF-8"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(com.bytedance.sdk.openadsdk.core.u.me meVar, Double d4, String str, String str2) {
        if (meVar == null || meVar.tc() == null) {
            return;
        }
        try {
            Object obj = meVar.tc().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str3 = (String) meVar.tc().get("lurl");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                if (d4 != null) {
                    str3 = str3.replace("${AUCTION_PRICE}", String.valueOf(d4));
                }
                if (str != null) {
                    str3 = str3.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    str3 = str3.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.ls.c().c(c(meVar, str3, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }
}
