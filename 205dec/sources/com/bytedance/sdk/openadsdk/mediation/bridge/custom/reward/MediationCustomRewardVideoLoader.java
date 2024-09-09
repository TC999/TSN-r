package com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationCustomRewardVideoLoader extends MediationCustomAdBaseLoader {
    public final void callAdVideoCache() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(8112, null, String.class);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 8113) {
            if (i4 == 8121) {
                MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
                return (T) isReadyCondition();
            }
            return null;
        }
        MediationApiLog.i("TTMediationSDK", "MediationCustomRewardVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity != null) {
            showAd(activity);
            return null;
        }
        return null;
    }

    public final void callRewardVideoAdClick() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1009, null, String.class);
        }
    }

    public final void callRewardVideoAdClosed() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1014, null, String.class);
        }
    }

    public final void callRewardVideoAdShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1008, null, String.class);
        }
    }

    public final void callRewardVideoComplete() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1026, null, String.class);
        }
    }

    public final void callRewardVideoError() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1021, null, String.class);
        }
    }

    public final void callRewardVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8017, mediationRewardItem.rewardVerify());
        create.add(8018, mediationRewardItem.getAmount());
        create.add(8019, mediationRewardItem.getRewardName());
        create.add(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.call(1018, create.build(), String.class);
    }

    public final void callRewardVideoSkippedVideo() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1037, null, String.class);
        }
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void showAd(Activity activity);

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
