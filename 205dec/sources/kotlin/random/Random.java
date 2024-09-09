package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Random.kt */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016\u00a8\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Random {
    @NotNull
    public static final Default Default = new Default(null);
    @NotNull
    private static final Random defaultRandom = kotlin.internal.b.f55545a.b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Random.kt */
    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "bitCount", "nextBits", "nextInt", "until", "from", "", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "array", "nextBytes", "size", "fromIndex", "toIndex", "defaultRandom", "Lkotlin/random/Random;", "<init>", "()V", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Default extends Random implements Serializable {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Random.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lkotlin/random/Random$Default$a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private static final class a implements Serializable {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final a f55764a = new a();
            private static final long serialVersionUID = 0;

            private a() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(u uVar) {
            this();
        }

        private final Object writeReplace() {
            return a.f55764a;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i4) {
            return Random.defaultRandom.nextBits(i4);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array) {
            f0.p(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int i4) {
            return Random.defaultRandom.nextBytes(i4);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d4) {
            return Random.defaultRandom.nextDouble(d4);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i4) {
            return Random.defaultRandom.nextInt(i4);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j4) {
            return Random.defaultRandom.nextLong(j4);
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array, int i4, int i5) {
            f0.p(array, "array");
            return Random.defaultRandom.nextBytes(array, i4, i5);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d4, double d5) {
            return Random.defaultRandom.nextDouble(d4, d5);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i4, int i5) {
            return Random.defaultRandom.nextInt(i4, i5);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j4, long j5) {
            return Random.defaultRandom.nextLong(j4, j5);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i4, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                i4 = 0;
            }
            if ((i6 & 4) != 0) {
                i5 = bArr.length;
            }
            return random.nextBytes(bArr, i4, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i4);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "array"
            kotlin.jvm.internal.f0.p(r7, r0)
            r0 = 1
            r1 = 0
            if (r8 < 0) goto Le
            int r2 = r7.length
            if (r8 > r2) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1d
            if (r9 < 0) goto L18
            int r2 = r7.length
            if (r9 > r2) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.String r3 = "fromIndex ("
            if (r2 == 0) goto L8d
            if (r8 > r9) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L67
            int r0 = r9 - r8
            int r0 = r0 / 4
            r2 = 0
        L2d:
            if (r2 >= r0) goto L50
            int r2 = r2 + 1
            int r3 = r6.nextInt()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r8 + 1
            int r5 = r3 >>> 8
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 2
            int r5 = r3 >>> 16
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 3
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            r7[r4] = r3
            int r8 = r8 + 4
            goto L2d
        L50:
            int r9 = r9 - r8
            int r0 = r9 * 8
            int r0 = r6.nextBits(r0)
        L57:
            if (r1 >= r9) goto L66
            int r2 = r1 + 1
            int r3 = r8 + r1
            int r1 = r1 * 8
            int r1 = r0 >>> r1
            byte r1 = (byte) r1
            r7[r3] = r1
            r1 = r2
            goto L57
        L66:
            return r7
        L67:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L8d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r0.append(r7)
            r7 = 46
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            goto Lbd
        Lbc:
            throw r8
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextBytes(byte[], int, int):byte[]");
    }

    public double nextDouble() {
        return e.d(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d4) {
        return nextDouble(0.0d, d4);
    }

    public int nextInt(int i4) {
        return nextInt(0, i4);
    }

    public long nextLong(long j4) {
        return nextLong(0L, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.f.d(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L44
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L44
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L44
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            java.lang.Double.isNaN(r2)
            double r4 = r9 / r2
            java.lang.Double.isNaN(r2)
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L4b
        L44:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L4b:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L55
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L55:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public int nextInt(int i4, int i5) {
        int nextInt;
        int i6;
        int i7;
        int nextInt2;
        boolean z3;
        f.e(i4, i5);
        int i8 = i5 - i4;
        if (i8 > 0 || i8 == Integer.MIN_VALUE) {
            if (((-i8) & i8) == i8) {
                i7 = nextBits(f.g(i8));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i6 = nextInt % i8;
                } while ((nextInt - i6) + (i8 - 1) < 0);
                i7 = i6;
            }
            return i4 + i7;
        }
        do {
            nextInt2 = nextInt();
            z3 = false;
            if (i4 <= nextInt2 && nextInt2 < i5) {
                z3 = true;
                continue;
            }
        } while (!z3);
        return nextInt2;
    }

    public long nextLong(long j4, long j5) {
        long nextLong;
        boolean z3;
        long nextLong2;
        long j6;
        long j7;
        int nextInt;
        f.f(j4, j5);
        long j8 = j5 - j4;
        if (j8 <= 0) {
            do {
                nextLong = nextLong();
                z3 = false;
                if (j4 <= nextLong && nextLong < j5) {
                    z3 = true;
                    continue;
                }
            } while (!z3);
            return nextLong;
        }
        if (((-j8) & j8) == j8) {
            int i4 = (int) j8;
            int i5 = (int) (j8 >>> 32);
            if (i4 != 0) {
                nextInt = nextBits(f.g(i4));
            } else if (i5 == 1) {
                nextInt = nextInt();
            } else {
                j7 = (nextBits(f.g(i5)) << 32) + (nextInt() & 4294967295L);
            }
            j7 = nextInt & 4294967295L;
        } else {
            do {
                nextLong2 = nextLong() >>> 1;
                j6 = nextLong2 % j8;
            } while ((nextLong2 - j6) + (j8 - 1) < 0);
            j7 = j6;
        }
        return j4 + j7;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        f0.p(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @NotNull
    public byte[] nextBytes(int i4) {
        return nextBytes(new byte[i4]);
    }
}
