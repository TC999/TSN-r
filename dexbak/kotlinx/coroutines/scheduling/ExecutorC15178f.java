package kotlinx.coroutines.scheduling;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractC15168s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Dispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010+\u001a\u00020\"¢\u0006\u0004\b/\u00100J#\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0010R\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010+\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/f;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/scheduling/j;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "tailDispatch", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Runnable;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "Lkotlin/coroutines/f;", "context", "dispatch", "(Lkotlin/coroutines/f;Ljava/lang/Runnable;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "f", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "b", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Lkotlinx/coroutines/scheduling/d;", "c", "Lkotlinx/coroutines/scheduling/d;", "dispatcher", "", "d", "I", "parallelism", "e", "Ljava/lang/String;", "name", "h", "()I", "taskMode", "p", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Lkotlinx/coroutines/scheduling/d;ILjava/lang/String;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class ExecutorC15178f extends AbstractC15168s1 implements InterfaceC15182j, Executor {

    /* renamed from: g */
    private static final AtomicIntegerFieldUpdater f43282g = AtomicIntegerFieldUpdater.newUpdater(ExecutorC15178f.class, "inFlightTasks");

    /* renamed from: c */
    private final C15177d f43284c;

    /* renamed from: d */
    private final int f43285d;

    /* renamed from: e */
    private final String f43286e;

    /* renamed from: f */
    private final int f43287f;

    /* renamed from: b */
    private final ConcurrentLinkedQueue<Runnable> f43283b = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public ExecutorC15178f(@NotNull C15177d c15177d, int i, @Nullable String str, int i2) {
        this.f43284c = c15177d;
        this.f43285d = i;
        this.f43286e = str;
        this.f43287f = i2;
    }

    /* renamed from: q */
    private final void m3741q(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f43282g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f43285d) {
                this.f43284c.m3743u(runnable, this, z);
                return;
            }
            this.f43283b.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f43285d) {
                return;
            }
            runnable = this.f43283b.poll();
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        m3741q(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        m3741q(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        m3741q(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.InterfaceC15182j
    /* renamed from: f */
    public void mo3739f() {
        Runnable poll = this.f43283b.poll();
        if (poll != null) {
            this.f43284c.m3743u(poll, this, true);
            return;
        }
        f43282g.decrementAndGet(this);
        Runnable poll2 = this.f43283b.poll();
        if (poll2 != null) {
            m3741q(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.scheduling.InterfaceC15182j
    /* renamed from: h */
    public int mo3738h() {
        return this.f43287f;
    }

    @Override // kotlinx.coroutines.AbstractC15168s1
    @NotNull
    /* renamed from: p */
    public Executor mo3514p() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String str = this.f43286e;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f43284c + ']';
    }
}
