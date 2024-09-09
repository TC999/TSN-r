package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntegerValueTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p implements y0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f57850a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f57851b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<e0> f57852c;

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f b() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return false;
    }

    @Nullable
    public Void d() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<a1> getParameters() {
        List<a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public Collection<e0> j() {
        return this.f57852c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        return this.f57851b.k();
    }

    @NotNull
    public String toString() {
        return "IntegerValueType(" + this.f57850a + ')';
    }
}
