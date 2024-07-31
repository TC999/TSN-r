package com.mbridge.msdk.splash.p505d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.p503b.SplashLoadListener;
import java.util.ArrayList;

/* renamed from: com.mbridge.msdk.splash.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashLoadListenerImpl implements SplashLoadListener {

    /* renamed from: a */
    private MBSplashLoadListener f31875a;

    /* renamed from: b */
    private SplashProvider f31876b;

    /* renamed from: c */
    private MBridgeIds f31877c;

    /* renamed from: d */
    private String f31878d;

    /* renamed from: e */
    private String f31879e;

    public SplashLoadListenerImpl(SplashProvider splashProvider, MBridgeIds mBridgeIds) {
        this.f31876b = splashProvider;
        this.f31877c = mBridgeIds;
        if (mBridgeIds != null) {
            this.f31878d = mBridgeIds.getUnitId();
        }
    }

    /* renamed from: a */
    public final void m21111a(MBSplashLoadListener mBSplashLoadListener) {
        this.f31875a = mBSplashLoadListener;
    }

    /* renamed from: a */
    public final void m21110a(String str) {
        this.f31879e = str;
    }

    @Override // com.mbridge.msdk.splash.p503b.SplashLoadListener
    /* renamed from: a */
    public final void mo21112a(CampaignEx campaignEx, int i) {
        SplashProvider splashProvider;
        SplashProvider splashProvider2 = this.f31876b;
        if (splashProvider2 == null || !splashProvider2.m21108a() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f31875a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.f31877c, i);
            this.f31875a.isSupportZoomOut(this.f31877c, campaignEx.getFlb() == 1);
        }
        this.f31876b.m21094a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        C11385e.m22068a(MBSDKContext.m22865f().m22861j(), arrayList, this.f31878d, campaignEx.isBidCampaign());
        if (i != 2 || (splashProvider = this.f31876b) == null) {
            return;
        }
        splashProvider.m21102a(campaignEx, 0, true);
    }

    @Override // com.mbridge.msdk.splash.p503b.SplashLoadListener
    /* renamed from: a */
    public final void mo21109a(String str, int i) {
        SplashProvider splashProvider = this.f31876b;
        if (splashProvider == null || !splashProvider.m21108a()) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f31875a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.f31877c, str, i);
        }
        this.f31876b.m21094a(false);
        C11385e.m22070a(MBSDKContext.m22865f().m22861j(), str, this.f31878d, !TextUtils.isEmpty(this.f31879e));
    }
}
