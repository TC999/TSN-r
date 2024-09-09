package com.mbridge.msdk.rover;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;

/* compiled from: RoverController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static b f40436d;

    /* renamed from: a  reason: collision with root package name */
    Context f40437a;

    /* renamed from: b  reason: collision with root package name */
    long f40438b = 259200000;

    /* renamed from: c  reason: collision with root package name */
    private Handler f40439c = new Handler() { // from class: com.mbridge.msdk.rover.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            b.a(b.this);
        }
    };

    private b() {
    }

    private boolean c() {
        Context context = this.f40437a;
        if (context != null) {
            try {
                long j4 = context.getPackageManager().getPackageInfo(this.f40437a.getPackageName(), 0).lastUpdateTime;
                long currentTimeMillis = System.currentTimeMillis();
                r1 = currentTimeMillis - j4 > this.f40438b;
                x.a("", "currentTime=" + currentTimeMillis + ",lastUpdateTime:" + j4);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return r1;
    }

    public final void a(Context context) {
        this.f40437a = context;
    }

    public final void b() {
        if (this.f40437a == null) {
            x.d("RoverController", "Context is null");
        } else if (c()) {
            Object b4 = ae.b(this.f40437a, a.f40435d, 0L);
            long longValue = b4 instanceof Long ? ((Long) b4).longValue() : 1L;
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = a.f40434c;
            com.mbridge.msdk.c.a b5 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b5 != null && b5.S() > 0) {
                i4 = (int) b5.S();
            }
            if (currentTimeMillis - longValue > ((long) i4) && longValue != 1) {
                this.f40439c.sendEmptyMessageDelayed(0, PolicyConfig.mServerBusyRetryBaseInternal);
            }
        }
    }

    public static b a() {
        if (f40436d == null) {
            synchronized (b.class) {
                if (f40436d == null) {
                    f40436d = new b();
                }
            }
        }
        return f40436d;
    }

    static /* synthetic */ void a(b bVar) {
        ae.a(bVar.f40437a, a.f40435d, Long.valueOf(System.currentTimeMillis()));
        new g(bVar.f40437a).a(1, com.mbridge.msdk.foundation.same.net.f.d.a().f39589z, new com.mbridge.msdk.foundation.same.net.g.d(), new h() { // from class: com.mbridge.msdk.rover.b.2
            @Override // com.mbridge.msdk.rover.h
            public final void a(RoverCampaignUnit roverCampaignUnit) {
                ArrayList<CampaignEx> arrayList = roverCampaignUnit.ads;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                for (CampaignEx campaignEx : arrayList) {
                    if (campaignEx != null) {
                        new c(roverCampaignUnit, campaignEx, b.this.f40437a);
                    }
                }
            }
        });
    }
}
