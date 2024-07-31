package kotlinx.coroutines.flow;

import com.p518qq.p519e.comm.adevent.AdEventType;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: SharingStarted.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/SharingCommand;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.StartedLazily$command$1", m8638f = "SharingStarted.kt", m8637i = {0, 0, 0}, m8636l = {AdEventType.VIDEO_PRELOADED}, m8635m = "invokeSuspend", m8634n = {"$this$flow", "started", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class StartedLazily$command$1 extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super SharingStarted>, InterfaceC14268c<? super Unit>, Object> {

    /* renamed from: a */
    private FlowCollector f42660a;

    /* renamed from: b */
    Object f42661b;

    /* renamed from: c */
    Object f42662c;

    /* renamed from: d */
    Object f42663d;

    /* renamed from: e */
    int f42664e;

    /* renamed from: f */
    final /* synthetic */ StateFlow f42665f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(StateFlow stateFlow, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.f42665f = stateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.f42665f, interfaceC14268c);
        startedLazily$command$1.f42660a = (FlowCollector) obj;
        return startedLazily$command$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(FlowCollector<? super SharingStarted> flowCollector, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((StartedLazily$command$1) create(flowCollector, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.f42664e;
        if (i == 0) {
            C14294d0.m8596n(obj);
            FlowCollector flowCollector = this.f42660a;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            StateFlow stateFlow = this.f42665f;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(flowCollector, booleanRef);
            this.f42661b = flowCollector;
            this.f42662c = booleanRef;
            this.f42663d = stateFlow;
            this.f42664e = 1;
            if (stateFlow.mo4470e(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            InterfaceC14958h interfaceC14958h = (InterfaceC14958h) this.f42663d;
            Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.f42662c;
            FlowCollector flowCollector2 = (FlowCollector) this.f42661b;
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
