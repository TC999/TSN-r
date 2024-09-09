package com.baidu.idl.face.platform.ui.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BrightnessUtils {
    private static final String TAG = "BrightnessUtils";

    public static int getScreenBrightness(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static void saveBrightness(ContentResolver contentResolver, int i4) {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        Settings.System.putInt(contentResolver, "screen_brightness", i4);
        contentResolver.notifyChange(uriFor, null);
    }

    public static void setBrightness(Activity activity, int i4) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i4).floatValue() * 0.003921569f;
        Log.d("BrightnessUtils", "set  lp.screenBrightness == " + attributes.screenBrightness);
        activity.getWindow().setAttributes(attributes);
    }

    public static void startAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
    }

    public static void stopAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
    }
}
