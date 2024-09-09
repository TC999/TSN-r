package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapGLRenderer.java */
/* renamed from: com.amap.api.col.3l.x9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x9 implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f9444a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f9445b;

    public x9(Context context) {
        this(context, (byte) 0);
    }

    public final IAMapDelegate a() {
        return this.f9444a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getHeight() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final ViewParent getParent() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getRenderMode() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getWidth() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean isEnabled() {
        return this.f9444a != null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean post(Runnable runnable) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean postDelayed(Runnable runnable, long j4) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void requestRender() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setBackgroundColor(int i4) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(l2 l2Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(m2 m2Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderMode(int i4) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setVisibility(int i4) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z3) {
    }

    private x9(Context context, byte b4) {
        this.f9444a = null;
        this.f9445b = false;
        this.f9444a = new p9(this, context);
    }
}
