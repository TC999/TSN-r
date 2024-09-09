package com.bytedance.sdk.openadsdk.core.eq;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.core.q.c.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.component.ux.k kVar);

        void w();
    }

    public static void c(com.bytedance.sdk.openadsdk.a.w wVar, int i4, int i5, final c cVar, String str) {
        com.bytedance.sdk.component.utils.a.f("splashLoadAd", " getImageBytes url " + wVar);
        com.bytedance.sdk.openadsdk.core.q.ux.c().xv().c(wVar, new c.w() { // from class: com.bytedance.sdk.openadsdk.core.eq.fp.1
            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c(com.bytedance.sdk.component.ux.k kVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar2) {
                c cVar2;
                if (wVar2.sr() && (cVar2 = c.this) != null) {
                    cVar2.c(wVar2, kVar);
                    return;
                }
                c cVar3 = c.this;
                if (cVar3 != null) {
                    cVar3.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c(int i6, String str2, Throwable th) {
                c cVar2 = c.this;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c() {
                c cVar2 = c.this;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }
        }, i4, i5, str);
    }

    public static void c(com.bytedance.sdk.openadsdk.a.w wVar, int i4, int i5, final c cVar, String str, int i6, com.bytedance.sdk.component.ux.t tVar, boolean z3) {
        com.bytedance.sdk.component.utils.a.f("splashLoadAd", " getImageBytes url " + wVar);
        com.bytedance.sdk.openadsdk.core.q.ux.c().xv().c(wVar, new c.w() { // from class: com.bytedance.sdk.openadsdk.core.eq.fp.2
            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c(com.bytedance.sdk.component.ux.k kVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar2) {
                c cVar2;
                if (wVar2.sr() && (cVar2 = c.this) != null) {
                    cVar2.c(wVar2, kVar);
                    return;
                }
                c cVar3 = c.this;
                if (cVar3 != null) {
                    cVar3.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c(int i7, String str2, Throwable th) {
                c cVar2 = c.this;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.c.c.w
            public void c() {
                c cVar2 = c.this;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }
        }, i4, i5, str, i6, tVar, z3);
    }

    public static Drawable c(byte[] bArr, int i4) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}
