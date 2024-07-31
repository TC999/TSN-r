package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Iterator;
import kotlin.Annotations;
import kotlin.C14294d0;
import kotlin.DeprecationLevel;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.ranges.C14413k;
import kotlin.ranges.C14418n;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.C14739z;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Builders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007\u001a8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016\"\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000\u001a#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u001e\u0010\u0019\u001a\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\b*\u00020\u001f\u001a\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\b*\u00020\"\u001a\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\b*\u00020%\u001a\u0010\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\b*\u00020'\u001aT\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010)\u001a\u00020 24\b\u0001\u0010\u0007\u001a.\u0012\u0004\u0012\u00020*\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0006H\u0007\u001aO\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\n\u001aO\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/h;", "n", "(Ll1/p;)Lkotlinx/coroutines/flow/h;", "Lkotlin/Function0;", "f", "Lkotlin/Function1;", "g", "(Ll1/l;)Lkotlinx/coroutines/flow/h;", "", "a", "", "b", "Lkotlin/sequences/m;", "e", "", "elements", "p", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/h;", DomainCampaignEx.LOOPBACK_VALUE, "o", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/h;", "m", "j", "", "", "h", "", "", "i", "Lkotlin/ranges/k;", "c", "Lkotlin/ranges/n;", "d", "bufferSize", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/ParameterName;", "name", "channel", CampaignEx.JSON_KEY_AD_Q, "Lkotlinx/coroutines/channels/b0;", C7304t.f25048d, "k", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class FlowKt__BuildersKt {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14781a<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f42295a;

        public C14781a(InterfaceC15269a interfaceC15269a) {
            this.f42295a = interfaceC15269a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object emit = flowCollector.emit(this.f42295a.invoke(), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return emit == m8642h ? emit : Unit.f41048a;
        }
    }

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14782b<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ Object f42296a;

        public C14782b(Object obj) {
            this.f42296a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object emit = flowCollector.emit(this.f42296a, interfaceC14268c);
            m8642h = C14287b.m8642h();
            return emit == m8642h ? emit : Unit.f41048a;
        }
    }

    /* compiled from: Builders.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowViaChannel$1", m8638f = "Builders.kt", m8637i = {0}, m8636l = {216}, m8635m = "invokeSuspend", m8634n = {"$this$channelFlow"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14783c<T> extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private InterfaceC14686b0 f42297a;

        /* renamed from: b */
        Object f42298b;

        /* renamed from: c */
        int f42299c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15284p f42300d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14783c(InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42300d = interfaceC15284p;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14783c c14783c = new C14783c(this.f42300d, interfaceC14268c);
            c14783c.f42297a = (InterfaceC14686b0) obj;
            return c14783c;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14783c) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42299c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                InterfaceC14686b0 interfaceC14686b0 = this.f42297a;
                this.f42300d.invoke(interfaceC14686b0, interfaceC14686b0.getChannel());
                this.f42298b = interfaceC14686b0;
                this.f42299c = 1;
                if (C14739z.m5167b(interfaceC14686b0, null, this, 1, null) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42298b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m5030a(@NotNull Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m5029b(@NotNull Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @NotNull
    /* renamed from: c */
    public static final InterfaceC14958h<Integer> m5028c(@NotNull C14413k c14413k) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(c14413k);
    }

    @NotNull
    /* renamed from: d */
    public static final InterfaceC14958h<Long> m5027d(@NotNull C14418n c14418n) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(c14418n);
    }

    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14958h<T> m5026e(@NotNull Sequence<? extends T> sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    @FlowPreview
    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m5025f(@NotNull InterfaceC15269a<? extends T> interfaceC15269a) {
        return new C14781a(interfaceC15269a);
    }

    @FlowPreview
    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14958h<T> m5024g(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(interfaceC15280l);
    }

    @NotNull
    /* renamed from: h */
    public static final InterfaceC14958h<Integer> m5023h(@NotNull int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @NotNull
    /* renamed from: i */
    public static final InterfaceC14958h<Long> m5022i(@NotNull long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @NotNull
    /* renamed from: j */
    public static final <T> InterfaceC14958h<T> m5021j(@NotNull T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: k */
    public static final <T> InterfaceC14958h<T> m5020k(@Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new C14942b(interfaceC15284p, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: l */
    public static final <T> InterfaceC14958h<T> m5019l(@Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new C14952f(interfaceC15284p, null, 0, null, 14, null);
    }

    @NotNull
    /* renamed from: m */
    public static final <T> InterfaceC14958h<T> m5018m() {
        return C14954g.f42695a;
    }

    @NotNull
    /* renamed from: n */
    public static final <T> InterfaceC14958h<T> m5017n(@Inference @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new C15047w(interfaceC15284p);
    }

    @NotNull
    /* renamed from: o */
    public static final <T> InterfaceC14958h<T> m5016o(T t) {
        return new C14782b(t);
    }

    @NotNull
    /* renamed from: p */
    public static final <T> InterfaceC14958h<T> m5015p(@NotNull T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @FlowPreview
    @NotNull
    /* renamed from: q */
    public static final <T> InterfaceC14958h<T> m5014q(int i, @Inference @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14704h0<? super T>, Unit> interfaceC15284p) {
        InterfaceC14958h<T> m4550d;
        m4550d = C15016n.m4550d(C15006k.m4580y(new C14783c(interfaceC15284p, null)), i, null, 2, null);
        return m4550d;
    }

    /* renamed from: r */
    public static /* synthetic */ InterfaceC14958h m5013r(int i, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return C15006k.m4689T0(i, interfaceC15284p);
    }
}
