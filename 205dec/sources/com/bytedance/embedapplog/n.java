package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    private final Context f26772c;

    /* renamed from: f  reason: collision with root package name */
    private volatile JSONObject f26773f;

    /* renamed from: r  reason: collision with root package name */
    private volatile JSONObject f26774r;
    private final SharedPreferences sr;
    private final SharedPreferences ux;

    /* renamed from: w  reason: collision with root package name */
    private final InitConfig f26775w;
    private final SharedPreferences xv;

    public n(Context context, InitConfig initConfig) {
        this.f26772c = context;
        this.f26775w = initConfig;
        this.ux = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "embed_applog_stats", 0);
        this.xv = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "embed_header_custom", 0);
        this.sr = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "embed_last_sp_session", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f26775w.getLanguage();
    }

    public int ba() {
        return this.f26775w.getVersionCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String bk() {
        return this.f26775w.getRegion();
    }

    public String bw() {
        return this.f26775w.getAppImei() == null ? "" : this.f26775w.getAppImei();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f26775w.getAliyunUdid();
    }

    public void c(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public boolean c(ArrayList<up> arrayList) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String ck() {
        return this.ux.getString("user_agent", null);
    }

    public int eq() {
        return this.f26775w.getManifestVersionCode();
    }

    public int ev() {
        return this.ux.getInt("bav_monitor_rate", 0);
    }

    public JSONObject f() {
        return this.f26774r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fp() {
        return this.xv.getString("user_unique_id", null);
    }

    public String fz() {
        if (!TextUtils.isEmpty(this.f26775w.getAbVersion())) {
            return this.f26775w.getAbVersion();
        }
        return this.xv.getString("ab_version", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gb() {
        return null;
    }

    public String gd() {
        return this.f26775w.getAid();
    }

    public boolean gw() {
        return this.f26775w.isAndroidIdEnable();
    }

    public boolean i() {
        return this.ux.getBoolean("bav_ab_config", false);
    }

    public boolean ia() {
        if (this.f26775w.getProcess() == 0) {
            String c4 = g.c(this.f26772c);
            if (!TextUtils.isEmpty(c4)) {
                this.f26775w.setProcess(c4.contains(":") ? 2 : 1);
            } else {
                this.f26775w.setProcess(0);
            }
        }
        return this.f26775w.getProcess() == 1;
    }

    public long j() {
        return this.ux.getLong("session_interval", PolicyConfig.mServerBusyRetryBaseInternal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.f26775w.getGoogleAid();
    }

    public long ls() {
        return this.ux.getLong("batch_event_interval", PolicyConfig.mServerBusyRetryBaseInternal);
    }

    public boolean m() {
        return this.f26775w.isImeiEnable();
    }

    public String me() {
        return this.f26775w.getVersion();
    }

    public CharSequence mt() {
        return this.f26775w.getZiJieCloudPkg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.f26775w.getReleaseBuild();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return this.f26775w.getChannel();
    }

    public String pr() {
        return this.f26775w.getVersionMinor();
    }

    public boolean q() {
        return this.ux.getBoolean("bav_log_collect", false);
    }

    public long r() {
        return this.ux.getLong("app_log_last_config_time", 0L);
    }

    public long s() {
        return this.ux.getLong("abtest_fetch_interval", 0L);
    }

    public SharedPreferences sr() {
        return this.ux;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        return this.xv.getString("header_custom_info", null);
    }

    public JSONObject u() {
        JSONObject jSONObject = this.f26773f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (i()) {
                        jSONObject = new JSONObject(this.xv.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f26773f = jSONObject;
            }
        }
        return jSONObject;
    }

    public InitConfig up() {
        return this.f26775w;
    }

    public boolean ux() {
        return this.f26775w.isPlayEnable();
    }

    public String vc() {
        return this.f26775w.geCustomerAndroidId();
    }

    public String w() {
        return this.sr.getString("session_last_day", "");
    }

    public String wv() {
        return this.f26775w.getTweakedChannel();
    }

    public String wx() {
        return this.f26775w.getAbFeature();
    }

    public String x() {
        return this.f26775w.getAppBuildSerial() == null ? "" : this.f26775w.getAppBuildSerial();
    }

    public String xk() {
        return this.f26775w.getAbClient();
    }

    public int xv() {
        return this.sr.getInt("session_order", 0);
    }

    public int y() {
        return this.f26775w.getUpdateVersionCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ys() {
        return this.xv.getString("ab_sdk_version", "");
    }

    public String yu() {
        return this.f26775w.getAbGroup();
    }

    public String z() {
        return this.f26775w.getAppName();
    }

    public void c(String str, int i4) {
        this.sr.edit().putString("session_last_day", str).putInt("session_order", i4).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(JSONObject jSONObject) {
        this.xv.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv(JSONObject jSONObject) {
        be.c("setAbConfig, " + jSONObject.toString(), null);
        this.xv.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f26773f = null;
    }

    public void c(JSONObject jSONObject) {
        if (be.f26702w) {
            be.c("setConfig, " + jSONObject.toString(), null);
        }
        this.f26774r = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.ux.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= 604800) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        } else {
            edit.remove("abtest_fetch_interval");
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        be.f26701c = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 > 0 && optInt5 <= 100) {
            edit.putInt("bav_monitor_rate", optInt5);
            ge.c(true);
        } else {
            edit.remove("bav_monitor_rate");
            ge.c(false);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }
}
