package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010!\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010#\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001a\u00a8\u0006&"}, d2 = {"Lkotlinx/coroutines/m1;", "Lkotlinx/coroutines/l0;", "", "unconfined", "", "r", "H", "I", "J", "Lkotlinx/coroutines/c1;", "task", "Lkotlin/f1;", "t", "C", "p", "shutdown", "a", "useCount", "b", "Z", "shared", "Lkotlinx/coroutines/internal/a;", "c", "Lkotlinx/coroutines/internal/a;", "unconfinedQueue", "E", "()Z", "isEmpty", "B", "()J", "nextTime", "isActive", "F", "isUnconfinedLoopActive", "G", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m1 extends l0 {

    /* renamed from: a  reason: collision with root package name */
    private long f60494a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f60495b;

    /* renamed from: c  reason: collision with root package name */
    private kotlinx.coroutines.internal.a<c1<?>> f60496c;

    public static /* synthetic */ void D(m1 m1Var, boolean z3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                z3 = false;
            }
            m1Var.C(z3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void q(m1 m1Var, boolean z3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                z3 = false;
            }
            m1Var.p(z3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long r(boolean z3) {
        return z3 ? 4294967296L : 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long B() {
        kotlinx.coroutines.internal.a<c1<?>> aVar = this.f60496c;
        return (aVar == null || aVar.d()) ? Long.MAX_VALUE : 0L;
    }

    public final void C(boolean z3) {
        this.f60494a += r(z3);
        if (z3) {
            return;
        }
        this.f60495b = true;
    }

    protected boolean E() {
        return G();
    }

    public final boolean F() {
        return this.f60494a >= r(true);
    }

    public final boolean G() {
        kotlinx.coroutines.internal.a<c1<?>> aVar = this.f60496c;
        if (aVar != null) {
            return aVar.d();
        }
        return true;
    }

    public long H() {
        return !I() ? Long.MAX_VALUE : 0L;
    }

    public final boolean I() {
        c1<?> e4;
        kotlinx.coroutines.internal.a<c1<?>> aVar = this.f60496c;
        if (aVar == null || (e4 = aVar.e()) == null) {
            return false;
        }
        e4.run();
        return true;
    }

    public boolean J() {
        return false;
    }

    public final boolean isActive() {
        return this.f60494a > 0;
    }

    public final void p(boolean z3) {
        long r3 = this.f60494a - r(z3);
        this.f60494a = r3;
        if (r3 <= 0 && this.f60495b) {
            shutdown();
        }
    }

    protected void shutdown() {
    }

    public final void t(@NotNull c1<?> c1Var) {
        kotlinx.coroutines.internal.a<c1<?>> aVar = this.f60496c;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f60496c = aVar;
        }
        aVar.a(c1Var);
    }
}
