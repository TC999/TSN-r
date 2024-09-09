package com.bytedance.sdk.openadsdk.fz.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ys.c.c.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35862c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.DrawFeedAdListener f35863w;

    public c(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.f35863w = drawFeedAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35863w == null) {
            return null;
        }
        switch (i4) {
            case 172101:
                this.f35863w.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 172102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new p(bridge));
                }
                this.f35863w.onDrawFeedAdLoad(arrayList);
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35862c;
    }
}
