package com.bytedance.msdk.core.fp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.api.sr.ys;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.k.sr;
import com.bytedance.msdk.core.k.ux;
import com.bytedance.msdk.f.ck;
import com.bytedance.msdk.f.m;
import com.bytedance.msdk.f.s;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import com.bytedance.msdk.xv.r;
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
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f27947a;
    private int au;
    private com.bytedance.msdk.core.xv.w bj;
    private int bk;
    private int bw;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f27949f;
    private String gd;
    private long ia;

    /* renamed from: k  reason: collision with root package name */
    private String f27952k;

    /* renamed from: m  reason: collision with root package name */
    private com.bytedance.msdk.core.w.w f27953m;

    /* renamed from: p  reason: collision with root package name */
    private int f27955p;
    private String pr;

    /* renamed from: r  reason: collision with root package name */
    private String f27957r;

    /* renamed from: s  reason: collision with root package name */
    private long f27958s;
    private long sr;
    private long ux;
    private int wx;

    /* renamed from: x  reason: collision with root package name */
    private int f27962x;
    private String xv;

    /* renamed from: z  reason: collision with root package name */
    private int f27964z;

    /* renamed from: c  reason: collision with root package name */
    private int f27948c = 259200000;

    /* renamed from: w  reason: collision with root package name */
    private final List<com.bytedance.msdk.ux.c> f27961w = new CopyOnWriteArrayList();

    /* renamed from: t  reason: collision with root package name */
    private String f27959t = null;
    private int ys = 0;
    private String fp = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private int fz = Integer.MAX_VALUE;

    /* renamed from: u  reason: collision with root package name */
    private final List<ys> f27960u = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Boolean> f27950i = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    private final AtomicBoolean f27956q = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private int f27951j = 0;
    private Map<String, String> ls = new ConcurrentHashMap();
    private Map<String, List<String>> gb = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private double f27954n = 0.0d;
    private boolean ck = false;
    private Map<String, sr> ba = new ConcurrentHashMap();

    /* renamed from: y  reason: collision with root package name */
    private int f27963y = 0;
    private final Map<String, List<sr>> eq = new ConcurrentHashMap();
    private final Map<String, ux> me = new ConcurrentHashMap();
    private final Map<String, Integer> wv = new ConcurrentHashMap();
    private final Map<String, Integer> xk = new ConcurrentHashMap();
    private int yu = 0;
    private int gw = 0;
    private int vc = 0;
    private int up = 0;
    private int mt = 0;
    private int oo = 0;

    private boolean b() {
        Boolean bool = this.f27950i.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ox() {
        com.bytedance.msdk.core.bk.c.c().sr();
        if (ls()) {
            synchronized (this.f27960u) {
                for (ys ysVar : this.f27960u) {
                    ysVar.c();
                }
                this.f27960u.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo() {
        if (this.f27961w.size() > 0) {
            synchronized (this.f27961w) {
                for (com.bytedance.msdk.ux.c cVar : this.f27961w) {
                    cVar.c();
                }
                this.f27961w.clear();
            }
        }
    }

    public int au() {
        return this.gw;
    }

    public int bj() {
        return this.vc;
    }

    public boolean bm() {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "enable_bid_result_return = " + this.up);
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "enable_bid_result_return_for_baidu = " + this.mt);
        return this.up == 1 && this.mt == 1;
    }

    public Map<String, sr> bw() {
        return this.ba;
    }

    public boolean eq() {
        return this.bw == 1;
    }

    public boolean gw() {
        return this.f27963y == 1;
    }

    public String m() {
        return this.pr;
    }

    public boolean me() {
        return this.f27962x == 1;
    }

    public Map<String, Integer> mt() {
        return this.wv;
    }

    public Map<String, Integer> oo() {
        return this.xk;
    }

    public int pr() {
        return this.f27964z;
    }

    public int up() {
        com.bytedance.msdk.core.w.w wVar = this.f27953m;
        if (wVar != null) {
            return wVar.c();
        }
        return 0;
    }

    public int vc() {
        return this.f27948c;
    }

    public boolean wv() {
        return this.au == 1;
    }

    public boolean wx() {
        return this.f27964z == 1;
    }

    public boolean x() {
        return this.wx == 1;
    }

    public com.bytedance.msdk.core.w.w xk() {
        return this.f27953m;
    }

    public com.bytedance.msdk.core.xv.w yu() {
        if (wv()) {
            return this.bj;
        }
        return null;
    }

    private void ev(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(new JSONObject(str).optString("app_ab_params")).optJSONObject("mediation_settings");
            if (optJSONObject != null) {
                this.yu = optJSONObject.optInt("ad_request_optmize");
                this.oo = optJSONObject.optInt("use_csj_loglib");
            }
        } catch (Throwable unused) {
        }
    }

    private String f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bk = jSONObject.optInt("fetch_ad_type", 0);
            return jSONObject.toString();
        }
        return null;
    }

    private String gd(JSONObject jSONObject) {
        this.f27950i.clear();
        if (jSONObject != null) {
            try {
                if (jSONObject.optBoolean("ad_event_control")) {
                    this.f27950i.put("ad_event_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_banner_control")) {
                    this.f27950i.put("type_banner_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_interaction_control")) {
                    this.f27950i.put("type_interaction_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_interactionfull_control")) {
                    this.f27950i.put("type_interactionfull_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_splash_control")) {
                    this.f27950i.put("type_splash_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_feed_control")) {
                    this.f27950i.put("type_feed_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_reward_control")) {
                    this.f27950i.put("type_reward_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_full_control")) {
                    this.f27950i.put("type_full_control", Boolean.TRUE);
                }
                if (jSONObject.optBoolean("type_native_control")) {
                    this.f27950i.put("type_native_control", Boolean.TRUE);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.xk.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.xk.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.wv.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.wv.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void r(String str) {
        try {
            com.bytedance.msdk.core.admanager.reward.rewardagain.xv.c(new JSONArray(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private String sr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return "";
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        arrayList.add(sr.c(next, jSONArray.optJSONObject(i4)));
                    }
                    this.eq.put(next, arrayList);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    private String ux(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.ba.put(next, sr.c(next, jSONObject.optJSONObject(next)));
            }
            return jSONObject.toString();
        }
        return null;
    }

    public boolean a() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_interactionfull_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public Map<String, List<String>> ba() {
        return this.gb;
    }

    public boolean bk() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_splash_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean c() {
        return this.f27956q.get();
    }

    public boolean ck() {
        return this.f27951j == 1;
    }

    public boolean fp() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_full_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean fz() {
        try {
            return Integer.valueOf(this.f27952k).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean gb() {
        if (this.fz == Integer.MAX_VALUE) {
            this.fz = 1;
        }
        return this.fz == 1;
    }

    public int i() {
        return com.bytedance.msdk.ux.c.c.p().sr();
    }

    public boolean ia() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_native_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean j() {
        return (com.bytedance.msdk.ux.c.c.p().ev() || com.bytedance.msdk.ux.c.c.p().xv()) ? false : true;
    }

    public boolean ls() {
        return (TextUtils.isEmpty(com.bytedance.msdk.core.w.k().a()) || com.bytedance.msdk.ux.c.c.p().ev() || !c()) ? false : true;
    }

    public void n() {
        f.c().xv();
        this.xv = null;
    }

    public long q() {
        return com.bytedance.msdk.ux.c.c.p().ux();
    }

    public boolean s() {
        return this.f27955p >= 1;
    }

    public boolean t() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_feed_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean u() {
        try {
            return Integer.valueOf(this.f27952k).intValue() > 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean w() {
        return this.yu == 1;
    }

    public int xv() {
        return this.oo;
    }

    public double y() {
        return this.f27954n;
    }

    public boolean ys() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_reward_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public Map<String, String> z() {
        return this.ls;
    }

    public com.bytedance.msdk.core.k.w c(String str, int i4, int i5) {
        return com.bytedance.msdk.ux.c.c.p().c(str, i4, i5);
    }

    public com.bytedance.msdk.core.k.c w(String str) {
        return com.bytedance.msdk.ux.c.c.p().c(str);
    }

    public boolean xv(String str) {
        return com.bytedance.msdk.ux.c.c.p().w(str);
    }

    private String w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.f27953m = new com.bytedance.msdk.core.w.w(jSONObject);
        return jSONObject.toString();
    }

    private String xv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.bj = new com.bytedance.msdk.core.xv.w(jSONObject);
        return jSONObject.toString();
    }

    public long c(int i4, String str) {
        com.bytedance.msdk.core.k.w c4 = c(str, i4, 101);
        if (c4 != null) {
            return c4.x();
        }
        return 3000L;
    }

    public String f() {
        if (this.xv == null) {
            this.xv = f.c().w(DownloadModel.ETAG);
        }
        return this.xv;
    }

    private void r(JSONObject jSONObject) {
        this.ls.clear();
        this.f27951j = 0;
        if (jSONObject == null) {
            return;
        }
        this.f27951j = jSONObject.optInt("if_sample", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (optJSONObject != null) {
            try {
                Iterator<String> keys = optJSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                            this.ls.put(next, optString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public com.bytedance.msdk.core.k.c c(String str) {
        return com.bytedance.msdk.ux.c.c.p().c(str);
    }

    public boolean w(String str, int i4) {
        return (com.bytedance.msdk.ux.c.c.p().xv() || com.bytedance.msdk.ux.c.c.p().ev() || com.bytedance.msdk.ux.c.c.p().c(str, i4, 101) == null) ? false : true;
    }

    public boolean xv(String str, int i4) {
        com.bytedance.msdk.core.k.w c4;
        Map<Integer, List<p>> n4;
        if (com.bytedance.msdk.ux.c.c.p().ev()) {
            return true;
        }
        return (TextUtils.isEmpty(str) || (c4 = com.bytedance.msdk.ux.c.c.p().c(str, i4, 101)) == null || (n4 = c4.n()) == null || n4.size() == 0) ? false : true;
    }

    private void ev(JSONObject jSONObject) {
        this.gb.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                if (optJSONArray.get(i4) != null) {
                                    arrayList.add(optJSONArray.get(i4).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.gb.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean c(String str, String str2, int i4) {
        List<p> up;
        com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.ux.c.c.p().c(str, i4, 101);
        if (c4 == null || (up = c4.up()) == null) {
            return false;
        }
        for (p pVar : up) {
            if (pVar != null && TextUtils.equals(pVar.ia(), str2)) {
                return pVar.yu();
            }
        }
        return false;
    }

    public List<sr> f(String str) {
        return this.eq.get(str);
    }

    public boolean k() {
        if (b()) {
            Boolean bool = this.f27950i.get("type_banner_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean p() {
        if (b()) {
            Boolean bool = this.f27950i.get("ad_event_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public String ux() {
        return this.gd;
    }

    private String w(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.bytedance.msdk.core.gd.w> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        arrayList.add(optJSONArray.optString(i5));
                    }
                    com.bytedance.msdk.core.gd.w wVar = new com.bytedance.msdk.core.gd.w();
                    wVar.c(optJSONObject.optLong("break_request_duration"));
                    wVar.c(arrayList);
                    concurrentHashMap.put(optJSONObject.optString("adn_name"), wVar);
                }
            }
            com.bytedance.msdk.core.gd.xv.c().c(concurrentHashMap);
            return jSONArray.toString();
        }
        com.bytedance.msdk.core.gd.xv.c().c(null);
        return null;
    }

    public ux ux(String str) {
        return this.me.get(str);
    }

    public boolean c(String str, int i4) {
        com.bytedance.msdk.core.k.w c4;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.bytedance.msdk.ux.c.c.p().ev() || (c4 = com.bytedance.msdk.ux.c.c.p().c(str, i4, 101)) == null || c4.yu() == i4;
    }

    public String r() {
        return this.fp;
    }

    public String sr() {
        return this.ev;
    }

    @Override // com.bytedance.msdk.core.fp.c
    public void c(JSONObject jSONObject, final boolean z3) {
        JSONObject jSONObject2;
        xv xvVar;
        boolean z4;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("app_abtest");
            this.f27959t = optString;
            ev(optString);
            final int w3 = com.bytedance.msdk.ux.xv.c.c().w();
            this.xv = jSONObject.optString(DownloadModel.ETAG);
            this.sr = jSONObject.optLong("max_age");
            this.ux = System.currentTimeMillis() + this.sr;
            this.f27949f = jSONObject.optString("ab_version");
            this.f27957r = jSONObject.optString("ab_params");
            this.ev = jSONObject.optString("country");
            this.gd = jSONObject.optString("transparent_params");
            this.f27964z = jSONObject.optInt("if_test");
            this.f27955p = jSONObject.optInt("if_get_detail_return");
            this.f27952k = jSONObject.optString("ecpm_precision_level");
            this.f27947a = jSONObject.optString("fetch_primerit_level");
            final String optString2 = jSONObject.optString("url");
            this.ys = jSONObject.optInt("innerLog", 0);
            this.fp = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.ia = jSONObject.optLong("break_request_times", 0L);
            this.f27958s = jSONObject.optLong("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            this.wx = jSONObject.optInt("ex_info", 0);
            this.pr = jSONObject.optString("ex_");
            this.f27963y = jSONObject.optInt("if_enable_label", 0);
            this.f27948c = jSONObject.optInt("ecpm_ttl", 259200000);
            int optInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.fz = optInt;
            if (optInt != 0 && optInt != 1) {
                this.fz = 1;
            }
            this.f27954n = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int optInt2 = jSONObject.optInt("enable_label_return", 0);
            this.bw = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.bw = 0;
            }
            this.f27962x = jSONObject.optInt("dynamic_policy_enable", 0);
            com.bytedance.msdk.adapter.sr.xv.w("DynamicPolicy", "mDynamicPolicyEnable=" + this.f27962x);
            int i4 = this.f27962x;
            if (i4 != 0 && i4 != 1) {
                this.f27962x = 0;
            }
            int i5 = this.gw;
            int i6 = this.vc;
            JSONObject optJSONObject = jSONObject.optJSONObject("p_c");
            if (optJSONObject != null) {
                this.gw = optJSONObject.optInt("l_p_a", 0);
                this.vc = optJSONObject.optInt("l_p_r", 0);
            } else {
                this.gw = 0;
                this.vc = 0;
            }
            if (i5 != this.gw || i6 != this.vc) {
                com.bytedance.msdk.sr.w.ux.c();
            }
            com.bytedance.msdk.core.r.c.c().c(this.ia, this.f27958s);
            this.up = jSONObject.optInt("enable_bid_result_return", 0);
            this.mt = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            final JSONObject optJSONObject2 = jSONObject.optJSONObject("supervisor_feature");
            if (optJSONObject2 != null) {
                s.c(true);
                s.c(optJSONObject2);
            } else {
                s.c(false);
            }
            final JSONArray optJSONArray = jSONObject.optJSONArray("ra_info");
            if (optJSONArray != null) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.xv.c(optJSONArray);
            }
            com.bytedance.msdk.ux.c.c.p().c(w3).w(jSONObject.optJSONObject("app_common_config"));
            JSONObject optJSONObject3 = jSONObject.optJSONObject("adn_init_conf");
            com.bytedance.msdk.ux.c.c.p().xv(optJSONObject3);
            com.bytedance.msdk.ux.c.c.p().c(w3).c(optJSONObject3);
            final String w4 = w(jSONObject.optJSONArray("adn_control_conf"));
            final String f4 = f(jSONObject.optJSONObject("poor_network_config"));
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rit_conf");
            com.bytedance.msdk.ux.c.c.p().w(optJSONArray2);
            com.bytedance.msdk.ux.c.c.p().c(w3).c(optJSONArray2);
            final String gd = gd(jSONObject.optJSONObject("module_disable_control"));
            final JSONObject optJSONObject4 = jSONObject.optJSONObject("call_stack_conf");
            r(optJSONObject4);
            final JSONObject optJSONObject5 = jSONObject.optJSONObject("custom_adn_feature");
            ev(optJSONObject5);
            final JSONObject optJSONObject6 = jSONObject.optJSONObject("timeout_req");
            p(optJSONObject6);
            final JSONObject optJSONObject7 = jSONObject.optJSONObject("is_callback");
            k(optJSONObject7);
            final String ux = ux(jSONObject.optJSONObject("label_outputs"));
            final String sr = sr(jSONObject.optJSONObject("label_group_infos"));
            final String c4 = c(jSONObject.optJSONArray("dynamic_rules"));
            final String w5 = w(jSONObject.optJSONObject("dynamic_policy"));
            this.au = jSONObject.optInt("behavior_policy_enable", 0);
            com.bytedance.msdk.adapter.sr.xv.w("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.au);
            final String xv = xv(jSONObject.optJSONObject("behavior_policy"));
            try {
                com.bytedance.msdk.ux.c.c.p().c(w3).c(new Runnable() { // from class: com.bytedance.msdk.core.fp.xv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String c5;
                        String c6;
                        String c7;
                        String c8;
                        String c9;
                        String c10;
                        String c11;
                        String c12;
                        wv gd2 = com.bytedance.msdk.ux.c.c.p().c(w3).gd();
                        gd2.c(DownloadModel.ETAG, xv.this.xv);
                        gd2.c("max_age", xv.this.sr);
                        gd2.c("max_expire_time", xv.this.ux);
                        gd2.c("ab_version", xv.this.f27949f);
                        gd2.c("ab_params", xv.this.f27957r);
                        gd2.c("country", xv.this.ev);
                        gd2.c("transparent_params", xv.this.gd);
                        gd2.c("if_test", xv.this.f27964z);
                        gd2.c("network_permission", xv.this.f27955p);
                        gd2.c("ecpm_precision_level", xv.this.f27952k);
                        gd2.c("fetch_primerit_level", xv.this.f27947a);
                        gd2.c("app_abtest", xv.this.f27959t);
                        gd2.c("module_control", gd);
                        gd2.c("tt_app_log_url", xv.this.fp);
                        gd2.c("break_request_times", xv.this.ia);
                        gd2.c("break_request_hold_time", xv.this.f27958s);
                        gd2.c("ex_info", xv.this.wx);
                        gd2.c("if_enable_label", xv.this.f27963y);
                        gd2.c("cpm_expire_time", xv.this.f27948c);
                        JSONObject jSONObject3 = optJSONObject2;
                        gd2.c("key_supervisor_feature", jSONObject3 != null ? jSONObject3.toString() : "");
                        gd2.c("custom_adn_sample_ratio", (float) xv.this.f27954n);
                        gd2.c("enable_label_return", xv.this.bw);
                        gd2.c("dynamic_policy_enable", xv.this.f27962x);
                        gd2.c("behavior_policy_enable", xv.this.au);
                        gd2.c("limit_p_a", xv.this.gw);
                        gd2.c("limit_p_r", xv.this.vc);
                        gd2.c("enable_bid_result_return", xv.this.up);
                        gd2.c("enable_bid_result_return_for_baidu", xv.this.mt);
                        JSONObject jSONObject4 = optJSONObject4;
                        if (jSONObject4 != null) {
                            gd2.c("call_stack", jSONObject4.toString());
                        } else {
                            gd2.c("call_stack", "");
                        }
                        JSONObject jSONObject5 = optJSONObject5;
                        if (jSONObject5 != null) {
                            gd2.c("custom_adn_feature", jSONObject5.toString());
                        } else {
                            gd2.c("custom_adn_feature", "");
                        }
                        JSONObject jSONObject6 = optJSONObject6;
                        if (jSONObject6 != null) {
                            gd2.c("timeout_req", jSONObject6.toString());
                        } else {
                            gd2.c("timeout_req", "");
                        }
                        JSONObject jSONObject7 = optJSONObject7;
                        if (jSONObject7 != null) {
                            gd2.c("is_callback", jSONObject7.toString());
                        } else {
                            gd2.c("is_callback", "");
                        }
                        String str = optString2;
                        if (str != null && !TextUtils.isEmpty(str)) {
                            String c13 = com.bytedance.msdk.f.c.c(optString2, com.bytedance.msdk.f.w.c());
                            if (c13 != null) {
                                gd2.c("server_dist_host", c13);
                            }
                        } else {
                            gd2.f("server_dist_host");
                        }
                        String str2 = w4;
                        if (str2 != null && (c12 = com.bytedance.msdk.f.c.c(str2, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("adn_control_conf", c12);
                        }
                        String str3 = f4;
                        if (str3 != null) {
                            gd2.c("network_conf", str3);
                        }
                        if (!TextUtils.isEmpty(ux) && (c11 = com.bytedance.msdk.f.c.c(ux, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("label_outputs", c11);
                        }
                        if (!TextUtils.isEmpty(sr) && (c10 = com.bytedance.msdk.f.c.c(sr, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("label_group_infos", c10);
                        }
                        if (!TextUtils.isEmpty(c4) && (c9 = com.bytedance.msdk.f.c.c(c4, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("dynamic_rules", c9);
                        }
                        if (!TextUtils.isEmpty(xv.this.pr) && (c8 = com.bytedance.msdk.f.c.c(xv.this.pr, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("ex_", c8);
                        }
                        JSONArray jSONArray = optJSONArray;
                        if (jSONArray != null) {
                            String jSONArray2 = jSONArray.toString();
                            if (!TextUtils.isEmpty(jSONArray2) && (c7 = com.bytedance.msdk.f.c.c(jSONArray2, com.bytedance.msdk.f.w.c())) != null) {
                                gd2.c("reward_again_styles", c7);
                            }
                        }
                        if (!TextUtils.isEmpty(w5) && (c6 = com.bytedance.msdk.f.c.c(w5, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("dynamic_policy", c6);
                        }
                        if (!TextUtils.isEmpty(xv) && (c5 = com.bytedance.msdk.f.c.c(xv, com.bytedance.msdk.f.w.c())) != null) {
                            gd2.c("behavior_policy", c5);
                        }
                        gd2.c("is_config_from_assert", z3);
                        gd2.c("has_config_in_sp", true);
                    }
                });
                jSONObject2 = null;
                z4 = false;
                xvVar = this;
            } catch (Throwable th) {
                th = th;
                jSONObject2 = null;
                z4 = false;
                xvVar = this;
                try {
                    th.printStackTrace();
                } finally {
                    xvVar.c(z4, jSONObject2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            jSONObject2 = null;
            xvVar = this;
            z4 = false;
        }
    }

    public void sr(String str) {
        try {
            wv c4 = f.c();
            if ("2".equals(str)) {
                this.f27950i.put("active_control", Boolean.TRUE);
                c4.c("all_active_control", true);
            } else {
                this.f27950i.put("active_control", Boolean.FALSE);
                c4.c("all_active_control", false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean ev() {
        return this.bk == 1;
    }

    public String gd() {
        return this.f27959t;
    }

    public void w(ys ysVar) {
        if (ysVar == null) {
            return;
        }
        synchronized (this.f27960u) {
            if (this.f27960u.contains(ysVar)) {
                this.f27960u.remove(ysVar);
            }
        }
    }

    public void w(int i4) {
        this.f27964z = i4;
    }

    private String c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                ux.c(jSONArray.optJSONObject(i4), this.me);
            } catch (Exception e4) {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", "maybe some rit parse dynamic rules fail .....");
                e4.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public void c(final boolean z3, final JSONObject jSONObject) {
        final boolean j4 = j();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final int w3 = com.bytedance.msdk.ux.xv.c.c().w();
        com.bytedance.msdk.sr.w.c.w().c(com.bytedance.msdk.core.c.getContext(), z3, j4, new com.bytedance.msdk.core.f.w() { // from class: com.bytedance.msdk.core.fp.xv.2
            @Override // com.bytedance.msdk.core.f.w
            public void c() {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + j4);
                if (j4) {
                    if (!xv.this.f27956q.get()) {
                        xv.this.f27956q.set(true);
                        int c4 = com.bytedance.msdk.sr.w.c.c();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - com.bytedance.msdk.sr.xv.c();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        try {
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                                jSONObject2.put("adn_time", elapsedRealtime3);
                            }
                        } catch (Throwable unused) {
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("init_mode", Integer.valueOf(w3));
                        hashMap.put("csj_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.sr - com.bytedance.sdk.gromore.init.f.f31256c));
                        if (!com.bytedance.msdk.sr.sr.sr()) {
                            com.bytedance.msdk.adapter.sr.xv.c("TMe", "-----==---- \u5ef6\u65f6\u4e0a\u62a5sdk_init_end");
                            boolean z4 = z3;
                            com.bytedance.msdk.sr.sr.c(elapsedRealtime2, c4, z4 ? 1 : 0, jSONObject, hashMap);
                        } else {
                            com.bytedance.msdk.adapter.sr.xv.c("TMe", "-----==---- \u6b63\u5e38\u4e0a\u62a5sdk_init_end");
                            boolean z5 = z3;
                            r.c(elapsedRealtime2, c4, z5 ? 1 : 0, -1L, jSONObject, hashMap);
                        }
                        xv.this.wo();
                        com.bytedance.msdk.core.w.c.c();
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "sdk init end, duration: " + elapsedRealtime2 + ", initAdnCount: " + c4 + ", isFromLocalConfig: " + z3);
                    }
                    w.c(com.bytedance.msdk.core.c.w()).c(new com.bytedance.msdk.api.sr.ux() { // from class: com.bytedance.msdk.core.fp.xv.2.1
                        @Override // com.bytedance.msdk.api.sr.ux
                        public void c(com.bytedance.msdk.api.c cVar) {
                        }

                        @Override // com.bytedance.msdk.api.sr.ux
                        public void c(List<String> list) {
                            com.bytedance.msdk.adapter.sr.xv.c("TMe", "\u521d\u59cb\u5316\u66f4\u65b0pangle\u914d\u7f6e\u6210\u529f");
                        }
                    });
                    xv.this.ox();
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.fp.c
    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        wv c4 = f.c();
        this.sr = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = this.sr;
        this.ux = currentTimeMillis + j4;
        c4.c("max_age", j4);
        c4.c("max_expire_time", this.ux);
    }

    @Override // com.bytedance.msdk.core.fp.c
    public void c(boolean z3) {
        JSONObject pr;
        JSONObject jSONObject;
        int optInt;
        try {
            wv c4 = f.c();
            if (!c4.ux("has_config_in_sp") && (pr = com.bytedance.msdk.core.w.k().pr()) != null) {
                int optInt2 = pr.optInt("cypher", -1);
                if (optInt2 == 2) {
                    String c5 = m.c(pr.optString("message"));
                    if (!TextUtils.isEmpty(c5)) {
                        jSONObject = new JSONObject(c5);
                        pr = jSONObject;
                    }
                    optInt = pr.optInt("state_code");
                    String optString = pr.optString("message");
                    if (optInt != 20000 && !TextUtils.isEmpty(pr.toString())) {
                        pr.optJSONObject("adn_init_conf");
                        if (pr.optString("app_id").equals(com.bytedance.msdk.core.w.k().a())) {
                            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "\u672c\u5730\u914d\u7f6e\u89e3\u6790\u6210\u529f");
                            c(pr, true);
                            com.bytedance.msdk.core.bk.c.c().ux();
                            com.bytedance.msdk.core.w.k().c((JSONObject) null);
                            if (!z3) {
                                c(true, (JSONObject) null);
                            }
                            if (!com.bytedance.msdk.ux.c.c.p().ev() || ck.c(com.bytedance.msdk.core.c.getContext())) {
                                return;
                            }
                            com.bytedance.msdk.core.bk.c.c().c(-2, "\u672c\u5730\u6ca1\u6709\u914d\u7f6e/\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528");
                            return;
                        }
                        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "\u672c\u5730\u914d\u7f6eappid\u6216appkey\u975e\u6cd5");
                    } else {
                        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", " \u89e3\u5bc6\u9519\u8bef\u6216\u8005\u89e3\u6790\u9519\u8bef\uff1astateCode=" + optInt + "\uff0cmsg=" + optString);
                    }
                } else {
                    if (optInt2 == 1) {
                        String w3 = com.bytedance.msdk.f.c.w(pr.optString("message"), com.bytedance.msdk.f.w.c());
                        if (!TextUtils.isEmpty(w3)) {
                            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "setting data : " + w3.toString());
                            jSONObject = new JSONObject(w3);
                            pr = jSONObject;
                        }
                    } else if (optInt2 == 0) {
                        pr = new JSONObject(pr.optString("message"));
                    }
                    optInt = pr.optInt("state_code");
                    String optString2 = pr.optString("message");
                    if (optInt != 20000) {
                    }
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", " \u89e3\u5bc6\u9519\u8bef\u6216\u8005\u89e3\u6790\u9519\u8bef\uff1astateCode=" + optInt + "\uff0cmsg=" + optString2);
                }
            }
            com.bytedance.msdk.core.w.k().c((JSONObject) null);
            this.xv = c4.w(DownloadModel.ETAG);
            this.sr = c4.sr("max_age");
            this.ux = c4.sr("max_expire_time");
            this.f27949f = c4.w("ab_version");
            this.f27957r = c4.w("ab_params");
            this.ev = c4.w("country");
            this.gd = c4.w("transparent_params");
            this.f27964z = c4.xv("if_test");
            this.f27955p = c4.xv("network_permission");
            this.f27952k = c4.w("ecpm_precision_level");
            this.f27947a = c4.w("fetch_primerit_level");
            this.fp = c4.w("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.ia = c4.w("break_request_times", 0L);
            this.f27958s = c4.w("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            this.wx = c4.w("ex_info", 0);
            this.f27963y = c4.w("if_enable_label", 0);
            this.f27948c = c4.w("cpm_expire_time", 259200000);
            this.f27954n = c4.w("custom_adn_sample_ratio", 0.0f);
            this.bw = c4.w("enable_label_return", 0);
            this.f27962x = c4.w("dynamic_policy_enable", 0);
            this.au = c4.w("behavior_policy_enable", 0);
            this.gw = c4.w("limit_p_a", 0);
            this.vc = c4.w("limit_p_r", 0);
            this.up = c4.w("enable_bid_result_return", 0);
            this.mt = c4.w("enable_bid_result_return_for_baidu", 0);
            com.bytedance.msdk.core.r.c.c().c(this.ia, this.f27958s);
            String w4 = c4.w("network_conf");
            if (!TextUtils.isEmpty(w4)) {
                f(new JSONObject(w4));
            }
            String w5 = c4.w("reward_again_styles");
            if (!TextUtils.isEmpty(w5)) {
                r(com.bytedance.msdk.f.c.w(w5, com.bytedance.msdk.f.w.c()));
            }
            com.bytedance.msdk.ux.sr.c.p().k();
            String w6 = c4.w("adn_control_conf");
            if (!TextUtils.isEmpty(w6)) {
                if (!w6.startsWith("[") && !w6.startsWith("{")) {
                    w6 = com.bytedance.msdk.f.c.w(w6, com.bytedance.msdk.f.w.c());
                }
                w(new JSONArray(w6));
            }
            String w7 = c4.w("module_control");
            if (!TextUtils.isEmpty(w7)) {
                gd(new JSONObject(w7));
            }
            boolean ux = c4.ux("all_active_control");
            if (ux) {
                this.f27950i.put("active_control", Boolean.valueOf(ux));
            }
            String w8 = c4.w("call_stack");
            if (!TextUtils.isEmpty(w8)) {
                r(new JSONObject(w8));
            }
            String w9 = c4.w("custom_adn_feature");
            if (!TextUtils.isEmpty(w9)) {
                ev(new JSONObject(w9));
            }
            String w10 = c4.w("timeout_req");
            if (!TextUtils.isEmpty(w10)) {
                p(new JSONObject(w10));
            }
            String w11 = c4.w("is_callback");
            if (!TextUtils.isEmpty(w11)) {
                k(new JSONObject(w11));
            }
            String w12 = c4.w("key_supervisor_feature");
            if (!TextUtils.isEmpty(w12)) {
                s.c(true);
                s.c(new JSONObject(w12));
            } else {
                s.c(false);
            }
            String w13 = c4.w("label_outputs");
            if (!TextUtils.isEmpty(w13)) {
                if (!w13.startsWith("[") && !w13.startsWith("{")) {
                    w13 = com.bytedance.msdk.f.c.w(w13, com.bytedance.msdk.f.w.c());
                }
                if (!TextUtils.isEmpty(w13)) {
                    ux(new JSONObject(w13));
                }
            }
            String w14 = c4.w("label_group_infos");
            if (!TextUtils.isEmpty(w14)) {
                if (!w14.startsWith("[") && !w14.startsWith("{")) {
                    w14 = com.bytedance.msdk.f.c.w(w14, com.bytedance.msdk.f.w.c());
                }
                if (!TextUtils.isEmpty(w14)) {
                    sr(new JSONObject(w14));
                }
            }
            String w15 = c4.w("dynamic_rules");
            if (!TextUtils.isEmpty(w15)) {
                if (!w15.startsWith("[") && !w15.startsWith("{")) {
                    w15 = com.bytedance.msdk.f.c.w(w15, com.bytedance.msdk.f.w.c());
                }
                if (!TextUtils.isEmpty(w15)) {
                    c(new JSONArray(w15));
                }
            }
            String w16 = c4.w("dynamic_policy");
            if (!TextUtils.isEmpty(w16)) {
                if (!w16.startsWith("[") && !w16.startsWith("{")) {
                    w16 = com.bytedance.msdk.f.c.w(w16, com.bytedance.msdk.f.w.c());
                }
                if (!TextUtils.isEmpty(w16)) {
                    w(new JSONObject(w16));
                }
            }
            String w17 = c4.w("behavior_policy");
            if (!TextUtils.isEmpty(w17)) {
                if (!w17.startsWith("[") && !w17.startsWith("{")) {
                    w17 = com.bytedance.msdk.f.c.w(w17, com.bytedance.msdk.f.w.c());
                }
                if (!TextUtils.isEmpty(w17)) {
                    xv(new JSONObject(w17));
                }
            }
            String w18 = c4.w("ex_");
            if (!TextUtils.isEmpty(w18) && !w18.startsWith("[") && !w18.startsWith("{")) {
                this.pr = com.bytedance.msdk.f.c.w(w18, com.bytedance.msdk.f.w.c());
            }
            if (!TextUtils.isEmpty(c4.w("app_abtest"))) {
                String w19 = c4.w("app_abtest");
                this.f27959t = w19;
                ev(w19);
            }
            if (!z3) {
                c(true, (JSONObject) null);
            }
            if (!com.bytedance.msdk.ux.c.c.p().ev() || ck.c(com.bytedance.msdk.core.c.getContext())) {
                return;
            }
        } catch (Throwable unused) {
            if (!z3) {
                c(true, (JSONObject) null);
            }
            if (!com.bytedance.msdk.ux.c.c.p().ev() || ck.c(com.bytedance.msdk.core.c.getContext())) {
                return;
            }
        }
        com.bytedance.msdk.core.bk.c.c().c(-2, "\u672c\u5730\u6ca1\u6709\u914d\u7f6e/\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528");
    }

    public List<String> c(List<String> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (com.bytedance.msdk.ux.c.c.p().ev()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (com.bytedance.msdk.ux.c.c.p().c(str, 0, 101) == null) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public void c(ys ysVar) {
        if (ysVar == null) {
            return;
        }
        if (ls()) {
            ysVar.c();
            return;
        }
        synchronized (this.f27960u) {
            if (!this.f27960u.contains(ysVar)) {
                this.f27960u.add(ysVar);
            }
        }
    }

    public void c(int i4) {
        this.fz = i4;
    }

    public boolean c(long j4) {
        return j4 < ((long) this.f27948c);
    }
}
