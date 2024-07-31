package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.jni.C7286A;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.kwad.sdk.p433f.C10758b;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7230cn {

    /* renamed from: a */
    private Context f24710a;

    /* renamed from: b */
    private int f24711b;

    public C7230cn(Context context, int i) {
        this.f24710a = context;
        this.f24711b = i;
    }

    /* renamed from: a */
    public JSONObject m34054a() {
        long j;
        C7283h c7283h;
        boolean z;
        boolean z2;
        String str;
        String str2;
        C7230cn c7230cn;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            C7283h m33888a = C7283h.m33888a(this.f24710a, "re_po_rt");
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            if (m33888a.m33878b(C7262df.f24830aO, 1) == 1 && (m33867e || m33867e2)) {
                String m34267a = C7191bh.m34267a(this.f24710a);
                if (!TextUtils.isEmpty(m34267a) && !m34267a.startsWith("RISK")) {
                    jSONObject.put("01001", m34267a);
                }
                String m34255c = C7191bh.m34255c(this.f24710a);
                if (!TextUtils.isEmpty(m34255c) && !m34255c.startsWith("RISK")) {
                    jSONObject.put("01003", m34255c);
                }
                String m34259b = C7191bh.m34259b(this.f24710a, 0);
                if (!TextUtils.isEmpty(m34259b) && !m34259b.startsWith("RISK")) {
                    jSONObject.put("01019", m34259b);
                }
                String m34259b2 = C7191bh.m34259b(this.f24710a, 1);
                if (!TextUtils.isEmpty(m34259b2) && !m34259b2.startsWith("RISK")) {
                    jSONObject.put("01004", m34259b2);
                }
                String m34252d = C7191bh.m34252d(this.f24710a);
                if (!TextUtils.isEmpty(m34252d) && !m34252d.startsWith("RISK")) {
                    jSONObject.put("01007", m34252d);
                }
            }
            if (m33888a.m33878b(C7262df.f24831aP, 0) == 1 && (m33867e || m33867e2)) {
                C7190bg c7190bg = new C7190bg();
                if (m33888a.m33878b(C7262df.f24871bc, 1) == 1) {
                    jSONObject.put("10020", c7190bg.m34272f(this.f24710a));
                }
            }
            if (m33888a.m33878b(C7262df.f24832aQ, 1) == 1 && (m33867e || m33867e2)) {
                jSONObject.put("01011", C7191bh.m34250e(this.f24710a));
            }
            if (m33888a.m33878b(C7262df.f24833aR, 1) == 1 && (m33867e || m33867e2)) {
                String m34231p = C7191bh.m34231p(this.f24710a);
                if (!TextUtils.isEmpty(m34231p) && !m34231p.startsWith("RISK")) {
                    jSONObject.put("01016", m34231p);
                }
            }
            if (m33888a.m33878b(C7262df.f24821aF, 1) == 1) {
                if (m33867e || m33867e2) {
                    String m34248f = C7191bh.m34248f(this.f24710a);
                    if (!TextUtils.isEmpty(m34248f) && !m34248f.startsWith("RISK")) {
                        jSONObject.put("01013", m34248f);
                    }
                    jSONObject.put("02042", C7191bh.m34226u(this.f24710a));
                }
                jSONObject.put("02054", C7191bh.m34223x(this.f24710a));
                j = currentTimeMillis;
                str = "RISK";
                z2 = m33867e2;
                z = m33867e;
                try {
                    if (Engine.loadSuccess) {
                        try {
                            jSONObject.put("02019", C7196bl.m34196b(this.f24710a));
                            jSONObject.put("02021", C7196bl.m34191d(this.f24710a));
                            jSONObject.put("02022", C7196bl.m34193c(this.f24710a));
                            jSONObject.put("02030", C7196bl.m34187f(this.f24710a));
                            C7220ce c7220ce = new C7220ce(this.f24710a);
                            jSONObject.put("01014", c7220ce.m34095a("01014") != null ? c7220ce.m34095a("01014") : "");
                            jSONObject.put("02001", c7220ce.m34095a("02001") != null ? c7220ce.m34095a("02001") : C7196bl.m34200a());
                            jSONObject.put("02002", c7220ce.m34095a("02002") != null ? c7220ce.m34095a("02002") : C7196bl.m34197b());
                            jSONObject.put("02003", c7220ce.m34095a("02003") != null ? c7220ce.m34095a("02003") : C7196bl.m34194c());
                            jSONObject.put("02004", c7220ce.m34095a("02004") != null ? c7220ce.m34095a("02004") : C7196bl.m34192d());
                            jSONObject.put("02005", c7220ce.m34095a("02005") != null ? c7220ce.m34095a("02005") : C7196bl.m34190e());
                            jSONObject.put("02006", c7220ce.m34095a("02006") != null ? c7220ce.m34095a("02006") : C7196bl.m34188f());
                            jSONObject.put("02007", c7220ce.m34095a("02007") != null ? c7220ce.m34095a("02007") : C7196bl.m34186g());
                            jSONObject.put("02008", c7220ce.m34095a("02008") != null ? c7220ce.m34095a("02008") : C7196bl.m34184h());
                            jSONObject.put("02009", c7220ce.m34095a("02009") != null ? c7220ce.m34095a("02009") : C7196bl.m34182i());
                            jSONObject.put("02010", c7220ce.m34095a("02010") != null ? c7220ce.m34095a("02010") : C7196bl.m34180j());
                            jSONObject.put("02011", c7220ce.m34095a("02011") != null ? c7220ce.m34095a("02011") : C7196bl.m34178k());
                            jSONObject.put("02012", c7220ce.m34095a("02012") != null ? c7220ce.m34095a("02012") : C7196bl.m34177l());
                            jSONObject.put("02013", c7220ce.m34095a("02013") != null ? c7220ce.m34095a("02013") : C7196bl.m34176m());
                            jSONObject.put("02014", c7220ce.m34095a("02014") != null ? c7220ce.m34095a("02014") : C7196bl.m34175n());
                            jSONObject.put("02015", c7220ce.m34095a("02015") != null ? c7220ce.m34095a("02015") : C7196bl.m34173p());
                            jSONObject.put("02016", c7220ce.m34095a("02016") != null ? c7220ce.m34095a("02016") : C7196bl.m34172q());
                            jSONObject.put("02017", c7220ce.m34095a("02017") != null ? c7220ce.m34095a("02017") : Integer.valueOf(C7196bl.m34171r()));
                            jSONObject.put("02018", c7220ce.m34095a("02018") != null ? c7220ce.m34095a("02018") : C7196bl.m34170s());
                            jSONObject.put("02020", c7220ce.m34095a("02020") != null ? c7220ce.m34095a("02020") : C7196bl.m34168u());
                            jSONObject.put("02023", c7220ce.m34095a("02023") != null ? c7220ce.m34095a("02023") : "");
                            jSONObject.put("02031", c7220ce.m34095a("02031") != null ? c7220ce.m34095a("02031") : C7196bl.m34164y());
                            jSONObject.put("02032", c7220ce.m34095a("02032") != null ? c7220ce.m34095a("02032") : C7196bl.m34174o());
                            jSONObject.put("02033", c7220ce.m34095a("02033") != null ? c7220ce.m34095a("02033") : C7196bl.m34165x());
                            jSONObject.put("02034", c7220ce.m34095a("02034") != null ? c7220ce.m34095a("02034") : C7196bl.m34163z());
                            jSONObject.put("02035", c7220ce.m34095a("02035") != null ? c7220ce.m34095a("02035") : C7196bl.m34212A());
                            jSONObject.put("02036", c7220ce.m34095a("02036") != null ? c7220ce.m34095a("02036") : "");
                            jSONObject.put("02037", c7220ce.m34095a("02037") != null ? c7220ce.m34095a("02037") : C7196bl.m34166w());
                            jSONObject.put("02038", c7220ce.m34095a("02038") != null ? c7220ce.m34095a("02038") : C7196bl.m34167v());
                            jSONObject.put("02045", c7220ce.m34095a("02045") != null ? c7220ce.m34095a("02045") : C7196bl.m34211B());
                        } catch (Exception unused) {
                        }
                        c7230cn = this;
                    } else {
                        jSONObject.put("02001", C7196bl.m34200a());
                        jSONObject.put("02002", C7196bl.m34197b());
                        jSONObject.put("02003", C7196bl.m34194c());
                        jSONObject.put("02004", C7196bl.m34192d());
                        jSONObject.put("02005", C7196bl.m34190e());
                        jSONObject.put("02006", C7196bl.m34188f());
                        jSONObject.put("02007", C7196bl.m34186g());
                        jSONObject.put("02008", C7196bl.m34184h());
                        jSONObject.put("02009", C7196bl.m34182i());
                        jSONObject.put("02010", C7196bl.m34180j());
                        jSONObject.put("02011", C7196bl.m34178k());
                        jSONObject.put("02012", C7196bl.m34177l());
                        jSONObject.put("02013", C7196bl.m34176m());
                        jSONObject.put("02014", C7196bl.m34175n());
                        jSONObject.put("02015", C7196bl.m34173p());
                        jSONObject.put("02016", C7196bl.m34172q());
                        jSONObject.put("02017", C7196bl.m34171r());
                        jSONObject.put("02018", C7196bl.m34170s());
                        c7230cn = this;
                        try {
                            jSONObject.put("02019", C7196bl.m34196b(c7230cn.f24710a));
                            jSONObject.put("02020", C7196bl.m34168u());
                            jSONObject.put("02021", C7196bl.m34191d(c7230cn.f24710a));
                            jSONObject.put("02022", C7196bl.m34193c(c7230cn.f24710a));
                            jSONObject.put("02030", C7196bl.m34187f(c7230cn.f24710a));
                            jSONObject.put("02031", C7196bl.m34164y());
                            jSONObject.put("02032", C7196bl.m34174o());
                            jSONObject.put("02033", C7196bl.m34165x());
                            jSONObject.put("02034", C7196bl.m34163z());
                            jSONObject.put("02035", C7196bl.m34212A());
                            jSONObject.put("02037", C7196bl.m34166w());
                            jSONObject.put("02038", C7196bl.m34167v());
                            jSONObject.put("02045", C7196bl.m34211B());
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    str2 = "";
                    jSONObject.put("02067", StubApp.getOrigApplicationContext(c7230cn.f24710a.getApplicationContext()).getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                    jSONObject.put("02039", C7191bh.m34243i());
                    jSONObject.put("02040", C7191bh.m34241j());
                    jSONObject.put("02041", C7191bh.m34227t(c7230cn.f24710a));
                    jSONObject.put("02044", C7196bl.m34169t());
                    jSONObject.put("02046", C7196bl.m34210C());
                    String m34262a = C7191bh.m34262a("persist.service.adb.enable");
                    if (!TextUtils.isEmpty(m34262a)) {
                        jSONObject.put("03058", m34262a);
                    }
                    String m34262a2 = C7191bh.m34262a("sys.resettype");
                    if (!TextUtils.isEmpty(m34262a2)) {
                        jSONObject.put("03057", m34262a2);
                    }
                    String m34262a3 = C7191bh.m34262a("ro.boot.bootreason");
                    if (!TextUtils.isEmpty(m34262a3)) {
                        jSONObject.put("03056", m34262a3);
                    }
                    String m34262a4 = C7191bh.m34262a("ro.runtime.firstboot");
                    if (!TextUtils.isEmpty(m34262a4)) {
                        jSONObject.put("03055", m34262a4);
                    }
                    String m34262a5 = C7191bh.m34262a("init.svc.atcmdserver");
                    if (!TextUtils.isEmpty(m34262a5)) {
                        jSONObject.put("03054", m34262a5);
                    }
                    String m34262a6 = C7191bh.m34262a("ro.build.date.utc");
                    if (!TextUtils.isEmpty(m34262a6)) {
                        jSONObject.put("03061", m34262a6);
                    }
                    String m34262a7 = C7191bh.m34262a("ro.bootimage.build.date.utc");
                    if (!TextUtils.isEmpty(m34262a7)) {
                        jSONObject.put("03062", m34262a7);
                    }
                    String m34262a8 = C7191bh.m34262a("ro.build.date.YmdHM");
                    if (!TextUtils.isEmpty(m34262a8)) {
                        jSONObject.put("03063", m34262a8);
                    }
                    String m34262a9 = C7191bh.m34262a("dhcp.ipv6.wlan0.dns1");
                    if (!TextUtils.isEmpty(m34262a9)) {
                        jSONObject.put("03067", m34262a9);
                    }
                    String m34262a10 = C7191bh.m34262a("dhcp.ipv6.wlan0.dns2");
                    if (!TextUtils.isEmpty(m34262a10)) {
                        jSONObject.put("03068", m34262a10);
                    }
                    String m34262a11 = C7191bh.m34262a("dhcp.wlan0.dns1");
                    if (!TextUtils.isEmpty(m34262a11)) {
                        jSONObject.put("03069", m34262a11);
                    }
                    String m34262a12 = C7191bh.m34262a("dhcp.wlan0.dns2");
                    if (!TextUtils.isEmpty(m34262a12)) {
                        jSONObject.put("03070", m34262a12);
                    }
                    String m34262a13 = C7191bh.m34262a("net.change");
                    if (!TextUtils.isEmpty(m34262a13)) {
                        jSONObject.put("03071", m34262a13);
                    }
                    String m34262a14 = C7191bh.m34262a("net.dns1");
                    if (!TextUtils.isEmpty(m34262a14)) {
                        jSONObject.put("03072", m34262a14);
                    }
                    String m34262a15 = C7191bh.m34262a("net.dns2");
                    if (!TextUtils.isEmpty(m34262a15)) {
                        jSONObject.put("03073", m34262a15);
                    }
                    c7283h = m33888a;
                    long m33884a = c7283h.m33884a(C7262df.f24892d, -1L);
                    if (m33884a != -1) {
                        jSONObject.put("03074", m33884a + System.currentTimeMillis());
                    }
                    try {
                        jSONObject.put("03064", Settings.System.getInt(c7230cn.f24710a.getContentResolver(), "screen_brightness_mode"));
                        jSONObject.put("03065", Settings.System.getInt(c7230cn.f24710a.getContentResolver(), "accelerometer_rotation"));
                    } catch (Throwable unused3) {
                    }
                    jSONObject.put("03081", C7196bl.m34201L());
                    jSONObject.put("03053", C7191bh.m34222y(c7230cn.f24710a));
                    jSONObject.put("03052", C7196bl.m34181i(c7230cn.f24710a));
                    jSONObject.put("03050", C7196bl.m34183h(c7230cn.f24710a));
                    jSONObject.put("03049", C7196bl.m34185g(c7230cn.f24710a));
                    jSONObject.put("02027", C7196bl.m34205H());
                    jSONObject.put("02028", C7196bl.m34209D());
                    jSONObject.put("02029", C7196bl.m34208E());
                    jSONObject.put("02057", C7196bl.m34207F());
                    jSONObject.put("02058", C7196bl.m34206G());
                } catch (Throwable unused4) {
                    return null;
                }
            } else {
                j = currentTimeMillis;
                c7283h = m33888a;
                z = m33867e;
                z2 = m33867e2;
                str = "RISK";
                str2 = "";
                c7230cn = this;
            }
            if (c7283h.m33878b(C7262df.f24822aG, 1) == 1) {
                jSONObject.put("03001", C7199bo.m34151a());
                jSONObject.put("03002", C7199bo.m34148b());
                jSONObject.put("03001", C7199bo.m34151a());
                jSONObject.put("03043", SystemClock.elapsedRealtime());
                jSONObject.put("03044", SystemClock.uptimeMillis());
                jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                C7210by c7210by = new C7210by(c7230cn.f24710a);
                if (Engine.loadSuccess) {
                    jSONObject.put("03004", c7210by.m34115a("03004") != null ? c7210by.m34115a("03004") : str2);
                    jSONObject.put("03036", c7210by.m34114b("03036") != null ? c7210by.m34114b("03036") : str2);
                    jSONObject.put("03039", c7210by.m34115a("03039") != null ? c7210by.m34115a("03039") : str2);
                    jSONObject.put("03040", c7210by.m34115a("03040") != null ? c7210by.m34115a("03040") : str2);
                    jSONObject.put("03041", c7210by.m34115a("03041") != null ? c7210by.m34115a("03041") : str2);
                    jSONObject.put("03042", c7210by.m34115a("03042") != null ? c7210by.m34115a("03042") : str2);
                    jSONObject.put("03079", c7210by.m34115a("03079") != null ? c7210by.m34115a("03079") : null);
                    jSONObject.put("03080", c7210by.m34115a("03080") != null ? c7210by.m34115a("03080") : null);
                }
                jSONObject.put("03007", C7207bv.m34127a(c7230cn.f24710a));
                jSONObject.put("03008", C7207bv.m34125c(c7230cn.f24710a));
                jSONObject.put("03011", C7169am.m34370b(c7230cn.f24710a));
                jSONObject.put("03012", C7169am.m34371b());
                jSONObject.put("03014", C7191bh.m34246g(c7230cn.f24710a));
                jSONObject.put("03034", C7191bh.m34244h(c7230cn.f24710a));
                jSONObject.put("03020", C7207bv.m34126b(c7230cn.f24710a));
                jSONObject.put("03037", C7196bl.m34204I());
                jSONObject.put("03038", C7196bl.m34203J());
                jSONObject.put("03077", C7196bl.m34202K());
                try {
                    C7190bg c7190bg2 = new C7190bg();
                    jSONObject.put("03006", c7190bg2.m34278a(c7230cn.f24710a));
                    jSONObject.put("03010", c7190bg2.m34276b(c7230cn.f24710a));
                    jSONObject.put("03033", c7190bg2.m34275c(c7230cn.f24710a));
                    jSONObject.put("03013", c7190bg2.m34279a());
                    jSONObject.put("03021", c7190bg2.m34273e(c7230cn.f24710a));
                    jSONObject.put("03030", C7190bg.m34274d(c7230cn.f24710a));
                    jSONObject.put("10031", c7190bg2.m34277b());
                } catch (Exception unused5) {
                }
            }
            if (c7283h.m33878b(C7262df.f24836aU, 0) == 1) {
                jSONObject.put("03019", C7191bh.m34238k(c7230cn.f24710a));
                String m34234m = C7191bh.m34234m(c7230cn.f24710a);
                if (!TextUtils.isEmpty(m34234m)) {
                    jSONObject.put("03047", m34234m);
                }
                jSONObject.put("03018", C7191bh.m34242i(c7230cn.f24710a));
            }
            if (c7283h.m33878b(C7262df.f24837aV, 1) == 1) {
                jSONObject.put("02059", C7197bm.m34161a(c7230cn.f24710a));
                jSONObject.put("02060", C7197bm.m34162a());
                jSONObject.put("02061", C7197bm.m34160b());
                jSONObject.put("02062", C7197bm.m34159c());
                if (Engine.loadSuccess) {
                    C7216ca c7216ca = new C7216ca(c7230cn.f24710a);
                    jSONObject.put("08001", c7216ca.m34099a("08001") != null ? c7216ca.m34099a("08001") : str2);
                }
                JSONObject m34158d = C7197bm.m34158d();
                if (m34158d != null && m34158d.length() > 0) {
                    jSONObject.put("10050", m34158d);
                }
            }
            if (c7283h.m33878b(C7262df.f24835aT, 1) == 1 && (z || z2)) {
                jSONObject.put("03029", C7191bh.m34240j(c7230cn.f24710a));
            }
            if (c7283h.m33878b(C7262df.f24823aH, 1) == 1) {
                if (Engine.loadSuccess) {
                    C7211bz c7211bz = new C7211bz(c7230cn.f24710a);
                    jSONObject.put("04001", c7211bz.m34113a("04001") != null ? c7211bz.m34113a("04001") : str2);
                    jSONObject.put("04002", c7211bz.m34113a("04002") != null ? c7211bz.m34113a("04002") : str2);
                    jSONObject.put("04003", c7211bz.m34113a("04003") != null ? c7211bz.m34113a("04003") : str2);
                    jSONObject.put("04004", c7211bz.m34113a("04004") != null ? c7211bz.m34113a("04004") : str2);
                } else {
                    try {
                        C7194bj m34213b = C7195bk.m34213b();
                        jSONObject.put("04001", C7195bk.m34214a());
                        jSONObject.put("04002", m34213b.m34217b());
                        jSONObject.put("04003", m34213b.m34215c());
                        jSONObject.put("04004", m34213b.m34220a());
                    } catch (Exception unused6) {
                    }
                }
            }
            if (c7283h.m33878b(C7262df.f24826aK, 0) == 1 && (z || z2)) {
                Object m34249f = C7191bh.m34249f();
                if (m34249f != null) {
                    jSONObject.put("06014", m34249f);
                }
                if (Engine.loadSuccess) {
                    C7221cf c7221cf = new C7221cf(c7230cn.f24710a);
                    jSONObject.put("06015", c7221cf.m34093b("06015") != null ? c7221cf.m34093b("06015") : str2);
                }
            }
            if (z || z2) {
                String m34245h = C7191bh.m34245h();
                if (!TextUtils.isEmpty(m34245h) && !m34245h.startsWith(str)) {
                    jSONObject.put("07005", m34245h);
                } else if (m34245h == null) {
                    jSONObject.put("07005", str2);
                } else {
                    jSONObject.put("07005", m34245h);
                }
            }
            if (c7283h.m33878b(C7262df.f24824aI, 0) == 1 && (z || z2)) {
                if (Engine.loadSuccess) {
                    jSONObject.put("07007", new C7218cc(c7230cn.f24710a).m34097a("07007"));
                }
                JSONArray m34143a = C7203br.m34143a(c7230cn.f24710a);
                if (m34143a != null && m34143a.length() > 0) {
                    jSONObject.put("03035", m34143a);
                }
            }
            if (z || z2) {
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
                    jSONObject.put("09001", C7191bh.m34253d());
                } catch (Exception unused7) {
                }
            }
            if (c7283h.m33878b(C7262df.f24828aM, 0) == 1 && (z || z2)) {
                jSONObject.put("10002", new C7309w(c7230cn.f24710a).m33726a(1));
            }
            if (c7283h.m33878b(C7262df.f24825aJ, 1) == 1 && Engine.loadSuccess) {
                String m34096a = new C7219cd(c7230cn.f24710a).m34096a("05001");
                try {
                    if (!TextUtils.isEmpty(m34096a) && m34096a.length() > 10) {
                        jSONObject.put("05001", new JSONArray(m34096a));
                    }
                } catch (Exception unused8) {
                }
            }
            if (Engine.loadSuccess) {
                C7217cb c7217cb = new C7217cb(c7230cn.f24710a);
                jSONObject.put("13001", c7217cb.m34098a("13001") != null ? c7217cb.m34098a("13001") : str2);
            }
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11003", C7193bi.f24587v);
            jSONObject.put("11004", Engine.loadSoCount);
            jSONObject.put("11006", z ? 1 : 0);
            jSONObject.put("11029", z2 ? 1 : 0);
            jSONObject.put("11008", c7283h.m33876b(C7262df.f24895g, C7202bq.f24602e));
            jSONObject.put("11009", C7204bs.m34142a(StubApp.getOrigApplicationContext(c7230cn.f24710a.getApplicationContext())));
            try {
                String m34224w = C7191bh.m34224w(c7230cn.f24710a);
                if (!TextUtils.isEmpty(m34224w)) {
                    jSONObject.put("01026", m34224w);
                }
                if (c7283h.m33878b(C7262df.f24827aL, 1) == 1) {
                    String mo24009Ih = C10758b.m24900Is().mo24009Ih();
                    if (!TextUtils.isEmpty(mo24009Ih)) {
                        jSONObject.put("11102", mo24009Ih);
                    }
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
                }
            } catch (Throwable unused9) {
            }
            try {
                jSONObject.put("02078", C7286A.getE("W_S_V"));
                jSONObject.put("02079", C7286A.getE("W_S_S_V"));
                if (Build.VERSION.SDK_INT > 21) {
                    jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                }
                String string = Settings.Global.getString(c7230cn.f24710a.getContentResolver(), "Phenotype_boot_count");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("03085", string);
                }
                String string2 = Settings.Global.getString(c7230cn.f24710a.getContentResolver(), "boot_count");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("03086", string2);
                }
                String string3 = Settings.System.getString(c7230cn.f24710a.getContentResolver(), "power_on_times");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("03091", string3);
                }
                String string4 = Settings.System.getString(c7230cn.f24710a.getContentResolver(), "first_boot_flag");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("03104", string4);
                }
                jSONObject.put("03113", C7191bh.m34269a());
            } catch (Throwable unused10) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - j);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused11) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34053a(String str) {
        JSONObject m34054a;
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24710a);
            if (m34081a == null || (m34054a = m34054a()) == null) {
                return null;
            }
            m34081a.put("module_section", m34054a);
            return m34081a.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
