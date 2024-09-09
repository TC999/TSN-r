package com.bytedance.sdk.openadsdk.core.q.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.ux.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.q.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0505c implements w {
        C0505c() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
        public void c() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
        public void c(int i4, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
        public void c(k kVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c();

        void c(int i4, String str, Throwable th);

        void c(k kVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar);
    }

    public static C0505c w() {
        return new C0505c();
    }

    protected void c() {
    }

    public void c(com.bytedance.sdk.openadsdk.a.w wVar, w wVar2, int i4, int i5, String str) {
        c(wVar, wVar2, i4, i5, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void c(com.bytedance.sdk.openadsdk.a.w wVar, w wVar2, int i4, int i5, String str, int i6, t tVar, boolean z3) {
        c(wVar, wVar2, i4, i5, ImageView.ScaleType.CENTER_INSIDE, str, i6, tVar, z3);
    }

    public void c(com.bytedance.sdk.openadsdk.a.w wVar, final w wVar2, int i4, int i5, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.r.w.c(wVar.f31365c).w(wVar.f31366w).c(i4).w(i5).xv(str).c(Bitmap.Config.RGB_565).c(scaleType).w(!TextUtils.isEmpty(str)).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.q.c.c.1
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k kVar) {
                c.this.c(kVar, wVar2);
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i6, String str2, Throwable th) {
                c.this.c(i6, str2, th, wVar2);
            }
        });
        c();
    }

    public void c(com.bytedance.sdk.openadsdk.a.w wVar, final w wVar2, int i4, int i5, ImageView.ScaleType scaleType, String str, int i6, t tVar, boolean z3) {
        com.bytedance.sdk.openadsdk.r.w.c(wVar.f31365c).w(wVar.f31366w).c(i4).w(i5).xv(str).c(Bitmap.Config.RGB_565).c(scaleType).c(tVar).c(z3).w(!TextUtils.isEmpty(str)).c(new fp() { // from class: com.bytedance.sdk.openadsdk.core.q.c.c.2
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k kVar) {
                c.this.c(kVar, wVar2);
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i7, String str2, Throwable th) {
                c.this.c(i7, str2, th, wVar2);
            }
        }, i6);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(k kVar, w wVar) {
        if (wVar != null) {
            Object xv = kVar.xv();
            int c4 = c(kVar);
            if (xv instanceof byte[]) {
                wVar.c(kVar, new com.bytedance.sdk.openadsdk.core.q.c.w((byte[]) xv, c4));
            } else if (xv instanceof Bitmap) {
                wVar.c(kVar, new com.bytedance.sdk.openadsdk.core.q.c.w((Bitmap) xv, c4));
            } else {
                wVar.c(0, "not bitmap or gif result!", null);
            }
        }
        if (wVar != null) {
            wVar.c();
        }
    }

    private int c(k kVar) {
        Map<String, String> r3 = kVar.r();
        if (r3 != null) {
            try {
                String str = r3.get(CampaignEx.JSON_KEY_IMAGE_SIZE);
                if (str == null || !(str instanceof String)) {
                    return 0;
                }
                return Integer.parseInt(str);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    protected void c(int i4, String str, Throwable th, w wVar) {
        if (wVar != null) {
            wVar.c(i4, str, th);
        }
    }
}
