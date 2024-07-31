package cn.bluemobi.dylan.base.utils;

import java.lang.reflect.Method;

/* renamed from: cn.bluemobi.dylan.base.utils.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Reflector {

    /* compiled from: Reflector.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.q$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1144a {

        /* renamed from: a */
        private final Object f1824a;

        /* renamed from: b */
        private final Class f1825b;

        public C1144a(Object obj, Class cls) {
            this.f1824a = obj;
            this.f1825b = cls;
        }

        /* renamed from: a */
        Object m57699a() {
            return this.f1824a;
        }

        Class getType() {
            return this.f1825b;
        }
    }

    /* renamed from: a */
    public static void m57700a(Object obj, String str, C1144a... c1144aArr) {
        if (obj == null) {
            return;
        }
        try {
            Class<?>[] clsArr = c1144aArr == null ? new Class[0] : new Class[c1144aArr.length];
            Object[] objArr = c1144aArr == null ? new Object[0] : new Object[c1144aArr.length];
            if (c1144aArr != null) {
                int length = clsArr.length;
                for (int i = 0; i < length; i++) {
                    clsArr[i] = c1144aArr[i].getType();
                    objArr[i] = c1144aArr[i].m57699a();
                }
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
    }
}
