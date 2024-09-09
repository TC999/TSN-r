package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {
    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
        }
        return !activity.isFinishing();
    }

    public static Activity b(Context context) {
        int i4;
        Activity a4 = a(context);
        int i5 = 0;
        if (a(a4)) {
            i4 = 0;
        } else {
            int i6 = a4 == null ? 1 : 2;
            Activity a5 = p.b().a();
            if (!a(a5)) {
                i5 = a5 == null ? 1 : 2;
                GDTLogger.e("\u6ca1\u6709\u83b7\u53d6\u5230Activity\uff0c\u5c06\u4f1a\u5f71\u54cd\u5f39\u7a97\u5c55\u793a\uff01\u8bf7\u5c1d\u8bd5\uff1a1\u3001\u5b9e\u4f8b\u5316\u5e7f\u544a\u65f6Context\u4f20\u5165Activity\uff0c\u5e76\u4fdd\u8bc1\u4f20\u5165\u7684Activity\u4e0d\u88ab\u9500\u6bc1\uff1b2\u3001\u63d0\u65e9\u521d\u59cb\u5316SDK");
            }
            i4 = i6;
            a4 = a5;
        }
        com.qq.e.comm.plugin.n0.v.a(9130071, null, Integer.valueOf(i4), Integer.valueOf(i5), null);
        return a4;
    }

    public static Activity a(Context context) {
        if (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Activity a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        Activity a4 = a(rootView.getContext());
        if (a4 != null) {
            return a4;
        }
        if (rootView instanceof ViewGroup) {
            return a((ViewGroup) rootView);
        }
        return null;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "always_finish_activities", 0) == 1;
    }

    private static Activity a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt != null) {
                Activity a4 = a(childAt.getContext());
                if (a4 != null) {
                    return a4;
                }
                if (childAt instanceof ViewGroup) {
                    return a((ViewGroup) childAt);
                }
            }
        }
        return null;
    }

    public static void a() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (com.qq.e.comm.plugin.d0.a.d().f().a("bappf", 1) == 0) {
            return;
        }
        try {
            Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
            if ((Build.VERSION.SDK_INT < 23 || a4.checkSelfPermission("android.permission.REORDER_TASKS") == 0) && (runningTasks = (activityManager = (ActivityManager) a4.getSystemService("activity")).getRunningTasks(20)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (a4.getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e4) {
            d1.a("open opt bring to front failed", e4);
        }
    }
}
