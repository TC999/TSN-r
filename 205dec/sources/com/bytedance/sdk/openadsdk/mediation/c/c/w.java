package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w extends com.bytedance.sdk.openadsdk.fz.c.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private TTAdNative.DrawFeedAdListener f36110c;

    public w(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        super(drawFeedAdListener);
        this.f36110c = drawFeedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.c.c.c, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 172102) {
            List<Bridge> list = (List) valueSet.objectValue(0, List.class);
            if (list == null) {
                list = new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (Bridge bridge : list) {
                arrayList.add(new k(bridge));
            }
            TTAdNative.DrawFeedAdListener drawFeedAdListener = this.f36110c;
            if (drawFeedAdListener != null) {
                drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                return null;
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
