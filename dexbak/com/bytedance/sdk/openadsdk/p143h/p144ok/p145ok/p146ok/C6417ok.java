package com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6377k;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6417ok implements Bridge {

    /* renamed from: a */
    private final TTAdNative.DrawFeedAdListener f22579a;

    /* renamed from: ok */
    private ValueSet f22580ok = C5930a.f21279c;

    public C6417ok(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.f22579a = drawFeedAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22579a == null) {
            return null;
        }
        switch (i) {
            case 172101:
                this.f22579a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 172102:
                List<Bridge> list = (List) valueSet.objectValue(0, List.class);
                if (list == null) {
                    list = new ArrayList(0);
                }
                ArrayList arrayList = new ArrayList();
                for (Bridge bridge : list) {
                    arrayList.add(new C6377k(bridge));
                }
                this.f22579a.onDrawFeedAdLoad(arrayList);
                break;
        }
        m36323ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36323ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22580ok;
    }
}
