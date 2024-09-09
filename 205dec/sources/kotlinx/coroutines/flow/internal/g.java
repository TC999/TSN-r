package kotlinx.coroutines.flow.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\bJ\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0004X\u0085\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/flow/internal/g;", "S", "T", "Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "s", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "newContext", "r", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/b0;", "scope", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "", "toString", "Lkotlinx/coroutines/flow/h;", "d", "Lkotlinx/coroutines/flow/h;", "flow", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g<S, T> extends e<T> {
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    protected final kotlinx.coroutines.flow.h<S> f60143d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChannelFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends SuspendLambda implements d2.p<kotlinx.coroutines.flow.i<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private kotlinx.coroutines.flow.i f60144a;

        /* renamed from: b  reason: collision with root package name */
        Object f60145b;

        /* renamed from: c  reason: collision with root package name */
        int f60146c;

        a(kotlin.coroutines.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(cVar);
            aVar.f60144a = (kotlinx.coroutines.flow.i) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(obj, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60146c;
            if (i4 == 0) {
                d0.n(obj);
                kotlinx.coroutines.flow.i<? super T> iVar = this.f60144a;
                g gVar = g.this;
                this.f60145b = iVar;
                this.f60146c = 1;
                if (gVar.s(iVar, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlinx.coroutines.flow.i iVar2 = (kotlinx.coroutines.flow.i) this.f60145b;
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull kotlinx.coroutines.flow.h<? extends S> hVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(fVar, i4, bufferOverflow);
        this.f60143d = hVar;
    }

    static /* synthetic */ Object p(g gVar, kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar) {
        Object h4;
        Object h5;
        Object h6;
        if (gVar.f60132b == -3) {
            kotlin.coroutines.f context = cVar.getContext();
            kotlin.coroutines.f plus = context.plus(gVar.f60131a);
            if (f0.g(plus, context)) {
                Object s3 = gVar.s(iVar, cVar);
                h6 = kotlin.coroutines.intrinsics.b.h();
                return s3 == h6 ? s3 : f1.f55527a;
            }
            d.b bVar = kotlin.coroutines.d.f55503f0;
            if (f0.g((kotlin.coroutines.d) plus.get(bVar), (kotlin.coroutines.d) context.get(bVar))) {
                Object r3 = gVar.r(iVar, plus, cVar);
                h5 = kotlin.coroutines.intrinsics.b.h();
                return r3 == h5 ? r3 : f1.f55527a;
            }
        }
        Object e4 = super.e(iVar, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    static /* synthetic */ Object q(g gVar, b0 b0Var, kotlin.coroutines.c cVar) {
        Object h4;
        Object s3 = gVar.s(new t(b0Var), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return s3 == h4 ? s3 : f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return p(this, iVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    protected Object j(@NotNull b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return q(this, b0Var, cVar);
    }

    @Nullable
    final /* synthetic */ Object r(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.f fVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object d4 = f.d(fVar, f.a(iVar, cVar.getContext()), null, new a(null), cVar, 4, null);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return d4 == h4 ? d4 : f1.f55527a;
    }

    @Nullable
    protected abstract Object s(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public String toString() {
        return this.f60143d + " -> " + super.toString();
    }
}
