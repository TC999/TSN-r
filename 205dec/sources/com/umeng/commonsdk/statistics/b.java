package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.acse.ottn.c4;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EnvelopeManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f53552a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f53553b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f53554c = "EnvelopeManager";

    /* renamed from: d  reason: collision with root package name */
    private static final String f53555d = "debug.umeng.umTaskId";

    /* renamed from: e  reason: collision with root package name */
    private static final String f53556e = "debug.umeng.umCaseId";

    /* renamed from: f  reason: collision with root package name */
    private static final String f53557f = "empty";

    /* renamed from: g  reason: collision with root package name */
    private static String f53558g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f53559h = "";

    /* renamed from: i  reason: collision with root package name */
    private static String f53560i;

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, String> f53561j;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f53562l;

    /* renamed from: k  reason: collision with root package name */
    private int f53563k = 0;

    static {
        HashMap hashMap = new HashMap();
        f53561j = hashMap;
        hashMap.put("header", "#h");
        f53561j.put("sdk_type", "#sdt");
        f53561j.put("access", "#ac");
        f53561j.put("device_model", "#dm");
        f53561j.put("umid", "#umid");
        f53561j.put("os", "os");
        f53561j.put("language", "#lang");
        f53561j.put("device_type", "#dt");
        f53561j.put("resolution", "#rl");
        f53561j.put("device_manufacturer", "#dmf");
        f53561j.put("device_name", "#dn");
        f53561j.put("platform_version", "#pv");
        f53561j.put("font_size_setting", "#fss");
        f53561j.put("os_version", "#ov");
        f53561j.put("device_manuid", "#did");
        f53561j.put("platform_sdk_version", "#psv");
        f53561j.put("device_brand", "#db");
        f53561j.put("appkey", "#ak");
        f53561j.put("id_tracking", "#itr");
        f53561j.put("id_type", "#it");
        f53561j.put("uuid", "#ud");
        f53561j.put("device_id", "#dd");
        f53561j.put("imprint", "#imp");
        f53561j.put("sdk_version", "#sv");
        f53561j.put("st", "#st");
        f53561j.put("analytics", "#a");
        f53561j.put("package_name", "#pkg");
        f53561j.put("app_signature", "#sig");
        f53561j.put("app_sig_sha1", "#sis1");
        f53561j.put("app_sig_sha", "#sis");
        f53561j.put("app_version", "#av");
        f53561j.put("version_code", "#vc");
        f53561j.put("idmd5", "#imd");
        f53561j.put("mccmnc", "#mnc");
        f53561j.put("device_board", "#boa");
        f53561j.put("device_manutime", "#mant");
        f53561j.put("timezone", "#tz");
        f53561j.put("country", "#ct");
        f53561j.put("carrier", "#car");
        f53561j.put("display_name", "#disn");
        f53561j.put("network_type", "#nt");
        f53561j.put("com_ver", "#cv");
        f53561j.put("mini_ver", "#mv");
        f53561j.put("com_type", "#cot");
        f53561j.put("module", "#mod");
        f53561j.put("api_level", "#al");
        f53561j.put("session_id", "#sid");
        f53561j.put("local_ip", "#ip");
        f53561j.put("successful_requests", "#sre");
        f53561j.put("failed_requests", "#fre");
        f53561j.put("req_time", "#ret");
        f53561j.put("channel", "#chn");
        f53561j.put("wrapper_type", "#wt");
        f53561j.put("wrapper_version", "#wv");
        f53561j.put("targetSdkVer", "#tsv");
        f53561j.put("rps_pr", "#rps");
        f53561j.put("module_ver", "#mov");
        f53561j.put("vertical_type", "#vt");
        f53561j.put("secret", "#sec");
        f53561j.put("pro_ver", "#prv");
        f53561j.put("$pr_ve", "#$prv");
        f53561j.put("$ud_da", "#uda");
        f53561j.put("devicetoken", "#tok");
        f53561j.put("i_sdk_v", "#iv");
        f53561j.put("access_subtype", "#ast");
        f53561j.put("backstate", "#bst");
        f53561j.put("zdata_ver", "#zv");
        f53561j.put("zdata_req_ts", "#zrt");
        f53561j.put("app_b_v", "#bv");
        f53561j.put("zdata", "#zta");
        f53561j.put("module_tag", "#mt");
        f53561j.put("zid_sdk_version", "#zsv");
        f53561j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return f53561j.containsKey(str) ? f53561j.get(str) : str;
    }

    private static boolean b() {
        f53558g = UMUtils.getSystemProperty("debug.umeng.umTaskId", "");
        f53559h = UMUtils.getSystemProperty("debug.umeng.umCaseId", "");
        return (!TextUtils.isEmpty(f53558g) && !"empty".equals(f53558g)) && (!TextUtils.isEmpty(f53559h) && !"empty".equals(f53559h));
    }

    public static void a() {
        if (f53560i != null) {
            f53560i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f53558g);
                    jSONObject.put("umCaseId", f53559h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
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
                return a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a4 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a4 != 0) {
                return a(a4, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i("EnvelopeManager", "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j4 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i("EnvelopeManager", "free size is " + j4);
        }
        return j4;
    }

    private JSONObject a(int i4, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i4);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i4);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z3;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i("EnvelopeManager", "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i("EnvelopeManager", "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has("sessions")) {
                    str4 = str2;
                    z3 = true;
                } else {
                    str4 = str2;
                    z3 = false;
                }
                JSONObject a4 = a(context, str4, z3);
                if (a4 != null && jSONObject != null) {
                    a4 = a(a4, jSONObject);
                }
                JSONObject jSONObject4 = a4;
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject4.put(a(str6), jSONObject2.opt(str6));
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
                        return a(101, jSONObject4);
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
                        e a5 = e.a(context);
                        if (a5 != null) {
                            a5.b();
                            String encodeToString = Base64.encodeToString(new ca().a(a5.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a("id_tracking"), encodeToString);
                                jSONObject4.put(a("header"), jSONObject5);
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
                    return a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope a6 = a(context, jSONObject4.toString().getBytes());
                    if (a6 == null) {
                        return a(111, jSONObject4);
                    }
                    envelope = a6;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject4);
                }
                int a7 = a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a7 != 0) {
                    return a(a7, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i("EnvelopeManager", "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                if (!str5.startsWith("z") && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
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
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e5) {
                        e = e5;
                        jSONObject3 = null;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e6) {
                        e = e6;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
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
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(com.umeng.commonsdk.internal.c.f53454a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt("preInitInvokedFlag", 0);
                iArr[1] = sharedPreferences.getInt("policyGrantInvokedFlag", 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
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
                return a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a4 = a(context, envelope2, "h==1.2.0", "", str);
            if (a4 != 0) {
                return a(a4, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i("EnvelopeManager", "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x03f6 -> B:194:0x03f6). Please submit an issue!!! */
    private static JSONObject a(Context context, String str, boolean z3) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences2 = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f53560i)) {
                try {
                    jSONObject = new JSONObject(f53560i);
                    sharedPreferences = sharedPreferences2;
                } catch (Exception unused) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(a("app_signature"), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a("app_sig_sha1"), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a("app_sig_sha"), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a("idmd5"), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a("mccmnc"), mccmnc);
                    f53553b = mccmnc;
                } else {
                    jSONObject2.put(a("mccmnc"), "");
                }
                if (FieldManager.allow("header_sub_os_info")) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a("sub_os_name"), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a("sub_os_version"), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a("device_type"), deviceType);
                }
                jSONObject2.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject2.put(a("sdk_type"), "Android");
                jSONObject2.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), Build.MODEL);
                jSONObject2.put(a("device_board"), Build.BOARD);
                jSONObject2.put(a("device_brand"), Build.BRAND);
                sharedPreferences = sharedPreferences2;
                jSONObject2.put(a("device_manutime"), Build.TIME);
                jSONObject2.put(a("device_manufacturer"), Build.MANUFACTURER);
                jSONObject2.put(a("device_manuid"), Build.ID);
                jSONObject2.put(a("device_name"), Build.DEVICE);
                jSONObject2.put(a("os_version"), Build.VERSION.RELEASE);
                jSONObject2.put(a("os"), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    String a4 = a("resolution");
                    jSONObject2.put(a4, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(a("mc"), DeviceConfig.getMac(context));
                jSONObject2.put(a("timezone"), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a("country"), localeInfo[0]);
                jSONObject2.put(a("language"), localeInfo[1]);
                jSONObject2.put(a("carrier"), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a("display_name"), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a("access"), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a("access"), "2G/3G");
                } else {
                    jSONObject2.put(a("access"), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a("access_subtype"), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a("others_OS"), c4.f5363a);
                } else {
                    jSONObject2.put(a("others_OS"), "Android");
                }
                jSONObject2.put(a("network_type"), DeviceConfig.getNetworkType(context));
                jSONObject2.put(a("com_ver"), "9.6.5");
                jSONObject2.put(a("com_type"), SdkVersion.SDK_TYPE);
                jSONObject2.put(a("mini_ver"), "1");
                if (!TextUtils.isEmpty(f53552a)) {
                    jSONObject2.put(a("module"), f53552a);
                }
                jSONObject2.put(a("api_level"), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a("urec_ver"), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put("xpus", "1");
                        if (DeviceConfig.hasOpsPermission(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                            jSONObject2.put("rpus", "1");
                        }
                    }
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put("issys", "1");
                    }
                } catch (Throwable unused3) {
                }
                f53560i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a("oaid_required_time"), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused4) {
            }
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put(a("successful_requests"), sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put(a("failed_requests"), sharedPreferences3.getInt("failed_requests", 0));
                jSONObject.put(a("req_time"), sharedPreferences3.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a("zid"), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a("zid_sdk_version"), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused5) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a("devicetoken"), deviceToken);
                }
            } catch (Exception e4) {
                UMCrashManager.reportCrash(context, e4);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(a("umid"), imprintProperty);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(context, e5);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.f53549a);
                jSONObject.put(a("wrapper_version"), a.f53550b);
            } catch (Exception unused6) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                jSONObject.put(a("targetSdkVer"), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(a("rps_pr"), "yes");
                } else {
                    jSONObject.put(a("rps_pr"), "no");
                }
            } catch (Throwable unused7) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f53558g);
                    jSONObject.put("umCaseId", f53559h);
                }
            } catch (Throwable unused8) {
            }
            if (("t".equals(str) || "a".equals(str)) && z3) {
                try {
                    int[] b4 = b(context);
                    jSONObject.put(a("policy"), String.valueOf(b4[0]) + String.valueOf(b4[1]) + String.valueOf(b4[2]));
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
                    jSONObject.put(a("module_tag"), jSONObject3);
                }
            } catch (Throwable unused10) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a("dk"), realTimeDebugKey);
                }
            } catch (Throwable unused11) {
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(a("i_ver"), "1.2.0");
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                    jSONObject4.put(a("a_ver"), UMUtils.VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                    jSONObject4.put(a("g_ver"), UMUtils.VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                    jSONObject4.put(a("p_ver"), UMUtils.VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                    jSONObject4.put(a("s_ver"), UMUtils.VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                    jSONObject4.put(a("c_ver"), UMUtils.VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                    jSONObject4.put(a("n_ver"), UMUtils.VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                    jSONObject4.put(a("m_ver"), UMUtils.VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject4.put(a("u_ver"), UMUtils.VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                    jSONObject4.put(a("v_ver"), UMUtils.VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject4.put(a("z_ver"), UMUtils.VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                    jSONObject4.put(a("l_ver"), UMUtils.VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                    jSONObject4.put(a("t_ver"), UMUtils.VALUE_ABTEST_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
                    jSONObject4.put(a("r_ver"), UMUtils.VALUE_ANTI_VERSION);
                }
                jSONObject.put(a("module_ver"), jSONObject4);
            } catch (Throwable unused12) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a("_$apmflag"), apmFlag);
                }
            } catch (Throwable unused13) {
            }
            byte[] a5 = ImprintHandler.getImprintService(context).a();
            if (a5 != null && a5.length > 0) {
                try {
                    jSONObject.put(a("imprint"), Base64.encodeToString(a5, 0));
                } catch (JSONException e6) {
                    UMCrashManager.reportCrash(context, e6);
                }
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put(a("header"), jSONObject);
            }
            return null;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a("vertical_type")) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f53563k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i4 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i4 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e4) {
            UMCrashManager.reportCrash(context, e4);
        }
        if (i4 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i4 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f53562l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b4 = d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b4);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        } else if (str.startsWith("h")) {
            return 122;
        } else {
            if (!str.startsWith("z") && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith("t")) {
                return d.a(context, com.umeng.commonsdk.stateless.a.f53524f, sb.toString(), binary);
            }
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
    }

    public static void a(boolean z3) {
        f53562l = z3;
    }
}
