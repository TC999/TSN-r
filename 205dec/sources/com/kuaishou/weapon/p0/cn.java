package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    private Context f38206a;

    /* renamed from: b  reason: collision with root package name */
    private int f38207b;

    public cn(Context context, int i4) {
        this.f38206a = context;
        this.f38207b = i4;
    }

    public JSONObject a() {
        long j4;
        h hVar;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        cn cnVar;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a4 = h.a(this.f38206a, "re_po_rt");
            boolean e4 = a4.e("a1_p_s_p_s");
            boolean e5 = a4.e("a1_p_s_p_s_c_b");
            if (a4.b("plc001_b_bcl_ie", 1) == 1 && (e4 || e5)) {
                String a5 = bh.a(this.f38206a);
                if (!TextUtils.isEmpty(a5) && !a5.startsWith("RISK")) {
                    jSONObject.put("01001", a5);
                }
                String c4 = bh.c(this.f38206a);
                if (!TextUtils.isEmpty(c4) && !c4.startsWith("RISK")) {
                    jSONObject.put("01003", c4);
                }
                String b4 = bh.b(this.f38206a, 0);
                if (!TextUtils.isEmpty(b4) && !b4.startsWith("RISK")) {
                    jSONObject.put("01019", b4);
                }
                String b5 = bh.b(this.f38206a, 1);
                if (!TextUtils.isEmpty(b5) && !b5.startsWith("RISK")) {
                    jSONObject.put("01004", b5);
                }
                String d4 = bh.d(this.f38206a);
                if (!TextUtils.isEmpty(d4) && !d4.startsWith("RISK")) {
                    jSONObject.put("01007", d4);
                }
            }
            if (a4.b("plc001_b_bcl_is", 0) == 1 && (e4 || e5)) {
                bg bgVar = new bg();
                if (a4.b("plc001_b_pry_gsl", 1) == 1) {
                    jSONObject.put("10020", bgVar.f(this.f38206a));
                }
            }
            if (a4.b("plc001_b_bcl_ic", 1) == 1 && (e4 || e5)) {
                jSONObject.put("01011", bh.e(this.f38206a));
            }
            if (a4.b("plc001_b_bcl_btm", 1) == 1 && (e4 || e5)) {
                String p3 = bh.p(this.f38206a);
                if (!TextUtils.isEmpty(p3) && !p3.startsWith("RISK")) {
                    jSONObject.put("01016", p3);
                }
            }
            if (a4.b("plc001_b_bcl_d", 1) == 1) {
                if (e4 || e5) {
                    String f4 = bh.f(this.f38206a);
                    if (!TextUtils.isEmpty(f4) && !f4.startsWith("RISK")) {
                        jSONObject.put("01013", f4);
                    }
                    jSONObject.put("02042", bh.u(this.f38206a));
                }
                jSONObject.put("02054", bh.x(this.f38206a));
                j4 = currentTimeMillis;
                str = "RISK";
                z4 = e5;
                z3 = e4;
                try {
                    if (Engine.loadSuccess) {
                        try {
                            jSONObject.put("02019", bl.b(this.f38206a));
                            jSONObject.put("02021", bl.d(this.f38206a));
                            jSONObject.put("02022", bl.c(this.f38206a));
                            jSONObject.put("02030", bl.f(this.f38206a));
                            ce ceVar = new ce(this.f38206a);
                            jSONObject.put("01014", ceVar.a("01014") != null ? ceVar.a("01014") : "");
                            jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                            jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                            jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                            jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                            jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                            jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                            jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                            jSONObject.put("02008", ceVar.a("02008") != null ? ceVar.a("02008") : bl.h());
                            jSONObject.put("02009", ceVar.a("02009") != null ? ceVar.a("02009") : bl.i());
                            jSONObject.put("02010", ceVar.a("02010") != null ? ceVar.a("02010") : bl.j());
                            jSONObject.put("02011", ceVar.a("02011") != null ? ceVar.a("02011") : bl.k());
                            jSONObject.put("02012", ceVar.a("02012") != null ? ceVar.a("02012") : bl.l());
                            jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                            jSONObject.put("02014", ceVar.a("02014") != null ? ceVar.a("02014") : bl.n());
                            jSONObject.put("02015", ceVar.a("02015") != null ? ceVar.a("02015") : bl.p());
                            jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                            jSONObject.put("02017", ceVar.a("02017") != null ? ceVar.a("02017") : Integer.valueOf(bl.r()));
                            jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                            jSONObject.put("02020", ceVar.a("02020") != null ? ceVar.a("02020") : bl.u());
                            jSONObject.put("02023", ceVar.a("02023") != null ? ceVar.a("02023") : "");
                            jSONObject.put("02031", ceVar.a("02031") != null ? ceVar.a("02031") : bl.y());
                            jSONObject.put("02032", ceVar.a("02032") != null ? ceVar.a("02032") : bl.o());
                            jSONObject.put("02033", ceVar.a("02033") != null ? ceVar.a("02033") : bl.x());
                            jSONObject.put("02034", ceVar.a("02034") != null ? ceVar.a("02034") : bl.z());
                            jSONObject.put("02035", ceVar.a("02035") != null ? ceVar.a("02035") : bl.A());
                            jSONObject.put("02036", ceVar.a("02036") != null ? ceVar.a("02036") : "");
                            jSONObject.put("02037", ceVar.a("02037") != null ? ceVar.a("02037") : bl.w());
                            jSONObject.put("02038", ceVar.a("02038") != null ? ceVar.a("02038") : bl.v());
                            jSONObject.put("02045", ceVar.a("02045") != null ? ceVar.a("02045") : bl.B());
                        } catch (Exception unused) {
                        }
                        cnVar = this;
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02008", bl.h());
                        jSONObject.put("02009", bl.i());
                        jSONObject.put("02010", bl.j());
                        jSONObject.put("02011", bl.k());
                        jSONObject.put("02012", bl.l());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02014", bl.n());
                        jSONObject.put("02015", bl.p());
                        jSONObject.put("02016", bl.q());
                        jSONObject.put("02017", bl.r());
                        jSONObject.put("02018", bl.s());
                        cnVar = this;
                        try {
                            jSONObject.put("02019", bl.b(cnVar.f38206a));
                            jSONObject.put("02020", bl.u());
                            jSONObject.put("02021", bl.d(cnVar.f38206a));
                            jSONObject.put("02022", bl.c(cnVar.f38206a));
                            jSONObject.put("02030", bl.f(cnVar.f38206a));
                            jSONObject.put("02031", bl.y());
                            jSONObject.put("02032", bl.o());
                            jSONObject.put("02033", bl.x());
                            jSONObject.put("02034", bl.z());
                            jSONObject.put("02035", bl.A());
                            jSONObject.put("02037", bl.w());
                            jSONObject.put("02038", bl.v());
                            jSONObject.put("02045", bl.B());
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    str2 = "";
                    jSONObject.put("02067", StubApp.getOrigApplicationContext(cnVar.f38206a.getApplicationContext()).getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                    jSONObject.put("02039", bh.i());
                    jSONObject.put("02040", bh.j());
                    jSONObject.put("02041", bh.t(cnVar.f38206a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("02046", bl.C());
                    String a6 = bh.a("persist.service.adb.enable");
                    if (!TextUtils.isEmpty(a6)) {
                        jSONObject.put("03058", a6);
                    }
                    String a7 = bh.a("sys.resettype");
                    if (!TextUtils.isEmpty(a7)) {
                        jSONObject.put("03057", a7);
                    }
                    String a8 = bh.a("ro.boot.bootreason");
                    if (!TextUtils.isEmpty(a8)) {
                        jSONObject.put("03056", a8);
                    }
                    String a9 = bh.a("ro.runtime.firstboot");
                    if (!TextUtils.isEmpty(a9)) {
                        jSONObject.put("03055", a9);
                    }
                    String a10 = bh.a("init.svc.atcmdserver");
                    if (!TextUtils.isEmpty(a10)) {
                        jSONObject.put("03054", a10);
                    }
                    String a11 = bh.a("ro.build.date.utc");
                    if (!TextUtils.isEmpty(a11)) {
                        jSONObject.put("03061", a11);
                    }
                    String a12 = bh.a("ro.bootimage.build.date.utc");
                    if (!TextUtils.isEmpty(a12)) {
                        jSONObject.put("03062", a12);
                    }
                    String a13 = bh.a("ro.build.date.YmdHM");
                    if (!TextUtils.isEmpty(a13)) {
                        jSONObject.put("03063", a13);
                    }
                    String a14 = bh.a("dhcp.ipv6.wlan0.dns1");
                    if (!TextUtils.isEmpty(a14)) {
                        jSONObject.put("03067", a14);
                    }
                    String a15 = bh.a("dhcp.ipv6.wlan0.dns2");
                    if (!TextUtils.isEmpty(a15)) {
                        jSONObject.put("03068", a15);
                    }
                    String a16 = bh.a("dhcp.wlan0.dns1");
                    if (!TextUtils.isEmpty(a16)) {
                        jSONObject.put("03069", a16);
                    }
                    String a17 = bh.a("dhcp.wlan0.dns2");
                    if (!TextUtils.isEmpty(a17)) {
                        jSONObject.put("03070", a17);
                    }
                    String a18 = bh.a("net.change");
                    if (!TextUtils.isEmpty(a18)) {
                        jSONObject.put("03071", a18);
                    }
                    String a19 = bh.a("net.dns1");
                    if (!TextUtils.isEmpty(a19)) {
                        jSONObject.put("03072", a19);
                    }
                    String a20 = bh.a("net.dns2");
                    if (!TextUtils.isEmpty(a20)) {
                        jSONObject.put("03073", a20);
                    }
                    hVar = a4;
                    long a21 = hVar.a("plc001_t_d", -1L);
                    if (a21 != -1) {
                        jSONObject.put("03074", a21 + System.currentTimeMillis());
                    }
                    try {
                        jSONObject.put("03064", Settings.System.getInt(cnVar.f38206a.getContentResolver(), "screen_brightness_mode"));
                        jSONObject.put("03065", Settings.System.getInt(cnVar.f38206a.getContentResolver(), "accelerometer_rotation"));
                    } catch (Throwable unused3) {
                    }
                    jSONObject.put("03081", bl.L());
                    jSONObject.put("03053", bh.y(cnVar.f38206a));
                    jSONObject.put("03052", bl.i(cnVar.f38206a));
                    jSONObject.put("03050", bl.h(cnVar.f38206a));
                    jSONObject.put("03049", bl.g(cnVar.f38206a));
                    jSONObject.put("02027", bl.H());
                    jSONObject.put("02028", bl.D());
                    jSONObject.put("02029", bl.E());
                    jSONObject.put("02057", bl.F());
                    jSONObject.put("02058", bl.G());
                } catch (Throwable unused4) {
                    return null;
                }
            } else {
                j4 = currentTimeMillis;
                hVar = a4;
                z3 = e4;
                z4 = e5;
                str = "RISK";
                str2 = "";
                cnVar = this;
            }
            if (hVar.b("plc001_b_bcl_r", 1) == 1) {
                jSONObject.put("03001", bo.a());
                jSONObject.put("03002", bo.b());
                jSONObject.put("03001", bo.a());
                jSONObject.put("03043", SystemClock.elapsedRealtime());
                jSONObject.put("03044", SystemClock.uptimeMillis());
                jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                by byVar = new by(cnVar.f38206a);
                if (Engine.loadSuccess) {
                    jSONObject.put("03004", byVar.a("03004") != null ? byVar.a("03004") : str2);
                    jSONObject.put("03036", byVar.b("03036") != null ? byVar.b("03036") : str2);
                    jSONObject.put("03039", byVar.a("03039") != null ? byVar.a("03039") : str2);
                    jSONObject.put("03040", byVar.a("03040") != null ? byVar.a("03040") : str2);
                    jSONObject.put("03041", byVar.a("03041") != null ? byVar.a("03041") : str2);
                    jSONObject.put("03042", byVar.a("03042") != null ? byVar.a("03042") : str2);
                    jSONObject.put("03079", byVar.a("03079") != null ? byVar.a("03079") : null);
                    jSONObject.put("03080", byVar.a("03080") != null ? byVar.a("03080") : null);
                }
                jSONObject.put("03007", bv.a(cnVar.f38206a));
                jSONObject.put("03008", bv.c(cnVar.f38206a));
                jSONObject.put("03011", am.b(cnVar.f38206a));
                jSONObject.put("03012", am.b());
                jSONObject.put("03014", bh.g(cnVar.f38206a));
                jSONObject.put("03034", bh.h(cnVar.f38206a));
                jSONObject.put("03020", bv.b(cnVar.f38206a));
                jSONObject.put("03037", bl.I());
                jSONObject.put("03038", bl.J());
                jSONObject.put("03077", bl.K());
                try {
                    bg bgVar2 = new bg();
                    jSONObject.put("03006", bgVar2.a(cnVar.f38206a));
                    jSONObject.put("03010", bgVar2.b(cnVar.f38206a));
                    jSONObject.put("03033", bgVar2.c(cnVar.f38206a));
                    jSONObject.put("03013", bgVar2.a());
                    jSONObject.put("03021", bgVar2.e(cnVar.f38206a));
                    jSONObject.put("03030", bg.d(cnVar.f38206a));
                    jSONObject.put("10031", bgVar2.b());
                } catch (Exception unused5) {
                }
            }
            if (hVar.b("plc001_b_bcl_tc", 0) == 1) {
                jSONObject.put("03019", bh.k(cnVar.f38206a));
                String m4 = bh.m(cnVar.f38206a);
                if (!TextUtils.isEmpty(m4)) {
                    jSONObject.put("03047", m4);
                }
                jSONObject.put("03018", bh.i(cnVar.f38206a));
            }
            if (hVar.b("plc001_b_bcl_il", 1) == 1) {
                jSONObject.put("02059", bm.a(cnVar.f38206a));
                jSONObject.put("02060", bm.a());
                jSONObject.put("02061", bm.b());
                jSONObject.put("02062", bm.c());
                if (Engine.loadSuccess) {
                    ca caVar = new ca(cnVar.f38206a);
                    jSONObject.put("08001", caVar.a("08001") != null ? caVar.a("08001") : str2);
                }
                JSONObject d5 = bm.d();
                if (d5 != null && d5.length() > 0) {
                    jSONObject.put("10050", d5);
                }
            }
            if (hVar.b("plc001_b_bcl_rp", 1) == 1 && (z3 || z4)) {
                jSONObject.put("03029", bh.j(cnVar.f38206a));
            }
            if (hVar.b("plc001_b_bcl_c", 1) == 1) {
                if (Engine.loadSuccess) {
                    bz bzVar = new bz(cnVar.f38206a);
                    jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : str2);
                    jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : str2);
                    jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : str2);
                    jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : str2);
                } else {
                    try {
                        bj b6 = bk.b();
                        jSONObject.put("04001", bk.a());
                        jSONObject.put("04002", b6.b());
                        jSONObject.put("04003", b6.c());
                        jSONObject.put("04004", b6.a());
                    } catch (Exception unused6) {
                    }
                }
            }
            if (hVar.b("plc001_b_bcl_w", 0) == 1 && (z3 || z4)) {
                Object f5 = bh.f();
                if (f5 != null) {
                    jSONObject.put("06014", f5);
                }
                if (Engine.loadSuccess) {
                    cf cfVar = new cf(cnVar.f38206a);
                    jSONObject.put("06015", cfVar.b("06015") != null ? cfVar.b("06015") : str2);
                }
            }
            if (z3 || z4) {
                String h4 = bh.h();
                if (!TextUtils.isEmpty(h4) && !h4.startsWith(str)) {
                    jSONObject.put("07005", h4);
                } else if (h4 == null) {
                    jSONObject.put("07005", str2);
                } else {
                    jSONObject.put("07005", h4);
                }
            }
            if (hVar.b("plc001_b_bcl_n", 0) == 1 && (z3 || z4)) {
                if (Engine.loadSuccess) {
                    jSONObject.put("07007", new cc(cnVar.f38206a).a("07007"));
                }
                JSONArray a22 = br.a(cnVar.f38206a);
                if (a22 != null && a22.length() > 0) {
                    jSONObject.put("03035", a22);
                }
            }
            if (z3 || z4) {
                try {
                    double b7 = bh.b();
                    if (b7 > 0.0d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b7);
                        jSONObject.put("09002", sb.toString());
                    }
                    double c5 = bh.c();
                    if (c5 > 0.0d) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c5);
                        jSONObject.put("09003", sb2.toString());
                    }
                    jSONObject.put("09001", bh.d());
                } catch (Exception unused7) {
                }
            }
            if (hVar.b("plc001_b_bcl_a", 0) == 1 && (z3 || z4)) {
                jSONObject.put("10002", new w(cnVar.f38206a).a(1));
            }
            if (hVar.b("plc001_b_bcl_s", 1) == 1 && Engine.loadSuccess) {
                String a23 = new cd(cnVar.f38206a).a("05001");
                try {
                    if (!TextUtils.isEmpty(a23) && a23.length() > 10) {
                        jSONObject.put("05001", new JSONArray(a23));
                    }
                } catch (Exception unused8) {
                }
            }
            if (Engine.loadSuccess) {
                cb cbVar = new cb(cnVar.f38206a);
                jSONObject.put("13001", cbVar.a("13001") != null ? cbVar.a("13001") : str2);
            }
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11003", bi.f38086v);
            jSONObject.put("11004", Engine.loadSoCount);
            jSONObject.put("11006", z3 ? 1 : 0);
            jSONObject.put("11029", z4 ? 1 : 0);
            jSONObject.put("11008", hVar.b("plc001_v", "0.0.0"));
            jSONObject.put("11009", bs.a(StubApp.getOrigApplicationContext(cnVar.f38206a.getApplicationContext())));
            try {
                String w3 = bh.w(cnVar.f38206a);
                if (!TextUtils.isEmpty(w3)) {
                    jSONObject.put("01026", w3);
                }
                if (hVar.b("plc001_b_bcl_u", 1) == 1) {
                    String Ih = com.kwad.sdk.f.b.Is().Ih();
                    if (!TextUtils.isEmpty(Ih)) {
                        jSONObject.put("11102", Ih);
                    }
                    jSONObject.put("11104", com.kwad.sdk.f.b.Is().Io());
                    jSONObject.put("11105", com.kwad.sdk.f.b.Is().getDeviceId());
                    jSONObject.put("11106", com.kwad.sdk.f.b.Is().getIccId());
                    jSONObject.put("11107", com.kwad.sdk.f.b.Is().Ig());
                    jSONObject.put("11108", com.kwad.sdk.f.b.Is().Ij());
                    jSONObject.put("11109", com.kwad.sdk.f.b.Is().Ik());
                    jSONObject.put("11110", com.kwad.sdk.f.b.Is().Il());
                    jSONObject.put("11111", com.kwad.sdk.f.b.Is().getIp());
                    jSONObject.put("11112", com.kwad.sdk.f.b.Is().getLocation());
                    jSONObject.put("11113", com.kwad.sdk.f.b.Is().getOaid());
                    jSONObject.put("11114", com.kwad.sdk.f.b.Is().Ii());
                    jSONObject.put("11115", com.kwad.sdk.f.b.Is().In());
                    jSONObject.put("11116", com.kwad.sdk.f.b.Is().Im());
                    jSONObject.put("11202", bh.b(com.kwad.sdk.f.b.Is().Ih()));
                    jSONObject.put("11204", bh.b(com.kwad.sdk.f.b.Is().Io()));
                    jSONObject.put("11205", bh.b(com.kwad.sdk.f.b.Is().getDeviceId()));
                    jSONObject.put("11206", bh.b(com.kwad.sdk.f.b.Is().getIccId()));
                    jSONObject.put("11207", bh.b(com.kwad.sdk.f.b.Is().Ig()));
                    jSONObject.put("11208", bh.b(com.kwad.sdk.f.b.Is().Ij()));
                    jSONObject.put("11209", bh.b(com.kwad.sdk.f.b.Is().Ik()));
                    jSONObject.put("11210", bh.b(com.kwad.sdk.f.b.Is().Il()));
                    jSONObject.put("11211", bh.b(com.kwad.sdk.f.b.Is().getIp()));
                    jSONObject.put("11212", bh.b(com.kwad.sdk.f.b.Is().getLocation()));
                    jSONObject.put("11213", bh.b(com.kwad.sdk.f.b.Is().getOaid()));
                    jSONObject.put("11214", bh.b(com.kwad.sdk.f.b.Is().Ii()));
                    jSONObject.put("11215", bh.b(com.kwad.sdk.f.b.Is().In()));
                    jSONObject.put("11216", bh.b(com.kwad.sdk.f.b.Is().Im()));
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                }
            } catch (Throwable unused9) {
            }
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
                if (Build.VERSION.SDK_INT > 21) {
                    jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                }
                String string = Settings.Global.getString(cnVar.f38206a.getContentResolver(), "Phenotype_boot_count");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("03085", string);
                }
                String string2 = Settings.Global.getString(cnVar.f38206a.getContentResolver(), "boot_count");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("03086", string2);
                }
                String string3 = Settings.System.getString(cnVar.f38206a.getContentResolver(), "power_on_times");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("03091", string3);
                }
                String string4 = Settings.System.getString(cnVar.f38206a.getContentResolver(), "first_boot_flag");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("03104", string4);
                }
                jSONObject.put("03113", bh.a());
            } catch (Throwable unused10) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - j4);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused11) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a4;
        try {
            JSONObject a5 = new cm(str, ck.f38176l).a(this.f38206a);
            if (a5 == null || (a4 = a()) == null) {
                return null;
            }
            a5.put("module_section", a4);
            return a5.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
