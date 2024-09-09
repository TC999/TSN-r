package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f1;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u000203\u0012 \u0010J\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Hj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`I\u00a2\u0006\u0004\bK\u0010LJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0014\u00a2\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001fH\u0014\u00a2\u0006\u0004\b#\u0010$R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u001f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u001f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010=\u001a\u00020\u001f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u00108R\u0014\u0010?\u001a\u00020\u001f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u00108R\u0014\u0010A\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u00108R\u0014\u0010B\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u00108R\u0014\u0010C\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00108R\u0014\u0010G\u001a\u00020D8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\u00a8\u0006M"}, d2 = {"Lkotlinx/coroutines/channels/i;", "E", "Lkotlinx/coroutines/channels/a;", "", "currentSize", "Lkotlinx/coroutines/internal/j0;", "o0", "(I)Lkotlinx/coroutines/internal/j0;", "element", "Lkotlin/f1;", "m0", "(ILjava/lang/Object;)V", "n0", "(I)V", "", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", "B", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/g0;", "send", "j", "(Lkotlinx/coroutines/channels/g0;)Ljava/lang/Object;", "f0", "()Ljava/lang/Object;", "g0", "(Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/c0;", "receive", "", "W", "(Lkotlinx/coroutines/channels/c0;)Z", "wasClosed", "c0", "(Z)V", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "e", "[Ljava/lang/Object;", "buffer", "f", "I", "head", "g", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "h", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "p", "isFull", "isEmpty", "isClosedForReceive", "", "k", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i<E> extends a<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f59421d;

    /* renamed from: e  reason: collision with root package name */
    private Object[] f59422e;

    /* renamed from: f  reason: collision with root package name */
    private int f59423f;

    /* renamed from: g  reason: collision with root package name */
    private final int f59424g;

    /* renamed from: h  reason: collision with root package name */
    private final BufferOverflow f59425h;
    private volatile int size;

    public i(int i4, @NotNull BufferOverflow bufferOverflow, @Nullable d2.l<? super E, f1> lVar) {
        super(lVar);
        this.f59424g = i4;
        this.f59425h = bufferOverflow;
        if (i4 >= 1) {
            this.f59421d = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i4, 8)];
            kotlin.collections.o.w2(objArr, b.f59396d, 0, 0, 6, null);
            f1 f1Var = f1.f55527a;
            this.f59422e = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i4 + " was specified").toString());
    }

    private final void m0(int i4, E e4) {
        if (i4 < this.f59424g) {
            n0(i4);
            Object[] objArr = this.f59422e;
            objArr[(this.f59423f + i4) % objArr.length] = e4;
            return;
        }
        Object[] objArr2 = this.f59422e;
        int i5 = this.f59423f;
        objArr2[i5 % objArr2.length] = null;
        objArr2[(i4 + i5) % objArr2.length] = e4;
        this.f59423f = (i5 + 1) % objArr2.length;
    }

    private final void n0(int i4) {
        Object[] objArr = this.f59422e;
        if (i4 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f59424g);
            Object[] objArr2 = new Object[min];
            for (int i5 = 0; i5 < i4; i5++) {
                Object[] objArr3 = this.f59422e;
                objArr2[i5] = objArr3[(this.f59423f + i5) % objArr3.length];
            }
            kotlin.collections.o.n2(objArr2, b.f59396d, i4, min);
            this.f59422e = objArr2;
            this.f59423f = 0;
        }
    }

    private final kotlinx.coroutines.internal.j0 o0(int i4) {
        if (i4 < this.f59424g) {
            this.size = i4 + 1;
            return null;
        }
        int i5 = h.f59420a[this.f59425h.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return b.f59397e;
        }
        return b.f59398f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object A(E e4) {
        e0<E> M;
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            int i4 = this.size;
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            kotlinx.coroutines.internal.j0 o02 = o0(i4);
            if (o02 != null) {
                return o02;
            }
            if (i4 == 0) {
                do {
                    M = M();
                    if (M != null) {
                        if (M instanceof t) {
                            this.size = i4;
                            kotlin.jvm.internal.f0.m(M);
                            return M;
                        }
                        kotlin.jvm.internal.f0.m(M);
                    }
                } while (M.y(e4, null) == null);
                this.size = i4;
                f1 f1Var = f1.f55527a;
                reentrantLock.unlock();
                kotlin.jvm.internal.f0.m(M);
                M.i(e4);
                kotlin.jvm.internal.f0.m(M);
                return M.e();
            }
            m0(i4, e4);
            return b.f59397e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object B(E e4, @NotNull kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            int i4 = this.size;
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            kotlinx.coroutines.internal.j0 o02 = o0(i4);
            if (o02 != null) {
                return o02;
            }
            if (i4 == 0) {
                while (true) {
                    c.d<E> i5 = i(e4);
                    Object w3 = fVar.w(i5);
                    if (w3 == null) {
                        this.size = i4;
                        e0<? super E> o4 = i5.o();
                        f1 f1Var = f1.f55527a;
                        reentrantLock.unlock();
                        kotlin.jvm.internal.f0.m(o4);
                        o4.i(e4);
                        kotlin.jvm.internal.f0.m(o4);
                        return o4.e();
                    } else if (w3 == b.f59398f) {
                        break;
                    } else if (w3 != kotlinx.coroutines.internal.c.f60351b) {
                        if (w3 != kotlinx.coroutines.selects.g.d() && !(w3 instanceof t)) {
                            throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + w3).toString());
                        }
                        this.size = i4;
                        return w3;
                    }
                }
            }
            if (!fVar.p()) {
                this.size = i4;
                return kotlinx.coroutines.selects.g.d();
            }
            m0(i4, e4);
            return b.f59397e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public boolean W(@NotNull c0<? super E> c0Var) {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            return super.W(c0Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean Z() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean a0() {
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public void c0(boolean z3) {
        d2.l<E, f1> lVar = this.f59404b;
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            int i4 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i5 = 0; i5 < i4; i5++) {
                Object obj = this.f59422e[this.f59423f];
                if (lVar != null && obj != b.f59396d) {
                    undeliveredElementException = kotlinx.coroutines.internal.b0.c(lVar, obj, undeliveredElementException);
                }
                Object[] objArr = this.f59422e;
                int i6 = this.f59423f;
                objArr[i6] = b.f59396d;
                this.f59423f = (i6 + 1) % objArr.length;
            }
            this.size = 0;
            f1 f1Var = f1.f55527a;
            reentrantLock.unlock();
            super.c0(z3);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @Nullable
    protected Object f0() {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            int i4 = this.size;
            if (i4 == 0) {
                Object m4 = m();
                if (m4 == null) {
                    m4 = b.f59399g;
                }
                return m4;
            }
            Object[] objArr = this.f59422e;
            int i5 = this.f59423f;
            Object obj = objArr[i5];
            g0 g0Var = null;
            objArr[i5] = null;
            this.size = i4 - 1;
            Object obj2 = b.f59399g;
            boolean z3 = false;
            if (i4 == this.f59424g) {
                g0 g0Var2 = null;
                while (true) {
                    g0 N = N();
                    if (N == null) {
                        g0Var = g0Var2;
                        break;
                    }
                    kotlin.jvm.internal.f0.m(N);
                    if (N.k0(null) != null) {
                        kotlin.jvm.internal.f0.m(N);
                        obj2 = N.i0();
                        g0Var = N;
                        z3 = true;
                        break;
                    }
                    kotlin.jvm.internal.f0.m(N);
                    N.l0();
                    g0Var2 = N;
                }
            }
            if (obj2 != b.f59399g && !(obj2 instanceof t)) {
                this.size = i4;
                Object[] objArr2 = this.f59422e;
                objArr2[(this.f59423f + i4) % objArr2.length] = obj2;
            }
            this.f59423f = (this.f59423f + 1) % this.f59422e.length;
            f1 f1Var = f1.f55527a;
            if (z3) {
                kotlin.jvm.internal.f0.m(g0Var);
                g0Var.h0();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.d0
    public boolean g() {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            return super.g();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009f A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0010, B:11:0x0016, B:13:0x002a, B:15:0x0034, B:34:0x0085, B:36:0x0089, B:38:0x008d, B:44:0x00af, B:39:0x0099, B:41:0x009f, B:17:0x0044, B:20:0x0049, B:23:0x004e, B:25:0x0054, B:28:0x0060, B:30:0x0064, B:31:0x0069, B:32:0x0083), top: B:53:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    @Override // kotlinx.coroutines.channels.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object g0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.f<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f59421d
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc6
            if (r1 != 0) goto L16
            kotlinx.coroutines.channels.t r9 = r8.m()     // Catch: java.lang.Throwable -> Lc6
            if (r9 == 0) goto L10
            goto L12
        L10:
            kotlinx.coroutines.internal.j0 r9 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> Lc6
        L12:
            r0.unlock()
            return r9
        L16:
            java.lang.Object[] r2 = r8.f59422e     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.f59423f     // Catch: java.lang.Throwable -> Lc6
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc6
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc6
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc6
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.f59424g     // Catch: java.lang.Throwable -> Lc6
            r6 = 1
            if (r1 != r3) goto L84
        L2a:
            kotlinx.coroutines.channels.a$g r3 = r8.U()     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r7 = r9.w(r3)     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L44
            java.lang.Object r2 = r3.o()     // Catch: java.lang.Throwable -> Lc6
            r5 = r2
            kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5     // Catch: java.lang.Throwable -> Lc6
            kotlin.jvm.internal.f0.m(r5)     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r2 = r5.i0()     // Catch: java.lang.Throwable -> Lc6
        L42:
            r3 = 1
            goto L85
        L44:
            kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L49
            goto L84
        L49:
            java.lang.Object r3 = kotlinx.coroutines.internal.c.f60351b     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L4e
            goto L2a
        L4e:
            java.lang.Object r2 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r2) goto L60
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f59422e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f59423f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r7
        L60:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.t     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L69
            r5 = r7
            kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5     // Catch: java.lang.Throwable -> Lc6
            r2 = r7
            goto L42
        L69:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r9.<init>()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc6
            r9.append(r7)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lc6
            throw r1     // Catch: java.lang.Throwable -> Lc6
        L84:
            r3 = 0
        L85:
            kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> Lc6
            if (r2 == r7) goto L99
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.t     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L99
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f59422e     // Catch: java.lang.Throwable -> Lc6
            int r7 = r8.f59423f     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc6
            goto Laf
        L99:
            boolean r9 = r9.p()     // Catch: java.lang.Throwable -> Lc6
            if (r9 != 0) goto Laf
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f59422e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f59423f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r9 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r9
        Laf:
            int r9 = r8.f59423f     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f59422e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 % r1
            r8.f59423f = r9     // Catch: java.lang.Throwable -> Lc6
            kotlin.f1 r9 = kotlin.f1.f55527a     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            if (r3 == 0) goto Lc5
            kotlin.jvm.internal.f0.m(r5)
            r5.h0()
        Lc5:
            return r4
        Lc6:
            r9 = move-exception
            r0.unlock()
            goto Lcc
        Lcb:
            throw r9
        Lcc:
            goto Lcb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.i.g0(kotlinx.coroutines.selects.f):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.d0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            return b0();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @Nullable
    public Object j(@NotNull g0 g0Var) {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            return super.j(g0Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @NotNull
    protected String k() {
        return "(buffer:capacity=" + this.f59424g + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.c, kotlinx.coroutines.channels.h0
    public boolean p() {
        ReentrantLock reentrantLock = this.f59421d;
        reentrantLock.lock();
        try {
            return z();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean x() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean y() {
        return this.size == this.f59424g && this.f59425h == BufferOverflow.SUSPEND;
    }
}
