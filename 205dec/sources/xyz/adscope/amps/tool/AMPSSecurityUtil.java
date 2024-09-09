package xyz.adscope.amps.tool;

import android.util.Base64;
import java.io.IOException;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.GzipUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSecurityUtil {
    public static String compressEncrypt(String str) {
        try {
            return Base64.encodeToString(AesUtil.encryptByte(GzipUtil.compress(str.getBytes())), 2);
        } catch (IOException e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            return "";
        }
    }

    public static String decryptUncompress(String str) {
        try {
            return new String(GzipUtil.uncompress(AesUtil.decryptByte(Base64.decode(str, 2))));
        } catch (IOException e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            return "";
        }
    }

    public static String processCompressEncrypt(String str, String str2) {
        byte[] bArr;
        String[] split;
        try {
            bArr = str.getBytes();
            split = str2.split(",");
        } catch (Exception e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            bArr = null;
        }
        if (split.length != 2) {
            return str;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        if (parseInt != -1 && parseInt == 101) {
            bArr = GzipUtil.compress(bArr);
        }
        if (parseInt2 == 1001) {
            bArr = AesUtil.encryptByte(bArr);
        }
        return Base64.encodeToString(bArr, 2);
    }

    public static String processUnCompressAndDecrypt(String str, String str2) {
        byte[] bArr;
        String[] split;
        try {
            bArr = Base64.decode(str, 2);
            split = str2.split(",");
        } catch (Exception e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            bArr = null;
        }
        if (split.length != 2) {
            return str;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        if (parseInt2 != -1 && parseInt2 == 1001) {
            bArr = AesUtil.decryptByte(bArr);
        }
        if (parseInt != -1 && parseInt == 101) {
            bArr = GzipUtil.uncompress(bArr);
        }
        return new String(bArr);
    }
}
