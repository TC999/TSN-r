package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr implements DislikeInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36417c;

    public sr(Bridge bridge) {
        this.f36417c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        List<Bridge> list = (List) this.f36417c.values().objectValue(243001, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new f(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public PersonalizationPrompt getPersonalizationPrompt() {
        return new r((Bridge) this.f36417c.values().objectValue(243002, Bridge.class));
    }
}
