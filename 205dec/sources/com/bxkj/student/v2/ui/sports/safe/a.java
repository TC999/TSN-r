package com.bxkj.student.v2.ui.sports.safe;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import l.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MockUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MockUtils.java */
    /* renamed from: com.bxkj.student.v2.ui.sports.safe.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class C0314a implements b.a {
        C0314a() {
        }

        @Override // l.b.a
        public void a(@NonNull String[] strings) {
            j.c("requestQueryAllPackages->onRejectAndNoAsk");
        }

        @Override // l.b.a
        public void b() {
            j.c("requestQueryAllPackages->onSucceed");
        }

        @Override // l.b.a
        public void c(@NonNull String[] strings) {
            j.c("requestQueryAllPackages->onReject");
        }
    }

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i4 = 0;
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
            try {
                String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str.equals("android.permission.ACCESS_MOCK_LOCATION") && !applicationInfo.packageName.equals(context.getPackageName())) {
                            i4++;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e4) {
                j.e("Got exception " + e4.getMessage(), new Object[0]);
            }
        }
        return i4 > 0;
    }

    public static String b(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128)).toString();
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return packageName;
        }
    }

    public static List<String> c(Context context) {
        List<String> d4 = d(context, false);
        ArrayList arrayList = new ArrayList();
        for (String str : d4) {
            if (!f(context, str) && e(context, str, "android.permission.ACCESS_MOCK_LOCATION")) {
                arrayList.add(b(context, str));
            }
        }
        return arrayList;
    }

    public static List<String> d(Context context, boolean includeSystem) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        HashSet hashSet = new HashSet();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                hashSet.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(1000)) {
                hashSet.add(runningTaskInfo.topActivity.getPackageName());
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(1000)) {
                hashSet.add(runningServiceInfo.service.getPackageName());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return new ArrayList(hashSet);
    }

    public static boolean e(Context context, String app, String permission) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(app, 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str.equals(permission)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
        }
        return false;
    }

    public static boolean f(Context context, String app) {
        try {
            return (context.getPackageManager().getPackageInfo(app, 0).applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static void g(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            new l.b(activity).c("android.permission.QUERY_ALL_PACKAGES", "android.permission.GET_INSTALLED_APPS").d(new C0314a());
        }
    }
}
