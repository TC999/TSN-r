package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DomainSameTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {
    public static void a(Context context, CampaignEx campaignEx) {
        x.b("DomainSameTool", "updateInstallList \u5f00\u59cb \u66f4\u65b0\u672c\u673a\u5df2\u5b89\u88c5\u5e7f\u544a\u5217\u8868");
        if (context == null) {
            x.b("DomainSameTool", "updateInstallList \u5217\u8868\u4e3a\u7a7a \u4e0d\u505a\u66f4\u65b0\u672c\u673a\u5df2\u5b89\u88c5\u5e7f\u544a\u5217\u8868");
            return;
        }
        com.mbridge.msdk.foundation.db.l a4 = com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.i.a(context));
        boolean z3 = false;
        if (campaignEx != null) {
            if (ac.c(context, campaignEx.getPackageName())) {
                if (com.mbridge.msdk.foundation.controller.a.e() != null) {
                    com.mbridge.msdk.foundation.controller.a.e().add(new com.mbridge.msdk.foundation.entity.i(campaignEx.getId(), campaignEx.getPackageName()));
                }
                z3 = true;
            } else if (a4 != null && !a4.a(campaignEx.getId())) {
                com.mbridge.msdk.foundation.entity.h hVar = new com.mbridge.msdk.foundation.entity.h();
                hVar.a(campaignEx.getId());
                hVar.a(campaignEx.getFca());
                hVar.b(campaignEx.getFcb());
                hVar.d(0);
                hVar.c(0);
                hVar.a(System.currentTimeMillis());
                a4.a(hVar);
            }
        }
        if (z3) {
            x.b("DomainSameTool", "\u66f4\u65b0\u5b89\u88c5\u5217\u8868");
            com.mbridge.msdk.foundation.controller.a.f().h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x003b, LOOP:0: B:13:0x0024->B:14:0x0026, LOOP_END, TryCatch #0 {Exception -> 0x003b, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x0017, B:11:0x0020, B:14:0x0026, B:15:0x0030, B:17:0x0036), top: B:22:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r5) {
        /*
            java.lang.String r0 = ""
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L3b
            r1.<init>()     // Catch: java.lang.Exception -> L3b
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Exception -> L3b
            java.util.List r2 = r2.i()     // Catch: java.lang.Exception -> L3b
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
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.ac.a(r1)     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r5 = move-exception
            r5.printStackTrace()
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.h.a(int):java.lang.String");
    }

    public static void a(List<CampaignEx> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            CampaignEx campaignEx = list.get(i4);
            if (!ac.c(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx.getPackageName()) && campaignEx.getOfferType() == 99) {
                arrayList.add(campaignEx);
            }
        }
        com.mbridge.msdk.foundation.db.p.a(com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(arrayList);
    }

    public static boolean a(Context context) {
        boolean z3 = false;
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z4 = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(f3.f5657f, String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    return false;
                }
                if ("0".equals(str)) {
                    return true;
                }
                return z4;
            } catch (Throwable th) {
                z3 = z4;
                th = th;
                x.b("DomainSameTool", th.getMessage(), th);
                return z3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
