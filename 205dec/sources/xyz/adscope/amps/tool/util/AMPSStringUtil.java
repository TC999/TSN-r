package xyz.adscope.amps.tool.util;

import java.security.MessageDigest;
import java.util.UUID;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSStringUtil {
    public static String createRequestId() {
        String uuid = UUID.randomUUID().toString();
        try {
            return md5(uuid);
        } catch (Exception e4) {
            e4.printStackTrace();
            return uuid;
        }
    }

    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (Exception e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            return "";
        }
    }
}
