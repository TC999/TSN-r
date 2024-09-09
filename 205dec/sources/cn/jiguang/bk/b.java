package cn.jiguang.bk;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f2697a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2698b;

    /* renamed from: c  reason: collision with root package name */
    private static String f2699c;

    public static Object a(Context context) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f2698b)) {
                try {
                    return new JSONObject(f2698b);
                } catch (Throwable unused) {
                }
            }
            cn.jiguang.cc.a a4 = cn.jiguang.cc.a.a(context);
            jSONObject.put("android_id", a4.f3247i);
            jSONObject.put("manufacturer", a4.f3250l);
            jSONObject.put("model", a4.f3241c);
            Object a5 = cn.jiguang.c.b.a(context);
            if (a5 instanceof JSONObject) {
                cn.jiguang.bq.d.c("JAppListProbeHelper", "transfer dev info succeed");
                JSONArray jSONArray = ((JSONObject) a5).getJSONArray("sim_slots");
                String str3 = "";
                String str4 = str3;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    if (jSONObject2 != null) {
                        if (TextUtils.isEmpty(str3)) {
                            str3 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("imei1", str3);
                            }
                        } else {
                            str4 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str4)) {
                                jSONObject.put("imei2", str4);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                    jSONObject.put("imei1", a4.f3254p);
                }
                jSONObject.put("os_version", ((JSONObject) a5).optString("os_version", ""));
                jSONObject.put("language", ((JSONObject) a5).optString("language", ""));
                try {
                    str = jSONObject.getJSONObject("ids").optString("joad", "");
                    try {
                        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(f2699c)) {
                            str = f2699c;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str2 = null;
                    Object a6 = cn.jiguang.bx.e.a(context, "get_all_ids", null);
                    if (a6 != null && (a6 instanceof JSONObject)) {
                        str = ((JSONObject) a6).optString("joad", "");
                        f2699c = str;
                        cn.jiguang.bq.d.c("JAppListProbeHelper", "transfer ids single, ids: " + str);
                    }
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("joad", str);
                }
            }
            if (!jSONObject.toString().equals("{}")) {
                str2 = jSONObject.toString();
            }
            f2698b = str2;
            cn.jiguang.bq.d.c("JAppListProbeHelper", "force dev info " + jSONObject.toString());
        } catch (Throwable unused4) {
        }
        return jSONObject;
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            cn.jiguang.bq.d.i("JAppListProbeHelper", "unexpected error, context: " + context + ", contentJson: " + jSONObject);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("use_config");
        context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("can_req_config", optBoolean).apply();
        f2697a = new AtomicBoolean(optBoolean);
        cn.jiguang.bq.d.f("JAppListProbeHelper", "handle probe switch cmd, use_config: " + optBoolean);
    }
}
