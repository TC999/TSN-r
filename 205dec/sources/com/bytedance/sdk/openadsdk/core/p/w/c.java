package com.bytedance.sdk.openadsdk.core.p.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface c {

    /* renamed from: com.bytedance.sdk.openadsdk.core.p.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0501c {
        public static c c(final com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
            return new c() { // from class: com.bytedance.sdk.openadsdk.core.p.w.c.c.1
                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c() {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onIdle();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void w(long j4, long j5, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onDownloadPaused(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void xv(long j4, long j5, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onDownloadFailed(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, long j5, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onDownloadActive(j4, j5, str, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onDownloadFinished(j4, str, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(String str, String str2) {
                    com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = com.bytedance.sdk.openadsdk.ys.w.c.w.this;
                    if (wVar2 != null) {
                        wVar2.onInstalled(str, str2);
                    }
                }
            };
        }
    }

    void c();

    void c(long j4, long j5, String str, String str2);

    void c(long j4, String str, String str2);

    void c(String str, String str2);

    void w(long j4, long j5, String str, String str2);

    void xv(long j4, long j5, String str, String str2);
}
