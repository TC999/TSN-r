package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f31439a;
    private static final List<Pair<String, JSONObject>> bl = new CopyOnWriteArrayList();
    static final Map<String, String> ok = new HashMap();

    public static void a(String str, JSONObject jSONObject) {
        bl.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject kf(String str, JSONObject jSONObject) {
        String str2 = "5.9.0.8";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i4 = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i4);
            jSONObject.put("support_abi", Arrays.toString(i4 >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "5.9.0.8");
            String ok2 = s.ok("com.byted.pangle.m");
            if (!TextUtils.isEmpty(ok2)) {
                str2 = ok2;
            }
            jSONObject2.put("plugin_version", str2);
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = ok;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put(EventMonitor.EVENT_EXTRA, jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, map.get(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private static void n(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.n.ok.ok().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.kf(str, jSONObject));
                a.a(arrayList);
            }
        });
    }

    private static void s(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString(EventMonitor.EVENT_EXTRA, jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
            return;
        }
        n(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (f31439a == null) {
            f31439a = TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        String format = String.format("https://%s%s", f31439a.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = bl;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(kf((String) pair.first, (JSONObject) pair.second));
                }
                bl.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.a.bl.ok().ok(true, format, com.bytedance.sdk.openadsdk.api.plugin.bl.a.ok(jSONObject).toString().getBytes());
    }

    public static void ok(int i4, String str, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j4));
            jSONObject.putOpt("code", Integer.valueOf(i4));
            jSONObject.putOpt("message", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        n("plugin_load_failed", jSONObject);
    }

    public static void ok(String str, JSONObject jSONObject) {
        s("zeus_" + str, jSONObject);
    }

    public static void ok() {
        List<Pair<String, JSONObject>> list = bl;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    s((String) pair.first, (JSONObject) pair.second);
                }
            }
            bl.clear();
        } catch (Exception unused) {
        }
    }

    public static void ok(AdConfig adConfig) {
        String str;
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = ok;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        if (pluginUpdateConfig != 0) {
            str = pluginUpdateConfig + "";
        } else {
            str = "2";
        }
        map.put("plugin_update_conf", str);
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
