package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.dislike.c.sr;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.ys.w.w.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.dislike.c.xv f33127c;

    /* renamed from: w  reason: collision with root package name */
    private static sr f33128w;

    public static void c() {
        if (f33128w == null) {
            f33128w = new sr() { // from class: com.bytedance.sdk.openadsdk.core.dislike.c.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.c.sr
                public int c(Context context, float f4) {
                    return xk.ux(context, f4);
                }
            };
        }
        if (f33127c == null) {
            f33127c = new com.bytedance.sdk.openadsdk.core.dislike.c.xv() { // from class: com.bytedance.sdk.openadsdk.core.dislike.c.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.c.xv
                public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, f fVar) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(wVar, fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.c.xv
                public void c(Context context, com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, String str) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(wVar.xv(), wVar.sr(), wVar.r(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.c.c.c(f33127c, f33128w);
    }
}
