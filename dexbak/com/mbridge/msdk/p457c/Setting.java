package com.mbridge.msdk.p457c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.p461b.DspFilterUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.ActiveAppConfigEntity;
import com.mbridge.msdk.foundation.entity.AtfEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.JsonUtils;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.p457c.p458a.SettingConst;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.mbridge.msdk.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class Setting {

    /* renamed from: a */
    public static int f29712a = 1500;

    /* renamed from: A */
    private String f29713A;

    /* renamed from: B */
    private long f29714B;

    /* renamed from: C */
    private int f29715C;

    /* renamed from: D */
    private long f29716D;

    /* renamed from: E */
    private long f29717E;

    /* renamed from: F */
    private int f29718F;

    /* renamed from: G */
    private int f29719G;

    /* renamed from: H */
    private int f29720H;

    /* renamed from: I */
    private String f29721I;

    /* renamed from: J */
    private String f29722J;

    /* renamed from: K */
    private int f29723K;

    /* renamed from: L */
    private List<CampaignEx> f29724L;

    /* renamed from: M */
    private List<AtfEntity> f29725M;

    /* renamed from: Q */
    private int f29729Q;

    /* renamed from: aB */
    private String f29740aB;

    /* renamed from: aQ */
    private String f29755aQ;

    /* renamed from: aV */
    private JSONObject f29760aV;

    /* renamed from: aX */
    private int f29762aX;

    /* renamed from: aZ */
    private long f29764aZ;

    /* renamed from: af */
    private LinkedList<String> f29770af;

    /* renamed from: al */
    private int f29776al;

    /* renamed from: am */
    private List<String> f29777am;

    /* renamed from: an */
    private int f29778an;

    /* renamed from: ao */
    private int f29779ao;

    /* renamed from: ap */
    private int f29780ap;

    /* renamed from: aq */
    private int f29781aq;

    /* renamed from: ar */
    private String f29782ar;

    /* renamed from: as */
    private String f29783as;

    /* renamed from: bF */
    private List<ActiveAppConfigEntity> f29797bF;

    /* renamed from: bG */
    private String f29798bG;

    /* renamed from: bH */
    private String f29799bH;

    /* renamed from: bL */
    private ArrayList<Integer> f29803bL;

    /* renamed from: bM */
    private HashMap<String, String> f29804bM;

    /* renamed from: ba */
    private long f29812ba;

    /* renamed from: bb */
    private int f29813bb;

    /* renamed from: bc */
    private int f29814bc;

    /* renamed from: bd */
    private long f29815bd;

    /* renamed from: bf */
    private int f29817bf;

    /* renamed from: bx */
    private Map<String, C11193a> f29835bx;

    /* renamed from: bz */
    private C11194b f29837bz;

    /* renamed from: c */
    private String f29838c;

    /* renamed from: d */
    private long f29839d;

    /* renamed from: e */
    private int f29840e;

    /* renamed from: g */
    private int f29842g;

    /* renamed from: h */
    private boolean f29843h;

    /* renamed from: i */
    private Map<String, String> f29844i;

    /* renamed from: j */
    private boolean f29845j;

    /* renamed from: k */
    private long f29846k;

    /* renamed from: n */
    private boolean f29849n;

    /* renamed from: o */
    private long f29850o;

    /* renamed from: p */
    private long f29851p;

    /* renamed from: q */
    private long f29852q;

    /* renamed from: r */
    private boolean f29853r;

    /* renamed from: s */
    private int f29854s;

    /* renamed from: t */
    private int f29855t;

    /* renamed from: u */
    private int f29856u;

    /* renamed from: v */
    private long f29857v;

    /* renamed from: w */
    private int f29858w;

    /* renamed from: x */
    private int f29859x;

    /* renamed from: y */
    private int f29860y;

    /* renamed from: z */
    private int f29861z;

    /* renamed from: b */
    private int f29791b = 0;

    /* renamed from: f */
    private long f29841f = 86400;

    /* renamed from: l */
    private String f29847l = RequestUrlUtil.m22248a().f30793c;

    /* renamed from: m */
    private String f29848m = RequestUrlUtil.m22248a().f30794d;

    /* renamed from: N */
    private boolean f29726N = false;

    /* renamed from: O */
    private int f29727O = 3;

    /* renamed from: P */
    private boolean f29728P = true;

    /* renamed from: R */
    private JSONArray f29730R = new JSONArray();

    /* renamed from: S */
    private JSONArray f29731S = new JSONArray();

    /* renamed from: T */
    private int f29732T = 0;

    /* renamed from: U */
    private int f29733U = 0;

    /* renamed from: V */
    private int f29734V = 0;

    /* renamed from: W */
    private int f29735W = 3;

    /* renamed from: X */
    private int f29736X = 600;

    /* renamed from: Y */
    private int f29737Y = 10;

    /* renamed from: Z */
    private int f29738Z = 8000;

    /* renamed from: aa */
    private int f29765aa = 8000;

    /* renamed from: ab */
    private int f29766ab = 1300;

    /* renamed from: ac */
    private int f29767ac = f29712a;

    /* renamed from: ad */
    private int f29768ad = 0;

    /* renamed from: ae */
    private boolean f29769ae = false;

    /* renamed from: ag */
    private int f29771ag = 0;

    /* renamed from: ah */
    private int f29772ah = SdkConfigData.DEFAULT_REQUEST_INTERVAL;

    /* renamed from: ai */
    private int f29773ai = 10;

    /* renamed from: aj */
    private int f29774aj = 120;

    /* renamed from: ak */
    private String f29775ak = "";

    /* renamed from: at */
    private int f29784at = 1;

    /* renamed from: au */
    private int f29785au = 1;

    /* renamed from: av */
    private int f29786av = 1;

    /* renamed from: aw */
    private int f29787aw = 0;

    /* renamed from: ax */
    private int f29788ax = 1;

    /* renamed from: ay */
    private String f29789ay = "";

    /* renamed from: az */
    private int f29790az = 0;

    /* renamed from: aA */
    private int f29739aA = 2;

    /* renamed from: aC */
    private int f29741aC = 86400;

    /* renamed from: aD */
    private String f29742aD = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKAJ7eXHM==";

    /* renamed from: aE */
    private String f29743aE = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKsYFh=";

    /* renamed from: aF */
    private int f29744aF = 1;

    /* renamed from: aG */
    private int f29745aG = 30;

    /* renamed from: aH */
    private int f29746aH = 5;

    /* renamed from: aI */
    private int f29747aI = 0;

    /* renamed from: aJ */
    private int f29748aJ = 0;

    /* renamed from: aK */
    private int f29749aK = 9377;

    /* renamed from: aL */
    private int f29750aL = 0;

    /* renamed from: aM */
    private int f29751aM = 0;

    /* renamed from: aN */
    private int f29752aN = 0;

    /* renamed from: aO */
    private int f29753aO = 2;

    /* renamed from: aP */
    private int f29754aP = 10;

    /* renamed from: aR */
    private int f29756aR = 1;

    /* renamed from: aS */
    private int f29757aS = 24;

    /* renamed from: aT */
    private boolean f29758aT = false;

    /* renamed from: aU */
    private String f29759aU = "";

    /* renamed from: aW */
    private List<Integer> f29761aW = new ArrayList();

    /* renamed from: aY */
    private int f29763aY = 1;

    /* renamed from: be */
    private int f29816be = 3;

    /* renamed from: bg */
    private String f29818bg = "";

    /* renamed from: bh */
    private String f29819bh = "";

    /* renamed from: bi */
    private String f29820bi = "";

    /* renamed from: bj */
    private String f29821bj = "";

    /* renamed from: bk */
    private String f29822bk = "";

    /* renamed from: bl */
    private int f29823bl = 0;

    /* renamed from: bm */
    private int f29824bm = 21600;

    /* renamed from: bn */
    private int f29825bn = 2;

    /* renamed from: bo */
    private int f29826bo = 0;

    /* renamed from: bp */
    private int f29827bp = 0;

    /* renamed from: bq */
    private int f29828bq = DomainCampaignEx.TTC_CT_DEFAULT_VALUE;

    /* renamed from: br */
    private int f29829br = 0;

    /* renamed from: bs */
    private String f29830bs = "";

    /* renamed from: bt */
    private String f29831bt = "";

    /* renamed from: bu */
    private String f29832bu = "";

    /* renamed from: bv */
    private String f29833bv = "";

    /* renamed from: bw */
    private String f29834bw = "";

    /* renamed from: by */
    private int f29836by = 0;

    /* renamed from: bA */
    private int f29792bA = 0;

    /* renamed from: bB */
    private String f29793bB = "";

    /* renamed from: bC */
    private String f29794bC = "";

    /* renamed from: bD */
    private int f29795bD = 2;

    /* renamed from: bE */
    private int f29796bE = 7200;

    /* renamed from: bI */
    private int f29800bI = 0;

    /* renamed from: bJ */
    private boolean f29801bJ = false;

    /* renamed from: bK */
    private int f29802bK = 120;

    /* renamed from: bN */
    private int f29805bN = 0;

    /* renamed from: bO */
    private int f29806bO = 0;

    /* renamed from: bP */
    private int f29807bP = 0;

    /* renamed from: bQ */
    private int f29808bQ = 0;

    /* renamed from: bR */
    private int f29809bR = 0;

    /* renamed from: bS */
    private int f29810bS = 1;

    /* renamed from: bT */
    private String f29811bT = "";

    /* compiled from: Setting.java */
    /* renamed from: com.mbridge.msdk.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11193a {

        /* renamed from: a */
        private List<String> f29862a;

        /* renamed from: b */
        private List<String> f29863b;

        /* renamed from: c */
        private List<String> f29864c;

        /* renamed from: d */
        private List<String> f29865d;

        /* renamed from: a */
        public final List<String> m23271a() {
            return this.f29862a;
        }

        /* renamed from: b */
        public final List<String> m23269b() {
            return this.f29863b;
        }

        /* renamed from: c */
        public final List<String> m23268c() {
            return this.f29864c;
        }

        /* renamed from: d */
        public final List<String> m23267d() {
            return this.f29865d;
        }

        /* renamed from: a */
        public final void m23270a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f29862a = JsonUtils.m21842a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.f29863b = JsonUtils.m21842a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f29864c = JsonUtils.m21842a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f29865d = JsonUtils.m21842a(optJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: aq */
    public static boolean m23355aq() {
        try {
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b != null) {
                return m23252b.f29843h;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: A */
    public final int m23452A() {
        return this.f29753aO;
    }

    /* renamed from: B */
    public final int m23450B() {
        return this.f29741aC;
    }

    /* renamed from: C */
    public final int m23448C() {
        return this.f29739aA;
    }

    /* renamed from: D */
    public final String m23446D() {
        return this.f29740aB;
    }

    /* renamed from: E */
    public final int m23444E() {
        return this.f29784at;
    }

    /* renamed from: F */
    public final int m23442F() {
        return this.f29785au;
    }

    /* renamed from: G */
    public final int m23440G() {
        return this.f29786av;
    }

    /* renamed from: H */
    public final int m23438H() {
        return this.f29787aw;
    }

    /* renamed from: I */
    public final int m23436I() {
        return this.f29788ax;
    }

    /* renamed from: J */
    public final int m23434J() {
        return this.f29790az;
    }

    /* renamed from: K */
    public final int m23432K() {
        return this.f29723K;
    }

    /* renamed from: L */
    public final String m23430L() {
        return this.f29722J;
    }

    /* renamed from: M */
    public final int m23428M() {
        return this.f29718F;
    }

    /* renamed from: N */
    public final int m23426N() {
        return this.f29719G;
    }

    /* renamed from: O */
    public final List<CampaignEx> m23424O() {
        return this.f29724L;
    }

    /* renamed from: P */
    public final int m23422P() {
        return this.f29720H;
    }

    /* renamed from: Q */
    public final String m23420Q() {
        return this.f29721I;
    }

    /* renamed from: R */
    public final int m23418R() {
        return this.f29715C;
    }

    /* renamed from: S */
    public final long m23416S() {
        return this.f29714B * 1000;
    }

    /* renamed from: T */
    public final int m23414T() {
        return this.f29856u;
    }

    /* renamed from: U */
    public final int m23412U() {
        return this.f29861z;
    }

    /* renamed from: V */
    public final int m23410V() {
        return this.f29858w;
    }

    /* renamed from: W */
    public final long m23408W() {
        if (this.f29857v <= 0) {
            this.f29857v = 7200L;
        }
        return this.f29857v;
    }

    /* renamed from: X */
    public final int m23406X() {
        return this.f29817bf;
    }

    /* renamed from: Y */
    public final long m23405Y() {
        return this.f29815bd;
    }

    /* renamed from: Z */
    public final int m23404Z() {
        return this.f29813bb;
    }

    /* renamed from: a */
    public final int m23403a() {
        return this.f29766ab;
    }

    /* renamed from: aA */
    public final Map<String, C11193a> m23397aA() {
        return this.f29835bx;
    }

    /* renamed from: aB */
    public final int m23396aB() {
        return this.f29745aG;
    }

    /* renamed from: aC */
    public final int m23395aC() {
        return this.f29746aH;
    }

    /* renamed from: aD */
    public final int m23394aD() {
        return this.f29747aI;
    }

    /* renamed from: aE */
    public final int m23393aE() {
        return this.f29748aJ;
    }

    /* renamed from: aF */
    public final boolean m23392aF() {
        return this.f29726N;
    }

    /* renamed from: aG */
    public final int m23391aG() {
        return this.f29727O;
    }

    /* renamed from: aH */
    public final boolean m23390aH() {
        return this.f29728P;
    }

    /* renamed from: aI */
    public final int m23389aI() {
        return this.f29836by;
    }

    /* renamed from: aJ */
    public final C11194b m23388aJ() {
        return this.f29837bz;
    }

    /* renamed from: aK */
    public final int m23387aK() {
        return this.f29768ad;
    }

    /* renamed from: aL */
    public final String m23386aL() {
        return this.f29794bC;
    }

    /* renamed from: aM */
    public final String m23385aM() {
        return this.f29793bB;
    }

    /* renamed from: aN */
    public final int m23384aN() {
        return this.f29795bD;
    }

    /* renamed from: aO */
    public final int m23383aO() {
        return this.f29796bE;
    }

    /* renamed from: aP */
    public final List<ActiveAppConfigEntity> m23382aP() {
        return this.f29797bF;
    }

    /* renamed from: aQ */
    public final String m23381aQ() {
        return this.f29798bG;
    }

    /* renamed from: aR */
    public final String m23380aR() {
        return this.f29799bH;
    }

    /* renamed from: aS */
    public final int m23379aS() {
        return this.f29800bI;
    }

    /* renamed from: aT */
    public final boolean m23378aT() {
        return this.f29801bJ;
    }

    /* renamed from: aU */
    public final int m23377aU() {
        return this.f29802bK;
    }

    /* renamed from: aV */
    public final ArrayList<Integer> m23376aV() {
        return this.f29803bL;
    }

    /* renamed from: aW */
    public final HashMap<String, String> m23375aW() {
        return this.f29804bM;
    }

    /* renamed from: aX */
    public final int m23374aX() {
        return this.f29805bN;
    }

    /* renamed from: aY */
    public final int m23373aY() {
        return this.f29807bP;
    }

    /* renamed from: aZ */
    public final int m23372aZ() {
        return this.f29808bQ;
    }

    /* renamed from: aa */
    public final int m23371aa() {
        return this.f29814bc;
    }

    /* renamed from: ab */
    public final long m23370ab() {
        return this.f29764aZ * 1000;
    }

    /* renamed from: ac */
    public final long m23369ac() {
        return this.f29812ba * 1000;
    }

    /* renamed from: ad */
    public final boolean m23368ad() {
        return this.f29853r;
    }

    /* renamed from: ae */
    public final long m23367ae() {
        return this.f29852q;
    }

    /* renamed from: af */
    public final boolean m23366af() {
        return this.f29849n;
    }

    /* renamed from: ag */
    public final long m23365ag() {
        return this.f29850o;
    }

    /* renamed from: ah */
    public final String m23364ah() {
        return this.f29838c;
    }

    /* renamed from: ai */
    public final int m23363ai() {
        return this.f29840e;
    }

    /* renamed from: aj */
    public final long m23362aj() {
        return this.f29841f;
    }

    /* renamed from: ak */
    public final String m23361ak() {
        return this.f29783as;
    }

    /* renamed from: al */
    public final String m23360al() {
        return this.f29847l;
    }

    /* renamed from: am */
    public final String m23359am() {
        return this.f29848m;
    }

    /* renamed from: an */
    public final long m23358an() {
        return this.f29846k;
    }

    /* renamed from: ao */
    public final int m23357ao() {
        return this.f29854s;
    }

    /* renamed from: ap */
    public final int m23356ap() {
        return this.f29855t;
    }

    /* renamed from: ar */
    public final String m23354ar() {
        return this.f29818bg;
    }

    /* renamed from: as */
    public final String m23353as() {
        return this.f29819bh;
    }

    /* renamed from: at */
    public final String m23352at() {
        return this.f29820bi;
    }

    /* renamed from: au */
    public final String m23351au() {
        return this.f29821bj;
    }

    /* renamed from: av */
    public final String m23350av() {
        return this.f29822bk;
    }

    /* renamed from: aw */
    public final void m23349aw() {
        String language = Locale.getDefault().getLanguage();
        boolean z = true;
        if (!((TextUtils.isEmpty(this.f29818bg) || TextUtils.isEmpty(this.f29819bh) || TextUtils.isEmpty(this.f29820bi) || TextUtils.isEmpty(this.f29821bj)) ? false : true)) {
            if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                this.f29818bg = "确认关闭？";
                this.f29819bh = "关闭后您将不会获得任何奖励噢~ ";
                this.f29820bi = "确认关闭";
                this.f29821bj = "继续观看";
            } else {
                this.f29818bg = "Confirm to close? ";
                this.f29819bh = "You will not be rewarded after closing the window";
                this.f29820bi = "Close it";
                this.f29821bj = "Continue";
            }
        }
        if ((TextUtils.isEmpty(this.f29818bg) || TextUtils.isEmpty(this.f29819bh) || TextUtils.isEmpty(this.f29820bi) || TextUtils.isEmpty(this.f29822bk)) ? false : false) {
            return;
        }
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            this.f29818bg = "确认关闭？";
            this.f29819bh = "关闭后您将不会获得任何奖励噢~ ";
            this.f29820bi = "确认关闭";
            this.f29822bk = "继续试玩";
            return;
        }
        this.f29818bg = "Confirm to close? ";
        this.f29819bh = "You will not be rewarded after closing the window";
        this.f29820bi = "Close it";
        this.f29822bk = "Continue";
    }

    /* renamed from: ax */
    public final String m23348ax() {
        return this.f29830bs;
    }

    /* renamed from: ay */
    public final String m23347ay() {
        return this.f29831bt;
    }

    /* renamed from: az */
    public final String m23346az() {
        return this.f29832bu;
    }

    /* renamed from: b */
    public final int m23345b() {
        return this.f29738Z;
    }

    /* renamed from: ba */
    public final int m23340ba() {
        return this.f29810bS;
    }

    /* renamed from: bb */
    public final String m23339bb() {
        return this.f29811bT;
    }

    /* renamed from: bc */
    public final String m23338bc() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CcgConstant.f38530a, this.f29838c);
            jSONObject.put("upal", this.f29839d);
            jSONObject.put("cfc", this.f29840e);
            jSONObject.put("uplc", this.f29842g);
            jSONObject.put("aa", this.f29843h);
            jSONObject.put("cfb", this.f29845j);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f29850o);
            jSONObject.put("awct", this.f29851p);
            jSONObject.put("rurl", this.f29849n);
            jSONObject.put("ujds", this.f29853r);
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, this.f29857v);
            jSONObject.put("pcto", this.f29764aZ);
            jSONObject.put("tcto", this.f29812ba);
            jSONObject.put("wicon", this.f29859x);
            jSONObject.put("wreq", this.f29860y);
            jSONObject.put("apk_toast", this.f29721I);
            jSONObject.put("mv_wildcard", this.f29722J);
            jSONObject.put("is_startup_crashsystem", this.f29723K);
            jSONObject.put("sfct", this.f29815bd);
            jSONObject.put("pcrn", this.f29858w);
            jSONObject.put("pcct", this.f29717E);
            jSONObject.put("dlrf", this.f29715C);
            jSONObject.put("dlrfct", this.f29716D);
            jSONObject.put("upaid", this.f29814bc);
            jSONObject.put("pctn", this.f29816be);
            jSONObject.put("ilrf", this.f29763aY);
            jSONObject.put(CampaignEx.JSON_KEY_ST_IEX, this.f29720H);
            jSONObject.put("plc", this.f29718F);
            jSONObject.put("dut", this.f29719G);
            jSONObject.put("adct", this.f29817bf);
            jSONObject.put("dlapk", this.f29762aX);
            jSONObject.put("pf", this.f29776al);
            jSONObject.put("pmax", this.f29778an);
            jSONObject.put("pid", this.f29782ar);
            jSONObject.put("full", this.f29779ao);
            jSONObject.put("add", this.f29780ap);
            jSONObject.put("delete", this.f29781aq);
            jSONObject.put("upmi", this.f29813bb);
            jSONObject.put("upgd", this.f29785au);
            jSONObject.put("upsrl", this.f29784at);
            jSONObject.put("updevid", this.f29786av);
            jSONObject.put("sc", this.f29787aw);
            jSONObject.put("up_tips", this.f29788ax);
            jSONObject.put("iseu", this.f29790az);
            jSONObject.put("up_tips_url", this.f29789ay);
            jSONObject.put("jmc", this.f29739aA);
            jSONObject.put("jmct", this.f29741aC);
            jSONObject.put("atrqt", this.f29791b);
            jSONObject.put("omsdkjs_url", this.f29793bB);
            jSONObject.put("mcs", this.f29774aj);
            jSONObject.put("mcto", this.f29773ai);
            jSONObject.put("GDPR_area", this.f29801bJ);
            jSONObject.put("alrbs", this.f29800bI);
            jSONObject.put("ct", this.f29802bK);
            jSONObject.put("isDefault", this.f29806bO);
            jSONObject.put("st_net", this.f29810bS);
            jSONObject.put("vtag", this.f29811bT);
            return jSONObject.toString();
        } catch (Throwable th) {
            SameLogTool.m21733d("Setting", th.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public final int m23337c() {
        return this.f29765aa;
    }

    /* renamed from: d */
    public final boolean m23332d() {
        return this.f29769ae;
    }

    /* renamed from: e */
    public final int m23327e() {
        return this.f29733U;
    }

    /* renamed from: f */
    public final int m23322f() {
        return this.f29734V;
    }

    /* renamed from: g */
    public final int m23317g() {
        return this.f29735W;
    }

    /* renamed from: h */
    public final int m23312h() {
        return this.f29736X;
    }

    /* renamed from: i */
    public final int m23308i() {
        return this.f29737Y;
    }

    /* renamed from: j */
    public final int m23305j() {
        return this.f29732T;
    }

    /* renamed from: k */
    public final JSONArray m23303k() {
        return this.f29730R;
    }

    /* renamed from: l */
    public final JSONArray m23301l() {
        return this.f29731S;
    }

    /* renamed from: m */
    public final int m23299m() {
        return this.f29729Q;
    }

    /* renamed from: n */
    public final List<AtfEntity> m23297n() {
        return this.f29725M;
    }

    /* renamed from: o */
    public final String m23295o() {
        return this.f29775ak;
    }

    /* renamed from: p */
    public final int m23293p() {
        return this.f29774aj;
    }

    /* renamed from: q */
    public final int m23291q() {
        return this.f29791b;
    }

    /* renamed from: r */
    public final boolean m23289r() {
        return this.f29758aT;
    }

    /* renamed from: s */
    public final JSONObject m23287s() {
        return this.f29760aV;
    }

    /* renamed from: t */
    public final int m23285t() {
        return this.f29757aS;
    }

    public final String toString() {
        return "cc=" + this.f29838c + " upal=" + this.f29839d + " cfc=" + this.f29840e + " getpf=" + this.f29841f + " uplc=" + this.f29842g + " rurl=" + this.f29849n;
    }

    /* renamed from: u */
    public final int m23283u() {
        return this.f29756aR;
    }

    /* renamed from: v */
    public final String m23281v() {
        return this.f29755aQ;
    }

    /* renamed from: w */
    public final int m23279w() {
        return this.f29754aP;
    }

    /* renamed from: x */
    public final int m23277x() {
        return this.f29750aL;
    }

    /* renamed from: y */
    public final int m23275y() {
        return this.f29751aM;
    }

    /* renamed from: z */
    public final int m23273z() {
        return this.f29752aN;
    }

    /* renamed from: A */
    public final void m23451A(int i) {
        this.f29780ap = i;
    }

    /* renamed from: B */
    public final void m23449B(int i) {
        this.f29781aq = i;
    }

    /* renamed from: C */
    public final void m23447C(int i) {
        this.f29718F = i;
    }

    /* renamed from: D */
    public final void m23445D(int i) {
        this.f29719G = i;
    }

    /* renamed from: E */
    public final void m23443E(int i) {
        this.f29720H = i;
    }

    /* renamed from: F */
    public final void m23441F(int i) {
        this.f29715C = i;
    }

    /* renamed from: G */
    public final void m23439G(int i) {
        this.f29717E = i;
    }

    /* renamed from: H */
    public final void m23437H(int i) {
        this.f29858w = i;
    }

    /* renamed from: I */
    public final void m23435I(int i) {
        this.f29859x = i;
    }

    /* renamed from: J */
    public final void m23433J(int i) {
        this.f29860y = i;
    }

    /* renamed from: K */
    public final void m23431K(int i) {
        this.f29816be = i;
    }

    /* renamed from: L */
    public final void m23429L(int i) {
        this.f29817bf = i;
    }

    /* renamed from: M */
    public final void m23427M(int i) {
        this.f29813bb = i;
    }

    /* renamed from: N */
    public final void m23425N(int i) {
        this.f29814bc = i;
    }

    /* renamed from: O */
    public final void m23423O(int i) {
        this.f29840e = i;
    }

    /* renamed from: P */
    public final void m23421P(int i) {
        this.f29842g = i;
    }

    /* renamed from: Q */
    public final void m23419Q(int i) {
        this.f29768ad = i;
    }

    /* renamed from: R */
    public final void m23417R(int i) {
        this.f29800bI = i;
    }

    /* renamed from: S */
    public final void m23415S(int i) {
        this.f29802bK = i;
    }

    /* renamed from: T */
    public final void m23413T(int i) {
        this.f29806bO = i;
    }

    /* renamed from: U */
    public final void m23411U(int i) {
        this.f29807bP = i;
    }

    /* renamed from: V */
    public final void m23409V(int i) {
        this.f29808bQ = i;
    }

    /* renamed from: a */
    public final void m23398a(boolean z) {
        this.f29769ae = z;
    }

    /* renamed from: b */
    public final void m23344b(int i) {
        this.f29773ai = i;
    }

    /* renamed from: c */
    public final void m23336c(int i) {
        this.f29774aj = i;
    }

    /* renamed from: d */
    public final void m23331d(int i) {
        this.f29791b = i;
    }

    /* renamed from: e */
    public final void m23326e(int i) {
        this.f29757aS = i;
    }

    /* renamed from: f */
    public final void m23321f(int i) {
        this.f29756aR = i;
    }

    /* renamed from: g */
    public final void m23316g(int i) {
        if (i > 0) {
            this.f29754aP = i;
        }
    }

    /* renamed from: h */
    public final void m23311h(int i) {
        this.f29750aL = i;
    }

    /* renamed from: i */
    public final void m23307i(int i) {
        this.f29751aM = i;
    }

    /* renamed from: j */
    public final void m23304j(int i) {
        this.f29752aN = i;
    }

    /* renamed from: k */
    public final void m23302k(int i) {
        this.f29753aO = i;
    }

    /* renamed from: l */
    public final boolean m23300l(int i) {
        return this.f29761aW.contains(Integer.valueOf(i));
    }

    /* renamed from: m */
    public final void m23298m(int i) {
        this.f29741aC = i;
    }

    /* renamed from: n */
    public final void m23296n(int i) {
        this.f29739aA = i;
    }

    /* renamed from: o */
    public final void m23294o(int i) {
        this.f29784at = i;
    }

    /* renamed from: p */
    public final void m23292p(int i) {
        this.f29785au = i;
    }

    /* renamed from: q */
    public final void m23290q(int i) {
        this.f29786av = i;
    }

    /* renamed from: r */
    public final void m23288r(int i) {
        this.f29787aw = i;
    }

    /* renamed from: s */
    public final void m23286s(int i) {
        this.f29788ax = i;
    }

    /* renamed from: t */
    public final void m23284t(int i) {
        this.f29790az = i;
    }

    /* renamed from: u */
    public final void m23282u(int i) {
        this.f29723K = i;
    }

    /* renamed from: v */
    public final void m23280v(int i) {
        this.f29763aY = i;
    }

    /* renamed from: w */
    public final void m23278w(int i) {
        this.f29762aX = i;
    }

    /* renamed from: x */
    public final void m23276x(int i) {
        this.f29776al = i;
    }

    /* renamed from: y */
    public final void m23274y(int i) {
        this.f29778an = i;
    }

    /* renamed from: z */
    public final void m23272z(int i) {
        this.f29779ao = i;
    }

    /* renamed from: i */
    private static Map<String, C11193a> m23306i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C11193a c11193a = new C11193a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    c11193a.m23270a(optJSONObject);
                }
                hashMap.put(next, c11193a);
            }
            return hashMap;
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public final void m23402a(int i) {
        this.f29729Q = i;
    }

    /* renamed from: b */
    public final void m23341b(boolean z) {
        this.f29758aT = z;
    }

    /* renamed from: c */
    public final void m23334c(String str) {
        this.f29722J = str;
    }

    /* renamed from: d */
    public final void m23329d(String str) {
        this.f29782ar = str;
    }

    /* renamed from: e */
    public final void m23324e(String str) {
        this.f29721I = str;
    }

    /* renamed from: f */
    public final void m23320f(long j) {
        this.f29850o = j;
    }

    /* renamed from: g */
    public final void m23315g(long j) {
        this.f29851p = j;
    }

    /* renamed from: h */
    public final void m23310h(long j) {
        this.f29839d = j;
    }

    /* renamed from: f */
    public static Setting m23319f(String str) {
        Exception exc;
        Setting setting;
        ArrayList arrayList;
        ArrayList arrayList2;
        CampaignEx parseSettingCampaign;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Setting setting2 = new Setting();
            try {
                setting2.f29760aV = jSONObject;
                setting2.f29838c = jSONObject.optString(CcgConstant.f38530a);
                setting2.f29721I = jSONObject.optString("apk_toast", "正在下载中，请去通知栏查看下载进度");
                setting2.f29722J = jSONObject.optString("mv_wildcard", "mbridge");
                setting2.f29839d = jSONObject.optLong("upal");
                setting2.f29840e = jSONObject.optInt("cfc");
                setting2.f29841f = jSONObject.optLong("getpf");
                setting2.f29842g = jSONObject.optInt("uplc");
                setting2.f29843h = jSONObject.optBoolean("aa");
                setting2.f29846k = jSONObject.optLong("current_time");
                setting2.f29845j = jSONObject.optBoolean("cfb");
                setting2.f29851p = jSONObject.optLong("awct");
                setting2.f29850o = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT);
                setting2.f29849n = jSONObject.optBoolean("rurl");
                setting2.f29852q = jSONObject.optLong("uct");
                setting2.f29853r = jSONObject.optBoolean("ujds");
                setting2.f29854s = jSONObject.optInt("n2");
                setting2.f29855t = jSONObject.optInt("n3");
                setting2.f29723K = jSONObject.optInt("is_startup_crashsystem");
                setting2.f29856u = jSONObject.optInt("n4", 1800);
                setting2.f29858w = jSONObject.optInt("pcrn");
                setting2.f29857v = jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB);
                setting2.f29813bb = jSONObject.optInt("upmi");
                setting2.f29814bc = jSONObject.optInt("upaid");
                setting2.f29858w = jSONObject.optInt("pcrn", 100);
                setting2.f29859x = jSONObject.optInt("wicon", 2);
                setting2.f29860y = jSONObject.optInt("wreq", 2);
                setting2.f29861z = jSONObject.optInt("opent", 1);
                setting2.f29815bd = jSONObject.optLong("sfct", 1800L);
                setting2.f29713A = jSONObject.optString("t_vba");
                setting2.f29714B = jSONObject.optLong("tcct", 21600000L);
                setting2.f29715C = jSONObject.optInt("dlrf", 1);
                setting2.f29716D = jSONObject.optInt("dlrfct", DomainCampaignEx.TTC_CT_DEFAULT_VALUE);
                setting2.f29717E = jSONObject.optInt("pcct", 43200);
                setting2.f29816be = jSONObject.optInt("pctn", 3);
                setting2.f29763aY = jSONObject.optInt("ilrf", 1);
                setting2.f29783as = jSONObject.optString("pw", "");
                setting2.f29762aX = jSONObject.optInt("dlapk", 1);
                setting2.f29785au = jSONObject.optInt("upgd", 1);
                setting2.f29784at = jSONObject.optInt("upsrl", 1);
                setting2.f29786av = jSONObject.optInt("updevid", 1);
                setting2.f29787aw = jSONObject.optInt("sc", 0);
                setting2.f29788ax = jSONObject.optInt("up_tips", 1);
                setting2.f29790az = jSONObject.optInt("iseu", -1);
                setting2.f29789ay = jSONObject.optString("up_tips_url", SettingConst.f29870a);
                setting2.f29739aA = jSONObject.optInt("jmc", 2);
                setting2.f29741aC = jSONObject.optInt("jmct", 86400);
                setting2.f29740aB = jSONObject.optString("jm_unit");
                setting2.f29743aE = jSONObject.optString("cdai");
                setting2.f29742aD = jSONObject.optString("csdai");
                setting2.f29744aF = jSONObject.optInt("ils");
                setting2.f29734V = jSONObject.optInt("rty_tk_clk", 0);
                setting2.f29733U = jSONObject.optInt("rty_tk_imp", 0);
                setting2.f29735W = jSONObject.optInt("rty_cnt", 3);
                setting2.f29736X = jSONObject.optInt("rty_to", 600);
                setting2.f29737Y = jSONObject.optInt("rty_inr", 10);
                setting2.f29772ah = jSONObject.optInt("clptm", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
                setting2.f29771ag = jSONObject.optInt("clptype", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("clpcode");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    LinkedList<String> linkedList = new LinkedList<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        linkedList.add(optJSONArray.optString(i));
                    }
                    setting2.f29770af = linkedList;
                }
                long optLong = jSONObject.optLong("pcto");
                if (optLong == 0) {
                    setting2.f29764aZ = 20L;
                } else {
                    setting2.f29764aZ = optLong;
                }
                long optLong2 = jSONObject.optLong("tcto");
                if (optLong2 == 0) {
                    setting2.f29812ba = 10L;
                } else {
                    setting2.f29812ba = optLong2;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("jt");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        HashMap hashMap = new HashMap();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                            hashMap.put(optJSONObject.optString(DomainCampaignEx.LOOPBACK_DOMAIN), optJSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT));
                        }
                        setting2.f29844i = hashMap;
                    }
                }
                setting2.f29718F = jSONObject.optInt("plc", 3);
                setting2.f29719G = jSONObject.optInt("dut", 86400);
                setting2.f29720H = jSONObject.optInt(CampaignEx.JSON_KEY_ST_IEX, 1);
                JSONArray optJSONArray3 = jSONObject.optJSONArray("cal");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        String optString = optJSONArray3.optString(i3);
                        if (StringUtils.m21956b(optString) && (parseSettingCampaign = CampaignEx.parseSettingCampaign(new JSONObject(optString))) != null) {
                            arrayList.add(parseSettingCampaign);
                        }
                    }
                }
                if (arrayList != null) {
                    setting2.f29724L = arrayList;
                }
                try {
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("atf");
                    if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            String optString2 = optJSONArray4.optString(i4);
                            if (StringUtils.m21956b(optString2)) {
                                JSONObject jSONObject2 = new JSONObject(optString2);
                                arrayList2.add(new AtfEntity(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList2 != null) {
                        setting2.f29725M = arrayList2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setting2.f29817bf = jSONObject.optInt("adct", 259200);
                setting2.f29776al = jSONObject.optInt("pf", 900);
                setting2.f29778an = jSONObject.optInt("pmax", 20);
                setting2.f29782ar = jSONObject.optString("pid");
                JSONArray optJSONArray5 = jSONObject.optJSONArray("pb");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        arrayList3.add(optJSONArray5.optString(i5));
                    }
                    setting2.f29777am = arrayList3;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("pctrl");
                if (optJSONObject2 != null) {
                    setting2.f29779ao = optJSONObject2.optInt("full", 1);
                    setting2.f29780ap = optJSONObject2.optInt("add", 1);
                    setting2.f29781aq = optJSONObject2.optInt("delete", 1);
                }
                setting2.f29818bg = jSONObject.optString("confirm_title", "");
                setting2.f29819bh = jSONObject.optString("confirm_description", "");
                setting2.f29820bi = jSONObject.optString("confirm_t", "");
                setting2.f29821bj = jSONObject.optString("confirm_c_rv", "");
                setting2.f29822bk = jSONObject.optString("confirm_c_play", "");
                setting2.f29823bl = jSONObject.optInt("offercacheRate", 0);
                setting2.f29824bm = jSONObject.optInt("offercachepacing", 21600);
                setting2.f29825bn = jSONObject.optInt("useexpriedcacheoffer", 2);
                setting2.f29826bo = jSONObject.optInt("retryoffer", 0);
                setting2.f29827bp = jSONObject.optInt("mapping_cache_rate", 0);
                setting2.f29828bq = jSONObject.optInt("tokencachetime", DomainCampaignEx.TTC_CT_DEFAULT_VALUE);
                setting2.f29829br = jSONObject.optInt("protect", 0);
                setting2.f29830bs = jSONObject.optString("adchoice_icon", "");
                setting2.f29832bu = jSONObject.optString("adchoice_link", "");
                setting2.f29831bt = jSONObject.optString("adchoice_size", "");
                setting2.f29834bw = jSONObject.optString("platform_logo", "");
                setting2.f29833bv = jSONObject.optString("platform_name", "");
                setting2.f29835bx = m23306i(jSONObject.optString("cdnate_cfg", ""));
                setting2.f29791b = jSONObject.optInt("atrqt", 0);
                setting2.f29792bA = jSONObject.optInt("iupdid", 0);
                setting2.f29774aj = jSONObject.optInt("mcs", 120);
                setting2.f29773ai = jSONObject.optInt("mcto", 10);
                setting2.f29775ak = jSONObject.optString("ab_id", "");
                setting2.f29793bB = jSONObject.optString("omsdkjs_url", "");
                setting2.f29794bC = jSONObject.optString("omsdkjs_h5_url", "");
                setting2.f29795bD = jSONObject.optInt("activeAppStatus", 2);
                setting2.f29796bE = jSONObject.optInt("activeAppTime", 7200);
                String optString3 = jSONObject.optString("activeAppConfig");
                if (!TextUtils.isEmpty(optString3)) {
                    String m21812b = SameBase64Tool.m21812b(optString3);
                    if (m21812b.startsWith("[")) {
                        JSONArray jSONArray = new JSONArray(m21812b);
                        if (jSONArray.length() > 0) {
                            ArrayList arrayList4 = new ArrayList();
                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i6);
                                if (jSONObject3 != null) {
                                    ActiveAppConfigEntity activeAppConfigEntity = new ActiveAppConfigEntity();
                                    activeAppConfigEntity.m22631a(jSONObject3.optString("pn"));
                                    activeAppConfigEntity.m22629b(jSONObject3.optString("at"));
                                    activeAppConfigEntity.m22627c(jSONObject3.optString("ai"));
                                    activeAppConfigEntity.m22625d(jSONObject3.optString("ac"));
                                    arrayList4.add(activeAppConfigEntity);
                                }
                            }
                            setting2.f29797bF = arrayList4;
                        }
                    }
                }
                setting2.f29799bH = jSONObject.optString("mraid_js");
                setting2.f29798bG = jSONObject.optString("web_env_url");
                int optInt = jSONObject.optInt("alrbs", 0);
                setting2.f29800bI = (optInt > 2 || optInt < 0) ? 0 : 0;
                setting2.f29801bJ = jSONObject.optBoolean("GDPR_area", false);
                setting2.f29802bK = jSONObject.optInt("ct", 120);
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ercd");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    ArrayList<Integer> arrayList5 = new ArrayList<>();
                    for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                        int optInt2 = optJSONArray6.optInt(i7);
                        if (optInt2 != 0) {
                            arrayList5.add(Integer.valueOf(optInt2));
                        }
                    }
                    if (arrayList5.size() > 0) {
                        arrayList5.add(-1);
                        setting2.f29803bL = arrayList5;
                    }
                }
                String optString4 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(optString4)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(SameBase64Tool.m21812b(optString4));
                        Iterator<String> keys = jSONObject4.keys();
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject4.optString(next)) && !TextUtils.isEmpty(SameBase64Tool.m21812b(jSONObject4.optString(next)))) {
                                hashMap2.put(next, jSONObject4.optString(next));
                            }
                        }
                        if (hashMap2.size() > 0) {
                            setting2.f29804bM = hashMap2;
                        }
                    } catch (Exception e2) {
                        SameLogTool.m21733d("SETTING", e2.getMessage());
                    }
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("refactor_switch");
                if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                    for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                        JSONObject jSONObject5 = optJSONArray7.getJSONObject(i8);
                        Iterator<String> keys2 = jSONObject5.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject5.getBoolean(next2)) {
                                setting2.f29761aW.add(Integer.valueOf(Integer.parseInt(next2)));
                            }
                        }
                    }
                }
                try {
                    int optInt3 = jSONObject.optInt("lqcnt", 30);
                    int optInt4 = jSONObject.optInt("lqto", 5);
                    int optInt5 = jSONObject.optInt("lqswt", 0);
                    int optInt6 = jSONObject.optInt("lqtype", 0);
                    setting2.f29746aH = optInt4;
                    setting2.f29745aG = optInt3;
                    setting2.f29747aI = optInt5;
                    setting2.f29748aJ = optInt6;
                    JSONArray optJSONArray8 = jSONObject.optJSONArray("lg_bl");
                    if (optJSONArray8 == null) {
                        optJSONArray8 = new JSONArray();
                        optJSONArray8.put("2000088");
                    }
                    setting2.f29731S = optJSONArray8;
                    JSONArray optJSONArray9 = jSONObject.optJSONArray("lg_wl");
                    if (optJSONArray9 == null) {
                        optJSONArray9 = new JSONArray();
                        optJSONArray9.put("2000041");
                        optJSONArray9.put("2000042");
                        optJSONArray9.put("2000032");
                        optJSONArray9.put("2000079");
                    }
                    setting2.f29730R = optJSONArray9;
                    setting2.f29732T = jSONObject.optInt("lg_wl_rt");
                    setting2.f29738Z = jSONObject.optInt("srml", 8000);
                    setting2.f29765aa = jSONObject.optInt("lrml", 8000);
                    setting2.f29766ab = jSONObject.optInt("wgl_d_ms", 1300);
                    int optInt7 = jSONObject.optInt("dp_ct", f29712a);
                    setting2.f29767ac = optInt7;
                    DspFilterUtils.f30068c = optInt7;
                    int parseInt = Integer.parseInt(SameBase64Tool.m21812b(jSONObject.optString("lqpt")));
                    if (parseInt > 0 && parseInt < 65535) {
                        setting2.f29749aK = parseInt;
                        RequestUrlUtil.m22248a().f30796f = parseInt;
                        RequestUrlUtil.m22248a().f30797g = parseInt;
                    }
                } catch (Exception unused) {
                }
                setting2.f29805bN = jSONObject.optInt("wvddt", 0);
                setting2.f29847l = jSONObject.optString("hst_st", "");
                setting2.f29848m = jSONObject.optString("hst_st_t", "");
                try {
                    int optInt8 = jSONObject.optInt(C7304t.f25048d, 3);
                    boolean z = jSONObject.optInt("k", 0) == 1;
                    boolean z2 = jSONObject.optInt("m", 1) == 1;
                    setting2.f29727O = optInt8;
                    setting2.f29726N = z;
                    setting2.f29728P = z2;
                } catch (Exception e3) {
                    SameLogTool.m21733d("Setting", e3.getMessage());
                }
                setting2.f29836by = jSONObject.optInt("fbk_swt", 0);
                setting2.f29837bz = C11194b.m23265a(jSONObject.optJSONObject("fbk"));
                try {
                    int optInt9 = jSONObject.optInt("ad_connection_timeout", CommonConst.f30571L);
                    int optInt10 = jSONObject.optInt("ad_read_timeout", CommonConst.f30572M);
                    int optInt11 = jSONObject.optInt("ad_write_timeout", CommonConst.f30573N);
                    int optInt12 = jSONObject.optInt("ad_retry_count", CommonConst.f30577R);
                    if (optInt9 <= 0) {
                        optInt9 = CommonConst.f30571L;
                    }
                    setting2.f29752aN = optInt9;
                    if (optInt10 <= 0) {
                        optInt10 = CommonConst.f30572M;
                    }
                    setting2.f29750aL = optInt10;
                    if (optInt11 <= 0) {
                        optInt11 = CommonConst.f30573N;
                    }
                    setting2.f29751aM = optInt11;
                    if (optInt12 < 0) {
                        optInt12 = CommonConst.f30577R;
                    }
                    setting2.f29753aO = optInt12;
                    int optInt13 = jSONObject.optInt("max_download_task_size", 10);
                    if (optInt13 <= 0) {
                        optInt13 = 10;
                    }
                    setting2.f29729Q = optInt13;
                    setting2.m23316g(jSONObject.optInt("max_bitmap_cache_size", 10));
                    setting2.f29808bQ = jSONObject.optInt("t_t");
                    setting2.f29807bP = jSONObject.optInt("h_t");
                    int optInt14 = jSONObject.optInt("gtp");
                    setting2.f29809bR = optInt14;
                    RequestUrlUtil.m22248a().m22247a(optInt14);
                } catch (Exception unused2) {
                }
                try {
                    setting2.f29755aQ = jSONObject.optString("http_track_url", "");
                } catch (Exception unused3) {
                }
                try {
                    setting2.f29756aR = jSONObject.optInt("is_transmission_available", 1);
                    setting2.f29757aS = jSONObject.optInt("is_transmission_delay", 24);
                } catch (Exception unused4) {
                    setting2.f29756aR = 1;
                    setting2.f29757aS = 24;
                }
                setting2.f29810bS = jSONObject.optInt("st_net", 1);
                setting2.f29811bT = jSONObject.optString("vtag", "");
                try {
                    setting2.f29769ae = jSONObject.optInt("check_webview", 0) != 0;
                } catch (Exception unused5) {
                    setting2.f29769ae = false;
                }
                String optString5 = jSONObject.optString("swxid");
                if (!TextUtils.isEmpty(setting2.f29759aU)) {
                    setting2.f29759aU = optString5;
                    if (TextUtils.isEmpty(MBSDKContext.m22865f().m22858m())) {
                        MBSDKContext.m22865f().m22866e(setting2.f29759aU);
                    }
                }
                try {
                    setting2.f29768ad = jSONObject.optInt("ch_nv_im_cb", 1);
                } catch (Exception unused6) {
                    setting2.f29768ad = 1;
                }
                try {
                    setting2.f29758aT = jSONObject.optInt("do_us_fi_re", 1) != 0;
                } catch (Exception unused7) {
                    setting2.f29758aT = true;
                }
                return setting2;
            } catch (Exception e4) {
                exc = e4;
                setting = setting2;
                exc.printStackTrace();
                return setting;
            }
        } catch (Exception e5) {
            exc = e5;
            setting = null;
        }
    }

    /* renamed from: W */
    public final void m23407W(int i) {
        this.f29810bS = i;
    }

    /* renamed from: a */
    public final void m23399a(String str) {
        this.f29755aQ = str;
    }

    /* renamed from: b */
    public final void m23342b(String str) {
        this.f29789ay = str;
    }

    /* renamed from: c */
    public final void m23335c(long j) {
        this.f29815bd = j;
    }

    /* renamed from: d */
    public final void m23330d(long j) {
        this.f29764aZ = j;
    }

    /* renamed from: e */
    public final void m23325e(long j) {
        this.f29812ba = j;
    }

    /* renamed from: g */
    public final void m23314g(String str) {
        this.f29794bC = str;
    }

    /* renamed from: h */
    public final void m23309h(String str) {
        this.f29793bB = str;
    }

    /* renamed from: a */
    public final void m23401a(long j) {
        this.f29716D = j;
    }

    /* renamed from: b */
    public final void m23343b(long j) {
        this.f29857v = j;
    }

    /* renamed from: c */
    public final void m23333c(boolean z) {
        this.f29853r = z;
    }

    /* renamed from: d */
    public final void m23328d(boolean z) {
        this.f29849n = z;
    }

    /* renamed from: e */
    public final void m23323e(boolean z) {
        this.f29843h = z;
    }

    /* renamed from: g */
    public final void m23313g(boolean z) {
        this.f29801bJ = z;
    }

    /* renamed from: a */
    public static String m23400a(Context context, String str) {
        Setting m23252b;
        String str2 = "";
        try {
            m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        } catch (Throwable unused) {
        }
        if (m23252b != null && m23252b.f29844i != null) {
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> entry : m23252b.f29844i.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(key)) {
                    String str3 = m23252b.f29844i.get(key);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    String replace = str3.replace("{gaid}", SameDiTool.m21803E());
                    if (replace.contains("{android_id}")) {
                        if (DomainSameDiTool.m21903g(context) != null) {
                            str2 = replace.replace("{android_id}", DomainSameDiTool.m21903g(context));
                        }
                        str2 = replace;
                    } else {
                        if (replace.contains("{android_id_md5_upper}") && DomainSameDiTool.m21901h(context) != null) {
                            str2 = replace.replace("{android_id_md5_upper}", DomainSameDiTool.m21901h(context));
                        }
                        str2 = replace;
                    }
                    return str2;
                }
            }
        }
        return str2;
    }

    /* compiled from: Setting.java */
    /* renamed from: com.mbridge.msdk.c.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11194b {

        /* renamed from: a */
        private String f29866a;

        /* renamed from: b */
        private String f29867b;

        /* renamed from: c */
        private String f29868c;

        /* renamed from: d */
        private JSONArray f29869d;

        /* renamed from: a */
        public static C11194b m23265a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C11194b c11194b = new C11194b();
            Context m22861j = MBSDKContext.m22865f().m22861j();
            c11194b.f29866a = jSONObject.optString("title", m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_title", "string")));
            c11194b.f29867b = jSONObject.optString(CommonNetImpl.CANCEL, m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_close_close", "string")));
            c11194b.f29868c = jSONObject.optString("submit", m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_close_submit", "string")));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            c11194b.f29869d = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c11194b.f29869d = jSONArray;
                jSONArray.put(m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_content_stuck", "string")));
                c11194b.f29869d.put(m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_content_cnr", "string")));
                c11194b.f29869d.put(m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_content_balck_screen", "string")));
                c11194b.f29869d.put(m22861j.getString(ResourceUtil.m21814a(m22861j, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return c11194b;
        }

        /* renamed from: b */
        public final String m23264b() {
            return this.f29867b;
        }

        /* renamed from: c */
        public final String m23263c() {
            return this.f29868c;
        }

        /* renamed from: d */
        public final JSONArray m23262d() {
            return this.f29869d;
        }

        /* renamed from: a */
        public final String m23266a() {
            return this.f29866a;
        }
    }

    /* renamed from: f */
    public final void m23318f(boolean z) {
        this.f29845j = z;
    }
}
