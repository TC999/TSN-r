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
/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1", f = "Zip.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1<R, T> extends SuspendLambda implements d2.q<i<? super R>, T[], kotlin.coroutines.c<? super f1>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private i p$;
    private Object[] p$0;
    final /* synthetic */ FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1(kotlin.coroutines.c cVar, FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2 flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2) {
        super(3, cVar);
        this.this$0 = flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2;
    }

    @NotNull
    public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull T[] tArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1 flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1 = new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1(cVar, this.this$0);
        flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1.p$ = iVar;
        flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1.p$0 = tArr;
        return flowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d2.q
    public final Object invoke(Object obj, Object obj2, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$2$lambda$1) create((i) obj, (Object[]) obj2, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        i iVar;
        i iVar2;
        Object[] objArr;
        h4 = kotlin.coroutines.intrinsics.b.h();
        int i4 = this.label;
        if (i4 == 0) {
            kotlin.d0.n(obj);
            iVar = this.p$;
            Object[] objArr2 = this.p$0;
            d2.p pVar = this.this$0.f59961b;
            this.L$0 = iVar;
            this.L$1 = objArr2;
            this.L$2 = iVar;
            this.label = 1;
            Object invoke = pVar.invoke(objArr2, this);
            if (invoke == h4) {
                return h4;
            }
            iVar2 = iVar;
            objArr = objArr2;
            obj = invoke;
        } else if (i4 != 1) {
            if (i4 == 2) {
                Object[] objArr3 = (Object[]) this.L$1;
                i iVar3 = (i) this.L$0;
                kotlin.d0.n(obj);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            iVar = (i) this.L$2;
            objArr = (Object[]) this.L$1;
            iVar2 = (i) this.L$0;
            kotlin.d0.n(obj);
        }
        this.L$0 = iVar2;
        this.L$1 = objArr;
        this.label = 2;
        if (iVar.emit(obj, this) == h4) {
            return h4;
        }
        return f1.f55527a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        i iVar = this.p$;
        Object invoke = this.this$0.f59961b.invoke(this.p$0, this);
        kotlin.jvm.internal.c0.e(0);
        iVar.emit(invoke, this);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}
