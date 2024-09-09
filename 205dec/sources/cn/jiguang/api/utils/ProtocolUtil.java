package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.cl.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ProtocolUtil {
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String TAG = "ProtocolUtil";

    public static void fillIntData(byte[] bArr, int i4, int i5) {
        System.arraycopy(int2ByteArray(i4), 0, bArr, i5, 4);
    }

    public static void fillStringData(byte[] bArr, String str, int i4) {
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i4, bytes.length);
    }

    public static byte[] fixedStringToBytes(String str, int i4) {
        if (str == null || "".equals(str)) {
            return new byte[]{0, 0, 0, 0};
        }
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        if (bArr == null) {
            return new byte[]{0, 0, 0, 0};
        }
        byte[] defaultByte = getDefaultByte(i4);
        if (bArr.length <= i4) {
            i4 = bArr.length;
        }
        System.arraycopy(bArr, 0, defaultByte, 0, i4);
        return defaultByte;
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytes] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getBytesConsumed(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException unused) {
            d.c(TAG, "[getBytesConsumed] - ByteBuffer error.");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static byte[] getDefaultByte(int i4) {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[0] = 0;
        }
        return bArr;
    }

    public static String getString(ByteBuffer byteBuffer, int i4) {
        byte[] bArr = new byte[i4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer, JResponse jResponse) {
        int i4 = ByteBufferUtils.getShort(byteBuffer, jResponse);
        if (i4 < 0) {
            d.c(TAG, "[getTlv2] - ByteBuffer error.");
            return null;
        }
        byte[] bArr = new byte[i4];
        ByteBufferUtils.get(byteBuffer, bArr, jResponse);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] int2ByteArray(int i4) {
        return new byte[]{(byte) (i4 >>> 24), (byte) (i4 >>> 16), (byte) (i4 >>> 8), (byte) i4};
    }

    public static byte[] long2ByteArray(long j4) {
        return new byte[]{(byte) (j4 >>> 56), (byte) (j4 >>> 48), (byte) (j4 >>> 40), (byte) (j4 >>> 32), (byte) (j4 >>> 24), (byte) (j4 >>> 16), (byte) (j4 >>> 8), (byte) j4};
    }

    public static byte[] short2ByteArray(short s3) {
        return new byte[]{(byte) (s3 >>> 8), (byte) s3};
    }

    public static byte[] tlv2ToByteArray(String str) {
        if (str != null && !"".equals(str)) {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            if (bArr != null) {
                short length = (short) bArr.length;
                byte[] bArr2 = new byte[length + 2];
                System.arraycopy(short2ByteArray(length), 0, bArr2, 0, 2);
                System.arraycopy(bArr, 0, bArr2, 2, length);
                return bArr2;
            }
        }
        return new byte[]{0, 0};
    }
}
