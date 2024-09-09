package cn.jpush.android.a;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class b extends a {
    public static void a(String str) {
        a.a("key_token", str);
    }

    public static String b(Context context) {
        a.a(context);
        return a.b("key_token", "");
    }

    public static boolean c(Context context) {
        a.a(context);
        return a.b("first_request", true).booleanValue();
    }

    public static void d(Context context) {
        a.a(context);
        a.a("first_request", false);
    }
}
