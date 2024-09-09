package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.ls.c.w.c.xv {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.ls.c.w.c.xv f34165c;

    /* renamed from: w  reason: collision with root package name */
    WeakReference<ExpressOnePointFiveView> f34166w;
    int xv;

    public xv(ExpressOnePointFiveView expressOnePointFiveView, int i4, com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        super(null);
        this.f34165c = xvVar;
        this.f34166w = new WeakReference<>(expressOnePointFiveView);
        this.xv = i4;
    }

    private boolean c() {
        try {
            WeakReference<ExpressOnePointFiveView> weakReference = this.f34166w;
            return this.xv == ((weakReference == null || weakReference.get() == null) ? -1 : this.f34166w.get().getCurrentCompletelyVisibleAdPosition());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onClickRetry() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onClickRetry();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onProgressUpdate(long j4, long j5) {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onProgressUpdate(j4, j5);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoAdComplete() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoAdComplete();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoAdContinuePlay() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoAdContinuePlay();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoAdPaused() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoAdPaused();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoAdStartPlay() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoAdStartPlay();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoError(int i4, int i5) {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoError(i4, i5);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
    public void onVideoLoad() {
        com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar;
        if (!c() || (xvVar = this.f34165c) == null) {
            return;
        }
        xvVar.onVideoLoad();
    }
}
