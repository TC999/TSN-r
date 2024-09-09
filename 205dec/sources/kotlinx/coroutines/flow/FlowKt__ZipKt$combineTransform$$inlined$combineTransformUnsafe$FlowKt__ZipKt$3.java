package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", i = {0}, l = {273}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3<R> extends SuspendLambda implements d2.p<i<? super R>, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ h[] $flows;
    final /* synthetic */ d2.s $transform$inlined;
    Object L$0;
    int label;
    private i p$;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Zip.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", i = {0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "continuation", "args", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements d2.q<i<? super R>, Object[], kotlin.coroutines.c<? super f1>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        private i p$;
        private Object[] p$0;

        public AnonymousClass1(kotlin.coroutines.c cVar) {
            super(3, cVar);
        }

        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.p$ = iVar;
            anonymousClass1.p$0 = objArr;
            return anonymousClass1;
        }

        @Override // d2.q
        public final Object invoke(Object obj, Object[] objArr, kotlin.coroutines.c<? super f1> cVar) {
            return ((AnonymousClass1) create((i) obj, objArr, cVar)).invokeSuspend(f1.f55527a);
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
                Object[] objArr = this.p$0;
                d2.s sVar = FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3.this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.L$0 = iVar;
                this.L$1 = objArr;
                this.L$2 = this;
                this.L$3 = objArr;
                this.L$4 = iVar;
                this.label = 1;
                kotlin.jvm.internal.c0.e(6);
                Object invoke = sVar.invoke(iVar, obj2, obj3, obj4, this);
                kotlin.jvm.internal.c0.e(7);
                if (invoke == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i iVar2 = (i) this.L$4;
                Object[] objArr2 = (Object[]) this.L$3;
                kotlin.coroutines.c cVar = (kotlin.coroutines.c) this.L$2;
                Object[] objArr3 = (Object[]) this.L$1;
                i iVar3 = (i) this.L$0;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(h[] hVarArr, kotlin.coroutines.c cVar, d2.s sVar) {
        super(2, cVar);
        this.$flows = hVarArr;
        this.$transform$inlined = sVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(this.$flows, cVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3.p$ = (i) obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3;
    }

    @Override // d2.p
    public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3) create(obj, cVar)).invokeSuspend(f1.f55527a);
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
            h[] hVarArr = this.$flows;
            d2.a a4 = FlowKt__ZipKt.a();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.L$0 = iVar;
            this.label = 1;
            if (CombineKt.a(iVar, hVarArr, a4, anonymousClass1, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i iVar2 = (i) this.L$0;
            kotlin.d0.n(obj);
        }
        return f1.f55527a;
    }
}
