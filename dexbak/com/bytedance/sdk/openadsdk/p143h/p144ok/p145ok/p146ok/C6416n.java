package com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6386t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.ok.ok.ok.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6416n implements Bridge {

    /* renamed from: a */
    private final TTAdNative.NativeExpressAdListener f22577a;

    /* renamed from: ok */
    private ValueSet f22578ok = C5930a.f21279c;

    public C6416n(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.f22577a = nativeExpressAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22577a == null) {
            return null;
        }
        switch (i) {
            case 153101:
                this.f22577a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 153102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new C6386t(bridge));
                }
                this.f22577a.onNativeExpressAdLoad(arrayList);
                break;
        }
        m36324ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36324ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22578ok;
    }
}
