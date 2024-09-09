package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Channel.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J-\u0010\u0011\u001a\u00020\u00042#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\rH'R\u001a\u0010\u0016\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u001a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/h0;", "E", "", "element", "Lkotlin/f1;", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "K", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "f", "P", "()Z", "isClosedForSend$annotations", "()V", "isClosedForSend", "p", "isFull$annotations", "isFull", "Lkotlinx/coroutines/selects/e;", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface h0<E> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static /* synthetic */ boolean a(h0 h0Var, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return h0Var.K(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void b() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed in next releases without replacement")
        @ExperimentalCoroutinesApi
        public static /* synthetic */ void c() {
        }
    }

    boolean K(@Nullable Throwable th);

    @Nullable
    Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar);

    boolean P();

    @ExperimentalCoroutinesApi
    void f(@NotNull d2.l<? super Throwable, f1> lVar);

    boolean offer(E e4);

    boolean p();

    @NotNull
    kotlinx.coroutines.selects.e<E, h0<E>> r();
}
