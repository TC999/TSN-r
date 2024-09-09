package com.mbridge.msdk.widget.custom.baseview;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41287a;

    /* renamed from: b  reason: collision with root package name */
    private int f41288b;

    public e(MBCircularProgressButton mBCircularProgressButton) {
        this.f41287a = mBCircularProgressButton.isEnabled();
        this.f41288b = mBCircularProgressButton.getProgress();
    }

    public final void a(MBCircularProgressButton mBCircularProgressButton) {
        this.f41288b = mBCircularProgressButton.getProgress();
    }

    public final void b(MBCircularProgressButton mBCircularProgressButton) {
        if (mBCircularProgressButton.getProgress() != this.f41288b) {
            mBCircularProgressButton.setProgress(mBCircularProgressButton.getProgress());
        } else if (mBCircularProgressButton.isEnabled() != this.f41287a) {
            mBCircularProgressButton.setEnabled(mBCircularProgressButton.isEnabled());
        }
    }
}
