package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.ApplicationLayerUtil;
import com.umeng.commonsdk.internal.utils.CpuUtil;
import com.umeng.commonsdk.internal.utils.UMInternalUtils;
import com.umeng.commonsdk.internal.utils.UMProbe;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMInternalManager {
    /* renamed from: a */
    public static void m13953a(Context context) {
        try {
            ULog.m13781i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UMCommonContent.f37787aQ, UMInternalConfig.f38793e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, m13946d(context), UMServerURL.PATH_ANALYTICS, "i", UMInternalConfig.f38793e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.m13781i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    /* renamed from: b */
    public static void m13949b(Context context) {
        ULog.m13781i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            m13940j(context);
        }
    }

    /* renamed from: c */
    public static void m13947c(Context context) {
        ULog.m13781i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        m13940j(context);
    }

    /* renamed from: d */
    public static JSONObject m13946d(Context context) {
        JSONObject m13950b;
        JSONArray m13942h;
        JSONObject m13954a;
        JSONArray m13938l;
        JSONArray m13939k;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (FieldManager.allow(UMConstant.f39164J) && (m13939k = m13939k(origApplicationContext)) != null && m13939k.length() > 0) {
                    jSONObject2.put("rs", m13939k);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
            try {
                if (FieldManager.allow(UMConstant.f39196ao) && (m13938l = m13938l(origApplicationContext)) != null && m13938l.length() > 0) {
                    jSONObject2.put("by", m13938l);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(origApplicationContext, e2);
            }
            try {
                m13952a(origApplicationContext, jSONObject2);
            } catch (Exception e3) {
                UMCrashManager.reportCrash(origApplicationContext, e3);
            }
            try {
                m13948b(origApplicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
            try {
                if (FieldManager.allow(UMConstant.f39197ap) && (m13954a = m13954a()) != null && m13954a.length() > 0) {
                    jSONObject2.put("build", m13954a);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(origApplicationContext, e5);
            }
            try {
                JSONObject m13945e = m13945e(origApplicationContext);
                if (m13945e != null && m13945e.length() > 0) {
                    jSONObject2.put("scr", m13945e);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
            try {
                JSONObject m13944f = m13944f(origApplicationContext);
                if (m13944f != null && m13944f.length() > 0) {
                    jSONObject2.put("sinfo", m13944f);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(origApplicationContext, e7);
            }
            try {
                JSONArray m13943g = m13943g(origApplicationContext);
                if (m13943g != null && m13943g.length() > 0) {
                    jSONObject2.put("input", m13943g);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(origApplicationContext, e8);
            }
            try {
                if (FieldManager.allow(UMConstant.f39188ag) && (m13942h = m13942h(origApplicationContext)) != null && m13942h.length() > 0) {
                    jSONObject2.put("appls", m13942h);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(origApplicationContext, e9);
            }
            try {
                JSONObject m13941i = m13941i(origApplicationContext);
                if (m13941i != null && m13941i.length() > 0) {
                    jSONObject2.put("mem", m13941i);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(origApplicationContext, e10);
            }
            try {
                if (FieldManager.allow(UMConstant.f39198aq) && (m13950b = m13950b()) != null && m13950b.length() > 0) {
                    jSONObject2.put("cpu", m13950b);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(UMCommonContent.f37820ax, jSONObject2);
            } catch (JSONException e11) {
                UMCrashManager.reportCrash(origApplicationContext, e11);
            }
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static JSONObject m13945e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", ApplicationLayerUtil.m13930c(context));
                jSONObject.put("a_nav_h", ApplicationLayerUtil.m13927d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: f */
    public static JSONObject m13944f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String packageName = origApplicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", ApplicationLayerUtil.m13935a(origApplicationContext, packageName));
                jSONObject.put("a_alut", ApplicationLayerUtil.m13932b(origApplicationContext, packageName));
                jSONObject.put("a_c", ApplicationLayerUtil.m13929c(origApplicationContext, packageName));
                jSONObject.put("a_uid", ApplicationLayerUtil.m13926d(origApplicationContext, packageName));
                if (ApplicationLayerUtil.m13937a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", ApplicationLayerUtil.m13934b());
                jSONObject.put("s_fs", ApplicationLayerUtil.m13936a(origApplicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(origApplicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(origApplicationContext));
                jSONObject.put("st", ApplicationLayerUtil.m13931c());
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
                jSONObject.put("hn", ApplicationLayerUtil.m13928d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: g */
    public static JSONArray m13943g(Context context) {
        Context origApplicationContext;
        List<InputMethodInfo> m13923f;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m13923f = ApplicationLayerUtil.m13923f((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            for (InputMethodInfo inputMethodInfo : m13923f) {
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

    /* renamed from: h */
    public static JSONArray m13942h(Context context) {
        Context origApplicationContext;
        List<ApplicationLayerUtil.C13229a> m13922g;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m13922g = ApplicationLayerUtil.m13922g((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null && !m13922g.isEmpty()) {
            for (ApplicationLayerUtil.C13229a c13229a : m13922g) {
                if (c13229a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c13229a.f38839a);
                        jSONObject.put("a_la", c13229a.f38840b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(origApplicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: i */
    public static JSONObject m13941i(Context context) {
        Context origApplicationContext;
        ActivityManager.MemoryInfo m13921h;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (m13921h = ApplicationLayerUtil.m13921h((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            try {
                jSONObject.put(UMCommonContent.f37782aL, m13921h.totalMem);
                jSONObject.put("f", m13921h.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }

    /* renamed from: j */
    private static void m13940j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, UMInternalConfig.f38794f, UMInternalData.m13974a(context).m13975a(), null, 5000L);
            }
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, UMInternalConfig.f38810v, UMInternalData.m13974a(context).m13975a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: k */
    private static JSONArray m13939k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i = 0; i < runningServices.size(); i++) {
                if (runningServices.get(i) != null && runningServices.get(i).service != null && runningServices.get(i).service.getClassName() != null && runningServices.get(i).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
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

    /* renamed from: l */
    private static JSONArray m13938l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String m13900a = UMInternalUtils.m13900a(context);
        if (!TextUtils.isEmpty(m13900a)) {
            try {
                jSONArray.put(new JSONObject(m13900a));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    private static JSONObject m13950b() {
        try {
            CpuUtil.C13232a m13912a = CpuUtil.m13912a();
            if (m13912a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("pro", m13912a.f38853a);
                    jSONObject.put("pla", m13912a.f38854b);
                    jSONObject.put("cpus", m13912a.f38855c);
                    jSONObject.put("fea", m13912a.f38856d);
                    jSONObject.put(PathCenter.f37684c, m13912a.f38857e);
                    jSONObject.put("arc", m13912a.f38858f);
                    jSONObject.put("var", m13912a.f38859g);
                    jSONObject.put("par", m13912a.f38860h);
                    jSONObject.put("rev", m13912a.f38861i);
                    jSONObject.put("har", m13912a.f38862j);
                    jSONObject.put("rev", m13912a.f38863k);
                    jSONObject.put("ser", m13912a.f38864l);
                    jSONObject.put("cur_cpu", CpuUtil.m13909d());
                    jSONObject.put("max_cpu", CpuUtil.m13911b());
                    jSONObject.put("min_cpu", CpuUtil.m13910c());
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

    /* renamed from: a */
    private static void m13952a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m13951a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        m13951a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        m13951a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        m13951a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        m13951a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    /* renamed from: a */
    private static void m13951a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static JSONObject m13954a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            int i = Build.VERSION.SDK_INT;
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            int i2 = 0;
            if (i >= 21) {
                JSONArray jSONArray = new JSONArray();
                int i3 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i3]);
                    i3++;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                int i4 = 0;
                while (true) {
                    String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
                    if (i4 >= strArr2.length) {
                        break;
                    }
                    jSONArray2.put(strArr2[i4]);
                    i4++;
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                while (true) {
                    String[] strArr3 = Build.SUPPORTED_ABIS;
                    if (i2 >= strArr3.length) {
                        break;
                    }
                    jSONArray3.put(strArr3[i2]);
                    i2++;
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

    /* renamed from: b */
    private static void m13948b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String m13897a = UMProbe.m13897a(context);
            if (TextUtils.isEmpty(m13897a)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(m13897a);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(UMProbe.f38876d)) {
                    jSONObject.put(UMProbe.f38876d, jSONObject2.opt(UMProbe.f38876d));
                }
                if (jSONObject2.has(UMProbe.f38875c)) {
                    jSONObject.put(UMProbe.f38875c, jSONObject2.opt(UMProbe.f38875c));
                }
                if (jSONObject2.has(UMProbe.f38874b)) {
                    jSONObject.put(UMProbe.f38874b, jSONObject2.opt(UMProbe.f38874b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
