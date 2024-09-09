package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: ReportUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39725a = "e";

    public static String a(Campaign campaign, int i4, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put("label", i4);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put("title", campaign.getAppName());
                jSONObject.put("value", jSONObject2);
            } else {
                jSONObject.put("value", "");
            }
        } catch (Exception unused) {
            x.d(f39725a, "ad track data failed !");
        }
        return jSONObject.toString();
    }

    public static void b() {
        try {
            ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String c(Context context, String str) {
        String g4;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pf", "1");
                jSONObject.put("ov", t.C());
                jSONObject.put("pn", t.A(context));
                jSONObject.put("vn", t.v(context));
                jSONObject.put("vc", t.u(context));
                jSONObject.put("ot", t.t(context));
                jSONObject.put("dm", t.x());
                jSONObject.put("bd", t.z());
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, t.E());
                jSONObject.put("mnc", com.mbridge.msdk.foundation.tools.e.e(context));
                jSONObject.put("mcc", com.mbridge.msdk.foundation.tools.e.d(context));
                int D = t.D(context);
                jSONObject.put("nt", D);
                jSONObject.put("nts", t.a(context, D));
                jSONObject.put("l", t.s(context));
                jSONObject.put("tz", t.B());
                jSONObject.put("ua", t.A());
                jSONObject.put("app_id", com.mbridge.msdk.foundation.controller.a.f().k());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject.put("sv", MBConfiguration.SDK_VERSION);
                jSONObject.put("gpv", com.mbridge.msdk.foundation.tools.e.j(context));
                jSONObject.put("ss", t.x(context) + "x" + t.y(context));
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (b4.Z() == 1) {
                            String b5 = com.mbridge.msdk.foundation.tools.e.b(context);
                            if (b5 != null) {
                                jSONObject2.put("imei", b5);
                            }
                            String i4 = com.mbridge.msdk.foundation.tools.e.i(context);
                            if (i4 != null) {
                                jSONObject2.put("mac", i4);
                            }
                        }
                        if (b4.aa() == 1 && (g4 = com.mbridge.msdk.foundation.tools.e.g(context)) != null) {
                            jSONObject2.put("android_id", g4);
                        }
                        try {
                            String H = t.H();
                            if (!TextUtils.isEmpty(H)) {
                                jSONObject2.put("manufacturer", H);
                            }
                            String b6 = com.mbridge.msdk.foundation.tools.e.b();
                            if (!TextUtils.isEmpty(b6)) {
                                jSONObject2.put("cpu2", b6);
                            }
                            String d4 = com.mbridge.msdk.foundation.tools.e.d();
                            if (!TextUtils.isEmpty(d4)) {
                                jSONObject2.put("tags", d4);
                            }
                            String e4 = com.mbridge.msdk.foundation.tools.e.e();
                            if (!TextUtils.isEmpty(e4)) {
                                jSONObject2.put("user", e4);
                            }
                            String f4 = com.mbridge.msdk.foundation.tools.e.f();
                            if (!TextUtils.isEmpty(f4)) {
                                jSONObject2.put("radio", f4);
                            }
                            String g5 = com.mbridge.msdk.foundation.tools.e.g();
                            if (!TextUtils.isEmpty(g5)) {
                                jSONObject2.put("bootloader", g5);
                            }
                            String h4 = com.mbridge.msdk.foundation.tools.e.h();
                            if (!TextUtils.isEmpty(h4)) {
                                jSONObject2.put("hardware", h4);
                            }
                            String i5 = com.mbridge.msdk.foundation.tools.e.i();
                            if (!TextUtils.isEmpty(i5)) {
                                jSONObject2.put("host", i5);
                            }
                            String j4 = com.mbridge.msdk.foundation.tools.e.j();
                            if (!TextUtils.isEmpty(j4)) {
                                jSONObject2.put("codename", j4);
                            }
                            String k4 = com.mbridge.msdk.foundation.tools.e.k();
                            if (!TextUtils.isEmpty(k4)) {
                                jSONObject2.put("incremental", k4);
                            }
                            String l4 = com.mbridge.msdk.foundation.tools.e.l();
                            if (!TextUtils.isEmpty(l4)) {
                                jSONObject2.put("serial", l4);
                            }
                            String m4 = com.mbridge.msdk.foundation.tools.e.m();
                            if (!TextUtils.isEmpty(m4)) {
                                jSONObject2.put("display", m4);
                            }
                            String n4 = com.mbridge.msdk.foundation.tools.e.n();
                            if (!TextUtils.isEmpty(n4)) {
                                jSONObject2.put("board", n4);
                            }
                            String o4 = com.mbridge.msdk.foundation.tools.e.o();
                            if (!TextUtils.isEmpty(o4)) {
                                jSONObject2.put("type", o4);
                            }
                            String c4 = com.mbridge.msdk.foundation.tools.e.c();
                            if (!TextUtils.isEmpty(c4)) {
                                jSONObject2.put("support", c4);
                            }
                            String p3 = com.mbridge.msdk.foundation.tools.e.p();
                            if (!TextUtils.isEmpty(p3)) {
                                jSONObject2.put("release", p3);
                            }
                            int q3 = com.mbridge.msdk.foundation.tools.e.q();
                            if (q3 != -1) {
                                jSONObject2.put("sdkint", q3);
                            }
                            String l5 = com.mbridge.msdk.foundation.tools.e.l(context);
                            if (!TextUtils.isEmpty(l5)) {
                                jSONObject2.put("battery", l5);
                            }
                            int k5 = com.mbridge.msdk.foundation.tools.e.k(context);
                            if (k5 != -1) {
                                jSONObject2.put("batterystatus", k5);
                            }
                            int r3 = com.mbridge.msdk.foundation.tools.e.r();
                            if (r3 != -1) {
                                jSONObject2.put("baseos", r3);
                            }
                            String E = t.E(context);
                            if (!TextUtils.isEmpty(E)) {
                                jSONObject2.put("is24H", E);
                            }
                            int n5 = com.mbridge.msdk.foundation.tools.e.n(context);
                            if (n5 != -1) {
                                jSONObject2.put("sensor", n5);
                            }
                            String o5 = com.mbridge.msdk.foundation.tools.e.o(context);
                            if (!TextUtils.isEmpty(o5)) {
                                jSONObject2.put("ime", o5);
                            }
                            int m5 = com.mbridge.msdk.foundation.tools.e.m(context);
                            if (m5 != -1) {
                                jSONObject2.put("phonetype", m5);
                            }
                            String I = t.I();
                            if (!TextUtils.isEmpty(I)) {
                                jSONObject2.put("totalram", I);
                            }
                            String F = t.F(context);
                            if (!TextUtils.isEmpty(F)) {
                                jSONObject2.put("totalmemory", F);
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(jSONObject2.toString())) {
                            String a4 = s.a(jSONObject2.toString());
                            if (!TextUtils.isEmpty(a4)) {
                                jSONObject.put("dvi", URLEncoder.encode(a4, "utf-8"));
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                return jSONObject.toString();
            } catch (Exception e7) {
                e7.printStackTrace();
                return "";
            }
        }
        return "";
    }

    private static void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(str, context, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.e.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    x.d(e.f39725a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    x.d(e.f39725a, str2);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f39725a, e4.getMessage());
        }
    }

    private static void e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.e.3
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    x.d(e.f39725a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    x.d(e.f39725a, str2);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f39725a, e4.getMessage());
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + t.D(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("reason=" + str2 + "&");
                    stringBuffer.append("result=1&");
                    stringBuffer.append("devid=" + t.E() + "&");
                    if (campaignEx != null) {
                        stringBuffer.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            stringBuffer.append("ad_type=5&");
                            stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            stringBuffer.append("ad_type=6&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            stringBuffer.append("ad_type=7&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        }
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                    }
                    if (b.a().c()) {
                        b.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, String str2, Context context, String str3) {
        if (context != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        dVar.a("m_device_info", c(context, str3));
        dVar.a("m_action", str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str4 = f39725a;
                x.a(str4, "8.5.0 add channel ,before value : " + str2);
                String a4 = Aa.a();
                if (a4 == null) {
                    a4 = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("channel", a4);
                String str5 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str3);
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject.put("u_stid", str5 != null ? str5 : "");
                }
                str2 = jSONObject.toString();
                x.a(str4, "8.5.0 add channel ,update value : " + str2);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                String str6 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str3);
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject2.put("u_stid", str6 != null ? str6 : "");
                }
                str2 = jSONObject2.toString();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dVar.a("m_data", str2);
        dVar.a("m_sdk", "msdk");
        return dVar;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(Context context) {
        String g4;
        String a4;
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        try {
            dVar.a("platform", "1");
            String A = t.A(context);
            if (!TextUtils.isEmpty(A)) {
                dVar.a("package_name", URLEncoder.encode(A));
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("os_version", Build.VERSION.RELEASE);
                dVar.a("brand", URLEncoder.encode(t.z()));
                dVar.a("model", URLEncoder.encode(t.x()));
                dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, t.E());
                dVar.a("mnc", com.mbridge.msdk.foundation.tools.e.e(context));
                dVar.a("mcc", com.mbridge.msdk.foundation.tools.e.d(context));
                int D = t.D(context);
                dVar.a("network_type", D + "");
                dVar.a("network_str", t.a(context, D));
                dVar.a("language", URLEncoder.encode(t.s(context)));
                dVar.a("timezone", URLEncoder.encode(t.B()));
                dVar.a("ua", URLEncoder.encode(t.A()));
                dVar.a("gp_version", URLEncoder.encode(com.mbridge.msdk.foundation.tools.e.j(context)));
            }
            dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            dVar.a("app_version_name", URLEncoder.encode(t.v(context)));
            dVar.a("orientation", URLEncoder.encode(t.t(context) + ""));
            try {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                    dVar.a("gpsv", GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE + "");
                }
            } catch (Exception unused) {
                x.d(f39725a, "can't find com.google.android.gms.common.GooglePlayServicesUtil class");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            dVar.a("screen_size", t.x(context) + "x" + t.y(context));
            com.mbridge.msdk.foundation.same.net.g.e.c(dVar);
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            if (b4 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac") && b4.Z() == 1) {
                        String b5 = com.mbridge.msdk.foundation.tools.e.b(context);
                        if (b5 != null) {
                            jSONObject.put("imei", b5);
                        }
                        String i4 = com.mbridge.msdk.foundation.tools.e.i(context);
                        if (i4 != null) {
                            jSONObject.put("mac", i4);
                        }
                    }
                    if (b4.G() == 1 && (a4 = com.mbridge.msdk.foundation.tools.e.a(context)) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, a4);
                    }
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id") && b4.aa() == 1 && (g4 = com.mbridge.msdk.foundation.tools.e.g(context)) != null) {
                        jSONObject.put("android_id", g4);
                    }
                    try {
                        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            String H = t.H();
                            if (!TextUtils.isEmpty(H)) {
                                jSONObject.put("manufacturer", H);
                            }
                            String b6 = com.mbridge.msdk.foundation.tools.e.b();
                            if (!TextUtils.isEmpty(b6)) {
                                jSONObject.put("cpu2", b6);
                            }
                            String d4 = com.mbridge.msdk.foundation.tools.e.d();
                            if (!TextUtils.isEmpty(d4)) {
                                jSONObject.put("tags", d4);
                            }
                            String e4 = com.mbridge.msdk.foundation.tools.e.e();
                            if (!TextUtils.isEmpty(e4)) {
                                jSONObject.put("user", e4);
                            }
                            String f4 = com.mbridge.msdk.foundation.tools.e.f();
                            if (!TextUtils.isEmpty(f4)) {
                                jSONObject.put("radio", f4);
                            }
                            String g5 = com.mbridge.msdk.foundation.tools.e.g();
                            if (!TextUtils.isEmpty(g5)) {
                                jSONObject.put("bootloader", g5);
                            }
                            String h4 = com.mbridge.msdk.foundation.tools.e.h();
                            if (!TextUtils.isEmpty(h4)) {
                                jSONObject.put("hardware", h4);
                            }
                            String i5 = com.mbridge.msdk.foundation.tools.e.i();
                            if (!TextUtils.isEmpty(i5)) {
                                jSONObject.put("host", i5);
                            }
                            String j4 = com.mbridge.msdk.foundation.tools.e.j();
                            if (!TextUtils.isEmpty(j4)) {
                                jSONObject.put("codename", j4);
                            }
                            String k4 = com.mbridge.msdk.foundation.tools.e.k();
                            if (!TextUtils.isEmpty(k4)) {
                                jSONObject.put("incremental", k4);
                            }
                            String l4 = com.mbridge.msdk.foundation.tools.e.l();
                            if (!TextUtils.isEmpty(l4)) {
                                jSONObject.put("serial", l4);
                            }
                            String m4 = com.mbridge.msdk.foundation.tools.e.m();
                            if (!TextUtils.isEmpty(m4)) {
                                jSONObject.put("display", m4);
                            }
                            String n4 = com.mbridge.msdk.foundation.tools.e.n();
                            if (!TextUtils.isEmpty(n4)) {
                                jSONObject.put("board", n4);
                            }
                            String o4 = com.mbridge.msdk.foundation.tools.e.o();
                            if (!TextUtils.isEmpty(o4)) {
                                jSONObject.put("type", o4);
                            }
                            String c4 = com.mbridge.msdk.foundation.tools.e.c();
                            if (!TextUtils.isEmpty(c4)) {
                                jSONObject.put("support", c4);
                            }
                            String p3 = com.mbridge.msdk.foundation.tools.e.p();
                            if (!TextUtils.isEmpty(p3)) {
                                jSONObject.put("release", p3);
                            }
                            int q3 = com.mbridge.msdk.foundation.tools.e.q();
                            if (q3 != -1) {
                                jSONObject.put("sdkint", q3);
                            }
                            String l5 = com.mbridge.msdk.foundation.tools.e.l(context);
                            if (!TextUtils.isEmpty(l5)) {
                                jSONObject.put("battery", l5);
                            }
                            int k5 = com.mbridge.msdk.foundation.tools.e.k(context);
                            if (k5 != -1) {
                                jSONObject.put("batterystatus", k5);
                            }
                            int r3 = com.mbridge.msdk.foundation.tools.e.r();
                            if (r3 != -1) {
                                jSONObject.put("baseos", r3);
                            }
                            String E = t.E(context);
                            if (!TextUtils.isEmpty(E)) {
                                jSONObject.put("is24H", E);
                            }
                            int n5 = com.mbridge.msdk.foundation.tools.e.n(context);
                            if (n5 != -1) {
                                jSONObject.put("sensor", n5);
                            }
                            String o5 = com.mbridge.msdk.foundation.tools.e.o(context);
                            if (!TextUtils.isEmpty(o5)) {
                                jSONObject.put("ime", o5);
                            }
                            int m5 = com.mbridge.msdk.foundation.tools.e.m(context);
                            if (m5 != -1) {
                                jSONObject.put("phonetype", m5);
                            }
                            String I = t.I();
                            if (!TextUtils.isEmpty(I)) {
                                jSONObject.put("totalram", I);
                            }
                            String F = t.F(context);
                            if (!TextUtils.isEmpty(F)) {
                                jSONObject.put("totalmemory", F);
                            }
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(jSONObject.toString())) {
                        String a5 = s.a(jSONObject.toString());
                        if (!TextUtils.isEmpty(a5)) {
                            dVar.a("dvi", a5);
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                e7.printStackTrace();
            }
        }
        return dVar;
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.e.4
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    x.d(e.f39725a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    x.d(e.f39725a, str2);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f39725a, e4.getMessage());
        }
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(Context context, n nVar) {
        try {
            com.mbridge.msdk.foundation.same.net.g.d a4 = a(context);
            try {
                a4.a("app_id", com.mbridge.msdk.foundation.controller.a.f().k() + "");
                a4.a("data", URLEncoder.encode(nVar.d()));
                return a4;
            } catch (Exception unused) {
                return a4;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(Context context, String str) {
        com.mbridge.msdk.foundation.same.net.g.d a4 = a(context);
        a4.a("app_id", com.mbridge.msdk.foundation.controller.a.f().k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a4.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        return a4;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, Context context, String str2) {
        com.mbridge.msdk.foundation.same.net.g.d a4 = a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(com.mbridge.msdk.foundation.controller.a.f().k());
        sb.append("");
        a4.a("app_id", sb.toString());
        a4.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str2);
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("&");
                    sb2.append("u_stid");
                    sb2.append("=");
                    sb2.append(str3 != null ? str3 : "");
                    str = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("u_stid=");
                    sb3.append(str3 != null ? str3 : "");
                    str = sb3.toString();
                }
            }
            a4.a("data", URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        a4.a("m_sdk", "msdk");
        return a4;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, Context context) {
        com.mbridge.msdk.foundation.same.net.g.d a4 = a(context);
        a4.a("app_id", com.mbridge.msdk.foundation.controller.a.f().k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a4.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        a4.a("m_sdk", "msdk");
        return a4;
    }

    public static String a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append("&" + entry.getKey() + "=" + entry.getValue());
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(CampaignEx campaignEx, List<com.mbridge.msdk.rover.e> list) {
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        if (campaignEx != null) {
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, campaignEx.getId());
                jSONObject.put(DomainCampaignEx.ROVER_KEY_MARK, campaignEx.getRoverMark());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (list != null && list.size() >= 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (com.mbridge.msdk.rover.e eVar : list) {
                if (eVar != null) {
                    jSONArray2.put(eVar.a());
                }
            }
            jSONObject.put("urls", jSONArray2);
        }
        jSONArray.put(jSONObject);
        dVar.a("data", jSONArray.toString());
        return dVar;
    }

    public static boolean a() {
        try {
            return System.currentTimeMillis() - 86400000 > ((Long) ae.b(com.mbridge.msdk.foundation.controller.a.f().j(), "privateAuthorityTimesTamp", 0L)).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i4, int i5) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000056&");
            if (campaignEx != null) {
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
            }
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            stringBuffer.append("unit_id=" + b4.D() + "&");
            String E = t.E();
            if (!TextUtils.isEmpty(E)) {
                stringBuffer.append("gaid=" + E + "&");
            }
            stringBuffer.append("action_type=" + i4 + "&");
            stringBuffer.append("jm_a=" + com.mbridge.msdk.d.b.a(context).c() + "&");
            stringBuffer.append("jm_n=" + com.mbridge.msdk.d.b.a(context).a() + "&");
            if (campaignEx != null) {
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            }
            stringBuffer.append("result_type=" + i5);
            if (b.a().c()) {
                b.a().a(stringBuffer.toString());
            } else {
                new d(context).b(stringBuffer.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, boolean z3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000047&");
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str3 == null) {
                        str3 = "";
                    }
                    sb.append(str3);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z3 ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    e(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z3, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000104&");
                if (!TextUtils.isEmpty(str2)) {
                    String str7 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("network_type=" + t.D(context) + "&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=" + str3 + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    stringBuffer.append("rid_n=" + str4 + "&");
                }
                if (!TextUtils.isEmpty(str5)) {
                    stringBuffer.append("cid=" + str5 + "&");
                }
                if (!TextUtils.isEmpty(str6)) {
                    stringBuffer.append("template_id=" + str6 + "&");
                }
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z3 ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    e(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z3) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000048&");
            stringBuffer.append("network_type=" + t.D(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            CampaignEx campaignEx = list.get(0);
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            if (z3) {
                stringBuffer.append("hb=");
                stringBuffer.append(1);
                stringBuffer.append("&");
            }
            String requestId = campaignEx.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                stringBuffer.append("rid=");
                stringBuffer.append(requestId);
                stringBuffer.append("&");
            }
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (!TextUtils.isEmpty(requestIdNotice)) {
                stringBuffer.append("rid_n=");
                stringBuffer.append(requestIdNotice);
                stringBuffer.append("&");
            }
            StringBuilder sb = new StringBuilder("rtins_type=");
            for (int i4 = 0; i4 < list.size(); i4++) {
                CampaignEx campaignEx2 = list.get(i4);
                if (i4 < list.size() - 1) {
                    sb.append(campaignEx2.getRtinsType());
                    sb.append(",");
                } else {
                    sb.append(campaignEx2.getRtinsType());
                }
            }
            stringBuffer.append((CharSequence) sb);
            if (b.a().c()) {
                b.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            x.d(f39725a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000054&");
            stringBuffer.append("network_type=" + t.D(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("reason=&");
            stringBuffer.append("result=2&");
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2);
            }
            if (campaignEx.getAdType() == 287) {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=3&");
            } else if (campaignEx.getAdType() == 94) {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=1&");
            } else if (campaignEx.getAdType() == 296) {
                stringBuffer.append("ad_type=5&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else if (campaignEx.getAdType() == 297) {
                stringBuffer.append("ad_type=6&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else if (campaignEx.getAdType() == 298) {
                stringBuffer.append("ad_type=7&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=1&");
            }
            stringBuffer.append("devid=" + t.E() + "&");
            if (campaignEx.isBidCampaign()) {
                stringBuffer.append("hb=1&");
            }
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=");
            stringBuffer.append(campaignEx.getRequestIdNotice());
            stringBuffer.append("&");
            stringBuffer.append("adspace_t=");
            stringBuffer.append(campaignEx.getAdSpaceT());
            if (b.a().c()) {
                b.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, int i4, String str2, String str3, CampaignEx campaignEx) {
        if (campaignEx == null || context == null) {
            return;
        }
        try {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            boolean isBidCampaign = campaignEx.isBidCampaign();
            String requestId = campaignEx.getRequestId();
            String id = campaignEx.getId();
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(campaignUnitId)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000108&");
            if (!TextUtils.isEmpty(campaignUnitId)) {
                String str4 = com.mbridge.msdk.foundation.controller.a.f39078b.get(campaignUnitId);
                StringBuilder sb = new StringBuilder();
                sb.append("u_stid=");
                if (str4 == null) {
                    str4 = "";
                }
                sb.append(str4);
                sb.append("&");
                stringBuffer.append(sb.toString());
            }
            if (!TextUtils.isEmpty(requestId)) {
                stringBuffer.append("rid=" + requestId + "&");
            }
            if (!TextUtils.isEmpty(id)) {
                stringBuffer.append("cid=" + id + "&");
            }
            stringBuffer.append("template_id=" + i4 + "&");
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("ad_type=" + str + "&");
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("process=" + str3 + "&");
            }
            stringBuffer.append("unit_id=" + campaignUnitId + "&");
            stringBuffer.append("hb=");
            stringBuffer.append(isBidCampaign ? 1 : 0);
            stringBuffer.append("&");
            stringBuffer.append("reason=" + str2);
            if (b.a().c()) {
                b.a().a(stringBuffer.toString());
            } else {
                e(context, stringBuffer.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i4, String str3, int i5) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000073&");
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("reason=" + str3 + "&");
                stringBuffer.append("result=" + i4 + "&");
                if (campaignEx != null) {
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                }
                stringBuffer.append("d_t=" + i5 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i4, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000114&");
            stringBuffer.append("network_type=" + t.D(context) + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("gh_id=");
            String str3 = "";
            sb.append(TextUtils.isEmpty(campaignEx.getGhId()) ? "" : URLEncoder.encode(campaignEx.getGhId(), "utf-8"));
            sb.append("&");
            stringBuffer.append(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gh_path=");
            sb2.append(TextUtils.isEmpty(campaignEx.getGhPath()) ? "" : URLEncoder.encode(campaignEx.getGhPath(), "utf-8"));
            sb2.append("&");
            stringBuffer.append(sb2.toString());
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            stringBuffer.append("result=" + i4 + "&");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("reason=");
            if (!TextUtils.isEmpty(str)) {
                str3 = URLEncoder.encode(str, "utf-8");
            }
            sb3.append(str3);
            sb3.append("&");
            stringBuffer.append(sb3.toString());
            stringBuffer.append("cid=" + campaignEx.getId());
            if (b.a().c()) {
                b.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i4, int i5) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000074&");
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("type=" + i4 + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBuffer.append("d_t=" + i5 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i4, int i5, int i6) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000075&");
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("type=" + i4 + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBuffer.append("statue=" + i5 + "&");
                stringBuffer.append("d_t=" + i6 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, int i4, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000076&");
                    stringBuffer.append("network_type=" + t.D(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i4 + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (b.a().c()) {
                        b.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000086&");
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("uniquekey=" + str + "&");
                stringBuffer.append("rid=" + str2 + "&");
                stringBuffer.append("rid_n=" + str4 + "&");
                stringBuffer.append("cid=" + str5 + "&");
                stringBuffer.append("unit_id=" + str6 + "&");
                if (!TextUtils.isEmpty(str6)) {
                    String str7 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("packageName=" + str3);
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i4, String str4, String str5, String str6) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000087&");
                stringBuffer.append("network_type=" + t.D(context) + "&");
                stringBuffer.append("uniquekey=" + str + "&");
                stringBuffer.append("rid=" + str2 + "&");
                stringBuffer.append("rid_n=" + str4 + "&");
                stringBuffer.append("cid=" + str5 + "&");
                stringBuffer.append("unit_id=" + str6 + "&");
                if (!TextUtils.isEmpty(str6)) {
                    String str7 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("packageName=" + str3 + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("result=");
                sb2.append(i4);
                stringBuffer.append(sb2.toString());
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000089&");
                stringBuffer.append("appid=" + com.mbridge.msdk.foundation.controller.a.f().k() + "&");
                stringBuffer.append("s=" + str + "&");
                stringBuffer.append("i=" + str2 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("i_c=");
                sb.append(str3);
                stringBuffer.append(sb.toString());
                if (b.a().c()) {
                    b.a().a(stringBuffer.toString());
                } else {
                    d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(str, context, str2), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.e.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str3) {
                    x.d(e.f39725a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str3) {
                    n nVar = new n();
                    nVar.d(str);
                    nVar.a(System.currentTimeMillis());
                    nVar.a(0);
                    nVar.c("POST");
                    nVar.b(com.mbridge.msdk.foundation.same.net.f.d.a().f39564a);
                    o.a(i.a(context)).a(nVar);
                    x.d(e.f39725a, str3);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f39725a, e4.getMessage());
        }
    }

    public static void a(String str) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
        String str2 = "key=2000088&state=" + str;
        x.d(f39725a, str2);
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null || a.a(b4, str2)) {
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(str2, com.mbridge.msdk.foundation.controller.a.f().j(), ""), null);
        }
    }

    public static void a(int i4, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a("key=2000080&reason=" + str2 + "&ad_type=" + i4 + "&url=" + URLEncoder.encode(str, "utf-8"), com.mbridge.msdk.foundation.controller.a.f().j(), ""), null);
        } catch (Exception e4) {
            x.d(f39725a, e4.getMessage());
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i4, int i5, String str2, int i6, int i7, int i8) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000094", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("video_prg");
            sb.append("=");
            sb.append(i4);
            sb.append("&");
            sb.append("phase");
            sb.append("=");
            sb.append(i5);
            sb.append("&");
            sb.append("feedback_content");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("feedback_close");
            sb.append("=");
            sb.append(i6);
            sb.append("&");
            sb.append("type");
            sb.append("=");
            sb.append(i8);
            sb.append("&");
            sb.append("ad_type");
            sb.append("=");
            sb.append(i7);
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(t.D(com.mbridge.msdk.foundation.controller.a.f().j())), "utf-8"));
            if (i6 == 1) {
                sb.append("&");
                sb.append("campaign");
                sb.append("=");
                sb.append(URLEncoder.encode(CampaignEx.campaignToJsonObject(campaignEx).toString(), "utf-8"));
            }
            if (MBridgeConstans.DEBUG && i6 == 1) {
                String str3 = f39725a;
                x.d(str3, "2000094:" + ((Object) sb));
            }
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a(sb.toString(), com.mbridge.msdk.foundation.controller.a.f().j(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.e.5
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str4) {
                    x.a("", "FLBClick REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str4) {
                    x.a("", "FLBClick REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }
}
