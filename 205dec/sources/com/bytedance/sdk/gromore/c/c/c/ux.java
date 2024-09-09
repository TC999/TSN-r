package com.bytedance.sdk.gromore.c.c.c;

import android.app.Activity;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.w f31142c;

    public ux(Activity activity, Map<String, Object> map, com.bytedance.msdk.api.sr.c.c.xv xvVar) {
        if (xvVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.f31142c = xvVar.c(activity, map);
        } else {
            this.f31142c = xvVar.c(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv
    public void c() {
        com.bytedance.msdk.api.sr.w wVar = this.f31142c;
        if (wVar != null) {
            wVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv
    public void c(final com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.w wVar = this.f31142c;
        if (wVar != null) {
            wVar.c(new com.bytedance.msdk.api.sr.r() { // from class: com.bytedance.sdk.gromore.c.c.c.ux.1
                @Override // com.bytedance.msdk.api.sr.r
                public void c(int i4, @Nullable String str) {
                    com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(i4, str);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.r
                public void w() {
                    com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.w();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.r
                public void c() {
                    com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c();
                    }
                }
            });
        }
    }

    public ux(com.bytedance.msdk.api.sr.w wVar) {
        this.f31142c = wVar;
    }
}
