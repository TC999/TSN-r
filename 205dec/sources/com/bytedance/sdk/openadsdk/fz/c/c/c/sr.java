package com.bytedance.sdk.openadsdk.fz.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ys.c.c.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35866c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.NativeAdListener f35867w;

    public sr(TTAdNative.NativeAdListener nativeAdListener) {
        this.f35867w = nativeAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35867w == null) {
            return null;
        }
        switch (i4) {
            case 143101:
                this.f35867w.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 143102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new t(bridge));
                }
                this.f35867w.onNativeAdLoad(arrayList);
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35866c;
    }
}
