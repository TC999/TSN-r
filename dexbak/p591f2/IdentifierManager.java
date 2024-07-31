package p591f2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: f2.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class IdentifierManager {

    /* renamed from: a */
    private static final String f40136a = "IdentifierManager";

    /* renamed from: b */
    private static Object f40137b;

    /* renamed from: c */
    private static Class<?> f40138c;

    /* renamed from: d */
    private static Method f40139d;

    /* renamed from: e */
    private static Method f40140e;

    /* renamed from: f */
    private static Method f40141f;

    /* renamed from: g */
    private static Method f40142g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f40138c = cls;
            f40137b = cls.newInstance();
            f40139d = f40138c.getMethod("getUDID", Context.class);
            f40140e = f40138c.getMethod("getOAID", Context.class);
            f40141f = f40138c.getMethod("getVAID", Context.class);
            f40142g = f40138c.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            Log.e(f40136a, "reflect exception!", e);
        }
    }

    /* renamed from: a */
    public static String m12749a(Context context) {
        return m12748b(context, f40139d);
    }

    /* renamed from: b */
    private static String m12748b(Context context, Method method) {
        Object obj = f40137b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            Log.e(f40136a, "invoke exception!", e);
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m12747c() {
        return (f40138c == null || f40137b == null) ? false : true;
    }

    /* renamed from: d */
    public static String m12746d(Context context) {
        return m12748b(context, f40140e);
    }

    /* renamed from: e */
    public static String m12745e(Context context) {
        return m12748b(context, f40141f);
    }

    /* renamed from: f */
    public static String m12744f(Context context) {
        return m12748b(context, f40142g);
    }
}
