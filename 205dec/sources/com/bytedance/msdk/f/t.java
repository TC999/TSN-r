package com.bytedance.msdk.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t {

    /* renamed from: c  reason: collision with root package name */
    private static String f28360c = null;
    private static String sr = null;
    private static long ux = -1;

    /* renamed from: w  reason: collision with root package name */
    private static long f28361w = -1;
    private static int xv = 1;

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (me.ux()) {
                sb.append("MIUI-");
            } else if (me.w()) {
                sb.append("FLYME-");
            } else {
                String t3 = me.t();
                if (me.c(t3)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(t3)) {
                    sb.append(t3);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String c() {
        if (ux == -1) {
            sr = gd();
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u83b7\u53d6mac\uff0c\u771f\u5b9e\u83b7\u53d6");
            return sr;
        } else if (SystemClock.elapsedRealtime() - ux > 1800000 && TextUtils.isEmpty(sr)) {
            sr = gd();
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u83b7\u53d6mac\uff0c\u771f\u5b9e\u83b7\u53d6");
            return sr;
        } else {
            return sr;
        }
    }

    private static String c(int i4) {
        return i4 != 120 ? i4 != 160 ? i4 != 240 ? i4 != 320 ? i4 != 480 ? i4 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static String ev() {
        if (Build.VERSION.SDK_INT >= 21) {
            String languageTag = Locale.getDefault().toLanguageTag();
            return !TextUtils.isEmpty(languageTag) ? languageTag : "";
        }
        return Locale.getDefault().getLanguage();
    }

    public static long f() {
        if (sr()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        }
        return -1L;
    }

    private static String gd() {
        ux = SystemClock.elapsedRealtime();
        String c4 = c("wlan0");
        if (TextUtils.isEmpty(c4)) {
            c4 = c("eth0");
        }
        return TextUtils.isEmpty(c4) ? "DU:MM:YA:DD:RE:SS" : c4;
    }

    private static int k() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private static String[] p() {
        String[] strArr = {"", ""};
        try {
            boolean z3 = false;
            boolean z4 = false;
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : c(networkInterface)) {
                    boolean z5 = inetAddress instanceof Inet4Address;
                    if (!z5 || !z3) {
                        if (z5 || !z4) {
                            if (c(z5, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    return strArr;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z5) {
                                        com.bytedance.sdk.openadsdk.core.xv.ux.c().gb(xv.c(hostAddress));
                                        strArr[0] = hostAddress;
                                        if (z4) {
                                            return strArr;
                                        }
                                        z3 = true;
                                    } else {
                                        int indexOf = hostAddress.indexOf(37);
                                        if (indexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, indexOf);
                                        }
                                        if (w(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.xv.ux.c().n(xv.c(hostAddress));
                                            strArr[1] = hostAddress;
                                            if (z3) {
                                                return strArr;
                                            }
                                            z4 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    public static JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.msdk.core.c.getContext();
        try {
            jSONObject.put("device_id", ls.c(com.bytedance.msdk.core.c.getContext()));
            jSONObject.put("user_unique_id", ls.c(com.bytedance.msdk.core.c.getContext()) != null ? ls.c(com.bytedance.msdk.core.c.getContext()) : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", com.bytedance.msdk.c.sr.w());
            jSONObject.put("plugin_version", com.bytedance.msdk.c.sr.sr());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("resolution", com.bytedance.msdk.adapter.sr.r.xv(com.bytedance.msdk.core.c.getContext()) + "x" + com.bytedance.msdk.adapter.sr.r.w(com.bytedance.msdk.core.c.getContext()));
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("timezone", k());
            jSONObject.put("access", com.bytedance.msdk.xv.ux.xv(context));
            jSONObject.put("openudid", ls.xv(context));
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", gd.w());
            jSONObject.put("app_version", gd.c());
            jSONObject.put("package", m.c());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", a());
            String str = Build.MANUFACTURER;
            jSONObject.put("device_manufacturer", str);
            ArrayList<String> c4 = p.c(context, "MD5");
            if (c4 != null && !c4.isEmpty()) {
                jSONObject.put("sig_hash", str);
            }
            jSONObject.put("display_density", c(com.bytedance.msdk.adapter.sr.r.ux(context)));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.bytedance.msdk.adapter.sr.r.ux(context));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", ls.gd(context));
            jSONObject.put("version_code", m.w());
            jSONObject.put("udid", ls.ux(context));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("imei", ls.ux(com.bytedance.msdk.core.c.getContext()));
            jSONObject2.put("imei_md5", n.c(ls.ux(com.bytedance.msdk.core.c.getContext())));
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, ev.c().w());
            jSONObject2.put("applog_did", ls.c(com.bytedance.msdk.core.c.getContext()));
            jSONObject2.put("publisher_did", com.bytedance.msdk.core.w.k().s());
            jSONObject2.put("android_id", ls.xv(com.bytedance.msdk.core.c.getContext()));
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, z.c());
            jSONObject.put("custom", jSONObject2);
            String w3 = w();
            if (TextUtils.isEmpty(w3)) {
                w3 = "127.0.0.1";
            } else if (w3.contains(",")) {
                w3 = xv(w3);
            }
            jSONObject.put("ip", w3);
        } catch (Exception e4) {
            com.bytedance.msdk.xv.w.w.c("getUploadEventV3Header", "exception: " + e4.toString());
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject sr(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", ls.ux(context));
            jSONObject.put("imei_md5", n.c(ls.ux(context)));
            com.bytedance.msdk.adapter.sr.xv.c("IdUtils.getImei(context)", "IdUtils.getImei(context)=" + ls.ux(context));
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, ev.c().w());
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, z.c());
            jSONObject.put("applog_did", ls.c(context));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("ua", xv());
            jSONObject.put("ip", w());
            jSONObject.put("package_name", m.c());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.w.k().s());
            jSONObject.put("android_id", ls.xv(context));
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject ux(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ls.ux(context));
            jSONObject.put("android_id", ls.xv(context));
            jSONObject.put("uuid", ls.sr(context));
            jSONObject.put("ssid", ls.r(context));
            jSONObject.put("wifi_mac", ls.ev(context));
            jSONObject.put("imsi", ls.f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", me.c());
            jSONObject.put("sys_compiling_time", ls.w(context));
            jSONObject.put("type", xv(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", ck.w(context));
            jSONObject.put("mac", c());
            jSONObject.put("screen_width", com.bytedance.msdk.adapter.sr.r.w(context));
            jSONObject.put("screen_height", com.bytedance.msdk.adapter.sr.r.xv(context));
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, z.c());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String w() {
        int i4;
        if (f28361w == -1) {
            f28360c = c(true);
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u83b7\u53d6ip\uff0c\u771f\u5b9e\u83b7\u53d6");
            return f28360c;
        } else if (SystemClock.elapsedRealtime() - f28361w > 1800000) {
            f28360c = c(true);
            xv = 0;
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u83b7\u53d6ip\uff0c\u5927\u4e8e30min\u4e86\uff0c\u771f\u5b9e\u83b7\u53d6");
            return f28360c;
        } else if (TextUtils.isEmpty(f28360c) && (i4 = xv) < 9) {
            xv = i4 + 1;
            f28360c = c(true);
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u83b7\u53d6ip\uff0c30min\u5185\uff0cip\u662f\u7a7a\uff0c\u91cd\u8bd5\u7b2c" + xv + "\u6b21\uff0c\u771f\u5b9e\u83b7\u53d6");
            return f28360c;
        } else {
            return f28360c;
        }
    }

    public static int xv(Context context) {
        if (w(context)) {
            return 3;
        }
        return c(context) ? 2 : 1;
    }

    public static String xv() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i4 = lastIndexOf + 1;
            String substring = str.substring(0, i4);
            String substring2 = str.substring(i4);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= '\u007f') {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    @SuppressLint({"NewApi"})
    private static String c(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i4])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String xv(String str) {
        String[] split = str.split(",");
        return (split == null || split.length <= 0 || TextUtils.isEmpty(split[0])) ? "127.0.0.1" : split[0].trim();
    }

    public static boolean sr() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static boolean w(boolean z3, InetAddress inetAddress, String[] strArr) {
        if (z3) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (z3 || TextUtils.isEmpty(strArr[1])) {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Field declaredField = cls.getDeclaredField("os");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
            method.setAccessible(true);
            Object invoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
            if (invoke == null) {
                return false;
            }
            String str = (String) invoke;
            if (str.startsWith("127")) {
                return true;
            }
            if (z3) {
                strArr[0] = str;
                return true;
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            if (w(str)) {
                strArr[1] = str;
                return true;
            }
            return true;
        }
        return true;
    }

    private static String c(boolean z3) {
        f28361w = SystemClock.elapsedRealtime();
        try {
            String[] p3 = p();
            if (z3) {
                return p3[0];
            }
            return p3[1];
        } catch (Exception unused) {
            return "";
        }
    }

    public static long ux() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long parseLong = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]);
            bufferedReader.close();
            return parseLong * 1024;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    private static List<InetAddress> c(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Object c4 = com.bytedance.sdk.openadsdk.core.eq.j.c(networkInterface, "java.net.NetworkInterface", "addresses", null);
                if (!(c4 instanceof List)) {
                    return Collections.list(networkInterface.getInetAddresses());
                }
                return (List) c4;
            }
            Object c5 = com.bytedance.sdk.openadsdk.core.eq.j.c(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(c5 instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) c5);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static String w(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i4 << 1;
            sb.append(Integer.toHexString(((bArr[i5] << 8) & 65280) | (bArr[i5 + 1] & 255)));
            if (i4 < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static boolean c(boolean z3, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z3) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (z3 || TextUtils.isEmpty(strArr[1])) {
            if (Build.VERSION.SDK_INT < 24) {
                return w(z3, inetAddress, strArr);
            }
            if (z3) {
                declaredField = InetAddress.class.getDeclaredField("holder");
            } else {
                declaredField = Inet6Address.class.getDeclaredField("holder6");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(inetAddress);
            Class<?> cls = obj.getClass();
            if (z3) {
                Field declaredField2 = cls.getDeclaredField("address");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
                byte[] bArr = {(byte) ((intValue >>> 24) & 255), (byte) ((intValue >>> 16) & 255), (byte) ((intValue >>> 8) & 255), (byte) (intValue & 255)};
                String c4 = c(bArr);
                if (bArr[0] != Byte.MAX_VALUE) {
                    strArr[0] = c4;
                }
            } else {
                Field declaredField3 = cls.getDeclaredField("ipaddress");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(obj);
                if (obj3 instanceof byte[]) {
                    String w3 = w((byte[]) obj3);
                    if (!w(w3)) {
                        return true;
                    }
                    strArr[1] = w3;
                }
            }
            return true;
        }
        return true;
    }

    private static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        if ((charAt == '2' || charAt == '3' || charAt == '5') && str.length() >= 2) {
            char charAt2 = str.charAt(1);
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 < 'a' || charAt2 > 'f') {
                    return charAt2 >= 'A' && charAt2 <= 'F';
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean w(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String c(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static boolean c(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }
}
