package com.p521ss.android.downloadlib.p534h;

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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.download.api.config.InterfaceC11968t;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.p523bl.C11951a;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12030bl;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.ss.android.downloadlib.h.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12197j {

    /* renamed from: a */
    private static Object[] f34472a = new Object[0];

    /* renamed from: bl */
    private static Object[] f34473bl = new Object[73];

    /* renamed from: ok */
    static final char[] f34474ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: s */
    private static String f34475s = null;

    /* renamed from: a */
    public static boolean m18804a(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* renamed from: bl */
    public static String m18801bl(Context context, String str) {
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

    /* renamed from: h */
    public static Intent m18799h(Context context, String str) {
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

    /* renamed from: k */
    public static File m18798k(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        String parent = parentFile != null ? parentFile.getParent() : null;
        File file = new File(parent + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        C12409ok.m17904a("ToolUtils", sb.toString());
        return file;
    }

    /* renamed from: kf */
    public static boolean m18797kf(Context context, String str) {
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
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m18796n(Context context, String str) {
        if (context == null) {
            context = C12128r.getContext();
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

    /* renamed from: ok */
    public static boolean m18784ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* renamed from: p */
    public static Signature[] m18772p(Context context, String str) {
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

    /* renamed from: q */
    public static Signature[] m18771q(Context context, String str) {
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

    /* renamed from: s */
    public static Drawable m18770s(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m18806a(Context context, String str) {
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

    /* renamed from: ok */
    public static long m18779ok(JSONObject jSONObject, String str) {
        return C11951a.m19662ok(jSONObject, str);
    }

    @WorkerThread
    /* renamed from: bl */
    public static boolean m18800bl(String str) {
        File file;
        Context context = C12128r.getContext();
        if (!TextUtils.isEmpty(str) && m18796n(context, str)) {
            int i = context.getApplicationInfo().targetSdkVersion;
            if (C12128r.m18946q().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i != 29 || Environment.isExternalStorageLegacy()) && i <= 29)) {
                try {
                    if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && C12128r.m18946q().optInt("get_ext_dir_mode") == 1) {
                        file = m18798k(context, str);
                    } else {
                        String path = Environment.getExternalStorageDirectory().getPath();
                        file = new File(path, "android/data/" + str);
                    }
                    if (file.exists()) {
                        long m18811ok = C12196h.m18811ok(file);
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            if (packageInfo.lastUpdateTime < m18811ok) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    public static JSONObject m18777ok(JSONObject jSONObject, JSONObject jSONObject2) {
        return C11951a.m19661ok(jSONObject, jSONObject2);
    }

    @NonNull
    /* renamed from: ok */
    public static JSONObject m18780ok(JSONObject jSONObject) {
        return C11951a.m19663ok(jSONObject);
    }

    @NonNull
    /* renamed from: ok */
    public static JSONObject m18773ok(JSONObject... jSONObjectArr) {
        return C11951a.m19659ok(jSONObjectArr);
    }

    /* renamed from: a */
    public static boolean m18805a(C11998a c11998a) {
        if (c11998a == null) {
            return false;
        }
        return m18782ok(c11998a.mo19300n(), c11998a.m19502fd(), c11998a.m19507em()).m19337ok();
    }

    /* renamed from: ok */
    public static boolean m18791ok(Context context, Intent intent) {
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

    /* renamed from: a */
    public static boolean m18807a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = C12128r.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    /* renamed from: ok */
    public static String m18793ok(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return (j / IjkMediaMeta.AV_CH_STEREO_RIGHT) + "G";
        } else if (j >= 1048576) {
            return (j / 1048576) + "M";
        } else {
            return decimalFormat.format(((float) j) / 1048576.0f) + "M";
        }
    }

    /* renamed from: a */
    public static long m18808a(long j) {
        try {
            return m18785ok(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    public static boolean m18809a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: ok */
    public static PackageInfo m18787ok(C11998a c11998a) {
        DownloadInfo downloadInfo;
        if (c11998a == null || (downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz())) == null) {
            return null;
        }
        try {
            return C12293bl.m18414ok(C12128r.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    /* renamed from: a */
    public static HashMap<String, String> m18803a(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    /* renamed from: ok */
    public static Drawable m18790ok(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: bl */
    public static void m18802bl() {
        try {
            if (C12128r.m18961n().mo19530ok(C12128r.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) C12128r.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (C12128r.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ok */
    public static C12030bl m18782ok(String str, int i, String str2) {
        C12030bl c12030bl = new C12030bl();
        if (TextUtils.isEmpty(str)) {
            return c12030bl;
        }
        try {
            PackageInfo packageInfo = C12128r.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                c12030bl.m19338a(packageInfo.versionCode);
                c12030bl.m19336ok(C12030bl.f34057a);
                InterfaceC11968t m18967h = C12128r.m18967h();
                if (m18967h != null && m18967h.m19637ok() && !m18794ok(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    c12030bl.m19336ok(C12030bl.f34058bl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c12030bl;
    }

    /* renamed from: ok */
    private static boolean m18794ok(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || m18781ok(str, str2) >= 0;
    }

    /* renamed from: ok */
    public static boolean m18788ok(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return m18782ok(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).m19337ok();
    }

    /* renamed from: ok */
    public static boolean m18789ok(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i == packageInfo.versionCode;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ok */
    public static boolean m18776ok(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            if ((signatureArr[i] == null && signatureArr2[i] != null) || (signatureArr[i] != null && !signatureArr[i].equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ok */
    public static int m18792ok(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: ok */
    public static String m18783ok(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    /* renamed from: ok */
    public static int m18781ok(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i = 0;
                int i2 = 0;
                while (i < min) {
                    i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < split.length; i3++) {
                    if (Integer.parseInt(split[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < split2.length) {
                    if (Integer.parseInt(split2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    /* renamed from: ok */
    public static String m18774ok(String... strArr) {
        return C11951a.m19660ok(strArr);
    }

    @NonNull
    /* renamed from: ok */
    public static <T> T m18775ok(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    /* renamed from: ok */
    public static boolean m18795ok() {
        try {
            if (C12128r.getContext().getPackageManager().getPackageInfo(C12128r.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ok */
    public static long m18785ok(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return C12713kf.m16518s(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: ok */
    public static long m18786ok(File file) {
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

    /* renamed from: ok */
    public static void m18778ok(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
