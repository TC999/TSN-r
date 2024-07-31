package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15161r;
import kotlinx.coroutines.InterfaceC15146o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\f\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/sync/f;", "Lkotlinx/coroutines/sync/e;", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "cont", "", "f", "(Lkotlinx/coroutines/o;)Z", "h", "()Z", "g", "b", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "release", "()V", "", "I", "permits", "a", "()I", "availablePermits", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15222f implements InterfaceC15221e {

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f43387c = AtomicReferenceFieldUpdater.newUpdater(C15222f.class, Object.class, "head");

    /* renamed from: d */
    private static final AtomicLongFieldUpdater f43388d = AtomicLongFieldUpdater.newUpdater(C15222f.class, "deqIdx");

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f43389e = AtomicReferenceFieldUpdater.newUpdater(C15222f.class, Object.class, "tail");

    /* renamed from: f */
    private static final AtomicLongFieldUpdater f43390f = AtomicLongFieldUpdater.newUpdater(C15222f.class, "enqIdx");

    /* renamed from: g */
    static final AtomicIntegerFieldUpdater f43391g = AtomicIntegerFieldUpdater.newUpdater(C15222f.class, "_availablePermits");
    volatile int _availablePermits;

    /* renamed from: a */
    private final InterfaceC15280l<Throwable, Unit> f43392a;

    /* renamed from: b */
    private final int f43393b;
    private volatile long deqIdx = 0;
    private volatile long enqIdx = 0;
    private volatile Object head;
    private volatile Object tail;

    /* compiled from: Semaphore.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "<anonymous parameter 0>", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15223a extends Lambda implements InterfaceC15280l<Throwable, Unit> {
        C15223a() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            C15222f.this.release();
        }
    }

    public C15222f(int i, int i2) {
        this.f43393b = i;
        boolean z = true;
        if (!(i > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        }
        if ((i2 < 0 || i < i2) ? false : false) {
            C15224g c15224g = new C15224g(0L, null, 2);
            this.head = c15224g;
            this.tail = c15224g;
            this._availablePermits = i - i2;
            this.f43392a = new C15223a();
            return;
        }
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0074, code lost:
        continue;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3608f(kotlinx.coroutines.InterfaceC15146o<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.tail
            kotlinx.coroutines.sync.g r2 = (kotlinx.coroutines.sync.C15224g) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.sync.C15222f.f43390f
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.Semaphore.m3648h()
            long r5 = (long) r5
            long r5 = r3 / r5
        L15:
            r7 = r2
        L16:
            long r8 = r7.m4344o()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 < 0) goto L2a
            boolean r8 = r7.mo4346g()
            if (r8 == 0) goto L25
            goto L2a
        L25:
            java.lang.Object r7 = kotlinx.coroutines.internal.C15078h0.m4340b(r7)
            goto L3c
        L2a:
            java.lang.Object r8 = kotlinx.coroutines.internal.AbstractC15075g.m4358a(r7)
            kotlinx.coroutines.internal.j0 r9 = kotlinx.coroutines.internal.ConcurrentLinkedList.m4363b()
            if (r8 != r9) goto Lbd
            kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.internal.ConcurrentLinkedList.m4363b()
            java.lang.Object r7 = kotlinx.coroutines.internal.C15078h0.m4340b(r7)
        L3c:
            boolean r8 = kotlinx.coroutines.internal.C15078h0.m4334h(r7)
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L81
            kotlinx.coroutines.internal.g0 r8 = kotlinx.coroutines.internal.C15078h0.m4336f(r7)
        L48:
            java.lang.Object r11 = r0.tail
            kotlinx.coroutines.internal.g0 r11 = (kotlinx.coroutines.internal.AbstractC15076g0) r11
            long r12 = r11.m4344o()
            long r14 = r8.m4344o()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L5a
        L58:
            r8 = 1
            goto L74
        L5a:
            boolean r12 = r8.m4342r()
            if (r12 != 0) goto L62
            r8 = 0
            goto L74
        L62:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.sync.C15222f.f43389e
            boolean r12 = io.netty.channel.C13675a.m12692a(r12, r0, r11, r8)
            if (r12 == 0) goto L77
            boolean r8 = r11.m4345n()
            if (r8 == 0) goto L58
            r11.m4348l()
            goto L58
        L74:
            if (r8 == 0) goto L15
            goto L81
        L77:
            boolean r11 = r8.m4345n()
            if (r11 == 0) goto L48
            r8.m4348l()
            goto L48
        L81:
            kotlinx.coroutines.internal.g0 r2 = kotlinx.coroutines.internal.C15078h0.m4336f(r7)
            kotlinx.coroutines.sync.g r2 = (kotlinx.coroutines.sync.C15224g) r2
            int r5 = kotlinx.coroutines.sync.Semaphore.m3648h()
            long r5 = (long) r5
            long r3 = r3 % r5
            int r4 = (int) r3
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.f43395e
            boolean r3 = r5.compareAndSet(r4, r3, r1)
            if (r3 == 0) goto La0
            kotlinx.coroutines.sync.a r3 = new kotlinx.coroutines.sync.a
            r3.<init>(r2, r4)
            r1.mo3902e(r3)
            return r10
        La0:
            kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.sync.Semaphore.m3649g()
            kotlinx.coroutines.internal.j0 r5 = kotlinx.coroutines.sync.Semaphore.m3647i()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.f43395e
            boolean r2 = r2.compareAndSet(r4, r3, r5)
            if (r2 == 0) goto Lbc
            kotlin.f1 r2 = kotlin.Unit.f41048a
            kotlin.Result$a r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.Result.m60148constructorimpl(r2)
            r1.resumeWith(r2)
            return r10
        Lbc:
            return r9
        Lbd:
            kotlinx.coroutines.internal.g r8 = (kotlinx.coroutines.internal.AbstractC15075g) r8
            kotlinx.coroutines.internal.g0 r8 = (kotlinx.coroutines.internal.AbstractC15076g0) r8
            if (r8 == 0) goto Lc6
        Lc3:
            r7 = r8
            goto L16
        Lc6:
            long r8 = r7.m4344o()
            r10 = 1
            long r8 = r8 + r10
            r10 = r7
            kotlinx.coroutines.sync.g r10 = (kotlinx.coroutines.sync.C15224g) r10
            kotlinx.coroutines.sync.g r8 = kotlinx.coroutines.sync.Semaphore.m3653c(r8, r10)
            boolean r9 = r7.m4347m(r8)
            if (r9 == 0) goto L16
            boolean r9 = r7.mo4346g()
            if (r9 == 0) goto Lc3
            r7.m4348l()
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.C15222f.m3608f(kotlinx.coroutines.o):boolean");
    }

    /* renamed from: g */
    private final boolean m3607g(InterfaceC15146o<? super Unit> interfaceC15146o) {
        Object mo3911N = interfaceC15146o.mo3911N(Unit.f41048a, null, this.f43392a);
        if (mo3911N != null) {
            interfaceC15146o.mo3906T(mo3911N);
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
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean m3606h() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.C15222f.m3606h():boolean");
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15221e
    /* renamed from: a */
    public int mo3613a() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15221e
    /* renamed from: b */
    public boolean mo3612b() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!f43391g.compareAndSet(this, i, i - 1));
        return true;
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15221e
    @Nullable
    /* renamed from: c */
    public Object mo3611c(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if (f43391g.getAndDecrement(this) > 0) {
            return Unit.f41048a;
        }
        Object m3609e = m3609e(interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m3609e == m8642h ? m3609e : Unit.f41048a;
    }

    @Nullable
    /* renamed from: e */
    final /* synthetic */ Object m3609e(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = C15161r.m3852b(m8650d);
        while (true) {
            if (!m3608f(m3852b)) {
                if (f43391g.getAndDecrement(this) > 0) {
                    Unit unit = Unit.f41048a;
                    Result.C14124a c14124a = Result.Companion;
                    m3852b.resumeWith(Result.m60148constructorimpl(unit));
                    break;
                }
            } else {
                break;
            }
        }
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15221e
    public void release() {
        while (true) {
            int i = this._availablePermits;
            if (i < this.f43393b) {
                if (f43391g.compareAndSet(this, i, i + 1) && (i >= 0 || m3606h())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f43393b).toString());
            }
        }
    }
}
