package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w implements v {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<x> f56495a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Set<x> f56496b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<x> f56497c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Set<x> f56498d;

    public w(@NotNull List<x> allDependencies, @NotNull Set<x> modulesWhoseInternalsAreVisible, @NotNull List<x> directExpectedByDependencies, @NotNull Set<x> allExpectedByDependencies) {
        kotlin.jvm.internal.f0.p(allDependencies, "allDependencies");
        kotlin.jvm.internal.f0.p(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.f0.p(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.f0.p(allExpectedByDependencies, "allExpectedByDependencies");
        this.f56495a = allDependencies;
        this.f56496b = modulesWhoseInternalsAreVisible;
        this.f56497c = directExpectedByDependencies;
        this.f56498d = allExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    @NotNull
    public List<x> a() {
        return this.f56495a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    @NotNull
    public List<x> b() {
        return this.f56497c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    @NotNull
    public Set<x> c() {
        return this.f56496b;
    }
}
