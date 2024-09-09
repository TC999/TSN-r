package xyz.adscope.common.info.deviceinfo;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.stub.StubApp;
import java.util.Locale;
import java.util.TimeZone;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoEnum;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.sm.oaid.DeviceID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.DeviceIdentifier;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.sp.CommonSpUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.tool.thread.CommonThreadPool;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DeviceInfoUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f64662a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64663b;

    public static String a(Context context) {
        try {
            return context.getResources().getConfiguration().locale.getCountry();
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    public static void b(final Context context) {
        try {
            DeviceID.getGAID(context, new IGetter() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.3
                @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    try {
                        LogUtil.e("DeviceInfoUtil", "sm gaid:" + str);
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (TextUtils.isEmpty(DeviceInfoUtil.f64663b)) {
                            String unused = DeviceInfoUtil.f64663b = str;
                        }
                        CommonSpUtil.putString(context, CommonConstants.DEVICE_GAID_KEY, DeviceInfoUtil.f64663b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    LogUtil.e("DeviceInfoUtil", "sm gaid error:" + exc.getMessage());
                }
            });
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    public static String c() {
        try {
            StringBuilder sb = new StringBuilder();
            String brand = getBrand();
            String model = getModel();
            String hardDisk = getHardDisk();
            String osVersion = getOsVersion();
            String fileMark = getFileMark();
            String deviceUpdateMark = getDeviceUpdateMark();
            long currentTimeMillis = System.currentTimeMillis();
            sb.append(brand);
            sb.append(model);
            sb.append(hardDisk);
            sb.append(osVersion);
            sb.append(fileMark);
            sb.append(deviceUpdateMark);
            sb.append(currentTimeMillis);
            return MD5Util.md5(sb.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static void c(final Context context) {
        try {
            new DevicesIDsHelper(new DevicesIDsHelper.AppIdsUpdater() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.2
                @Override // xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper.AppIdsUpdater
                public void OnIdsValid(String str) {
                    try {
                        LogUtil.e("DeviceInfoUtil", "cn oaid:" + str);
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (TextUtils.isEmpty(DeviceInfoUtil.f64662a)) {
                            String unused = DeviceInfoUtil.f64662a = str;
                        }
                        CommonSpUtil.putString(context, CommonConstants.DEVICE_OAID_KEY, DeviceInfoUtil.f64662a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).getOAID(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d(final Context context) {
        try {
            DeviceIdentifier.register((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (DeviceID.supportedOAID(context)) {
                DeviceID.getOAID(context, new IGetter() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.1
                    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                    public void onOAIDGetComplete(String str) {
                        LogUtil.e("DeviceInfoUtil", "sm oaid:" + str);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (TextUtils.isEmpty(DeviceInfoUtil.f64662a)) {
                                String unused = DeviceInfoUtil.f64662a = str;
                            }
                            CommonSpUtil.putString(context, CommonConstants.DEVICE_OAID_KEY, DeviceInfoUtil.f64662a);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                    public void onOAIDGetError(Exception exc) {
                    }
                });
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    public static int dip2px(Context context, float f4) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static boolean e(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ void f(Context context) {
        d(context);
        c(context);
    }

    public static String getAndroidVersion() {
        try {
            return Build.VERSION.SDK_INT + "";
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getCarrier(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                String simOperator = telephonyManager.getSimOperator();
                if (simOperator != null) {
                    if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                        if (simOperator.equals("46001")) {
                            return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CUCC.getValue();
                        }
                        if (simOperator.equals("46003")) {
                            return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CTCC.getValue();
                        }
                    }
                    return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CMCC.getValue();
                }
                return DeviceInfoEnum.CARRIER_TYPE.CARRIER_UNKNOWN.getValue();
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
        return DeviceInfoEnum.CARRIER_TYPE.CARRIER_UNKNOWN.getValue();
    }

    public static int getConnectType(Context context) {
        try {
            if (context == null) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_WIFI.getCode();
            }
            if (type == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                String subtypeName = activeNetworkInfo.getSubtypeName();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_2G.getCode();
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
                        return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_3G.getCode();
                    case 13:
                    case 18:
                        return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_4G.getCode();
                    case 19:
                    default:
                        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) {
                            return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
                        }
                        return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_3G.getCode();
                    case 20:
                        return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_5G.getCode();
                }
            }
            return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
        } catch (Throwable unused) {
            return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
        }
    }

    public static String getCountry(Context context) {
        return a(context);
    }

    public static int getCountryCN(Context context) {
        String a4 = a(context);
        if (!TextUtils.isEmpty(a4)) {
            a4 = a4.toUpperCase();
        }
        DeviceInfoEnum.DEVICE_COUNTRY_TYPE device_country_type = DeviceInfoEnum.DEVICE_COUNTRY_TYPE.COUNTRY_CHINA_TYPE;
        return device_country_type.getCountry().equals(a4) ? device_country_type.getCode() : DeviceInfoEnum.DEVICE_COUNTRY_TYPE.COUNTRY_OTHER_TYPE.getCode();
    }

    public static float getDensity(Context context) {
        if (context != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.density;
            } catch (Throwable th) {
                LogUtil.e("DeviceInfoUtil", "e : " + th);
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public static String getDeviceBootMark() {
        return "";
    }

    public static String getDeviceName(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    public static int getDeviceType(Context context) {
        return (e(context) ? DeviceInfoEnum.DEVICE_TYPE.TYPE_TABLET : DeviceInfoEnum.DEVICE_TYPE.TYPE_PHONE).getCode();
    }

    public static String getDeviceUpdateMark() {
        try {
            return new DeviceInfoSystemMark().getDeviceUpdateMark();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getFileMark() {
        long j4;
        try {
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            j4 = Math.max(SysProp.getLong("ro.build.date.utc", -1L), Math.max(Environment.getRootDirectory().lastModified(), Build.TIME));
            return j4 + "";
        }
        j4 = 0;
        return j4 + "";
    }

    public static String getGaid(Context context) {
        try {
            if (TextUtils.isEmpty(f64663b)) {
                String string = CommonSpUtil.getString(context, CommonConstants.DEVICE_GAID_KEY);
                f64663b = string;
                return string;
            }
            return f64663b;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getHardDisk() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                LogUtil.i("DeviceInfoUtil", "");
                return "0";
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            statFs.getAvailableBlocks();
            return String.valueOf(statFs.getBlockSize() * statFs.getBlockCount());
        } catch (Throwable th) {
            th.printStackTrace();
            return "0";
        }
    }

    public static String getHmsCoreVersion(Context context) {
        return getVersionCode(context, "com.huawei.hwid");
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    @TargetApi(3)
    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return null;
        }
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOaid(Context context) {
        try {
            if (TextUtils.isEmpty(f64662a)) {
                String string = CommonSpUtil.getString(context, CommonConstants.DEVICE_OAID_KEY);
                f64662a = string;
                return string;
            }
            return f64662a;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int getOrientation(Context context) {
        try {
            return context.getResources().getConfiguration().orientation;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getOs() {
        return DeviceInfoEnum.OS_TYPE.OS_ANDROID.getCode();
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static float getPPI(Context context) {
        if (context != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.densityDpi;
            } catch (Throwable th) {
                LogUtil.e("DeviceInfoUtil", "e : " + th);
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public static String getPhysicalMemory(Context context) {
        try {
            return String.valueOf(getMemoryInfo(context).totalMem);
        } catch (Throwable th) {
            th.printStackTrace();
            return "0";
        }
    }

    public static float getPxRatio(Context context) {
        return getDensity(context);
    }

    public static int getScreenHeight(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenHeightDp(Context context) {
        try {
            return px2dip(context, context.getResources().getDisplayMetrics().heightPixels);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenWidthDp(Context context) {
        try {
            float f4 = context.getResources().getDisplayMetrics().density;
            float f5 = context.getResources().getDisplayMetrics().widthPixels;
            if (f4 <= 0.0f) {
                f4 = 1.0f;
            }
            return (int) ((f5 / f4) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static String getSdkId(Context context) {
        String str = (String) CommonSpUtil.get(context, CommonConstants.APP_SDK_ID, "");
        if (TextUtils.isEmpty(str)) {
            String c4 = c();
            CommonSpUtil.put(context, CommonConstants.APP_SDK_ID, c4);
            return c4;
        }
        return str;
    }

    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(true, 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getUserAgent(Context context) {
        return CommonSpUtil.getString(context, CommonConstants.USER_AGENT_KEY);
    }

    public static String getVersionCode(Context context, String str) {
        try {
            int i4 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            if (i4 != 0) {
                return String.valueOf(i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }

    public static void initOaid(final Context context) {
        try {
            String oaid = getOaid(context);
            f64662a = oaid;
            if (TextUtils.isEmpty(oaid)) {
                d(context);
                c(context);
            } else {
                CommonThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.common.info.deviceinfo.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceInfoUtil.f(context);
                    }
                });
            }
            String gaid = getGaid(context);
            f64663b = gaid;
            if (TextUtils.isEmpty(gaid)) {
                b(context);
            } else {
                CommonThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.common.info.deviceinfo.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceInfoUtil.b(context);
                    }
                });
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    public static int px2dip(Context context, float f4) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }
}
