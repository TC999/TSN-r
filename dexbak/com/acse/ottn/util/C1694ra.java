package com.acse.ottn.util;

import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import java.io.IOException;

/* renamed from: com.acse.ottn.util.ra */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1694ra {
    /* renamed from: a */
    public static void m55917a(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2);
    }

    /* renamed from: a */
    public static void m55916a(String str, String str2, IOException iOException) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2, iOException);
    }

    /* renamed from: b */
    public static void m55915b(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        m55917a(str, str2);
    }

    /* renamed from: c */
    public static void m55914c(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2);
    }

    /* renamed from: d */
    public static void m55913d(String str, String str2) {
        if (!AcseHelpManager.mIsDebug || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.v(str, str2);
    }
}
