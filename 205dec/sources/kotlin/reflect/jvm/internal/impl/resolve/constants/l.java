package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends g<Float> {
    public l(float f4) {
        super(Float.valueOf(f4));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return a().floatValue() + ".toFloat()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public m0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        m0 B = module.k().B();
        f0.o(B, "module.builtIns.floatType");
        return B;
    }
}
