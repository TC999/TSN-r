package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class InstalledAppInfoManager {

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AppPackageInfo implements Serializable {
        private static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    /* renamed from: a */
    public static AppPackageInfo m24280a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null) {
            appPackageInfo.isSystemApp = m24281a(applicationInfo) || m24278b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && C11017ak.m24114an(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    /* renamed from: b */
    private static boolean m24278b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    @NonNull
    /* renamed from: bW */
    public static Map<String, AppPackageInfo> m24277bW(Context context) {
        ActivityInfo activityInfo;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (C11028au.m24064Ms()) {
            try {
                List<String> m24063Mt = C11028au.m24063Mt();
                if (m24063Mt != null && !m24063Mt.isEmpty()) {
                    for (String str : new ArrayList(m24063Mt)) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (packageInfo != null) {
                                AppPackageInfo m24280a = m24280a(packageInfo, packageManager);
                                m24280a.reportMethod = 3;
                                hashMap.put(m24280a.packageName, m24280a);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return hashMap;
        }
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h != null && C11120o.m23758Lm()) {
            try {
                List<String> m23878dh = C11059bi.m23878dh(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                        String str2 = resolveInfo.activityInfo.packageName;
                        if (m23878dh != null && !m23878dh.isEmpty()) {
                            m23878dh.remove(str2);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo m24280a2 = m24280a(packageInfo2, packageManager);
                            m24280a2.reportMethod = 1;
                            hashMap.put(m24280a2.packageName, m24280a2);
                        }
                    }
                }
                if (m23878dh != null && !m23878dh.isEmpty()) {
                    for (String str3 : m23878dh) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(str3, 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo m24280a3 = m24280a(packageInfo3, packageManager);
                                m24280a3.reportMethod = 2;
                                hashMap.put(m24280a3.packageName, m24280a3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            hashMap.putAll(m24275d(context, interfaceC10970h.mo24317yG()));
        }
        return hashMap;
    }

    @NonNull
    /* renamed from: c */
    public static JSONArray[] m24276c(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (context == null || list == null || list.isEmpty() || interfaceC10970h == null || !C11120o.m23758Lm()) {
            return jSONArrayArr;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    AppPackageInfo m24280a = m24280a(packageInfo, packageManager);
                    hashMap.put(m24280a.packageName, m24280a);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    hashMap2.put(str, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                hashMap2.put(str, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = m24274h(hashMap);
        jSONArrayArr[1] = m24274h(hashMap2);
        return jSONArrayArr;
    }

    @NonNull
    /* renamed from: d */
    private static Map<String, AppPackageInfo> m24275d(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo m24280a = m24280a(packageInfo, packageManager);
                        hashMap.put(m24280a.packageName, m24280a);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    @NonNull
    /* renamed from: h */
    public static JSONArray m24274h(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : map.keySet()) {
                AppPackageInfo appPackageInfo = map.get(str);
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    C11126t.m23679a(jSONArray, m24279a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m24282a(final Context context, final InterfaceC10761a<JSONArray> interfaceC10761a) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.InstalledAppInfoManager.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                interfaceC10761a.accept(InstalledAppInfoManager.m24274h(InstalledAppInfoManager.m24277bW(context)));
            }
        });
    }

    /* renamed from: a */
    public static JSONObject m24279a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        C11126t.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        C11126t.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        C11126t.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        C11126t.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        C11126t.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        C11126t.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    /* renamed from: a */
    private static boolean m24281a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
