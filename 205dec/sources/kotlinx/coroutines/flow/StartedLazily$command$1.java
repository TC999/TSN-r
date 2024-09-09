package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharingStarted.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/SharingCommand;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {0, 0, 0}, l = {212}, m = "invokeSuspend", n = {"$this$flow", "started", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class StartedLazily$command$1 extends SuspendLambda implements d2.p<i<? super SharingCommand>, kotlin.coroutines.c<? super f1>, Object> {

    /* renamed from: a  reason: collision with root package name */
    private i f59977a;

    /* renamed from: b  reason: collision with root package name */
    Object f59978b;

    /* renamed from: c  reason: collision with root package name */
    Object f59979c;

    /* renamed from: d  reason: collision with root package name */
    Object f59980d;

    /* renamed from: e  reason: collision with root package name */
    int f59981e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ h0 f59982f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(h0 h0Var, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.f59982f = h0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.f59982f, cVar);
        startedLazily$command$1.f59977a = (i) obj;
        return startedLazily$command$1;
    }

    @Override // d2.p
    public final Object invoke(i<? super SharingCommand> iVar, kotlin.coroutines.c<? super f1> cVar) {
        return ((StartedLazily$command$1) create(iVar, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.f59981e;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            i iVar = this.f59977a;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            h0 h0Var = this.f59982f;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(iVar, booleanRef);
            this.f59978b = iVar;
            this.f59979c = booleanRef;
            this.f59980d = h0Var;
            this.f59981e = 1;
            if (h0Var.e(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            h hVar = (h) this.f59980d;
            Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.f59979c;
            i iVar2 = (i) this.f59978b;
            kotlin.d0.n(obj);
        }
        return f1.f55527a;
    }
}
