package com.autonavi.aps.amapapi.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.DeviceInfo;
import com.amap.api.col.p0463l.Encrypt;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.security.C2422a;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.UByte;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* renamed from: com.autonavi.aps.amapapi.utils.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2432j {

    /* renamed from: a */
    static WifiManager f8409a;

    /* renamed from: b */
    private static int f8410b;

    /* renamed from: c */
    private static String[] f8411c;

    /* renamed from: d */
    private static String f8412d;

    /* renamed from: a */
    public static String m51208a(int i) {
        if (i != 33) {
            switch (i) {
                case 0:
                    return "success";
                case 1:
                    return "重要参数为空";
                case 2:
                    return "WIFI信息不足";
                case 3:
                    return "请求参数获取出现异常";
                case 4:
                    return "网络连接异常";
                case 5:
                    return "解析数据异常";
                case 6:
                    return "定位结果错误";
                case 7:
                    return "KEY错误";
                case 8:
                    return "其他错误";
                case 9:
                    return "初始化异常";
                case 10:
                    return "定位服务启动失败";
                case 11:
                    return "错误的基站信息，请检查是否插入SIM卡";
                case 12:
                    return "缺少定位权限";
                case 13:
                    return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
                case 14:
                    return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
                case 15:
                    return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
                default:
                    switch (i) {
                        case 18:
                            return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
                        case 19:
                            return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
                        case 20:
                            return "模糊定位失败，具体可查看错误信息/详细信息描述";
                        default:
                            return "其他错误";
                    }
            }
        }
        return "补偿定位失败，未命中缓存";
    }

    /* renamed from: a */
    public static boolean m51194a(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer == null || Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(aMapLocationServer.m51625d()) || "5".equals(aMapLocationServer.m51625d()) || "6".equals(aMapLocationServer.m51625d())) {
            return false;
        }
        return m51181b(aMapLocationServer);
    }

    /* renamed from: b */
    public static boolean m51181b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == Utils.DOUBLE_EPSILON && latitude == Utils.DOUBLE_EPSILON) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    /* renamed from: c */
    public static int m51177c() {
        int i = f8410b;
        if (i > 0) {
            return i;
        }
        try {
            try {
                return Reflect.m51257b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return Integer.parseInt(Reflect.m51260a("android.os.Build$VERSION", "SDK").toString());
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    /* renamed from: d */
    private static boolean m51169d(Context context, String str) throws Throwable {
        return ((Integer) Reflect.m51259a(str, "getInt", new Object[]{context.getContentResolver(), ((String) Reflect.m51260a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    /* renamed from: e */
    public static String m51167e() {
        try {
            return Encrypt.m54719f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static boolean m51164f(Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i = Reflect.m51258b(((Application) context).getBaseContext(), "checkSelfPermission", Aps.f7993E);
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: g */
    public static boolean m51162g(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (f8409a == null) {
            f8409a = (WifiManager) m51203a(context, "wifi");
        }
        try {
            if (m51174c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z = f8409a.isWifiEnabled();
            } else {
                C2428b.m51299a(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z = false;
            }
            try {
                DebugUtils.m51283b();
            } catch (Throwable unused) {
                DebugUtils.m51282c();
                return z ? z : z;
            }
        } catch (Throwable unused2) {
            z = false;
        }
        if (z && m51177c() > 17) {
            try {
                return "true".equals(String.valueOf(Reflect.m51261a(f8409a, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused3) {
                return z;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: h */
    public static String m51160h(Context context) {
        NetworkInfo m51175c = m51175c(context);
        if (m51175c == null || !m51175c.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = m51175c.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type == 0) {
            String subtypeName = m51175c.getSubtypeName();
            switch (m51175c.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    if (!"GSM".equalsIgnoreCase(subtypeName)) {
                        return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
                    }
                    break;
            }
            return "2G";
        }
        return Constants.APP_VERSION_UNKNOWN;
    }

    /* renamed from: i */
    public static String m51158i(Context context) {
        String m54813I = DeviceInfo.m54813I();
        if (TextUtils.isEmpty(m54813I) || m54813I.equals("00:00:00:00:00:00")) {
            m54813I = C2431i.m51223a(context);
        }
        return TextUtils.isEmpty(m54813I) ? "00:00:00:00:00:00" : m54813I;
    }

    /* renamed from: j */
    public static boolean m51157j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    /* renamed from: k */
    public static boolean m51156k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    /* renamed from: l */
    public static String m51155l(Context context) {
        if (f8412d == null) {
            f8412d = C2422a.m51455a("MD5", C1780e4.m55243g(context));
        }
        return f8412d;
    }

    /* renamed from: m */
    public static boolean m51154m(Context context) {
        try {
            if (!m51151p(context) && !m51152o(context)) {
                if (!m51153n(context)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            DebugUtils.m51283b();
            return false;
        }
    }

    /* renamed from: n */
    private static boolean m51153n(Context context) {
        return m51159h("huawei") && m51150q(context) && m51148s(context);
    }

    /* renamed from: o */
    private static boolean m51152o(Context context) {
        return m51159h("vivo") && m51150q(context) && m51149r(context);
    }

    /* renamed from: p */
    private static boolean m51151p(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 31 || context == null || context.checkSelfPermission(C7282g.f24949g) == 0) {
                return false;
            }
            return context.checkSelfPermission(C7282g.f24950h) == 0;
        } catch (Throwable unused) {
            DebugUtils.m51283b();
            return false;
        }
    }

    /* renamed from: q */
    private static boolean m51150q(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            int i2 = context.getApplicationInfo().targetSdkVersion;
            return ((i == 30) && (i2 >= 23)) || ((i == 31) && (i2 <= 30 && i2 >= 23));
        } catch (Throwable unused) {
            DebugUtils.m51283b();
            return false;
        }
    }

    /* renamed from: r */
    private static boolean m51149r(Context context) {
        Cursor cursor;
        boolean z = false;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{context.getPackageName()}, null);
            boolean z2 = false;
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    } else if (cursor.getString(0) != null && cursor.getInt(1) == 1) {
                        z2 = true;
                    }
                } catch (Throwable unused) {
                    z = z2;
                    try {
                        DebugUtils.m51283b();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    } catch (Throwable unused2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z2;
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    /* renamed from: s */
    private static boolean m51148s(Context context) {
        try {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context == null || context.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) {
                        return false;
                    }
                } else if (context == null || context.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                DebugUtils.m51283b();
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* renamed from: b */
    public static long m51186b() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public static String m51183b(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(C2428b.f8376j)) {
            if (context == null) {
                return null;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(C1780e4.m55243g(context), 64);
            } catch (Throwable th) {
                C2428b.m51299a(th, "Utils", "getAppName part");
                packageInfo = null;
            }
            try {
                if (TextUtils.isEmpty(C2428b.f8377k)) {
                    C2428b.f8377k = null;
                }
            } catch (Throwable th2) {
                C2428b.m51299a(th2, "Utils", "getAppName");
            }
            StringBuilder sb = new StringBuilder();
            if (packageInfo != null) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
                if (loadLabel != null) {
                    sb.append(loadLabel.toString());
                }
                if (!TextUtils.isEmpty(packageInfo.versionName)) {
                    sb.append(packageInfo.versionName);
                }
            }
            String m55243g = C1780e4.m55243g(context);
            if (!TextUtils.isEmpty(m55243g)) {
                sb.append(",");
                sb.append(m55243g);
            }
            if (!TextUtils.isEmpty(C2428b.f8377k)) {
                sb.append(",");
                sb.append(C2428b.f8377k);
            }
            String sb2 = sb.toString();
            C2428b.f8376j = sb2;
            return sb2;
        }
        return C2428b.f8376j;
    }

    /* renamed from: e */
    public static boolean m51166e(Context context) {
        int i;
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : Aps.f7992D) {
                try {
                    i = Reflect.m51258b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i == 0) {
                }
            }
            return true;
        }
        for (String str2 : Aps.f7992D) {
            if (context.checkCallingOrSelfPermission(str2) == 0) {
            }
        }
        return true;
        return false;
    }

    /* renamed from: a */
    public static boolean m51197a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return m51181b(aMapLocation);
        }
        return false;
    }

    /* renamed from: c */
    public static NetworkInfo m51175c(Context context) {
        try {
            return DeviceInfo.m54807O(context);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    /* renamed from: f */
    public static int m51163f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    /* renamed from: a */
    public static String[] m51198a(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f8411c) != null) ? strArr : strArr2;
        }
        f8411c = strArr2;
        return strArr2;
    }

    /* renamed from: c */
    public static double m51176c(double d) {
        double d2 = (long) (d * 100.0d);
        Double.isNaN(d2);
        return d2 / 100.0d;
    }

    /* renamed from: c */
    public static double m51172c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    /* renamed from: d */
    public static int m51171d() {
        return new Random().nextInt(65536) - 32768;
    }

    /* renamed from: c */
    private static FileOutputStream m51173c(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, false);
    }

    /* renamed from: d */
    public static boolean m51170d(Context context) {
        try {
            NetworkInfo m51175c = m51175c(context);
            if (m51175c != null) {
                if (m51175c.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: h */
    private static boolean m51159h(String str) {
        try {
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (!str2.equalsIgnoreCase(str)) {
                if (!str3.toLowerCase().contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            DebugUtils.m51283b();
            return false;
        }
    }

    /* renamed from: d */
    public static float m51168d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    /* renamed from: g */
    public static byte m51161g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    /* renamed from: e */
    public static int m51165e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    /* renamed from: c */
    public static boolean m51174c(Context context, String str) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 23 ? !(context == null || context.checkCallingOrSelfPermission(C1925p4.m54183u(str)) != 0) : !(context == null || context.checkSelfPermission(C1925p4.m54183u(str)) != 0)) {
                z = true;
            }
        } catch (Throwable unused) {
            DebugUtils.m51283b();
        }
        return z;
    }

    /* renamed from: a */
    public static long m51211a() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    public static boolean m51204a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (m51177c() < 17) {
                return m51169d(context, "android.provider.Settings$System");
            }
            return m51169d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static byte[] m51184b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static float m51187a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    /* renamed from: a */
    public static float m51196a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return m51187a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    /* renamed from: b */
    public static double m51185b(double d) {
        double d2 = (long) (d * 1000000.0d);
        Double.isNaN(d2);
        return d2 / 1000000.0d;
    }

    /* renamed from: b */
    public static int m51178b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & UByte.f41242c) << ((1 - i2) * 8);
        }
        return i;
    }

    /* renamed from: b */
    public static ArrayList<String> m51179b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static float m51195a(DPoint dPoint, DPoint dPoint2) {
        return m51187a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    /* renamed from: b */
    public static boolean m51182b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: a */
    public static Object m51203a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(str);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Utils", "getServ");
            return null;
        }
    }

    /* renamed from: b */
    private static FileInputStream m51180b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    /* renamed from: a */
    public static byte[] m51188a(byte[] bArr) {
        return C1925p4.m54184t(bArr);
    }

    /* renamed from: a */
    public static boolean m51189a(JSONObject jSONObject, String str) {
        return C1925p4.m54191m(jSONObject, str);
    }

    /* renamed from: a */
    public static boolean m51191a(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    /* renamed from: a */
    public static int m51199a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static String m51200a(ConnectivityManager connectivityManager) {
        int i = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    /* renamed from: a */
    public static byte[] m51206a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (i * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m51207a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m51205a(long r4, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L8
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
        L8:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L17
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L17
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L17
            r1.applyPattern(r6)     // Catch: java.lang.Throwable -> L14
            goto L20
        L14:
            r6 = move-exception
            r0 = r1
            goto L18
        L17:
            r6 = move-exception
        L18:
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r6, r1, r2)
            r1 = r0
        L20:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L2a
            long r4 = m51211a()
        L2a:
            if (r1 != 0) goto L2f
            java.lang.String r4 = "NULL"
            return r4
        L2f:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.C2432j.m51205a(long, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static double m51210a(double d) {
        return m51185b(d);
    }

    /* renamed from: a */
    public static float m51209a(float f) {
        double d = f;
        Double.isNaN(d);
        double d2 = (long) (d * 100.0d);
        Double.isNaN(d2);
        return (float) (d2 / 100.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011 A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:12:0x0011, B:14:0x0017, B:19:0x0024, B:21:0x002e, B:23:0x0037), top: B:30:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m51201a(android.location.Location r7, int r8) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L40
            r2 = 18
            if (r1 < r2) goto Lc
            boolean r1 = r7.isFromMockProvider()     // Catch: java.lang.Throwable -> Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            r2 = 1
            if (r1 == 0) goto L11
            return r2
        L11:
            android.os.Bundle r1 = r7.getExtras()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L1e
            java.lang.String r3 = "satellites"
            int r1 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L40
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 > 0) goto L22
            return r2
        L22:
            if (r8 != 0) goto L40
            double r3 = r7.getAltitude()     // Catch: java.lang.Throwable -> L40
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L40
            float r8 = r7.getBearing()     // Catch: java.lang.Throwable -> L40
            r1 = 0
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 != 0) goto L40
            float r7 = r7.getSpeed()     // Catch: java.lang.Throwable -> L40
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 != 0) goto L40
            return r2
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.C2432j.m51201a(android.location.Location, int):boolean");
    }

    /* renamed from: a */
    public static boolean m51202a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursor = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        if (cursor.getInt(0) > 0) {
                            z = true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                }
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m51190a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> m51179b = m51179b(str);
            String[] split = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (m51179b.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            double size = m51179b.size() + i;
            Double.isNaN(size);
            if (i2 * 2 >= size * 0.618d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static List<String> m51193a(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = m51180b(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (Throwable unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return arrayList;
                            }
                        }
                        bufferedReader2.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    inputStreamReader = null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m51192a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = m51173c(file);
                if (str != null) {
                    fileOutputStream.write(str.getBytes());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
