package com.bytedance.msdk.f;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xk {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f28367c = false;
    private static String sr = null;
    private static boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    private static String f28368w;
    private static String xv;

    public static String c() {
        if (!f28367c) {
            sr();
        }
        return f28368w;
    }

    private static void sr() {
        TelephonyManager c4;
        String str;
        String str2;
        String str3;
        if (com.bytedance.msdk.core.c.getContext() == null || f28367c) {
            return;
        }
        try {
            c4 = y.c();
        } catch (Throwable unused) {
        }
        if (c4 == null) {
            return;
        }
        int simState = c4.getSimState();
        if (simState == 0) {
            ux = false;
        } else if (simState == 1) {
            ux = false;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("MCC", ux ? "\u6709SIM\u5361" : "\u65e0SIM\u5361");
        String str4 = null;
        try {
            str = c4.getSimOperatorName();
        } catch (Throwable unused2) {
            str = null;
        }
        try {
            str2 = c4.getNetworkOperator();
        } catch (Throwable unused3) {
            str2 = null;
        }
        if (str2 == null || str2.length() < 5) {
            try {
                str2 = c4.getSimOperator();
            } catch (Throwable unused4) {
            }
        }
        if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
            str3 = null;
        } else {
            str4 = str2.substring(0, 3);
            str3 = str2.substring(3);
        }
        if (!TextUtils.isEmpty(str)) {
            f28368w = str;
        }
        if (!TextUtils.isEmpty(str4)) {
            xv = str4;
        }
        if (!TextUtils.isEmpty(str3)) {
            sr = str3;
        }
        f28367c = true;
    }

    public static String w() {
        try {
            if (!f28367c) {
                sr();
            }
            Configuration configuration = com.bytedance.msdk.core.c.getContext().getResources().getConfiguration();
            int i4 = configuration.mcc;
            String valueOf = i4 != 0 ? String.valueOf(i4) : xv;
            com.bytedance.msdk.adapter.sr.xv.sr("MCC", "config=" + configuration.mcc + ",sMCC=" + xv);
            if (ux) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(ux ? "\u6709SIM\u5361" : "\u65e0SIM\u5361,MCC\u8fd4\u56denull");
            com.bytedance.msdk.adapter.sr.xv.sr("MCC", sb.toString());
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String xv() {
        if (!f28367c) {
            sr();
        }
        return sr;
    }
}
