package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSystemCommonBackendContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface g1 extends r2.p {

    /* compiled from: TypeSystemCommonBackendContext.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull
        public static r2.g a(@NotNull g1 g1Var, @NotNull r2.g receiver) {
            kotlin.jvm.internal.f0.p(g1Var, "this");
            kotlin.jvm.internal.f0.p(receiver, "receiver");
            r2.i g4 = g1Var.g(receiver);
            return g4 == null ? receiver : g1Var.a(g4, true);
        }
    }

    @Nullable
    PrimitiveType D(@NotNull r2.m mVar);

    @Nullable
    PrimitiveType U(@NotNull r2.m mVar);

    boolean Z(@NotNull r2.m mVar);

    @NotNull
    r2.g n(@NotNull r2.n nVar);

    boolean p(@NotNull r2.m mVar);

    @NotNull
    r2.g v(@NotNull r2.g gVar);

    boolean v0(@NotNull r2.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.name.d x(@NotNull r2.m mVar);

    @Nullable
    r2.g y(@NotNull r2.g gVar);
}
