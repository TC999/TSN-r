package com.bytedance.pangle.provider;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.pangle.provider.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6188b {
    /* renamed from: a */
    public static String m37023a(String str, String str2, Uri uri) {
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
            jSONObject.put("plugin_pkg_name", str2);
            jSONObject.put("uri", uri != null ? uri.toString() : "");
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
