package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.Random;

/* compiled from: SplashShowListenerImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private MBSplashShowListener f40686a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f40687b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40688c;

    /* renamed from: d  reason: collision with root package name */
    private c f40689d;

    public d(c cVar, MBSplashShowListener mBSplashShowListener, double d4, CampaignEx campaignEx) {
        this.f40689d = cVar;
        this.f40686a = mBSplashShowListener;
        this.f40687b = campaignEx;
        this.f40688c = a(d4, campaignEx);
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.f40689d;
        if (cVar != null) {
            cVar.f40653a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append(this.f40689d.b());
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.f40689d.c() ? 1 : 0);
        stringBuffer.append("&");
        stringBuffer.append("countdown=");
        stringBuffer.append(this.f40689d.d());
        stringBuffer.append("&");
        e.a(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40687b, mBridgeIds.getUnitId(), stringBuffer.toString());
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener == null || this.f40688c) {
            return;
        }
        mBSplashShowListener.onShowSuccessed(mBridgeIds);
    }

    public final void b(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener == null || this.f40688c) {
            return;
        }
        mBSplashShowListener.onAdClicked(mBridgeIds);
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        c cVar = this.f40689d;
        if (cVar != null) {
            cVar.f40653a = false;
        }
        e.b(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40687b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i4) {
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i4);
        }
        c cVar = this.f40689d;
        if (cVar != null) {
            cVar.f40653a = false;
        }
        if (i4 == 6 || i4 == 4 || i4 == 5) {
            CampaignEx campaignEx = this.f40687b;
            String unitId = mBridgeIds.getUnitId();
            com.mbridge.msdk.splash.a.b bVar = null;
            if (campaignEx != null) {
                try {
                    com.mbridge.msdk.splash.a.b c4 = com.mbridge.msdk.splash.a.b.a().b(unitId).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).c(campaignEx.getId());
                    bVar = c4.e(campaignEx.getCreativeId() + "").a(campaignEx.isBidCampaign());
                } catch (Exception e4) {
                    if (MBridgeConstans.DEBUG) {
                        e4.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            com.mbridge.msdk.splash.e.a.a(bVar, unitId, i4);
        }
    }

    public final void a(MBridgeIds mBridgeIds, long j4) {
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j4);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i4, int i5, int i6) {
        MBSplashShowListener mBSplashShowListener = this.f40686a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        CampaignEx campaignEx = this.f40687b;
        String unitId = mBridgeIds.getUnitId();
        try {
            e.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx, unitId, "flb_size=" + i5 + "x" + i4 + "&flb_type=" + i6 + "&");
        } catch (Exception e4) {
            try {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private boolean a(double d4, CampaignEx campaignEx) {
        long j4;
        com.mbridge.msdk.c.a b4;
        try {
            String k4 = com.mbridge.msdk.foundation.controller.a.f().k();
            long j5 = 0;
            if (TextUtils.isEmpty(k4) || (b4 = com.mbridge.msdk.c.b.a().b(k4)) == null) {
                j4 = 0;
            } else {
                j4 = b4.W() * 1000;
                j5 = 1000 * b4.ag();
            }
            x.d("SplashShowListenerImpl", "cbp : " + d4 + " plct : " + j5 + " plctb : " + j4);
            if (campaignEx != null) {
                if (campaignEx.isSpareOffer(j5, j4)) {
                    campaignEx.setSpareOfferFlag(1);
                    return true;
                }
                campaignEx.setSpareOfferFlag(0);
            }
            if (campaignEx == null || campaignEx.isBidCampaign() || d4 == 1.0d) {
                return false;
            }
            double nextDouble = new Random().nextDouble();
            StringBuilder sb = new StringBuilder();
            sb.append("hit : ");
            sb.append(nextDouble);
            sb.append(" ");
            sb.append(nextDouble > d4);
            x.d("SplashShowListenerImpl", sb.toString());
            return nextDouble > d4;
        } catch (Exception e4) {
            x.b("SplashShowListenerImpl", "CBPERROR", e4);
            return false;
        }
    }
}
