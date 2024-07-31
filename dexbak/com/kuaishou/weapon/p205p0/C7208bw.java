package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.kwad.sdk.p433f.C10758b;
import com.stub.StubApp;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7208bw {

    /* renamed from: d */
    private static final byte[] f24618d = new byte[0];

    /* renamed from: a */
    private Context f24619a;

    /* renamed from: b */
    private boolean f24620b;

    /* renamed from: c */
    private int f24621c;

    public C7208bw(Context context, int i, boolean z) {
        this.f24619a = context;
        this.f24620b = z;
        this.f24621c = i;
    }

    /* renamed from: a */
    public JSONObject m34123a() {
        try {
            JSONObject jSONObject = new JSONObject();
            C7283h m33888a = C7283h.m33888a(this.f24619a, "re_po_rt");
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", m33867e ? 1 : 0);
            jSONObject.put("11029", m33867e2 ? 1 : 0);
            if (m33888a.m33878b(C7262df.f24862au, 1) == 1 && (m33867e || m33867e2)) {
                String m34267a = C7191bh.m34267a(this.f24619a);
                if (!TextUtils.isEmpty(m34267a) && !m34267a.startsWith("RISK")) {
                    jSONObject.put("01001", C7281f.m33897a(m34267a));
                }
                String m34255c = C7191bh.m34255c(this.f24619a);
                if (!TextUtils.isEmpty(m34255c) && !m34255c.startsWith("RISK")) {
                    jSONObject.put("01003", m34255c);
                }
                String m34259b = C7191bh.m34259b(this.f24619a, 0);
                if (!TextUtils.isEmpty(m34259b) && !m34259b.startsWith("RISK")) {
                    jSONObject.put("01019", m34259b);
                }
                String m34259b2 = C7191bh.m34259b(this.f24619a, 1);
                if (!TextUtils.isEmpty(m34259b2) && !m34259b2.startsWith("RISK")) {
                    jSONObject.put("01004", C7281f.m33897a(m34259b2));
                }
            }
            int m33878b = m33888a.m33878b(C7262df.f24861at, 1);
            if (m33878b == 1 && (m33867e || m33867e2)) {
                String m34248f = C7191bh.m34248f(this.f24619a);
                if (!TextUtils.isEmpty(m34248f) && !m34248f.startsWith("RISK")) {
                    jSONObject.put("01013", m34248f);
                }
            }
            if (m33888a.m33878b(C7262df.f24863av, 1) == 1 && (m33867e || m33867e2)) {
                String m34252d = C7191bh.m34252d(this.f24619a);
                if (!TextUtils.isEmpty(m34252d) && !m34252d.startsWith("RISK")) {
                    jSONObject.put("01007", m34252d);
                }
            }
            if (m33888a.m33878b(C7262df.f24864aw, 1) == 1 && (m33867e || m33867e2)) {
                jSONObject.put("01011", C7191bh.m34250e(this.f24619a));
            }
            if (m33867e || m33867e2) {
                String m34245h = C7191bh.m34245h();
                if (!TextUtils.isEmpty(m34245h) && !m34245h.startsWith("RISK")) {
                    jSONObject.put("07005", m34245h);
                } else if (m34245h == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", m34245h);
                }
                jSONObject.put("07006", C7191bh.m34247g());
            }
            if (m33888a.m33878b(C7262df.f24866ay, 1) == 1 && (m33867e || m33867e2)) {
                String m34231p = C7191bh.m34231p(this.f24619a);
                if (!TextUtils.isEmpty(m34231p) && !m34231p.startsWith("RISK")) {
                    jSONObject.put("01016", m34231p);
                }
            }
            if (m33867e || m33867e2) {
                try {
                    double m34261b = C7191bh.m34261b();
                    if (m34261b > Utils.DOUBLE_EPSILON) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m34261b);
                        jSONObject.put("09002", sb.toString());
                    }
                    double m34256c = C7191bh.m34256c();
                    if (m34256c > Utils.DOUBLE_EPSILON) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(m34256c);
                        jSONObject.put("09003", sb2.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(C7209bx.m34121a(StubApp.getOrigApplicationContext(this.f24619a.getApplicationContext())), 2));
            jSONObject.put("11012", C7209bx.m34119b(this.f24619a));
            try {
                jSONObject.put("11202", C7191bh.m34257b(C10758b.m24900Is().mo24009Ih()));
                jSONObject.put("11204", C7191bh.m34257b(C10758b.m24900Is().mo24002Io()));
                jSONObject.put("11205", C7191bh.m34257b(C10758b.m24900Is().getDeviceId()));
                jSONObject.put("11206", C7191bh.m34257b(C10758b.m24900Is().getIccId()));
                jSONObject.put("11207", C7191bh.m34257b(C10758b.m24900Is().mo24010Ig()));
                jSONObject.put("11208", C7191bh.m34257b(C10758b.m24900Is().mo24007Ij()));
                jSONObject.put("11209", C7191bh.m34257b(C10758b.m24900Is().mo24006Ik()));
                jSONObject.put("11210", C7191bh.m34257b(C10758b.m24900Is().mo24005Il()));
                jSONObject.put("11211", C7191bh.m34257b(C10758b.m24900Is().getIp()));
                jSONObject.put("11212", C7191bh.m34257b(C10758b.m24900Is().getLocation()));
                jSONObject.put("11213", C7191bh.m34257b(C10758b.m24900Is().getOaid()));
                jSONObject.put("11214", C7191bh.m34257b(C10758b.m24900Is().mo24008Ii()));
                jSONObject.put("11215", C7191bh.m34257b(C10758b.m24900Is().mo24003In()));
                jSONObject.put("11216", C7191bh.m34257b(C10758b.m24900Is().mo24004Im()));
                jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
                jSONObject.put("11104", C10758b.m24900Is().mo24002Io());
                jSONObject.put("11105", C10758b.m24900Is().getDeviceId());
                jSONObject.put("11106", C10758b.m24900Is().getIccId());
                jSONObject.put("11107", C10758b.m24900Is().mo24010Ig());
                jSONObject.put("11108", C10758b.m24900Is().mo24007Ij());
                jSONObject.put("11109", C10758b.m24900Is().mo24006Ik());
                jSONObject.put("11110", C10758b.m24900Is().mo24005Il());
                jSONObject.put("11111", C10758b.m24900Is().getIp());
                jSONObject.put("11112", C10758b.m24900Is().getLocation());
                jSONObject.put("11113", C10758b.m24900Is().getOaid());
                jSONObject.put("11114", C10758b.m24900Is().mo24008Ii());
                jSONObject.put("11115", C10758b.m24900Is().mo24003In());
                jSONObject.put("11116", C10758b.m24900Is().mo24004Im());
            } catch (Throwable unused2) {
            }
            String m34224w = C7191bh.m34224w(this.f24619a);
            if (!TextUtils.isEmpty(m34224w)) {
                jSONObject.put("01026", m34224w);
            }
            if (m33878b == 1) {
                try {
                    JSONObject m34413a = C7165ai.m34413a(this.f24619a);
                    if (m34413a != null) {
                        jSONObject.put("11015", m34413a);
                    }
                    if (Engine.loadSuccess) {
                        C7220ce c7220ce = new C7220ce(this.f24619a);
                        jSONObject.put("02001", c7220ce.m34095a("02001") != null ? c7220ce.m34095a("02001") : C7196bl.m34200a());
                        jSONObject.put("02002", c7220ce.m34095a("02002") != null ? c7220ce.m34095a("02002") : C7196bl.m34197b());
                        jSONObject.put("02003", c7220ce.m34095a("02003") != null ? c7220ce.m34095a("02003") : C7196bl.m34194c());
                        jSONObject.put("02007", c7220ce.m34095a("02007") != null ? c7220ce.m34095a("02007") : C7196bl.m34186g());
                        jSONObject.put("02006", c7220ce.m34095a("02006") != null ? c7220ce.m34095a("02006") : C7196bl.m34188f());
                        jSONObject.put("02004", c7220ce.m34095a("02004") != null ? c7220ce.m34095a("02004") : C7196bl.m34192d());
                        jSONObject.put("02005", c7220ce.m34095a("02005") != null ? c7220ce.m34095a("02005") : C7196bl.m34190e());
                        jSONObject.put("02018", c7220ce.m34095a("02018") != null ? c7220ce.m34095a("02018") : C7196bl.m34170s());
                        jSONObject.put("02013", c7220ce.m34095a("02013") != null ? c7220ce.m34095a("02013") : C7196bl.m34176m());
                        jSONObject.put("02016", c7220ce.m34095a("02016") != null ? c7220ce.m34095a("02016") : C7196bl.m34172q());
                    } else {
                        jSONObject.put("02001", C7196bl.m34200a());
                        jSONObject.put("02002", C7196bl.m34197b());
                        jSONObject.put("02003", C7196bl.m34194c());
                        jSONObject.put("02004", C7196bl.m34192d());
                        jSONObject.put("02005", C7196bl.m34190e());
                        jSONObject.put("02006", C7196bl.m34188f());
                        jSONObject.put("02007", C7196bl.m34186g());
                        jSONObject.put("02018", C7196bl.m34170s());
                        jSONObject.put("02013", C7196bl.m34176m());
                        jSONObject.put("02016", C7196bl.m34172q());
                    }
                    jSONObject.put("02021", C7196bl.m34191d(this.f24619a));
                    jSONObject.put("02022", C7196bl.m34193c(this.f24619a));
                    jSONObject.put("02044", C7196bl.m34169t());
                    jSONObject.put("11009", C7204bs.m34142a(StubApp.getOrigApplicationContext(this.f24619a.getApplicationContext())));
                    if (Engine.loadSuccess) {
                        C7211bz c7211bz = new C7211bz(this.f24619a);
                        jSONObject.put("04001", c7211bz.m34113a("04001") != null ? c7211bz.m34113a("04001") : "");
                        jSONObject.put("04002", c7211bz.m34113a("04002") != null ? c7211bz.m34113a("04002") : "");
                        jSONObject.put("04003", c7211bz.m34113a("04003") != null ? c7211bz.m34113a("04003") : "");
                        jSONObject.put("04004", c7211bz.m34113a("04004") != null ? c7211bz.m34113a("04004") : "");
                    } else {
                        try {
                            C7194bj m34213b = C7195bk.m34213b();
                            jSONObject.put("04001", C7195bk.m34214a());
                            jSONObject.put("04002", m34213b.m34217b());
                            jSONObject.put("04003", m34213b.m34215c());
                            jSONObject.put("04004", m34213b.m34220a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.f24620b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put("20000", this.f24621c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34122a(String str) {
        try {
            synchronized (f24618d) {
                JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24619a);
                if (m34081a == null) {
                    return null;
                }
                JSONObject m34123a = m34123a();
                if (m34123a == null) {
                    return null;
                }
                m34081a.put("module_section", m34123a);
                return m34081a.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
