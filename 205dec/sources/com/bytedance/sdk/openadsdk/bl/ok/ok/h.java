package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h implements PersonalizationPrompt {
    private final Bridge ok;

    public h(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.ok.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.ok.values().objectValue(242001, String.class);
    }
}
