package com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo;

import android.app.Activity;
import androidx.core.view.PointerIconCompat;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class MediationCustomFullVideoLoader extends MediationCustomAdBaseLoader {
    public final void callAdVideoCache() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(8112, null, String.class);
        }
    }

    public final void callFullVideoAdClick() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1009, null, String.class);
        }
    }

    public final void callFullVideoAdClosed() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, String.class);
        }
    }

    public final void callFullVideoAdShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1008, null, String.class);
        }
    }

    public final void callFullVideoComplete() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1026, null, String.class);
        }
    }

    public final void callFullVideoError() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1021, null, String.class);
        }
    }

    public final void callFullVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8017, mediationRewardItem.rewardVerify());
        create.add(8018, mediationRewardItem.getAmount());
        create.add(8019, mediationRewardItem.getRewardName());
        create.add(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.call(PointerIconCompat.TYPE_ZOOM_IN, create.build(), String.class);
    }

    public final void callFullVideoSkippedVideo() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1037, null, String.class);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 8113) {
            if (i == 8121) {
                MediationApiLog.m36297i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
                return (T) isReadyCondition();
            }
            return null;
        }
        MediationApiLog.m36297i("TTMediationSDK", "MediationCustomFullVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity != null) {
            showAd(activity);
            return null;
        }
        return null;
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void showAd(Activity activity);

    public final void callLoadSuccess(double d) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d);
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

    public final void callLoadSuccess(double d, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d);
            create.add(8075, map);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }
}
