package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DispatchedTask.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H \u00a2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ#\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8 X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/c1;", "T", "Lkotlinx/coroutines/scheduling/i;", "Lkotlinx/coroutines/SchedulerTask;", "", "i", "()Ljava/lang/Object;", "takenState", "", "cause", "Lkotlin/f1;", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "exception", "finallyException", "h", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "I", "resumeMode", "Lkotlin/coroutines/c;", "e", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c1<T> extends kotlinx.coroutines.scheduling.i {
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public int f59070c;

    public c1(int i4) {
        this.f59070c = i4;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract kotlin.coroutines.c<T> e();

    @Nullable
    public Throwable f(@Nullable Object obj) {
        if (!(obj instanceof d0)) {
            obj = null;
        }
        d0 d0Var = (d0) obj;
        if (d0Var != null) {
            return d0Var.f59534a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T g(@Nullable Object obj) {
        return obj;
    }

    public final void h(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.j.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.f0.m(th);
        n0.b(e().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object m119constructorimpl;
        Object m119constructorimpl2;
        kotlinx.coroutines.scheduling.j jVar = this.f60609b;
        try {
            kotlin.coroutines.c<T> e4 = e();
            if (e4 != null) {
                kotlinx.coroutines.internal.j jVar2 = (kotlinx.coroutines.internal.j) e4;
                kotlin.coroutines.c<T> cVar = jVar2.f60373h;
                kotlin.coroutines.f context = cVar.getContext();
                Object i4 = i();
                Object c4 = kotlinx.coroutines.internal.o0.c(context, jVar2.f60371f);
                Throwable f4 = f(i4);
                e2 e2Var = (f4 == null && d1.c(this.f59070c)) ? (e2) context.get(e2.f59626i0) : null;
                if (e2Var != null && !e2Var.isActive()) {
                    CancellationException l4 = e2Var.l();
                    c(i4, l4);
                    Result.a aVar = Result.Companion;
                    cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(l4)));
                } else if (f4 != null) {
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(f4)));
                } else {
                    T g4 = g(i4);
                    Result.a aVar3 = Result.Companion;
                    cVar.resumeWith(Result.m119constructorimpl(g4));
                }
                kotlin.f1 f1Var = kotlin.f1.f55527a;
                kotlinx.coroutines.internal.o0.a(context, c4);
                try {
                    Result.a aVar4 = Result.Companion;
                    jVar.g();
                    m119constructorimpl2 = Result.m119constructorimpl(f1Var);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    m119constructorimpl2 = Result.m119constructorimpl(kotlin.d0.a(th));
                }
                h(null, Result.m122exceptionOrNullimpl(m119constructorimpl2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.Companion;
                jVar.g();
                m119constructorimpl = Result.m119constructorimpl(kotlin.f1.f55527a);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.Companion;
                m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th3));
            }
            h(th2, Result.m122exceptionOrNullimpl(m119constructorimpl));
        }
    }
}
