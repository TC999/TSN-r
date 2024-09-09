package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final o f58302a = new o();

    private o() {
    }

    public final boolean a(@NotNull l1 type) {
        f0.p(type, "type");
        return kotlin.reflect.jvm.internal.impl.types.c.f58268a.a(q.f58304a.z0(false, true), b0.c(type), TypeCheckerState.a.b.f58261a);
    }
}
