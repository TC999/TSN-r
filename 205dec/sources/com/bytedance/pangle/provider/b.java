package com.bytedance.pangle.provider;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    public static String a(String str, String str2, Uri uri) {
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", str);
            jSONObject.put("plugin_pkg_name", str2);
            jSONObject.put("uri", uri != null ? uri.toString() : "");
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
