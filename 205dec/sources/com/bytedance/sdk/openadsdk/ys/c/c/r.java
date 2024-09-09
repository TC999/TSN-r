package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r implements PersonalizationPrompt {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36416c;

    public r(Bridge bridge) {
        this.f36416c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.f36416c.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.f36416c.values().objectValue(242001, String.class);
    }
}
