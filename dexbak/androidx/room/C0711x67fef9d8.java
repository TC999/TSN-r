package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterfaceC15146o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: CoroutinesRoom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/CoroutinesRoom$Companion$execute$4$job$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
@DebugMetadata(m8639c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", m8638f = "CoroutinesRoom.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
/* renamed from: androidx.room.CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class C0711x67fef9d8 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ Callable $callable$inlined;
    final /* synthetic */ CancellationSignal $cancellationSignal$inlined;
    final /* synthetic */ ContinuationInterceptor $context$inlined;
    final /* synthetic */ InterfaceC15146o $continuation;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0711x67fef9d8(InterfaceC15146o interfaceC15146o, InterfaceC14268c interfaceC14268c, ContinuationInterceptor continuationInterceptor, Callable callable, CancellationSignal cancellationSignal) {
        super(2, interfaceC14268c);
        this.$continuation = interfaceC15146o;
        this.$context$inlined = continuationInterceptor;
        this.$callable$inlined = callable;
        this.$cancellationSignal$inlined = cancellationSignal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        return new C0711x67fef9d8(this.$continuation, completion, this.$context$inlined, this.$callable$inlined, this.$cancellationSignal$inlined);
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((C0711x67fef9d8) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        C14287b.m8642h();
        if (this.label == 0) {
            C14294d0.m8596n(obj);
            try {
                Object call = this.$callable$inlined.call();
                InterfaceC15146o interfaceC15146o = this.$continuation;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(call));
            } catch (Throwable th) {
                InterfaceC15146o interfaceC15146o2 = this.$continuation;
                Result.C14124a c14124a2 = Result.Companion;
                interfaceC15146o2.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
            }
            return Unit.f41048a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
