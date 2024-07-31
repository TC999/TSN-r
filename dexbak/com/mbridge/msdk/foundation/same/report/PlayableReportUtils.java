package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.same.p479f.ReportTask;
import com.mbridge.msdk.foundation.tools.SameDiTool;

/* renamed from: com.mbridge.msdk.foundation.same.report.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class PlayableReportUtils {

    /* renamed from: a */
    private static Handler f30923a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m22116a(CampaignEx campaignEx, String str, String str2, String str3) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        VideoReportData videoReportData = new VideoReportData("2000043", TextUtils.isEmpty(campaignEx.getMraid()) ^ true ? 1 : 3, "0", "", campaignEx.getId(), str2, str, String.valueOf(campaignEx.getKeyIaRst()));
        videoReportData.m22404n(campaignEx.getId());
        videoReportData.m22410k(campaignEx.getRequestId());
        videoReportData.m22408l(campaignEx.getRequestIdNotice());
        videoReportData.m22443b(campaignEx.getAdSpaceT());
        videoReportData.m22416h(str3);
        videoReportData.m22438c(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j()));
        videoReportData.m22448a(campaignEx.isMraid() ? VideoReportData.f30525a : VideoReportData.f30526b);
        m22114a(videoReportData, str2);
    }

    /* renamed from: b */
    public static void m22110b(VideoReportData videoReportData, String str) {
        if (videoReportData != null) {
            videoReportData.m22402o("2000059");
            videoReportData.m22406m(str);
            videoReportData.m22438c(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j()));
            videoReportData.m22441b(SameDiTool.m21803E());
            String m22437c = VideoReportData.m22437c(videoReportData);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(m22437c);
            } else {
                m22112a(m22437c, MBSDKContext.m22865f().m22861j(), str);
            }
        }
    }

    /* renamed from: c */
    public static void m22109c(VideoReportData videoReportData, Context context, String str) {
        String m22417h = VideoReportData.m22417h(videoReportData);
        if (MBBatchReportManager.m22142a().m22135c()) {
            MBBatchReportManager.m22142a().m22139a(m22417h);
        } else {
            m22112a(m22417h, context, str);
        }
    }

    /* renamed from: d */
    public static void m22108d(VideoReportData videoReportData, Context context, String str) {
        if (videoReportData != null) {
            videoReportData.m22402o("2000063");
            videoReportData.m22406m(str);
            videoReportData.m22438c(SameDiTool.m21804D(context));
            String m22447a = VideoReportData.m22447a(videoReportData);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(m22447a);
            } else {
                m22112a(m22447a, context, str);
            }
        }
    }

    /* renamed from: b */
    public static void m22111b(VideoReportData videoReportData, Context context, String str) {
        String m22420g = VideoReportData.m22420g(videoReportData);
        if (MBBatchReportManager.m22142a().m22135c()) {
            MBBatchReportManager.m22142a().m22139a(m22420g);
        } else {
            m22112a(m22420g, context, str);
        }
    }

    /* renamed from: a */
    public static void m22114a(VideoReportData videoReportData, String str) {
        if (videoReportData != null) {
            videoReportData.m22441b(SameDiTool.m21803E());
            String m22432d = VideoReportData.m22432d(videoReportData);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(m22432d);
            } else {
                m22112a(m22432d, MBSDKContext.m22865f().m22861j(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m22115a(VideoReportData videoReportData, Context context, String str) {
        if (videoReportData != null) {
            videoReportData.m22402o("2000060");
            videoReportData.m22406m(str);
            videoReportData.m22438c(SameDiTool.m21804D(context));
            String m22442b = VideoReportData.m22442b(videoReportData);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(m22442b);
            } else {
                m22112a(m22442b, context, str);
            }
        }
    }

    /* renamed from: a */
    public static void m22112a(String str, Context context, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        m22113a(new ReportTask(str, str2));
    }

    /* renamed from: a */
    private static void m22113a(Runnable runnable) {
        Handler handler = f30923a;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
