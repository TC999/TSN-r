package com.bytedance.sdk.component.adexpress.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BrushMaskView extends View {

    /* renamed from: c  reason: collision with root package name */
    private static final String f29485c = BrushMaskView.class.getSimpleName();
    private Path ev;

    /* renamed from: f  reason: collision with root package name */
    private BitmapDrawable f29486f;
    private Path gd;

    /* renamed from: p  reason: collision with root package name */
    private Paint f29487p;

    /* renamed from: r  reason: collision with root package name */
    private Paint f29488r;
    private Canvas sr;
    private Paint ux;

    /* renamed from: w  reason: collision with root package name */
    private Paint f29489w;
    private Bitmap xv;

    public BrushMaskView(Context context) {
        super(context);
        c(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.xv;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.ux);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        setMeasuredDimension(c(i4), c(i5));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        c(i4, i5);
    }

    public void setEraserSize(float f4) {
        this.f29488r.setStrokeWidth(f4);
        this.f29487p.setStrokeWidth(f4);
    }

    public void setMaskColor(int i4) {
        this.f29489w.setColor(i4);
    }

    @RequiresApi(api = 21)
    public void setWatermark(int i4) {
        if (i4 == -1) {
            this.f29486f = null;
        } else {
            this.f29486f = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i4));
        }
    }

    public void xv() {
        final int width = getWidth();
        final int height = getHeight();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400L);
        valueAnimator.setIntValues(0, width);
        valueAnimator.setInterpolator(new TimeInterpolator() { // from class: com.bytedance.sdk.component.adexpress.widget.BrushMaskView.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f4) {
                int i4 = (int) (width * f4);
                if (BrushMaskView.this.sr != null) {
                    Canvas canvas = BrushMaskView.this.sr;
                    int i5 = height;
                    canvas.drawRect(0.0f, i5 / 2, i4 - 50, i5 / 2, BrushMaskView.this.f29488r);
                    BrushMaskView.this.sr.drawCircle(i4, height / 2, 10.0f, BrushMaskView.this.f29488r);
                }
                BrushMaskView.this.postInvalidate();
                return f4;
            }
        });
        valueAnimator.start();
    }

    private void c(Context context) {
        Paint paint = new Paint();
        this.f29489w = paint;
        paint.setAntiAlias(true);
        this.f29489w.setDither(true);
        setMaskColor(-1426063361);
        Paint paint2 = new Paint();
        this.ux = paint2;
        paint2.setAntiAlias(true);
        this.ux.setDither(true);
        Paint paint3 = new Paint();
        this.f29487p = paint3;
        paint3.setColor(-7829368);
        this.f29487p.setAlpha(100);
        this.f29487p.setAntiAlias(true);
        this.f29487p.setDither(true);
        this.f29487p.setStyle(Paint.Style.STROKE);
        this.f29487p.setStrokeCap(Paint.Cap.ROUND);
        if (Build.VERSION.SDK_INT >= 21) {
            setWatermark(-1);
        } else {
            setMaskColor(-1426063361);
        }
        Paint paint4 = new Paint();
        this.f29488r = paint4;
        paint4.setAntiAlias(true);
        this.f29488r.setDither(true);
        this.f29488r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f29488r.setStyle(Paint.Style.STROKE);
        this.f29488r.setStrokeCap(Paint.Cap.ROUND);
        setEraserSize(60.0f);
        this.ev = new Path();
        this.gd = new Path();
    }

    private void w(float f4, float f5) {
        this.ev.reset();
        this.gd.reset();
        this.ev.moveTo(f4, f5);
        this.gd.moveTo(f4, f5);
    }

    public void w() {
        xv();
    }

    public void c(float f4, float f5) {
        w(f4, f5);
        invalidate();
    }

    private void c(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            this.xv = createBitmap;
            Canvas canvas = this.sr;
            if (canvas == null) {
                this.sr = new Canvas(this.xv);
            } else {
                canvas.setBitmap(createBitmap);
            }
            this.sr.drawRoundRect(new RectF(0.0f, 0.0f, i4, i5), 120.0f, 120.0f, this.f29489w);
            if (this.f29486f != null) {
                this.f29486f.setBounds(new Rect(0, 0, i4, i5));
                this.f29486f.draw(this.sr);
            }
        } catch (Exception e4) {
            a.f(f29485c, e4.getMessage());
        }
    }

    private int c(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void c() {
        c(getWidth(), getHeight());
        invalidate();
    }
}
