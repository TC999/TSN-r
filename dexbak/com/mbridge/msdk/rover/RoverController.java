package com.mbridge.msdk.rover;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.ArrayList;

/* renamed from: com.mbridge.msdk.rover.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RoverController {

    /* renamed from: d */
    private static RoverController f31665d;

    /* renamed from: a */
    Context f31666a;

    /* renamed from: b */
    long f31667b = 259200000;

    /* renamed from: c */
    private Handler f31668c = new Handler() { // from class: com.mbridge.msdk.rover.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            RoverController.m21324a(RoverController.this);
        }
    };

    private RoverController() {
    }

    /* renamed from: c */
    private boolean m21322c() {
        Context context = this.f31666a;
        if (context != null) {
            try {
                long j = context.getPackageManager().getPackageInfo(this.f31666a.getPackageName(), 0).lastUpdateTime;
                long currentTimeMillis = System.currentTimeMillis();
                r1 = currentTimeMillis - j > this.f31667b;
                SameLogTool.m21738a("", "currentTime=" + currentTimeMillis + ",lastUpdateTime:" + j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r1;
    }

    /* renamed from: a */
    public final void m21325a(Context context) {
        this.f31666a = context;
    }

    /* renamed from: b */
    public final void m21323b() {
        if (this.f31666a == null) {
            SameLogTool.m21733d("RoverController", "Context is null");
        } else if (m21322c()) {
            Object m21961b = C11400ae.m21961b(this.f31666a, RoverConstans.f31664d, 0L);
            long longValue = m21961b instanceof Long ? ((Long) m21961b).longValue() : 1L;
            long currentTimeMillis = System.currentTimeMillis();
            int i = RoverConstans.f31663c;
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b != null && m23252b.m23416S() > 0) {
                i = (int) m23252b.m23416S();
            }
            if (currentTimeMillis - longValue > ((long) i) && longValue != 1) {
                this.f31668c.sendEmptyMessageDelayed(0, 30000L);
            }
        }
    }

    /* renamed from: a */
    public static RoverController m21326a() {
        if (f31665d == null) {
            synchronized (RoverController.class) {
                if (f31665d == null) {
                    f31665d = new RoverController();
                }
            }
        }
        return f31665d;
    }

    /* renamed from: a */
    static /* synthetic */ void m21324a(RoverController roverController) {
        C11400ae.m21963a(roverController.f31666a, RoverConstans.f31664d, Long.valueOf(System.currentTimeMillis()));
        new RoverRequest(roverController.f31666a).m22234a(1, RequestUrlUtil.m22248a().f30816z, new CommonRequestParams(), new RoverResponseHandler() { // from class: com.mbridge.msdk.rover.b.2
            @Override // com.mbridge.msdk.rover.RoverResponseHandler
            /* renamed from: a */
            public final void mo21303a(RoverCampaignUnit roverCampaignUnit) {
                ArrayList<CampaignEx> arrayList = roverCampaignUnit.ads;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                for (CampaignEx campaignEx : arrayList) {
                    if (campaignEx != null) {
                        new RoverDoing(roverCampaignUnit, campaignEx, RoverController.this.f31666a);
                    }
                }
            }
        });
    }
}
