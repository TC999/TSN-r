package com.beizi.p051ad.internal.utilities;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.beizi.p051ad.lance.p062a.FileUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.beizi.p051ad.p056c.EnumType;
import com.stub.StubApp;

/* renamed from: com.beizi.ad.internal.utilities.DeviceInfoUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DeviceInfoUtil {
    public static String ETHERNET_SERVICE = "ethernet";
    public static int SCREEN_DECIMAL_DIGITS = 2;

    private static void getIdentifiersAndDevType(Context context, DeviceInfo deviceInfo) {
        try {
            if (((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getPhoneType() != 0) {
                deviceInfo.devType = EnumType.EnumC2813b.DEVICE_PHONE;
            } else {
                deviceInfo.devType = EnumType.EnumC2813b.DEVICE_FLAT;
            }
        } catch (Throwable unused) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, "No permission to access imei");
            int i = context.getResources().getConfiguration().screenLayout & 15;
            if (i != 4 && i != 3) {
                deviceInfo.devType = EnumType.EnumC2813b.DEVICE_PHONE;
            } else {
                deviceInfo.devType = EnumType.EnumC2813b.DEVICE_FLAT;
            }
        }
        deviceInfo.root = SystemUtil.m49038a();
    }

    private static void getScreenInformations(Context context, DeviceInfo deviceInfo) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        deviceInfo.resolution = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
        float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        double sqrt = Math.sqrt((double) ((f2 * f2) + (f * f)));
        double pow = Math.pow(10.0d, (double) SCREEN_DECIMAL_DIGITS);
        double round = Math.round(sqrt * pow);
        Double.isNaN(round);
        deviceInfo.screenSize = String.format("%.2f", Double.valueOf(round / pow));
    }

    private static void getSdkUID(Context context, DeviceInfo deviceInfo) {
        deviceInfo.sdkUID = (String) SPUtils.get(context, DeviceInfo.SDK_UID_KEY_NEW, "");
    }

    public static void retrieveDeviceInfo(Context context) {
        DeviceInfo deviceInfo = DeviceInfo.getInstance();
        if (TextUtils.isEmpty(deviceInfo.sdkUID)) {
            try {
                getIdentifiersAndDevType(context, deviceInfo);
                getScreenInformations(context, deviceInfo);
                getSdkUID(context, deviceInfo);
                deviceInfo.getMarks(context);
                if (!TextUtils.isEmpty(deviceInfo.manufacturer) && (deviceInfo.manufacturer.equalsIgnoreCase("HUAWEI") || deviceInfo.manufacturer.equalsIgnoreCase("HONOR"))) {
                    deviceInfo.agVercode = SystemUtil.m49028e(context);
                }
                deviceInfo.wxInstalled = FileUtil.m49059a(context, "com.tencent.mm");
                deviceInfo.hmsCoreVersion = SystemUtil.m49036a(context, "com.huawei.hwid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
