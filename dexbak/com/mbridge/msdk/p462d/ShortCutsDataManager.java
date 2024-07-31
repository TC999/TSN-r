package com.mbridge.msdk.p462d;

import android.content.Context;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ShortCutsDataManager {

    /* renamed from: a */
    public static int f30147a = 3;

    /* renamed from: b */
    public static int f30148b = 1;

    /* renamed from: c */
    public static int f30149c = 4;

    /* renamed from: d */
    public static int f30150d = 5;

    /* renamed from: e */
    private static String f30151e = "ShortCutsDataManager";

    /* renamed from: f */
    private CommonClickControl f30152f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShortCutsDataManager.java */
    /* renamed from: com.mbridge.msdk.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11236a {

        /* renamed from: a */
        private static ShortCutsDataManager f30158a = new ShortCutsDataManager();
    }

    /* renamed from: a */
    public static ShortCutsDataManager m23003a() {
        return C11236a.f30158a;
    }

    private ShortCutsDataManager() {
    }

    /* renamed from: a */
    private void m23002a(Context context, CampaignEx campaignEx, int i) {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        if (this.f30152f == null) {
            this.f30152f = new CommonClickControl(context, m23252b.m23446D());
        }
        if (i == 1) {
            this.f30152f.m23094c(campaignEx);
        } else if (i == 2) {
            this.f30152f.m23114a(campaignEx);
        }
    }

    /* renamed from: a */
    static /* synthetic */ List m23001a(ShortCutsDataManager shortCutsDataManager, Context context, List list) {
        int jmPd;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i);
            if (campaignEx != null) {
                boolean m21992c = SameTool.m21992c(context, campaignEx.getPackageName());
                if (campaignEx.getWtick() == 1 || !m21992c) {
                    arrayList.add(campaignEx);
                    if (campaignEx.getLinkType() == 3 && (jmPd = campaignEx.getJmPd()) != 0) {
                        if (jmPd != 1) {
                            if (SameDiTool.m21804D(context) == 9) {
                                shortCutsDataManager.m23002a(context, campaignEx, 2);
                            }
                        } else {
                            shortCutsDataManager.m23002a(context, campaignEx, 2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
