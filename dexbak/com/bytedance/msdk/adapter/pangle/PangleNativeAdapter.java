package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTUIUtils;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleNativeAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21451s;

    /* renamed from: B */
    private AdSlot m37674B(AdSlot.Builder builder) {
        PangleAdapterUtils.updateData(builder, this.mWaterfallAbTestParam, getClientReqId(), false);
        return builder.build();
    }

    /* renamed from: C */
    private void m37673C(TTAdNative tTAdNative, AdSlot.Builder builder) {
        new PangleNativeLoader().loadAd(this.f21451s, isClientBidding(), tTAdNative, m37674B(builder), this);
    }

    /* renamed from: D */
    private void m37672D(TTAdNative tTAdNative, AdSlot.Builder builder, int i, int i2) {
        if (i2 > 0) {
            builder.setExpressViewAcceptedSize(i, i2);
        } else {
            builder.setExpressViewAcceptedSize(i, 0.0f);
        }
        new PangleNativeExpressLoader().loadAd(this.f21451s, isClientBidding(), tTAdNative, m37674B(builder), this);
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return TTPangleSDKInitManager.get().getSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        this.f21451s = context;
        if (map != null) {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(this.f21451s);
            int intValue = ((Integer) map.get(TTRequestExtraParams.PARAM_AD_WIDTH)).intValue();
            int intValue2 = ((Integer) map.get(TTRequestExtraParams.PARAM_AD_HEIGHT)).intValue();
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(getAdSlotId()).setSupportDeepLink(true).setAdloadSeq(this.mAdSlot.getAdloadSeq()).setPrimeRit(this.mAdSlot.getAdUnitId()).setDownloadType(this.mAdSlot.getDownloadType()).setAdCount(getAdLoadCount());
            if (intValue > 0 && intValue2 > 0) {
                adCount.setImageAcceptedSize(TTUIUtils.m59088a(this.f21451s, intValue), TTUIUtils.m59088a(this.f21451s, intValue2));
            }
            if (!TextUtils.isEmpty(getAdm())) {
                adCount.withBid(getAdm());
            }
            Object obj = map.get("tt_ad_origin_type");
            if (obj != null) {
                int intValue3 = ((Integer) obj).intValue();
                if (intValue3 == 1) {
                    m37672D(createAdNative, adCount, intValue, intValue2);
                    return;
                } else if (intValue3 == 2) {
                    m37673C(createAdNative, adCount);
                    return;
                } else if (intValue3 == 3) {
                    notifyAdFailed(AdErrorUtil.obtainAdError(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH, AdError.getMessage(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH)));
                    return;
                }
            }
            if (this.mAdSlot.getAdStyleType() == 1) {
                m37672D(createAdNative, adCount, intValue, intValue2);
            } else if (this.mAdSlot.getAdStyleType() == 2) {
                m37673C(createAdNative, adCount);
            }
        }
    }
}
