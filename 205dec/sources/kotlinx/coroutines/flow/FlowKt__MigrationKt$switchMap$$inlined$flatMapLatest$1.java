package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {0, 0, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF}, m = "invokeSuspend", n = {"$this$transformLatest", "it", "$this$transformLatest", "it", "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1<R, T> extends SuspendLambda implements d2.q<i<? super R>, T, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ d2.p $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private i p$;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(d2.p pVar, kotlin.coroutines.c cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    @NotNull
    public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, cVar);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.p$ = iVar;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.p$0 = t3;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d2.q
    public final Object invoke(Object obj, Object obj2, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1) create((i) obj, obj2, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        i<? super T> iVar;
        i<? super T> iVar2;
        Object obj2;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.label;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            iVar = this.p$;
            Object obj3 = this.p$0;
            d2.p pVar = this.$transform;
            this.L$0 = iVar;
            this.L$1 = obj3;
            this.L$2 = iVar;
            this.label = 1;
            Object invoke = pVar.invoke(obj3, this);
            if (invoke == h4) {
                return h4;
            }
            iVar2 = iVar;
            obj2 = obj3;
            obj = invoke;
        } else if (i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h hVar = (h) this.L$3;
            i iVar3 = (i) this.L$2;
            i iVar4 = (i) this.L$0;
            kotlin.d0.n(obj);
            return f1.f55527a;
        } else {
            iVar = (i) this.L$2;
            obj2 = this.L$1;
            iVar2 = (i) this.L$0;
            kotlin.d0.n(obj);
        }
        h hVar2 = (h) obj;
        this.L$0 = iVar2;
        this.L$1 = obj2;
        this.L$2 = iVar;
        this.L$3 = hVar2;
        this.label = 2;
        if (hVar2.e(iVar, this) == h4) {
            return h4;
        }
        return f1.f55527a;
    }
}
