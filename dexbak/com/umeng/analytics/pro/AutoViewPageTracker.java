package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.InternalAgent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.UMDBConfig;
import com.umeng.analytics.pro.UMStoreManager;
import com.umeng.analytics.vshelper.PageLifeCycle;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.analytics.vshelper.RealTimeDebugSwitch;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(14)
/* renamed from: com.umeng.analytics.pro.l */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AutoViewPageTracker {

    /* renamed from: a */
    public static String f38339a;

    /* renamed from: b */
    boolean f38348b;

    /* renamed from: c */
    boolean f38349c;

    /* renamed from: f */
    PageLifeCycle f38350f;

    /* renamed from: g */
    Application.ActivityLifecycleCallbacks f38351g;

    /* renamed from: h */
    private final Map<String, Long> f38352h;

    /* renamed from: l */
    private boolean f38353l;

    /* renamed from: m */
    private int f38354m;

    /* renamed from: n */
    private int f38355n;

    /* renamed from: i */
    private static JSONArray f38342i = new JSONArray();

    /* renamed from: j */
    private static Object f38343j = new Object();

    /* renamed from: k */
    private static Application f38344k = null;

    /* renamed from: d */
    static String f38340d = null;

    /* renamed from: e */
    static int f38341e = -1;

    /* renamed from: o */
    private static boolean f38345o = true;

    /* renamed from: p */
    private static Object f38346p = new Object();

    /* renamed from: q */
    private static AppLifeCycle f38347q = new RealTimeDebugSwitch();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoViewPageTracker.java */
    /* renamed from: com.umeng.analytics.pro.l$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13164a {

        /* renamed from: a */
        private static final AutoViewPageTracker f38357a = new AutoViewPageTracker();

        private C13164a() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m14306a(AutoViewPageTracker autoViewPageTracker) {
        int i = autoViewPageTracker.f38355n;
        autoViewPageTracker.f38355n = i - 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ int m14300b(AutoViewPageTracker autoViewPageTracker) {
        int i = autoViewPageTracker.f38354m;
        autoViewPageTracker.f38354m = i - 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ int m14291e(AutoViewPageTracker autoViewPageTracker) {
        int i = autoViewPageTracker.f38355n;
        autoViewPageTracker.f38355n = i + 1;
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ int m14289f(AutoViewPageTracker autoViewPageTracker) {
        int i = autoViewPageTracker.f38354m;
        autoViewPageTracker.f38354m = i + 1;
        return i;
    }

    /* renamed from: g */
    private void m14288g() {
        if (this.f38353l) {
            return;
        }
        this.f38353l = true;
        if (f38344k != null) {
            f38344k.registerActivityLifecycleCallbacks(this.f38351g);
        }
    }

    private AutoViewPageTracker() {
        this.f38352h = new HashMap();
        this.f38353l = false;
        this.f38348b = false;
        this.f38349c = false;
        this.f38354m = 0;
        this.f38355n = 0;
        this.f38350f = PageNameMonitor.getInstance();
        this.f38351g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                AutoViewPageTracker.f38347q.mo14116a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(UMConstant.f39160F)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (AutoViewPageTracker.f38346p) {
                        if (AutoViewPageTracker.f38345o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    AutoViewPageTracker.this.m14297c(activity);
                    InternalAgent.m14841a().m14790i();
                    AutoViewPageTracker.this.f38348b = false;
                    AutoViewPageTracker.f38347q.mo14109d(activity);
                } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    InternalAgent.m14841a().m14790i();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(UMConstant.f39160F)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (AutoViewPageTracker.f38346p) {
                        if (AutoViewPageTracker.f38345o) {
                            boolean unused = AutoViewPageTracker.f38345o = false;
                        }
                    }
                    AutoViewPageTracker.this.m14309a(activity);
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    AutoViewPageTracker.this.m14309a(activity);
                }
                AutoViewPageTracker.f38347q.mo14111c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (AutoViewPageTracker.this.f38354m <= 0) {
                        if (AutoViewPageTracker.f38340d == null) {
                            AutoViewPageTracker.f38340d = UUID.randomUUID().toString();
                        }
                        if (AutoViewPageTracker.f38341e == -1) {
                            AutoViewPageTracker.f38341e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (AutoViewPageTracker.f38341e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            InternalAgent m14841a = InternalAgent.m14841a();
                            if (m14841a != null) {
                                m14841a.m14831a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            AutoViewPageTracker.f38341e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, UMLogAnalytics.f38313ar);
                            }
                        } else if (AutoViewPageTracker.f38341e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", AutoViewPageTracker.f38340d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (InternalAgent.m14841a() != null) {
                                InternalAgent.m14841a().m14831a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (AutoViewPageTracker.this.f38355n < 0) {
                        AutoViewPageTracker.m14291e(AutoViewPageTracker.this);
                    } else {
                        AutoViewPageTracker.m14289f(AutoViewPageTracker.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        AutoViewPageTracker.m14306a(AutoViewPageTracker.this);
                        return;
                    }
                    AutoViewPageTracker.m14300b(AutoViewPageTracker.this);
                    if (AutoViewPageTracker.this.f38354m <= 0) {
                        if (AutoViewPageTracker.f38341e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i = AutoViewPageTracker.f38341e;
                        if (i == 1 || (i == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", AutoViewPageTracker.f38340d);
                            hashMap.put(MediationConstant.KEY_REASON, "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            InternalAgent m14841a = InternalAgent.m14841a();
                            if (m14841a != null) {
                                m14841a.m14831a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (AutoViewPageTracker.f38340d != null) {
                                AutoViewPageTracker.f38340d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f38344k != null) {
                m14288g();
            }
        }
    }

    /* renamed from: c */
    public void m14298c() {
        m14297c((Activity) null);
        m14303b();
    }

    /* renamed from: b */
    public void m14301b(Context context) {
        synchronized (f38346p) {
            if (f38345o) {
                f38345o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                String localClassName = globleActivity.getLocalClassName();
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + localClassName);
                m14309a(globleActivity);
                return;
            }
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    /* renamed from: c */
    public static void m14296c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f38343j) {
                    jSONArray = f38342i.toString();
                    f38342i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(UMDBConfig.C13152d.C13153a.f38219c, new JSONArray(jSONArray));
                    UMStoreManager.m14345a(context).m14339a(SessionTracker.m14188a().m14176c(), jSONObject, UMStoreManager.EnumC13161a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public boolean m14310a() {
        return this.f38353l;
    }

    /* renamed from: a */
    public static synchronized AutoViewPageTracker m14308a(Context context) {
        AutoViewPageTracker autoViewPageTracker;
        synchronized (AutoViewPageTracker.class) {
            if (f38344k == null && context != null) {
                if (context instanceof Activity) {
                    f38344k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f38344k = (Application) context;
                }
            }
            autoViewPageTracker = C13164a.f38357a;
        }
        return autoViewPageTracker;
    }

    /* renamed from: a */
    public static void m14307a(Context context, String str) {
        if (f38341e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f38340d);
            hashMap.put(MediationConstant.KEY_REASON, str);
            if (f38340d != null) {
                f38340d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                InternalAgent.m14841a().m14831a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    /* renamed from: b */
    public void m14303b() {
        this.f38353l = false;
        if (f38344k != null) {
            f38344k.unregisterActivityLifecycleCallbacks(this.f38351g);
            f38344k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14297c(Activity activity) {
        long j;
        long j2;
        try {
            synchronized (this.f38352h) {
                if (f38339a == null && activity != null) {
                    f38339a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j = 0;
                if (TextUtils.isEmpty(f38339a) || !this.f38352h.containsKey(f38339a)) {
                    j2 = 0;
                } else {
                    long longValue = this.f38352h.get(f38339a).longValue();
                    this.f38352h.remove(f38339a);
                    j = System.currentTimeMillis() - longValue;
                    j2 = longValue;
                }
            }
            synchronized (f38343j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UContent.f38157v, f38339a);
                    jSONObject.put("duration", j);
                    jSONObject.put(UContent.f38159x, j2);
                    jSONObject.put("type", 0);
                    f38342i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    private void m14302b(Activity activity) {
        f38339a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f38352h) {
            this.f38352h.put(f38339a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14309a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f38346p) {
                    InternalAgent.m14841a().m14792h();
                }
            }
        } else if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f38350f.activityResume(str);
            if (this.f38348b) {
                this.f38348b = false;
                if (!TextUtils.isEmpty(f38339a)) {
                    if (f38339a.equals(str)) {
                        return;
                    }
                    m14302b(activity);
                    synchronized (f38346p) {
                        InternalAgent.m14841a().m14792h();
                    }
                    return;
                }
                f38339a = str;
                return;
            }
            m14302b(activity);
            synchronized (f38346p) {
                InternalAgent.m14841a().m14792h();
            }
        }
    }
}
