package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Indent;
import kotlinx.coroutines.C15060h2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* compiled from: SafeCollector.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010%\u001a\u00020\f¢\u0006\u0004\b,\u0010-J'\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0018\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010(\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "uCont", DomainCampaignEx.LOOPBACK_VALUE, "", "emit", "(Lkotlin/coroutines/c;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "currentContext", "previousContext", "checkContext", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/j;", "exception", "exceptionTransparencyViolated", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", CommonNetImpl.RESULT, "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "collectContextSize", "I", "lastEmissionContext", "Lkotlin/coroutines/f;", "completion", "Lkotlin/coroutines/c;", "collector", "Lkotlinx/coroutines/flow/i;", "collectContext", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {
    @JvmPlatformAnnotations
    @NotNull
    public final CoroutineContext collectContext;
    @JvmPlatformAnnotations
    public final int collectContextSize;
    @JvmPlatformAnnotations
    @NotNull
    public final FlowCollector<T> collector;
    private InterfaceC14268c<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* compiled from: SafeCollector.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "count", "Lkotlin/coroutines/f$b;", "<anonymous parameter 1>", "a", "(ILkotlin/coroutines/f$b;)I"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.SafeCollector$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14976a extends Lambda implements InterfaceC15284p<Integer, CoroutineContext.InterfaceC14275b, Integer> {

        /* renamed from: a */
        public static final C14976a f42805a = new C14976a();

        C14976a() {
            super(2);
        }

        /* renamed from: a */
        public final int m4803a(int i, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            return i + 1;
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.InterfaceC14275b interfaceC14275b) {
            return Integer.valueOf(m4803a(num.intValue(), interfaceC14275b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        super(C14998p.f42848b, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, C14976a.f42805a)).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof C14989j) {
            exceptionTransparencyViolated((C14989j) coroutineContext2, t);
        }
        SafeCollector_commonKt.m4802a(this, coroutineContext);
        this.lastEmissionContext = coroutineContext;
    }

    private final void exceptionTransparencyViolated(C14989j c14989j, Object obj) {
        String m6719p;
        m6719p = Indent.m6719p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + c14989j.f42840b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(m6719p.toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        try {
            Object emit = emit(interfaceC14268c, (InterfaceC14268c<? super Unit>) t);
            m8642h = C14287b.m8642h();
            if (emit == m8642h) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            m8642h2 = C14287b.m8642h();
            return emit == m8642h2 ? emit : Unit.f41048a;
        } catch (Throwable th) {
            this.lastEmissionContext = new C14989j(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        InterfaceC14268c<? super Unit> interfaceC14268c = this.completion;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        return (CoroutineStackFrame) interfaceC14268c;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext context;
        InterfaceC14268c<? super Unit> interfaceC14268c = this.completion;
        return (interfaceC14268c == null || (context = interfaceC14268c.getContext()) == null) ? EmptyCoroutineContext.INSTANCE : context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl != null) {
            this.lastEmissionContext = new C14989j(m60151exceptionOrNullimpl);
        }
        InterfaceC14268c<? super Unit> interfaceC14268c = this.completion;
        if (interfaceC14268c != null) {
            interfaceC14268c.resumeWith(obj);
        }
        m8642h = C14287b.m8642h();
        return m8642h;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(InterfaceC14268c<? super Unit> interfaceC14268c, T t) {
        CoroutineContext context = interfaceC14268c.getContext();
        C15060h2.m4443A(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t);
        }
        this.completion = interfaceC14268c;
        InterfaceC15285q m4757a = C14999s.m4757a();
        FlowCollector<T> flowCollector = this.collector;
        if (flowCollector != null) {
            return m4757a.invoke(flowCollector, t, this);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
    }
}
