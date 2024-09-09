package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorVisibility.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class s {
    @Nullable
    public final Integer a(@NotNull s visibility) {
        kotlin.jvm.internal.f0.p(visibility, "visibility");
        return b().a(visibility.b());
    }

    @NotNull
    public abstract i1 b();

    @NotNull
    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull o oVar, @NotNull k kVar);

    @NotNull
    public abstract s f();

    @NotNull
    public final String toString() {
        return b().toString();
    }
}
