package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationBaseAdBridge implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private MediationAdSlotValueSet f36058c;
    public Bridge mGMAd;

    public MediationBaseAdBridge(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
        this.mGMAd = bridge;
        this.f36058c = mediationAdSlotValueSet;
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        Double d4 = bridge != null ? (Double) bridge.call(8143, null, Double.class) : null;
        if (d4 == null) {
            return 0.0d;
        }
        return d4.doubleValue();
    }

    public Map<String, Object> getCustomData() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getExtraObject();
        }
        return null;
    }

    public Object getGdtVideoOption() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getGdtVideoOption();
        }
        return null;
    }

    public int getOrientation() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOrientation();
        }
        return 2;
    }

    public int getRewardAmount() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardAmount();
        }
        return 0;
    }

    public String getRewardName() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardName();
        }
        return null;
    }

    public MediationAdSlotValueSet getSlotValueSet() {
        return this.f36058c;
    }

    public String getUserID() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getUserId();
        }
        return null;
    }

    public float getVolume() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getVolume();
        }
        return 0.0f;
    }

    public abstract boolean hasDestroyed();

    public boolean isMuted() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f36058c;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isMuted();
        }
        return false;
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void onDestroy();

    public void setCpm(double d4) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8016, d4);
            this.mGMAd.call(8111, create.build(), Void.class);
        }
    }

    public void setCpmLevel(String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8058, str);
            this.mGMAd.call(8207, create.build(), Void.class);
        }
    }

    public void setExpress() {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8033, true);
            this.mGMAd.call(8129, create.build(), Void.class);
        }
    }

    public void setImageMode(int i4) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8060, i4);
            this.mGMAd.call(8209, create.build(), Void.class);
        }
    }

    public void setLevelTag(String str) {
        if (TextUtils.isEmpty(str) || this.mGMAd == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8058, str);
        this.mGMAd.call(8208, create.build(), Void.class);
    }

    public void setSlotValueSet(MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f36058c = mediationAdSlotValueSet;
    }
}
