package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Rectangle {
    @JBindingInclude
    private int beyond180Mode;
    public float bottom;
    public FPoint[] clipMapRect;
    public IPoint[] clipRect;
    @JBindingInclude
    private int[] jniClipRect;
    public float left;
    public Rect rect;
    public float right;

    /* renamed from: top  reason: collision with root package name */
    public float f12058top;

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    private void updateClipMapRect(int i4, int i5) {
        int i6 = 0;
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect = this.rect;
        if (rect != null) {
            FPoint[] fPointArr2 = this.clipMapRect;
            FPoint fPoint = fPointArr2[0];
            int i7 = rect.left;
            ((PointF) fPoint).x = i7 - i4;
            FPoint fPoint2 = fPointArr2[0];
            int i8 = rect.top;
            ((PointF) fPoint2).y = i8 - i5;
            FPoint fPoint3 = fPointArr2[1];
            int i9 = rect.right;
            ((PointF) fPoint3).x = i9 - i4;
            ((PointF) fPointArr2[1]).y = i8 - i5;
            ((PointF) fPointArr2[2]).x = i9 - i4;
            FPoint fPoint4 = fPointArr2[2];
            int i10 = rect.bottom;
            ((PointF) fPoint4).y = i10 - i5;
            ((PointF) fPointArr2[3]).x = i7 - i4;
            ((PointF) fPointArr2[3]).y = i10 - i5;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            FPoint[] fPointArr3 = this.clipMapRect;
            if (i6 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i11 = i6 * 2;
            iArr[i11] = (int) ((PointF) fPointArr3[i6]).x;
            iArr[i11 + 1] = (int) ((PointF) fPointArr3[i6]).y;
            i6++;
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect = this.rect;
        if (rect != null) {
            IPoint[] iPointArr2 = this.clipRect;
            IPoint iPoint = iPointArr2[0];
            int i4 = rect.left;
            ((Point) iPoint).x = i4;
            IPoint iPoint2 = iPointArr2[0];
            int i5 = rect.top;
            ((Point) iPoint2).y = i5;
            IPoint iPoint3 = iPointArr2[1];
            int i6 = rect.right;
            ((Point) iPoint3).x = i6;
            ((Point) iPointArr2[1]).y = i5;
            ((Point) iPointArr2[2]).x = i6;
            IPoint iPoint4 = iPointArr2[2];
            int i7 = rect.bottom;
            ((Point) iPoint4).y = i7;
            ((Point) iPointArr2[3]).x = i4;
            ((Point) iPointArr2[3]).y = i7;
        }
    }

    public boolean contains(int i4, int i5) {
        Rect rect = this.rect;
        if (rect != null) {
            if (rect.contains(i4, i5)) {
                return true;
            }
            if (this.beyond180Mode != 0) {
                return this.rect.contains(i4 - 268435456, i5) || this.rect.contains(i4 + 268435456, i5);
            }
            return false;
        }
        return false;
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(Rect rect) {
        Rect rect2 = this.rect;
        if (rect2 != null && rect != null) {
            int width = rect2.left + rect2.width();
            int i4 = rect.left;
            if (width > i4) {
                int width2 = i4 + rect.width();
                Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.top + rect3.height();
                    int i5 = rect.top;
                    if (height > i5 && i5 + rect.height() > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void updateRect(Rect rect, int i4, int i5) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            Rect rect2 = this.rect;
            int i6 = rect2.right;
            if ((rect2.left / 100000.0f) * (i6 / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i6 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i4, i5);
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((Point) iPoint).x, ((Point) iPoint).y);
    }

    public boolean isOverlap(int i4, int i5, int i6, int i7) {
        Rect rect = this.rect;
        if (rect != null && rect.left + rect.width() > i4) {
            int i8 = i4 + i6;
            Rect rect2 = this.rect;
            if (i8 > rect2.left && rect2.top + rect2.height() > i5 && i5 + i7 > this.rect.top) {
                return true;
            }
        }
        return false;
    }

    public Rectangle(Rect rect, int i4, int i5) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i4, i5);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    public boolean contains(Rect rect) {
        if (rect == null) {
            return false;
        }
        return this.rect.contains(rect);
    }

    public Rectangle(float f4, float f5, float f6, float f7) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f4 >= f5 || f7 <= f6) {
            return;
        }
        this.left = f4;
        this.right = f5;
        this.f12058top = f7;
        this.bottom = f6;
    }
}
