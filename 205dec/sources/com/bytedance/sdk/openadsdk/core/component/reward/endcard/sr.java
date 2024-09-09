package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import com.bytedance.sdk.openadsdk.core.ia.ux;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class sr extends com.bytedance.sdk.openadsdk.core.s.sr {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ux> f32339c;

    /* renamed from: w  reason: collision with root package name */
    private final me f32340w;
    private final String xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(me meVar, String str, ux uxVar) {
        this.f32340w = meVar;
        this.xv = str;
        this.f32339c = new WeakReference<>(uxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.bk.c
    public void c() {
        WeakReference<ux> weakReference = this.f32339c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f32339c.get().c();
    }

    @Override // com.bytedance.sdk.openadsdk.bk.c
    public void c(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f32340w, this.xv, "playable_track", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.bk.c
    public void c(int i4, String str) {
        WeakReference<ux> weakReference = this.f32339c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f32339c.get().c(i4, str);
    }
}
