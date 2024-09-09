package cn.jiguang.f;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {
    public static int a(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "teleony_getIntNetType", null, null);
            if (a4 instanceof Integer) {
                return ((Integer) a4).intValue();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void a() {
        try {
            cn.jiguang.bl.a.a(null, "teleony_clearCache", null, null);
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "teleony_getNetworkOperator", null, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "teleony_getCurrentNetType", null, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
