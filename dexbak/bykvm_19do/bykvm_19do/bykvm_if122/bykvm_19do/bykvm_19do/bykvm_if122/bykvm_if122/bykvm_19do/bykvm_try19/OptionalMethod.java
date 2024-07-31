package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class OptionalMethod<T> {

    /* renamed from: a */
    private final Class<?> f1228a;

    /* renamed from: b */
    private final String f1229b;

    /* renamed from: c */
    private final Class[] f1230c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f1228a = cls;
        this.f1229b = str;
        this.f1230c = clsArr;
    }

    /* renamed from: a */
    public boolean m58499a(T t) {
        return m58501a(t.getClass()) != null;
    }

    /* renamed from: b */
    public Object m58497b(T t, Object... objArr) throws InvocationTargetException {
        Method m58501a = m58501a(t.getClass());
        if (m58501a == null) {
            return null;
        }
        try {
            return m58501a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public Object m58496c(T t, Object... objArr) {
        try {
            return m58497b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m58495d(T t, Object... objArr) {
        try {
            return m58498a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public Object m58498a(T t, Object... objArr) throws InvocationTargetException {
        Method m58501a = m58501a(t.getClass());
        if (m58501a != null) {
            try {
                return m58501a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + m58501a);
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f1229b + " not supported for object " + t);
    }

    /* renamed from: a */
    private Method m58501a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f1229b;
        if (str != null) {
            Method m58500a = m58500a(cls, str, this.f1230c);
            if (m58500a == null || (cls2 = this.f1228a) == null || cls2.isAssignableFrom(m58500a.getReturnType())) {
                return m58500a;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m58500a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
