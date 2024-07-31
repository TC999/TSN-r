package com.mbridge.msdk.splash.p507f;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* renamed from: com.mbridge.msdk.splash.f.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SplashLoadResponseHandler extends SplashResponseHandler {

    /* renamed from: a */
    private int f31923a;

    public SplashLoadResponseHandler(int i) {
        this.f31923a = i;
    }

    /* renamed from: a */
    public abstract void mo21055a(int i, String str);

    /* renamed from: a */
    public abstract void mo21054a(CampaignUnit campaignUnit, int i);

    @Override // com.mbridge.msdk.splash.p507f.SplashResponseHandler
    /* renamed from: a */
    public final void mo21048a(List<Frame> list) {
    }

    @Override // com.mbridge.msdk.splash.p507f.SplashResponseHandler
    /* renamed from: a */
    public final void mo21047a(List<C11336b> list, CampaignUnit campaignUnit) {
        mo21054a(campaignUnit, this.f31923a);
    }

    @Override // com.mbridge.msdk.splash.p507f.SplashResponseHandler
    /* renamed from: b */
    public final void mo21046b(int i, String str) {
        mo21055a(i, str);
    }
}
