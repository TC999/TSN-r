package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f1221a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1222b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f1223c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Class<?> cls, String str, Class... clsArr) {
        this.f1221a = cls;
        this.f1222b = str;
        this.f1223c = clsArr;
    }

    public boolean a(T t3) {
        return a(t3.getClass()) != null;
    }

    public Object b(T t3, Object... objArr) throws InvocationTargetException {
        Method a4 = a(t3.getClass());
        if (a4 == null) {
            return null;
        }
        try {
            return a4.invoke(t3, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object c(T t3, Object... objArr) {
        try {
            return b(t3, objArr);
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t3, Object... objArr) {
        try {
            return a(t3, objArr);
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object a(T t3, Object... objArr) throws InvocationTargetException {
        Method a4 = a(t3.getClass());
        if (a4 != null) {
            try {
                return a4.invoke(t3, objArr);
            } catch (IllegalAccessException e4) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a4);
                assertionError.initCause(e4);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f1222b + " not supported for object " + t3);
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f1222b;
        if (str != null) {
            Method a4 = a(cls, str, this.f1223c);
            if (a4 == null || (cls2 = this.f1221a) == null || cls2.isAssignableFrom(a4.getReturnType())) {
                return a4;
            }
            return null;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
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
