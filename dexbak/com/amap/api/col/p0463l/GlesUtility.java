package com.amap.api.col.p0463l;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.amap.api.col.3l.n2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GlesUtility {

    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1861a extends GLMapSurfaceConfigChooser {

        /* renamed from: h */
        private static int f4733h = 4;

        /* renamed from: a */
        protected int f4734a;

        /* renamed from: b */
        protected int f4735b;

        /* renamed from: c */
        protected int f4736c;

        /* renamed from: g */
        private int[] f4740g = new int[1];

        /* renamed from: d */
        protected int f4737d = 0;

        /* renamed from: e */
        protected int f4738e = 16;

        /* renamed from: f */
        protected int f4739f = 8;

        public C1861a(int i, int i2, int i3) {
            this.f4734a = i;
            this.f4735b = i2;
            this.f4736c = i3;
        }

        /* renamed from: a */
        private int m54449a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f4740g)) {
                return this.f4740g[0];
            }
            return 0;
        }

        /* renamed from: b */
        private C1863c m54448b(EGL10 egl10, EGLDisplay eGLDisplay) {
            C1863c c1863c = new C1863c((byte) 0);
            int[] m54446d = m54446d(true);
            c1863c.f4741a = m54446d;
            egl10.eglChooseConfig(eGLDisplay, m54446d, null, 0, c1863c.f4742b);
            if (c1863c.f4742b[0] <= 0) {
                int[] m54446d2 = m54446d(false);
                c1863c.f4741a = m54446d2;
                egl10.eglChooseConfig(eGLDisplay, m54446d2, null, 0, c1863c.f4742b);
                if (c1863c.f4742b[0] <= 0) {
                    return null;
                }
            }
            return c1863c;
        }

        /* renamed from: c */
        private EGLConfig m54447c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int m54449a = m54449a(egl10, eGLDisplay, eGLConfig, 12325);
                int m54449a2 = m54449a(egl10, eGLDisplay, eGLConfig, 12326);
                if (m54449a >= this.f4738e && m54449a2 >= this.f4739f) {
                    int m54449a3 = m54449a(egl10, eGLDisplay, eGLConfig, 12324);
                    int m54449a4 = m54449a(egl10, eGLDisplay, eGLConfig, 12323);
                    int m54449a5 = m54449a(egl10, eGLDisplay, eGLConfig, 12322);
                    int m54449a6 = m54449a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (m54449a3 == this.f4734a && m54449a4 == this.f4735b && m54449a5 == this.f4736c && m54449a6 == this.f4737d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        /* renamed from: d */
        private int[] m54446d(boolean z) {
            return new int[]{12324, this.f4734a, 12323, this.f4735b, 12322, this.f4736c, 12321, this.f4737d, 12325, this.f4738e, 12326, this.f4739f, 12338, z ? 1 : 0, 12352, f4733h, 12344};
        }

        @Override // com.amap.api.col.p0463l.GLMapSurfaceConfigChooser, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.col.p0463l.GLTextureView.InterfaceC1993e
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr;
            int[] iArr2;
            C1863c m54448b = m54448b(egl10, eGLDisplay);
            if (m54448b == null || (iArr = m54448b.f4741a) == null) {
                return null;
            }
            int[] iArr3 = m54448b.f4742b;
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr3[0]];
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, iArr3[0], iArr3);
            EGLConfig m54447c = m54447c(egl10, eGLDisplay, eGLConfigArr);
            if (m54447c == null) {
                this.f4734a = 8;
                this.f4735b = 8;
                this.f4736c = 8;
                C1863c m54448b2 = m54448b(egl10, eGLDisplay);
                if (m54448b2 == null || (iArr2 = m54448b2.f4741a) == null) {
                    return m54447c;
                }
                int[] iArr4 = m54448b2.f4742b;
                EGLConfig[] eGLConfigArr2 = new EGLConfig[iArr4[0]];
                egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, iArr4[0], iArr4);
                return m54447c(egl10, eGLDisplay, eGLConfigArr2);
            }
            return m54447c;
        }
    }

    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1862b extends GlMapSurfaceEglContextFactory {
        @Override // com.amap.api.col.p0463l.GlMapSurfaceEglContextFactory, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.p0463l.GLTextureView.InterfaceC1994f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0463l.GlMapSurfaceEglContextFactory, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.p0463l.GLTextureView.InterfaceC1994f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* renamed from: a */
    public static void m54450a(IGLSurfaceView iGLSurfaceView, int i, int i2, int i3) {
        iGLSurfaceView.setEGLContextFactory(new C1862b());
        iGLSurfaceView.setEGLConfigChooser(new C1861a(i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1863c {

        /* renamed from: a */
        public int[] f4741a;

        /* renamed from: b */
        public int[] f4742b;

        private C1863c() {
            this.f4741a = null;
            this.f4742b = new int[1];
        }

        /* synthetic */ C1863c(byte b) {
            this();
        }
    }
}
