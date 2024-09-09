package com.acse.ottn.util;

import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class ra {
    public static void a(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2);
    }

    public static void a(String str, String str2, IOException iOException) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2, iOException);
    }

    public static void b(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, str2);
    }

    public static void c(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2);
    }

    public static void d(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.v(str, str2);
    }
}
