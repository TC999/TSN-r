package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;

/* renamed from: com.kwad.sdk.widget.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11151h {
    private boolean mClipBackground;
    @NonNull
    private C11152a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* renamed from: com.kwad.sdk.widget.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11152a {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        /* renamed from: cf */
        public final C11152a m23531cf(boolean z) {
            this.leftTop = z;
            return this;
        }

        /* renamed from: cg */
        public final C11152a m23530cg(boolean z) {
            this.topRight = z;
            return this;
        }

        /* renamed from: ch */
        public final C11152a m23529ch(boolean z) {
            this.rightBottom = z;
            return this;
        }

        /* renamed from: ci */
        public final C11152a m23528ci(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }
    }

    public C11151h() {
        this.radiusArray = new float[8];
        this.mCornerConf = new C11152a();
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

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            canvas.save();
            canvas.clipPath(getPath());
            return;
        }
        canvas.saveLayer(this.mRectF, null, 31);
    }

    public final void beforeDraw(Canvas canvas) {
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
    public final C11152a getCornerConf() {
        return this.mCornerConf;
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int i = C9659R.attr.ksad_radius;
                int i2 = C9659R.attr.ksad_clipBackground;
                int[] iArr = {i, i2};
                Arrays.sort(iArr);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
                this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
                this.mClipBackground = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void onSizeChanged(int i, int i2) {
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public final void setRadius(float f) {
        this.mRadius = f;
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public C11151h(C11152a c11152a) {
        this.radiusArray = new float[8];
        this.mCornerConf = c11152a;
    }
}
