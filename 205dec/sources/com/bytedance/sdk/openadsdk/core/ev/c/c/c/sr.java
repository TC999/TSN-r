package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private me f33406c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33407w;

    public sr(com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar, me meVar) {
        this.f33406c = meVar;
        this.f33407w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        if (TTLiveCommerceHelper.getInstance().canOpenGoodsDetailPage(this.f33406c) == 1) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar = this.f33407w;
        return cVar != null && cVar.c(map);
    }
}
