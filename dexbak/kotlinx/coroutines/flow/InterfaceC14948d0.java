package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/flow/d0;", "", "Lkotlinx/coroutines/flow/h0;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.d0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14948d0 {

    /* renamed from: a */
    public static final C14949a f42687a = C14949a.f42690c;

    /* compiled from: SharingStarted.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/flow/d0$a;", "", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/d0;", "a", "Lkotlinx/coroutines/flow/d0;", "c", "()Lkotlinx/coroutines/flow/d0;", "Eagerly", "b", "d", "Lazily", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.d0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14949a {

        /* renamed from: c */
        static final /* synthetic */ C14949a f42690c = new C14949a();
        @NotNull

        /* renamed from: a */
        private static final InterfaceC14948d0 f42688a = new C14953f0();
        @NotNull

        /* renamed from: b */
        private static final InterfaceC14948d0 f42689b = new StartedLazily();

        private C14949a() {
        }

        /* renamed from: b */
        public static /* synthetic */ InterfaceC14948d0 m4821b(C14949a c14949a, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = Long.MAX_VALUE;
            }
            return c14949a.m4822a(j, j2);
        }

        @NotNull
        /* renamed from: a */
        public final InterfaceC14948d0 m4822a(long j, long j2) {
            return new C14955g0(j, j2);
        }

        @NotNull
        /* renamed from: c */
        public final InterfaceC14948d0 m4820c() {
            return f42688a;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14948d0 m4819d() {
            return f42689b;
        }
    }

    @NotNull
    /* renamed from: a */
    InterfaceC14958h<SharingStarted> mo4814a(@NotNull StateFlow<Integer> stateFlow);
}
