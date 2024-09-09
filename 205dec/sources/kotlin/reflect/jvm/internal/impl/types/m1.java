package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m1 extends e0 {
    public m1() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public List<a1> G0() {
        return L0().G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public y0 H0() {
        return L0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    public boolean I0() {
        return L0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public final l1 K0() {
        e0 L0 = L0();
        while (L0 instanceof m1) {
            L0 = ((m1) L0).L0();
        }
        return (l1) L0;
    }

    @NotNull
    protected abstract e0 L0();

    public boolean M0() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return L0().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        return L0().p();
    }

    @NotNull
    public String toString() {
        return M0() ? L0().toString() : "<Not computed yet>";
    }
}
