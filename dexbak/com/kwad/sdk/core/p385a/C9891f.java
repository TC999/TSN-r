package com.kwad.sdk.core.p385a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9891f {
    /* renamed from: P */
    private static String m27425P(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + m27423dK(parse.getQuery()) + "&" + str2;
    }

    /* renamed from: a */
    public static void m27424a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", m27422dL(m27425P(str, str2)));
    }

    /* renamed from: dK */
    private static String m27423dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    /* renamed from: dL */
    private static String m27422dL(String str) {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = KWEGIDDFP.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }
}
