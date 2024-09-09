package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeParameterDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a1 extends f, r2.n {
    @NotNull
    kotlin.reflect.jvm.internal.impl.storage.n N();

    boolean S();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    a1 a();

    int f();

    @NotNull
    List<kotlin.reflect.jvm.internal.impl.types.e0> getUpperBounds();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    kotlin.reflect.jvm.internal.impl.types.y0 j();

    boolean l();

    @NotNull
    Variance o();
}
