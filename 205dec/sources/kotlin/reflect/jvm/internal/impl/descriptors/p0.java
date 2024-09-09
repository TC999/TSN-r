package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PropertyDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface p0 extends CallableMemberDescriptor, g1 {
    @NotNull
    List<o0> A();

    @Nullable
    u R();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    p0 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    p0 c(@NotNull kotlin.reflect.jvm.internal.impl.types.f1 f1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends p0> d();

    @Nullable
    q0 getGetter();

    @Nullable
    r0 getSetter();

    @Nullable
    u u0();
}
