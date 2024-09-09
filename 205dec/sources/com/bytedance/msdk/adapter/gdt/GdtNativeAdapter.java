package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.TTVideoOption;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtNativeAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s  reason: collision with root package name */
    private Context f26970s;

    /* renamed from: t  reason: collision with root package name */
    private TTVideoOption f26971t;

    private void B() {
        GdtNativeExpressLoader gdtNativeExpressLoader = new GdtNativeExpressLoader();
        gdtNativeExpressLoader.a(getAdLoadCount()).c(getAdSlotId()).k(this.mAdSlot.getImgAcceptedWidth()).i(this.mAdSlot.getImgAcceptedHeight()).b(this.f26971t);
        gdtNativeExpressLoader.loadAd(this.f26970s, isClientBidding(), this);
    }

    private void C() {
        GdtNativeLoader gdtNativeLoader = new GdtNativeLoader();
        gdtNativeLoader.a(getAdLoadCount()).b(this.mAdSlot.getGdtNativeAdLogoParams()).d(getAdSlotId()).c(this.f26971t);
        gdtNativeLoader.loadAd(this.f26970s, isClientBidding(), this);
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return SDKStatus.getSDKVersion();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        this.f26970s = context;
        if (map != null) {
            this.f26971t = this.mAdSlot.getTTVideoOption();
            Object obj = map.get("tt_ad_origin_type");
            if (obj != null) {
                int intValue = ((Integer) obj).intValue();
                if (intValue == 1 || intValue == 3) {
                    B();
                    return;
                } else if (intValue == 2) {
                    C();
                    return;
                }
            }
            int adStyleType = this.mAdSlot.getAdStyleType();
            if (adStyleType == 1) {
                B();
            } else if (adStyleType == 2) {
                C();
            }
        }
    }
}
