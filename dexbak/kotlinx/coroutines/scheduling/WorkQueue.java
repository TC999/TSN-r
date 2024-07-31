package kotlinx.coroutines.scheduling;

import com.kuaishou.weapon.p205p0.C7304t;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/n;", "", "Lkotlinx/coroutines/scheduling/i;", "task", "c", "(Lkotlinx/coroutines/scheduling/i;)Lkotlinx/coroutines/scheduling/i;", "victim", "", "blockingOnly", "", "m", "(Lkotlinx/coroutines/scheduling/n;Z)J", "Lkotlinx/coroutines/scheduling/e;", "queue", "j", "(Lkotlinx/coroutines/scheduling/e;)Z", "i", "()Lkotlinx/coroutines/scheduling/i;", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/scheduling/i;)V", "h", "fair", "a", "(Lkotlinx/coroutines/scheduling/i;Z)Lkotlinx/coroutines/scheduling/i;", C7304t.f25048d, "(Lkotlinx/coroutines/scheduling/n;)J", "k", "globalQueue", "g", "(Lkotlinx/coroutines/scheduling/e;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class WorkQueue {

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f43304b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f43305c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");

    /* renamed from: d */
    private static final AtomicIntegerFieldUpdater f43306d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f43307e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* renamed from: a */
    private final AtomicReferenceArray<AbstractRunnableC15181i> f43308a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    /* renamed from: b */
    public static /* synthetic */ AbstractRunnableC15181i m3734b(WorkQueue workQueue, AbstractRunnableC15181i abstractRunnableC15181i, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.m3735a(abstractRunnableC15181i, z);
    }

    /* renamed from: c */
    private final AbstractRunnableC15181i m3733c(AbstractRunnableC15181i abstractRunnableC15181i) {
        if (abstractRunnableC15181i.f43292b.mo3738h() == 1) {
            f43307e.incrementAndGet(this);
        }
        if (m3731e() == 127) {
            return abstractRunnableC15181i;
        }
        int i = this.producerIndex & 127;
        while (this.f43308a.get(i) != null) {
            Thread.yield();
        }
        this.f43308a.lazySet(i, abstractRunnableC15181i);
        f43305c.incrementAndGet(this);
        return null;
    }

    /* renamed from: d */
    private final void m3732d(AbstractRunnableC15181i abstractRunnableC15181i) {
        if (abstractRunnableC15181i != null) {
            if (abstractRunnableC15181i.f43292b.mo3738h() == 1) {
                f43307e.decrementAndGet(this);
            }
        }
    }

    /* renamed from: i */
    private final AbstractRunnableC15181i m3727i() {
        AbstractRunnableC15181i andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f43306d.compareAndSet(this, i, i + 1) && (andSet = this.f43308a.getAndSet(i2, null)) != null) {
                m3732d(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: j */
    private final boolean m3726j(Tasks tasks) {
        AbstractRunnableC15181i m3727i = m3727i();
        if (m3727i != null) {
            tasks.m4169a(m3727i);
            return true;
        }
        return false;
    }

    /* renamed from: m */
    private final long m3723m(WorkQueue workQueue, boolean z) {
        AbstractRunnableC15181i abstractRunnableC15181i;
        do {
            abstractRunnableC15181i = (AbstractRunnableC15181i) workQueue.lastScheduledTask;
            if (abstractRunnableC15181i == null) {
                return -2L;
            }
            if (z) {
                if (!(abstractRunnableC15181i.f43292b.mo3738h() == 1)) {
                    return -2L;
                }
            }
            long mo3736a = C15184l.f43301h.mo3736a() - abstractRunnableC15181i.f43291a;
            long j = C15184l.f43296c;
            if (mo3736a < j) {
                return j - mo3736a;
            }
        } while (!C13675a.m12692a(f43304b, workQueue, abstractRunnableC15181i, null));
        m3734b(this, abstractRunnableC15181i, false, 2, null);
        return -1L;
    }

    @Nullable
    /* renamed from: a */
    public final AbstractRunnableC15181i m3735a(@NotNull AbstractRunnableC15181i abstractRunnableC15181i, boolean z) {
        if (z) {
            return m3733c(abstractRunnableC15181i);
        }
        AbstractRunnableC15181i abstractRunnableC15181i2 = (AbstractRunnableC15181i) f43304b.getAndSet(this, abstractRunnableC15181i);
        if (abstractRunnableC15181i2 != null) {
            return m3733c(abstractRunnableC15181i2);
        }
        return null;
    }

    /* renamed from: e */
    public final int m3731e() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: f */
    public final int m3730f() {
        return this.lastScheduledTask != null ? m3731e() + 1 : m3731e();
    }

    /* renamed from: g */
    public final void m3729g(@NotNull Tasks tasks) {
        AbstractRunnableC15181i abstractRunnableC15181i = (AbstractRunnableC15181i) f43304b.getAndSet(this, null);
        if (abstractRunnableC15181i != null) {
            tasks.m4169a(abstractRunnableC15181i);
        }
        do {
        } while (m3726j(tasks));
    }

    @Nullable
    /* renamed from: h */
    public final AbstractRunnableC15181i m3728h() {
        AbstractRunnableC15181i abstractRunnableC15181i = (AbstractRunnableC15181i) f43304b.getAndSet(this, null);
        return abstractRunnableC15181i != null ? abstractRunnableC15181i : m3727i();
    }

    /* renamed from: k */
    public final long m3725k(@NotNull WorkQueue workQueue) {
        int i = workQueue.consumerIndex;
        int i2 = workQueue.producerIndex;
        AtomicReferenceArray<AbstractRunnableC15181i> atomicReferenceArray = workQueue.f43308a;
        while (true) {
            if (i == i2) {
                break;
            }
            int i3 = i & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            AbstractRunnableC15181i abstractRunnableC15181i = atomicReferenceArray.get(i3);
            if (abstractRunnableC15181i != null) {
                if ((abstractRunnableC15181i.f43292b.mo3738h() == 1) && atomicReferenceArray.compareAndSet(i3, abstractRunnableC15181i, null)) {
                    f43307e.decrementAndGet(workQueue);
                    m3734b(this, abstractRunnableC15181i, false, 2, null);
                    return -1L;
                }
            }
            i++;
        }
        return m3723m(workQueue, true);
    }

    /* renamed from: l */
    public final long m3724l(@NotNull WorkQueue workQueue) {
        AbstractRunnableC15181i m3727i = workQueue.m3727i();
        if (m3727i != null) {
            m3734b(this, m3727i, false, 2, null);
            return -1L;
        }
        return m3723m(workQueue, false);
    }
}
