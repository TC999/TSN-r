package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InlineClassAwareCaller.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a6\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\b\u001a\u00020\u0005*\u00020\u0003H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\f\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t*\u00020\rH\u0000\u001a\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t*\u0004\u0018\u00010\u000fH\u0000\u001a\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\"\u001a\u0010\u0015\u001a\u0004\u0018\u00010\r*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/c;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "", "isDefault", "b", "g", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "f", "d", "Lkotlin/reflect/jvm/internal/impl/types/e0;", "i", "Lkotlin/reflect/jvm/internal/impl/descriptors/k;", "h", "", "a", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "expectedReceiverType", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @Nullable
    public static final Object a(@Nullable Object obj, @NotNull CallableMemberDescriptor descriptor) {
        f0.p(descriptor, "descriptor");
        if ((descriptor instanceof p0) && kotlin.reflect.jvm.internal.impl.resolve.e.d((f1) descriptor)) {
            return obj;
        }
        e0 e4 = e(descriptor);
        Class<?> i4 = e4 == null ? null : i(e4);
        return i4 == null ? obj : f(i4, descriptor).invoke(obj, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <M extends Member> c<M> b(@NotNull c<? extends M> cVar, @NotNull CallableMemberDescriptor descriptor, boolean z3) {
        boolean z4;
        f0.p(cVar, "<this>");
        f0.p(descriptor, "descriptor");
        boolean z5 = true;
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.a(descriptor)) {
            List<d1> h4 = descriptor.h();
            f0.o(h4, "descriptor.valueParameters");
            if (!(h4 instanceof Collection) || !h4.isEmpty()) {
                for (d1 d1Var : h4) {
                    e0 type = d1Var.getType();
                    f0.o(type, "it.type");
                    if (kotlin.reflect.jvm.internal.impl.resolve.e.c(type)) {
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            if (!z4) {
                e0 returnType = descriptor.getReturnType();
                if (!(returnType != null && kotlin.reflect.jvm.internal.impl.resolve.e.c(returnType)) && ((cVar instanceof b) || !g(descriptor))) {
                    z5 = false;
                }
            }
        }
        return z5 ? new f(descriptor, cVar, z3) : cVar;
    }

    public static /* synthetic */ c c(c cVar, CallableMemberDescriptor callableMemberDescriptor, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return b(cVar, callableMemberDescriptor, z3);
    }

    @NotNull
    public static final Method d(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor descriptor) {
        f0.p(cls, "<this>");
        f0.p(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, descriptor).getReturnType());
            f0.o(declaredMethod, "{\n        getDeclaredMet\u2026riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    private static final e0 e(CallableMemberDescriptor callableMemberDescriptor) {
        s0 Q = callableMemberDescriptor.Q();
        s0 M = callableMemberDescriptor.M();
        if (Q != null) {
            return Q.getType();
        }
        if (M == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof j) {
            return M.getType();
        }
        k b4 = callableMemberDescriptor.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
        if (dVar == null) {
            return null;
        }
        return dVar.q();
    }

    @NotNull
    public static final Method f(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor descriptor) {
        f0.p(cls, "<this>");
        f0.p(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            f0.o(declaredMethod, "{\n        getDeclaredMet\u2026LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    private static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        e0 e4 = e(callableMemberDescriptor);
        return e4 != null && kotlin.reflect.jvm.internal.impl.resolve.e.c(e4);
    }

    @Nullable
    public static final Class<?> h(@Nullable k kVar) {
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && kotlin.reflect.jvm.internal.impl.resolve.e.b(kVar)) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
            Class<?> p3 = kotlin.reflect.jvm.internal.f0.p(dVar);
            if (p3 != null) {
                return p3;
            }
            throw new KotlinReflectionInternalError("Class object for the class " + dVar.getName() + " cannot be found (classId=" + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar) + ')');
        }
        return null;
    }

    @Nullable
    public static final Class<?> i(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return h(e0Var.H0().b());
    }
}
