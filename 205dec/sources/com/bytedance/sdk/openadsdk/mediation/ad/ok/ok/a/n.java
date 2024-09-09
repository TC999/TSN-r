package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationViewBinder f36054a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public n(IMediationViewBinder iMediationViewBinder) {
        this.f36054a = iMediationViewBinder;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationViewBinder iMediationViewBinder = this.f36054a;
        if (iMediationViewBinder == null) {
            return null;
        }
        switch (i4) {
            case 271021:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getLayoutId()));
            case 271022:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getTitleId()));
            case 271023:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getDecriptionTextId()));
            case 271024:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getCallToActionId()));
            case 271025:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getIconImageId()));
            case 271026:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getMainImageId()));
            case 271027:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getMediaViewId()));
            case 271028:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getSourceId()));
            case 271029:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage1Id()));
            case 271030:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage2Id()));
            case 271031:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage3Id()));
            case 271032:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getLogoLayoutId()));
            case 271033:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getShakeViewContainerId()));
            case 271034:
                return (T) iMediationViewBinder.getExtras();
            default:
                ok(i4, valueSet, cls);
                return null;
        }
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
