package com.bytedance.msdk.core.c;

import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.msdk.c.ux implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    protected Bridge f27850c;

    /* renamed from: w  reason: collision with root package name */
    protected com.bytedance.msdk.adapter.c f27851w;

    public w(com.bytedance.msdk.adapter.c cVar) {
        this.f27851w = cVar;
    }

    @Override // com.bytedance.msdk.c.ux
    public void bidLoseNotify(Map<String, Object> map) {
        if (isClientBiddingAd()) {
            Object obj = map.get("bidding_lose_reason");
            int lossReason = MediationConstant.BiddingLossReason.OTHER.getLossReason();
            if (obj instanceof MediationConstant.BiddingLossReason) {
                lossReason = ((MediationConstant.BiddingLossReason) obj).getLossReason();
            }
            map.put("bidding_lose_reason_NUM", Integer.valueOf(lossReason));
            if (this.f27850c != null) {
                b a4 = b.a();
                a4.h(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map);
                this.f27850c.call(8144, a4.l(), Void.class);
            }
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void bidWinNotify(Map<String, Object> map) {
        if (isClientBiddingAd() && this.f27850c != null) {
            b a4 = b.a();
            a4.h(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map);
            this.f27850c.call(8142, a4.l(), Void.class);
        }
    }

    public abstract <T> T c(int i4, ValueSet valueSet, Class<T> cls);

    public boolean c() {
        com.bytedance.msdk.adapter.c cVar = this.f27851w;
        if (cVar != null) {
            return cVar.isClientBidding();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public final <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8128) {
            this.f27850c = (Bridge) valueSet.objectValue(8035, Bridge.class);
        } else if (i4 == 8208) {
            String stringValue = valueSet.stringValue(8058);
            if (!TextUtils.isEmpty(stringValue)) {
                setLevelTag(stringValue);
            }
        } else if (i4 == 8209) {
            setImageMode(valueSet.intValue(8060));
        } else if (i4 == 8140) {
            setInteractionType(valueSet.intValue(8059));
        }
        return (T) c(i4, valueSet, cls);
    }

    @Override // com.bytedance.msdk.c.ux
    public long getAdId() {
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            return ((Long) bridge.call(8246, null, Long.class)).longValue();
        }
        return super.getAdId();
    }

    @Override // com.bytedance.msdk.c.ux
    public long getCreativeId() {
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            return ((Long) bridge.call(8245, null, Long.class)).longValue();
        }
        return super.getCreativeId();
    }

    @Override // com.bytedance.msdk.c.ux
    public Map<String, Object> getMediaExtraInfo() {
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            setMediaExtraInfo((Map) bridge.call(8239, null, Map.class));
        }
        return super.getMediaExtraInfo();
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean hasDestroyed() {
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            return ((Boolean) bridge.call(8120, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.msdk.c.ux
    public void onDestroy() {
        super.onDestroy();
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            bridge.call(8109, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void onPause() {
        super.onPause();
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            bridge.call(8149, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void onResume() {
        super.onResume();
        Bridge bridge = this.f27850c;
        if (bridge != null) {
            bridge.call(8148, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
