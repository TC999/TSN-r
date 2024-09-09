package com.bytedance.sdk.openadsdk.fz.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ys.c.c.ys;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35868c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.NativeExpressAdListener f35869w;

    public ux(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.f35869w = nativeExpressAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35869w == null) {
            return null;
        }
        switch (i4) {
            case 153101:
                this.f35869w.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 153102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new ys(bridge));
                }
                this.f35869w.onNativeExpressAdLoad(arrayList);
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35868c;
    }
}
