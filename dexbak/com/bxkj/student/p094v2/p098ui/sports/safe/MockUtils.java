package com.bxkj.student.p094v2.p098ui.sports.safe;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import p615l.RequestPermission;

/* renamed from: com.bxkj.student.v2.ui.sports.safe.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MockUtils {

    /* compiled from: MockUtils.java */
    /* renamed from: com.bxkj.student.v2.ui.sports.safe.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5704a implements RequestPermission.InterfaceC15268a {
        C5704a() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NonNull String[] strings) {
            C11792j.m20470c("requestQueryAllPackages->onRejectAndNoAsk");
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            C11792j.m20470c("requestQueryAllPackages->onSucceed");
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NonNull String[] strings) {
            C11792j.m20470c("requestQueryAllPackages->onReject");
        }
    }

    /* renamed from: a */
    public static boolean m38626a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i = 0;
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
            try {
                String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str.equals("android.permission.ACCESS_MOCK_LOCATION") && !applicationInfo.packageName.equals(context.getPackageName())) {
                            i++;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                C11792j.m20468e("Got exception " + e.getMessage(), new Object[0]);
            }
        }
        return i > 0;
    }

    /* renamed from: b */
    public static String m38625b(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return packageName;
        }
    }

    /* renamed from: c */
    public static List<String> m38624c(Context context) {
        List<String> m38623d = m38623d(context, false);
        ArrayList arrayList = new ArrayList();
        for (String str : m38623d) {
            if (!m38621f(context, str) && m38622e(context, str, "android.permission.ACCESS_MOCK_LOCATION")) {
                arrayList.add(m38625b(context, str));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<String> m38623d(Context context, boolean includeSystem) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        HashSet hashSet = new HashSet();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                hashSet.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(1000)) {
                hashSet.add(runningTaskInfo.topActivity.getPackageName());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(1000)) {
                hashSet.add(runningServiceInfo.service.getPackageName());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return new ArrayList(hashSet);
    }

    /* renamed from: e */
    public static boolean m38622e(Context context, String app, String permission) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(app, 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str.equals(permission)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m38621f(Context context, String app) {
        try {
            return (context.getPackageManager().getPackageInfo(app, 0).applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: g */
    public static void m38620g(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            new RequestPermission(activity).m3480c("android.permission.QUERY_ALL_PACKAGES", "android.permission.GET_INSTALLED_APPS").m3479d(new C5704a());
        }
    }
}
