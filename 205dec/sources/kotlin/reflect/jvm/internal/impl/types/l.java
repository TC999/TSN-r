package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassifierBasedTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class l implements y0 {

    /* renamed from: a  reason: collision with root package name */
    private int f58393a;

    private final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        return (w.r(fVar) || kotlin.reflect.jvm.internal.impl.resolve.d.E(fVar)) ? false : true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.f b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f first, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f second) {
        kotlin.jvm.internal.f0.p(first, "first");
        kotlin.jvm.internal.f0.p(second, "second");
        if (kotlin.jvm.internal.f0.g(first.getName(), second.getName())) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = first.b();
            for (kotlin.reflect.jvm.internal.impl.descriptors.k b5 = second.b(); b4 != null && b5 != null; b5 = b5.b()) {
                if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d0) {
                    return b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d0;
                }
                if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d0) {
                    return false;
                }
                if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0) {
                    return (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0) && kotlin.jvm.internal.f0.g(((kotlin.reflect.jvm.internal.impl.descriptors.g0) b4).e(), ((kotlin.reflect.jvm.internal.impl.descriptors.g0) b5).e());
                } else if ((b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0) || !kotlin.jvm.internal.f0.g(b4.getName(), b5.getName())) {
                    return false;
                } else {
                    b4 = b4.b();
                }
            }
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof y0) && obj.hashCode() == hashCode()) {
            y0 y0Var = (y0) obj;
            if (y0Var.getParameters().size() != getParameters().size()) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = b();
            kotlin.reflect.jvm.internal.impl.descriptors.f b5 = y0Var.b();
            if (b5 != null && e(b4) && e(b5)) {
                return f(b5);
            }
            return false;
        }
        return false;
    }

    protected abstract boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar);

    public int hashCode() {
        int identityHashCode;
        int i4 = this.f58393a;
        if (i4 != 0) {
            return i4;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = b();
        if (e(b4)) {
            identityHashCode = kotlin.reflect.jvm.internal.impl.resolve.d.m(b4).hashCode();
        } else {
            identityHashCode = System.identityHashCode(this);
        }
        this.f58393a = identityHashCode;
        return identityHashCode;
    }
}
