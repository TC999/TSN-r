package xyz.adscope.common.info.deviceinfo;

import com.acse.ottn.f3;
import java.lang.reflect.Method;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SysProp {

    /* renamed from: a  reason: collision with root package name */
    public static Method f64667a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64668b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f64669c;

    static {
        Method[] methods;
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    f64667a = method;
                } else if (name.equals(f3.f5659h)) {
                    f64669c = method;
                } else if (name.equals(f3.f5657f)) {
                    f64668b = method;
                }
            }
        } catch (ClassNotFoundException e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
    }

    public static String get(String str, String str2) {
        try {
            return (String) f64668b.invoke(null, str, str2);
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return str2;
        }
    }

    public static long getLong(String str, long j4) {
        try {
            return ((Long) f64667a.invoke(null, str, Long.valueOf(j4))).longValue();
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return j4;
        }
    }

    public static void set(String str, String str2) {
        try {
            f64669c.invoke(null, str, str2);
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
        }
    }
}
