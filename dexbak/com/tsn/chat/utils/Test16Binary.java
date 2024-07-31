package com.tsn.chat.utils;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import kotlin.UByte;

/* renamed from: com.tsn.chat.utils.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Test16Binary {
    /* renamed from: a */
    public static int m14856a(byte[] bArr) {
        return (bArr[3] << BinaryMemcacheOpcodes.FLUSHQ) | (bArr[0] & UByte.f41242c) | ((bArr[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[2] << BinaryMemcacheOpcodes.FLUSHQ) >>> 8);
    }

    /* renamed from: b */
    public static short m14855b(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & UByte.f41242c)) << 8)) | ((short) (bArr[0] & UByte.f41242c)));
    }

    /* renamed from: c */
    public static String m14854c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        for (byte b : bArr) {
            i++;
            sb.append("0123456789abcdef".charAt((b >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b & 15));
            sb.append(" ");
            if (i == 8) {
                sb.append("  ");
            } else if (i == 16) {
                sb.append(ShellAdbUtils.f33810d);
                i = 0;
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static String m14853d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b & 15));
            sb.append("-");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    /* renamed from: e */
    public static String m14852e(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b & 15));
        }
        return sb.toString();
    }

    /* renamed from: f */
    public static byte[] m14851f(byte b) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return bArr;
    }

    /* renamed from: g */
    public static byte[] m14850g(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = m14846k(str.substring(i2, i3), str.substring(i3, i3 + 1));
        }
        return bArr;
    }

    /* renamed from: h */
    public static String m14849h(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i2]) * 16) + "0123456789ABCDEF".indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }

    /* renamed from: i */
    public static byte[] m14848i(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    /* renamed from: j */
    public static String m14847j(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = String.valueOf(str2) + Integer.toHexString(str.charAt(i));
        }
        return str2;
    }

    /* renamed from: k */
    private static byte m14846k(String str, String str2) {
        return (byte) (((byte) (Byte.decode("0x" + str).byteValue() << 4)) | Byte.decode("0x" + str2).byteValue());
    }
}
