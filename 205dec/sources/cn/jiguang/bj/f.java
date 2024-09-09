package cn.jiguang.bj;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Long f2670a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f2671b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f2672c;

    /* renamed from: d  reason: collision with root package name */
    private static String f2673d;

    /* renamed from: e  reason: collision with root package name */
    private static Class f2674e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f2675f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f2676g;

    /* renamed from: h  reason: collision with root package name */
    private static Class f2677h;

    /* renamed from: i  reason: collision with root package name */
    private static LinkedList<String> f2678i;

    public static long a(Context context) {
        Long l4 = f2670a;
        if (l4 != null) {
            return l4.longValue();
        }
        Object a4 = a(context, null, 20, null, null, new Object[0]);
        if (a4 instanceof Long) {
            Long valueOf = Long.valueOf(((Long) a4).longValue());
            f2670a = valueOf;
            return valueOf.longValue();
        }
        return 0L;
    }

    public static PackageInfo a(Context context, Object... objArr) {
        Object a4 = a(context, null, 98, null, null, objArr);
        if (a4 instanceof PackageInfo) {
            return (PackageInfo) a4;
        }
        return null;
    }

    public static Object a(Context context, String str, int i4, String str2, Bundle bundle, Object... objArr) {
        try {
            if (f2674e == null) {
                f2674e = Class.forName("cn.jiguang.api.JCoreManager");
            }
            if (f2675f == null) {
                f2675f = f2674e.getDeclaredMethod("onEvent", Context.class, String.class, Integer.TYPE, String.class, Bundle.class, Object[].class);
            }
            return f2675f.invoke(null, context, str, Integer.valueOf(i4), str2, bundle, objArr);
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when invokeOnEvent." + th.getMessage());
            return null;
        }
    }

    public static Map<Integer, Bundle> a() {
        try {
            Class<?> cls = Class.forName("cn.jiguang.internal.ActionManager");
            Object invoke = cls.getDeclaredMethod("loadPInfo", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke instanceof Map) {
                return (Map) invoke;
            }
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when getUid." + th.getMessage());
        }
        return null;
    }

    public static void a(Context context, String str, long j4, int i4) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("type", "dy");
        bundle.putLong("req", j4);
        bundle.putLong("res", i4);
        a(context, null, 122, null, bundle, new Object[0]);
    }

    public static int b() {
        try {
            if (f2677h == null) {
                f2677h = Class.forName("cn.jiguang.internal.JConstants");
            }
            Field declaredField = f2677h.getDeclaredField("SDK_VERSION_INT");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return 0;
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f2671b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object a4 = a(context, null, 123, null, null, new Object[0]);
        if (a4 instanceof Boolean) {
            Boolean bool2 = (Boolean) a4;
            f2671b = bool2;
            return bool2.booleanValue();
        }
        return false;
    }

    public static String c() {
        try {
            if (f2677h == null) {
                f2677h = Class.forName("cn.jiguang.internal.JConstants");
            }
            Field declaredField = f2677h.getDeclaredField("APP_KEY");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return "";
        }
    }

    public static boolean c(Context context) {
        Boolean bool = f2672c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object a4 = a(context, null, 121, null, null, new Object[0]);
        if (a4 instanceof Boolean) {
            Boolean bool2 = (Boolean) a4;
            f2672c = bool2;
            return bool2.booleanValue();
        }
        return false;
    }

    public static String d(Context context) {
        String str = f2673d;
        if (str != null) {
            return str;
        }
        Object a4 = a(context, null, 6, null, null, new Object[0]);
        if (a4 instanceof String) {
            String str2 = (String) a4;
            f2673d = str2;
            return str2;
        }
        return null;
    }

    public static boolean d() {
        try {
            Boolean bool = f2676g;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (f2677h == null) {
                f2677h = Class.forName("cn.jiguang.internal.JConstants");
            }
            Field field = f2677h.getField("INTERNAL_USE");
            field.setAccessible(true);
            Object obj = field.get(null);
            if (obj instanceof Boolean) {
                f2676g = Boolean.valueOf(((Boolean) obj).booleanValue());
            }
            return f2676g.booleanValue();
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when isInternalUse." + th.getMessage());
            return false;
        }
    }

    public static LinkedList<String> e() {
        try {
            LinkedList<String> linkedList = f2678i;
            if (linkedList == null || linkedList.size() <= 0) {
                if (f2677h == null) {
                    f2677h = Class.forName("cn.jiguang.internal.JConstants");
                }
                Field declaredField = f2677h.getDeclaredField("TUU");
                declaredField.setAccessible(true);
                LinkedList<String> linkedList2 = (LinkedList) declaredField.get(null);
                f2678i = linkedList2;
                return linkedList2;
            }
            return f2678i;
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JCoreBridge", "error occured when isDebugModel." + th.getMessage());
            return null;
        }
    }
}
