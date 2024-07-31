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
import com.kwad.sdk.p430d.p431a.C10751a;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
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
        float f = this.aSs;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f3 = elapsedRealtime >= 1500 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.aSw.setLocalMatrix(this.mMatrix);
            this.aSp.setShader(this.aSw);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aSs) / 100.0f) * f3, getHeight(), this.aSp);
            if (elapsedRealtime > 500 && elapsedRealtime <= 1500) {
                f2 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.aSs) / 100.0f) * f2;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
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
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aSu = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSv = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSo.setShader(this.aSu);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aSw = linearGradient;
        this.aSp.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            float f = this.aSs;
            if (f <= 0.0f || f >= 100.0f) {
                return;
            }
            this.mStartTime = SystemClock.elapsedRealtime();
            post(this.aSx);
            return;
        }
        removeCallbacks(this.aSx);
    }

    public void setProgress(float f) {
        this.aSs = f;
        invalidate();
        if (f != 0.0f && f != 100.0f) {
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

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        paint.setTextSize(C10751a.m24924a(context, 16.0f));
        this.aSq.setColor(-1);
        this.aSq.setTextAlign(Paint.Align.CENTER);
        this.aSt = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }
}
