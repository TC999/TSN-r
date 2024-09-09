package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: WorkQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/n;", "", "Lkotlinx/coroutines/scheduling/i;", "task", "c", "(Lkotlinx/coroutines/scheduling/i;)Lkotlinx/coroutines/scheduling/i;", "victim", "", "blockingOnly", "", "m", "(Lkotlinx/coroutines/scheduling/n;Z)J", "Lkotlinx/coroutines/scheduling/e;", "queue", "j", "(Lkotlinx/coroutines/scheduling/e;)Z", "i", "()Lkotlinx/coroutines/scheduling/i;", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/scheduling/i;)V", "h", "fair", "a", "(Lkotlinx/coroutines/scheduling/i;Z)Lkotlinx/coroutines/scheduling/i;", "l", "(Lkotlinx/coroutines/scheduling/n;)J", "k", "globalQueue", "g", "(Lkotlinx/coroutines/scheduling/e;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60621b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60622c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60623d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60624e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<i> f60625a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ i b(n nVar, i iVar, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return nVar.a(iVar, z3);
    }

    private final i c(i iVar) {
        if (iVar.f60609b.n() == 1) {
            f60624e.incrementAndGet(this);
        }
        if (e() == 127) {
            return iVar;
        }
        int i4 = this.producerIndex & 127;
        while (this.f60625a.get(i4) != null) {
            Thread.yield();
        }
        this.f60625a.lazySet(i4, iVar);
        f60622c.incrementAndGet(this);
        return null;
    }

    private final void d(i iVar) {
        if (iVar != null) {
            if (iVar.f60609b.n() == 1) {
                f60624e.decrementAndGet(this);
            }
        }
    }

    private final i i() {
        i andSet;
        while (true) {
            int i4 = this.consumerIndex;
            if (i4 - this.producerIndex == 0) {
                return null;
            }
            int i5 = i4 & 127;
            if (f60623d.compareAndSet(this, i4, i4 + 1) && (andSet = this.f60625a.getAndSet(i5, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(e eVar) {
        i i4 = i();
        if (i4 != null) {
            eVar.a(i4);
            return true;
        }
        return false;
    }

    private final long m(n nVar, boolean z3) {
        i iVar;
        do {
            iVar = (i) nVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z3) {
                if (!(iVar.f60609b.n() == 1)) {
                    return -2L;
                }
            }
            long a4 = l.f60618h.a() - iVar.f60608a;
            long j4 = l.f60613c;
            if (a4 < j4) {
                return j4 - a4;
            }
        } while (!io.netty.channel.a.a(f60621b, nVar, iVar, null));
        b(this, iVar, false, 2, null);
        return -1L;
    }

    @Nullable
    public final i a(@NotNull i iVar, boolean z3) {
        if (z3) {
            return c(iVar);
        }
        i iVar2 = (i) f60621b.getAndSet(this, iVar);
        if (iVar2 != null) {
            return c(iVar2);
        }
        return null;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull e eVar) {
        i iVar = (i) f60621b.getAndSet(this, null);
        if (iVar != null) {
            eVar.a(iVar);
        }
        do {
        } while (j(eVar));
    }

    @Nullable
    public final i h() {
        i iVar = (i) f60621b.getAndSet(this, null);
        return iVar != null ? iVar : i();
    }

    public final long k(@NotNull n nVar) {
        int i4 = nVar.consumerIndex;
        int i5 = nVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = nVar.f60625a;
        while (true) {
            if (i4 == i5) {
                break;
            }
            int i6 = i4 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i6);
            if (iVar != null) {
                if ((iVar.f60609b.n() == 1) && atomicReferenceArray.compareAndSet(i6, iVar, null)) {
                    f60624e.decrementAndGet(nVar);
                    b(this, iVar, false, 2, null);
                    return -1L;
                }
            }
            i4++;
        }
        return m(nVar, true);
    }

    public final long l(@NotNull n nVar) {
        i i4 = nVar.i();
        if (i4 != null) {
            b(this, i4, false, 2, null);
            return -1L;
        }
        return m(nVar, false);
    }
}
