package cn.jiguang.bm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.acse.ottn.c4;
import com.bytedance.embedapplog.GameReportHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2770a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2771b = true;

    /* renamed from: c  reason: collision with root package name */
    private static long f2772c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static long f2773d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2774e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2775f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static final Object f2776g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static JSONObject f2777h = null;

    /* renamed from: i  reason: collision with root package name */
    private static JSONObject f2778i = null;

    /* renamed from: j  reason: collision with root package name */
    private static List<String> f2779j = null;

    /* renamed from: k  reason: collision with root package name */
    private static int f2780k = 10;

    /* renamed from: l  reason: collision with root package name */
    private static int f2781l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static int f2782m = 50;

    /* renamed from: n  reason: collision with root package name */
    private static JSONArray f2783n;

    /* renamed from: o  reason: collision with root package name */
    private static JSONArray f2784o;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f2785p;

    /* renamed from: q  reason: collision with root package name */
    private static String f2786q;

    /* renamed from: r  reason: collision with root package name */
    private static String f2787r;

    public static Object a(Context context, Bundle bundle) {
        Bundle bundle2;
        String str;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("lifecycle_name");
        String string2 = bundle.getString("activity_name");
        String str2 = string2 + "_" + bundle.getInt("activity_hash");
        Intent intent = (Intent) bundle.getParcelable("activity_intent");
        cn.jiguang.bp.h.a("JOperateReport", "lifecycle_name:" + string);
        cn.jiguang.bp.h.a("JOperateReport", "activity_name:" + string2);
        cn.jiguang.bp.h.a("JOperateReport", "activity_intent:" + intent);
        if ("onActivityStarted".equals(string)) {
            a(context, intent);
            bundle2 = new Bundle();
            bundle2.putString("type", CampaignEx.JSON_NATIVE_VIDEO_START);
            bundle2.putString("eventNameKey", str2);
            bundle2.putString("eventName", "jg_app_viewscreen");
        } else {
            if ("onActivityResumed".equals(string)) {
                a(context, intent);
                bundle2 = new Bundle();
                str = CampaignEx.JSON_NATIVE_VIDEO_RESUME;
            } else if (!"onActivityPaused".equals(string)) {
                if ("onActivityStopped".equals(string)) {
                    bundle2 = new Bundle();
                    bundle2.putString("type", "end");
                    bundle2.putString("eventNameKey", str2);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("jg_activity", string2);
                    } catch (Throwable unused) {
                    }
                    bundle2.putString("event_property", jSONObject.toString());
                }
                return null;
            } else {
                bundle2 = new Bundle();
                str = CampaignEx.JSON_NATIVE_VIDEO_PAUSE;
            }
            bundle2.putString("type", str);
            bundle2.putString("eventNameKey", str2);
        }
        a(context, bundle2, false);
        return null;
    }

    public static Object a(Context context, Bundle bundle, boolean z3) {
        try {
            String string = bundle.getString("type");
            String string2 = bundle.getString("eventNameKey");
            if (CampaignEx.JSON_NATIVE_VIDEO_START.equals(string)) {
                cn.jiguang.bp.c.a().a(bundle.getString("eventName"), string2);
            } else if (CampaignEx.JSON_NATIVE_VIDEO_PAUSE.equals(string)) {
                cn.jiguang.bp.c.a().a(string2);
            } else if (CampaignEx.JSON_NATIVE_VIDEO_RESUME.equals(string)) {
                cn.jiguang.bp.c.a().b(string2);
            } else if ("end".equals(string)) {
                cn.jiguang.bp.c.a().a(context, z3, string2, c(bundle.getString("event_property")));
            } else if ("remove".equals(string)) {
                cn.jiguang.bp.c.a().c(string2);
            } else if ("clear".equals(string)) {
                cn.jiguang.bp.c.a().b();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject a(Context context, int i4, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        try {
            long g4 = f.g(context);
            String c4 = cn.jiguang.bp.g.c(context);
            jSONObject.put("uid", g4);
            jSONObject.put("cuid", c4);
            jSONObject.put("type", i4);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("random_id", UUID.randomUUID());
            jSONObject.put("peripheralProperty", b(context, z3));
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateReport", "peripheralProperty:", th);
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject2 == null) {
            jSONObject3 = new JSONObject();
        } else {
            try {
                jSONObject3 = new JSONObject(jSONObject2.toString());
            } catch (Throwable unused) {
                jSONObject3 = new JSONObject();
            }
        }
        if (jSONObject == null) {
            jSONObject4 = new JSONObject();
        } else {
            try {
                jSONObject4 = new JSONObject(jSONObject.toString());
            } catch (Throwable unused2) {
                jSONObject4 = new JSONObject();
            }
        }
        Iterator<String> keys = jSONObject4.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject3.put(next, jSONObject4.get(next));
            } catch (Throwable unused3) {
            }
        }
        return jSONObject3;
    }

    private static void a(int i4, String str, JSONObject jSONObject, JSONObject jSONObject2, Context context) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str);
            jSONObject.put("jg_data_source", "android");
            jSONObject.put("jg_is_first_day", cn.jiguang.bp.g.j(context) ? 1 : 0);
            jSONObject.put("jg_data_source_id", cn.jiguang.bp.g.e(context));
            jSONObject.put("jg_brand", Build.BRAND);
            JSONObject jSONObject4 = f2777h;
            if (jSONObject4 != null) {
                jSONObject = a(jSONObject4, jSONObject);
            }
            jSONObject3.put("value", jSONObject);
            jSONObject2.put("event", jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        c(context, "jg_app_cuid", new JSONObject());
    }

    public static void a(final Context context, Intent intent) {
        String queryParameter;
        String scheme;
        String host;
        cn.jiguang.bp.h.a("JOperateReport", "setReportDebug intent:" + intent);
        if (f2785p || intent == null) {
            return;
        }
        Uri data = intent.getData();
        cn.jiguang.bp.h.a("JOperateReport", "setReportDebug data:" + data);
        if (data == null || (queryParameter = data.getQueryParameter("token")) == null || (scheme = data.getScheme()) == null || (host = data.getHost()) == null || !"joperate_debug".equals(host)) {
            return;
        }
        cn.jiguang.bp.h.b("JOperateReport", "setReportDebug intent:" + intent);
        if (cn.jiguang.bp.g.a(context) + cn.jiguang.bp.g.b(context) <= 0) {
            cn.jiguang.bp.h.g("JOperateReport", "There is no CUID now, please wait a while and try again\uff01");
            return;
        }
        f2785p = true;
        f2787r = queryParameter;
        f2786q = scheme;
        cn.jiguang.bp.h.a("JOperateReport", "setReportDebug mToken:" + f2787r);
        cn.jiguang.bp.h.a("JOperateReport", "setReportDebug mScheme:" + f2786q);
        f.a(new Runnable() { // from class: cn.jiguang.bm.i.4
            @Override // java.lang.Runnable
            public void run() {
                i.g(context, i.h(context, 0, "jg_debug", new JSONObject(), false));
            }
        }, new int[0]);
    }

    public static void a(Context context, Bundle bundle, Set<String> set) {
        a(context, bundle.getString("event_id"), c(bundle.getString("event_property")), set);
    }

    private static void a(Context context, String str, JSONObject jSONObject, Set<String> set) {
        d(context, 1, str, jSONObject, false);
    }

    private static void a(Context context, String str, JSONObject jSONObject, boolean z3) {
        d(context, 0, str, jSONObject, z3);
    }

    private static void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry<String, cn.jiguang.bn.a> entry : a.a(context).b()) {
                jSONObject4.put(entry.getKey(), entry.getValue().b());
            }
            d.a(context, a.a(context).c().toString());
            jSONObject3.put("value", jSONObject4);
            jSONObject2.put("userProperties", jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context, boolean z3) {
        synchronized (i.class) {
            if (0 != f2772c) {
                return;
            }
            if (z3) {
                return;
            }
            if (context.getPackageName().equals(f.h(context))) {
                f2772c = System.currentTimeMillis();
                if (cn.jiguang.bp.g.i(context)) {
                    f2773d = System.currentTimeMillis();
                    cn.jiguang.bp.g.a(context, false);
                    c(context, "jg_app_active", new JSONObject());
                }
            }
        }
    }

    public static void a(Bundle bundle) {
        StringBuilder sb;
        String str;
        if (bundle != null) {
            int i4 = bundle.getInt("interval", 10);
            if (i4 >= 0) {
                f2780k = i4;
                sb = new StringBuilder();
                str = "set report interval success, interval:";
            } else {
                sb = new StringBuilder();
                str = "set report interval fail, interval:";
            }
            sb.append(str);
            sb.append(i4);
            cn.jiguang.bp.h.b("JOperateReport", sb.toString());
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray) {
        if (jSONObject == null) {
            f2778i = null;
            f2779j = null;
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            cn.jiguang.bp.h.a("JOperateReport", "set notification :" + jSONObject.toString());
            List asList = Arrays.asList("jg_msg_id", "jg_task_id", "jg_plan_id");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (asList.contains(next)) {
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            f2778i = jSONObject2;
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONArray == null) {
            f2779j = null;
            return;
        }
        f2779j = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                f2779j.add(jSONArray.getString(i4));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    private static boolean a(String str) {
        return "jg_app_active".equals(str) || "jg_app_cuid".equals(str);
    }

    private static JSONArray b(String str) {
        String[] split;
        JSONArray jSONArray = new JSONArray();
        if (str != null && (split = str.split("\n")) != null) {
            for (int i4 = 0; i4 < split.length; i4++) {
                cn.jiguang.bp.h.a("JOperateReport", "getOldReportData file:" + i4 + ":" + split[i4]);
                try {
                    if (!TextUtils.isEmpty(split[i4])) {
                        jSONArray.put(new JSONObject(split[i4]));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject b(Context context, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject c4 = c(context, z3);
            if (c4 != null) {
                jSONObject = c4;
            }
            cn.jiguang.bp.h.a("JOperateReport", "getJsonPeripheralPropertyAll:" + jSONObject);
            jSONObject.put("jg_launch_first", (f2773d > 0L ? 1 : (f2773d == 0L ? 0 : -1)) != 0 ? 1 : 0);
            jSONObject.put("jg_launch_background", f2771b ? 1 : 0);
            jSONObject.put("jg_event_duration", (System.currentTimeMillis() - f2772c) / 1000);
            jSONObject.put("jg_org_id", cn.jiguang.bp.g.d(context));
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateReport", "getJsonPeripheralProperty:", th);
        }
        return jSONObject;
    }

    public static void b(Context context) {
        f2771b = false;
        j(context);
    }

    public static void b(Context context, Bundle bundle) {
        a(context, bundle.getString("event_id"), c(bundle.getString("event_property")), (Set<String>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                jSONArray.getJSONObject(i4).getJSONObject("peripheralProperty").put("jg_org_id", cn.jiguang.bp.g.d(context));
            } catch (Throwable unused) {
                return;
            }
        }
        jSONObject.put("type", "operate_event");
        jSONObject.put("platform", "a");
        jSONObject.put("app_key", f.j(context));
        jSONObject.put("orgId", cn.jiguang.bp.g.d(context));
        jSONObject.put("data", jSONArray);
        cn.jiguang.bp.h.a("JOperateReport", "reportJcore:" + jSONObject);
        cn.jiguang.bp.h.c("JOperateReport", "report operate event: " + jSONArray.toString());
        f.a(context, jSONObject);
    }

    public static void b(Bundle bundle) {
        if (bundle != null) {
            f2781l = bundle.getInt("type", 0);
            cn.jiguang.bp.h.b("JOperateReport", "set network type: " + f2781l);
        }
    }

    private static void b(String str, JSONObject jSONObject) {
        if ("jg_message_click".equals(str)) {
            a(jSONObject, jSONObject.optJSONArray("jg_target_event"));
        }
    }

    public static JSONObject c(Context context, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("jg_app_name", cn.jiguang.bp.a.b(context));
            jSONObject.put("jg_operate_sdk_ver", g.a(context).a());
            jSONObject.put("jg_app_version", cn.jiguang.bp.a.a(context));
            jSONObject.put("jg_app_key", f.j(context));
            if (!z3) {
                jSONObject.put("jg_channel_source", f.b(context));
                jSONObject.put("jg_device_id", f.i(context));
                JSONObject a4 = f.a(context);
                int i4 = 1;
                if (a4 != null) {
                    jSONObject.put("jg_manufacturer", a4.optString("manufacturer", ""));
                    jSONObject.put("jg_devices_model", a4.optString("model", ""));
                    jSONObject.put("jg_os_language", a4.optString("language", ""));
                    jSONObject.put("jg_os_version", a4.optString("os_version", ""));
                    jSONObject.put("jg_rom_version", a4.optString("romversion", ""));
                    String[] split = a4.optString("resolution", "").split("\\*");
                    if (2 == split.length) {
                        jSONObject.put("jg_screen_width", split[0]);
                        jSONObject.put("jg_screen_height", split[1]);
                    }
                    jSONObject.put("jg_screen_size", a4.optString("screensize", ""));
                    jSONObject.put("jg_mac_address", a4.optString("mac", ""));
                    jSONObject.put("jg_time_zone", a4.optString("timezone", ""));
                }
                Bundle e4 = f.e(context);
                if (e4 != null) {
                    boolean containsKey = e4.containsKey("lat");
                    boolean containsKey2 = e4.containsKey("lot");
                    if (containsKey && containsKey2) {
                        jSONObject.put("jg_latitude", e4.getDouble("lat"));
                        jSONObject.put("jg_longitude", e4.getDouble("lot"));
                    }
                    if (e4.containsKey("wss")) {
                        jSONObject.put("jg_ssid", e4.getString("wss"));
                    }
                    String string = e4.containsKey("networkType") ? e4.getString("networkType") : "";
                    String string2 = e4.containsKey("operator") ? e4.getString("operator") : "";
                    jSONObject.put("jg_network_type", string);
                    if (!string.equals("wifi")) {
                        i4 = 0;
                    }
                    jSONObject.put("jg_wifi", i4);
                    jSONObject.put("jg_carrier", string2);
                }
            }
            jSONObject.put("jg_platform_type", "app");
            jSONObject.put("jg_os", "android");
            String a5 = cn.jiguang.bp.a.a();
            if (a5 != null) {
                jSONObject.put("jg_os", c4.f5363a);
                jSONObject.put("jg_os_version", a5);
            }
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateReport", "getJsonPeripheralProperty:", th);
        }
        return jSONObject;
    }

    private static JSONObject c(String str) {
        if (str == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateReport", "" + str, th);
            return new JSONObject();
        }
    }

    public static void c(Context context) {
        a(context, "jg_app_launch", new JSONObject(), true);
    }

    public static void c(Context context, Bundle bundle) {
        String string = bundle.getString("event_id");
        JSONObject c4 = c(bundle.getString("event_property"));
        b(string, c4);
        c(context, string, c4);
    }

    private static void c(Context context, String str, JSONObject jSONObject) {
        d(context, 0, str, jSONObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        if (jSONObject2 == null) {
            cn.jiguang.bp.f.a(context, jSONObject2);
            return;
        }
        cn.jiguang.bp.f.b(context, "\n" + jSONObject2);
    }

    public static void c(Bundle bundle) {
        if (bundle != null) {
            int i4 = bundle.getInt("count", 0);
            if (i4 < 0 || i4 > 500) {
                cn.jiguang.bp.h.e("JOperateReport", "please set event cache count between 0-500, " + i4);
                return;
            }
            f2782m = i4;
            cn.jiguang.bp.h.b("JOperateReport", "Successfully set event count, " + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str, JSONObject jSONObject) {
        StringBuilder sb;
        String str2;
        Iterator<String> keys = jSONObject.keys();
        if (str.length() <= 256) {
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                str = keys.next();
                if (str.length() > 256) {
                    sb = new StringBuilder();
                    str2 = "Max cannot greater than 256\uff0ckey:";
                    break;
                }
                Object opt = jSONObject.opt(str);
                if (String.valueOf(opt).length() > 256) {
                    if (opt instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) opt;
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            Object opt2 = jSONArray.opt(i4);
                            if (String.valueOf(opt2).length() > 256) {
                                cn.jiguang.bp.h.e("JOperateReport", "Max cannot greater than 256\uff0clist value:" + opt2);
                                opt2 = String.valueOf(opt2).substring(0, 257);
                            }
                            jSONArray2.put(opt2);
                        }
                        try {
                            jSONObject.put(str, jSONArray2);
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    cn.jiguang.bp.h.e("JOperateReport", "Max cannot greater than 256\uff0cvalue:" + opt);
                    try {
                        jSONObject.put(str, String.valueOf(opt).substring(0, 257));
                    } catch (Throwable unused2) {
                    }
                }
            }
            return false;
        }
        sb = new StringBuilder();
        str2 = "Max cannot greater than 256\uff0ceventKey:";
        sb.append(str2);
        sb.append(str);
        cn.jiguang.bp.h.g("JOperateReport", sb.toString());
        return true;
    }

    public static Object d(Context context, Bundle bundle) {
        return Boolean.valueOf(f2785p);
    }

    public static Object d(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("properties");
        cn.jiguang.bp.h.a("JOperateReport", "set utm :" + string.toString());
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject();
            List asList = Arrays.asList("utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (asList.contains(next)) {
                    jSONObject2.put("jg_" + next, jSONObject.get(next));
                }
            }
            f2777h = jSONObject2;
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static void d(Context context) {
        f2771b = true;
        c(context, "jg_app_hide", new JSONObject());
        cn.jiguang.bp.g.e(context, System.currentTimeMillis());
        cn.jiguang.bp.h.a("JOperateReport", "clear notificationProperties");
        a((JSONObject) null, (JSONArray) null);
    }

    private static void d(Context context, int i4, String str, JSONObject jSONObject, boolean z3) {
        e(context, i4, str, jSONObject, z3);
        f(context, i4, str, jSONObject, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str, JSONObject jSONObject) {
        synchronized (f2775f) {
            cn.jiguang.bp.h.a("JOperateReport", "newReport:" + jSONObject);
            cn.jiguang.bp.h.a("JOperateReport", "newReport reportCache:" + f2783n);
            if (f2783n == null) {
                JSONArray n4 = n(context);
                f2783n = n4;
                if (n4 == null) {
                    f2783n = new JSONArray();
                }
            }
            cn.jiguang.bp.h.a("JOperateReport", "newReport reportCache length:" + f2783n.length());
            if (!a(str)) {
                f2783n.put(jSONObject);
                c(context, jSONObject);
            }
            if (p(context)) {
                l(context);
                long currentTimeMillis = System.currentTimeMillis() - cn.jiguang.bp.g.g(context);
                if (f2783n.length() > 0 && (currentTimeMillis > f2780k * 1000 || f2783n.length() > f2782m)) {
                    b(context, f2783n);
                    f2783n = new JSONArray();
                    c(context, (JSONObject) null);
                    cn.jiguang.bp.g.h(context);
                }
            }
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        cn.jiguang.bp.h.a("JOperateReport", "setOldReportData file:" + jSONObject2);
        if (jSONObject2 == null) {
            cn.jiguang.bp.f.c(context, "");
            return;
        }
        cn.jiguang.bp.f.d(context, "\n" + jSONObject2);
    }

    public static Object e(Context context, Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString("type")) == null) {
            return null;
        }
        if (GameReportHelper.REGISTER.equals(string)) {
            cn.jiguang.bo.a.a().a(context, bundle);
        } else if ("clear".equals(string)) {
            cn.jiguang.bo.a.a().b(context, bundle);
        } else if ("unregister".equals(string)) {
            cn.jiguang.bo.a.a().c(context, bundle);
        }
        return null;
    }

    private static JSONObject e(Context context, JSONObject jSONObject) {
        try {
            long g4 = f.g(context);
            String c4 = cn.jiguang.bp.g.c(context);
            jSONObject.put("uid", g4);
            jSONObject.put("cuid", c4);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void e(Context context) {
        m(context);
    }

    private static void e(final Context context, final int i4, final String str, final JSONObject jSONObject, final boolean z3) {
        if (f2779j != null && (str.equals("jg_message_click") || f2779j.contains(str))) {
            final JSONObject jSONObject2 = f2778i;
            f.a(new Runnable() { // from class: cn.jiguang.bm.i.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject b4 = cn.jiguang.bo.a.a().b(context);
                    cn.jiguang.bp.h.a("JOperateReport", "jpush report superProperties:" + b4);
                    JSONObject c4 = cn.jiguang.bo.a.a().c(context);
                    cn.jiguang.bp.h.a("JOperateReport", "jpush report dynamicSuperProperties:" + c4);
                    JSONObject a4 = i.a(jSONObject2, i.a(jSONObject, i.a(c4, b4)));
                    cn.jiguang.bp.h.a("JOperateReport", "jpush report eventKey:" + str);
                    if (a4.length() > 500) {
                        cn.jiguang.bp.h.g("JOperateReport", "Max cannot greater than 500\uff0cNumber of attributes");
                    } else if (i.c(str, a4)) {
                    } else {
                        JSONObject h4 = i.h(context, i4, str, a4, z3);
                        cn.jiguang.bp.h.a("JOperateReport", "jpush report jsonObject:" + h4);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(h4);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("type", "conversion_event");
                            jSONObject3.put("platform", "a");
                            jSONObject3.put("app_key", f.j(context));
                            jSONObject3.put("orgId", cn.jiguang.bp.g.d(context));
                            jSONObject3.put("data", jSONArray);
                            cn.jiguang.bp.h.a("JOperateReport", "jpush operate reportJcore:" + jSONObject3);
                            cn.jiguang.bp.h.c("JOperateReport", "report jpush event: " + jSONArray.toString());
                            f.a(context, jSONObject3);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }, new int[0]);
            return;
        }
        cn.jiguang.bp.h.a("JOperateReport", "it isn't jpush report event: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, String str, JSONObject jSONObject) {
        synchronized (f2774e) {
            cn.jiguang.bp.h.a("JOperateReport", "oldReport:" + jSONObject);
            cn.jiguang.bp.h.a("JOperateReport", "oldReport reportCacheOld:" + f2784o);
            long currentTimeMillis = System.currentTimeMillis();
            if (f2784o == null) {
                JSONArray o4 = o(context);
                f2784o = o4;
                if (o4 == null) {
                    f2784o = new JSONArray();
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                cn.jiguang.bp.h.d("JOperateReport", "oldReport getOldReportData time:" + (currentTimeMillis2 - currentTimeMillis));
            }
            cn.jiguang.bp.h.a("JOperateReport", "oldReport reportCacheOld:" + f2784o.toString().length());
            cn.jiguang.bp.h.a("JOperateReport", "oldReport reportCacheOld length:" + f2784o.length());
            if (jSONObject != null) {
                if (f2784o.length() > 1000) {
                    cn.jiguang.bp.h.d("JOperateReport", "oldReport Just the first 1,000.");
                    return;
                }
                if (!a(str)) {
                    f2784o.put(jSONObject);
                    d(context, jSONObject);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                cn.jiguang.bp.h.a("JOperateReport", "oldReport save time:" + (currentTimeMillis3 - currentTimeMillis));
            } else if (p(context)) {
                l(context);
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < f2784o.length(); i4++) {
                    JSONObject optJSONObject = f2784o.optJSONObject(i4);
                    if (optJSONObject != null) {
                        try {
                            String optString = optJSONObject.getJSONObject("event").optString("id");
                            if (a.a(context).a(optString)) {
                                jSONArray.put(f(context, e(context, optJSONObject)));
                                if (jSONArray.length() == 50) {
                                    b(context, jSONArray);
                                    jSONArray = new JSONArray();
                                }
                            } else {
                                cn.jiguang.bp.h.a("JOperateReport", "oldReport no hasEventKey:" + optString);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    b(context, jSONArray);
                    new JSONArray();
                }
                d(context, (JSONObject) null);
                f2784o = null;
                long currentTimeMillis4 = System.currentTimeMillis();
                cn.jiguang.bp.h.d("JOperateReport", "oldReport send time:" + (currentTimeMillis4 - currentTimeMillis));
            }
        }
    }

    private static JSONObject f(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("event");
            JSONObject optJSONObject = jSONObject2.optJSONObject("value");
            a(context, optJSONObject, jSONObject);
            a(jSONObject2.optInt("type"), jSONObject2.optString("id"), optJSONObject, jSONObject, context);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void f(Context context) {
        g(context);
    }

    private static void f(final Context context, final int i4, final String str, final JSONObject jSONObject, final boolean z3) {
        final JSONObject jSONObject2 = f2778i;
        f.a(new Runnable() { // from class: cn.jiguang.bm.i.2
            @Override // java.lang.Runnable
            public void run() {
                if (cn.jiguang.bp.g.m(context)) {
                    cn.jiguang.bp.h.a("JOperateReport", "report JOpetate Off");
                    return;
                }
                JSONObject b4 = cn.jiguang.bo.a.a().b(context);
                cn.jiguang.bp.h.a("JOperateReport", "report superProperties:" + b4);
                JSONObject c4 = cn.jiguang.bo.a.a().c(context);
                cn.jiguang.bp.h.a("JOperateReport", "report dynamicSuperProperties:" + c4);
                JSONObject a4 = i.a(jSONObject2, i.a(jSONObject, i.a(c4, b4)));
                cn.jiguang.bp.h.a("JOperateReport", "report eventKey:" + str);
                cn.jiguang.bp.h.a("JOperateReport", "report jsonObject:" + a4);
                if (a4.length() > 500) {
                    cn.jiguang.bp.h.g("JOperateReport", "Max cannot greater than 500\uff0cNumber of attributes");
                } else if (i.c(str, a4)) {
                } else {
                    boolean k4 = i.k(context);
                    cn.jiguang.bp.h.a("JOperateReport", "hasVersion:" + k4 + ", isSaveWake:" + z3 + ", eventKey:" + str);
                    i.g(context, i4, str, a4, z3);
                    if (!k4 || z3) {
                        i.e(context, str, i.i(context, i4, str, a4, z3));
                        return;
                    }
                    i.e(context, null, null);
                    if (!a.a(context).a(str)) {
                        cn.jiguang.bp.h.a("JOperateReport", "report no hasEventKey:" + str);
                    } else if (i.f2785p) {
                        i.g(context, i.h(context, i4, str, a4, z3));
                    } else {
                        i.d(context, str, i.h(context, i4, str, a4, z3));
                    }
                }
            }
        }, new int[0]);
    }

    public static void g(Context context) {
        cn.jiguang.bp.h.a("JOperateReport", "sendNotificationPermissions");
        int a4 = cn.jiguang.bp.i.a(context);
        if (a4 == cn.jiguang.bp.g.a(context, -1)) {
            cn.jiguang.bp.h.a("JOperateReport", "sendNotificationPermissions enabled == integer : " + a4);
            return;
        }
        cn.jiguang.bp.g.b(context, a4);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("jg_date_time", System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        c(context, 1 == a4 ? "jg_notification_state_on" : "jg_notification_state_off", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, int i4, String str, JSONObject jSONObject, boolean z3) {
        synchronized (f2776g) {
            if ("jg_app_active".equals(str)) {
                cn.jiguang.bp.f.g(context, i(context, i4, str, jSONObject, z3).toString());
            } else if ("jg_app_cuid".equals(str)) {
                cn.jiguang.bp.g.f(context, h(context, i4, str, jSONObject, z3).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Context context, final JSONObject jSONObject) {
        if (f2785p) {
            f.a(new Runnable() { // from class: cn.jiguang.bm.i.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", "operate_event");
                        jSONObject2.put("platform", "a");
                        jSONObject2.put("app_key", f.j(context));
                        jSONObject2.put("orgId", cn.jiguang.bp.g.d(context));
                        JSONArray jSONArray = new JSONArray();
                        jSONObject2.put("data", jSONArray);
                        jSONObject2.put("scheme", i.f2786q);
                        jSONObject2.put("token", i.f2787r);
                        jSONObject2.put("appkey", f.j(context));
                        jSONArray.put(jSONObject);
                        cn.jiguang.bp.h.a("JOperateReport", "reportDebug jsonObject:" + jSONObject2);
                        String a4 = cn.jiguang.bp.e.a(context, jSONObject2);
                        cn.jiguang.bp.h.a("JOperateReport", "reportDebug sendDebugReport re:" + a4);
                    } catch (Throwable unused) {
                    }
                }
            }, new int[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject h(Context context, int i4, String str, JSONObject jSONObject, boolean z3) {
        JSONObject a4 = a(context, i4, z3);
        try {
            a(context, jSONObject, a4);
            a(i4, str, jSONObject, a4, context);
        } catch (Throwable unused) {
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject i(Context context, int i4, String str, JSONObject jSONObject, boolean z3) {
        JSONObject a4 = a(context, i4, z3);
        try {
            a(i4, str, jSONObject, a4, context);
        } catch (Throwable unused) {
        }
        return a4;
    }

    private static void j(Context context) {
        if (!f2770a) {
            c(context, "jg_app_show", new JSONObject());
            return;
        }
        f2770a = false;
        c(context, "jg_app_launch", new JSONObject());
        if (cn.jiguang.bp.g.p(context) > 0) {
            c(context, "jg_app_end", new JSONObject());
            cn.jiguang.bp.g.e(context, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(Context context) {
        long a4 = cn.jiguang.bp.g.a(context);
        long b4 = cn.jiguang.bp.g.b(context);
        cn.jiguang.bp.h.a("JOperateReport", "userVersion:" + a4);
        cn.jiguang.bp.h.a("JOperateReport", "eventVersion:" + b4);
        return a4 + b4 > 0;
    }

    private static void l(Context context) {
        synchronized (f2776g) {
            if (k(context)) {
                String e4 = cn.jiguang.bp.f.e(context);
                if (!TextUtils.isEmpty(e4)) {
                    if (a.a(context).a("jg_app_active")) {
                        try {
                            b(context, new JSONArray().put(f(context, e(context, new JSONObject(e4)))));
                        } catch (Throwable unused) {
                        }
                        cn.jiguang.bp.f.g(context, null);
                    } else {
                        cn.jiguang.bp.h.a("JOperateReport", "report no hasEventKey::jg_app_active");
                    }
                }
                String l4 = cn.jiguang.bp.g.l(context);
                if (!TextUtils.isEmpty(l4)) {
                    if (a.a(context).a("jg_app_cuid")) {
                        try {
                            b(context, new JSONArray().put(new JSONObject(l4)));
                        } catch (Throwable unused2) {
                        }
                        cn.jiguang.bp.g.f(context, null);
                    } else {
                        cn.jiguang.bp.h.a("JOperateReport", "report no hasEventKey::jg_app_cuid");
                    }
                }
            }
        }
    }

    private static void m(final Context context) {
        if (p(context)) {
            f.a(new Runnable() { // from class: cn.jiguang.bm.i.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (i.f2775f) {
                        if (i.f2783n == null) {
                            JSONArray unused = i.f2783n = i.n(context);
                            if (i.f2783n == null) {
                                JSONArray unused2 = i.f2783n = new JSONArray();
                            }
                        }
                        cn.jiguang.bp.h.a("JOperateReport", "flush event length:" + i.f2783n.length());
                        i.b(context, i.f2783n);
                        JSONArray unused3 = i.f2783n = new JSONArray();
                        i.c(context, (JSONObject) null);
                        cn.jiguang.bp.g.h(context);
                    }
                }
            }, new int[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray n(Context context) {
        return b(cn.jiguang.bp.f.a(context));
    }

    private static JSONArray o(Context context) {
        return b(cn.jiguang.bp.f.b(context));
    }

    private static boolean p(Context context) {
        String str;
        Bundle e4 = f.e(context);
        if (e4 == null) {
            cn.jiguang.bp.h.a("JOperateReport", "we can't get network type");
            return true;
        }
        String string = e4.containsKey("networkType") ? e4.getString("networkType") : "";
        cn.jiguang.bp.h.a("JOperateReport", "Current reporting network type is " + f2781l + ", current is " + string);
        if (f2781l == 1 && !string.equals("wifi")) {
            str = "Current reporting network type is WiFi, but current network isn't, Cancelly report";
        } else if (f2781l == 2 && (string.equals("wifi") || string.equals("unknown"))) {
            str = "Current reporting network type is WWAN, but current network isn't, Cancelly report";
        } else if (f2781l == 3) {
            str = "Current reporting network type is none, Cancelly report";
        } else if (!f.c(context).booleanValue()) {
            return true;
        } else {
            str = "Current is only jpush,so not allow report";
        }
        cn.jiguang.bp.h.b("JOperateReport", str);
        return false;
    }
}
