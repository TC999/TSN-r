package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DeviceUtils {
    /* renamed from: a */
    public static String m59223a() {
        return m59219a(true);
    }

    /* renamed from: a */
    private static String m59222a(int i) {
        return i != 120 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "ldpi";
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static String m59220a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
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

    /* renamed from: a */
    public static String m59219a(boolean z) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        boolean z2 = inetAddress instanceof Inet4Address;
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        if (z) {
                            if (z2) {
                                return upperCase;
                            }
                        } else if (!z2) {
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

    /* renamed from: a */
    public static JSONObject m59221a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", IdUtils.m59190e(context));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, IdUtils.m59201a(context));
            jSONObject.put("uuid", IdUtils.m59187h(context));
            jSONObject.put("ssid", IdUtils.m59188g(context));
            jSONObject.put("wifi_mac", IdUtils.m59186i(context));
            jSONObject.put("imsi", IdUtils.m59189f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", RomUtils.m59147k());
            jSONObject.put("sys_compiling_time", IdUtils.m59194b(context));
            jSONObject.put("type", m59215c(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", NetworkUtils.m59168c(context));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, m59216c());
            jSONObject.put("screen_width", UIUtils.getScreenWidth(context));
            jSONObject.put("screen_height", UIUtils.getScreenHeight(context));
            jSONObject.put("oaid", OAIDHelper.m59164a());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static String m59218b() {
        if (Build.VERSION.SDK_INT >= 21) {
            String languageTag = Locale.getDefault().toLanguageTag();
            return !TextUtils.isEmpty(languageTag) ? languageTag : "";
        }
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: b */
    public static JSONObject m59217b(Context context) {
        char c;
        loop0: while (true) {
            while (c != 'H') {
                c = c != 'J' ? 'H' : 'I';
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", IdUtils.m59190e(context));
            jSONObject.put("imei_md5", MD5.m59172a(IdUtils.m59190e(context)));
            Logger.m37562d("IdUtils.getImei(context)", "IdUtils.getImei(context)=" + IdUtils.m59190e(context));
            jSONObject.put("gaid", AdvertisingIdHelper.m59229c().m59235a());
            jSONObject.put("oaid", OAIDHelper.m59164a());
            jSONObject.put("applog_did", IdUtils.m59191d(context));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(PathCenter.f37685d, m59207i());
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, m59223a());
            jSONObject.put("package_name", ToolUtils.m59259a());
            jSONObject.put("publisher_did", SdkGlobalInfo.m59939B().m59896q());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, IdUtils.m59201a(context));
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static int m59215c(Context context) {
        if (m59211e(context)) {
            return 3;
        }
        return m59213d(context) ? 2 : 1;
    }

    /* renamed from: c */
    public static String m59216c() {
        String m59220a = m59220a("wlan0");
        if (TextUtils.isEmpty(m59220a)) {
            m59220a = m59220a("eth0");
        }
        return TextUtils.isEmpty(m59220a) ? "DU:MM:YA:DD:RE:SS" : m59220a;
    }

    /* renamed from: d */
    private static String m59214d() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (RomUtils.m59138t()) {
            str = "MIUI-";
        } else if (!RomUtils.m59141q()) {
            String m59152f = RomUtils.m59152f();
            if (RomUtils.m59154d(m59152f)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(m59152f)) {
                sb.append(m59152f);
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

    /* renamed from: d */
    public static boolean m59213d(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: e */
    private static int m59212e() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    /* renamed from: e */
    public static boolean m59211e(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static long m59210f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long parseLong = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]);
            bufferedReader.close();
            return parseLong * 1024;
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: g */
    public static long m59209g() {
        if (m59206j()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockSize() * statFs.getBlockCount();
        }
        return -1L;
    }

    /* renamed from: h */
    public static JSONObject m59208h() {
        JSONObject jSONObject = new JSONObject();
        Context m59945d = InternalContainer.m59945d();
        try {
            jSONObject.put("device_id", IdUtils.m59191d(InternalContainer.m59945d()));
            jSONObject.put("user_unique_id", IdUtils.m59191d(InternalContainer.m59945d()) != null ? IdUtils.m59191d(InternalContainer.m59945d()) : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", "2.9.2.1");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(UMCommonContent.f37867z, UIUtils.getScreenHeight(InternalContainer.m59945d()) + "x" + UIUtils.getScreenWidth(InternalContainer.m59945d()));
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put(UMCommonContent.f37756M, m59212e());
            jSONObject.put(UMCommonContent.f37760Q, NetworkUtils.m59167d(m59945d));
            jSONObject.put("openudid", IdUtils.m59201a(m59945d));
            jSONObject.put(CommonNetImpl.AID, "5685");
            jSONObject.put("display_name", AppInfo.m59227b());
            jSONObject.put("app_version", AppInfo.m59228a());
            jSONObject.put("package", ToolUtils.m59259a());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", m59214d());
            String str = Build.MANUFACTURER;
            jSONObject.put(UMCommonContent.f37751H, str);
            ArrayList<String> m59226a = AppSigning.m59226a(m59945d, "MD5");
            if (m59226a != null && !m59226a.isEmpty()) {
                jSONObject.put("sig_hash", str);
            }
            jSONObject.put("display_density", m59222a(UIUtils.getDensityDpi(m59945d)));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", UIUtils.getDensityDpi(m59945d));
            jSONObject.put(UMCommonContent.f37749F, Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", IdUtils.m59185j(m59945d));
            jSONObject.put("version_code", ToolUtils.m59253d());
            jSONObject.put("udid", IdUtils.m59190e(m59945d));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("imei_md5", MD5.m59172a(IdUtils.m59190e(InternalContainer.m59945d())));
            jSONObject2.put("gaid", AdvertisingIdHelper.m59229c().m59235a());
            jSONObject2.put("applog_did", IdUtils.m59191d(InternalContainer.m59945d()));
            jSONObject2.put("publisher_did", SdkGlobalInfo.m59939B().m59896q());
            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, IdUtils.m59201a(InternalContainer.m59945d()));
            jSONObject2.put("oaid", OAIDHelper.m59164a());
            jSONObject.put("custom", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: i */
    public static String m59207i() {
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
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            String substring2 = str.substring(i);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: j */
    public static boolean m59206j() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
