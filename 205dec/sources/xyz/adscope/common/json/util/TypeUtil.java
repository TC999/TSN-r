package xyz.adscope.common.json.util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TypeUtil {
    public static boolean isBasicType(Class<?> cls) {
        if (cls.isPrimitive() || String.class.isAssignableFrom(cls)) {
            return true;
        }
        return isWrapType(cls);
    }

    public static boolean isWrapType(Class<?> cls) {
        return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
    }
}
