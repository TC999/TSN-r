package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* compiled from: SimUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f673a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f674b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f675c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f676d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f677e = true;

    public static String a() {
        if (!f673a) {
            d();
        }
        return f674b;
    }

    public static String b() {
        try {
            if (!f673a) {
                d();
            }
            Configuration configuration = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d().getResources().getConfiguration();
            int i4 = configuration.mcc;
            String valueOf = i4 != 0 ? String.valueOf(i4) : f675c;
            Logger.e("MCC", "config=" + configuration.mcc + ",sMCC=" + f675c);
            if (f677e) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f677e ? "\u6709SIM\u5361" : "\u65e0SIM\u5361,MCC\u8fd4\u56denull");
            Logger.e("MCC", sb.toString());
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        if (!f673a) {
            d();
        }
        return f676d;
    }

    private static void d() {
        String str;
        String str2;
        String str3;
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() == null || f673a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d().getSystemService("phone");
            int simState = telephonyManager.getSimState();
            if (simState == 0) {
                f677e = false;
            } else if (simState == 1) {
                f677e = false;
            }
            Logger.e("MCC", f677e ? "\u6709SIM\u5361" : "\u65e0SIM\u5361");
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
                f674b = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                f675c = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                f676d = str3;
            }
        } catch (Throwable unused4) {
        }
        f673a = true;
    }
}
