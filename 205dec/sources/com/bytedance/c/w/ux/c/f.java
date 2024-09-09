package com.bytedance.c.w.ux.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: t  reason: collision with root package name */
    private static com.bytedance.c.w.f f26584t;

    /* renamed from: a  reason: collision with root package name */
    private Application f26585a;

    /* renamed from: b  reason: collision with root package name */
    private Context f26586b;

    /* renamed from: g  reason: collision with root package name */
    private String f26591g;

    /* renamed from: h  reason: collision with root package name */
    private long f26592h;

    /* renamed from: i  reason: collision with root package name */
    private String f26593i;

    /* renamed from: j  reason: collision with root package name */
    private long f26594j;

    /* renamed from: k  reason: collision with root package name */
    private String f26595k;

    /* renamed from: l  reason: collision with root package name */
    private long f26596l;

    /* renamed from: m  reason: collision with root package name */
    private String f26597m;

    /* renamed from: n  reason: collision with root package name */
    private long f26598n;

    /* renamed from: o  reason: collision with root package name */
    private String f26599o;

    /* renamed from: p  reason: collision with root package name */
    private long f26600p;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f26587c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<Long> f26588d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f26589e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private List<Long> f26590f = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f26601q = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f26602r = false;

    /* renamed from: s  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f26603s = new a();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String c4;
            f fVar = f.this;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            fVar.f26591g = c4;
            f.this.f26592h = System.currentTimeMillis();
            f.this.f26587c.add(f.this.f26591g);
            f.this.f26588d.add(Long.valueOf(f.this.f26592h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String c4;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            int indexOf = f.this.f26587c.indexOf(c4);
            if (indexOf > -1 && indexOf < f.this.f26587c.size()) {
                f.this.f26587c.remove(indexOf);
                f.this.f26588d.remove(indexOf);
            }
            f.this.f26589e.add(c4);
            f.this.f26590f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String c4;
            f fVar = f.this;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            fVar.f26597m = c4;
            f.this.f26598n = System.currentTimeMillis();
            f.h(f.this);
            if (f.this.f26601q <= 0) {
                f.this.f26602r = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String c4;
            f fVar = f.this;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            fVar.f26595k = c4;
            f.this.f26596l = System.currentTimeMillis();
            f.this.f26602r = true;
            f.q(f.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String c4;
            f fVar = f.this;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            fVar.f26593i = c4;
            f.this.f26594j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String c4;
            f fVar = f.this;
            if (f.f26584t == null) {
                c4 = activity.getClass().getName();
            } else {
                c4 = f.f26584t.c(activity);
            }
            fVar.f26599o = c4;
            f.this.f26600p = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(@NonNull Context context) {
        this.f26586b = context;
        if (context instanceof Application) {
            this.f26585a = (Application) context;
        }
        t();
    }

    private JSONObject e(String str, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    static /* synthetic */ int h(f fVar) {
        int i4 = fVar.f26601q;
        fVar.f26601q = i4 - 1;
        return i4;
    }

    private JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f26587c;
        if (list != null && !list.isEmpty()) {
            for (int i4 = 0; i4 < this.f26587c.size(); i4++) {
                try {
                    jSONArray.put(e(this.f26587c.get(i4), this.f26588d.get(i4).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray l() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f26589e;
        if (list != null && !list.isEmpty()) {
            for (int i4 = 0; i4 < this.f26589e.size(); i4++) {
                try {
                    jSONArray.put(e(this.f26589e.get(i4), this.f26590f.get(i4).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    static /* synthetic */ int q(f fVar) {
        int i4 = fVar.f26601q;
        fVar.f26601q = i4 + 1;
        return i4;
    }

    private void t() {
        Application application = this.f26585a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.f26603s);
        }
    }

    public boolean B() {
        return this.f26602r;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", e(this.f26591g, this.f26592h));
            jSONObject.put("last_start_activity", e(this.f26593i, this.f26594j));
            jSONObject.put("last_resume_activity", e(this.f26595k, this.f26596l));
            jSONObject.put("last_pause_activity", e(this.f26597m, this.f26598n));
            jSONObject.put("last_stop_activity", e(this.f26599o, this.f26600p));
            jSONObject.put("alive_activities", i());
            jSONObject.put("finish_activities", l());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0005, B:6:0x0012, B:9:0x001a, B:10:0x001e, B:12:0x0024, B:14:0x002c, B:17:0x0031), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray x() {
        /*
            r6 = this;
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            android.content.Context r1 = r6.f26586b     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Exception -> L77
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L12
            return r0
        L12:
            r2 = 5
            java.util.List r1 = r1.getRunningTasks(r2)     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L1a
            return r0
        L1a:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L77
        L1e:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L77
            if (r2 == 0) goto L77
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L77
            android.app.ActivityManager$RunningTaskInfo r2 = (android.app.ActivityManager.RunningTaskInfo) r2     // Catch: java.lang.Exception -> L77
            if (r2 == 0) goto L1e
            android.content.ComponentName r3 = r2.baseActivity     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L31
            goto L1e
        L31:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.<init>()     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "id"
            int r5 = r2.id     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "package_name"
            android.content.ComponentName r5 = r2.baseActivity     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r5 = r5.getPackageName()     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "description"
            java.lang.CharSequence r5 = r2.description     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "number_of_activities"
            int r5 = r2.numActivities     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "number_of_running_activities"
            int r5 = r2.numRunning     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "topActivity"
            android.content.ComponentName r5 = r2.topActivity     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r5 = r5.toString()     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r5)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r4 = "baseActivity"
            android.content.ComponentName r2 = r2.baseActivity     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            java.lang.String r2 = r2.toString()     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r3.put(r4, r2)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            r0.put(r3)     // Catch: org.json.JSONException -> L1e java.lang.Exception -> L77
            goto L1e
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.c.w.ux.c.f.x():org.json.JSONArray");
    }
}
