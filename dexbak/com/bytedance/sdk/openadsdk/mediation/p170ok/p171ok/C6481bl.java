package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6413a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6481bl extends C6413a {

    /* renamed from: ok */
    private TTAdNative.FeedAdListener f22849ok;

    public C6481bl(TTAdNative.FeedAdListener feedAdListener) {
        super(feedAdListener);
        this.f22849ok = feedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6413a, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 164102) {
            List<Bridge> list = (List) valueSet.objectValue(0, List.class);
            if (list == null) {
                list = new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (Bridge bridge : list) {
                arrayList.add(new C6483j(bridge));
            }
            TTAdNative.FeedAdListener feedAdListener = this.f22849ok;
            if (feedAdListener != null) {
                feedAdListener.onFeedAdLoad(arrayList);
                return null;
            }
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
