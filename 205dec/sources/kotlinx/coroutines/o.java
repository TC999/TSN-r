package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'\u00a2\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\tH'J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H'J\b\u0010\u0015\u001a\u00020\rH'J\u0014\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&J1\u0010\u001a\u001a\u00020\r2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u0018H&J\u001b\u0010\u001c\u001a\u00020\r*\u00020\u001b2\u0006\u0010\u0003\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\r*\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\tH'J<\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'\u00a2\u0006\u0004\b\u0001\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010!\u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/o;", "T", "Lkotlin/coroutines/c;", "value", "", "idempotent", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "n", "(Ljava/lang/Object;Ljava/lang/Object;Ld2/l;)Ljava/lang/Object;", "exception", "o", "token", "S", "H", "", "a", "Lkotlinx/coroutines/CompletionHandler;", "handler", "B", "Lkotlinx/coroutines/l0;", "G", "(Lkotlinx/coroutines/l0;Ljava/lang/Object;)V", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Object;Ld2/l;)V", "isActive", "()Z", "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface o<T> extends kotlin.coroutines.c<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CancellableContinuation.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static /* synthetic */ boolean a(o oVar, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return oVar.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Object b(o oVar, Object obj, Object obj2, int i4, Object obj3) {
            if (obj3 == null) {
                if ((i4 & 2) != 0) {
                    obj2 = null;
                }
                return oVar.d(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    void B(@NotNull d2.l<? super Throwable, kotlin.f1> lVar);

    @ExperimentalCoroutinesApi
    void G(@NotNull l0 l0Var, T t3);

    @InternalCoroutinesApi
    void H();

    @InternalCoroutinesApi
    void S(@NotNull Object obj);

    @ExperimentalCoroutinesApi
    void T(T t3, @Nullable d2.l<? super Throwable, kotlin.f1> lVar);

    boolean a(@Nullable Throwable th);

    @InternalCoroutinesApi
    @Nullable
    Object d(T t3, @Nullable Object obj);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @InternalCoroutinesApi
    @Nullable
    Object n(T t3, @Nullable Object obj, @Nullable d2.l<? super Throwable, kotlin.f1> lVar);

    @InternalCoroutinesApi
    @Nullable
    Object o(@NotNull Throwable th);

    @ExperimentalCoroutinesApi
    void q(@NotNull l0 l0Var, @NotNull Throwable th);
}
