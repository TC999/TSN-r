package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.Bundle;
import android.util.Pair;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class sr {

    /* renamed from: c  reason: collision with root package name */
    private static List<Pair<String, JSONObject>> f31493c = new ArrayList();

    public static void c(int i4, String str, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j4));
            jSONObject.putOpt("code", Integer.valueOf(i4));
            jSONObject.putOpt("message", str);
            jSONObject.putOpt("isBoost", Boolean.TRUE);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        xv("plugin_load_failed", jSONObject);
    }

    public static void w(String str, JSONObject jSONObject) {
        f31493c.add(new Pair<>(str, jSONObject));
    }

    private static void xv(String str, JSONObject jSONObject) {
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString(EventMonitor.EVENT_EXTRA, jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static void c(String str, JSONObject jSONObject) {
        xv("zeus_" + str, jSONObject);
    }

    public static void c() {
        if (f31493c.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : f31493c) {
                if (pair != null) {
                    xv((String) pair.first, (JSONObject) pair.second);
                }
            }
            f31493c.clear();
        } catch (Exception unused) {
        }
    }
}
