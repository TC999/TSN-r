package com.amap.api.col.p0463l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.p048ae.gmap.GLMapRender;

/* renamed from: com.amap.api.col.3l.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapGLSurfaceView extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a */
    private IAMapDelegate f4724a;

    /* renamed from: b */
    private GLMapRender f4725b;

    /* renamed from: c */
    protected boolean f4726c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapGLSurfaceView.java */
    /* renamed from: com.amap.api.col.3l.n$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1860a implements Runnable {
        RunnableC1860a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AMapGLSurfaceView.this.f4725b != null) {
                try {
                    AMapGLSurfaceView.this.f4725b.onSurfaceDestory();
                } catch (Throwable th) {
                    th.printStackTrace();
                    C1732a3.m55741D(th);
                }
            }
        }
    }

    public AMapGLSurfaceView(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    /* renamed from: b */
    public final IAMapDelegate m54453b() {
        return this.f4724a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f4725b;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onDetachedFromWindow() {
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f4725b;
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
        LinkLogManager.m55489e(str, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f4725b;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C1732a3.m55741D(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f4725b.mSurfacedestoryed);
        if (!this.f4725b.mSurfacedestoryed) {
            queueEvent(new RunnableC1860a());
            int i = 0;
            while (!this.f4725b.mSurfacedestoryed) {
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
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f4724a.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                GLMapRender gLMapRender = this.f4725b;
                if (gLMapRender != null) {
                    gLMapRender.renderPause();
                    this.f4726c = false;
                }
            } else if (i != 0) {
            } else {
                GLMapRender gLMapRender2 = this.f4725b;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(GLMapSurfaceConfigChooser gLMapSurfaceConfigChooser) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) gLMapSurfaceConfigChooser);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(GlMapSurfaceEglContextFactory glMapSurfaceEglContextFactory) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) glMapSurfaceEglContextFactory);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f4725b = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    private AMapGLSurfaceView(Context context, boolean z, byte b) {
        super(context, null);
        this.f4724a = null;
        this.f4725b = null;
        this.f4726c = false;
        GlesUtility.m54450a(this, 5, 6, 5);
        this.f4724a = new AMapDelegateImp(this, context, z);
    }
}
