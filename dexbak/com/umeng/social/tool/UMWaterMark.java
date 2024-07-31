package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class UMWaterMark {
    static final int RELATIVE_POSITION_HORIZONTAL_LEFT = 4;
    static final int RELATIVE_POSITION_HORIZONTAL_RIGHT = 3;
    static final int RELATIVE_POSITION_VERTICAL_BOTTOM = 1;
    static final int RELATIVE_POSITION_VERTICAL_TOP = 2;
    private static final String TAG = "UMWaterMark";
    private int mBottomMargin;
    private Context mContext;
    private int mLeftMargin;
    private int mRightMargin;
    private int mTopMargin;
    private float mScale = 0.3f;
    private Rect mAnchorMarkRect = new Rect();
    private int mVerticalRelativePosition = -1;
    private int mHorizontalRelativePosition = -1;
    private int mGravity = 51;
    private boolean mIsTransparent = false;
    private boolean mIsBringToFront = false;
    private float mAlpha = -1.0f;
    private int mDegree = -1;
    private Rect mMeasureRect = new Rect();

    private float getDx(int i) {
        int dip2px = dip2px(this.mLeftMargin);
        int i2 = -dip2px(this.mRightMargin);
        int i3 = this.mGravity & 7;
        if (i3 != 1) {
            return i3 != 5 ? dip2px : (i - getMarkWidth()) + i2;
        }
        if (dip2px == 0) {
            dip2px = i2;
        }
        return (((i - getMarkWidth()) * 1.0f) / 2.0f) + dip2px;
    }

    private float getDy(int i) {
        int i2 = -dip2px(this.mBottomMargin);
        int dip2px = dip2px(this.mTopMargin);
        int i3 = this.mGravity & 112;
        if (i3 != 16) {
            return i3 != 80 ? dip2px : (i - getMarkHeight()) + i2;
        }
        if (dip2px != 0) {
            i2 = dip2px;
        }
        return (((i - getMarkHeight()) * 1.0f) / 2.0f) + i2;
    }

    private int getMarkHeight() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getHeight();
    }

    private int getMarkWidth() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getWidth();
    }

    private float getRelativeDx(int i) {
        Rect rect = this.mAnchorMarkRect;
        float f = rect.left;
        float f2 = rect.right;
        int i2 = this.mHorizontalRelativePosition;
        if (i2 != 3) {
            if (i2 != 4) {
                return getDx(i);
            }
            return (-dip2px(this.mRightMargin)) + (f - getMarkWidth());
        }
        return dip2px(this.mLeftMargin) + f2;
    }

    private float getRelativeDy(int i) {
        Rect rect = this.mAnchorMarkRect;
        float f = rect.top;
        float f2 = rect.bottom;
        int i2 = this.mVerticalRelativePosition;
        if (i2 != 1) {
            if (i2 != 2) {
                return getDy(i);
            }
            return (-dip2px(this.mBottomMargin)) + (f - getMarkHeight());
        }
        return dip2px(this.mTopMargin) + f2;
    }

    private float getScaleAnchorX(int i) {
        int i2 = this.mGravity & 7;
        if (i2 == 1) {
            i /= 2;
        } else if (i2 != 5) {
            return 0.0f;
        }
        return i;
    }

    private float getScaleAnchorY(int i) {
        int i2 = this.mGravity & 112;
        if (i2 == 16) {
            i /= 2;
        } else if (i2 != 80) {
            return 0.0f;
        }
        return i;
    }

    private void safelyRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception unused) {
            }
        }
    }

    public void bringToFront() {
        this.mIsBringToFront = true;
    }

    void clearRelativePosition() {
        this.mHorizontalRelativePosition = -1;
        this.mVerticalRelativePosition = -1;
    }

    public Bitmap compound(Bitmap bitmap) {
        Bitmap createBitmap;
        Canvas canvas;
        try {
            if (bitmap == null) {
                Log.e(TAG, "scr bitmap is null");
                return null;
            }
            Bitmap markBitmap = getMarkBitmap();
            if (markBitmap == null) {
                Log.e(TAG, "mark bitmap is null");
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                int markWidth = getMarkWidth();
                int markHeight = getMarkHeight();
                if (markWidth > 0 && markHeight > 0) {
                    if (this.mIsTransparent) {
                        createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        canvas = new Canvas(createBitmap);
                        canvas.drawColor(0);
                    } else {
                        createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                        canvas = new Canvas(createBitmap);
                    }
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    Matrix matrix = new Matrix();
                    float min = (this.mScale * Math.min(bitmap.getWidth(), bitmap.getHeight())) / Math.max(markWidth, markHeight);
                    matrix.postScale(min, min, getScaleAnchorX(markWidth), getScaleAnchorY(markHeight));
                    int i = this.mDegree;
                    if (i != -1) {
                        matrix.postRotate(i, markWidth / 2, markHeight / 2);
                    }
                    matrix.postTranslate(isHorizontalRelativePosition() ? getRelativeDx(width) : getDx(width), isVerticalRelativePosition() ? getRelativeDy(height) : getDy(height));
                    if (this.mAlpha != -1.0f) {
                        Paint paint = new Paint();
                        paint.setAlpha((int) (this.mAlpha * 255.0f));
                        canvas.drawBitmap(markBitmap, matrix, paint);
                    } else {
                        canvas.drawBitmap(markBitmap, matrix, null);
                    }
                    safelyRecycleBitmap(bitmap);
                    safelyRecycleBitmap(markBitmap);
                    releaseResource();
                    return createBitmap;
                }
                String str = TAG;
                Log.e(str, "mark bitmap is error, markWidth:" + markWidth + ", markHeight:" + markHeight);
                return bitmap;
            }
            String str2 = TAG;
            Log.e(str2, "mark bitmap is error, markWidth:" + width + ", markHeight:" + height);
            return bitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    int dip2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    Bitmap getMarkBitmap() {
        return null;
    }

    boolean isBringToFront() {
        return this.mIsBringToFront;
    }

    boolean isHorizontalRelativePosition() {
        return this.mHorizontalRelativePosition != -1;
    }

    boolean isVerticalRelativePosition() {
        return this.mVerticalRelativePosition != -1;
    }

    Rect onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (isHorizontalRelativePosition()) {
            i3 = 0;
            i4 = 0;
        } else {
            i3 = (int) getDx(i);
            i4 = getMarkWidth() + i3;
        }
        if (isVerticalRelativePosition()) {
            i5 = 0;
        } else {
            i6 = (int) getDy(i2);
            i5 = getMarkHeight() + i6;
        }
        this.mMeasureRect.set(i3, i6, i4, i5);
        return this.mMeasureRect;
    }

    void releaseResource() {
    }

    public void setAlpha(float f) {
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        this.mAlpha = f;
    }

    void setAnchorMarkHorizontalRect(Rect rect) {
        Rect rect2 = this.mAnchorMarkRect;
        rect2.set(rect.left, rect2.top, rect.right, rect2.bottom);
    }

    void setAnchorMarkVerticalRect(Rect rect) {
        this.mAnchorMarkRect = rect;
        rect.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setGravity(int i) {
        if (i > 0 && this.mGravity != i) {
            this.mGravity = i;
        }
    }

    void setHorizontalRelativePosition(int i) {
        this.mHorizontalRelativePosition = i;
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.mLeftMargin = i;
        this.mTopMargin = i2;
        this.mRightMargin = i3;
        this.mBottomMargin = i4;
    }

    public void setRotate(int i) {
        if (i < 0 || i > 360) {
            return;
        }
        this.mDegree = i;
    }

    public void setScale(float f) {
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        this.mScale = f;
    }

    public void setTransparent() {
        this.mIsTransparent = true;
    }

    void setVerticalRelativePosition(int i) {
        this.mVerticalRelativePosition = i;
    }
}
