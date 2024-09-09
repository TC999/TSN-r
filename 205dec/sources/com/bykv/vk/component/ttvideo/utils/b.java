package com.bykv.vk.component.ttvideo.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Random;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {
    public static String a(String str) {
        String str2 = new String();
        if (str != null) {
            str2 = str2 + str;
        }
        Random random = new Random();
        return Base64.encodeToString(((str2 + random.nextInt()) + System.currentTimeMillis()).getBytes(), 2);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("T");
        }
        sb.append(Long.toString(System.currentTimeMillis()));
        sb.append("T");
        sb.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return sb.toString();
    }
}
