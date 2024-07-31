package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6385s implements DislikeInfo {

    /* renamed from: ok */
    private final Bridge f22528ok;

    public C6385s(Bridge bridge) {
        this.f22528ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        List<Bridge> list = (List) this.f22528ok.values().objectValue(243001, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6378kf(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public PersonalizationPrompt getPersonalizationPrompt() {
        return new C6374h((Bridge) this.f22528ok.values().objectValue(243002, Bridge.class));
    }
}
