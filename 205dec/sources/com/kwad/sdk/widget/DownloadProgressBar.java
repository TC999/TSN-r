package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DownloadProgressBar extends View {
    Paint aSo;
    Paint aSp;
    Paint aSq;
    private String aSr;
    private float aSs;
    private Rect aSt;
    private LinearGradient aSu;
    private LinearGradient aSv;
    private LinearGradient aSw;
    private Runnable aSx;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aSx);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.aSo.setShader(this.aSu);
        canvas.drawRect(this.mRectF, this.aSo);
        this.aSo.setShader(this.aSv);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aSs) / 100.0f, getHeight(), this.aSo);
        float f4 = this.aSs;
        float f5 = 0.0f;
        if (f4 > 0.0f && f4 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f6 = elapsedRealtime >= 1500 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f6);
            this.aSw.setLocalMatrix(this.mMatrix);
            this.aSp.setShader(this.aSw);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aSs) / 100.0f) * f6, getHeight(), this.aSp);
            if (elapsedRealtime > 500 && elapsedRealtime <= 1500) {
                f5 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.aSs) / 100.0f) * f5;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f6);
            this.aSw.setLocalMatrix(this.mMatrix);
            this.aSp.setShader(this.aSw);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.aSp);
        }
        String str = this.aSr;
        if (str != null) {
            this.aSq.getTextBounds(str, 0, str.length(), this.aSt);
            Rect rect = this.aSt;
            canvas.drawText(this.aSr, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.aSq);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.aSu = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSv = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSo.setShader(this.aSu);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSw = linearGradient;
        this.aSp.setShader(linearGradient);
        float f4 = i4;
        this.mRectF.set(0.0f, 0.0f, f4, i5);
        this.mPath.reset();
        float f5 = f4 / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f5, f5, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i4) {
        super.onVisibilityChanged(view, i4);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (i4 == 0) {
            float f4 = this.aSs;
            if (f4 <= 0.0f || f4 >= 100.0f) {
                return;
            }
            this.mStartTime = SystemClock.elapsedRealtime();
            post(this.aSx);
            return;
        }
        removeCallbacks(this.aSx);
    }

    public void setProgress(float f4) {
        this.aSs = f4;
        invalidate();
        if (f4 != 0.0f && f4 != 100.0f) {
            if (getWindowVisibility() == 0 && this.mStartTime == 0) {
                post(this.aSx);
                return;
            }
            return;
        }
        removeCallbacks(this.aSx);
    }

    public void setText(String str) {
        this.aSr = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.aSx = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aSo = new Paint(1);
        this.aSp = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.aSq = paint;
        paint.setTextSize(com.kwad.sdk.d.a.a.a(context, 16.0f));
        this.aSq.setColor(-1);
        this.aSq.setTextAlign(Paint.Align.CENTER);
        this.aSt = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }
}
