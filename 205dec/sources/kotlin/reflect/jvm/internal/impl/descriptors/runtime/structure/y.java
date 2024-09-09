package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaRecordComponent.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y extends t implements m2.w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f56621a;

    public y(@NotNull Object recordComponent) {
        f0.p(recordComponent, "recordComponent");
        this.f56621a = recordComponent;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    @NotNull
    public Member S() {
        Method c4 = a.f56563a.c(this.f56621a);
        if (c4 != null) {
            return c4;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // m2.w
    @NotNull
    public m2.x getType() {
        Class<?> d4 = a.f56563a.d(this.f56621a);
        if (d4 != null) {
            return new n(d4);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // m2.w
    public boolean k() {
        return false;
    }
}
