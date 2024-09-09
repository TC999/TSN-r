package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends o<Byte> {
    public d(byte b4) {
        super(Byte.valueOf(b4));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return a().intValue() + ".toByte()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public m0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        m0 t3 = module.k().t();
        f0.o(t3, "module.builtIns.byteType");
        return t3;
    }
}
