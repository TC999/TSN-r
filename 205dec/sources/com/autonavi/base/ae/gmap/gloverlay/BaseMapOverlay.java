package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public BaseMapOverlay(int i4, Context context, IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = i4;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e4);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t3 = this.mGLOverlay;
            if (t3 != null) {
                t3.removeAll();
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public final E getItem(int i4) {
        try {
            synchronized (this.mItemList) {
                if (i4 >= 0 && i4 <= this.mItemList.size() - 1) {
                    return this.mItemList.get(i4);
                }
                return null;
            }
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    protected abstract void iniGLOverlay();

    public boolean isClickable() {
        T t3 = this.mGLOverlay;
        if (t3 != null) {
            return t3.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t3 = this.mGLOverlay;
        if (t3 != null) {
            return t3.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i4) {
        if (i4 >= 0) {
            try {
                if (i4 > this.mItemList.size() - 1) {
                    return;
                }
                if (i4 == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i4);
                T t3 = this.mGLOverlay;
                if (t3 != null) {
                    t3.removeItem(i4);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z3) {
        T t3 = this.mGLOverlay;
        if (t3 != null) {
            t3.setClickable(z3);
        }
    }

    public abstract void setVisible(boolean z3);

    public void removeItem(E e4) {
        if (e4 == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e4));
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }
}
