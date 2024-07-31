package com.mbridge.msdk.widget.custom.baseview;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mbridge.msdk.widget.custom.baseview.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class StateManager {

    /* renamed from: a */
    private boolean f32600a;

    /* renamed from: b */
    private int f32601b;

    public StateManager(MBCircularProgressButton mBCircularProgressButton) {
        this.f32600a = mBCircularProgressButton.isEnabled();
        this.f32601b = mBCircularProgressButton.getProgress();
    }

    /* renamed from: a */
    public final void m20516a(MBCircularProgressButton mBCircularProgressButton) {
        this.f32601b = mBCircularProgressButton.getProgress();
    }

    /* renamed from: b */
    public final void m20515b(MBCircularProgressButton mBCircularProgressButton) {
        if (mBCircularProgressButton.getProgress() != this.f32601b) {
            mBCircularProgressButton.setProgress(mBCircularProgressButton.getProgress());
        } else if (mBCircularProgressButton.isEnabled() != this.f32600a) {
            mBCircularProgressButton.setEnabled(mBCircularProgressButton.isEnabled());
        }
    }
}
