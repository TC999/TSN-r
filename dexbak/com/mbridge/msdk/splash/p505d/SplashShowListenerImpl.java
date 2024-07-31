package com.mbridge.msdk.splash.p505d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.splash.p501a.C11567b;
import com.mbridge.msdk.splash.p506e.SplashReport;
import java.util.Random;

/* renamed from: com.mbridge.msdk.splash.d.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashShowListenerImpl {

    /* renamed from: a */
    private MBSplashShowListener f31919a;

    /* renamed from: b */
    private CampaignEx f31920b;

    /* renamed from: c */
    private boolean f31921c;

    /* renamed from: d */
    private SplashProvider f31922d;

    public SplashShowListenerImpl(SplashProvider splashProvider, MBSplashShowListener mBSplashShowListener, double d, CampaignEx campaignEx) {
        this.f31922d = splashProvider;
        this.f31919a = mBSplashShowListener;
        this.f31920b = campaignEx;
        this.f31921c = m21073a(d, campaignEx);
    }

    /* renamed from: a */
    public final void m21072a(MBridgeIds mBridgeIds) {
        SplashProvider splashProvider = this.f31922d;
        if (splashProvider != null) {
            splashProvider.f31886a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append(this.f31922d.m21093b());
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.f31922d.m21086c() ? 1 : 0);
        stringBuffer.append("&");
        stringBuffer.append("countdown=");
        stringBuffer.append(this.f31922d.m21082d());
        stringBuffer.append("&");
        C11385e.m22082a(MBSDKContext.m22865f().m22861j(), this.f31920b, mBridgeIds.getUnitId(), stringBuffer.toString());
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener == null || this.f31921c) {
            return;
        }
        mBSplashShowListener.onShowSuccessed(mBridgeIds);
    }

    /* renamed from: b */
    public final void m21067b(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener == null || this.f31921c) {
            return;
        }
        mBSplashShowListener.onAdClicked(mBridgeIds);
    }

    /* renamed from: a */
    public final void m21068a(MBridgeIds mBridgeIds, String str) {
        SplashProvider splashProvider = this.f31922d;
        if (splashProvider != null) {
            splashProvider.f31886a = false;
        }
        C11385e.m22058b(MBSDKContext.m22865f().m22861j(), this.f31920b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    /* renamed from: a */
    public final void m21071a(MBridgeIds mBridgeIds, int i) {
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i);
        }
        SplashProvider splashProvider = this.f31922d;
        if (splashProvider != null) {
            splashProvider.f31886a = false;
        }
        if (i == 6 || i == 4 || i == 5) {
            CampaignEx campaignEx = this.f31920b;
            String unitId = mBridgeIds.getUnitId();
            C11567b c11567b = null;
            if (campaignEx != null) {
                try {
                    C11567b m21286c = C11567b.m21293a().m21287b(unitId).m21285d(campaignEx.getRequestId()).m21282g(campaignEx.getRequestIdNotice()).m21286c(campaignEx.getId());
                    c11567b = m21286c.m21284e(campaignEx.getCreativeId() + "").m21290a(campaignEx.isBidCampaign());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            SplashReport.m21060a(c11567b, unitId, i);
        }
    }

    /* renamed from: a */
    public final void m21069a(MBridgeIds mBridgeIds, long j) {
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j);
        }
    }

    /* renamed from: a */
    public final void m21070a(MBridgeIds mBridgeIds, int i, int i2, int i3) {
        MBSplashShowListener mBSplashShowListener = this.f31919a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        CampaignEx campaignEx = this.f31920b;
        String unitId = mBridgeIds.getUnitId();
        try {
            C11385e.m22082a(MBSDKContext.m22865f().m22861j(), campaignEx, unitId, "flb_size=" + i2 + "x" + i + "&flb_type=" + i3 + "&");
        } catch (Exception e) {
            try {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m21073a(double d, CampaignEx campaignEx) {
        long j;
        Setting m23252b;
        try {
            String m22860k = MBSDKContext.m22865f().m22860k();
            long j2 = 0;
            if (TextUtils.isEmpty(m22860k) || (m23252b = SettingManager.m23261a().m23252b(m22860k)) == null) {
                j = 0;
            } else {
                j = m23252b.m23408W() * 1000;
                j2 = 1000 * m23252b.m23365ag();
            }
            SameLogTool.m21733d("SplashShowListenerImpl", "cbp : " + d + " plct : " + j2 + " plctb : " + j);
            if (campaignEx != null) {
                if (campaignEx.isSpareOffer(j2, j)) {
                    campaignEx.setSpareOfferFlag(1);
                    return true;
                }
                campaignEx.setSpareOfferFlag(0);
            }
            if (campaignEx == null || campaignEx.isBidCampaign() || d == 1.0d) {
                return false;
            }
            double nextDouble = new Random().nextDouble();
            StringBuilder sb = new StringBuilder();
            sb.append("hit : ");
            sb.append(nextDouble);
            sb.append(" ");
            sb.append(nextDouble > d);
            SameLogTool.m21733d("SplashShowListenerImpl", sb.toString());
            return nextDouble > d;
        } catch (Exception e) {
            SameLogTool.m21735b("SplashShowListenerImpl", "CBPERROR", e);
            return false;
        }
    }
}
