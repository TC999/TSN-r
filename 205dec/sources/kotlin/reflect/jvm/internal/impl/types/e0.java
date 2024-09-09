package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e0 implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.a, r2.g {

    /* renamed from: a  reason: collision with root package name */
    private int f58333a;

    private e0() {
    }

    public /* synthetic */ e0(kotlin.jvm.internal.u uVar) {
        this();
    }

    private final int F0() {
        if (g0.a(this)) {
            return super.hashCode();
        }
        return (((H0().hashCode() * 31) + G0().hashCode()) * 31) + (I0() ? 1 : 0);
    }

    @NotNull
    public abstract List<a1> G0();

    @NotNull
    public abstract y0 H0();

    public abstract boolean I0();

    @NotNull
    public abstract e0 J0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @NotNull
    public abstract l1 K0();

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            return I0() == e0Var.I0() && kotlin.reflect.jvm.internal.impl.types.checker.r.f58305a.a(K0(), e0Var.K0());
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f58333a;
        if (i4 != 0) {
            return i4;
        }
        int F0 = F0();
        this.f58333a = F0;
        return F0;
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h p();
}
