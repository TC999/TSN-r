package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ConflatedChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010.\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`-\u00a2\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0014R\u0018\u0010\u001a\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u000f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u000f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010&\u001a\u00020\u000f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0014\u0010'\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0014\u0010+\u001a\u00020(8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/channels/v;", "E", "Lkotlinx/coroutines/channels/a;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "m0", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", "B", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "f0", "g0", "", "wasClosed", "Lkotlin/f1;", "c0", "Lkotlinx/coroutines/channels/c0;", "receive", "W", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "e", "Ljava/lang/Object;", "value", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "isEmpty", "", "k", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class v<E> extends a<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f59501d;

    /* renamed from: e  reason: collision with root package name */
    private Object f59502e;

    public v(@Nullable d2.l<? super E, f1> lVar) {
        super(lVar);
        this.f59501d = new ReentrantLock();
        this.f59502e = b.f59396d;
    }

    private final UndeliveredElementException m0(Object obj) {
        d2.l<E, f1> lVar;
        Object obj2 = this.f59502e;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != b.f59396d && (lVar = this.f59404b) != null) {
            undeliveredElementException = kotlinx.coroutines.internal.b0.d(lVar, obj2, null, 2, null);
        }
        this.f59502e = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object A(E e4) {
        e0<E> M;
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            if (this.f59502e == b.f59396d) {
                do {
                    M = M();
                    if (M != null) {
                        if (M instanceof t) {
                            kotlin.jvm.internal.f0.m(M);
                            return M;
                        }
                        kotlin.jvm.internal.f0.m(M);
                    }
                } while (M.y(e4, null) == null);
                f1 f1Var = f1.f55527a;
                reentrantLock.unlock();
                kotlin.jvm.internal.f0.m(M);
                M.i(e4);
                kotlin.jvm.internal.f0.m(M);
                return M.e();
            }
            UndeliveredElementException m02 = m0(e4);
            if (m02 == null) {
                return b.f59397e;
            }
            throw m02;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object B(E e4, @NotNull kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            if (this.f59502e == b.f59396d) {
                while (true) {
                    c.d<E> i4 = i(e4);
                    Object w3 = fVar.w(i4);
                    if (w3 == null) {
                        e0<? super E> o4 = i4.o();
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
                        return w3;
                    }
                }
            }
            if (!fVar.p()) {
                return kotlinx.coroutines.selects.g.d();
            }
            UndeliveredElementException m02 = m0(e4);
            if (m02 == null) {
                return b.f59397e;
            }
            throw m02;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public boolean W(@NotNull c0<? super E> c0Var) {
        ReentrantLock reentrantLock = this.f59501d;
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
        return this.f59502e == b.f59396d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public void c0(boolean z3) {
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            UndeliveredElementException m02 = m0(b.f59396d);
            f1 f1Var = f1.f55527a;
            reentrantLock.unlock();
            super.c0(z3);
            if (m02 != null) {
                throw m02;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @Nullable
    protected Object f0() {
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            Object obj = this.f59502e;
            kotlinx.coroutines.internal.j0 j0Var = b.f59396d;
            if (obj != j0Var) {
                this.f59502e = j0Var;
                f1 f1Var = f1.f55527a;
                return obj;
            }
            Object m4 = m();
            if (m4 == null) {
                m4 = b.f59399g;
            }
            return m4;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @Nullable
    protected Object g0(@NotNull kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            Object obj = this.f59502e;
            kotlinx.coroutines.internal.j0 j0Var = b.f59396d;
            if (obj == j0Var) {
                Object m4 = m();
                if (m4 == null) {
                    m4 = b.f59399g;
                }
                return m4;
            } else if (!fVar.p()) {
                return kotlinx.coroutines.selects.g.d();
            } else {
                Object obj2 = this.f59502e;
                this.f59502e = j0Var;
                f1 f1Var = f1.f55527a;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.d0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f59501d;
        reentrantLock.lock();
        try {
            return b0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @NotNull
    protected String k() {
        return "(value=" + this.f59502e + ')';
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean x() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean y() {
        return false;
    }
}
