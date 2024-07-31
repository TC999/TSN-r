package com.p201hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(16)
/* renamed from: com.hw.videoprocessor.util.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class OutputSurface implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: n */
    private static final int f24142n = 4;

    /* renamed from: o */
    private static final int f24143o = 12440;

    /* renamed from: a */
    private EGL10 f24144a;

    /* renamed from: b */
    private EGLDisplay f24145b;

    /* renamed from: c */
    private EGLContext f24146c;

    /* renamed from: d */
    private EGLSurface f24147d;

    /* renamed from: e */
    private SurfaceTexture f24148e;

    /* renamed from: f */
    private Surface f24149f;

    /* renamed from: g */
    private final Object f24150g;

    /* renamed from: h */
    private boolean f24151h;

    /* renamed from: i */
    private TextureRenderer f24152i;

    /* renamed from: j */
    private int f24153j;

    /* renamed from: k */
    private int f24154k;

    /* renamed from: l */
    private int f24155l;

    /* renamed from: m */
    private ByteBuffer f24156m;

    public OutputSurface(int i, int i2, int i3) {
        this.f24145b = null;
        this.f24146c = null;
        this.f24147d = null;
        this.f24150g = new Object();
        this.f24155l = 0;
        if (i > 0 && i2 > 0) {
            this.f24153j = i;
            this.f24154k = i2;
            this.f24155l = i3;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
            this.f24156m = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            m34865e(i, i2);
            m34862h();
            m34860j();
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    private void m34867c(String str) {
        if (this.f24144a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    /* renamed from: e */
    private void m34865e(int i, int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f24144a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f24145b = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (!this.f24144a.eglInitialize(eglGetDisplay, null)) {
                this.f24145b = null;
                throw new RuntimeException("unable to initialize EGL10");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.f24144a.eglChooseConfig(this.f24145b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.f24146c = this.f24144a.eglCreateContext(this.f24145b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{f24143o, 2, 12344});
                m34867c("eglCreateContext");
                if (this.f24146c != null) {
                    this.f24147d = this.f24144a.eglCreatePbufferSurface(this.f24145b, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
                    m34867c("eglCreatePbufferSurface");
                    if (this.f24147d == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    /* renamed from: j */
    private void m34860j() {
        TextureRenderer textureRenderer = new TextureRenderer(this.f24155l);
        this.f24152i = textureRenderer;
        textureRenderer.m34851g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f24152i.m34853e());
        this.f24148e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f24149f = new Surface(this.f24148e);
    }

    /* renamed from: a */
    public void m34869a() {
        synchronized (this.f24150g) {
            while (!this.f24151h) {
                try {
                    this.f24150g.wait(5000L);
                    if (!this.f24151h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.f24151h = false;
        }
        this.f24152i.m34856b("before updateTexImage");
        this.f24148e.updateTexImage();
    }

    /* renamed from: b */
    public void m34868b(String str) {
        this.f24152i.m34857a(str);
    }

    /* renamed from: d */
    public void m34866d(boolean z) {
        this.f24152i.m34854d(this.f24148e, z);
    }

    /* renamed from: f */
    public ByteBuffer m34864f() {
        this.f24156m.rewind();
        GLES20.glReadPixels(0, 0, this.f24153j, this.f24154k, 6408, 5121, this.f24156m);
        return this.f24156m;
    }

    /* renamed from: g */
    public Surface m34863g() {
        return this.f24149f;
    }

    /* renamed from: h */
    public void m34862h() {
        if (this.f24144a != null) {
            m34867c("before makeCurrent");
            EGL10 egl10 = this.f24144a;
            EGLDisplay eGLDisplay = this.f24145b;
            EGLSurface eGLSurface = this.f24147d;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f24146c)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    /* renamed from: i */
    public void m34861i() {
        EGL10 egl10 = this.f24144a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f24146c)) {
                EGL10 egl102 = this.f24144a;
                EGLDisplay eGLDisplay = this.f24145b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f24144a.eglDestroySurface(this.f24145b, this.f24147d);
            this.f24144a.eglDestroyContext(this.f24145b, this.f24146c);
        }
        this.f24149f.release();
        this.f24145b = null;
        this.f24146c = null;
        this.f24147d = null;
        this.f24144a = null;
        this.f24152i = null;
        this.f24149f = null;
        this.f24148e = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f24150g) {
            if (!this.f24151h) {
                this.f24151h = true;
                this.f24150g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    public OutputSurface() {
        this.f24145b = null;
        this.f24146c = null;
        this.f24147d = null;
        this.f24150g = new Object();
        this.f24155l = 0;
        m34860j();
    }
}
