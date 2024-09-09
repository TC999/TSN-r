package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LockFreeTaskQueue.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\b\u0000\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0017\u0013B\u0017\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0014\u00a2\u0006\u0004\b.\u0010/J3\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010 \"\u0004\b\u0001\u0010\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\u00a2\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010\u0016R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$R\u0014\u0010&\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0014\u0010(\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0011\u0010*\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0011\u0010-\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/internal/v;", "", "E", "", "index", "element", "Lkotlinx/coroutines/internal/Core;", "e", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/v;", "oldHead", "newHead", "m", "(II)Lkotlinx/coroutines/internal/v;", "", "j", "()J", "state", "c", "(J)Lkotlinx/coroutines/internal/v;", "b", "", "d", "()Z", "a", "(Ljava/lang/Object;)I", "l", "()Ljava/lang/Object;", "k", "()Lkotlinx/coroutines/internal/v;", "R", "Lkotlin/Function1;", "transform", "", "i", "(Ld2/l;)Ljava/util/List;", "g", "I", "mask", "capacity", "Z", "singleConsumer", "h", "isEmpty", "f", "()I", "size", "<init>", "(IZ)V", "w", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f60424g = 8;

    /* renamed from: h  reason: collision with root package name */
    public static final int f60425h = 30;

    /* renamed from: i  reason: collision with root package name */
    public static final int f60426i = 1073741823;

    /* renamed from: j  reason: collision with root package name */
    public static final int f60427j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final long f60428k = 1073741823;

    /* renamed from: l  reason: collision with root package name */
    public static final int f60429l = 30;

    /* renamed from: m  reason: collision with root package name */
    public static final long f60430m = 1152921503533105152L;

    /* renamed from: n  reason: collision with root package name */
    public static final int f60431n = 60;

    /* renamed from: o  reason: collision with root package name */
    public static final long f60432o = 1152921504606846976L;

    /* renamed from: p  reason: collision with root package name */
    public static final int f60433p = 61;

    /* renamed from: q  reason: collision with root package name */
    public static final long f60434q = 2305843009213693952L;

    /* renamed from: r  reason: collision with root package name */
    public static final int f60435r = 1024;

    /* renamed from: t  reason: collision with root package name */
    public static final int f60437t = 0;

    /* renamed from: u  reason: collision with root package name */
    public static final int f60438u = 1;

    /* renamed from: v  reason: collision with root package name */
    public static final int f60439v = 2;
    private volatile Object _next = null;
    private volatile long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f60441a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicReferenceArray f60442b;

    /* renamed from: c  reason: collision with root package name */
    private final int f60443c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f60444d;

    /* renamed from: w  reason: collision with root package name */
    public static final a f60440w = new a(null);
    @JvmField
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    public static final j0 f60436s = new j0("REMOVE_FROZEN");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60422e = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_next");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f60423f = AtomicLongFieldUpdater.newUpdater(v.class, "_state");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004J\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005JR\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0001\u0010\n*\u00020\u000226\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00010\u000bH\u0086\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010$\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR\u0014\u0010'\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0015\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/internal/v$a;", "", "", "other", "e", "", "newHead", "b", "newTail", "c", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "block", "d", "(JLd2/p;)Ljava/lang/Object;", "a", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/j0;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/j0;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public final int a(long j4) {
            return (j4 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j4, int i4) {
            return e(j4, 1073741823L) | (i4 << 0);
        }

        public final long c(long j4, int i4) {
            return e(j4, 1152921503533105152L) | (i4 << 30);
        }

        public final <T> T d(long j4, @NotNull d2.p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.invoke(Integer.valueOf((int) ((1073741823 & j4) >> 0)), Integer.valueOf((int) ((j4 & 1152921503533105152L) >> 30)));
        }

        public final long e(long j4, long j5) {
            return j4 & (j5 ^ (-1));
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/v$b;", "", "", "a", "I", "index", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final int f60445a;

        public b(int i4) {
            this.f60445a = i4;
        }
    }

    public v(int i4, boolean z3) {
        this.f60443c = i4;
        this.f60444d = z3;
        int i5 = i4 - 1;
        this.f60441a = i5;
        this.f60442b = new AtomicReferenceArray(i4);
        if (!(i5 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i4 & i5) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final v<E> b(long j4) {
        v<E> vVar = new v<>(this.f60443c * 2, this.f60444d);
        int i4 = (int) ((1073741823 & j4) >> 0);
        int i5 = (int) ((1152921503533105152L & j4) >> 30);
        while (true) {
            int i6 = this.f60441a;
            if ((i4 & i6) != (i5 & i6)) {
                Object obj = this.f60442b.get(i6 & i4);
                if (obj == null) {
                    obj = new b(i4);
                }
                vVar.f60442b.set(vVar.f60441a & i4, obj);
                i4++;
            } else {
                vVar._state = f60440w.e(j4, 1152921504606846976L);
                return vVar;
            }
        }
    }

    private final v<E> c(long j4) {
        while (true) {
            v<E> vVar = (v) this._next;
            if (vVar != null) {
                return vVar;
            }
            io.netty.channel.a.a(f60422e, this, null, b(j4));
        }
    }

    private final v<E> e(int i4, E e4) {
        Object obj = this.f60442b.get(this.f60441a & i4);
        if ((obj instanceof b) && ((b) obj).f60445a == i4) {
            this.f60442b.set(i4 & this.f60441a, e4);
            return this;
        }
        return null;
    }

    private final long j() {
        long j4;
        long j5;
        do {
            j4 = this._state;
            if ((j4 & 1152921504606846976L) != 0) {
                return j4;
            }
            j5 = j4 | 1152921504606846976L;
        } while (!f60423f.compareAndSet(this, j4, j5));
        return j5;
    }

    private final v<E> m(int i4, int i5) {
        long j4;
        a aVar;
        int i6;
        do {
            j4 = this._state;
            aVar = f60440w;
            i6 = (int) ((1073741823 & j4) >> 0);
            if ((1152921504606846976L & j4) != 0) {
                return k();
            }
        } while (!f60423f.compareAndSet(this, j4, aVar.b(j4, i5)));
        this.f60442b.set(this.f60441a & i6, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@org.jetbrains.annotations.NotNull E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.v$a r14 = kotlinx.coroutines.internal.v.f60440w
            int r14 = r14.a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.v$a r0 = kotlinx.coroutines.internal.v.f60440w
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f60441a
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f60444d
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f60442b
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f60443c
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.v.f60423f
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f60442b
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L73
            goto L7e
        L73:
            kotlinx.coroutines.internal.v r0 = r0.k()
            kotlinx.coroutines.internal.v r0 = r0.e(r9, r14)
            if (r0 == 0) goto L7e
            goto L69
        L7e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.v.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j4;
        do {
            j4 = this._state;
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
        } while (!f60423f.compareAndSet(this, j4, j4 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j4 = this._state;
        return 1073741823 & (((int) ((j4 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j4) >> 0)));
    }

    public final boolean g() {
        return (this._state & 2305843009213693952L) != 0;
    }

    public final boolean h() {
        long j4 = this._state;
        return ((int) ((1073741823 & j4) >> 0)) == ((int) ((j4 & 1152921503533105152L) >> 30));
    }

    @NotNull
    public final <R> List<R> i(@NotNull d2.l<? super E, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(this.f60443c);
        long j4 = this._state;
        int i4 = (int) ((1073741823 & j4) >> 0);
        int i5 = (int) ((j4 & 1152921503533105152L) >> 30);
        while (true) {
            int i6 = this.f60441a;
            if ((i4 & i6) == (i5 & i6)) {
                return arrayList;
            }
            Object obj = (Object) this.f60442b.get(i6 & i4);
            if (obj != 0 && !(obj instanceof b)) {
                arrayList.add(lVar.invoke(obj));
            }
            i4++;
        }
    }

    @NotNull
    public final v<E> k() {
        return c(j());
    }

    @Nullable
    public final Object l() {
        while (true) {
            long j4 = this._state;
            if ((1152921504606846976L & j4) != 0) {
                return f60436s;
            }
            a aVar = f60440w;
            int i4 = (int) ((1073741823 & j4) >> 0);
            int i5 = (int) ((1152921503533105152L & j4) >> 30);
            int i6 = this.f60441a;
            if ((i5 & i6) == (i4 & i6)) {
                return null;
            }
            Object obj = this.f60442b.get(i6 & i4);
            if (obj == null) {
                if (this.f60444d) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i7 = (i4 + 1) & 1073741823;
                if (f60423f.compareAndSet(this, j4, aVar.b(j4, i7))) {
                    this.f60442b.set(this.f60441a & i4, null);
                    return obj;
                } else if (this.f60444d) {
                    v<E> vVar = this;
                    do {
                        vVar = vVar.m(i4, i7);
                    } while (vVar != null);
                    return obj;
                }
            }
        }
    }
}
