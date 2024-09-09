package com.bytedance.c.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.c.w.d;
import com.bytedance.c.w.r.d;
import com.bytedance.c.w.r.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile JSONObject f26474a;

    private static String a() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private static JSONObject b(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (f26474a == null) {
            Context i4 = d.i();
            try {
                f26474a = new JSONObject();
                f26474a.put("os", "Android");
                f26474a.put("platform", "Android");
                f26474a.put("sdk_lib", "Android");
                f26474a.put("os_version", a());
                f26474a.put("os_api", Build.VERSION.SDK_INT);
                f26474a.put("use_apm_sdk", "1");
                f26474a.put("sdk_version", 134);
                f26474a.put("sdk_version_code", 134);
                f26474a.put("sdk_version_name", "0.0.1-alpha.14-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                f26474a.put("device_model", str);
                f26474a.put("device_brand", str2);
                f26474a.put("device_manufacturer", Build.MANUFACTURER);
                if (map != null) {
                    f26474a.put("aid", String.valueOf(map.get("aid")));
                    f26474a.put("app_version", map.get("app_version"));
                    f26474a.put("version_code", map.get("version_code"));
                    f26474a.put("update_version_code", map.get("update_version_code"));
                    f26474a.put("manifest_version_code", map.get("version_code"));
                    f26474a.put("channel", map.get("channel"));
                }
                f26474a.put("bd_did", d.l().a());
                f26474a.put("package", i4.getPackageName());
                f26474a.put("display_name", i4.getApplicationInfo().name);
                d(f26474a);
            } catch (Exception unused) {
            }
        }
        jSONObject.put("header", f26474a);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject2.put("local_time_ms", currentTimeMillis);
        jSONObject2.put("tea_event_index", 10001);
        jSONObject2.put("session_id", UUID.randomUUID().toString());
        jSONObject2.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(currentTimeMillis)));
        jSONArray.put(jSONObject2);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    public static void c(b bVar) {
        Map<String, Object> a4 = d.a().a();
        if (a4 == null && a4.get("aid") == null) {
            if (bVar != null) {
                bVar.c(false);
                return;
            }
            return;
        }
        try {
            byte[] bytes = b(a4).toString().getBytes("UTF-8");
            com.bytedance.c.w.r.b b4 = w.b(new d.a().a(w.j(a4) + "?device_platform=android&version_code=134&iid=iid&aid=" + a4.get("aid")).b(true).c(bytes).d());
            if (bVar != null) {
                bVar.c(b4.a());
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject) {
        Map<String, Object> e4;
        Object obj;
        com.bytedance.c.w.ux.a a4 = com.bytedance.c.w.d.a();
        if (a4 == null || jSONObject == null || (e4 = a4.e()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : e4.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = e4.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e5) {
            b.k.c(e5);
        }
    }
}
