package com.bytedance.sdk.openadsdk.j.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTNativeExpressAd.ExpressVideoAdListener f35913a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public bl(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f35913a = expressVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f35913a;
        if (expressVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 152101:
                expressVideoAdListener.onVideoLoad();
                break;
            case 152102:
                this.f35913a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
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
                this.f35913a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 152107:
                expressVideoAdListener.onVideoAdComplete();
                break;
            case 152108:
                expressVideoAdListener.onClickRetry();
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
