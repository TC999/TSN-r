package f2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: IdentifierManager.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54666a = "IdentifierManager";

    /* renamed from: b  reason: collision with root package name */
    private static Object f54667b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f54668c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f54669d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f54670e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f54671f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f54672g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f54668c = cls;
            f54667b = cls.newInstance();
            f54669d = f54668c.getMethod("getUDID", Context.class);
            f54670e = f54668c.getMethod("getOAID", Context.class);
            f54671f = f54668c.getMethod("getVAID", Context.class);
            f54672g = f54668c.getMethod("getAAID", Context.class);
        } catch (Exception e4) {
            Log.e(f54666a, "reflect exception!", e4);
        }
    }

    public static String a(Context context) {
        return b(context, f54669d);
    }

    private static String b(Context context, Method method) {
        Object obj = f54667b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e4) {
            Log.e(f54666a, "invoke exception!", e4);
            return null;
        }
    }

    public static boolean c() {
        return (f54668c == null || f54667b == null) ? false : true;
    }

    public static String d(Context context) {
        return b(context, f54670e);
    }

    public static String e(Context context) {
        return b(context, f54671f);
    }

    public static String f(Context context) {
        return b(context, f54672g);
    }
}
