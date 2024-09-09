package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GLTextureView.java */
@SuppressLint({"NewApi"})
/* renamed from: com.amap.api.col.3l.y  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: l  reason: collision with root package name */
    private static final j f9446l = new j((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<y> f9447a;

    /* renamed from: b  reason: collision with root package name */
    private i f9448b;

    /* renamed from: c  reason: collision with root package name */
    private GLSurfaceView.Renderer f9449c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9450d;

    /* renamed from: e  reason: collision with root package name */
    private e f9451e;

    /* renamed from: f  reason: collision with root package name */
    private f f9452f;

    /* renamed from: g  reason: collision with root package name */
    private g f9453g;

    /* renamed from: h  reason: collision with root package name */
    private k f9454h;

    /* renamed from: i  reason: collision with root package name */
    private int f9455i;

    /* renamed from: j  reason: collision with root package name */
    private int f9456j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9457k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f9458a;

        public a(int[] iArr) {
            this.f9458a = b(iArr);
        }

        private int[] b(int[] iArr) {
            if (y.this.f9456j == 2 || y.this.f9456j == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i4 = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                iArr2[i4] = 12352;
                if (y.this.f9456j == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.p0003l.y.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f9458a, null, 0, iArr)) {
                int i4 = iArr[0];
                if (i4 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i4];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9458a, eGLConfigArr, i4, iArr)) {
                        EGLConfig a4 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a4 != null) {
                            return a4;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class b extends a {

        /* renamed from: c  reason: collision with root package name */
        private int[] f9460c;

        /* renamed from: d  reason: collision with root package name */
        protected int f9461d;

        /* renamed from: e  reason: collision with root package name */
        protected int f9462e;

        /* renamed from: f  reason: collision with root package name */
        protected int f9463f;

        /* renamed from: g  reason: collision with root package name */
        protected int f9464g;

        /* renamed from: h  reason: collision with root package name */
        protected int f9465h;

        /* renamed from: i  reason: collision with root package name */
        protected int f9466i;

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.f9460c = new int[1];
            this.f9461d = 8;
            this.f9462e = 8;
            this.f9463f = 8;
            this.f9464g = 0;
            this.f9465h = 16;
            this.f9466i = 0;
        }

        private int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i4) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i4, this.f9460c)) {
                return this.f9460c[0];
            }
            return 0;
        }

        @Override // com.amap.api.col.p0003l.y.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int c4 = c(egl10, eGLDisplay, eGLConfig, 12325);
                int c5 = c(egl10, eGLDisplay, eGLConfig, 12326);
                if (c4 >= this.f9465h && c5 >= this.f9466i) {
                    int c6 = c(egl10, eGLDisplay, eGLConfig, 12324);
                    int c7 = c(egl10, eGLDisplay, eGLConfig, 12323);
                    int c8 = c(egl10, eGLDisplay, eGLConfig, 12322);
                    int c9 = c(egl10, eGLDisplay, eGLConfig, 12321);
                    if (c6 == this.f9461d && c7 == this.f9462e && c8 == this.f9463f && c9 == this.f9464g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class c implements f {
        private c() {
        }

        @Override // com.amap.api.col.p0003l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, y.this.f9456j, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (y.this.f9456j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.p0003l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.c("eglDestroyContex", egl10.eglGetError());
        }

        /* synthetic */ c(y yVar, byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.amap.api.col.p0003l.y.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e4) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e4);
                return null;
            }
        }

        @Override // com.amap.api.col.p0003l.y.g
        public final void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        /* synthetic */ d(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$g */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$h */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<y> f9469a;

        /* renamed from: b  reason: collision with root package name */
        EGL10 f9470b;

        /* renamed from: c  reason: collision with root package name */
        EGLDisplay f9471c;

        /* renamed from: d  reason: collision with root package name */
        EGLSurface f9472d;

        /* renamed from: e  reason: collision with root package name */
        EGLConfig f9473e;

        /* renamed from: f  reason: collision with root package name */
        EGLContext f9474f;

        public h(WeakReference<y> weakReference) {
            this.f9469a = weakReference;
        }

        private void b(String str) {
            c(str, this.f9470b.eglGetError());
        }

        public static void c(String str, int i4) {
            throw new RuntimeException(e(str, i4));
        }

        public static void d(String str, String str2, int i4) {
            Log.w(str, e(str2, i4));
        }

        private static String e(String str, int i4) {
            return str + " failed: " + i4;
        }

        private void k() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f9472d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f9470b.eglMakeCurrent(this.f9471c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            y yVar = this.f9469a.get();
            if (yVar != null) {
                yVar.f9453g.b(this.f9470b, this.f9471c, this.f9472d);
            }
            this.f9472d = null;
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f9470b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f9471c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f9470b.eglInitialize(eglGetDisplay, new int[2])) {
                    y yVar = this.f9469a.get();
                    if (yVar == null) {
                        this.f9473e = null;
                        this.f9474f = null;
                    } else {
                        this.f9473e = yVar.f9451e.chooseConfig(this.f9470b, this.f9471c);
                        this.f9474f = yVar.f9452f.createContext(this.f9470b, this.f9471c, this.f9473e);
                    }
                    EGLContext eGLContext = this.f9474f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f9474f = null;
                        b("createContext");
                    }
                    this.f9472d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public final boolean f() {
            if (this.f9470b != null) {
                if (this.f9471c != null) {
                    if (this.f9473e != null) {
                        k();
                        y yVar = this.f9469a.get();
                        if (yVar != null) {
                            this.f9472d = yVar.f9453g.a(this.f9470b, this.f9471c, this.f9473e, yVar.getSurfaceTexture());
                        } else {
                            this.f9472d = null;
                        }
                        EGLSurface eGLSurface = this.f9472d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f9470b.eglMakeCurrent(this.f9471c, eGLSurface, eGLSurface, this.f9474f)) {
                                return true;
                            }
                            d("EGLHelper", "eglMakeCurrent", this.f9470b.eglGetError());
                            return false;
                        }
                        if (this.f9470b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        final GL g() {
            GL gl = this.f9474f.getGL();
            y yVar = this.f9469a.get();
            if (yVar != null) {
                if (yVar.f9454h != null) {
                    gl = yVar.f9454h.a();
                }
                if ((yVar.f9455i & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (yVar.f9455i & 1) != 0 ? 1 : 0, (yVar.f9455i & 2) != 0 ? new l() : null);
                }
                return gl;
            }
            return gl;
        }

        public final int h() {
            if (this.f9470b.eglSwapBuffers(this.f9471c, this.f9472d)) {
                return 12288;
            }
            return this.f9470b.eglGetError();
        }

        public final void i() {
            k();
        }

        public final void j() {
            if (this.f9474f != null) {
                y yVar = this.f9469a.get();
                if (yVar != null) {
                    yVar.f9452f.destroyContext(this.f9470b, this.f9471c, this.f9474f);
                }
                this.f9474f = null;
            }
            EGLDisplay eGLDisplay = this.f9471c;
            if (eGLDisplay != null) {
                this.f9470b.eglTerminate(eGLDisplay);
                this.f9471c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$i */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9475a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9476b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9477c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9478d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9479e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9480f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9481g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9482h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f9483i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f9484j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9485k;

        /* renamed from: p  reason: collision with root package name */
        private boolean f9490p;

        /* renamed from: s  reason: collision with root package name */
        private h f9493s;

        /* renamed from: t  reason: collision with root package name */
        private WeakReference<y> f9494t;

        /* renamed from: q  reason: collision with root package name */
        private ArrayList<Runnable> f9491q = new ArrayList<>();

        /* renamed from: r  reason: collision with root package name */
        private boolean f9492r = true;

        /* renamed from: l  reason: collision with root package name */
        private int f9486l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f9487m = 0;

        /* renamed from: o  reason: collision with root package name */
        private boolean f9489o = true;

        /* renamed from: n  reason: collision with root package name */
        private int f9488n = 1;

        i(WeakReference<y> weakReference) {
            this.f9494t = weakReference;
        }

        static /* synthetic */ boolean e(i iVar) {
            iVar.f9476b = true;
            return true;
        }

        private void o() {
            if (this.f9483i) {
                this.f9483i = false;
                this.f9493s.i();
            }
        }

        private void p() {
            if (this.f9482h) {
                this.f9493s.j();
                this.f9482h = false;
                y.f9446l.g(this);
            }
        }

        private void q() throws InterruptedException {
            boolean z3;
            this.f9493s = new h(this.f9494t);
            this.f9482h = false;
            this.f9483i = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            GL10 gl10 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int i4 = 0;
            int i5 = 0;
            boolean z11 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (y.f9446l) {
                            while (!this.f9475a) {
                                if (!this.f9491q.isEmpty()) {
                                    runnable = this.f9491q.remove(0);
                                } else {
                                    boolean z12 = this.f9478d;
                                    boolean z13 = this.f9477c;
                                    if (z12 != z13) {
                                        this.f9478d = z13;
                                        y.f9446l.notifyAll();
                                    } else {
                                        z13 = false;
                                    }
                                    if (this.f9485k) {
                                        o();
                                        p();
                                        this.f9485k = false;
                                        z6 = true;
                                    }
                                    if (z4) {
                                        o();
                                        p();
                                        z4 = false;
                                    }
                                    if (z13 && this.f9483i) {
                                        o();
                                    }
                                    if (z13 && this.f9482h) {
                                        y yVar = this.f9494t.get();
                                        if (!(yVar == null ? false : yVar.f9457k) || y.f9446l.c()) {
                                            p();
                                        }
                                    }
                                    if (z13 && y.f9446l.d()) {
                                        this.f9493s.j();
                                    }
                                    if (!this.f9479e && !this.f9481g) {
                                        if (this.f9483i) {
                                            o();
                                        }
                                        this.f9481g = true;
                                        this.f9480f = false;
                                        y.f9446l.notifyAll();
                                    }
                                    if (this.f9479e && this.f9481g) {
                                        this.f9481g = false;
                                        y.f9446l.notifyAll();
                                    }
                                    if (z5) {
                                        this.f9490p = true;
                                        y.f9446l.notifyAll();
                                        z5 = false;
                                        z11 = false;
                                    }
                                    if (s()) {
                                        if (!this.f9482h) {
                                            if (z6) {
                                                z6 = false;
                                            } else if (y.f9446l.e(this)) {
                                                try {
                                                    this.f9493s.a();
                                                    this.f9482h = true;
                                                    y.f9446l.notifyAll();
                                                    z7 = true;
                                                } catch (RuntimeException e4) {
                                                    y.f9446l.g(this);
                                                    throw e4;
                                                }
                                            }
                                        }
                                        if (this.f9482h && !this.f9483i) {
                                            this.f9483i = true;
                                            z8 = true;
                                            z9 = true;
                                            z10 = true;
                                        }
                                        if (this.f9483i) {
                                            if (this.f9492r) {
                                                int i6 = this.f9486l;
                                                int i7 = this.f9487m;
                                                this.f9492r = false;
                                                i4 = i6;
                                                i5 = i7;
                                                z3 = false;
                                                z8 = true;
                                                z10 = true;
                                                z11 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            this.f9489o = z3;
                                            y.f9446l.notifyAll();
                                        }
                                    }
                                    y.f9446l.wait();
                                }
                            }
                            synchronized (y.f9446l) {
                                o();
                                p();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z8) {
                            if (this.f9493s.f()) {
                                synchronized (y.f9446l) {
                                    this.f9484j = true;
                                    y.f9446l.notifyAll();
                                }
                                z8 = false;
                            } else {
                                synchronized (y.f9446l) {
                                    this.f9484j = true;
                                    this.f9480f = true;
                                    y.f9446l.notifyAll();
                                }
                            }
                        }
                        if (z9) {
                            gl10 = (GL10) this.f9493s.g();
                            y.f9446l.b(gl10);
                            z9 = false;
                        }
                        if (z7) {
                            y yVar2 = this.f9494t.get();
                            if (yVar2 != null) {
                                yVar2.f9449c.onSurfaceCreated(gl10, this.f9493s.f9473e);
                            }
                            z7 = false;
                        }
                        if (z10) {
                            y yVar3 = this.f9494t.get();
                            if (yVar3 != null) {
                                yVar3.f9449c.onSurfaceChanged(gl10, i4, i5);
                            }
                            z10 = false;
                        }
                        y yVar4 = this.f9494t.get();
                        if (yVar4 != null) {
                            yVar4.f9449c.onDrawFrame(gl10);
                        }
                        int h4 = this.f9493s.h();
                        if (h4 != 12288) {
                            if (h4 != 12302) {
                                h.d("GLThread", "eglSwapBuffers", h4);
                                synchronized (y.f9446l) {
                                    this.f9480f = true;
                                    y.f9446l.notifyAll();
                                }
                            } else {
                                z4 = true;
                            }
                        }
                        if (z11) {
                            z5 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (y.f9446l) {
                            o();
                            p();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean r() {
            return this.f9482h && this.f9483i && s();
        }

        private boolean s() {
            if (this.f9478d || !this.f9479e || this.f9480f || this.f9486l <= 0 || this.f9487m <= 0) {
                return false;
            }
            return this.f9489o || this.f9488n == 1;
        }

        public final int a() {
            int i4;
            synchronized (y.f9446l) {
                i4 = this.f9488n;
            }
            return i4;
        }

        public final void b(int i4) {
            if (i4 >= 0 && i4 <= 1) {
                synchronized (y.f9446l) {
                    this.f9488n = i4;
                    y.f9446l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public final void c(int i4, int i5) {
            synchronized (y.f9446l) {
                this.f9486l = i4;
                this.f9487m = i5;
                this.f9492r = true;
                this.f9489o = true;
                this.f9490p = false;
                y.f9446l.notifyAll();
                while (!this.f9476b && !this.f9478d && !this.f9490p && r()) {
                    try {
                        y.f9446l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d(Runnable runnable) {
            if (runnable != null) {
                synchronized (y.f9446l) {
                    this.f9491q.add(runnable);
                    y.f9446l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public final void f() {
            synchronized (y.f9446l) {
                this.f9489o = true;
                y.f9446l.notifyAll();
            }
        }

        public final void g() {
            synchronized (y.f9446l) {
                this.f9479e = true;
                this.f9484j = false;
                y.f9446l.notifyAll();
                while (this.f9481g && !this.f9484j && !this.f9476b) {
                    try {
                        y.f9446l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            synchronized (y.f9446l) {
                this.f9479e = false;
                y.f9446l.notifyAll();
                while (!this.f9481g && !this.f9476b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f9446l.wait();
                        } else {
                            y.f9446l.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void i() {
            synchronized (y.f9446l) {
                this.f9477c = true;
                y.f9446l.notifyAll();
                while (!this.f9476b && !this.f9478d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f9446l.wait();
                        } else {
                            y.f9446l.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void j() {
            synchronized (y.f9446l) {
                this.f9477c = false;
                this.f9489o = true;
                this.f9490p = false;
                y.f9446l.notifyAll();
                while (!this.f9476b && this.f9478d && !this.f9490p) {
                    try {
                        y.f9446l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void k() {
            synchronized (y.f9446l) {
                this.f9475a = true;
                y.f9446l.notifyAll();
                while (!this.f9476b) {
                    try {
                        y.f9446l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void l() {
            this.f9485k = true;
            y.f9446l.notifyAll();
        }

        public final int m() {
            int i4;
            synchronized (y.f9446l) {
                i4 = this.f9486l;
            }
            return i4;
        }

        public final int n() {
            int i4;
            synchronized (y.f9446l) {
                i4 = this.f9487m;
            }
            return i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                q();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                y.f9446l.a(this);
                throw th;
            }
            y.f9446l.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$j */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class j {

        /* renamed from: g  reason: collision with root package name */
        private static String f9495g = "GLThreadManager";

        /* renamed from: a  reason: collision with root package name */
        private boolean f9496a;

        /* renamed from: b  reason: collision with root package name */
        private int f9497b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9498c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9499d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9500e;

        /* renamed from: f  reason: collision with root package name */
        private i f9501f;

        private j() {
        }

        private void f() {
            if (this.f9496a) {
                return;
            }
            this.f9497b = 131072;
            this.f9499d = true;
            this.f9496a = true;
        }

        public final synchronized void a(i iVar) {
            i.e(iVar);
            if (this.f9501f == iVar) {
                this.f9501f = null;
            }
            notifyAll();
        }

        public final synchronized void b(GL10 gl10) {
            if (!this.f9498c && gl10 != null) {
                f();
                String glGetString = gl10.glGetString(7937);
                if (this.f9497b < 131072) {
                    this.f9499d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f9500e = this.f9499d ? false : true;
                this.f9498c = true;
            }
        }

        public final synchronized boolean c() {
            return this.f9500e;
        }

        public final synchronized boolean d() {
            f();
            return !this.f9499d;
        }

        public final boolean e(i iVar) {
            i iVar2 = this.f9501f;
            if (iVar2 != iVar && iVar2 != null) {
                f();
                if (this.f9499d) {
                    return true;
                }
                i iVar3 = this.f9501f;
                if (iVar3 != null) {
                    iVar3.l();
                    return false;
                }
                return false;
            }
            this.f9501f = iVar;
            notifyAll();
            return true;
        }

        public final void g(i iVar) {
            if (this.f9501f == iVar) {
                this.f9501f = null;
            }
            notifyAll();
        }

        /* synthetic */ j(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$k */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface k {
        GL a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$l */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f9502a = new StringBuilder();

        l() {
        }

        private void b() {
            if (this.f9502a.length() > 0) {
                Log.v("GLSurfaceView", this.f9502a.toString());
                StringBuilder sb = this.f9502a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            b();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            b();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i4, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                char c4 = cArr[i4 + i6];
                if (c4 == '\n') {
                    b();
                } else {
                    this.f9502a.append(c4);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$m */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class m extends b {
        public m() {
            super();
        }
    }

    public y(Context context) {
        super(context, null);
        this.f9447a = new WeakReference<>(this);
        b();
    }

    private void b() {
        setSurfaceTextureListener(this);
    }

    private void l() {
        if (this.f9448b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean n() {
        return Build.VERSION.SDK_INT < 23;
    }

    public final void c(e eVar) {
        l();
        this.f9451e = eVar;
    }

    public final void d(f fVar) {
        l();
        this.f9452f = fVar;
    }

    public void f() {
        this.f9448b.i();
    }

    protected void finalize() throws Throwable {
        try {
            i iVar = this.f9448b;
            if (iVar != null) {
                iVar.k();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f9448b.a();
    }

    public void h() {
        this.f9448b.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9450d && this.f9449c != null) {
            i iVar = this.f9448b;
            int a4 = iVar != null ? iVar.a() : 1;
            i iVar2 = new i(this.f9447a);
            this.f9448b = iVar2;
            if (a4 != 1) {
                iVar2.b(a4);
            }
            this.f9448b.start();
        }
        this.f9450d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.f9448b;
        if (iVar != null) {
            iVar.k();
        }
        this.f9450d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i6 - i4, i7 - i5);
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.f9448b.g();
        if (!n() && !MapsInitializer.getTextureSizeChangedInvoked()) {
            if (this.f9448b.m() == i4 && this.f9448b.n() == i5) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i4, i5);
            return;
        }
        onSurfaceTextureSizeChanged(surfaceTexture, i4, i5);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f9448b.h();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.f9448b.c(i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f9448b.d(runnable);
    }

    public void requestRender() {
        this.f9448b.f();
    }

    public void setRenderMode(int i4) {
        this.f9448b.b(i4);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        l();
        if (this.f9451e == null) {
            this.f9451e = new m();
        }
        if (this.f9452f == null) {
            this.f9452f = new c(this, (byte) 0);
        }
        if (this.f9453g == null) {
            this.f9453g = new d((byte) 0);
        }
        this.f9449c = renderer;
        i iVar = new i(this.f9447a);
        this.f9448b = iVar;
        iVar.start();
    }
}
