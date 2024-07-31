package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    public float f47176top;

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    private void updateClipMapRect(int i, int i2) {
        int i3 = 0;
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
            int i4 = rect.left;
            ((PointF) fPoint).x = i4 - i;
            FPoint fPoint2 = fPointArr2[0];
            int i5 = rect.top;
            ((PointF) fPoint2).y = i5 - i2;
            FPoint fPoint3 = fPointArr2[1];
            int i6 = rect.right;
            ((PointF) fPoint3).x = i6 - i;
            ((PointF) fPointArr2[1]).y = i5 - i2;
            ((PointF) fPointArr2[2]).x = i6 - i;
            FPoint fPoint4 = fPointArr2[2];
            int i7 = rect.bottom;
            ((PointF) fPoint4).y = i7 - i2;
            ((PointF) fPointArr2[3]).x = i4 - i;
            ((PointF) fPointArr2[3]).y = i7 - i2;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            FPoint[] fPointArr3 = this.clipMapRect;
            if (i3 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i8 = i3 * 2;
            iArr[i8] = (int) ((PointF) fPointArr3[i3]).x;
            iArr[i8 + 1] = (int) ((PointF) fPointArr3[i3]).y;
            i3++;
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
            int i = rect.left;
            ((Point) iPoint).x = i;
            IPoint iPoint2 = iPointArr2[0];
            int i2 = rect.top;
            ((Point) iPoint2).y = i2;
            IPoint iPoint3 = iPointArr2[1];
            int i3 = rect.right;
            ((Point) iPoint3).x = i3;
            ((Point) iPointArr2[1]).y = i2;
            ((Point) iPointArr2[2]).x = i3;
            IPoint iPoint4 = iPointArr2[2];
            int i4 = rect.bottom;
            ((Point) iPoint4).y = i4;
            ((Point) iPointArr2[3]).x = i;
            ((Point) iPointArr2[3]).y = i4;
        }
    }

    public boolean contains(int i, int i2) {
        Rect rect = this.rect;
        if (rect != null) {
            if (rect.contains(i, i2)) {
                return true;
            }
            if (this.beyond180Mode != 0) {
                return this.rect.contains(i - 268435456, i2) || this.rect.contains(i + 268435456, i2);
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
            int i = rect.left;
            if (width > i) {
                int width2 = i + rect.width();
                Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.top + rect3.height();
                    int i2 = rect.top;
                    if (height > i2 && i2 + rect.height() > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void updateRect(Rect rect, int i, int i2) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            Rect rect2 = this.rect;
            int i3 = rect2.right;
            if ((rect2.left / 100000.0f) * (i3 / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i3 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i, i2);
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((Point) iPoint).x, ((Point) iPoint).y);
    }

    public boolean isOverlap(int i, int i2, int i3, int i4) {
        Rect rect = this.rect;
        if (rect != null && rect.left + rect.width() > i) {
            int i5 = i + i3;
            Rect rect2 = this.rect;
            if (i5 > rect2.left && rect2.top + rect2.height() > i2 && i2 + i4 > this.rect.top) {
                return true;
            }
        }
        return false;
    }

    public Rectangle(Rect rect, int i, int i2) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i, i2);
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

    public Rectangle(float f, float f2, float f3, float f4) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f >= f2 || f4 <= f3) {
            return;
        }
        this.left = f;
        this.right = f2;
        this.f47176top = f4;
        this.bottom = f3;
    }
}
