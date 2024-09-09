package com.amap.api.col.p0003l;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GlesUtility.java */
/* renamed from: com.amap.api.col.3l.n2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n2 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends l2 {

        /* renamed from: h  reason: collision with root package name */
        private static int f8368h = 4;

        /* renamed from: a  reason: collision with root package name */
        protected int f8369a;

        /* renamed from: b  reason: collision with root package name */
        protected int f8370b;

        /* renamed from: c  reason: collision with root package name */
        protected int f8371c;

        /* renamed from: g  reason: collision with root package name */
        private int[] f8375g = new int[1];

        /* renamed from: d  reason: collision with root package name */
        protected int f8372d = 0;

        /* renamed from: e  reason: collision with root package name */
        protected int f8373e = 16;

        /* renamed from: f  reason: collision with root package name */
        protected int f8374f = 8;

        public a(int i4, int i5, int i6) {
            this.f8369a = i4;
            this.f8370b = i5;
            this.f8371c = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i4) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i4, this.f8375g)) {
                return this.f8375g[0];
            }
            return 0;
        }

        private c b(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            int[] d4 = d(true);
            cVar.f8376a = d4;
            egl10.eglChooseConfig(eGLDisplay, d4, null, 0, cVar.f8377b);
            if (cVar.f8377b[0] <= 0) {
                int[] d5 = d(false);
                cVar.f8376a = d5;
                egl10.eglChooseConfig(eGLDisplay, d5, null, 0, cVar.f8377b);
                if (cVar.f8377b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        private EGLConfig c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a5 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a4 >= this.f8373e && a5 >= this.f8374f) {
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a8 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a9 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a6 == this.f8369a && a7 == this.f8370b && a8 == this.f8371c && a9 == this.f8372d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int[] d(boolean z3) {
            return new int[]{12324, this.f8369a, 12323, this.f8370b, 12322, this.f8371c, 12321, this.f8372d, 12325, this.f8373e, 12326, this.f8374f, 12338, z3 ? 1 : 0, 12352, f8368h, 12344};
        }

        @Override // com.amap.api.col.p0003l.l2, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.col.p0003l.y.e
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr;
            int[] iArr2;
            c b4 = b(egl10, eGLDisplay);
            if (b4 == null || (iArr = b4.f8376a) == null) {
                return null;
            }
            int[] iArr3 = b4.f8377b;
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr3[0]];
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, iArr3[0], iArr3);
            EGLConfig c4 = c(egl10, eGLDisplay, eGLConfigArr);
            if (c4 == null) {
                this.f8369a = 8;
                this.f8370b = 8;
                this.f8371c = 8;
                c b5 = b(egl10, eGLDisplay);
                if (b5 == null || (iArr2 = b5.f8376a) == null) {
                    return c4;
                }
                int[] iArr4 = b5.f8377b;
                EGLConfig[] eGLConfigArr2 = new EGLConfig[iArr4[0]];
                egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, iArr4[0], iArr4);
                return c(egl10, eGLDisplay, eGLConfigArr2);
            }
            return c4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b extends m2 {
        @Override // com.amap.api.col.p0003l.m2, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.p0003l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003l.m2, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.p0003l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public static void a(IGLSurfaceView iGLSurfaceView, int i4, int i5, int i6) {
        iGLSurfaceView.setEGLContextFactory(new b());
        iGLSurfaceView.setEGLConfigChooser(new a(i4, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GlesUtility.java */
    /* renamed from: com.amap.api.col.3l.n2$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int[] f8376a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f8377b;

        private c() {
            this.f8376a = null;
            this.f8377b = new int[1];
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }
}
