package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.c.c.c;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationCustomAdBaseLoader implements IMediationAdLoader {
    public Bridge mGmAdLoader;

    private void c() {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8405, this);
            this.mGmAdLoader.call(8221, create.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else if (i4 == 8225) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i4 == 8149) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i4 == 8148) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i4 == 8109) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i4, valueSet, cls);
    }

    public final void callLoadFail(int i4, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i4);
            create.add(8015, str);
            this.mGmAdLoader.call(8123, create.build(), String.class);
        }
    }

    public abstract <T> T callMethod(int i4, ValueSet valueSet, Class<T> cls);

    public final String getAdm() {
        Bridge bridge = this.mGmAdLoader;
        return bridge != null ? (String) bridge.call(8137, null, String.class) : "";
    }

    public final int getBiddingType() {
        Integer num;
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null || (num = (Integer) bridge.call(8226, null, Integer.class)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final Object getExtraDataNoParse() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return bridge.call(8224, null, Object.class);
        }
        return null;
    }

    public final Bridge getGMBridge() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return (Bridge) bridge.call(8127, null, Bridge.class);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader
    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
        loadInner(context, c.c(create.getAdSlotValueSet()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(create.getMediationCustomServiceConfigValue()), create.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Bridge bridge) {
        this.mGmAdLoader = bridge;
        c();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z3, double d4, int i4, @Nullable Map<String, Object> map) {
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8075, map);
        this.mGmAdLoader.call(8227, create.build(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
