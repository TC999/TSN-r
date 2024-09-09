package cn.jiguang.cn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, 22, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr3[i4] = (byte) (bArr[i4] ^ bArr2[(bArr.length + i4) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }
}
