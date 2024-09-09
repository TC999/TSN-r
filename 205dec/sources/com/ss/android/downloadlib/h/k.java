package com.ss.android.downloadlib.h;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k {
    private static Map<String, ok> ok = Collections.synchronizedMap(new HashMap());

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok {
        void ok();

        void ok(String str);
    }

    public static boolean a(String str) {
        return com.ss.android.downloadlib.addownload.r.n().ok(com.ss.android.downloadlib.addownload.r.getContext(), str);
    }

    private static ok bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ok.remove(str);
    }

    public static void ok(String[] strArr, ok okVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        ok(valueOf, okVar);
        TTDelegateActivity.ok(valueOf, strArr);
    }

    public static void ok(String str) {
        ok bl;
        if (TextUtils.isEmpty(str) || (bl = bl(str)) == null) {
            return;
        }
        bl.ok();
    }

    public static void ok(String str, String str2) {
        ok bl;
        if (TextUtils.isEmpty(str) || (bl = bl(str)) == null) {
            return;
        }
        bl.ok(str2);
    }

    private static void ok(String str, ok okVar) {
        if (TextUtils.isEmpty(str) || okVar == null) {
            return;
        }
        ok.put(str, okVar);
    }
}
