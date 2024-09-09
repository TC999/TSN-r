package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.stub.StubApp;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: ReportController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39699a = "d";

    /* renamed from: b  reason: collision with root package name */
    private Context f39700b;

    /* renamed from: c  reason: collision with root package name */
    private int f39701c;

    public d(Context context, int i4) {
        this.f39700b = context;
        this.f39701c = i4;
    }

    private void c(String str) {
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(str, this.f39700b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.15
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    String str3 = d.f39699a;
                    x.b(str3, "reportPB success data:" + str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    String str3 = d.f39699a;
                    x.b(str3, "reportPB onFailed msg:" + str2);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(String str) {
        c(str);
    }

    private String b() {
        StringBuffer stringBuffer = new StringBuffer("?");
        stringBuffer.append("platform=");
        stringBuffer.append(URLEncoder.encode("1"));
        stringBuffer.append("&");
        stringBuffer.append("os_version=");
        stringBuffer.append(URLEncoder.encode(Build.VERSION.RELEASE));
        stringBuffer.append("&");
        stringBuffer.append("package_name=");
        stringBuffer.append(URLEncoder.encode(t.A(this.f39700b)));
        stringBuffer.append("&");
        stringBuffer.append("app_version_name=");
        stringBuffer.append(URLEncoder.encode(t.v(this.f39700b)));
        stringBuffer.append("&");
        stringBuffer.append("app_version_code=");
        stringBuffer.append(URLEncoder.encode(t.u(this.f39700b) + ""));
        stringBuffer.append("&");
        stringBuffer.append("screen_size=");
        stringBuffer.append(URLEncoder.encode(t.x(this.f39700b) + "x" + t.y(this.f39700b)));
        stringBuffer.append("&");
        stringBuffer.append("orientation=");
        stringBuffer.append(URLEncoder.encode(t.t(this.f39700b) + ""));
        stringBuffer.append("&");
        stringBuffer.append("gaid=");
        stringBuffer.append(URLEncoder.encode(t.E()));
        stringBuffer.append("&");
        String encode = URLEncoder.encode(t.z());
        stringBuffer.append("brand=");
        stringBuffer.append(encode);
        stringBuffer.append("&");
        stringBuffer.append("mnc=");
        stringBuffer.append(URLEncoder.encode(com.mbridge.msdk.foundation.tools.e.e(this.f39700b)));
        stringBuffer.append("&");
        stringBuffer.append("mcc=");
        stringBuffer.append(URLEncoder.encode(com.mbridge.msdk.foundation.tools.e.d(this.f39700b)));
        stringBuffer.append("&");
        int D = t.D(this.f39700b);
        stringBuffer.append("network_type=");
        stringBuffer.append(URLEncoder.encode(D + ""));
        stringBuffer.append("&");
        stringBuffer.append("network_str");
        stringBuffer.append(URLEncoder.encode(t.a(this.f39700b, D)));
        stringBuffer.append("&");
        stringBuffer.append("language=");
        stringBuffer.append(URLEncoder.encode(t.s(this.f39700b)));
        stringBuffer.append("&");
        stringBuffer.append("timezone=");
        stringBuffer.append(URLEncoder.encode(t.B()));
        stringBuffer.append("&");
        String encode2 = URLEncoder.encode(t.A());
        stringBuffer.append("useragent=");
        stringBuffer.append(encode2);
        stringBuffer.append("&");
        stringBuffer.append("sdk_version=");
        stringBuffer.append(URLEncoder.encode(MBConfiguration.SDK_VERSION));
        stringBuffer.append("&");
        String encode3 = URLEncoder.encode(com.mbridge.msdk.foundation.tools.e.j(this.f39700b));
        stringBuffer.append("gp_version=");
        stringBuffer.append(encode3);
        stringBuffer.append("&");
        stringBuffer.append("sign=");
        stringBuffer.append(URLEncoder.encode(SameMD5.getMD5(com.mbridge.msdk.foundation.controller.a.f().k() + com.mbridge.msdk.foundation.controller.a.f().l())));
        stringBuffer.append("&");
        stringBuffer.append("app_id=");
        stringBuffer.append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.a.f().k()));
        stringBuffer.append("&");
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (b4.Z() == 1) {
                    if (com.mbridge.msdk.foundation.tools.e.b(this.f39700b) != null) {
                        jSONObject.put("imei", com.mbridge.msdk.foundation.tools.e.b(this.f39700b));
                    }
                    if (com.mbridge.msdk.foundation.tools.e.i(this.f39700b) != null) {
                        jSONObject.put("mac", com.mbridge.msdk.foundation.tools.e.i(this.f39700b));
                    }
                }
                if (b4.aa() == 1 && com.mbridge.msdk.foundation.tools.e.g(this.f39700b) != null) {
                    jSONObject.put("android_id", com.mbridge.msdk.foundation.tools.e.g(this.f39700b));
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String a4 = s.a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a4)) {
                        stringBuffer.append("dvi=");
                        stringBuffer.append(a4);
                        stringBuffer.append("&");
                    } else {
                        stringBuffer.append("dvi=");
                        stringBuffer.append("");
                        stringBuffer.append("&");
                    }
                } else {
                    stringBuffer.append("dvi=");
                    stringBuffer.append("");
                    stringBuffer.append("&");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            stringBuffer.append("dvi=");
            stringBuffer.append("");
            stringBuffer.append("&");
        }
        stringBuffer.append("unit_id=");
        stringBuffer.append(0);
        return stringBuffer.toString();
    }

    public final void a(int i4, String str) {
        new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a("event", e.a((Campaign) null, i4, "request"), this.f39700b, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.1
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void a(String str2) {
                x.b(d.f39699a, "report success");
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void b(String str2) {
            }
        });
    }

    public d(Context context) {
        this.f39701c = 0;
        this.f39700b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final void a(final n nVar, final Boolean bool) {
        if (nVar != null) {
            if (nVar.c().equals("GET")) {
                new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b).a(0, nVar.b(), (com.mbridge.msdk.foundation.same.net.g.d) null, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.12
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void a(String str) {
                        x.b(d.f39699a, "report success");
                        o.a(i.a(d.this.f39700b)).a(nVar.b());
                        if (!bool.booleanValue() || o.a(i.a(d.this.f39700b)).b() <= 20) {
                            return;
                        }
                        com.mbridge.msdk.foundation.controller.b.a().c();
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void b(String str) {
                    }
                });
            } else if (nVar.c().equals("POST")) {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
                if (TextUtils.isEmpty(nVar.d())) {
                    return;
                }
                com.mbridge.msdk.foundation.same.net.g.d a4 = e.a(nVar.d(), this.f39700b, nVar.a());
                if (nVar.f() > 0) {
                    a4.a(AdLogEventRepo.COL_RETRY_COUNT, nVar.f() + "");
                }
                aVar.c(0, nVar.b(), a4, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.13
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void a(String str) {
                        x.b(d.f39699a, "report success");
                        o.a(i.a(d.this.f39700b)).a(nVar.d(), nVar.b(), nVar.g());
                        if (!bool.booleanValue() || o.a(i.a(d.this.f39700b)).a() <= 0) {
                            return;
                        }
                        com.mbridge.msdk.foundation.controller.b.a().c();
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void b(String str) {
                        o.a(i.a(d.this.f39700b)).a(nVar);
                    }
                });
            }
        }
    }

    public final void a(final n nVar) {
        new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(this.f39700b, nVar), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.14
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void a(String str) {
                x.b(d.f39699a, "report success");
                try {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        int e4 = nVar2.e();
                        q a4 = q.a(i.a(d.this.f39700b));
                        a4.a(e4 + "");
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void b(String str) {
            }
        });
    }

    public final void a(String str) {
        c(str);
    }

    public final void a(String str, String str2, String str3, String str4) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            String str5 = "click_type=" + URLEncoder.encode(str, "utf-8") + "&" + BidResponsedEx.KEY_CID + "=" + URLEncoder.encode(str2, "utf-8") + "&" + MBridgeConstans.PROPERTIES_UNIT_ID + "=" + URLEncoder.encode(str3, "utf-8") + "&" + DomainCampaignEx.LOOPBACK_KEY + "=" + URLEncoder.encode("2000027", "utf-8") + "&http_url=" + URLEncoder.encode(str4, "utf-8");
            if (b.a().c()) {
                b.a().a(str5);
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(str5, this.f39700b, str3), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str6) {
                    x.a("", "SSL REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str6) {
                    x.a("", "SSL REPORT FAILED");
                }
            });
        } catch (Exception unused) {
            x.d(f39699a, "ssl  error report failed");
        }
    }

    public final void a(String str, final File file) {
        new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(this.f39700b, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.3
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void a(String str2) {
                x.b(d.f39699a, "report success exception");
                File file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void b(String str2) {
                x.b(d.f39699a, "report failed exception");
            }
        });
    }

    public final void a(final String str, String str2, String str3, Frame frame) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
        com.mbridge.msdk.foundation.same.net.g.d a4 = e.a(str2, this.f39700b, str3);
        if (frame != null) {
            a4.a("session_id", frame.getSessionId());
            a4.a("parent_session_id", frame.getParentSessionId());
        }
        aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a4, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.4
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void a(String str4) {
                x.b(d.f39699a, "report success");
                if ("net_time_stats".equals(str)) {
                    return;
                }
                if ("click_duration".equals(str)) {
                    com.mbridge.msdk.foundation.controller.b.a().c();
                } else if ("load_duration".equals(str)) {
                    com.mbridge.msdk.foundation.controller.b.a().c();
                    com.mbridge.msdk.foundation.controller.b.a().c();
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void b(String str4) {
                x.b(d.f39699a, "report success");
            }
        });
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.e eVar, String str2) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
        String a4 = com.mbridge.msdk.foundation.entity.e.a(eVar);
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        if (b.a().c()) {
            b.a().a(a4);
            return;
        }
        aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(a4, this.f39700b, str2), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.5
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void a(String str3) {
                x.b(d.f39699a, "report success");
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void b(String str3) {
            }
        });
    }

    public final void a(CampaignEx campaignEx, List<com.mbridge.msdk.rover.e> list, com.mbridge.msdk.rover.f fVar) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
        String b4 = b();
        com.mbridge.msdk.foundation.same.net.g.d a4 = e.a(campaignEx, list);
        aVar.c(1, com.mbridge.msdk.foundation.same.net.f.d.a().A + b4, a4, fVar);
    }

    public final void a(int i4, int i5, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append("2000112");
            sb.append("&");
            sb.append("st_net");
            sb.append("=");
            sb.append(i5);
            sb.append("&");
            sb.append("result");
            sb.append("=");
            sb.append(i4);
            sb.append("&");
            sb.append("url");
            sb.append("=");
            sb.append(str2);
            sb.append("&");
            sb.append("reason");
            sb.append("=");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), this.f39700b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.6
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str3) {
                    x.a("", "reportSettingLoadFailed onSuccess");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str3) {
                    x.a("", "reportSettingLoadFailed onFailed:" + str3);
                }
            });
        } catch (Throwable unused) {
            x.d(f39699a, "reportSettingLoadFailed onFailed");
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            StringBuilder sb = new StringBuilder();
            if (z3) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000065", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append(CampaignEx.JSON_KEY_CLICK_URL);
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), this.f39700b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.10
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str6) {
                    x.a("", "MraidClic REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str6) {
                    x.a("", "MraidClic REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public final void a() {
        try {
            if (e.a()) {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
                String k4 = com.mbridge.msdk.foundation.controller.a.f().k();
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(k4);
                if (b4 == null) {
                    b4 = com.mbridge.msdk.c.b.a().b();
                }
                int J = b4.J();
                String str = "key=2000053&Appid=" + k4 + "&uptips2=" + b4.I() + "&info_status=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().d() + "&iseu=" + J;
                String E = t.E();
                if (!TextUtils.isEmpty(E)) {
                    str = str + "&" + AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY + "=" + E;
                }
                String str2 = str + "&GDPR_area=" + b4.aT() + "&GDPR_consent=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().f();
                x.a(f39699a, "reportPrivateAuthorityStatus  data:" + str2);
                if (b.a().c()) {
                    b.a().a(str2);
                    return;
                }
                aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(str2, this.f39700b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.7
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void a(String str3) {
                        x.a("", "PrivateAuthorityStatus onSuccess ");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void b(String str3) {
                        x.a("", "PrivateAuthorityStatus onFailed:" + str3);
                    }
                });
                e.b();
            }
        } catch (Throwable unused) {
            x.d(f39699a, "PrivateAuthorityStatus onFailed");
        }
    }

    public final void a(int i4, int i5, String str, String str2, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000058", "utf-8"));
            sb.append("&");
            sb.append("appid");
            sb.append("=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.a.f().k(), "utf-8"));
            sb.append("&");
            sb.append("dl_service");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39771c + "", "utf-8"));
            sb.append("&");
            sb.append("dl_service_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39772d + "", "utf-8"));
            sb.append("&");
            sb.append("dl_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i4 + "", "utf-8"));
            sb.append("&");
            sb.append("dl_link_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i5 + "", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append("dl_v4");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39777i + "", "utf-8"));
            sb.append("&");
            sb.append("dl_v4_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39778j + "", "utf-8"));
            sb.append("&");
            sb.append("dl_pkg");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39769a + "", "utf-8"));
            sb.append("&");
            sb.append("dl_pkg_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39770b + "", "utf-8"));
            sb.append("&");
            sb.append("dl_i_p");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39773e + "", "utf-8"));
            sb.append("&");
            sb.append("dl_i_p_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39775g + "", "utf-8"));
            sb.append("&");
            sb.append("dl_fp");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39774f + "", "utf-8"));
            sb.append("&");
            sb.append("dl_fp_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(ah.f39776h + "", "utf-8"));
            sb.append("&");
            sb.append("tgt_v");
            sb.append("=");
            sb.append(URLEncoder.encode(t.w(this.f39700b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_n");
            sb.append("=");
            sb.append(URLEncoder.encode(t.v(this.f39700b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_c");
            sb.append("=");
            sb.append(URLEncoder.encode(t.u(this.f39700b) + "", "utf-8"));
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), this.f39700b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.8
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str4) {
                    x.a("", "reportDownloadMethod REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str4) {
                    x.a("", "reportDownloadMethod REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z3) {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            StringBuilder sb = new StringBuilder();
            if (z3) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000066", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append("err_method");
            sb.append("=");
            sb.append(str5);
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), this.f39700b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.9
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str6) {
                    x.a("", "MraidUnSupportMethod REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str6) {
                    x.a("", "MraidUnSupportMethod REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f39700b);
            StringBuilder sb = new StringBuilder();
            int D = t.D(this.f39700b);
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000071", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append("reason");
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(D + "", "utf-8"));
            sb.append("&");
            sb.append("result");
            sb.append("=");
            sb.append(URLEncoder.encode("0", "utf-8"));
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), this.f39700b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.d.11
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str6) {
                    x.a("", "OMSDK REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str6) {
                    x.a("", "OMSDK REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }
}
