package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.TypedValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GlMapUtil {
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1 = 2;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1_EAGLE_EYE = 3;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2 = 4;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2_EAGLE_EYE = 5;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3 = 6;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3_EAGLE_EYE = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1 = 3;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1_EAGLE_EYE = 4;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2 = 5;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2_EAGLE_EYE = 6;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3 = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3_EAGLE_EYE = 8;
    public static final int AN_ENGINE_ID_EAGLE_EYE = 2;
    public static final int AN_ENGINE_ID_INVALID = -1;
    public static final int AN_ENGINE_ID_MAIN = 1;
    public static final int DEVICE_DISPLAY_DPI_HIGH = 320;
    public static final int DEVICE_DISPLAY_DPI_LOW = 120;
    public static final int DEVICE_DISPLAY_DPI_MEDIAN = 240;
    public static final int DEVICE_DISPLAY_DPI_NORMAL = 160;
    public static final int DEVICE_DISPLAY_DPI_XHIGH = 480;
    public static final int DEVICE_DISPLAY_DPI_XXHIGH = 640;

    public static byte[] decodeAssetResData(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    open.close();
                    return byteArray;
                }
            }
        } catch (IOException | OutOfMemoryError unused) {
            return null;
        }
    }

    public static int dipToPixel(Context context, int i4) {
        if (context == null) {
            return i4;
        }
        try {
            return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            return i4;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getString(Context context, int i4) {
        return context.getResources().getString(i4);
    }

    public static boolean isAssic(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (charArray[i4] >= '\u0100' || charArray[i4] <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int spToPixel(Context context, int i4) {
        return (int) TypedValue.applyDimension(2, i4, context.getResources().getDisplayMetrics());
    }
}
