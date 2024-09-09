package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f795a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static String a(byte[] bArr) {
        return a(bArr, f795a);
    }

    private static String a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int i6 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[i5] & 255) >> 2];
            int i7 = i6 + 1;
            int i8 = i5 + 1;
            bArr3[i6] = bArr2[((bArr[i5] & 3) << 4) | ((bArr[i8] & 255) >> 4)];
            int i9 = i7 + 1;
            int i10 = i5 + 2;
            bArr3[i7] = bArr2[((bArr[i8] & 15) << 2) | ((bArr[i10] & 255) >> 6)];
            i4 = i9 + 1;
            bArr3[i9] = bArr2[bArr[i10] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i11 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[length] & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i11] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i12] = 61;
            bArr3[i12 + 1] = 61;
        } else if (length2 == 2) {
            int i13 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[length] & 255) >> 2];
            int i14 = i13 + 1;
            int i15 = length + 1;
            bArr3[i13] = bArr2[((bArr[i15] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i14] = bArr2[(bArr[i15] & 15) << 2];
            bArr3[i14 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }
}
