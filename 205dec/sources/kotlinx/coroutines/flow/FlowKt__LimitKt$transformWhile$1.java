package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Limit.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0, 0, 0}, l = {154}, m = "invokeSuspend", n = {"$this$flow", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__LimitKt$transformWhile$1<R> extends SuspendLambda implements d2.p<i<? super R>, kotlin.coroutines.c<? super f1>, Object> {

    /* renamed from: a  reason: collision with root package name */
    private i f59762a;

    /* renamed from: b  reason: collision with root package name */
    Object f59763b;

    /* renamed from: c  reason: collision with root package name */
    Object f59764c;

    /* renamed from: d  reason: collision with root package name */
    Object f59765d;

    /* renamed from: e  reason: collision with root package name */
    int f59766e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ h f59767f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ d2.q f59768g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$transformWhile$1(h hVar, d2.q qVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.f59767f = hVar;
        this.f59768g = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.f59767f, this.f59768g, cVar);
        flowKt__LimitKt$transformWhile$1.f59762a = (i) obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    @Override // d2.p
    public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__LimitKt$transformWhile$1) create(obj, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.f59766e;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            i iVar = this.f59762a;
            h hVar = this.f59767f;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this, iVar);
            try {
                this.f59763b = iVar;
                this.f59764c = hVar;
                this.f59765d = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                this.f59766e = 1;
                if (hVar.e(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12, this) == h4) {
                    return h4;
                }
            } catch (AbortFlowException e4) {
                e = e4;
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                kotlinx.coroutines.flow.internal.m.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return f1.f55527a;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.f59765d;
            h hVar2 = (h) this.f59764c;
            i iVar2 = (i) this.f59763b;
            try {
                kotlin.d0.n(obj);
            } catch (AbortFlowException e5) {
                e = e5;
                kotlinx.coroutines.flow.internal.m.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return f1.f55527a;
            }
        }
        return f1.f55527a;
    }
}
