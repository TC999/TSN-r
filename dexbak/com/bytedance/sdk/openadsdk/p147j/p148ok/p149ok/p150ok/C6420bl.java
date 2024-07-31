package com.bytedance.sdk.openadsdk.p147j.p148ok.p149ok.p150ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* renamed from: com.bytedance.sdk.openadsdk.j.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6420bl implements Bridge {

    /* renamed from: a */
    private final TTNativeExpressAd.ExpressVideoAdListener f22585a;

    /* renamed from: ok */
    private ValueSet f22586ok = C5930a.f21279c;

    public C6420bl(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f22585a = expressVideoAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f22585a;
        if (expressVideoAdListener == null) {
            return null;
        }
        switch (i) {
            case 152101:
                expressVideoAdListener.onVideoLoad();
                break;
            case 152102:
                this.f22585a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
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
                this.f22585a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 152107:
                expressVideoAdListener.onVideoAdComplete();
                break;
            case 152108:
                expressVideoAdListener.onClickRetry();
                break;
        }
        m36320ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36320ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22586ok;
    }
}
