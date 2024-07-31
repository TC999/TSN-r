package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.filter.EventBlackList;
import com.umeng.analytics.filter.EventWhiteList;
import com.umeng.analytics.pro.ActivityManualPageTracker;
import com.umeng.analytics.pro.AutoViewPageTracker;
import com.umeng.analytics.pro.BackgroundMonitor;
import com.umeng.analytics.pro.BackgroundWatcher;
import com.umeng.analytics.pro.C13171p;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.analytics.pro.EventTracker;
import com.umeng.analytics.pro.OnAppCrashHandler;
import com.umeng.analytics.pro.SessionIdManager;
import com.umeng.analytics.pro.SessionTracker;
import com.umeng.analytics.pro.UContent;
import com.umeng.analytics.pro.UMLogAnalytics;
import com.umeng.analytics.pro.UMStoreManager;
import com.umeng.analytics.pro.ViewPageTracker;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class InternalAgent implements BackgroundWatcher, OnAppCrashHandler {

    /* renamed from: A */
    private static final String f37543A = "umsp_2";

    /* renamed from: B */
    private static final String f37544B = "umsp_3";

    /* renamed from: C */
    private static final String f37545C = "umsp_4";

    /* renamed from: D */
    private static final String f37546D = "umsp_5";

    /* renamed from: a */
    private static Context f37547a = null;

    /* renamed from: h */
    private static final String f37548h = "sp_uapp";

    /* renamed from: i */
    private static final String f37549i = "prepp_uapp";

    /* renamed from: o */
    private static final int f37550o = 128;

    /* renamed from: p */
    private static final int f37551p = 256;

    /* renamed from: q */
    private static String f37552q = "";

    /* renamed from: r */
    private static String f37553r = "";

    /* renamed from: t */
    private static final String f37555t = "ekv_bl_ver";

    /* renamed from: w */
    private static final String f37557w = "ekv_wl_ver";

    /* renamed from: z */
    private static final String f37558z = "umsp_1";

    /* renamed from: b */
    private ISysListener f37559b;

    /* renamed from: c */
    private C13171p f37560c;

    /* renamed from: d */
    private ViewPageTracker f37561d;

    /* renamed from: e */
    private ActivityManualPageTracker f37562e;

    /* renamed from: f */
    private SessionTracker f37563f;

    /* renamed from: g */
    private AutoViewPageTracker f37564g;

    /* renamed from: j */
    private boolean f37565j;

    /* renamed from: k */
    private volatile JSONObject f37566k;

    /* renamed from: l */
    private volatile JSONObject f37567l;

    /* renamed from: m */
    private volatile JSONObject f37568m;

    /* renamed from: n */
    private boolean f37569n;

    /* renamed from: u */
    private EventBlackList f37570u;

    /* renamed from: x */
    private EventWhiteList f37571x;

    /* renamed from: y */
    private BackgroundMonitor f37572y;

    /* renamed from: s */
    private static final String f37554s = UContent.f38128ar;

    /* renamed from: v */
    private static final String f37556v = UContent.f38129as;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalAgent.java */
    /* renamed from: com.umeng.analytics.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13106a {

        /* renamed from: a */
        private static final InternalAgent f37573a = new InternalAgent();

        private C13106a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f37547a = StubApp.getOrigApplicationContext(appContext.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static InternalAgent m14841a() {
        return C13106a.f37573a;
    }

    /* renamed from: i */
    private void m14789i(Context context) {
        try {
            if (context == null) {
                MLog.m13820e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            }
            if (this.f37567l == null) {
                this.f37567l = new JSONObject();
            }
            String string = sharedPreferences.getString(f37549i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f37568m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f37568m == null) {
                this.f37568m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    public JSONObject m14818b() {
        return this.f37566k;
    }

    /* renamed from: c */
    public JSONObject m14812c() {
        return this.f37568m;
    }

    /* renamed from: d */
    public JSONObject m14807d() {
        return this.f37567l;
    }

    /* renamed from: e */
    public void m14803e() {
        this.f37567l = null;
    }

    /* renamed from: f */
    public String m14799f() {
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("getOnResumedActivityName can not be called in child process");
            return null;
        }
        return f37552q;
    }

    /* renamed from: g */
    public String m14795g() {
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("getOnPausedActivityName can not be called in child process");
            return null;
        }
        return f37553r;
    }

    /* renamed from: h */
    public void m14792h() {
        try {
            Context context = f37547a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.m13820e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38409k, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f37547a;
                UMWorkDispatch.sendEvent(context3, CoreProtocolImpl.C13167a.f38405g, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f37559b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m14788j() {
        try {
            Context context = f37547a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.m13820e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f37547a;
            UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38404f, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f37547a;
            UMWorkDispatch.sendEvent(context3, CoreProtocolImpl.C13167a.f38413o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13818e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    /* renamed from: k */
    public synchronized void m14787k() {
        Context context;
        try {
            context = f37547a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f37566k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f37547a).edit();
            edit.putString(f37548h, this.f37566k.toString());
            edit.commit();
        } else {
            this.f37566k = new JSONObject();
        }
    }

    /* renamed from: l */
    public synchronized JSONObject m14786l() {
        Context context;
        try {
            context = f37547a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f37566k == null) {
            this.f37566k = new JSONObject();
        }
        return this.f37566k;
    }

    /* renamed from: m */
    public synchronized void m14785m() {
        try {
            Context context = f37547a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.m13820e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                    return;
                }
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f37547a).edit();
                edit.remove(f37548h);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.BackgroundWatcher
    /* renamed from: n */
    public void mo14278n() {
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.m14032b()) {
            if (FieldManager.allow(UMConstant.f39158D)) {
                if (UMWorkDispatch.eventHasExist(CoreProtocolImpl.C13167a.f38393B)) {
                    return;
                }
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f37547a;
                UMWorkDispatch.sendEvent(context, CoreProtocolImpl.C13167a.f38393B, CoreProtocol.getInstance(context), null);
                return;
            }
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
        }
    }

    private InternalAgent() {
        this.f37560c = new C13171p();
        this.f37561d = new ViewPageTracker();
        this.f37562e = new ActivityManualPageTracker();
        this.f37563f = SessionTracker.m14188a();
        this.f37564g = null;
        this.f37565j = false;
        this.f37566k = null;
        this.f37567l = null;
        this.f37568m = null;
        this.f37569n = false;
        this.f37570u = null;
        this.f37571x = null;
        this.f37572y = null;
        this.f37560c.m14217a(this);
    }

    /* renamed from: e */
    private boolean m14800e(String str) {
        if (this.f37570u.enabled() && this.f37570u.matchHit(str)) {
            return true;
        }
        if (this.f37571x.enabled()) {
            if (this.f37571x.matchHit(str)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m14838a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f37570u == null) {
                EventBlackList eventBlackList = new EventBlackList(f37554s, "ekv_bl_ver");
                this.f37570u = eventBlackList;
                eventBlackList.register(f37547a);
            }
            if (this.f37571x == null) {
                EventWhiteList eventWhiteList = new EventWhiteList(f37556v, "ekv_wl_ver");
                this.f37571x = eventWhiteList;
                eventWhiteList.register(f37547a);
            }
            if (UMUtils.isMainProgress(f37547a)) {
                if (!this.f37565j) {
                    this.f37565j = true;
                    m14789i(f37547a);
                }
                synchronized (this) {
                    if (!this.f37569n) {
                        AutoViewPageTracker m14308a = AutoViewPageTracker.m14308a(context);
                        this.f37564g = m14308a;
                        if (m14308a.m14310a()) {
                            this.f37569n = true;
                        }
                        this.f37572y = BackgroundMonitor.m14286a();
                        try {
                            BackgroundMonitor.m14285a(context);
                            this.f37572y.m14282a(this);
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(UMLogAnalytics.f38270B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f37547a));
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m14814b(String str) {
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f37561d.m14165b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m14811c(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38328p, 0, "\\|");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("onPause can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.m14015aq(UMLogAnalytics.f38329q, 2, "\\|");
            }
            try {
                if (!this.f37565j || !this.f37569n) {
                    m14838a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f37562e.m14165b(context.getClass().getName());
                }
                m14790i();
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.m13818e("Exception occurred in Mobclick.onRause(). ", th);
                }
            }
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f37553r = context.getClass().getName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m14806d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("onKillProcess can not be called in child process");
                return;
            }
            AutoViewPageTracker autoViewPageTracker = this.f37564g;
            if (autoViewPageTracker != null) {
                autoViewPageTracker.m14298c();
            }
            AutoViewPageTracker.m14307a(context, "onKillProcess");
            ActivityManualPageTracker activityManualPageTracker = this.f37562e;
            if (activityManualPageTracker != null) {
                activityManualPageTracker.m14166b();
            }
            ViewPageTracker viewPageTracker = this.f37561d;
            if (viewPageTracker != null) {
                viewPageTracker.m14166b();
            }
            Context context2 = f37547a;
            if (context2 != null) {
                SessionTracker sessionTracker = this.f37563f;
                if (sessionTracker != null) {
                    sessionTracker.m14174c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                CoreProtocolImpl.m14274a(f37547a).m14254d();
                ViewPageTracker.m14168a(f37547a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    AutoViewPageTracker.m14296c(f37547a);
                }
                PreferenceWrapper.getDefault(f37547a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public synchronized void m14798f(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38303ah, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        this.f37566k = new JSONObject();
        Context context2 = f37547a;
        UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38419u, CoreProtocol.getInstance(context2), null);
    }

    /* renamed from: g */
    public synchronized void m14794g(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38311ap, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (this.f37568m.length() > 0) {
            Context context2 = f37547a;
            UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38423y, CoreProtocol.getInstance(context2), null);
        }
        this.f37568m = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m14817b(Context context) {
        if (context == null) {
            MLog.m13820e("unexpected null context in onResume");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("onResume can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.m14015aq(UMLogAnalytics.f38327o, 2, "\\|");
            }
            try {
                if (!this.f37565j || !this.f37569n) {
                    m14838a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f37562e.m14167a(context.getClass().getName());
                }
                m14792h();
                if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                    f37552q = context.getClass().getName();
                }
            } catch (Throwable th) {
                MLog.m13818e("Exception occurred in Mobclick.onResume(). ", th);
            }
        }
    }

    /* renamed from: e */
    public synchronized Object m14801e(Context context, String str) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38304ai, 0, "\\|");
            return null;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("getSuperProperty can not be called in child process");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            UMLog.m14015aq(UMLogAnalytics.f38302ag, 0, "\\|");
            return null;
        } else if (!str.equals(f37558z) && !str.equals(f37543A) && !str.equals(f37544B) && !str.equals(f37545C) && !str.equals(f37546D)) {
            MLog.m13820e("please check key or value, must be correct!");
            return null;
        } else {
            if (this.f37566k != null) {
                if (this.f37566k.has(str)) {
                    return this.f37566k.opt(str);
                }
            } else {
                this.f37566k = new JSONObject();
            }
            return null;
        }
    }

    /* renamed from: h */
    public synchronized JSONObject m14791h(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38312aq, 0, "\\|");
            return null;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (this.f37568m == null) {
            this.f37568m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f37568m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f37568m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* renamed from: i */
    public void m14790i() {
        try {
            Context context = f37547a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.m13820e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38406h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f37547a;
                UMWorkDispatch.sendEvent(context3, CoreProtocolImpl.C13167a.f38402d, CoreProtocol.getInstance(context3), null);
                Context context4 = f37547a;
                UMWorkDispatch.sendEvent(context4, 4099, CoreProtocol.getInstance(context4), null);
                Context context5 = f37547a;
                UMWorkDispatch.sendEvent(context5, CoreProtocolImpl.C13167a.f38407i, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f37559b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    /* renamed from: f */
    public synchronized void m14797f(Context context, String str) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38309an, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (this.f37568m == null) {
            this.f37568m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f37568m.has(str)) {
                this.f37568m.remove(str);
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38422x, CoreProtocol.getInstance(context2), this.f37568m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.m14015aq(UMLogAnalytics.f38310ao, 0, "\\|");
            }
            return;
        }
        MLog.m13820e("please check propertics, property is null!");
    }

    /* renamed from: g */
    private boolean m14793g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.m13820e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m14810c(Context context, String str) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38338z, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("setSecret can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        AnalyticsConfig.m14844a(f37547a, str);
    }

    /* renamed from: d */
    public synchronized void m14805d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38303ah, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.m14015aq(UMLogAnalytics.f38302ag, 0, "\\|");
        } else if (!str.equals(f37558z) && !str.equals(f37543A) && !str.equals(f37544B) && !str.equals(f37545C) && !str.equals(f37546D)) {
            MLog.m13820e("please check key or value, must be correct!");
        } else {
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            }
            if (this.f37566k.has(str)) {
                this.f37566k.remove(str);
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38420v, CoreProtocol.getInstance(context2), str);
            }
        }
    }

    /* renamed from: b */
    public void m14816b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.m14015aq(UMLogAnalytics.f38282N, 0, "\\|");
                return;
            }
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f37565j || !this.f37569n) {
                m14838a(f37547a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(UContent.f38107aK, str);
                m14829a(f37547a, UContent.f38106aJ, (Map<String, Object>) hashMap, -1L, false);
                return;
            }
            UMLog.m14015aq(UMLogAnalytics.f38283O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13816e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14823a(String str) {
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f37561d.m14167a(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m14808c(String str, Object obj) {
        int i;
        if (TextUtils.isEmpty(str)) {
            MLog.m13820e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i = 0;
        }
        if (i > 128) {
            MLog.m13820e("key length is " + i + ", please check key, illegal");
            return false;
        } else if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length > 256) {
                MLog.m13820e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
                return false;
            }
            return true;
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        } else {
            MLog.m13820e("value is " + obj + ", please check value, type illegal");
            return false;
        }
    }

    /* renamed from: e */
    public synchronized String m14802e(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38304ai, 0, "\\|");
            return null;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("getSuperProperties can not be called in child process");
            return null;
        } else if (this.f37566k != null) {
            return this.f37566k.toString();
        } else {
            this.f37566k = new JSONObject();
            return null;
        }
    }

    /* renamed from: a */
    public void m14825a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("setSysListener can not be called in child process");
        } else {
            this.f37559b = iSysListener;
        }
    }

    /* renamed from: a */
    public void m14837a(Context context, int i) {
        if (context == null) {
            MLog.m13820e("unexpected null context in setVerticalType");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        AnalyticsConfig.m14845a(f37547a, i);
    }

    /* renamed from: b */
    private void m14813b(String str, Object obj) {
        try {
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            }
            int i = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i < strArr.length) {
                        if (strArr[i] != null && !HelperUtils.checkStrLen(strArr[i], 256)) {
                            jSONArray.put(strArr[i]);
                        }
                        i++;
                    }
                    this.f37566k.put(str, jSONArray);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i < jArr.length) {
                        jSONArray2.put(jArr[i]);
                        i++;
                    }
                    this.f37566k.put(str, jSONArray2);
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i < iArr.length) {
                        jSONArray3.put(iArr[i]);
                        i++;
                    }
                    this.f37566k.put(str, jSONArray3);
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i < fArr.length) {
                        jSONArray4.put(fArr[i]);
                        i++;
                    }
                    this.f37566k.put(str, jSONArray4);
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i < dArr.length) {
                        jSONArray5.put(dArr[i]);
                        i++;
                    }
                    this.f37566k.put(str, jSONArray5);
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i < sArr.length) {
                        jSONArray6.put((int) sArr[i]);
                        i++;
                    }
                    this.f37566k.put(str, jSONArray6);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i < list.size()) {
                    Object obj2 = list.get(i);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i));
                    }
                    i++;
                }
                this.f37566k.put(str, jSONArray7);
            } else if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f37566k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    private boolean m14796f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.m13820e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    /* renamed from: c */
    public void m14809c(String str) {
        if (m14793g(str)) {
            m14822a(UContent.f38084O, (Object) str);
        }
    }

    /* renamed from: a */
    public void m14832a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f37565j || !this.f37569n) {
                m14838a(f37547a);
            }
            String str2 = "";
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            } else {
                str2 = this.f37566k.toString();
            }
            EventTracker.m14204a(f37547a).m14200a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13816e(th);
            }
        }
    }

    /* renamed from: d */
    public void m14804d(String str) {
        if (m14793g(str)) {
            m14822a(UContent.f38085P, (Object) str);
        }
    }

    /* renamed from: a */
    void m14835a(Context context, String str) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38335w, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("reportError can not be called in child process");
        } else if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.m14015aq(UMLogAnalytics.f38336x, 0, "\\|");
            }
        } else {
            try {
                if (!this.f37565j || !this.f37569n) {
                    m14838a(f37547a);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(UContent.f38092W, 2);
                jSONObject.put("context", str);
                jSONObject.put("__ii", this.f37563f.m14176c());
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38408j, CoreProtocol.getInstance(context2), jSONObject);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.m13816e(th);
                }
            }
        }
    }

    /* renamed from: a */
    void m14828a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f37547a)) {
                MLog.m13820e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f37565j || !this.f37569n) {
                    m14838a(f37547a);
                }
                m14835a(f37547a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e) {
                if (MLog.DEBUG) {
                    MLog.m13816e(e);
                    return;
                }
                return;
            }
        }
        UMLog.m14015aq(UMLogAnalytics.f38337y, 0, "\\|");
    }

    /* renamed from: a */
    public void m14833a(Context context, String str, String str2, long j, int i) {
        if (context == null) {
            return;
        }
        try {
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f37565j || !this.f37569n) {
                m14838a(f37547a);
            }
            if (m14800e(str)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            } else {
                str3 = this.f37566k.toString();
            }
            EventTracker.m14204a(f37547a).m14202a(str, str2, j, i, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13816e(th);
            }
        }
    }

    /* renamed from: b */
    public synchronized void m14815b(Object obj) {
        Context context;
        try {
            context = f37547a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f37547a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f37549i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(f37549i).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14830a(Context context, String str, Map<String, Object> map, long j) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13816e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(UContent.f38108aL).contains(str)) {
                UMLog.m14015aq(UMLogAnalytics.f38314b, 0, "\\|");
                return;
            } else if (map.isEmpty()) {
                UMLog.m14015aq(UMLogAnalytics.f38316d, 0, "\\|");
                return;
            } else {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (Arrays.asList(UContent.f38108aL).contains(entry.getKey())) {
                        UMLog.m14015aq(UMLogAnalytics.f38317e, 0, "\\|");
                        return;
                    }
                }
                m14829a(context, str, map, j, false);
                return;
            }
        }
        UMLog.m14015aq(UMLogAnalytics.f38315c, 0, "\\|");
    }

    /* renamed from: a */
    public void m14831a(Context context, String str, Map<String, Object> map) {
        m14829a(context, str, map, -1L, true);
    }

    /* renamed from: a */
    private void m14829a(Context context, String str, Map<String, Object> map, long j, boolean z) {
        try {
            if (context == null) {
                MLog.m13820e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f37547a == null) {
                f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f37565j || !this.f37569n) {
                m14838a(f37547a);
            }
            if (m14800e(str)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f37566k == null) {
                this.f37566k = new JSONObject();
            } else {
                str2 = this.f37566k.toString();
            }
            EventTracker.m14204a(f37547a).m14201a(str, map, j, str2, z);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13816e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.OnAppCrashHandler
    /* renamed from: a */
    public void mo14189a(Throwable th) {
        try {
            Context context = f37547a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.m13820e("onAppCrash can not be called in child process");
            } else if (AnalyticsConfig.enable) {
                ViewPageTracker viewPageTracker = this.f37561d;
                if (viewPageTracker != null) {
                    viewPageTracker.m14166b();
                }
                AutoViewPageTracker.m14307a(f37547a, "onAppCrash");
                ActivityManualPageTracker activityManualPageTracker = this.f37562e;
                if (activityManualPageTracker != null) {
                    activityManualPageTracker.m14166b();
                }
                AutoViewPageTracker autoViewPageTracker = this.f37564g;
                if (autoViewPageTracker != null) {
                    autoViewPageTracker.m14298c();
                }
                SessionTracker sessionTracker = this.f37563f;
                if (sessionTracker != null) {
                    sessionTracker.m14174c(f37547a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(UContent.f38092W, 1);
                    jSONObject.put("context", DataHelper.convertExceptionToString(th));
                    UMStoreManager.m14345a(f37547a).m14342a(this.f37563f.m14176c(), jSONObject.toString(), 1);
                }
                CoreProtocolImpl.m14274a(f37547a).m14254d();
                ViewPageTracker.m14168a(f37547a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    AutoViewPageTracker.m14296c(f37547a);
                }
                PreferenceWrapper.getDefault(f37547a).edit().commit();
            }
        } catch (Exception e) {
            if (MLog.DEBUG) {
                MLog.m13818e("Exception in onAppCrash", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14821a(String str, String str2) {
        try {
            Context context = f37547a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.m13820e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UContent.f38082M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f37547a;
            UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38403e, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f37547a;
            UMWorkDispatch.sendEvent(context3, CoreProtocolImpl.C13167a.f38413o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13818e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14819a(boolean z) {
        Context context = f37547a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("setCatchUncaughtExceptions can not be called in child process");
        } else if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
        } else {
            AnalyticsConfig.CATCH_EXCEPTION = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14820a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14840a(double d, double d2) {
        Context context = f37547a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f37520a == null) {
            AnalyticsConfig.f37520a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f37520a;
        dArr[0] = d;
        dArr[1] = d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14836a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.m13820e("unexpected null context in setScenarioType");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            m14837a(f37547a, eScenarioType.toValue());
        }
        if (this.f37565j && this.f37569n) {
            return;
        }
        m14838a(f37547a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14839a(long j) {
        Context context = f37547a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("setSessionContinueMillis can not be called in child process");
            return;
        }
        AnalyticsConfig.kContinueSessionMillis = j;
        SessionIdManager.m14159a().m14158a(AnalyticsConfig.kContinueSessionMillis);
    }

    /* renamed from: a */
    public synchronized void m14834a(Context context, String str, Object obj) {
        int i = 0;
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38301af, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f37558z) && !str.equals(f37543A) && !str.equals(f37544B) && !str.equals(f37545C) && !str.equals(f37546D)) {
                MLog.m13820e("property name is " + str + ", please check key, must be correct!");
                return;
            } else if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.m13820e("property value is " + obj + ", please check value, lawless!");
                return;
            } else {
                try {
                    if (this.f37566k == null) {
                        this.f37566k = new JSONObject();
                    }
                    if (obj.getClass().isArray()) {
                        if (obj instanceof String[]) {
                            String[] strArr = (String[]) obj;
                            if (strArr.length > 10) {
                                MLog.m13820e("please check value, size is " + strArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray = new JSONArray();
                            while (i < strArr.length) {
                                if (strArr[i] != null && HelperUtils.checkStrLen(strArr[i], 256)) {
                                    jSONArray.put(strArr[i]);
                                    i++;
                                }
                                MLog.m13820e("please check value, length is " + strArr[i].length() + ", overlength 256!");
                                return;
                            }
                            this.f37566k.put(str, jSONArray);
                        } else if (obj instanceof long[]) {
                            long[] jArr = (long[]) obj;
                            if (jArr.length > 10) {
                                MLog.m13820e("please check value, size is " + jArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            while (i < jArr.length) {
                                jSONArray2.put(jArr[i]);
                                i++;
                            }
                            this.f37566k.put(str, jSONArray2);
                        } else if (obj instanceof int[]) {
                            int[] iArr = (int[]) obj;
                            if (iArr.length > 10) {
                                MLog.m13820e("please check value, size is " + iArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            while (i < iArr.length) {
                                jSONArray3.put(iArr[i]);
                                i++;
                            }
                            this.f37566k.put(str, jSONArray3);
                        } else if (obj instanceof float[]) {
                            float[] fArr = (float[]) obj;
                            if (fArr.length > 10) {
                                MLog.m13820e("please check value, size is " + fArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray4 = new JSONArray();
                            while (i < fArr.length) {
                                jSONArray4.put(fArr[i]);
                                i++;
                            }
                            this.f37566k.put(str, jSONArray4);
                        } else if (obj instanceof double[]) {
                            double[] dArr = (double[]) obj;
                            if (dArr.length > 10) {
                                MLog.m13820e("please check value, size is " + dArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray5 = new JSONArray();
                            while (i < dArr.length) {
                                jSONArray5.put(dArr[i]);
                                i++;
                            }
                            this.f37566k.put(str, jSONArray5);
                        } else if (obj instanceof short[]) {
                            short[] sArr = (short[]) obj;
                            if (sArr.length > 10) {
                                MLog.m13820e("please check value, size is " + sArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray6 = new JSONArray();
                            while (i < sArr.length) {
                                jSONArray6.put((int) sArr[i]);
                                i++;
                            }
                            this.f37566k.put(str, jSONArray6);
                        } else {
                            MLog.m13820e("please check value, illegal type!");
                            return;
                        }
                    } else {
                        if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                            MLog.m13820e("please check value, illegal type!");
                            return;
                        }
                        this.f37566k.put(str, obj);
                    }
                } catch (Throwable unused) {
                }
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38418t, CoreProtocol.getInstance(context2), this.f37566k.toString());
                return;
            }
        }
        UMLog.m14015aq(UMLogAnalytics.f38302ag, 0, "\\|");
    }

    /* renamed from: a */
    public synchronized void m14824a(Object obj) {
        Context context;
        try {
            context = f37547a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m13820e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f37547a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f37548h, this.f37566k.toString()).commit();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m14827a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.m13816e(th);
        }
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38305aj, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        EventTracker.m14204a(f37547a).m14197a(list);
    }

    /* renamed from: a */
    public synchronized void m14826a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38307al, 0, "\\|");
            return;
        }
        if (f37547a == null) {
            f37547a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f37547a)) {
            MLog.m13820e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f37565j || !this.f37569n) {
            m14838a(f37547a);
        }
        if (this.f37568m == null) {
            this.f37568m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f37568m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (m14808c(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.m13820e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f37568m = jSONObject2;
            if (this.f37568m.length() > 0) {
                Context context2 = f37547a;
                UMWorkDispatch.sendEvent(context2, CoreProtocolImpl.C13167a.f38421w, CoreProtocol.getInstance(context2), this.f37568m.toString());
            }
            return;
        }
        UMLog.m14015aq(UMLogAnalytics.f38308am, 0, "\\|");
    }

    /* renamed from: a */
    public void m14822a(String str, Object obj) {
        if (m14796f(str)) {
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                MLog.m13820e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UContent.f38088S, str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!m14793g(str2)) {
                        return;
                    }
                    jSONObject.put("pv", str2);
                } else {
                    jSONObject.put("pv", obj);
                }
                Context context = f37547a;
                UMWorkDispatch.sendEvent(context, CoreProtocolImpl.C13167a.f38415q, CoreProtocol.getInstance(context), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
