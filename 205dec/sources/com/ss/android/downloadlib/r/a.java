package com.ss.android.downloadlib.r;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.download.api.config.ys;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a {

    /* renamed from: w  reason: collision with root package name */
    private static Object[] f48914w = new Object[0];
    private static Object[] xv = new Object[73];

    /* renamed from: c  reason: collision with root package name */
    static final char[] f48913c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String sr = null;

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static Signature[] ev(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean f(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i4 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i4 <= packageInfo.versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static Signature[] gd(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File p(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        String parent = parentFile != null ? parentFile.getParent() : null;
        File file = new File(parent + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.ss.android.socialbase.downloader.xv.c.w("ToolUtils", sb.toString());
        return file;
    }

    public static Intent r(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Drawable sr(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean ux(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean w(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String xv(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static long c(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.xv.w.c(jSONObject, str);
    }

    public static int w(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.xv.w.c(jSONObject, jSONObject2);
    }

    @WorkerThread
    public static boolean xv(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.k.getContext();
        if (!TextUtils.isEmpty(str) && ux(context, str)) {
            int i4 = context.getApplicationInfo().targetSdkVersion;
            if (com.ss.android.downloadlib.addownload.k.gd().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i4 != 29 || Environment.isExternalStorageLegacy()) && i4 <= 29)) {
                try {
                    if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.k.gd().optInt("get_ext_dir_mode") == 1) {
                        file = p(context, str);
                    } else {
                        String path = Environment.getExternalStorageDirectory().getPath();
                        file = new File(path, "android/data/" + str);
                    }
                    if (file.exists()) {
                        long c4 = r.c(file);
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            if (packageInfo.lastUpdateTime < c4) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    @NonNull
    public static JSONObject c(JSONObject jSONObject) {
        return com.ss.android.download.api.xv.w.c(jSONObject);
    }

    @NonNull
    public static JSONObject c(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.xv.w.c(jSONObjectArr);
    }

    public static boolean c(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean w(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return false;
        }
        return c(wVar.ux(), wVar.yu(), wVar.wx()).c();
    }

    public static boolean w(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String c(long j4) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j4 >= 1073741824) {
            return (j4 / 1073741824) + "G";
        } else if (j4 >= 1048576) {
            return (j4 / 1048576) + "M";
        } else {
            return decimalFormat.format(((float) j4) / 1048576.0f) + "M";
        }
    }

    public static long w(long j4) {
        try {
            return c(Environment.getExternalStorageDirectory(), j4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return j4;
        }
    }

    public static PackageInfo c(com.ss.android.downloadad.api.c.w wVar) {
        DownloadInfo downloadInfo;
        if (wVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.getContext()).getDownloadInfo(wVar.fz())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.xv.c(com.ss.android.downloadlib.addownload.k.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean w() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @NonNull
    public static HashMap<String, String> w(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return hashMap;
    }

    public static Drawable c(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void xv() {
        try {
            if (com.ss.android.downloadlib.addownload.k.ux().c(com.ss.android.downloadlib.addownload.k.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.k.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.k.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.addownload.w.xv c(String str, int i4, String str2) {
        com.ss.android.downloadlib.addownload.w.xv xvVar = new com.ss.android.downloadlib.addownload.w.xv();
        if (TextUtils.isEmpty(str)) {
            return xvVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.k.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                xvVar.w(packageInfo.versionCode);
                xvVar.c(com.ss.android.downloadlib.addownload.w.xv.f48729w);
                ys r3 = com.ss.android.downloadlib.addownload.k.r();
                if (r3 != null && r3.c() && !c(packageInfo.versionCode, i4, packageInfo.versionName, str2)) {
                    xvVar.c(com.ss.android.downloadlib.addownload.w.xv.xv);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return xvVar;
    }

    private static boolean c(int i4, int i5, String str, String str2) {
        if (i5 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i5 > 0 && i4 >= i5) || c(str, str2) >= 0;
    }

    public static boolean c(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return c(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).c();
    }

    public static boolean c(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i4 = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i4 == packageInfo.versionCode;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean c(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < signatureArr.length; i4++) {
            if ((signatureArr[i4] == null && signatureArr2[i4] != null) || (signatureArr[i4] != null && !signatureArr[i4].equals(signatureArr2[i4]))) {
                return false;
            }
        }
        return true;
    }

    public static int c(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String c(String str, int i4) {
        return i4 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i4) ? str : str.substring(0, i4);
    }

    public static int c(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i4 = 0;
                int i5 = 0;
                while (i4 < min) {
                    i5 = Integer.parseInt(split[i4]) - Integer.parseInt(split2[i4]);
                    if (i5 != 0) {
                        break;
                    }
                    i4++;
                }
                if (i5 != 0) {
                    return i5 > 0 ? 1 : -1;
                }
                for (int i6 = i4; i6 < split.length; i6++) {
                    if (Integer.parseInt(split[i6]) > 0) {
                        return 1;
                    }
                }
                while (i4 < split2.length) {
                    if (Integer.parseInt(split2[i4]) > 0) {
                        return -1;
                    }
                    i4++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String c(String... strArr) {
        return com.ss.android.download.api.xv.w.c(strArr);
    }

    @NonNull
    public static <T> T c(T... tArr) {
        if (tArr != null) {
            for (T t3 : tArr) {
                if (t3 != null) {
                    return t3;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean c() {
        try {
            if (com.ss.android.downloadlib.addownload.k.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.k.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static long c(File file, long j4) {
        if (file == null) {
            return j4;
        }
        try {
            return com.ss.android.socialbase.downloader.gd.f.sr(file.getAbsolutePath());
        } catch (Exception e4) {
            e4.printStackTrace();
            return j4;
        }
    }

    public static long c(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static void c(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
