package com.p521ss.android.socialbase.appdownloader.p543kf;

import android.text.TextUtils;
import android.util.Base64;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12315bl {
    /* renamed from: ok */
    public static String m18260ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(C12713kf.m16546ok(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b : decode) {
            if (i >= length) {
                i %= length;
            }
            sb.append((char) (b ^ str2.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    /* renamed from: ok */
    public static String m18261ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(C12713kf.m16546ok(str), 0));
    }
}
