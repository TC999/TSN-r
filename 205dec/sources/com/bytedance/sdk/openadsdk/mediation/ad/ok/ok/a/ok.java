package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationAdSlot f36055a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(IMediationAdSlot iMediationAdSlot) {
        this.f36055a = iMediationAdSlot;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationAdSlot iMediationAdSlot = this.f36055a;
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
                        ok(i4, valueSet, cls);
                        return null;
                }
        }
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
