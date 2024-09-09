package com.bytedance.sdk.openadsdk.bl.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAppDownloadListener f31633a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTAppDownloadListener tTAppDownloadListener) {
        this.f31633a = tTAppDownloadListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAppDownloadListener tTAppDownloadListener = this.f31633a;
        if (tTAppDownloadListener == null) {
            return null;
        }
        switch (i4) {
            case 221101:
                tTAppDownloadListener.onIdle();
                break;
            case 221102:
                this.f31633a.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221103:
                String str = (String) valueSet.objectValue(3, String.class);
                this.f31633a.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), str);
                break;
            case 221104:
                this.f31633a.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221105:
                this.f31633a.onDownloadFinished(valueSet.longValue(0), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 221106:
                this.f31633a.onInstalled((String) valueSet.objectValue(0, String.class), (String) valueSet.objectValue(1, String.class));
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
