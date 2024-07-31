package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Merge.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", m8638f = "Merge.kt", m8637i = {0, 0, 0}, m8636l = {101}, m8635m = "invokeSuspend", m8634n = {"$this$flowScope", "previousFlow", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

    /* renamed from: a */
    private CoroutineScope f42736a;

    /* renamed from: b */
    Object f42737b;

    /* renamed from: c */
    Object f42738c;

    /* renamed from: d */
    Object f42739d;

    /* renamed from: e */
    int f42740e;

    /* renamed from: f */
    final /* synthetic */ ChannelFlowTransformLatest f42741f;

    /* renamed from: g */
    final /* synthetic */ FlowCollector f42742g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.f42741f = channelFlowTransformLatest;
        this.f42742g = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.f42741f, this.f42742g, interfaceC14268c);
        channelFlowTransformLatest$flowCollect$3.f42736a = (CoroutineScope) obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.f42740e;
        if (i == 0) {
            C14294d0.m8596n(obj);
            CoroutineScope coroutineScope = this.f42736a;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            InterfaceC14958h<S> interfaceC14958h = this.f42741f.f42826d;
            C14963xfa64eeb5 c14963xfa64eeb5 = new C14963xfa64eeb5(this, coroutineScope, objectRef);
            this.f42737b = coroutineScope;
            this.f42738c = objectRef;
            this.f42739d = interfaceC14958h;
            this.f42740e = 1;
            if (interfaceC14958h.mo4470e(c14963xfa64eeb5, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42739d;
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.f42738c;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.f42737b;
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
