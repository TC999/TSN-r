package com.ss.android.downloadlib.r;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, c> f48931c = Collections.synchronizedMap(new HashMap());

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c {
        void c();

        void c(String str);
    }

    public static void c(String[] strArr, c cVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        c(valueOf, cVar);
        TTDelegateActivity.c(valueOf, strArr);
    }

    public static boolean w(String str) {
        return com.ss.android.downloadlib.addownload.k.ux().c(com.ss.android.downloadlib.addownload.k.getContext(), str);
    }

    private static c xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f48931c.remove(str);
    }

    public static void c(String str) {
        c xv;
        if (TextUtils.isEmpty(str) || (xv = xv(str)) == null) {
            return;
        }
        xv.c();
    }

    public static void c(String str, String str2) {
        c xv;
        if (TextUtils.isEmpty(str) || (xv = xv(str)) == null) {
            return;
        }
        xv.c(str2);
    }

    private static void c(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        f48931c.put(str, cVar);
    }
}
