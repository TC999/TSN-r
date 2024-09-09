package com.qq.e.comm.plugin.e.j;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.i0.f;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    public static String a(String str, String str2) {
        b(str, str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(f.b(str.getBytes(com.qq.e.comm.plugin.k.a.f44515a)), 10).replace("=", "");
        } catch (f.b | NullPointerException unused) {
            return null;
        }
    }

    private static void b(String str, String str2) {
        if (TextUtils.equals(str2, "click")) {
            d1.a("gdt_tag_p_click", "\u52a0\u5bc6\u524d\uff1a%s ", str);
        } else if (TextUtils.equals(str2, "exposure")) {
            d1.a("gdt_tag_p_exposure", "\u52a0\u5bc6\u524d\uff1a%s ", str);
        } else if (TextUtils.equals(str2, "request")) {
            d1.a("gdt_tag_p_request", "\u52a0\u5bc6\u524d\uff1a%s ", str);
        }
    }
}
