package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.flow.InterfaceC14948d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m12616d2 = {"Lkotlinx/coroutines/flow/d0$a;", "Lkotlin/time/d;", "stopTimeout", "replayExpiration", "Lkotlinx/coroutines/flow/d0;", "a", "(Lkotlinx/coroutines/flow/d0$a;DD)Lkotlinx/coroutines/flow/d0;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14951e0 {
    @ExperimentalTime
    @NotNull
    /* renamed from: a */
    public static final InterfaceC14948d0 m4817a(@NotNull InterfaceC14948d0.C14949a c14949a, double d, double d2) {
        return new C14955g0(Duration.toLongMilliseconds-impl(d), Duration.toLongMilliseconds-impl(d2));
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC14948d0 m4816b(InterfaceC14948d0.C14949a c14949a, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = Duration.f41658e.getZERO-UwyO8pc();
        }
        if ((i & 2) != 0) {
            d2 = Duration.f41658e.getINFINITE-UwyO8pc();
        }
        return m4817a(c14949a, d, d2);
    }
}
