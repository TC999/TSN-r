package com.mbridge.msdk.foundation.same.net.p485f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.tools.StringUtils;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.net.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HttpUtils {

    /* renamed from: a */
    private static final String f30760a = "b";

    /* renamed from: a */
    public static String m22257a(List<C11336b> list) {
        C11336b m22254b = m22254b(list, "Content-Type");
        if (m22254b != null) {
            String m22290b = m22254b.m22290b();
            if (!TextUtils.isEmpty(m22290b)) {
                String[] split = m22290b.split(";");
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].trim().split("=");
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    /* renamed from: b */
    private static C11336b m22254b(List<C11336b> list, String str) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                C11336b c11336b = list.get(i);
                if (c11336b != null && str.equals(c11336b.m22291a())) {
                    return c11336b;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m22255b(List<C11336b> list) {
        return TextUtils.equals(m22256a(list, "Content-Encoding"), "gzip");
    }

    /* renamed from: a */
    public static String m22256a(List<C11336b> list, String str) {
        C11336b m22254b = m22254b(list, str);
        return m22254b != null ? m22254b.m22290b() : "";
    }

    /* renamed from: a */
    public static void m22258a(CommonRequestParams commonRequestParams, String str, String str2) {
        if (commonRequestParams != null) {
            try {
                if (!StringUtils.m21957a(str) && !StringUtils.m21957a(str2)) {
                    commonRequestParams.m22222a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
