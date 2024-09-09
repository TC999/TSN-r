package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeConstructor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface y0 extends r2.m {
    @NotNull
    y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.f b();

    boolean c();

    @NotNull
    List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters();

    @NotNull
    Collection<e0> j();

    @NotNull
    kotlin.reflect.jvm.internal.impl.builtins.h k();
}
