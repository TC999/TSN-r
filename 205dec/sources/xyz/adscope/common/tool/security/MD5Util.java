package xyz.adscope.common.tool.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MD5Util {
    public static String md5(String str) {
        StringBuilder sb;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i4));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append("e : ");
            sb.append(e);
            LogUtil.e(CommonConstants.TAG, sb.toString());
            return "";
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            sb = new StringBuilder();
            sb.append("e : ");
            sb.append(e);
            LogUtil.e(CommonConstants.TAG, sb.toString());
            return "";
        } catch (Exception e6) {
            e = e6;
            sb = new StringBuilder();
            sb.append("e : ");
            sb.append(e);
            LogUtil.e(CommonConstants.TAG, sb.toString());
            return "";
        }
    }
}
