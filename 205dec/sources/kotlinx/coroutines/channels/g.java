package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ArrayBroadcastChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001bB\u000f\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\bQ\u0010FJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0082\u0010\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017\u00a2\u0006\u0004\b\u001b\u0010\bJ\u001f\u0010\u001e\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\"\u0010#J#\u0010&\u001a\u00020!2\u0006\u0010 \u001a\u00028\u00002\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0014\u00a2\u0006\u0004\b&\u0010'R\u0018\u0010,\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R0\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f01j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010@\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00118B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010?R$\u0010C\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00118B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010?R$\u0010G\u001a\u0002062\u0006\u0010<\u001a\u0002068B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bD\u0010:\"\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010IR\u0014\u0010P\u001a\u00020M8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006R"}, d2 = {"Lkotlinx/coroutines/channels/g;", "E", "Lkotlinx/coroutines/channels/c;", "Lkotlinx/coroutines/channels/j;", "", "cause", "", "T", "(Ljava/lang/Throwable;)Z", "Lkotlin/f1;", "U", "()V", "Lkotlinx/coroutines/channels/g$a;", "addSub", "removeSub", "e0", "(Lkotlinx/coroutines/channels/g$a;Lkotlinx/coroutines/channels/g$a;)V", "", "V", "()J", "index", "W", "(J)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/d0;", "t", "()Lkotlinx/coroutines/channels/d0;", "K", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", "B", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "", "e", "[Ljava/lang/Object;", "buffer", "", "Lkotlinx/coroutines/internal/SubscribersList;", "f", "Ljava/util/List;", "subscribers", "", "g", "I", "X", "()I", "capacity", "value", "Y", "b0", "(J)V", "head", "a0", "d0", "tail", "Z", "c0", "(I)V", "size", "x", "()Z", "isBufferAlwaysFull", "y", "isBufferFull", "", "k", "()Ljava/lang/String;", "bufferDebugString", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g<E> extends c<E> implements j<E> {
    private volatile long _head;
    private volatile int _size;
    private volatile long _tail;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f59414d;

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f59415e;

    /* renamed from: f  reason: collision with root package name */
    private final List<a<E>> f59416f;

    /* renamed from: g  reason: collision with root package name */
    private final int f59417g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ArrayBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014\u00a2\u0006\u0004\b\u000f\u0010\tJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0006R\u0014\u0010'\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0014\u0010)\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0006R\u0014\u0010+\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0006\u00a8\u0006."}, d2 = {"Lkotlinx/coroutines/channels/g$a;", "E", "Lkotlinx/coroutines/channels/a;", "Lkotlinx/coroutines/channels/d0;", "", "o0", "()Z", "", "p0", "()Ljava/lang/Object;", "", "cause", "K", "(Ljava/lang/Throwable;)Z", "m0", "f0", "Lkotlinx/coroutines/selects/f;", "select", "g0", "(Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "subLock", "Lkotlinx/coroutines/channels/g;", "e", "Lkotlinx/coroutines/channels/g;", "broadcastChannel", "", "value", "n0", "()J", "q0", "(J)V", "subHead", "Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "<init>", "(Lkotlinx/coroutines/channels/g;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<E> extends kotlinx.coroutines.channels.a<E> implements d0<E> {
        private volatile long _subHead;

        /* renamed from: d  reason: collision with root package name */
        private final ReentrantLock f59418d;

        /* renamed from: e  reason: collision with root package name */
        private final g<E> f59419e;

        public a(@NotNull g<E> gVar) {
            super(null);
            this.f59419e = gVar;
            this.f59418d = new ReentrantLock();
            this._subHead = 0L;
        }

        private final boolean o0() {
            if (l() != null) {
                return false;
            }
            return (a0() && this.f59419e.l() == null) ? false : true;
        }

        private final Object p0() {
            long n02 = n0();
            t<?> l4 = this.f59419e.l();
            if (n02 >= this.f59419e.a0()) {
                if (l4 == null) {
                    l4 = l();
                }
                return l4 != null ? l4 : b.f59399g;
            }
            Object W = this.f59419e.W(n02);
            t<?> l5 = l();
            return l5 != null ? l5 : W;
        }

        @Override // kotlinx.coroutines.channels.c, kotlinx.coroutines.channels.h0
        public boolean K(@Nullable Throwable th) {
            boolean K = super.K(th);
            if (K) {
                g.f0(this.f59419e, null, this, 1, null);
                ReentrantLock reentrantLock = this.f59418d;
                reentrantLock.lock();
                try {
                    q0(this.f59419e.a0());
                    f1 f1Var = f1.f55527a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return K;
        }

        @Override // kotlinx.coroutines.channels.a
        protected boolean Z() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.a
        protected boolean a0() {
            return n0() >= this.f59419e.a0();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
        @Override // kotlinx.coroutines.channels.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.lang.Object f0() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.f59418d
                r0.lock()
                java.lang.Object r1 = r8.p0()     // Catch: java.lang.Throwable -> L45
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.t     // Catch: java.lang.Throwable -> L45
                r3 = 1
                if (r2 == 0) goto Lf
                goto L13
            Lf:
                kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> L45
                if (r1 != r2) goto L15
            L13:
                r2 = 0
                goto L20
            L15:
                long r4 = r8.n0()     // Catch: java.lang.Throwable -> L45
                r6 = 1
                long r4 = r4 + r6
                r8.q0(r4)     // Catch: java.lang.Throwable -> L45
                r2 = 1
            L20:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.t
                r4 = 0
                if (r0 != 0) goto L2a
                r0 = r4
                goto L2b
            L2a:
                r0 = r1
            L2b:
                kotlinx.coroutines.channels.t r0 = (kotlinx.coroutines.channels.t) r0
                if (r0 == 0) goto L34
                java.lang.Throwable r0 = r0.f59488d
                r8.K(r0)
            L34:
                boolean r0 = r8.m0()
                if (r0 == 0) goto L3b
                goto L3c
            L3b:
                r3 = r2
            L3c:
                if (r3 == 0) goto L44
                kotlinx.coroutines.channels.g<E> r0 = r8.f59419e
                r2 = 3
                kotlinx.coroutines.channels.g.f0(r0, r4, r4, r2, r4)
            L44:
                return r1
            L45:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.g.a.f0():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.a
        @Nullable
        protected Object g0(@NotNull kotlinx.coroutines.selects.f<?> fVar) {
            ReentrantLock reentrantLock = this.f59418d;
            reentrantLock.lock();
            try {
                Object p02 = p0();
                boolean z3 = false;
                if (!(p02 instanceof t) && p02 != b.f59399g) {
                    if (!fVar.p()) {
                        p02 = kotlinx.coroutines.selects.g.d();
                    } else {
                        q0(n0() + 1);
                        z3 = true;
                    }
                }
                reentrantLock.unlock();
                t tVar = (t) (!(p02 instanceof t) ? null : p02);
                if (tVar != null) {
                    K(tVar.f59488d);
                }
                if (m0() ? true : z3) {
                    g.f0(this.f59419e, null, null, 3, null);
                }
                return p02;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
            r2 = (kotlinx.coroutines.channels.t) r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m0() {
            /*
                r8 = this;
                r0 = 0
            L1:
                boolean r1 = r8.o0()
                r2 = 0
                if (r1 == 0) goto L5b
                java.util.concurrent.locks.ReentrantLock r1 = r8.f59418d
                boolean r1 = r1.tryLock()
                if (r1 != 0) goto L11
                goto L5b
            L11:
                java.lang.Object r1 = r8.p0()     // Catch: java.lang.Throwable -> L54
                kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.channels.b.f59399g     // Catch: java.lang.Throwable -> L54
                if (r1 != r3) goto L1f
            L19:
                java.util.concurrent.locks.ReentrantLock r1 = r8.f59418d
                r1.unlock()
                goto L1
            L1f:
                boolean r3 = r1 instanceof kotlinx.coroutines.channels.t     // Catch: java.lang.Throwable -> L54
                if (r3 == 0) goto L2c
                r2 = r1
                kotlinx.coroutines.channels.t r2 = (kotlinx.coroutines.channels.t) r2     // Catch: java.lang.Throwable -> L54
            L26:
                java.util.concurrent.locks.ReentrantLock r1 = r8.f59418d
                r1.unlock()
                goto L5b
            L2c:
                kotlinx.coroutines.channels.e0 r3 = r8.M()     // Catch: java.lang.Throwable -> L54
                if (r3 == 0) goto L26
                boolean r4 = r3 instanceof kotlinx.coroutines.channels.t     // Catch: java.lang.Throwable -> L54
                if (r4 == 0) goto L37
                goto L26
            L37:
                kotlinx.coroutines.internal.j0 r2 = r3.y(r1, r2)     // Catch: java.lang.Throwable -> L54
                if (r2 == 0) goto L19
                long r4 = r8.n0()     // Catch: java.lang.Throwable -> L54
                r6 = 1
                long r4 = r4 + r6
                r8.q0(r4)     // Catch: java.lang.Throwable -> L54
                r0 = 1
                java.util.concurrent.locks.ReentrantLock r2 = r8.f59418d
                r2.unlock()
                kotlin.jvm.internal.f0.m(r3)
                r3.i(r1)
                goto L1
            L54:
                r0 = move-exception
                java.util.concurrent.locks.ReentrantLock r1 = r8.f59418d
                r1.unlock()
                throw r0
            L5b:
                if (r2 == 0) goto L62
                java.lang.Throwable r1 = r2.f59488d
                r8.K(r1)
            L62:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.g.a.m0():boolean");
        }

        public final long n0() {
            return this._subHead;
        }

        public final void q0(long j4) {
            this._subHead = j4;
        }

        @Override // kotlinx.coroutines.channels.c
        protected boolean x() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.c
        protected boolean y() {
            throw new IllegalStateException("Should not be used".toString());
        }
    }

    public g(int i4) {
        super(null);
        this.f59417g = i4;
        if (i4 >= 1) {
            this.f59414d = new ReentrantLock();
            this.f59415e = new Object[i4];
            this._head = 0L;
            this._tail = 0L;
            this._size = 0;
            this.f59416f = kotlinx.coroutines.internal.e.d();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i4 + " was specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.j
    /* renamed from: T */
    public final boolean a(Throwable th) {
        boolean K = K(th);
        for (a<E> aVar : this.f59416f) {
            aVar.a(th);
        }
        return K;
    }

    private final void U() {
        boolean z3 = false;
        boolean z4 = false;
        for (a<E> aVar : this.f59416f) {
            if (aVar.m0()) {
                z3 = true;
            }
            z4 = true;
        }
        if (z3 || !z4) {
            f0(this, null, null, 3, null);
        }
    }

    private final long V() {
        long j4 = Long.MAX_VALUE;
        for (a<E> aVar : this.f59416f) {
            j4 = kotlin.ranges.q.v(j4, aVar.n0());
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E W(long j4) {
        return (E) this.f59415e[(int) (j4 % this.f59417g)];
    }

    private final long Y() {
        return this._head;
    }

    private final int Z() {
        return this._size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a0() {
        return this._tail;
    }

    private final void b0(long j4) {
        this._head = j4;
    }

    private final void c0(int i4) {
        this._size = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(long j4) {
        this._tail = j4;
    }

    private final void e0(a<E> aVar, a<E> aVar2) {
        long v3;
        g0 N;
        while (true) {
            ReentrantLock reentrantLock = this.f59414d;
            reentrantLock.lock();
            if (aVar != null) {
                try {
                    aVar.q0(a0());
                    boolean isEmpty = this.f59416f.isEmpty();
                    this.f59416f.add(aVar);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (aVar2 != null) {
                this.f59416f.remove(aVar2);
                if (Y() != aVar2.n0()) {
                    return;
                }
            }
            long V = V();
            long a02 = a0();
            long Y = Y();
            v3 = kotlin.ranges.q.v(V, a02);
            if (v3 <= Y) {
                return;
            }
            int Z = Z();
            while (Y < v3) {
                Object[] objArr = this.f59415e;
                int i4 = this.f59417g;
                objArr[(int) (Y % i4)] = null;
                boolean z3 = Z >= i4;
                Y++;
                b0(Y);
                Z--;
                c0(Z);
                if (z3) {
                    do {
                        N = N();
                        if (N != null && !(N instanceof t)) {
                            kotlin.jvm.internal.f0.m(N);
                        }
                    } while (N.k0(null) == null);
                    this.f59415e[(int) (a02 % this.f59417g)] = N.i0();
                    c0(Z + 1);
                    d0(a02 + 1);
                    f1 f1Var = f1.f55527a;
                    reentrantLock.unlock();
                    kotlin.jvm.internal.f0.m(N);
                    N.h0();
                    U();
                    aVar = null;
                    aVar2 = null;
                }
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void f0(g gVar, a aVar, a aVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = null;
        }
        if ((i4 & 2) != 0) {
            aVar2 = null;
        }
        gVar.e0(aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object A(E e4) {
        ReentrantLock reentrantLock = this.f59414d;
        reentrantLock.lock();
        try {
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            int Z = Z();
            if (Z >= this.f59417g) {
                return b.f59398f;
            }
            long a02 = a0();
            this.f59415e[(int) (a02 % this.f59417g)] = e4;
            c0(Z + 1);
            d0(a02 + 1);
            f1 f1Var = f1.f55527a;
            reentrantLock.unlock();
            U();
            return b.f59397e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object B(E e4, @NotNull kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f59414d;
        reentrantLock.lock();
        try {
            t<?> m4 = m();
            if (m4 != null) {
                return m4;
            }
            int Z = Z();
            if (Z >= this.f59417g) {
                return b.f59398f;
            }
            if (!fVar.p()) {
                return kotlinx.coroutines.selects.g.d();
            }
            long a02 = a0();
            this.f59415e[(int) (a02 % this.f59417g)] = e4;
            c0(Z + 1);
            d0(a02 + 1);
            f1 f1Var = f1.f55527a;
            reentrantLock.unlock();
            U();
            return b.f59397e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c, kotlinx.coroutines.channels.h0
    public boolean K(@Nullable Throwable th) {
        if (super.K(th)) {
            U();
            return true;
        }
        return false;
    }

    public final int X() {
        return this.f59417g;
    }

    @Override // kotlinx.coroutines.channels.j
    public void b(@Nullable CancellationException cancellationException) {
        a(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.c
    @NotNull
    protected String k() {
        return "(buffer:capacity=" + this.f59415e.length + ",size=" + Z() + ')';
    }

    @Override // kotlinx.coroutines.channels.j
    @NotNull
    public d0<E> t() {
        a aVar = new a(this);
        f0(this, aVar, null, 2, null);
        return aVar;
    }

    @Override // kotlinx.coroutines.channels.c
    protected boolean x() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected boolean y() {
        return Z() >= this.f59417g;
    }
}
