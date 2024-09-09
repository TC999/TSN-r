package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007\u001a8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016\"\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001a\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000\u001a#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0004\b\u001e\u0010\u0019\u001a\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\b*\u00020\u001f\u001a\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\b*\u00020\"\u001a\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\b*\u00020%\u001a\u0010\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\b*\u00020'\u001aT\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010)\u001a\u00020 24\b\u0001\u0010\u0007\u001a.\u0012\u0004\u0012\u00020*\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000+\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00040\u0001\u00a2\u0006\u0002\b\u0006H\u0007\u001aO\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\n\u001aO\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/h;", "n", "(Ld2/p;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function0;", "a", "Lkotlin/Function1;", "b", "(Ld2/l;)Lkotlinx/coroutines/flow/h;", "", "c", "", "d", "Lkotlin/sequences/m;", "g", "", "elements", "p", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/h;", "value", "o", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/h;", "m", "j", "", "", "h", "", "", "i", "Lkotlin/ranges/k;", "e", "Lkotlin/ranges/n;", "f", "bufferSize", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/ParameterName;", "name", "channel", CampaignEx.JSON_KEY_AD_Q, "Lkotlinx/coroutines/channels/b0;", "l", "k", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class FlowKt__BuildersKt {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements h<T> {

        /* renamed from: a */
        final /* synthetic */ d2.a f59650a;

        public a(d2.a aVar) {
            this.f59650a = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object emit = iVar.emit(this.f59650a.invoke(), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return emit == h4 ? emit : f1.f55527a;
        }
    }

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements h<T> {

        /* renamed from: a */
        final /* synthetic */ Object f59651a;

        public b(Object obj) {
            this.f59651a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object emit = iVar.emit(this.f59651a, cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return emit == h4 ? emit : f1.f55527a;
        }
    }

    /* compiled from: Builders.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowViaChannel$1", f = "Builders.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends SuspendLambda implements d2.p<kotlinx.coroutines.channels.b0<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private kotlinx.coroutines.channels.b0 f59652a;

        /* renamed from: b */
        Object f59653b;

        /* renamed from: c */
        int f59654c;

        /* renamed from: d */
        final /* synthetic */ d2.p f59655d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d2.p pVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59655d = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f59655d, cVar);
            cVar2.f59652a = (kotlinx.coroutines.channels.b0) obj;
            return cVar2;
        }

        @Override // d2.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(obj, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59654c;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                kotlinx.coroutines.channels.b0 b0Var = this.f59652a;
                this.f59655d.invoke(b0Var, b0Var.getChannel());
                this.f59653b = b0Var;
                this.f59654c = 1;
                if (kotlinx.coroutines.channels.z.b(b0Var, null, this, 1, null) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlinx.coroutines.channels.b0 b0Var2 = (kotlinx.coroutines.channels.b0) this.f59653b;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> a(@NotNull d2.a<? extends T> aVar) {
        return new a(aVar);
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> b(@NotNull d2.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(lVar);
    }

    @NotNull
    public static final <T> h<T> c(@NotNull Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @NotNull
    public static final h<Integer> e(@NotNull kotlin.ranges.k kVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(kVar);
    }

    @NotNull
    public static final h<Long> f(@NotNull kotlin.ranges.n nVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(nVar);
    }

    @NotNull
    public static final <T> h<T> g(@NotNull kotlin.sequences.m<? extends T> mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(mVar);
    }

    @NotNull
    public static final h<Integer> h(@NotNull int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @NotNull
    public static final h<Long> i(@NotNull long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @NotNull
    public static final <T> h<T> j(@NotNull T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> k(@BuilderInference @NotNull d2.p<? super kotlinx.coroutines.channels.b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return new kotlinx.coroutines.flow.b(pVar, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> h<T> l(@BuilderInference @NotNull d2.p<? super kotlinx.coroutines.channels.b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return new f(pVar, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> h<T> m() {
        return g.f60012a;
    }

    @NotNull
    public static final <T> h<T> n(@BuilderInference @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return new w(pVar);
    }

    @NotNull
    public static final <T> h<T> o(T t3) {
        return new b(t3);
    }

    @NotNull
    public static final <T> h<T> p(@NotNull T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @FlowPreview
    @NotNull
    public static final <T> h<T> q(int i4, @BuilderInference @NotNull d2.p<? super q0, ? super kotlinx.coroutines.channels.h0<? super T>, f1> pVar) {
        h<T> d4;
        d4 = n.d(k.y(new c(pVar, null)), i4, null, 2, null);
        return d4;
    }

    public static /* synthetic */ h r(int i4, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = -2;
        }
        return k.T0(i4, pVar);
    }
}
