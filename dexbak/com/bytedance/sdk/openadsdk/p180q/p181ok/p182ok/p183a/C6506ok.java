package com.bytedance.sdk.openadsdk.p180q.p181ok.p182ok.p183a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6383r;

/* renamed from: com.bytedance.sdk.openadsdk.q.ok.ok.a.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6506ok implements Bridge {

    /* renamed from: a */
    private final TTFeedAd.VideoAdListener f22884a;

    /* renamed from: ok */
    private ValueSet f22885ok = C5930a.f21279c;

    public C6506ok(TTFeedAd.VideoAdListener videoAdListener) {
        this.f22884a = videoAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22884a == null) {
            return null;
        }
        switch (i) {
            case 161101:
                this.f22884a.onVideoLoad(new C6383r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.f22884a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.f22884a.onVideoAdPaused(new C6383r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.f22884a.onVideoAdStartPlay(new C6383r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.f22884a.onVideoAdContinuePlay(new C6383r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.f22884a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.f22884a.onVideoAdComplete(new C6383r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m36189ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36189ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22885ok;
    }
}
