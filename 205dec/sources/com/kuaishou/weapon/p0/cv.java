package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cv {

    /* renamed from: a  reason: collision with root package name */
    public static String f38234a = "appkey";

    /* renamed from: b  reason: collision with root package name */
    public static String f38235b = "secretkey";

    /* renamed from: c  reason: collision with root package name */
    public static String f38236c = "pver";

    /* renamed from: d  reason: collision with root package name */
    public static String f38237d = "sdkver";

    /* renamed from: e  reason: collision with root package name */
    public static String f38238e = "ksid";

    /* renamed from: f  reason: collision with root package name */
    public static String f38239f = "timestamp";

    /* renamed from: g  reason: collision with root package name */
    public static String f38240g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", EventMonitor.V1_STAGING_ADLOG);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String b4 = h.a(context, "re_po_rt").b("plc001_p_i", "0.0.0");
                if (TextUtils.isEmpty(b4)) {
                    b4 = "0.0.0";
                }
                jSONObject.put("pver", b4);
            } catch (Exception unused) {
                jSONObject.put("pver", "0.0.0");
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", "p0");
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", EventMonitor.V1_STAGING_ADLOG);
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f38234a, str);
            hashMap.put(f38235b, str2);
            hashMap.put(f38239f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f38240g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map d4 = d(context);
        if (d4 == null || d4.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d4.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f38234a));
            sb.append(map.get(f38235b));
            sb.append(map.get(f38239f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b("plc001_v", "0.0.0"));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", "p0");
        } catch (Exception unused) {
        }
    }
}
