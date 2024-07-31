package kotlinx.coroutines.scheduling;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.random.Random;
import kotlin.ranges._Ranges;
import kotlinx.coroutines.C15156p3;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InterfaceC15152o3;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineScheduler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003HKaB+\u0012\u0006\u0010R\u001a\u00020\f\u0012\u0006\u0010T\u001a\u00020\f\u0012\b\b\u0002\u0010V\u001a\u00020\u000f\u0012\b\b\u0002\u0010X\u001a\u00020B¢\u0006\u0004\b^\u0010_J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\fH\u0082\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0082\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u001dJ\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0015J+\u0010'\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b)\u0010\nJ+\u0010,\u001a\u00020\u00192\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0000¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b¢\u0006\u0004\b0\u0010\u0012J\u001b\u00104\u001a\u00020\u00192\n\u00103\u001a\u000601j\u0002`2H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0019H\u0016¢\u0006\u0004\b6\u0010\u001bJ\u0015\u00108\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u000f¢\u0006\u0004\b8\u00109J-\u0010=\u001a\u00020\u00192\n\u0010:\u001a\u000601j\u0002`22\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010&\u001a\u00020\u0005¢\u0006\u0004\b=\u0010>J#\u0010?\u001a\u00020\u00032\n\u0010:\u001a\u000601j\u0002`22\u0006\u0010<\u001a\u00020;H\u0000¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0019H\u0000¢\u0006\u0004\bA\u0010\u001bJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010IR \u0010P\u001a\u000e\u0012\n\u0012\b\u0018\u00010\bR\u00020\u00000M8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010ER\u0014\u0010T\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010ER\u0014\u0010V\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u00108R\u0014\u0010X\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010WR\u0015\u0010Z\u001a\u00020\f8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0015R\u0015\u0010\\\u001a\u00020\f8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0015R\u0011\u0010]\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b]\u0010\u001d¨\u0006b"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/i;", "task", "", "g", "(Lkotlinx/coroutines/scheduling/i;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", ExifInterface.LONGITUDE_EAST, "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "worker", "", "D", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)I", "", "state", C7304t.f25048d, "(J)I", "i", "C", "()I", "p", "B", "()J", "Lkotlin/f1;", "n", "()V", "N", "()Z", "H", "skipUnpark", "K", "(Z)V", "O", "(J)Z", "Q", "j", "tailDispatch", "M", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;Lkotlinx/coroutines/scheduling/i;Z)Lkotlinx/coroutines/scheduling/i;", "m", "oldIndex", "newIndex", "G", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;II)V", "F", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)Z", "h", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "timeout", "J", "(J)V", "block", "Lkotlinx/coroutines/scheduling/j;", "taskContext", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;Z)V", "k", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/j;)Lkotlinx/coroutines/scheduling/i;", "L", "", "toString", "()Ljava/lang/String;", "I", "(Lkotlinx/coroutines/scheduling/i;)V", "Lkotlinx/coroutines/scheduling/e;", "a", "Lkotlinx/coroutines/scheduling/e;", "globalCpuQueue", "b", "globalBlockingQueue", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "c", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "d", "corePoolSize", "e", "maxPoolSize", "f", "idleWorkerKeepAliveNs", "Ljava/lang/String;", "schedulerName", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "createdWorkers", "s", "availableCpuPermits", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "y", "WorkerState", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: l */
    private static final int f43245l = -1;

    /* renamed from: m */
    private static final int f43246m = 0;

    /* renamed from: n */
    private static final int f43247n = 1;

    /* renamed from: o */
    private static final int f43248o = 21;

    /* renamed from: p */
    private static final long f43249p = 2097151;

    /* renamed from: q */
    private static final long f43250q = 4398044413952L;

    /* renamed from: r */
    private static final int f43251r = 42;

    /* renamed from: s */
    private static final long f43252s = 9223367638808264704L;

    /* renamed from: t */
    public static final int f43253t = 1;

    /* renamed from: u */
    public static final int f43254u = 2097150;

    /* renamed from: v */
    private static final long f43255v = 2097151;

    /* renamed from: w */
    private static final long f43256w = -2097152;

    /* renamed from: x */
    private static final long f43257x = 2097152;
    private volatile int _isTerminated;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public final Tasks f43259a;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public final Tasks f43260b;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public final AtomicReferenceArray<C15173b> f43261c;
    volatile long controlState;
    @JvmPlatformAnnotations

    /* renamed from: d */
    public final int f43262d;
    @JvmPlatformAnnotations

    /* renamed from: e */
    public final int f43263e;
    @JvmPlatformAnnotations

    /* renamed from: f */
    public final long f43264f;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: g */
    public final String f43265g;
    private volatile long parkedWorkersStack;

    /* renamed from: y */
    public static final C15172a f43258y = new C15172a(null);
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: k */
    public static final Symbol f43244k = new Symbol("NOT_IN_STACK");

    /* renamed from: h */
    private static final AtomicLongFieldUpdater f43241h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: i */
    static final AtomicLongFieldUpdater f43242i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: j */
    private static final AtomicIntegerFieldUpdater f43243j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$a;", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/j0;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/j0;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15172a {
        private C15172a() {
        }

        public /* synthetic */ C15172a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineScheduler(int i, int i2, long j, @NotNull String str) {
        this.f43262d = i;
        this.f43263e = i2;
        this.f43264f = j;
        this.f43265g = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j > 0) {
            this.f43259a = new Tasks();
            this.f43260b = new Tasks();
            this.parkedWorkersStack = 0L;
            this.f43261c = new AtomicReferenceArray<>(i2 + 1);
            this.controlState = i << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public final int m3809A() {
        return (int) (this.controlState & 2097151);
    }

    /* renamed from: B */
    private final long m3808B() {
        return f43242i.addAndGet(this, 2097152L);
    }

    /* renamed from: C */
    private final int m3807C() {
        return (int) (f43242i.incrementAndGet(this) & 2097151);
    }

    /* renamed from: D */
    private final int m3806D(C15173b c15173b) {
        Object m3768g = c15173b.m3768g();
        while (m3768g != f43244k) {
            if (m3768g == null) {
                return 0;
            }
            C15173b c15173b2 = (C15173b) m3768g;
            int m3769f = c15173b2.m3769f();
            if (m3769f != 0) {
                return m3769f;
            }
            m3768g = c15173b2.m3768g();
        }
        return -1;
    }

    /* renamed from: E */
    private final C15173b m3805E() {
        while (true) {
            long j = this.parkedWorkersStack;
            C15173b c15173b = this.f43261c.get((int) (2097151 & j));
            if (c15173b == null) {
                return null;
            }
            long j2 = (2097152 + j) & f43256w;
            int m3806D = m3806D(c15173b);
            if (m3806D >= 0 && f43241h.compareAndSet(this, j, m3806D | j2)) {
                c15173b.m3759p(f43244k);
                return c15173b;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public final long m3802H() {
        return f43242i.addAndGet(this, 4398046511104L);
    }

    /* renamed from: K */
    private final void m3799K(boolean z) {
        long addAndGet = f43242i.addAndGet(this, 2097152L);
        if (z || m3793Q() || m3795O(addAndGet)) {
            return;
        }
        m3793Q();
    }

    /* renamed from: M */
    private final AbstractRunnableC15181i m3797M(C15173b c15173b, AbstractRunnableC15181i abstractRunnableC15181i, boolean z) {
        if (c15173b == null || c15173b.f43268b == WorkerState.TERMINATED) {
            return abstractRunnableC15181i;
        }
        if (abstractRunnableC15181i.f43292b.mo3738h() == 0 && c15173b.f43268b == WorkerState.BLOCKING) {
            return abstractRunnableC15181i;
        }
        c15173b.f43272f = true;
        return c15173b.f43267a.m3735a(abstractRunnableC15181i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final boolean m3796N() {
        long j;
        do {
            j = this.controlState;
            if (((int) ((f43252s & j) >> 42)) == 0) {
                return false;
            }
        } while (!f43242i.compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    /* renamed from: O */
    private final boolean m3795O(long j) {
        int m7481n;
        m7481n = _Ranges.m7481n(((int) (2097151 & j)) - ((int) ((j & f43250q) >> 21)), 0);
        if (m7481n < this.f43262d) {
            int m3783j = m3783j();
            if (m3783j == 1 && this.f43262d > 1) {
                m3783j();
            }
            if (m3783j > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: P */
    static /* synthetic */ boolean m3794P(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.m3795O(j);
    }

    /* renamed from: Q */
    private final boolean m3793Q() {
        C15173b m3805E;
        do {
            m3805E = m3805E();
            if (m3805E == null) {
                return false;
            }
        } while (!C15173b.f43266h.compareAndSet(m3805E, -1, 0));
        LockSupport.unpark(m3805E);
        return true;
    }

    /* renamed from: g */
    private final boolean m3786g(AbstractRunnableC15181i abstractRunnableC15181i) {
        if (abstractRunnableC15181i.f43292b.mo3738h() == 1) {
            return this.f43260b.m4169a(abstractRunnableC15181i);
        }
        return this.f43259a.m4169a(abstractRunnableC15181i);
    }

    /* renamed from: i */
    private final int m3784i(long j) {
        return (int) ((j & f43250q) >> 21);
    }

    /* renamed from: j */
    private final int m3783j() {
        int m7481n;
        synchronized (this.f43261c) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            m7481n = _Ranges.m7481n(i - ((int) ((j & f43250q) >> 21)), 0);
            if (m7481n >= this.f43262d) {
                return 0;
            }
            if (i >= this.f43263e) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (i2 > 0 && this.f43261c.get(i2) == null) {
                C15173b c15173b = new C15173b(this, i2);
                this.f43261c.set(i2, c15173b);
                if (i2 == ((int) (2097151 & f43242i.incrementAndGet(this)))) {
                    c15173b.start();
                    return m7481n + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final int m3781l(long j) {
        return (int) (j & 2097151);
    }

    /* renamed from: m */
    private final C15173b m3780m() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof C15173b)) {
            currentThread = null;
        }
        C15173b c15173b = (C15173b) currentThread;
        if (c15173b == null || !C14342f0.m8193g(CoroutineScheduler.this, this)) {
            return null;
        }
        return c15173b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public final void m3779n() {
        f43242i.addAndGet(this, f43256w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public final int m3778p() {
        return (int) (f43242i.getAndDecrement(this) & 2097151);
    }

    /* renamed from: r */
    public static /* synthetic */ void m3776r(CoroutineScheduler coroutineScheduler, Runnable runnable, InterfaceC15182j interfaceC15182j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC15182j = C15180h.f43290b;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.m3777q(runnable, interfaceC15182j, z);
    }

    /* renamed from: s */
    private final int m3775s() {
        return (int) ((this.controlState & f43252s) >> 42);
    }

    /* renamed from: F */
    public final boolean m3804F(@NotNull C15173b c15173b) {
        long j;
        long j2;
        int m3769f;
        if (c15173b.m3768g() != f43244k) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            j2 = (2097152 + j) & f43256w;
            m3769f = c15173b.m3769f();
            c15173b.m3759p(this.f43261c.get((int) (2097151 & j)));
        } while (!f43241h.compareAndSet(this, j, j2 | m3769f));
        return true;
    }

    /* renamed from: G */
    public final void m3803G(@NotNull C15173b c15173b, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & f43256w;
            if (i3 == i) {
                i3 = i2 == 0 ? m3806D(c15173b) : i2;
            }
            if (i3 >= 0 && f43241h.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    /* renamed from: I */
    public final void m3801I(@NotNull AbstractRunnableC15181i abstractRunnableC15181i) {
        try {
            abstractRunnableC15181i.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                InterfaceC15152o3 m3872b = C15156p3.m3872b();
                if (m3872b == null) {
                }
            } finally {
                InterfaceC15152o3 m3872b2 = C15156p3.m3872b();
                if (m3872b2 != null) {
                    m3872b2.m3931b();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r8 != null) goto L27;
     */
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3800J(long r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f43243j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r7.m3780m()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r1 = r7.f43261c
            monitor-enter(r1)
            long r3 = r7.controlState     // Catch: java.lang.Throwable -> L7d
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r4 = (int) r3
            monitor-exit(r1)
            if (r2 > r4) goto L43
            r1 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r7.f43261c
            java.lang.Object r3 = r3.get(r1)
            kotlin.jvm.internal.C14342f0.m8187m(r3)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r3 = (kotlinx.coroutines.scheduling.CoroutineScheduler.C15173b) r3
            if (r3 == r0) goto L3e
        L2a:
            boolean r5 = r3.isAlive()
            if (r5 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r3)
            r3.join(r8)
            goto L2a
        L37:
            kotlinx.coroutines.scheduling.n r3 = r3.f43267a
            kotlinx.coroutines.scheduling.e r5 = r7.f43260b
            r3.m3729g(r5)
        L3e:
            if (r1 == r4) goto L43
            int r1 = r1 + 1
            goto L1d
        L43:
            kotlinx.coroutines.scheduling.e r8 = r7.f43260b
            r8.m4168b()
            kotlinx.coroutines.scheduling.e r8 = r7.f43259a
            r8.m4168b()
        L4d:
            if (r0 == 0) goto L56
            kotlinx.coroutines.scheduling.i r8 = r0.m3770e(r2)
            if (r8 == 0) goto L56
            goto L5e
        L56:
            kotlinx.coroutines.scheduling.e r8 = r7.f43259a
            java.lang.Object r8 = r8.m4163g()
            kotlinx.coroutines.scheduling.i r8 = (kotlinx.coroutines.scheduling.AbstractRunnableC15181i) r8
        L5e:
            if (r8 == 0) goto L61
            goto L69
        L61:
            kotlinx.coroutines.scheduling.e r8 = r7.f43260b
            java.lang.Object r8 = r8.m4163g()
            kotlinx.coroutines.scheduling.i r8 = (kotlinx.coroutines.scheduling.AbstractRunnableC15181i) r8
        L69:
            if (r8 == 0) goto L6f
            r7.m3801I(r8)
            goto L4d
        L6f:
            if (r0 == 0) goto L76
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.m3756s(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.m3800J(long):void");
    }

    /* renamed from: L */
    public final void m3798L() {
        if (m3793Q() || m3794P(this, 0L, 1, null)) {
            return;
        }
        m3793Q();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m3800J(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        m3776r(this, runnable, null, false, 6, null);
    }

    /* renamed from: h */
    public final int m3785h(long j) {
        return (int) ((j & f43252s) >> 42);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    @NotNull
    /* renamed from: k */
    public final AbstractRunnableC15181i m3782k(@NotNull Runnable runnable, @NotNull InterfaceC15182j interfaceC15182j) {
        long mo3736a = C15184l.f43301h.mo3736a();
        if (runnable instanceof AbstractRunnableC15181i) {
            AbstractRunnableC15181i abstractRunnableC15181i = (AbstractRunnableC15181i) runnable;
            abstractRunnableC15181i.f43291a = mo3736a;
            abstractRunnableC15181i.f43292b = interfaceC15182j;
            return abstractRunnableC15181i;
        }
        return new C15183k(runnable, mo3736a, interfaceC15182j);
    }

    /* renamed from: q */
    public final void m3777q(@NotNull Runnable runnable, @NotNull InterfaceC15182j interfaceC15182j, boolean z) {
        InterfaceC15152o3 m3872b = C15156p3.m3872b();
        if (m3872b != null) {
            m3872b.m3927f();
        }
        AbstractRunnableC15181i m3782k = m3782k(runnable, interfaceC15182j);
        C15173b m3780m = m3780m();
        AbstractRunnableC15181i m3797M = m3797M(m3780m, m3782k, z);
        if (m3797M != null && !m3786g(m3797M)) {
            throw new RejectedExecutionException(this.f43265g + " was terminated");
        }
        boolean z2 = z && m3780m != null;
        if (m3782k.f43292b.mo3738h() != 0) {
            m3799K(z2);
        } else if (z2) {
        } else {
            m3798L();
        }
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f43261c.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            C15173b c15173b = this.f43261c.get(i6);
            if (c15173b != null) {
                int m3730f = c15173b.f43267a.m3730f();
                int i7 = C15174a.f43274a[c15173b.f43268b.ordinal()];
                if (i7 == 1) {
                    i3++;
                } else if (i7 == 2) {
                    i2++;
                    arrayList.add(String.valueOf(m3730f) + "b");
                } else if (i7 == 3) {
                    i++;
                    arrayList.add(String.valueOf(m3730f) + "c");
                } else if (i7 == 4) {
                    i4++;
                    if (m3730f > 0) {
                        arrayList.add(String.valueOf(m3730f) + "d");
                    }
                } else if (i7 == 5) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.f43265g + '@' + DebugStrings.m3553b(this) + "[Pool Size {core = " + this.f43262d + ", max = " + this.f43263e + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f43259a.m4167c() + ", global blocking queue size = " + this.f43260b.m4167c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((f43250q & j) >> 21)) + ", CPUs acquired = " + (this.f43262d - ((int) ((f43252s & j) >> 42))) + "}]";
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\bD\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0019R*\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0011R\u0014\u0010/\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010.R\u0016\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00103R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00103R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010)R\u0016\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010>R\u0012\u0010C\u001a\u00020@8Æ\u0002¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006G"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "Ljava/lang/Thread;", "", CampaignEx.JSON_KEY_AD_Q, "()Z", "Lkotlin/f1;", "n", "()V", "r", "j", "Lkotlinx/coroutines/scheduling/i;", "task", "c", "(Lkotlinx/coroutines/scheduling/i;)V", "", "taskMode", "b", "(I)V", "a", C7304t.f25048d, "u", RtspHeaders.Values.MODE, "i", "scanLocalQueue", "d", "(Z)Lkotlinx/coroutines/scheduling/i;", "m", "()Lkotlinx/coroutines/scheduling/i;", "blockingOnly", UMCommonContent.f37782aL, "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "k", "(I)I", "e", "index", "indexInArray", "I", "f", "()I", "o", "Lkotlinx/coroutines/scheduling/n;", "Lkotlinx/coroutines/scheduling/n;", "localQueue", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "p", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "mayHaveLocalTasks", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "h", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15173b extends Thread {

        /* renamed from: h */
        static final AtomicIntegerFieldUpdater f43266h = AtomicIntegerFieldUpdater.newUpdater(C15173b.class, "workerCtl");
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: a */
        public final WorkQueue f43267a;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public WorkerState f43268b;

        /* renamed from: c */
        private long f43269c;

        /* renamed from: d */
        private long f43270d;

        /* renamed from: e */
        private int f43271e;
        @JvmPlatformAnnotations

        /* renamed from: f */
        public boolean f43272f;
        private volatile int indexInArray;
        @Nullable
        private volatile Object nextParkedWorker;
        @NotNull
        volatile int workerCtl;

        private C15173b() {
            setDaemon(true);
            this.f43267a = new WorkQueue();
            this.f43268b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f43244k;
            this.f43271e = Random.Default.nextInt();
        }

        /* renamed from: a */
        private final void m3774a(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.f43242i.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f43256w);
            if (this.f43268b != WorkerState.TERMINATED) {
                this.f43268b = WorkerState.DORMANT;
            }
        }

        /* renamed from: b */
        private final void m3773b(int i) {
            if (i != 0 && m3756s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.m3798L();
            }
        }

        /* renamed from: c */
        private final void m3772c(AbstractRunnableC15181i abstractRunnableC15181i) {
            int mo3738h = abstractRunnableC15181i.f43292b.mo3738h();
            m3766i(mo3738h);
            m3773b(mo3738h);
            CoroutineScheduler.this.m3801I(abstractRunnableC15181i);
            m3774a(mo3738h);
        }

        /* renamed from: d */
        private final AbstractRunnableC15181i m3771d(boolean z) {
            AbstractRunnableC15181i m3762m;
            AbstractRunnableC15181i m3762m2;
            if (z) {
                boolean z2 = m3764k(CoroutineScheduler.this.f43262d * 2) == 0;
                if (z2 && (m3762m2 = m3762m()) != null) {
                    return m3762m2;
                }
                AbstractRunnableC15181i m3728h = this.f43267a.m3728h();
                if (m3728h != null) {
                    return m3728h;
                }
                if (!z2 && (m3762m = m3762m()) != null) {
                    return m3762m;
                }
            } else {
                AbstractRunnableC15181i m3762m3 = m3762m();
                if (m3762m3 != null) {
                    return m3762m3;
                }
            }
            return m3755t(false);
        }

        /* renamed from: i */
        private final void m3766i(int i) {
            this.f43269c = 0L;
            if (this.f43268b == WorkerState.PARKING) {
                this.f43268b = WorkerState.BLOCKING;
            }
        }

        /* renamed from: j */
        private final boolean m3765j() {
            return this.nextParkedWorker != CoroutineScheduler.f43244k;
        }

        /* renamed from: l */
        private final void m3763l() {
            if (this.f43269c == 0) {
                this.f43269c = System.nanoTime() + CoroutineScheduler.this.f43264f;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f43264f);
            if (System.nanoTime() - this.f43269c >= 0) {
                this.f43269c = 0L;
                m3754u();
            }
        }

        /* renamed from: m */
        private final AbstractRunnableC15181i m3762m() {
            if (m3764k(2) == 0) {
                AbstractRunnableC15181i m4163g = CoroutineScheduler.this.f43259a.m4163g();
                return m4163g != null ? m4163g : CoroutineScheduler.this.f43260b.m4163g();
            }
            AbstractRunnableC15181i m4163g2 = CoroutineScheduler.this.f43260b.m4163g();
            return m4163g2 != null ? m4163g2 : CoroutineScheduler.this.f43259a.m4163g();
        }

        /* renamed from: n */
        private final void m3761n() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f43268b != WorkerState.TERMINATED) {
                    AbstractRunnableC15181i m3770e = m3770e(this.f43272f);
                    if (m3770e != null) {
                        this.f43270d = 0L;
                        m3772c(m3770e);
                    } else {
                        this.f43272f = false;
                        if (this.f43270d == 0) {
                            m3757r();
                        } else if (z) {
                            m3756s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f43270d);
                            this.f43270d = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            m3756s(WorkerState.TERMINATED);
        }

        /* renamed from: q */
        private final boolean m3758q() {
            boolean z;
            if (this.f43268b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((CoroutineScheduler.f43252s & j) >> 42)) != 0) {
                        if (CoroutineScheduler.f43242i.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f43268b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        /* renamed from: r */
        private final void m3757r() {
            if (!m3765j()) {
                CoroutineScheduler.this.m3804F(this);
                return;
            }
            this.workerCtl = -1;
            while (m3765j() && !CoroutineScheduler.this.isTerminated() && this.f43268b != WorkerState.TERMINATED) {
                m3756s(WorkerState.PARKING);
                Thread.interrupted();
                m3763l();
            }
        }

        /* renamed from: t */
        private final AbstractRunnableC15181i m3755t(boolean z) {
            long m3724l;
            int m3809A = CoroutineScheduler.this.m3809A();
            if (m3809A < 2) {
                return null;
            }
            int m3764k = m3764k(m3809A);
            long j = Long.MAX_VALUE;
            for (int i = 0; i < m3809A; i++) {
                m3764k++;
                if (m3764k > m3809A) {
                    m3764k = 1;
                }
                C15173b c15173b = CoroutineScheduler.this.f43261c.get(m3764k);
                if (c15173b != null && c15173b != this) {
                    if (z) {
                        m3724l = this.f43267a.m3725k(c15173b.f43267a);
                    } else {
                        m3724l = this.f43267a.m3724l(c15173b.f43267a);
                    }
                    if (m3724l == -1) {
                        return this.f43267a.m3728h();
                    }
                    if (m3724l > 0) {
                        j = Math.min(j, m3724l);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.f43270d = j;
            return null;
        }

        /* renamed from: u */
        private final void m3754u() {
            synchronized (CoroutineScheduler.this.f43261c) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.m3809A() <= CoroutineScheduler.this.f43262d) {
                    return;
                }
                if (f43266h.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    m3760o(0);
                    CoroutineScheduler.this.m3803G(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.f43242i.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i) {
                        C15173b c15173b = CoroutineScheduler.this.f43261c.get(andDecrement);
                        C14342f0.m8187m(c15173b);
                        C15173b c15173b2 = c15173b;
                        CoroutineScheduler.this.f43261c.set(i, c15173b2);
                        c15173b2.m3760o(i);
                        CoroutineScheduler.this.m3803G(c15173b2, andDecrement, i);
                    }
                    CoroutineScheduler.this.f43261c.set(andDecrement, null);
                    Unit unit = Unit.f41048a;
                    this.f43268b = WorkerState.TERMINATED;
                }
            }
        }

        @Nullable
        /* renamed from: e */
        public final AbstractRunnableC15181i m3770e(boolean z) {
            AbstractRunnableC15181i m4163g;
            if (m3758q()) {
                return m3771d(z);
            }
            if (z) {
                m4163g = this.f43267a.m3728h();
                if (m4163g == null) {
                    m4163g = CoroutineScheduler.this.f43260b.m4163g();
                }
            } else {
                m4163g = CoroutineScheduler.this.f43260b.m4163g();
            }
            return m4163g != null ? m4163g : m3755t(true);
        }

        /* renamed from: f */
        public final int m3769f() {
            return this.indexInArray;
        }

        @Nullable
        /* renamed from: g */
        public final Object m3768g() {
            return this.nextParkedWorker;
        }

        @NotNull
        /* renamed from: h */
        public final CoroutineScheduler m3767h() {
            return CoroutineScheduler.this;
        }

        /* renamed from: k */
        public final int m3764k(int i) {
            int i2 = this.f43271e;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f43271e = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* renamed from: o */
        public final void m3760o(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f43265g);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* renamed from: p */
        public final void m3759p(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m3761n();
        }

        /* renamed from: s */
        public final boolean m3756s(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f43268b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f43242i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f43268b = workerState;
            }
            return z;
        }

        public C15173b(CoroutineScheduler coroutineScheduler, int i) {
            this();
            m3760o(i);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? C15184l.f43300g : j, (i3 & 8) != 0 ? C15184l.f43295b : str);
    }
}
