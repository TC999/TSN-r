package com.mbridge.msdk.splash.e;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.p;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;

/* compiled from: SplashReport.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {
    public static void a(CampaignEx campaignEx, String str, String str2) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str2) || !campaignEx.isMraid()) {
                    return;
                }
                new d(com.mbridge.msdk.foundation.controller.a.f().j()).b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, str2, campaignEx.isBidCampaign());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void b(CampaignEx campaignEx, String str, String str2) {
        a(campaignEx, str, 2, str2);
    }

    public static void b(CampaignEx campaignEx, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000092", "utf-8"));
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
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(t.D(com.mbridge.msdk.foundation.controller.a.f().j())), "utf-8"));
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.f().j(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.splash.e.a.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    x.a("", "FLBClick REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    x.a("", "FLBClick REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, long j4, int i4) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isMraid()) {
                    p pVar = new p();
                    pVar.k(campaignEx.getRequestId());
                    pVar.l(campaignEx.getRequestIdNotice());
                    pVar.n(campaignEx.getId());
                    pVar.d(i4);
                    pVar.q(String.valueOf(System.currentTimeMillis() - j4));
                    pVar.f("");
                    pVar.p(str2);
                    pVar.h("6");
                    pVar.a(p.f39346a);
                    c.b(pVar, str);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        p pVar = new p("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, t.D(com.mbridge.msdk.foundation.controller.a.f().j()));
        pVar.a(p.f39346a);
        c.b(pVar, com.mbridge.msdk.foundation.controller.a.f().j(), str);
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
            StringBuilder sb = new StringBuilder();
            if (campaignEx.isBidCampaign()) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000070", "utf-8"));
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
            sb.append(CampaignEx.JSON_KEY_CLICK_URL);
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(t.D(com.mbridge.msdk.foundation.controller.a.f().j())), "utf-8"));
            if (b.a().c()) {
                b.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, e.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.f().j(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.splash.e.a.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str3) {
                    x.a("", "Mraid Expand REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str3) {
                    x.a("", "Mraid Expand REPORT FAILED");
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        a(campaignEx, "", 1, str);
    }

    private static void a(CampaignEx campaignEx, String str, int i4, String str2) {
        a(com.mbridge.msdk.splash.a.b.a().c(campaignEx.getId()).b(str2).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i4).a(campaignEx.isBidCampaign()), str2);
    }

    private static void a(com.mbridge.msdk.splash.a.b bVar, String str) {
        if (bVar != null) {
            bVar.a("2000068");
            if (b.a().c()) {
                b.a().a(bVar.b());
            } else {
                c.a(bVar.b(), com.mbridge.msdk.foundation.controller.a.f().j(), str);
            }
        }
    }

    public static void a(com.mbridge.msdk.splash.a.b bVar, String str, int i4) {
        if (bVar != null) {
            bVar.a("2000069");
            bVar.a(i4);
            if (b.a().c()) {
                b.a().a(bVar.b());
            } else {
                c.a(bVar.b(), com.mbridge.msdk.foundation.controller.a.f().j(), str);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().h() == null) {
            return;
        }
        com.mbridge.msdk.click.b.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().h(), false, false);
    }
}
