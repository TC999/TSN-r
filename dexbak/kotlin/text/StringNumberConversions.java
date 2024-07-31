package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000H\u0000¨\u0006\u0019"}, m12616d2 = {"", "", "V0", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "W0", "(Ljava/lang/String;I)Ljava/lang/Byte;", "", "b1", "(Ljava/lang/String;)Ljava/lang/Short;", "c1", "(Ljava/lang/String;I)Ljava/lang/Short;", "X0", "(Ljava/lang/String;)Ljava/lang/Integer;", "Y0", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "Z0", "(Ljava/lang/String;)Ljava/lang/Long;", "a1", "(Ljava/lang/String;I)Ljava/lang/Long;", "input", "", "U0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class StringNumberConversions extends C14578u {
    @NotNull
    /* renamed from: U0 */
    public static final Void m6633U0(@NotNull String input) {
        C14342f0.m8184p(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: V0 */
    public static final Byte m6632V0(@NotNull String toByteOrNull) {
        C14342f0.m8184p(toByteOrNull, "$this$toByteOrNull");
        return m6631W0(toByteOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: W0 */
    public static final Byte m6631W0(@NotNull String toByteOrNull, int i) {
        int intValue;
        C14342f0.m8184p(toByteOrNull, "$this$toByteOrNull");
        Integer m6629Y0 = m6629Y0(toByteOrNull, i);
        if (m6629Y0 == null || (intValue = m6629Y0.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: X0 */
    public static Integer m6630X0(@NotNull String toIntOrNull) {
        C14342f0.m8184p(toIntOrNull, "$this$toIntOrNull");
        return m6629Y0(toIntOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: Y0 */
    public static final Integer m6629Y0(@NotNull String toIntOrNull, int i) {
        boolean z;
        int i2;
        C14342f0.m8184p(toIntOrNull, "$this$toIntOrNull");
        CharJVM.m6893a(i);
        int length = toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toIntOrNull.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (C14342f0.m8180t(charAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int m6892b = CharJVM.m6892b(toIntOrNull.charAt(i5), i);
            if (m6892b < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + m6892b) {
                return null;
            }
            i3 = i2 - m6892b;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: Z0 */
    public static Long m6628Z0(@NotNull String toLongOrNull) {
        C14342f0.m8184p(toLongOrNull, "$this$toLongOrNull");
        return m6627a1(toLongOrNull, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /* renamed from: a1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long m6627a1(@org.jetbrains.annotations.NotNull java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "$this$toLongOrNull"
            kotlin.jvm.internal.C14342f0.m8184p(r0, r2)
            kotlin.text.C14559a.m6897a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.C14342f0.m8180t(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r6 >= 0) goto L39
            if (r2 != r9) goto L2a
            return r3
        L2a:
            r6 = 45
            if (r5 != r6) goto L32
            r7 = -9223372036854775808
            r4 = 1
            goto L3a
        L32:
            r6 = 43
            if (r5 != r6) goto L38
            r4 = 1
            goto L39
        L38:
            return r3
        L39:
            r9 = 0
        L3a:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L42:
            if (r4 >= r2) goto L73
            char r14 = r0.charAt(r4)
            int r14 = kotlin.text.CharJVM.m6892b(r14, r1)
            if (r14 >= 0) goto L4f
            return r3
        L4f:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L5e
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
        L5e:
            return r3
        L5f:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L6a
            return r3
        L6a:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L73:
            if (r9 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L7f
        L7a:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringNumberConversions.m6627a1(java.lang.String, int):java.lang.Long");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: b1 */
    public static final Short m6626b1(@NotNull String toShortOrNull) {
        C14342f0.m8184p(toShortOrNull, "$this$toShortOrNull");
        return m6625c1(toShortOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: c1 */
    public static final Short m6625c1(@NotNull String toShortOrNull, int i) {
        int intValue;
        C14342f0.m8184p(toShortOrNull, "$this$toShortOrNull");
        Integer m6629Y0 = m6629Y0(toShortOrNull, i);
        if (m6629Y0 == null || (intValue = m6629Y0.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
