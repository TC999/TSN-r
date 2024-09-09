package kotlinx.coroutines.selects;

import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SelectUnbiased.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/a;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "a", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @Nullable
    public static final <R> Object a(@NotNull l<? super a<? super R>, f1> lVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        j jVar = new j(cVar);
        try {
            lVar.invoke(jVar);
        } catch (Throwable th) {
            jVar.e(th);
        }
        Object f4 = jVar.f();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (f4 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return f4;
    }

    @Nullable
    private static final Object b(@NotNull l lVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        c0.e(0);
        j jVar = new j(cVar);
        try {
            lVar.invoke(jVar);
        } catch (Throwable th) {
            jVar.e(th);
        }
        Object f4 = jVar.f();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (f4 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        c0.e(1);
        return f4;
    }
}
