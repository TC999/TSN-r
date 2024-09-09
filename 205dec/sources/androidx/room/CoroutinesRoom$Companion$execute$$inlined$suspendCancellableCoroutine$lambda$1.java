package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutinesRoom.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/CoroutinesRoom$Companion$execute$4$job$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1 extends SuspendLambda implements d2.p<kotlinx.coroutines.q0, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ Callable $callable$inlined;
    final /* synthetic */ CancellationSignal $cancellationSignal$inlined;
    final /* synthetic */ kotlin.coroutines.d $context$inlined;
    final /* synthetic */ kotlinx.coroutines.o $continuation;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(kotlinx.coroutines.o oVar, kotlin.coroutines.c cVar, kotlin.coroutines.d dVar, Callable callable, CancellationSignal cancellationSignal) {
        super(2, cVar);
        this.$continuation = oVar;
        this.$context$inlined = dVar;
        this.$callable$inlined = callable;
        this.$cancellationSignal$inlined = cancellationSignal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
        kotlin.jvm.internal.f0.p(completion, "completion");
        return new CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(this.$continuation, completion, this.$context$inlined, this.$callable$inlined, this.$cancellationSignal$inlined);
    }

    @Override // d2.p
    public final Object invoke(kotlinx.coroutines.q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
        return ((CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.b.h();
        if (this.label == 0) {
            kotlin.d0.n(obj);
            try {
                Object call = this.$callable$inlined.call();
                kotlinx.coroutines.o oVar = this.$continuation;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(call));
            } catch (Throwable th) {
                kotlinx.coroutines.o oVar2 = this.$continuation;
                Result.a aVar2 = Result.Companion;
                oVar2.resumeWith(Result.m119constructorimpl(kotlin.d0.a(th)));
            }
            return f1.f55527a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
