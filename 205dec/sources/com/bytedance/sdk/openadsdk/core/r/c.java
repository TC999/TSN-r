package com.bytedance.sdk.openadsdk.core.r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import com.stub.StubApp;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f34515c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f34516w;
    private static String xv;

    public static String c() {
        return "open_news";
    }

    public static String c(Context context) {
        try {
        } catch (Throwable th) {
            a.xv("getApplicationName:", th);
        }
        if (f34515c != null) {
            return f34515c;
        }
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.keySet() != null) {
            for (String str : bundle.keySet()) {
                if (str != null && str.toLowerCase().contains("channel")) {
                    Object obj = bundle.get(str);
                    jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                }
            }
        }
        f34515c = jSONObject.toString();
        return f34515c;
    }

    @HungeonFlag
    public static String ev() {
        if (!TextUtils.isEmpty(xv)) {
            return xv;
        }
        String xv2 = ux.c().xv("app_sha1", 2592000000L);
        xv = xv2;
        if (!TextUtils.isEmpty(xv2)) {
            return xv;
        }
        String c4 = com.bytedance.sdk.component.utils.xv.c(ls.getContext());
        xv = c4;
        if (c(c4)) {
            xv = xv.toUpperCase(Locale.getDefault());
            ux.c().ux("app_sha1", xv);
            return xv;
        }
        return "";
    }

    public static String f() {
        return ys.r(ls.getContext());
    }

    public static String r() {
        return i.xv();
    }

    public static String sr() {
        return wv.p();
    }

    public static String ux() {
        return k.sr().gd();
    }

    public static String w() {
        return "1371";
    }

    public static String w(Context context) {
        if (f34516w != null) {
            return f34516w;
        }
        try {
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            f34516w = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return f34516w;
    }

    public static int xv(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static String xv() {
        return "6.1.0.6";
    }

    private static boolean c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String str2 : split) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
