package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements SurfaceHolder.Callback {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<SurfaceHolder.Callback> f24932c;

    public xv(SurfaceHolder.Callback callback) {
        this.f24932c = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback c() {
        return this.f24932c.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        SurfaceHolder.Callback callback = this.f24932c.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i4, i5, i6);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f24932c.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f24932c.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
