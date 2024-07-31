package com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6384rh;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.ok.ok.ok.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6418s implements Bridge {

    /* renamed from: a */
    private final TTAdNative.NativeAdListener f22581a;

    /* renamed from: ok */
    private ValueSet f22582ok = C5930a.f21279c;

    public C6418s(TTAdNative.NativeAdListener nativeAdListener) {
        this.f22581a = nativeAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22581a == null) {
            return null;
        }
        switch (i) {
            case 143101:
                this.f22581a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 143102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new C6384rh(bridge));
                }
                this.f22581a.onNativeAdLoad(arrayList);
                break;
        }
        m36322ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36322ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22582ok;
    }
}
