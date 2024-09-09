package com.baidu.liantian.b;

/* compiled from: Base64.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f12112a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        byte b4;
        int i4;
        int length = bArr.length;
        int i5 = (length / 4) * 3;
        if (i5 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        while (true) {
            byte b5 = bArr[length - 1];
            b4 = 10;
            if (b5 != 10 && b5 != 13 && b5 != 32 && b5 != 9) {
                if (b5 != 61) {
                    break;
                }
                i6++;
            }
            length--;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 < length) {
            byte b6 = bArr[i7];
            if (b6 != b4 && b6 != 13 && b6 != 32 && b6 != 9) {
                if (b6 >= 65 && b6 <= 90) {
                    i4 = b6 - 65;
                } else if (b6 >= 97 && b6 <= 122) {
                    i4 = b6 - 71;
                } else if (b6 >= 48 && b6 <= 57) {
                    i4 = b6 + 4;
                } else if (b6 == 43) {
                    i4 = 62;
                } else if (b6 != 47) {
                    return null;
                } else {
                    i4 = 63;
                }
                i8 = (i8 << 6) | ((byte) i4);
                if (i10 % 4 == 3) {
                    int i11 = i9 + 1;
                    bArr2[i9] = (byte) ((i8 & 16711680) >> 16);
                    int i12 = i11 + 1;
                    bArr2[i11] = (byte) ((i8 & 65280) >> 8);
                    bArr2[i12] = (byte) (i8 & 255);
                    i9 = i12 + 1;
                }
                i10++;
            }
            i7++;
            b4 = 10;
        }
        if (i6 > 0) {
            int i13 = i8 << (i6 * 6);
            int i14 = i9 + 1;
            bArr2[i9] = (byte) ((i13 & 16711680) >> 16);
            if (i6 == 1) {
                i9 = i14 + 1;
                bArr2[i14] = (byte) ((i13 & 65280) >> 8);
            } else {
                i9 = i14;
            }
        }
        byte[] bArr3 = new byte[i9];
        System.arraycopy(bArr2, 0, bArr3, 0, i9);
        return bArr3;
    }
}
