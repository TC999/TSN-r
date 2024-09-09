package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.TTSettingConfigCallback;
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

/* compiled from: TTSdkSettings.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c implements bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a {

    /* renamed from: a  reason: collision with root package name */
    private String f347a;

    /* renamed from: b  reason: collision with root package name */
    private long f348b;

    /* renamed from: c  reason: collision with root package name */
    private long f349c;

    /* renamed from: d  reason: collision with root package name */
    private String f350d;

    /* renamed from: e  reason: collision with root package name */
    private String f351e;

    /* renamed from: f  reason: collision with root package name */
    private String f352f;

    /* renamed from: g  reason: collision with root package name */
    private String f353g;

    /* renamed from: h  reason: collision with root package name */
    private int f354h;

    /* renamed from: i  reason: collision with root package name */
    private int f355i;

    /* renamed from: j  reason: collision with root package name */
    private int f356j;

    /* renamed from: p  reason: collision with root package name */
    private long f362p;

    /* renamed from: q  reason: collision with root package name */
    private long f363q;

    /* renamed from: t  reason: collision with root package name */
    private List<TTSettingConfigCallback> f366t;

    /* renamed from: u  reason: collision with root package name */
    private Map<String, Boolean> f367u;

    /* renamed from: v  reason: collision with root package name */
    private final AtomicBoolean f368v;

    /* renamed from: k  reason: collision with root package name */
    private String f357k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f358l = 0;

    /* renamed from: m  reason: collision with root package name */
    private String f359m = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";

    /* renamed from: n  reason: collision with root package name */
    private int f360n = 100;

    /* renamed from: o  reason: collision with root package name */
    private int f361o = 0;

    /* renamed from: r  reason: collision with root package name */
    private Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a> f364r = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> f365s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTSdkSettings.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f369a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f370b;

        a(boolean z3, boolean z4) {
            this.f369a = z3;
            this.f370b = z4;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.c
        public void a() {
            Logger.e("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + this.f369a);
            if (this.f369a) {
                if (!c.this.f368v.get()) {
                    int size = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().h().size();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.d();
                    g.a(elapsedRealtime, size, this.f370b ? 1 : 0);
                    Logger.d("TTMediationSDK", "sdk init end, duration: " + elapsedRealtime + ", initAdnCount: " + size + ", isFromLocalConfig: " + this.f370b);
                }
                c.this.f368v.set(true);
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a.c();
                c.this.C();
            }
        }
    }

    public c() {
        new HashMap();
        this.f366t = new CopyOnWriteArrayList();
        this.f367u = new HashMap();
        this.f368v = new AtomicBoolean(false);
    }

    private boolean B() {
        Boolean bool = this.f367u.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (q()) {
            synchronized (this.f366t) {
                for (TTSettingConfigCallback tTSettingConfigCallback : this.f366t) {
                    tTSettingConfigCallback.configLoad();
                }
                this.f366t.clear();
            }
        }
    }

    private Long a(int i4) {
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                if (i4 != 5) {
                    if (i4 != 7 && i4 != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private String a(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray == null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a().a(null);
            return null;
        }
        ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    arrayList.add(optJSONArray.optString(i5));
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b bVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b();
                bVar.a(optJSONObject.optLong("break_request_duration"));
                bVar.a(arrayList);
                concurrentHashMap.put(optJSONObject.optString("adn_name"), bVar);
            }
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a().a(concurrentHashMap);
        return jSONArray.toString();
    }

    private void a(boolean z3) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), new a(p(), z3));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002f A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0020 -> B:19:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0024 -> B:31:0x003d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x002f -> B:31:0x003d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Long b(int r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c.b(int):java.lang.Long");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0333 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONArray r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c.b(org.json.JSONArray):java.lang.String");
    }

    private String c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f364r.clear();
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        this.f364r.put(next, new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a(optJSONObject.optString("app_id"), optJSONObject.optString("app_key")));
                    }
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    private String d(JSONObject jSONObject) {
        this.f367u.clear();
        if (jSONObject != null) {
            try {
                if (jSONObject.optBoolean("ad_event_control")) {
                    this.f367u.put("ad_event_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_banner_control")) {
                    this.f367u.put("type_banner_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_interaction_control")) {
                    this.f367u.put("type_interaction_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_splash_control")) {
                    this.f367u.put("type_splash_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_feed_control")) {
                    this.f367u.put("type_feed_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_reward_control")) {
                    this.f367u.put("type_reward_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_full_control")) {
                    this.f367u.put("type_full_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_native_control")) {
                    this.f367u.put("type_native_control", Boolean.TRUE);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private String e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f356j = jSONObject.optInt("fetch_ad_type", 0);
            return jSONObject.toString();
        }
        return null;
    }

    public boolean A() {
        return this.f356j == 1;
    }

    public bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a(String str) {
        return this.f364r.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a
    public void a() {
        try {
            r a4 = r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
            this.f347a = a4.d(DownloadModel.ETAG);
            this.f348b = a4.c("max_age");
            this.f349c = a4.c("max_expire_time");
            this.f350d = a4.d("ab_version");
            this.f351e = a4.d("ab_params");
            this.f352f = a4.d("country");
            this.f353g = a4.d("transparent_params");
            this.f354h = a4.b("if_test");
            this.f355i = a4.b("network_permission");
            this.f359m = a4.a("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.f362p = a4.a("break_request_times", 0L);
            this.f363q = a4.a("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            com.bytedance.msdk.core.corelogic.a.c().a(this.f362p, this.f363q);
            String d4 = a4.d("tt_app_common_config");
            if (!TextUtils.isEmpty(d4)) {
                JSONObject jSONObject = new JSONObject(d4);
                this.f360n = jSONObject.optInt("event_batch_size", 100);
                this.f361o = jSONObject.optInt("event_send_type", 0);
            }
            Logger.e("TTSETTING", "load--mAppLogUrl=" + this.f359m);
            Logger.e("TTSETTING", "load--mEventBatchSize=" + this.f360n + ",mEventSendType=" + this.f361o);
            if (!TextUtils.isEmpty(a4.d("app_abtest"))) {
                this.f357k = a4.d("app_abtest");
            }
            String d5 = a4.d("network_conf");
            if (d5 != null) {
                e(new JSONObject(d5));
            }
            String d6 = a4.d("adn_init_conf");
            if (!TextUtils.isEmpty(d6)) {
                if (!d6.startsWith("[") && !d6.startsWith("{")) {
                    d6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(d6, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
                }
                c(new JSONObject(d6));
            }
            String d7 = a4.d("adn_control_conf");
            if (!TextUtils.isEmpty(d7)) {
                if (!d7.startsWith("[") && !d7.startsWith("{")) {
                    d7 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(d7, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
                }
                a(new JSONArray(d7));
            }
            String d8 = a4.d("rit_conf");
            if (!TextUtils.isEmpty(d8)) {
                if (!d8.startsWith("[") && !d8.startsWith("{")) {
                    d8 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(d8, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
                }
                b(new JSONArray(d8));
            }
            String d9 = a4.d("module_control");
            if (!TextUtils.isEmpty(d9)) {
                d(new JSONObject(d9));
            }
            boolean a5 = a4.a("all_active_control");
            if (a5) {
                this.f367u.put("active_control", Boolean.valueOf(a5));
            }
        } catch (Throwable unused) {
        }
        a(true);
    }

    public void a(TTSettingConfigCallback tTSettingConfigCallback) {
        if (tTSettingConfigCallback == null) {
            return;
        }
        if (q()) {
            tTSettingConfigCallback.configLoad();
            return;
        }
        synchronized (this.f366t) {
            if (!this.f366t.contains(tTSettingConfigCallback)) {
                this.f366t.add(tTSettingConfigCallback);
            }
        }
        b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).d().c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        r a4 = r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
        this.f348b = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = this.f348b;
        this.f349c = currentTimeMillis + j4;
        a4.b("max_age", j4);
        a4.b("max_expire_time", this.f349c);
    }

    public boolean a(String str, int i4) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map = this.f365s;
        return map == null || map.size() == 0 || (cVar = this.f365s.get(str)) == null || cVar.l() == i4;
    }

    public bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c b(String str) {
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map = this.f365s;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void b() {
        r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a();
        this.f347a = null;
    }

    public void b(TTSettingConfigCallback tTSettingConfigCallback) {
        if (tTSettingConfigCallback == null) {
            return;
        }
        synchronized (this.f366t) {
            if (this.f366t.contains(tTSettingConfigCallback)) {
                this.f366t.remove(tTSettingConfigCallback);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.a
    public void b(JSONObject jSONObject) {
        String b4;
        String b5;
        String b6;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f347a = jSONObject.optString(DownloadModel.ETAG);
            this.f348b = jSONObject.optLong("max_age");
            this.f349c = System.currentTimeMillis() + this.f348b;
            this.f350d = jSONObject.optString("ab_version");
            this.f351e = jSONObject.optString("ab_params");
            this.f352f = jSONObject.optString("country");
            this.f353g = jSONObject.optString("transparent_params");
            this.f354h = jSONObject.optInt("if_test");
            this.f355i = jSONObject.optInt("if_get_detail_return");
            String optString = jSONObject.optString("url");
            this.f357k = jSONObject.optString("app_abtest");
            this.f358l = jSONObject.optInt("innerLog", 0);
            this.f359m = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.f362p = jSONObject.optLong("break_request_times", 0L);
            this.f363q = jSONObject.optLong("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            com.bytedance.msdk.core.corelogic.a.c().a(this.f362p, this.f363q);
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject != null) {
                this.f360n = optJSONObject.optInt("event_batch_size", 100);
                this.f361o = optJSONObject.optInt("event_send_type", 0);
            }
            Logger.e("TTSETTING", "save--mEventBatchSize=" + this.f360n + ",mEventSendType=" + this.f361o);
            String c4 = c(jSONObject.optJSONObject("adn_init_conf"));
            String a4 = a(jSONObject.optJSONArray("adn_control_conf"));
            String e4 = e(jSONObject.optJSONObject("poor_network_config"));
            String b7 = b(jSONObject.optJSONArray("rit_conf"));
            String d4 = d(jSONObject.optJSONObject("module_disable_control"));
            r a5 = r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
            a5.b(DownloadModel.ETAG, this.f347a);
            a5.b("max_age", this.f348b);
            a5.b("max_expire_time", this.f349c);
            a5.b("ab_version", this.f350d);
            a5.b("ab_params", this.f351e);
            a5.b("country", this.f352f);
            a5.b("transparent_params", this.f353g);
            a5.b("if_test", this.f354h);
            a5.b("network_permission", this.f355i);
            a5.b("app_abtest", this.f357k);
            a5.b("module_control", d4);
            a5.b("tt_app_log_url", this.f359m);
            a5.b("break_request_times", this.f362p);
            a5.b("break_request_hold_time", this.f363q);
            if (optJSONObject != null) {
                a5.b("tt_app_common_config", optJSONObject.toString());
            }
            if (optString == null || TextUtils.isEmpty(optString)) {
                a5.f("server_dist_host");
            } else {
                String b8 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.b(optString, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
                if (b8 != null) {
                    a5.b("server_dist_host", b8);
                }
            }
            if (c4 != null && (b6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.b(c4, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a())) != null) {
                a5.b("adn_init_conf", b6);
            }
            if (a4 != null && (b5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.b(a4, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a())) != null) {
                a5.b("adn_control_conf", b5);
            }
            if (b7 != null && (b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.b(b7, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a())) != null) {
                a5.b("rit_conf", b4);
            }
            if (e4 != null) {
                a5.b("network_conf", e4);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public long c(String str) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c b4 = b(str);
        if (b4 != null) {
            return b4.c();
        }
        return 3000L;
    }

    public Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a> c() {
        return this.f364r;
    }

    public Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> d() {
        return this.f365s;
    }

    public boolean d(String str) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar;
        Map<Integer, List<h>> r3;
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map = this.f365s;
        if (map == null || map.size() == 0) {
            return true;
        }
        return (TextUtils.isEmpty(str) || (cVar = this.f365s.get(str)) == null || (r3 = cVar.r()) == null || r3.size() == 0) ? false : true;
    }

    public String e() {
        return this.f357k;
    }

    public boolean e(String str) {
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map;
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a> map2 = this.f364r;
        return (map2 == null || map2.isEmpty() || (map = this.f365s) == null || map.isEmpty() || this.f365s.get(str) == null) ? false : true;
    }

    public String f() {
        return this.f359m;
    }

    public void f(String str) {
        try {
            r a4 = r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
            if ("2".equals(str)) {
                this.f367u.put("active_control", Boolean.TRUE);
                a4.b("all_active_control", true);
            } else {
                this.f367u.put("active_control", Boolean.FALSE);
                a4.b("all_active_control", false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public String g() {
        return this.f352f;
    }

    public String h() {
        if (this.f347a == null) {
            this.f347a = r.a("tt_sdk_settings", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).d(DownloadModel.ETAG);
        }
        return this.f347a;
    }

    public int i() {
        return this.f360n;
    }

    public int j() {
        return this.f361o;
    }

    public int k() {
        return this.f354h;
    }

    public String l() {
        return this.f353g;
    }

    public boolean m() {
        return this.f355i == 1;
    }

    public boolean n() {
        if (B()) {
            Boolean bool = this.f367u.get("ad_event_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean o() {
        if (B()) {
            Boolean bool = this.f367u.get("type_banner_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean p() {
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map = this.f365s;
        return map != null && map.size() > 0;
    }

    public boolean q() {
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c> map = this.f365s;
        return map != null && map.size() > 0 && this.f368v.get();
    }

    public boolean r() {
        if (B()) {
            Boolean bool = this.f367u.get("type_feed_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean s() {
        if (B()) {
            Boolean bool = this.f367u.get("type_full_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean t() {
        if (B()) {
            Boolean bool = this.f367u.get("type_interaction_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean u() {
        if (B()) {
            Boolean bool = this.f367u.get("type_native_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean v() {
        return this.f358l == 1;
    }

    public boolean w() {
        if (B()) {
            Boolean bool = this.f367u.get("type_reward_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean x() {
        if (B()) {
            Boolean bool = this.f367u.get("type_splash_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean y() {
        return this.f354h == 1;
    }

    public boolean z() {
        return this.f354h == 2;
    }
}
