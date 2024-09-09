package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.stub.StubApp;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMInternalManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i_sdk_v", "1.2.0");
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", "1.2.0");
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e4) {
            UMCrashManager.reportCrash(context, e4);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    public static JSONObject d(Context context) {
        JSONObject b4;
        JSONArray h4;
        JSONObject a4;
        JSONArray l4;
        JSONArray k4;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (FieldManager.allow("inner_rs") && (k4 = k(origApplicationContext)) != null && k4.length() > 0) {
                    jSONObject2.put("rs", k4);
                }
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
            try {
                if (FieldManager.allow("inner_batt2") && (l4 = l(origApplicationContext)) != null && l4.length() > 0) {
                    jSONObject2.put("by", l4);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(origApplicationContext, e5);
            }
            try {
                a(origApplicationContext, jSONObject2);
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
            try {
                b(origApplicationContext, jSONObject2);
            } catch (Exception e7) {
                UMCrashManager.reportCrash(origApplicationContext, e7);
            }
            try {
                if (FieldManager.allow("inner_build2") && (a4 = a()) != null && a4.length() > 0) {
                    jSONObject2.put("build", a4);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(origApplicationContext, e8);
            }
            try {
                JSONObject e9 = e(origApplicationContext);
                if (e9 != null && e9.length() > 0) {
                    jSONObject2.put("scr", e9);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(origApplicationContext, e10);
            }
            try {
                JSONObject f4 = f(origApplicationContext);
                if (f4 != null && f4.length() > 0) {
                    jSONObject2.put("sinfo", f4);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(origApplicationContext, e11);
            }
            try {
                JSONArray g4 = g(origApplicationContext);
                if (g4 != null && g4.length() > 0) {
                    jSONObject2.put("input", g4);
                }
            } catch (Exception e12) {
                UMCrashManager.reportCrash(origApplicationContext, e12);
            }
            try {
                if (FieldManager.allow("inner_appls") && (h4 = h(origApplicationContext)) != null && h4.length() > 0) {
                    jSONObject2.put("appls", h4);
                }
            } catch (Exception e13) {
                UMCrashManager.reportCrash(origApplicationContext, e13);
            }
            try {
                JSONObject i4 = i(origApplicationContext);
                if (i4 != null && i4.length() > 0) {
                    jSONObject2.put("mem", i4);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(origApplicationContext, e14);
            }
            try {
                if (FieldManager.allow("inner_cpu2") && (b4 = b()) != null && b4.length() > 0) {
                    jSONObject2.put("cpu", b4);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("inner", jSONObject2);
            } catch (JSONException e15) {
                UMCrashManager.reportCrash(origApplicationContext, e15);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e4) {
                UMCrashManager.reportCrash(context, e4);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String packageName = origApplicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(origApplicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(origApplicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(origApplicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(origApplicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(origApplicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(origApplicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(origApplicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context origApplicationContext;
        List<InputMethodInfo> f4;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f4 = com.umeng.commonsdk.internal.utils.a.f((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            for (InputMethodInfo inputMethodInfo : f4) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(origApplicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context origApplicationContext;
        List<a.C1059a> g4;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (g4 = com.umeng.commonsdk.internal.utils.a.g((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null && !g4.isEmpty()) {
            for (a.C1059a c1059a : g4) {
                if (c1059a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c1059a.f53475a);
                        jSONObject.put("a_la", c1059a.f53476b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(origApplicationContext, e4);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context origApplicationContext;
        ActivityManager.MemoryInfo h4;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (h4 = com.umeng.commonsdk.internal.utils.a.h((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            try {
                jSONObject.put("t", h4.totalMem);
                jSONObject.put("f", h4.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, b.a(context).a(), null, 5000L);
            }
            UMRTLog.e("MobclickRT", "--->>> \u51b7\u542f\u52a8\uff1a5\u79d2\u540e\u89e6\u53d12\u53f7\u6570\u636e\u4ed3\u9057\u7559\u4fe1\u5c01\u68c0\u67e5\u52a8\u4f5c\u3002");
            UMWorkDispatch.sendEvent(context, 32787, b.a(context).a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i4 = 0; i4 < runningServices.size(); i4++) {
                if (runningServices.get(i4) != null && runningServices.get(i4).service != null && runningServices.get(i4).service.getClassName() != null && runningServices.get(i4).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i4).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i4).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject2.put("ls", jSONArray);
                } catch (JSONException unused2) {
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sers", jSONObject2);
                } catch (JSONException unused3) {
                }
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(jSONObject3);
                    return jSONArray2;
                } catch (Throwable th) {
                    th = th;
                    jSONArray = jSONArray2;
                    UMCrashManager.reportCrash(context, th);
                    return jSONArray;
                }
            }
            return jSONArray;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a4 = j.a(context);
        if (!TextUtils.isEmpty(a4)) {
            try {
                jSONArray.put(new JSONObject(a4));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a4 = com.umeng.commonsdk.internal.utils.d.a();
            if (a4 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("pro", a4.f53489a);
                    jSONObject.put("pla", a4.f53490b);
                    jSONObject.put("cpus", a4.f53491c);
                    jSONObject.put("fea", a4.f53492d);
                    jSONObject.put("imp", a4.f53493e);
                    jSONObject.put("arc", a4.f53494f);
                    jSONObject.put("var", a4.f53495g);
                    jSONObject.put("par", a4.f53496h);
                    jSONObject.put("rev", a4.f53497i);
                    jSONObject.put("har", a4.f53498j);
                    jSONObject.put("rev", a4.f53499k);
                    jSONObject.put("ser", a4.f53500l);
                    jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                    jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                    jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z3) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z3) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            int i4 = Build.VERSION.SDK_INT;
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            int i5 = 0;
            if (i4 >= 21) {
                JSONArray jSONArray = new JSONArray();
                int i6 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i6]);
                    i6++;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                int i7 = 0;
                while (true) {
                    String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
                    if (i7 >= strArr2.length) {
                        break;
                    }
                    jSONArray2.put(strArr2[i7]);
                    i7++;
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                while (true) {
                    String[] strArr3 = Build.SUPPORTED_ABIS;
                    if (i5 >= strArr3.length) {
                        break;
                    }
                    jSONArray3.put(strArr3[i5]);
                    i5++;
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a4 = k.a(context);
            if (TextUtils.isEmpty(a4)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a4);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has("_gdf_r")) {
                    jSONObject.put("_gdf_r", jSONObject2.opt("_gdf_r"));
                }
                if (jSONObject2.has("_thm_z")) {
                    jSONObject.put("_thm_z", jSONObject2.opt("_thm_z"));
                }
                if (jSONObject2.has("_dsk_s")) {
                    jSONObject.put("_dsk_s", jSONObject2.opt("_dsk_s"));
                }
            } catch (Exception unused) {
            }
        }
    }
}
