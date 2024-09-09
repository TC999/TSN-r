package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class GLOverlay {
    protected int mCode;
    protected int mEngineID;
    protected IAMapDelegate mGLMapView;
    protected boolean isNightStyle = false;
    boolean mIsInBundle = false;
    protected long mNativeInstance = 0;
    protected int mItemPriority = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum EAMapOverlayTpye {
        AMAPOVERLAY_ARROW(4),
        AMAPOVERLAY_VECTOR(5),
        AMAPROUTE_OVERLAY(16);
        
        private int id;

        EAMapOverlayTpye(int i4) {
            this.id = i4;
        }

        public final int getId() {
            return this.id;
        }
    }

    public GLOverlay(int i4, IAMapDelegate iAMapDelegate, int i5) {
        this.mEngineID = i4;
        this.mGLMapView = iAMapDelegate;
        this.mCode = i5;
    }

    private static native int nativeGetCount(long j4);

    private static native int nativeGetOverlayPriority(long j4);

    private static native int nativeGetSubType(long j4);

    private static native int nativeGetType(long j4);

    private static native boolean nativeIsClickable(long j4);

    private static native boolean nativeIsVisible(long j4);

    private static native void nativeRemoveAll(long j4);

    private static native void nativeRemoveItem(long j4, int i4);

    private static native void nativeSetClickable(long j4, boolean z3);

    private static native void nativeSetMaxDisplayLevel(long j4, float f4);

    private static native void nativeSetMinDisplayLevel(long j4, float f4);

    private static native void nativeSetOverlayOnTop(long j4, boolean z3);

    private static native void nativeSetOverlayPriority(long j4, int i4);

    private static native void nativeSetOverlayPriorityOnly(long j4, int i4);

    protected static native void nativeSetVisible(long j4, boolean z3);

    public void clearFocus() {
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return 0;
        }
        return nativeGetCount(j4);
    }

    public int getSubType() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return -1;
        }
        return nativeGetSubType(j4);
    }

    public int getType() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return -1;
        }
        return nativeGetType(j4);
    }

    public boolean isClickable() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeIsClickable(j4);
    }

    public boolean isVisible() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeIsVisible(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseInstance() {
        if (this.mNativeInstance != 0) {
            this.mNativeInstance = 0L;
        }
    }

    public void removeAll() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveAll(j4);
    }

    public void removeItem(int i4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveItem(j4, i4);
    }

    public void setClickable(boolean z3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetClickable(j4, z3);
    }

    public void setMaxDisplayLevel(float f4) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f4);
    }

    public void setMinDisplayLevel(float f4) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f4);
    }

    public void setOverlayItemPriority(int i4) {
        this.mItemPriority = i4;
    }

    public void setOverlayOnTop(boolean z3) {
        nativeSetOverlayOnTop(this.mNativeInstance, z3);
    }

    public void setOverlayPriority(int i4) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i4);
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || (overlayBundle = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID)) == null) {
            return;
        }
        overlayBundle.sortOverlay();
    }

    public void setOverlayPriorityOnly(int i4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetOverlayPriorityOnly(j4, i4);
    }

    public void setVisible(boolean z3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetVisible(j4, z3);
    }

    public void useNightStyle(boolean z3) {
        this.isNightStyle = z3;
    }
}
