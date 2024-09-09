package com.bytedance.sdk.openadsdk.n;

import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.k;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class p {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Field> f36249c = new HashMap();

    public static void c(String str) {
        try {
            if (eq.f33190w < 5500) {
                ux(str);
            } else {
                Bridge f4 = k.sr().f(4);
                if (f4 != null) {
                    f4.call(100, b.a().i(0, str).l(), null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int sr(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return eq.f33190w;
        }
        return c(str, 102);
    }

    private static void ux(String str) {
        try {
            Class.forName("com.bytedance.pangle.Zeus").getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int w(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return eq.f33190w;
        }
        return c(str, 101);
    }

    public static int xv(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 6106;
        }
        return c(str, 103);
    }

    private static int c(String str, int i4) {
        Integer num;
        try {
            Bridge f4 = k.sr().f(4);
            if (f4 != null && (num = (Integer) f4.call(i4, b.a().i(0, str).l(), Integer.class)) != null) {
                return num.intValue();
            }
        } catch (Throwable th) {
            a.xv("ZeusUtil", th);
        }
        return 0;
    }
}
