package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Future.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/e2;", "Ljava/util/concurrent/Future;", "future", "Lkotlinx/coroutines/i1;", "b", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class i2 {
    public static final void a(@NotNull o<?> oVar, @NotNull Future<?> future) {
        oVar.B(new k(future));
    }

    @InternalCoroutinesApi
    @NotNull
    public static final i1 b(@NotNull e2 e2Var, @NotNull Future<?> future) {
        return e2Var.m(new l(e2Var, future));
    }
}
