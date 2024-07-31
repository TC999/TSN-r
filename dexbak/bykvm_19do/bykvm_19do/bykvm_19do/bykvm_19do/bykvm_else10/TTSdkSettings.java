package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTSdkInitializationListener;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdnLoadFailShowConfigBean;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdnLoadFailShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitChecker;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AES;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AESKey;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.TTSettingConfigCallback;
import com.bytedance.msdk.core.corelogic.CircuitBreakerController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTSdkSettings implements ISettings {

    /* renamed from: a */
    private String f350a;

    /* renamed from: b */
    private long f351b;

    /* renamed from: c */
    private long f352c;

    /* renamed from: d */
    private String f353d;

    /* renamed from: e */
    private String f354e;

    /* renamed from: f */
    private String f355f;

    /* renamed from: g */
    private String f356g;

    /* renamed from: h */
    private int f357h;

    /* renamed from: i */
    private int f358i;

    /* renamed from: j */
    private int f359j;

    /* renamed from: p */
    private long f365p;

    /* renamed from: q */
    private long f366q;

    /* renamed from: t */
    private List<TTSettingConfigCallback> f369t;

    /* renamed from: u */
    private Map<String, Boolean> f370u;

    /* renamed from: v */
    private final AtomicBoolean f371v;

    /* renamed from: k */
    private String f360k = null;

    /* renamed from: l */
    private int f361l = 0;

    /* renamed from: m */
    private String f362m = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";

    /* renamed from: n */
    private int f363n = 100;

    /* renamed from: o */
    private int f364o = 0;

    /* renamed from: r */
    private Map<String, AdNetworkConfValue> f367r = new HashMap();

    /* renamed from: s */
    private Map<String, AdsenseRitConfig> f368s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTSdkSettings.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0957a implements TTSdkInitializationListener {

        /* renamed from: a */
        final /* synthetic */ boolean f372a;

        /* renamed from: b */
        final /* synthetic */ boolean f373b;

        C0957a(boolean z, boolean z2) {
            this.f372a = z;
            this.f373b = z2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTSdkInitializationListener
        /* renamed from: a */
        public void mo59268a() {
            Logger.m37557e("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + this.f372a);
            if (this.f372a) {
                if (!TTSdkSettings.this.f371v.get()) {
                    int size = SdkGlobalInfo.m59939B().m59905h().size();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - InitHelper.m59272d();
                    AdEventUtil.m59329a(elapsedRealtime, size, this.f373b ? 1 : 0);
                    Logger.m37562d("TTMediationSDK", "sdk init end, duration: " + elapsedRealtime + ", initAdnCount: " + size + ", isFromLocalConfig: " + this.f373b);
                }
                TTSdkSettings.this.f371v.set(true);
                InitChecker.m59286c();
                TTSdkSettings.this.m59768C();
            }
        }
    }

    public TTSdkSettings() {
        new HashMap();
        this.f369t = new CopyOnWriteArrayList();
        this.f370u = new HashMap();
        this.f371v = new AtomicBoolean(false);
    }

    /* renamed from: B */
    private boolean m59769B() {
        Boolean bool = this.f370u.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m59768C() {
        if (m59730q()) {
            synchronized (this.f369t) {
                for (TTSettingConfigCallback tTSettingConfigCallback : this.f369t) {
                    tTSettingConfigCallback.configLoad();
                }
                this.f369t.clear();
            }
        }
    }

    /* renamed from: a */
    private Long m59766a(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    /* renamed from: a */
    private String m59761a(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray == null) {
            AdnLoadFailShowControl.m59628a().m59625a(null);
            return null;
        }
        ConcurrentHashMap<String, AdnLoadFailShowConfigBean> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
                AdnLoadFailShowConfigBean adnLoadFailShowConfigBean = new AdnLoadFailShowConfigBean();
                adnLoadFailShowConfigBean.m59631a(optJSONObject.optLong("break_request_duration"));
                adnLoadFailShowConfigBean.m59630a(arrayList);
                concurrentHashMap.put(optJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), adnLoadFailShowConfigBean);
            }
        }
        AdnLoadFailShowControl.m59628a().m59625a(concurrentHashMap);
        return jSONArray.toString();
    }

    /* renamed from: a */
    private void m59759a(boolean z) {
        InitHelper.m59279a(InternalContainer.m59945d(), new C0957a(m59731p(), z));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002f A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0020 -> B:19:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0024 -> B:31:0x003d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x002f -> B:31:0x003d). Please submit an issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Long m59757b(int r6) {
        /*
            r5 = this;
        L0:
            r0 = 1
            r1 = 10000(0x2710, double:4.9407E-320)
            if (r6 == r0) goto L42
            r0 = 2
            if (r6 == r0) goto L42
            r0 = 3
            r3 = 95
            if (r6 == r0) goto L20
            r0 = 5
            if (r6 == r0) goto L42
            r0 = 7
            if (r6 == r0) goto L18
            r0 = 8
            if (r6 == r0) goto L18
            goto L3d
        L18:
            r0 = 600000(0x927c0, double:2.964394E-318)
        L1b:
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            return r6
        L20:
            r0 = 95
            r4 = 95
        L24:
            switch(r0) {
                case 94: goto L33;
                case 95: goto L28;
                case 96: goto L2f;
                default: goto L27;
            }
        L27:
            goto L3d
        L28:
            switch(r4) {
                case 94: goto L20;
                case 95: goto L2c;
                case 96: goto L20;
                default: goto L2b;
            }
        L2b:
            goto L2f
        L2c:
            r0 = 5000(0x1388, double:2.4703E-320)
            goto L1b
        L2f:
            switch(r4) {
                case 55: goto L0;
                case 56: goto L3d;
                case 57: goto L0;
                default: goto L32;
            }
        L32:
            goto L38
        L33:
            r0 = 39
            if (r4 != r0) goto L38
            goto L20
        L38:
            java.lang.Long r6 = java.lang.Long.valueOf(r1)
            return r6
        L3d:
            r0 = 94
            r4 = 125(0x7d, float:1.75E-43)
            goto L24
        L42:
            java.lang.Long r6 = java.lang.Long.valueOf(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.TTSdkSettings.m59757b(int):java.lang.Long");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0333 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m59753b(org.json.JSONArray r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.TTSdkSettings.m59753b(org.json.JSONArray):java.lang.String");
    }

    /* renamed from: c */
    private String m59749c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f367r.clear();
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        this.f367r.put(next, new AdNetworkConfValue(optJSONObject.optString("app_id"), optJSONObject.optString("app_key")));
                    }
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    /* renamed from: d */
    private String m59746d(JSONObject jSONObject) {
        this.f370u.clear();
        if (jSONObject != null) {
            try {
                if (jSONObject.optBoolean("ad_event_control")) {
                    this.f370u.put("ad_event_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_banner_control")) {
                    this.f370u.put("type_banner_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_interaction_control")) {
                    this.f370u.put("type_interaction_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_splash_control")) {
                    this.f370u.put("type_splash_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_feed_control")) {
                    this.f370u.put("type_feed_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_reward_control")) {
                    this.f370u.put("type_reward_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_full_control")) {
                    this.f370u.put("type_full_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_native_control")) {
                    this.f370u.put("type_native_control", Boolean.TRUE);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: e */
    private String m59743e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f359j = jSONObject.optInt("fetch_ad_type", 0);
            return jSONObject.toString();
        }
        return null;
    }

    /* renamed from: A */
    public boolean m59770A() {
        return this.f359j == 1;
    }

    /* renamed from: a */
    public AdNetworkConfValue m59763a(String str) {
        return this.f367r.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.ISettings
    /* renamed from: a */
    public void mo59767a() {
        try {
            SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
            this.f350a = m59131a.m59120d(DownloadModel.ETAG);
            this.f351b = m59131a.m59121c("max_age");
            this.f352c = m59131a.m59121c("max_expire_time");
            this.f353d = m59131a.m59120d("ab_version");
            this.f354e = m59131a.m59120d("ab_params");
            this.f355f = m59131a.m59120d("country");
            this.f356g = m59131a.m59120d("transparent_params");
            this.f357h = m59131a.m59127b("if_test");
            this.f358i = m59131a.m59127b("network_permission");
            this.f362m = m59131a.m59130a("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.f365p = m59131a.m59132a("break_request_times", 0L);
            this.f366q = m59131a.m59132a("break_request_hold_time", 10000L);
            CircuitBreakerController.m37366c().m37368a(this.f365p, this.f366q);
            String m59120d = m59131a.m59120d("tt_app_common_config");
            if (!TextUtils.isEmpty(m59120d)) {
                JSONObject jSONObject = new JSONObject(m59120d);
                this.f363n = jSONObject.optInt("event_batch_size", 100);
                this.f364o = jSONObject.optInt("event_send_type", 0);
            }
            Logger.m37557e("TTSETTING", "load--mAppLogUrl=" + this.f362m);
            Logger.m37557e("TTSETTING", "load--mEventBatchSize=" + this.f363n + ",mEventSendType=" + this.f364o);
            if (!TextUtils.isEmpty(m59131a.m59120d("app_abtest"))) {
                this.f360k = m59131a.m59120d("app_abtest");
            }
            String m59120d2 = m59131a.m59120d("network_conf");
            if (m59120d2 != null) {
                m59743e(new JSONObject(m59120d2));
            }
            String m59120d3 = m59131a.m59120d("adn_init_conf");
            if (!TextUtils.isEmpty(m59120d3)) {
                if (!m59120d3.startsWith("[") && !m59120d3.startsWith("{")) {
                    m59120d3 = AES.m59265a(m59120d3, AESKey.m59260a());
                }
                m59749c(new JSONObject(m59120d3));
            }
            String m59120d4 = m59131a.m59120d("adn_control_conf");
            if (!TextUtils.isEmpty(m59120d4)) {
                if (!m59120d4.startsWith("[") && !m59120d4.startsWith("{")) {
                    m59120d4 = AES.m59265a(m59120d4, AESKey.m59260a());
                }
                m59761a(new JSONArray(m59120d4));
            }
            String m59120d5 = m59131a.m59120d("rit_conf");
            if (!TextUtils.isEmpty(m59120d5)) {
                if (!m59120d5.startsWith("[") && !m59120d5.startsWith("{")) {
                    m59120d5 = AES.m59265a(m59120d5, AESKey.m59260a());
                }
                m59753b(new JSONArray(m59120d5));
            }
            String m59120d6 = m59131a.m59120d("module_control");
            if (!TextUtils.isEmpty(m59120d6)) {
                m59746d(new JSONObject(m59120d6));
            }
            boolean m59135a = m59131a.m59135a("all_active_control");
            if (m59135a) {
                this.f370u.put("active_control", Boolean.valueOf(m59135a));
            }
        } catch (Throwable unused) {
        }
        m59759a(true);
    }

    /* renamed from: a */
    public void m59764a(TTSettingConfigCallback tTSettingConfigCallback) {
        if (tTSettingConfigCallback == null) {
            return;
        }
        if (m59730q()) {
            tTSettingConfigCallback.configLoad();
            return;
        }
        synchronized (this.f369t) {
            if (!this.f369t.contains(tTSettingConfigCallback)) {
                this.f369t.add(tTSettingConfigCallback);
            }
        }
        SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59781c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.ISettings
    /* renamed from: a */
    public void mo59760a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
        this.f351b = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f351b;
        this.f352c = currentTimeMillis + j;
        m59131a.m59124b("max_age", j);
        m59131a.m59124b("max_expire_time", this.f352c);
    }

    /* renamed from: a */
    public boolean m59762a(String str, int i) {
        AdsenseRitConfig adsenseRitConfig;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, AdsenseRitConfig> map = this.f368s;
        return map == null || map.size() == 0 || (adsenseRitConfig = this.f368s.get(str)) == null || adsenseRitConfig.m59539l() == i;
    }

    /* renamed from: b */
    public AdsenseRitConfig m59754b(String str) {
        Map<String, AdsenseRitConfig> map = this.f368s;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: b */
    public void m59758b() {
        SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d()).m59136a();
        this.f350a = null;
    }

    /* renamed from: b */
    public void m59755b(TTSettingConfigCallback tTSettingConfigCallback) {
        if (tTSettingConfigCallback == null) {
            return;
        }
        synchronized (this.f369t) {
            if (this.f369t.contains(tTSettingConfigCallback)) {
                this.f369t.remove(tTSettingConfigCallback);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.ISettings
    /* renamed from: b */
    public void mo59752b(JSONObject jSONObject) {
        String m59264b;
        String m59264b2;
        String m59264b3;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f350a = jSONObject.optString(DownloadModel.ETAG);
            this.f351b = jSONObject.optLong("max_age");
            this.f352c = System.currentTimeMillis() + this.f351b;
            this.f353d = jSONObject.optString("ab_version");
            this.f354e = jSONObject.optString("ab_params");
            this.f355f = jSONObject.optString("country");
            this.f356g = jSONObject.optString("transparent_params");
            this.f357h = jSONObject.optInt("if_test");
            this.f358i = jSONObject.optInt("if_get_detail_return");
            String optString = jSONObject.optString("url");
            this.f360k = jSONObject.optString("app_abtest");
            this.f361l = jSONObject.optInt("innerLog", 0);
            this.f362m = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.f365p = jSONObject.optLong("break_request_times", 0L);
            this.f366q = jSONObject.optLong("break_request_hold_time", 10000L);
            CircuitBreakerController.m37366c().m37368a(this.f365p, this.f366q);
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject != null) {
                this.f363n = optJSONObject.optInt("event_batch_size", 100);
                this.f364o = optJSONObject.optInt("event_send_type", 0);
            }
            Logger.m37557e("TTSETTING", "save--mEventBatchSize=" + this.f363n + ",mEventSendType=" + this.f364o);
            String m59749c = m59749c(jSONObject.optJSONObject("adn_init_conf"));
            String m59761a = m59761a(jSONObject.optJSONArray("adn_control_conf"));
            String m59743e = m59743e(jSONObject.optJSONObject("poor_network_config"));
            String m59753b = m59753b(jSONObject.optJSONArray("rit_conf"));
            String m59746d = m59746d(jSONObject.optJSONObject("module_disable_control"));
            SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
            m59131a.m59123b(DownloadModel.ETAG, this.f350a);
            m59131a.m59124b("max_age", this.f351b);
            m59131a.m59124b("max_expire_time", this.f352c);
            m59131a.m59123b("ab_version", this.f353d);
            m59131a.m59123b("ab_params", this.f354e);
            m59131a.m59123b("country", this.f355f);
            m59131a.m59123b("transparent_params", this.f356g);
            m59131a.m59125b("if_test", this.f357h);
            m59131a.m59125b("network_permission", this.f358i);
            m59131a.m59123b("app_abtest", this.f360k);
            m59131a.m59123b("module_control", m59746d);
            m59131a.m59123b("tt_app_log_url", this.f362m);
            m59131a.m59124b("break_request_times", this.f365p);
            m59131a.m59124b("break_request_hold_time", this.f366q);
            if (optJSONObject != null) {
                m59131a.m59123b("tt_app_common_config", optJSONObject.toString());
            }
            if (optString == null || TextUtils.isEmpty(optString)) {
                m59131a.m59118f("server_dist_host");
            } else {
                String m59264b4 = AES.m59264b(optString, AESKey.m59260a());
                if (m59264b4 != null) {
                    m59131a.m59123b("server_dist_host", m59264b4);
                }
            }
            if (m59749c != null && (m59264b3 = AES.m59264b(m59749c, AESKey.m59260a())) != null) {
                m59131a.m59123b("adn_init_conf", m59264b3);
            }
            if (m59761a != null && (m59264b2 = AES.m59264b(m59761a, AESKey.m59260a())) != null) {
                m59131a.m59123b("adn_control_conf", m59264b2);
            }
            if (m59753b != null && (m59264b = AES.m59264b(m59753b, AESKey.m59260a())) != null) {
                m59131a.m59123b("rit_conf", m59264b);
            }
            if (m59743e != null) {
                m59131a.m59123b("network_conf", m59743e);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: c */
    public long m59750c(String str) {
        AdsenseRitConfig m59754b = m59754b(str);
        if (m59754b != null) {
            return m59754b.m59560c();
        }
        return 3000L;
    }

    /* renamed from: c */
    public Map<String, AdNetworkConfValue> m59751c() {
        return this.f367r;
    }

    /* renamed from: d */
    public Map<String, AdsenseRitConfig> m59748d() {
        return this.f368s;
    }

    /* renamed from: d */
    public boolean m59747d(String str) {
        AdsenseRitConfig adsenseRitConfig;
        Map<Integer, List<WaterFallConfig>> m59533r;
        Map<String, AdsenseRitConfig> map = this.f368s;
        if (map == null || map.size() == 0) {
            return true;
        }
        return (TextUtils.isEmpty(str) || (adsenseRitConfig = this.f368s.get(str)) == null || (m59533r = adsenseRitConfig.m59533r()) == null || m59533r.size() == 0) ? false : true;
    }

    /* renamed from: e */
    public String m59745e() {
        return this.f360k;
    }

    /* renamed from: e */
    public boolean m59744e(String str) {
        Map<String, AdsenseRitConfig> map;
        Map<String, AdNetworkConfValue> map2 = this.f367r;
        return (map2 == null || map2.isEmpty() || (map = this.f368s) == null || map.isEmpty() || this.f368s.get(str) == null) ? false : true;
    }

    /* renamed from: f */
    public String m59742f() {
        return this.f362m;
    }

    /* renamed from: f */
    public void m59741f(String str) {
        try {
            SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
            if ("2".equals(str)) {
                this.f370u.put("active_control", Boolean.TRUE);
                m59131a.m59122b("all_active_control", true);
            } else {
                this.f370u.put("active_control", Boolean.FALSE);
                m59131a.m59122b("all_active_control", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public String m59740g() {
        return this.f355f;
    }

    /* renamed from: h */
    public String m59739h() {
        if (this.f350a == null) {
            this.f350a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d()).m59120d(DownloadModel.ETAG);
        }
        return this.f350a;
    }

    /* renamed from: i */
    public int m59738i() {
        return this.f363n;
    }

    /* renamed from: j */
    public int m59737j() {
        return this.f364o;
    }

    /* renamed from: k */
    public int m59736k() {
        return this.f357h;
    }

    /* renamed from: l */
    public String m59735l() {
        return this.f356g;
    }

    /* renamed from: m */
    public boolean m59734m() {
        return this.f358i == 1;
    }

    /* renamed from: n */
    public boolean m59733n() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("ad_event_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: o */
    public boolean m59732o() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_banner_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: p */
    public boolean m59731p() {
        Map<String, AdsenseRitConfig> map = this.f368s;
        return map != null && map.size() > 0;
    }

    /* renamed from: q */
    public boolean m59730q() {
        Map<String, AdsenseRitConfig> map = this.f368s;
        return map != null && map.size() > 0 && this.f371v.get();
    }

    /* renamed from: r */
    public boolean m59729r() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_feed_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: s */
    public boolean m59728s() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_full_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: t */
    public boolean m59727t() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_interaction_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: u */
    public boolean m59726u() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_native_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: v */
    public boolean m59725v() {
        return this.f361l == 1;
    }

    /* renamed from: w */
    public boolean m59724w() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_reward_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: x */
    public boolean m59723x() {
        if (m59769B()) {
            Boolean bool = this.f370u.get("type_splash_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    /* renamed from: y */
    public boolean m59722y() {
        return this.f357h == 1;
    }

    /* renamed from: z */
    public boolean m59721z() {
        return this.f357h == 2;
    }
}
