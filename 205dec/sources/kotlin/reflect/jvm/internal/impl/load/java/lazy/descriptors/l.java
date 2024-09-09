package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j;
import kotlin.reflect.jvm.internal.impl.types.e0;
import m2.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaStaticScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class l extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        super(c4, null, 2, null);
        f0.p(c4, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @Nullable
    protected s0 A() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    @NotNull
    protected j.a I(@NotNull r method, @NotNull List<? extends a1> methodTypeParameters, @NotNull e0 returnType, @NotNull List<? extends d1> valueParameters) {
        List F;
        f0.p(method, "method");
        f0.p(methodTypeParameters, "methodTypeParameters");
        f0.p(returnType, "returnType");
        f0.p(valueParameters, "valueParameters");
        F = CollectionsKt__CollectionsKt.F();
        return new j.a(returnType, null, valueParameters, methodTypeParameters, false, F);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void t(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<p0> result) {
        f0.p(name, "name");
        f0.p(result, "result");
    }
}
