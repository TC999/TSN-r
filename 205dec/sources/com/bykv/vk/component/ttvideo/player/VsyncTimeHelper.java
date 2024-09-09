package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.stub.StubApp;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class VsyncTimeHelper {
    private static final double DEFAULT_REFRESH_RATE = 16.0d;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final long TIME_UNSET = -9223372036854775807L;
    private final DefaultDisplayListener displayListener;
    private long vsyncDurationNs;
    private final UIVSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(17)
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i4) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i4) {
            if (i4 == 0) {
                VsyncTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i4) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class UIVSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final String BUNDLE_TIMESTAMP = "time";
        private static final String BUNDLE_VSYNC_DURATION = "vsync";
        private static final UIVSyncSampler INSTANCE = new UIVSyncSampler();
        private static final int MSG_ADD_OBSERVER = 0;
        private static final int MSG_REMOVE_OBSERVER = 1;
        private static final int MSG_UPDATE_VSYNC_DURATION = 4;
        private static final int MSG_VSYNC_COMING = 2;
        private static final String TAG = "UIVSyncSampler";
        private Bundle bundle;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private int currentUIFps;
        private final Handler handler;
        private int lowestUIFps;
        private final Handler mainHandler;
        private int observerCount;
        private long uiVsyncDurationNs;
        private long vsyncSampleCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;
        public volatile long lastSampledVsyncTimeNs = -9223372036854775807L;
        public volatile int skipedFrameCount = 0;

        private UIVSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("Vsync:Handler");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper(), this);
            this.bundle = new Bundle();
            Handler handler = new Handler(Looper.getMainLooper());
            this.mainHandler = handler;
            handler.post(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.VsyncTimeHelper.UIVSyncSampler.1
                @Override // java.lang.Runnable
                public void run() {
                    UIVSyncSampler.this.choreographer = Choreographer.getInstance();
                    if (UIVSyncSampler.this.observerCount > 0) {
                        UIVSyncSampler.this.choreographer.postFrameCallback(UIVSyncSampler.INSTANCE);
                    }
                }
            });
        }

        private void addObserverInternal() {
            Choreographer choreographer;
            int i4 = this.observerCount + 1;
            this.observerCount = i4;
            if (i4 != 1 || (choreographer = this.choreographer) == null) {
                return;
            }
            choreographer.postFrameCallback(this);
        }

        public static UIVSyncSampler getInstance() {
            return INSTANCE;
        }

        private void recordUIFps(long j4) {
            if (this.uiVsyncDurationNs == 0) {
                return;
            }
            this.vsyncSampleCount++;
            this.sampledVsyncTimeNs = j4;
            if (this.lastSampledVsyncTimeNs == -9223372036854775807L) {
                this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
                return;
            }
            long j5 = this.sampledVsyncTimeNs - this.lastSampledVsyncTimeNs;
            if (j5 <= 0) {
                this.lastSampledVsyncTimeNs = -9223372036854775807L;
                return;
            }
            long j6 = this.uiVsyncDurationNs;
            this.skipedFrameCount += j5 - j6 > 0 ? Math.round(((float) (j5 - j6)) / ((float) j6)) : 0;
            int i4 = (int) (1000000000 / j5);
            this.currentUIFps = i4;
            int i5 = this.lowestUIFps;
            if (i5 != 0) {
                i4 = Math.min(i5, i4);
            }
            this.lowestUIFps = i4;
            this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
        }

        private void removeObserverInternal() {
            Choreographer choreographer;
            int i4 = this.observerCount - 1;
            this.observerCount = i4;
            if (i4 != 0 || (choreographer = this.choreographer) == null) {
                return;
            }
            choreographer.removeFrameCallback(this);
            this.sampledVsyncTimeNs = -9223372036854775807L;
            this.lastSampledVsyncTimeNs = -9223372036854775807L;
            this.skipedFrameCount = 0;
            this.currentUIFps = 0;
            this.lowestUIFps = 0;
            this.vsyncSampleCount = 0L;
        }

        private void updateUIVsyncDurationNs(long j4) {
            this.uiVsyncDurationNs = j4;
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(0);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j4) {
            Message obtainMessage = this.handler.obtainMessage(2);
            this.bundle.putLong("time", j4);
            obtainMessage.setData(this.bundle);
            obtainMessage.sendToTarget();
            this.choreographer.postFrameCallback(this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 0) {
                addObserverInternal();
                return true;
            } else if (i4 == 1) {
                removeObserverInternal();
                return true;
            } else if (i4 == 2) {
                recordUIFps(message.getData().getLong("time"));
                return true;
            } else if (i4 != 4) {
                return false;
            } else {
                updateUIVsyncDurationNs(message.getData().getLong(BUNDLE_VSYNC_DURATION));
                return true;
            }
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void updateVsyncDuration(long j4) {
            this.bundle.putLong(BUNDLE_VSYNC_DURATION, j4);
            Message obtainMessage = this.handler.obtainMessage(4);
            obtainMessage.setData(this.bundle);
            obtainMessage.sendToTarget();
        }
    }

    @CalledByNative
    public VsyncTimeHelper(TTPlayer tTPlayer) {
        this(tTPlayer != null ? tTPlayer.getContext() : null);
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            this.vsyncDurationNs = (long) (1.0E9d / refreshRate);
        } else {
            this.vsyncDurationNs = 62500000L;
        }
        this.vsyncSampler.updateVsyncDuration(this.vsyncDurationNs);
    }

    @CalledByNative
    public void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    @CalledByNative
    public void enable() {
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    @CalledByNative
    public int getLowestUIFps() {
        return this.vsyncSampler.lowestUIFps;
    }

    @CalledByNative
    public int getUIFps() {
        return this.vsyncSampler.currentUIFps;
    }

    @CalledByNative
    public long getVsyncDurationNs() {
        return this.vsyncDurationNs;
    }

    public VsyncTimeHelper(Context context) {
        if (context != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = UIVSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
    }
}
