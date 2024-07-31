package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignReportDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.optimize.SimpleDownload;
import com.mbridge.msdk.optimize.SimpleDownloadCallback;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;

/* renamed from: com.mbridge.msdk.foundation.tools.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainSameSDKTool {

    /* renamed from: a */
    public static boolean f31063a;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[Catch: all -> 0x026a, TRY_ENTER, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m21875a(java.lang.String r18, final java.lang.String r19, final com.mbridge.msdk.foundation.entity.CampaignEx r20, final boolean r21) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.DomainSameSDKTool.m21875a(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, boolean):void");
    }

    /* renamed from: a */
    private static void m21877a(final CampaignEx campaignEx, final String str, final boolean z) {
        String str2;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getAkdlui())) {
            str2 = str;
        } else {
            str2 = campaignEx.getAkdlui();
            if (TextUtils.isEmpty(str2)) {
                str2 = SameMD5.getMD5(str);
            }
        }
        try {
            m21876a(str, 2, campaignEx);
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (!TargetAdaptionUtils.m21954b(m22861j)) {
                CommonClickUtil.m23075a(m22861j, str, str2);
                return;
            }
            Context m22861j2 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j2, str2 + "isDowning", Long.valueOf(System.currentTimeMillis()));
            Context m22861j3 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j3, str2 + UMModuleRegister.PROCESS, Integer.valueOf(Process.myPid()));
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    DomainSameSDKTool.m21878a(MBSDKContext.m22865f().m22861j(), CampaignEx.this, str, z);
                }
            }).start();
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21878a(final Context context, final CampaignEx campaignEx, final String str, final boolean z) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        try {
            final String str2 = md5;
            SimpleDownload.m21369a(DomainSameFileTool.m21879a("/apk", context, new boolean[1]), CommonClickUtil.m23072a(str), str, new SimpleDownloadCallback() { // from class: com.mbridge.msdk.foundation.tools.g.3
                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21334a() {
                    if (z) {
                        CommonClickControl.m23113a(campaignEx, context, CampaignEx.JSON_NATIVE_VIDEO_START);
                    } else {
                        CommonClickControl.m23113a(campaignEx, context, "shortcuts_start");
                    }
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21333a(int i) {
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: b */
                public final void mo21331b() {
                    CommonClickUtil.m23075a(context, str, str2);
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21332a(File file) {
                    Context m22861j = MBSDKContext.m22865f().m22861j();
                    C11400ae.m21963a(m22861j, str2 + "isDowning", 0L);
                    Context m22861j2 = MBSDKContext.m22865f().m22861j();
                    C11400ae.m21963a(m22861j2, str2 + UMModuleRegister.PROCESS, 0);
                    CommonClickControl.m23113a(campaignEx, context, "end");
                    CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22727a(campaignEx);
                    if (file.exists() && z) {
                        CommonClickUtil.m23077a(context, Uri.fromFile(file), str, str2);
                        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, file.getAbsolutePath());
                    } else if (z) {
                    } else {
                        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, file.getAbsolutePath());
                    }
                }
            });
        } catch (Throwable unused) {
            CommonClickUtil.m23075a(MBSDKContext.m22865f().m22861j(), str, md5);
        }
    }

    /* renamed from: a */
    public static void m21876a(String str, int i, CampaignEx campaignEx) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = TextUtils.isEmpty("") ? SameMD5.getMD5(str) : "";
        }
        Context m22861j = MBSDKContext.m22865f().m22861j();
        C11400ae.m21963a(m22861j, md5 + "downloadType", Integer.valueOf(i));
        if (campaignEx != null) {
            Context m22861j2 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j2, md5 + "linkType", Integer.valueOf(campaignEx.getLinkType()));
            String requestId = campaignEx.getRequestId();
            Context m22861j3 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j3, md5 + "rid", TextUtils.isEmpty(requestId) ? "" : requestId);
            Context m22861j4 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j4, md5 + "rid_n", campaignEx.getRequestIdNotice());
            Context m22861j5 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j5, md5 + BidResponsedEx.KEY_CID, campaignEx.getId());
            return;
        }
        Context m22861j6 = MBSDKContext.m22865f().m22861j();
        C11400ae.m21963a(m22861j6, md5 + "linkType", -1);
        Context m22861j7 = MBSDKContext.m22865f().m22861j();
        C11400ae.m21963a(m22861j7, md5 + "rid", "");
        Context m22861j8 = MBSDKContext.m22865f().m22861j();
        C11400ae.m21963a(m22861j8, md5 + "rid_n", "");
        Context m22861j9 = MBSDKContext.m22865f().m22861j();
        C11400ae.m21963a(m22861j9, md5 + BidResponsedEx.KEY_CID, "");
    }
}
