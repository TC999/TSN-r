package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.p048ae.gmap.GLMapRender;

/* renamed from: com.amap.api.col.3l.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapGLTextureView extends GLTextureView implements IGLSurfaceView {

    /* renamed from: m */
    private IAMapDelegate f4763m;

    /* renamed from: n */
    private GLMapRender f4764n;

    /* renamed from: o */
    protected boolean f4765o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapGLTextureView.java */
    /* renamed from: com.amap.api.col.3l.o$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1866a implements Runnable {
        RunnableC1866a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AMapGLTextureView.this.f4764n != null) {
                    AMapGLTextureView.this.f4764n.onSurfaceDestory();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C1732a3.m55741D(th);
            }
        }
    }

    public AMapGLTextureView(Context context, boolean z) {
        super(context);
        this.f4763m = null;
        this.f4764n = null;
        this.f4765o = false;
        if (Build.VERSION.SDK_INT >= 34) {
            GlesUtility.m54450a(this, 8, 8, 8);
        } else {
            GlesUtility.m54450a(this, 5, 6, 5);
        }
        this.f4763m = new AMapDelegateImp(this, context, z);
    }

    @Override // com.amap.api.col.p0463l.GLTextureView
    /* renamed from: f */
    public final void mo53486f() {
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f4764n.mSurfacedestoryed);
        if (!this.f4764n.mSurfacedestoryed) {
            queueEvent(new RunnableC1866a());
            int i = 0;
            while (!this.f4764n.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.mo53486f();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.GLTextureView
    /* renamed from: h */
    public final void mo53484h() {
        super.mo53484h();
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLTextureView onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.GLTextureView, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f4764n;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mo53484h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.GLTextureView, android.view.View
    public final void onDetachedFromWindow() {
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        mo53486f();
        try {
            GLMapRender gLMapRender = this.f4764n;
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
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            mo53486f();
            try {
                GLMapRender gLMapRender = this.f4764n;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0463l.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f4763m.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i);
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i != 8 && i != 4) {
                if (i != 0 || (gLMapRender = this.f4764n) == null) {
                    return;
                }
                gLMapRender.renderResume();
                return;
            }
            GLMapRender gLMapRender2 = this.f4764n;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f4765o = false;
            }
            requestRender();
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: r */
    public final IAMapDelegate m54418r() {
        return this.f4763m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(GLMapSurfaceConfigChooser gLMapSurfaceConfigChooser) {
        super.m53489c(gLMapSurfaceConfigChooser);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(GlMapSurfaceEglContextFactory glMapSurfaceEglContextFactory) {
        super.m53488d(glMapSurfaceEglContextFactory);
    }

    @Override // com.amap.api.col.p0463l.GLTextureView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f4764n = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z) {
    }
}
