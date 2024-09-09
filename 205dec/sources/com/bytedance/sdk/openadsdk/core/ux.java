package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static String f35098c = "AppEnvironment";
    private boolean sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, String> f35099w;
    private long xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public static final ux f35102c = new ux();
    }

    private void sr() {
        double d4;
        Runtime runtime = Runtime.getRuntime();
        double maxMemory = runtime.maxMemory();
        Double.isNaN(maxMemory);
        float f4 = (float) ((maxMemory * 1.0d) / 1048576.0d);
        double d5 = runtime.totalMemory();
        Double.isNaN(d5);
        float f5 = (float) ((d5 * 1.0d) / 1048576.0d);
        Double.isNaN(runtime.freeMemory());
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) ls.getContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.a.f(f35098c, "\u7cfb\u7edf\u662f\u5426\u5904\u4e8e\u4f4e\u5185\u5b58\u8fd0\u884c\uff1a" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.a.f(f35098c, "maxMemory: " + f4);
        com.bytedance.sdk.component.utils.a.f(f35098c, "totalMemory: " + f5);
        com.bytedance.sdk.component.utils.a.f(f35098c, "freeMemory: " + ((float) ((d4 * 1.0d) / 1048576.0d)));
        int i4 = (int) ((f5 / f4) * 100.0f);
        com.bytedance.sdk.component.utils.a.f(f35098c, "totalMaxRate: " + i4);
        this.f35099w.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.f35099w.put("total_max_memory_rate", String.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ux() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = ls.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", k.sr().ev());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put(TTDelegateActivity.INTENT_PERMISSIONS, jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void w(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return;
        }
        this.f35099w.put("ad_id", meVar.jr());
        Map<String, String> map = this.f35099w;
        map.put("rit", "" + com.bytedance.sdk.openadsdk.core.eq.wv.gd(meVar));
        this.f35099w.put(ConstantAd.KEY_CACHE_AD, com.bytedance.sdk.openadsdk.core.eq.wv.a(meVar));
        Map<String, String> map2 = this.f35099w;
        map2.put("ad_slot_type", "" + com.bytedance.sdk.openadsdk.core.eq.wv.ev(meVar));
        this.f35099w.put("net_type", com.bytedance.sdk.component.utils.ys.r(ls.getContext()));
        if (com.bytedance.sdk.openadsdk.core.eq.u.xv(meVar)) {
            this.f35099w.put("ad_style", "is_playable");
        }
        sr();
    }

    public void xv() {
        if (this.sr || com.bytedance.sdk.openadsdk.core.eq.wv.c(this.xv, System.currentTimeMillis())) {
            return;
        }
        this.sr = true;
        com.bytedance.sdk.openadsdk.core.fz.a.c().ev(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ux.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                ux.this.sr = false;
                com.bytedance.sdk.openadsdk.core.fz.c.xv<com.bytedance.sdk.openadsdk.core.fz.c.xv> w3 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w();
                JSONObject ux = ux.this.ux();
                if (ux != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ux.this.xv = currentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.eq.ba.c("tt_sp_app_env").c("last_app_env_time", currentTimeMillis);
                    w3.w(ux.toString());
                }
                return w3;
            }
        });
    }

    private ux() {
        this.ux = "";
        HashMap hashMap = new HashMap();
        this.f35099w = hashMap;
        hashMap.put("ad_style", "default");
        this.f35099w.put("ad_id", "default");
        this.f35099w.put("rit", "default");
        this.f35099w.put(ConstantAd.KEY_CACHE_AD, "default");
        this.f35099w.put("ad_slot_type", "default");
        this.f35099w.put("net_type", "default");
        this.f35099w.put("low_memory", "default");
        this.f35099w.put("total_max_memory_rate", "default");
        this.f35099w.put("commit_hash", "eba5d13");
        this.f35099w.put("branch", "");
        this.f35099w.put("plugin_version", "6.1.0.6");
        this.f35099w.put("sdk_api_version", eq.xv);
        this.xv = com.bytedance.sdk.openadsdk.core.eq.ba.c("tt_sp_app_env").w("last_app_env_time", 0L);
        this.sr = false;
    }

    public static ux c() {
        return c.f35102c;
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return;
        }
        String py = meVar.py();
        Map<String, String> map = this.f35099w;
        if (TextUtils.isEmpty(py)) {
            py = "";
        }
        map.put("ad_info", py);
    }

    public Map<String, String> w() {
        return this.f35099w;
    }
}
