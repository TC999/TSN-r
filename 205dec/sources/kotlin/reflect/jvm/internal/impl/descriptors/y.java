package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: InvalidModuleException.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final c0<z> f56638a = new c0<>("InvalidModuleNotifier");

    public static final void a(@NotNull d0 d0Var) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        z zVar = (z) d0Var.D0(f56638a);
        if (zVar == null) {
            throw new InvalidModuleException(kotlin.jvm.internal.f0.C("Accessing invalid module descriptor ", d0Var));
        }
        zVar.a(d0Var);
    }
}
