package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: -Base64.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\n"}, m12616d2 = {"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, m12615k = 2, m12614mv = {1, 4, 0})
@JvmName(name = "-Base64")
/* renamed from: okio.-Base64  reason: invalid class name */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Base64 {
    @NotNull
    private static final byte[] BASE64;
    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String decodeBase64ToArray) {
        int i;
        char charAt;
        C14342f0.m8184p(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((charAt = decodeBase64ToArray.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = decodeBase64ToArray.charAt(i6);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 != 1) {
            if (i9 == 2) {
                bArr[i5] = (byte) ((i4 << 12) >> 16);
                i5++;
            } else if (i9 == 3) {
                int i10 = i4 << 6;
                int i11 = i5 + 1;
                bArr[i5] = (byte) (i10 >> 16);
                i5 = i11 + 1;
                bArr[i11] = (byte) (i10 >> 8);
            }
            if (i5 == i2) {
                return bArr;
            }
            byte[] copyOf = Arrays.copyOf(bArr, i5);
            C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            return copyOf;
        }
        return null;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] encodeBase64, @NotNull byte[] map) {
        C14342f0.m8184p(encodeBase64, "$this$encodeBase64");
        C14342f0.m8184p(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = encodeBase64[i];
            int i4 = i3 + 1;
            byte b2 = encodeBase64[i3];
            int i5 = i4 + 1;
            byte b3 = encodeBase64[i4];
            int i6 = i2 + 1;
            bArr[i2] = map[(b & UByte.f41242c) >> 2];
            int i7 = i6 + 1;
            bArr[i6] = map[((b & 3) << 4) | ((b2 & UByte.f41242c) >> 4)];
            int i8 = i7 + 1;
            bArr[i7] = map[((b2 & 15) << 2) | ((b3 & UByte.f41242c) >> 6)];
            i2 = i8 + 1;
            bArr[i8] = map[b3 & Utf8.REPLACEMENT_BYTE];
            i = i5;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b4 = encodeBase64[i];
            int i9 = i2 + 1;
            bArr[i2] = map[(b4 & UByte.f41242c) >> 2];
            int i10 = i9 + 1;
            bArr[i9] = map[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr[i10] = b5;
            bArr[i10 + 1] = b5;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = encodeBase64[i];
            byte b7 = encodeBase64[i11];
            int i12 = i2 + 1;
            bArr[i2] = map[(b6 & UByte.f41242c) >> 2];
            int i13 = i12 + 1;
            bArr[i12] = map[((b6 & 3) << 4) | ((b7 & UByte.f41242c) >> 4)];
            bArr[i13] = map[(b7 & 15) << 2];
            bArr[i13 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
