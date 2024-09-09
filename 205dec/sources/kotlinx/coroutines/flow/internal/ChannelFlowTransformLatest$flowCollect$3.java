package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {0, 0, 0}, l = {101}, m = "invokeSuspend", n = {"$this$flowScope", "previousFlow", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

    /* renamed from: a  reason: collision with root package name */
    private q0 f60053a;

    /* renamed from: b  reason: collision with root package name */
    Object f60054b;

    /* renamed from: c  reason: collision with root package name */
    Object f60055c;

    /* renamed from: d  reason: collision with root package name */
    Object f60056d;

    /* renamed from: e  reason: collision with root package name */
    int f60057e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ChannelFlowTransformLatest f60058f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.flow.i f60059g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.f60058f = channelFlowTransformLatest;
        this.f60059g = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.f60058f, this.f60059g, cVar);
        channelFlowTransformLatest$flowCollect$3.f60053a = (q0) obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // d2.p
    public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.f60057e;
        if (i4 == 0) {
            d0.n(obj);
            q0 q0Var = this.f60053a;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            kotlinx.coroutines.flow.h<S> hVar = this.f60058f.f60143d;
            ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(this, q0Var, objectRef);
            this.f60054b = q0Var;
            this.f60055c = objectRef;
            this.f60056d = hVar;
            this.f60057e = 1;
            if (hVar.e(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlinx.coroutines.flow.h hVar2 = (kotlinx.coroutines.flow.h) this.f60056d;
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.f60055c;
            q0 q0Var2 = (q0) this.f60054b;
            d0.n(obj);
        }
        return f1.f55527a;
    }
}
