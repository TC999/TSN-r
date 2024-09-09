package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstructorDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface j extends w {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    g b();

    boolean b0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.x0
    @Nullable
    j c(@NotNull kotlin.reflect.jvm.internal.impl.types.f1 f1Var);

    @NotNull
    d c0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    kotlin.reflect.jvm.internal.impl.types.e0 getReturnType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    List<a1> getTypeParameters();
}
