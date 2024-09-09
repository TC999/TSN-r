package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;

/* compiled from: SplashLoadListenerImpl.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.mbridge.msdk.splash.b.b {

    /* renamed from: a  reason: collision with root package name */
    private MBSplashLoadListener f40647a;

    /* renamed from: b  reason: collision with root package name */
    private c f40648b;

    /* renamed from: c  reason: collision with root package name */
    private MBridgeIds f40649c;

    /* renamed from: d  reason: collision with root package name */
    private String f40650d;

    /* renamed from: e  reason: collision with root package name */
    private String f40651e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f40648b = cVar;
        this.f40649c = mBridgeIds;
        if (mBridgeIds != null) {
            this.f40650d = mBridgeIds.getUnitId();
        }
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        this.f40647a = mBSplashLoadListener;
    }

    public final void a(String str) {
        this.f40651e = str;
    }

    @Override // com.mbridge.msdk.splash.b.b
    public final void a(CampaignEx campaignEx, int i4) {
        c cVar;
        c cVar2 = this.f40648b;
        if (cVar2 == null || !cVar2.a() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f40647a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.f40649c, i4);
            this.f40647a.isSupportZoomOut(this.f40649c, campaignEx.getFlb() == 1);
        }
        this.f40648b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        e.a(com.mbridge.msdk.foundation.controller.a.f().j(), arrayList, this.f40650d, campaignEx.isBidCampaign());
        if (i4 != 2 || (cVar = this.f40648b) == null) {
            return;
        }
        cVar.a(campaignEx, 0, true);
    }

    @Override // com.mbridge.msdk.splash.b.b
    public final void a(String str, int i4) {
        c cVar = this.f40648b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f40647a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.f40649c, str, i4);
        }
        this.f40648b.a(false);
        e.a(com.mbridge.msdk.foundation.controller.a.f().j(), str, this.f40650d, !TextUtils.isEmpty(this.f40651e));
    }
}
