package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.connect.common.Constants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Merge.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/i;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "Lkotlinx/coroutines/q0;", Constants.PARAM_SCOPE, "Lkotlinx/coroutines/channels/d0;", "o", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/h;", "d", "Ljava/lang/Iterable;", "flows", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14987i<T> extends ChannelFlow<T> {

    /* renamed from: d */
    private final Iterable<InterfaceC14958h<T>> f42831d;

    /* compiled from: Merge.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge$collectTo$2$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14988a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42832a;

        /* renamed from: b */
        Object f42833b;

        /* renamed from: c */
        int f42834c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC14958h f42835d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC14686b0 f42836e;

        /* renamed from: f */
        final /* synthetic */ SendingCollector f42837f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14988a(InterfaceC14958h interfaceC14958h, InterfaceC14268c interfaceC14268c, InterfaceC14686b0 interfaceC14686b0, SendingCollector sendingCollector) {
            super(2, interfaceC14268c);
            this.f42835d = interfaceC14958h;
            this.f42836e = interfaceC14686b0;
            this.f42837f = sendingCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14988a c14988a = new C14988a(this.f42835d, interfaceC14268c, this.f42836e, this.f42837f);
            c14988a.f42832a = (CoroutineScope) obj;
            return c14988a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14988a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42834c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                CoroutineScope coroutineScope = this.f42832a;
                InterfaceC14958h interfaceC14958h = this.f42835d;
                SendingCollector sendingCollector = this.f42837f;
                this.f42833b = coroutineScope;
                this.f42834c = 1;
                if (interfaceC14958h.mo4470e(sendingCollector, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f42833b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    public /* synthetic */ C14987i(Iterable iterable, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    /* renamed from: j */
    protected Object mo4770j(@NotNull InterfaceC14686b0<? super T> interfaceC14686b0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        SendingCollector sendingCollector = new SendingCollector(interfaceC14686b0);
        for (InterfaceC14958h<T> interfaceC14958h : this.f42831d) {
            C15111j.m4126f(interfaceC14686b0, null, null, new C14988a(interfaceC14958h, null, interfaceC14686b0, sendingCollector), 3, null);
        }
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: k */
    protected ChannelFlow<T> mo4769k(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new C14987i(this.f42831d, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: o */
    public InterfaceC14695d0<T> mo4768o(@NotNull CoroutineScope coroutineScope) {
        return C14991l.m4767a(coroutineScope, this.f42814a, this.f42815b, m4782m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14987i(@NotNull Iterable<? extends InterfaceC14958h<? extends T>> iterable, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f42831d = iterable;
    }
}
