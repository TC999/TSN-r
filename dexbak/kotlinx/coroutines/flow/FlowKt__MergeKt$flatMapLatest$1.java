package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Merge.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", m8638f = "Merge.kt", m8637i = {0, 0, 1, 1, 1, 1}, m8636l = {190, 216}, m8635m = "invokeSuspend", m8634n = {"$this$transformLatest", "it", "$this$transformLatest", "it", "$this$emitAll$iv", "flow$iv"}, m8633s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__MergeKt$flatMapLatest$1<R, T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, T, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC15284p $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* renamed from: p$ */
    private FlowCollector f42459p$;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$flatMapLatest$1(InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
        super(3, interfaceC14268c);
        this.$transform = interfaceC15284p;
    }

    @NotNull
    public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, interfaceC14268c);
        flowKt__MergeKt$flatMapLatest$1.f42459p$ = flowCollector;
        flowKt__MergeKt$flatMapLatest$1.p$0 = t;
        return flowKt__MergeKt$flatMapLatest$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p617l1.InterfaceC15285q
    public final Object invoke(Object obj, Object obj2, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((FlowKt__MergeKt$flatMapLatest$1) create((FlowCollector) obj, obj2, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        FlowCollector<? super T> flowCollector;
        FlowCollector<? super T> flowCollector2;
        Object obj2;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            flowCollector = this.f42459p$;
            Object obj3 = this.p$0;
            InterfaceC15284p interfaceC15284p = this.$transform;
            this.L$0 = flowCollector;
            this.L$1 = obj3;
            this.L$2 = flowCollector;
            this.label = 1;
            Object invoke = interfaceC15284p.invoke(obj3, this);
            if (invoke == m8642h) {
                return m8642h;
            }
            flowCollector2 = flowCollector;
            obj2 = obj3;
            obj = invoke;
        } else if (i != 1) {
            if (i == 2) {
                InterfaceC14958h interfaceC14958h = (InterfaceC14958h) this.L$3;
                FlowCollector flowCollector3 = (FlowCollector) this.L$2;
                FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                C14294d0.m8596n(obj);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$2;
            obj2 = this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            C14294d0.m8596n(obj);
        }
        InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) obj;
        this.L$0 = flowCollector2;
        this.L$1 = obj2;
        this.L$2 = flowCollector;
        this.L$3 = interfaceC14958h2;
        this.label = 2;
        if (interfaceC14958h2.mo4470e(flowCollector, this) == m8642h) {
            return m8642h;
        }
        return Unit.f41048a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector<? super T> flowCollector = this.f42459p$;
        Object obj2 = this.p$0;
        InlineMarker.m8227e(0);
        ((InterfaceC14958h) this.$transform.invoke(obj2, this)).mo4470e(flowCollector, this);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return Unit.f41048a;
    }
}
