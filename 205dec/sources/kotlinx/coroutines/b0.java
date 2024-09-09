package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableJob.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/b0;", "Lkotlinx/coroutines/e2;", "", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "exception", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b0 extends e2 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CompletableJob.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static <R> R b(@NotNull b0 b0Var, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) e2.a.d(b0Var, r3, pVar);
        }

        @Nullable
        public static <E extends f.b> E c(@NotNull b0 b0Var, @NotNull f.c<E> cVar) {
            return (E) e2.a.e(b0Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f d(@NotNull b0 b0Var, @NotNull f.c<?> cVar) {
            return e2.a.g(b0Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f e(@NotNull b0 b0Var, @NotNull kotlin.coroutines.f fVar) {
            return e2.a.h(b0Var, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 f(@NotNull b0 b0Var, @NotNull e2 e2Var) {
            return e2.a.i(b0Var, e2Var);
        }
    }

    boolean c(@NotNull Throwable th);

    boolean complete();
}
