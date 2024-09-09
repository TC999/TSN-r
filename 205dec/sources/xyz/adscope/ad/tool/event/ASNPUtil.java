package xyz.adscope.ad.tool.event;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.UUID;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPUtil {
    private static final String TAG = "ASNPUtil";

    public static String createRequestId() {
        String uuid = UUID.randomUUID().toString();
        try {
            return md5(uuid);
        } catch (Exception e4) {
            e4.printStackTrace();
            return uuid;
        }
    }

    public static long getTimeMillisBeforeDay(int i4) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i4);
            return calendar.getTimeInMillis();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
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
            LogUtil.e(TAG, "e : " + e4);
            return "";
        }
    }

    public static void updateNetWorkConfig(String str) {
        if (Kalle.getConfig() != null) {
            Kalle.getConfig().getHeaders().set("Accept-Encrypt", str);
        }
    }
}
