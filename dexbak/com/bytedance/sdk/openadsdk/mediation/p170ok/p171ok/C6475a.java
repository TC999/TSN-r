package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6417ok;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6475a extends C6417ok {

    /* renamed from: ok */
    private TTAdNative.DrawFeedAdListener f22838ok;

    public C6475a(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        super(drawFeedAdListener);
        this.f22838ok = drawFeedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6417ok, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 172102) {
            List<Bridge> list = (List) valueSet.objectValue(0, List.class);
            if (list == null) {
                list = new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (Bridge bridge : list) {
                arrayList.add(new C6493r(bridge));
            }
            TTAdNative.DrawFeedAdListener drawFeedAdListener = this.f22838ok;
            if (drawFeedAdListener != null) {
                drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                return null;
            }
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
