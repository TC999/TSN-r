package cn.jiguang.ag;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {
    public static Object a(Class<?> cls, String str, Object[] objArr, Class[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }

    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        a(obj);
        a(clsArr, objArr);
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void a(Class<?>[] clsArr, Object[] objArr) {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }
}
