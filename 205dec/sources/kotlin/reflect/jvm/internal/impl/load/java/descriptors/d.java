package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d ownerDescriptor, @NotNull u0 getterMethod, @Nullable u0 u0Var, @NotNull p0 overriddenProperty) {
        super(ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), getterMethod.s(), getterMethod.getVisibility(), u0Var != null, overriddenProperty.getName(), getterMethod.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        f0.p(ownerDescriptor, "ownerDescriptor");
        f0.p(getterMethod, "getterMethod");
        f0.p(overriddenProperty, "overriddenProperty");
    }
}
