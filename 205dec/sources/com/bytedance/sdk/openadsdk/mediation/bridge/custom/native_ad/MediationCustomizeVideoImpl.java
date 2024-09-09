package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationCustomizeVideoImpl implements Bridge, IMediationCustomizeVideo {

    /* renamed from: c  reason: collision with root package name */
    private TTFeedAd.CustomizeVideo f36085c;

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.f36085c = customizeVideo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8165) {
            reportVideoStart();
            return null;
        } else if (i4 == 8168) {
            reportVideoFinish();
            return null;
        } else if (i4 == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        } else if (i4 == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        } else if (i4 == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        } else if (i4 == 8170) {
            reportVideoAutoStart();
            return null;
        } else if (i4 == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        } else if (i4 == 8172) {
            reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        } else {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j4) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j4) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j4, int i4, int i5) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j4, i4, i5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j4) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i4, int i5) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f36085c;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i4, i5);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
