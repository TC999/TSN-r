package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Yield.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"Lkotlin/f1;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v3 {
    public static final void a(@NotNull kotlin.coroutines.f fVar) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var != null && !e2Var.isActive()) {
            throw e2Var.l();
        }
    }

    @Nullable
    public static final Object b(@NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        kotlin.coroutines.c d4;
        Object obj;
        Object h4;
        Object h5;
        kotlin.coroutines.f context = cVar.getContext();
        a(context);
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        if (!(d4 instanceof kotlinx.coroutines.internal.j)) {
            d4 = null;
        }
        kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) d4;
        if (jVar != null) {
            if (jVar.f60372g.isDispatchNeeded(context)) {
                jVar.l(context, kotlin.f1.f55527a);
            } else {
                u3 u3Var = new u3();
                kotlin.coroutines.f plus = context.plus(u3Var);
                obj = kotlin.f1.f55527a;
                jVar.l(plus, obj);
                if (u3Var.f60744a) {
                    if (kotlinx.coroutines.internal.k.h(jVar)) {
                        obj = kotlin.coroutines.intrinsics.b.h();
                    }
                }
            }
            obj = kotlin.coroutines.intrinsics.b.h();
        } else {
            obj = kotlin.f1.f55527a;
        }
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (obj == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        h5 = kotlin.coroutines.intrinsics.b.h();
        return obj == h5 ? obj : kotlin.f1.f55527a;
    }
}
