package com.mbridge.msdk.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
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

/* compiled from: Setting.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f38679a = 1500;
    private String A;
    private long B;
    private int C;
    private long D;
    private long E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private List<CampaignEx> f38680L;
    private List<com.mbridge.msdk.foundation.entity.b> M;
    private int Q;
    private String aB;
    private String aQ;
    private JSONObject aV;
    private int aX;
    private long aZ;
    private LinkedList<String> af;
    private int al;
    private List<String> am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private String ar;
    private String as;
    private List<com.mbridge.msdk.foundation.entity.a> bF;
    private String bG;
    private String bH;
    private ArrayList<Integer> bL;
    private HashMap<String, String> bM;
    private long ba;
    private int bb;
    private int bc;
    private long bd;
    private int bf;
    private Map<String, C0727a> bx;
    private b bz;

    /* renamed from: c  reason: collision with root package name */
    private String f38682c;

    /* renamed from: d  reason: collision with root package name */
    private long f38683d;

    /* renamed from: e  reason: collision with root package name */
    private int f38684e;

    /* renamed from: g  reason: collision with root package name */
    private int f38686g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38687h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f38688i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f38689j;

    /* renamed from: k  reason: collision with root package name */
    private long f38690k;

    /* renamed from: n  reason: collision with root package name */
    private boolean f38693n;

    /* renamed from: o  reason: collision with root package name */
    private long f38694o;

    /* renamed from: p  reason: collision with root package name */
    private long f38695p;

    /* renamed from: q  reason: collision with root package name */
    private long f38696q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f38697r;

    /* renamed from: s  reason: collision with root package name */
    private int f38698s;

    /* renamed from: t  reason: collision with root package name */
    private int f38699t;

    /* renamed from: u  reason: collision with root package name */
    private int f38700u;

    /* renamed from: v  reason: collision with root package name */
    private long f38701v;

    /* renamed from: w  reason: collision with root package name */
    private int f38702w;

    /* renamed from: x  reason: collision with root package name */
    private int f38703x;

    /* renamed from: y  reason: collision with root package name */
    private int f38704y;

    /* renamed from: z  reason: collision with root package name */
    private int f38705z;

    /* renamed from: b  reason: collision with root package name */
    private int f38681b = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f38685f = 86400;

    /* renamed from: l  reason: collision with root package name */
    private String f38691l = com.mbridge.msdk.foundation.same.net.f.d.a().f39566c;

    /* renamed from: m  reason: collision with root package name */
    private String f38692m = com.mbridge.msdk.foundation.same.net.f.d.a().f39567d;
    private boolean N = false;
    private int O = 3;
    private boolean P = true;
    private JSONArray R = new JSONArray();
    private JSONArray S = new JSONArray();
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 3;
    private int X = 600;
    private int Y = 10;
    private int Z = AVMDLDataLoader.KeyIsLiveSetLoaderType;
    private int aa = AVMDLDataLoader.KeyIsLiveSetLoaderType;
    private int ab = 1300;
    private int ac = f38679a;
    private int ad = 0;
    private boolean ae = false;
    private int ag = 0;
    private int ah = 3600;
    private int ai = 10;
    private int aj = 120;
    private String ak = "";
    private int at = 1;
    private int au = 1;
    private int av = 1;
    private int aw = 0;
    private int ax = 1;
    private String ay = "";
    private int az = 0;
    private int aA = 2;
    private int aC = 86400;
    private String aD = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKAJ7eXHM==";
    private String aE = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKsYFh=";
    private int aF = 1;
    private int aG = 30;
    private int aH = 5;
    private int aI = 0;
    private int aJ = 0;
    private int aK = 9377;
    private int aL = 0;
    private int aM = 0;
    private int aN = 0;
    private int aO = 2;
    private int aP = 10;
    private int aR = 1;
    private int aS = 24;
    private boolean aT = false;
    private String aU = "";
    private List<Integer> aW = new ArrayList();
    private int aY = 1;
    private int be = 3;
    private String bg = "";
    private String bh = "";
    private String bi = "";
    private String bj = "";
    private String bk = "";
    private int bl = 0;
    private int bm = 21600;
    private int bn = 2;
    private int bo = 0;
    private int bp = 0;
    private int bq = DomainCampaignEx.TTC_CT_DEFAULT_VALUE;
    private int br = 0;
    private String bs = "";
    private String bt = "";
    private String bu = "";
    private String bv = "";
    private String bw = "";
    private int by = 0;
    private int bA = 0;
    private String bB = "";
    private String bC = "";
    private int bD = 2;
    private int bE = 7200;
    private int bI = 0;
    private boolean bJ = false;
    private int bK = 120;
    private int bN = 0;
    private int bO = 0;
    private int bP = 0;
    private int bQ = 0;
    private int bR = 0;
    private int bS = 1;
    private String bT = "";

    /* compiled from: Setting.java */
    /* renamed from: com.mbridge.msdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0727a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f38706a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f38707b;

        /* renamed from: c  reason: collision with root package name */
        private List<String> f38708c;

        /* renamed from: d  reason: collision with root package name */
        private List<String> f38709d;

        public final List<String> a() {
            return this.f38706a;
        }

        public final List<String> b() {
            return this.f38707b;
        }

        public final List<String> c() {
            return this.f38708c;
        }

        public final List<String> d() {
            return this.f38709d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f38706a = m.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.f38707b = m.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f38708c = m.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f38709d = m.a(optJSONArray4);
                }
            } catch (Exception e4) {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public static boolean aq() {
        try {
            a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 != null) {
                return b4.f38687h;
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public final int A() {
        return this.aO;
    }

    public final int B() {
        return this.aC;
    }

    public final int C() {
        return this.aA;
    }

    public final String D() {
        return this.aB;
    }

    public final int E() {
        return this.at;
    }

    public final int F() {
        return this.au;
    }

    public final int G() {
        return this.av;
    }

    public final int H() {
        return this.aw;
    }

    public final int I() {
        return this.ax;
    }

    public final int J() {
        return this.az;
    }

    public final int K() {
        return this.K;
    }

    public final String L() {
        return this.J;
    }

    public final int M() {
        return this.F;
    }

    public final int N() {
        return this.G;
    }

    public final List<CampaignEx> O() {
        return this.f38680L;
    }

    public final int P() {
        return this.H;
    }

    public final String Q() {
        return this.I;
    }

    public final int R() {
        return this.C;
    }

    public final long S() {
        return this.B * 1000;
    }

    public final int T() {
        return this.f38700u;
    }

    public final int U() {
        return this.f38705z;
    }

    public final int V() {
        return this.f38702w;
    }

    public final long W() {
        if (this.f38701v <= 0) {
            this.f38701v = 7200L;
        }
        return this.f38701v;
    }

    public final int X() {
        return this.bf;
    }

    public final long Y() {
        return this.bd;
    }

    public final int Z() {
        return this.bb;
    }

    public final int a() {
        return this.ab;
    }

    public final Map<String, C0727a> aA() {
        return this.bx;
    }

    public final int aB() {
        return this.aG;
    }

    public final int aC() {
        return this.aH;
    }

    public final int aD() {
        return this.aI;
    }

    public final int aE() {
        return this.aJ;
    }

    public final boolean aF() {
        return this.N;
    }

    public final int aG() {
        return this.O;
    }

    public final boolean aH() {
        return this.P;
    }

    public final int aI() {
        return this.by;
    }

    public final b aJ() {
        return this.bz;
    }

    public final int aK() {
        return this.ad;
    }

    public final String aL() {
        return this.bC;
    }

    public final String aM() {
        return this.bB;
    }

    public final int aN() {
        return this.bD;
    }

    public final int aO() {
        return this.bE;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> aP() {
        return this.bF;
    }

    public final String aQ() {
        return this.bG;
    }

    public final String aR() {
        return this.bH;
    }

    public final int aS() {
        return this.bI;
    }

    public final boolean aT() {
        return this.bJ;
    }

    public final int aU() {
        return this.bK;
    }

    public final ArrayList<Integer> aV() {
        return this.bL;
    }

    public final HashMap<String, String> aW() {
        return this.bM;
    }

    public final int aX() {
        return this.bN;
    }

    public final int aY() {
        return this.bP;
    }

    public final int aZ() {
        return this.bQ;
    }

    public final int aa() {
        return this.bc;
    }

    public final long ab() {
        return this.aZ * 1000;
    }

    public final long ac() {
        return this.ba * 1000;
    }

    public final boolean ad() {
        return this.f38697r;
    }

    public final long ae() {
        return this.f38696q;
    }

    public final boolean af() {
        return this.f38693n;
    }

    public final long ag() {
        return this.f38694o;
    }

    public final String ah() {
        return this.f38682c;
    }

    public final int ai() {
        return this.f38684e;
    }

    public final long aj() {
        return this.f38685f;
    }

    public final String ak() {
        return this.as;
    }

    public final String al() {
        return this.f38691l;
    }

    public final String am() {
        return this.f38692m;
    }

    public final long an() {
        return this.f38690k;
    }

    public final int ao() {
        return this.f38698s;
    }

    public final int ap() {
        return this.f38699t;
    }

    public final String ar() {
        return this.bg;
    }

    public final String as() {
        return this.bh;
    }

    public final String at() {
        return this.bi;
    }

    public final String au() {
        return this.bj;
    }

    public final String av() {
        return this.bk;
    }

    public final void aw() {
        String language = Locale.getDefault().getLanguage();
        boolean z3 = true;
        if (!((TextUtils.isEmpty(this.bg) || TextUtils.isEmpty(this.bh) || TextUtils.isEmpty(this.bi) || TextUtils.isEmpty(this.bj)) ? false : true)) {
            if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                this.bg = "\u786e\u8ba4\u5173\u95ed\uff1f";
                this.bh = "\u5173\u95ed\u540e\u60a8\u5c06\u4e0d\u4f1a\u83b7\u5f97\u4efb\u4f55\u5956\u52b1\u5662~ ";
                this.bi = "\u786e\u8ba4\u5173\u95ed";
                this.bj = "\u7ee7\u7eed\u89c2\u770b";
            } else {
                this.bg = "Confirm to close? ";
                this.bh = "You will not be rewarded after closing the window";
                this.bi = "Close it";
                this.bj = "Continue";
            }
        }
        if ((TextUtils.isEmpty(this.bg) || TextUtils.isEmpty(this.bh) || TextUtils.isEmpty(this.bi) || TextUtils.isEmpty(this.bk)) ? false : false) {
            return;
        }
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            this.bg = "\u786e\u8ba4\u5173\u95ed\uff1f";
            this.bh = "\u5173\u95ed\u540e\u60a8\u5c06\u4e0d\u4f1a\u83b7\u5f97\u4efb\u4f55\u5956\u52b1\u5662~ ";
            this.bi = "\u786e\u8ba4\u5173\u95ed";
            this.bk = "\u7ee7\u7eed\u8bd5\u73a9";
            return;
        }
        this.bg = "Confirm to close? ";
        this.bh = "You will not be rewarded after closing the window";
        this.bi = "Close it";
        this.bk = "Continue";
    }

    public final String ax() {
        return this.bs;
    }

    public final String ay() {
        return this.bt;
    }

    public final String az() {
        return this.bu;
    }

    public final int b() {
        return this.Z;
    }

    public final int ba() {
        return this.bS;
    }

    public final String bb() {
        return this.bT;
    }

    public final String bc() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", this.f38682c);
            jSONObject.put("upal", this.f38683d);
            jSONObject.put("cfc", this.f38684e);
            jSONObject.put("uplc", this.f38686g);
            jSONObject.put("aa", this.f38687h);
            jSONObject.put("cfb", this.f38689j);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f38694o);
            jSONObject.put("awct", this.f38695p);
            jSONObject.put("rurl", this.f38693n);
            jSONObject.put("ujds", this.f38697r);
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, this.f38701v);
            jSONObject.put("pcto", this.aZ);
            jSONObject.put("tcto", this.ba);
            jSONObject.put("wicon", this.f38703x);
            jSONObject.put("wreq", this.f38704y);
            jSONObject.put("apk_toast", this.I);
            jSONObject.put("mv_wildcard", this.J);
            jSONObject.put("is_startup_crashsystem", this.K);
            jSONObject.put("sfct", this.bd);
            jSONObject.put("pcrn", this.f38702w);
            jSONObject.put("pcct", this.E);
            jSONObject.put("dlrf", this.C);
            jSONObject.put("dlrfct", this.D);
            jSONObject.put("upaid", this.bc);
            jSONObject.put("pctn", this.be);
            jSONObject.put("ilrf", this.aY);
            jSONObject.put(CampaignEx.JSON_KEY_ST_IEX, this.H);
            jSONObject.put("plc", this.F);
            jSONObject.put("dut", this.G);
            jSONObject.put("adct", this.bf);
            jSONObject.put("dlapk", this.aX);
            jSONObject.put("pf", this.al);
            jSONObject.put("pmax", this.an);
            jSONObject.put("pid", this.ar);
            jSONObject.put("full", this.ao);
            jSONObject.put("add", this.ap);
            jSONObject.put("delete", this.aq);
            jSONObject.put("upmi", this.bb);
            jSONObject.put("upgd", this.au);
            jSONObject.put("upsrl", this.at);
            jSONObject.put("updevid", this.av);
            jSONObject.put("sc", this.aw);
            jSONObject.put("up_tips", this.ax);
            jSONObject.put("iseu", this.az);
            jSONObject.put("up_tips_url", this.ay);
            jSONObject.put("jmc", this.aA);
            jSONObject.put("jmct", this.aC);
            jSONObject.put("atrqt", this.f38681b);
            jSONObject.put("omsdkjs_url", this.bB);
            jSONObject.put("mcs", this.aj);
            jSONObject.put("mcto", this.ai);
            jSONObject.put("GDPR_area", this.bJ);
            jSONObject.put("alrbs", this.bI);
            jSONObject.put("ct", this.bK);
            jSONObject.put("isDefault", this.bO);
            jSONObject.put("st_net", this.bS);
            jSONObject.put("vtag", this.bT);
            return jSONObject.toString();
        } catch (Throwable th) {
            x.d("Setting", th.getMessage());
            return null;
        }
    }

    public final int c() {
        return this.aa;
    }

    public final boolean d() {
        return this.ae;
    }

    public final int e() {
        return this.U;
    }

    public final int f() {
        return this.V;
    }

    public final int g() {
        return this.W;
    }

    public final int h() {
        return this.X;
    }

    public final int i() {
        return this.Y;
    }

    public final int j() {
        return this.T;
    }

    public final JSONArray k() {
        return this.R;
    }

    public final JSONArray l() {
        return this.S;
    }

    public final int m() {
        return this.Q;
    }

    public final List<com.mbridge.msdk.foundation.entity.b> n() {
        return this.M;
    }

    public final String o() {
        return this.ak;
    }

    public final int p() {
        return this.aj;
    }

    public final int q() {
        return this.f38681b;
    }

    public final boolean r() {
        return this.aT;
    }

    public final JSONObject s() {
        return this.aV;
    }

    public final int t() {
        return this.aS;
    }

    public final String toString() {
        return "cc=" + this.f38682c + " upal=" + this.f38683d + " cfc=" + this.f38684e + " getpf=" + this.f38685f + " uplc=" + this.f38686g + " rurl=" + this.f38693n;
    }

    public final int u() {
        return this.aR;
    }

    public final String v() {
        return this.aQ;
    }

    public final int w() {
        return this.aP;
    }

    public final int x() {
        return this.aL;
    }

    public final int y() {
        return this.aM;
    }

    public final int z() {
        return this.aN;
    }

    public final void A(int i4) {
        this.ap = i4;
    }

    public final void B(int i4) {
        this.aq = i4;
    }

    public final void C(int i4) {
        this.F = i4;
    }

    public final void D(int i4) {
        this.G = i4;
    }

    public final void E(int i4) {
        this.H = i4;
    }

    public final void F(int i4) {
        this.C = i4;
    }

    public final void G(int i4) {
        this.E = i4;
    }

    public final void H(int i4) {
        this.f38702w = i4;
    }

    public final void I(int i4) {
        this.f38703x = i4;
    }

    public final void J(int i4) {
        this.f38704y = i4;
    }

    public final void K(int i4) {
        this.be = i4;
    }

    public final void L(int i4) {
        this.bf = i4;
    }

    public final void M(int i4) {
        this.bb = i4;
    }

    public final void N(int i4) {
        this.bc = i4;
    }

    public final void O(int i4) {
        this.f38684e = i4;
    }

    public final void P(int i4) {
        this.f38686g = i4;
    }

    public final void Q(int i4) {
        this.ad = i4;
    }

    public final void R(int i4) {
        this.bI = i4;
    }

    public final void S(int i4) {
        this.bK = i4;
    }

    public final void T(int i4) {
        this.bO = i4;
    }

    public final void U(int i4) {
        this.bP = i4;
    }

    public final void V(int i4) {
        this.bQ = i4;
    }

    public final void a(boolean z3) {
        this.ae = z3;
    }

    public final void b(int i4) {
        this.ai = i4;
    }

    public final void c(int i4) {
        this.aj = i4;
    }

    public final void d(int i4) {
        this.f38681b = i4;
    }

    public final void e(int i4) {
        this.aS = i4;
    }

    public final void f(int i4) {
        this.aR = i4;
    }

    public final void g(int i4) {
        if (i4 > 0) {
            this.aP = i4;
        }
    }

    public final void h(int i4) {
        this.aL = i4;
    }

    public final void i(int i4) {
        this.aM = i4;
    }

    public final void j(int i4) {
        this.aN = i4;
    }

    public final void k(int i4) {
        this.aO = i4;
    }

    public final boolean l(int i4) {
        return this.aW.contains(Integer.valueOf(i4));
    }

    public final void m(int i4) {
        this.aC = i4;
    }

    public final void n(int i4) {
        this.aA = i4;
    }

    public final void o(int i4) {
        this.at = i4;
    }

    public final void p(int i4) {
        this.au = i4;
    }

    public final void q(int i4) {
        this.av = i4;
    }

    public final void r(int i4) {
        this.aw = i4;
    }

    public final void s(int i4) {
        this.ax = i4;
    }

    public final void t(int i4) {
        this.az = i4;
    }

    public final void u(int i4) {
        this.K = i4;
    }

    public final void v(int i4) {
        this.aY = i4;
    }

    public final void w(int i4) {
        this.aX = i4;
    }

    public final void x(int i4) {
        this.al = i4;
    }

    public final void y(int i4) {
        this.an = i4;
    }

    public final void z(int i4) {
        this.ao = i4;
    }

    private static Map<String, C0727a> i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C0727a c0727a = new C0727a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    c0727a.a(optJSONObject);
                }
                hashMap.put(next, c0727a);
            }
            return hashMap;
        } catch (JSONException e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
            return null;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    public final void a(int i4) {
        this.Q = i4;
    }

    public final void b(boolean z3) {
        this.aT = z3;
    }

    public final void c(String str) {
        this.J = str;
    }

    public final void d(String str) {
        this.ar = str;
    }

    public final void e(String str) {
        this.I = str;
    }

    public final void f(long j4) {
        this.f38694o = j4;
    }

    public final void g(long j4) {
        this.f38695p = j4;
    }

    public final void h(long j4) {
        this.f38683d = j4;
    }

    public static a f(String str) {
        Exception exc;
        a aVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        CampaignEx parseSettingCampaign;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            a aVar2 = new a();
            try {
                aVar2.aV = jSONObject;
                aVar2.f38682c = jSONObject.optString("cc");
                aVar2.I = jSONObject.optString("apk_toast", "\u6b63\u5728\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u53bb\u901a\u77e5\u680f\u67e5\u770b\u4e0b\u8f7d\u8fdb\u5ea6");
                aVar2.J = jSONObject.optString("mv_wildcard", "mbridge");
                aVar2.f38683d = jSONObject.optLong("upal");
                aVar2.f38684e = jSONObject.optInt("cfc");
                aVar2.f38685f = jSONObject.optLong("getpf");
                aVar2.f38686g = jSONObject.optInt("uplc");
                aVar2.f38687h = jSONObject.optBoolean("aa");
                aVar2.f38690k = jSONObject.optLong("current_time");
                aVar2.f38689j = jSONObject.optBoolean("cfb");
                aVar2.f38695p = jSONObject.optLong("awct");
                aVar2.f38694o = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT);
                aVar2.f38693n = jSONObject.optBoolean("rurl");
                aVar2.f38696q = jSONObject.optLong("uct");
                aVar2.f38697r = jSONObject.optBoolean("ujds");
                aVar2.f38698s = jSONObject.optInt("n2");
                aVar2.f38699t = jSONObject.optInt("n3");
                aVar2.K = jSONObject.optInt("is_startup_crashsystem");
                aVar2.f38700u = jSONObject.optInt("n4", 1800);
                aVar2.f38702w = jSONObject.optInt("pcrn");
                aVar2.f38701v = jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB);
                aVar2.bb = jSONObject.optInt("upmi");
                aVar2.bc = jSONObject.optInt("upaid");
                aVar2.f38702w = jSONObject.optInt("pcrn", 100);
                aVar2.f38703x = jSONObject.optInt("wicon", 2);
                aVar2.f38704y = jSONObject.optInt("wreq", 2);
                aVar2.f38705z = jSONObject.optInt("opent", 1);
                aVar2.bd = jSONObject.optLong("sfct", 1800L);
                aVar2.A = jSONObject.optString("t_vba");
                aVar2.B = jSONObject.optLong("tcct", 21600000L);
                aVar2.C = jSONObject.optInt("dlrf", 1);
                aVar2.D = jSONObject.optInt("dlrfct", DomainCampaignEx.TTC_CT_DEFAULT_VALUE);
                aVar2.E = jSONObject.optInt("pcct", 43200);
                aVar2.be = jSONObject.optInt("pctn", 3);
                aVar2.aY = jSONObject.optInt("ilrf", 1);
                aVar2.as = jSONObject.optString("pw", "");
                aVar2.aX = jSONObject.optInt("dlapk", 1);
                aVar2.au = jSONObject.optInt("upgd", 1);
                aVar2.at = jSONObject.optInt("upsrl", 1);
                aVar2.av = jSONObject.optInt("updevid", 1);
                aVar2.aw = jSONObject.optInt("sc", 0);
                aVar2.ax = jSONObject.optInt("up_tips", 1);
                aVar2.az = jSONObject.optInt("iseu", -1);
                aVar2.ay = jSONObject.optString("up_tips_url", com.mbridge.msdk.c.a.b.f38710a);
                aVar2.aA = jSONObject.optInt("jmc", 2);
                aVar2.aC = jSONObject.optInt("jmct", 86400);
                aVar2.aB = jSONObject.optString("jm_unit");
                aVar2.aE = jSONObject.optString("cdai");
                aVar2.aD = jSONObject.optString("csdai");
                aVar2.aF = jSONObject.optInt("ils");
                aVar2.V = jSONObject.optInt("rty_tk_clk", 0);
                aVar2.U = jSONObject.optInt("rty_tk_imp", 0);
                aVar2.W = jSONObject.optInt("rty_cnt", 3);
                aVar2.X = jSONObject.optInt("rty_to", 600);
                aVar2.Y = jSONObject.optInt("rty_inr", 10);
                aVar2.ah = jSONObject.optInt("clptm", 3600);
                aVar2.ag = jSONObject.optInt("clptype", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("clpcode");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    LinkedList<String> linkedList = new LinkedList<>();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        linkedList.add(optJSONArray.optString(i4));
                    }
                    aVar2.af = linkedList;
                }
                long optLong = jSONObject.optLong("pcto");
                if (optLong == 0) {
                    aVar2.aZ = 20L;
                } else {
                    aVar2.aZ = optLong;
                }
                long optLong2 = jSONObject.optLong("tcto");
                if (optLong2 == 0) {
                    aVar2.ba = 10L;
                } else {
                    aVar2.ba = optLong2;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("jt");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        HashMap hashMap = new HashMap();
                        for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
                            hashMap.put(optJSONObject.optString(DomainCampaignEx.LOOPBACK_DOMAIN), optJSONObject.optString("format"));
                        }
                        aVar2.f38688i = hashMap;
                    }
                }
                aVar2.F = jSONObject.optInt("plc", 3);
                aVar2.G = jSONObject.optInt("dut", 86400);
                aVar2.H = jSONObject.optInt(CampaignEx.JSON_KEY_ST_IEX, 1);
                JSONArray optJSONArray3 = jSONObject.optJSONArray("cal");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                        String optString = optJSONArray3.optString(i6);
                        if (ag.b(optString) && (parseSettingCampaign = CampaignEx.parseSettingCampaign(new JSONObject(optString))) != null) {
                            arrayList.add(parseSettingCampaign);
                        }
                    }
                }
                if (arrayList != null) {
                    aVar2.f38680L = arrayList;
                }
                try {
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("atf");
                    if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList();
                        for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                            String optString2 = optJSONArray4.optString(i7);
                            if (ag.b(optString2)) {
                                JSONObject jSONObject2 = new JSONObject(optString2);
                                arrayList2.add(new com.mbridge.msdk.foundation.entity.b(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList2 != null) {
                        aVar2.M = arrayList2;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                aVar2.bf = jSONObject.optInt("adct", 259200);
                aVar2.al = jSONObject.optInt("pf", 900);
                aVar2.an = jSONObject.optInt("pmax", 20);
                aVar2.ar = jSONObject.optString("pid");
                JSONArray optJSONArray5 = jSONObject.optJSONArray("pb");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                        arrayList3.add(optJSONArray5.optString(i8));
                    }
                    aVar2.am = arrayList3;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("pctrl");
                if (optJSONObject2 != null) {
                    aVar2.ao = optJSONObject2.optInt("full", 1);
                    aVar2.ap = optJSONObject2.optInt("add", 1);
                    aVar2.aq = optJSONObject2.optInt("delete", 1);
                }
                aVar2.bg = jSONObject.optString("confirm_title", "");
                aVar2.bh = jSONObject.optString("confirm_description", "");
                aVar2.bi = jSONObject.optString("confirm_t", "");
                aVar2.bj = jSONObject.optString("confirm_c_rv", "");
                aVar2.bk = jSONObject.optString("confirm_c_play", "");
                aVar2.bl = jSONObject.optInt("offercacheRate", 0);
                aVar2.bm = jSONObject.optInt("offercachepacing", 21600);
                aVar2.bn = jSONObject.optInt("useexpriedcacheoffer", 2);
                aVar2.bo = jSONObject.optInt("retryoffer", 0);
                aVar2.bp = jSONObject.optInt("mapping_cache_rate", 0);
                aVar2.bq = jSONObject.optInt("tokencachetime", DomainCampaignEx.TTC_CT_DEFAULT_VALUE);
                aVar2.br = jSONObject.optInt("protect", 0);
                aVar2.bs = jSONObject.optString("adchoice_icon", "");
                aVar2.bu = jSONObject.optString("adchoice_link", "");
                aVar2.bt = jSONObject.optString("adchoice_size", "");
                aVar2.bw = jSONObject.optString("platform_logo", "");
                aVar2.bv = jSONObject.optString("platform_name", "");
                aVar2.bx = i(jSONObject.optString("cdnate_cfg", ""));
                aVar2.f38681b = jSONObject.optInt("atrqt", 0);
                aVar2.bA = jSONObject.optInt("iupdid", 0);
                aVar2.aj = jSONObject.optInt("mcs", 120);
                aVar2.ai = jSONObject.optInt("mcto", 10);
                aVar2.ak = jSONObject.optString("ab_id", "");
                aVar2.bB = jSONObject.optString("omsdkjs_url", "");
                aVar2.bC = jSONObject.optString("omsdkjs_h5_url", "");
                aVar2.bD = jSONObject.optInt("activeAppStatus", 2);
                aVar2.bE = jSONObject.optInt("activeAppTime", 7200);
                String optString3 = jSONObject.optString("activeAppConfig");
                if (!TextUtils.isEmpty(optString3)) {
                    String b4 = s.b(optString3);
                    if (b4.startsWith("[")) {
                        JSONArray jSONArray = new JSONArray(b4);
                        if (jSONArray.length() > 0) {
                            ArrayList arrayList4 = new ArrayList();
                            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i9);
                                if (jSONObject3 != null) {
                                    com.mbridge.msdk.foundation.entity.a aVar3 = new com.mbridge.msdk.foundation.entity.a();
                                    aVar3.a(jSONObject3.optString("pn"));
                                    aVar3.b(jSONObject3.optString("at"));
                                    aVar3.c(jSONObject3.optString("ai"));
                                    aVar3.d(jSONObject3.optString("ac"));
                                    arrayList4.add(aVar3);
                                }
                            }
                            aVar2.bF = arrayList4;
                        }
                    }
                }
                aVar2.bH = jSONObject.optString("mraid_js");
                aVar2.bG = jSONObject.optString("web_env_url");
                int optInt = jSONObject.optInt("alrbs", 0);
                aVar2.bI = (optInt > 2 || optInt < 0) ? 0 : 0;
                aVar2.bJ = jSONObject.optBoolean("GDPR_area", false);
                aVar2.bK = jSONObject.optInt("ct", 120);
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ercd");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    ArrayList<Integer> arrayList5 = new ArrayList<>();
                    for (int i10 = 0; i10 < optJSONArray6.length(); i10++) {
                        int optInt2 = optJSONArray6.optInt(i10);
                        if (optInt2 != 0) {
                            arrayList5.add(Integer.valueOf(optInt2));
                        }
                    }
                    if (arrayList5.size() > 0) {
                        arrayList5.add(-1);
                        aVar2.bL = arrayList5;
                    }
                }
                String optString4 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(optString4)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(s.b(optString4));
                        Iterator<String> keys = jSONObject4.keys();
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject4.optString(next)) && !TextUtils.isEmpty(s.b(jSONObject4.optString(next)))) {
                                hashMap2.put(next, jSONObject4.optString(next));
                            }
                        }
                        if (hashMap2.size() > 0) {
                            aVar2.bM = hashMap2;
                        }
                    } catch (Exception e5) {
                        x.d("SETTING", e5.getMessage());
                    }
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("refactor_switch");
                if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                    for (int i11 = 0; i11 < optJSONArray7.length(); i11++) {
                        JSONObject jSONObject5 = optJSONArray7.getJSONObject(i11);
                        Iterator<String> keys2 = jSONObject5.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject5.getBoolean(next2)) {
                                aVar2.aW.add(Integer.valueOf(Integer.parseInt(next2)));
                            }
                        }
                    }
                }
                try {
                    int optInt3 = jSONObject.optInt("lqcnt", 30);
                    int optInt4 = jSONObject.optInt("lqto", 5);
                    int optInt5 = jSONObject.optInt("lqswt", 0);
                    int optInt6 = jSONObject.optInt("lqtype", 0);
                    aVar2.aH = optInt4;
                    aVar2.aG = optInt3;
                    aVar2.aI = optInt5;
                    aVar2.aJ = optInt6;
                    JSONArray optJSONArray8 = jSONObject.optJSONArray("lg_bl");
                    if (optJSONArray8 == null) {
                        optJSONArray8 = new JSONArray();
                        optJSONArray8.put("2000088");
                    }
                    aVar2.S = optJSONArray8;
                    JSONArray optJSONArray9 = jSONObject.optJSONArray("lg_wl");
                    if (optJSONArray9 == null) {
                        optJSONArray9 = new JSONArray();
                        optJSONArray9.put("2000041");
                        optJSONArray9.put("2000042");
                        optJSONArray9.put("2000032");
                        optJSONArray9.put("2000079");
                    }
                    aVar2.R = optJSONArray9;
                    aVar2.T = jSONObject.optInt("lg_wl_rt");
                    aVar2.Z = jSONObject.optInt("srml", AVMDLDataLoader.KeyIsLiveSetLoaderType);
                    aVar2.aa = jSONObject.optInt("lrml", AVMDLDataLoader.KeyIsLiveSetLoaderType);
                    aVar2.ab = jSONObject.optInt("wgl_d_ms", 1300);
                    int optInt7 = jSONObject.optInt("dp_ct", f38679a);
                    aVar2.ac = optInt7;
                    com.mbridge.msdk.click.b.a.f38895c = optInt7;
                    int parseInt = Integer.parseInt(s.b(jSONObject.optString("lqpt")));
                    if (parseInt > 0 && parseInt < 65535) {
                        aVar2.aK = parseInt;
                        com.mbridge.msdk.foundation.same.net.f.d.a().f39569f = parseInt;
                        com.mbridge.msdk.foundation.same.net.f.d.a().f39570g = parseInt;
                    }
                } catch (Exception unused) {
                }
                aVar2.bN = jSONObject.optInt("wvddt", 0);
                aVar2.f38691l = jSONObject.optString("hst_st", "");
                aVar2.f38692m = jSONObject.optString("hst_st_t", "");
                try {
                    int optInt8 = jSONObject.optInt("l", 3);
                    boolean z3 = jSONObject.optInt("k", 0) == 1;
                    boolean z4 = jSONObject.optInt("m", 1) == 1;
                    aVar2.O = optInt8;
                    aVar2.N = z3;
                    aVar2.P = z4;
                } catch (Exception e6) {
                    x.d("Setting", e6.getMessage());
                }
                aVar2.by = jSONObject.optInt("fbk_swt", 0);
                aVar2.bz = b.a(jSONObject.optJSONObject("fbk"));
                try {
                    int optInt9 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.f39372L);
                    int optInt10 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.M);
                    int optInt11 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.N);
                    int optInt12 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.R);
                    if (optInt9 <= 0) {
                        optInt9 = com.mbridge.msdk.foundation.same.a.f39372L;
                    }
                    aVar2.aN = optInt9;
                    if (optInt10 <= 0) {
                        optInt10 = com.mbridge.msdk.foundation.same.a.M;
                    }
                    aVar2.aL = optInt10;
                    if (optInt11 <= 0) {
                        optInt11 = com.mbridge.msdk.foundation.same.a.N;
                    }
                    aVar2.aM = optInt11;
                    if (optInt12 < 0) {
                        optInt12 = com.mbridge.msdk.foundation.same.a.R;
                    }
                    aVar2.aO = optInt12;
                    int optInt13 = jSONObject.optInt("max_download_task_size", 10);
                    if (optInt13 <= 0) {
                        optInt13 = 10;
                    }
                    aVar2.Q = optInt13;
                    aVar2.g(jSONObject.optInt("max_bitmap_cache_size", 10));
                    aVar2.bQ = jSONObject.optInt("t_t");
                    aVar2.bP = jSONObject.optInt("h_t");
                    int optInt14 = jSONObject.optInt("gtp");
                    aVar2.bR = optInt14;
                    com.mbridge.msdk.foundation.same.net.f.d.a().a(optInt14);
                } catch (Exception unused2) {
                }
                try {
                    aVar2.aQ = jSONObject.optString("http_track_url", "");
                } catch (Exception unused3) {
                }
                try {
                    aVar2.aR = jSONObject.optInt("is_transmission_available", 1);
                    aVar2.aS = jSONObject.optInt("is_transmission_delay", 24);
                } catch (Exception unused4) {
                    aVar2.aR = 1;
                    aVar2.aS = 24;
                }
                aVar2.bS = jSONObject.optInt("st_net", 1);
                aVar2.bT = jSONObject.optString("vtag", "");
                try {
                    aVar2.ae = jSONObject.optInt("check_webview", 0) != 0;
                } catch (Exception unused5) {
                    aVar2.ae = false;
                }
                String optString5 = jSONObject.optString("swxid");
                if (!TextUtils.isEmpty(aVar2.aU)) {
                    aVar2.aU = optString5;
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.a.f().m())) {
                        com.mbridge.msdk.foundation.controller.a.f().e(aVar2.aU);
                    }
                }
                try {
                    aVar2.ad = jSONObject.optInt("ch_nv_im_cb", 1);
                } catch (Exception unused6) {
                    aVar2.ad = 1;
                }
                try {
                    aVar2.aT = jSONObject.optInt("do_us_fi_re", 1) != 0;
                } catch (Exception unused7) {
                    aVar2.aT = true;
                }
                return aVar2;
            } catch (Exception e7) {
                exc = e7;
                aVar = aVar2;
                exc.printStackTrace();
                return aVar;
            }
        } catch (Exception e8) {
            exc = e8;
            aVar = null;
        }
    }

    public final void W(int i4) {
        this.bS = i4;
    }

    public final void a(String str) {
        this.aQ = str;
    }

    public final void b(String str) {
        this.ay = str;
    }

    public final void c(long j4) {
        this.bd = j4;
    }

    public final void d(long j4) {
        this.aZ = j4;
    }

    public final void e(long j4) {
        this.ba = j4;
    }

    public final void g(String str) {
        this.bC = str;
    }

    public final void h(String str) {
        this.bB = str;
    }

    public final void a(long j4) {
        this.D = j4;
    }

    public final void b(long j4) {
        this.f38701v = j4;
    }

    public final void c(boolean z3) {
        this.f38697r = z3;
    }

    public final void d(boolean z3) {
        this.f38693n = z3;
    }

    public final void e(boolean z3) {
        this.f38687h = z3;
    }

    public final void g(boolean z3) {
        this.bJ = z3;
    }

    public static String a(Context context, String str) {
        a b4;
        String str2 = "";
        try {
            b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        } catch (Throwable unused) {
        }
        if (b4 != null && b4.f38688i != null) {
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> entry : b4.f38688i.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(key)) {
                    String str3 = b4.f38688i.get(key);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    String replace = str3.replace("{gaid}", t.E());
                    if (replace.contains("{android_id}")) {
                        if (e.g(context) != null) {
                            str2 = replace.replace("{android_id}", e.g(context));
                        }
                        str2 = replace;
                    } else {
                        if (replace.contains("{android_id_md5_upper}") && e.h(context) != null) {
                            str2 = replace.replace("{android_id_md5_upper}", e.h(context));
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
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f38711a;

        /* renamed from: b  reason: collision with root package name */
        private String f38712b;

        /* renamed from: c  reason: collision with root package name */
        private String f38713c;

        /* renamed from: d  reason: collision with root package name */
        private JSONArray f38714d;

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b bVar = new b();
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            bVar.f38711a = jSONObject.optString("title", j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_title", "string")));
            bVar.f38712b = jSONObject.optString("cancel", j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_close_close", "string")));
            bVar.f38713c = jSONObject.optString("submit", j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_close_submit", "string")));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            bVar.f38714d = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.f38714d = jSONArray;
                jSONArray.put(j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_content_stuck", "string")));
                bVar.f38714d.put(j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_content_cnr", "string")));
                bVar.f38714d.put(j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_content_balck_screen", "string")));
                bVar.f38714d.put(j4.getString(r.a(j4, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return bVar;
        }

        public final String b() {
            return this.f38712b;
        }

        public final String c() {
            return this.f38713c;
        }

        public final JSONArray d() {
            return this.f38714d;
        }

        public final String a() {
            return this.f38711a;
        }
    }

    public final void f(boolean z3) {
        this.f38689j = z3;
    }
}
