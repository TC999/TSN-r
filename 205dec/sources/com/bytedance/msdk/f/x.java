package com.bytedance.msdk.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class x {

    /* renamed from: c  reason: collision with root package name */
    private static String f28366c;

    public static boolean c() {
        return com.bytedance.msdk.adapter.sr.xv.w() && com.bytedance.msdk.core.w.k().n() && com.bytedance.msdk.core.w.k().ck();
    }

    public static String w() {
        if (TextUtils.isEmpty(f28366c)) {
            f28366c = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f28366c;
    }

    public static String c(String str) {
        try {
            if (c()) {
                String gb = com.bytedance.msdk.core.w.k().gb();
                if (TextUtils.isEmpty(gb)) {
                    return str;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TestHelperUtils", "AnyDoorId=" + gb);
                return Uri.parse(str).buildUpon().appendQueryParameter(w(), gb).appendQueryParameter("aid", "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }
}
