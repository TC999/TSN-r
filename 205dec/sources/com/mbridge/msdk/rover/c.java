package com.mbridge.msdk.rover;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RoverDoing.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static String f40442b = "0";

    /* renamed from: d  reason: collision with root package name */
    private CampaignEx f40445d;

    /* renamed from: e  reason: collision with root package name */
    private Context f40446e;

    /* renamed from: c  reason: collision with root package name */
    private List<e> f40444c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    d f40443a = new d() { // from class: com.mbridge.msdk.rover.c.1
        @Override // com.mbridge.msdk.rover.d
        public final void a(String str, int i4, int i5, int i6, String str2, String str3) {
            c.a(c.this, str, i4, i5, i6, str2, str3);
        }

        @Override // com.mbridge.msdk.rover.d
        public final void b(String str, int i4, int i5, int i6, String str2, String str3) {
            c.a(c.this, str, i4, i5, i6, str2, str3);
        }

        @Override // com.mbridge.msdk.rover.d
        public final void c(String str, int i4, int i5, int i6, String str2, String str3) {
            c.a(c.this, str, i4, i5, i6, str2, str3);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f40447f = new HashMap();

    public c(RoverCampaignUnit roverCampaignUnit, CampaignEx campaignEx, Context context) {
        CommonJumpLoader commonJumpLoader = new CommonJumpLoader(context, true);
        this.f40445d = campaignEx;
        this.f40446e = context;
        commonJumpLoader.a("2", f40442b, campaignEx, new com.mbridge.msdk.click.e() { // from class: com.mbridge.msdk.rover.c.3
            @Override // com.mbridge.msdk.click.e
            public final void a(Object obj) {
            }

            @Override // com.mbridge.msdk.click.e
            public final void a(Object obj, String str) {
                if (c.this.f40445d == null || c.this.f40445d.getRoverIsPost() != 1) {
                    return;
                }
                c.b(c.this);
            }

            @Override // com.mbridge.msdk.click.e
            public final void b(Object obj) {
                if (c.this.f40445d == null || c.this.f40445d.getRoverIsPost() != 1) {
                    return;
                }
                c.b(c.this);
            }
        }, this.f40443a);
    }

    static /* synthetic */ void b(c cVar) {
        if (cVar.f40446e != null) {
            com.mbridge.msdk.foundation.same.report.d dVar = new com.mbridge.msdk.foundation.same.report.d(cVar.f40446e);
            f fVar = new f() { // from class: com.mbridge.msdk.rover.c.2
                @Override // com.mbridge.msdk.rover.f
                public final void a(String str) {
                }

                @Override // com.mbridge.msdk.rover.f
                public final void f() {
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.prepare();
            }
            dVar.a(cVar.f40445d, cVar.f40444c, fVar);
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.loop();
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str, int i4, int i5, int i6, String str2, String str3) {
        try {
            if (cVar.f40447f == null) {
                cVar.f40447f = new HashMap();
            }
            if (cVar.f40447f.containsKey(str)) {
                return;
            }
            cVar.f40447f.put(str, null);
            if (TextUtils.isEmpty(str) || !str.contains("data:*/*;charset=utf-8;base64")) {
                e eVar = new e();
                eVar.a(str);
                eVar.a(i4);
                eVar.b(i5);
                eVar.c(i6);
                eVar.b(s.a(str2));
                eVar.c(str3 == null ? "" : s.a(str3));
                List<e> list = cVar.f40444c;
                if (list != null) {
                    list.add(eVar);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                cVar.f40444c = arrayList;
                arrayList.add(eVar);
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }
}
