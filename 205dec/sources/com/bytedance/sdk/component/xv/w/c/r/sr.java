package com.bytedance.sdk.component.xv.w.c.r;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class sr<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f30793c;

    /* renamed from: w  reason: collision with root package name */
    private final String f30794w;
    private final Class[] xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(Class<?> cls, String str, Class... clsArr) {
        this.f30793c = cls;
        this.f30794w = str;
        this.xv = clsArr;
    }

    public boolean c(T t3) {
        return c(t3.getClass()) != null;
    }

    public Object sr(T t3, Object... objArr) {
        try {
            return xv(t3, objArr);
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

    public Object w(T t3, Object... objArr) {
        try {
            return c(t3, objArr);
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

    public Object xv(T t3, Object... objArr) throws InvocationTargetException {
        Method c4 = c(t3.getClass());
        if (c4 != null) {
            try {
                return c4.invoke(t3, objArr);
            } catch (IllegalAccessException e4) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + c4);
                assertionError.initCause(e4);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f30794w + " not supported for object " + t3);
    }

    public Object c(T t3, Object... objArr) throws InvocationTargetException {
        Method c4 = c(t3.getClass());
        if (c4 == null) {
            return null;
        }
        try {
            return c4.invoke(t3, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method c(Class<?> cls) {
        Class<?> cls2;
        String str = this.f30794w;
        if (str != null) {
            Method c4 = c(cls, str, this.xv);
            if (c4 == null || (cls2 = this.f30793c) == null || cls2.isAssignableFrom(c4.getReturnType())) {
                return c4;
            }
            return null;
        }
        return null;
    }

    private static Method c(Class<?> cls, String str, Class[] clsArr) {
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
