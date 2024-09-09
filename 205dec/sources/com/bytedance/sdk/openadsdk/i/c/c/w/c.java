package com.bytedance.sdk.openadsdk.i.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ys.c.c.k;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35894c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTFeedAd.VideoAdListener f35895w;

    public c(TTFeedAd.VideoAdListener videoAdListener) {
        this.f35895w = videoAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35895w == null) {
            return null;
        }
        switch (i4) {
            case 161101:
                this.f35895w.onVideoLoad(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.f35895w.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.f35895w.onVideoAdPaused(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.f35895w.onVideoAdStartPlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.f35895w.onVideoAdContinuePlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.f35895w.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.f35895w.onVideoAdComplete(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35894c;
    }
}
