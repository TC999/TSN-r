package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassicTypeCheckerState.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull
    public static final TypeCheckerState a(boolean z3, boolean z4, @NotNull b typeSystemContext, @NotNull f kotlinTypePreparator, @NotNull g kotlinTypeRefiner) {
        f0.p(typeSystemContext, "typeSystemContext");
        f0.p(kotlinTypePreparator, "kotlinTypePreparator");
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeCheckerState(z3, z4, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ TypeCheckerState b(boolean z3, boolean z4, b bVar, f fVar, g gVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = true;
        }
        if ((i4 & 4) != 0) {
            bVar = q.f58304a;
        }
        if ((i4 & 8) != 0) {
            fVar = f.a.f58277a;
        }
        if ((i4 & 16) != 0) {
            gVar = g.a.f58278a;
        }
        return a(z3, z4, bVar, fVar, gVar);
    }
}
