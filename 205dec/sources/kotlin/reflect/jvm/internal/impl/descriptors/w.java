package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface w extends CallableMemberDescriptor {

    /* compiled from: FunctionDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a<D extends w> {
        @NotNull
        a<D> a();

        @NotNull
        a<D> b(@NotNull List<d1> list);

        @Nullable
        D build();

        @NotNull
        a<D> c(@Nullable s0 s0Var);

        @NotNull
        a<D> d();

        @NotNull
        a<D> e(@Nullable s0 s0Var);

        @NotNull
        a<D> f(@NotNull kotlin.reflect.jvm.internal.impl.types.d1 d1Var);

        @NotNull
        <V> a<D> g(@NotNull a.InterfaceC1126a<V> interfaceC1126a, V v3);

        @NotNull
        a<D> h(@NotNull s sVar);

        @NotNull
        a<D> i();

        @NotNull
        a<D> j(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        @NotNull
        a<D> k(@NotNull Modality modality);

        @NotNull
        a<D> l();

        @NotNull
        a<D> m(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var);

        @NotNull
        a<D> n(@Nullable CallableMemberDescriptor callableMemberDescriptor);

        @NotNull
        a<D> o(boolean z3);

        @NotNull
        a<D> p(@NotNull List<a1> list);

        @NotNull
        a<D> q(@NotNull k kVar);

        @NotNull
        a<D> r(@NotNull CallableMemberDescriptor.Kind kind);

        @NotNull
        a<D> s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar);

        @NotNull
        a<D> t();
    }

    boolean B0();

    boolean E();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    w a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    k b();

    @Nullable
    w c(@NotNull kotlin.reflect.jvm.internal.impl.types.f1 f1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends w> d();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    @Nullable
    w q0();

    @NotNull
    a<? extends w> x();

    boolean z0();
}
