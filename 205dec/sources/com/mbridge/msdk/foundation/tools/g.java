package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.File;

/* compiled from: DomainSameSDKTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39836a;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[Catch: all -> 0x026a, TRY_ENTER, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001d, B:10:0x0023, B:11:0x0027, B:14:0x0047, B:17:0x0054, B:36:0x0120, B:38:0x0124, B:42:0x013c, B:46:0x0144, B:48:0x014e, B:49:0x0153, B:68:0x0266, B:41:0x0134, B:19:0x0064, B:22:0x0091, B:27:0x00c9, B:30:0x00f4, B:33:0x0103, B:34:0x010f, B:51:0x0158, B:53:0x0171, B:55:0x0178, B:57:0x017f, B:58:0x0184, B:60:0x01e7, B:61:0x01f8), top: B:75:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r18, final java.lang.String r19, final com.mbridge.msdk.foundation.entity.CampaignEx r20, final boolean r21) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.g.a(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, boolean):void");
    }

    private static void a(final CampaignEx campaignEx, final String str, final boolean z3) {
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
            a(str, 2, campaignEx);
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (!ah.b(j4)) {
                com.mbridge.msdk.click.c.a(j4, str, str2);
                return;
            }
            Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j5, str2 + "isDowning", Long.valueOf(System.currentTimeMillis()));
            Context j6 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j6, str2 + "process", Integer.valueOf(Process.myPid()));
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    g.a(com.mbridge.msdk.foundation.controller.a.f().j(), CampaignEx.this, str, z3);
                }
            }).start();
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public static void a(final Context context, final CampaignEx campaignEx, final String str, final boolean z3) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        try {
            final String str2 = md5;
            com.mbridge.msdk.optimize.a.a(f.a("/apk", context, new boolean[1]), com.mbridge.msdk.click.c.a(str), str, new com.mbridge.msdk.optimize.b() { // from class: com.mbridge.msdk.foundation.tools.g.3
                @Override // com.mbridge.msdk.optimize.b
                public final void a() {
                    if (z3) {
                        com.mbridge.msdk.click.b.a(campaignEx, context, CampaignEx.JSON_NATIVE_VIDEO_START);
                    } else {
                        com.mbridge.msdk.click.b.a(campaignEx, context, "shortcuts_start");
                    }
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void a(int i4) {
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void b() {
                    com.mbridge.msdk.click.c.a(context, str, str2);
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void a(File file) {
                    Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                    ae.a(j4, str2 + "isDowning", 0L);
                    Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                    ae.a(j5, str2 + "process", 0);
                    com.mbridge.msdk.click.b.a(campaignEx, context, "end");
                    com.mbridge.msdk.foundation.db.g.b(com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(campaignEx);
                    if (file.exists() && z3) {
                        com.mbridge.msdk.click.c.a(context, Uri.fromFile(file), str, str2);
                        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, file.getAbsolutePath());
                    } else if (z3) {
                    } else {
                        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, file.getAbsolutePath());
                    }
                }
            });
        } catch (Throwable unused) {
            com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.a.f().j(), str, md5);
        }
    }

    public static void a(String str, int i4, CampaignEx campaignEx) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = TextUtils.isEmpty("") ? SameMD5.getMD5(str) : "";
        }
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        ae.a(j4, md5 + "downloadType", Integer.valueOf(i4));
        if (campaignEx != null) {
            Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j5, md5 + "linkType", Integer.valueOf(campaignEx.getLinkType()));
            String requestId = campaignEx.getRequestId();
            Context j6 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j6, md5 + "rid", TextUtils.isEmpty(requestId) ? "" : requestId);
            Context j7 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j7, md5 + "rid_n", campaignEx.getRequestIdNotice());
            Context j8 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j8, md5 + BidResponsedEx.KEY_CID, campaignEx.getId());
            return;
        }
        Context j9 = com.mbridge.msdk.foundation.controller.a.f().j();
        ae.a(j9, md5 + "linkType", -1);
        Context j10 = com.mbridge.msdk.foundation.controller.a.f().j();
        ae.a(j10, md5 + "rid", "");
        Context j11 = com.mbridge.msdk.foundation.controller.a.f().j();
        ae.a(j11, md5 + "rid_n", "");
        Context j12 = com.mbridge.msdk.foundation.controller.a.f().j();
        ae.a(j12, md5 + BidResponsedEx.KEY_CID, "");
    }
}
