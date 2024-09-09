package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject, boolean z3) {
        if (z3 && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e4) {
            return e4;
        } catch (RuntimeException e5) {
            return handleInaccessibleObjectException(e5);
        }
    }
}
