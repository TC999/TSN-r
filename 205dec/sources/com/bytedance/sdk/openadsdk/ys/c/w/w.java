package com.bytedance.sdk.openadsdk.ys.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36438c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAppDownloadListener f36439w;

    public w(TTAppDownloadListener tTAppDownloadListener) {
        this.f36439w = tTAppDownloadListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAppDownloadListener tTAppDownloadListener = this.f36439w;
        if (tTAppDownloadListener == null) {
            return null;
        }
        switch (i4) {
            case 221101:
                tTAppDownloadListener.onIdle();
                break;
            case 221102:
                this.f36439w.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221103:
                String str = (String) valueSet.objectValue(3, String.class);
                this.f36439w.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), str);
                break;
            case 221104:
                this.f36439w.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221105:
                this.f36439w.onDownloadFinished(valueSet.longValue(0), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 221106:
                this.f36439w.onInstalled((String) valueSet.objectValue(0, String.class), (String) valueSet.objectValue(1, String.class));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36438c;
    }
}
