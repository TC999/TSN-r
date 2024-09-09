package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdNative.FeedAdListener f35887a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTAdNative.FeedAdListener feedAdListener) {
        this.f35887a = feedAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35887a == null) {
            return null;
        }
        switch (i4) {
            case 164101:
                this.f35887a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 164102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new r(bridge));
                }
                this.f35887a.onFeedAdLoad(arrayList);
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
