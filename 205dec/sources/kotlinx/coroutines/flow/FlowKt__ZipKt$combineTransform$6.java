package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Zip.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__ZipKt$combineTransform$6<R> extends SuspendLambda implements d2.p<i<? super R>, kotlin.coroutines.c<? super f1>, Object> {
    final /* synthetic */ h[] $flows;
    final /* synthetic */ d2.q $transform;
    Object L$0;
    int label;
    private i p$;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Zip.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1<T> extends Lambda implements d2.a<T[]> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        public final T[] invoke() {
            int length = FlowKt__ZipKt$combineTransform$6.this.$flows.length;
            kotlin.jvm.internal.f0.y(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Zip.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR}, m = "invokeSuspend", n = {"$this$combineInternal", "it"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass2<T> extends SuspendLambda implements d2.q<i<? super R>, T[], kotlin.coroutines.c<? super f1>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private i p$;
        private Object[] p$0;

        public AnonymousClass2(kotlin.coroutines.c cVar) {
            super(3, cVar);
        }

        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull i<? super R> iVar, @NotNull T[] tArr, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.p$ = iVar;
            anonymousClass2.p$0 = tArr;
            return anonymousClass2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.q
        public final Object invoke(Object obj, Object obj2, kotlin.coroutines.c<? super f1> cVar) {
            return ((AnonymousClass2) create((i) obj, (Object[]) obj2, cVar)).invokeSuspend(f1.f55527a);
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
                d2.q qVar = FlowKt__ZipKt$combineTransform$6.this.$transform;
                this.L$0 = iVar;
                this.L$1 = objArr;
                this.label = 1;
                if (qVar.invoke(iVar, objArr, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Object[] objArr2 = (Object[]) this.L$1;
                i iVar2 = (i) this.L$0;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            FlowKt__ZipKt$combineTransform$6.this.$transform.invoke(this.p$, this.p$0, this);
            return f1.f55527a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$6(h[] hVarArr, d2.q qVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.$flows = hVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.$flows, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$6.p$ = (i) obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    @Override // d2.p
    public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
        return ((FlowKt__ZipKt$combineTransform$6) create(obj, cVar)).invokeSuspend(f1.f55527a);
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
            kotlin.jvm.internal.f0.w();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            this.L$0 = iVar;
            this.label = 1;
            if (CombineKt.a(iVar, hVarArr, anonymousClass1, anonymousClass2, this) == h4) {
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

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        i iVar = this.p$;
        h[] hVarArr = this.$flows;
        kotlin.jvm.internal.f0.w();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
        kotlin.jvm.internal.c0.e(0);
        CombineKt.a(iVar, hVarArr, anonymousClass1, anonymousClass2, this);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}
