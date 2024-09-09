package com.baidu.idl.face.platform.ui.widget;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
    private float mR;
    private int mSuccessActiveCount;
    private Paint mTextSecondPaint;
    private Paint mTextTopPaint;
    private String mTipSecondText;
    private String mTipTopText;
    private int mTotalActiveCount;
    private float mX;
    private float mY;
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
        for (int i4 = 0; i4 < 360; i4 += 6) {
            float f4 = this.mR;
            canvas.drawLine(f4 + 40.0f, 0.0f, f4 + 40.0f + 25.0f, 0.0f, this.mCircleLinePaint);
            canvas.rotate(6.0f);
        }
        canvas.restore();
    }

    private void drawSuccessCircleLine(Canvas canvas) {
        int i4 = (int) ((this.mSuccessActiveCount / this.mTotalActiveCount) * 360.0f);
        canvas.save();
        canvas.rotate(-90.0f);
        for (int i5 = 0; i5 < i4; i5 += 6) {
            float f4 = this.mR;
            canvas.drawLine(f4 + 40.0f, 0.0f, f4 + 40.0f + 25.0f, 0.0f, this.mCircleLineSelectPaint);
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

    public static Rect getPreviewDetectRect(int i4, int i5, int i6) {
        float f4 = i4 / 2;
        float f5 = f4 - (0.33f * f4);
        float f6 = i5 / 2;
        float f7 = i6 / 2;
        float f8 = f7 - (0.1f * f7);
        if (f6 <= f5) {
            f5 = f6;
        }
        float f9 = (0.2f * f5) + f5;
        return new Rect((int) (f6 - f5), (int) (f8 - f9), (int) (f6 + f5), (int) (f8 + f9));
    }

    public Rect getFaceRoundRect() {
        Rect rect = this.mFaceRect;
        if (rect != null) {
            Log.e(TAG, rect.toString());
        }
        return this.mFaceRect;
    }

    public float getRound() {
        return this.mR;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        canvas.drawPaint(this.mBGPaint);
        canvas.drawCircle(this.mX, this.mY, this.mR, this.mFaceRoundPaint);
        if (!TextUtils.isEmpty(this.mTipSecondText)) {
            canvas.drawText(this.mTipSecondText, this.mX, (((this.mY - this.mR) - 40.0f) - 25.0f) - 59.0f, this.mTextSecondPaint);
        }
        if (!TextUtils.isEmpty(this.mTipTopText)) {
            canvas.drawText(this.mTipTopText, this.mX, ((((this.mY - this.mR) - 40.0f) - 25.0f) - 59.0f) - 90.0f, this.mTextTopPaint);
        }
        if (this.mIsActiveLive) {
            canvas.translate(this.mX, this.mY);
            drawCircleLine(canvas);
            drawSuccessCircleLine(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        float f4 = (i6 - i4) / 2.0f;
        float f5 = (i7 - i5) / 2.0f;
        float f6 = f5 - (0.1f * f5);
        float f7 = f4 - (0.33f * f4);
        if (this.mFaceRect == null) {
            this.mFaceRect = new Rect((int) (f4 - f7), (int) (f6 - f7), (int) (f4 + f7), (int) (f6 + f7));
        }
        if (this.mFaceDetectRect == null) {
            float f8 = (0.2f * f7) + f7;
            this.mFaceDetectRect = new Rect((int) (f4 - f7), (int) (f6 - f8), (int) (f4 + f7), (int) (f8 + f6));
        }
        this.mX = f4;
        this.mY = f6;
        this.mR = f7;
    }

    public void setFaceInfo(FaceExtInfo faceExtInfo) {
        this.mFaceExtInfo = faceExtInfo;
        postInvalidate();
    }

    public void setIsActiveLive(boolean z3) {
        this.mIsActiveLive = z3;
    }

    public void setProcessCount(int i4, int i5) {
        this.mSuccessActiveCount = i4;
        this.mTotalActiveCount = i5;
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

    public static Rect getPreviewDetectRect(int i4, int i5, int i6, int i7) {
        float f4 = i4 / 2;
        float f5 = f4 - (0.33f * f4);
        float f6 = i6;
        float f7 = (i4 * 1.0f) / (f6 * 1.0f);
        mRatioX = f7;
        float f8 = i7;
        float f9 = (i5 * 1.0f) / (1.0f * f8);
        mRatioY = f9;
        float f10 = f6 / 2.0f;
        float f11 = f10 * f7;
        float f12 = f8 / 2.0f;
        float f13 = (f12 * f9) - ((f12 * f9) * 0.1f);
        if (f10 * f7 <= f5) {
            f5 = f10 * f7;
        }
        float f14 = (0.2f * f5) + f5;
        return new Rect((int) (f11 - f5), (int) (f13 - f14), (int) (f11 + f5), (int) (f13 + f14));
    }
}
