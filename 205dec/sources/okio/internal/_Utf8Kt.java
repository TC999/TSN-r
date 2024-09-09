package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: -Utf8.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String commonAsUtf8ToByteArray) {
        int i4;
        int i5;
        char charAt;
        f0.p(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i6 = 0;
        while (i6 < length) {
            char charAt2 = commonAsUtf8ToByteArray.charAt(i6);
            if (f0.t(charAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i7 = i6;
                while (i6 < length2) {
                    char charAt3 = commonAsUtf8ToByteArray.charAt(i6);
                    if (f0.t(charAt3, 128) < 0) {
                        int i8 = i7 + 1;
                        bArr[i7] = (byte) charAt3;
                        i6++;
                        while (i6 < length2 && f0.t(commonAsUtf8ToByteArray.charAt(i6), 128) < 0) {
                            bArr[i8] = (byte) commonAsUtf8ToByteArray.charAt(i6);
                            i6++;
                            i8++;
                        }
                        i7 = i8;
                    } else {
                        if (f0.t(charAt3, 2048) < 0) {
                            int i9 = i7 + 1;
                            bArr[i7] = (byte) ((charAt3 >> 6) | 192);
                            i4 = i9 + 1;
                            bArr[i9] = (byte) ((charAt3 & '?') | 128);
                        } else if ('\ud800' > charAt3 || '\udfff' < charAt3) {
                            int i10 = i7 + 1;
                            bArr[i7] = (byte) ((charAt3 >> '\f') | 224);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i4 = i11 + 1;
                            bArr[i11] = (byte) ((charAt3 & '?') | 128);
                        } else if (f0.t(charAt3, 56319) > 0 || length2 <= (i5 = i6 + 1) || '\udc00' > (charAt = commonAsUtf8ToByteArray.charAt(i5)) || '\udfff' < charAt) {
                            i4 = i7 + 1;
                            bArr[i7] = 63;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i5)) - 56613888;
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) ((charAt4 >> 18) | 240);
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i4 = i14 + 1;
                            bArr[i14] = (byte) ((charAt4 & 63) | 128);
                            i6 += 2;
                            i7 = i4;
                        }
                        i6++;
                        i7 = i4;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i7);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i6] = (byte) charAt2;
            i6++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        f0.o(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009d, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x011e, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L37;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = bArr.length;
        }
        return commonToUtf8String(bArr, i4, i5);
    }
}
