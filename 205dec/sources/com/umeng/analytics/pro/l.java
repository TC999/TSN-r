package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AutoViewPageTracker.java */
@TargetApi(14)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f53017a;

    /* renamed from: b  reason: collision with root package name */
    boolean f53026b;

    /* renamed from: c  reason: collision with root package name */
    boolean f53027c;

    /* renamed from: f  reason: collision with root package name */
    com.umeng.analytics.vshelper.a f53028f;

    /* renamed from: g  reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f53029g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Long> f53030h;

    /* renamed from: l  reason: collision with root package name */
    private boolean f53031l;

    /* renamed from: m  reason: collision with root package name */
    private int f53032m;

    /* renamed from: n  reason: collision with root package name */
    private int f53033n;

    /* renamed from: i  reason: collision with root package name */
    private static JSONArray f53020i = new JSONArray();

    /* renamed from: j  reason: collision with root package name */
    private static Object f53021j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static Application f53022k = null;

    /* renamed from: d  reason: collision with root package name */
    static String f53018d = null;

    /* renamed from: e  reason: collision with root package name */
    static int f53019e = -1;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f53023o = true;

    /* renamed from: p  reason: collision with root package name */
    private static Object f53024p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private static bn f53025q = new com.umeng.analytics.vshelper.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: AutoViewPageTracker.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final l f53035a = new l();

        private a() {
        }
    }

    static /* synthetic */ int a(l lVar) {
        int i4 = lVar.f53033n;
        lVar.f53033n = i4 - 1;
        return i4;
    }

    static /* synthetic */ int b(l lVar) {
        int i4 = lVar.f53032m;
        lVar.f53032m = i4 - 1;
        return i4;
    }

    static /* synthetic */ int e(l lVar) {
        int i4 = lVar.f53033n;
        lVar.f53033n = i4 + 1;
        return i4;
    }

    static /* synthetic */ int f(l lVar) {
        int i4 = lVar.f53032m;
        lVar.f53032m = i4 + 1;
        return i4;
    }

    private void g() {
        if (this.f53031l) {
            return;
        }
        this.f53031l = true;
        if (f53022k != null) {
            f53022k.registerActivityLifecycleCallbacks(this.f53029g);
        }
    }

    private l() {
        this.f53030h = new HashMap();
        this.f53031l = false;
        this.f53026b = false;
        this.f53027c = false;
        this.f53032m = 0;
        this.f53033n = 0;
        this.f53028f = PageNameMonitor.getInstance();
        this.f53029g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.f53025q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow("header_first_resume")) {
                    UMRTLog.i("MobclickRT", "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.f53024p) {
                        if (l.f53023o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i("MobclickRT", "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.f53026b = false;
                    l.f53025q.d(activity);
                } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow("header_first_resume")) {
                    UMRTLog.i("MobclickRT", "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.f53024p) {
                        if (l.f53023o) {
                            boolean unused = l.f53023o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i("MobclickRT", "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.f53025q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f53032m <= 0) {
                        if (l.f53018d == null) {
                            l.f53018d = UUID.randomUUID().toString();
                        }
                        if (l.f53019e == -1) {
                            l.f53019e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f53019e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a4 = com.umeng.analytics.b.a();
                            if (a4 != null) {
                                a4.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            l.f53019e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, "\u8bf7\u5728Application.onCreate\u51fd\u6570\u4e2d\u4f7f\u7528UMConfigure.preInit\u51fd\u6570\u521d\u59cb\u5316\u53cb\u76dfsdk");
                            }
                        } else if (l.f53019e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", l.f53018d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (l.this.f53033n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f53032m <= 0) {
                        if (l.f53019e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i4 = l.f53019e;
                        if (i4 == 1 || (i4 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", l.f53018d);
                            hashMap.put("reason", "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a4 = com.umeng.analytics.b.a();
                            if (a4 != null) {
                                a4.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (l.f53018d != null) {
                                l.f53018d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f53022k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f53024p) {
            if (f53023o) {
                f53023o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e("MobclickRT", "--->>> init\u89e6\u53d1onResume: \u65e0\u524d\u53f0Activity\uff0c\u76f4\u63a5\u9000\u51fa\u3002");
                    return;
                }
                String localClassName = globleActivity.getLocalClassName();
                UMRTLog.e("MobclickRT", "--->>> init\u89e6\u53d1onResume: \u8865\u6551\u6210\u529f\uff0c\u524d\u53f0Activity\u540d\uff1a" + localClassName);
                a(globleActivity);
                return;
            }
            UMRTLog.e("MobclickRT", "--->>> init\u89e6\u53d1onResume: firstResumeCall = false\uff0c\u76f4\u63a5\u8fd4\u56de\u3002");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f53021j) {
                    jSONArray = f53020i.toString();
                    f53020i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__b", new JSONArray(jSONArray));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f53031l;
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (f53022k == null && context != null) {
                if (context instanceof Activity) {
                    f53022k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f53022k = (Application) context;
                }
            }
            lVar = a.f53035a;
        }
        return lVar;
    }

    public static void a(Context context, String str) {
        if (f53019e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f53018d);
            hashMap.put("reason", str);
            if (f53018d != null) {
                f53018d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f53031l = false;
        if (f53022k != null) {
            f53022k.unregisterActivityLifecycleCallbacks(this.f53029g);
            f53022k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j4;
        long j5;
        try {
            synchronized (this.f53030h) {
                if (f53017a == null && activity != null) {
                    f53017a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j4 = 0;
                if (TextUtils.isEmpty(f53017a) || !this.f53030h.containsKey(f53017a)) {
                    j5 = 0;
                } else {
                    long longValue = this.f53030h.get(f53017a).longValue();
                    this.f53030h.remove(f53017a);
                    j4 = System.currentTimeMillis() - longValue;
                    j5 = longValue;
                }
            }
            synchronized (f53021j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_name", f53017a);
                    jSONObject.put("duration", j4);
                    jSONObject.put("page_start", j5);
                    jSONObject.put("type", 0);
                    f53020i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f53017a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f53030h) {
            this.f53030h.put(f53017a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f53024p) {
                    com.umeng.analytics.b.a().h();
                }
            }
        } else if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f53028f.activityResume(str);
            if (this.f53026b) {
                this.f53026b = false;
                if (!TextUtils.isEmpty(f53017a)) {
                    if (f53017a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f53024p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f53017a = str;
                return;
            }
            b(activity);
            synchronized (f53024p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
