package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ModuleDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d0 extends k {

    /* compiled from: ModuleDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <R, D> R a(@NotNull d0 d0Var, @NotNull m<R, D> visitor, D d4) {
            kotlin.jvm.internal.f0.p(d0Var, "this");
            kotlin.jvm.internal.f0.p(visitor, "visitor");
            return visitor.k(d0Var, d4);
        }

        @Nullable
        public static k b(@NotNull d0 d0Var) {
            kotlin.jvm.internal.f0.p(d0Var, "this");
            return null;
        }
    }

    @Nullable
    <T> T D0(@NotNull c0<T> c0Var);

    boolean L(@NotNull d0 d0Var);

    @NotNull
    l0 j0(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @NotNull
    kotlin.reflect.jvm.internal.impl.builtins.h k();

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    @NotNull
    List<d0> w0();
}
