package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.PkgInfoUtil;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.umeng.commonsdk.internal.utils.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ApplicationLayerUtil {

    /* compiled from: ApplicationLayerUtil.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13229a {

        /* renamed from: a */
        public String f38839a;

        /* renamed from: b */
        public String f38840b;
    }

    /* renamed from: a */
    public static long m13935a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo m13465a = PkgInfoUtil.m13466a().m13465a(context, str, 64);
            if (m13465a != null) {
                return m13465a.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m13790e("getAppFirstInstallTime" + th.getMessage());
            return 0L;
        }
    }

    /* renamed from: b */
    public static long m13932b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo m13465a = PkgInfoUtil.m13466a().m13465a(context, str, 64);
            if (m13465a != null) {
                return m13465a.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m13790e("getAppLastUpdateTime:" + th.getMessage());
            return 0L;
        }
    }

    /* renamed from: b */
    public static void m13933b(Context context) {
    }

    /* renamed from: c */
    public static String m13929c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            ULog.m13790e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static int m13926d(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo m13465a = PkgInfoUtil.m13466a().m13465a(context, str, 64);
            if (m13465a == null || (applicationInfo = m13465a.applicationInfo) == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m13790e("getAppUid:" + th.getMessage());
            return 0;
        }
    }

    /* renamed from: e */
    public static DisplayMetrics m13925e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    /* renamed from: f */
    public static List<InputMethodInfo> m13923f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    /* renamed from: g */
    public static List<C13229a> m13922g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        C13229a c13229a = new C13229a();
                        c13229a.f38839a = str;
                        c13229a.f38840b = m13924e(context, str);
                        arrayList.add(c13229a);
                    }
                }
            }
        } catch (Exception e) {
            ULog.m13790e("getAppList:" + e.getMessage());
        }
        return arrayList;
    }

    /* renamed from: h */
    public static ActivityManager.MemoryInfo m13921h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    /* renamed from: i */
    public static String m13920i(Context context) {
        return null;
    }

    /* renamed from: j */
    public static String m13919j(Context context) {
        return null;
    }

    /* renamed from: e */
    private static String m13924e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e) {
            ULog.m13790e("getLabel:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static int m13930c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: a */
    public static boolean m13937a() {
        return Root.m13905a();
    }

    /* renamed from: b */
    public static String m13934b() {
        return new SimpleDateFormat().format(new Date());
    }

    /* renamed from: a */
    public static float m13936a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e) {
            ULog.m13790e("getFontSize:" + e.getMessage());
            return 0.0f;
        }
    }

    /* renamed from: d */
    public static int m13927d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: c */
    public static long m13931c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    /* renamed from: d */
    public static String m13928d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : HelperUtils.getUmengMD5(obj);
        } catch (Exception e) {
            ULog.m13790e("getHostName:" + e.getMessage());
            return null;
        }
    }
}
