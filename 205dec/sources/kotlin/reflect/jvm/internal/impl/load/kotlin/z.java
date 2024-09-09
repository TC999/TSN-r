package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeMappingMode.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final a f57264k = new a(null);
    @JvmField
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public static final z f57265l;
    @JvmField
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public static final z f57266m;
    @JvmField
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public static final z f57267n;
    @JvmField
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final z f57268o;
    @JvmField
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    public static final z f57269p;
    @JvmField
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    public static final z f57270q;
    @JvmField
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    public static final z f57271r;
    @JvmField
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    public static final z f57272s;
    @JvmField
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    public static final z f57273t;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f57274a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f57275b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f57276c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57277d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f57278e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final z f57279f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f57280g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final z f57281h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final z f57282i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f57283j;

    /* compiled from: TypeMappingMode.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* compiled from: TypeMappingMode.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57284a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
            f57284a = iArr;
        }
    }

    static {
        z zVar = new z(false, false, false, false, false, null, false, null, null, false, 1023, null);
        f57265l = zVar;
        z zVar2 = new z(false, false, false, false, false, null, false, null, null, true, 511, null);
        f57266m = zVar2;
        f57267n = new z(false, true, false, false, false, null, false, null, null, false, 1021, null);
        f57268o = new z(false, false, false, false, false, zVar, false, null, null, false, 988, null);
        f57269p = new z(false, false, false, false, false, zVar2, false, null, null, true, 476, null);
        f57270q = new z(false, true, false, false, false, zVar, false, null, null, false, 988, null);
        f57271r = new z(false, false, false, true, false, zVar, false, null, null, false, 983, null);
        f57272s = new z(false, false, false, true, false, zVar, false, null, null, false, 919, null);
        f57273t = new z(false, false, true, false, false, zVar, false, null, null, false, 984, null);
    }

    public z() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public z(boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @Nullable z zVar, boolean z8, @Nullable z zVar2, @Nullable z zVar3, boolean z9) {
        this.f57274a = z3;
        this.f57275b = z4;
        this.f57276c = z5;
        this.f57277d = z6;
        this.f57278e = z7;
        this.f57279f = zVar;
        this.f57280g = z8;
        this.f57281h = zVar2;
        this.f57282i = zVar3;
        this.f57283j = z9;
    }

    public final boolean a() {
        return this.f57280g;
    }

    public final boolean b() {
        return this.f57283j;
    }

    public final boolean c() {
        return this.f57275b;
    }

    public final boolean d() {
        return this.f57274a;
    }

    public final boolean e() {
        return this.f57276c;
    }

    @NotNull
    public final z f(@NotNull Variance effectiveVariance, boolean z3) {
        f0.p(effectiveVariance, "effectiveVariance");
        if (!z3 || !this.f57276c) {
            int i4 = b.f57284a[effectiveVariance.ordinal()];
            if (i4 == 1) {
                z zVar = this.f57281h;
                if (zVar != null) {
                    return zVar;
                }
            } else if (i4 != 2) {
                z zVar2 = this.f57279f;
                if (zVar2 != null) {
                    return zVar2;
                }
            } else {
                z zVar3 = this.f57282i;
                if (zVar3 != null) {
                    return zVar3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final z g() {
        return new z(this.f57274a, true, this.f57276c, this.f57277d, this.f57278e, this.f57279f, this.f57280g, this.f57281h, this.f57282i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ z(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, kotlin.reflect.jvm.internal.impl.load.kotlin.z r17, boolean r18, kotlin.reflect.jvm.internal.impl.load.kotlin.z r19, kotlin.reflect.jvm.internal.impl.load.kotlin.z r20, boolean r21, int r22, kotlin.jvm.internal.u r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L9
            r1 = 1
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L18
            r4 = 0
            goto L19
        L18:
            r4 = r14
        L19:
            r6 = r0 & 8
            if (r6 == 0) goto L1f
            r6 = 0
            goto L20
        L1f:
            r6 = r15
        L20:
            r7 = r0 & 16
            if (r7 == 0) goto L26
            r7 = 0
            goto L28
        L26:
            r7 = r16
        L28:
            r8 = r0 & 32
            if (r8 == 0) goto L2e
            r8 = 0
            goto L30
        L2e:
            r8 = r17
        L30:
            r9 = r0 & 64
            if (r9 == 0) goto L35
            goto L37
        L35:
            r2 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3d
            r9 = r8
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L45
            r10 = r8
            goto L47
        L45:
            r10 = r20
        L47:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r5 = r21
        L4e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.z.<init>(boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.z, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.z, kotlin.reflect.jvm.internal.impl.load.kotlin.z, boolean, int, kotlin.jvm.internal.u):void");
    }
}
