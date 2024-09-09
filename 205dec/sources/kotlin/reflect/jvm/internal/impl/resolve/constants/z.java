package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z extends a0<Short> {
    public z(short s3) {
        super(Short.valueOf(s3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.d a4 = kotlin.reflect.jvm.internal.impl.descriptors.v.a(module, j.a.f56132u0);
        if (a4 == null) {
            m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j("Unsigned type UShort not found");
            f0.o(j4, "createErrorType(\"Unsigned type UShort not found\")");
            return j4;
        }
        m0 q3 = a4.q();
        f0.o(q3, "module.findClassAcrossMo\u2026d type UShort not found\")");
        return q3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return a().intValue() + ".toUShort()";
    }
}
