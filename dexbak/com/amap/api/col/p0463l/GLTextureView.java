package com.amap.api.col.p0463l;

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

@SuppressLint({"NewApi"})
/* renamed from: com.amap.api.col.3l.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: l */
    private static final C1998j f5714l = new C1998j((byte) 0);

    /* renamed from: a */
    private final WeakReference<GLTextureView> f5715a;

    /* renamed from: b */
    private C1997i f5716b;

    /* renamed from: c */
    private GLSurfaceView.Renderer f5717c;

    /* renamed from: d */
    private boolean f5718d;

    /* renamed from: e */
    private InterfaceC1993e f5719e;

    /* renamed from: f */
    private InterfaceC1994f f5720f;

    /* renamed from: g */
    private InterfaceC1995g f5721g;

    /* renamed from: h */
    private InterfaceC1999k f5722h;

    /* renamed from: i */
    private int f5723i;

    /* renamed from: j */
    private int f5724j;

    /* renamed from: k */
    private boolean f5725k;

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private abstract class AbstractC1989a implements InterfaceC1993e {

        /* renamed from: a */
        protected int[] f5726a;

        public AbstractC1989a(int[] iArr) {
            this.f5726a = m53475b(iArr);
        }

        /* renamed from: b */
        private int[] m53475b(int[] iArr) {
            if (GLTextureView.this.f5724j == 2 || GLTextureView.this.f5724j == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (GLTextureView.this.f5724j == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        /* renamed from: a */
        abstract EGLConfig mo53474a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.p0463l.GLTextureView.InterfaceC1993e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f5726a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f5726a, eGLConfigArr, i, iArr)) {
                        EGLConfig mo53474a = mo53474a(egl10, eGLDisplay, eGLConfigArr);
                        if (mo53474a != null) {
                            return mo53474a;
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

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C1990b extends AbstractC1989a {

        /* renamed from: c */
        private int[] f5728c;

        /* renamed from: d */
        protected int f5729d;

        /* renamed from: e */
        protected int f5730e;

        /* renamed from: f */
        protected int f5731f;

        /* renamed from: g */
        protected int f5732g;

        /* renamed from: h */
        protected int f5733h;

        /* renamed from: i */
        protected int f5734i;

        public C1990b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.f5728c = new int[1];
            this.f5729d = 8;
            this.f5730e = 8;
            this.f5731f = 8;
            this.f5732g = 0;
            this.f5733h = 16;
            this.f5734i = 0;
        }

        /* renamed from: c */
        private int m53473c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f5728c)) {
                return this.f5728c[0];
            }
            return 0;
        }

        @Override // com.amap.api.col.p0463l.GLTextureView.AbstractC1989a
        /* renamed from: a */
        public final EGLConfig mo53474a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int m53473c = m53473c(egl10, eGLDisplay, eGLConfig, 12325);
                int m53473c2 = m53473c(egl10, eGLDisplay, eGLConfig, 12326);
                if (m53473c >= this.f5733h && m53473c2 >= this.f5734i) {
                    int m53473c3 = m53473c(egl10, eGLDisplay, eGLConfig, 12324);
                    int m53473c4 = m53473c(egl10, eGLDisplay, eGLConfig, 12323);
                    int m53473c5 = m53473c(egl10, eGLDisplay, eGLConfig, 12322);
                    int m53473c6 = m53473c(egl10, eGLDisplay, eGLConfig, 12321);
                    if (m53473c3 == this.f5729d && m53473c4 == this.f5730e && m53473c5 == this.f5731f && m53473c6 == this.f5732g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C1991c implements InterfaceC1994f {
        private C1991c() {
        }

        @Override // com.amap.api.col.p0463l.GLTextureView.InterfaceC1994f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, GLTextureView.this.f5724j, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.f5724j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.p0463l.GLTextureView.InterfaceC1994f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            C1996h.m53468c("eglDestroyContex", egl10.eglGetError());
        }

        /* synthetic */ C1991c(GLTextureView gLTextureView, byte b) {
            this();
        }
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C1992d implements InterfaceC1995g {
        private C1992d() {
        }

        @Override // com.amap.api.col.p0463l.GLTextureView.InterfaceC1995g
        /* renamed from: a */
        public final EGLSurface mo53472a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.col.p0463l.GLTextureView.InterfaceC1995g
        /* renamed from: b */
        public final void mo53471b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        /* synthetic */ C1992d(byte b) {
            this();
        }
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1993e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1994f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1995g {
        /* renamed from: a */
        EGLSurface mo53472a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: b */
        void mo53471b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1996h {

        /* renamed from: a */
        private WeakReference<GLTextureView> f5737a;

        /* renamed from: b */
        EGL10 f5738b;

        /* renamed from: c */
        EGLDisplay f5739c;

        /* renamed from: d */
        EGLSurface f5740d;

        /* renamed from: e */
        EGLConfig f5741e;

        /* renamed from: f */
        EGLContext f5742f;

        public C1996h(WeakReference<GLTextureView> weakReference) {
            this.f5737a = weakReference;
        }

        /* renamed from: b */
        private void m53469b(String str) {
            m53468c(str, this.f5738b.eglGetError());
        }

        /* renamed from: c */
        public static void m53468c(String str, int i) {
            throw new RuntimeException(m53466e(str, i));
        }

        /* renamed from: d */
        public static void m53467d(String str, String str2, int i) {
            Log.w(str, m53466e(str2, i));
        }

        /* renamed from: e */
        private static String m53466e(String str, int i) {
            return str + " failed: " + i;
        }

        /* renamed from: k */
        private void m53460k() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f5740d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f5738b.eglMakeCurrent(this.f5739c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f5737a.get();
            if (gLTextureView != null) {
                gLTextureView.f5721g.mo53471b(this.f5738b, this.f5739c, this.f5740d);
            }
            this.f5740d = null;
        }

        /* renamed from: a */
        public final void m53470a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f5738b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f5739c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f5738b.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f5737a.get();
                    if (gLTextureView == null) {
                        this.f5741e = null;
                        this.f5742f = null;
                    } else {
                        this.f5741e = gLTextureView.f5719e.chooseConfig(this.f5738b, this.f5739c);
                        this.f5742f = gLTextureView.f5720f.createContext(this.f5738b, this.f5739c, this.f5741e);
                    }
                    EGLContext eGLContext = this.f5742f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f5742f = null;
                        m53469b("createContext");
                    }
                    this.f5740d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        /* renamed from: f */
        public final boolean m53465f() {
            if (this.f5738b != null) {
                if (this.f5739c != null) {
                    if (this.f5741e != null) {
                        m53460k();
                        GLTextureView gLTextureView = this.f5737a.get();
                        if (gLTextureView != null) {
                            this.f5740d = gLTextureView.f5721g.mo53472a(this.f5738b, this.f5739c, this.f5741e, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f5740d = null;
                        }
                        EGLSurface eGLSurface = this.f5740d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f5738b.eglMakeCurrent(this.f5739c, eGLSurface, eGLSurface, this.f5742f)) {
                                return true;
                            }
                            m53467d("EGLHelper", "eglMakeCurrent", this.f5738b.eglGetError());
                            return false;
                        }
                        if (this.f5738b.eglGetError() == 12299) {
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

        /* renamed from: g */
        final GL m53464g() {
            GL gl = this.f5742f.getGL();
            GLTextureView gLTextureView = this.f5737a.get();
            if (gLTextureView != null) {
                if (gLTextureView.f5722h != null) {
                    gl = gLTextureView.f5722h.m53433a();
                }
                if ((gLTextureView.f5723i & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (gLTextureView.f5723i & 1) != 0 ? 1 : 0, (gLTextureView.f5723i & 2) != 0 ? new C2000l() : null);
                }
                return gl;
            }
            return gl;
        }

        /* renamed from: h */
        public final int m53463h() {
            if (this.f5738b.eglSwapBuffers(this.f5739c, this.f5740d)) {
                return 12288;
            }
            return this.f5738b.eglGetError();
        }

        /* renamed from: i */
        public final void m53462i() {
            m53460k();
        }

        /* renamed from: j */
        public final void m53461j() {
            if (this.f5742f != null) {
                GLTextureView gLTextureView = this.f5737a.get();
                if (gLTextureView != null) {
                    gLTextureView.f5720f.destroyContext(this.f5738b, this.f5739c, this.f5742f);
                }
                this.f5742f = null;
            }
            EGLDisplay eGLDisplay = this.f5739c;
            if (eGLDisplay != null) {
                this.f5738b.eglTerminate(eGLDisplay);
                this.f5739c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1997i extends Thread {

        /* renamed from: a */
        private boolean f5743a;

        /* renamed from: b */
        private boolean f5744b;

        /* renamed from: c */
        private boolean f5745c;

        /* renamed from: d */
        private boolean f5746d;

        /* renamed from: e */
        private boolean f5747e;

        /* renamed from: f */
        private boolean f5748f;

        /* renamed from: g */
        private boolean f5749g;

        /* renamed from: h */
        private boolean f5750h;

        /* renamed from: i */
        private boolean f5751i;

        /* renamed from: j */
        private boolean f5752j;

        /* renamed from: k */
        private boolean f5753k;

        /* renamed from: p */
        private boolean f5758p;

        /* renamed from: s */
        private C1996h f5761s;

        /* renamed from: t */
        private WeakReference<GLTextureView> f5762t;

        /* renamed from: q */
        private ArrayList<Runnable> f5759q = new ArrayList<>();

        /* renamed from: r */
        private boolean f5760r = true;

        /* renamed from: l */
        private int f5754l = 0;

        /* renamed from: m */
        private int f5755m = 0;

        /* renamed from: o */
        private boolean f5757o = true;

        /* renamed from: n */
        private int f5756n = 1;

        C1997i(WeakReference<GLTextureView> weakReference) {
            this.f5762t = weakReference;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m53455e(C1997i c1997i) {
            c1997i.f5744b = true;
            return true;
        }

        /* renamed from: o */
        private void m53445o() {
            if (this.f5751i) {
                this.f5751i = false;
                this.f5761s.m53462i();
            }
        }

        /* renamed from: p */
        private void m53444p() {
            if (this.f5750h) {
                this.f5761s.m53461j();
                this.f5750h = false;
                GLTextureView.f5714l.m53434g(this);
            }
        }

        /* renamed from: q */
        private void m53443q() throws InterruptedException {
            boolean z;
            this.f5761s = new C1996h(this.f5762t);
            this.f5750h = false;
            this.f5751i = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            GL10 gl10 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i = 0;
            int i2 = 0;
            boolean z9 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (GLTextureView.f5714l) {
                            while (!this.f5743a) {
                                if (!this.f5759q.isEmpty()) {
                                    runnable = this.f5759q.remove(0);
                                } else {
                                    boolean z10 = this.f5746d;
                                    boolean z11 = this.f5745c;
                                    if (z10 != z11) {
                                        this.f5746d = z11;
                                        GLTextureView.f5714l.notifyAll();
                                    } else {
                                        z11 = false;
                                    }
                                    if (this.f5753k) {
                                        m53445o();
                                        m53444p();
                                        this.f5753k = false;
                                        z4 = true;
                                    }
                                    if (z2) {
                                        m53445o();
                                        m53444p();
                                        z2 = false;
                                    }
                                    if (z11 && this.f5751i) {
                                        m53445o();
                                    }
                                    if (z11 && this.f5750h) {
                                        GLTextureView gLTextureView = this.f5762t.get();
                                        if (!(gLTextureView == null ? false : gLTextureView.f5725k) || GLTextureView.f5714l.m53438c()) {
                                            m53444p();
                                        }
                                    }
                                    if (z11 && GLTextureView.f5714l.m53437d()) {
                                        this.f5761s.m53461j();
                                    }
                                    if (!this.f5747e && !this.f5749g) {
                                        if (this.f5751i) {
                                            m53445o();
                                        }
                                        this.f5749g = true;
                                        this.f5748f = false;
                                        GLTextureView.f5714l.notifyAll();
                                    }
                                    if (this.f5747e && this.f5749g) {
                                        this.f5749g = false;
                                        GLTextureView.f5714l.notifyAll();
                                    }
                                    if (z3) {
                                        this.f5758p = true;
                                        GLTextureView.f5714l.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (m53441s()) {
                                        if (!this.f5750h) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (GLTextureView.f5714l.m53436e(this)) {
                                                try {
                                                    this.f5761s.m53470a();
                                                    this.f5750h = true;
                                                    GLTextureView.f5714l.notifyAll();
                                                    z5 = true;
                                                } catch (RuntimeException e) {
                                                    GLTextureView.f5714l.m53434g(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.f5750h && !this.f5751i) {
                                            this.f5751i = true;
                                            z6 = true;
                                            z7 = true;
                                            z8 = true;
                                        }
                                        if (this.f5751i) {
                                            if (this.f5760r) {
                                                int i3 = this.f5754l;
                                                int i4 = this.f5755m;
                                                this.f5760r = false;
                                                i = i3;
                                                i2 = i4;
                                                z = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.f5757o = z;
                                            GLTextureView.f5714l.notifyAll();
                                        }
                                    }
                                    GLTextureView.f5714l.wait();
                                }
                            }
                            synchronized (GLTextureView.f5714l) {
                                m53445o();
                                m53444p();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z6) {
                            if (this.f5761s.m53465f()) {
                                synchronized (GLTextureView.f5714l) {
                                    this.f5752j = true;
                                    GLTextureView.f5714l.notifyAll();
                                }
                                z6 = false;
                            } else {
                                synchronized (GLTextureView.f5714l) {
                                    this.f5752j = true;
                                    this.f5748f = true;
                                    GLTextureView.f5714l.notifyAll();
                                }
                            }
                        }
                        if (z7) {
                            gl10 = (GL10) this.f5761s.m53464g();
                            GLTextureView.f5714l.m53439b(gl10);
                            z7 = false;
                        }
                        if (z5) {
                            GLTextureView gLTextureView2 = this.f5762t.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.f5717c.onSurfaceCreated(gl10, this.f5761s.f5741e);
                            }
                            z5 = false;
                        }
                        if (z8) {
                            GLTextureView gLTextureView3 = this.f5762t.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.f5717c.onSurfaceChanged(gl10, i, i2);
                            }
                            z8 = false;
                        }
                        GLTextureView gLTextureView4 = this.f5762t.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.f5717c.onDrawFrame(gl10);
                        }
                        int m53463h = this.f5761s.m53463h();
                        if (m53463h != 12288) {
                            if (m53463h != 12302) {
                                C1996h.m53467d("GLThread", "eglSwapBuffers", m53463h);
                                synchronized (GLTextureView.f5714l) {
                                    this.f5748f = true;
                                    GLTextureView.f5714l.notifyAll();
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (z9) {
                            z3 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (GLTextureView.f5714l) {
                            m53445o();
                            m53444p();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        /* renamed from: r */
        private boolean m53442r() {
            return this.f5750h && this.f5751i && m53441s();
        }

        /* renamed from: s */
        private boolean m53441s() {
            if (this.f5746d || !this.f5747e || this.f5748f || this.f5754l <= 0 || this.f5755m <= 0) {
                return false;
            }
            return this.f5757o || this.f5756n == 1;
        }

        /* renamed from: a */
        public final int m53459a() {
            int i;
            synchronized (GLTextureView.f5714l) {
                i = this.f5756n;
            }
            return i;
        }

        /* renamed from: b */
        public final void m53458b(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.f5714l) {
                    this.f5756n = i;
                    GLTextureView.f5714l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        /* renamed from: c */
        public final void m53457c(int i, int i2) {
            synchronized (GLTextureView.f5714l) {
                this.f5754l = i;
                this.f5755m = i2;
                this.f5760r = true;
                this.f5757o = true;
                this.f5758p = false;
                GLTextureView.f5714l.notifyAll();
                while (!this.f5744b && !this.f5746d && !this.f5758p && m53442r()) {
                    try {
                        GLTextureView.f5714l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: d */
        public final void m53456d(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.f5714l) {
                    this.f5759q.add(runnable);
                    GLTextureView.f5714l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* renamed from: f */
        public final void m53454f() {
            synchronized (GLTextureView.f5714l) {
                this.f5757o = true;
                GLTextureView.f5714l.notifyAll();
            }
        }

        /* renamed from: g */
        public final void m53453g() {
            synchronized (GLTextureView.f5714l) {
                this.f5747e = true;
                this.f5752j = false;
                GLTextureView.f5714l.notifyAll();
                while (this.f5749g && !this.f5752j && !this.f5744b) {
                    try {
                        GLTextureView.f5714l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: h */
        public final void m53452h() {
            synchronized (GLTextureView.f5714l) {
                this.f5747e = false;
                GLTextureView.f5714l.notifyAll();
                while (!this.f5749g && !this.f5744b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            GLTextureView.f5714l.wait();
                        } else {
                            GLTextureView.f5714l.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: i */
        public final void m53451i() {
            synchronized (GLTextureView.f5714l) {
                this.f5745c = true;
                GLTextureView.f5714l.notifyAll();
                while (!this.f5744b && !this.f5746d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            GLTextureView.f5714l.wait();
                        } else {
                            GLTextureView.f5714l.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: j */
        public final void m53450j() {
            synchronized (GLTextureView.f5714l) {
                this.f5745c = false;
                this.f5757o = true;
                this.f5758p = false;
                GLTextureView.f5714l.notifyAll();
                while (!this.f5744b && this.f5746d && !this.f5758p) {
                    try {
                        GLTextureView.f5714l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: k */
        public final void m53449k() {
            synchronized (GLTextureView.f5714l) {
                this.f5743a = true;
                GLTextureView.f5714l.notifyAll();
                while (!this.f5744b) {
                    try {
                        GLTextureView.f5714l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: l */
        public final void m53448l() {
            this.f5753k = true;
            GLTextureView.f5714l.notifyAll();
        }

        /* renamed from: m */
        public final int m53447m() {
            int i;
            synchronized (GLTextureView.f5714l) {
                i = this.f5754l;
            }
            return i;
        }

        /* renamed from: n */
        public final int m53446n() {
            int i;
            synchronized (GLTextureView.f5714l) {
                i = this.f5755m;
            }
            return i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                m53443q();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f5714l.m53440a(this);
                throw th;
            }
            GLTextureView.f5714l.m53440a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1998j {

        /* renamed from: g */
        private static String f5763g = "GLThreadManager";

        /* renamed from: a */
        private boolean f5764a;

        /* renamed from: b */
        private int f5765b;

        /* renamed from: c */
        private boolean f5766c;

        /* renamed from: d */
        private boolean f5767d;

        /* renamed from: e */
        private boolean f5768e;

        /* renamed from: f */
        private C1997i f5769f;

        private C1998j() {
        }

        /* renamed from: f */
        private void m53435f() {
            if (this.f5764a) {
                return;
            }
            this.f5765b = 131072;
            this.f5767d = true;
            this.f5764a = true;
        }

        /* renamed from: a */
        public final synchronized void m53440a(C1997i c1997i) {
            C1997i.m53455e(c1997i);
            if (this.f5769f == c1997i) {
                this.f5769f = null;
            }
            notifyAll();
        }

        /* renamed from: b */
        public final synchronized void m53439b(GL10 gl10) {
            if (!this.f5766c && gl10 != null) {
                m53435f();
                String glGetString = gl10.glGetString(7937);
                if (this.f5765b < 131072) {
                    this.f5767d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f5768e = this.f5767d ? false : true;
                this.f5766c = true;
            }
        }

        /* renamed from: c */
        public final synchronized boolean m53438c() {
            return this.f5768e;
        }

        /* renamed from: d */
        public final synchronized boolean m53437d() {
            m53435f();
            return !this.f5767d;
        }

        /* renamed from: e */
        public final boolean m53436e(C1997i c1997i) {
            C1997i c1997i2 = this.f5769f;
            if (c1997i2 != c1997i && c1997i2 != null) {
                m53435f();
                if (this.f5767d) {
                    return true;
                }
                C1997i c1997i3 = this.f5769f;
                if (c1997i3 != null) {
                    c1997i3.m53448l();
                    return false;
                }
                return false;
            }
            this.f5769f = c1997i;
            notifyAll();
            return true;
        }

        /* renamed from: g */
        public final void m53434g(C1997i c1997i) {
            if (this.f5769f == c1997i) {
                this.f5769f = null;
            }
            notifyAll();
        }

        /* synthetic */ C1998j(byte b) {
            this();
        }
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$k */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1999k {
        /* renamed from: a */
        GL m53433a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$l */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2000l extends Writer {

        /* renamed from: a */
        private StringBuilder f5770a = new StringBuilder();

        C2000l() {
        }

        /* renamed from: a */
        private void m53432a() {
            if (this.f5770a.length() > 0) {
                Log.v("GLSurfaceView", this.f5770a.toString());
                StringBuilder sb = this.f5770a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            m53432a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            m53432a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    m53432a();
                } else {
                    this.f5770a.append(c);
                }
            }
        }
    }

    /* compiled from: GLTextureView.java */
    /* renamed from: com.amap.api.col.3l.y$m */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2001m extends C1990b {
        public C2001m() {
            super();
        }
    }

    public GLTextureView(Context context) {
        super(context, null);
        this.f5715a = new WeakReference<>(this);
        m53490b();
    }

    /* renamed from: b */
    private void m53490b() {
        setSurfaceTextureListener(this);
    }

    /* renamed from: l */
    private void m53480l() {
        if (this.f5716b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* renamed from: n */
    private static boolean m53478n() {
        return Build.VERSION.SDK_INT < 23;
    }

    /* renamed from: c */
    public final void m53489c(InterfaceC1993e interfaceC1993e) {
        m53480l();
        this.f5719e = interfaceC1993e;
    }

    /* renamed from: d */
    public final void m53488d(InterfaceC1994f interfaceC1994f) {
        m53480l();
        this.f5720f = interfaceC1994f;
    }

    /* renamed from: f */
    public void mo53486f() {
        this.f5716b.m53451i();
    }

    protected void finalize() throws Throwable {
        try {
            C1997i c1997i = this.f5716b;
            if (c1997i != null) {
                c1997i.m53449k();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f5716b.m53459a();
    }

    /* renamed from: h */
    public void mo53484h() {
        this.f5716b.m53450j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5718d && this.f5717c != null) {
            C1997i c1997i = this.f5716b;
            int m53459a = c1997i != null ? c1997i.m53459a() : 1;
            C1997i c1997i2 = new C1997i(this.f5715a);
            this.f5716b = c1997i2;
            if (m53459a != 1) {
                c1997i2.m53458b(m53459a);
            }
            this.f5716b.start();
        }
        this.f5718d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        C1997i c1997i = this.f5716b;
        if (c1997i != null) {
            c1997i.m53449k();
        }
        this.f5718d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i3 - i, i4 - i2);
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f5716b.m53453g();
        if (!m53478n() && !MapsInitializer.getTextureSizeChangedInvoked()) {
            if (this.f5716b.m53447m() == i && this.f5716b.m53446n() == i2) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            return;
        }
        onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f5716b.m53452h();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f5716b.m53457c(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f5716b.m53456d(runnable);
    }

    public void requestRender() {
        this.f5716b.m53454f();
    }

    public void setRenderMode(int i) {
        this.f5716b.m53458b(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        m53480l();
        if (this.f5719e == null) {
            this.f5719e = new C2001m();
        }
        if (this.f5720f == null) {
            this.f5720f = new C1991c(this, (byte) 0);
        }
        if (this.f5721g == null) {
            this.f5721g = new C1992d((byte) 0);
        }
        this.f5717c = renderer;
        C1997i c1997i = new C1997i(this.f5715a);
        this.f5716b = c1997i;
        c1997i.start();
    }
}
