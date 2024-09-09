package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004789\u001cB\u0007\u00a2\u0006\u0004\b6\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0014\u00a2\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004\u00a2\u0006\u0004\b,\u0010\rR$\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010/R\u0014\u00105\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010#\u00a8\u0006:"}, d2 = {"Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/o1;", "Lkotlinx/coroutines/z0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "V", "(Ljava/lang/Runnable;)Z", "T", "()Ljava/lang/Runnable;", "Lkotlin/f1;", "S", "()V", "Lkotlinx/coroutines/n1$c;", "c0", "(Lkotlinx/coroutines/n1$c;)Z", "", "now", "delayedTask", "", "Z", "(JLkotlinx/coroutines/n1$c;)I", "W", "shutdown", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "(JLkotlinx/coroutines/o;)V", "block", "Lkotlinx/coroutines/i1;", "a0", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/i1;", "H", "()J", "Lkotlin/coroutines/f;", "context", "dispatch", "(Lkotlin/coroutines/f;Ljava/lang/Runnable;)V", "U", "(Ljava/lang/Runnable;)V", "Y", "(JLkotlinx/coroutines/n1$c;)V", "X", "value", "isCompleted", "()Z", "b0", "(Z)V", "E", "isEmpty", "B", "nextTime", "<init>", "a", "b", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class n1 extends o1 implements z0 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60508d = AtomicReferenceFieldUpdater.newUpdater(n1.class, Object.class, "_queue");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60509e = AtomicReferenceFieldUpdater.newUpdater(n1.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/n1$a;", "Lkotlinx/coroutines/n1$c;", "Lkotlin/f1;", "run", "", "toString", "Lkotlinx/coroutines/o;", "d", "Lkotlinx/coroutines/o;", "cont", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/n1;JLkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends c {

        /* renamed from: d  reason: collision with root package name */
        private final o<kotlin.f1> f60510d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j4, @NotNull o<? super kotlin.f1> oVar) {
            super(j4);
            this.f60510d = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f60510d.G(n1.this, kotlin.f1.f55527a);
        }

        @Override // kotlinx.coroutines.n1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f60510d.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/n1$b;", "Lkotlinx/coroutines/n1$c;", "Lkotlin/f1;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "d", "Ljava/lang/Runnable;", "block", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class b extends c {

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f60512d;

        public b(long j4, @NotNull Runnable runnable) {
            super(j4);
            this.f60512d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f60512d.run();
        }

        @Override // kotlinx.coroutines.n1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f60512d.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010#\u001a\u00020\t\u00a2\u0006\u0004\b)\u0010*J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R0\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010&\"\u0004\b\u0017\u0010'\u00a8\u0006+"}, d2 = {"Lkotlinx/coroutines/n1$c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/internal/t0;", "other", "", "e", "", "now", "", "i", "Lkotlinx/coroutines/n1$d;", "delayed", "Lkotlinx/coroutines/n1;", "eventLoop", "h", "Lkotlin/f1;", "dispose", "", "toString", "", "a", "Ljava/lang/Object;", "_heap", "b", "I", "f", "()I", "d", "(I)V", "index", "c", "J", "nanoTime", "Lkotlinx/coroutines/internal/s0;", "value", "()Lkotlinx/coroutines/internal/s0;", "(Lkotlinx/coroutines/internal/s0;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c implements Runnable, Comparable<c>, i1, kotlinx.coroutines.internal.t0 {

        /* renamed from: a  reason: collision with root package name */
        private Object f60513a;

        /* renamed from: b  reason: collision with root package name */
        private int f60514b = -1;
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public long f60515c;

        public c(long j4) {
            this.f60515c = j4;
        }

        @Override // kotlinx.coroutines.internal.t0
        public void a(@Nullable kotlinx.coroutines.internal.s0<?> s0Var) {
            kotlinx.coroutines.internal.j0 j0Var;
            Object obj = this.f60513a;
            j0Var = q1.f60536a;
            if (obj != j0Var) {
                this.f60513a = s0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.t0
        @Nullable
        public kotlinx.coroutines.internal.s0<?> b() {
            Object obj = this.f60513a;
            if (!(obj instanceof kotlinx.coroutines.internal.s0)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.s0) obj;
        }

        @Override // kotlinx.coroutines.internal.t0
        public void d(int i4) {
            this.f60514b = i4;
        }

        @Override // kotlinx.coroutines.i1
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.j0 j0Var;
            kotlinx.coroutines.internal.j0 j0Var2;
            Object obj = this.f60513a;
            j0Var = q1.f60536a;
            if (obj == j0Var) {
                return;
            }
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                dVar.j(this);
            }
            j0Var2 = q1.f60536a;
            this.f60513a = j0Var2;
        }

        @Override // java.lang.Comparable
        /* renamed from: e */
        public int compareTo(@NotNull c cVar) {
            long j4 = this.f60515c - cVar.f60515c;
            if (j4 > 0) {
                return 1;
            }
            return j4 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.internal.t0
        public int f() {
            return this.f60514b;
        }

        public final synchronized int h(long j4, @NotNull d dVar, @NotNull n1 n1Var) {
            kotlinx.coroutines.internal.j0 j0Var;
            Object obj = this.f60513a;
            j0Var = q1.f60536a;
            if (obj == j0Var) {
                return 2;
            }
            synchronized (dVar) {
                c e4 = dVar.e();
                if (n1Var.isCompleted()) {
                    return 1;
                }
                if (e4 == null) {
                    dVar.f60516b = j4;
                } else {
                    long j5 = e4.f60515c;
                    if (j5 - j4 < 0) {
                        j4 = j5;
                    }
                    if (j4 - dVar.f60516b > 0) {
                        dVar.f60516b = j4;
                    }
                }
                long j6 = this.f60515c;
                long j7 = dVar.f60516b;
                if (j6 - j7 < 0) {
                    this.f60515c = j7;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final boolean i(long j4) {
            return j4 - this.f60515c >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f60515c + ']';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: EventLoop.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lkotlinx/coroutines/n1$d;", "Lkotlinx/coroutines/internal/s0;", "Lkotlinx/coroutines/n1$c;", "", "b", "J", "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends kotlinx.coroutines.internal.s0<c> {
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public long f60516b;

        public d(long j4) {
            this.f60516b = j4;
        }
    }

    private final void S() {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60508d;
                j0Var = q1.f60543h;
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, null, j0Var)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.v) {
                ((kotlinx.coroutines.internal.v) obj).d();
                return;
            } else {
                j0Var2 = q1.f60543h;
                if (obj == j0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.v vVar = new kotlinx.coroutines.internal.v(8, true);
                vVar.a((Runnable) obj);
                if (io.netty.channel.a.a(f60508d, this, obj, vVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable T() {
        kotlinx.coroutines.internal.j0 j0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.v) {
                kotlinx.coroutines.internal.v vVar = (kotlinx.coroutines.internal.v) obj;
                Object l4 = vVar.l();
                if (l4 != kotlinx.coroutines.internal.v.f60436s) {
                    return (Runnable) l4;
                }
                io.netty.channel.a.a(f60508d, this, obj, vVar.k());
            } else {
                j0Var = q1.f60543h;
                if (obj == j0Var) {
                    return null;
                }
                if (io.netty.channel.a.a(f60508d, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean V(Runnable runnable) {
        kotlinx.coroutines.internal.j0 j0Var;
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (io.netty.channel.a.a(f60508d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.v) {
                kotlinx.coroutines.internal.v vVar = (kotlinx.coroutines.internal.v) obj;
                int a4 = vVar.a(runnable);
                if (a4 == 0) {
                    return true;
                }
                if (a4 == 1) {
                    io.netty.channel.a.a(f60508d, this, obj, vVar.k());
                } else if (a4 == 2) {
                    return false;
                }
            } else {
                j0Var = q1.f60543h;
                if (obj == j0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.v vVar2 = new kotlinx.coroutines.internal.v(8, true);
                vVar2.a((Runnable) obj);
                vVar2.a(runnable);
                if (io.netty.channel.a.a(f60508d, this, obj, vVar2)) {
                    return true;
                }
            }
        }
    }

    private final void W() {
        c m4;
        o3 b4 = p3.b();
        long nanoTime = b4 != null ? b4.nanoTime() : System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null || (m4 = dVar.m()) == null) {
                return;
            }
            L(nanoTime, m4);
        }
    }

    private final int Z(long j4, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            io.netty.channel.a.a(f60509e, this, null, new d(j4));
            Object obj = this._delayed;
            kotlin.jvm.internal.f0.m(obj);
            dVar = (d) obj;
        }
        return cVar.h(j4, dVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(boolean z3) {
        this._isCompleted = z3 ? 1 : 0;
    }

    private final boolean c0(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? dVar.h() : null) == cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.m1
    public long B() {
        c h4;
        long o4;
        kotlinx.coroutines.internal.j0 j0Var;
        if (super.B() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.v)) {
                j0Var = q1.f60543h;
                return obj == j0Var ? Long.MAX_VALUE : 0L;
            } else if (!((kotlinx.coroutines.internal.v) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (h4 = dVar.h()) == null) {
            return Long.MAX_VALUE;
        }
        long j4 = h4.f60515c;
        o3 b4 = p3.b();
        o4 = kotlin.ranges.q.o(j4 - (b4 != null ? b4.nanoTime() : System.nanoTime()), 0L);
        return o4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.m1
    public boolean E() {
        kotlinx.coroutines.internal.j0 j0Var;
        if (G()) {
            d dVar = (d) this._delayed;
            if (dVar == null || dVar.g()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof kotlinx.coroutines.internal.v) {
                        return ((kotlinx.coroutines.internal.v) obj).h();
                    }
                    j0Var = q1.f60543h;
                    if (obj != j0Var) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    @Override // kotlinx.coroutines.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long H() {
        /*
            r9 = this;
            boolean r0 = r9.I()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.n1$d r0 = (kotlinx.coroutines.n1.d) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.g()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.o3 r3 = kotlinx.coroutines.p3.b()
            if (r3 == 0) goto L20
            long r3 = r3.nanoTime()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.t0 r5 = r0.e()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 == 0) goto L44
            kotlinx.coroutines.n1$c r5 = (kotlinx.coroutines.n1.c) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.i(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.V(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L3a:
            r5 = 0
        L3b:
            if (r5 == 0) goto L42
            kotlinx.coroutines.internal.t0 r5 = r0.k(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L42:
            monitor-exit(r0)
            goto L45
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.n1$c r6 = (kotlinx.coroutines.n1.c) r6
            if (r6 == 0) goto L4d
            goto L24
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.T()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.B()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n1.H():long");
    }

    public final void U(@NotNull Runnable runnable) {
        if (V(runnable)) {
            N();
        } else {
            v0.f60753m.U(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X() {
        this._queue = null;
        this._delayed = null;
    }

    public final void Y(long j4, @NotNull c cVar) {
        int Z = Z(j4, cVar);
        if (Z == 0) {
            if (c0(cVar)) {
                N();
            }
        } else if (Z == 1) {
            L(j4, cVar);
        } else if (Z != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final i1 a0(long j4, @NotNull Runnable runnable) {
        long d4 = q1.d(j4);
        if (d4 < 4611686018427387903L) {
            o3 b4 = p3.b();
            long nanoTime = b4 != null ? b4.nanoTime() : System.nanoTime();
            b bVar = new b(d4 + nanoTime, runnable);
            Y(nanoTime, bVar);
            return bVar;
        }
        return s2.f60556a;
    }

    @Override // kotlinx.coroutines.z0
    public void d(long j4, @NotNull o<? super kotlin.f1> oVar) {
        long d4 = q1.d(j4);
        if (d4 < 4611686018427387903L) {
            o3 b4 = p3.b();
            long nanoTime = b4 != null ? b4.nanoTime() : System.nanoTime();
            a aVar = new a(d4 + nanoTime, oVar);
            r.a(oVar, aVar);
            Y(nanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.l0
    public final void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        U(runnable);
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar) {
        return z0.a.b(this, j4, runnable, fVar);
    }

    @Override // kotlinx.coroutines.z0
    @Nullable
    public Object o(long j4, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        return z0.a.a(this, j4, cVar);
    }

    @Override // kotlinx.coroutines.m1
    protected void shutdown() {
        k3.f60465b.c();
        b0(true);
        S();
        do {
        } while (H() <= 0);
        W();
    }
}
