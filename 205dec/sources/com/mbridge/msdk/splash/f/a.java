package com.mbridge.msdk.splash.f;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* compiled from: SplashLoadResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f40690a;

    public a(int i4) {
        this.f40690a = i4;
    }

    public abstract void a(int i4, String str);

    public abstract void a(CampaignUnit campaignUnit, int i4);

    @Override // com.mbridge.msdk.splash.f.c
    public final void a(List<Frame> list) {
    }

    @Override // com.mbridge.msdk.splash.f.c
    public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit) {
        a(campaignUnit, this.f40690a);
    }

    @Override // com.mbridge.msdk.splash.f.c
    public final void b(int i4, String str) {
        a(i4, str);
    }
}
