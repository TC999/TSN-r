package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.UUID;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DeviceUtils {
    private static final String TAG = "DeviceUtils";

    public static String getAndroidID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        try {
            return MD5Utils.encryption(string.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public static String getDeviceCode(Context context) {
        String str = "";
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return MD5Utils.encryption(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getSerialNumber(Context context) {
        return Build.SERIAL;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
