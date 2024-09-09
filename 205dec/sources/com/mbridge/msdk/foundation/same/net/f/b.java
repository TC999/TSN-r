package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ag;
import java.util.List;

/* compiled from: HttpUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39554a = "b";

    public static String a(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        com.mbridge.msdk.foundation.same.net.c.b b4 = b(list, "Content-Type");
        if (b4 != null) {
            String b5 = b4.b();
            if (!TextUtils.isEmpty(b5)) {
                String[] split = b5.split(";");
                for (int i4 = 1; i4 < split.length; i4++) {
                    String[] split2 = split[i4].trim().split("=");
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    private static com.mbridge.msdk.foundation.same.net.c.b b(List<com.mbridge.msdk.foundation.same.net.c.b> list, String str) {
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                com.mbridge.msdk.foundation.same.net.c.b bVar = list.get(i4);
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public static boolean b(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        return TextUtils.equals(a(list, "Content-Encoding"), "gzip");
    }

    public static String a(List<com.mbridge.msdk.foundation.same.net.c.b> list, String str) {
        com.mbridge.msdk.foundation.same.net.c.b b4 = b(list, str);
        return b4 != null ? b4.b() : "";
    }

    public static void a(com.mbridge.msdk.foundation.same.net.g.d dVar, String str, String str2) {
        if (dVar != null) {
            try {
                if (!ag.a(str) && !ag.a(str2)) {
                    dVar.a(str, str2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
