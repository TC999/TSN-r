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
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.stub.StubApp;
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
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Utils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    static WifiManager f12047a;

    /* renamed from: b  reason: collision with root package name */
    private static int f12048b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f12049c;

    /* renamed from: d  reason: collision with root package name */
    private static String f12050d;

    public static String a(int i4) {
        if (i4 != 33) {
            switch (i4) {
                case 0:
                    return "success";
                case 1:
                    return "\u91cd\u8981\u53c2\u6570\u4e3a\u7a7a";
                case 2:
                    return "WIFI\u4fe1\u606f\u4e0d\u8db3";
                case 3:
                    return "\u8bf7\u6c42\u53c2\u6570\u83b7\u53d6\u51fa\u73b0\u5f02\u5e38";
                case 4:
                    return "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38";
                case 5:
                    return "\u89e3\u6790\u6570\u636e\u5f02\u5e38";
                case 6:
                    return "\u5b9a\u4f4d\u7ed3\u679c\u9519\u8bef";
                case 7:
                    return "KEY\u9519\u8bef";
                case 8:
                    return "\u5176\u4ed6\u9519\u8bef";
                case 9:
                    return "\u521d\u59cb\u5316\u5f02\u5e38";
                case 10:
                    return "\u5b9a\u4f4d\u670d\u52a1\u542f\u52a8\u5931\u8d25";
                case 11:
                    return "\u9519\u8bef\u7684\u57fa\u7ad9\u4fe1\u606f\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u63d2\u5165SIM\u5361";
                case 12:
                    return "\u7f3a\u5c11\u5b9a\u4f4d\u6743\u9650";
                case 13:
                    return "\u7f51\u7edc\u5b9a\u4f4d\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8bbe\u5907\u662f\u5426\u63d2\u5165sim\u5361\uff0c\u662f\u5426\u5f00\u542f\u79fb\u52a8\u7f51\u7edc\u6216\u5f00\u542f\u4e86wifi\u6a21\u5757";
                case 14:
                    return "GPS \u5b9a\u4f4d\u5931\u8d25\uff0c\u7531\u4e8e\u8bbe\u5907\u5f53\u524d GPS \u72b6\u6001\u5dee,\u5efa\u8bae\u6301\u8bbe\u5907\u5230\u76f8\u5bf9\u5f00\u9614\u7684\u9732\u5929\u573a\u6240\u518d\u6b21\u5c1d\u8bd5";
                case 15:
                    return "\u5f53\u524d\u8fd4\u56de\u4f4d\u7f6e\u4e3a\u6a21\u62df\u8f6f\u4ef6\u8fd4\u56de\uff0c\u8bf7\u5173\u95ed\u6a21\u62df\u8f6f\u4ef6\uff0c\u6216\u8005\u5728option\u4e2d\u8bbe\u7f6e\u5141\u8bb8\u6a21\u62df";
                default:
                    switch (i4) {
                        case 18:
                            return "\u5b9a\u4f4d\u5931\u8d25\uff0c\u98de\u884c\u6a21\u5f0f\u4e0b\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u8005\u6253\u5f00WIFI\u5f00\u5173";
                        case 19:
                            return "\u5b9a\u4f4d\u5931\u8d25\uff0c\u6ca1\u6709\u68c0\u67e5\u5230SIM\u5361\uff0c\u5e76\u4e14\u5173\u95ed\u4e86WIFI\u5f00\u5173\uff0c\u8bf7\u6253\u5f00WIFI\u5f00\u5173\u6216\u8005\u63d2\u5165SIM\u5361";
                        case 20:
                            return "\u6a21\u7cca\u5b9a\u4f4d\u5931\u8d25\uff0c\u5177\u4f53\u53ef\u67e5\u770b\u9519\u8bef\u4fe1\u606f/\u8be6\u7ec6\u4fe1\u606f\u63cf\u8ff0";
                        default:
                            return "\u5176\u4ed6\u9519\u8bef";
                    }
            }
        }
        return "\u8865\u507f\u5b9a\u4f4d\u5931\u8d25\uff0c\u672a\u547d\u4e2d\u7f13\u5b58";
    }

    public static boolean a(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar == null || "8".equals(aVar.d()) || "5".equals(aVar.d()) || "6".equals(aVar.d())) {
            return false;
        }
        return b(aVar);
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static int c() {
        int i4 = f12048b;
        if (i4 > 0) {
            return i4;
        }
        try {
            try {
                return f.b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return Integer.parseInt(f.a("android.os.Build$VERSION", "SDK").toString());
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private static boolean d(Context context, String str) throws Throwable {
        return ((Integer) f.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) f.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static String e() {
        try {
            return j4.f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean f(Context context) {
        int i4;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i4 = f.b(((Application) context).getBaseContext(), "checkSelfPermission", com.autonavi.aps.amapapi.b.E);
        } catch (Throwable unused) {
            i4 = 0;
        }
        return i4 == 0;
    }

    @SuppressLint({"NewApi"})
    public static boolean g(Context context) {
        boolean z3;
        if (context == null) {
            return true;
        }
        if (f12047a == null) {
            f12047a = (WifiManager) a(context, "wifi");
        }
        try {
            if (c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z3 = f12047a.isWifiEnabled();
            } else {
                b.a(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z3 = false;
            }
            try {
                d.b();
            } catch (Throwable unused) {
                d.c();
                return z3 ? z3 : z3;
            }
        } catch (Throwable unused2) {
            z3 = false;
        }
        if (z3 && c() > 17) {
            try {
                return "true".equals(String.valueOf(f.a(f12047a, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused3) {
                return z3;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String h(Context context) {
        NetworkInfo c4 = c(context);
        if (c4 == null || !c4.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c4.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type == 0) {
            String subtypeName = c4.getSubtypeName();
            switch (c4.getSubtype()) {
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
        return "UNKNOWN";
    }

    public static String i(Context context) {
        String I = i4.I();
        if (TextUtils.isEmpty(I) || I.equals("00:00:00:00:00:00")) {
            I = i.a(context);
        }
        return TextUtils.isEmpty(I) ? "00:00:00:00:00:00" : I;
    }

    public static boolean j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static String l(Context context) {
        if (f12050d == null) {
            f12050d = com.autonavi.aps.amapapi.security.a.a("MD5", e4.g(context));
        }
        return f12050d;
    }

    public static boolean m(Context context) {
        try {
            if (!p(context) && !o(context)) {
                if (!n(context)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean n(Context context) {
        return h("huawei") && q(context) && s(context);
    }

    private static boolean o(Context context) {
        return h("vivo") && q(context) && r(context);
    }

    private static boolean p(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 31 || context == null || context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                return false;
            }
            return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean q(Context context) {
        try {
            int i4 = Build.VERSION.SDK_INT;
            int i5 = context.getApplicationInfo().targetSdkVersion;
            return ((i4 == 30) && (i5 >= 23)) || ((i4 == 31) && (i5 <= 30 && i5 >= 23));
        } catch (Throwable unused) {
            d.b();
            return false;
        }
    }

    private static boolean r(Context context) {
        Cursor cursor;
        boolean z3 = false;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{context.getPackageName()}, null);
            boolean z4 = false;
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    } else if (cursor.getString(0) != null && cursor.getInt(1) == 1) {
                        z4 = true;
                    }
                } catch (Throwable unused) {
                    z3 = z4;
                    try {
                        d.b();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z3;
                    } catch (Throwable unused2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z3;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z4;
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    private static boolean s(Context context) {
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
                d.b();
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(b.f12014j)) {
            if (context == null) {
                return null;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(e4.g(context), 64);
            } catch (Throwable th) {
                b.a(th, "Utils", "getAppName part");
                packageInfo = null;
            }
            try {
                if (TextUtils.isEmpty(b.f12015k)) {
                    b.f12015k = null;
                }
            } catch (Throwable th2) {
                b.a(th2, "Utils", "getAppName");
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
            String g4 = e4.g(context);
            if (!TextUtils.isEmpty(g4)) {
                sb.append(",");
                sb.append(g4);
            }
            if (!TextUtils.isEmpty(b.f12015k)) {
                sb.append(",");
                sb.append(b.f12015k);
            }
            String sb2 = sb.toString();
            b.f12014j = sb2;
            return sb2;
        }
        return b.f12014j;
    }

    public static boolean e(Context context) {
        int i4;
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : com.autonavi.aps.amapapi.b.D) {
                try {
                    i4 = f.b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i4 = 0;
                }
                if (i4 == 0) {
                }
            }
            return true;
        }
        for (String str2 : com.autonavi.aps.amapapi.b.D) {
            if (context.checkCallingOrSelfPermission(str2) == 0) {
            }
        }
        return true;
        return false;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static NetworkInfo c(Context context) {
        try {
            return i4.O(context);
        } catch (Throwable th) {
            b.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static int f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i4;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i5 = 0;
            while (i5 < charArray.length && Character.isDigit(charArray[i5])) {
                i5++;
            }
            strArr2[1] = networkOperator.substring(3, i5 + 3);
        }
        try {
            i4 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            b.a(th, "Utils", "getMccMnc");
            i4 = 0;
        }
        if (i4 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = f12049c) != null) ? strArr : strArr2;
        }
        f12049c = strArr2;
        return strArr2;
    }

    public static double c(double d4) {
        double d5 = (long) (d4 * 100.0d);
        Double.isNaN(d5);
        return d5 / 100.0d;
    }

    public static double c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    private static FileOutputStream c(File file) throws IOException {
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

    public static boolean d(Context context) {
        try {
            NetworkInfo c4 = c(context);
            if (c4 != null) {
                if (c4.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean h(String str) {
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
            d.b();
            return false;
        }
    }

    public static float d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static byte g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static int e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static boolean c(Context context, String str) {
        boolean z3 = false;
        try {
            if (Build.VERSION.SDK_INT < 23 ? !(context == null || context.checkCallingOrSelfPermission(q4.u(str)) != 0) : !(context == null || context.checkSelfPermission(q4.u(str)) != 0)) {
                z3 = true;
            }
        } catch (Throwable unused) {
            d.b();
        }
        return z3;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (c() < 17) {
                return d(context, "android.provider.Settings$System");
            }
            return d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] b(int i4, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr[i5] = (byte) ((i4 >> (i5 * 8)) & 255);
        }
        return bArr;
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static double b(double d4) {
        double d5 = (long) (d4 * 1000000.0d);
        Double.isNaN(d5);
        return d5 / 1000000.0d;
    }

    public static int b(byte[] bArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < 2; i5++) {
            i4 |= (bArr[i5] & 255) << ((1 - i5) * 8);
        }
        return i4;
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i4 = 0; i4 < split.length; i4++) {
                if (split[i4].contains(",nb") || split[i4].contains(",access")) {
                    arrayList.add(split[i4]);
                }
            }
        }
        return arrayList;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(str);
        } catch (Throwable th) {
            b.a(th, "Utils", "getServ");
            return null;
        }
    }

    private static FileInputStream b(File file) throws IOException {
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

    public static byte[] a(byte[] bArr) {
        return q4.t(bArr);
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return q4.m(jSONObject, str);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static String a(ConnectivityManager connectivityManager) {
        int i4 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i4 = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused) {
            }
        }
        switch (i4) {
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

    public static byte[] a(long j4) {
        byte[] bArr = new byte[8];
        for (int i4 = 0; i4 < 8; i4++) {
            bArr[i4] = (byte) ((j4 >> (i4 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(int i4, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i4 & 255);
        bArr[1] = (byte) ((i4 & 65280) >> 8);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(long r4, java.lang.String r6) {
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
            com.autonavi.aps.amapapi.utils.b.a(r6, r1, r2)
            r1 = r0
        L20:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L2a
            long r4 = a()
        L2a:
            if (r1 != 0) goto L2f
            java.lang.String r4 = "NULL"
            return r4
        L2f:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.j.a(long, java.lang.String):java.lang.String");
    }

    public static double a(double d4) {
        return b(d4);
    }

    public static float a(float f4) {
        double d4 = f4;
        Double.isNaN(d4);
        double d5 = (long) (d4 * 100.0d);
        Double.isNaN(d5);
        return (float) (d5 / 100.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011 A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:12:0x0011, B:14:0x0017, B:19:0x0024, B:21:0x002e, B:23:0x0037), top: B:30:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.location.Location r7, int r8) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.j.a(android.location.Location, int):boolean");
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z3 = false;
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
                            z3 = true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z3;
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

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> b4 = b(str);
            String[] split = str2.toString().split("#");
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < split.length; i6++) {
                if (split[i6].contains(",nb") || split[i6].contains(",access")) {
                    i4++;
                    if (b4.contains(split[i6])) {
                        i5++;
                    }
                }
            }
            double size = b4.size() + i4;
            Double.isNaN(size);
            if (i5 * 2 >= size * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static List<String> a(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = b(file);
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
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = c(file);
                if (str != null) {
                    fileOutputStream.write(str.getBytes());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }
}
