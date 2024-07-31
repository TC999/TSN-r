package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6442ok implements Bridge {

    /* renamed from: a */
    private final IMediationAdSlot f22700a;

    /* renamed from: ok */
    private ValueSet f22701ok = C5930a.f21279c;

    public C6442ok(IMediationAdSlot iMediationAdSlot) {
        this.f22700a = iMediationAdSlot;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationAdSlot iMediationAdSlot = this.f22700a;
        if (iMediationAdSlot == null) {
            return null;
        }
        switch (i) {
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
                switch (i) {
                    case 266101:
                        return (T) iMediationAdSlot.getMediationNativeToBannerListener();
                    case 266102:
                        return (T) iMediationAdSlot.getMediationSplashRequestInfo();
                    case 266103:
                        return (T) iMediationAdSlot.getRewardName();
                    case 266104:
                        return (T) Integer.class.cast(Integer.valueOf(iMediationAdSlot.getRewardAmount()));
                    default:
                        m36274ok(i, valueSet, cls);
                        return null;
                }
        }
    }

    /* renamed from: ok */
    protected void m36274ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22701ok;
    }
}
