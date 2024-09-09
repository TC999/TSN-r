package com.bytedance.sdk.openadsdk.core.c;

import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ck.w {

    /* renamed from: c  reason: collision with root package name */
    private ck.w f32043c;

    public c(ck.w wVar) {
        this.f32043c = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck.w
    public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar) {
        ck.w wVar2 = this.f32043c;
        if (wVar2 != null) {
            wVar2.c(i4, str, wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck.w
    public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final com.bytedance.sdk.openadsdk.core.u.w wVar) {
        if (this.f32043c != null) {
            if (com.bykv.vk.openvk.component.video.c.xv.c.w()) {
                this.f32043c.c(cVar, wVar);
            } else {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32043c.c(cVar, wVar);
                    }
                });
            }
        }
    }
}
