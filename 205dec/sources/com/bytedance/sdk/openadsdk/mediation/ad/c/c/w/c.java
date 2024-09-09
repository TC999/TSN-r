package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36025c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationAdSlot f36026w;

    public c(IMediationAdSlot iMediationAdSlot) {
        this.f36026w = iMediationAdSlot;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationAdSlot iMediationAdSlot = this.f36026w;
        if (iMediationAdSlot == null) {
            return null;
        }
        switch (i4) {
            case 266001:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isSplashShakeButton()));
            case 266002:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isSplashPreLoad()));
            case 266003:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isMuted()));
            case 266004:
                return (T) Float.class.cast(Float.valueOf(iMediationAdSlot.getVolume()));
            case 266005:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isUseSurfaceView()));
            case 266006:
                return (T) iMediationAdSlot.getExtraObject();
            case 266007:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isBidNotify()));
            case 266008:
                return (T) iMediationAdSlot.getScenarioId();
            case 266009:
                return (T) Boolean.class.cast(Boolean.valueOf(iMediationAdSlot.isAllowShowCloseBtn()));
            case 266010:
                return (T) Float.class.cast(Float.valueOf(iMediationAdSlot.getShakeViewWidth()));
            case 266011:
                return (T) Float.class.cast(Float.valueOf(iMediationAdSlot.getShakeViewHeight()));
            case 266012:
                return (T) iMediationAdSlot.getWxAppId();
            default:
                switch (i4) {
                    case 266101:
                        return (T) iMediationAdSlot.getMediationNativeToBannerListener();
                    case 266102:
                        return (T) iMediationAdSlot.getMediationSplashRequestInfo();
                    case 266103:
                        return (T) iMediationAdSlot.getRewardName();
                    case 266104:
                        return (T) Integer.class.cast(Integer.valueOf(iMediationAdSlot.getRewardAmount()));
                    default:
                        c(i4, valueSet, cls);
                        return null;
                }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36025c;
    }
}
