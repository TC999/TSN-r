package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b extends g<List<? extends g<?>>> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<d0, e0> f57827b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<? extends g<?>> value, @NotNull d2.l<? super d0, ? extends e0> computeType) {
        super(value);
        f0.p(value, "value");
        f0.p(computeType, "computeType");
        this.f57827b = computeType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        e0 invoke = this.f57827b.invoke(module);
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.c0(invoke) && !kotlin.reflect.jvm.internal.impl.builtins.h.o0(invoke)) {
            kotlin.reflect.jvm.internal.impl.builtins.h.B0(invoke);
        }
        return invoke;
    }
}
