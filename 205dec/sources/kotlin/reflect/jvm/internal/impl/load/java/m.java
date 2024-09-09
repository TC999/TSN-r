package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FieldOverridabilityCondition.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        f0.p(superDescriptor, "superDescriptor");
        f0.p(subDescriptor, "subDescriptor");
        if ((subDescriptor instanceof p0) && (superDescriptor instanceof p0)) {
            p0 p0Var = (p0) subDescriptor;
            p0 p0Var2 = (p0) superDescriptor;
            if (f0.g(p0Var.getName(), p0Var2.getName())) {
                if (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(p0Var) && kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(p0Var2)) {
                    return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                }
                if (!kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(p0Var) && !kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(p0Var2)) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
            }
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
