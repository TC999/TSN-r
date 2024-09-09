package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackageFragmentDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class z extends k implements kotlin.reflect.jvm.internal.impl.descriptors.g0 {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56521e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f56522f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d0 module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        super(module, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), fqName.h(), v0.f56634a);
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        this.f56521e = fqName;
        this.f56522f = "package " + fqName + " of " + module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d4) {
        kotlin.jvm.internal.f0.p(visitor, "visitor");
        return visitor.h(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c e() {
        return this.f56521e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 NO_SOURCE = v0.f56634a;
        kotlin.jvm.internal.f0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    @NotNull
    public String toString() {
        return this.f56522f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d0 b() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d0) super.b();
    }
}
