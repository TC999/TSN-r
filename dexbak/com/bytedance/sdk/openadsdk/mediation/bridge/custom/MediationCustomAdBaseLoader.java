package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6487ok;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class MediationCustomAdBaseLoader implements IMediationAdLoader {
    public Bridge mGmAdLoader;

    /* renamed from: ok */
    private void m36269ok() {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8405, this);
            this.mGmAdLoader.call(8221, create.build(), String.class);
        }
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else if (i == 8225) {
            MediationApiLog.m36297i("TTMediationSDK", "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            MediationApiLog.m36297i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            MediationApiLog.m36297i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            MediationApiLog.m36297i("TTMediationSDK", "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    public final void callLoadFail(int i, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i);
            create.add(8015, str);
            this.mGmAdLoader.call(8123, create.build(), String.class);
        }
    }

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

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
        loadInner(context, C6487ok.m36217ok(create.getAdSlotValueSet()), new MediationCustomServiceConfig(create.getMediationCustomServiceConfigValue()), create.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig, Bridge bridge) {
        this.mGmAdLoader = bridge;
        m36269ok();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                e.printStackTrace();
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

    public void receiveBidResult(boolean z, double d, int i, @Nullable Map<String, Object> map) {
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8075, map);
        this.mGmAdLoader.call(8227, create.build(), Void.class);
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
