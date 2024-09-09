package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharingStarted.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/d0;", "", "Lkotlinx/coroutines/flow/h0;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60004a = a.f60007c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SharingStarted.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/flow/d0$a;", "", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/d0;", "a", "Lkotlinx/coroutines/flow/d0;", "c", "()Lkotlinx/coroutines/flow/d0;", "Eagerly", "b", "d", "Lazily", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ a f60007c = new a();
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private static final d0 f60005a = new f0();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final d0 f60006b = new StartedLazily();

        private a() {
        }

        public static /* synthetic */ d0 b(a aVar, long j4, long j5, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j4 = 0;
            }
            if ((i4 & 2) != 0) {
                j5 = Long.MAX_VALUE;
            }
            return aVar.a(j4, j5);
        }

        @NotNull
        public final d0 a(long j4, long j5) {
            return new g0(j4, j5);
        }

        @NotNull
        public final d0 c() {
            return f60005a;
        }

        @NotNull
        public final d0 d() {
            return f60006b;
        }
    }

    @NotNull
    h<SharingCommand> a(@NotNull h0<Integer> h0Var);
}
