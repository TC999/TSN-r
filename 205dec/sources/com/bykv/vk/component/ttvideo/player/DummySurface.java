package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;

@TargetApi(17)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class DummySurface extends Surface {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        private void initInternal(int i4) {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.init(i4);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i4 != 0);
        }

        private void releaseInternal() {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.release();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            try {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e4);
                    this.initError = e4;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e5) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e5);
                    this.initException = e5;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        public DummySurface init(int i4) {
            boolean z3;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z3 = false;
                this.handler.obtainMessage(1, i4, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    DummySurface dummySurface = this.surface;
                    dummySurface.getClass();
                    return dummySurface;
                }
                throw error;
            }
            throw runtimeException;
        }

        public void release() {
            Handler handler = this.handler;
            handler.getClass();
            handler.sendEmptyMessage(2);
        }
    }

    private static void assertApiLevel17OrHigher() {
    }

    @TargetApi(24)
    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        if ((Build.VERSION.SDK_INT >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z3;
        synchronized (DummySurface.class) {
            if (!secureModeInitialized) {
                secureMode = Build.VERSION.SDK_INT < 24 ? 0 : getSecureModeV24(context);
                secureModeInitialized = true;
            }
            z3 = secureMode != 0;
        }
        return z3;
    }

    public static DummySurface newInstanceV17(boolean z3) {
        assertApiLevel17OrHigher();
        return new DummySurfaceThread().init(z3 ? secureMode : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z3) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z3;
    }
}
