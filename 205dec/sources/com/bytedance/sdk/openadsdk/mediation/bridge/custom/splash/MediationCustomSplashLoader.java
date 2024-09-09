package com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash;

import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationCustomSplashLoader extends MediationCustomAdBaseLoader {
    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 6152) {
            if (i4 == 8121) {
                MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
                return (T) isReadyCondition();
            }
            return null;
        }
        MediationApiLog.i("TTMediationSDK", "MediationCustomSplashLoader showSplashAd");
        ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(20060, ViewGroup.class);
        if (viewGroup != null) {
            showAd(viewGroup);
            return null;
        }
        return null;
    }

    public final void callSplashAdClicked() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1009, null, String.class);
        }
    }

    public final void callSplashAdDismiss() {
        this.mGmAdLoader.call(1011, null, String.class);
    }

    public final void callSplashAdShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1008, null, String.class);
        }
    }

    public final void callSplashAdSkip() {
        this.mGmAdLoader.call(1019, null, String.class);
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void showAd(ViewGroup viewGroup);

    public final void callLoadSuccess(double d4) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d4);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8075, map);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }

    public final void callLoadSuccess(double d4, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d4);
            create.add(8075, map);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }
}
