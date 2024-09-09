package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SessionTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class u implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f53124a = "session_start_time";

    /* renamed from: b  reason: collision with root package name */
    public static final String f53125b = "session_end_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53126c = "session_id";

    /* renamed from: d  reason: collision with root package name */
    public static final String f53127d = "pre_session_id";

    /* renamed from: e  reason: collision with root package name */
    public static final String f53128e = "a_start_time";

    /* renamed from: f  reason: collision with root package name */
    public static final String f53129f = "a_end_time";

    /* renamed from: g  reason: collision with root package name */
    public static final String f53130g = "fg_count";

    /* renamed from: h  reason: collision with root package name */
    private static String f53131h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Context f53132i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f53133j = false;

    /* renamed from: k  reason: collision with root package name */
    private static long f53134k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f53135l = true;

    /* renamed from: m  reason: collision with root package name */
    private static long f53136m;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: SessionTracker.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final u f53137a = new u();

        private a() {
        }
    }

    public static u a() {
        return a.f53137a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53132i);
        if (sharedPreferences != null) {
            long j4 = sharedPreferences.getLong("fg_count", 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong("fg_count", j4 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong("fg_count", 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f53132i == null && context != null) {
            f53132i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        String d4 = y.a().d(f53132i);
        try {
            f(context);
            o.a(f53132i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d4;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f53132i == null && context != null) {
                f53132i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong("a_start_time", 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i("MobclickRT", "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong("a_end_time", longValue);
            edit.putLong("session_end_time", longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong("fg_count", 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j4) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53132i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong("session_start_time", j4);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f53132i == null) {
                f53132i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53132i);
            if (sharedPreferences == null) {
                return;
            }
            f53134k = sharedPreferences.getLong("a_end_time", 0L);
            UMRTLog.i("MobclickRT", "------>>> lastActivityEndTime: " + f53134k);
            String string = sharedPreferences.getString("versionname", "");
            String appVersionName = UMUtils.getAppVersionName(f53132i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i("MobclickRT", "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong("session_start_time", longValue);
                edit.commit();
                o.a(f53132i).a((Object) null, true);
                String c4 = y.a().c(f53132i);
                UMRTLog.i("MobclickRT", "--->>> force generate new session: session id = " + c4);
                f53133j = true;
                a(f53132i, longValue, true);
            } else if (y.a().e(f53132i)) {
                UMRTLog.i("MobclickRT", "--->>> More then 30 sec from last session.");
                f53133j = true;
                edit.putLong("session_start_time", longValue);
                edit.commit();
                a(f53132i, longValue, false);
            } else {
                UMRTLog.i("MobclickRT", "--->>> less then 30 sec from last session, do nothing.");
                f53133j = false;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f53132i == null && context != null) {
                f53132i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53132i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString("versionname", "");
            String appVersionName = UMUtils.getAppVersionName(f53132i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString("versionname", appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i("MobclickRT", "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i4 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString("versionname", "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString("versionname", appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i4);
                edit.putString("vers_name", string);
                edit.commit();
                if (f53135l) {
                    f53135l = false;
                }
                if (f53133j) {
                    f53133j = false;
                    b(f53132i, longValue, true);
                    b(f53132i, longValue);
                    return;
                }
                return;
            }
            if (f53133j) {
                f53133j = false;
                if (f53135l) {
                    f53135l = false;
                }
                f53131h = e(context);
                MLog.d("\u521b\u5efa\u65b0\u4f1a\u8bdd: " + f53131h);
                UMRTLog.i("MobclickRT", "mSessionChanged flag has been set, Start new session: " + f53131h);
                return;
            }
            f53131h = sharedPreferences.getString("session_id", null);
            edit.putLong("a_start_time", longValue);
            edit.putLong("a_end_time", 0L);
            edit.commit();
            MLog.d("\u5ef6\u7eed\u4e0a\u4e00\u4e2a\u4f1a\u8bdd: " + f53131h);
            UMRTLog.i("MobclickRT", "Extend current session: " + f53131h);
            if (f53135l) {
                f53135l = false;
                if (FieldManager.allow("header_foreground_count")) {
                    Context context2 = f53132i;
                    UMWorkDispatch.sendEventEx(context2, 8213, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            o.a(f53132i).a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f53131h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f53131h;
    }

    @Deprecated
    public String c() {
        return c(f53132i);
    }

    public boolean b(Context context, long j4, boolean z3) {
        SharedPreferences sharedPreferences;
        String a4;
        long j5;
        boolean z4 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (a4 = y.a().a(f53132i)) == null) {
            return false;
        }
        long j6 = sharedPreferences.getLong("a_start_time", 0L);
        long j7 = sharedPreferences.getLong("a_end_time", 0L);
        if (j6 > 0 && j7 == 0) {
            z4 = true;
            if (z3) {
                j5 = f53134k;
                if (j5 == 0) {
                    UMRTLog.i("MobclickRT", "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j4);
                    j5 = j4;
                } else {
                    UMRTLog.i("MobclickRT", "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f53134k);
                }
                c(f53132i, Long.valueOf(j5));
            } else {
                c(f53132i, Long.valueOf(j4));
                j5 = j4;
            }
            JSONObject jSONObject = new JSONObject();
            if (z3) {
                jSONObject.put("__f", j5);
            } else {
                jSONObject.put("__f", j4);
            }
            JSONObject b4 = com.umeng.analytics.b.a().b();
            if (b4 != null && b4.length() > 0) {
                jSONObject.put("__sp", b4);
            }
            JSONObject c4 = com.umeng.analytics.b.a().c();
            if (c4 != null && c4.length() > 0) {
                jSONObject.put("__pp", c4);
            }
            if (FieldManager.allow("header_foreground_count")) {
                UMRTLog.e("MobclickRT", "--->>>*** foregroundCount = " + f53136m);
                jSONObject.put("__g", f53136m);
                f53136m = 0L;
            } else {
                jSONObject.put("__g", 0L);
            }
            i.a(context).a(a4, jSONObject, i.a.END);
            o.a(f53132i).e();
        }
        return z4;
    }

    public void b(Context context, long j4) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f53132i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j4, boolean z3) {
        String b4 = y.a().b(context);
        UMRTLog.i("MobclickRT", "--->>> onInstantSessionInternal: current session id = " + b4);
        if (TextUtils.isEmpty(b4)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j4);
            JSONObject b5 = com.umeng.analytics.b.a().b();
            if (b5 != null && b5.length() > 0) {
                jSONObject.put("__sp", b5);
            }
            JSONObject c4 = com.umeng.analytics.b.a().c();
            if (c4 != null && c4.length() > 0) {
                jSONObject.put("__pp", c4);
            }
            i.a(context).a(b4, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z3);
        } catch (Throwable unused) {
        }
        return b4;
    }

    @Deprecated
    public String b() {
        return f53131h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j4, long j5, long j6) {
        a(f53132i, str2, j4, j5, j6);
        UMRTLog.i("MobclickRT", "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f53132i;
            UMWorkDispatch.sendEvent(context, 36945, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j4, long j5, long j6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j4);
    }

    private void a(Context context, String str, long j4, long j5, long j6) {
        if (TextUtils.isEmpty(f53131h)) {
            f53131h = y.a().a(f53132i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f53131h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__f", j5);
            jSONObject.put("__g", j6);
            JSONObject b4 = com.umeng.analytics.b.a().b();
            if (b4 != null && b4.length() > 0) {
                jSONObject.put("__sp", b4);
            }
            JSONObject c4 = com.umeng.analytics.b.a().c();
            if (c4 != null && c4.length() > 0) {
                jSONObject.put("__pp", c4);
            }
            i.a(context).a(f53131h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j4);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow("header_foreground_count")) {
                f53136m = j6;
                d(context);
                Context context2 = f53132i;
                UMWorkDispatch.sendEventEx(context2, 8213, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f53131h = str;
    }

    private void a(String str, long j4) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53132i);
        if (sharedPreferences == null) {
            return;
        }
        long j5 = sharedPreferences.getLong("session_end_time", 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j4);
            jSONObject.put("__f", j5);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put("__d", jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i4 = f53132i.getApplicationInfo().uid;
            if (i4 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i4))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i4))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("download_traffic", longValue);
                jSONObject3.put("upload_traffic", longValue2);
                jSONObject.put("__c", jSONObject3);
            }
            i.a(f53132i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f53132i);
            l.c(f53132i);
        } catch (Throwable unused) {
        }
    }
}
