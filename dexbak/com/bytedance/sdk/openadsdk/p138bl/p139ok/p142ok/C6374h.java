package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6374h implements PersonalizationPrompt {

    /* renamed from: ok */
    private final Bridge f22515ok;

    public C6374h(Bridge bridge) {
        this.f22515ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.f22515ok.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.f22515ok.values().objectValue(242001, String.class);
    }
}
