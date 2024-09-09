package cn.jpush.android.ad;

import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2;
        if ((objArr != null ? objArr.length : 0) == (clsArr != null ? clsArr.length : 0)) {
            Method method = obj.getClass().getMethod(str, clsArr);
            boolean isAccessible = method.isAccessible();
            if (!isAccessible) {
                method.setAccessible(true);
            }
            Exception exc = null;
            try {
                obj2 = method.invoke(obj, objArr);
            } catch (Exception e4) {
                exc = e4;
                obj2 = null;
            }
            if (!isAccessible) {
                method.setAccessible(false);
            }
            if (exc == null) {
                return obj2;
            }
            throw exc;
        }
        throw new IllegalArgumentException("argClasses' size is not equal to args' size");
    }
}
