package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {
    public static c c(final com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        return new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.w.this;
                if (wVar2 != null) {
                    wVar2.onAdClicked(view, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void w(View view, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.w.this;
                if (wVar2 != null) {
                    wVar2.onAdShow(view, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, String str, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.w.this;
                if (wVar2 != null) {
                    wVar2.onRenderFail(view, str, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.w.this;
                if (wVar2 != null) {
                    wVar2.onRenderSuccess(view, f4, f5);
                }
            }
        };
    }

    public void c(View view, float f4, float f5) {
    }

    public void c(View view, int i4) {
    }

    public void c(View view, String str, int i4) {
    }

    public void w(View view, int i4) {
    }

    public static c c(final com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar) {
        return new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.c.this;
                if (cVar2 != null) {
                    cVar2.onAdClicked(view, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void w(View view, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.c.this;
                if (cVar2 != null) {
                    cVar2.onAdShow(view, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, String str, int i4) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.c.this;
                if (cVar2 != null) {
                    cVar2.onRenderFail(view, str, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar2 = com.bytedance.sdk.openadsdk.ls.c.w.c.c.this;
                if (cVar2 != null) {
                    cVar2.onRenderSuccess(view, f4, f5);
                }
            }
        };
    }
}
