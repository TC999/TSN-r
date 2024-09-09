package com.bytedance.sdk.openadsdk.q.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.bl.ok.ok.r;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTFeedAd.VideoAdListener f36260a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(TTFeedAd.VideoAdListener videoAdListener) {
        this.f36260a = videoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36260a == null) {
            return null;
        }
        switch (i4) {
            case 161101:
                this.f36260a.onVideoLoad(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.f36260a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.f36260a.onVideoAdPaused(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.f36260a.onVideoAdStartPlay(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.f36260a.onVideoAdContinuePlay(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.f36260a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.f36260a.onVideoAdComplete(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
