package com.mbridge.msdk.d;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShortCutsDataManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f38974a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static int f38975b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f38976c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static int f38977d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static String f38978e = "ShortCutsDataManager";

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.click.b f38979f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShortCutsDataManager.java */
    /* renamed from: com.mbridge.msdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0732a {

        /* renamed from: a  reason: collision with root package name */
        private static a f38985a = new a();
    }

    public static a a() {
        return C0732a.f38985a;
    }

    private a() {
    }

    private void a(Context context, CampaignEx campaignEx, int i4) {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        if (this.f38979f == null) {
            this.f38979f = new com.mbridge.msdk.click.b(context, b4.D());
        }
        if (i4 == 1) {
            this.f38979f.c(campaignEx);
        } else if (i4 == 2) {
            this.f38979f.a(campaignEx);
        }
    }

    static /* synthetic */ List a(a aVar, Context context, List list) {
        int jmPd;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i4);
            if (campaignEx != null) {
                boolean c4 = ac.c(context, campaignEx.getPackageName());
                if (campaignEx.getWtick() == 1 || !c4) {
                    arrayList.add(campaignEx);
                    if (campaignEx.getLinkType() == 3 && (jmPd = campaignEx.getJmPd()) != 0) {
                        if (jmPd != 1) {
                            if (t.D(context) == 9) {
                                aVar.a(context, campaignEx, 2);
                            }
                        } else {
                            aVar.a(context, campaignEx, 2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
