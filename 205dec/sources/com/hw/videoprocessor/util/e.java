package com.hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: InputSurface.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f37617e = false;

    /* renamed from: f  reason: collision with root package name */
    private static final int f37618f = 12610;

    /* renamed from: g  reason: collision with root package name */
    private static final int f37619g = 4;

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f37620a;

    /* renamed from: b  reason: collision with root package name */
    private EGLContext f37621b;

    /* renamed from: c  reason: collision with root package name */
    private EGLSurface f37622c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f37623d;

    public e(Surface surface) {
        surface.getClass();
        this.f37623d = surface;
        b();
    }

    private void a(String str) {
        boolean z3 = false;
        while (EGL14.eglGetError() != 12288) {
            z3 = true;
        }
        if (z3) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f37620a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                this.f37620a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f37620a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f37621b = EGL14.eglCreateContext(this.f37620a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                a("eglCreateContext");
                if (this.f37621b != null) {
                    this.f37622c = EGL14.eglCreateWindowSurface(this.f37620a, eGLConfigArr[0], this.f37623d, new int[]{12344}, 0);
                    a("eglCreateWindowSurface");
                    if (this.f37622c == null) {
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

    public Surface c() {
        return this.f37623d;
    }

    public void d() {
        EGLDisplay eGLDisplay = this.f37620a;
        EGLSurface eGLSurface = this.f37622c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f37621b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void e() {
        if (EGL14.eglGetCurrentContext().equals(this.f37621b)) {
            EGLDisplay eGLDisplay = this.f37620a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f37620a, this.f37622c);
        EGL14.eglDestroyContext(this.f37620a, this.f37621b);
        this.f37623d.release();
        this.f37620a = null;
        this.f37621b = null;
        this.f37622c = null;
        this.f37623d = null;
    }

    public void f(long j4) {
        EGLExt.eglPresentationTimeANDROID(this.f37620a, this.f37622c, j4);
    }

    public boolean g() {
        return EGL14.eglSwapBuffers(this.f37620a, this.f37622c);
    }
}
