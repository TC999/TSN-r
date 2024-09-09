package com.autonavi.base.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLCrossVector extends GLOverlay {
    private long mDiceNativeInstance;

    public GLCrossVector(final int i4, final IAMapDelegate iAMapDelegate, int i5) {
        super(i4, iAMapDelegate, i5);
        this.mDiceNativeInstance = 0L;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.1
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i4, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.getId());
            }
        });
    }

    private static native void nativeAddVectorCar(long j4, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j4, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j4, Object obj, boolean z3);

    private static native void nativeSetArrowResId(long j4, boolean z3, int i4);

    private static native void nativeSetBackgroundResId(long j4, int i4);

    private static native void nativeSetCarResId(long j4, int i4);

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, final byte[] bArr, int i4) {
        if (aVectorCrossAttr == null || bArr == null || i4 == 0) {
            return -1;
        }
        Rect rect = aVectorCrossAttr.stAreaRect;
        final int[] iArr = {rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode ? 1 : 0};
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.2
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, iArr, bArr);
                }
            });
        }
        return 0;
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z3) {
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.3
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        long j4 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j4);
        super.releaseInstance();
    }

    public void setArrowResId(boolean z3, int i4) {
        nativeSetArrowResId(this.mNativeInstance, z3, i4);
    }

    public void setBackgroundResId(int i4) {
        nativeSetBackgroundResId(this.mNativeInstance, i4);
    }

    public void setCarResId(int i4) {
        nativeSetCarResId(this.mNativeInstance, i4);
    }
}
