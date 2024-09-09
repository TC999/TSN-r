package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.flow.d0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharingStarted.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/flow/d0$a;", "Lkotlin/time/d;", "stopTimeout", "replayExpiration", "Lkotlinx/coroutines/flow/d0;", "a", "(Lkotlinx/coroutines/flow/d0$a;DD)Lkotlinx/coroutines/flow/d0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 {
    @ExperimentalTime
    @NotNull
    public static final d0 a(@NotNull d0.a aVar, double d4, double d5) {
        return new g0(kotlin.time.d.toLongMilliseconds-impl(d4), kotlin.time.d.toLongMilliseconds-impl(d5));
    }

    public static /* synthetic */ d0 b(d0.a aVar, double d4, double d5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            d4 = kotlin.time.d.f58993b.getZERO-UwyO8pc();
        }
        if ((i4 & 2) != 0) {
            d5 = kotlin.time.d.f58993b.getINFINITE-UwyO8pc();
        }
        return a(aVar, d4, d5);
    }
}
