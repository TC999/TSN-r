package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import io.netty.channel.C13675a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\b\u0000\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0017\u0013B\u0017\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0014¢\u0006\u0004\b.\u0010/J3\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010 \"\u0004\b\u0001\u0010\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0014¢\u0006\u0004\b#\u0010\u0016R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u0014\u0010&\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010$R\u0014\u0010(\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0011\u0010*\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00061"}, m12616d2 = {"Lkotlinx/coroutines/internal/v;", "", ExifInterface.LONGITUDE_EAST, "", "index", "element", "Lkotlinx/coroutines/internal/Core;", "e", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/v;", "oldHead", "newHead", "m", "(II)Lkotlinx/coroutines/internal/v;", "", "j", "()J", "state", "c", "(J)Lkotlinx/coroutines/internal/v;", "b", "", "d", "()Z", "a", "(Ljava/lang/Object;)I", C7304t.f25048d, "()Ljava/lang/Object;", "k", "()Lkotlinx/coroutines/internal/v;", "R", "Lkotlin/Function1;", "transform", "", "i", "(Ll1/l;)Ljava/util/List;", "g", "I", "mask", "capacity", "Z", "singleConsumer", "h", "isEmpty", "f", "()I", "size", "<init>", "(IZ)V", IAdInterListener.AdReqParam.WIDTH, "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15104v<E> {

    /* renamed from: g */
    public static final int f43107g = 8;

    /* renamed from: h */
    public static final int f43108h = 30;

    /* renamed from: i */
    public static final int f43109i = 1073741823;

    /* renamed from: j */
    public static final int f43110j = 0;

    /* renamed from: k */
    public static final long f43111k = 1073741823;

    /* renamed from: l */
    public static final int f43112l = 30;

    /* renamed from: m */
    public static final long f43113m = 1152921503533105152L;

    /* renamed from: n */
    public static final int f43114n = 60;

    /* renamed from: o */
    public static final long f43115o = 1152921504606846976L;

    /* renamed from: p */
    public static final int f43116p = 61;

    /* renamed from: q */
    public static final long f43117q = 2305843009213693952L;

    /* renamed from: r */
    public static final int f43118r = 1024;

    /* renamed from: t */
    public static final int f43120t = 0;

    /* renamed from: u */
    public static final int f43121u = 1;

    /* renamed from: v */
    public static final int f43122v = 2;
    private volatile Object _next = null;
    private volatile long _state = 0;

    /* renamed from: a */
    private final int f43124a;

    /* renamed from: b */
    private AtomicReferenceArray f43125b;

    /* renamed from: c */
    private final int f43126c;

    /* renamed from: d */
    private final boolean f43127d;

    /* renamed from: w */
    public static final C15105a f43123w = new C15105a(null);
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: s */
    public static final Symbol f43119s = new Symbol("REMOVE_FROZEN");

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f43105e = AtomicReferenceFieldUpdater.newUpdater(C15104v.class, Object.class, "_next");

    /* renamed from: f */
    private static final AtomicLongFieldUpdater f43106f = AtomicLongFieldUpdater.newUpdater(C15104v.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004J\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005JR\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0001\u0010\n*\u00020\u000226\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00010\u000bH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010$\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0014\u0010'\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u0015¨\u0006*"}, m12616d2 = {"Lkotlinx/coroutines/internal/v$a;", "", "", AdnName.OTHER, "e", "", "newHead", "b", "newTail", "c", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "block", "d", "(JLl1/p;)Ljava/lang/Object;", "a", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/j0;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/j0;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.v$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15105a {
        private C15105a() {
        }

        /* renamed from: a */
        public final int m4146a(long j) {
            return (j & C15104v.f43117q) != 0 ? 2 : 1;
        }

        /* renamed from: b */
        public final long m4145b(long j, int i) {
            return m4142e(j, C15104v.f43111k) | (i << 0);
        }

        /* renamed from: c */
        public final long m4144c(long j, int i) {
            return m4142e(j, C15104v.f43113m) | (i << 30);
        }

        /* renamed from: d */
        public final <T> T m4143d(long j, @NotNull InterfaceC15284p<? super Integer, ? super Integer, ? extends T> interfaceC15284p) {
            return interfaceC15284p.invoke(Integer.valueOf((int) ((C15104v.f43111k & j) >> 0)), Integer.valueOf((int) ((j & C15104v.f43113m) >> 30)));
        }

        /* renamed from: e */
        public final long m4142e(long j, long j2) {
            return j & (j2 ^ (-1));
        }

        public /* synthetic */ C15105a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/internal/v$b;", "", "", "a", "I", "index", "<init>", "(I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.v$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15106b {
        @JvmPlatformAnnotations

        /* renamed from: a */
        public final int f43128a;

        public C15106b(int i) {
            this.f43128a = i;
        }
    }

    public C15104v(int i, boolean z) {
        this.f43126c = i;
        this.f43127d = z;
        int i2 = i - 1;
        this.f43124a = i2;
        this.f43125b = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private final C15104v<E> m4158b(long j) {
        C15104v<E> c15104v = new C15104v<>(this.f43126c * 2, this.f43127d);
        int i = (int) ((f43111k & j) >> 0);
        int i2 = (int) ((f43113m & j) >> 30);
        while (true) {
            int i3 = this.f43124a;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.f43125b.get(i3 & i);
                if (obj == null) {
                    obj = new C15106b(i);
                }
                c15104v.f43125b.set(c15104v.f43124a & i, obj);
                i++;
            } else {
                c15104v._state = f43123w.m4142e(j, f43115o);
                return c15104v;
            }
        }
    }

    /* renamed from: c */
    private final C15104v<E> m4157c(long j) {
        while (true) {
            C15104v<E> c15104v = (C15104v) this._next;
            if (c15104v != null) {
                return c15104v;
            }
            C13675a.m12692a(f43105e, this, null, m4158b(j));
        }
    }

    /* renamed from: e */
    private final C15104v<E> m4155e(int i, E e) {
        Object obj = this.f43125b.get(this.f43124a & i);
        if ((obj instanceof C15106b) && ((C15106b) obj).f43128a == i) {
            this.f43125b.set(i & this.f43124a, e);
            return this;
        }
        return null;
    }

    /* renamed from: j */
    private final long m4150j() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & f43115o) != 0) {
                return j;
            }
            j2 = j | f43115o;
        } while (!f43106f.compareAndSet(this, j, j2));
        return j2;
    }

    /* renamed from: m */
    private final C15104v<E> m4147m(int i, int i2) {
        long j;
        C15105a c15105a;
        int i3;
        do {
            j = this._state;
            c15105a = f43123w;
            i3 = (int) ((f43111k & j) >> 0);
            if ((f43115o & j) != 0) {
                return m4149k();
            }
        } while (!f43106f.compareAndSet(this, j, c15105a.m4145b(j, i2)));
        this.f43125b.set(this.f43124a & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4159a(@org.jetbrains.annotations.NotNull E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.v$a r14 = kotlinx.coroutines.internal.C15104v.f43123w
            int r14 = r14.m4146a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.v$a r0 = kotlinx.coroutines.internal.C15104v.f43123w
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
            int r10 = r13.f43124a
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f43127d
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f43125b
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f43126c
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.C15104v.f43106f
            long r11 = r0.m4144c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f43125b
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
            kotlinx.coroutines.internal.v r0 = r0.m4149k()
            kotlinx.coroutines.internal.v r0 = r0.m4155e(r9, r14)
            if (r0 == 0) goto L7e
            goto L69
        L7e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C15104v.m4159a(java.lang.Object):int");
    }

    /* renamed from: d */
    public final boolean m4156d() {
        long j;
        do {
            j = this._state;
            if ((j & f43117q) != 0) {
                return true;
            }
            if ((f43115o & j) != 0) {
                return false;
            }
        } while (!f43106f.compareAndSet(this, j, j | f43117q));
        return true;
    }

    /* renamed from: f */
    public final int m4154f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & f43113m) >> 30)) - ((int) ((f43111k & j) >> 0)));
    }

    /* renamed from: g */
    public final boolean m4153g() {
        return (this._state & f43117q) != 0;
    }

    /* renamed from: h */
    public final boolean m4152h() {
        long j = this._state;
        return ((int) ((f43111k & j) >> 0)) == ((int) ((j & f43113m) >> 30));
    }

    @NotNull
    /* renamed from: i */
    public final <R> List<R> m4151i(@NotNull InterfaceC15280l<? super E, ? extends R> interfaceC15280l) {
        ArrayList arrayList = new ArrayList(this.f43126c);
        long j = this._state;
        int i = (int) ((f43111k & j) >> 0);
        int i2 = (int) ((j & f43113m) >> 30);
        while (true) {
            int i3 = this.f43124a;
            if ((i & i3) == (i2 & i3)) {
                return arrayList;
            }
            Object obj = (Object) this.f43125b.get(i3 & i);
            if (obj != 0 && !(obj instanceof C15106b)) {
                arrayList.add(interfaceC15280l.invoke(obj));
            }
            i++;
        }
    }

    @NotNull
    /* renamed from: k */
    public final C15104v<E> m4149k() {
        return m4157c(m4150j());
    }

    @Nullable
    /* renamed from: l */
    public final Object m4148l() {
        while (true) {
            long j = this._state;
            if ((f43115o & j) != 0) {
                return f43119s;
            }
            C15105a c15105a = f43123w;
            int i = (int) ((f43111k & j) >> 0);
            int i2 = (int) ((f43113m & j) >> 30);
            int i3 = this.f43124a;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.f43125b.get(i3 & i);
            if (obj == null) {
                if (this.f43127d) {
                    return null;
                }
            } else if (obj instanceof C15106b) {
                return null;
            } else {
                int i4 = (i + 1) & f43109i;
                if (f43106f.compareAndSet(this, j, c15105a.m4145b(j, i4))) {
                    this.f43125b.set(this.f43124a & i, null);
                    return obj;
                } else if (this.f43127d) {
                    C15104v<E> c15104v = this;
                    do {
                        c15104v = c15104v.m4147m(i, i4);
                    } while (c15104v != null);
                    return obj;
                }
            }
        }
    }
}
