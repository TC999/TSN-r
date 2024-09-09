package xyz.adscope.common.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppInfo {
    public static Bitmap getAppIcon(Context context) {
        ApplicationInfo applicationInfo;
        Drawable loadIcon;
        Bitmap bitmap = null;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = context.getApplicationInfo()) != null && (loadIcon = applicationInfo.loadIcon(packageManager)) != null) {
                if (Build.VERSION.SDK_INT < 26 || !(loadIcon instanceof AdaptiveIconDrawable)) {
                    bitmap = ((BitmapDrawable) loadIcon).getBitmap();
                } else {
                    bitmap = Bitmap.createBitmap(loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap);
                    loadIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    loadIcon.draw(canvas);
                }
            }
        } catch (Throwable th) {
            LogUtil.i(CommonConstants.TAG, "e : " + th);
        }
        return bitmap;
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        Object th;
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        if (str != null) {
            try {
            } catch (Throwable th3) {
                th = th3;
                LogUtil.e(CommonConstants.TAG, "Exception " + th);
                return str;
            }
            if (str.length() > 0) {
                return str;
            }
        }
        return "";
    }

    public static long getInstallDate(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return 0L;
        }
    }

    public static long getLastUpdateTime(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return 0L;
        }
    }

    public static String getPackName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getVerCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return DeviceInfoUtil.getVersionCode(context, context.getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return "0";
        }
    }

    public static String getVerName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return "";
        }
    }
}
