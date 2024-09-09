package com.bytedance.sdk.component.panglearmor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.a;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SoftDecTool {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f29977a = false;
    public static volatile int acs = -1;

    /* renamed from: c  reason: collision with root package name */
    private static SharedPreferences f29978c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f29979f = false;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f29980h = false;
    public static volatile int has = -1;
    public static volatile float hav = -1.0f;

    /* renamed from: w  reason: collision with root package name */
    private static volatile int f29981w;

    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0088 -> B:79:0x00c1). Please submit an issue!!! */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.SoftDecTool.b():int");
    }

    @HungeonFlag
    public static native String b(int i4, Object[] objArr);

    public static native byte[] bc(int i4, byte[] bArr);

    @DungeonFlag
    private static String c(InputStream inputStream) {
        int i4;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i5 = b4 & 255;
                if (i5 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i5));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("UnsupportedEncodingException", e4);
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e6) {
            throw new RuntimeException("NoSuchAlgorithmException", e6);
        }
    }

    @DungeonFlag
    public static synchronized String cn(int i4, Object[] objArr) {
        synchronized (SoftDecTool.class) {
            if (ev.w()) {
                return b(i4, objArr);
            }
            return null;
        }
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences("softdec");
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong("t", System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(c(Build.BOARD, "ro.product.board"));
        sb.append(c(Build.MODEL, "ro.product.model"));
        sb.append(c(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(c(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(c(Build.DISPLAY, "ro.build.display.id"));
        long j4 = Build.TIME;
        long parseLong = Long.parseLong(f.c("ro.build.date.utc", "-1"));
        if (j4 != -1000 && parseLong != -1) {
            if (String.valueOf(j4).length() >= 10) {
                sb.append(Long.parseLong(String.valueOf(j4).substring(0, 10)) == parseLong ? 0 : 1);
            } else {
                sb.append(1);
            }
            sb.append(j4 != parseLong * 1000 ? 1 : 0);
        } else {
            sb.append("00");
        }
        return sb.toString();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return Settings.Secure.getString(f.ux().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fi() {
        try {
            return f.ux().getPackageManager().getPackageInfo(f.ux().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    @DungeonFlag
    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences("softdec");
        if (sharedPreferences != null) {
            long j4 = sharedPreferences.getLong("frt", 0L);
            if (j4 == 0) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                sharedPreferences.edit().putLong("frt", currentTimeMillis).apply();
                return currentTimeMillis;
            }
            return j4;
        }
        return 0L;
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences("softdec");
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j4 = sharedPreferences.getLong("t", 0L);
            if (j4 != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j4 <= 300000) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static JSONObject gdh() {
        List<Sensor> sensorList;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("softdec");
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || f.ux() == null || c(f.ux().getPackageManager().getPackageInfo(f.ux().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            SensorManager sensorManager = (SensorManager) f.ux().getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        treeSet.add(String.format(Locale.getDefault(), "%s###%s###%d", sensor.getName(), sensor.getVendor(), Integer.valueOf(sensor.getType())));
                    }
                }
            }
            String c4 = f.c("gsm.version.baseband", "");
            String c5 = f.c("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sensors", treeSet);
            jSONObject.put("radio", c4);
            jSONObject.put("fp", c5);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", f.c("ro.build.display.id", ""));
            jSONObject.put("build_id", f.c("ro.build.id", ""));
            jSONObject.put("incremental", f.c("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", f.c("ro.build.date.utc", ""));
            String c6 = c();
            if (!TextUtils.isEmpty(c6)) {
                jSONObject.put("fschara", c6);
            }
            JSONArray jSONArray = new JSONArray();
            if (Build.VERSION.SDK_INT <= 28) {
                jSONArray.put(c("/system/lib64/libc.so"));
            } else {
                jSONArray.put(c("/apex/com.android.runtime/lib64/bionic/libc.so"));
            }
            jSONArray.put(c("/system/lib64/libandroid_runtime.so"));
            jSONArray.put(c("/system/lib64/libandroid_servers.so"));
            jSONArray.put(c("/system/framework/arm64/boot.oat"));
            jSONArray.put(c("/system/framework/arm64/boot-ext.oat"));
            jSONArray.put(c("/system/framework/arm64/boot-framework.oat"));
            jSONArray.put(c("/system/framework/arm64/apex.oat"));
            jSONObject.put("hash", jSONArray);
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(String str) {
        if (f29978c == null) {
            try {
                Context ux = f.ux();
                if (ux != null && str != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        Context createDeviceProtectedStorageContext = ux.createDeviceProtectedStorageContext();
                        if (!createDeviceProtectedStorageContext.moveSharedPreferencesFrom(ux, str)) {
                            a.sr("HARLOG", "Failed to move shared preferences.");
                        }
                        ux = createDeviceProtectedStorageContext;
                    }
                    f29978c = com.bytedance.sdk.openadsdk.api.plugin.w.w(ux, str, 0);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return f29978c;
    }

    @DungeonFlag
    public static synchronized int h(String str, boolean z3) {
        synchronized (SoftDecTool.class) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences("softdec");
                int i4 = sharedPreferences.getInt(str, 0);
                if (z3) {
                    int i5 = i4 + 1;
                    sharedPreferences.edit().putInt(str, i5).apply();
                    return i5;
                }
                return i4;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
    }

    @DungeonFlag
    public static int hv() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) f.ux().getSystemService("connectivity");
                return !connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(15);
            } catch (Throwable unused) {
                return -1;
            }
        }
        return -1;
    }

    @DungeonFlag
    public static String i() {
        f29981w++;
        if (f29981w != 2) {
            return "2";
        }
        try {
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) f.ux().getSystemService("accessibility")).getInstalledAccessibilityServiceList()) {
                treeSet.add(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = getSharedPreferences("softdec");
            String jSONArray2 = jSONArray.toString();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String string = sharedPreferences.getString("iacba", "");
            String string2 = sharedPreferences.getString("date", "1970-01-01");
            if (string.equals(jSONArray.toString()) && format.equals(string2)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", jSONArray2).apply();
            sharedPreferences.edit().putString("date", format).apply();
            return jSONArray2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "-1";
        }
    }

    @DungeonFlag
    public static String kv() {
        return System.getProperty("os.version");
    }

    @DungeonFlag
    public static String p() {
        return com.bytedance.sdk.openadsdk.api.plugin.w.c(f.ux()).getPath();
    }

    @DungeonFlag
    public static String prx() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        return (TextUtils.isEmpty(property) && TextUtils.isEmpty(property2)) ? "" : String.format("%s:%s", property, property2);
    }

    @DungeonFlag
    public static String s() {
        PackageInfo packageInfo;
        try {
            packageInfo = f.ux().getPackageManager().getPackageInfo(f.ux().getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr.length > 0) {
                try {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(byteArray);
                    return c(messageDigest.digest());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "-1";
                }
            }
            return "-1";
        }
        return "-1";
    }

    @DungeonFlag
    public static long tft() {
        return f.r();
    }

    @DungeonFlag
    public static int trc() {
        return f.ev();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) f.ux().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (Integer.toHexString(bArr[i4] & 255).length() == 1) {
                sb.append("0");
                sb.append(Integer.toHexString(bArr[i4] & 255));
            } else {
                sb.append(Integer.toHexString(bArr[i4] & 255));
            }
            if (bArr.length - 1 != i4) {
                sb.append(":");
            }
        }
        return sb.toString().toUpperCase();
    }

    private static String c() {
        return cn(f.bk, new Object[0]);
    }

    private static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
                while (digestInputStream.read(new byte[8192]) != -1) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                int length = digest.length;
                for (int i4 = 0; i4 < length; i4++) {
                    sb.append(String.format("%02x", Byte.valueOf(digest[i4])));
                }
                String sb2 = sb.toString();
                digestInputStream.close();
                fileInputStream.close();
                return sb2;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static boolean c(long j4, long j5) {
        long j6 = j5 - j4;
        return j6 < 86400000 && j6 > -86400000 && c(j4) == c(j5);
    }

    private static long c(long j4) {
        return (j4 + TimeZone.getDefault().getOffset(j4)) / 86400000;
    }

    @DungeonFlag
    private static int c(String str, String str2) {
        String c4 = f.c(str2, "unknown");
        if (str.equals("unknown") || c4.equals("unknown")) {
            return 0;
        }
        return !str.equals(c4) ? 1 : 0;
    }
}
