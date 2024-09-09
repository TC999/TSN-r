package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d extends e, g {
    @NotNull
    s0 E0();

    @Nullable
    c F();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.h U();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.h W();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    d a();

    boolean a0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    k b();

    @NotNull
    Collection<c> g();

    @NotNull
    s getVisibility();

    @NotNull
    ClassKind i();

    boolean isInline();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0();

    @Nullable
    d l0();

    @NotNull
    Collection<d> m();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.h o0(@NotNull kotlin.reflect.jvm.internal.impl.types.d1 d1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    kotlin.reflect.jvm.internal.impl.types.m0 q();

    @NotNull
    List<a1> r();

    @NotNull
    Modality s();

    boolean t();

    boolean v();

    boolean y();

    @Nullable
    x<kotlin.reflect.jvm.internal.impl.types.m0> z();
}
