package com.ss.android.socialbase.appdownloader.f;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {
    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(com.ss.android.socialbase.downloader.gd.f.c(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (byte b4 : decode) {
            if (i4 >= length) {
                i4 %= length;
            }
            sb.append((char) (b4 ^ str2.charAt(i4)));
            i4++;
        }
        return sb.toString();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(com.ss.android.socialbase.downloader.gd.f.c(str), 0));
    }
}
