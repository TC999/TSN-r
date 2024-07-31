package p645t0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* renamed from: t0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ISettingUtils {
    /* renamed from: a */
    public static String m307a(Context context, String str) {
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
            Method declaredMethod2 = Class.forName("android.provider.Settings$Secure").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls2);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(null, context.getContentResolver(), str, Integer.valueOf(intValue));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static String m306b(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            try {
                Class<?> cls = Class.forName("android.provider.Settings$Global");
                Field declaredField = cls.getDeclaredField("MOVED_TO_SECURE");
                declaredField.setAccessible(true);
                hashSet = (HashSet) declaredField.get(cls);
            } catch (Exception unused) {
            }
            try {
                Class<?> cls2 = Class.forName("android.provider.Settings$Secure");
                Field declaredField2 = cls2.getDeclaredField("MOVED_TO_LOCK_SETTINGS");
                declaredField2.setAccessible(true);
                hashSet2 = (HashSet) declaredField2.get(cls2);
            } catch (Exception unused2) {
            }
            try {
                Class<?> cls3 = Class.forName("android.provider.Settings$Secure");
                Field declaredField3 = cls3.getDeclaredField("MOVED_TO_GLOBAL");
                declaredField3.setAccessible(true);
                hashSet3 = (HashSet) declaredField3.get(cls3);
            } catch (Exception unused3) {
            }
            if (!hashSet.contains(str)) {
                if (hashSet3.contains(str)) {
                    Method declaredMethod2 = Class.forName("android.provider.Global").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return (String) declaredMethod2.invoke(null, contentResolver, str, Integer.valueOf(intValue));
                } else if (hashSet2.contains(str)) {
                    Method declaredMethod3 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[0]);
                    declaredMethod3.setAccessible(true);
                    Method declaredMethod4 = Class.forName("com.android.internal.widget.ILockSettings$Stub").getDeclaredMethod("asInterface", IBinder.class);
                    declaredMethod4.setAccessible(true);
                    Object invoke = declaredMethod4.invoke(null, (IBinder) declaredMethod3.invoke(null, "lock_settings"));
                    boolean z = Process.myUid() == 1000;
                    if (hashSet2.contains(str) && invoke != null && !z) {
                        return (String) invoke.getClass().getDeclaredMethod("getString", String.class, String.class, Integer.TYPE).invoke(str, "0", Integer.valueOf(intValue));
                    }
                }
            }
            Field declaredField4 = Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
            declaredField4.setAccessible(true);
            Object obj = declaredField4.get(null);
            return (String) obj.getClass().getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE).invoke(obj, contentResolver, str, Integer.valueOf(intValue));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
