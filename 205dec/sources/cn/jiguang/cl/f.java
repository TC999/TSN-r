package cn.jiguang.cl;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            a(stringBuffer, b4);
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b4) {
        stringBuffer.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b4 & 15));
    }
}
