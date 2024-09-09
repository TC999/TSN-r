package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContextElement.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/i3;", "S", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "context", "Q", "(Lkotlin/coroutines/f;)Ljava/lang/Object;", "oldState", "Lkotlin/f1;", "u", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface i3<S> extends f.b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ThreadContextElement.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <S, R> R a(@NotNull i3<S> i3Var, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(i3Var, r3, pVar);
        }

        @Nullable
        public static <S, E extends f.b> E b(@NotNull i3<S> i3Var, @NotNull f.c<E> cVar) {
            return (E) f.b.a.b(i3Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.f c(@NotNull i3<S> i3Var, @NotNull f.c<?> cVar) {
            return f.b.a.c(i3Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.f d(@NotNull i3<S> i3Var, @NotNull kotlin.coroutines.f fVar) {
            return f.b.a.d(i3Var, fVar);
        }
    }

    S Q(@NotNull kotlin.coroutines.f fVar);

    void u(@NotNull kotlin.coroutines.f fVar, S s3);
}
