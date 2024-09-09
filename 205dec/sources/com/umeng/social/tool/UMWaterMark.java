package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    private float getDx(int i4) {
        int dip2px = dip2px(this.mLeftMargin);
        int i5 = -dip2px(this.mRightMargin);
        int i6 = this.mGravity & 7;
        if (i6 != 1) {
            return i6 != 5 ? dip2px : (i4 - getMarkWidth()) + i5;
        }
        if (dip2px == 0) {
            dip2px = i5;
        }
        return (((i4 - getMarkWidth()) * 1.0f) / 2.0f) + dip2px;
    }

    private float getDy(int i4) {
        int i5 = -dip2px(this.mBottomMargin);
        int dip2px = dip2px(this.mTopMargin);
        int i6 = this.mGravity & 112;
        if (i6 != 16) {
            return i6 != 80 ? dip2px : (i4 - getMarkHeight()) + i5;
        }
        if (dip2px != 0) {
            i5 = dip2px;
        }
        return (((i4 - getMarkHeight()) * 1.0f) / 2.0f) + i5;
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

    private float getRelativeDx(int i4) {
        Rect rect = this.mAnchorMarkRect;
        float f4 = rect.left;
        float f5 = rect.right;
        int i5 = this.mHorizontalRelativePosition;
        if (i5 != 3) {
            if (i5 != 4) {
                return getDx(i4);
            }
            return (-dip2px(this.mRightMargin)) + (f4 - getMarkWidth());
        }
        return dip2px(this.mLeftMargin) + f5;
    }

    private float getRelativeDy(int i4) {
        Rect rect = this.mAnchorMarkRect;
        float f4 = rect.top;
        float f5 = rect.bottom;
        int i5 = this.mVerticalRelativePosition;
        if (i5 != 1) {
            if (i5 != 2) {
                return getDy(i4);
            }
            return (-dip2px(this.mBottomMargin)) + (f4 - getMarkHeight());
        }
        return dip2px(this.mTopMargin) + f5;
    }

    private float getScaleAnchorX(int i4) {
        int i5 = this.mGravity & 7;
        if (i5 == 1) {
            i4 /= 2;
        } else if (i5 != 5) {
            return 0.0f;
        }
        return i4;
    }

    private float getScaleAnchorY(int i4) {
        int i5 = this.mGravity & 112;
        if (i5 == 16) {
            i4 /= 2;
        } else if (i5 != 80) {
            return 0.0f;
        }
        return i4;
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
                    int i4 = this.mDegree;
                    if (i4 != -1) {
                        matrix.postRotate(i4, markWidth / 2, markHeight / 2);
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

    int dip2px(float f4) {
        return (int) ((f4 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
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

    Rect onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (isHorizontalRelativePosition()) {
            i6 = 0;
            i7 = 0;
        } else {
            i6 = (int) getDx(i4);
            i7 = getMarkWidth() + i6;
        }
        if (isVerticalRelativePosition()) {
            i8 = 0;
        } else {
            i9 = (int) getDy(i5);
            i8 = getMarkHeight() + i9;
        }
        this.mMeasureRect.set(i6, i9, i7, i8);
        return this.mMeasureRect;
    }

    void releaseResource() {
    }

    public void setAlpha(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            return;
        }
        this.mAlpha = f4;
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

    public void setGravity(int i4) {
        if (i4 > 0 && this.mGravity != i4) {
            this.mGravity = i4;
        }
    }

    void setHorizontalRelativePosition(int i4) {
        this.mHorizontalRelativePosition = i4;
    }

    public void setMargins(int i4, int i5, int i6, int i7) {
        this.mLeftMargin = i4;
        this.mTopMargin = i5;
        this.mRightMargin = i6;
        this.mBottomMargin = i7;
    }

    public void setRotate(int i4) {
        if (i4 < 0 || i4 > 360) {
            return;
        }
        this.mDegree = i4;
    }

    public void setScale(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            return;
        }
        this.mScale = f4;
    }

    public void setTransparent() {
        this.mIsTransparent = true;
    }

    void setVerticalRelativePosition(int i4) {
        this.mVerticalRelativePosition = i4;
    }
}
