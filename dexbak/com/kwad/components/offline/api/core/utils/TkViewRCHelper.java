package com.kwad.components.offline.api.core.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.C11151h;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TkViewRCHelper {
    private boolean mClipBackground;
    @NonNull
    private C11151h.C11152a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class CornerConf {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public boolean isLeftTop() {
            return this.leftTop;
        }

        public boolean isRightBottom() {
            return this.rightBottom;
        }

        public boolean isTopRight() {
            return this.topRight;
        }

        public void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }

        public CornerConf setBottomLeft(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public CornerConf setLeftTop(boolean z) {
            this.leftTop = z;
            return this;
        }

        public CornerConf setRightBottom(boolean z) {
            this.rightBottom = z;
            return this;
        }

        public CornerConf setTopRight(boolean z) {
            this.topRight = z;
            return this;
        }
    }

    public TkViewRCHelper() {
        this.radiusArray = new float[8];
        this.mCornerConf = new C11151h.C11152a();
    }

    private Path getPath() {
        float[] radius;
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        if (this.mRadius == 0.0f) {
            radius = this.radiusArray;
        } else {
            radius = getRadius();
        }
        this.mPath.addRoundRect(this.mRectF, radius, Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        this.radiusArray[0] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[1] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[2] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[3] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[4] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[5] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[6] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        this.radiusArray[7] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        return this.radiusArray;
    }

    public void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            canvas.save();
            canvas.clipPath(getPath());
            return;
        }
        canvas.saveLayer(this.mRectF, null, 31);
    }

    public void beforeDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.mRectF, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    @NonNull
    public C11151h.C11152a getCornerConf() {
        return this.mCornerConf;
    }

    public void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void onSizeChanged(int i, int i2) {
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public TkViewRCHelper(C11151h.C11152a c11152a) {
        this.radiusArray = new float[8];
        if (c11152a == null) {
            this.mCornerConf = new C11151h.C11152a();
        } else {
            this.mCornerConf = c11152a;
        }
    }
}
