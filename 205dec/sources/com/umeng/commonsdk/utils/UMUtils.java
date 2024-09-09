package com.umeng.commonsdk.utils;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.acse.ottn.f3;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import xyz.adscope.common.network.cookie.db.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SESSION_ID = "session_id";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static final String KEY_SHARED_PREFERENCES_NAME = au.b().b("ucc");
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static final String SP_FILE_NAME = au.b().b("usi");
    private static Object spLock = new Object();
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_LINK_VERSION = "";
    public static String VALUE_ABTEST_VERSION = "";
    public static String VALUE_ANTI_VERSION = "";
    private static volatile String sAppVersionName = "";
    private static volatile String sAppVersionCode = "";

    public static String MD5(String str) {
        try {
            if (str == null) {
                return null;
            }
            try {
                try {
                    byte[] bytes = str.getBytes();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    messageDigest.update(bytes);
                    byte[] digest = messageDigest.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i4 = 0; i4 < digest.length; i4++) {
                        stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i4])));
                    }
                    return stringBuffer.toString();
                } catch (Exception unused) {
                    return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
                }
            } catch (Exception e4) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "MD5 e is " + e4);
                }
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "MD5 e is " + th);
            }
            return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            String hexString = Integer.toHexString(bArr[i4]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i4 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getActivityInfo(new ComponentName(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("tencent" + str + ":"));
            List<ResolveInfo> queryIntentActivities = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Exception e4) {
                UMCrashManager.reportCrash(context, e4);
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier(str, str2, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String encryptBySHA1(String str) {
        try {
            try {
                byte[] bytes = str.getBytes();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(bytes);
                    return bytes2Hex(messageDigest.digest());
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "encrypt by SHA1 e is " + th);
                }
                return null;
            }
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "encrypt by SHA1 e is " + e4);
            }
            return null;
        }
    }

    public static String genId() {
        return "1234567890";
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        byte[] bArr = {10, 1, (byte) (bArr[0] + 1), 5, 4, (byte) (bArr[0] + bArr[3]), 7, 9, 23, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - bArr[7])};
        return bArr;
    }

    public static String[] getActiveUser(Context context) {
        return com.umeng.analytics.c.a(context);
    }

    public static String getApmFlag() {
        Method declaredMethod;
        try {
            Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", new Class[0])) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppMD5Signature(Context context) {
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                return !TextUtils.isEmpty(appMD5Signature) ? appMD5Signature.replace(":", "").toLowerCase() : appMD5Signature;
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getAppName(Context context) {
        return DeviceConfig.getAppName(context);
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo a4 = b.a().a(context, str, 64);
                if (a4 != null) {
                    return String.valueOf(a4.versionCode);
                }
            } catch (Exception e4) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + e4);
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + th);
                }
            }
        }
        return "";
    }

    public static String getAppVersionCode(Context context) {
        if (TextUtils.isEmpty(sAppVersionCode)) {
            if (context == null) {
                return "";
            }
            try {
                PackageInfo a4 = b.a().a(context, context.getPackageName(), 64);
                if (a4 != null) {
                    String valueOf = String.valueOf(a4.versionCode);
                    sAppVersionCode = valueOf;
                    return valueOf;
                }
                return "";
            } catch (Exception e4) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + e4);
                    return "";
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version code e is " + th);
                    return "";
                }
                return "";
            }
        }
        return sAppVersionCode;
    }

    public static String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(sAppVersionName)) {
            if (context == null) {
                return "";
            }
            try {
                PackageInfo a4 = b.a().a(context, context.getPackageName(), 64);
                if (a4 != null) {
                    String str = a4.versionName;
                    sAppVersionName = str;
                    return str;
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version name e is " + th);
                    return "";
                }
                return "";
            }
        }
        return sAppVersionName;
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sAppkey)) {
                return UMConfigure.sAppkey;
            }
            return getMultiProcessSP(context, "appkey");
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app key e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Properties getBuildProp() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
        }
        return properties;
    }

    public static String getCPU() {
        String str = null;
        try {
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e4) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        Log.e("UMUtils", "Could not read from file /proc/cpuinfo, e is " + e4);
                    }
                }
            } catch (Exception e5) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get cpu e is " + e5);
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get cpu e is " + th);
                }
                return "";
            }
        } catch (FileNotFoundException e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not read from file /proc/cpuinfo, e is " + e6);
            }
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(UMConfigure.sChannel)) {
                return UMConfigure.sChannel;
            }
            return getMultiProcessSP(context, "channel");
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get channel e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get channel e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2.trim();
            }
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i("MobclickAgent", "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Object invoke;
        Method method;
        Object invoke2;
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                Class<?> cls = Class.forName("com.umeng.message.PushAgent");
                Method method2 = cls.getMethod("getInstance", Context.class);
                if (method2 == null || (invoke = method2.invoke(cls, origApplicationContext)) == null || (method = cls.getMethod("getRegistrationId", new Class[0])) == null || (invoke2 = method.invoke(invoke, new Object[0])) == null || !(invoke2 instanceof String)) {
                    return null;
                }
                return (String) invoke2;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get device type e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get device type e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i4 = displayMetrics.widthPixels;
            int i5 = displayMetrics.heightPixels;
            return String.valueOf(i5) + "*" + String.valueOf(i4);
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get display resolution e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get display resolution e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getFileMD5(File file) {
        try {
            try {
                byte[] bArr = new byte[1024];
                try {
                    if (!file.isFile()) {
                        return "";
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            fileInputStream.close();
                            return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                        }
                    }
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception e4) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get file MD5 e is " + e4);
                }
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get file MD5 e is " + th);
            }
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not read gpu infor, e is " + e4);
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not read gpu infor, e is " + th);
            }
            return new String[0];
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, "last_appkey");
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get last app key e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get last app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return null;
        }
        try {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get locale e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
                return null;
            }
        } catch (Exception e4) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "fail to read user config locale, e is " + e4);
                }
                locale = null;
            } catch (Exception e5) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get locale e is " + e5);
                }
                UMCrashManager.reportCrash(context, e5);
                return null;
            }
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                return "";
            }
            return "";
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get mac e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get mac e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, 13};
    }

    public static String getMultiProcessSP(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (isMainProgress(context)) {
                            sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                        } else {
                            String subProcessName = UMFrUtils.getSubProcessName(context);
                            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            sharedPreferences = origApplicationContext.getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                        }
                        if (sharedPreferences != null) {
                            return sharedPreferences.getString(str, null);
                        }
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network access mode e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get network access mode e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
            return strArr;
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        return DeviceConfig.getNetworkOperatorName(context);
    }

    public static String getOaidRequiredTime(Context context) {
        if (FieldManager.allow("header_device_oaid")) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.f53637a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString("key_umeng_sp_oaid_required_time", "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static String getOperator(Context context) {
        String registeredOperator = DeviceConfig.getRegisteredOperator(context);
        return TextUtils.isEmpty(registeredOperator) ? "Unknown" : registeredOperator;
    }

    public static String getRegisteredOperator(Context context) {
        return DeviceConfig.getRegisteredOperator(context);
    }

    public static String getSubOSName(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (!TextUtils.isEmpty(property)) {
                        str = "MIUI";
                    } else if (isFlyMe()) {
                        str = "Flyme";
                    } else if (TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                        return property;
                    } else {
                        str = "YunOS";
                    }
                    return str;
                } catch (Exception e4) {
                    UMCrashManager.reportCrash(context, e4);
                    return null;
                }
            } catch (Exception e5) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get sub os name e is " + e5);
                }
                UMCrashManager.reportCrash(context, e5);
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get sub os name e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        String yunOSVersion;
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (TextUtils.isEmpty(property)) {
                        try {
                            if (isFlyMe()) {
                                yunOSVersion = getFlymeVersion(buildProp);
                            } else {
                                yunOSVersion = getYunOSVersion(buildProp);
                            }
                            return yunOSVersion;
                        } catch (Exception unused) {
                        }
                    }
                    return property;
                } catch (Exception e4) {
                    UMCrashManager.reportCrash(context, e4);
                    return null;
                }
            } catch (Exception e5) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get sub os version e is " + e5);
                }
                UMCrashManager.reportCrash(context, e5);
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "get sub os version e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(f3.f5657f, String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUMId(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), "umid", null);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(context, e4);
                return null;
            }
        }
        return null;
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString("session_id", "") : "";
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ztoken", null);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(context, e4);
                return null;
            }
        }
        return null;
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getZid(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (UMConfigure.needSendZcfgEnv(origApplicationContext)) {
            return null;
        }
        return com.umeng.commonsdk.internal.b.a(origApplicationContext).a().a();
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return b.a().a(context, str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isApplication(Context context) {
        try {
            String name = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClass().getSuperclass().getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            return name.equals("android.app.Application");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e4) {
            UMCrashManager.reportCrash(context, e4);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 != read) {
                stringWriter.write(cArr, 0, read);
            } else {
                return stringWriter.toString();
            }
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "\u7edf\u8ba1SDK\u7248\u672c\u53f7: 9.6.5");
        }
        VALUE_ANALYTICS_VERSION = "9.6.5";
        String b4 = com.umeng.commonsdk.internal.c.b();
        if (!TextUtils.isEmpty(b4)) {
            VALUE_ASMS_VERSION = b4;
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(2, "ZID SDK\u7248\u672c\u53f7: " + b4);
            }
        }
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "\u6e38\u620f\u7edf\u8ba1SDK\u7248\u672c\u53f7: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                String str2 = (String) cls2.getDeclaredField(Field.VERSION).get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "\u53ef\u89c6\u5316\u57cb\u70b9SDK\u7248\u672c\u53f7: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append("p");
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "\u63a8\u9001SDK\u7248\u672c\u53f7: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
        if (cls4 != null) {
            stringBuffer.append("s");
            Class<?> cls5 = getClass("com.umeng.a");
            if (cls5 != null) {
                try {
                    String str4 = (String) cls5.getDeclaredField("g").get(cls5);
                    if (!TextUtils.isEmpty(str4)) {
                        VALUE_SHARE_VERSION = str4;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "\u5206\u4eabSDK\u7248\u672c\u53f7: " + str4);
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
            if (TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                try {
                    Method declaredMethod = cls4.getDeclaredMethod("getSdkVersion", new Class[0]);
                    declaredMethod.setAccessible(true);
                    VALUE_SHARE_VERSION = (String) declaredMethod.invoke(cls4, new Object[0]);
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append("z");
        }
        stringBuffer.append("i");
        if (SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append("u");
            Class<?> cls6 = getClass("com.umeng.airec.BuildConfig");
            if (cls6 != null) {
                try {
                    String str5 = (String) cls6.getDeclaredField("VERSION_NAME").get(cls6);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "\u667a\u80fd\u63a8\u8350SDK\u7248\u672c\u53f7: " + str5);
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        if (getClass("com.umeng.umverify.UMVerifyHelper") != null) {
            stringBuffer.append("n");
        }
        Class<?> cls7 = getClass("com.umeng.sms.UMSMS");
        if (cls7 != null) {
            stringBuffer.append("m");
            try {
                Method declaredMethod2 = cls7.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod2 != null) {
                    String str6 = (String) declaredMethod2.invoke(cls7, new Object[0]);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_SMS_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "\u77ed\u4fe1\u9a8c\u8bc1\u7801SDK\u7248\u672c\u53f7: " + str6);
                        }
                    }
                }
            } catch (Throwable unused7) {
            }
        }
        try {
            Class<?> cls8 = getClass("com.umeng.umcrash.UMCrash");
            if (cls8 != null) {
                stringBuffer.append("c");
                java.lang.reflect.Field declaredField = cls8.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str7 = (String) declaredField.get(cls8);
                if (!TextUtils.isEmpty(str7)) {
                    VALUE_APM_VERSION = str7;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK\u7248\u672c\u53f7: " + str7);
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        Class<?> cls9 = getClass("com.umeng.umlink.MobclickLink");
        if (cls9 != null) {
            stringBuffer.append("l");
            try {
                Method declaredMethod3 = cls9.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    String str8 = (String) declaredMethod3.invoke(cls9, new Object[0]);
                    if (!TextUtils.isEmpty(str8)) {
                        VALUE_LINK_VERSION = str8;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ULink SDK\u7248\u672c\u53f7: " + str8);
                        }
                    }
                }
            } catch (Throwable unused9) {
            }
        }
        Class<?> cls10 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls10 != null) {
            try {
                Method declaredMethod4 = cls10.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod4 != null) {
                    stringBuffer.append("t");
                    String str9 = (String) declaredMethod4.invoke(cls10, new Object[0]);
                    if (!TextUtils.isEmpty(str9)) {
                        VALUE_ABTEST_VERSION = str9;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "UABTEST SDK\u7248\u672c\u53f7: " + str9);
                        }
                    }
                }
            } catch (Throwable unused10) {
            }
        }
        Class<?> cls11 = getClass("com.uyumao.sdk.UYMManager");
        if (cls11 != null) {
            try {
                Method declaredMethod5 = cls11.getDeclaredMethod("getSdkVersion", new Class[0]);
                if (declaredMethod5 != null) {
                    stringBuffer.append("r");
                    String str10 = (String) declaredMethod5.invoke(cls11, new Object[0]);
                    if (!TextUtils.isEmpty(str10)) {
                        VALUE_ANTI_VERSION = str10;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ANTI SDK\u7248\u672c\u53f7: " + str10);
                        }
                    }
                }
            } catch (Throwable unused11) {
            }
        }
        if (TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        com.umeng.commonsdk.statistics.b.f53552a = stringBuffer.toString();
        Log.i("MobclickAgent", "module init:" + com.umeng.commonsdk.statistics.b.f53552a);
    }

    public static void setAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "appkey", str);
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set app key e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setChannel(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "channel", str);
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set channel e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set channel e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "last_appkey", str);
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set last app key e is " + e4);
            }
            UMCrashManager.reportCrash(context, e4);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e("UMUtils", "set last app key e is " + th);
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setMultiProcessSP(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str) && str2 != null) {
                        if (isMainProgress(context)) {
                            sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                        } else {
                            String subProcessName = UMFrUtils.getSubProcessName(context);
                            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            sharedPreferences = origApplicationContext.getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                        }
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putString(str, str2).commit();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void setUUIDForZid(Context context) {
        String str;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        try {
            str = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo a4 = b.a().a(context, str, 64);
                if (a4 != null) {
                    return a4.versionName;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    Log.e("UMUtils", "get app version name e is " + th);
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return "";
    }
}
