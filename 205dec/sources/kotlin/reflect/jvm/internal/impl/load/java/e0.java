package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import org.jetbrains.annotations.NotNull;

/* compiled from: utils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 {
    public static final boolean a(@NotNull CallableMemberDescriptor memberDescriptor) {
        f0.p(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) && f0.g(memberDescriptor.s0(kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.G), Boolean.TRUE);
    }

    public static final boolean b(@NotNull u javaTypeEnhancementState) {
        f0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.c().invoke(s.e()) == ReportLevel.STRICT;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s c(@NotNull i1 i1Var) {
        f0.p(i1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.s g4 = q.g(i1Var);
        f0.o(g4, "toDescriptorVisibility(this)");
        return g4;
    }
}
