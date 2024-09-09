package defpackage;

import java.lang.reflect.Method;

/* renamed from: I  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class I {

    /* renamed from: a  reason: collision with root package name */
    public final int f29a;
    final Method afterInvocation;

    /* renamed from: b  reason: collision with root package name */
    public final int f30b;
    final Method beforeInvocation;

    public I(Method method, Method method2) {
        this.beforeInvocation = method;
        this.afterInvocation = method2;
        this.f29a = method.getParameterCount();
        this.f30b = method2.getParameterCount();
    }
}
