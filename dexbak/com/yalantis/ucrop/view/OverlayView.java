package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.C13495R;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p028c1.OverlayViewChangeListener;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OverlayView extends View {

    /* renamed from: C */
    public static final int f39955C = 0;

    /* renamed from: D */
    public static final int f39956D = 1;

    /* renamed from: E */
    public static final int f39957E = 2;

    /* renamed from: F */
    public static final boolean f39958F = true;

    /* renamed from: G */
    public static final boolean f39959G = true;

    /* renamed from: H */
    public static final boolean f39960H = false;

    /* renamed from: I */
    public static final int f39961I = 0;

    /* renamed from: J */
    public static final int f39962J = 2;

    /* renamed from: K */
    public static final int f39963K = 2;

    /* renamed from: A */
    private OverlayViewChangeListener f39964A;

    /* renamed from: B */
    private boolean f39965B;

    /* renamed from: a */
    private final RectF f39966a;

    /* renamed from: b */
    private final RectF f39967b;

    /* renamed from: c */
    protected int f39968c;

    /* renamed from: d */
    protected int f39969d;

    /* renamed from: e */
    protected float[] f39970e;

    /* renamed from: f */
    protected float[] f39971f;

    /* renamed from: g */
    private int f39972g;

    /* renamed from: h */
    private int f39973h;

    /* renamed from: i */
    private float f39974i;

    /* renamed from: j */
    private float[] f39975j;

    /* renamed from: k */
    private boolean f39976k;

    /* renamed from: l */
    private boolean f39977l;

    /* renamed from: m */
    private boolean f39978m;

    /* renamed from: n */
    private int f39979n;

    /* renamed from: o */
    private Path f39980o;

    /* renamed from: p */
    private Paint f39981p;

    /* renamed from: q */
    private Paint f39982q;

    /* renamed from: r */
    private Paint f39983r;

    /* renamed from: s */
    private Paint f39984s;

    /* renamed from: t */
    private int f39985t;

    /* renamed from: u */
    private float f39986u;

    /* renamed from: v */
    private float f39987v;

    /* renamed from: w */
    private int f39988w;

    /* renamed from: x */
    private int f39989x;

    /* renamed from: y */
    private int f39990y;

    /* renamed from: z */
    private int f39991z;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    private int m12949c(float f, float f2) {
        double d = this.f39989x;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double sqrt = Math.sqrt(Math.pow(f - this.f39970e[i2], 2.0d) + Math.pow(f2 - this.f39970e[i2 + 1], 2.0d));
            if (sqrt < d) {
                i = i2 / 2;
                d = sqrt;
            }
        }
        if (this.f39985t == 1 && i < 0 && this.f39966a.contains(f, f2)) {
            return 4;
        }
        return i;
    }

    /* renamed from: e */
    private void m12947e(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(C13495R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(C13495R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_frame));
        this.f39983r.setStrokeWidth(dimensionPixelSize);
        this.f39983r.setColor(color);
        this.f39983r.setStyle(Paint.Style.STROKE);
        this.f39984s.setStrokeWidth(dimensionPixelSize * 3);
        this.f39984s.setColor(color);
        this.f39984s.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: f */
    private void m12946f(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(C13495R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(C13495R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_grid));
        this.f39982q.setStrokeWidth(dimensionPixelSize);
        this.f39982q.setColor(color);
        this.f39972g = typedArray.getInt(C13495R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.f39973h = typedArray.getInt(C13495R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    /* renamed from: j */
    private void m12942j(float f, float f2) {
        this.f39967b.set(this.f39966a);
        int i = this.f39988w;
        if (i == 0) {
            RectF rectF = this.f39967b;
            RectF rectF2 = this.f39966a;
            rectF.set(f, f2, rectF2.right, rectF2.bottom);
        } else if (i == 1) {
            RectF rectF3 = this.f39967b;
            RectF rectF4 = this.f39966a;
            rectF3.set(rectF4.left, f2, f, rectF4.bottom);
        } else if (i == 2) {
            RectF rectF5 = this.f39967b;
            RectF rectF6 = this.f39966a;
            rectF5.set(rectF6.left, rectF6.top, f, f2);
        } else if (i == 3) {
            RectF rectF7 = this.f39967b;
            RectF rectF8 = this.f39966a;
            rectF7.set(f, rectF8.top, rectF8.right, f2);
        } else if (i == 4) {
            this.f39967b.offset(f - this.f39986u, f2 - this.f39987v);
            if (this.f39967b.left <= getLeft() || this.f39967b.top <= getTop() || this.f39967b.right >= getRight() || this.f39967b.bottom >= getBottom()) {
                return;
            }
            this.f39966a.set(this.f39967b);
            m12941k();
            postInvalidate();
            return;
        }
        boolean z = this.f39967b.height() >= ((float) this.f39990y);
        boolean z2 = this.f39967b.width() >= ((float) this.f39990y);
        RectF rectF9 = this.f39966a;
        rectF9.set(z2 ? this.f39967b.left : rectF9.left, z ? this.f39967b.top : rectF9.top, z2 ? this.f39967b.right : rectF9.right, z ? this.f39967b.bottom : rectF9.bottom);
        if (z || z2) {
            m12941k();
            postInvalidate();
        }
    }

    /* renamed from: k */
    private void m12941k() {
        this.f39970e = RectUtils.m12981b(this.f39966a);
        this.f39971f = RectUtils.m12982a(this.f39966a);
        this.f39975j = null;
        this.f39980o.reset();
        this.f39980o.addCircle(this.f39966a.centerX(), this.f39966a.centerY(), Math.min(this.f39966a.width(), this.f39966a.height()) / 2.0f, Path.Direction.CW);
    }

    /* renamed from: a */
    protected void m12951a(@NonNull Canvas canvas) {
        if (this.f39977l) {
            if (this.f39975j == null && !this.f39966a.isEmpty()) {
                this.f39975j = new float[(this.f39972g * 4) + (this.f39973h * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.f39972g; i2++) {
                    float[] fArr = this.f39975j;
                    int i3 = i + 1;
                    RectF rectF = this.f39966a;
                    fArr[i] = rectF.left;
                    int i4 = i3 + 1;
                    float f = i2 + 1.0f;
                    float height = rectF.height() * (f / (this.f39972g + 1));
                    RectF rectF2 = this.f39966a;
                    fArr[i3] = height + rectF2.top;
                    float[] fArr2 = this.f39975j;
                    int i5 = i4 + 1;
                    fArr2[i4] = rectF2.right;
                    i = i5 + 1;
                    fArr2[i5] = (rectF2.height() * (f / (this.f39972g + 1))) + this.f39966a.top;
                }
                for (int i6 = 0; i6 < this.f39973h; i6++) {
                    float[] fArr3 = this.f39975j;
                    int i7 = i + 1;
                    float f2 = i6 + 1.0f;
                    float width = this.f39966a.width() * (f2 / (this.f39973h + 1));
                    RectF rectF3 = this.f39966a;
                    fArr3[i] = width + rectF3.left;
                    float[] fArr4 = this.f39975j;
                    int i8 = i7 + 1;
                    fArr4[i7] = rectF3.top;
                    int i9 = i8 + 1;
                    float width2 = rectF3.width() * (f2 / (this.f39973h + 1));
                    RectF rectF4 = this.f39966a;
                    fArr4[i8] = width2 + rectF4.left;
                    i = i9 + 1;
                    this.f39975j[i9] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f39975j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f39982q);
            }
        }
        if (this.f39976k) {
            canvas.drawRect(this.f39966a, this.f39983r);
        }
        if (this.f39985t != 0) {
            canvas.save();
            this.f39967b.set(this.f39966a);
            RectF rectF5 = this.f39967b;
            int i10 = this.f39991z;
            rectF5.inset(i10, -i10);
            canvas.clipRect(this.f39967b, Region.Op.DIFFERENCE);
            this.f39967b.set(this.f39966a);
            RectF rectF6 = this.f39967b;
            int i11 = this.f39991z;
            rectF6.inset(-i11, i11);
            canvas.clipRect(this.f39967b, Region.Op.DIFFERENCE);
            canvas.drawRect(this.f39966a, this.f39984s);
            canvas.restore();
        }
    }

    /* renamed from: b */
    protected void m12950b(@NonNull Canvas canvas) {
        canvas.save();
        if (this.f39978m) {
            canvas.clipPath(this.f39980o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f39966a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f39979n);
        canvas.restore();
        if (this.f39978m) {
            canvas.drawCircle(this.f39966a.centerX(), this.f39966a.centerY(), Math.min(this.f39966a.width(), this.f39966a.height()) / 2.0f, this.f39981p);
        }
    }

    /* renamed from: d */
    protected void m12948d() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Deprecated
    /* renamed from: g */
    public boolean m12945g() {
        return this.f39985t == 1;
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f39966a;
    }

    public int getFreestyleCropMode() {
        return this.f39985t;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.f39964A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m12944h(@NonNull TypedArray typedArray) {
        this.f39978m = typedArray.getBoolean(C13495R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(C13495R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(C13495R.C13497color.ucrop_color_default_dimmed));
        this.f39979n = color;
        this.f39981p.setColor(color);
        this.f39981p.setStyle(Paint.Style.STROKE);
        this.f39981p.setStrokeWidth(1.0f);
        m12947e(typedArray);
        this.f39976k = typedArray.getBoolean(C13495R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        m12946f(typedArray);
        this.f39977l = typedArray.getBoolean(C13495R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    /* renamed from: i */
    public void m12943i() {
        int i = this.f39968c;
        float f = this.f39974i;
        int i2 = (int) (i / f);
        int i3 = this.f39969d;
        if (i2 > i3) {
            int i4 = (int) (i3 * f);
            int i5 = (i - i4) / 2;
            this.f39966a.set(getPaddingLeft() + i5, getPaddingTop(), getPaddingLeft() + i4 + i5, getPaddingTop() + this.f39969d);
        } else {
            int i6 = (i3 - i2) / 2;
            this.f39966a.set(getPaddingLeft(), getPaddingTop() + i6, getPaddingLeft() + this.f39968c, getPaddingTop() + i2 + i6);
        }
        OverlayViewChangeListener overlayViewChangeListener = this.f39964A;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.mo12915a(this.f39966a);
        }
        m12941k();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m12950b(canvas);
        m12951a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f39968c = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f39969d = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.f39965B) {
                this.f39965B = false;
                setTargetAspectRatio(this.f39974i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f39966a.isEmpty() && this.f39985t != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int m12949c = m12949c(x, y);
                this.f39988w = m12949c;
                boolean z = m12949c != -1;
                if (!z) {
                    this.f39986u = -1.0f;
                    this.f39987v = -1.0f;
                } else if (this.f39986u < 0.0f) {
                    this.f39986u = x;
                    this.f39987v = y;
                }
                return z;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f39988w != -1) {
                float min = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                m12942j(min, min2);
                this.f39986u = min;
                this.f39987v = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.f39986u = -1.0f;
                this.f39987v = -1.0f;
                this.f39988w = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.f39964A;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.mo12915a(this.f39966a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z) {
        this.f39978m = z;
    }

    public void setCropFrameColor(@ColorInt int i) {
        this.f39983r.setColor(i);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i) {
        this.f39983r.setStrokeWidth(i);
    }

    public void setCropGridColor(@ColorInt int i) {
        this.f39982q.setColor(i);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i) {
        this.f39973h = i;
        this.f39975j = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i) {
        this.f39972g = i;
        this.f39975j = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i) {
        this.f39982q.setStrokeWidth(i);
    }

    public void setDimmedColor(@ColorInt int i) {
        this.f39979n = i;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.f39985t = z ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.f39985t = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.f39964A = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z) {
        this.f39976k = z;
    }

    public void setShowCropGrid(boolean z) {
        this.f39977l = z;
    }

    public void setTargetAspectRatio(float f) {
        this.f39974i = f;
        if (this.f39968c > 0) {
            m12943i();
            postInvalidate();
            return;
        }
        this.f39965B = true;
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39966a = new RectF();
        this.f39967b = new RectF();
        this.f39975j = null;
        this.f39980o = new Path();
        this.f39981p = new Paint(1);
        this.f39982q = new Paint(1);
        this.f39983r = new Paint(1);
        this.f39984s = new Paint(1);
        this.f39985t = 0;
        this.f39986u = -1.0f;
        this.f39987v = -1.0f;
        this.f39988w = -1;
        this.f39989x = getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f39990y = getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_rect_min_size);
        this.f39991z = getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        m12948d();
    }
}
