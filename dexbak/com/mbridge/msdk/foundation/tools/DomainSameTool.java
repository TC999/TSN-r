package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.Frequence;
import com.mbridge.msdk.foundation.entity.InstallApp;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.p472db.SCDao;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.tools.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainSameTool {
    /* renamed from: a */
    public static void m21872a(Context context, CampaignEx campaignEx) {
        SameLogTool.m21736b("DomainSameTool", "updateInstallList 开始 更新本机已安装广告列表");
        if (context == null) {
            SameLogTool.m21736b("DomainSameTool", "updateInstallList 列表为空 不做更新本机已安装广告列表");
            return;
        }
        FrequenceDao m22703a = FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(context));
        boolean z = false;
        if (campaignEx != null) {
            if (SameTool.m21992c(context, campaignEx.getPackageName())) {
                if (MBSDKContext.m22867e() != null) {
                    MBSDKContext.m22867e().add(new InstallApp(campaignEx.getId(), campaignEx.getPackageName()));
                }
                z = true;
            } else if (m22703a != null && !m22703a.m22701a(campaignEx.getId())) {
                Frequence frequence = new Frequence();
                frequence.m22551a(campaignEx.getId());
                frequence.m22553a(campaignEx.getFca());
                frequence.m22549b(campaignEx.getFcb());
                frequence.m22545d(0);
                frequence.m22547c(0);
                frequence.m22552a(System.currentTimeMillis());
                m22703a.m22702a(frequence);
            }
        }
        if (z) {
            SameLogTool.m21736b("DomainSameTool", "更新安装列表");
            MBSDKContext.m22865f().m22863h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x003b, LOOP:0: B:13:0x0024->B:14:0x0026, LOOP_END, TryCatch #0 {Exception -> 0x003b, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x0017, B:11:0x0020, B:14:0x0026, B:15:0x0030, B:17:0x0036), top: B:22:0x0002 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m21874a(int r5) {
        /*
            java.lang.String r0 = ""
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L3b
            r1.<init>()     // Catch: java.lang.Exception -> L3b
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Exception -> L3b
            java.util.List r2 = r2.m22862i()     // Catch: java.lang.Exception -> L3b
            if (r2 == 0) goto L30
            int r3 = r2.size()     // Catch: java.lang.Exception -> L3b
            if (r3 <= 0) goto L30
            int r3 = r2.size()     // Catch: java.lang.Exception -> L3b
            if (r3 <= r5) goto L23
            if (r5 != 0) goto L20
            goto L23
        L20:
            int r5 = r3 - r5
            goto L24
        L23:
            r5 = 0
        L24:
            if (r5 >= r3) goto L30
            java.lang.Object r4 = r2.get(r5)     // Catch: java.lang.Exception -> L3b
            r1.put(r4)     // Catch: java.lang.Exception -> L3b
            int r5 = r5 + 1
            goto L24
        L30:
            int r5 = r1.length()     // Catch: java.lang.Exception -> L3b
            if (r5 <= 0) goto L3f
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameTool.m22007a(r1)     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r5 = move-exception
            r5.printStackTrace()
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.DomainSameTool.m21874a(int):java.lang.String");
    }

    /* renamed from: a */
    public static void m21871a(List<CampaignEx> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CampaignEx campaignEx = list.get(i);
            if (!SameTool.m21992c(MBSDKContext.m22865f().m22861j(), campaignEx.getPackageName()) && campaignEx.getOfferType() == 99) {
                arrayList.add(campaignEx);
            }
        }
        SCDao.m22679a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22676a(arrayList);
    }

    /* renamed from: a */
    public static boolean m21873a(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", FaceEnvironment.f8430OS);
            boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    return false;
                }
                if ("0".equals(str)) {
                    return true;
                }
                return z2;
            } catch (Throwable th) {
                z = z2;
                th = th;
                SameLogTool.m21735b("DomainSameTool", th.getMessage(), th);
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
