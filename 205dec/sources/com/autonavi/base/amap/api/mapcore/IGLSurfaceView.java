package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.col.p0003l.l2;
import com.amap.api.col.p0003l.m2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j4);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i4);

    void setEGLConfigChooser(l2 l2Var);

    void setEGLContextFactory(m2 m2Var);

    void setRenderMode(int i4);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i4);

    void setZOrderOnTop(boolean z3);
}
