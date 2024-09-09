package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.z;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleNativeAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f27061s;

    private AdSlot B(AdSlot.Builder builder) {
        PangleAdapterUtils.updateData(builder, this.mWaterfallAbTestParam, getClientReqId(), false);
        return builder.build();
    }

    private void C(TTAdNative tTAdNative, AdSlot.Builder builder) {
        new PangleNativeLoader().loadAd(this.f27061s, isClientBidding(), tTAdNative, B(builder), this);
    }

    private void D(TTAdNative tTAdNative, AdSlot.Builder builder, int i4, int i5) {
        if (i5 > 0) {
            builder.setExpressViewAcceptedSize(i4, i5);
        } else {
            builder.setExpressViewAcceptedSize(i4, 0.0f);
        }
        new PangleNativeExpressLoader().loadAd(this.f27061s, isClientBidding(), tTAdNative, B(builder), this);
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
        this.f27061s = context;
        if (map != null) {
            TTAdNative createAdNative = TTPangleSDKInitManager.get().createAdNative(this.f27061s);
            int intValue = ((Integer) map.get(TTRequestExtraParams.PARAM_AD_WIDTH)).intValue();
            int intValue2 = ((Integer) map.get(TTRequestExtraParams.PARAM_AD_HEIGHT)).intValue();
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(getAdSlotId()).setSupportDeepLink(true).setAdloadSeq(this.mAdSlot.getAdloadSeq()).setPrimeRit(this.mAdSlot.getAdUnitId()).setDownloadType(this.mAdSlot.getDownloadType()).setAdCount(getAdLoadCount());
            if (intValue > 0 && intValue2 > 0) {
                adCount.setImageAcceptedSize(z.a(this.f27061s, intValue), z.a(this.f27061s, intValue2));
            }
            if (!TextUtils.isEmpty(getAdm())) {
                adCount.withBid(getAdm());
            }
            Object obj = map.get("tt_ad_origin_type");
            if (obj != null) {
                int intValue3 = ((Integer) obj).intValue();
                if (intValue3 == 1) {
                    D(createAdNative, adCount, intValue, intValue2);
                    return;
                } else if (intValue3 == 2) {
                    C(createAdNative, adCount);
                    return;
                } else if (intValue3 == 3) {
                    notifyAdFailed(AdErrorUtil.obtainAdError(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH, AdError.getMessage(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH)));
                    return;
                }
            }
            if (this.mAdSlot.getAdStyleType() == 1) {
                D(createAdNative, adCount, intValue, intValue2);
            } else if (this.mAdSlot.getAdStyleType() == 2) {
                C(createAdNative, adCount);
            }
        }
    }
}
