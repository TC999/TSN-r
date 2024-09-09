package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl extends com.bytedance.sdk.openadsdk.h.ok.ok.ok.a {
    private TTAdNative.FeedAdListener ok;

    public bl(TTAdNative.FeedAdListener feedAdListener) {
        super(feedAdListener);
        this.ok = feedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.h.ok.ok.ok.a, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 164102) {
            List<Bridge> list = (List) valueSet.objectValue(0, List.class);
            if (list == null) {
                list = new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (Bridge bridge : list) {
                arrayList.add(new j(bridge));
            }
            TTAdNative.FeedAdListener feedAdListener = this.ok;
            if (feedAdListener != null) {
                feedAdListener.onFeedAdLoad(arrayList);
                return null;
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
