package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: inlineClassesUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57866a = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmInline");

    public static final boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        f0.p(aVar, "<this>");
        if (aVar instanceof q0) {
            p0 correspondingProperty = ((q0) aVar).V();
            f0.o(correspondingProperty, "correspondingProperty");
            if (d(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        f0.p(kVar, "<this>");
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
            if (dVar.isInline() || dVar.v()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 == null) {
            return false;
        }
        return b(b4);
    }

    public static final boolean d(@NotNull f1 f1Var) {
        x<m0> z3;
        f0.p(f1Var, "<this>");
        if (f1Var.Q() == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = f1Var.b();
            kotlin.reflect.jvm.internal.impl.name.f fVar = null;
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
            if (dVar != null && (z3 = dVar.z()) != null) {
                fVar = z3.a();
            }
            if (f0.g(fVar, f1Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final e0 e(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        e0 f4 = f(e0Var);
        if (f4 == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.types.f1.f(e0Var).p(f4, Variance.INVARIANT);
    }

    @Nullable
    public static final e0 f(@NotNull e0 e0Var) {
        x<m0> z3;
        f0.p(e0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (!(b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            b4 = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        if (dVar == null || (z3 = dVar.z()) == null) {
            return null;
        }
        return z3.b();
    }
}
