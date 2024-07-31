package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.InternalAgent;
import com.umeng.analytics.InternalConfig;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.common.SPHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.SLModeUtil;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.o */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CoreProtocolImpl {

    /* renamed from: a */
    private static Context f38366a = null;

    /* renamed from: l */
    private static final String f38367l = "first_activate_time";

    /* renamed from: m */
    private static final String f38368m = "ana_is_f";

    /* renamed from: n */
    private static final String f38369n = "thtstart";

    /* renamed from: o */
    private static final String f38370o = "dstk_last_time";

    /* renamed from: p */
    private static final String f38371p = "dstk_cnt";

    /* renamed from: q */
    private static final String f38372q = "gkvc";

    /* renamed from: r */
    private static final String f38373r = "ekvc";

    /* renamed from: t */
    private static final String f38374t = "-1";

    /* renamed from: x */
    private static final String f38375x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y */
    private static Class<?> f38376y;

    /* renamed from: z */
    private static Method f38377z;

    /* renamed from: b */
    private C13169c f38378b;

    /* renamed from: c */
    private SharedPreferences f38379c;

    /* renamed from: d */
    private String f38380d;

    /* renamed from: e */
    private String f38381e;

    /* renamed from: f */
    private int f38382f;

    /* renamed from: g */
    private JSONArray f38383g;

    /* renamed from: h */
    private final int f38384h;

    /* renamed from: i */
    private int f38385i;

    /* renamed from: j */
    private int f38386j;

    /* renamed from: k */
    private long f38387k;

    /* renamed from: s */
    private final long f38388s;

    /* renamed from: u */
    private boolean f38389u;

    /* renamed from: v */
    private boolean f38390v;

    /* renamed from: w */
    private Object f38391w;

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13167a {

        /* renamed from: A */
        public static final int f38392A = 8209;

        /* renamed from: B */
        public static final int f38393B = 8210;

        /* renamed from: C */
        public static final int f38394C = 8211;

        /* renamed from: D */
        public static final int f38395D = 8212;

        /* renamed from: E */
        public static final int f38396E = 8213;

        /* renamed from: F */
        public static final int f38397F = 8214;

        /* renamed from: G */
        public static final int f38398G = 8215;

        /* renamed from: a */
        public static final int f38399a = 4097;

        /* renamed from: b */
        public static final int f38400b = 4098;

        /* renamed from: c */
        public static final int f38401c = 4099;

        /* renamed from: d */
        public static final int f38402d = 4100;

        /* renamed from: e */
        public static final int f38403e = 4101;

        /* renamed from: f */
        public static final int f38404f = 4102;

        /* renamed from: g */
        public static final int f38405g = 4103;

        /* renamed from: h */
        public static final int f38406h = 4104;

        /* renamed from: i */
        public static final int f38407i = 4105;

        /* renamed from: j */
        public static final int f38408j = 4106;

        /* renamed from: k */
        public static final int f38409k = 4352;

        /* renamed from: l */
        public static final int f38410l = 4353;

        /* renamed from: m */
        public static final int f38411m = 4354;

        /* renamed from: n */
        public static final int f38412n = 4355;

        /* renamed from: o */
        public static final int f38413o = 4356;

        /* renamed from: p */
        public static final int f38414p = 4357;

        /* renamed from: q */
        public static final int f38415q = 4358;

        /* renamed from: r */
        public static final int f38416r = 8193;

        /* renamed from: s */
        public static final int f38417s = 8194;

        /* renamed from: t */
        public static final int f38418t = 8195;

        /* renamed from: u */
        public static final int f38419u = 8196;

        /* renamed from: v */
        public static final int f38420v = 8197;

        /* renamed from: w */
        public static final int f38421w = 8199;

        /* renamed from: x */
        public static final int f38422x = 8200;

        /* renamed from: y */
        public static final int f38423y = 8201;

        /* renamed from: z */
        public static final int f38424z = 8208;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13168b {

        /* renamed from: a */
        private static final CoreProtocolImpl f38425a = new CoreProtocolImpl();

        private C13168b() {
        }
    }

    static {
        m14241h();
    }

    /* renamed from: a */
    public static CoreProtocolImpl m14274a(Context context) {
        if (f38366a == null && context != null) {
            f38366a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13168b.f38425a;
    }

    /* renamed from: b */
    private void m14261b(JSONObject jSONObject) {
        JSONObject m14318f;
        if (UMStoreManager.m14345a(UMGlobalContext.getAppContext(f38366a)).m14324c() || (m14318f = UMStoreManager.m14345a(UMGlobalContext.getAppContext(f38366a)).m14318f()) == null) {
            return;
        }
        String optString = m14318f.optString("__av");
        String optString2 = m14318f.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(EnvelopeManager.m13836a("app_version"), UMUtils.getAppVersionName(f38366a));
            } else {
                jSONObject.put(EnvelopeManager.m13836a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(EnvelopeManager.m13836a("version_code"), UMUtils.getAppVersionCode(f38366a));
            } else {
                jSONObject.put(EnvelopeManager.m13836a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m14249e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!m14275a(this.f38387k, this.f38385i)) {
                    return;
                }
                this.f38385i++;
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!m14275a(this.f38387k, this.f38386j)) {
                    return;
                }
                this.f38386j++;
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f38383g == null) {
                    this.f38383g = new JSONArray();
                }
                this.f38383g.put(jSONObject);
                UMStoreManager.m14345a(f38366a).m14338a(this.f38383g);
                this.f38383g = new JSONArray();
                return;
            }
            if (this.f38383g.length() >= this.f38382f) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                UMStoreManager.m14345a(f38366a).m14338a(this.f38383g);
                this.f38383g = new JSONArray();
            }
            if (this.f38387k == 0) {
                this.f38387k = System.currentTimeMillis();
            }
            this.f38383g.put(jSONObject);
        } catch (Throwable th) {
            MLog.m13816e(th);
        }
    }

    /* renamed from: f */
    private void m14245f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (jSONObject.getJSONObject(EnvelopeManager.m13836a("header")).has(UContent.f38104aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(EnvelopeManager.m13836a("analytics"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(EnvelopeManager.m13836a("analytics"));
                    if (jSONObject2.has(UContent.f38149n) && (optJSONObject2 = jSONObject2.getJSONArray(UContent.f38149n).optJSONObject(0)) != null) {
                        String optString = optJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(optString)) {
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                            UMStoreManager.m14345a(f38366a).m14331b(optString);
                        }
                    }
                }
                UMStoreManager.m14345a(f38366a).m14332b();
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                Context context = f38366a;
                UMWorkDispatch.sendEvent(context, C13167a.f38410l, CoreProtocol.getInstance(context), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(EnvelopeManager.m13836a("analytics")) && (optJSONObject = jSONObject.optJSONObject(EnvelopeManager.m13836a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(UContent.f38149n)) {
                UMStoreManager.m14345a(f38366a).m14333a(true, false);
            }
            UMStoreManager.m14345a(f38366a).m14332b();
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private static void m14241h() {
        try {
            Class<?> cls = Class.forName(f38375x);
            f38376y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f38377z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m14239i() {
        JSONObject m14264b = m14264b(UMEnvelopeBuild.maxDataSpace(f38366a));
        if (m14264b == null || m14264b.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m14264b.opt("header");
        JSONObject jSONObject2 = (JSONObject) m14264b.opt("content");
        if (f38366a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f38366a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                m14248e(buildEnvelopeWithExtHeader);
            }
            m14262b((Object) buildEnvelopeWithExtHeader);
        }
    }

    /* renamed from: j */
    private void m14238j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject m14276a = m14276a(UMEnvelopeBuild.maxDataSpace(f38366a));
        if (m14276a == null || m14276a.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m14276a.opt("header");
        JSONObject jSONObject2 = (JSONObject) m14276a.opt("content");
        Context context = f38366a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            m14252d(buildEnvelopeWithExtHeader);
        }
        m14273a((Object) buildEnvelopeWithExtHeader);
    }

    /* renamed from: k */
    private JSONObject m14237k() {
        JSONObject m14236l = m14236l();
        if (m14236l != null) {
            try {
                m14236l.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return m14236l;
    }

    /* renamed from: l */
    private JSONObject m14236l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(EnvelopeManager.m13836a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(EnvelopeManager.m13836a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f38366a);
            jSONObject.put(EnvelopeManager.m13836a(UContent.f38144i), verticalType);
            String str = "9.6.5";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f38366a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(EnvelopeManager.m13836a("sdk_version"), str);
            } else {
                jSONObject.put(EnvelopeManager.m13836a("sdk_version"), "9.6.5");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f38366a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(EnvelopeManager.m13836a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f38366a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38366a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f38366a, UContent.f38130at, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(EnvelopeManager.m13836a(UContent.f38132av), "");
                } else {
                    jSONObject.put(EnvelopeManager.m13836a(UContent.f38132av), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f38366a, UContent.f38131au, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(EnvelopeManager.m13836a(UContent.f38133aw), "");
                } else {
                    jSONObject.put(EnvelopeManager.m13836a(UContent.f38133aw), imprintProperty3);
                }
            }
            jSONObject.put(EnvelopeManager.m13836a(UContent.f38124an), "1.0.0");
            if (m14229s()) {
                jSONObject.put(EnvelopeManager.m13836a(UContent.f38126ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f38368m, 0L).commit();
                }
            }
            jSONObject.put(EnvelopeManager.m13836a(UContent.f38147l), m14235m());
            jSONObject.put(EnvelopeManager.m13836a(UContent.f38148m), m14234n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(EnvelopeManager.m13836a(UContent.f38147l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(EnvelopeManager.m13836a(UContent.f38148m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f38366a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: m */
    private String m14235m() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f38366a, "pr_ve", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f38380d)) {
                    return this.f38380d;
                }
                if (this.f38379c == null) {
                    this.f38379c = PreferenceWrapper.getDefault(f38366a);
                }
                String string = this.f38379c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f38366a);
                if (TextUtils.isEmpty(string)) {
                    this.f38379c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    str = "0";
                } else {
                    String string2 = this.f38379c.getString("cur_version", "");
                    if (appVersionName.equals(string2)) {
                        str = string;
                    } else {
                        this.f38379c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        str = string2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f38380d = str;
        return str;
    }

    /* renamed from: n */
    private String m14234n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f38366a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f38381e)) {
                    return this.f38381e;
                }
                if (this.f38379c == null) {
                    this.f38379c = PreferenceWrapper.getDefault(f38366a);
                }
                String string = this.f38379c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f38379c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f38379c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f38381e = str;
        return str;
    }

    /* renamed from: o */
    private void m14233o() {
        try {
            this.f38385i = 0;
            this.f38386j = 0;
            this.f38387k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f38366a).edit().putLong(f38370o, System.currentTimeMillis()).putInt(f38371p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: p */
    private boolean m14232p() {
        try {
            if (!TextUtils.isEmpty(SessionTracker.m14188a().m14181b())) {
                m14263b(f38366a);
            }
            if (this.f38383g.length() > 0) {
                for (int i = 0; i < this.f38383g.length(); i++) {
                    JSONObject optJSONObject = this.f38383g.optJSONObject(i);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        String optString = optJSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: q */
    private void m14231q() {
        if (this.f38383g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f38383g.length(); i++) {
                try {
                    JSONObject jSONObject = this.f38383g.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String optString = jSONObject.optString("__i");
                        String str = "-1";
                        if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                            String m14181b = SessionTracker.m14188a().m14181b();
                            if (!TextUtils.isEmpty(m14181b)) {
                                str = m14181b;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f38383g = jSONArray;
        }
    }

    /* renamed from: r */
    private void m14230r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!m14229s() || (context = f38366a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f38367l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f38367l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    private boolean m14229s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f38366a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f38368m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public void m14265b() {
    }

    /* renamed from: c */
    public void m14258c() {
        m14263b(f38366a);
        m14254d();
        m14266a(true);
    }

    /* renamed from: d */
    public void m14254d() {
        try {
            if (this.f38383g.length() > 0) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                UMStoreManager.m14345a(f38366a).m14338a(this.f38383g);
                this.f38383g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f38366a).edit().putLong(f38369n, this.f38387k).putInt(f38372q, this.f38385i).putInt(f38373r, this.f38386j).commit();
        } catch (Throwable unused) {
        }
    }

    private CoreProtocolImpl() {
        this.f38378b = null;
        this.f38379c = null;
        this.f38380d = null;
        this.f38381e = null;
        this.f38382f = 10;
        this.f38383g = new JSONArray();
        this.f38384h = 5000;
        this.f38385i = 0;
        this.f38386j = 0;
        this.f38387k = 0L;
        this.f38388s = 28800000L;
        this.f38389u = false;
        this.f38390v = false;
        this.f38391w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38366a);
            this.f38387k = sharedPreferences.getLong(f38369n, 0L);
            this.f38385i = sharedPreferences.getInt(f38372q, 0);
            this.f38386j = sharedPreferences.getInt(f38373r, 0);
            this.f38378b = new C13169c();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private void m14242g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(EnvelopeManager.m13836a("header")).has(UContent.f38104aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(EnvelopeManager.m13836a("analytics"))) {
                    if (jSONObject.getJSONObject(EnvelopeManager.m13836a("analytics")).has(UContent.f38149n)) {
                        UMStoreManager.m14345a(f38366a).m14315i();
                        UMStoreManager.m14345a(f38366a).m14316h();
                        UMStoreManager.m14345a(f38366a).m14325b(true, false);
                        UMStoreManager.m14345a(f38366a).m14346a();
                        return;
                    }
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(EnvelopeManager.m13836a("analytics")) && (optJSONObject = jSONObject.optJSONObject(EnvelopeManager.m13836a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(UContent.f38149n)) {
                    UMStoreManager.m14345a(f38366a).m14325b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(UContent.f38095Z)) {
                    UMStoreManager.m14345a(f38366a).m14316h();
                }
                if (optJSONObject.has("error")) {
                    UMStoreManager.m14345a(f38366a).m14315i();
                }
            }
            UMStoreManager.m14345a(f38366a).m14346a();
        } catch (Exception unused) {
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13169c {

        /* renamed from: a */
        private ReportPolicy.ReportStrategy f38426a = null;

        /* renamed from: b */
        private int f38427b = -1;

        /* renamed from: c */
        private int f38428c = -1;

        /* renamed from: d */
        private int f38429d = -1;

        /* renamed from: e */
        private int f38430e = -1;

        /* renamed from: f */
        private ABTest f38431f;

        public C13169c() {
            this.f38431f = null;
            this.f38431f = ABTest.getService(CoreProtocolImpl.f38366a);
        }

        /* renamed from: a */
        public void m14227a() {
            try {
                int[] m14225a = m14225a(-1, -1);
                this.f38427b = m14225a[0];
                this.f38428c = m14225a[1];
            } catch (Throwable unused) {
            }
        }

        /* renamed from: b */
        protected void m14224b() {
            int i;
            ReportPolicy.ReportStrategy defconPolicy;
            Defcon service = Defcon.getService(CoreProtocolImpl.f38366a);
            if (!service.isOpen()) {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(CoreProtocolImpl.f38366a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(UMLogAnalytics.f38279K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f38426a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(CoreProtocolImpl.f38366a));
                } else if (this.f38431f.isInTest() && "RPT".equals(this.f38431f.getTestName())) {
                    if (this.f38431f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(CoreProtocolImpl.f38366a, "test_report_interval", "-1")).intValue() != -1) {
                            i = m14226a(90000);
                        } else {
                            i = this.f38428c;
                            if (i <= 0) {
                                i = this.f38430e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.f38426a = m14223b(this.f38431f.getTestPolicy(), i);
                } else {
                    int i2 = this.f38429d;
                    int i3 = this.f38430e;
                    int i4 = this.f38427b;
                    if (i4 != -1) {
                        i3 = this.f38428c;
                        i2 = i4;
                    }
                    this.f38426a = m14223b(i2, i3);
                }
            } else {
                ReportPolicy.ReportStrategy reportStrategy = this.f38426a;
                if (!((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid())) {
                    defconPolicy = new ReportPolicy.DefconPolicy(StatTracer.getInstance(CoreProtocolImpl.f38366a), service);
                } else {
                    defconPolicy = this.f38426a;
                }
                this.f38426a = defconPolicy;
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f38426a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(UMLogAnalytics.f38277I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(UMLogAnalytics.f38278J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(UMLogAnalytics.f38280L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(UMLogAnalytics.f38281M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        /* renamed from: c */
        public ReportPolicy.ReportStrategy m14222c() {
            m14224b();
            return this.f38426a;
        }

        /* renamed from: a */
        public int[] m14225a(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(CoreProtocolImpl.f38366a, "report_policy", "-1")).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(CoreProtocolImpl.f38366a, "report_interval", "-1")).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            if (6 == intValue) {
                return new int[]{intValue, ((intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) ? 90 : 90) * 1000};
            } else if (11 == intValue) {
                return new int[]{intValue, ((intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) ? 15 : 15) * 1000};
            } else {
                return new int[]{i, i2};
            }
        }

        /* renamed from: a */
        public int m14226a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(CoreProtocolImpl.f38366a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        /* renamed from: b */
        private ReportPolicy.ReportStrategy m14223b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f38426a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f38426a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            } else if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f38426a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(CoreProtocolImpl.f38366a));
            } else if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f38426a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(CoreProtocolImpl.f38366a);
            } else if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f38426a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(CoreProtocolImpl.f38366a), i2);
            } else if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f38426a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(CoreProtocolImpl.f38366a));
            } else if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f38426a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.f38426a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval(i2);
                return reportQuasiRealtime;
            }
        }
    }

    /* renamed from: c */
    private void m14256c(JSONObject jSONObject) {
        try {
            if (!UMStoreManager.m14345a(f38366a).m14319e()) {
                JSONObject m14317g = UMStoreManager.m14345a(f38366a).m14317g();
                if (m14317g != null) {
                    String optString = m14317g.optString("__av");
                    String optString2 = m14317g.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(EnvelopeManager.m13836a("app_version"), UMUtils.getAppVersionName(f38366a));
                    } else {
                        jSONObject.put(EnvelopeManager.m13836a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(EnvelopeManager.m13836a("version_code"), UMUtils.getAppVersionCode(f38366a));
                        return;
                    } else {
                        jSONObject.put(EnvelopeManager.m13836a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(EnvelopeManager.m13836a("app_version"), UMUtils.getAppVersionName(f38366a));
            jSONObject.put(EnvelopeManager.m13836a("version_code"), UMUtils.getAppVersionCode(f38366a));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m14277a() {
        if (f38366a != null) {
            synchronized (this.f38391w) {
                if (this.f38389u) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    Context context = f38366a;
                    UMWorkDispatch.sendEvent(context, C13167a.f38410l, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.f38391w) {
                if (this.f38390v) {
                    Context context2 = f38366a;
                    UMWorkDispatch.sendEvent(context2, C13167a.f38411m, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13170d {

        /* renamed from: a */
        private Map<String, Object> f38432a;

        /* renamed from: b */
        private String f38433b;

        /* renamed from: c */
        private String f38434c;

        /* renamed from: d */
        private long f38435d;

        private C13170d() {
            this.f38432a = null;
            this.f38433b = null;
            this.f38434c = null;
            this.f38435d = 0L;
        }

        /* renamed from: a */
        public Map<String, Object> m14221a() {
            return this.f38432a;
        }

        /* renamed from: b */
        public String m14220b() {
            return this.f38434c;
        }

        /* renamed from: c */
        public String m14219c() {
            return this.f38433b;
        }

        /* renamed from: d */
        public long m14218d() {
            return this.f38435d;
        }

        public C13170d(String str, Map<String, Object> map, String str2, long j) {
            this.f38432a = map;
            this.f38433b = str;
            this.f38435d = j;
            this.f38434c = str2;
        }
    }

    /* renamed from: h */
    private void m14240h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            UMStoreManager.m14345a(f38366a).m14342a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m14252d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(EnvelopeManager.m13836a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(EnvelopeManager.m13836a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m13826d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.m13826d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(UContent.f38095Z)) {
                    jSONObject3.put(UContent.f38095Z, jSONObject4.getJSONArray(UContent.f38095Z));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m13826d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.m13826d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m13826d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.m13826d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(UContent.f38149n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(UContent.f38149n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(UContent.f38156u)) {
                                jSONObject5.remove(UContent.f38156u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(UContent.f38149n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m13826d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.m13826d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(UContent.f38078I)) {
                    jSONObject3.put(UContent.f38078I, jSONObject4.getJSONObject(UContent.f38078I));
                }
                if (jSONObject4.has(UContent.f38081L)) {
                    jSONObject3.put(UContent.f38081L, jSONObject4.getJSONObject(UContent.f38081L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m13826d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.m13826d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(EnvelopeManager.m13836a("header")) && (jSONObject2 = jSONObject.getJSONObject(EnvelopeManager.m13836a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(EnvelopeManager.m13836a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(EnvelopeManager.m13836a("sdk_version")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(EnvelopeManager.m13836a("device_id")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(EnvelopeManager.m13836a("device_model")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("version_code"))) {
                    jSONObject3.put(ConstantHelper.LOG_VS, jSONObject2.getInt(EnvelopeManager.m13836a("version_code")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(EnvelopeManager.m13836a("appkey")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(EnvelopeManager.m13836a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m13826d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m13816e(th);
        }
    }

    /* renamed from: b */
    public JSONObject m14264b(long j) {
        if (TextUtils.isEmpty(SessionIdManager.m14159a().m14148d(UMGlobalContext.getAppContext(f38366a)))) {
            return null;
        }
        JSONObject m14326b = UMStoreManager.m14345a(UMGlobalContext.getAppContext(f38366a)).m14326b(false);
        String[] m14782a = InternalConfig.m14782a(f38366a);
        if (m14782a != null && !TextUtils.isEmpty(m14782a[0]) && !TextUtils.isEmpty(m14782a[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UContent.f38082M, m14782a[0]);
                jSONObject.put(UContent.f38083N, m14782a[1]);
                if (jSONObject.length() > 0) {
                    m14326b.put(UContent.f38081L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int m14211a = DefconProcesser.m14212a().m14211a(f38366a);
        if (m14326b.length() != 1 || m14326b.optJSONObject(UContent.f38081L) == null || m14211a == 3) {
            DefconProcesser.m14212a().m14207b(m14326b, f38366a);
            if (m14326b.length() > 0 || m14211a == 3) {
                JSONObject m14237k = m14237k();
                if (m14237k != null) {
                    m14261b(m14237k);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    if (m14211a == 3) {
                        jSONObject3.put("analytics", new JSONObject());
                    } else if (m14326b.length() > 0) {
                        jSONObject3.put("analytics", m14326b);
                    }
                    if (m14237k != null && m14237k.length() > 0) {
                        jSONObject2.put("header", m14237k);
                    }
                    if (jSONObject3.length() > 0) {
                        jSONObject2.put("content", jSONObject3);
                    }
                    return m14260b(jSONObject2, j);
                } catch (Throwable unused2) {
                    return jSONObject2;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    private boolean m14255c(boolean z) {
        if (m14229s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f38378b == null) {
            this.f38378b = new C13169c();
        }
        this.f38378b.m14227a();
        ReportPolicy.ReportStrategy m14222c = this.f38378b.m14222c();
        boolean shouldSendMessage = m14222c.shouldSendMessage(z);
        if (shouldSendMessage) {
            if (((m14222c instanceof ReportPolicy.ReportByInterval) || (m14222c instanceof ReportPolicy.DebugPolicy) || (m14222c instanceof ReportPolicy.ReportQuasiRealtime)) && m14232p()) {
                m14254d();
            }
            if ((m14222c instanceof ReportPolicy.DefconPolicy) && m14232p()) {
                m14254d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.m13826d("数据发送策略 : " + m14222c.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    /* renamed from: a */
    private void m14270a(String str, String str2) {
        Method method;
        Class<?> cls = f38376y;
        if (cls == null || (method = f38377z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    /* renamed from: e */
    private void m14248e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(EnvelopeManager.m13836a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(EnvelopeManager.m13836a("analytics"));
                if (jSONObject4.has(UContent.f38149n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(UContent.f38149n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(UContent.f38149n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.m13826d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(UContent.f38081L)) {
                    jSONObject3.put(UContent.f38081L, jSONObject4.getJSONObject(UContent.f38081L));
                    if (jSONObject3.length() > 0) {
                        MLog.m13826d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(EnvelopeManager.m13836a("header")) && jSONObject.has(EnvelopeManager.m13836a("header")) && (jSONObject2 = jSONObject.getJSONObject(EnvelopeManager.m13836a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(EnvelopeManager.m13836a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(EnvelopeManager.m13836a("sdk_version")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(EnvelopeManager.m13836a("device_id")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(EnvelopeManager.m13836a("device_model")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("version_code"))) {
                    jSONObject3.put(ConstantHelper.LOG_VS, jSONObject2.getInt(EnvelopeManager.m13836a("version_code")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(EnvelopeManager.m13836a("appkey")));
                }
                if (jSONObject2.has(EnvelopeManager.m13836a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(EnvelopeManager.m13836a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m13826d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m13816e(th);
        }
    }

    /* renamed from: a */
    public void m14272a(Object obj, int i) {
        if (SLModeUtil.m13463a()) {
            if (i != 4357) {
                return;
            }
            try {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                UMDBUtils.m14355a(f38366a);
                SLModeUtil.m13457c(f38366a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i != 4358) {
                    switch (i) {
                        case 4097:
                            if (UMUtils.isMainProgress(f38366a)) {
                                if (obj != null) {
                                    m14249e(obj);
                                }
                                if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                m14266a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(f38366a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f38366a), new JSONArray().put(obj));
                            return;
                        case 4098:
                            if (obj != null) {
                                m14249e(obj);
                            }
                            if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            m14266a(false);
                            return;
                        case 4099:
                            ViewPageTracker.m14168a(f38366a);
                            return;
                        case C13167a.f38402d /* 4100 */:
                            AutoViewPageTracker.m14296c(f38366a);
                            return;
                        case C13167a.f38403e /* 4101 */:
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            m14271a((Object) null, true);
                            m14243g(obj);
                            return;
                        case C13167a.f38404f /* 4102 */:
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            m14271a((Object) null, true);
                            m14246f(obj);
                            return;
                        case C13167a.f38405g /* 4103 */:
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            SessionTracker.m14188a().m14184a(f38366a, obj);
                            synchronized (this.f38391w) {
                                this.f38390v = true;
                            }
                            return;
                        case C13167a.f38406h /* 4104 */:
                            SessionTracker.m14188a().m14174c(f38366a, obj);
                            return;
                        case C13167a.f38407i /* 4105 */:
                            m14254d();
                            return;
                        case C13167a.f38408j /* 4106 */:
                            m14240h(obj);
                            return;
                        default:
                            switch (i) {
                                case C13167a.f38409k /* 4352 */:
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    SessionTracker.m14188a().m14177b(f38366a, obj);
                                    synchronized (this.f38391w) {
                                        this.f38389u = true;
                                    }
                                    return;
                                case C13167a.f38410l /* 4353 */:
                                    m14271a(obj, true);
                                    return;
                                case C13167a.f38411m /* 4354 */:
                                    m14258c();
                                    return;
                                case C13167a.f38412n /* 4355 */:
                                    if (!UMUtils.isMainProgress(f38366a)) {
                                        UMProcessDBHelper.getInstance(f38366a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f38366a), new JSONArray().put(obj));
                                        return;
                                    } else if (obj != null) {
                                        m14249e(obj);
                                        m14254d();
                                        return;
                                    } else {
                                        return;
                                    }
                                case C13167a.f38413o /* 4356 */:
                                    if (obj == null || f38376y == null || f38377z == null) {
                                        return;
                                    }
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has(UContent.f38082M)) {
                                            str = jSONObject.getString(UContent.f38082M);
                                            str2 = jSONObject.getString("uid");
                                        }
                                        m14270a(str2, str);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i) {
                                        case C13167a.f38418t /* 8195 */:
                                            InternalAgent.m14841a().m14824a(obj);
                                            return;
                                        case C13167a.f38419u /* 8196 */:
                                            InternalAgent.m14841a().m14785m();
                                            return;
                                        case C13167a.f38420v /* 8197 */:
                                            InternalAgent.m14841a().m14787k();
                                            return;
                                        default:
                                            switch (i) {
                                                case C13167a.f38421w /* 8199 */:
                                                case C13167a.f38422x /* 8200 */:
                                                    InternalAgent.m14841a().m14815b(obj);
                                                    return;
                                                case C13167a.f38423y /* 8201 */:
                                                    InternalAgent.m14841a().m14815b((Object) null);
                                                    return;
                                                default:
                                                    switch (i) {
                                                        case C13167a.f38424z /* 8208 */:
                                                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = f38366a;
                                                            UMWorkDispatch.sendEvent(context, C13167a.f38392A, CoreProtocol.getInstance(context), null);
                                                            Context context2 = f38366a;
                                                            UMWorkDispatch.sendEvent(context2, C13167a.f38411m, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case C13167a.f38392A /* 8209 */:
                                                            m14271a(obj, false);
                                                            return;
                                                        case C13167a.f38393B /* 8210 */:
                                                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (!UMUtils.isMainProgress(f38366a) || (this.f38378b.m14222c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                return;
                                                            }
                                                            m14266a(true);
                                                            return;
                                                        default:
                                                            switch (i) {
                                                                case C13167a.f38396E /* 8213 */:
                                                                    if (FieldManager.allow(UMConstant.f39159E)) {
                                                                        if (DeviceConfig.getGlobleActivity(f38366a) != null) {
                                                                            SessionTracker.m14180b(f38366a);
                                                                        }
                                                                        Context context3 = f38366a;
                                                                        UMWorkDispatch.sendEventEx(context3, C13167a.f38396E, CoreProtocol.getInstance(context3), null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case C13167a.f38397F /* 8214 */:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                        String optString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                        String optString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = f38366a;
                                                                        String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                        SPHelper.m14056a(context4, str3, AnalyticsConfig.RTD_START_TIME, optString);
                                                                        SPHelper.m14056a(f38366a, str3, AnalyticsConfig.RTD_PERIOD, optString2);
                                                                        SPHelper.m14056a(f38366a, str3, AnalyticsConfig.DEBUG_KEY, optString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case C13167a.f38398G /* 8215 */:
                                                                    SPHelper.m14058a(f38366a, AnalyticsConfig.RTD_SP_FILE);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else if (obj != null && (obj instanceof JSONObject)) {
                    String optString4 = ((JSONObject) obj).optString(UContent.f38088S);
                    Object opt = ((JSONObject) obj).opt("pv");
                    if (TextUtils.isEmpty(optString4)) {
                        return;
                    }
                    String[] m14782a = InternalConfig.m14782a(f38366a);
                    if (m14782a != null && !TextUtils.isEmpty(m14782a[0]) && !TextUtils.isEmpty(m14782a[1])) {
                        if (UContent.f38084O.equals(optString4)) {
                            InternalConfig.m14779a((String) opt);
                            return;
                        } else if (UContent.f38085P.equals(optString4)) {
                            InternalConfig.m14775b((String) opt);
                            return;
                        } else {
                            InternalConfig.m14778a(optString4, opt);
                            return;
                        }
                    }
                    MLog.m13820e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: g */
    private void m14243g(Object obj) {
        try {
            m14263b(f38366a);
            m14254d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(UContent.f38082M);
                String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                String[] m14782a = InternalConfig.m14782a(f38366a);
                if (m14782a != null && string.equals(m14782a[0]) && string2.equals(m14782a[1])) {
                    return;
                }
                SessionTracker.m14188a().m14186a(f38366a, j);
                String m14149c = SessionIdManager.m14159a().m14149c(f38366a);
                boolean m14178b = SessionTracker.m14188a().m14178b(f38366a, j, false);
                InternalConfig.m14781a(f38366a, string, string2);
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + m14149c);
                SessionTracker.m14188a().m14185a(f38366a, j, true);
                if (m14178b) {
                    SessionTracker.m14188a().m14179b(f38366a, j);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public long m14247f() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f38366a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j = sharedPreferences.getLong(f38367l, 0L);
            if (j == 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f38367l, currentTimeMillis).commit();
                    return currentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j;
        } catch (Throwable unused2) {
            return 0L;
        }
    }

    /* renamed from: c */
    public void m14257c(Object obj) {
        m14263b(f38366a);
        m14254d();
        if (m14251d(false)) {
            m14238j();
        }
    }

    /* renamed from: f */
    private void m14246f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                m14263b(f38366a);
                m14254d();
                String[] m14782a = InternalConfig.m14782a(f38366a);
                if (m14782a == null || TextUtils.isEmpty(m14782a[0]) || TextUtils.isEmpty(m14782a[1])) {
                    return;
                }
                SessionTracker.m14188a().m14186a(f38366a, j);
                String m14149c = SessionIdManager.m14159a().m14149c(f38366a);
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + m14149c);
                boolean m14178b = SessionTracker.m14188a().m14178b(f38366a, j, false);
                InternalConfig.m14776b(f38366a);
                SessionTracker.m14188a().m14185a(f38366a, j, true);
                if (m14178b) {
                    SessionTracker.m14188a().m14179b(f38366a, j);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m13818e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    /* renamed from: b */
    private JSONObject m14260b(JSONObject jSONObject, long j) {
        try {
            if (DataSpliter.m14213a(jSONObject) > j) {
                jSONObject = null;
                UMStoreManager.m14345a(f38366a).m14333a(true, false);
                UMStoreManager.m14345a(f38366a).m14332b();
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: b */
    public JSONObject m14259b(boolean z) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = UMStoreManager.m14345a(f38366a).m14335a(z);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    if (jSONObject.has(UContent.f38149n)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(UContent.f38149n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i = 0;
                        while (i < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(UContent.f38155t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(UContent.f38156u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(UContent.f38155t, optJSONArray2);
                                jSONObject2.remove(UContent.f38156u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList<JSONObject> arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i2));
                                }
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i3));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(UContent.f38159x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                for (JSONObject jSONObject3 : arrayList) {
                                    jSONArray5.put(jSONObject3);
                                }
                                jSONObject2.put(UContent.f38155t, jSONArray5);
                                jSONObject2.remove(UContent.f38156u);
                            }
                            if (jSONObject2.has(UContent.f38155t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(UContent.f38155t);
                                int i4 = 0;
                                while (i4 < optJSONArray3.length()) {
                                    JSONObject jSONObject4 = optJSONArray3.getJSONObject(i4);
                                    if (jSONObject4.has(UContent.f38159x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject4.put("ts", jSONObject4.getLong(UContent.f38159x));
                                        jSONObject4.remove(UContent.f38159x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(UContent.f38155t, optJSONArray3);
                                jSONObject2.put(UContent.f38161z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(UContent.f38161z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(UContent.f38149n, jSONArray4);
                    }
                } catch (Exception e) {
                    MLog.m13820e("merge pages error");
                    e.printStackTrace();
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38366a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] m14782a = InternalConfig.m14782a(f38366a);
            if (m14782a != null && !TextUtils.isEmpty(m14782a[0]) && !TextUtils.isEmpty(m14782a[1])) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(UContent.f38082M, m14782a[0]);
                jSONObject5.put(UContent.f38083N, m14782a[1]);
                if (jSONObject5.length() > 0) {
                    JSONObject jSONObject6 = new JSONObject();
                    String m14783a = InternalConfig.m14783a();
                    if (m14783a != null) {
                        jSONObject6.put(UContent.f38084O, m14783a);
                    }
                    String m14777b = InternalConfig.m14777b();
                    if (m14777b != null) {
                        jSONObject6.put(UContent.f38085P, m14777b);
                    }
                    Map<String, Object> m14774c = InternalConfig.m14774c(f38366a);
                    if (m14774c != null && m14774c.size() > 0) {
                        for (String str : m14774c.keySet()) {
                            jSONObject6.put(str, m14774c.get(str));
                        }
                    }
                    if (jSONObject6.length() > 0) {
                        jSONObject5.put("up", jSONObject6);
                    }
                    jSONObject.put(UContent.f38081L, jSONObject5);
                }
            }
            if (ABTest.getService(f38366a).isInTest()) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(ABTest.getService(f38366a).getTestName(), ABTest.getService(f38366a).getGroupInfo());
                jSONObject.put(UContent.f38080K, jSONObject7);
            }
            DefconProcesser.m14212a().m14210a(jSONObject, f38366a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: e */
    public void m14250e() {
        if (m14251d(false)) {
            m14238j();
        }
    }

    /* renamed from: d */
    public void m14253d(Object obj) {
        m14230r();
        m14235m();
        m14234n();
        m14266a(true);
    }

    /* renamed from: d */
    private boolean m14251d(boolean z) {
        if (this.f38378b == null) {
            this.f38378b = new C13169c();
        }
        ReportPolicy.ReportStrategy m14222c = this.f38378b.m14222c();
        if (m14222c instanceof ReportPolicy.DefconPolicy) {
            if (z) {
                return ((ReportPolicy.DefconPolicy) m14222c).shouldSendMessageByInstant();
            }
            return m14222c.shouldSendMessage(false);
        }
        return true;
    }

    /* renamed from: b */
    public void m14262b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            m14245f(jSONObject);
                        }
                    } else {
                        m14245f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public void m14263b(Context context) {
        try {
            UMStoreManager.m14345a(context).m14321d();
            m14231q();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m14266a(boolean z) {
        if (m14255c(z)) {
            if (!(this.f38378b.m14222c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f38366a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    m14238j();
                }
            } else if (z) {
                if (UMEnvelopeBuild.isOnline(f38366a)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    m14238j();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(f38366a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                m14238j();
            }
        }
    }

    /* renamed from: a */
    private boolean m14269a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i++;
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    /* renamed from: a */
    private boolean m14268a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && m14269a(optJSONArray2)) {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    /* renamed from: a */
    public JSONObject m14276a(long j) {
        if (TextUtils.isEmpty(SessionIdManager.m14159a().m14148d(f38366a))) {
            return null;
        }
        JSONObject m14259b = m14259b(false);
        int m14211a = DefconProcesser.m14212a().m14211a(f38366a);
        if (m14259b.length() > 0) {
            if (m14259b.length() == 1) {
                if (m14259b.optJSONObject(UContent.f38081L) != null && m14211a != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(m14259b.optString("userlevel")) && m14211a != 3) {
                    return null;
                }
            } else if (m14259b.length() == 2 && m14259b.optJSONObject(UContent.f38081L) != null && !TextUtils.isEmpty(m14259b.optString("userlevel")) && m14211a != 3) {
                return null;
            }
            String optString = m14259b.optString(UContent.f38149n);
            String optString2 = m14259b.optString(UContent.f38095Z);
            String optString3 = m14259b.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && m14268a(m14259b)) {
                return null;
            }
        } else if (m14211a != 3) {
            return null;
        }
        JSONObject m14236l = m14236l();
        if (m14236l != null) {
            m14256c(m14236l);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (m14211a == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (m14259b.length() > 0) {
                jSONObject2.put("analytics", m14259b);
            }
            if (m14236l != null && m14236l.length() > 0) {
                jSONObject.put("header", m14236l);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return m14267a(jSONObject, j);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    private JSONObject m14267a(JSONObject jSONObject, long j) {
        try {
            if (DataSpliter.m14213a(jSONObject) > j) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("header");
                jSONObject2.put(UContent.f38104aH, DataSpliter.m14213a(jSONObject));
                jSONObject.put("header", jSONObject2);
                return DataSpliter.m14215a(f38366a, j, jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    private boolean m14275a(long j, int i) {
        if (j != 0) {
            if (System.currentTimeMillis() - j <= 28800000) {
                return i < 5000;
            }
            m14233o();
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public void m14273a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            m14242g(jSONObject);
                        }
                    } else {
                        m14242g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public void m14271a(Object obj, boolean z) {
        if (z) {
            if (m14251d(true)) {
                m14239i();
            }
        } else if (UMEnvelopeBuild.isOnline(f38366a) && m14251d(true)) {
            m14239i();
        }
    }
}
