package kotlinx.coroutines.scheduling;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Dispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010,\u001a\u00020\"\u00a2\u0006\u0004\b0\u00101J#\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0010R\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lkotlinx/coroutines/scheduling/f;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/scheduling/j;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "tailDispatch", "Lkotlin/f1;", "r", "(Ljava/lang/Runnable;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "Lkotlin/coroutines/f;", "context", "dispatch", "(Lkotlin/coroutines/f;Ljava/lang/Runnable;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "g", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "b", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Lkotlinx/coroutines/scheduling/d;", "c", "Lkotlinx/coroutines/scheduling/d;", "dispatcher", "", "d", "I", "parallelism", "e", "Ljava/lang/String;", "name", "f", "n", "()I", "taskMode", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Lkotlinx/coroutines/scheduling/d;ILjava/lang/String;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class f extends s1 implements j, Executor {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60599g = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");

    /* renamed from: c  reason: collision with root package name */
    private final d f60601c;

    /* renamed from: d  reason: collision with root package name */
    private final int f60602d;

    /* renamed from: e  reason: collision with root package name */
    private final String f60603e;

    /* renamed from: f  reason: collision with root package name */
    private final int f60604f;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f60600b = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public f(@NotNull d dVar, int i4, @Nullable String str, int i5) {
        this.f60601c = dVar;
        this.f60602d = i4;
        this.f60603e = str;
        this.f60604f = i5;
    }

    private final void r(Runnable runnable, boolean z3) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f60599g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f60602d) {
                this.f60601c.C(runnable, this, z3);
                return;
            }
            this.f60600b.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f60602d) {
                return;
            }
            runnable = this.f60600b.poll();
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        r(runnable, false);
    }

    @Override // kotlinx.coroutines.l0
    public void dispatchYield(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        r(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        r(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.j
    public void g() {
        Runnable poll = this.f60600b.poll();
        if (poll != null) {
            this.f60601c.C(poll, this, true);
            return;
        }
        f60599g.decrementAndGet(this);
        Runnable poll2 = this.f60600b.poll();
        if (poll2 != null) {
            r(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.scheduling.j
    public int n() {
        return this.f60604f;
    }

    @Override // kotlinx.coroutines.s1
    @NotNull
    public Executor q() {
        return this;
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        String str = this.f60603e;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f60601c + ']';
    }
}
