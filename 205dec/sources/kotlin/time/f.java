package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Duration.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\bE\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u0003*\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u001a)\u0010\u001c\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00130\u0019H\u0082\b\u001a)\u0010\u001d\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00130\u0019H\u0082\b\u001a\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002\u001a\u001a\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u001a\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010$\u001a\"\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0000H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*\u001a\u001a\u0010+\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010$\u001a\u001a\u0010,\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010$\"\u0014\u0010/\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u00102\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b0\u00101\"\u0014\u00104\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b3\u00101\"\u0014\u00106\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b5\u00101\"!\u0010;\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108\"!\u0010;\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b9\u0010=\u001a\u0004\b<\u0010$\"!\u0010;\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b9\u0010@\u001a\u0004\b>\u0010?\"!\u0010C\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bB\u0010:\u001a\u0004\bA\u00108\"!\u0010C\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bB\u0010=\u001a\u0004\bD\u0010$\"!\u0010C\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bB\u0010@\u001a\u0004\bE\u0010?\"!\u0010H\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bG\u0010:\u001a\u0004\bF\u00108\"!\u0010H\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bG\u0010=\u001a\u0004\bI\u0010$\"!\u0010H\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bG\u0010@\u001a\u0004\bJ\u0010?\"!\u0010M\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bL\u0010:\u001a\u0004\bK\u00108\"!\u0010M\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bL\u0010=\u001a\u0004\bN\u0010$\"!\u0010M\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bL\u0010@\u001a\u0004\bO\u0010?\"!\u0010R\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bQ\u0010:\u001a\u0004\bP\u00108\"!\u0010R\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bQ\u0010=\u001a\u0004\bS\u0010$\"!\u0010R\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bQ\u0010@\u001a\u0004\bT\u0010?\"!\u0010W\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bV\u0010:\u001a\u0004\bU\u00108\"!\u0010W\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bV\u0010=\u001a\u0004\bX\u0010$\"!\u0010W\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\bV\u0010@\u001a\u0004\bY\u0010?\"!\u0010\\\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b[\u0010:\u001a\u0004\bZ\u00108\"!\u0010\\\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b[\u0010=\u001a\u0004\b]\u0010$\"!\u0010\\\u001a\u00020\u0003*\u00020\t8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b[\u0010@\u001a\u0004\b^\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/d;", "m0", "(ILkotlin/time/DurationUnit;)J", "", "n0", "(JLkotlin/time/DurationUnit;)J", "", "l0", "(DLkotlin/time/DurationUnit;)J", "duration", "k0", "(IJ)J", "j0", "(DJ)J", "", "value", "", "strictIso", "f0", "(Ljava/lang/String;Z)J", "g0", "startIndex", "Lkotlin/Function1;", "", "predicate", "i0", "h0", "nanos", "e0", "millis", "d0", "normalNanos", "l", "(J)J", "normalMillis", "j", "normalValue", "unitDiscriminator", "i", "(JI)J", "m", "k", "a", "I", "NANOS_IN_MILLIS", "b", "J", "MAX_NANOS", "c", "MAX_MILLIS", "d", "MAX_NANOS_IN_MILLIS", "S", "(I)J", "getNanoseconds$annotations", "(I)V", "nanoseconds", "T", "(J)V", "R", "(D)J", "(D)V", "A", "getMicroseconds$annotations", "microseconds", "B", "z", "G", "getMilliseconds$annotations", "milliseconds", "H", "F", "Y", "getSeconds$annotations", "seconds", "Z", "X", "M", "getMinutes$annotations", "minutes", "N", "L", "u", "getHours$annotations", "hours", "v", "t", "o", "getDays$annotations", "days", "p", "n", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {

    /* renamed from: a */
    public static final int f59000a = 1000000;

    /* renamed from: b */
    public static final long f59001b = 4611686018426999999L;

    /* renamed from: c */
    public static final long f59002c = 4611686018427387903L;

    /* renamed from: d */
    private static final long f59003d = 4611686018426L;

    public static final long A(int i4) {
        return m0(i4, DurationUnit.MICROSECONDS);
    }

    public static final long B(long j4) {
        return n0(j4, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void C(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void D(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void E(long j4) {
    }

    public static final long F(double d4) {
        return l0(d4, DurationUnit.MILLISECONDS);
    }

    public static final long G(int i4) {
        return m0(i4, DurationUnit.MILLISECONDS);
    }

    public static final long H(long j4) {
        return n0(j4, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void I(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void J(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void K(long j4) {
    }

    public static final long L(double d4) {
        return l0(d4, DurationUnit.MINUTES);
    }

    public static final long M(int i4) {
        return m0(i4, DurationUnit.MINUTES);
    }

    public static final long N(long j4) {
        return n0(j4, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void O(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void P(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void Q(long j4) {
    }

    public static final long R(double d4) {
        return l0(d4, DurationUnit.NANOSECONDS);
    }

    public static final long S(int i4) {
        return m0(i4, DurationUnit.NANOSECONDS);
    }

    public static final long T(long j4) {
        return n0(j4, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void U(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void V(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void W(long j4) {
    }

    public static final long X(double d4) {
        return l0(d4, DurationUnit.SECONDS);
    }

    public static final long Y(int i4) {
        return m0(i4, DurationUnit.SECONDS);
    }

    public static final long Z(long j4) {
        return n0(j4, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void a0(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void b0(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void c0(long j4) {
    }

    public static final long d0(long j4) {
        return j4 * 1000000;
    }

    public static final long e0(long j4) {
        return j4 / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0092 A[LOOP:1: B:232:0x006c->B:247:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x009b A[EDGE_INSN: B:377:0x009b->B:249:0x009b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long f0(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.f.f0(java.lang.String, boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final long g0(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            char r5 = r7.charAt(r4)
            java.lang.String r6 = "+-"
            boolean r5 = kotlin.text.n.U2(r6, r5, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r0 = r0 - r5
            r6 = 16
            if (r0 <= r6) goto L6c
            kotlin.ranges.k r0 = new kotlin.ranges.k
            int r6 = kotlin.text.n.i3(r7)
            r0.<init>(r5, r6)
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L36
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L36
        L34:
            r0 = 1
            goto L59
        L36:
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            r5 = r0
            kotlin.collections.r0 r5 = (kotlin.collections.r0) r5
            int r5 = r5.nextInt()
            char r5 = r7.charAt(r5)
            r6 = 48
            if (r6 > r5) goto L55
            r6 = 58
            if (r5 >= r6) goto L55
            r5 = 1
            goto L56
        L55:
            r5 = 0
        L56:
            if (r5 != 0) goto L3a
            r0 = 0
        L59:
            if (r0 == 0) goto L6c
            char r7 = r7.charAt(r4)
            r0 = 45
            if (r7 != r0) goto L66
            r0 = -9223372036854775808
            goto L6b
        L66:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L6b:
            return r0
        L6c:
            java.lang.String r0 = "+"
            boolean r0 = kotlin.text.n.u2(r7, r0, r4, r2, r1)
            if (r0 == 0) goto L78
            java.lang.String r7 = kotlin.text.n.u6(r7, r3)
        L78:
            long r0 = java.lang.Long.parseLong(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.f.g0(java.lang.String):long");
    }

    private static final int h0(String str, int i4, d2.l<? super Character, Boolean> lVar) {
        while (i4 < str.length() && lVar.invoke(Character.valueOf(str.charAt(i4))).booleanValue()) {
            i4++;
        }
        return i4;
    }

    public static final long i(long j4, int i4) {
        return d.j((j4 << 1) + i4);
    }

    private static final String i0(String str, int i4, d2.l<? super Character, Boolean> lVar) {
        int i5 = i4;
        while (i5 < str.length() && lVar.invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
            i5++;
        }
        String substring = str.substring(i4, i5);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final long j(long j4) {
        return d.j((j4 << 1) + 1);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    private static final long j0(double d4, long j4) {
        return d.j0(j4, d4);
    }

    public static final long k(long j4) {
        long D;
        boolean z3 = false;
        if (-4611686018426L <= j4 && j4 < 4611686018427L) {
            z3 = true;
        }
        if (z3) {
            return l(d0(j4));
        }
        D = kotlin.ranges.q.D(j4, -4611686018427387903L, 4611686018427387903L);
        return j(D);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    private static final long k0(int i4, long j4) {
        return d.k0(j4, i4);
    }

    public static final long l(long j4) {
        return d.j(j4 << 1);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long l0(double d4, @NotNull DurationUnit unit) {
        long K0;
        long K02;
        f0.p(unit, "unit");
        double a4 = h.a(d4, unit, DurationUnit.NANOSECONDS);
        boolean z3 = true;
        if (!Double.isNaN(a4)) {
            K0 = kotlin.math.d.K0(a4);
            if ((-4611686018426999999L > K0 || K0 >= 4611686018427000000L) ? false : false) {
                return l(K0);
            }
            K02 = kotlin.math.d.K0(h.a(d4, unit, DurationUnit.MILLISECONDS));
            return k(K02);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long m(long j4) {
        boolean z3 = false;
        if (-4611686018426999999L <= j4 && j4 < 4611686018427000000L) {
            z3 = true;
        }
        if (z3) {
            return l(j4);
        }
        return j(e0(j4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long m0(int i4, @NotNull DurationUnit unit) {
        f0.p(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return l(h.c(i4, unit, DurationUnit.NANOSECONDS));
        }
        return n0(i4, unit);
    }

    public static final long n(double d4) {
        return l0(d4, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long n0(long j4, @NotNull DurationUnit unit) {
        long D;
        f0.p(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long c4 = h.c(4611686018426999999L, durationUnit, unit);
        boolean z3 = false;
        if ((-c4) <= j4 && j4 <= c4) {
            z3 = true;
        }
        if (z3) {
            return l(h.c(j4, unit, durationUnit));
        }
        D = kotlin.ranges.q.D(h.b(j4, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L);
        return j(D);
    }

    public static final long o(int i4) {
        return m0(i4, DurationUnit.DAYS);
    }

    public static final long p(long j4) {
        return n0(j4, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void q(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void r(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void s(long j4) {
    }

    public static final long t(double d4) {
        return l0(d4, DurationUnit.HOURS);
    }

    public static final long u(int i4) {
        return m0(i4, DurationUnit.HOURS);
    }

    public static final long v(long j4) {
        return n0(j4, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void w(double d4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void x(int i4) {
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void y(long j4) {
    }

    public static final long z(double d4) {
        return l0(d4, DurationUnit.MICROSECONDS);
    }
}
