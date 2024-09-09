package com.acse.ottn;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static Application f6129a;

    public static void a(Application application) {
        f6129a = application;
    }

    public static Application b() {
        return f6129a;
    }

    public static void c(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static void d(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(1, 2);
    }

    public static void a() {
        a4.b().a();
    }

    public static void b(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    public static boolean a(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance == 400) {
                    Log.i("\u540e\u53f0", next.processName);
                    return true;
                }
                Log.i("\u524d\u53f0", next.processName);
            }
        }
        return false;
    }

    public static void a(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    public static void a(View view, Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
    }
}
