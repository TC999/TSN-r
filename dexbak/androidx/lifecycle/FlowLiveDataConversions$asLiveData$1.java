package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowLiveData.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 1})
@DebugMetadata(m8639c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", m8638f = "FlowLiveData.kt", m8637i = {}, m8636l = {149}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class FlowLiveDataConversions$asLiveData$1<T> extends SuspendLambda implements InterfaceC15284p<LiveDataScope<T>, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC14958h $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asLiveData$1(InterfaceC14958h interfaceC14958h, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$this_asLiveData = interfaceC14958h;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8184p(completion, "completion");
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, completion);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((FlowLiveDataConversions$asLiveData$1) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            InterfaceC14958h interfaceC14958h = this.$this_asLiveData;
            FlowCollector<T> flowCollector = new FlowCollector<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj2, @NotNull InterfaceC14268c interfaceC14268c) {
                    Object m8642h2;
                    Object emit = LiveDataScope.this.emit(obj2, interfaceC14268c);
                    m8642h2 = C14287b.m8642h();
                    return emit == m8642h2 ? emit : Unit.f41048a;
                }
            };
            this.label = 1;
            if (interfaceC14958h.mo4470e(flowCollector, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
