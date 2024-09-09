package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResolutionAnchorProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final c0<k> f57883a = new c0<>("ResolutionAnchorProvider");

    @Nullable
    public static final d0 a(@NotNull d0 d0Var) {
        f0.p(d0Var, "<this>");
        k kVar = (k) d0Var.D0(f57883a);
        if (kVar == null) {
            return null;
        }
        return kVar.a(d0Var);
    }
}
