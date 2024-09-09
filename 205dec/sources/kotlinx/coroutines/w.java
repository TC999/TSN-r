package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Job.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/u2;", "parentJob", "Lkotlin/f1;", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface w extends e2 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Job.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static <R> R b(@NotNull w wVar, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) e2.a.d(wVar, r3, pVar);
        }

        @Nullable
        public static <E extends f.b> E c(@NotNull w wVar, @NotNull f.c<E> cVar) {
            return (E) e2.a.e(wVar, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f d(@NotNull w wVar, @NotNull f.c<?> cVar) {
            return e2.a.g(wVar, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f e(@NotNull w wVar, @NotNull kotlin.coroutines.f fVar) {
            return e2.a.h(wVar, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 f(@NotNull w wVar, @NotNull e2 e2Var) {
            return e2.a.i(wVar, e2Var);
        }
    }

    @InternalCoroutinesApi
    void i(@NotNull u2 u2Var);
}
