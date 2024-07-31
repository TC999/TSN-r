package com.baidu.idl.face.platform.p049ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.utils.DensityUtils;

/* renamed from: com.baidu.idl.face.platform.ui.widget.FaceDetectRoundView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceDetectRoundView extends View {
    public static final int CIRCLE_LINE_WIDTH = 3;
    public static final float HEIGHT_EXT_RATIO = 0.2f;
    public static final float HEIGHT_RATIO = 0.1f;
    public static final int PATH_SMALL_SPACE = 12;
    public static final int PATH_SPACE = 16;
    public static final float RECT_RATIO = 0.9f;
    public static final float SURFACE_HEIGHT = 1000.0f;
    public static final float SURFACE_RATIO = 0.75f;
    public static final float WIDTH_SPACE_RATIO = 0.33f;
    private static float mRatioX;
    private static float mRatioY;
    private Paint mBGPaint;
    private Paint mCircleLinePaint;
    private Paint mCircleLineSelectPaint;
    private Rect mFaceDetectRect;
    private FaceExtInfo mFaceExtInfo;
    private Rect mFaceRect;
    private Paint mFaceRoundPaint;
    private boolean mIsActiveLive;

    /* renamed from: mR */
    private float f8435mR;
    private int mSuccessActiveCount;
    private Paint mTextSecondPaint;
    private Paint mTextTopPaint;
    private String mTipSecondText;
    private String mTipTopText;
    private int mTotalActiveCount;

    /* renamed from: mX */
    private float f8436mX;

    /* renamed from: mY */
    private float f8437mY;
    private static final String TAG = FaceDetectRoundView.class.getSimpleName();
    public static final int COLOR_BG = Color.parseColor("#FFFFFF");
    public static final int COLOR_ROUND = Color.parseColor("#FFA800");
    public static final int COLOR_CIRCLE_LINE = Color.parseColor("#CCCCCC");
    public static final int COLOR_CIRCLE_SELECT_LINE = Color.parseColor("#00BAF2");

    public FaceDetectRoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        float dip2px = DensityUtils.dip2px(context, 3.0f);
        Paint paint = new Paint(1);
        this.mBGPaint = paint;
        paint.setColor(COLOR_BG);
        this.mBGPaint.setStyle(Paint.Style.FILL);
        this.mBGPaint.setAntiAlias(true);
        this.mBGPaint.setDither(true);
        Paint paint2 = new Paint(1);
        this.mFaceRoundPaint = paint2;
        paint2.setColor(COLOR_ROUND);
        this.mFaceRoundPaint.setStyle(Paint.Style.FILL);
        this.mFaceRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFaceRoundPaint.setAntiAlias(true);
        this.mFaceRoundPaint.setDither(true);
        Paint paint3 = new Paint(1);
        this.mCircleLinePaint = paint3;
        paint3.setColor(COLOR_CIRCLE_LINE);
        this.mCircleLinePaint.setStrokeWidth(dip2px);
        this.mCircleLinePaint.setStyle(Paint.Style.STROKE);
        this.mCircleLinePaint.setAntiAlias(true);
        this.mCircleLinePaint.setDither(true);
        Paint paint4 = new Paint(1);
        this.mCircleLineSelectPaint = paint4;
        paint4.setColor(COLOR_CIRCLE_SELECT_LINE);
        this.mCircleLineSelectPaint.setStrokeWidth(dip2px);
        this.mCircleLineSelectPaint.setStyle(Paint.Style.STROKE);
        this.mCircleLineSelectPaint.setAntiAlias(true);
        this.mCircleLineSelectPaint.setDither(true);
        Paint paint5 = new Paint(1);
        this.mTextSecondPaint = paint5;
        paint5.setColor(Color.parseColor("#666666"));
        this.mTextSecondPaint.setTextSize(DensityUtils.dip2px(getContext(), 16.0f));
        this.mTextSecondPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextSecondPaint.setAntiAlias(true);
        this.mTextSecondPaint.setDither(true);
        Paint paint6 = new Paint(1);
        this.mTextTopPaint = paint6;
        paint6.setColor(Color.parseColor("#000000"));
        this.mTextTopPaint.setTextSize(DensityUtils.dip2px(getContext(), 22.0f));
        this.mTextTopPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextTopPaint.setAntiAlias(true);
        this.mTextTopPaint.setDither(true);
    }

    private void drawCircleLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(-90.0f);
        for (int i = 0; i < 360; i += 6) {
            float f = this.f8435mR;
            canvas.drawLine(f + 40.0f, 0.0f, f + 40.0f + 25.0f, 0.0f, this.mCircleLinePaint);
            canvas.rotate(6.0f);
        }
        canvas.restore();
    }

    private void drawSuccessCircleLine(Canvas canvas) {
        int i = (int) ((this.mSuccessActiveCount / this.mTotalActiveCount) * 360.0f);
        canvas.save();
        canvas.rotate(-90.0f);
        for (int i2 = 0; i2 < i; i2 += 6) {
            float f = this.f8435mR;
            canvas.drawLine(f + 40.0f, 0.0f, f + 40.0f + 25.0f, 0.0f, this.mCircleLineSelectPaint);
            canvas.rotate(6.0f);
        }
        canvas.restore();
    }

    public static Rect getFaceInfoRect(FaceExtInfo faceExtInfo) {
        if (faceExtInfo == null) {
            return null;
        }
        return faceExtInfo.getFaceRect(mRatioX, mRatioY, 0.75f);
    }

    public static Rect getPreviewDetectRect(int i, int i2, int i3) {
        float f = i / 2;
        float f2 = f - (0.33f * f);
        float f3 = i2 / 2;
        float f4 = i3 / 2;
        float f5 = f4 - (0.1f * f4);
        if (f3 <= f2) {
            f2 = f3;
        }
        float f6 = (0.2f * f2) + f2;
        return new Rect((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
    }

    public Rect getFaceRoundRect() {
        Rect rect = this.mFaceRect;
        if (rect != null) {
            Log.e(TAG, rect.toString());
        }
        return this.mFaceRect;
    }

    public float getRound() {
        return this.f8435mR;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        canvas.drawPaint(this.mBGPaint);
        canvas.drawCircle(this.f8436mX, this.f8437mY, this.f8435mR, this.mFaceRoundPaint);
        if (!TextUtils.isEmpty(this.mTipSecondText)) {
            canvas.drawText(this.mTipSecondText, this.f8436mX, (((this.f8437mY - this.f8435mR) - 40.0f) - 25.0f) - 59.0f, this.mTextSecondPaint);
        }
        if (!TextUtils.isEmpty(this.mTipTopText)) {
            canvas.drawText(this.mTipTopText, this.f8436mX, ((((this.f8437mY - this.f8435mR) - 40.0f) - 25.0f) - 59.0f) - 90.0f, this.mTextTopPaint);
        }
        if (this.mIsActiveLive) {
            canvas.translate(this.f8436mX, this.f8437mY);
            drawCircleLine(canvas);
            drawSuccessCircleLine(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = (i3 - i) / 2.0f;
        float f2 = (i4 - i2) / 2.0f;
        float f3 = f2 - (0.1f * f2);
        float f4 = f - (0.33f * f);
        if (this.mFaceRect == null) {
            this.mFaceRect = new Rect((int) (f - f4), (int) (f3 - f4), (int) (f + f4), (int) (f3 + f4));
        }
        if (this.mFaceDetectRect == null) {
            float f5 = (0.2f * f4) + f4;
            this.mFaceDetectRect = new Rect((int) (f - f4), (int) (f3 - f5), (int) (f + f4), (int) (f5 + f3));
        }
        this.f8436mX = f;
        this.f8437mY = f3;
        this.f8435mR = f4;
    }

    public void setFaceInfo(FaceExtInfo faceExtInfo) {
        this.mFaceExtInfo = faceExtInfo;
        postInvalidate();
    }

    public void setIsActiveLive(boolean z) {
        this.mIsActiveLive = z;
    }

    public void setProcessCount(int i, int i2) {
        this.mSuccessActiveCount = i;
        this.mTotalActiveCount = i2;
        postInvalidate();
    }

    public void setTipSecondText(String str) {
        this.mTipSecondText = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        invalidate();
    }

    public void setTipTopText(String str) {
        this.mTipTopText = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        invalidate();
    }

    public static Rect getPreviewDetectRect(int i, int i2, int i3, int i4) {
        float f = i / 2;
        float f2 = f - (0.33f * f);
        float f3 = i3;
        float f4 = (i * 1.0f) / (f3 * 1.0f);
        mRatioX = f4;
        float f5 = i4;
        float f6 = (i2 * 1.0f) / (1.0f * f5);
        mRatioY = f6;
        float f7 = f3 / 2.0f;
        float f8 = f7 * f4;
        float f9 = f5 / 2.0f;
        float f10 = (f9 * f6) - ((f9 * f6) * 0.1f);
        if (f7 * f4 <= f2) {
            f2 = f7 * f4;
        }
        float f11 = (0.2f * f2) + f2;
        return new Rect((int) (f8 - f2), (int) (f10 - f11), (int) (f8 + f2), (int) (f10 + f11));
    }
}
