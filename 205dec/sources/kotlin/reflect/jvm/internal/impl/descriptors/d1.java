package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ValueParameterDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d1 extends m0, f1 {

    /* compiled from: ValueParameterDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static boolean a(@NotNull d1 d1Var) {
            kotlin.jvm.internal.f0.p(d1Var, "this");
            return false;
        }
    }

    @NotNull
    d1 Y(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i4);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    d1 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    kotlin.reflect.jvm.internal.impl.descriptors.a b();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<d1> d();

    int f();

    boolean n0();

    boolean p0();

    @Nullable
    kotlin.reflect.jvm.internal.impl.types.e0 t0();

    boolean x0();
}
