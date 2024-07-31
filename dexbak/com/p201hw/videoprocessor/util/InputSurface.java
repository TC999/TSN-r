package com.p201hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

@TargetApi(18)
/* renamed from: com.hw.videoprocessor.util.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class InputSurface {

    /* renamed from: e */
    private static final boolean f24135e = false;

    /* renamed from: f */
    private static final int f24136f = 12610;

    /* renamed from: g */
    private static final int f24137g = 4;

    /* renamed from: a */
    private EGLDisplay f24138a;

    /* renamed from: b */
    private EGLContext f24139b;

    /* renamed from: c */
    private EGLSurface f24140c;

    /* renamed from: d */
    private Surface f24141d;

    public InputSurface(Surface surface) {
        surface.getClass();
        this.f24141d = surface;
        m34875b();
    }

    /* renamed from: a */
    private void m34876a(String str) {
        boolean z = false;
        while (EGL14.eglGetError() != 12288) {
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    /* renamed from: b */
    private void m34875b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f24138a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                this.f24138a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f24138a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, f24136f, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f24139b = EGL14.eglCreateContext(this.f24138a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                m34876a("eglCreateContext");
                if (this.f24139b != null) {
                    this.f24140c = EGL14.eglCreateWindowSurface(this.f24138a, eGLConfigArr[0], this.f24141d, new int[]{12344}, 0);
                    m34876a("eglCreateWindowSurface");
                    if (this.f24140c == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    /* renamed from: c */
    public Surface m34874c() {
        return this.f24141d;
    }

    /* renamed from: d */
    public void m34873d() {
        EGLDisplay eGLDisplay = this.f24138a;
        EGLSurface eGLSurface = this.f24140c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f24139b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: e */
    public void m34872e() {
        if (EGL14.eglGetCurrentContext().equals(this.f24139b)) {
            EGLDisplay eGLDisplay = this.f24138a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f24138a, this.f24140c);
        EGL14.eglDestroyContext(this.f24138a, this.f24139b);
        this.f24141d.release();
        this.f24138a = null;
        this.f24139b = null;
        this.f24140c = null;
        this.f24141d = null;
    }

    /* renamed from: f */
    public void m34871f(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f24138a, this.f24140c, j);
    }

    /* renamed from: g */
    public boolean m34870g() {
        return EGL14.eglSwapBuffers(this.f24138a, this.f24140c);
    }
}
