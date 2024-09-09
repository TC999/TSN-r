package cn.bluemobi.dylan.base.utils;

import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Reflector.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Reflector.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f1810a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f1811b;

        public a(Object obj, Class cls) {
            this.f1810a = obj;
            this.f1811b = cls;
        }

        Object a() {
            return this.f1810a;
        }

        Class getType() {
            return this.f1811b;
        }
    }

    public static void a(Object obj, String str, a... aVarArr) {
        if (obj == null) {
            return;
        }
        try {
            Class<?>[] clsArr = aVarArr == null ? new Class[0] : new Class[aVarArr.length];
            Object[] objArr = aVarArr == null ? new Object[0] : new Object[aVarArr.length];
            if (aVarArr != null) {
                int length = clsArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    clsArr[i4] = aVarArr[i4].getType();
                    objArr[i4] = aVarArr[i4].a();
                }
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
    }
}
