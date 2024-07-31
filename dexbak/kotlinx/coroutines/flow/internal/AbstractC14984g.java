package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.connect.common.Constants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: ChannelFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H¤@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/g;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "s", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "newContext", "r", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/b0;", Constants.PARAM_SCOPE, "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "", "toString", "Lkotlinx/coroutines/flow/h;", "d", "Lkotlinx/coroutines/flow/h;", "flow", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14984g<S, T> extends ChannelFlow<T> {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    protected final InterfaceC14958h<S> f42826d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", m8638f = "ChannelFlow.kt", m8637i = {0}, m8636l = {164}, m8635m = "invokeSuspend", m8634n = {"it"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.internal.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14985a extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42827a;

        /* renamed from: b */
        Object f42828b;

        /* renamed from: c */
        int f42829c;

        C14985a(InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14985a c14985a = new C14985a(interfaceC14268c);
            c14985a.f42827a = (FlowCollector) obj;
            return c14985a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14985a) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42829c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector<? super T> flowCollector = this.f42827a;
                AbstractC14984g abstractC14984g = AbstractC14984g.this;
                this.f42828b = flowCollector;
                this.f42829c = 1;
                if (abstractC14984g.mo4771s(flowCollector, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                FlowCollector flowCollector2 = (FlowCollector) this.f42828b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC14984g(@NotNull InterfaceC14958h<? extends S> interfaceC14958h, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f42826d = interfaceC14958h;
    }

    /* renamed from: p */
    static /* synthetic */ Object m4775p(AbstractC14984g abstractC14984g, FlowCollector flowCollector, InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        if (abstractC14984g.f42815b == -3) {
            CoroutineContext context = interfaceC14268c.getContext();
            CoroutineContext plus = context.plus(abstractC14984g.f42814a);
            if (C14342f0.m8193g(plus, context)) {
                Object mo4771s = abstractC14984g.mo4771s(flowCollector, interfaceC14268c);
                m8642h3 = C14287b.m8642h();
                return mo4771s == m8642h3 ? mo4771s : Unit.f41048a;
            }
            ContinuationInterceptor.C14270b c14270b = ContinuationInterceptor.f41024k0;
            if (C14342f0.m8193g((ContinuationInterceptor) plus.get(c14270b), (ContinuationInterceptor) context.get(c14270b))) {
                Object m4773r = abstractC14984g.m4773r(flowCollector, plus, interfaceC14268c);
                m8642h2 = C14287b.m8642h();
                return m4773r == m8642h2 ? m4773r : Unit.f41048a;
            }
        }
        Object mo4470e = super.mo4470e(flowCollector, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    /* renamed from: q */
    static /* synthetic */ Object m4774q(AbstractC14984g abstractC14984g, InterfaceC14686b0 interfaceC14686b0, InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Object mo4771s = abstractC14984g.mo4771s(new SendingCollector(interfaceC14686b0), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4771s == m8642h ? mo4771s : Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return m4775p(this, flowCollector, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    /* renamed from: j */
    protected Object mo4770j(@NotNull InterfaceC14686b0<? super T> interfaceC14686b0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return m4774q(this, interfaceC14686b0, interfaceC14268c);
    }

    @Nullable
    /* renamed from: r */
    final /* synthetic */ Object m4773r(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4777d = C14983f.m4777d(coroutineContext, C14983f.m4780a(flowCollector, interfaceC14268c.getContext()), null, new C14985a(null), interfaceC14268c, 4, null);
        m8642h = C14287b.m8642h();
        return m4777d == m8642h ? m4777d : Unit.f41048a;
    }

    @Nullable
    /* renamed from: s */
    protected abstract Object mo4771s(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return this.f42826d + " -> " + super.toString();
    }
}
