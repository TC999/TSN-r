package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010%\u001a\u00020\f\u00a2\u0006\u0004\b,\u0010-J'\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0018\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\f8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010(\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "uCont", "value", "", "emit", "(Lkotlin/coroutines/c;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "currentContext", "previousContext", "checkContext", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/j;", "exception", "exceptionTransparencyViolated", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "collectContextSize", "I", "lastEmissionContext", "Lkotlin/coroutines/f;", "completion", "Lkotlin/coroutines/c;", "collector", "Lkotlinx/coroutines/flow/i;", "collectContext", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.i<T>, kotlin.coroutines.jvm.internal.c {
    @JvmField
    @NotNull
    public final kotlin.coroutines.f collectContext;
    @JvmField
    public final int collectContextSize;
    @JvmField
    @NotNull
    public final kotlinx.coroutines.flow.i<T> collector;
    private kotlin.coroutines.c<? super f1> completion;
    private kotlin.coroutines.f lastEmissionContext;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "", "count", "Lkotlin/coroutines/f$b;", "<anonymous parameter 1>", "a", "(ILkotlin/coroutines/f$b;)I"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.p<Integer, f.b, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60122a = new a();

        a() {
            super(2);
        }

        public final int a(int i4, @NotNull f.b bVar) {
            return i4 + 1;
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, f.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.f fVar) {
        super(p.f60165b, EmptyCoroutineContext.INSTANCE);
        this.collector = iVar;
        this.collectContext = fVar;
        this.collectContextSize = ((Number) fVar.fold(0, a.f60122a)).intValue();
    }

    private final void checkContext(kotlin.coroutines.f fVar, kotlin.coroutines.f fVar2, T t3) {
        if (fVar2 instanceof j) {
            exceptionTransparencyViolated((j) fVar2, t3);
        }
        SafeCollector_commonKt.a(this, fVar);
        this.lastEmissionContext = fVar;
    }

    private final void exceptionTransparencyViolated(j jVar, Object obj) {
        String p3;
        p3 = kotlin.text.p.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + jVar.f60157b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(p3.toString());
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object h5;
        try {
            Object emit = emit(cVar, (kotlin.coroutines.c<? super f1>) t3);
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (emit == h4) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            h5 = kotlin.coroutines.intrinsics.b.h();
            return emit == h5 ? emit : f1.f55527a;
        } catch (Throwable th) {
            this.lastEmissionContext = new j(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<? super f1> cVar = this.completion;
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        return (kotlin.coroutines.jvm.internal.c) cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        kotlin.coroutines.f context;
        kotlin.coroutines.c<? super f1> cVar = this.completion;
        return (cVar == null || (context = cVar.getContext()) == null) ? EmptyCoroutineContext.INSTANCE : context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl != null) {
            this.lastEmissionContext = new j(m122exceptionOrNullimpl);
        }
        kotlin.coroutines.c<? super f1> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        h4 = kotlin.coroutines.intrinsics.b.h();
        return h4;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(kotlin.coroutines.c<? super f1> cVar, T t3) {
        kotlin.coroutines.f context = cVar.getContext();
        h2.A(context);
        kotlin.coroutines.f fVar = this.lastEmissionContext;
        if (fVar != context) {
            checkContext(context, fVar, t3);
        }
        this.completion = cVar;
        d2.q a4 = s.a();
        kotlinx.coroutines.flow.i<T> iVar = this.collector;
        if (iVar != null) {
            return a4.invoke(iVar, t3, this);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
    }
}
