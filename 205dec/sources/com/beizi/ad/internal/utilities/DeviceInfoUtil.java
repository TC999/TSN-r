package com.beizi.ad.internal.utilities;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.beizi.ad.c.e;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.p;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DeviceInfoUtil {
    public static String ETHERNET_SERVICE = "ethernet";
    public static int SCREEN_DECIMAL_DIGITS = 2;

    private static void getIdentifiersAndDevType(Context context, DeviceInfo deviceInfo) {
        try {
            if (((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getPhoneType() != 0) {
                deviceInfo.devType = e.b.DEVICE_PHONE;
            } else {
                deviceInfo.devType = e.b.DEVICE_FLAT;
            }
        } catch (Throwable unused) {
            HaoboLog.e(HaoboLog.baseLogTag, "No permission to access imei");
            int i4 = context.getResources().getConfiguration().screenLayout & 15;
            if (i4 != 4 && i4 != 3) {
                deviceInfo.devType = e.b.DEVICE_PHONE;
            } else {
                deviceInfo.devType = e.b.DEVICE_FLAT;
            }
        }
        deviceInfo.root = p.a();
    }

    private static void getScreenInformations(Context context, DeviceInfo deviceInfo) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        deviceInfo.resolution = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
        float f4 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        float f5 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        double sqrt = Math.sqrt((double) ((f5 * f5) + (f4 * f4)));
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
                    deviceInfo.agVercode = p.e(context);
                }
                deviceInfo.wxInstalled = h.a(context, "com.tencent.mm");
                deviceInfo.hmsCoreVersion = p.a(context, "com.huawei.hwid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
