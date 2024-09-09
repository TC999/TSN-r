package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.UIUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: DeviceUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i {
    public static String a() {
        return a(true);
    }

    private static String a(int i4) {
        return i4 != 120 ? i4 != 240 ? i4 != 320 ? i4 != 480 ? i4 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "ldpi";
    }

    @SuppressLint({"NewApi"})
    private static String a(String str) {
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

    public static String a(boolean z3) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        boolean z4 = inetAddress instanceof Inet4Address;
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        if (z3) {
                            if (z4) {
                                return upperCase;
                            }
                        } else if (!z4) {
                            int indexOf = upperCase.indexOf(37);
                            return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", k.e(context));
            jSONObject.put("android_id", k.a(context));
            jSONObject.put("uuid", k.h(context));
            jSONObject.put("ssid", k.g(context));
            jSONObject.put("wifi_mac", k.i(context));
            jSONObject.put("imsi", k.f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", q.k());
            jSONObject.put("sys_compiling_time", k.b(context));
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", n.c(context));
            jSONObject.put("mac", c());
            jSONObject.put("screen_width", UIUtils.getScreenWidth(context));
            jSONObject.put("screen_height", UIUtils.getScreenHeight(context));
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, o.a());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String b() {
        if (Build.VERSION.SDK_INT >= 21) {
            String languageTag = Locale.getDefault().toLanguageTag();
            return !TextUtils.isEmpty(languageTag) ? languageTag : "";
        }
        return Locale.getDefault().getLanguage();
    }

    public static JSONObject b(Context context) {
        char c4;
        loop0: while (true) {
            while (c4 != 'H') {
                c4 = c4 != 'J' ? 'H' : 'I';
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", k.e(context));
            jSONObject.put("imei_md5", m.a(k.e(context)));
            Logger.d("IdUtils.getImei(context)", "IdUtils.getImei(context)=" + k.e(context));
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, f.c().a());
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, o.a());
            jSONObject.put("applog_did", k.d(context));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("ua", i());
            jSONObject.put("ip", a());
            jSONObject.put("package_name", b0.a());
            jSONObject.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().q());
            jSONObject.put("android_id", k.a(context));
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int c(Context context) {
        if (e(context)) {
            return 3;
        }
        return d(context) ? 2 : 1;
    }

    public static String c() {
        String a4 = a("wlan0");
        if (TextUtils.isEmpty(a4)) {
            a4 = a("eth0");
        }
        return TextUtils.isEmpty(a4) ? "DU:MM:YA:DD:RE:SS" : a4;
    }

    private static String d() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (q.t()) {
            str = "MIUI-";
        } else if (!q.q()) {
            String f4 = q.f();
            if (q.d(f4)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(f4)) {
                sb.append(f4);
                str = "-";
            }
            sb.append(Build.VERSION.INCREMENTAL);
            return sb.toString();
        } else {
            str = "FLYME-";
        }
        sb.append(str);
        sb.append(Build.VERSION.INCREMENTAL);
        return sb.toString();
    }

    public static boolean d(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int e() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static boolean e(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long parseLong = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]);
            bufferedReader.close();
            return parseLong * 1024;
        } catch (IOException e4) {
            e4.printStackTrace();
            return -1L;
        }
    }

    public static long g() {
        if (j()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockSize() * statFs.getBlockCount();
        }
        return -1L;
    }

    public static JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        Context d4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
        try {
            jSONObject.put("device_id", k.d(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()));
            jSONObject.put("user_unique_id", k.d(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()) != null ? k.d(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()) : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", "2.9.2.1");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("resolution", UIUtils.getScreenHeight(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()) + "x" + UIUtils.getScreenWidth(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()));
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("timezone", e());
            jSONObject.put("access", n.d(d4));
            jSONObject.put("openudid", k.a(d4));
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", g.b());
            jSONObject.put("app_version", g.a());
            jSONObject.put("package", b0.a());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", d());
            String str = Build.MANUFACTURER;
            jSONObject.put("device_manufacturer", str);
            ArrayList<String> a4 = h.a(d4, "MD5");
            if (a4 != null && !a4.isEmpty()) {
                jSONObject.put("sig_hash", str);
            }
            jSONObject.put("display_density", a(UIUtils.getDensityDpi(d4)));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", UIUtils.getDensityDpi(d4));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", k.j(d4));
            jSONObject.put("version_code", b0.d());
            jSONObject.put("udid", k.e(d4));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("imei_md5", m.a(k.e(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d())));
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, f.c().a());
            jSONObject2.put("applog_did", k.d(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()));
            jSONObject2.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().q());
            jSONObject2.put("android_id", k.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()));
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, o.a());
            jSONObject.put("custom", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String i() {
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

    public static boolean j() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
