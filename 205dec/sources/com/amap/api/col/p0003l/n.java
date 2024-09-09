package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapGLSurfaceView.java */
/* renamed from: com.amap.api.col.3l.n  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f8359a;

    /* renamed from: b  reason: collision with root package name */
    private GLMapRender f8360b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f8361c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AMapGLSurfaceView.java */
    /* renamed from: com.amap.api.col.3l.n$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.f8360b != null) {
                try {
                    n.this.f8360b.onSurfaceDestory();
                } catch (Throwable th) {
                    th.printStackTrace();
                    a3.D(th);
                }
            }
        }
    }

    public n(Context context, boolean z3) {
        this(context, z3, (byte) 0);
    }

    public final IAMapDelegate b() {
        return this.f8359a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c3.e(b3.f7206c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f8360b;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onDetachedFromWindow() {
        String str = b3.f7206c;
        c3.e(str, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f8360b;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        String str = b3.f7206c;
        c3.e(str, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f8360b;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        String str = b3.f7206c;
        c3.e(str, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f8360b.mSurfacedestoryed);
        if (!this.f8360b.mSurfacedestoryed) {
            queueEvent(new a());
            int i4 = 0;
            while (!this.f8360b.mSurfacedestoryed) {
                int i5 = i4 + 1;
                if (i4 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i4 = i5;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        c3.e(b3.f7206c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f8359a.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        c3.e(b3.f7206c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i4)));
        try {
            if (i4 == 8 || i4 == 4) {
                GLMapRender gLMapRender = this.f8360b;
                if (gLMapRender != null) {
                    gLMapRender.renderPause();
                    this.f8361c = false;
                }
            } else if (i4 != 0) {
            } else {
                GLMapRender gLMapRender2 = this.f8360b;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(l2 l2Var) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) l2Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(m2 m2Var) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) m2Var);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f8360b = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    private n(Context context, boolean z3, byte b4) {
        super(context, null);
        this.f8359a = null;
        this.f8360b = null;
        this.f8361c = false;
        n2.a(this, 5, 6, 5);
        this.f8359a = new p9(this, context, z3);
    }
}
