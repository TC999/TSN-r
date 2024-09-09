package com.bytedance.sdk.openadsdk.core.u;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.u.mt;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me {
    private up ab;
    private String al;
    private fz ax;

    /* renamed from: b  reason: collision with root package name */
    private int f34727b;
    private int ba;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w bm;
    private boolean bn;
    private Map<String, Object> bw;
    private q bx;

    /* renamed from: c  reason: collision with root package name */
    public ok f34728c;
    private String ck;

    /* renamed from: d  reason: collision with root package name */
    private int f34729d;
    private z db;
    private int dd;
    private i df;
    private int dk;
    private ck ds;

    /* renamed from: e  reason: collision with root package name */
    private int f34730e;
    private String eb;
    private com.bytedance.sdk.openadsdk.core.ugeno.f.c ed;
    private com.bytedance.sdk.openadsdk.core.ugeno.gd.c ee;
    private n em;
    private ng eq;
    private String ev;
    private String ez;

    /* renamed from: f  reason: collision with root package name */
    private String f34731f;
    private String fh;
    private y fn;
    private String fp;
    private String gb;
    private JSONObject gd;
    private long gp;
    private m gw;
    private String hk;
    private int hl;
    private int ht;
    private int hv;

    /* renamed from: i  reason: collision with root package name */
    private s f34734i;
    private String ia;
    private fp ib;
    private boolean il;
    private String iu;
    private String iw;
    private int ix;

    /* renamed from: j  reason: collision with root package name */
    private int f34735j;
    private int jm;
    private int jr;
    private int ju;
    private String jv;
    private oo jw;

    /* renamed from: k  reason: collision with root package name */
    private String f34736k;
    private String kn;
    private String ku;
    private bw ky;
    private int ld;
    private String le;
    private xk lp;
    private String ls;
    private boolean lw;

    /* renamed from: m  reason: collision with root package name */
    private c f34738m;
    private JSONObject mc;
    private int me;
    private int mk;

    /* renamed from: ms  reason: collision with root package name */
    private int f34739ms;
    private int mu;

    /* renamed from: n  reason: collision with root package name */
    private JSONObject f34740n;
    private yu nc;

    /* renamed from: o  reason: collision with root package name */
    private boolean f34741o;
    private JSONObject oh;
    private ia pr;
    private String ps;
    private int pu;
    private String py;

    /* renamed from: q  reason: collision with root package name */
    private ys f34744q;
    private int qf;
    private volatile JSONObject qq;
    private String qy;
    private String rd;
    private String rg;
    private String rh;
    private int sr;
    private p st;

    /* renamed from: t  reason: collision with root package name */
    private String f34747t;
    private wx tc;
    private int te;
    private mt tl;
    private ls tn;
    private bm tx;
    private t tz;

    /* renamed from: u  reason: collision with root package name */
    private sr f34748u;
    private ba up;
    private gb ux;
    private int uy;

    /* renamed from: v  reason: collision with root package name */
    private String f34749v;
    private int vb;
    private pr vc;
    private bk vj;
    private ux vt;

    /* renamed from: w  reason: collision with root package name */
    public String f34750w;
    private int wo;
    private JSONObject wq;
    private int wt;
    private boolean wv;
    private boolean wx;

    /* renamed from: x  reason: collision with root package name */
    private c f34751x;
    private int xg;
    private boolean xk;
    private int xq;
    private b xt;
    private String xu;
    private com.bytedance.sdk.openadsdk.core.dislike.xv.w xv;
    private String xw;

    /* renamed from: y  reason: collision with root package name */
    private int f34752y;
    private k ya;
    private long ys;
    private boolean yx;

    /* renamed from: z  reason: collision with root package name */
    private long f34753z;
    private String zb;
    private String zg;
    private long zt;

    /* renamed from: r  reason: collision with root package name */
    private int f34745r = -1;

    /* renamed from: p  reason: collision with root package name */
    private List<gb> f34742p = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private List<String> f34726a = new ArrayList();
    private List<String> bk = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private String f34746s = "0";
    private String fz = "0";
    private int yu = -1;
    private int mt = 2;
    private int oo = -200;
    private int au = 0;
    private r bj = new r();
    private int ox = 1;
    private int ng = 0;
    private int ok = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f34733h = 0;
    private int fm = 1;
    private int ge = 0;
    private int ta = 0;
    private int eu = 0;
    private int be = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f34732g = 0;
    private int bs = 1;
    private int lf = 0;
    private int kk = 1;
    private boolean zr = false;
    private int yn = 1;
    private float yh = 100.0f;
    private int kr = 0;
    private int pb = 2;
    private int jd = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f34737l = 100;
    private int nd = 2;
    private int ny = 2;
    private float qu = 0.07f;
    private float cf = 0.0f;
    private int uj = -1;
    private long nb = 0;
    private boolean ve = true;

    /* renamed from: pl  reason: collision with root package name */
    private int f34743pl = -1;
    private int za = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private String f34754c;
        private String ev;

        /* renamed from: f  reason: collision with root package name */
        private String f34755f;
        private String gd;

        /* renamed from: k  reason: collision with root package name */
        private String f34756k;

        /* renamed from: p  reason: collision with root package name */
        private String f34757p;

        /* renamed from: r  reason: collision with root package name */
        private String f34758r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f34759w;
        private String xv;

        public boolean a() {
            return !TextUtils.isEmpty(this.f34757p);
        }

        public String c() {
            return this.f34755f;
        }

        public String ev() {
            return this.f34756k;
        }

        public String f() {
            return this.ux;
        }

        public String gd() {
            return this.ev;
        }

        public String k() {
            return this.f34757p;
        }

        public String p() {
            return this.gd;
        }

        public String r() {
            return this.f34758r;
        }

        public String sr() {
            return this.xv;
        }

        public String ux() {
            return this.sr;
        }

        public String w() {
            return this.f34754c;
        }

        public String xv() {
            return this.f34759w;
        }

        public void c(String str) {
            this.f34755f = str;
        }

        public void ev(String str) {
            this.f34756k = str;
        }

        public void f(String str) {
            this.ux = str;
        }

        public void gd(String str) {
            this.ev = str;
        }

        public void k(String str) {
            this.f34757p = str;
        }

        public void p(String str) {
            this.gd = str;
        }

        public void r(String str) {
            this.f34758r = str;
        }

        public void sr(String str) {
            this.xv = str;
        }

        public void ux(String str) {
            this.sr = str;
        }

        public void w(String str) {
            this.f34754c = str;
        }

        public void xv(String str) {
            this.f34759w = str;
        }
    }

    private float vk() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 5.0f;
        }
        return mtVar.ys();
    }

    public long a() {
        return this.zt;
    }

    public int ab() {
        return this.f34730e;
    }

    public int al() {
        return this.ba;
    }

    public int au() {
        return this.f34727b;
    }

    public int ax() {
        return this.ta;
    }

    public int b() {
        return this.fm;
    }

    public m ba() {
        return this.gw;
    }

    public b bb() {
        return this.xt;
    }

    public int be() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 0;
        }
        return mtVar.ev();
    }

    public int bj() {
        return this.wo;
    }

    public String bk() {
        return this.eb;
    }

    public int bm() {
        return this.oo;
    }

    public yu bn() {
        return this.nc;
    }

    public int bs() {
        return this.f34729d;
    }

    public oo bw() {
        return this.jw;
    }

    public boolean bx() {
        if (ve() != null) {
            return ve().ux();
        }
        return false;
    }

    public int c() {
        return this.jm;
    }

    public String cf() {
        return this.gb;
    }

    public int ck() {
        return this.f34752y;
    }

    public int co() {
        if (this.sr == 4 && TextUtils.isEmpty(this.xu)) {
            return this.jr;
        }
        return 0;
    }

    public s d() {
        return this.f34734i;
    }

    public List<String> db() {
        return this.f34726a;
    }

    public ls dc() {
        return this.tn;
    }

    public boolean dd() {
        return this.lf == 1;
    }

    public boolean df() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this)) {
            return true;
        }
        if (this.f34742p.isEmpty()) {
            return false;
        }
        if (this.f34735j != 4 || this.f34742p.size() >= 3) {
            for (gb gbVar : this.f34742p) {
                if (!gbVar.ux()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String dk() {
        return this.ia;
    }

    public boolean ds() {
        return jw() == 1;
    }

    public ba du() {
        return this.up;
    }

    public int e() {
        bm bmVar = this.tx;
        if (bmVar == null) {
            return 2;
        }
        return bmVar.c();
    }

    public int eb() {
        up upVar = this.ab;
        if (upVar == null) {
            return 90;
        }
        return upVar.xv();
    }

    public z ed() {
        return this.db;
    }

    public float ee() {
        float f4 = this.qu;
        if (f4 < 0.07f || f4 > 0.175f) {
            this.qu = 0.07f;
        }
        return this.qu;
    }

    public int ek() {
        return this.xq;
    }

    public boolean em() {
        return ax() == 1;
    }

    public int eq() {
        return this.ng;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        me meVar = (me) obj;
        return this.f34746s.equals(meVar.f34746s) && this.gb.equals(meVar.gb);
    }

    public String eu() {
        mt mtVar = this.tl;
        return mtVar == null ? "\u70b9\u51fb\u67e5\u770b" : mtVar.k();
    }

    public String ev() {
        return this.py;
    }

    public String ez() {
        if (!TextUtils.isEmpty(this.f34749v)) {
            this.f34749v = this.f34749v.trim();
        }
        return this.f34749v;
    }

    public String f() {
        return this.le;
    }

    public int fh() {
        if (this.yn != 2) {
            this.yn = 1;
        }
        return this.yn;
    }

    public int fm() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 82;
        }
        return mtVar.f();
    }

    public boolean fn() {
        return this.xk;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp() {
        return this.ee;
    }

    public String fz() {
        return this.kn;
    }

    public int g() {
        return this.ix;
    }

    public int gb() {
        return this.ny;
    }

    public String gd() {
        return this.fh;
    }

    public int ge() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 0;
        }
        return mtVar.gd();
    }

    public mt gp() {
        return this.tl;
    }

    public int gw() {
        return this.ok;
    }

    public int h() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 50;
        }
        return mtVar.sr();
    }

    public int hashCode() {
        return (this.f34746s.hashCode() * 31) + this.gb.hashCode();
    }

    public boolean hc() {
        return this.zr;
    }

    public long hk() {
        return this.nb;
    }

    public bw hl() {
        return this.ky;
    }

    public String ho() {
        return this.al;
    }

    public int ht() {
        return this.mk;
    }

    public int hv() {
        if (this.pu < 0) {
            this.pu = 0;
        }
        if (this.pu > 10000) {
            this.pu = 10000;
        }
        return this.pu;
    }

    public boolean i() {
        return this.f34741o;
    }

    public String ia() {
        return this.rh;
    }

    public String ib() {
        return this.xu;
    }

    public i il() {
        return this.df;
    }

    public String iu() {
        return this.jv;
    }

    public ia iw() {
        return this.pr;
    }

    public sr ix() {
        return this.f34748u;
    }

    public String iy() {
        return hashCode() + xq();
    }

    public long j() {
        return this.gp;
    }

    public boolean ja() {
        return this.bn;
    }

    public String jd() {
        return this.ev;
    }

    public boolean jg() {
        return this.ve;
    }

    public JSONObject jk() {
        return this.wq;
    }

    public q jm() {
        return this.bx;
    }

    public String jr() {
        return this.f34746s;
    }

    public String ju() {
        return this.fp;
    }

    public int jv() {
        return this.dd;
    }

    public int jw() {
        return this.ge;
    }

    public int jy() {
        return this.za;
    }

    public JSONObject k() {
        return this.qq;
    }

    public int kk() {
        bm bmVar = this.tx;
        if (bmVar == null) {
            return 30;
        }
        return bmVar.xv();
    }

    public com.bytedance.sdk.component.adexpress.c.xv.sr kn() {
        if (qy() == null) {
            return null;
        }
        String w3 = qy().w();
        String sr = qy().sr();
        String xv = qy().xv();
        String ux = qy().ux();
        String c4 = qy().c();
        int gd = com.bytedance.sdk.openadsdk.core.eq.wv.gd(this);
        com.bytedance.sdk.component.adexpress.c.xv.sr ux2 = com.bytedance.sdk.component.adexpress.c.xv.sr.c().c(w3).w(xv).xv(sr).sr(ux).ux(c4);
        return ux2.f(gd + "");
    }

    public int kp() {
        return this.wt;
    }

    public gb kr() {
        return this.ux;
    }

    public int ku() {
        JSONObject jSONObject = this.gd;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public String kw() {
        return this.ps;
    }

    public String ky() {
        return this.f34736k;
    }

    public JSONObject l() {
        return this.gd;
    }

    public int ld() {
        return this.f34732g;
    }

    public boolean le() {
        return ht() != 1;
    }

    public mt.w lf() {
        mt mtVar = this.tl;
        if (mtVar != null) {
            return mtVar.a();
        }
        return null;
    }

    public long lp() {
        return this.f34753z;
    }

    public int ls() {
        return this.vb;
    }

    public com.bytedance.sdk.component.adexpress.c.xv.sr lw() {
        if (rh() == null) {
            return null;
        }
        String w3 = rh().w();
        String sr = rh().sr();
        String xv = rh().xv();
        String ux = rh().ux();
        String c4 = rh().c();
        int gd = com.bytedance.sdk.openadsdk.core.eq.wv.gd(this);
        com.bytedance.sdk.component.adexpress.c.xv.sr ux2 = com.bytedance.sdk.component.adexpress.c.xv.sr.c().c(w3).w(xv).xv(sr).sr(ux).ux(c4);
        return ux2.f(gd + "");
    }

    public int m() {
        return this.f34743pl;
    }

    public int mc() {
        return this.ju;
    }

    public boolean me() {
        return this.ng == 1;
    }

    public ng mk() {
        return this.eq;
    }

    public pr mm() {
        return this.vc;
    }

    public JSONObject mo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", qq());
            jSONObject.put("ad_rec_stamp", hk());
            jSONObject.put("interaction_type", v());
            jSONObject.put("target_url", pu());
            jSONObject.put("use_media_video_player", z());
            jSONObject.put("landing_scroll_percentage", pb());
            jSONObject.put("gecko_id", jd());
            jSONObject.put("extension", l());
            jSONObject.put("ad_id", jr());
            jSONObject.put("source", yh());
            jSONObject.put("package_name", vt());
            jSONObject.put("screenshot", vj());
            jSONObject.put("play_bar_style", up());
            jSONObject.put("play_bar_show_time", bm());
            jSONObject.put("if_block_lp", eq());
            jSONObject.put("cache_sort", b());
            jSONObject.put("if_sp_cache", wo());
            jSONObject.put("splash_timeout_stage", ox());
            jSONObject.put("render_control", y());
            jSONObject.put("is_from_local_cache", fn());
            jSONObject.put("is_from_cache_type", xt());
            jSONObject.put("no_video_concat", c());
            jSONObject.put("no_land_btn", w());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", n());
            jSONObject2.put("other", gb());
            jSONObject.put("set_click_type", jSONObject2);
            gb kr = kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", kr.c());
                jSONObject3.put("height", kr.xv());
                jSONObject3.put("width", kr.w());
                jSONObject.put(RewardPlus.ICON, jSONObject3);
            }
            JSONObject ya = ya();
            if (ya != null) {
                jSONObject.put("session_params", ya);
            }
            r mt = mt();
            if (mt != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", mt.f34813c);
                jSONObject4.put("click_upper_non_content_area", mt.f34815w);
                jSONObject4.put("click_lower_content_area", mt.xv);
                jSONObject4.put("click_lower_non_content_area", mt.sr);
                jSONObject4.put("click_button_area", mt.ux);
                jSONObject4.put("click_video_area", mt.f34814f);
                jSONObject.put("click_area", jSONObject4);
            }
            com.bytedance.sdk.openadsdk.ys.w.xv.w oo = oo();
            if (oo != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.eq.n.c(oo));
            }
            List<gb> nc = nc();
            if (nc != null) {
                JSONArray jSONArray = new JSONArray();
                for (gb gbVar : nc) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", gbVar.c());
                    jSONObject5.put("height", gbVar.xv());
                    jSONObject5.put("width", gbVar.w());
                    jSONObject5.put("image_preview", gbVar.f());
                    jSONObject5.put("image_key", gbVar.r());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> db = db();
            if (db != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : db) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> nd = nd();
            if (nd != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : nd) {
                    jSONArray3.put(str2);
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, jSONArray3);
            }
            jSONObject.put("phone_num", ky());
            jSONObject.put("title", ny());
            jSONObject.put("download_num", tx());
            jSONObject.put("description", ju());
            jSONObject.put("ext", cf());
            jSONObject.put("req_id", xq());
            jSONObject.put("image_mode", tz());
            jSONObject.put("intercept_flag", au());
            jSONObject.put("web_inspector", bj());
            jSONObject.put("button_text", dk());
            jSONObject.put("ad_logo", vc());
            jSONObject.put("video_adaptation", gw());
            jSONObject.put("feed_video_opentype", x());
            jSONObject.put("feed_reward_type", m());
            jSONObject.put("orientation", fh());
            jSONObject.put("aspect_ratio", yx());
            jSONObject.put("aspect_margin", ee());
            jSONObject.put("corner_radius", rw());
            sr ix = ix();
            if (ix != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", ix.xv());
                jSONObject6.put("package_name", ix.sr());
                jSONObject6.put(DownloadModel.DOWNLOAD_URL, ix.w());
                jSONObject6.put("score", ix.ux());
                jSONObject6.put("comment_num", ix.f());
                jSONObject6.put("quick_app_url", ix.c());
                jSONObject6.put(CampaignEx.JSON_KEY_APP_SIZE, ix.r());
                jSONObject.put("app", jSONObject6);
            }
            s d4 = d();
            if (d4 != null) {
                jSONObject.put("download_sdk_conf", d4.xv());
            }
            if (ba() != null) {
                ba().w(jSONObject);
            }
            if (mm() != null) {
                mm().c(jSONObject);
            }
            if (qu() != null) {
                qu().c(jSONObject);
            }
            if (ve() != null) {
                ve().c(jSONObject);
            }
            if (wv() != null) {
                wv().c(jSONObject);
            }
            if (wx() != null) {
                wx().c(jSONObject);
            }
            if (pr() != null) {
                pr().c(jSONObject);
            }
            if (bn() != null) {
                bn().c(jSONObject);
            }
            if (bw() != null) {
                bw().c(jSONObject);
            }
            if (pl() != null) {
                pl().c(jSONObject);
            }
            if (hl() != null) {
                hl().c(jSONObject);
            }
            jSONObject.put("count_down", al());
            jSONObject.put("expiration_time", lp());
            jSONObject.put("_child_metas", yz());
            jSONObject.put("player_type", ou());
            jSONObject.put("video_encode_type", yn());
            jSONObject.put("feed_video_finish_type", ck());
            if (mk() != null) {
                mk().c(jSONObject);
            }
            if (iw() != null) {
                iw().c(jSONObject);
            }
            jSONObject.put("if_both_open", jw());
            jSONObject.put("if_double_deeplink", ax());
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("splash_clickarea", xu());
            jSONObject7.put("splash_clicktext", ng());
            jSONObject7.put("area_height", h());
            jSONObject7.put("area_width", oh());
            jSONObject7.put("area_blank_height", fm());
            jSONObject7.put("half_blank_height", te());
            jSONObject7.put("splash_style_id", ge());
            jSONObject7.put("btn_background_dest_color", ta());
            jSONObject7.put("top_splash_clicktext", eu());
            jSONObject7.put("splash_load_time_optimization", be());
            jSONObject7.put("text_config", lf() != null ? lf().c() : null);
            jSONObject7.put("top_text_config", xg() != null ? xg().c() : null);
            jSONObject7.put("sliding_distance", vk());
            jSONObject7.put("slide_area", mu() != null ? mu().ux() : null);
            jSONObject.put("splash_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("position", e());
            jSONObject8.put("left_or_right_margin", tl());
            jSONObject8.put("top_or_bottom_margin", kk());
            bm bmVar = this.tx;
            jSONObject8.put("skip_style", bmVar == null ? 1 : bmVar.sr());
            jSONObject.put("skip_control", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("show_type", zr());
            jSONObject9.put("blank", zt());
            jSONObject9.put("half_blank", eb());
            jSONObject.put("splash_compliance_bar", jSONObject9);
            if (tc() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = tc().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            jSONObject.put("landing_page_type", xw());
            c rh = rh();
            if (rh != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("id", rh.w());
                jSONObject11.put("md5", rh.xv());
                jSONObject11.put("url", rh.sr());
                jSONObject11.put("data", rh.ux());
                jSONObject11.put("diff_data", rh.f());
                jSONObject11.put("version", rh.c());
                jSONObject11.put("dynamic_creative", rh.r());
                jSONObject11.put("material_type", rh.ev());
                jSONObject11.put("ugen_url", rh.gd());
                jSONObject11.put("ugen_md5", rh.p());
                jSONObject11.put("engine_version", rh.k());
                jSONObject.put("tpl_info", jSONObject11);
            }
            c qy = qy();
            if (qy != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("middle_id", qy.w());
                jSONObject12.put("middle_md5", qy.xv());
                jSONObject12.put("middle_url", qy.sr());
                jSONObject12.put("middle_data", qy.ux());
                jSONObject12.put("middle_diff_data", qy.f());
                jSONObject12.put("middle_version", qy.c());
                jSONObject12.put("middle_dynamic_creative", qy.r());
                jSONObject.put("middle_tpl_info", jSONObject12);
            }
            jSONObject.put("page_render_type", t());
            jSONObject.put("promotion_type", ls());
            jSONObject.put("if_lpua_package", this.hv);
            com.bytedance.sdk.openadsdk.core.ugeno.f.c ys = ys();
            if (ys != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", ys.c());
                jSONObject13.put("md5", ys.w());
                jSONObject13.put("url", ys.xv());
                jSONObject13.put("scene", ys.sr());
                jSONObject.put("ugeno", jSONObject13);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp = fp();
            if (fp != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("product_infos", fp.c());
                jSONObject14.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, fp.w());
                jSONObject14.put("render_config", fp.xv());
                jSONObject14.put("live_room_data", fp.sr());
                jSONObject.put("dylite_info", jSONObject14);
            }
            jSONObject.put("native_lp_data", f());
            jSONObject.put("native_lp_tpl_id", r());
            jSONObject.put("native_lp_ugen_url", ev());
            jSONObject.put("native_lp_ugen_md5", gd());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, ux());
            jSONObject.put("native_lp_is_preload", p());
            if (p()) {
                jSONObject.put("native_lp_content", k());
            }
            jSONObject.put("market_url", ib());
            jSONObject.put("close_on_dislike", hc());
            ux zg = zg();
            if (zg != null) {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("developer_name", zg.r());
                jSONObject15.put("app_version", zg.ux());
                jSONObject15.put(TTDelegateActivity.INTENT_PERMISSIONS, zg.p());
                jSONObject15.put("privacy_policy_url", zg.ev());
                jSONObject15.put("package_name", zg.k());
                jSONObject15.put("app_name", zg.a());
                jSONObject15.put("score", zg.xv());
                jSONObject15.put("creative_tags", zg.sr());
                jSONObject15.put("permissions_url", zg.w());
                jSONObject15.put("desc_url", zg.gd());
                jSONObject.put("app_manage", jSONObject15);
            }
            i il = il();
            if (il != null) {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("ugen_dialog_url", il.w());
                jSONObject16.put("ugen_dialog_md5", il.xv());
                jSONObject16.put("dialog_style", il.c());
                jSONObject.put("easy_dl_dialog", jSONObject16);
            }
            if (tn() != null) {
                jSONObject.put("easy_pl_material", tn());
            }
            jSONObject.put("app_manage_type", rd());
            jSONObject.put("lp_down_rule", jv() == 1 ? 1 : 0);
            JSONObject jSONObject17 = new JSONObject();
            jSONObject17.put("render_sequence", ld());
            jSONObject17.put("valid_uchain", rg());
            jSONObject17.put("backup_render_control", nb());
            jSONObject17.put("render_thread", vb());
            jSONObject17.put("reserve_time", st());
            jSONObject.put("render", jSONObject17);
            jSONObject.put("auction_price", iu());
            jSONObject.put(BidResponsed.KEY_PRICE, q());
            jSONObject.put("ad_info", py());
            jSONObject.put("adx_name", ez());
            jSONObject.put("no_default_ttdsp_price", ht());
            jSONObject.put("endcard_close_time", uy());
            jSONObject.put("proportion_watching", wq());
            jSONObject.put("render_delay_time", hv());
            jSONObject.put("video_skip_result", sc());
            jSONObject.put("shake_value", mc());
            jSONObject.put("deep_shake_value", co());
            jSONObject.put("rotation_angle", za());
            jSONObject.put("calculation_method", g());
            jSONObject.put("calculation_method_twist", bs());
            jSONObject.put("show_poll_time", ek());
            jSONObject.put("dynamic_join_type", ab());
            jSONObject.put("click_send_type", of());
            jSONObject.put("cache_ext", bk());
            jSONObject.put("cache_time", a());
            jSONObject.put("req_id", ia());
            jSONObject.put("is_cache", s());
            jSONObject.put("log_ext", fz());
            jSONObject.put("material_key", u());
            jSONObject.put("need_get_materials", i());
            jSONObject.put("s_send_ts", j());
            ok okVar = this.f34728c;
            if (okVar != null) {
                jSONObject.put("wc_miniapp_info", okVar.gd());
            }
            p ut = ut();
            if (ut != null) {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("click_trigger_type", ut.c());
                jSONObject18.put("shake_start_time", ut.w());
                jSONObject18.put("shake_end_time", ut.xv());
                jSONObject.put("click_trigger_config", jSONObject18);
            }
        } catch (Exception unused) {
        }
        if (du() != null) {
            du().c(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", yw());
            jSONObject.put("live_interaction_type", kp());
            jSONObject.put("ec_schema", xk());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("ecom_live_params", ho());
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        n yr = yr();
        if (yr != null) {
            yr.c(jSONObject);
        }
        fz ym = ym();
        if (ym != null) {
            ym.c(jSONObject);
        }
        z ed = ed();
        if (ed != null) {
            try {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("reward_live_deep_link_user_id", ed.c());
                jSONObject19.put("reward_live_deep_link_request_id", ed.f());
                jSONObject19.put("reward_live_deep_link_room_id", ed.w());
                jSONObject19.put("reward_live_last_time", ed.ux());
                jSONObject19.put("reawrd_live_short_touch_params", ed.xv());
                jSONObject19.put("reawrd_live_extra_pangle_scheme_params", ed.sr());
                jSONObject.put("reward_live_deep_link_params", jSONObject19);
            } catch (Exception unused2) {
            }
        }
        t ti = ti();
        if (ti != null) {
            try {
                JSONObject jSONObject20 = new JSONObject();
                jSONObject20.put("style_type", ti.c());
                jSONObject20.put(CampaignEx.JSON_KEY_IMAGE_URL, ti.w());
                jSONObject20.put("position", ti.xv());
                jSONObject20.put("image_height", ti.sr());
                jSONObject20.put("image_scale_rate", ti.f());
                jSONObject20.put("image_gif_url", ti.ux());
                jSONObject20.put("image_gif_aspect_ratio", ti.r());
                jSONObject.put("dynamic_join_coupon_style", jSONObject20);
            } catch (Exception unused3) {
            }
        }
        bk ue = ue();
        if (ue != null) {
            try {
                jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, ue.c());
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        y sk = sk();
        if (sk != null) {
            try {
                jSONObject.put("live_info", sk.c());
            } catch (JSONException unused4) {
            }
        }
        xk nh = nh();
        if (nh != null) {
            try {
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("group_id", nh.c());
                jSONObject21.put("group_tag", nh.w());
                jSONObject21.put("card_tag", nh.xv());
                jSONObject.put("group_info", jSONObject21);
            } catch (Exception unused5) {
            }
        }
        b bb = bb();
        if (bb != null) {
            try {
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("video_adapter_type", bb.c());
                jSONObject22.put("video_mute_type", bb.w());
                jSONObject.put("video_config", jSONObject22);
            } catch (Exception unused6) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", ja());
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("dynamic_configs", my());
            String kw = kw();
            if (!TextUtils.isEmpty(kw)) {
                jSONObject.put("gnd_prefetch_cache_key", kw);
                jSONObject.put("gnd_prefetch_timing", jy());
            }
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("twist_config", jk());
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        this.tn.w(jSONObject);
        return jSONObject;
    }

    public int ms() {
        return fp.ev(this);
    }

    public r mt() {
        return this.bj;
    }

    public mt.c mu() {
        mt mtVar = this.tl;
        if (mtVar != null) {
            return mtVar.t();
        }
        return null;
    }

    public String my() {
        return this.iu;
    }

    public int n() {
        return this.nd;
    }

    public int nb() {
        return this.bs;
    }

    public List<gb> nc() {
        return this.f34742p;
    }

    public List<String> nd() {
        return this.bk;
    }

    public String ng() {
        mt mtVar = this.tl;
        return mtVar == null ? "" : mtVar.w();
    }

    public xk nh() {
        return this.lp;
    }

    public bm nk() {
        return this.tx;
    }

    public String ny() {
        return this.f34747t;
    }

    public String o() {
        return this.xw;
    }

    public int of() {
        return this.qf == 1 ? 1 : 0;
    }

    public int oh() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 236;
        }
        return mtVar.ux();
    }

    public boolean ok() {
        mt mtVar = this.tl;
        return mtVar == null || mtVar.xv();
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w oo() {
        return this.bm;
    }

    public int ou() {
        return this.jd;
    }

    public int ox() {
        return this.kk;
    }

    public int oz() {
        return this.uj;
    }

    public boolean p() {
        return this.yx;
    }

    public int pb() {
        return this.f34745r;
    }

    public ck pl() {
        return this.ds;
    }

    public fp pr() {
        return this.ib;
    }

    public boolean ps() {
        int bk = com.bytedance.sdk.openadsdk.core.eq.wv.bk(this);
        return bk == 3 || bk == 6;
    }

    public String pu() {
        return this.f34731f;
    }

    public String py() {
        return this.rd;
    }

    public String q() {
        return this.iw;
    }

    public boolean qf() {
        return this.wx;
    }

    public String qq() {
        return this.rg;
    }

    public ys qu() {
        return this.f34744q;
    }

    public c qy() {
        return this.f34738m;
    }

    public int r() {
        return this.ht;
    }

    public int rd() {
        return this.ld;
    }

    public int rg() {
        return this.lf;
    }

    public c rh() {
        return this.f34751x;
    }

    public float rw() {
        float f4 = this.cf;
        if (f4 < 0.0f || f4 > 50.0f) {
            this.cf = 0.0f;
        }
        return this.cf;
    }

    public boolean s() {
        return this.lw;
    }

    public int sc() {
        if (com.bytedance.sdk.openadsdk.core.ls.w().zt()) {
            return 3;
        }
        return this.pb;
    }

    public ok si() {
        return this.f34728c;
    }

    public y sk() {
        return this.fn;
    }

    public boolean sr() {
        return this.f34739ms == 1;
    }

    public int st() {
        return this.mu;
    }

    public int t() {
        if (fp.sr(this)) {
            return 0;
        }
        return this.hl;
    }

    public String ta() {
        mt mtVar = this.tl;
        return mtVar == null ? "#008DEA" : mtVar.p();
    }

    public Map<String, Object> tc() {
        return this.bw;
    }

    public int te() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 56;
        }
        return mtVar.r();
    }

    public t ti() {
        return this.tz;
    }

    public int tl() {
        bm bmVar = this.tx;
        if (bmVar == null) {
            return 16;
        }
        return bmVar.w();
    }

    public JSONObject tn() {
        return this.mc;
    }

    public long tx() {
        return this.ys;
    }

    public int tz() {
        return this.f34735j;
    }

    public String u() {
        return this.zg;
    }

    public bk ue() {
        return this.vj;
    }

    public String uj() {
        try {
            return wt().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int up() {
        if (yx() != 100.0f || y() == 2) {
            return 0;
        }
        return this.au;
    }

    public p ut() {
        return this.st;
    }

    public String ux() {
        return this.hk;
    }

    public int uy() {
        return this.kr;
    }

    public int v() {
        return this.sr;
    }

    public int vb() {
        return this.xg;
    }

    public int vc() {
        return this.ox;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.xv.w ve() {
        com.bytedance.sdk.openadsdk.core.dislike.c.c();
        return this.xv;
    }

    public boolean vj() {
        return this.wv;
    }

    public String vt() {
        return this.f34750w;
    }

    public int w() {
        return this.f34739ms;
    }

    public int wo() {
        return this.te;
    }

    public int wq() {
        return this.f34737l;
    }

    public JSONObject wt() {
        if (this.f34740n == null) {
            try {
                if (!TextUtils.isEmpty(this.gb)) {
                    this.f34740n = new JSONObject(this.gb);
                }
            } catch (JSONException unused) {
            }
        }
        return this.f34740n;
    }

    public wx wv() {
        return this.tc;
    }

    public k wx() {
        return this.ya;
    }

    public up wy() {
        return this.ab;
    }

    public int x() {
        return this.f34733h;
    }

    public mt.w xg() {
        mt mtVar = this.tl;
        if (mtVar != null) {
            return mtVar.bk();
        }
        return null;
    }

    public String xk() {
        return this.ez;
    }

    public String xq() {
        return this.ck;
    }

    public int xt() {
        return this.yu;
    }

    public int xu() {
        mt mtVar = this.tl;
        if (mtVar == null) {
            return 1;
        }
        return mtVar.c();
    }

    public boolean xv() {
        return this.jm == 1;
    }

    public int xw() {
        return this.be;
    }

    public int y() {
        return this.mt;
    }

    public JSONObject ya() {
        return this.oh;
    }

    public String yh() {
        return this.ls;
    }

    public fz ym() {
        return this.ax;
    }

    public int yn() {
        return this.me;
    }

    public n yr() {
        return this.em;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.f.c ys() {
        return this.ed;
    }

    public int yu() {
        return this.uy;
    }

    public String yw() {
        return this.zb;
    }

    public float yx() {
        if (this.yh <= 0.0f) {
            this.yh = 100.0f;
        }
        return (this.yh * 1000.0f) / 1000.0f;
    }

    public String yz() {
        return this.ku;
    }

    public int z() {
        return this.eu;
    }

    public int za() {
        return this.dk;
    }

    public String zb() {
        return this.fz;
    }

    public ux zg() {
        return this.vt;
    }

    public int zr() {
        up upVar = this.ab;
        if (upVar == null) {
            return 0;
        }
        return upVar.c();
    }

    public int zt() {
        up upVar = this.ab;
        if (upVar == null) {
            return 90;
        }
        return upVar.w();
    }

    public static JSONObject ux(me meVar) {
        if (meVar != null) {
            try {
                return meVar.mo();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public void a(int i4) {
        this.f34743pl = i4;
    }

    public void au(int i4) {
        this.pu = i4;
    }

    public void b(int i4) {
        if (i4 == Integer.MIN_VALUE) {
            i4 = com.bytedance.sdk.openadsdk.core.eq.wv.ev(this) == 3 ? 500 : 1000;
        }
        this.xq = i4 >= 500 ? i4 > 3000 ? 3000 : i4 : 500;
    }

    public void ba(int i4) {
        this.f34730e = i4;
    }

    public void bj(int i4) {
        if (i4 < 0 || i4 > 100) {
            return;
        }
        this.f34737l = i4;
    }

    public void bk(int i4) {
        this.ok = i4;
    }

    public void bm(int i4) {
        this.jd = i4;
    }

    public void bw(int i4) {
        this.bs = i4;
    }

    public void c(int i4) {
        this.jm = i4;
    }

    public void ck(int i4) {
        this.sr = i4;
    }

    public void eq(int i4) {
        this.ba = i4;
    }

    public void ev(String str) {
        this.zg = str;
    }

    public void f(String str) {
        this.rh = str;
    }

    public void fp(int i4) {
        this.f34727b = i4;
    }

    public void fz(int i4) {
        this.fm = i4;
    }

    public void gb(int i4) {
        if (i4 != 1) {
            i4 = 0;
        }
        this.dd = i4;
    }

    public void gd(String str) {
        this.iw = str;
    }

    public void gw(int i4) {
        this.mk = i4;
    }

    public void h(int i4) {
        this.za = i4;
    }

    public void i(int i4) {
        this.kk = i4;
    }

    public void ia(int i4) {
        this.wo = i4;
    }

    public void j(int i4) {
        this.f34729d = i4;
    }

    public void k(String str) {
        this.ez = str;
    }

    public void ls(int i4) {
        this.ld = i4;
    }

    public void m(int i4) {
        this.mu = i4;
    }

    public void me(int i4) {
        this.yu = i4;
    }

    public void mt(int i4) {
        if (i4 >= 0 && i4 <= 180) {
            this.dk = i4;
        } else {
            this.dk = 50;
        }
    }

    public void n(int i4) {
        this.me = i4;
    }

    public void ng(int i4) {
        this.uj = i4;
    }

    public void oh(int i4) {
        this.hv = i4;
    }

    public void ok(int i4) {
        this.jr = i4;
    }

    public void oo(int i4) {
        this.kr = i4;
    }

    public void ox(int i4) {
        this.qf = i4 != 1 ? 0 : 1;
    }

    public void p(String str) {
        this.qy = str;
    }

    public void pr(int i4) {
        this.lf = i4;
    }

    public void q(int i4) {
        this.ix = i4;
    }

    public void r(String str) {
        this.kn = str;
    }

    public void s(int i4) {
        this.oo = i4;
    }

    public void sr(String str) {
        this.fh = str;
    }

    public void u(int i4) {
        this.te = i4;
    }

    public void vc(int i4) {
        this.yn = i4;
    }

    public void w(int i4) {
        this.f34739ms = i4;
    }

    public void wo(int i4) {
        this.wt = i4;
    }

    public void wv(int i4) {
        this.ge = i4;
    }

    public void wx(int i4) {
        this.f34732g = i4;
    }

    public void x(int i4) {
        this.xg = i4;
    }

    public void xk(int i4) {
        this.ta = i4;
    }

    public void xu(int i4) {
        if (i4 >= 1 && i4 <= 9) {
            this.pb = i4;
        } else {
            this.pb = 3;
        }
    }

    public void xv(int i4) {
        this.ht = i4;
    }

    public void y(int i4) {
        this.f34735j = i4;
    }

    public void ys(int i4) {
        this.au = i4;
    }

    public void yu(int i4) {
        this.be = i4;
    }

    public void z(int i4) {
        this.f34745r = i4;
    }

    public static boolean sr(me meVar) {
        int ev;
        return (meVar == null || (ev = com.bytedance.sdk.openadsdk.core.eq.wv.ev(meVar)) == 8 || ev == 7 || meVar.rh() == null || Build.VERSION.SDK_INT > 27) ? false : true;
    }

    public void a(String str) {
        this.xw = str;
    }

    public void ba(String str) {
        this.f34749v = str;
    }

    public void bk(String str) {
        this.ls = str;
    }

    public void c(boolean z3) {
        this.il = z3;
        try {
            JSONObject wt = wt();
            wt.put("isDirectDownload", this.il);
            i(wt.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void ck(String str) {
        this.rd = str;
    }

    public void eq(String str) {
        this.zb = str;
    }

    public void ev(int i4) {
        this.mt = i4;
    }

    public void f(int i4) {
        this.f34752y = i4;
    }

    public void fp(String str) {
        this.f34736k = str;
    }

    public void fz(String str) {
        this.ia = str;
    }

    public void gb(String str) {
        this.f34750w = str;
    }

    public void gd(int i4) {
        this.ng = i4;
    }

    public void i(String str) {
        this.gb = str;
    }

    public void ia(String str) {
        this.f34747t = str;
    }

    public void j(String str) {
        this.fz = str;
    }

    public void k(int i4) {
        this.f34733h = i4;
    }

    public void ls(String str) {
        this.xu = str;
    }

    public void me(String str) {
        this.al = str;
    }

    public void n(String str) {
        this.jv = str;
    }

    public void p(int i4) {
        this.uy = i4;
    }

    public void q(String str) {
        this.ck = str;
    }

    public void r(int i4) {
        this.eu = i4;
    }

    public void s(String str) {
        this.fp = str;
    }

    public void t(int i4) {
        this.ox = i4;
    }

    public void u(String str) {
        this.f34746s = str;
    }

    public void up(int i4) {
        if (i4 < 12) {
            i4 = 12;
        }
        if (i4 > 20) {
            i4 = 20;
        }
        this.ju = i4;
    }

    public void w(String str) {
        this.le = str;
    }

    public void wv(String str) {
        this.ku = str;
    }

    public void xk(String str) {
        this.ps = str;
    }

    public void xv(String str) {
        this.py = str;
    }

    public void y(String str) {
        this.iu = str;
    }

    public void ys(String str) {
        this.ev = str;
    }

    public void z(String str) {
        this.rg = str;
    }

    public static boolean xv(me meVar) {
        try {
            if (meVar.ya() != null) {
                return meVar.ya().optInt("parent_type") == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void ev(boolean z3) {
        this.bn = z3;
    }

    public void f(boolean z3) {
        this.xk = z3;
    }

    public void gd(boolean z3) {
        this.zr = z3;
    }

    public void p(boolean z3) {
        this.ve = z3;
    }

    public void r(boolean z3) {
        this.wx = z3;
    }

    public void t(String str) {
        this.f34731f = str;
    }

    public void w(boolean z3) {
        this.yx = z3;
    }

    public static boolean f(me meVar) {
        return meVar != null && meVar.hv == 1;
    }

    public static boolean w(me meVar) {
        if (meVar == null) {
            return false;
        }
        return meVar.tz() == 5 || meVar.tz() == 15 || meVar.tz() == 166;
    }

    public void sr(int i4) {
        this.hl = i4;
    }

    public void ux(String str) {
        this.eb = str;
    }

    public void xv(boolean z3) {
        this.lw = z3;
    }

    public void sr(boolean z3) {
        this.f34741o = z3;
    }

    public void ux(int i4) {
        this.vb = i4;
    }

    public void xv(long j4) {
        this.ys = j4;
    }

    public void sr(long j4) {
        this.f34753z = j4;
    }

    public void ux(boolean z3) {
        this.wv = z3;
    }

    public void xv(JSONObject jSONObject) {
        this.oh = jSONObject;
    }

    public void c(String str) {
        this.hk = str;
    }

    public void sr(JSONObject jSONObject) {
        this.mc = jSONObject;
    }

    public void ux(long j4) {
        if (j4 != 0) {
            this.nb = j4;
        } else {
            this.nb = System.currentTimeMillis() / 1000;
        }
    }

    public void w(long j4) {
        this.gp = j4;
    }

    public void xv(float f4) {
        this.cf = f4;
    }

    public void c(JSONObject jSONObject) {
        this.qq = jSONObject;
    }

    public void w(double d4) {
        if (d4 != 2.0d && d4 != 1.0d) {
            this.nd = 2;
        } else {
            this.nd = (int) d4;
        }
    }

    public static boolean c(me meVar) {
        return meVar != null && meVar.z() == 1;
    }

    public void ux(JSONObject jSONObject) {
        this.wq = jSONObject;
    }

    public void c(long j4) {
        this.zt = j4;
    }

    public void w(c cVar) {
        this.f34738m = cVar;
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar) {
        this.ed = cVar;
    }

    public void w(JSONObject jSONObject) {
        this.gd = jSONObject;
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.gd.c cVar) {
        this.ee = cVar;
    }

    public void w(gb gbVar) {
        this.f34742p.add(gbVar);
    }

    public void c(double d4) {
        if (d4 != 2.0d && d4 != 1.0d) {
            this.ny = 2;
        } else {
            this.ny = (int) d4;
        }
    }

    public void w(float f4) {
        this.qu = f4;
    }

    public void c(m mVar) {
        this.gw = mVar;
    }

    public void c(wx wxVar) {
        this.tc = wxVar;
    }

    public void c(k kVar) {
        this.ya = kVar;
    }

    public void c(fp fpVar) {
        this.ib = fpVar;
    }

    public void c(oo ooVar) {
        this.jw = ooVar;
    }

    public void c(r rVar) {
        this.bj = rVar;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.bm = wVar;
    }

    public void c(c cVar) {
        this.f34751x = cVar;
        com.bytedance.sdk.component.adexpress.c.xv.sr lw = lw();
        if (lw != null && !this.f34751x.a()) {
            com.bytedance.sdk.component.adexpress.c.w.w.c(lw);
        }
        if (cVar == null || TextUtils.isEmpty(cVar.gd())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.f.c(cVar);
    }

    public void c(ia iaVar) {
        this.pr = iaVar;
    }

    public void c(mt mtVar) {
        this.tl = mtVar;
    }

    public void c(ux uxVar) {
        this.vt = uxVar;
    }

    public void c(ng ngVar) {
        this.eq = ngVar;
    }

    public void c(gb gbVar) {
        this.ux = gbVar;
    }

    public void c(sr srVar) {
        this.f34748u = srVar;
    }

    public void c(s sVar) {
        this.f34734i = sVar;
    }

    public void c(ys ysVar) {
        this.f34744q = ysVar;
    }

    public void c(Map<String, Object> map) {
        this.bw = map;
    }

    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        this.xv = wVar;
    }

    public void c(yu yuVar) {
        this.nc = yuVar;
    }

    public void c(ck ckVar) {
        this.ds = ckVar;
    }

    public void c(float f4) {
        this.yh = f4;
    }

    public void c(i iVar) {
        this.df = iVar;
        if (iVar != null) {
            String w3 = iVar.w();
            String xv = this.df.xv();
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.f.c(w3, xv);
        }
    }

    public void c(q qVar) {
        this.bx = qVar;
    }

    public void c(bw bwVar) {
        this.ky = bwVar;
    }

    public void c(z zVar) {
        this.db = zVar;
    }

    public void c(ok okVar) {
        this.f34728c = okVar;
    }

    public void c(bm bmVar) {
        this.tx = bmVar;
    }

    public void c(up upVar) {
        this.ab = upVar;
    }

    public void c(pr prVar) {
        this.vc = prVar;
    }

    public void c(bk bkVar) {
        this.vj = bkVar;
    }

    public void c(y yVar) {
        this.fn = yVar;
    }

    public void c(t tVar) {
        this.tz = tVar;
    }

    public void c(xk xkVar) {
        this.lp = xkVar;
    }

    public void c(b bVar) {
        this.xt = bVar;
    }

    public void c(p pVar) {
        this.st = pVar;
    }

    public void c(ba baVar) {
        this.up = baVar;
    }

    public void c(com.bykv.vk.openvk.component.video.api.xv.xv xvVar) {
        if (this.eq == null) {
            this.eq = new ng();
        }
        this.eq.c(xvVar);
    }

    public void c(n nVar) {
        this.em = nVar;
    }

    public void c(fz fzVar) {
        this.ax = fzVar;
    }

    public void c(ls lsVar) {
        this.tn = lsVar;
    }
}
