package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.TTVideoOption;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtNativeAdapter extends TTAbsAdLoaderAdapter {

    /* renamed from: s */
    private Context f21360s;

    /* renamed from: t */
    private TTVideoOption f21361t;

    /* renamed from: B */
    private void m37811B() {
        GdtNativeExpressLoader gdtNativeExpressLoader = new GdtNativeExpressLoader();
        gdtNativeExpressLoader.m37809a(getAdLoadCount()).m37807c(getAdSlotId()).m37799k(this.mAdSlot.getImgAcceptedWidth()).m37801i(this.mAdSlot.getImgAcceptedHeight()).m37808b(this.f21361t);
        gdtNativeExpressLoader.loadAd(this.f21360s, isClientBidding(), this);
    }

    /* renamed from: C */
    private void m37810C() {
        GdtNativeLoader gdtNativeLoader = new GdtNativeLoader();
        gdtNativeLoader.m37790a(getAdLoadCount()).m37789b(this.mAdSlot.getGdtNativeAdLogoParams()).m37787d(getAdSlotId()).m37788c(this.f21361t);
        gdtNativeLoader.loadAd(this.f21360s, isClientBidding(), this);
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
        this.f21360s = context;
        if (map != null) {
            this.f21361t = this.mAdSlot.getTTVideoOption();
            Object obj = map.get("tt_ad_origin_type");
            if (obj != null) {
                int intValue = ((Integer) obj).intValue();
                if (intValue == 1 || intValue == 3) {
                    m37811B();
                    return;
                } else if (intValue == 2) {
                    m37810C();
                    return;
                }
            }
            int adStyleType = this.mAdSlot.getAdStyleType();
            if (adStyleType == 1) {
                m37811B();
            } else if (adStyleType == 2) {
                m37810C();
            }
        }
    }
}
