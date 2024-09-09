package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* renamed from: o0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1478o0 {

    /* renamed from: a  reason: collision with root package name */
    public final Class[] f61572a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f61573b;

    public C1478o0(Constructor constructor) {
        this.f61572a = constructor.getParameterTypes();
        this.f61573b = constructor.isVarArgs();
    }

    public C1478o0(Method method) {
        this.f61572a = method.getParameterTypes();
        this.f61573b = method.isVarArgs();
    }
}
