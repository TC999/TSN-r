package com.bytedance.sdk.openadsdk.core.z;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.eq.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.wx;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends p {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ux sr;

    /* renamed from: c  reason: collision with root package name */
    private final sr f35783c;

    /* renamed from: r  reason: collision with root package name */
    private volatile Runnable f35784r;

    /* renamed from: w  reason: collision with root package name */
    private final Context f35785w;
    private static final AtomicLong xv = new AtomicLong(0);
    private static boolean ux = true;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f35782f = false;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            a.xv("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    ux.xv.set(longExtra);
                }
            } else if (intExtra == 2) {
                try {
                    if (ux.this.f35783c != null) {
                        ux.this.f35783c.c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private ux(sr srVar) {
        super("SdkSettingsHelper");
        this.f35783c = srVar == null ? ls.w() : srVar;
        Context context = ls.getContext();
        this.f35785w = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            try {
                context.registerReceiver(new c(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), wv.ls(), ev.c());
            } catch (Throwable unused) {
            }
        }
    }

    private boolean gd() {
        return TextUtils.isEmpty(k.sr().ev());
    }

    private static JSONObject p() {
        JSONObject optJSONObject;
        JSONObject fz = k.sr().fz();
        if (fz == null) {
            return new JSONObject();
        }
        Iterator<String> keys = fz.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = fz.optJSONObject(next)) != null) {
                try {
                    optJSONObject.put("plugin_update_network", k.sr().a().c(next));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return fz;
    }

    public static boolean ux() {
        return f35782f;
    }

    public static void xv() {
        if (ls.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(wv.ev());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                Context context = ls.getContext();
                context.sendBroadcast(intent, wv.ev() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", gd.r());
            jSONObject.put("ipv6", gd.ev());
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, i.c());
            jSONObject.put("model", com.bytedance.sdk.openadsdk.core.i.u());
            jSONObject.put("conn_type", ys.w(this.f35785w));
            int i4 = 1;
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            int i5 = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i5);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", eq.xv);
            jSONObject.put("plugin_version", "6.1.0.6");
            jSONObject.put("is_plugin", eq.c());
            jSONObject.put("is_boost", true);
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.p.xv.c());
            jSONObject.put("package_name", wv.ev());
            jSONObject.put("position", wv.sr() ? 1 : 2);
            jSONObject.put("app_version", wv.p());
            jSONObject.put("app_code", wv.gd());
            String str = Build.MANUFACTURER;
            jSONObject.put("vendor", str);
            jSONObject.put("app_id", k.sr().ev());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ux.w(k.sr().ev() != null ? k.sr().ev().concat(String.valueOf(currentTimeMillis)).concat(eq.xv) : ""));
            a.xv("isApplicationForeground", "app_version:" + wv.p() + "\uff0cvendor:" + str);
            jSONObject.put("locale_language", gd.gd());
            jSONObject.put("channel", eq.f33188f);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.r.c().w());
            com.bytedance.sdk.openadsdk.t.c.c(this.f35785w, jSONObject);
            com.bytedance.sdk.openadsdk.t.c.w(this.f35785w, jSONObject);
            if (eq.c()) {
                jSONObject.put("plugins", p());
            }
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.i.f());
            jSONObject.put("source", 1);
            if (i5 >= 21) {
                jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            }
            String yu = k.sr().yu();
            if (!TextUtils.isEmpty(yu)) {
                jSONObject.put("rit_list", yu);
            }
            long ba = ls.w().ba();
            if (ba > 0) {
                jSONObject.put("data_time", ba);
            }
            JSONObject z3 = ls.w().z();
            if (z3 != null) {
                jSONObject.put("digest", z3);
            }
            if (!k.sr().j()) {
                i4 = 0;
            }
            jSONObject.put("csj_type", i4);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!ys.c(this.f35785w)) {
            try {
                this.f35783c.c();
            } catch (Throwable unused) {
            }
        } else if (gd()) {
        } else {
            JSONObject f4 = f();
            wx wxVar = new wx(com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux());
            wxVar.c(com.bytedance.sdk.openadsdk.f.sr.c(wxVar, wv.r("/api/ad/union/sdk/settings/")));
            wxVar.w("User-Agent", wv.f());
            wxVar.w(f4, "settings");
            wxVar.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.ux.2
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                    Pair<Boolean, JSONObject> pair;
                    if (wVar == null || !wVar.ev()) {
                        try {
                            ux.this.f35783c.c();
                            ls.w().k();
                        } catch (Throwable unused2) {
                        }
                        q.w();
                        return;
                    }
                    try {
                        pair = com.bytedance.sdk.openadsdk.core.xv.r.c(wVar, "settings", false);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().c("setting_parse", th);
                        pair = null;
                    }
                    try {
                        JSONObject jSONObject = (JSONObject) pair.second;
                        try {
                            ux.this.c(pair.toString(), wVar.xv());
                        } catch (Throwable unused3) {
                        }
                        JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray("plugins") : null;
                        if (optJSONArray != null) {
                            com.bytedance.sdk.openadsdk.core.gb.c.w.c().c(optJSONArray);
                        }
                        try {
                            ux.this.f35783c.c(jSONObject);
                            q.c();
                            if (!ux.f35782f) {
                                boolean unused4 = ux.f35782f = true;
                            }
                            k.sr().a().ux();
                            com.bytedance.sdk.openadsdk.core.ba.c.c();
                        } catch (Throwable unused5) {
                        }
                        com.bytedance.sdk.openadsdk.core.fz.a.c().w();
                        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                            ux.xv();
                        }
                    } catch (Throwable th2) {
                        a.c("SdkSettingsHelper", "setting data error2: ", th2);
                        com.bytedance.sdk.openadsdk.core.fz.a.c().c("setting_decrypt", th2);
                    }
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    try {
                        Iterator<String> keys = k.sr().fz().keys();
                        while (keys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.gb.c.w.c().c(keys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        ux.this.f35783c.c();
                        ls.w().k();
                    } catch (Throwable unused3) {
                    }
                    q.w();
                }
            });
        }
    }

    public void sr() {
        c(false);
    }

    public static void w() {
        try {
            ba.c("tt_sdk_settings_other").w();
            ba.c("tt_sdk_settings_slot").w();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j4) {
        xv.set(j4);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c(j4);
        }
        com.bytedance.sdk.component.gd.ev.c(this, 10);
    }

    public static ux c(sr srVar) {
        if (sr == null) {
            synchronized (ux.class) {
                if (sr == null) {
                    sr = new ux(srVar);
                }
            }
        }
        return sr;
    }

    public static void c(long j4) {
        if (j4 > 0 && ls.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(wv.ev());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j4);
                ls.getContext().sendBroadcast(intent, wv.ls());
            } catch (Throwable unused) {
            }
        }
    }

    public void c(boolean z3) {
        try {
            if (gd()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z3) {
                if (this.f35784r != null) {
                    a.sr("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j4 = (xv.get() + 60000) - currentTimeMillis;
                if (j4 > 0) {
                    this.f35784r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.ux.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ux.this.f35784r = null;
                            ux.this.w(System.currentTimeMillis());
                        }
                    };
                    ev.c().postDelayed(this.f35784r, j4);
                    return;
                }
                this.f35784r = null;
                w(currentTimeMillis);
            } else if (currentTimeMillis - xv.get() < 600000) {
            } else {
                w(currentTimeMillis);
            }
        } catch (Throwable th) {
            a.c("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, Map<String, String> map) {
        int i4 = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        hashMap.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                int intValue = Integer.valueOf((String) hashMap.get("active-control")).intValue();
                long longValue = Long.valueOf((String) hashMap.get("ts")).longValue();
                String str2 = (String) hashMap.get("pst");
                String c4 = com.bykv.vk.openvk.component.video.api.f.w.c(str + intValue + longValue);
                if (c4 != null) {
                    if (c4.equalsIgnoreCase(str2)) {
                        i4 = intValue;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        f.c(i4);
    }
}
