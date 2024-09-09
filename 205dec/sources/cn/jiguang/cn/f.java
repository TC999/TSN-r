package cn.jiguang.cn;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3480a = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, Byte.MAX_VALUE, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: b  reason: collision with root package name */
    private int[] f3481b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    private static int a(char c4) {
        return (byte) "0123456789abcdef".indexOf(c4);
    }

    private int a(int i4) {
        byte[] bArr = this.f3480a;
        return (bArr[i4 & 255] & 255) | ((bArr[(i4 >>> 24) & 255] & 255) << 24) | ((bArr[(i4 >>> 16) & 255] & 255) << 16) | ((bArr[(i4 >>> 8) & 255] & 255) << 8);
    }

    private int a(int i4, int i5) {
        return (i4 >>> (32 - i5)) | (i4 << i5);
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
        }
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = (byte) (a(charArray[i5 + 1]) | (a(charArray[i5]) << 4));
        }
        return bArr;
    }

    private int[] a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i4 * 4;
            iArr[i4] = (bArr[i5 + 3] & 255) | ((bArr[i5] & 255) << 24) | ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5 + 2] & 255) << 8);
        }
        return iArr;
    }

    private int b(int i4) {
        return a(i4, 24) ^ (((a(i4, 2) ^ i4) ^ a(i4, 10)) ^ a(i4, 18));
    }

    private static byte[] b(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i4 = 0; i4 < length; i4++) {
            copyOf[bArr.length + i4] = (byte) length;
        }
        return copyOf;
    }

    private int c(int i4) {
        return a(i4, 23) ^ (a(i4, 13) ^ i4);
    }

    private static byte[] c(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public void a(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] a4 = a(bArr);
        for (int i4 = 0; i4 < 32; i4 += 4) {
            a4[0] = a4[0] ^ b(a(((a4[1] ^ a4[2]) ^ a4[3]) ^ iArr[i4]));
            a4[1] = a4[1] ^ b(a(((a4[2] ^ a4[3]) ^ a4[0]) ^ iArr[i4 + 1]));
            a4[2] = a4[2] ^ b(a(((a4[3] ^ a4[0]) ^ a4[1]) ^ iArr[i4 + 2]));
            a4[3] = a4[3] ^ b(a(((a4[1] ^ a4[0]) ^ a4[2]) ^ iArr[i4 + 3]));
        }
        for (int i5 = 0; i5 < 16; i5 += 4) {
            int i6 = 3 - (i5 / 4);
            bArr2[i5] = (byte) ((a4[i6] >>> 24) & 255);
            bArr2[i5 + 1] = (byte) ((a4[i6] >>> 16) & 255);
            bArr2[i5 + 2] = (byte) ((a4[i6] >>> 8) & 255);
            bArr2[i5 + 3] = (byte) (a4[i6] & 255);
        }
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] a4 = a(str);
        String substring = str.substring(0, 16);
        cn.jiguang.bq.d.c("SM4", "seed=" + str);
        return a(bArr, a4, substring.getBytes("utf-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] b4 = b(bArr);
        int[] a4 = a(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[b4.length];
        int i4 = 0;
        while (true) {
            int i5 = i4 + 16;
            if (i5 > b4.length) {
                return bArr5;
            }
            System.arraycopy(b4, i4, bArr4, 0, 16);
            if (bArr3 != null) {
                a(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            a(bArr4, bArr3, a4);
            System.arraycopy(bArr3, 0, bArr5, i4, bArr3.length);
            i4 = i5;
        }
    }

    public int[] a(byte[] bArr, boolean z3) {
        int[] a4 = a(bArr);
        a4[0] = a4[0] ^ (-1548633402);
        a4[1] = a4[1] ^ 1453994832;
        a4[2] = a4[2] ^ 1736282519;
        a4[3] = a4[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i4 = 0; i4 < 32; i4 += 4) {
            int c4 = a4[0] ^ c(a(((a4[1] ^ a4[2]) ^ a4[3]) ^ this.f3481b[i4]));
            a4[0] = c4;
            iArr[i4] = c4;
            int i5 = i4 + 1;
            int c5 = a4[1] ^ c(a(((a4[2] ^ a4[3]) ^ a4[0]) ^ this.f3481b[i5]));
            a4[1] = c5;
            iArr[i5] = c5;
            int i6 = i4 + 2;
            int c6 = a4[2] ^ c(a(((a4[3] ^ a4[0]) ^ a4[1]) ^ this.f3481b[i6]));
            a4[2] = c6;
            iArr[i6] = c6;
            int i7 = i4 + 3;
            int c7 = a4[3] ^ c(a(((a4[0] ^ a4[1]) ^ a4[2]) ^ this.f3481b[i7]));
            a4[3] = c7;
            iArr[i7] = c7;
        }
        if (z3) {
            for (int i8 = 0; i8 < 16; i8++) {
                int i9 = iArr[i8];
                int i10 = 31 - i8;
                iArr[i8] = iArr[i10];
                iArr[i10] = i9;
            }
        }
        return iArr;
    }

    public byte[] b(byte[] bArr, String str) {
        return b(bArr, a(str), str.substring(0, 16).getBytes("utf-8"));
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] a4 = a(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i4 = 0;
        while (true) {
            int i5 = i4 + 16;
            if (i5 > bArr.length) {
                return c(bArr6);
            }
            System.arraycopy(bArr, i4, bArr4, 0, 16);
            a(bArr4, bArr5, a4);
            if (bArr3 != null) {
                a(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i4, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i4, 16);
            i4 = i5;
        }
    }
}
