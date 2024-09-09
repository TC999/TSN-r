package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapGLTextureView.java */
/* renamed from: com.amap.api.col.3l.o  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o extends y implements IGLSurfaceView {

    /* renamed from: m  reason: collision with root package name */
    private IAMapDelegate f8433m;

    /* renamed from: n  reason: collision with root package name */
    private GLMapRender f8434n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f8435o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AMapGLTextureView.java */
    /* renamed from: com.amap.api.col.3l.o$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (o.this.f8434n != null) {
                    o.this.f8434n.onSurfaceDestory();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
        }
    }

    public o(Context context, boolean z3) {
        super(context);
        this.f8433m = null;
        this.f8434n = null;
        this.f8435o = false;
        if (Build.VERSION.SDK_INT >= 34) {
            n2.a(this, 8, 8, 8);
        } else {
            n2.a(this, 5, 6, 5);
        }
        this.f8433m = new p9(this, context, z3);
    }

    @Override // com.amap.api.col.p0003l.y
    public final void f() {
        String str = b3.f7206c;
        c3.e(str, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f8434n.mSurfacedestoryed);
        if (!this.f8434n.mSurfacedestoryed) {
            queueEvent(new a());
            int i4 = 0;
            while (!this.f8434n.mSurfacedestoryed) {
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
        super.f();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.y
    public final void h() {
        super.h();
        c3.e(b3.f7206c, "AMapGLTextureView onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.y, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c3.e(b3.f7206c, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f8434n;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003l.y, android.view.View
    public final void onDetachedFromWindow() {
        String str = b3.f7206c;
        c3.e(str, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        f();
        try {
            GLMapRender gLMapRender = this.f8434n;
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
        c3.e(str, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            f();
            try {
                GLMapRender gLMapRender = this.f8434n;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c3.e(b3.f7206c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f8433m.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i4) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i4);
        c3.e(b3.f7206c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i4)));
        try {
            if (i4 != 8 && i4 != 4) {
                if (i4 != 0 || (gLMapRender = this.f8434n) == null) {
                    return;
                }
                gLMapRender.renderResume();
                return;
            }
            GLMapRender gLMapRender2 = this.f8434n;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f8435o = false;
            }
            requestRender();
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    public final IAMapDelegate r() {
        return this.f8433m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(l2 l2Var) {
        super.c(l2Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(m2 m2Var) {
        super.d(m2Var);
    }

    @Override // com.amap.api.col.p0003l.y, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f8434n = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z3) {
    }
}
