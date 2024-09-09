package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "h0", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface CoroutineExceptionHandler extends f.b {

    /* renamed from: h0  reason: collision with root package name */
    public static final b f59029h0 = b.f59030a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <R> R a(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(coroutineExceptionHandler, r3, pVar);
        }

        @Nullable
        public static <E extends f.b> E b(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull f.c<E> cVar) {
            return (E) f.b.a.b(coroutineExceptionHandler, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f c(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull f.c<?> cVar) {
            return f.b.a.c(coroutineExceptionHandler, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f d(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull kotlin.coroutines.f fVar) {
            return f.b.a.d(coroutineExceptionHandler, fVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$b;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements f.c<CoroutineExceptionHandler> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f59030a = new b();

        private b() {
        }
    }

    void handleException(@NotNull kotlin.coroutines.f fVar, @NotNull Throwable th);
}
