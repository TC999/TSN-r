package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.TimeUnit;
import kotlin.Annotations;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.math.C14376d;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: Duration.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\bD\u001a\"\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\b\u001a\u00020\u0004*\u00020\u00072\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\"\u0010\u000b\u001a\u00020\u0004*\u00020\n2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u0004*\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a)\u0010\u001d\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001e\u001a\u00020\u0000*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002\u001a\u001a\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u001a\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010%\u001a\"\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0000H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001a\u0010,\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010%\u001a\u001a\u0010-\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010%\"\u0014\u00100\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b.\u0010/\"\u0014\u00103\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b1\u00102\"\u0014\u00105\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b4\u00102\"\u0014\u00107\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00102\"!\u0010<\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010;\u001a\u0004\b8\u00109\"!\u0010<\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010>\u001a\u0004\b=\u0010%\"!\u0010<\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010A\u001a\u0004\b?\u0010@\"!\u0010D\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bC\u0010;\u001a\u0004\bB\u00109\"!\u0010D\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bC\u0010>\u001a\u0004\bE\u0010%\"!\u0010D\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bC\u0010A\u001a\u0004\bF\u0010@\"!\u0010I\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bH\u0010;\u001a\u0004\bG\u00109\"!\u0010I\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bH\u0010>\u001a\u0004\b/\u0010%\"!\u0010I\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bH\u0010A\u001a\u0004\bJ\u0010@\"!\u0010M\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bL\u0010;\u001a\u0004\bK\u00109\"!\u0010M\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bL\u0010>\u001a\u0004\bN\u0010%\"!\u0010M\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bL\u0010A\u001a\u0004\bO\u0010@\"!\u0010R\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bQ\u0010;\u001a\u0004\bP\u00109\"!\u0010R\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bQ\u0010>\u001a\u0004\bS\u0010%\"!\u0010R\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bQ\u0010A\u001a\u0004\bT\u0010@\"!\u0010W\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bV\u0010;\u001a\u0004\bU\u00109\"!\u0010W\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bV\u0010>\u001a\u0004\bX\u0010%\"!\u0010W\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bV\u0010A\u001a\u0004\bY\u0010@\"!\u0010\\\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b[\u0010;\u001a\u0004\bZ\u00109\"!\u0010\\\u001a\u00020\u0004*\u00020\u00078FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b[\u0010>\u001a\u0004\b]\u0010%\"!\u0010\\\u001a\u00020\u0004*\u00020\n8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b[\u0010A\u001a\u0004\b^\u0010@\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006_"}, m12616d2 = {"", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/d;", "n0", "(ILjava/util/concurrent/TimeUnit;)J", "", "o0", "(JLjava/util/concurrent/TimeUnit;)J", "", "m0", "(DLjava/util/concurrent/TimeUnit;)J", "duration", "l0", "(IJ)J", "k0", "(DJ)J", "", DomainCampaignEx.LOOPBACK_VALUE, "", "strictIso", "g0", "(Ljava/lang/String;Z)J", "h0", "startIndex", "Lkotlin/Function1;", "", "predicate", "j0", "i0", "nanos", "f0", "millis", "e0", "normalNanos", "m", "(J)J", "normalMillis", "k", "normalValue", "unitDiscriminator", "j", "(JI)J", "n", C7304t.f25048d, "a", "I", "NANOS_IN_MILLIS", "b", "J", "MAX_NANOS", "c", "MAX_MILLIS", "d", "MAX_NANOS_IN_MILLIS", ExifInterface.GPS_DIRECTION_TRUE, "(I)J", "getNanoseconds$annotations", "(I)V", "nanoseconds", "U", "(J)V", ExifInterface.LATITUDE_SOUTH, "(D)J", "(D)V", "B", "getMicroseconds$annotations", "microseconds", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "getMilliseconds$annotations", "milliseconds", "G", "Z", "getSeconds$annotations", "seconds", "a0", "Y", "N", "getMinutes$annotations", "minutes", "O", "M", "v", "getHours$annotations", "hours", IAdInterListener.AdReqParam.WIDTH, "u", "p", "getDays$annotations", "days", CampaignEx.JSON_KEY_AD_Q, "o", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.time.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C14597e {

    /* renamed from: a */
    public static final int f41660a = 1000000;

    /* renamed from: b */
    public static final long f41661b = 4611686018426999999L;

    /* renamed from: c */
    public static final long f41662c = 4611686018427387903L;

    /* renamed from: d */
    private static final long f41663d = 4611686018426L;

    /* renamed from: A */
    public static final long m6068A(double d) {
        return m6017m0(d, TimeUnit.MICROSECONDS);
    }

    /* renamed from: B */
    public static final long m6067B(int i) {
        return m6015n0(i, TimeUnit.MICROSECONDS);
    }

    /* renamed from: C */
    public static final long m6066C(long j) {
        return m6013o0(j, TimeUnit.MICROSECONDS);
    }

    @Annotations(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: D */
    public static /* synthetic */ void m6065D(double d) {
    }

    @Annotations(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: E */
    public static /* synthetic */ void m6064E(int i) {
    }

    @Annotations(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: F */
    public static /* synthetic */ void m6063F(long j) {
    }

    /* renamed from: G */
    public static final long m6062G(double d) {
        return m6017m0(d, TimeUnit.MILLISECONDS);
    }

    /* renamed from: H */
    public static final long m6061H(int i) {
        return m6015n0(i, TimeUnit.MILLISECONDS);
    }

    /* renamed from: I */
    public static final long m6060I(long j) {
        return m6013o0(j, TimeUnit.MILLISECONDS);
    }

    @Annotations(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: J */
    public static /* synthetic */ void m6059J(double d) {
    }

    @Annotations(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: K */
    public static /* synthetic */ void m6058K(int i) {
    }

    @Annotations(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: L */
    public static /* synthetic */ void m6057L(long j) {
    }

    /* renamed from: M */
    public static final long m6056M(double d) {
        return m6017m0(d, TimeUnit.MINUTES);
    }

    /* renamed from: N */
    public static final long m6055N(int i) {
        return m6015n0(i, TimeUnit.MINUTES);
    }

    /* renamed from: O */
    public static final long m6054O(long j) {
        return m6013o0(j, TimeUnit.MINUTES);
    }

    @Annotations(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: P */
    public static /* synthetic */ void m6053P(double d) {
    }

    @Annotations(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: Q */
    public static /* synthetic */ void m6052Q(int i) {
    }

    @Annotations(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: R */
    public static /* synthetic */ void m6051R(long j) {
    }

    /* renamed from: S */
    public static final long m6050S(double d) {
        return m6017m0(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: T */
    public static final long m6049T(int i) {
        return m6015n0(i, TimeUnit.NANOSECONDS);
    }

    /* renamed from: U */
    public static final long m6048U(long j) {
        return m6013o0(j, TimeUnit.NANOSECONDS);
    }

    @Annotations(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: V */
    public static /* synthetic */ void m6047V(double d) {
    }

    @Annotations(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: W */
    public static /* synthetic */ void m6046W(int i) {
    }

    @Annotations(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: X */
    public static /* synthetic */ void m6045X(long j) {
    }

    /* renamed from: Y */
    public static final long m6044Y(double d) {
        return m6017m0(d, TimeUnit.SECONDS);
    }

    /* renamed from: Z */
    public static final long m6043Z(int i) {
        return m6015n0(i, TimeUnit.SECONDS);
    }

    /* renamed from: a0 */
    public static final long m6041a0(long j) {
        return m6013o0(j, TimeUnit.SECONDS);
    }

    @Annotations(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: b0 */
    public static /* synthetic */ void m6039b0(double d) {
    }

    @Annotations(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: c0 */
    public static /* synthetic */ void m6037c0(int i) {
    }

    @Annotations(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: d0 */
    public static /* synthetic */ void m6035d0(long j) {
    }

    /* renamed from: e0 */
    public static final long m6033e0(long j) {
        return j * 1000000;
    }

    /* renamed from: f0 */
    public static final long m6031f0(long j) {
        return j / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:208:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0089 A[LOOP:1: B:223:0x0069->B:235:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0092 A[EDGE_INSN: B:361:0x0092->B:237:0x0092 ?: BREAK  , SYNTHETIC] */
    @kotlin.time.ExperimentalTime
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m6029g0(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.C14597e.m6029g0(java.lang.String, boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0075  */
    /* renamed from: h0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final long m6027h0(java.lang.String r8) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            char r5 = r8.charAt(r4)
            java.lang.String r6 = "+-"
            boolean r5 = kotlin.text.C14573n.m6768U2(r6, r5, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r0 = r0 - r5
            r6 = 16
            if (r0 <= r6) goto L6d
            kotlin.ranges.k r0 = new kotlin.ranges.k
            int r6 = kotlin.text.C14573n.m6757i3(r8)
            r0.<init>(r5, r6)
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L36
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L36
        L34:
            r0 = 1
            goto L5a
        L36:
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            r5 = r0
            kotlin.collections.q0 r5 = (kotlin.collections.AbstractC14213q0) r5
            int r5 = r5.nextInt()
            r6 = 57
            r7 = 48
            char r5 = r8.charAt(r5)
            if (r7 <= r5) goto L52
            goto L56
        L52:
            if (r6 < r5) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = 0
        L57:
            if (r5 != 0) goto L3a
            r0 = 0
        L5a:
            if (r0 == 0) goto L6d
            char r8 = r8.charAt(r4)
            r0 = 45
            if (r8 != r0) goto L67
            r0 = -9223372036854775808
            goto L6c
        L67:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L6c:
            return r0
        L6d:
            java.lang.String r0 = "+"
            boolean r0 = kotlin.text.C14573n.m6739u2(r8, r0, r4, r2, r1)
            if (r0 == 0) goto L79
            java.lang.String r8 = kotlin.text.C14573n.m6738u6(r8, r3)
        L79:
            long r0 = java.lang.Long.parseLong(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.C14597e.m6027h0(java.lang.String):long");
    }

    /* renamed from: i0 */
    public static final int m6025i0(String str, int i, InterfaceC15280l<? super Character, Boolean> interfaceC15280l) {
        while (i < str.length() && interfaceC15280l.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    @ExperimentalTime
    /* renamed from: j */
    public static final long m6024j(long j, int i) {
        return Duration.m6133i((j << 1) + i);
    }

    /* renamed from: j0 */
    private static final String m6023j0(String str, int i, InterfaceC15280l<? super Character, Boolean> interfaceC15280l) {
        int i2 = i;
        while (i2 < str.length() && interfaceC15280l.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        String substring = str.substring(i, i2);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @ExperimentalTime
    /* renamed from: k */
    public static final long m6022k(long j) {
        return Duration.m6133i((j << 1) + 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: k0 */
    private static final long m6021k0(double d, long j) {
        return Duration.m6126l0(j, d);
    }

    @ExperimentalTime
    /* renamed from: l */
    public static final long m6020l(long j) {
        long m7561D;
        if (-4611686018426L <= j && f41663d >= j) {
            return m6018m(m6033e0(j));
        }
        m7561D = _Ranges.m7561D(j, -4611686018427387903L, f41662c);
        return m6022k(m7561D);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: l0 */
    private static final long m6019l0(int i, long j) {
        return Duration.m6124m0(j, i);
    }

    @ExperimentalTime
    /* renamed from: m */
    public static final long m6018m(long j) {
        return Duration.m6133i(j << 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: m0 */
    public static final long m6017m0(double d, @NotNull TimeUnit unit) {
        long m7910I0;
        long m7910I02;
        C14342f0.m8184p(unit, "unit");
        double m6000b = DurationUnitJvm.m6000b(d, unit, TimeUnit.NANOSECONDS);
        if (!Double.isNaN(m6000b)) {
            m7910I0 = C14376d.m7910I0(m6000b);
            if (-4611686018426999999L <= m7910I0 && f41661b >= m7910I0) {
                return m6018m(m7910I0);
            }
            m7910I02 = C14376d.m7910I0(DurationUnitJvm.m6000b(d, unit, TimeUnit.MILLISECONDS));
            return m6020l(m7910I02);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    @ExperimentalTime
    /* renamed from: n */
    public static final long m6016n(long j) {
        if (-4611686018426999999L <= j && f41661b >= j) {
            return m6018m(j);
        }
        return m6022k(m6031f0(j));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: n0 */
    public static final long m6015n0(int i, @NotNull TimeUnit unit) {
        C14342f0.m8184p(unit, "unit");
        if (unit.compareTo(TimeUnit.SECONDS) <= 0) {
            return m6018m(DurationUnitJvm.m5998d(i, unit, TimeUnit.NANOSECONDS));
        }
        return m6013o0(i, unit);
    }

    /* renamed from: o */
    public static final long m6014o(double d) {
        return m6017m0(d, TimeUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: o0 */
    public static final long m6013o0(long j, @NotNull TimeUnit unit) {
        long m7561D;
        C14342f0.m8184p(unit, "unit");
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long m5998d = DurationUnitJvm.m5998d(f41661b, timeUnit, unit);
        if ((-m5998d) <= j && m5998d >= j) {
            return m6018m(DurationUnitJvm.m5998d(j, unit, timeUnit));
        }
        m7561D = _Ranges.m7561D(DurationUnitJvm.m5999c(j, unit, TimeUnit.MILLISECONDS), -4611686018427387903L, f41662c);
        return m6022k(m7561D);
    }

    /* renamed from: p */
    public static final long m6012p(int i) {
        return m6015n0(i, TimeUnit.DAYS);
    }

    /* renamed from: q */
    public static final long m6011q(long j) {
        return m6013o0(j, TimeUnit.DAYS);
    }

    @Annotations(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: r */
    public static /* synthetic */ void m6010r(double d) {
    }

    @Annotations(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: s */
    public static /* synthetic */ void m6009s(int i) {
    }

    @Annotations(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: t */
    public static /* synthetic */ void m6008t(long j) {
    }

    /* renamed from: u */
    public static final long m6007u(double d) {
        return m6017m0(d, TimeUnit.HOURS);
    }

    /* renamed from: v */
    public static final long m6006v(int i) {
        return m6015n0(i, TimeUnit.HOURS);
    }

    /* renamed from: w */
    public static final long m6005w(long j) {
        return m6013o0(j, TimeUnit.HOURS);
    }

    @Annotations(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: x */
    public static /* synthetic */ void m6004x(double d) {
    }

    @Annotations(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: y */
    public static /* synthetic */ void m6003y(int i) {
    }

    @Annotations(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: z */
    public static /* synthetic */ void m6002z(long j) {
    }
}
