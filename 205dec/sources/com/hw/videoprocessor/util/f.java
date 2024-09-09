package com.hw.videoprocessor.util;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: OutputSurface.java */
@TargetApi(16)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: n  reason: collision with root package name */
    private static final int f37624n = 4;

    /* renamed from: o  reason: collision with root package name */
    private static final int f37625o = 12440;

    /* renamed from: a  reason: collision with root package name */
    private EGL10 f37626a;

    /* renamed from: b  reason: collision with root package name */
    private EGLDisplay f37627b;

    /* renamed from: c  reason: collision with root package name */
    private EGLContext f37628c;

    /* renamed from: d  reason: collision with root package name */
    private EGLSurface f37629d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f37630e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f37631f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f37632g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f37633h;

    /* renamed from: i  reason: collision with root package name */
    private h f37634i;

    /* renamed from: j  reason: collision with root package name */
    private int f37635j;

    /* renamed from: k  reason: collision with root package name */
    private int f37636k;

    /* renamed from: l  reason: collision with root package name */
    private int f37637l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f37638m;

    public f(int i4, int i5, int i6) {
        this.f37627b = null;
        this.f37628c = null;
        this.f37629d = null;
        this.f37632g = new Object();
        this.f37637l = 0;
        if (i4 > 0 && i5 > 0) {
            this.f37635j = i4;
            this.f37636k = i5;
            this.f37637l = i6;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i4 * i5 * 4);
            this.f37638m = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            e(i4, i5);
            h();
            j();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void c(String str) {
        if (this.f37626a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void e(int i4, int i5) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f37626a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f37627b = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (!this.f37626a.eglInitialize(eglGetDisplay, null)) {
                this.f37627b = null;
                throw new RuntimeException("unable to initialize EGL10");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.f37626a.eglChooseConfig(this.f37627b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.f37628c = this.f37626a.eglCreateContext(this.f37627b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                c("eglCreateContext");
                if (this.f37628c != null) {
                    this.f37629d = this.f37626a.eglCreatePbufferSurface(this.f37627b, eGLConfigArr[0], new int[]{12375, i4, 12374, i5, 12344});
                    c("eglCreatePbufferSurface");
                    if (this.f37629d == null) {
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

    private void j() {
        h hVar = new h(this.f37637l);
        this.f37634i = hVar;
        hVar.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f37634i.e());
        this.f37630e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f37631f = new Surface(this.f37630e);
    }

    public void a() {
        synchronized (this.f37632g) {
            while (!this.f37633h) {
                try {
                    this.f37632g.wait(5000L);
                    if (!this.f37633h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e4) {
                    throw new RuntimeException(e4);
                }
            }
            this.f37633h = false;
        }
        this.f37634i.b("before updateTexImage");
        this.f37630e.updateTexImage();
    }

    public void b(String str) {
        this.f37634i.a(str);
    }

    public void d(boolean z3) {
        this.f37634i.d(this.f37630e, z3);
    }

    public ByteBuffer f() {
        this.f37638m.rewind();
        GLES20.glReadPixels(0, 0, this.f37635j, this.f37636k, 6408, 5121, this.f37638m);
        return this.f37638m;
    }

    public Surface g() {
        return this.f37631f;
    }

    public void h() {
        if (this.f37626a != null) {
            c("before makeCurrent");
            EGL10 egl10 = this.f37626a;
            EGLDisplay eGLDisplay = this.f37627b;
            EGLSurface eGLSurface = this.f37629d;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f37628c)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    public void i() {
        EGL10 egl10 = this.f37626a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f37628c)) {
                EGL10 egl102 = this.f37626a;
                EGLDisplay eGLDisplay = this.f37627b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f37626a.eglDestroySurface(this.f37627b, this.f37629d);
            this.f37626a.eglDestroyContext(this.f37627b, this.f37628c);
        }
        this.f37631f.release();
        this.f37627b = null;
        this.f37628c = null;
        this.f37629d = null;
        this.f37626a = null;
        this.f37634i = null;
        this.f37631f = null;
        this.f37630e = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f37632g) {
            if (!this.f37633h) {
                this.f37633h = true;
                this.f37632g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    public f() {
        this.f37627b = null;
        this.f37628c = null;
        this.f37629d = null;
        this.f37632g = new Object();
        this.f37637l = 0;
        j();
    }
}
