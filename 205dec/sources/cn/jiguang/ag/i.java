package cn.jiguang.ag;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f2207a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2208b = "";

    /* renamed from: c  reason: collision with root package name */
    private static int f2209c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static String f2210d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f2211e = "";

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("wifi".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("2g".equals(str)) {
            return 2;
        }
        if ("3g".equals(str)) {
            return 3;
        }
        if ("4g".equals(str)) {
            return 4;
        }
        return "5g".equals(str) ? 5 : 0;
    }

    public static String a(int i4) {
        cn.jiguang.w.a.a("TeleonyManagerUtils", "getRadioType - networkType:" + i4);
        String str = (i4 == 4 || i4 == 7 || i4 == 5 || i4 == 6 || i4 == 12 || i4 == 14) ? "cdma" : i4 == 13 ? "lte" : "gsm";
        cn.jiguang.w.a.a("TeleonyManagerUtils", "getRadioType - radioType:" + str);
        return str;
    }

    public static String a(Context context) {
        if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel) && cn.jiguang.ah.d.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (e.a("getNetworkType", 600000L)) {
                return f2208b;
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "unknown";
                }
                String typeName = activeNetworkInfo.getTypeName();
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (typeName == null) {
                    typeName = "unknown";
                } else if (!h.a(subtypeName)) {
                    typeName = typeName + "," + subtypeName;
                }
                f2208b = typeName.toLowerCase();
                cn.jiguang.w.a.b("TeleonyManagerUtils", "getNetworkType by api, value: " + f2208b);
                return f2208b;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("TeleonyManagerUtils", "getNetworkType failed, " + th.getMessage());
                return "unknown";
            }
        }
        return "";
    }

    public static String a(Context context, int i4) {
        String d4 = d(context);
        cn.jiguang.w.a.a("TeleonyManagerUtils", "getCurrentNetType - type:" + d4);
        if (TextUtils.isEmpty(d4) || TextUtils.equals(d4, "unknown")) {
            try {
                Object a4 = g.a((Class<?>) TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(i4)}, new Class[]{Integer.TYPE});
                if (((Integer) a4).intValue() == 0) {
                    d4 = "unknown";
                } else if (((Integer) a4).intValue() == 1) {
                    d4 = "2g";
                } else if (((Integer) a4).intValue() == 2) {
                    d4 = "3g";
                } else if (((Integer) a4).intValue() == 3) {
                    d4 = "4g";
                }
                cn.jiguang.w.a.b("TeleonyManagerUtils", "step2 - type:" + d4);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
            }
        }
        return TextUtils.isEmpty(d4) ? "unknown" : d4;
    }

    public static String a(Context context, boolean z3) {
        if ((z3 || cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsDownloadSource)) && cn.jiguang.ah.d.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (e.a("getNetworkOperator")) {
                return f2210d;
            }
            try {
                f2210d = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
                cn.jiguang.w.a.b("TeleonyManagerUtils", "getNetworkOperator by api");
            } catch (Throwable th) {
                cn.jiguang.w.a.f("TeleonyManagerUtils", "getNetworkOperator failed, " + th.getMessage());
            }
            return f2210d;
        }
        return "";
    }

    public static void a() {
        f2210d = "";
        f2207a = "";
        f2211e = "";
    }

    public static int b(Context context) {
        return a(d(context));
    }

    private static String b(int i4) {
        cn.jiguang.w.a.a("TeleonyManagerUtils", "getNetworkClass networkType:" + i4);
        switch (i4) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                switch (i4) {
                    case 16:
                        return "2g";
                    case 17:
                        return "3g";
                    case 18:
                    case 19:
                        return "4g";
                    case 20:
                        return "5g";
                    default:
                        return "unknown";
                }
        }
    }

    public static String b(Context context, boolean z3) {
        if ((z3 || cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsSpeedCoefficientValue)) && cn.jiguang.ah.d.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (e.a("getNetworkOperatorName")) {
                return f2211e;
            }
            try {
                f2211e = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
                cn.jiguang.w.a.b("TeleonyManagerUtils", "getNetworkOperatorName by api");
            } catch (Throwable th) {
                cn.jiguang.w.a.f("TeleonyManagerUtils", "getNetworkOperatorName failed, " + th.getMessage());
            }
            return f2211e;
        }
        return "";
    }

    public static int c(Context context) {
        try {
            if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                if (e.a("getIntNetworkType")) {
                    return f2209c;
                }
                f2209c = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                cn.jiguang.w.a.b("TeleonyManagerUtils", "getNetworkType int by api");
                return f2209c;
            }
            return 0;
        } catch (Throwable th) {
            Log.e("TeleonyManagerUtils", "getIntNetworkType failed: " + th.getMessage());
            return 0;
        }
    }

    public static String d(Context context) {
        String b4;
        String str = "unknown";
        if (cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel) && cn.jiguang.ah.d.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (e.a("getCurrentNetType")) {
                return f2207a;
            }
            if (context == null) {
                return "unknown";
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        b4 = "wifi";
                    } else if (activeNetworkInfo.getType() == 0) {
                        b4 = b(activeNetworkInfo.getSubtype());
                    }
                    str = b4;
                }
                cn.jiguang.w.a.b("TeleonyManagerUtils", "getCurrentNetType by api");
            } catch (Throwable th) {
                cn.jiguang.w.a.f("TeleonyManagerUtils", "getCurrentNetType failed, " + th.getMessage());
            }
            f2207a = str;
        }
        return str;
    }
}
