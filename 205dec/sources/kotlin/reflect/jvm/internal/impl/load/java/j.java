package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorsJvmAbiUtil.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j {
    private static /* synthetic */ void a(int i4) {
        Object[] objArr = new Object[3];
        if (i4 == 1 || i4 == 2) {
            objArr[0] = "companionObject";
        } else if (i4 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i4 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i4 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i4 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.u u02;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if ((callableMemberDescriptor instanceof p0) && (u02 = ((p0) callableMemberDescriptor).u0()) != null && u02.getAnnotations().i(x.f57102b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().i(x.f57102b);
    }

    public static boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(1);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.d.x(kVar) && kotlin.reflect.jvm.internal.impl.resolve.d.w(kVar.b()) && !d((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
    }

    public static boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(2);
        }
        return kotlin.reflect.jvm.internal.impl.builtins.d.a(kotlin.reflect.jvm.internal.impl.builtins.c.f56021a, dVar);
    }

    public static boolean e(@NotNull p0 p0Var) {
        if (p0Var == null) {
            a(0);
        }
        if (p0Var.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(p0Var.b())) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.d.x(p0Var.b()) && b(p0Var);
    }
}
