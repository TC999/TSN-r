package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.k3;
import kotlinx.coroutines.m1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DispatchedContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010E\u001a\u00020B\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\bN\u0010OJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001f\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 JH\u0010%\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2%\b\b\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010!H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0010\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0019H\u0086\b\u00a2\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010 J\u001f\u00101\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016\u00a2\u0006\u0004\b4\u00105R\u001e\u0010:\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e\u00a2\u0006\f\n\u0004\b6\u00107\u0012\u0004\b8\u00109R\"\u0010?\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00198\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b@\u00107R\u0014\u0010E\u001a\u00020B8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0017\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010\u0010R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010JR\u0014\u0010/\u001a\u00020.8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006P"}, d2 = {"Lkotlinx/coroutines/internal/j;", "T", "Lkotlinx/coroutines/c1;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/c;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/p;", "requester", "", "r", "(Lkotlinx/coroutines/p;)Z", "k", "()Lkotlinx/coroutines/p;", "Lkotlinx/coroutines/o;", "continuation", "", "j", "(Lkotlinx/coroutines/o;)Ljava/lang/Throwable;", "cause", "s", "(Ljava/lang/Throwable;)Z", "", "i", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "t", "(Ljava/lang/Object;Ld2/l;)V", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "u", "(Ljava/lang/Object;)Z", "v", "Lkotlin/coroutines/f;", "context", "value", "l", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "()V", "_state", "e", "Lkotlin/coroutines/jvm/internal/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "f", "countOrElement", "Lkotlinx/coroutines/l0;", "g", "Lkotlinx/coroutines/l0;", "dispatcher", "h", "Lkotlin/coroutines/c;", "m", "reusableCancellableContinuation", "()Lkotlin/coroutines/c;", "delegate", "getContext", "()Lkotlin/coroutines/f;", "<init>", "(Lkotlinx/coroutines/l0;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j<T> extends c1<T> implements kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c<T> {

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60368i = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    @JvmField
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Object f60369d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.c f60370e;
    @JvmField
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final Object f60371f;
    @JvmField
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final kotlinx.coroutines.l0 f60372g;
    @JvmField
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f60373h;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull kotlinx.coroutines.l0 l0Var, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f60372g = l0Var;
        this.f60373h = cVar;
        this.f60369d = k.a();
        this.f60370e = (kotlin.coroutines.jvm.internal.c) (cVar instanceof kotlin.coroutines.jvm.internal.c ? cVar : null);
        this.f60371f = o0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    public static /* synthetic */ void p() {
    }

    @Override // kotlinx.coroutines.c1
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof kotlinx.coroutines.e0) {
            ((kotlinx.coroutines.e0) obj).f59624b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.c1
    @NotNull
    public kotlin.coroutines.c<T> e() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        return this.f60370e;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return this.f60373h.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.c1
    @Nullable
    public Object i() {
        Object obj = this.f60369d;
        this.f60369d = k.a();
        return obj;
    }

    @Nullable
    public final Throwable j(@NotNull kotlinx.coroutines.o<?> oVar) {
        j0 j0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            j0Var = k.f60376b;
            if (obj != j0Var) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (io.netty.channel.a.a(f60368i, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!io.netty.channel.a.a(f60368i, this, j0Var, oVar));
        return null;
    }

    @Nullable
    public final kotlinx.coroutines.p<T> k() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = k.f60376b;
                return null;
            } else if (!(obj instanceof kotlinx.coroutines.p)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!io.netty.channel.a.a(f60368i, this, obj, k.f60376b));
        return (kotlinx.coroutines.p) obj;
    }

    public final void l(@NotNull kotlin.coroutines.f fVar, T t3) {
        this.f60369d = t3;
        this.f59070c = 1;
        this.f60372g.dispatchYield(fVar, this);
    }

    @Nullable
    public final kotlinx.coroutines.p<?> m() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof kotlinx.coroutines.p)) {
            obj = null;
        }
        return (kotlinx.coroutines.p) obj;
    }

    public final boolean r(@NotNull kotlinx.coroutines.p<?> pVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof kotlinx.coroutines.p) || obj == pVar;
        }
        return false;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        kotlin.coroutines.f context = this.f60373h.getContext();
        Object d4 = kotlinx.coroutines.i0.d(obj, null, 1, null);
        if (this.f60372g.isDispatchNeeded(context)) {
            this.f60369d = d4;
            this.f59070c = 0;
            this.f60372g.dispatch(context, this);
            return;
        }
        m1 b4 = k3.f60465b.b();
        if (b4.F()) {
            this.f60369d = d4;
            this.f59070c = 0;
            b4.t(this);
            return;
        }
        b4.C(true);
        try {
            kotlin.coroutines.f context2 = getContext();
            Object c4 = o0.c(context2, this.f60371f);
            this.f60373h.resumeWith(obj);
            f1 f1Var = f1.f55527a;
            o0.a(context2, c4);
            do {
            } while (b4.I());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            j0 j0Var = k.f60376b;
            if (kotlin.jvm.internal.f0.g(obj, j0Var)) {
                if (io.netty.channel.a.a(f60368i, this, j0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (io.netty.channel.a.a(f60368i, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void t(@NotNull Object obj, @Nullable d2.l<? super Throwable, f1> lVar) {
        boolean z3;
        Object b4 = kotlinx.coroutines.i0.b(obj, lVar);
        if (this.f60372g.isDispatchNeeded(getContext())) {
            this.f60369d = b4;
            this.f59070c = 1;
            this.f60372g.dispatch(getContext(), this);
            return;
        }
        m1 b5 = k3.f60465b.b();
        if (b5.F()) {
            this.f60369d = b4;
            this.f59070c = 1;
            b5.t(this);
            return;
        }
        b5.C(true);
        try {
            e2 e2Var = (e2) getContext().get(e2.f59626i0);
            if (e2Var == null || e2Var.isActive()) {
                z3 = false;
            } else {
                CancellationException l4 = e2Var.l();
                c(b4, l4);
                Result.a aVar = Result.Companion;
                resumeWith(Result.m119constructorimpl(kotlin.d0.a(l4)));
                z3 = true;
            }
            if (!z3) {
                kotlin.coroutines.f context = getContext();
                Object c4 = o0.c(context, this.f60371f);
                this.f60373h.resumeWith(obj);
                f1 f1Var = f1.f55527a;
                kotlin.jvm.internal.c0.d(1);
                o0.a(context, c4);
                kotlin.jvm.internal.c0.c(1);
            }
            do {
            } while (b5.I());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th) {
            try {
                h(th, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                b5.p(true);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        b5.p(true);
        kotlin.jvm.internal.c0.c(1);
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f60372g + ", " + kotlinx.coroutines.u0.c(this.f60373h) + ']';
    }

    public final boolean u(@Nullable Object obj) {
        e2 e2Var = (e2) getContext().get(e2.f59626i0);
        if (e2Var == null || e2Var.isActive()) {
            return false;
        }
        CancellationException l4 = e2Var.l();
        c(obj, l4);
        Result.a aVar = Result.Companion;
        resumeWith(Result.m119constructorimpl(kotlin.d0.a(l4)));
        return true;
    }

    public final void v(@NotNull Object obj) {
        kotlin.coroutines.f context = getContext();
        Object c4 = o0.c(context, this.f60371f);
        try {
            this.f60373h.resumeWith(obj);
            f1 f1Var = f1.f55527a;
        } finally {
            kotlin.jvm.internal.c0.d(1);
            o0.a(context, c4);
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
