package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StringNumberConversions.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000H\u0000\u00a8\u0006\u0019"}, d2 = {"", "", "V0", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "W0", "(Ljava/lang/String;I)Ljava/lang/Byte;", "", "b1", "(Ljava/lang/String;)Ljava/lang/Short;", "c1", "(Ljava/lang/String;I)Ljava/lang/Short;", "X0", "(Ljava/lang/String;)Ljava/lang/Integer;", "Y0", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "Z0", "(Ljava/lang/String;)Ljava/lang/Long;", "a1", "(Ljava/lang/String;I)Ljava/lang/Long;", "input", "", "U0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class v extends u {
    @NotNull
    public static final Void U0(@NotNull String input) {
        f0.p(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte V0(@NotNull String str) {
        f0.p(str, "<this>");
        return W0(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte W0(@NotNull String str, int i4) {
        int intValue;
        f0.p(str, "<this>");
        Integer Y0 = Y0(str, i4);
        if (Y0 != null && (intValue = Y0.intValue()) >= -128 && intValue <= 127) {
            return Byte.valueOf((byte) intValue);
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer X0(@NotNull String str) {
        f0.p(str, "<this>");
        return Y0(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer Y0(@NotNull String str, int i4) {
        boolean z3;
        int i5;
        f0.p(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char charAt = str.charAt(0);
        int i7 = -2147483647;
        int i8 = 1;
        if (f0.t(charAt, 48) >= 0) {
            z3 = false;
            i8 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i7 = Integer.MIN_VALUE;
                z3 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z3 = false;
            }
        }
        int i9 = -59652323;
        while (i8 < length) {
            int i10 = i8 + 1;
            int b4 = b.b(str.charAt(i8), i4);
            if (b4 < 0) {
                return null;
            }
            if ((i6 < i9 && (i9 != -59652323 || i6 < (i9 = i7 / i4))) || (i5 = i6 * i4) < i7 + b4) {
                return null;
            }
            i6 = i5 - b4;
            i8 = i10;
        }
        return z3 ? Integer.valueOf(i6) : Integer.valueOf(-i6);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long Z0(@NotNull String str) {
        f0.p(str, "<this>");
        return a1(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long a1(@org.jetbrains.annotations.NotNull java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.f0.p(r0, r2)
            kotlin.text.a.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.f0.t(r5, r6)
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
            if (r4 >= r2) goto L74
            int r14 = r4 + 1
            char r4 = r0.charAt(r4)
            int r4 = kotlin.text.b.b(r4, r1)
            if (r4 >= 0) goto L51
            return r3
        L51:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L61
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L60
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L61
        L60:
            return r3
        L61:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r4 = (long) r4
            long r16 = r7 + r4
            int r6 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r6 >= 0) goto L6c
            return r3
        L6c:
            long r10 = r10 - r4
            r4 = r14
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L74:
            if (r9 == 0) goto L7b
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L80
        L7b:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.v.a1(java.lang.String, int):java.lang.Long");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short b1(@NotNull String str) {
        f0.p(str, "<this>");
        return c1(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short c1(@NotNull String str, int i4) {
        int intValue;
        f0.p(str, "<this>");
        Integer Y0 = Y0(str, i4);
        if (Y0 != null && (intValue = Y0.intValue()) >= -32768 && intValue <= 32767) {
            return Short.valueOf((short) intValue);
        }
        return null;
    }
}
