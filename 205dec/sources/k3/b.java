package k3;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: IdentifierManager.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f55243a = "IdentifierManager";

    /* renamed from: b  reason: collision with root package name */
    private static Object f55244b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f55245c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f55246d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f55247e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f55248f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f55249g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f55245c = cls;
            f55244b = cls.newInstance();
            f55246d = f55245c.getMethod("getUDID", Context.class);
            f55247e = f55245c.getMethod("getOAID", Context.class);
            f55248f = f55245c.getMethod("getVAID", Context.class);
            f55249g = f55245c.getMethod("getAAID", Context.class);
        } catch (Exception e4) {
            Log.e(f55243a, "reflect exception!", e4);
        }
    }

    public static String a(Context context) {
        return b(context, f55246d);
    }

    private static String b(Context context, Method method) {
        Object obj = f55244b;
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
            Log.e(f55243a, "invoke exception!", e4);
            return null;
        }
    }

    public static boolean c() {
        return (f55245c == null || f55244b == null) ? false : true;
    }

    public static String d(Context context) {
        return b(context, f55247e);
    }

    public static String e(Context context) {
        return b(context, f55248f);
    }

    public static String f(Context context) {
        return b(context, f55249g);
    }
}
