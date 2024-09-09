package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: typeParameterUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements a1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f56256a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final k f56257b;

    /* renamed from: c  reason: collision with root package name */
    private final int f56258c;

    public b(@NotNull a1 originalDescriptor, @NotNull k declarationDescriptor, int i4) {
        kotlin.jvm.internal.f0.p(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.f0.p(declarationDescriptor, "declarationDescriptor");
        this.f56256a = originalDescriptor;
        this.f56257b = declarationDescriptor;
        this.f56258c = i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(m<R, D> mVar, D d4) {
        return (R) this.f56256a.C(mVar, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.storage.n N() {
        return this.f56256a.N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public boolean S() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public k b() {
        return this.f56257b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public int f() {
        return this.f56258c + this.f56256a.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f56256a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        return this.f56256a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        return this.f56256a.getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.types.e0> getUpperBounds() {
        return this.f56256a.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.y0 j() {
        return this.f56256a.j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public boolean l() {
        return this.f56256a.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public Variance o() {
        return this.f56256a.o();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.m0 q() {
        return this.f56256a.q();
    }

    @NotNull
    public String toString() {
        return this.f56256a + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public a1 a() {
        a1 a4 = this.f56256a.a();
        kotlin.jvm.internal.f0.o(a4, "originalDescriptor.original");
        return a4;
    }
}
