package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: OverridingStrategy.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g extends h {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.h
    public void b(@NotNull CallableMemberDescriptor first, @NotNull CallableMemberDescriptor second) {
        f0.p(first, "first");
        f0.p(second, "second");
        e(first, second);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.h
    public void c(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
        f0.p(fromSuper, "fromSuper");
        f0.p(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }

    protected abstract void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);
}
