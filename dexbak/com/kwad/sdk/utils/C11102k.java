package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.stub.StubApp;
import java.util.Locale;

/* renamed from: com.kwad.sdk.utils.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11102k {
    public static String aOC;
    public static String aOD;

    /* renamed from: M */
    public static String m23781M(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageInfo packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: bQ */
    public static String m23780bQ(Context context) {
        if (!TextUtils.isEmpty(aOC)) {
            return aOC;
        }
        try {
            PackageInfo packageInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                aOC = str;
                return str;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: bR */
    public static String m23779bR(Context context) {
        if (!TextUtils.isEmpty(aOD)) {
            return aOD;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            String string = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            aOD = string;
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: bS */
    public static int m23778bS(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    /* renamed from: bT */
    public static int m23777bT(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return (int) (displayMetrics.widthPixels / displayMetrics.density);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: bU */
    public static int m23776bU(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return (int) (displayMetrics.heightPixels / displayMetrics.density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }
}
