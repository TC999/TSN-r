package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.bytedance.msdk.adapter.util.Logger;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SimUtils {

    /* renamed from: a */
    private static boolean f680a = false;

    /* renamed from: b */
    private static String f681b = null;

    /* renamed from: c */
    private static String f682c = null;

    /* renamed from: d */
    private static String f683d = null;

    /* renamed from: e */
    private static boolean f684e = true;

    /* renamed from: a */
    public static String m59117a() {
        if (!f680a) {
            m59114d();
        }
        return f681b;
    }

    /* renamed from: b */
    public static String m59116b() {
        try {
            if (!f680a) {
                m59114d();
            }
            Configuration configuration = InternalContainer.m59945d().getResources().getConfiguration();
            int i = configuration.mcc;
            String valueOf = i != 0 ? String.valueOf(i) : f682c;
            Logger.m37557e("MCC", "config=" + configuration.mcc + ",sMCC=" + f682c);
            if (f684e) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f684e ? "有SIM卡" : "无SIM卡,MCC返回null");
            Logger.m37557e("MCC", sb.toString());
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static String m59115c() {
        if (!f680a) {
            m59114d();
        }
        return f683d;
    }

    /* renamed from: d */
    private static void m59114d() {
        String str;
        String str2;
        String str3;
        if (InternalContainer.m59945d() == null || f680a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) InternalContainer.m59945d().getSystemService("phone");
            int simState = telephonyManager.getSimState();
            if (simState == 0) {
                f684e = false;
            } else if (simState == 1) {
                f684e = false;
            }
            Logger.m37557e("MCC", f684e ? "有SIM卡" : "无SIM卡");
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                str4 = str2.substring(0, 3);
                str3 = str2.substring(3);
            }
            if (!TextUtils.isEmpty(str)) {
                f681b = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                f682c = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                f683d = str3;
            }
        } catch (Throwable unused4) {
        }
        f680a = true;
    }
}
