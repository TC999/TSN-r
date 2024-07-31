package com.acse.ottn.p045e;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.acse.ottn.util.C1632Ha;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;

/* renamed from: com.acse.ottn.e.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1552b {

    /* renamed from: a */
    private static Application f2897a;

    /* renamed from: a */
    public static void m56447a() {
        C1632Ha.m56256b().m56258a();
    }

    /* renamed from: a */
    public static void m56446a(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    /* renamed from: a */
    public static void m56445a(Application application) {
        f2897a = application;
    }

    /* renamed from: a */
    public static void m56443a(View view, Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
    }

    /* renamed from: a */
    public static boolean m56444a(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance == 400) {
                    Log.i("后台", next.processName);
                    return true;
                }
                Log.i("前台", next.processName);
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Application m56442b() {
        return f2897a;
    }

    /* renamed from: b */
    public static void m56441b(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    /* renamed from: c */
    public static void m56440c(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* renamed from: d */
    public static void m56439d(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(1, 2);
    }
}
