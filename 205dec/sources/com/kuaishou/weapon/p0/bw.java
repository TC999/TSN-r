package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bw {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f38117d = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private Context f38118a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38119b;

    /* renamed from: c  reason: collision with root package name */
    private int f38120c;

    public bw(Context context, int i4, boolean z3) {
        this.f38118a = context;
        this.f38119b = z3;
        this.f38120c = i4;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            h a4 = h.a(this.f38118a, "re_po_rt");
            boolean e4 = a4.e("a1_p_s_p_s");
            boolean e5 = a4.e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", e4 ? 1 : 0);
            jSONObject.put("11029", e5 ? 1 : 0);
            if (a4.b("plc001_c_ccl_ie", 1) == 1 && (e4 || e5)) {
                String a5 = bh.a(this.f38118a);
                if (!TextUtils.isEmpty(a5) && !a5.startsWith("RISK")) {
                    jSONObject.put("01001", f.a(a5));
                }
                String c4 = bh.c(this.f38118a);
                if (!TextUtils.isEmpty(c4) && !c4.startsWith("RISK")) {
                    jSONObject.put("01003", c4);
                }
                String b4 = bh.b(this.f38118a, 0);
                if (!TextUtils.isEmpty(b4) && !b4.startsWith("RISK")) {
                    jSONObject.put("01019", b4);
                }
                String b5 = bh.b(this.f38118a, 1);
                if (!TextUtils.isEmpty(b5) && !b5.startsWith("RISK")) {
                    jSONObject.put("01004", f.a(b5));
                }
            }
            int b6 = a4.b("plc001_c_ccl_d", 1);
            if (b6 == 1 && (e4 || e5)) {
                String f4 = bh.f(this.f38118a);
                if (!TextUtils.isEmpty(f4) && !f4.startsWith("RISK")) {
                    jSONObject.put("01013", f4);
                }
            }
            if (a4.b("plc001_c_ccl_is", 1) == 1 && (e4 || e5)) {
                String d4 = bh.d(this.f38118a);
                if (!TextUtils.isEmpty(d4) && !d4.startsWith("RISK")) {
                    jSONObject.put("01007", d4);
                }
            }
            if (a4.b("plc001_c_ccl_ic", 1) == 1 && (e4 || e5)) {
                jSONObject.put("01011", bh.e(this.f38118a));
            }
            if (e4 || e5) {
                String h4 = bh.h();
                if (!TextUtils.isEmpty(h4) && !h4.startsWith("RISK")) {
                    jSONObject.put("07005", h4);
                } else if (h4 == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", h4);
                }
                jSONObject.put("07006", bh.g());
            }
            if (a4.b("plc001_c_ccl_btm", 1) == 1 && (e4 || e5)) {
                String p3 = bh.p(this.f38118a);
                if (!TextUtils.isEmpty(p3) && !p3.startsWith("RISK")) {
                    jSONObject.put("01016", p3);
                }
            }
            if (e4 || e5) {
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
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(bx.a(StubApp.getOrigApplicationContext(this.f38118a.getApplicationContext())), 2));
            jSONObject.put("11012", bx.b(this.f38118a));
            try {
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
            } catch (Throwable unused2) {
            }
            String w3 = bh.w(this.f38118a);
            if (!TextUtils.isEmpty(w3)) {
                jSONObject.put("01026", w3);
            }
            if (b6 == 1) {
                try {
                    JSONObject a6 = ai.a(this.f38118a);
                    if (a6 != null) {
                        jSONObject.put("11015", a6);
                    }
                    if (Engine.loadSuccess) {
                        ce ceVar = new ce(this.f38118a);
                        jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                        jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                        jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                        jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                        jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                        jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                        jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                        jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                        jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                        jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02018", bl.s());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02016", bl.q());
                    }
                    jSONObject.put("02021", bl.d(this.f38118a));
                    jSONObject.put("02022", bl.c(this.f38118a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("11009", bs.a(StubApp.getOrigApplicationContext(this.f38118a.getApplicationContext())));
                    if (Engine.loadSuccess) {
                        bz bzVar = new bz(this.f38118a);
                        jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : "");
                        jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : "");
                        jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : "");
                        jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : "");
                    } else {
                        try {
                            bj b8 = bk.b();
                            jSONObject.put("04001", bk.a());
                            jSONObject.put("04002", b8.b());
                            jSONObject.put("04003", b8.c());
                            jSONObject.put("04004", b8.a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.f38119b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put("20000", this.f38120c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (f38117d) {
                JSONObject a4 = new cm(str, ck.f38176l).a(this.f38118a);
                if (a4 == null) {
                    return null;
                }
                JSONObject a5 = a();
                if (a5 == null) {
                    return null;
                }
                a4.put("module_section", a5);
                return a4.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
