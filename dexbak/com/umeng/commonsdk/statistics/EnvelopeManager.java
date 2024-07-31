package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.TSerializer;
import com.umeng.analytics.pro.UContent;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.UMSLConfig;
import com.umeng.commonsdk.stateless.UMSLNetWorkSender;
import com.umeng.commonsdk.stateless.UMSLUtils;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.IdTracker;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.SLModeUtil;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.statistics.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EnvelopeManager {

    /* renamed from: a */
    public static String f38917a = null;

    /* renamed from: b */
    public static String f38918b = "";

    /* renamed from: c */
    private static final String f38919c = "EnvelopeManager";

    /* renamed from: d */
    private static final String f38920d = "debug.umeng.umTaskId";

    /* renamed from: e */
    private static final String f38921e = "debug.umeng.umCaseId";

    /* renamed from: f */
    private static final String f38922f = "empty";

    /* renamed from: g */
    private static String f38923g = "";

    /* renamed from: h */
    private static String f38924h = "";

    /* renamed from: i */
    private static String f38925i;

    /* renamed from: j */
    private static Map<String, String> f38926j;

    /* renamed from: l */
    private static boolean f38927l;

    /* renamed from: k */
    private int f38928k = 0;

    static {
        HashMap hashMap = new HashMap();
        f38926j = hashMap;
        hashMap.put("header", "#h");
        f38926j.put(UMCommonContent.f37862u, "#sdt");
        f38926j.put(UMCommonContent.f37760Q, "#ac");
        f38926j.put("device_model", "#dm");
        f38926j.put("umid", "#umid");
        f38926j.put("os", "os");
        f38926j.put("language", "#lang");
        f38926j.put(UMCommonContent.f37805ai, "#dt");
        f38926j.put(UMCommonContent.f37867z, "#rl");
        f38926j.put(UMCommonContent.f37751H, "#dmf");
        f38926j.put(UMCommonContent.f37753J, "#dn");
        f38926j.put("platform_version", "#pv");
        f38926j.put("font_size_setting", "#fss");
        f38926j.put("os_version", "#ov");
        f38926j.put(UMCommonContent.f37752I, "#did");
        f38926j.put("platform_sdk_version", "#psv");
        f38926j.put(UMCommonContent.f37749F, "#db");
        f38926j.put("appkey", "#ak");
        f38926j.put(UMCommonContent.f37768Y, "#itr");
        f38926j.put("id_type", "#it");
        f38926j.put("uuid", "#ud");
        f38926j.put("device_id", "#dd");
        f38926j.put(UMCommonContent.f37767X, "#imp");
        f38926j.put("sdk_version", "#sv");
        f38926j.put("st", "#st");
        f38926j.put("analytics", "#a");
        f38926j.put("package_name", "#pkg");
        f38926j.put(UMCommonContent.f37857p, "#sig");
        f38926j.put(UMCommonContent.f37858q, "#sis1");
        f38926j.put(UMCommonContent.f37859r, "#sis");
        f38926j.put("app_version", "#av");
        f38926j.put("version_code", "#vc");
        f38926j.put(UMCommonContent.f37863v, "#imd");
        f38926j.put(UMCommonContent.f37745B, "#mnc");
        f38926j.put(UMCommonContent.f37748E, "#boa");
        f38926j.put(UMCommonContent.f37750G, "#mant");
        f38926j.put(UMCommonContent.f37756M, "#tz");
        f38926j.put("country", "#ct");
        f38926j.put(UMCommonContent.f37759P, "#car");
        f38926j.put("display_name", "#disn");
        f38926j.put(UMCommonContent.f37763T, "#nt");
        f38926j.put(UMCommonContent.f37823b, "#cv");
        f38926j.put(UMCommonContent.f37845d, "#mv");
        f38926j.put(UMCommonContent.f37844c, "#cot");
        f38926j.put(UMCommonContent.f37846e, "#mod");
        f38926j.put(UMCommonContent.f37806aj, "#al");
        f38926j.put("session_id", "#sid");
        f38926j.put(UMCommonContent.f37762S, "#ip");
        f38926j.put(UMCommonContent.f37764U, "#sre");
        f38926j.put(UMCommonContent.f37765V, "#fre");
        f38926j.put(UMCommonContent.f37766W, "#ret");
        f38926j.put("channel", "#chn");
        f38926j.put("wrapper_type", "#wt");
        f38926j.put("wrapper_version", "#wv");
        f38926j.put(UMCommonContent.f37795aY, "#tsv");
        f38926j.put(UMCommonContent.f37796aZ, "#rps");
        f38926j.put(UMCommonContent.f37826bc, "#mov");
        f38926j.put(UContent.f38144i, "#vt");
        f38926j.put("secret", "#sec");
        f38926j.put(UContent.f38124an, "#prv");
        f38926j.put(UContent.f38147l, "#$prv");
        f38926j.put(UContent.f38148m, "#uda");
        f38926j.put(UMCommonContent.f37770a, "#tok");
        f38926j.put(UMCommonContent.f37787aQ, "#iv");
        f38926j.put(UMCommonContent.f37761R, "#ast");
        f38926j.put("backstate", "#bst");
        f38926j.put("zdata_ver", "#zv");
        f38926j.put("zdata_req_ts", "#zrt");
        f38926j.put("app_b_v", "#bv");
        f38926j.put("zdata", "#zta");
        f38926j.put(UMCommonContent.f37812ap, "#mt");
        f38926j.put(UMCommonContent.f37809am, "#zsv");
        f38926j.put(UMCommonContent.f37811ao, "#oos");
    }

    /* renamed from: a */
    public static String m13836a(String str) {
        return f38926j.containsKey(str) ? f38926j.get(str) : str;
    }

    /* renamed from: b */
    private static boolean m13833b() {
        f38923g = UMUtils.getSystemProperty(f38920d, "");
        f38924h = UMUtils.getSystemProperty(f38921e, "");
        return (!TextUtils.isEmpty(f38923g) && !f38922f.equals(f38923g)) && (!TextUtils.isEmpty(f38924h) && !f38922f.equals(f38924h));
    }

    /* renamed from: a */
    public static void m13844a() {
        if (f38925i != null) {
            f38925i = null;
            IdTracker.m13709a();
        }
    }

    /* renamed from: b */
    public JSONObject m13831b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m13836a("header"), new JSONObject());
            try {
                if (m13833b()) {
                    jSONObject.put("umTaskId", f38923g);
                    jSONObject.put("umCaseId", f38924h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = m13835a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return m13843a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = m13837a(context, jSONObject3.toString().getBytes())) == null) {
                return m13843a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m13843a(114, jSONObject3);
            }
            int m13841a = m13841a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (m13841a != 0) {
                return m13843a(m13841a, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f38919c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return m13843a(110, new JSONObject());
        }
    }

    /* renamed from: a */
    public static long m13842a(Context context) {
        long j = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f38919c, "free size is " + j);
        }
        return j;
    }

    /* renamed from: a */
    private JSONObject m13843a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public JSONObject m13838a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f38919c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f38919c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(UContent.f38149n)) {
                    str4 = str2;
                    z = true;
                } else {
                    str4 = str2;
                    z = false;
                }
                JSONObject m13840a = m13840a(context, str4, z);
                if (m13840a != null && jSONObject != null) {
                    m13840a = m13835a(m13840a, jSONObject);
                }
                JSONObject jSONObject4 = m13840a;
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject4.put(m13836a(str6), jSONObject2.opt(str6));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str4 = "u";
                }
                String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str8 = str4 + "==" + str7 + "&=";
                    if (TextUtils.isEmpty(str8)) {
                        return m13843a(101, jSONObject4);
                    }
                    if (str8.endsWith("&=")) {
                        str8 = str8.substring(0, str8.length() - 2);
                    }
                    str5 = str8;
                } else {
                    str5 = null;
                }
                if (jSONObject4 != null) {
                    try {
                        IdTracker m13707a = IdTracker.m13707a(context);
                        if (m13707a != null) {
                            m13707a.m13704b();
                            String encodeToString = Base64.encodeToString(new TSerializer().m14505a(m13707a.m13702c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(m13836a("header"));
                                jSONObject5.put(m13836a(UMCommonContent.f37768Y), encodeToString);
                                jSONObject4.put(m13836a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return m13843a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope m13837a = m13837a(context, jSONObject4.toString().getBytes());
                    if (m13837a == null) {
                        return m13843a(111, jSONObject4);
                    }
                    envelope = m13837a;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return m13843a(114, jSONObject4);
                }
                int m13841a = m13841a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(m13836a("header")).optString(m13836a("app_version")) : null, str);
                if (m13841a != 0) {
                    return m13843a(m13841a, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f38919c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                if (!str5.startsWith(UMCommonContent.f37777aG) && !str5.startsWith("i") && !str5.startsWith(UMCommonContent.f37782aL) && !str5.startsWith("a") && !UMSLNetWorkSender.m13888a()) {
                    new UMSLNetWorkSender(context);
                    UMSLNetWorkSender.m13885b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e) {
                            e = e;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return m13843a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e3) {
                        e = e3;
                        UMCrashManager.reportCrash(context, e);
                        return m13843a(110, jSONObject3);
                    }
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str9 = next2;
                        if (jSONObject2.opt(str9) != null) {
                            try {
                                jSONObject3.put(str9, jSONObject2.opt(str9));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return m13843a(110, jSONObject3);
            }
        }
        return m13843a(110, (JSONObject) null);
    }

    /* renamed from: b */
    private static int[] m13832b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(UMInternalDataProtocol.f38818a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(UMInternalDataProtocol.f38819b, 0);
                iArr[1] = sharedPreferences.getInt(UMInternalDataProtocol.f38820c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    /* renamed from: a */
    public JSONObject m13839a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m13836a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = m13835a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return m13843a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = m13837a(context, jSONObject3.toString().getBytes())) == null) {
                return m13843a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m13843a(114, jSONObject3);
            }
            int m13841a = m13841a(context, envelope2, "h==1.2.0", "", str);
            if (m13841a != 0) {
                return m13843a(m13841a, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f38919c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return m13843a(110, new JSONObject());
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x03f6 -> B:194:0x03f6). Please submit an issue!!! */
    /* renamed from: a */
    private static JSONObject m13840a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences2 = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f38925i)) {
                try {
                    jSONObject = new JSONObject(f38925i);
                    sharedPreferences = sharedPreferences2;
                } catch (Exception unused) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(m13836a(UMCommonContent.f37857p), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(m13836a(UMCommonContent.f37858q), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(m13836a(UMCommonContent.f37859r), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(m13836a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(m13836a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(m13836a(UMCommonContent.f37863v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(m13836a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(m13836a(UMCommonContent.f37745B), mccmnc);
                    f38918b = mccmnc;
                } else {
                    jSONObject2.put(m13836a(UMCommonContent.f37745B), "");
                }
                if (FieldManager.allow(UMConstant.f39163I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(m13836a(UMCommonContent.f37754K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(m13836a(UMCommonContent.f37755L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(m13836a(UMCommonContent.f37805ai), deviceType);
                }
                jSONObject2.put(m13836a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject2.put(m13836a(UMCommonContent.f37862u), "Android");
                jSONObject2.put(m13836a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(m13836a("device_model"), Build.MODEL);
                jSONObject2.put(m13836a(UMCommonContent.f37748E), Build.BOARD);
                jSONObject2.put(m13836a(UMCommonContent.f37749F), Build.BRAND);
                sharedPreferences = sharedPreferences2;
                jSONObject2.put(m13836a(UMCommonContent.f37750G), Build.TIME);
                jSONObject2.put(m13836a(UMCommonContent.f37751H), Build.MANUFACTURER);
                jSONObject2.put(m13836a(UMCommonContent.f37752I), Build.ID);
                jSONObject2.put(m13836a(UMCommonContent.f37753J), Build.DEVICE);
                jSONObject2.put(m13836a("os_version"), Build.VERSION.RELEASE);
                jSONObject2.put(m13836a("os"), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    String m13836a = m13836a(UMCommonContent.f37867z);
                    jSONObject2.put(m13836a, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(m13836a(UMCommonContent.f37744A), DeviceConfig.getMac(context));
                jSONObject2.put(m13836a(UMCommonContent.f37756M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(m13836a("country"), localeInfo[0]);
                jSONObject2.put(m13836a("language"), localeInfo[1]);
                jSONObject2.put(m13836a(UMCommonContent.f37759P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(m13836a("display_name"), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(m13836a(UMCommonContent.f37760Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(m13836a(UMCommonContent.f37760Q), "2G/3G");
                } else {
                    jSONObject2.put(m13836a(UMCommonContent.f37760Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(m13836a(UMCommonContent.f37761R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(m13836a(UMCommonContent.f37811ao), "harmony");
                } else {
                    jSONObject2.put(m13836a(UMCommonContent.f37811ao), "Android");
                }
                jSONObject2.put(m13836a(UMCommonContent.f37763T), DeviceConfig.getNetworkType(context));
                jSONObject2.put(m13836a(UMCommonContent.f37823b), "9.6.5");
                jSONObject2.put(m13836a(UMCommonContent.f37844c), SdkVersion.SDK_TYPE);
                jSONObject2.put(m13836a(UMCommonContent.f37845d), "1");
                if (!TextUtils.isEmpty(f38917a)) {
                    jSONObject2.put(m13836a(UMCommonContent.f37846e), f38917a);
                }
                jSONObject2.put(m13836a(UMCommonContent.f37806aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(m13836a(UMCommonContent.f37802af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(m13836a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put(UMCommonContent.f37814ar, "1");
                        if (DeviceConfig.hasOpsPermission(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                            jSONObject2.put(UMCommonContent.f37815as, "1");
                        }
                    }
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(UMCommonContent.f37813aq, "1");
                    }
                } catch (Throwable unused3) {
                }
                f38925i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(m13836a(UMCommonContent.f37807ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused4) {
            }
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put(m13836a(UMCommonContent.f37764U), sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put(m13836a(UMCommonContent.f37765V), sharedPreferences3.getInt(UMCommonContent.f37765V, 0));
                jSONObject.put(m13836a(UMCommonContent.f37766W), sharedPreferences3.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(m13836a(UMCommonContent.f37808al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(m13836a(UMCommonContent.f37809am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused5) {
            }
            jSONObject.put(m13836a("channel"), UMUtils.getChannel(context));
            jSONObject.put(m13836a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(m13836a(UMCommonContent.f37770a), deviceToken);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(m13836a("umid"), imprintProperty);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                jSONObject.put(m13836a("wrapper_type"), BusinessWrapperConfig.f38914a);
                jSONObject.put(m13836a("wrapper_version"), BusinessWrapperConfig.f38915b);
            } catch (Exception unused6) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, C7282g.f24945c);
                jSONObject.put(m13836a(UMCommonContent.f37795aY), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(m13836a(UMCommonContent.f37796aZ), "yes");
                } else {
                    jSONObject.put(m13836a(UMCommonContent.f37796aZ), "no");
                }
            } catch (Throwable unused7) {
            }
            try {
                if (m13833b()) {
                    jSONObject.put("umTaskId", f38923g);
                    jSONObject.put("umCaseId", f38924h);
                }
            } catch (Throwable unused8) {
            }
            if ((UMCommonContent.f37782aL.equals(str) || "a".equals(str)) && z) {
                try {
                    int[] m13832b = m13832b(context);
                    jSONObject.put(m13836a(UMCommonContent.f37843bt), String.valueOf(m13832b[0]) + String.valueOf(m13832b[1]) + String.valueOf(m13832b[2]));
                } catch (Throwable unused9) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(m13836a(UMCommonContent.f37812ap), jSONObject3);
                }
            } catch (Throwable unused10) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(m13836a(UMCommonContent.f37842bs), realTimeDebugKey);
                }
            } catch (Throwable unused11) {
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(m13836a(UMCommonContent.f37827bd), UMInternalConfig.f38793e);
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37828be), UMUtils.VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37829bf), UMUtils.VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37830bg), UMUtils.VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37831bh), UMUtils.VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37832bi), UMUtils.VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37833bj), UMUtils.VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37834bk), UMUtils.VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37835bl), UMUtils.VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37836bm), UMUtils.VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37837bn), UMUtils.VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37838bo), UMUtils.VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37839bp), UMUtils.VALUE_ABTEST_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
                    jSONObject4.put(m13836a(UMCommonContent.f37840bq), UMUtils.VALUE_ANTI_VERSION);
                }
                jSONObject.put(m13836a(UMCommonContent.f37826bc), jSONObject4);
            } catch (Throwable unused12) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(m13836a(UMCommonContent.f37841br), apmFlag);
                }
            } catch (Throwable unused13) {
            }
            byte[] m13741a = ImprintHandler.getImprintService(context).m13741a();
            if (m13741a != null && m13741a.length > 0) {
                try {
                    jSONObject.put(m13836a(UMCommonContent.f37767X), Base64.encodeToString(m13741a, 0));
                } catch (JSONException e3) {
                    UMCrashManager.reportCrash(context, e3);
                }
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put(m13836a("header"), jSONObject);
            }
            return null;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m13835a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(m13836a("header")) != null && (jSONObject.opt(m13836a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(m13836a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(m13836a(UContent.f38144i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f38928k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private Envelope m13837a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e) {
            UMCrashManager.reportCrash(context, e);
        }
        if (i == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f38927l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    /* renamed from: a */
    private int m13841a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String m13854b = UMSLUtils.m13854b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(m13854b);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (SLModeUtil.m13463a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        } else if (str.startsWith("h")) {
            return 122;
        } else {
            if (!str.startsWith(UMCommonContent.f37777aG) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith(UMCommonContent.f37782aL)) {
                return UMSLUtils.m13861a(context, UMSLConfig.f38888f, sb.toString(), binary);
            }
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
    }

    /* renamed from: a */
    public static void m13834a(boolean z) {
        f38927l = z;
    }
}
