package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class GLAmapFocusHits {
        public long mOverlayHashCode = 0;
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
    }

    public GLOverlayBundle(int i4, IAMapDelegate iAMapDelegate) {
        this.mNativeInstance = 0L;
        this.mEngineID = i4;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    private int getOverlyExType(E e4) {
        return 0;
    }

    public static void intClr2PVRClr(float[] fArr, int i4) {
        fArr[2] = (i4 & 255) / 255.0f;
        fArr[1] = ((i4 >> 8) & 255) / 255.0f;
        fArr[0] = ((i4 >> 16) & 255) / 255.0f;
        fArr[3] = ((i4 >> 24) & 255) / 255.0f;
    }

    private static native void nativeAddGLOverlay(long j4, long j5, long j6);

    private static native void nativeAddGLOverlayEx(long j4, long j5, long j6, int i4);

    private static native void nativeClearAllGLOverlay(long j4, boolean z3);

    private static native boolean nativeOnSingleTapLineOverlay(long j4, int i4, int i5, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j4, int i4, int i5, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j4, long j5);

    private static native void nativeRemoveGLOverlayEx(long j4, long j5, int i4);

    private static native void nativeSortAllGLOverlay(long j4);

    public void addOverlay(E e4) {
        if (e4 == null) {
            return;
        }
        nativeAddGLOverlay(this.mNativeInstance, e4.getGLOverlay().getNativeInstatnce(), e4.getGLOverlay().getCode());
        e4.getGLOverlay().mIsInBundle = true;
        synchronized (this.mOverlayList) {
            this.mOverlayList.add(e4);
        }
    }

    public boolean addOverlayTextureItem(int i4, int i5, int i6, int i7) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i4, i5, i6, i7);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i4, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i4, int i5) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i4, i5, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public long checkSingleTapOnPoint(int i4, int i5) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i4, i5, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i4 = 0; i4 < this.mOverlayList.size(); i4++) {
                    E e4 = this.mOverlayList.get(i4);
                    if (e4 != null) {
                        e4.clearFocus();
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e4) {
        boolean contains;
        if (e4 == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e4);
        }
        return contains;
    }

    public E getOverlay(int i4) {
        synchronized (this.mOverlayList) {
            if (i4 >= 0) {
                if (i4 <= this.mOverlayList.size() - 1) {
                    return this.mOverlayList.get(i4);
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i4) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i4);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i4, int i5, int i6, int i7) {
        boolean onSingleTapPoints = (i7 & 1) == 1 ? onSingleTapPoints(i4, i5, i6) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i7 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i4, i5, i6);
        }
        return onSingleTapPoints;
    }

    boolean onSingleTapLines(int i4, int i5, int i6) {
        return false;
    }

    boolean onSingleTapPoints(int i4, int i5, int i6) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }

    public void removeAll(boolean z3) {
        nativeClearAllGLOverlay(this.mNativeInstance, z3);
        synchronized (this.mOverlayList) {
            for (int i4 = 0; i4 < this.mOverlayList.size(); i4++) {
                E e4 = this.mOverlayList.get(i4);
                if (e4 != null) {
                    e4.getGLOverlay().mIsInBundle = false;
                    e4.getGLOverlay().releaseInstance();
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e4) {
        if (e4 == null) {
            return;
        }
        nativeRemoveGLOverlay(this.mNativeInstance, e4.getGLOverlay().getNativeInstatnce());
        e4.getGLOverlay().mIsInBundle = false;
        synchronized (this.mOverlayList) {
            this.mOverlayList.remove(e4);
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public boolean addOverlayTextureItem(int i4, int i5, float f4, float f5, int i6, int i7) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i4, i5, f4, f5, i6, i7);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i4, gLOverlayTexture);
        }
        return true;
    }
}
