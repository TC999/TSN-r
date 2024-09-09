package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdNative.DrawFeedAdListener f35891a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.f35891a = drawFeedAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35891a == null) {
            return null;
        }
        switch (i4) {
            case 172101:
                this.f35891a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 172102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new k(bridge));
                }
                this.f35891a.onDrawFeedAdLoad(arrayList);
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
