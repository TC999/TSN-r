package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.p135a.C6317bl;
import com.bytedance.sdk.openadsdk.api.plugin.p136bl.C6322a;
import com.bytedance.sdk.openadsdk.p174n.C6496ok;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.ccg.CcgConstant;
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

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6314a {

    /* renamed from: a */
    private static SharedPreferences f22427a;

    /* renamed from: bl */
    private static final List<Pair<String, JSONObject>> f22428bl = new CopyOnWriteArrayList();

    /* renamed from: ok */
    static final Map<String, String> f22429ok = new HashMap();

    /* renamed from: a */
    public static void m36639a(String str, JSONObject jSONObject) {
        f22428bl.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kf */
    public static JSONObject m36636kf(String str, JSONObject jSONObject) {
        String str2 = "5.9.0.8";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i);
            jSONObject.put("support_abi", Arrays.toString(i >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "5.9.0.8");
            String m36552ok = C6330s.m36552ok("com.byted.pangle.m");
            if (!TextUtils.isEmpty(m36552ok)) {
                str2 = m36552ok;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = f22429ok;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(C2624bk.f8685i, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    /* renamed from: n */
    private static void m36635n(final String str, final JSONObject jSONObject) {
        C6496ok.m36207ok().m36211a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C6314a.m36636kf(str, jSONObject));
                C6314a.m36638a(arrayList);
            }
        });
    }

    /* renamed from: s */
    private static void m36629s(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(CcgConstant.f38549t, 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
            return;
        }
        m36635n(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m36638a(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (f22427a == null) {
            f22427a = TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        String format = String.format("https://%s%s", f22427a.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = f22428bl;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(m36636kf((String) pair.first, (JSONObject) pair.second));
                }
                f22428bl.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        C6317bl.m36619ok().m36615ok(true, format, C6322a.m36596ok(jSONObject).toString().getBytes());
    }

    /* renamed from: ok */
    public static void m36633ok(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m36635n("plugin_load_failed", jSONObject);
    }

    /* renamed from: ok */
    public static void m36631ok(String str, JSONObject jSONObject) {
        m36629s("zeus_" + str, jSONObject);
    }

    /* renamed from: ok */
    public static void m36634ok() {
        List<Pair<String, JSONObject>> list = f22428bl;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    m36629s((String) pair.first, (JSONObject) pair.second);
                }
            }
            f22428bl.clear();
        } catch (Exception unused) {
        }
    }

    /* renamed from: ok */
    public static void m36632ok(AdConfig adConfig) {
        String str;
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = f22429ok;
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
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
