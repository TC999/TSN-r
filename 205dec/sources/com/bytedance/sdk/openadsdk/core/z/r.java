package com.bytedance.sdk.openadsdk.core.z;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.c.c.c.c.b;
import com.bytedance.msdk.api.AdError;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.gb;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.eq;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.n;
import com.bytedance.sdk.openadsdk.core.yu;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements sr {
    private static final String db = null;
    private String ba;
    private int ds;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35753e;
    private eq eu;

    /* renamed from: i  reason: collision with root package name */
    private int f35757i;
    private JSONObject ju;
    private boolean kk;
    private String ky;
    private JSONObject me;

    /* renamed from: o  reason: collision with root package name */
    private volatile com.bytedance.sdk.component.f.c f35763o;

    /* renamed from: pl  reason: collision with root package name */
    private String f35765pl;
    private String pr;
    private SharedPreferences rd;
    private String tl;
    private JSONObject tx;
    public volatile com.bytedance.sdk.component.f.c ux;
    private long wv;
    private String xk;
    private w xq;

    /* renamed from: z  reason: collision with root package name */
    private String f35775z;

    /* renamed from: r  reason: collision with root package name */
    private int f35767r = Integer.MAX_VALUE;
    private Set<String> ev = Collections.synchronizedSet(new HashSet());
    private int gd = Integer.MAX_VALUE;

    /* renamed from: p  reason: collision with root package name */
    private int f35764p = Integer.MAX_VALUE;

    /* renamed from: k  reason: collision with root package name */
    private int f35759k = Integer.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private int f35749a = Integer.MAX_VALUE;
    private String bk = null;

    /* renamed from: t  reason: collision with root package name */
    private int f35769t = Integer.MAX_VALUE;
    private int ys = Integer.MAX_VALUE;
    private int fp = -1;
    private int ia = Integer.MAX_VALUE;

    /* renamed from: s  reason: collision with root package name */
    private int f35768s = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f35751c = 0;
    private int fz = Integer.MAX_VALUE;

    /* renamed from: w  reason: collision with root package name */
    public int f35772w = 10;
    public int xv = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f35770u = 3600;

    /* renamed from: q  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ux.w f35766q = null;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.w f35758j = null;
    private boolean ls = false;
    private int gb = Integer.MAX_VALUE;

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, c> f35762n = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.adexpress.c.xv.sr> ck = new HashMap();

    /* renamed from: y  reason: collision with root package name */
    private Set<String> f35774y = Collections.synchronizedSet(new HashSet());
    private final List<Object> eq = new CopyOnWriteArrayList();
    private JSONObject yu = null;
    private String wx = "";
    private int bw = Integer.MAX_VALUE;

    /* renamed from: x  reason: collision with root package name */
    private int f35773x = Integer.MAX_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private long f35761m = 0;
    private Set<String> gw = new ConcurrentSkipListSet();
    private Set<String> vc = new ConcurrentSkipListSet();
    private Set<String> up = new ConcurrentSkipListSet();
    private int mt = Integer.MAX_VALUE;
    private int oo = Integer.MAX_VALUE;
    private long au = 2147483647L;
    private int bj = Integer.MAX_VALUE;
    private int bm = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private int f35750b = Integer.MAX_VALUE;
    private int wo = 0;
    private long ox = 0;
    private int xu = 0;
    private long ng = 0;
    private int ok = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f35756h = null;
    private JSONObject oh = null;
    private int fm = 3;
    private final int te = 0;
    private int ge = 0;
    private final String ta = "live_sdk_conf";
    private int be = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    private int f35755g = Integer.MAX_VALUE;
    private String bs = null;
    private String lf = null;
    private int xg = Integer.MAX_VALUE;
    private int mu = Integer.MAX_VALUE;
    private Set<String> zr = Collections.synchronizedSet(new HashSet());
    private String zt = null;
    private String eb = null;
    private String rh = "apps.bytesfield.com";
    private int lw = Integer.MAX_VALUE;
    private int kn = Integer.MAX_VALUE;
    private int qy = 20;
    private int iw = 3;
    private volatile boolean gp = false;
    private float zg = -1.0f;
    private float jv = 2.1474836E9f;
    private JSONObject mk = null;
    private int yn = Integer.MAX_VALUE;
    private int yh = 2;

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f35771v = null;
    private JSONObject kr = null;
    private boolean pu = false;
    private int pb = 0;
    private int jd = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f35760l = 3;
    private boolean nc = true;
    private int nd = 0;
    private int ny = 1;
    private int dk = 0;
    private String jr = null;
    private int ix = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f35752d = 0;
    private String qu = null;
    private int cf = 1;
    private boolean ab = true;
    private JSONObject zb = null;
    private int wt = 1;
    private String uj = "\u8df3\u8fc7";
    private String tz = "";
    private int lp = 0;
    private int al = 0;
    private int vj = 0;
    private String fn = "";
    private int xt = -1;
    private long qf = -1;
    private int tc = 0;
    private long ya = 2147483647L;
    private int ib = Integer.MAX_VALUE;
    private int jw = Integer.MAX_VALUE;
    private volatile int em = Integer.MAX_VALUE;
    private volatile SharedPreferences ax = null;
    private JSONObject vt = null;
    private volatile SharedPreferences xw = null;
    private Object ld = new Object();
    public volatile com.bytedance.sdk.component.f.c sr = null;
    private JSONObject dd = null;
    private boolean rg = false;
    private boolean nb = false;

    /* renamed from: f  reason: collision with root package name */
    public int f35754f = 0;
    private boolean vb = true;
    private boolean st = false;
    private int ve = 0;
    private int bn = 0;

    private static boolean a(int i4) {
        return i4 == 0 || i4 == 1 || i4 == 2;
    }

    private void al() {
        w();
        com.bytedance.sdk.openadsdk.core.xv.sr.c().c(this.bs);
        this.sr.c("url_stats", this.tl);
        SharedPreferences.Editor edit = vj().edit();
        edit.putString("url_stats", this.tl);
        this.sr.c("url_alog", this.lf);
        edit.putString("url_alog", this.lf);
        this.sr.c("xpath", this.xk);
        if (this.me != null) {
            this.sr.c("digest", this.me.toString());
        }
        this.sr.c("data_time", this.wv);
        this.sr.c("fetch_template", this.f35755g);
        this.sr.c("pyload_h5", this.pr);
        this.sr.c("splash_check_type", this.bw);
        this.sr.c("if_both_open", this.mt);
        this.sr.c("adlog_exception_batch", this.bm);
        this.sr.c("adlog_interval", this.au);
        this.sr.c("adlog_batch", this.bj);
        this.sr.c("adlog_debug", this.f35750b);
        this.sr.c("enable_ttvideo", this.fp);
        this.sr.c("ext_use_type", this.ng);
        this.sr.c("enable_dl_ext", this.xu);
        this.sr.c("launch_strategy", this.f35751c);
        this.sr.c("switch_audio_focus", this.ok);
        this.sr.c("opt_show_check", this.fz);
        if (this.f35756h != null) {
            this.sr.c("pitaya_general_settings", this.f35756h.toString());
        }
        if (this.tx != null) {
            this.sr.c("live_stream_cof", this.tx.toString());
        }
        if (this.ju != null) {
            this.sr.c("pitaya_business_conf", this.ju.toString());
        }
        com.bytedance.sdk.component.f.c cVar = this.sr;
        JSONObject jSONObject = this.oh;
        cVar.c("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.sr.c("stats_batch", this.fm);
        this.sr.c("event_switch", this.ge);
        this.sr.c("use_texture", this.xv);
        this.sr.c("pre_fetch_cnt", this.f35772w);
        this.sr.c("web_upload_enable", this.f35767r);
        this.sr.c("web_upload_content_type", this.ev);
        this.sr.c("web_upload_send_restowv", this.gd);
        this.sr.c("web_upload_max_retry", this.ys);
        this.sr.c("web_upload_max_single_file", this.f35764p);
        this.sr.c("web_upload_max_zip_file", this.f35759k);
        this.sr.c("web_upload_report_url", this.bk);
        this.sr.c("web_upload_storage_type", this.f35769t);
        this.sr.c("web_upload_report_only_wifi", this.f35749a);
        this.sr.c("app_list_control", this.f35773x);
        this.sr.c("max_tpl_cnts", this.xg);
        this.sr.c("fetch_tpl_timeout_ctrl", this.mu);
        this.sr.c("open_single_abi", this.f35753e);
        this.sr.c("webview_cache_count", this.kn);
        this.sr.c("webview_cache_count_v3", this.qy);
        this.sr.c("webview_render_concurrent_count", this.iw);
        this.sr.c("gecko_hosts", this.zr);
        this.sr.c("enable_apm_pv", this.kk);
        this.sr.c("gecko_ids", this.tz);
        this.sr.c("hit_app_list_time", this.f35761m);
        this.sr.c("hit_app_list_data", this.gw);
        this.sr.c("scheme_list_data", this.vc);
        this.sr.c("top_scheme_list_data", this.up);
        this.sr.c("policy_url", this.ky);
        this.sr.c("circle_splash_switch", this.ia);
        this.sr.c("circle_load_splash_time", this.f35768s);
        this.sr.c("dyn_draw_engine_url", this.zt);
        this.sr.c("play_component_ugen_engine_url", this.eb);
        this.sr.c("ad_pkg_info_url", this.rh);
        this.sr.c("disable_dynamic_code_group", this.f35757i);
        this.sr.c("dynamic_code_group_cache_time", this.f35770u);
        this.sr.c("sp_key_if_sp_cache", this.lw);
        this.sr.c("download_sdk_config", this.wx);
        com.bytedance.sdk.component.f.c cVar2 = this.sr;
        JSONObject jSONObject2 = this.kr;
        cVar2.c("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.sr.c("npth_enable_type", this.f35754f);
        this.sr.c("is_sp_send_meta", this.vb);
        this.sr.c("is_first_plugin_resources", this.st);
        this.sr.c("vbtt", this.be);
        if (!TextUtils.isEmpty(this.ba)) {
            this.sr.c("template_ids", this.ba);
        }
        if (!TextUtils.isEmpty(this.f35775z)) {
            this.sr.c("tpl_infos", this.f35775z);
        }
        this.sr.c("call_stack_rate", this.zg);
        this.sr.c("gnd_prefetch_cache_ttl", this.qf);
        this.sr.c("gnd_prefetch_cache_size", this.xt);
        this.sr.c("global_rate", this.jv);
        this.sr.c("read_video_from_cache", this.yn);
        this.sr.c("brand_video_cache_count", this.yh);
        this.sr.c("enable_bw_screen_detection", this.pu);
        this.sr.c("playable_preload_count", this.pb);
        this.sr.c("splash_card_show_max_count", this.f35760l);
        com.bytedance.sdk.component.f.c cVar3 = this.sr;
        com.bytedance.sdk.openadsdk.core.ux.w wVar = this.f35766q;
        cVar3.c("clog_config", wVar != null ? wVar.toString() : "");
        com.bytedance.sdk.component.f.c cVar4 = this.sr;
        com.bytedance.sdk.openadsdk.core.dislike.w wVar2 = this.f35758j;
        cVar4.c("clog_config", wVar2 != null ? wVar2.toString() : "");
        this.sr.c("check_live_room", this.ls);
        this.sr.c("can_init_live", this.ab);
        com.bytedance.sdk.component.f.c cVar5 = this.sr;
        w wVar3 = this.xq;
        cVar5.c("app_live_config", wVar3 != null ? wVar3.toString() : "");
        com.bytedance.sdk.component.f.c cVar6 = this.sr;
        JSONObject jSONObject3 = this.zb;
        cVar6.c("plugin_update_state", jSONObject3 != null ? jSONObject3.toString() : "");
        com.bytedance.sdk.component.f.c cVar7 = this.sr;
        JSONObject jSONObject4 = this.vt;
        cVar7.c("antispam_autoclick_detect", jSONObject4 != null ? jSONObject4.toString() : "");
        this.sr.c("pglam_main_enable", this.ix);
        this.sr.c("pglam_dns_check_enable", this.f35752d);
        this.sr.c("pglam_clazz_check", this.qu);
        this.sr.c("ud_enable", this.cf);
        this.sr.c("is_open_isw", this.wt);
        edit.putInt("is_kv_cache_type", this.lp);
        edit.putInt("kv_init_type", this.al);
        edit.apply();
        this.sr.c("lp_url_sw", this.vj);
        if (this.vj == 1) {
            tz().c("lp_list", this.fn);
        }
        if (this.eu != null) {
            this.sr.c("live_sdk_conf", this.eu.toString());
        }
        this.sr.c("open_dl_type", this.bn);
        this.sr.c("app_dl_scheme_list", this.f35765pl);
        this.sr.c("scheme_get_type", this.nd);
        this.sr.c("scheme_get_num", this.ny);
        this.sr.c("if_query_all_package", this.dk);
        if (this.f35771v != null) {
            this.sr.c("video_cache_config", this.f35771v.toString());
        }
        if (this.mk != null) {
            this.sr.c("log_rate_conf", this.mk.toString());
        }
        this.sr.c("splash_close_text", this.uj);
        this.sr.c("network_module", this.gb);
        this.sr.c("force_zero_skip", this.nc);
        this.sr.c("mini_event_upload_version", this.tc);
        this.sr.c("bg_web_readd_t", this.ya);
        this.sr.c("refresh_req_num", this.ib);
        this.sr.c("refresh_max_times", this.jw);
        this.sr.c("shake_trigger_control", this.ds);
        this.sr.c("net_rating", this.rg);
        this.sr.c("device_rating", this.nb);
        com.bytedance.sdk.component.f.c cVar8 = this.sr;
        JSONObject jSONObject5 = this.dd;
        cVar8.c("net_rating_config", jSONObject5 != null ? jSONObject5.toString() : "");
        n.c(this.sr);
        m.c(this.sr);
    }

    private int f(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.bw = optInt;
        if (optInt == 0 || optInt == 1) {
            return optInt;
        }
        return 1;
    }

    private String i(String str) {
        return "ad_slot_conf_" + str;
    }

    private void lp() {
        ev.w(new p("") { // from class: com.bytedance.sdk.openadsdk.core.z.r.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ls.w.c.c();
            }
        });
    }

    public static void sr() {
        r w3 = ls.w();
        if (w3 != null) {
            boolean au = w3.au();
            if (k.sr().u().values().booleanValue(1) != au) {
                k.sr().u().call(10, b.a().h(0, new y().c("downloadPath", com.bytedance.sdk.openadsdk.core.p.ev.c(au))).l(), Void.class);
            }
            if (w3.ng() != null) {
                TTLiveCommerceHelper.getInstance().initTobLiveSDK();
            }
            yu.xv();
        }
    }

    private com.bytedance.sdk.component.f.c tz() {
        if (this.ux == null) {
            this.ux = ba.c("tt_sdk_lp_w_list");
        }
        return this.ux;
    }

    private void ux(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f35767r = jSONObject.optInt("enable", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("content_type");
            this.ev.clear();
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (!TextUtils.isEmpty(optString)) {
                        this.ev.add(optString);
                    }
                }
            }
            this.gd = jSONObject.optInt("send_response_to_webview", 0);
            this.f35764p = jSONObject.optInt("max_report_size_single", 2);
            this.f35759k = jSONObject.optInt("max_report_size_total", 5);
            this.ys = jSONObject.optInt("max_report_times", 0);
            this.bk = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.f35769t = jSONObject.optInt("storage_type", 0);
            this.f35749a = jSONObject.optInt("report_only_wifi_enable", 0);
            return;
        }
        this.f35767r = 0;
        this.ev.clear();
        this.gd = 0;
        this.f35764p = 2;
        this.f35759k = 5;
        this.ys = 0;
        this.bk = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
        this.f35769t = 0;
        this.f35749a = 0;
    }

    private SharedPreferences vj() {
        if (this.rd == null) {
            this.rd = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "tt_sdk_settings_other", 0);
        }
        return this.rd;
    }

    public String a() {
        if (TextUtils.isEmpty(this.lf)) {
            String w3 = w().w("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.lf = w3;
            if (TextUtils.isEmpty(w3)) {
                this.lf = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.lf;
    }

    public String ab() {
        if (this.vj != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.fn)) {
            return this.fn;
        }
        String w3 = tz().w("lp_list", this.fn);
        this.fn = w3;
        return w3;
    }

    public boolean au() {
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().a();
    }

    public JSONObject b() {
        return this.f35756h;
    }

    public long ba() {
        if (this.wv == 0) {
            this.wv = w().w("data_time", 0L);
        }
        return this.wv;
    }

    public boolean be() {
        if (this.em == Integer.MAX_VALUE) {
            this.em = w().w("settings_open", 0);
        }
        return this.em == 1;
    }

    public int bj() {
        if (this.ia == Integer.MAX_VALUE) {
            this.ia = w().w("circle_splash_switch", 0);
        }
        return this.ia;
    }

    public boolean bk() {
        if (this.f35750b == Integer.MAX_VALUE) {
            this.f35750b = w().w("adlog_debug", 0);
        }
        return this.f35750b == 1;
    }

    public int bm() {
        if (this.f35768s == Integer.MAX_VALUE) {
            this.f35768s = w().w("circle_load_splash_time", -1);
        }
        return this.f35768s;
    }

    public int bs() {
        int i4 = this.ny;
        if (i4 < 1) {
            return 1;
        }
        return i4;
    }

    public String bw() {
        if (TextUtils.equals(this.bk, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.bk = w().w("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.bk;
    }

    public int cf() {
        if (this.al == 0) {
            this.al = vj().getInt("kv_init_type", 0);
        }
        return this.al;
    }

    public String ck() {
        if (TextUtils.isEmpty(this.xk)) {
            this.xk = w().w("xpath", "");
        }
        return this.xk;
    }

    public boolean d() {
        return com.bytedance.sdk.openadsdk.core.eq.sr() && this.wt == 1;
    }

    public int db() {
        int c4 = c(this.f35770u, 3600, "dynamic_code_group_cache_time");
        this.f35770u = c4;
        if (c4 <= 0) {
            this.f35770u = 3600;
        }
        return this.f35770u;
    }

    public boolean dk() {
        return this.ab;
    }

    public int e() {
        if (this.ib == Integer.MAX_VALUE) {
            this.ib = w().w("refresh_req_num", 2);
        }
        if (this.ib <= 0) {
            this.ib = 2;
        }
        return this.ib;
    }

    public List<String> eb() {
        if (this.f35761m + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.gw) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public int eq() {
        if (this.f35767r == Integer.MAX_VALUE) {
            this.f35767r = w().w("web_upload_enable", 0);
        }
        return this.f35767r;
    }

    public boolean eu() {
        int ta = ta();
        return (ta == 40001 || ta == 40002 || ta == 4) && com.bytedance.sdk.component.panglearmor.ev.w();
    }

    public boolean ev() {
        if (this.fp == -1) {
            this.fp = w().w("enable_ttvideo", -1);
        }
        int i4 = this.fp;
        if (i4 == 0) {
            return false;
        }
        return (i4 == 1 && (com.bytedance.sdk.openadsdk.core.eq.ls.ux() || com.bytedance.sdk.openadsdk.core.eq.ls.sr())) ? false : true;
    }

    public String fm() {
        if (TextUtils.isEmpty(this.eb)) {
            this.eb = w().w("play_component_ugen_engine_url", "");
        }
        return this.eb;
    }

    public boolean fp() {
        if (this.xu == this.wo) {
            this.xu = w().w("enable_dl_ext", this.wo);
        }
        return this.xu == 1;
    }

    public boolean fz() {
        if (this.ge == 0) {
            this.ge = w().w("event_switch", 0);
        }
        return this.ge == 1;
    }

    public boolean g() {
        return this.nd != 1;
    }

    public int gb() {
        if (this.bm == Integer.MAX_VALUE) {
            this.bm = w().w("adlog_exception_batch", 100);
        }
        return this.bm;
    }

    public String gd() {
        if (TextUtils.isEmpty(this.tl)) {
            String w3 = w().w("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.tl = w3;
            if (TextUtils.isEmpty(w3)) {
                this.tl = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.tl;
    }

    public String ge() {
        if (TextUtils.isEmpty(this.uj)) {
            this.uj = w().w("splash_close_text", "\u8df3\u8fc7");
        }
        if (TextUtils.isEmpty(this.uj)) {
            this.uj = "\u8df3\u8fc7";
        }
        return this.uj;
    }

    public int gp() {
        if (this.xg == Integer.MAX_VALUE) {
            this.xg = w().w("max_tpl_cnts", 100);
        }
        return this.xg;
    }

    public JSONObject gw() {
        return this.kr;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.w h() {
        return this.f35758j;
    }

    public int ia() {
        if (this.fm == 3) {
            this.fm = w().w("stats_batch", 5);
        }
        a.w("tp_dr", "sb:" + this.fm + " pg:6106");
        int i4 = this.fm;
        if (i4 <= 0 || i4 > 100) {
            return 5;
        }
        return i4;
    }

    public boolean iw() {
        if (this.f35773x == Integer.MAX_VALUE) {
            this.f35773x = w().w("app_list_control", 0);
        }
        return this.f35773x == 1;
    }

    public w ix() {
        return this.xq;
    }

    public boolean j() {
        if (this.f35751c == 0) {
            this.f35751c = w().w("launch_strategy", 0);
        }
        return this.f35751c == 1;
    }

    public int jd() {
        return this.f35760l;
    }

    public JSONObject jr() {
        return this.zb;
    }

    public String[] ju() {
        String str = this.qu;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.qu.split("//");
    }

    public int jv() {
        if (this.qy == Integer.MAX_VALUE) {
            this.qy = w().w("webview_cache_count_v3", 20);
        }
        int i4 = this.qy;
        if (i4 < 0) {
            return 20;
        }
        return i4;
    }

    public void k() {
        this.bs = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public boolean kk() {
        return this.jd != 0;
    }

    public List<String> kn() {
        if (this.f35761m + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> w3 = gb.w(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.vc) {
            for (String str : this.vc) {
                if (!w3.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                    arrayList.add(str);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.sdk.openadsdk.core.z.r.3
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.set(i4, ((String) arrayList.get(i4)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public long kr() {
        if (this.qf == -1) {
            this.qf = w().w("gnd_prefetch_cache_ttl", 0);
        }
        return this.qf;
    }

    public boolean ky() {
        return this.vb;
    }

    public int l() {
        return this.yh;
    }

    public boolean lf() {
        return this.dk == 1;
    }

    public boolean ls() {
        if (this.fz == Integer.MAX_VALUE) {
            this.fz = w().w("opt_show_check", 0);
        }
        return this.fz == 1;
    }

    public JSONObject lw() {
        if (this.f35771v == null) {
            try {
                String w3 = w().w("video_cache_config", "");
                if (!TextUtils.isEmpty(w3)) {
                    this.f35771v = new JSONObject(w3);
                }
            } catch (Throwable th) {
                Log.w("TTSdkSettings", th.getMessage());
            }
        }
        return this.f35771v;
    }

    public JSONObject m() {
        if (this.yu == null) {
            String w3 = w().w("download_sdk_config", "");
            this.wx = w3;
            if (!TextUtils.isEmpty(w3)) {
                try {
                    this.yu = new JSONObject(this.wx);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return this.yu;
    }

    public Set<String> me() {
        Set<String> w3;
        if (this.ev.isEmpty() && (w3 = w().w("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && w3.size() != 0) {
            for (String str : w3) {
                this.ev.add(str);
            }
        }
        return this.ev;
    }

    public int mk() {
        if (this.be == Integer.MAX_VALUE) {
            this.be = w().w("vbtt", 5);
        }
        return this.be;
    }

    public boolean mt() {
        if (this.jv == 2.1474836E9f) {
            this.jv = w().w("global_rate", 1.0f);
        }
        return ((float) ((int) this.jv)) == 1.0f;
    }

    public long mu() {
        if (this.ya == 2147483647L) {
            this.ya = w().w("bg_web_readd_t", 3000L);
        }
        return this.ya;
    }

    public boolean n() {
        if (this.oo == Integer.MAX_VALUE) {
            this.oo = 1;
        }
        return this.oo == 1;
    }

    public int nc() {
        int w3 = w().w("npth_enable_type", 0);
        this.f35754f = w3;
        return w3;
    }

    public boolean nd() {
        int c4 = c(this.f35757i, 0, "disable_dynamic_code_group");
        this.f35757i = c4;
        return c4 != 1;
    }

    public eq ng() {
        return this.eu;
    }

    public boolean ny() {
        return this.ls;
    }

    public int o() {
        if (this.mu == Integer.MAX_VALUE) {
            this.mu = w().w("fetch_tpl_timeout_ctrl", 3000);
        }
        if (this.mu <= 0) {
            this.mu = 3000;
        }
        return this.mu;
    }

    public String oh() {
        if (TextUtils.isEmpty(this.zt)) {
            this.zt = w().w("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.zt;
    }

    public com.bytedance.sdk.openadsdk.core.ux.w ok() {
        return this.f35766q;
    }

    public JSONObject oo() {
        if (this.mk == null) {
            try {
                this.mk = new JSONObject(w().w("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.mk;
    }

    public JSONObject ox() {
        return this.tx;
    }

    public boolean p() {
        boolean w3 = w().w("enable_apm_pv", false);
        this.kk = w3;
        return w3;
    }

    public boolean pb() {
        return this.pu;
    }

    public int pr() {
        if (this.f35749a == Integer.MAX_VALUE) {
            this.f35749a = w().w("web_upload_report_only_wifi", 0);
        }
        return this.f35749a;
    }

    public boolean pu() {
        if (this.yn == Integer.MAX_VALUE) {
            this.yn = w().w("read_video_from_cache", 1);
        }
        return this.yn == 1;
    }

    public long q() {
        if (this.ng == this.ox) {
            this.ng = w().w("ext_use_type", this.ox);
        }
        return this.ng;
    }

    public int qu() {
        if (this.lp == 0) {
            this.lp = vj().getInt("is_kv_cache_type", 0);
        }
        return this.lp;
    }

    public List<String> qy() {
        if (this.up.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(this.up);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public String r() {
        if (TextUtils.isEmpty(this.bs)) {
            this.bs = com.bytedance.sdk.openadsdk.core.xv.sr.c().sr();
        }
        return this.bs;
    }

    public int rd() {
        if (this.kn == Integer.MAX_VALUE) {
            this.kn = w().w("webview_cache_count", 20);
        }
        int i4 = this.kn;
        if (i4 < 0) {
            return 20;
        }
        return i4;
    }

    public int rh() {
        if (this.lw == Integer.MAX_VALUE) {
            this.lw = w().w("sp_key_if_sp_cache", 1);
        }
        return this.lw;
    }

    public boolean s() {
        if (this.ok == Integer.MAX_VALUE) {
            this.ok = w().w("switch_audio_focus", 0);
        }
        return this.ok == 1;
    }

    public long t() {
        if (this.au == 2147483647L) {
            this.au = w().w("adlog_interval", 5000L);
        }
        return this.au;
    }

    public int ta() {
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().j();
    }

    public String te() {
        if (TextUtils.isEmpty(this.rh)) {
            this.rh = w().w("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.rh)) {
            this.rh = "apps.bytesfield.com";
        }
        return this.rh;
    }

    public int tl() {
        if (this.jw == Integer.MAX_VALUE) {
            this.jw = w().w("refresh_max_times", 1);
        }
        if (this.jw < 0) {
            this.jw = 1;
        }
        return this.jw;
    }

    public int tx() {
        return this.f35752d;
    }

    public boolean u() {
        if (this.xv == 0) {
            this.xv = w().w("use_texture", 0);
        }
        return this.xv == 0;
    }

    public boolean uj() {
        return this.nb;
    }

    public boolean up() {
        return vc() == 1;
    }

    public int v() {
        if (this.xt == -1) {
            this.xt = w().w("gnd_prefetch_cache_size", 5);
        }
        return this.xt;
    }

    public int vc() {
        if (this.bw == Integer.MAX_VALUE) {
            this.bw = w().w("splash_check_type", 1);
        }
        return this.bw;
    }

    public com.bytedance.sdk.component.f.c w() {
        if (this.sr == null) {
            this.sr = ba.c("tt_sdk_settings_other");
        }
        return this.sr;
    }

    public JSONObject wo() {
        if (this.oh == null) {
            String w3 = w().w("http_drop", "");
            if (!TextUtils.isEmpty(w3)) {
                try {
                    this.oh = new JSONObject(w3);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return this.oh;
    }

    public JSONObject wt() {
        return this.dd;
    }

    public int wv() {
        if (this.gd == Integer.MAX_VALUE) {
            this.gd = w().w("web_upload_send_restowv", 0);
        }
        return this.gd;
    }

    public int wx() {
        if (this.ys == Integer.MAX_VALUE) {
            this.ys = w().w("web_upload_max_retry", 0);
        }
        return this.ys;
    }

    public int x() {
        if (this.f35769t == Integer.MAX_VALUE) {
            this.f35769t = w().w("web_upload_storage_type", 0);
        }
        return this.f35769t;
    }

    public boolean xg() {
        return Build.VERSION.SDK_INT < this.tc;
    }

    public int xk() {
        if (this.f35764p == Integer.MAX_VALUE) {
            this.f35764p = w().w("web_upload_max_single_file", 2);
        }
        return this.f35764p;
    }

    public boolean xq() {
        if (this.cf == 1) {
            this.cf = w().w("ud_enable", 1);
        }
        return this.cf == 1;
    }

    public JSONObject xu() {
        return this.ju;
    }

    public com.bytedance.sdk.component.f.c xv() {
        if (this.f35763o == null) {
            this.f35763o = ba.c("tt_sdk_settings_slot");
        }
        if (ba.w() != 1) {
            return null;
        }
        return this.f35763o;
    }

    public float y() {
        if (this.zg < 0.0f) {
            this.zg = w().w("call_stack_rate", 0.0f);
        }
        return this.zg;
    }

    public boolean yh() {
        return this.gp;
    }

    public void yn() {
        if (this.xw == null) {
            synchronized (this.ld) {
                if (this.xw == null) {
                    this.xw = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "tt_sdk_settings_slot_splash", 0);
                }
            }
        }
    }

    public int ys() {
        if (this.bj == Integer.MAX_VALUE) {
            this.bj = w().w("adlog_batch", 10);
        }
        return this.bj;
    }

    public int yu() {
        if (this.f35759k == Integer.MAX_VALUE) {
            this.f35759k = w().w("web_upload_max_zip_file", 5);
        }
        return this.f35759k;
    }

    public JSONObject z() {
        if (this.me == null) {
            String w3 = w().w("digest", "");
            if (!TextUtils.isEmpty(w3)) {
                try {
                    this.me = new JSONObject(w3);
                } catch (Exception unused) {
                }
            }
        }
        return this.me;
    }

    public boolean zb() {
        return this.rg;
    }

    public boolean zg() {
        return this.f35753e;
    }

    public String zr() {
        if (TextUtils.isEmpty(this.ky)) {
            this.ky = w().w("policy_url", db);
        }
        return this.ky;
    }

    public boolean zt() {
        return this.nc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.sr
    public synchronized void c() {
        w();
        this.gp = true;
        this.bm = this.sr.w("adlog_exception_batch", 100);
        this.tl = this.sr.w("url_stats", "api-access.pangolin-sdk-toutiao1.com");
        this.kk = this.sr.w("enable_apm_pv", false);
        this.lf = this.sr.w("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.xk = this.sr.w("xpath", "");
        this.wv = this.sr.w("data_time", 0L);
        this.f35755g = this.sr.w("fetch_template", 3600);
        this.be = this.sr.w("vbtt", 5);
        this.ba = this.sr.w("template_ids", this.jr);
        this.pr = this.sr.w("pyload_h5", this.jr);
        this.bw = this.sr.w("splash_check_type", 1);
        this.f35750b = this.sr.w("adlog_debug", 0);
        this.bj = this.sr.w("adlog_batch", 10);
        this.au = this.sr.w("adlog_interval", 5000L);
        this.bm = this.sr.w("adlog_exception_batch", 100);
        this.fp = this.sr.w("enable_ttvideo", -1);
        this.xu = this.sr.w("enable_dl_ext", this.wo);
        this.ng = this.sr.w("ext_use_type", this.ox);
        this.f35751c = this.sr.w("launch_strategy", 0);
        this.fz = this.sr.w("opt_show_check", 0);
        String w3 = this.sr.w("digest", "");
        if (!TextUtils.isEmpty(w3)) {
            try {
                this.me = new JSONObject(w3);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        String w4 = this.sr.w("pitaya_general_settings", "");
        if (!TextUtils.isEmpty(w4)) {
            try {
                this.f35756h = new JSONObject(w4);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        String w5 = this.sr.w("live_stream_cof", "");
        if (!TextUtils.isEmpty(w5)) {
            try {
                this.tx = new JSONObject(w5);
            } catch (Exception e6) {
                a.f("parse exception", "e:" + e6.getMessage());
            }
        }
        String w6 = this.sr.w("pitaya_business_conf", "");
        if (!TextUtils.isEmpty(w6)) {
            try {
                this.ju = new JSONObject(w6);
            } catch (Exception e7) {
                a.f("parse exception", "e:" + e7.getMessage());
            }
        }
        String w7 = this.sr.w("http_drop", "");
        if (!TextUtils.isEmpty(w7)) {
            try {
                this.oh = new JSONObject(w7);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
        this.fm = this.sr.w("stats_batch", 5);
        this.ok = this.sr.w("switch_audio_focus", 0);
        this.ge = this.sr.w("event_switch", 0);
        this.xv = this.sr.w("use_texture", 0);
        this.f35772w = this.sr.w("pre_fetch_cnt", 10);
        this.mt = this.sr.w("if_both_open", 0);
        this.f35775z = this.sr.w("tpl_infos", this.jr);
        this.qf = this.sr.w("gnd_prefetch_cache_ttl", 0);
        this.xt = this.sr.w("gnd_prefetch_cache_size", 5);
        this.jv = this.sr.w("global_rate", 1.0f);
        this.f35773x = this.sr.w("app_list_control", 0);
        this.xg = this.sr.w("max_tpl_cnts", 100);
        this.mu = this.sr.w("fetch_tpl_timeout_ctrl", 3000);
        this.f35753e = this.sr.w("open_single_abi", false);
        this.kn = this.sr.w("webview_cache_count", 20);
        this.qy = this.sr.w("webview_cache_count_v3", 20);
        this.iw = this.sr.w("webview_render_concurrent_count", 3);
        this.ky = this.sr.w("policy_url", db);
        Set<String> set = this.zr;
        if (set != null) {
            set.clear();
        }
        this.zr = this.sr.w("gecko_hosts", Collections.synchronizedSet(new HashSet()));
        this.tz = this.sr.w("gecko_ids", "");
        this.zr = c(this.zr);
        this.f35761m = this.sr.w("hit_app_list_time", 0L);
        this.gw.clear();
        this.ia = this.sr.w("circle_splash_switch", 0);
        this.f35768s = this.sr.w("circle_load_splash_time", -1);
        this.zt = this.sr.w("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.eb = this.sr.w("play_component_ugen_engine_url", "");
        this.rh = this.sr.w("ad_pkg_info_url", "apps.bytesfield.com");
        this.lw = this.sr.w("sp_key_if_sp_cache", 1);
        this.f35757i = this.sr.w("disable_dynamic_code_group", 0);
        this.f35770u = this.sr.w("dynamic_code_group_cache_time", 3600);
        this.uj = this.sr.w("splash_close_text", "\u8df3\u8fc7");
        this.gb = this.sr.w("network_module", 1);
        this.nc = this.sr.w("force_zero_skip", true);
        com.bytedance.sdk.component.w.c.c.c.c().c(false);
        this.f35767r = this.sr.w("web_upload_enable", 0);
        Set<String> w8 = this.sr.w("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
        this.ev.clear();
        if (w8 != null && w8.size() != 0) {
            for (String str : w8) {
                this.ev.add(str);
            }
        }
        this.gd = this.sr.w("web_upload_send_restowv", 0);
        this.f35764p = this.sr.w("web_upload_max_single_file", 2);
        this.f35759k = this.sr.w("web_upload_max_zip_file", 5);
        this.ys = this.sr.w("web_upload_max_retry", 0);
        this.bk = this.sr.w("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        this.f35769t = this.sr.w("web_upload_storage_type", 0);
        this.f35749a = this.sr.w("web_upload_report_only_wifi", 0);
        Set<String> w9 = this.sr.w("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
        if (w9 != null && !w9.isEmpty()) {
            for (String str2 : w9) {
                this.gw.add(str2);
            }
        }
        synchronized (this.vc) {
            this.vc.clear();
            Set<String> w10 = this.sr.w("scheme_list_data", Collections.synchronizedSet(new HashSet()));
            if (w10 != null && !w10.isEmpty()) {
                for (String str3 : w10) {
                    this.vc.add(str3);
                }
            }
        }
        synchronized (this.up) {
            this.up.clear();
            Set<String> w11 = this.sr.w("top_scheme_list_data", Collections.synchronizedSet(new HashSet()));
            if (w11 != null && !w11.isEmpty()) {
                for (String str4 : w11) {
                    this.up.add(str4);
                }
            }
        }
        String w12 = this.sr.w("download_sdk_config", "");
        this.wx = w12;
        if (!TextUtils.isEmpty(w12)) {
            try {
                this.yu = new JSONObject(this.wx);
            } catch (JSONException e9) {
                a.sr("TTSdkSettings", e9);
            }
        }
        String w13 = this.sr.w("thread_config", "");
        if (!TextUtils.isEmpty(w13)) {
            try {
                this.kr = new JSONObject(w13);
                com.bytedance.sdk.openadsdk.core.ba.c.c();
            } catch (JSONException e10) {
                a.sr("TTSdkSettings", e10);
            }
        }
        this.zg = this.sr.w("call_stack_rate", 0.0f);
        this.yn = this.sr.w("read_video_from_cache", 1);
        this.yh = this.sr.w("brand_video_cache_count", 2);
        this.pu = this.sr.w("enable_bw_screen_detection", false);
        this.pb = this.sr.w("playable_preload_count", 0);
        this.f35760l = this.sr.w("splash_card_show_max_count", 3);
        this.f35766q = com.bytedance.sdk.openadsdk.core.ux.w.c(this.sr.w("clog_config", this.jr));
        this.f35758j = com.bytedance.sdk.openadsdk.core.dislike.w.c(this.sr.w("oncall_upload", ""));
        this.ls = this.sr.w("check_live_room", false);
        this.ab = this.sr.w("can_init_live", true);
        String w14 = this.sr.w("plugin_update_state", "");
        if (!TextUtils.isEmpty(w14)) {
            try {
                this.zb = new JSONObject(w14);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        String w15 = this.sr.w("antispam_autoclick_detect", "");
        if (!TextUtils.isEmpty(w15)) {
            try {
                this.vt = new JSONObject(w15);
                com.bytedance.sdk.component.panglearmor.c.ux.c().c(this.vt);
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        String w16 = this.sr.w("app_live_config", "");
        if (!TextUtils.isEmpty(w16)) {
            try {
                this.xq = w.c(new JSONObject(w16));
            } catch (JSONException unused) {
            }
        }
        this.ix = this.sr.w("pglam_main_enable", 0);
        this.f35752d = this.sr.w("pglam_dns_check_enable", 0);
        this.qu = this.sr.w("pglam_clazz_check", "");
        this.cf = this.sr.w("ud_enable", 1);
        this.lp = vj().getInt("is_kv_cache_type", 0);
        this.al = vj().getInt("kv_init_type", 0);
        this.bn = this.sr.w("open_dl_type", 0);
        this.f35765pl = this.sr.w("app_dl_scheme_list", "");
        int w17 = this.sr.w("lp_url_sw", 0);
        this.vj = w17;
        if (w17 == 1) {
            this.fn = tz().w("lp_list", "");
        }
        this.wt = this.sr.w("is_open_isw", 1);
        String w18 = this.sr.w("live_sdk_conf", this.jr);
        if (!TextUtils.isEmpty(w18)) {
            this.eu = eq.c(w18);
        }
        this.f35754f = this.sr.w("npth_enable_type", 0);
        this.nd = this.sr.w("scheme_get_type", 0);
        this.ny = this.sr.w("scheme_get_num", 1);
        this.dk = this.sr.w("if_query_all_package", 0);
        this.vb = this.sr.w("is_sp_send_meta", true);
        this.st = this.sr.w("is_first_plugin_resources", false);
        this.tc = this.sr.w("mini_event_upload_version", 0);
        this.ya = this.sr.w("bg_web_readd_t", 3000L);
        this.ib = this.sr.w("refresh_req_num", 2);
        this.jw = this.sr.w("refresh_max_times", 1);
        this.em = this.sr.w("settings_open", 0);
        this.ds = this.sr.w("shake_trigger_control", 0);
        i.c(com.bytedance.sdk.openadsdk.core.eq.c(ls.getContext()), this.st, ls.getContext());
        n.w(this.sr);
        m.w(this.sr);
        String w19 = this.sr.w("video_cache_config", "");
        if (!TextUtils.isEmpty(w19)) {
            try {
                JSONObject jSONObject = new JSONObject(w19);
                this.f35771v = jSONObject;
                com.bykv.vk.openvk.component.video.c.c.c(jSONObject);
            } catch (JSONException e13) {
                e13.printStackTrace();
            }
        }
        String w20 = this.sr.w("log_rate_conf", "");
        if (!TextUtils.isEmpty(w20)) {
            try {
                this.mk = new JSONObject(w20);
            } catch (Exception unused2) {
            }
        }
        sr();
    }

    public boolean f() {
        return this.ds == 1;
    }

    public int i() {
        if (this.f35772w == 10) {
            this.f35772w = w().w("pre_fetch_cnt", 10);
        }
        return this.f35772w;
    }

    public int k(String str) {
        if (str == null) {
            return 0;
        }
        return ls.w().fz(str).ys;
    }

    public int p(String str) {
        if (str == null) {
            return 1500;
        }
        return ls.w().fz(str).f35745t;
    }

    public boolean f(String str) {
        return fz(String.valueOf(str)).f35736f == 1;
    }

    private boolean gb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f35765pl)) {
            this.f35765pl = w().w("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.f35765pl)) {
            return false;
        }
        String[] split = this.f35765pl.split(",");
        if (split.length == 0) {
            return false;
        }
        for (String str2 : split) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private c j(String str) {
        String w3;
        com.bytedance.sdk.component.f.c xv = xv();
        c cVar = null;
        try {
            if (xv == null) {
                if (this.ax == null) {
                    this.ax = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "tt_sdk_settings_slot", 0);
                }
                w3 = this.ax.getString(i(str), "");
            } else {
                w3 = xv.w(i(str), "");
            }
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            cVar = w(new JSONObject(w3));
            this.f35762n.put(str, cVar);
            return cVar;
        } catch (Throwable th) {
            a.sr("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return cVar;
        }
    }

    private c ls(String str) {
        return c.c().c(str).k(1).a(1).bk(2).t(1).ys(0).fp(1).p(3).ev(0).r(0).ia(1).xv(2000).s(2).fz(100).gd(0).c(false).w(false).c(0L).xv(false).c((JSONArray) null);
    }

    private c q(String str) {
        c cVar = null;
        try {
            yn();
            String string = this.xw.getString(i(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            cVar = w(new JSONObject(string));
            this.f35762n.put(str, cVar);
            return cVar;
        } catch (Throwable th) {
            a.sr("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return cVar;
        }
    }

    private static c w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        boolean optBoolean = jSONObject.optBoolean("enable_bidding_cache", false);
        long optLong = jSONObject.optLong("bidding_cache_skip_time", 0L);
        boolean optBoolean2 = jSONObject.optBoolean("enable_bidding_pre_fetch", false);
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt6 = jSONObject.optInt("reg_creative_control", 1);
        int optInt7 = jSONObject.optInt("play_bar_show_time", 3);
        int optInt8 = jSONObject.optInt("rv_skip_time", 0);
        int optInt9 = jSONObject.optInt("voice_control", 0);
        int optInt10 = jSONObject.optInt("if_show_win", 1);
        int optInt11 = jSONObject.optInt("sp_preload", 0);
        int optInt12 = jSONObject.optInt("stop_time", 1500);
        int optInt13 = jSONObject.optInt("native_playable_delay", 0);
        int optInt14 = jSONObject.optInt("time_out_control", 2000);
        int optInt15 = jSONObject.optInt("iv_skip_time", 0);
        boolean optBoolean3 = jSONObject.optBoolean("close_on_click", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("parent_tpl_ids");
        int optInt16 = jSONObject.optInt("splash_load_type", 2);
        int optInt17 = jSONObject.optInt("splash_buffer_time", 100);
        int optInt18 = jSONObject.optInt("playable_landing_cache_count", 0);
        int optInt19 = jSONObject.optInt("time_out_control_type", 0);
        if (!a(optInt2)) {
            optInt2 = 1;
        }
        if (!a(optInt9)) {
            optInt9 = 0;
        }
        int optInt20 = jSONObject.optInt("slot_type", -1);
        return c.c().c(optString).k(optInt).a(optInt2).bk(optInt3).t(optInt4).ys(optInt5).fp(optInt6).p(optInt7).ev(optInt8).r(optInt9).ia(optInt10).sr(optInt11).ux(optInt12).f(optInt13).xv(optInt14).s(optInt16).fz(optInt17).gd(optInt15).c(optJSONArray).xv(optBoolean3).u(optInt18).i(optInt19).c(optLong).w(optBoolean).c(optBoolean2).u(optInt18).w(optInt20).c(jSONObject.optInt("refresh_rit_sw", 0));
    }

    public boolean bk(String str) {
        try {
            c fz = ls.w().fz(String.valueOf(str));
            if (fz != null) {
                return fz.f35744s != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int fp(String str) {
        return s(String.valueOf(str)).f35742q;
    }

    public c fz(String str) {
        if (str == null) {
            return ls(str);
        }
        c cVar = this.f35762n.get(str);
        if (cVar == null) {
            cVar = j(str);
        }
        return cVar == null ? ls(str) : cVar;
    }

    public boolean k(int i4) {
        return fz(String.valueOf(i4)).ia;
    }

    public int p(int i4) {
        return s(String.valueOf(i4)).f35746u;
    }

    public int r(String str) {
        return s(str).fp;
    }

    public c s(String str) {
        if (str == null) {
            return ls(str);
        }
        c cVar = this.f35762n.get(str);
        if (cVar == null) {
            cVar = q(str);
        }
        return cVar == null ? ls(str) : cVar;
    }

    public boolean t(String str) {
        try {
            c s3 = ls.w().s(String.valueOf(str));
            if (s3 != null) {
                return s3.f35744s != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean u(String str) {
        if (TextUtils.isEmpty(str) || str.equals("http") || str.equals("https")) {
            return false;
        }
        if (this.bn == 0) {
            this.bn = w().w("open_dl_type", 0);
        }
        int i4 = this.bn;
        if (i4 == 0) {
            return false;
        }
        if (i4 == 2) {
            return true;
        }
        return gb(str);
    }

    public int ys(String str) {
        return fz(str).ev;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(JSONObject jSONObject) {
        int length;
        this.zt = jSONObject.optString("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.eb = jSONObject.optString("play_component_ugen_engine_url", "");
        this.bs = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.lf = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.xk = jSONObject.optString("xpath");
        this.me = jSONObject.optJSONObject("digest");
        this.wv = jSONObject.optLong("data_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c(optJSONObject.optLong("duration") * 1000);
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c(optJSONObject.optInt("max"));
        }
        this.be = jSONObject.optInt("vbtt", 5);
        this.f35755g = jSONObject.optInt("fetch_tpl_interval", 3600);
        this.ky = jSONObject.optString("privacy_url", db);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("abtest");
        if (optJSONObject2 != null) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c(optJSONObject2.optString("version"));
            com.bytedance.sdk.openadsdk.core.xv.ux.c().w(optJSONObject2.optString("param"));
        } else {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().sr();
        }
        this.yn = jSONObject.optInt("read_video_from_cache", 1);
        this.pu = jSONObject.optBoolean("enable_bw_screen_detection", false);
        this.pb = jSONObject.optInt("playable_landing_cache_count", 0);
        com.bytedance.sdk.openadsdk.core.playable.ux.c().c(this.pb);
        ux(jSONObject.optJSONObject("web_upload"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.mk = optJSONObject3;
        if (optJSONObject3 != null) {
            this.jv = (float) optJSONObject3.optDouble("global_rate", 1.0d);
            if (this.mk.has("call_stack_rate")) {
                this.zg = (float) this.mk.optDouble("call_stack_rate");
            } else {
                this.zg = this.jv;
            }
        } else {
            this.jv = 1.0f;
        }
        this.pr = jSONObject.optString("pyload_h5");
        this.bw = f(jSONObject);
        a.f("splashLoad", "setting-\u300bmSplashCheckType=" + this.bw);
        this.mt = jSONObject.optInt("if_both_open", 0);
        this.oo = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.f35773x = jSONObject.optInt(CampaignEx.JSON_KEY_AD_AL, 1);
        this.xg = jSONObject.optInt("max_tpl_cnts", 100);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject4 != null) {
            com.bytedance.sdk.openadsdk.core.xv.sr.c().w(optJSONObject4);
            this.tl = optJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.kk = optJSONObject4.optBoolean("enable_apm_pv", false);
            this.f35753e = optJSONObject4.optBoolean("open_single_abi", false);
            this.mu = optJSONObject4.optInt("fetch_tpl_timeout_ctrl", 3000);
            this.ia = optJSONObject4.optInt("circle_splash", 0);
            this.f35768s = optJSONObject4.optInt("circle_time", -1);
            this.lw = optJSONObject4.optInt("if_sp_cache", 1);
            this.kn = optJSONObject4.optInt("webview_cache_count", 20);
            this.qy = optJSONObject4.optInt("webview_cache_count_v3", 20);
            this.iw = optJSONObject4.optInt("webview_render_concurrent_count", 3);
            this.jd = optJSONObject4.optInt("preload_load_merge", 0);
            this.rh = optJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.uj = optJSONObject4.optString("splash_close_text", "\u8df3\u8fc7");
            this.gb = optJSONObject4.optInt("network_module", 1);
            this.nc = optJSONObject4.optBoolean("force_zero_skip", true);
            com.bytedance.sdk.openadsdk.core.xv.ux.c().p(optJSONObject4.optInt("cypher_version", AdError.ERROR_CODE_REQUEST_PB_ERROR));
            com.bytedance.sdk.component.w.c.c.c.c().c(false);
            this.f35750b = optJSONObject4.optInt("adlog_debug", 0);
            this.bj = optJSONObject4.optInt("adlog_batch", 10);
            this.au = optJSONObject4.optLong("adlog_interval", 5000L);
            this.bm = optJSONObject4.optInt("adlog_exception_batch", 100);
            this.fp = optJSONObject4.optInt("enable_ttvideo", -1);
            this.ng = optJSONObject4.optLong("ext_use_type", this.ox);
            this.xu = optJSONObject4.optInt("enable_dl_ext", this.wo);
            this.f35751c = optJSONObject4.optInt("launch_strategy", 0);
            this.fz = optJSONObject4.optInt("opt_show_check", 0);
            this.ds = optJSONObject4.optInt("shake_trigger_control", 0);
            this.f35756h = optJSONObject4.optJSONObject("pitaya_general_settings");
            this.oh = optJSONObject4.optJSONObject("http_drop");
            this.fm = optJSONObject4.optInt("stats_batch", 5);
            this.tx = optJSONObject4.optJSONObject("live_stream_cof");
            this.ju = optJSONObject4.optJSONObject("pitaya_business_conf");
            com.bytedance.sdk.openadsdk.core.xv.ux.c().a(optJSONObject4.optInt("spl_cache_conf", 0));
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c(this.ju);
            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("client_intelligence_conf");
            if (optJSONObject5 != null) {
                this.rg = optJSONObject5.optBoolean("net_rating");
                this.dd = optJSONObject5.optJSONObject("net_rating_config");
                this.nb = optJSONObject5.optBoolean("device_rating");
            }
            this.ge = optJSONObject4.optInt("event_switch", 0);
            this.xv = optJSONObject4.optInt("use_texture", 0);
            this.ok = optJSONObject4.optInt("switch_audio_focus", 0);
            this.f35760l = optJSONObject4.optInt("splash_card_show_max_count", 3);
            this.f35772w = optJSONObject4.optInt("pre_fetch_cnt", 10);
            this.f35770u = optJSONObject4.optInt("dynamic_code_group_cache_time", 3600);
            this.f35757i = optJSONObject4.optInt("disable_dynamic_code_group");
            this.xt = optJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.qf = optJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            try {
                this.zr.clear();
                JSONArray optJSONArray = optJSONObject4.optJSONArray("gecko_hosts");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        this.zr.add(optJSONArray.getString(i4));
                    }
                }
                this.zr = c(this.zr);
            } catch (Throwable th) {
                a.xv("GeckoLog: settings json error " + th);
            }
            sr(optJSONObject4);
            this.nd = optJSONObject4.optInt("scheme_get_type", 0);
            this.ny = optJSONObject4.optInt("scheme_get_num", 1);
            this.dk = optJSONObject4.optInt("if_query_all_package", 0);
            this.f35766q = com.bytedance.sdk.openadsdk.core.ux.w.c(optJSONObject4.optJSONObject("clog_config"));
            this.f35758j = com.bytedance.sdk.openadsdk.core.dislike.w.c(optJSONObject4.optJSONObject("oncall_upload"));
            this.ls = optJSONObject4.optBoolean("check_live_room", false);
            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("pglam");
            if (optJSONObject6 != null) {
                this.ix = optJSONObject6.optInt("pglam_main_enable", 0);
                this.f35752d = optJSONObject6.optInt("pglam_dns_check_enable", 0);
                this.qu = optJSONObject6.optString("pglam_clazz_check", "");
            }
            this.cf = optJSONObject4.optInt("ud_enable", 1);
            this.kr = optJSONObject4.optJSONObject("thread_config");
            this.ab = optJSONObject4.optBoolean("can_init_live", true);
            this.xq = w.c(optJSONObject4.optJSONObject("app_live_config"));
            this.zb = optJSONObject4.optJSONObject("plugin_update_state");
            this.vt = optJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.bytedance.sdk.component.panglearmor.c.ux.c().c(this.vt);
            this.wt = optJSONObject4.optInt("is_open_isw", 1);
            this.lp = optJSONObject4.optInt("is_kv_cache_type", 0);
            this.al = optJSONObject4.optInt("kv_init_type", 0);
            this.bn = optJSONObject4.optInt("open_dl_type", 0);
            this.f35765pl = optJSONObject4.optString("app_dl_scheme_list", "");
            int optInt = optJSONObject4.optInt("lp_url_sw", 0);
            this.vj = optInt;
            if (optInt == 1) {
                this.fn = optJSONObject4.optString("lp_list", "");
            }
            this.tc = optJSONObject4.optInt("mini_event_upload_version", 0);
            this.ya = optJSONObject4.optLong("bg_web_readd_t", 3000L);
            this.ib = optJSONObject4.optInt("refresh_req_num", 2);
            this.jw = optJSONObject4.optInt("refresh_max_times", 1);
            vj().edit().putBoolean("_use_pl_", optJSONObject4.optBoolean("_use_pl_", false)).apply();
            this.f35754f = optJSONObject4.optInt("npth_enable_type", 0);
            this.vb = optJSONObject4.optBoolean("is_sp_send_meta", true);
            boolean z3 = this.st;
            boolean optBoolean = optJSONObject4.optBoolean("is_first_plugin_resources", false);
            this.st = optBoolean;
            if (z3 != optBoolean) {
                i.c(com.bytedance.sdk.openadsdk.core.eq.c(ls.getContext()), this.st, ls.getContext());
            }
        }
        n.w(jSONObject);
        m.c(jSONObject);
        this.f35761m = System.currentTimeMillis();
        this.gw.clear();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                String optString = optJSONArray2.optString(i5);
                if (!TextUtils.isEmpty(optString)) {
                    this.gw.add(optString);
                }
            }
        }
        synchronized (this.vc) {
            this.vc.clear();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("scheme_check_list");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                for (int i6 = 0; i6 < length3; i6++) {
                    String optString2 = optJSONArray3.optString(i6);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.vc.add(optString2);
                    }
                }
            }
        }
        synchronized (this.up) {
            this.up.clear();
            JSONArray optJSONArray4 = jSONObject.optJSONArray("top_scheme_list");
            if (optJSONArray4 != null) {
                int length4 = optJSONArray4.length();
                for (int i7 = 0; i7 < length4; i7++) {
                    String optString3 = optJSONArray4.optString(i7);
                    if (!TextUtils.isEmpty(optString3)) {
                        this.up.add(optString3);
                    }
                }
            }
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("download_config");
        if (optJSONObject7 != null) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().gd(optJSONObject7.optInt("if_storage_internal", 1));
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("download_sdk_config");
        this.yu = optJSONObject8;
        if (optJSONObject8 != null) {
            this.wx = optJSONObject8.toString();
        } else {
            this.wx = "";
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray5 != null && (length = optJSONArray5.length()) > 0) {
            this.f35762n.clear();
            for (int i8 = 0; i8 < length; i8++) {
                JSONObject optJSONObject9 = optJSONArray5.optJSONObject(i8);
                c w3 = w(optJSONObject9);
                if (w3 != null) {
                    this.f35762n.put(w3.f35735c, w3);
                    if (com.bytedance.sdk.openadsdk.core.xv.ux.c().k(w3.xv())) {
                        c(w3.f35735c, optJSONObject9.toString());
                    }
                    w(w3.f35735c, optJSONObject9.toString());
                    com.bytedance.sdk.openadsdk.tools.w.c(w3.f35735c, optJSONObject9);
                }
            }
        }
        com.bytedance.sdk.openadsdk.tools.w.xv(15, this.bs);
        this.yh = jSONObject.optInt("pre_cache_brand_count", this.yh);
        JSONObject optJSONObject10 = jSONObject.optJSONObject("video_cache_config");
        this.f35771v = optJSONObject10;
        if (optJSONObject10 != null) {
            com.bykv.vk.openvk.component.video.c.c.c(optJSONObject10);
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("live_sdk_conf");
        if (optJSONObject11 != null) {
            this.eu = eq.c(optJSONObject11);
        }
        sr();
        al();
        com.bytedance.sdk.openadsdk.core.ux.xv.c(this.f35766q);
        lp();
    }

    public boolean ev(String str) {
        return str == null || ls.w().fz(str).f35734a == 1;
    }

    public int f(int i4) {
        if (this.nc) {
            return 0;
        }
        return Math.max(fz(String.valueOf(i4)).f35741p, 0);
    }

    public boolean ia(String str) {
        return fz(str).w() == 1;
    }

    public JSONArray a(String str) {
        try {
            Set<com.bytedance.sdk.component.adexpress.c.xv.w> c4 = com.bytedance.sdk.component.adexpress.c.w.w.c(str, true);
            if (c4 != null && c4.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.component.adexpress.c.xv.w wVar : c4) {
                    if (wVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", wVar.w());
                        jSONObject.put("md5", wVar.xv());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public boolean gd(String str) {
        return str == null || ls.w().s(str).bk == 0;
    }

    public int r(int i4) {
        int i5 = fz(String.valueOf(i4)).f35747w;
        if (i5 < 1 || i5 > 5) {
            return 1;
        }
        return i5;
    }

    public int ev(int i4) {
        return fz(String.valueOf(i4)).f35743r;
    }

    public int gd(int i4) {
        int i5 = s(String.valueOf(i4)).fz;
        if (i5 == 0 || i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) {
            return i5;
        }
        return 2;
    }

    private void sr(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            optJSONArray = jSONObject.optJSONArray("gecko_ids");
        } catch (Throwable th) {
            a.xv("GeckoLog: settings json error " + th);
        }
        if (optJSONArray == null) {
            return;
        }
        this.tz = optJSONArray.toString();
        if (optJSONArray.length() == 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.c.c().w();
    }

    public long sr(String str) {
        return fz(str).sr;
    }

    public boolean sr(int i4) {
        return fz(String.valueOf(i4)).xv == 1;
    }

    public List<String> ux() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.tz);
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (!TextUtils.isEmpty(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY))) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("values");
                    int length2 = jSONArray2.length();
                    for (int i5 = 0; i5 < length2; i5++) {
                        String optString = jSONArray2.optString(i5);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public boolean ux(String str) {
        int i4 = ls.w().fz(String.valueOf(str)).ux;
        if (i4 != 1) {
            return i4 == 2 && ys.xv(ls.getContext()) != 0;
        }
        return ys.sr(ls.getContext());
    }

    public int ux(int i4) {
        if (this.nc) {
            return 0;
        }
        return Math.max(fz(String.valueOf(i4)).gd, 0);
    }

    private void w(String str, String str2) {
        com.bytedance.sdk.component.f.c xv = xv();
        if (xv == null) {
            try {
                if (this.ax == null) {
                    this.ax = com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext(), "tt_sdk_settings_slot", 0);
                }
                SharedPreferences.Editor edit = this.ax.edit();
                edit.putString(i(str), str2);
                edit.commit();
                return;
            } catch (Throwable th) {
                a.sr("TTSdkSetting", "saveSlotConfig failed:" + th.getMessage());
                return;
            }
        }
        xv.c(i(str), str2);
    }

    public boolean w(int i4) {
        return gd(i4) != 0;
    }

    public boolean w(String str) {
        return fz(str).ls;
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.sr
    public void c(final JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.n.f.c()) {
            com.bytedance.sdk.openadsdk.n.f.c(new p("saveData") { // from class: com.bytedance.sdk.openadsdk.core.z.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.xv(jSONObject);
                }
            });
        } else {
            xv(jSONObject);
        }
    }

    private void c(String str, String str2) {
        try {
            yn();
            SharedPreferences.Editor edit = this.xw.edit();
            edit.putString(i(str), str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public long xv(String str) {
        return fz(str).gb;
    }

    public void xv(int i4) {
        if (this.em != i4) {
            this.em = i4;
            w().c("settings_open", this.em);
        }
    }

    public void c(int i4) {
        this.oo = i4;
    }

    public boolean c(String str) {
        return fz(str).f35738j;
    }

    public boolean c(me meVar, int i4) {
        c fz = ls.w().fz(String.valueOf(i4));
        return com.bytedance.sdk.openadsdk.core.component.reward.sr.sr.c(meVar) == 4 ? fz.xv == 1 : fz.f35739k == 1;
    }

    public static Set<String> c(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }

    private int c(int i4, int i5, String str) {
        return i4 == i5 ? w().w(str, i5) : i5;
    }
}
