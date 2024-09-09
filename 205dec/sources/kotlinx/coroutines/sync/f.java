package kotlinx.coroutines.sync;

import d2.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\f\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/sync/f;", "Lkotlinx/coroutines/sync/e;", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "cont", "", "f", "(Lkotlinx/coroutines/o;)Z", "h", "()Z", "g", "b", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "release", "()V", "", "I", "permits", "a", "()I", "availablePermits", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements e {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60704c = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "head");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f60705d = AtomicLongFieldUpdater.newUpdater(f.class, "deqIdx");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60706e = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "tail");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f60707f = AtomicLongFieldUpdater.newUpdater(f.class, "enqIdx");

    /* renamed from: g  reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f60708g = AtomicIntegerFieldUpdater.newUpdater(f.class, "_availablePermits");
    volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final l<Throwable, f1> f60709a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60710b;
    private volatile long deqIdx = 0;
    private volatile long enqIdx = 0;
    private volatile Object head;
    private volatile Object tail;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Semaphore.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<anonymous parameter 0>", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements l<Throwable, f1> {
        a() {
            super(1);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            invoke2(th);
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            f.this.release();
        }
    }

    public f(int i4, int i5) {
        this.f60710b = i4;
        boolean z3 = true;
        if (!(i4 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i4).toString());
        }
        if ((i5 < 0 || i4 < i5) ? false : false) {
            g gVar = new g(0L, null, 2);
            this.head = gVar;
            this.tail = gVar;
            this._availablePermits = i4 - i5;
            this.f60709a = new a();
            return;
        }
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i4).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0074, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(kotlinx.coroutines.o<? super kotlin.f1> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.tail
            kotlinx.coroutines.sync.g r2 = (kotlinx.coroutines.sync.g) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.sync.f.f60707f
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.h()
            long r5 = (long) r5
            long r5 = r3 / r5
        L15:
            r7 = r2
        L16:
            long r8 = r7.o()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 < 0) goto L2a
            boolean r8 = r7.g()
            if (r8 == 0) goto L25
            goto L2a
        L25:
            java.lang.Object r7 = kotlinx.coroutines.internal.h0.b(r7)
            goto L3c
        L2a:
            java.lang.Object r8 = kotlinx.coroutines.internal.g.a(r7)
            kotlinx.coroutines.internal.j0 r9 = kotlinx.coroutines.internal.f.b()
            if (r8 != r9) goto Lbd
            kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.internal.f.b()
            java.lang.Object r7 = kotlinx.coroutines.internal.h0.b(r7)
        L3c:
            boolean r8 = kotlinx.coroutines.internal.h0.h(r7)
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L81
            kotlinx.coroutines.internal.g0 r8 = kotlinx.coroutines.internal.h0.f(r7)
        L48:
            java.lang.Object r11 = r0.tail
            kotlinx.coroutines.internal.g0 r11 = (kotlinx.coroutines.internal.g0) r11
            long r12 = r11.o()
            long r14 = r8.o()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L5a
        L58:
            r8 = 1
            goto L74
        L5a:
            boolean r12 = r8.r()
            if (r12 != 0) goto L62
            r8 = 0
            goto L74
        L62:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.sync.f.f60706e
            boolean r12 = io.netty.channel.a.a(r12, r0, r11, r8)
            if (r12 == 0) goto L77
            boolean r8 = r11.n()
            if (r8 == 0) goto L58
            r11.l()
            goto L58
        L74:
            if (r8 == 0) goto L15
            goto L81
        L77:
            boolean r11 = r8.n()
            if (r11 == 0) goto L48
            r8.l()
            goto L48
        L81:
            kotlinx.coroutines.internal.g0 r2 = kotlinx.coroutines.internal.h0.f(r7)
            kotlinx.coroutines.sync.g r2 = (kotlinx.coroutines.sync.g) r2
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.h()
            long r5 = (long) r5
            long r3 = r3 % r5
            int r4 = (int) r3
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.f60712e
            boolean r3 = r5.compareAndSet(r4, r3, r1)
            if (r3 == 0) goto La0
            kotlinx.coroutines.sync.a r3 = new kotlinx.coroutines.sync.a
            r3.<init>(r2, r4)
            r1.B(r3)
            return r10
        La0:
            kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.sync.SemaphoreKt.g()
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.sync.SemaphoreKt.i()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.f60712e
            boolean r2 = r2.compareAndSet(r4, r3, r5)
            if (r2 == 0) goto Lbc
            kotlin.f1 r2 = kotlin.f1.f55527a
            kotlin.Result$a r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.Result.m119constructorimpl(r2)
            r1.resumeWith(r2)
            return r10
        Lbc:
            return r9
        Lbd:
            kotlinx.coroutines.internal.g r8 = (kotlinx.coroutines.internal.g) r8
            kotlinx.coroutines.internal.g0 r8 = (kotlinx.coroutines.internal.g0) r8
            if (r8 == 0) goto Lc6
        Lc3:
            r7 = r8
            goto L16
        Lc6:
            long r8 = r7.o()
            r10 = 1
            long r8 = r8 + r10
            r10 = r7
            kotlinx.coroutines.sync.g r10 = (kotlinx.coroutines.sync.g) r10
            kotlinx.coroutines.sync.g r8 = kotlinx.coroutines.sync.SemaphoreKt.c(r8, r10)
            boolean r9 = r7.m(r8)
            if (r9 == 0) goto L16
            boolean r9 = r7.g()
            if (r9 == 0) goto Lc3
            r7.l()
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.f.f(kotlinx.coroutines.o):boolean");
    }

    private final boolean g(o<? super f1> oVar) {
        Object n4 = oVar.n(f1.f55527a, null, this.f60709a);
        if (n4 != null) {
            oVar.S(n4);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0070, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean h() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.f.h():boolean");
    }

    @Override // kotlinx.coroutines.sync.e
    public int a() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.e
    public boolean b() {
        int i4;
        do {
            i4 = this._availablePermits;
            if (i4 <= 0) {
                return false;
            }
        } while (!f60708g.compareAndSet(this, i4, i4 - 1));
        return true;
    }

    @Override // kotlinx.coroutines.sync.e
    @Nullable
    public Object c(@NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        if (f60708g.getAndDecrement(this) > 0) {
            return f1.f55527a;
        }
        Object e4 = e(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    final /* synthetic */ Object e(@NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p b4 = r.b(d4);
        while (true) {
            if (!f(b4)) {
                if (f60708g.getAndDecrement(this) > 0) {
                    f1 f1Var = f1.f55527a;
                    Result.a aVar = Result.Companion;
                    b4.resumeWith(Result.m119constructorimpl(f1Var));
                    break;
                }
            } else {
                break;
            }
        }
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Override // kotlinx.coroutines.sync.e
    public void release() {
        while (true) {
            int i4 = this._availablePermits;
            if (i4 < this.f60710b) {
                if (f60708g.compareAndSet(this, i4, i4 + 1) && (i4 >= 0 || h())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f60710b).toString());
            }
        }
    }
}
