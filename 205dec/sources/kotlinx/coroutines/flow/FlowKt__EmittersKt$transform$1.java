package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Emitters.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY}, m = "invokeSuspend", n = {"$this$flow", "$this$collect$iv"}, s = {"L$0", "L$1"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__EmittersKt$transform$1<R> extends SuspendLambda implements d2.p<i<? super R>, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ h $this_transform;
    final /* synthetic */ d2.q $transform;
    Object L$0;
    Object L$1;
    int label;
    private i p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1(h hVar, d2.q qVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.$this_transform = hVar;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, cVar);
        flowKt__EmittersKt$transform$1.p$ = (i) obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // d2.p
    public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__EmittersKt$transform$1) create(obj, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.label;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            i iVar = this.p$;
            h hVar = this.$this_transform;
            FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this, iVar);
            this.L$0 = iVar;
            this.L$1 = hVar;
            this.label = 1;
            if (hVar.e(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            h hVar2 = (h) this.L$1;
            i iVar2 = (i) this.L$0;
            kotlin.d0.n(obj);
        }
        return f1.f55527a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        i iVar = this.p$;
        h hVar = this.$this_transform;
        FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this, iVar);
        kotlin.jvm.internal.c0.e(0);
        hVar.e(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}
