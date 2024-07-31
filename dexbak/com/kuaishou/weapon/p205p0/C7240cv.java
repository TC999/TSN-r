package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UContent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7240cv {

    /* renamed from: a */
    public static String f24738a = "appkey";

    /* renamed from: b */
    public static String f24739b = "secretkey";

    /* renamed from: c */
    public static String f24740c = "pver";

    /* renamed from: d */
    public static String f24741d = "sdkver";

    /* renamed from: e */
    public static String f24742e = "ksid";

    /* renamed from: f */
    public static String f24743f = "timestamp";

    /* renamed from: g */
    public static String f24744g = "sign";

    /* renamed from: a */
    public static String m34028a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    /* renamed from: b */
    public static JSONObject m34027b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            m34029a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put("device_id", C7229cm.m34078b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static JSONObject m34025c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", C7205bt.m34131a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", C7191bh.m34230q(context));
            try {
                String m33876b = C7283h.m33888a(context, "re_po_rt").m33876b(C7262df.f24897i, C7202bq.f24602e);
                if (TextUtils.isEmpty(m33876b)) {
                    m33876b = C7202bq.f24602e;
                }
                jSONObject.put("pver", m33876b);
            } catch (Exception unused) {
                jSONObject.put("pver", C7202bq.f24602e);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, 1);
            jSONObject.put(UContent.f38088S, C7202bq.f24604g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put("device_id", C7229cm.m34078b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: d */
    private static Map m34024d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f24738a, str);
            hashMap.put(f24739b, str2);
            hashMap.put(f24743f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f24744g, m34026b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m34030a(Context context) {
        Map m34024d = m34024d(context);
        if (m34024d == null || m34024d.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : m34024d.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    /* renamed from: b */
    private static String m34026b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f24738a));
            sb.append(map.get(f24739b));
            sb.append(map.get(f24743f));
            return C7281f.m33897a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m34029a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", C7205bt.m34131a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", C7191bh.m34230q(context));
            jSONObject.put("dpver", C7283h.m33888a(context, "re_po_rt").m33876b(C7262df.f24895g, C7202bq.f24602e));
            jSONObject.put(Constants.PARAM_PLATFORM, 1);
            jSONObject.put(UContent.f38088S, C7202bq.f24604g);
        } catch (Exception unused) {
        }
    }
}
