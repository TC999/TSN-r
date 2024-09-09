package kotlinx.coroutines.scheduling;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.random.Random;
import kotlin.ranges.q;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.o3;
import kotlinx.coroutines.p3;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineScheduler.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003HKaB+\u0012\u0006\u0010S\u001a\u00020\f\u0012\u0006\u0010U\u001a\u00020\f\u0012\b\b\u0002\u0010W\u001a\u00020\u000f\u0012\b\b\u0002\u0010Y\u001a\u00020B\u00a2\u0006\u0004\b_\u0010`J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\fH\u0082\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH\u0082\b\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u000fH\u0082\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005H\u0082\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000fH\u0082\b\u00a2\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b$\u0010\u001dJ\u000f\u0010%\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b%\u0010\u0015J+\u0010'\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b)\u0010\nJ+\u0010,\u001a\u00020\u00192\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0000\u00a2\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u00a2\u0006\u0004\b0\u0010\u0012J\u001b\u00104\u001a\u00020\u00192\n\u00103\u001a\u000601j\u0002`2H\u0016\u00a2\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b6\u0010\u001bJ\u0015\u00108\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u000f\u00a2\u0006\u0004\b8\u00109J-\u0010=\u001a\u00020\u00192\n\u0010:\u001a\u000601j\u0002`22\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010&\u001a\u00020\u0005\u00a2\u0006\u0004\b=\u0010>J#\u0010?\u001a\u00020\u00032\n\u0010:\u001a\u000601j\u0002`22\u0006\u0010<\u001a\u00020;H\u0000\u00a2\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\bA\u0010\u001bJ\u000f\u0010C\u001a\u00020BH\u0016\u00a2\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020G8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020G8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010IR \u0010P\u001a\u000e\u0012\n\u0012\b\u0018\u00010\bR\u00020\u00000M8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010W\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010$R\u0014\u0010Y\u001a\u00020B8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010XR\u0015\u0010[\u001a\u00020\f8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010\u0015R\u0015\u0010]\u001a\u00020\f8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010\u0015R\u0011\u0010^\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b^\u0010\u001d\u00a8\u0006b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/i;", "task", "", "g", "(Lkotlinx/coroutines/scheduling/i;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "x", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "worker", "", "v", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)I", "", "state", "l", "(J)I", "i", "u", "()I", "o", "t", "()J", "Lkotlin/f1;", "n", "()V", "G", "()Z", "A", "skipUnpark", "D", "(Z)V", "H", "(J)Z", "J", "j", "tailDispatch", "F", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;Lkotlinx/coroutines/scheduling/i;Z)Lkotlinx/coroutines/scheduling/i;", "m", "oldIndex", "newIndex", "z", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;II)V", "y", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)Z", "h", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "timeout", "C", "(J)V", "block", "Lkotlinx/coroutines/scheduling/j;", "taskContext", "p", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;Z)V", "k", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;)Lkotlinx/coroutines/scheduling/i;", "E", "", "toString", "()Ljava/lang/String;", "B", "(Lkotlinx/coroutines/scheduling/i;)V", "Lkotlinx/coroutines/scheduling/e;", "a", "Lkotlinx/coroutines/scheduling/e;", "globalCpuQueue", "b", "globalBlockingQueue", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "c", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "d", "I", "corePoolSize", "e", "maxPoolSize", "f", "idleWorkerKeepAliveNs", "Ljava/lang/String;", "schedulerName", "s", "createdWorkers", "r", "availableCpuPermits", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: l  reason: collision with root package name */
    private static final int f60562l = -1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f60563m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f60564n = 1;

    /* renamed from: o  reason: collision with root package name */
    private static final int f60565o = 21;

    /* renamed from: p  reason: collision with root package name */
    private static final long f60566p = 2097151;

    /* renamed from: q  reason: collision with root package name */
    private static final long f60567q = 4398044413952L;

    /* renamed from: r  reason: collision with root package name */
    private static final int f60568r = 42;

    /* renamed from: s  reason: collision with root package name */
    private static final long f60569s = 9223367638808264704L;

    /* renamed from: t  reason: collision with root package name */
    public static final int f60570t = 1;

    /* renamed from: u  reason: collision with root package name */
    public static final int f60571u = 2097150;

    /* renamed from: v  reason: collision with root package name */
    private static final long f60572v = 2097151;

    /* renamed from: w  reason: collision with root package name */
    private static final long f60573w = -2097152;

    /* renamed from: x  reason: collision with root package name */
    private static final long f60574x = 2097152;
    private volatile int _isTerminated;
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final e f60576a;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final e f60577b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReferenceArray<b> f60578c;
    volatile long controlState;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public final int f60579d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public final int f60580e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public final long f60581f;
    @JvmField
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f60582g;
    private volatile long parkedWorkersStack;

    /* renamed from: y  reason: collision with root package name */
    public static final a f60575y = new a(null);
    @JvmField
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final j0 f60561k = new j0("NOT_IN_STACK");

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f60558h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: i  reason: collision with root package name */
    static final AtomicLongFieldUpdater f60559i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60560j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$a;", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/j0;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/j0;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public CoroutineScheduler(int i4, int i5, long j4, @NotNull String str) {
        this.f60579d = i4;
        this.f60580e = i5;
        this.f60581f = j4;
        this.f60582g = str;
        if (!(i4 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i4 + " should be at least 1").toString());
        }
        if (!(i5 >= i4)) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should be greater than or equals to core pool size " + i4).toString());
        }
        if (!(i5 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 > 0) {
            this.f60576a = new e();
            this.f60577b = new e();
            this.parkedWorkersStack = 0L;
            this.f60578c = new AtomicReferenceArray<>(i5 + 1);
            this.controlState = i4 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A() {
        return f60559i.addAndGet(this, 4398046511104L);
    }

    private final void D(boolean z3) {
        long addAndGet = f60559i.addAndGet(this, 2097152L);
        if (z3 || J() || H(addAndGet)) {
            return;
        }
        J();
    }

    private final i F(b bVar, i iVar, boolean z3) {
        if (bVar == null || bVar.f60585b == WorkerState.TERMINATED) {
            return iVar;
        }
        if (iVar.f60609b.n() == 0 && bVar.f60585b == WorkerState.BLOCKING) {
            return iVar;
        }
        bVar.f60589f = true;
        return bVar.f60584a.a(iVar, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G() {
        long j4;
        do {
            j4 = this.controlState;
            if (((int) ((9223367638808264704L & j4) >> 42)) == 0) {
                return false;
            }
        } while (!f60559i.compareAndSet(this, j4, j4 - 4398046511104L));
        return true;
    }

    private final boolean H(long j4) {
        int n4;
        n4 = q.n(((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21)), 0);
        if (n4 < this.f60579d) {
            int j5 = j();
            if (j5 == 1 && this.f60579d > 1) {
                j();
            }
            if (j5 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean I(CoroutineScheduler coroutineScheduler, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.H(j4);
    }

    private final boolean J() {
        b x3;
        do {
            x3 = x();
            if (x3 == null) {
                return false;
            }
        } while (!b.f60583h.compareAndSet(x3, -1, 0));
        LockSupport.unpark(x3);
        return true;
    }

    private final boolean g(i iVar) {
        if (iVar.f60609b.n() == 1) {
            return this.f60577b.a(iVar);
        }
        return this.f60576a.a(iVar);
    }

    private final int i(long j4) {
        return (int) ((j4 & 4398044413952L) >> 21);
    }

    private final int j() {
        int n4;
        synchronized (this.f60578c) {
            if (isTerminated()) {
                return -1;
            }
            long j4 = this.controlState;
            int i4 = (int) (j4 & 2097151);
            n4 = q.n(i4 - ((int) ((j4 & 4398044413952L) >> 21)), 0);
            if (n4 >= this.f60579d) {
                return 0;
            }
            if (i4 >= this.f60580e) {
                return 0;
            }
            int i5 = ((int) (this.controlState & 2097151)) + 1;
            if (i5 > 0 && this.f60578c.get(i5) == null) {
                b bVar = new b(this, i5);
                this.f60578c.set(i5, bVar);
                if (i5 == ((int) (2097151 & f60559i.incrementAndGet(this)))) {
                    bVar.start();
                    return n4 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l(long j4) {
        return (int) (j4 & 2097151);
    }

    private final b m() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || !f0.g(CoroutineScheduler.this, this)) {
            return null;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        f60559i.addAndGet(this, -2097152L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o() {
        return (int) (f60559i.getAndDecrement(this) & 2097151);
    }

    public static /* synthetic */ void q(CoroutineScheduler coroutineScheduler, Runnable runnable, j jVar, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            jVar = h.f60607b;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        coroutineScheduler.p(runnable, jVar, z3);
    }

    private final int r() {
        return (int) ((this.controlState & 9223367638808264704L) >> 42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s() {
        return (int) (this.controlState & 2097151);
    }

    private final long t() {
        return f60559i.addAndGet(this, 2097152L);
    }

    private final int u() {
        return (int) (f60559i.incrementAndGet(this) & 2097151);
    }

    private final int v(b bVar) {
        Object g4 = bVar.g();
        while (g4 != f60561k) {
            if (g4 == null) {
                return 0;
            }
            b bVar2 = (b) g4;
            int f4 = bVar2.f();
            if (f4 != 0) {
                return f4;
            }
            g4 = bVar2.g();
        }
        return -1;
    }

    private final b x() {
        while (true) {
            long j4 = this.parkedWorkersStack;
            b bVar = this.f60578c.get((int) (2097151 & j4));
            if (bVar == null) {
                return null;
            }
            long j5 = (2097152 + j4) & (-2097152);
            int v3 = v(bVar);
            if (v3 >= 0 && f60558h.compareAndSet(this, j4, v3 | j5)) {
                bVar.p(f60561k);
                return bVar;
            }
        }
    }

    public final void B(@NotNull i iVar) {
        try {
            iVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                o3 b4 = p3.b();
                if (b4 == null) {
                }
            } finally {
                o3 b5 = p3.b();
                if (b5 != null) {
                    b5.b();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r8 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C(long r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f60560j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r7.m()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r1 = r7.f60578c
            monitor-enter(r1)
            long r3 = r7.controlState     // Catch: java.lang.Throwable -> L7d
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r4 = (int) r3
            monitor-exit(r1)
            if (r2 > r4) goto L43
            r1 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r7.f60578c
            java.lang.Object r3 = r3.get(r1)
            kotlin.jvm.internal.f0.m(r3)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r3 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r3
            if (r3 == r0) goto L3e
        L2a:
            boolean r5 = r3.isAlive()
            if (r5 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r3)
            r3.join(r8)
            goto L2a
        L37:
            kotlinx.coroutines.scheduling.n r3 = r3.f60584a
            kotlinx.coroutines.scheduling.e r5 = r7.f60577b
            r3.g(r5)
        L3e:
            if (r1 == r4) goto L43
            int r1 = r1 + 1
            goto L1d
        L43:
            kotlinx.coroutines.scheduling.e r8 = r7.f60577b
            r8.b()
            kotlinx.coroutines.scheduling.e r8 = r7.f60576a
            r8.b()
        L4d:
            if (r0 == 0) goto L56
            kotlinx.coroutines.scheduling.i r8 = r0.e(r2)
            if (r8 == 0) goto L56
            goto L5e
        L56:
            kotlinx.coroutines.scheduling.e r8 = r7.f60576a
            java.lang.Object r8 = r8.g()
            kotlinx.coroutines.scheduling.i r8 = (kotlinx.coroutines.scheduling.i) r8
        L5e:
            if (r8 == 0) goto L61
            goto L69
        L61:
            kotlinx.coroutines.scheduling.e r8 = r7.f60577b
            java.lang.Object r8 = r8.g()
            kotlinx.coroutines.scheduling.i r8 = (kotlinx.coroutines.scheduling.i) r8
        L69:
            if (r8 == 0) goto L6f
            r7.B(r8)
            goto L4d
        L6f:
            if (r0 == 0) goto L76
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.s(r8)
        L76:
            r8 = 0
            r7.parkedWorkersStack = r8
            r7.controlState = r8
            return
        L7d:
            r8 = move-exception
            monitor-exit(r1)
            goto L81
        L80:
            throw r8
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.C(long):void");
    }

    public final void E() {
        if (J() || I(this, 0L, 1, null)) {
            return;
        }
        J();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        q(this, runnable, null, false, 6, null);
    }

    public final int h(long j4) {
        return (int) ((j4 & 9223367638808264704L) >> 42);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    @NotNull
    public final i k(@NotNull Runnable runnable, @NotNull j jVar) {
        long a4 = l.f60618h.a();
        if (runnable instanceof i) {
            i iVar = (i) runnable;
            iVar.f60608a = a4;
            iVar.f60609b = jVar;
            return iVar;
        }
        return new k(runnable, a4, jVar);
    }

    public final void p(@NotNull Runnable runnable, @NotNull j jVar, boolean z3) {
        o3 b4 = p3.b();
        if (b4 != null) {
            b4.f();
        }
        i k4 = k(runnable, jVar);
        b m4 = m();
        i F = F(m4, k4, z3);
        if (F != null && !g(F)) {
            throw new RejectedExecutionException(this.f60582g + " was terminated");
        }
        boolean z4 = z3 && m4 != null;
        if (k4.f60609b.n() != 0) {
            D(z4);
        } else if (z4) {
        } else {
            E();
        }
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f60578c.length();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 1; i9 < length; i9++) {
            b bVar = this.f60578c.get(i9);
            if (bVar != null) {
                int f4 = bVar.f60584a.f();
                int i10 = kotlinx.coroutines.scheduling.a.f60591a[bVar.f60585b.ordinal()];
                if (i10 == 1) {
                    i6++;
                } else if (i10 == 2) {
                    i5++;
                    arrayList.add(String.valueOf(f4) + "b");
                } else if (i10 == 3) {
                    i4++;
                    arrayList.add(String.valueOf(f4) + "c");
                } else if (i10 == 4) {
                    i7++;
                    if (f4 > 0) {
                        arrayList.add(String.valueOf(f4) + "d");
                    }
                } else if (i10 == 5) {
                    i8++;
                }
            }
        }
        long j4 = this.controlState;
        return this.f60582g + '@' + u0.b(this) + "[Pool Size {core = " + this.f60579d + ", max = " + this.f60580e + "}, Worker States {CPU = " + i4 + ", blocking = " + i5 + ", parked = " + i6 + ", dormant = " + i7 + ", terminated = " + i8 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f60576a.c() + ", global blocking queue size = " + this.f60577b.c() + ", Control State {created workers= " + ((int) (2097151 & j4)) + ", blocking tasks = " + ((int) ((4398044413952L & j4) >> 21)) + ", CPUs acquired = " + (this.f60579d - ((int) ((9223367638808264704L & j4) >> 42))) + "}]";
    }

    public final boolean y(@NotNull b bVar) {
        long j4;
        int f4;
        if (bVar.g() != f60561k) {
            return false;
        }
        do {
            j4 = this.parkedWorkersStack;
            f4 = bVar.f();
            bVar.p(this.f60578c.get((int) (2097151 & j4)));
        } while (!f60558h.compareAndSet(this, j4, ((2097152 + j4) & (-2097152)) | f4));
        return true;
    }

    public final void z(@NotNull b bVar, int i4, int i5) {
        while (true) {
            long j4 = this.parkedWorkersStack;
            int i6 = (int) (2097151 & j4);
            long j5 = (2097152 + j4) & (-2097152);
            if (i6 == i4) {
                i6 = i5 == 0 ? v(bVar) : i5;
            }
            if (i6 >= 0 && f60558h.compareAndSet(this, j4, j5 | i6)) {
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineScheduler.kt */
    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e\u00a2\u0006\u0004\bD\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0000\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\"\u0010\u0007J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010\u0019R*\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0011R\u0014\u0010/\u001a\u00020-8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R\u0016\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00103R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00103R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010)R\u0016\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010>R\u0012\u0010C\u001a\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "Ljava/lang/Thread;", "", CampaignEx.JSON_KEY_AD_Q, "()Z", "Lkotlin/f1;", "n", "()V", "r", "j", "Lkotlinx/coroutines/scheduling/i;", "task", "c", "(Lkotlinx/coroutines/scheduling/i;)V", "", "taskMode", "b", "(I)V", "a", "l", "u", "mode", "i", "scanLocalQueue", "d", "(Z)Lkotlinx/coroutines/scheduling/i;", "m", "()Lkotlinx/coroutines/scheduling/i;", "blockingOnly", "t", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "k", "(I)I", "e", "index", "indexInArray", "I", "f", "()I", "o", "Lkotlinx/coroutines/scheduling/n;", "Lkotlinx/coroutines/scheduling/n;", "localQueue", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "p", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "mayHaveLocalTasks", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "h", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends Thread {

        /* renamed from: h  reason: collision with root package name */
        static final AtomicIntegerFieldUpdater f60583h = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
        @JvmField
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final n f60584a;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public WorkerState f60585b;

        /* renamed from: c  reason: collision with root package name */
        private long f60586c;

        /* renamed from: d  reason: collision with root package name */
        private long f60587d;

        /* renamed from: e  reason: collision with root package name */
        private int f60588e;
        @JvmField

        /* renamed from: f  reason: collision with root package name */
        public boolean f60589f;
        private volatile int indexInArray;
        @Nullable
        private volatile Object nextParkedWorker;
        @NotNull
        volatile int workerCtl;

        private b() {
            setDaemon(true);
            this.f60584a = new n();
            this.f60585b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f60561k;
            this.f60588e = Random.Default.nextInt();
        }

        private final void a(int i4) {
            if (i4 == 0) {
                return;
            }
            CoroutineScheduler.f60559i.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f60585b != WorkerState.TERMINATED) {
                this.f60585b = WorkerState.DORMANT;
            }
        }

        private final void b(int i4) {
            if (i4 != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.E();
            }
        }

        private final void c(i iVar) {
            int n4 = iVar.f60609b.n();
            i(n4);
            b(n4);
            CoroutineScheduler.this.B(iVar);
            a(n4);
        }

        private final i d(boolean z3) {
            i m4;
            i m5;
            if (z3) {
                boolean z4 = k(CoroutineScheduler.this.f60579d * 2) == 0;
                if (z4 && (m5 = m()) != null) {
                    return m5;
                }
                i h4 = this.f60584a.h();
                if (h4 != null) {
                    return h4;
                }
                if (!z4 && (m4 = m()) != null) {
                    return m4;
                }
            } else {
                i m6 = m();
                if (m6 != null) {
                    return m6;
                }
            }
            return t(false);
        }

        private final void i(int i4) {
            this.f60586c = 0L;
            if (this.f60585b == WorkerState.PARKING) {
                this.f60585b = WorkerState.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f60561k;
        }

        private final void l() {
            if (this.f60586c == 0) {
                this.f60586c = System.nanoTime() + CoroutineScheduler.this.f60581f;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f60581f);
            if (System.nanoTime() - this.f60586c >= 0) {
                this.f60586c = 0L;
                u();
            }
        }

        private final i m() {
            if (k(2) == 0) {
                i g4 = CoroutineScheduler.this.f60576a.g();
                return g4 != null ? g4 : CoroutineScheduler.this.f60577b.g();
            }
            i g5 = CoroutineScheduler.this.f60577b.g();
            return g5 != null ? g5 : CoroutineScheduler.this.f60576a.g();
        }

        private final void n() {
            loop0: while (true) {
                boolean z3 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f60585b != WorkerState.TERMINATED) {
                    i e4 = e(this.f60589f);
                    if (e4 != null) {
                        this.f60587d = 0L;
                        c(e4);
                    } else {
                        this.f60589f = false;
                        if (this.f60587d == 0) {
                            r();
                        } else if (z3) {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f60587d);
                            this.f60587d = 0L;
                        } else {
                            z3 = true;
                        }
                    }
                }
            }
            s(WorkerState.TERMINATED);
        }

        private final boolean q() {
            boolean z3;
            if (this.f60585b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j4 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j4) >> 42)) != 0) {
                        if (CoroutineScheduler.f60559i.compareAndSet(coroutineScheduler, j4, j4 - 4398046511104L)) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    return false;
                }
                this.f60585b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.y(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && !CoroutineScheduler.this.isTerminated() && this.f60585b != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final i t(boolean z3) {
            long l4;
            int s3 = CoroutineScheduler.this.s();
            if (s3 < 2) {
                return null;
            }
            int k4 = k(s3);
            long j4 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < s3; i4++) {
                k4++;
                if (k4 > s3) {
                    k4 = 1;
                }
                b bVar = CoroutineScheduler.this.f60578c.get(k4);
                if (bVar != null && bVar != this) {
                    if (z3) {
                        l4 = this.f60584a.k(bVar.f60584a);
                    } else {
                        l4 = this.f60584a.l(bVar.f60584a);
                    }
                    if (l4 == -1) {
                        return this.f60584a.h();
                    }
                    if (l4 > 0) {
                        j4 = Math.min(j4, l4);
                    }
                }
            }
            if (j4 == Long.MAX_VALUE) {
                j4 = 0;
            }
            this.f60587d = j4;
            return null;
        }

        private final void u() {
            synchronized (CoroutineScheduler.this.f60578c) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.s() <= CoroutineScheduler.this.f60579d) {
                    return;
                }
                if (f60583h.compareAndSet(this, -1, 1)) {
                    int i4 = this.indexInArray;
                    o(0);
                    CoroutineScheduler.this.z(this, i4, 0);
                    int andDecrement = (int) (CoroutineScheduler.f60559i.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i4) {
                        b bVar = CoroutineScheduler.this.f60578c.get(andDecrement);
                        f0.m(bVar);
                        b bVar2 = bVar;
                        CoroutineScheduler.this.f60578c.set(i4, bVar2);
                        bVar2.o(i4);
                        CoroutineScheduler.this.z(bVar2, andDecrement, i4);
                    }
                    CoroutineScheduler.this.f60578c.set(andDecrement, null);
                    f1 f1Var = f1.f55527a;
                    this.f60585b = WorkerState.TERMINATED;
                }
            }
        }

        @Nullable
        public final i e(boolean z3) {
            i g4;
            if (q()) {
                return d(z3);
            }
            if (z3) {
                g4 = this.f60584a.h();
                if (g4 == null) {
                    g4 = CoroutineScheduler.this.f60577b.g();
                }
            } else {
                g4 = CoroutineScheduler.this.f60577b.g();
            }
            return g4 != null ? g4 : t(true);
        }

        public final int f() {
            return this.indexInArray;
        }

        @Nullable
        public final Object g() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler h() {
            return CoroutineScheduler.this;
        }

        public final int k(int i4) {
            int i5 = this.f60588e;
            int i6 = i5 ^ (i5 << 13);
            int i7 = i6 ^ (i6 >> 17);
            int i8 = i7 ^ (i7 << 5);
            this.f60588e = i8;
            int i9 = i4 - 1;
            return (i9 & i4) == 0 ? i8 & i9 : (i8 & Integer.MAX_VALUE) % i4;
        }

        public final void o(int i4) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f60582g);
            sb.append("-worker-");
            sb.append(i4 == 0 ? "TERMINATED" : String.valueOf(i4));
            setName(sb.toString());
            this.indexInArray = i4;
        }

        public final void p(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f60585b;
            boolean z3 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z3) {
                CoroutineScheduler.f60559i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f60585b = workerState;
            }
            return z3;
        }

        public b(CoroutineScheduler coroutineScheduler, int i4) {
            this();
            o(i4);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i4, int i5, long j4, String str, int i6, u uVar) {
        this(i4, i5, (i6 & 4) != 0 ? l.f60617g : j4, (i6 & 8) != 0 ? "DefaultDispatcher" : str);
    }
}
