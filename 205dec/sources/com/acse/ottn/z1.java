package com.acse.ottn;

import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class z1 {
    public static void a(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2);
    }

    public static void b(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, str2);
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

    public static void a(String str, String str2, IOException iOException) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2, iOException);
    }
}
