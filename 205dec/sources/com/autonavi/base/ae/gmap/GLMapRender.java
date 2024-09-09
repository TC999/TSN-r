package com.autonavi.base.ae.gmap;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.amap.api.col.p0003l.u5;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.concurrent.atomic.AtomicLong;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLMapRender implements GLSurfaceView.Renderer {
    public static final int ANIMATION_TICK_COUNT = 10;
    public static final int LONG_LONG_TICK_COUNT = 30;
    public static final int LONG_TICK_COUNT = 6;
    private static final int MAP_RENDER_MSG_RUNNABLE_ONGLTHREAD = 100;
    private static final int MAP_RENDER_MSG_SURFACE_RENDER = 10;
    public static final int NORMAL_TICK_COUNT = 2;
    public static final int RENDER_FPS_ANIMATION = 30;
    public static final int RENDER_FPS_GESTURE_ACTION = 40;
    static final int RENDER_FPS_MAX = 60;
    public static final int RENDER_FPS_NAVI = 10;
    public static final int RENDER_FPS_NORMAL = 15;
    static final long RENDER_TIMMER_DIFF_MIN = 16;
    static final String TAG = "render";
    public IAMap mGLMapView;
    private int mTargetFrameDurationMillis = 66;
    private float mTargetRenderFPS = 15.0f;
    private volatile boolean mIsRendPause = false;
    public volatile boolean mSurfacedestoryed = false;
    private HandlerThread mGLRenderThread = null;
    private Handler mGLRenderHandler = null;
    private long mLastFrameTime = System.currentTimeMillis();
    private boolean mIsTrafficMode = false;
    private volatile AtomicLong mDrawFrameTickCount = new AtomicLong(6);

    public GLMapRender(IAMap iAMap) {
        this.mGLMapView = iAMap;
    }

    private void drawSingleFrame(GL10 gl10) {
        try {
            this.mGLMapView.drawFrame(gl10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isRenderPause() {
        return this.mIsRendPause;
    }

    public void onAttachedToWindow() {
        if (this.mGLRenderThread == null) {
            HandlerThread handlerThread = new HandlerThread(" AMapGlRenderThread");
            this.mGLRenderThread = handlerThread;
            handlerThread.start();
            this.mGLRenderHandler = new Handler(this.mGLRenderThread.getLooper()) { // from class: com.autonavi.base.ae.gmap.GLMapRender.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    IAMap iAMap;
                    int i4 = message.what;
                    if (i4 != 10) {
                        if (i4 != 100) {
                            return;
                        }
                        ((Runnable) message.obj).run();
                    } else if (GLMapRender.this.mIsRendPause || (iAMap = GLMapRender.this.mGLMapView) == null || iAMap.getRenderMode() != 0) {
                    } else {
                        GLMapRender.this.mGLMapView.requestRender();
                    }
                }
            };
        }
    }

    public void onDetachedFromWindow() {
        HandlerThread handlerThread = this.mGLRenderThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mGLRenderThread = null;
            this.mGLRenderHandler = null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        HandlerThread handlerThread;
        long max;
        Handler handler;
        if (this.mGLMapView == null) {
            return;
        }
        try {
            this.mLastFrameTime = System.currentTimeMillis();
            drawSingleFrame(gl10);
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = currentTimeMillis - this.mLastFrameTime;
            this.mLastFrameTime = currentTimeMillis;
            long j5 = this.mDrawFrameTickCount.get();
            if (this.mGLMapView.getRenderMode() != 0 || this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive()) {
                return;
            }
            long j6 = j5 - 1;
            this.mDrawFrameTickCount.set(j6);
            if (j6 > 0) {
                max = Math.max(16L, this.mTargetFrameDurationMillis - j4);
            } else if (j6 > -5) {
                max = 60;
            } else if (j6 > -7) {
                max = 100;
            } else if (j6 > -9) {
                max = 250;
            } else {
                max = this.mIsTrafficMode ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : 500L;
                this.mDrawFrameTickCount.set(-9L);
            }
            if (max <= 0 || (handler = this.mGLRenderHandler) == null) {
                return;
            }
            handler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessageDelayed(10, max);
        } catch (Throwable th) {
            u5.p(th, "GLMapRender", "onDrawFrame");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i4, int i5) {
        if (this.mSurfacedestoryed) {
            onSurfaceCreated(gl10, null);
        }
        this.mGLMapView.changeSurface(gl10, i4, i5);
        resetTickCount(30);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.mIsRendPause = false;
        this.mSurfacedestoryed = false;
        this.mGLMapView.createSurface(gl10, eGLConfig);
    }

    public void onSurfaceDestory() {
        this.mIsRendPause = true;
        Handler handler = this.mGLRenderHandler;
        if (handler != null && this.mGLRenderThread != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mGLMapView.destroySurface(this.mGLMapView.getNativeEngineID());
        this.mSurfacedestoryed = true;
    }

    public void renderPause() {
        HandlerThread handlerThread;
        if (this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = true;
    }

    public void renderResume() {
        HandlerThread handlerThread;
        if (this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = false;
        this.mDrawFrameTickCount.set(-1L);
        resetTickCount(30);
    }

    public void resetTickCount(int i4) {
        HandlerThread handlerThread;
        long j4 = this.mDrawFrameTickCount.get();
        if (this.mIsRendPause || (handlerThread = this.mGLRenderThread) == null || this.mGLRenderHandler == null || !handlerThread.isAlive()) {
            long j5 = i4;
            if (j4 < j5) {
                this.mDrawFrameTickCount.set(j5);
            }
        } else if (j4 <= 0) {
            this.mDrawFrameTickCount.set(i4);
            this.mGLRenderHandler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessage(10);
        } else {
            long j6 = i4;
            if (j4 < j6) {
                this.mDrawFrameTickCount.set(j6);
            }
        }
    }

    public void sendToRenderEvent(Runnable runnable) {
        HandlerThread handlerThread;
        if (this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive()) {
            return;
        }
        this.mGLRenderHandler.post(runnable);
    }

    public void setRenderFps(float f4) {
        if (this.mTargetRenderFPS == f4 || f4 <= 0.0f) {
            return;
        }
        this.mTargetFrameDurationMillis = (int) ((1.0f / f4) * 1000.0f);
        this.mTargetRenderFPS = f4;
    }

    public void setTrafficMode(boolean z3) {
        this.mIsTrafficMode = z3;
    }
}
