package com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6340a implements Bridge {

    /* renamed from: a */
    private final TTAppDownloadListener f22477a;

    /* renamed from: ok */
    private ValueSet f22478ok = C5930a.f21279c;

    public C6340a(TTAppDownloadListener tTAppDownloadListener) {
        this.f22477a = tTAppDownloadListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAppDownloadListener tTAppDownloadListener = this.f22477a;
        if (tTAppDownloadListener == null) {
            return null;
        }
        switch (i) {
            case 221101:
                tTAppDownloadListener.onIdle();
                break;
            case 221102:
                this.f22477a.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221103:
                String str = (String) valueSet.objectValue(3, String.class);
                this.f22477a.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), str);
                break;
            case 221104:
                this.f22477a.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221105:
                this.f22477a.onDownloadFinished(valueSet.longValue(0), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 221106:
                this.f22477a.onInstalled((String) valueSet.objectValue(0, String.class), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m36538ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36538ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22478ok;
    }
}
