package com.bytedance.sdk.component.adexpress.dynamic.xv;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private double f29344a;
    private int au;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29345b;
    private double ba;
    private String be;
    private String bj;
    private String bk;
    private boolean bm;
    private boolean bs;
    private int bw;

    /* renamed from: c  reason: collision with root package name */
    private float f29346c;
    private int ck;
    private int db;
    private long dk = -1;

    /* renamed from: e  reason: collision with root package name */
    private List<c> f29347e;
    private boolean eb;
    private String eq;
    private int eu;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private float f29348f;
    private int fm;
    private String fp;
    private String fz;

    /* renamed from: g  reason: collision with root package name */
    private String f29349g;
    private boolean gb;
    private float gd;
    private int ge;
    private JSONObject gp;
    private double gw;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29350h;

    /* renamed from: i  reason: collision with root package name */
    private String f29351i;
    private String ia;
    private double iw;
    private String ix;

    /* renamed from: j  reason: collision with root package name */
    private String f29352j;
    private int jd;
    private String jr;
    private String ju;
    private boolean jv;

    /* renamed from: k  reason: collision with root package name */
    private double f29353k;
    private int kk;
    private int kn;
    private int kr;
    private boolean ky;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29354l;
    private int lf;
    private String ls;
    private boolean lw;

    /* renamed from: m  reason: collision with root package name */
    private int f29355m;
    private String me;
    private JSONObject mk;
    private int mt;
    private int mu;

    /* renamed from: n  reason: collision with root package name */
    private int f29356n;
    private String nc;
    private int nd;
    private JSONObject ng;
    private int ny;

    /* renamed from: o  reason: collision with root package name */
    private int f29357o;
    private int oh;
    private int ok;
    private boolean oo;
    private boolean ox;

    /* renamed from: p  reason: collision with root package name */
    private float f29358p;
    private String pb;
    private int pr;
    private int pu;

    /* renamed from: q  reason: collision with root package name */
    private String f29359q;
    private boolean qy;

    /* renamed from: r  reason: collision with root package name */
    private float f29360r;
    private String rd;
    private boolean rh;

    /* renamed from: s  reason: collision with root package name */
    private String f29361s;
    private float sr;

    /* renamed from: t  reason: collision with root package name */
    private String f29362t;
    private int ta;
    private int te;
    private int tl;
    private String tx;

    /* renamed from: u  reason: collision with root package name */
    private String f29363u;
    private boolean up;
    private boolean ux;

    /* renamed from: v  reason: collision with root package name */
    private int f29364v;
    private int vc;

    /* renamed from: w  reason: collision with root package name */
    private float f29365w;
    private boolean wo;
    private String wv;
    private int wx;

    /* renamed from: x  reason: collision with root package name */
    private int f29366x;
    private int xg;
    private String xk;
    private String xu;
    private float xv;

    /* renamed from: y  reason: collision with root package name */
    private String f29367y;
    private int yh;
    private int yn;
    private String ys;
    private boolean yu;

    /* renamed from: z  reason: collision with root package name */
    private double f29368z;
    private JSONObject zg;
    private int zr;
    private int zt;

    public static f c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.w(jSONObject.optString("adType", "embeded"));
        fVar.ys(jSONObject.optString("clickArea", "creative"));
        fVar.fp(jSONObject.optString("clickTigger", "click"));
        fVar.xv(jSONObject.optString("fontFamily", "PingFangSC"));
        fVar.sr(jSONObject.optString("textAlign", "left"));
        fVar.ux(jSONObject.optString("color", "#999999"));
        fVar.f(jSONObject.optString("bgColor", "transparent"));
        fVar.r(jSONObject.optString("bgImgUrl", ""));
        fVar.ck(jSONObject.optString("bgImgData", ""));
        fVar.ev(jSONObject.optString("borderColor", "#000000"));
        fVar.gd(jSONObject.optString("borderStyle", "solid"));
        fVar.p(jSONObject.optString("heightMode", "auto"));
        fVar.k(jSONObject.optString("widthMode", "fixed"));
        fVar.a(jSONObject.optString("interactText", ""));
        fVar.xv(jSONObject.optBoolean("isShowBgControl", false));
        fVar.bk(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            fVar.r(optJSONObject.optInt("translateY", 0));
            fVar.ev(optJSONObject.optInt("translateX", 0));
            fVar.sr(optJSONObject.optDouble("scaleX", 0.0d));
            fVar.ux(optJSONObject.optDouble("scaleY", 0.0d));
        }
        fVar.t(jSONObject.optString("interactType", ""));
        fVar.ux(jSONObject.optInt("interactSlideDirection", -1));
        fVar.ia(jSONObject.optString("justifyHorizontal", "space-around"));
        fVar.s(jSONObject.optString("justifyVertical", "flex-start"));
        fVar.w(jSONObject.optDouble("timingStart"));
        fVar.xv(jSONObject.optDouble("timingEnd"));
        fVar.sr((float) jSONObject.optDouble("width", 0.0d));
        fVar.xv((float) jSONObject.optDouble("height", 0.0d));
        fVar.c((float) jSONObject.optDouble("borderRadius", 0.0d));
        fVar.w((float) jSONObject.optDouble("borderSize", 0.0d));
        fVar.w(jSONObject.optBoolean("interactValidate", false));
        fVar.gd((float) jSONObject.optDouble("fontSize", 0.0d));
        fVar.ux((float) jSONObject.optDouble("paddingBottom", 0.0d));
        fVar.f((float) jSONObject.optDouble("paddingLeft", 0.0d));
        fVar.r((float) jSONObject.optDouble("paddingRight", 0.0d));
        fVar.ev((float) jSONObject.optDouble("paddingTop", 0.0d));
        fVar.sr(jSONObject.optBoolean("lineFeed", false));
        fVar.gd(jSONObject.optInt("lineCount", 0));
        fVar.f(jSONObject.optDouble("lineHeight", 1.2d));
        fVar.t(jSONObject.optInt("letterSpacing", 0));
        fVar.ux(jSONObject.optBoolean("isDataFixed", false));
        fVar.ys(jSONObject.optInt("fontWeight"));
        fVar.f(jSONObject.optBoolean("lineLimit"));
        fVar.fp(jSONObject.optInt("position"));
        fVar.fz(jSONObject.optString("align"));
        fVar.r(jSONObject.optBoolean("useLeft"));
        fVar.ev(jSONObject.optBoolean("useRight"));
        fVar.gd(jSONObject.optBoolean("useTop"));
        fVar.p(jSONObject.optBoolean("useBottom"));
        fVar.u(jSONObject.optString("data"));
        fVar.w(jSONObject.optJSONObject("i18n"));
        fVar.a(jSONObject.optInt("marginLeft"));
        fVar.bk(jSONObject.optInt("marginRight"));
        fVar.p(jSONObject.optInt("marginTop"));
        fVar.k(jSONObject.optInt("marginBottom"));
        fVar.ia(jSONObject.optInt("tagMaxCount"));
        fVar.k(jSONObject.optBoolean("allowTextFlow"));
        fVar.s(jSONObject.optInt("textFlowType"));
        fVar.fz(jSONObject.optInt("textFlowDuration"));
        fVar.u(jSONObject.optInt("left"));
        fVar.i(jSONObject.optInt("right"));
        fVar.q(jSONObject.optInt("top"));
        fVar.j(jSONObject.optInt("bottom"));
        fVar.i(jSONObject.optString("alignItems", "flex-start"));
        fVar.q(jSONObject.optString("direction", ""));
        fVar.c(jSONObject.optBoolean("loop", false));
        fVar.ls(jSONObject.optInt("zIndex"));
        fVar.ba(jSONObject.optInt("interactVisibleTime"));
        fVar.gb(jSONObject.optInt("interactHiddenTime"));
        fVar.bk(jSONObject.optBoolean("interactEnableMask"));
        fVar.t(jSONObject.optBoolean("interactWontHide"));
        fVar.c(jSONObject.optString("bgGradient"));
        fVar.eq(jSONObject.optInt("areaType"));
        fVar.me(jSONObject.optInt("interactSlideThreshold", 0));
        fVar.yu(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.sr.c() ? 0 : 120));
        fVar.s(jSONObject.optBoolean("openPlayableLandingPage", false));
        fVar.xv(jSONObject.optJSONObject("video"));
        fVar.sr(jSONObject.optJSONObject("image"));
        fVar.wv(jSONObject.optInt("borderShadowExtent"));
        fVar.ys(jSONObject.optBoolean("bgGauseBlur"));
        fVar.xk(jSONObject.optInt("bgGauseBlurRadius"));
        fVar.fp(jSONObject.optBoolean("showTimeProgress", false));
        fVar.ia(jSONObject.optBoolean("showPlayButton", false));
        fVar.c(jSONObject.optDouble("bgColorCg", 0.0d));
        fVar.f(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        fVar.w(jSONObject.optInt("borderTopLeftRadius", 0));
        fVar.c(jSONObject.optInt("borderTopRightRadius", 0));
        fVar.sr(jSONObject.optInt("borderBottomLeftRadius", 0));
        fVar.xv(jSONObject.optInt("borderBottomRightRadius", 0));
        fVar.ux(jSONObject.optJSONObject("interactI18n"));
        fVar.ls(jSONObject.optString("imageObjectFit"));
        fVar.gb(jSONObject.optString("interactTitle"));
        fVar.y(jSONObject.optInt("interactTextPositionTop"));
        fVar.j(jSONObject.optString("imageLottieTosPath"));
        fVar.a(jSONObject.optBoolean("animationsLoop"));
        fVar.n(jSONObject.optInt("lottieAppNameMaxLength"));
        fVar.z(jSONObject.optInt("lottieAdDescMaxLength"));
        fVar.ck(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    c cVar = new c();
                    cVar.xv(jSONObject2.optString("animationType"));
                    cVar.c(jSONObject2.optDouble("animationDuration"));
                    cVar.w(jSONObject2.optDouble("animationScaleX"));
                    cVar.xv(jSONObject2.optDouble("animationScaleY"));
                    cVar.sr(jSONObject2.optString("animationTimeFunction"));
                    cVar.sr(jSONObject2.optDouble("animationDelay"));
                    cVar.f(jSONObject2.optInt("animationIterationCount"));
                    cVar.ux(jSONObject2.optString("animationDirection"));
                    cVar.ux(jSONObject2.optDouble("animationInterval"));
                    cVar.c(jSONObject2.optInt("animationBorderWidth"));
                    cVar.c(jSONObject2.optLong(DomainCampaignEx.LOOPBACK_KEY));
                    cVar.w(jSONObject2.optInt("animationEffectWidth"));
                    cVar.xv(jSONObject2.optInt("animationSwing", 1));
                    cVar.sr(jSONObject2.optInt("animationTranslateX"));
                    cVar.ux(jSONObject2.optInt("animationTranslateY"));
                    cVar.w(jSONObject2.optString("animationRippleBackgroundColor"));
                    cVar.c(jSONObject2.optString("animationScaleDirection"));
                    cVar.r(jSONObject2.optInt("animationFadeStart"));
                    cVar.ev(jSONObject2.optInt("animationFadeEnd"));
                    cVar.f(jSONObject2.optString("animationFillMode"));
                    cVar.gd(jSONObject2.optInt("animationBounceHeight"));
                    if (fVar.fz() > 0.0d) {
                        cVar.sr(cVar.t() + fVar.fz());
                    }
                    arrayList.add(cVar);
                }
                fVar.c(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                fVar.n(jSONObject.optString("triggerSlideDirection", "0"));
                fVar.c(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return fVar;
    }

    private void ck(String str) {
        this.jr = str;
    }

    public float a() {
        return this.f29365w;
    }

    public int au() {
        return this.f29355m;
    }

    public boolean b() {
        return this.up;
    }

    public String ba() {
        return this.f29352j;
    }

    public int be() {
        return this.oh;
    }

    public double bj() {
        return this.gw;
    }

    public boolean bk() {
        return this.ux;
    }

    public int bm() {
        return this.vc;
    }

    public int bs() {
        return this.te;
    }

    public String bw() {
        return this.me;
    }

    public String db() {
        return this.tx;
    }

    public String e() {
        return this.be;
    }

    public boolean eb() {
        return this.ky;
    }

    public boolean eq() {
        return this.gb;
    }

    public boolean eu() {
        return this.f29350h;
    }

    public double ev() {
        return this.iw;
    }

    public JSONObject f() {
        return this.mk;
    }

    public boolean fm() {
        return this.ox;
    }

    public float fp() {
        return this.ev;
    }

    public double fz() {
        return this.f29353k;
    }

    public int g() {
        return this.fm;
    }

    public String gb() {
        return this.jr;
    }

    public int gd() {
        return this.yn;
    }

    public JSONObject ge() {
        return this.ng;
    }

    public boolean gp() {
        return this.jv;
    }

    public boolean gw() {
        return this.yu;
    }

    public boolean h() {
        return this.f29345b;
    }

    public String i() {
        return this.ys;
    }

    public float ia() {
        return this.gd;
    }

    public int iw() {
        return this.mu;
    }

    public String j() {
        return this.ia;
    }

    public int jd() {
        return this.kn;
    }

    public long ju() {
        return this.dk;
    }

    public int jv() {
        List<c> list = this.f29347e;
        if (list != null) {
            for (c cVar : list) {
                if ("translate".equals(cVar.gd()) && cVar.r() < 0) {
                    return -cVar.r();
                }
            }
            return 0;
        }
        return 0;
    }

    public float k() {
        return this.f29346c;
    }

    public int kk() {
        return this.lf;
    }

    public int kn() {
        return this.ny;
    }

    public int kr() {
        return this.zt;
    }

    public JSONObject ky() {
        return this.zg;
    }

    public String l() {
        return this.rd;
    }

    public int lf() {
        return this.ge;
    }

    public String ls() {
        return this.f29361s;
    }

    public int lw() {
        return this.nd;
    }

    public String m() {
        return this.xk;
    }

    public int me() {
        return this.f29356n;
    }

    public int mk() {
        return this.tl;
    }

    public int mt() {
        return this.bw;
    }

    public int mu() {
        return this.eu;
    }

    public String n() {
        return this.fz;
    }

    public boolean nc() {
        return this.qy;
    }

    public void nd() {
        c(this, this.gp);
    }

    public String ng() {
        return this.bj;
    }

    public void ny() {
        c(this, this.zg);
    }

    public int o() {
        return this.jd;
    }

    public boolean oh() {
        return this.wo;
    }

    public boolean ok() {
        return this.bm;
    }

    public int oo() {
        return this.f29366x;
    }

    public boolean ox() {
        return this.oo;
    }

    public String p() {
        return this.ix;
    }

    public boolean pb() {
        return this.lw;
    }

    public String pr() {
        return this.eq;
    }

    public boolean pu() {
        return this.rh;
    }

    public String q() {
        return this.fp;
    }

    public boolean qy() {
        return this.f29354l;
    }

    public int r() {
        return this.f29357o;
    }

    public List<c> rd() {
        return this.f29347e;
    }

    public int rh() {
        return this.db;
    }

    public float s() {
        return this.f29358p;
    }

    public int sr() {
        return this.kr;
    }

    public float t() {
        return this.f29348f;
    }

    public int ta() {
        return this.ok;
    }

    public String te() {
        return this.xu;
    }

    public String tl() {
        return this.f29349g;
    }

    public String tx() {
        return this.ju;
    }

    public double u() {
        return this.f29344a;
    }

    public int up() {
        return this.pr;
    }

    public int ux() {
        return this.pu;
    }

    public boolean v() {
        return this.eb;
    }

    public int vc() {
        return this.wx;
    }

    public int w() {
        return this.yh;
    }

    public int wo() {
        return this.mt;
    }

    public int wv() {
        return this.ck;
    }

    public String wx() {
        return this.f29367y;
    }

    public String x() {
        return this.wv;
    }

    public int xg() {
        return this.ta;
    }

    public double xk() {
        return this.f29368z;
    }

    public int xu() {
        return this.au;
    }

    public int xv() {
        return this.f29364v;
    }

    public String y() {
        return this.ls;
    }

    public int yh() {
        return this.zr;
    }

    public int yn() {
        return this.kk;
    }

    public float ys() {
        return this.f29360r;
    }

    public double yu() {
        return this.ba;
    }

    public String z() {
        return this.f29359q;
    }

    public String zg() {
        return this.pb;
    }

    public int zr() {
        return this.xg;
    }

    public String zt() {
        return this.nc;
    }

    public void a(String str) {
        this.f29352j = str;
    }

    public void ba(int i4) {
        this.mu = i4;
    }

    public void bk(String str) {
        this.ls = str;
    }

    public String ck() {
        return this.f29351i;
    }

    public void eq(int i4) {
        this.tl = i4;
    }

    public void ev(float f4) {
        this.gd = f4;
    }

    public void f(int i4) {
        this.yn = i4;
    }

    public void fp(String str) {
        this.me = str;
    }

    public void fz(String str) {
        this.bj = str;
    }

    public void gb(int i4) {
        this.xg = i4;
    }

    public void gd(float f4) {
        this.f29358p = f4;
    }

    public void i(int i4) {
        this.ge = i4;
    }

    public void ia(String str) {
        this.wv = str;
    }

    public void j(int i4) {
        this.eu = i4;
    }

    public void k(String str) {
        this.f29359q = str;
    }

    public void ls(int i4) {
        this.lf = i4;
    }

    public void me(int i4) {
        this.kk = i4;
    }

    public void n(int i4) {
        this.db = i4;
    }

    public void p(String str) {
        this.f29351i = str;
    }

    public void q(int i4) {
        this.ta = i4;
    }

    public void r(float f4) {
        this.ev = f4;
    }

    public void s(String str) {
        this.xk = str;
    }

    public void sr(int i4) {
        this.pu = i4;
    }

    public void t(String str) {
        this.f29367y = str;
    }

    public void u(String str) {
        this.xu = str;
    }

    public void ux(int i4) {
        this.f29357o = i4;
    }

    public void w(int i4) {
        this.f29364v = i4;
    }

    public void wv(int i4) {
        this.zr = i4;
    }

    public void xk(int i4) {
        this.zt = i4;
    }

    public void xv(int i4) {
        this.kr = i4;
    }

    public void y(int i4) {
        this.jd = i4;
    }

    public void ys(String str) {
        this.eq = str;
    }

    public void yu(int i4) {
        this.kn = i4;
    }

    public void z(int i4) {
        this.ny = i4;
    }

    public void a(int i4) {
        this.f29366x = i4;
    }

    public void bk(int i4) {
        this.f29355m = i4;
    }

    public void ck(int i4) {
        this.nd = i4;
    }

    public void ev(String str) {
        this.fz = str;
    }

    public void f(float f4) {
        this.f29360r = f4;
    }

    public void fp(int i4) {
        this.au = i4;
    }

    public void fz(int i4) {
        this.fm = i4;
    }

    public void gb(String str) {
        this.tx = str;
    }

    public void gd(String str) {
        this.f29363u = str;
    }

    public void i(String str) {
        this.be = str;
    }

    public void ia(int i4) {
        this.ok = i4;
    }

    public void j(String str) {
        this.nc = str;
    }

    public void k(int i4) {
        this.bw = i4;
    }

    public void ls(String str) {
        this.pb = str;
    }

    public void n(String str) {
        this.ju = str;
    }

    public void p(int i4) {
        this.pr = i4;
    }

    public void q(String str) {
        this.f29349g = str;
    }

    public void r(String str) {
        this.f29361s = str;
    }

    public void s(int i4) {
        this.oh = i4;
    }

    public void sr(float f4) {
        this.sr = f4;
    }

    public void t(int i4) {
        this.vc = i4;
    }

    public void u(int i4) {
        this.te = i4;
    }

    public void ux(float f4) {
        this.f29348f = f4;
    }

    public void w(float f4) {
        this.f29365w = f4;
    }

    public void xv(float f4) {
        this.xv = f4;
    }

    public void ys(int i4) {
        this.mt = i4;
    }

    public void a(boolean z3) {
        this.ky = z3;
    }

    public void bk(boolean z3) {
        this.f29354l = z3;
    }

    public void ev(int i4) {
        this.ck = i4;
    }

    public void f(String str) {
        this.ia = str;
    }

    public void fp(boolean z3) {
        this.rh = z3;
    }

    public void gd(int i4) {
        this.wx = i4;
    }

    public void ia(boolean z3) {
        this.lw = z3;
    }

    public void k(boolean z3) {
        this.f29350h = z3;
    }

    public void p(boolean z3) {
        this.ox = z3;
    }

    public void r(int i4) {
        this.f29356n = i4;
    }

    public void s(boolean z3) {
        this.qy = z3;
    }

    public void sr(String str) {
        this.ys = str;
    }

    public void t(boolean z3) {
        this.jv = z3;
    }

    public void ux(String str) {
        this.fp = str;
    }

    public void w(boolean z3) {
        this.ux = z3;
    }

    public void xv(double d4) {
        this.f29344a = d4;
    }

    public void ys(boolean z3) {
        this.eb = z3;
    }

    public void ev(boolean z3) {
        this.f29345b = z3;
    }

    public void f(double d4) {
        this.gw = d4;
    }

    public void gd(boolean z3) {
        this.wo = z3;
    }

    public void r(boolean z3) {
        this.bm = z3;
    }

    public void sr(double d4) {
        this.f29368z = d4;
    }

    public void ux(double d4) {
        this.ba = d4;
    }

    public void w(double d4) {
        this.f29353k = d4;
    }

    public void xv(String str) {
        this.f29362t = str;
    }

    public void f(boolean z3) {
        this.oo = z3;
    }

    public void sr(boolean z3) {
        this.yu = z3;
    }

    public void ux(boolean z3) {
        this.up = z3;
    }

    public void w(String str) {
        this.bk = str;
    }

    public void xv(boolean z3) {
        this.gb = z3;
    }

    public void sr(JSONObject jSONObject) {
        this.zg = jSONObject;
    }

    public void ux(JSONObject jSONObject) {
        this.mk = jSONObject;
    }

    public void w(JSONObject jSONObject) {
        this.ng = jSONObject;
    }

    public void xv(JSONObject jSONObject) {
        this.gp = jSONObject;
    }

    public boolean c() {
        return this.bs;
    }

    public void c(boolean z3) {
        this.bs = z3;
    }

    public void c(int i4) {
        this.yh = i4;
    }

    public void c(double d4) {
        this.iw = d4;
    }

    public void c(String str) {
        this.ix = str;
    }

    public void c(float f4) {
        this.f29346c = f4;
    }

    public void c(List<c> list) {
        this.f29347e = list;
    }

    public void c(long j4) {
        this.dk = j4;
    }

    private void c(f fVar, JSONObject jSONObject) {
        if (fVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            next.hashCode();
            char c4 = '\uffff';
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        c4 = '\r';
                        break;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        c4 = 14;
                        break;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        c4 = 15;
                        break;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        c4 = 16;
                        break;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        c4 = 17;
                        break;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        c4 = 18;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c4 = 19;
                        break;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        c4 = 20;
                        break;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        c4 = 21;
                        break;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        c4 = 22;
                        break;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        c4 = 23;
                        break;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        c4 = 24;
                        break;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        c4 = 25;
                        break;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        c4 = 26;
                        break;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        c4 = 27;
                        break;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        c4 = 28;
                        break;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        c4 = 29;
                        break;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        c4 = 30;
                        break;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        c4 = 31;
                        break;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        c4 = ' ';
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        c4 = '!';
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        c4 = '\"';
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        c4 = '#';
                        break;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        c4 = '$';
                        break;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        c4 = '%';
                        break;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        c4 = '&';
                        break;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        c4 = '\'';
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        c4 = '(';
                        break;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        c4 = ')';
                        break;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        c4 = '*';
                        break;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        c4 = '+';
                        break;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        c4 = ',';
                        break;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        c4 = '-';
                        break;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        c4 = '.';
                        break;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        c4 = '/';
                        break;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        c4 = '0';
                        break;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        c4 = '1';
                        break;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        c4 = '2';
                        break;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        c4 = '3';
                        break;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        c4 = '4';
                        break;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        c4 = '5';
                        break;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        c4 = '6';
                        break;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        c4 = '7';
                        break;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        c4 = '8';
                        break;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        c4 = '9';
                        break;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        c4 = ':';
                        break;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        c4 = ';';
                        break;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        c4 = '<';
                        break;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        c4 = '=';
                        break;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        c4 = '>';
                        break;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        c4 = '?';
                        break;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        c4 = '@';
                        break;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        c4 = 'A';
                        break;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        c4 = 'B';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    fVar.xv(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    fVar.ys(jSONObject.optString(next));
                    break;
                case 2:
                    fVar.n(jSONObject.optString(next));
                    break;
                case 3:
                    fVar.r(jSONObject.optString(next));
                    break;
                case 4:
                    fVar.gd(jSONObject.optInt(next));
                    break;
                case 5:
                    fVar.s(jSONObject.optBoolean(next));
                    break;
                case 6:
                    fVar.f(jSONObject.optBoolean(next));
                    break;
                case 7:
                    fVar.bk(jSONObject.optString(next));
                    break;
                case '\b':
                    fVar.f((float) jSONObject.optDouble(next));
                    break;
                case '\t':
                    fVar.w(jSONObject.optString(next));
                    break;
                case '\n':
                    fVar.j(jSONObject.optInt(next));
                    break;
                case 11:
                    fVar.xv(jSONObject.optString(next));
                    break;
                case '\f':
                    fVar.xv((float) jSONObject.optDouble(next));
                    break;
                case '\r':
                    fVar.sr(jSONObject.optString(next));
                    break;
                case 14:
                    fVar.i(jSONObject.optString(next));
                    break;
                case 15:
                    fVar.w(jSONObject.optBoolean(next));
                    break;
                case 16:
                    fVar.p(jSONObject.optInt(next));
                    break;
                case 17:
                    fVar.p(jSONObject.optBoolean(next));
                    break;
                case 18:
                    fVar.c(jSONObject.optLong(next));
                    break;
                case 19:
                    fVar.q(jSONObject.optString(next));
                    break;
                case 20:
                    fVar.ia(jSONObject.optInt(next));
                    break;
                case 21:
                    fVar.gb(jSONObject.optInt(next));
                    break;
                case 22:
                    fVar.gd(jSONObject.optBoolean(next));
                    break;
                case 23:
                    fVar.ys(jSONObject.optInt(next));
                    break;
                case 24:
                    fVar.ls(jSONObject.optInt(next));
                    break;
                case 25:
                    fVar.w(jSONObject.optDouble(next));
                    break;
                case 26:
                    fVar.f(jSONObject.optDouble(next));
                    break;
                case 27:
                    fVar.fz(jSONObject.optInt(next));
                    break;
                case 28:
                    fVar.ev(jSONObject.optBoolean(next));
                    break;
                case 29:
                    fVar.k(jSONObject.optInt(next));
                    break;
                case 30:
                    fVar.f(jSONObject.optString(next));
                    break;
                case 31:
                    fVar.r(jSONObject.optBoolean(next));
                    break;
                case ' ':
                    fVar.k(jSONObject.optString(next));
                    break;
                case '!':
                    fVar.q(jSONObject.optInt(next));
                    break;
                case '\"':
                    fVar.u(jSONObject.optString(next));
                    break;
                case '#':
                    fVar.u(jSONObject.optInt(next));
                    break;
                case '$':
                    fVar.c(jSONObject.optBoolean(next));
                    break;
                case '%':
                    fVar.ev((float) jSONObject.optDouble(next));
                    break;
                case '&':
                    fVar.fz(jSONObject.optString(next));
                    break;
                case '\'':
                    fVar.ux(jSONObject.optString(next));
                    break;
                case '(':
                    fVar.i(jSONObject.optInt(next));
                    break;
                case ')':
                    fVar.sr((float) jSONObject.optDouble(next));
                    break;
                case '*':
                    fVar.xv(jSONObject.optDouble(next));
                    break;
                case '+':
                    fVar.ux((float) jSONObject.optDouble(next));
                    break;
                case ',':
                    fVar.k(jSONObject.optBoolean(next));
                    break;
                case '-':
                    fVar.t(jSONObject.optBoolean(next));
                    break;
                case '.':
                    fVar.gd((float) jSONObject.optDouble(next));
                    break;
                case '/':
                    fVar.s(jSONObject.optString(next));
                    break;
                case '0':
                    fVar.ba(jSONObject.optInt(next));
                    break;
                case '1':
                    fVar.r((float) jSONObject.optDouble(next));
                    break;
                case '2':
                    fVar.ev(jSONObject.optString(next));
                    break;
                case '3':
                    fVar.gd(jSONObject.optString(next));
                    break;
                case '4':
                    fVar.fp(jSONObject.optInt(next));
                    break;
                case '5':
                    fVar.ux(jSONObject.optBoolean(next));
                    break;
                case '6':
                    fVar.bk(jSONObject.optInt(next));
                    break;
                case '7':
                    fVar.ia(jSONObject.optString(next));
                    break;
                case '8':
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject == null) {
                        break;
                    } else {
                        fVar.r(optJSONObject.optInt("translateY", 0));
                        fVar.ev(optJSONObject.optInt("translateX", 0));
                        fVar.sr(optJSONObject.optDouble("scaleX", 0.0d));
                        fVar.ux(optJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case '9':
                    fVar.sr(jSONObject.optBoolean(next));
                    break;
                case ':':
                    fVar.a(jSONObject.optString(next));
                    break;
                case ';':
                    fVar.t(jSONObject.optString(next));
                    break;
                case '<':
                    fVar.c((float) jSONObject.optDouble(next));
                    break;
                case '=':
                    fVar.fp(jSONObject.optString(next));
                    break;
                case '>':
                    fVar.p(jSONObject.optString(next));
                    break;
                case '?':
                    fVar.s(jSONObject.optInt(next));
                    break;
                case '@':
                    fVar.w((float) jSONObject.optDouble(next));
                    break;
                case 'A':
                    fVar.a(jSONObject.optInt(next));
                    break;
                case 'B':
                    fVar.t(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
