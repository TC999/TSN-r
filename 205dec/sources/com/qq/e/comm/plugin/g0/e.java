package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o1;
import com.qq.e.comm.plugin.util.q0;
import com.qq.e.comm.plugin.util.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    protected b A;
    long A0;
    String B;
    boolean B0;
    String C;
    y C0;
    String D;
    int D0;
    String E;
    double E0;
    String F0;
    String G;
    String G0;
    int H;
    int H0;
    int I;
    boolean I0;
    i0 J;
    String J0;
    private com.qq.e.comm.plugin.b.g K;
    int K0;

    /* renamed from: L  reason: collision with root package name */
    protected JSONObject f43506L;
    int L0;
    protected String M;
    JSONObject M0;
    h N;
    List<j> N0;
    int O;
    String P;
    boolean Q;
    Map<String, Object> Q0;
    int R;
    private SparseArray<e> R0;
    int S;
    private String S0;
    int T;
    List<e0> U;
    List<e0> V;
    private long V0;
    protected List<String> W;
    protected List<String> X;
    long X0;
    p Y;
    long Y0;
    String Z;
    long Z0;

    /* renamed from: a0  reason: collision with root package name */
    String f43508a0;

    /* renamed from: a1  reason: collision with root package name */
    long f43509a1;

    /* renamed from: b  reason: collision with root package name */
    String f43510b;

    /* renamed from: b0  reason: collision with root package name */
    c f43511b0;

    /* renamed from: b1  reason: collision with root package name */
    long f43512b1;

    /* renamed from: c  reason: collision with root package name */
    String f43513c;

    /* renamed from: c0  reason: collision with root package name */
    String f43514c0;

    /* renamed from: c1  reason: collision with root package name */
    long f43515c1;

    /* renamed from: d  reason: collision with root package name */
    String f43516d;

    /* renamed from: d0  reason: collision with root package name */
    int f43517d0;

    /* renamed from: e  reason: collision with root package name */
    String f43519e;

    /* renamed from: e0  reason: collision with root package name */
    String f43520e0;

    /* renamed from: f  reason: collision with root package name */
    String f43522f;

    /* renamed from: f0  reason: collision with root package name */
    k0 f43523f0;

    /* renamed from: f1  reason: collision with root package name */
    long f43524f1;

    /* renamed from: g  reason: collision with root package name */
    String f43525g;

    /* renamed from: g0  reason: collision with root package name */
    boolean f43526g0;

    /* renamed from: h  reason: collision with root package name */
    int f43527h;

    /* renamed from: h0  reason: collision with root package name */
    String f43528h0;

    /* renamed from: i  reason: collision with root package name */
    int f43529i;

    /* renamed from: i0  reason: collision with root package name */
    b0 f43530i0;

    /* renamed from: j  reason: collision with root package name */
    protected String f43531j;

    /* renamed from: j0  reason: collision with root package name */
    boolean f43532j0;

    /* renamed from: k  reason: collision with root package name */
    String f43533k;

    /* renamed from: k0  reason: collision with root package name */
    List<String> f43534k0;

    /* renamed from: l  reason: collision with root package name */
    protected String f43535l;

    /* renamed from: l0  reason: collision with root package name */
    String f43536l0;

    /* renamed from: m  reason: collision with root package name */
    String f43537m;

    /* renamed from: m0  reason: collision with root package name */
    boolean f43538m0;

    /* renamed from: n  reason: collision with root package name */
    int f43539n;

    /* renamed from: n0  reason: collision with root package name */
    boolean f43540n0;

    /* renamed from: o  reason: collision with root package name */
    int f43541o;

    /* renamed from: o0  reason: collision with root package name */
    String f43542o0;

    /* renamed from: p  reason: collision with root package name */
    String f43543p;

    /* renamed from: p0  reason: collision with root package name */
    List<s> f43544p0;

    /* renamed from: q  reason: collision with root package name */
    String f43545q;

    /* renamed from: q0  reason: collision with root package name */
    int f43546q0;

    /* renamed from: r  reason: collision with root package name */
    String f43547r;

    /* renamed from: r0  reason: collision with root package name */
    String f43548r0;

    /* renamed from: s  reason: collision with root package name */
    String f43549s;

    /* renamed from: s0  reason: collision with root package name */
    String f43550s0;

    /* renamed from: t  reason: collision with root package name */
    String f43551t;

    /* renamed from: t0  reason: collision with root package name */
    String f43552t0;

    /* renamed from: u  reason: collision with root package name */
    boolean f43553u;

    /* renamed from: u0  reason: collision with root package name */
    String f43554u0;

    /* renamed from: v  reason: collision with root package name */
    boolean f43555v;

    /* renamed from: v0  reason: collision with root package name */
    boolean f43556v0;

    /* renamed from: w  reason: collision with root package name */
    boolean f43557w;

    /* renamed from: w0  reason: collision with root package name */
    String f43558w0;

    /* renamed from: x  reason: collision with root package name */
    String f43559x;

    /* renamed from: x0  reason: collision with root package name */
    String f43560x0;

    /* renamed from: y  reason: collision with root package name */
    int f43561y;

    /* renamed from: y0  reason: collision with root package name */
    String f43562y0;

    /* renamed from: z  reason: collision with root package name */
    int f43563z;

    /* renamed from: z0  reason: collision with root package name */
    int f43564z0;
    int F = -1;
    int O0 = Integer.MIN_VALUE;
    private int P0 = Integer.MIN_VALUE;
    private int T0 = 2;
    private int U0 = 0;
    boolean W0 = false;

    /* renamed from: d1  reason: collision with root package name */
    List<Long> f43518d1 = new ArrayList();

    /* renamed from: e1  reason: collision with root package name */
    List<Long> f43521e1 = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    String f43507a = String.valueOf(w0.a());

    public e(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
        this.H = -1;
        boolean z3 = false;
        this.C = str;
        this.E = str2;
        this.D = str4;
        this.K = gVar;
        if (jSONObject == null) {
            return;
        }
        f.a(this, jSONObject);
        this.f43506L = jSONObject;
        this.H = a(jSONObject, str2);
        String optString = jSONObject.optString("negative_feedback_url");
        if (!TextUtils.isEmpty(optString)) {
            this.f43543p = optString.replace("__ACT_TYPE__", "2001");
        }
        this.f43553u = com.qq.e.comm.plugin.util.e.d(jSONObject);
        if (jSONObject.optInt("is_app_subscribe", 0) == 1 && com.qq.e.comm.plugin.util.e.b(this.f43539n)) {
            z3 = true;
        }
        this.f43532j0 = z3;
        if (X0()) {
            this.A = com.qq.e.comm.plugin.util.e.a(jSONObject);
        }
        if (this.f43511b0 == null) {
            this.f43511b0 = new c();
        }
        this.Y = com.qq.e.comm.plugin.util.a0.a(jSONObject);
        this.f43523f0 = a(jSONObject);
        this.f43544p0 = s.a(jSONObject);
        this.N0 = j.a(jSONObject);
        com.qq.e.comm.plugin.t.a.b().a(this.f43530i0, gVar);
        com.qq.e.comm.plugin.n0.g.a(this.f43530i0);
        y yVar = this.C0;
        if (yVar != null && yVar.u()) {
            this.C0 = null;
        }
        if (this.C0 != null) {
            com.qq.e.comm.plugin.dl.i.a().a(this);
        }
        this.Q0 = com.qq.e.comm.plugin.util.k0.b(jSONObject.optJSONObject("ext2"));
        com.qq.e.comm.plugin.n0.w.f.a(this);
        com.qq.e.comm.plugin.t.d.a(this);
        h();
    }

    private void h() {
        pro.getVresult(449, 0, this);
    }

    public final String A() {
        return this.f43516d;
    }

    public final List<String> A0() {
        return this.f43534k0;
    }

    public final String B() {
        String str = this.f43508a0;
        if (str == null || TextUtils.isEmpty(str)) {
            return g1() ? "\u6253\u5f00\u5feb\u5e94\u7528" : m1() ? "\u53bb\u5fae\u4fe1\u770b\u770b" : this.f43553u ? "\u7acb\u5373\u4e0b\u8f7d" : "\u67e5\u770b\u8be6\u60c5";
        }
        return this.f43508a0;
    }

    public String B0() {
        return this.f43558w0;
    }

    public final String C() {
        return this.f43514c0;
    }

    public final long C0() {
        return this.Z0;
    }

    public final int D() {
        return this.H0;
    }

    public final int D0() {
        return this.O;
    }

    public final String E() {
        return this.f43537m;
    }

    public long E0() {
        if (this.A0 <= 0 && this.f43526g0) {
            this.A0 = q0.a();
        }
        return this.A0;
    }

    public final String F() {
        return this.f43519e;
    }

    public final int F0() {
        return this.f43563z;
    }

    public final int G() {
        return this.f43541o;
    }

    public final String G0() {
        return this.f43559x;
    }

    public final double H() {
        return this.E0;
    }

    public int H0() {
        if (this.P0 == Integer.MIN_VALUE) {
            y yVar = this.C0;
            if (yVar != null) {
                this.P0 = yVar.f43738a;
            } else {
                this.P0 = 0;
            }
        }
        return this.P0;
    }

    public final p I() {
        return this.Y;
    }

    public final int I0() {
        return this.f43561y;
    }

    public final int J() {
        return this.F;
    }

    public final String J0() {
        return this.f43513c;
    }

    public String K() {
        if (!TextUtils.isEmpty(this.f43551t)) {
            return this.f43551t;
        }
        return this.f43547r;
    }

    public final String K0() {
        return this.f43547r;
    }

    public int L() {
        return this.U0;
    }

    public final String L0() {
        return this.P;
    }

    public int M() {
        return this.T0;
    }

    public final int M0() {
        return this.T;
    }

    public final long N() {
        return this.f43512b1;
    }

    public final int N0() {
        return this.S;
    }

    public final String O() {
        return this.f43531j;
    }

    public final long O0() {
        return this.f43515c1;
    }

    public final String P() {
        return this.J0;
    }

    public final String P0() {
        return this.B;
    }

    public int Q() {
        SparseArray<e> sparseArray = this.R0;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        y yVar = this.C0;
        if (yVar == null) {
            return 0;
        }
        return yVar.h();
    }

    public final String Q0() {
        return this.Z;
    }

    public final Map<String, Object> R() {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_AD_MP, Integer.valueOf(this.H));
        hashMap.put(ConstantAd.KEY_CACHE_AD, this.f43547r);
        hashMap.put("is_reward_ad", Boolean.valueOf(this.f43556v0));
        hashMap.put("token", this.f43549s);
        Map<String, Object> map = this.Q0;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final int R0() {
        return this.R;
    }

    public String S() {
        return this.f43562y0;
    }

    public final String S0() {
        return this.f43552t0;
    }

    public final long T() {
        return this.f43509a1;
    }

    public final k0 T0() {
        return this.f43523f0;
    }

    public final long U() {
        return this.f43524f1;
    }

    public String U0() {
        return this.f43560x0;
    }

    public List<s> V() {
        return this.f43544p0;
    }

    public final String V0() {
        return this.f43554u0;
    }

    public final String W() {
        return this.f43548r0;
    }

    public final String W0() {
        return this.G;
    }

    public final String X() {
        return this.f43522f;
    }

    public final boolean X0() {
        return this.f43553u && !this.f43532j0;
    }

    public final String Y() {
        return this.f43525g;
    }

    public final boolean Y0() {
        return this.I > 1;
    }

    public int Z() {
        return this.K0;
    }

    public boolean Z0() {
        return this.B0;
    }

    public final e a(int i4) {
        SparseArray<e> sparseArray;
        if (i4 < 0 || (sparseArray = this.R0) == null) {
            return null;
        }
        return sparseArray.get(i4);
    }

    public final void a(boolean z3) {
    }

    public String a0() {
        return this.S0;
    }

    public final boolean a1() {
        return this.f43540n0;
    }

    public final String b() {
        return this.f43520e0;
    }

    public final int b0() {
        return this.f43564z0;
    }

    public final boolean b1() {
        return this.Q;
    }

    public final void c(long j4) {
        this.f43512b1 = j4;
    }

    public final long c0() {
        if (this.Y0 <= 0) {
            this.Y0 = System.currentTimeMillis();
        }
        return this.Y0;
    }

    public boolean c1() {
        y i02 = i0();
        return i02 != null && com.qq.e.comm.plugin.rewardvideo.l.a(i02.p());
    }

    public final void d(long j4) {
        this.f43509a1 = j4;
    }

    public long d0() {
        return this.V0;
    }

    public boolean d1() {
        y yVar = this.C0;
        return yVar == null || yVar.x();
    }

    public final void e(long j4) {
        this.f43524f1 = j4;
    }

    public String e0() {
        return this.f43542o0;
    }

    public boolean e1() {
        return this.W0;
    }

    public final void f(long j4) {
        this.Y0 = j4;
    }

    public final List<j> f0() {
        return this.N0;
    }

    public boolean f1() {
        return this.L0 == 1;
    }

    public final int g() {
        return this.f43539n;
    }

    public final int g0() {
        return this.f43517d0;
    }

    public final boolean g1() {
        return this.f43539n == 53;
    }

    public final int h0() {
        return this.H;
    }

    public boolean h1() {
        return this.f43556v0;
    }

    public final long i() {
        return this.X0;
    }

    public final y i0() {
        return this.C0;
    }

    public final boolean i1() {
        return this.f43557w && this.f43555v;
    }

    public final int j() {
        return this.f43546q0;
    }

    public final String j0() {
        return this.f43543p;
    }

    public final boolean j1() {
        return this.f43555v;
    }

    public final String k() {
        return this.f43510b;
    }

    public final String k0() {
        return this.f43551t;
    }

    public final boolean k1() {
        return this.I0;
    }

    public final JSONObject l() {
        return this.f43506L;
    }

    public String l0() {
        return this.f43507a;
    }

    public final boolean l1() {
        return !TextUtils.isEmpty(L0());
    }

    public final String m() {
        if (TextUtils.isEmpty(this.M)) {
            this.M = this.f43506L.toString();
        }
        return this.M;
    }

    public final String m0() {
        return this.f43508a0;
    }

    public final boolean m1() {
        return this.f43541o == 12;
    }

    public final String n() {
        return this.D;
    }

    public final int n0() {
        return this.f43529i;
    }

    public void n1() {
        this.T0 = 1;
    }

    public final com.qq.e.comm.plugin.b.g o() {
        return this.K;
    }

    public final int o0() {
        return this.f43527h;
    }

    public final String p() {
        return this.C;
    }

    public final b0 p0() {
        return this.f43530i0;
    }

    public final b q() {
        return this.A;
    }

    public final String q0() {
        return this.E;
    }

    public String r() {
        return this.f43536l0;
    }

    public final int r0() {
        i0 i0Var = this.J;
        if (i0Var != null) {
            return i0Var.a();
        }
        return -1;
    }

    public final c s() {
        return this.f43511b0;
    }

    public final String s0() {
        return this.f43528h0;
    }

    public List<Long> t() {
        return this.f43521e1;
    }

    public final String t0() {
        return this.G0;
    }

    public final List<String> u() {
        return this.X;
    }

    public int u0() {
        return this.O0;
    }

    public final List<String> v() {
        return this.W;
    }

    public final List<e0> v0() {
        return this.U;
    }

    public List<Long> w() {
        return this.f43518d1;
    }

    public final List<e0> w0() {
        return this.V;
    }

    public final String x() {
        return this.f43535l;
    }

    public final String x0() {
        return this.f43550s0;
    }

    public final String y() {
        return this.F0;
    }

    public final String y0() {
        if (this.M0 == null) {
            return null;
        }
        return this.M0.optString("rcc") + this.M0.optString("rcd");
    }

    public final h z() {
        return this.N;
    }

    public int z0() {
        return this.D0;
    }

    public final e a(String str) {
        int size;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(this.f43547r)) {
            return this;
        }
        SparseArray<e> sparseArray = this.R0;
        if (sparseArray != null && (size = sparseArray.size()) != 0) {
            for (int i4 = 0; i4 < size; i4++) {
                e valueAt = this.R0.valueAt(i4);
                if (valueAt != null && str.equals(valueAt.f43547r)) {
                    return valueAt;
                }
            }
        }
        return null;
    }

    public final void b(boolean z3) {
        this.W0 = z3;
    }

    public void c(int i4) {
        this.O0 = i4;
    }

    public void g(long j4) {
        this.V0 = j4;
    }

    public final void i(long j4) {
        this.f43515c1 = j4;
    }

    public final void b(long j4) {
        if (this.f43518d1 == null) {
            this.f43518d1 = new ArrayList();
        }
        this.f43518d1.add(Long.valueOf(j4));
    }

    public void b(String str) {
        this.S0 = str;
    }

    public void b(int i4) {
        this.U0 = i4;
    }

    public final void h(long j4) {
        this.Z0 = j4;
    }

    public final void a(long j4) {
        if (this.f43521e1 == null) {
            this.f43521e1 = new ArrayList();
        }
        this.f43521e1.add(Long.valueOf(j4));
    }

    public void a(y yVar) {
        String str;
        if (yVar == null) {
            return;
        }
        y yVar2 = this.C0;
        if (yVar2 != null && !TextUtils.isEmpty(yVar2.f43739b)) {
            str = this.C0.j();
        } else {
            str = this.f43559x;
        }
        String j4 = yVar.j();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(j4)) {
            String format = String.format("template_id=%s", str);
            String format2 = String.format("template_id=%s", j4);
            if (!TextUtils.isEmpty(this.f43531j)) {
                this.f43531j = this.f43531j.replace(format, format2);
            }
            if (!TextUtils.isEmpty(this.f43535l)) {
                this.f43535l = this.f43535l.replace(format, format2);
            }
        }
        this.C0 = yVar;
        this.f43559x = j4;
        this.P0 = yVar.s();
    }

    public void a(int i4, e eVar) {
        if (this.R0 == null) {
            this.R0 = new SparseArray<>(5);
        }
        this.R0.put(i4, eVar);
    }

    public static int a(JSONObject jSONObject, String str) {
        byte[] d4;
        int parseInt;
        String optString = jSONObject.optString(CampaignEx.JSON_KEY_AD_MP);
        if (!TextUtils.isEmpty(optString)) {
            try {
                d4 = o1.d(Base64.decode(optString, 0));
            } catch (o1.d e4) {
                com.qq.e.comm.plugin.e0.d.f.a(str);
                e4.printStackTrace();
            } catch (NumberFormatException unused) {
            }
            if (d4 != null) {
                parseInt = Integer.parseInt(new String(d4, com.qq.e.comm.plugin.k.a.f44515a));
                d1.a("ad response mp origin value: " + optString + " decryption value: " + parseInt, new Object[0]);
                return parseInt;
            }
        }
        parseInt = -1;
        d1.a("ad response mp origin value: " + optString + " decryption value: " + parseInt, new Object[0]);
        return parseInt;
    }

    public static k0 a(JSONObject jSONObject) {
        return new k0(jSONObject.optString("wxappid"), jSONObject.optJSONObject("wechat_ad_trace_data"), jSONObject.optString("wechat_app_username"), jSONObject.optString("wechat_app_path"), jSONObject.optString("wechat_app_token"));
    }
}
