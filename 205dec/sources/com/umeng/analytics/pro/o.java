package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CoreProtocolImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static Context f53044a = null;

    /* renamed from: l  reason: collision with root package name */
    private static final String f53045l = "first_activate_time";

    /* renamed from: m  reason: collision with root package name */
    private static final String f53046m = "ana_is_f";

    /* renamed from: n  reason: collision with root package name */
    private static final String f53047n = "thtstart";

    /* renamed from: o  reason: collision with root package name */
    private static final String f53048o = "dstk_last_time";

    /* renamed from: p  reason: collision with root package name */
    private static final String f53049p = "dstk_cnt";

    /* renamed from: q  reason: collision with root package name */
    private static final String f53050q = "gkvc";

    /* renamed from: r  reason: collision with root package name */
    private static final String f53051r = "ekvc";

    /* renamed from: t  reason: collision with root package name */
    private static final String f53052t = "-1";

    /* renamed from: x  reason: collision with root package name */
    private static final String f53053x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y  reason: collision with root package name */
    private static Class<?> f53054y;

    /* renamed from: z  reason: collision with root package name */
    private static Method f53055z;

    /* renamed from: b  reason: collision with root package name */
    private c f53056b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f53057c;

    /* renamed from: d  reason: collision with root package name */
    private String f53058d;

    /* renamed from: e  reason: collision with root package name */
    private String f53059e;

    /* renamed from: f  reason: collision with root package name */
    private int f53060f;

    /* renamed from: g  reason: collision with root package name */
    private JSONArray f53061g;

    /* renamed from: h  reason: collision with root package name */
    private final int f53062h;

    /* renamed from: i  reason: collision with root package name */
    private int f53063i;

    /* renamed from: j  reason: collision with root package name */
    private int f53064j;

    /* renamed from: k  reason: collision with root package name */
    private long f53065k;

    /* renamed from: s  reason: collision with root package name */
    private final long f53066s;

    /* renamed from: u  reason: collision with root package name */
    private boolean f53067u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f53068v;

    /* renamed from: w  reason: collision with root package name */
    private Object f53069w;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;

        /* renamed from: a  reason: collision with root package name */
        public static final int f53070a = 4097;

        /* renamed from: b  reason: collision with root package name */
        public static final int f53071b = 4098;

        /* renamed from: c  reason: collision with root package name */
        public static final int f53072c = 4099;

        /* renamed from: d  reason: collision with root package name */
        public static final int f53073d = 4100;

        /* renamed from: e  reason: collision with root package name */
        public static final int f53074e = 4101;

        /* renamed from: f  reason: collision with root package name */
        public static final int f53075f = 4102;

        /* renamed from: g  reason: collision with root package name */
        public static final int f53076g = 4103;

        /* renamed from: h  reason: collision with root package name */
        public static final int f53077h = 4104;

        /* renamed from: i  reason: collision with root package name */
        public static final int f53078i = 4105;

        /* renamed from: j  reason: collision with root package name */
        public static final int f53079j = 4106;

        /* renamed from: k  reason: collision with root package name */
        public static final int f53080k = 4352;

        /* renamed from: l  reason: collision with root package name */
        public static final int f53081l = 4353;

        /* renamed from: m  reason: collision with root package name */
        public static final int f53082m = 4354;

        /* renamed from: n  reason: collision with root package name */
        public static final int f53083n = 4355;

        /* renamed from: o  reason: collision with root package name */
        public static final int f53084o = 4356;

        /* renamed from: p  reason: collision with root package name */
        public static final int f53085p = 4357;

        /* renamed from: q  reason: collision with root package name */
        public static final int f53086q = 4358;

        /* renamed from: r  reason: collision with root package name */
        public static final int f53087r = 8193;

        /* renamed from: s  reason: collision with root package name */
        public static final int f53088s = 8194;

        /* renamed from: t  reason: collision with root package name */
        public static final int f53089t = 8195;

        /* renamed from: u  reason: collision with root package name */
        public static final int f53090u = 8196;

        /* renamed from: v  reason: collision with root package name */
        public static final int f53091v = 8197;

        /* renamed from: w  reason: collision with root package name */
        public static final int f53092w = 8199;

        /* renamed from: x  reason: collision with root package name */
        public static final int f53093x = 8200;

        /* renamed from: y  reason: collision with root package name */
        public static final int f53094y = 8201;

        /* renamed from: z  reason: collision with root package name */
        public static final int f53095z = 8208;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final o f53096a = new o();

        private b() {
        }
    }

    static {
        h();
    }

    public static o a(Context context) {
        if (f53044a == null && context != null) {
            f53044a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return b.f53096a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject f4;
        if (i.a(UMGlobalContext.getAppContext(f53044a)).c() || (f4 = i.a(UMGlobalContext.getAppContext(f53044a)).f()) == null) {
            return;
        }
        String optString = f4.optString("__av");
        String optString2 = f4.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f53044a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f53044a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f53065k, this.f53063i)) {
                    return;
                }
                this.f53063i++;
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f53065k, this.f53064j)) {
                    return;
                }
                this.f53064j++;
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f53061g == null) {
                    this.f53061g = new JSONArray();
                }
                this.f53061g.put(jSONObject);
                i.a(f53044a).a(this.f53061g);
                this.f53061g = new JSONArray();
                return;
            }
            if (this.f53061g.length() >= this.f53060f) {
                UMRTLog.i("MobclickRT", "--->>>*** \u8d85\u8fc710\u4e2a\u4e8b\u4ef6\uff0c\u4e8b\u4ef6\u843d\u5e93\u3002");
                i.a(f53044a).a(this.f53061g);
                this.f53061g = new JSONArray();
            }
            if (this.f53065k == 0) {
                this.f53065k = System.currentTimeMillis();
            }
            this.f53061g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has("eof")) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                    if (jSONObject2.has("sessions") && (optJSONObject2 = jSONObject2.getJSONArray("sessions").optJSONObject(0)) != null) {
                        String optString = optJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(optString)) {
                            UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: really delete instant session data");
                            i.a(f53044a).b(optString);
                        }
                    }
                }
                i.a(f53044a).b();
                UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                Context context = f53044a;
                UMWorkDispatch.sendEvent(context, 4353, CoreProtocol.getInstance(context), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has("sessions")) {
                i.a(f53044a).a(true, false);
            }
            i.a(f53044a).b();
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrashUtils");
            f53054y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f53055z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject b4 = b(UMEnvelopeBuild.maxDataSpace(f53044a));
        if (b4 == null || b4.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b4.opt("header");
        JSONObject jSONObject2 = (JSONObject) b4.opt("content");
        if (f53044a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i("MobclickRT", "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f53044a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i("MobclickRT", "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a4 = a(UMEnvelopeBuild.maxDataSpace(f53044a));
        if (a4 == null || a4.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a4.opt("header");
        JSONObject jSONObject2 = (JSONObject) a4.opt("content");
        Context context = f53044a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i("MobclickRT", "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject l4 = l();
        if (l4 != null) {
            try {
                l4.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l4;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f53044a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("vertical_type"), verticalType);
            String str = "9.6.5";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f53044a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.6.5");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f53044a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f53044a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53044a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f53044a, "ekv_bl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ekv_bl_ver"), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ekv_bl_ver"), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f53044a, "ekv_wl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ekv_wl_ver"), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ekv_wl_ver"), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("pro_ver"), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("atm"), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("ana_is_f", 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("$pr_ve"), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ud_da"), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("$pr_ve"), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("$ud_da"), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f53044a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f53044a, "pr_ve", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f53058d)) {
                    return this.f53058d;
                }
                if (this.f53057c == null) {
                    this.f53057c = PreferenceWrapper.getDefault(f53044a);
                }
                String string = this.f53057c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f53044a);
                if (TextUtils.isEmpty(string)) {
                    this.f53057c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    str = "0";
                } else {
                    String string2 = this.f53057c.getString("cur_version", "");
                    if (appVersionName.equals(string2)) {
                        str = string;
                    } else {
                        this.f53057c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        str = string2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f53058d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f53044a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f53059e)) {
                    return this.f53059e;
                }
                if (this.f53057c == null) {
                    this.f53057c = PreferenceWrapper.getDefault(f53044a);
                }
                String string = this.f53057c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f53057c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f53057c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f53059e = str;
        return str;
    }

    private void o() {
        try {
            this.f53063i = 0;
            this.f53064j = 0;
            this.f53065k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f53044a).edit().putLong("dstk_last_time", System.currentTimeMillis()).putInt("dstk_cnt", 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(f53044a);
            }
            if (this.f53061g.length() > 0) {
                for (int i4 = 0; i4 < this.f53061g.length(); i4++) {
                    JSONObject optJSONObject = this.f53061g.optJSONObject(i4);
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

    private void q() {
        if (this.f53061g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < this.f53061g.length(); i4++) {
                try {
                    JSONObject jSONObject = this.f53061g.getJSONObject(i4);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String optString = jSONObject.optString("__i");
                        String str = "-1";
                        if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                            String b4 = u.a().b();
                            if (!TextUtils.isEmpty(b4)) {
                                str = b4;
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
            this.f53061g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = f53044a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong("first_activate_time", 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f53044a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong("ana_is_f", -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f53044a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f53061g.length() > 0) {
                UMRTLog.i("MobclickRT", "--->>>*** flushMemoryData: \u4e8b\u4ef6\u843d\u5e93\u3002");
                i.a(f53044a).a(this.f53061g);
                this.f53061g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f53044a).edit().putLong("thtstart", this.f53065k).putInt("gkvc", this.f53063i).putInt("ekvc", this.f53064j).commit();
        } catch (Throwable unused) {
        }
    }

    private o() {
        this.f53056b = null;
        this.f53057c = null;
        this.f53058d = null;
        this.f53059e = null;
        this.f53060f = 10;
        this.f53061g = new JSONArray();
        this.f53062h = 5000;
        this.f53063i = 0;
        this.f53064j = 0;
        this.f53065k = 0L;
        this.f53066s = 28800000L;
        this.f53067u = false;
        this.f53068v = false;
        this.f53069w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53044a);
            this.f53065k = sharedPreferences.getLong("thtstart", 0L);
            this.f53063i = sharedPreferences.getInt("gkvc", 0);
            this.f53064j = sharedPreferences.getInt("ekvc", 0);
            this.f53056b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has("eof")) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has("sessions")) {
                        i.a(f53044a).i();
                        i.a(f53044a).h();
                        i.a(f53044a).b(true, false);
                        i.a(f53044a).a();
                        return;
                    }
                    UMRTLog.i("MobclickRT", "--->>> Error, Should not go to this branch.");
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has("sessions")) {
                    i.a(f53044a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has("gkv")) {
                    i.a(f53044a).h();
                }
                if (optJSONObject.has("error")) {
                    i.a(f53044a).i();
                }
            }
            i.a(f53044a).a();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private ReportPolicy.ReportStrategy f53097a = null;

        /* renamed from: b  reason: collision with root package name */
        private int f53098b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f53099c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f53100d = -1;

        /* renamed from: e  reason: collision with root package name */
        private int f53101e = -1;

        /* renamed from: f  reason: collision with root package name */
        private ABTest f53102f;

        public c() {
            this.f53102f = null;
            this.f53102f = ABTest.getService(o.f53044a);
        }

        public void a() {
            try {
                int[] a4 = a(-1, -1);
                this.f53098b = a4[0];
                this.f53099c = a4[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            int i4;
            ReportPolicy.ReportStrategy defconPolicy;
            Defcon service = Defcon.getService(o.f53044a);
            if (!service.isOpen()) {
                boolean z3 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f53044a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z3 && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z3) {
                    this.f53097a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.f53044a));
                } else if (this.f53102f.isInTest() && "RPT".equals(this.f53102f.getTestName())) {
                    if (this.f53102f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f53044a, "test_report_interval", "-1")).intValue() != -1) {
                            i4 = a(90000);
                        } else {
                            i4 = this.f53099c;
                            if (i4 <= 0) {
                                i4 = this.f53101e;
                            }
                        }
                    } else {
                        i4 = 0;
                    }
                    this.f53097a = b(this.f53102f.getTestPolicy(), i4);
                } else {
                    int i5 = this.f53100d;
                    int i6 = this.f53101e;
                    int i7 = this.f53098b;
                    if (i7 != -1) {
                        i6 = this.f53099c;
                        i5 = i7;
                    }
                    this.f53097a = b(i5, i6);
                }
            } else {
                ReportPolicy.ReportStrategy reportStrategy = this.f53097a;
                if (!((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid())) {
                    defconPolicy = new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.f53044a), service);
                } else {
                    defconPolicy = this.f53097a;
                }
                this.f53097a = defconPolicy;
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f53097a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.f52990L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z4 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f53097a;
        }

        public int[] a(int i4, int i5) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f53044a, "report_policy", "-1")).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f53044a, "report_interval", "-1")).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i4, i5};
            }
            if (6 == intValue) {
                return new int[]{intValue, ((intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) ? 90 : 90) * 1000};
            } else if (11 == intValue) {
                return new int[]{intValue, ((intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) ? 15 : 15) * 1000};
            } else {
                return new int[]{i4, i5};
            }
        }

        public int a(int i4) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f53044a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i4 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i4, int i5) {
            if (i4 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f53097a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i4 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f53097a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            } else if (i4 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f53097a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.f53044a));
            } else if (i4 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f53097a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.f53044a);
            } else if (i4 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f53097a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i5);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.f53044a), i5);
            } else if (i4 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f53097a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.f53044a));
            } else if (i4 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f53097a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.f53097a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i5);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval(i5);
                return reportQuasiRealtime;
            }
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!i.a(f53044a).e()) {
                JSONObject g4 = i.a(f53044a).g();
                if (g4 != null) {
                    String optString = g4.optString("__av");
                    String optString2 = g4.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f53044a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f53044a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f53044a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f53044a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f53044a != null) {
            synchronized (this.f53069w) {
                if (this.f53067u) {
                    UMRTLog.i("MobclickRT", "--->>> network is now available, rebuild instant session data packet.");
                    Context context = f53044a;
                    UMWorkDispatch.sendEvent(context, 4353, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.f53069w) {
                if (this.f53068v) {
                    Context context2 = f53044a;
                    UMWorkDispatch.sendEvent(context2, 4354, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CoreProtocolImpl.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f53103a;

        /* renamed from: b  reason: collision with root package name */
        private String f53104b;

        /* renamed from: c  reason: collision with root package name */
        private String f53105c;

        /* renamed from: d  reason: collision with root package name */
        private long f53106d;

        private d() {
            this.f53103a = null;
            this.f53104b = null;
            this.f53105c = null;
            this.f53106d = 0L;
        }

        public Map<String, Object> a() {
            return this.f53103a;
        }

        public String b() {
            return this.f53105c;
        }

        public String c() {
            return this.f53104b;
        }

        public long d() {
            return this.f53106d;
        }

        public d(String str, Map<String, Object> map, String str2, long j4) {
            this.f53103a = map;
            this.f53104b = str;
            this.f53106d = j4;
            this.f53105c = str2;
        }
    }

    private void h(Object obj) {
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
            i.a(f53044a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f]\u4e8b\u4ef6:" + jSONObject3.toString());
                        } else {
                            MLog.d("\u4e8b\u4ef6:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("gkv")) {
                    jSONObject3.put("gkv", jSONObject4.getJSONArray("gkv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f]\u6e38\u620f\u4e8b\u4ef6:" + jSONObject3.toString());
                        } else {
                            MLog.d("\u6e38\u620f\u4e8b\u4ef6:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f]\u9519\u8bef:" + jSONObject3.toString());
                        } else {
                            MLog.d("\u9519\u8bef:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("sessions")) {
                    JSONArray jSONArray = jSONObject4.getJSONArray("sessions");
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i4);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has("autopages")) {
                                jSONObject5.remove("autopages");
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put("sessions", jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f]\u4f1a\u8bdd:" + jSONObject3.toString());
                        } else {
                            MLog.d("\u4f1a\u8bdd:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("activate_msg")) {
                    jSONObject3.put("activate_msg", jSONObject4.getJSONObject("activate_msg"));
                }
                if (jSONObject4.has("active_user")) {
                    jSONObject3.put("active_user", jSONObject4.getJSONObject("active_user"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f]\u8d26\u53f7:" + jSONObject3.toString());
                        } else {
                            MLog.d("\u8d26\u53f7:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("\u57fa\u7840\u4fe1\u606f:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j4) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(f53044a)))) {
            return null;
        }
        JSONObject b4 = i.a(UMGlobalContext.getAppContext(f53044a)).b(false);
        String[] a4 = com.umeng.analytics.c.a(f53044a);
        if (a4 != null && !TextUtils.isEmpty(a4[0]) && !TextUtils.isEmpty(a4[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", a4[0]);
                jSONObject.put("puid", a4[1]);
                if (jSONObject.length() > 0) {
                    b4.put("active_user", jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a5 = r.a().a(f53044a);
        if (b4.length() != 1 || b4.optJSONObject("active_user") == null || a5 == 3) {
            r.a().b(b4, f53044a);
            if (b4.length() > 0 || a5 == 3) {
                JSONObject k4 = k();
                if (k4 != null) {
                    b(k4);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    if (a5 == 3) {
                        jSONObject3.put("analytics", new JSONObject());
                    } else if (b4.length() > 0) {
                        jSONObject3.put("analytics", b4);
                    }
                    if (k4 != null && k4.length() > 0) {
                        jSONObject2.put("header", k4);
                    }
                    if (jSONObject3.length() > 0) {
                        jSONObject2.put("content", jSONObject3);
                    }
                    return b(jSONObject2, j4);
                } catch (Throwable unused2) {
                    return jSONObject2;
                }
            }
            return null;
        }
        return null;
    }

    private boolean c(boolean z3) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f53056b == null) {
            this.f53056b = new c();
        }
        this.f53056b.a();
        ReportPolicy.ReportStrategy c4 = this.f53056b.c();
        boolean shouldSendMessage = c4.shouldSendMessage(z3);
        if (shouldSendMessage) {
            if (((c4 instanceof ReportPolicy.ReportByInterval) || (c4 instanceof ReportPolicy.DebugPolicy) || (c4 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c4 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("\u6570\u636e\u53d1\u9001\u7b56\u7565 : " + c4.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f53054y;
        if (cls == null || (method = f53055z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e("MobclickRT", "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("sessions")) {
                    JSONArray jSONArray = jSONObject4.getJSONArray("sessions");
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i4);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put("sessions", jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("\u672c\u6b21\u542f\u52a8\u4f1a\u8bdd:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("active_user")) {
                    jSONObject3.put("active_user", jSONObject4.getJSONObject("active_user"));
                    if (jSONObject3.length() > 0) {
                        MLog.d("\u672c\u6b21\u542f\u52a8\u8d26\u53f7:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("\u672c\u6b21\u542f\u52a8\u57fa\u7840\u4fe1\u606f:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i4) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i4 != 4357) {
                return;
            }
            try {
                UMRTLog.i("MobclickRT", "--->>> clean db in silent mode.");
                h.a(f53044a);
                com.umeng.commonsdk.utils.c.c(f53044a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i4 != 4358) {
                    switch (i4) {
                        case 4097:
                            if (UMUtils.isMainProgress(f53044a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(f53044a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f53044a), new JSONArray().put(obj));
                            return;
                        case 4098:
                            if (obj != null) {
                                e(obj);
                            }
                            if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case 4099:
                            v.a(f53044a);
                            return;
                        case 4100:
                            l.c(f53044a);
                            return;
                        case 4101:
                            UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case 4102:
                            UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case 4103:
                            UMRTLog.i("MobclickRT", "--->>> START_SESSION");
                            u.a().a(f53044a, obj);
                            synchronized (this.f53069w) {
                                this.f53068v = true;
                            }
                            return;
                        case 4104:
                            u.a().c(f53044a, obj);
                            return;
                        case 4105:
                            d();
                            return;
                        case 4106:
                            h(obj);
                            return;
                        default:
                            switch (i4) {
                                case 4352:
                                    UMRTLog.i("MobclickRT", "--->>> INSTANT_SESSION_START");
                                    u.a().b(f53044a, obj);
                                    synchronized (this.f53069w) {
                                        this.f53067u = true;
                                    }
                                    return;
                                case 4353:
                                    a(obj, true);
                                    return;
                                case 4354:
                                    c();
                                    return;
                                case 4355:
                                    if (!UMUtils.isMainProgress(f53044a)) {
                                        UMProcessDBHelper.getInstance(f53044a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f53044a), new JSONArray().put(obj));
                                        return;
                                    } else if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    } else {
                                        return;
                                    }
                                case 4356:
                                    if (obj == null || f53054y == null || f53055z == null) {
                                        return;
                                    }
                                    UMRTLog.i("MobclickRT", "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has("provider")) {
                                            str = jSONObject.getString("provider");
                                            str2 = jSONObject.getString("uid");
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i4) {
                                        case 8195:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case 8196:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case 8197:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i4) {
                                                case 8199:
                                                case 8200:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case 8201:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i4) {
                                                        case 8208:
                                                            UMRTLog.i("MobclickRT", "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = f53044a;
                                                            UMWorkDispatch.sendEvent(context, 8209, CoreProtocol.getInstance(context), null);
                                                            Context context2 = f53044a;
                                                            UMWorkDispatch.sendEvent(context2, 4354, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case 8209:
                                                            a(obj, false);
                                                            return;
                                                        case 8210:
                                                            UMRTLog.i("MobclickRT", "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (!UMUtils.isMainProgress(f53044a) || (this.f53056b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                return;
                                                            }
                                                            a(true);
                                                            return;
                                                        default:
                                                            switch (i4) {
                                                                case 8213:
                                                                    if (FieldManager.allow("header_foreground_count")) {
                                                                        if (DeviceConfig.getGlobleActivity(f53044a) != null) {
                                                                            u.b(f53044a);
                                                                        }
                                                                        Context context3 = f53044a;
                                                                        UMWorkDispatch.sendEventEx(context3, 8213, CoreProtocol.getInstance(context3), null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 8214:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String optString = ((JSONObject) obj).optString("startTime");
                                                                        String optString2 = ((JSONObject) obj).optString("period");
                                                                        String optString3 = ((JSONObject) obj).optString("debugkey");
                                                                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = f53044a;
                                                                        String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                        com.umeng.common.b.a(context4, str3, "startTime", optString);
                                                                        com.umeng.common.b.a(f53044a, str3, "period", optString2);
                                                                        com.umeng.common.b.a(f53044a, str3, "debugkey", optString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 8215:
                                                                    com.umeng.common.b.a(f53044a, AnalyticsConfig.RTD_SP_FILE);
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
                    String optString4 = ((JSONObject) obj).optString("pk");
                    Object opt = ((JSONObject) obj).opt("pv");
                    if (TextUtils.isEmpty(optString4)) {
                        return;
                    }
                    String[] a4 = com.umeng.analytics.c.a(f53044a);
                    if (a4 != null && !TextUtils.isEmpty(a4[0]) && !TextUtils.isEmpty(a4[1])) {
                        if ("_$!mobile".equals(optString4)) {
                            com.umeng.analytics.c.a((String) opt);
                            return;
                        } else if ("_$!email".equals(optString4)) {
                            com.umeng.analytics.c.b((String) opt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(optString4, opt);
                            return;
                        }
                    }
                    MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f53044a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString("provider");
                String string2 = jSONObject.getString("uid");
                long j4 = jSONObject.getLong("ts");
                String[] a4 = com.umeng.analytics.c.a(f53044a);
                if (a4 != null && string.equals(a4[0]) && string2.equals(a4[1])) {
                    return;
                }
                u.a().a(f53044a, j4);
                String c4 = y.a().c(f53044a);
                boolean b4 = u.a().b(f53044a, j4, false);
                com.umeng.analytics.c.a(f53044a, string, string2);
                UMRTLog.i("MobclickRT", "--->>> onProfileSignIn: force generate new session: session id = " + c4);
                u.a().a(f53044a, j4, true);
                if (b4) {
                    u.a().b(f53044a, j4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f53044a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j4 = sharedPreferences.getLong("first_activate_time", 0L);
            if (j4 == 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong("first_activate_time", currentTimeMillis).commit();
                    return currentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j4;
        } catch (Throwable unused2) {
            return 0L;
        }
    }

    public void c(Object obj) {
        b(f53044a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j4 = jSONObject.getLong("ts");
                b(f53044a);
                d();
                String[] a4 = com.umeng.analytics.c.a(f53044a);
                if (a4 == null || TextUtils.isEmpty(a4[0]) || TextUtils.isEmpty(a4[1])) {
                    return;
                }
                u.a().a(f53044a, j4);
                String c4 = y.a().c(f53044a);
                UMRTLog.i("MobclickRT", "--->>> onProfileSignIn: force generate new session: session id = " + c4);
                boolean b4 = u.a().b(f53044a, j4, false);
                com.umeng.analytics.c.b(f53044a);
                u.a().a(f53044a, j4, true);
                if (b4) {
                    u.a().b(f53044a, j4);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j4) {
        try {
            if (q.a(jSONObject) > j4) {
                jSONObject = null;
                i.a(f53044a).a(true, false);
                i.a(f53044a).b();
                UMRTLog.i("MobclickRT", "--->>> Instant session packet overload !!! ");
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z3) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = i.a(f53044a).a(z3);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    if (jSONObject.has("sessions")) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("sessions");
                        JSONArray jSONArray4 = new JSONArray();
                        int i4 = 0;
                        while (i4 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i4);
                            JSONArray optJSONArray = jSONObject2.optJSONArray("pages");
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("autopages");
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put("pages", optJSONArray2);
                                jSONObject2.remove("autopages");
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList<JSONObject> arrayList = new ArrayList();
                                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i5));
                                }
                                for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i6));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey("page_start");
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                for (JSONObject jSONObject3 : arrayList) {
                                    jSONArray5.put(jSONObject3);
                                }
                                jSONObject2.put("pages", jSONArray5);
                                jSONObject2.remove("autopages");
                            }
                            if (jSONObject2.has("pages")) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray("pages");
                                int i7 = 0;
                                while (i7 < optJSONArray3.length()) {
                                    JSONObject jSONObject4 = optJSONArray3.getJSONObject(i7);
                                    if (jSONObject4.has("page_start")) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject4.put("ts", jSONObject4.getLong("page_start"));
                                        jSONObject4.remove("page_start");
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i7++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put("pages", optJSONArray3);
                                jSONObject2.put("$page_num", optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put("$page_num", 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i4++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put("sessions", jSONArray4);
                    }
                } catch (Exception e4) {
                    MLog.e("merge pages error");
                    e4.printStackTrace();
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53044a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a4 = com.umeng.analytics.c.a(f53044a);
            if (a4 != null && !TextUtils.isEmpty(a4[0]) && !TextUtils.isEmpty(a4[1])) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("provider", a4[0]);
                jSONObject5.put("puid", a4[1]);
                if (jSONObject5.length() > 0) {
                    JSONObject jSONObject6 = new JSONObject();
                    String a5 = com.umeng.analytics.c.a();
                    if (a5 != null) {
                        jSONObject6.put("_$!mobile", a5);
                    }
                    String b4 = com.umeng.analytics.c.b();
                    if (b4 != null) {
                        jSONObject6.put("_$!email", b4);
                    }
                    Map<String, Object> c4 = com.umeng.analytics.c.c(f53044a);
                    if (c4 != null && c4.size() > 0) {
                        for (String str : c4.keySet()) {
                            jSONObject6.put(str, c4.get(str));
                        }
                    }
                    if (jSONObject6.length() > 0) {
                        jSONObject5.put("up", jSONObject6);
                    }
                    jSONObject.put("active_user", jSONObject5);
                }
            }
            if (ABTest.getService(f53044a).isInTest()) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(ABTest.getService(f53044a).getTestName(), ABTest.getService(f53044a).getGroupInfo());
                jSONObject.put("group_info", jSONObject7);
            }
            r.a().a(jSONObject, f53044a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z3) {
        if (this.f53056b == null) {
            this.f53056b = new c();
        }
        ReportPolicy.ReportStrategy c4 = this.f53056b.c();
        if (c4 instanceof ReportPolicy.DefconPolicy) {
            if (z3) {
                return ((ReportPolicy.DefconPolicy) c4).shouldSendMessageByInstant();
            }
            return c4.shouldSendMessage(false);
        }
        return true;
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            f(jSONObject);
                        }
                    } else {
                        f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z3) {
        if (c(z3)) {
            if (!(this.f53056b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f53044a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i("MobclickRT", "--->>> constructMessage()");
                    j();
                }
            } else if (z3) {
                if (UMEnvelopeBuild.isOnline(f53044a)) {
                    UMRTLog.i("MobclickRT", "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(f53044a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i("MobclickRT", "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i4++;
                }
            } catch (Throwable unused) {
            }
        }
        return i4 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i4++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i4 >= length;
    }

    public JSONObject a(long j4) {
        if (TextUtils.isEmpty(y.a().d(f53044a))) {
            return null;
        }
        JSONObject b4 = b(false);
        int a4 = r.a().a(f53044a);
        if (b4.length() > 0) {
            if (b4.length() == 1) {
                if (b4.optJSONObject("active_user") != null && a4 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b4.optString("userlevel")) && a4 != 3) {
                    return null;
                }
            } else if (b4.length() == 2 && b4.optJSONObject("active_user") != null && !TextUtils.isEmpty(b4.optString("userlevel")) && a4 != 3) {
                return null;
            }
            String optString = b4.optString("sessions");
            String optString2 = b4.optString("gkv");
            String optString3 = b4.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b4)) {
                return null;
            }
        } else if (a4 != 3) {
            return null;
        }
        JSONObject l4 = l();
        if (l4 != null) {
            c(l4);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a4 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b4.length() > 0) {
                jSONObject2.put("analytics", b4);
            }
            if (l4 != null && l4.length() > 0) {
                jSONObject.put("header", l4);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j4);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j4) {
        try {
            if (q.a(jSONObject) > j4) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("header");
                jSONObject2.put("eof", q.a(jSONObject));
                jSONObject.put("header", jSONObject2);
                return q.a(f53044a, j4, jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j4, int i4) {
        if (j4 != 0) {
            if (System.currentTimeMillis() - j4 <= 28800000) {
                return i4 < 5000;
            }
            o();
            return true;
        }
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            g(jSONObject);
                        }
                    } else {
                        g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z3) {
        if (z3) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f53044a) && d(true)) {
            i();
        }
    }
}
