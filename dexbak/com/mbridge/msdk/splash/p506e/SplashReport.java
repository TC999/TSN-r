package com.mbridge.msdk.splash.p506e;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.PlayableReportUtils;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.splash.p501a.C11567b;
import com.umeng.analytics.pro.UMCommonContent;
import java.net.URLEncoder;

/* renamed from: com.mbridge.msdk.splash.e.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashReport {
    /* renamed from: a */
    public static void m21062a(CampaignEx campaignEx, String str, String str2) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str2) || !campaignEx.isMraid()) {
                    return;
                }
                new ReportController(MBSDKContext.m22865f().m22861j()).m22089b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, str2, campaignEx.isBidCampaign());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m21056b(CampaignEx campaignEx, String str, String str2) {
        m21063a(campaignEx, str, 2, str2);
    }

    /* renamed from: b */
    public static void m21057b(CampaignEx campaignEx, String str) {
        try {
            ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
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
            sb.append(UMCommonContent.f37763T);
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j())), "utf-8"));
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), MBSDKContext.m22865f().m22861j(), str), new ReportResponseHandler() { // from class: com.mbridge.msdk.splash.e.a.2
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    SameLogTool.m21738a("", "FLBClick REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    SameLogTool.m21738a("", "FLBClick REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21065a(Context context, CampaignEx campaignEx, String str, String str2, long j, int i) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isMraid()) {
                    VideoReportData videoReportData = new VideoReportData();
                    videoReportData.m22410k(campaignEx.getRequestId());
                    videoReportData.m22408l(campaignEx.getRequestIdNotice());
                    videoReportData.m22404n(campaignEx.getId());
                    videoReportData.m22433d(i);
                    videoReportData.m22398q(String.valueOf(System.currentTimeMillis() - j));
                    videoReportData.m22423f("");
                    videoReportData.m22400p(str2);
                    videoReportData.m22416h("6");
                    videoReportData.m22448a(VideoReportData.f30525a);
                    PlayableReportUtils.m22110b(videoReportData, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21059a(String str, CampaignEx campaignEx) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        VideoReportData videoReportData = new VideoReportData("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, SameDiTool.m21804D(MBSDKContext.m22865f().m22861j()));
        videoReportData.m22448a(VideoReportData.f30525a);
        PlayableReportUtils.m22111b(videoReportData, MBSDKContext.m22865f().m22861j(), str);
    }

    /* renamed from: a */
    public static void m21058a(String str, CampaignEx campaignEx, String str2) {
        try {
            ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
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
            sb.append(UMCommonContent.f37763T);
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j())), "utf-8"));
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), MBSDKContext.m22865f().m22861j(), str), new ReportResponseHandler() { // from class: com.mbridge.msdk.splash.e.a.1
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str3) {
                    SameLogTool.m21738a("", "Mraid Expand REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str3) {
                    SameLogTool.m21738a("", "Mraid Expand REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21064a(CampaignEx campaignEx, String str) {
        m21063a(campaignEx, "", 1, str);
    }

    /* renamed from: a */
    private static void m21063a(CampaignEx campaignEx, String str, int i, String str2) {
        m21061a(C11567b.m21293a().m21286c(campaignEx.getId()).m21287b(str2).m21285d(campaignEx.getRequestId()).m21282g(campaignEx.getRequestIdNotice()).m21283f(str).m21288b(i).m21290a(campaignEx.isBidCampaign()), str2);
    }

    /* renamed from: a */
    private static void m21061a(C11567b c11567b, String str) {
        if (c11567b != null) {
            c11567b.m21291a("2000068");
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(c11567b.m21289b());
            } else {
                PlayableReportUtils.m22112a(c11567b.m21289b(), MBSDKContext.m22865f().m22861j(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m21060a(C11567b c11567b, String str, int i) {
        if (c11567b != null) {
            c11567b.m21291a("2000069");
            c11567b.m21292a(i);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(c11567b.m21289b());
            } else {
                PlayableReportUtils.m22112a(c11567b.m21289b(), MBSDKContext.m22865f().m22861j(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m21066a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().m22503h() == null) {
            return;
        }
        CommonClickControl.m23126a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m22503h(), false, false);
    }
}
