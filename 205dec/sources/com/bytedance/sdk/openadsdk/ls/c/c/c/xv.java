package com.bytedance.sdk.openadsdk.ls.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35966c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTNativeExpressAd.ExpressVideoAdListener f35967w;

    public xv(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f35967w = expressVideoAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f35967w;
        if (expressVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 152101:
                expressVideoAdListener.onVideoLoad();
                break;
            case 152102:
                this.f35967w.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 152103:
                expressVideoAdListener.onVideoAdStartPlay();
                break;
            case 152104:
                expressVideoAdListener.onVideoAdPaused();
                break;
            case 152105:
                expressVideoAdListener.onVideoAdContinuePlay();
                break;
            case 152106:
                this.f35967w.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 152107:
                expressVideoAdListener.onVideoAdComplete();
                break;
            case 152108:
                expressVideoAdListener.onClickRetry();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35966c;
    }
}
