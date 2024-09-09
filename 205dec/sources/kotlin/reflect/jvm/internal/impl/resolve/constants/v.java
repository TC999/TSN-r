package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v extends g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull String value) {
        super(value);
        f0.p(value, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return '\"' + a() + '\"';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public m0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        m0 W = module.k().W();
        f0.o(W, "module.builtIns.stringType");
        return W;
    }
}
