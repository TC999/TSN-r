package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.HookBridge;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.BeforeInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import io.github.libxposed.api.errors.HookFailedError;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: K  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class K {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f34a;

    static {
        Method method;
        try {
            method = InvocationTargetException.class.getMethod("getCause", new Class[0]);
        } catch (Throwable unused) {
            method = null;
        }
        f34a = method;
    }

    public static H a(Executable executable, int i4, Class cls) {
        Method[] declaredMethods;
        if (Modifier.isAbstract(executable.getModifiers())) {
            throw new IllegalArgumentException("Cannot hook abstract methods: " + executable);
        } else if (executable.getDeclaringClass().getClassLoader() != N.class.getClassLoader()) {
            if (executable.getDeclaringClass() == Method.class && executable.getName().equals("invoke")) {
                throw new IllegalArgumentException("Cannot hook Method.invoke");
            }
            if (cls != null) {
                if (cls.getAnnotation(XposedHooker.class) != null) {
                    Method method = null;
                    Method method2 = null;
                    for (Method method3 : cls.getDeclaredMethods()) {
                        if (method3.getAnnotation(BeforeInvocation.class) != null) {
                            if (method != null) {
                                throw new IllegalArgumentException("More than one method annotated with @BeforeInvocation");
                            }
                            boolean z3 = (method3.getModifiers() & 9) == 9;
                            Class<?>[] parameterTypes = method3.getParameterTypes();
                            if (parameterTypes.length == 1) {
                                z3 &= parameterTypes[0].equals(XposedInterface.BeforeHookCallback.class);
                            } else if (parameterTypes.length != 0) {
                                throw new IllegalArgumentException("BeforeInvocation method format is invalid");
                            }
                            if (!z3) {
                                throw new IllegalArgumentException("BeforeInvocation method format is invalid");
                            }
                            method = method3;
                        }
                        if (method3.getAnnotation(AfterInvocation.class) != null) {
                            if (method2 != null) {
                                throw new IllegalArgumentException("More than one method annotated with @AfterInvocation");
                            }
                            boolean equals = ((method3.getModifiers() & 9) == 9) & method3.getReturnType().equals(Void.TYPE);
                            Class<?>[] parameterTypes2 = method3.getParameterTypes();
                            if (parameterTypes2.length == 1 || parameterTypes2.length == 2) {
                                equals &= parameterTypes2[0].equals(XposedInterface.AfterHookCallback.class);
                            } else if (parameterTypes2.length != 0) {
                                throw new IllegalArgumentException("AfterInvocation method format is invalid");
                            }
                            if (!equals) {
                                throw new IllegalArgumentException("AfterInvocation method format is invalid");
                            }
                            method2 = method3;
                        }
                    }
                    if (method == null && method2 == null) {
                        throw new IllegalArgumentException("No method annotated with @BeforeInvocation or @AfterInvocation");
                    }
                    try {
                        if (method == null) {
                            method = K.class.getMethod("b", new Class[0]);
                        } else if (method2 == null) {
                            method2 = K.class.getMethod("b", new Class[0]);
                        } else {
                            Class<?> returnType = method.getReturnType();
                            Class<?>[] parameterTypes3 = method2.getParameterTypes();
                            if (returnType != Void.TYPE && parameterTypes3.length == 2 && !returnType.equals(parameterTypes3[1])) {
                                throw new IllegalArgumentException("BeforeInvocation and AfterInvocation method format is invalid");
                            }
                        }
                        I i5 = new I(method, method2);
                        if (HookBridge.hookMethod(true, executable, J.class, i4, i5)) {
                            return new H(executable, i5);
                        }
                        throw new HookFailedError("Cannot hook " + executable);
                    } catch (NoSuchMethodException e4) {
                        throw new HookFailedError(e4);
                    }
                }
                throw new IllegalArgumentException("Hooker should be annotated with @XposedHooker");
            }
            throw new IllegalArgumentException("hooker should not be null!");
        } else {
            throw new IllegalArgumentException("Do not allow hooking inner methods");
        }
    }

    public static void b() {
    }
}
