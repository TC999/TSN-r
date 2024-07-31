package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.InternalAgent;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.analytics.pro.SessionIdManager;
import com.umeng.analytics.pro.UMDBConfig;
import com.umeng.analytics.pro.UMStoreManager;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.u */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SessionTracker implements SessionIdManager.InterfaceC13178a {

    /* renamed from: a */
    public static final String f38453a = "session_start_time";

    /* renamed from: b */
    public static final String f38454b = "session_end_time";

    /* renamed from: c */
    public static final String f38455c = "session_id";

    /* renamed from: d */
    public static final String f38456d = "pre_session_id";

    /* renamed from: e */
    public static final String f38457e = "a_start_time";

    /* renamed from: f */
    public static final String f38458f = "a_end_time";

    /* renamed from: g */
    public static final String f38459g = "fg_count";

    /* renamed from: h */
    private static String f38460h = null;

    /* renamed from: i */
    private static Context f38461i = null;

    /* renamed from: j */
    private static boolean f38462j = false;

    /* renamed from: k */
    private static long f38463k = 0;

    /* renamed from: l */
    private static boolean f38464l = true;

    /* renamed from: m */
    private static long f38465m;

    /* compiled from: SessionTracker.java */
    /* renamed from: com.umeng.analytics.pro.u$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13177a {

        /* renamed from: a */
        private static final SessionTracker f38466a = new SessionTracker();

        private C13177a() {
        }
    }

    /* renamed from: a */
    public static SessionTracker m14188a() {
        return C13177a.f38466a;
    }

    /* renamed from: b */
    public static void m14180b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38461i);
        if (sharedPreferences != null) {
            long j = sharedPreferences.getLong(f38459g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f38459g, j + 1);
                edit.commit();
            }
        }
    }

    /* renamed from: d */
    private void m14173d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f38459g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private String m14172e(Context context) {
        if (f38461i == null && context != null) {
            f38461i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        String m14148d = SessionIdManager.m14159a().m14148d(f38461i);
        try {
            m14171f(context);
            CoreProtocolImpl.m14274a(f38461i).m14253d((Object) null);
        } catch (Throwable unused) {
        }
        return m14148d;
    }

    /* renamed from: f */
    private void m14171f(Context context) {
        CoreProtocolImpl.m14274a(context).m14263b(context);
        CoreProtocolImpl.m14274a(context).m14254d();
    }

    /* renamed from: c */
    public void m14174c(Context context, Object obj) {
        try {
            if (f38461i == null && context != null) {
                f38461i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f38457e, 0L) == 0) {
                MLog.m13820e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f38458f, longValue);
            edit.putLong(f38454b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private SessionTracker() {
        SessionIdManager.m14159a().m14153a(this);
    }

    /* renamed from: a */
    public static long m14187a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f38459g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: a */
    public void m14186a(Context context, long j) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38461i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f38453a, j);
        edit.commit();
    }

    /* renamed from: b */
    public void m14177b(Context context, Object obj) {
        long longValue;
        try {
            if (f38461i == null) {
                f38461i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38461i);
            if (sharedPreferences == null) {
                return;
            }
            f38463k = sharedPreferences.getLong(f38458f, 0L);
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f38463k);
            String string = sharedPreferences.getString(UContent.f38102aF, "");
            String appVersionName = UMUtils.getAppVersionName(f38461i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f38453a, longValue);
                edit.commit();
                CoreProtocolImpl.m14274a(f38461i).m14271a((Object) null, true);
                String m14149c = SessionIdManager.m14159a().m14149c(f38461i);
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + m14149c);
                f38462j = true;
                m14185a(f38461i, longValue, true);
            } else if (SessionIdManager.m14159a().m14147e(f38461i)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f38462j = true;
                edit.putLong(f38453a, longValue);
                edit.commit();
                m14185a(f38461i, longValue, false);
            } else {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                f38462j = false;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m14184a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f38461i == null && context != null) {
                f38461i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38461i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(UContent.f38102aF, "");
            String appVersionName = UMUtils.getAppVersionName(f38461i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(UContent.f38102aF, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(UContent.f38102aF, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(UContent.f38102aF, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i);
                edit.putString("vers_name", string);
                edit.commit();
                if (f38464l) {
                    f38464l = false;
                }
                if (f38462j) {
                    f38462j = false;
                    m14178b(f38461i, longValue, true);
                    m14179b(f38461i, longValue);
                    return;
                }
                return;
            }
            if (f38462j) {
                f38462j = false;
                if (f38464l) {
                    f38464l = false;
                }
                f38460h = m14172e(context);
                MLog.m13826d("创建新会话: " + f38460h);
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f38460h);
                return;
            }
            f38460h = sharedPreferences.getString("session_id", null);
            edit.putLong(f38457e, longValue);
            edit.putLong(f38458f, 0L);
            edit.commit();
            MLog.m13826d("延续上一个会话: " + f38460h);
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Extend current session: " + f38460h);
            if (f38464l) {
                f38464l = false;
                if (FieldManager.allow(UMConstant.f39159E)) {
                    Context context2 = f38461i;
                    UMWorkDispatch.sendEventEx(context2, CoreProtocolImpl.C13167a.f38396E, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            m14171f(context);
            CoreProtocolImpl.m14274a(f38461i).m14266a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    /* renamed from: c */
    public String m14175c(Context context) {
        try {
            if (f38460h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f38460h;
    }

    @Deprecated
    /* renamed from: c */
    public String m14176c() {
        return m14175c(f38461i);
    }

    /* renamed from: b */
    public boolean m14178b(Context context, long j, boolean z) {
        SharedPreferences sharedPreferences;
        String m14156a;
        long j2;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (m14156a = SessionIdManager.m14159a().m14156a(f38461i)) == null) {
            return false;
        }
        long j3 = sharedPreferences.getLong(f38457e, 0L);
        long j4 = sharedPreferences.getLong(f38458f, 0L);
        if (j3 > 0 && j4 == 0) {
            z2 = true;
            if (z) {
                j2 = f38463k;
                if (j2 == 0) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j);
                    j2 = j;
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f38463k);
                }
                m14174c(f38461i, Long.valueOf(j2));
            } else {
                m14174c(f38461i, Long.valueOf(j));
                j2 = j;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38223g, j2);
            } else {
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38223g, j);
            }
            JSONObject m14818b = InternalAgent.m14841a().m14818b();
            if (m14818b != null && m14818b.length() > 0) {
                jSONObject.put("__sp", m14818b);
            }
            JSONObject m14812c = InternalAgent.m14841a().m14812c();
            if (m14812c != null && m14812c.length() > 0) {
                jSONObject.put("__pp", m14812c);
            }
            if (FieldManager.allow(UMConstant.f39159E)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f38465m);
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38224h, f38465m);
                f38465m = 0L;
            } else {
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38224h, 0L);
            }
            UMStoreManager.m14345a(context).m14339a(m14156a, jSONObject, UMStoreManager.EnumC13161a.END);
            CoreProtocolImpl.m14274a(f38461i).m14250e();
        }
        return z2;
    }

    /* renamed from: b */
    public void m14179b(Context context, long j) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            CoreProtocolImpl.m14274a(f38461i).m14257c((Object) null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String m14185a(Context context, long j, boolean z) {
        String m14151b = SessionIdManager.m14159a().m14151b(context);
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + m14151b);
        if (TextUtils.isEmpty(m14151b)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j);
            JSONObject m14818b = InternalAgent.m14841a().m14818b();
            if (m14818b != null && m14818b.length() > 0) {
                jSONObject.put("__sp", m14818b);
            }
            JSONObject m14812c = InternalAgent.m14841a().m14812c();
            if (m14812c != null && m14812c.length() > 0) {
                jSONObject.put("__pp", m14812c);
            }
            UMStoreManager.m14345a(context).m14339a(m14151b, jSONObject, UMStoreManager.EnumC13161a.INSTANTSESSIONBEGIN);
            CoreProtocolImpl.m14274a(context).m14271a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return m14151b;
    }

    @Deprecated
    /* renamed from: b */
    public String m14181b() {
        return f38460h;
    }

    @Override // com.umeng.analytics.pro.SessionIdManager.InterfaceC13178a
    /* renamed from: a */
    public void mo14140a(String str, String str2, long j, long j2, long j3) {
        m14183a(f38461i, str2, j, j2, j3);
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f38461i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.SessionIdManager.InterfaceC13178a
    /* renamed from: a */
    public void mo14141a(String str, long j, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m14182a(str, j);
    }

    /* renamed from: a */
    private void m14183a(Context context, String str, long j, long j2, long j3) {
        if (TextUtils.isEmpty(f38460h)) {
            f38460h = SessionIdManager.m14159a().m14156a(f38461i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f38460h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UMDBConfig.C13152d.C13153a.f38223g, j2);
            jSONObject.put(UMDBConfig.C13152d.C13153a.f38224h, j3);
            JSONObject m14818b = InternalAgent.m14841a().m14818b();
            if (m14818b != null && m14818b.length() > 0) {
                jSONObject.put("__sp", m14818b);
            }
            JSONObject m14812c = InternalAgent.m14841a().m14812c();
            if (m14812c != null && m14812c.length() > 0) {
                jSONObject.put("__pp", m14812c);
            }
            UMStoreManager.m14345a(context).m14339a(f38460h, jSONObject, UMStoreManager.EnumC13161a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j);
            UMStoreManager.m14345a(context).m14339a(str, jSONObject2, UMStoreManager.EnumC13161a.BEGIN);
            if (FieldManager.allow(UMConstant.f39159E)) {
                f38465m = j3;
                m14173d(context);
                Context context2 = f38461i;
                UMWorkDispatch.sendEventEx(context2, CoreProtocolImpl.C13167a.f38396E, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f38460h = str;
    }

    /* renamed from: a */
    private void m14182a(String str, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38461i);
        if (sharedPreferences == null) {
            return;
        }
        long j2 = sharedPreferences.getLong(f38454b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j);
            jSONObject.put(UMDBConfig.C13152d.C13153a.f38223g, j2);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(UContent.f38072C, location[0]);
                jSONObject2.put(UContent.f38073D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38221e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i = f38461i.getApplicationInfo().uid;
            if (i == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UContent.f38077H, longValue);
                jSONObject3.put(UContent.f38076G, longValue2);
                jSONObject.put(UMDBConfig.C13152d.C13153a.f38220d, jSONObject3);
            }
            UMStoreManager.m14345a(f38461i).m14339a(str, jSONObject, UMStoreManager.EnumC13161a.NEWSESSION);
            ViewPageTracker.m14168a(f38461i);
            AutoViewPageTracker.m14296c(f38461i);
        } catch (Throwable unused) {
        }
    }
}
