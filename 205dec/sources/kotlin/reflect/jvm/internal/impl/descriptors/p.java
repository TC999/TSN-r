package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorVisibility.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class p extends s {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final i1 f56526a;

    public p(@NotNull i1 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f56526a = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public i1 b() {
        return this.f56526a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public String c() {
        return b().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public s f() {
        s j4 = r.j(b().d());
        kotlin.jvm.internal.f0.o(j4, "toDescriptorVisibility(delegate.normalize())");
        return j4;
    }
}
