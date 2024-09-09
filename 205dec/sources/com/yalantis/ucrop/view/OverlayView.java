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
import c1.d;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.util.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class OverlayView extends View {
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final boolean F = true;
    public static final boolean G = true;
    public static final boolean H = false;
    public static final int I = 0;
    public static final int J = 2;
    public static final int K = 2;
    private d A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f54473a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f54474b;

    /* renamed from: c  reason: collision with root package name */
    protected int f54475c;

    /* renamed from: d  reason: collision with root package name */
    protected int f54476d;

    /* renamed from: e  reason: collision with root package name */
    protected float[] f54477e;

    /* renamed from: f  reason: collision with root package name */
    protected float[] f54478f;

    /* renamed from: g  reason: collision with root package name */
    private int f54479g;

    /* renamed from: h  reason: collision with root package name */
    private int f54480h;

    /* renamed from: i  reason: collision with root package name */
    private float f54481i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f54482j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f54483k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f54484l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f54485m;

    /* renamed from: n  reason: collision with root package name */
    private int f54486n;

    /* renamed from: o  reason: collision with root package name */
    private Path f54487o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f54488p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f54489q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f54490r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f54491s;

    /* renamed from: t  reason: collision with root package name */
    private int f54492t;

    /* renamed from: u  reason: collision with root package name */
    private float f54493u;

    /* renamed from: v  reason: collision with root package name */
    private float f54494v;

    /* renamed from: w  reason: collision with root package name */
    private int f54495w;

    /* renamed from: x  reason: collision with root package name */
    private int f54496x;

    /* renamed from: y  reason: collision with root package name */
    private int f54497y;

    /* renamed from: z  reason: collision with root package name */
    private int f54498z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    private int c(float f4, float f5) {
        double d4 = this.f54496x;
        int i4 = -1;
        for (int i5 = 0; i5 < 8; i5 += 2) {
            double sqrt = Math.sqrt(Math.pow(f4 - this.f54477e[i5], 2.0d) + Math.pow(f5 - this.f54477e[i5 + 1], 2.0d));
            if (sqrt < d4) {
                i4 = i5 / 2;
                d4 = sqrt;
            }
        }
        if (this.f54492t == 1 && i4 < 0 && this.f54473a.contains(f4, f5)) {
            return 4;
        }
        return i4;
    }

    private void e(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.f54490r.setStrokeWidth(dimensionPixelSize);
        this.f54490r.setColor(color);
        this.f54490r.setStyle(Paint.Style.STROKE);
        this.f54491s.setStrokeWidth(dimensionPixelSize * 3);
        this.f54491s.setColor(color);
        this.f54491s.setStyle(Paint.Style.STROKE);
    }

    private void f(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.f54489q.setStrokeWidth(dimensionPixelSize);
        this.f54489q.setColor(color);
        this.f54479g = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.f54480h = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void j(float f4, float f5) {
        this.f54474b.set(this.f54473a);
        int i4 = this.f54495w;
        if (i4 == 0) {
            RectF rectF = this.f54474b;
            RectF rectF2 = this.f54473a;
            rectF.set(f4, f5, rectF2.right, rectF2.bottom);
        } else if (i4 == 1) {
            RectF rectF3 = this.f54474b;
            RectF rectF4 = this.f54473a;
            rectF3.set(rectF4.left, f5, f4, rectF4.bottom);
        } else if (i4 == 2) {
            RectF rectF5 = this.f54474b;
            RectF rectF6 = this.f54473a;
            rectF5.set(rectF6.left, rectF6.top, f4, f5);
        } else if (i4 == 3) {
            RectF rectF7 = this.f54474b;
            RectF rectF8 = this.f54473a;
            rectF7.set(f4, rectF8.top, rectF8.right, f5);
        } else if (i4 == 4) {
            this.f54474b.offset(f4 - this.f54493u, f5 - this.f54494v);
            if (this.f54474b.left <= getLeft() || this.f54474b.top <= getTop() || this.f54474b.right >= getRight() || this.f54474b.bottom >= getBottom()) {
                return;
            }
            this.f54473a.set(this.f54474b);
            k();
            postInvalidate();
            return;
        }
        boolean z3 = this.f54474b.height() >= ((float) this.f54497y);
        boolean z4 = this.f54474b.width() >= ((float) this.f54497y);
        RectF rectF9 = this.f54473a;
        rectF9.set(z4 ? this.f54474b.left : rectF9.left, z3 ? this.f54474b.top : rectF9.top, z4 ? this.f54474b.right : rectF9.right, z3 ? this.f54474b.bottom : rectF9.bottom);
        if (z3 || z4) {
            k();
            postInvalidate();
        }
    }

    private void k() {
        this.f54477e = g.b(this.f54473a);
        this.f54478f = g.a(this.f54473a);
        this.f54482j = null;
        this.f54487o.reset();
        this.f54487o.addCircle(this.f54473a.centerX(), this.f54473a.centerY(), Math.min(this.f54473a.width(), this.f54473a.height()) / 2.0f, Path.Direction.CW);
    }

    protected void a(@NonNull Canvas canvas) {
        if (this.f54484l) {
            if (this.f54482j == null && !this.f54473a.isEmpty()) {
                this.f54482j = new float[(this.f54479g * 4) + (this.f54480h * 4)];
                int i4 = 0;
                for (int i5 = 0; i5 < this.f54479g; i5++) {
                    float[] fArr = this.f54482j;
                    int i6 = i4 + 1;
                    RectF rectF = this.f54473a;
                    fArr[i4] = rectF.left;
                    int i7 = i6 + 1;
                    float f4 = i5 + 1.0f;
                    float height = rectF.height() * (f4 / (this.f54479g + 1));
                    RectF rectF2 = this.f54473a;
                    fArr[i6] = height + rectF2.top;
                    float[] fArr2 = this.f54482j;
                    int i8 = i7 + 1;
                    fArr2[i7] = rectF2.right;
                    i4 = i8 + 1;
                    fArr2[i8] = (rectF2.height() * (f4 / (this.f54479g + 1))) + this.f54473a.top;
                }
                for (int i9 = 0; i9 < this.f54480h; i9++) {
                    float[] fArr3 = this.f54482j;
                    int i10 = i4 + 1;
                    float f5 = i9 + 1.0f;
                    float width = this.f54473a.width() * (f5 / (this.f54480h + 1));
                    RectF rectF3 = this.f54473a;
                    fArr3[i4] = width + rectF3.left;
                    float[] fArr4 = this.f54482j;
                    int i11 = i10 + 1;
                    fArr4[i10] = rectF3.top;
                    int i12 = i11 + 1;
                    float width2 = rectF3.width() * (f5 / (this.f54480h + 1));
                    RectF rectF4 = this.f54473a;
                    fArr4[i11] = width2 + rectF4.left;
                    i4 = i12 + 1;
                    this.f54482j[i12] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f54482j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f54489q);
            }
        }
        if (this.f54483k) {
            canvas.drawRect(this.f54473a, this.f54490r);
        }
        if (this.f54492t != 0) {
            canvas.save();
            this.f54474b.set(this.f54473a);
            RectF rectF5 = this.f54474b;
            int i13 = this.f54498z;
            rectF5.inset(i13, -i13);
            canvas.clipRect(this.f54474b, Region.Op.DIFFERENCE);
            this.f54474b.set(this.f54473a);
            RectF rectF6 = this.f54474b;
            int i14 = this.f54498z;
            rectF6.inset(-i14, i14);
            canvas.clipRect(this.f54474b, Region.Op.DIFFERENCE);
            canvas.drawRect(this.f54473a, this.f54491s);
            canvas.restore();
        }
    }

    protected void b(@NonNull Canvas canvas) {
        canvas.save();
        if (this.f54485m) {
            canvas.clipPath(this.f54487o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f54473a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f54486n);
        canvas.restore();
        if (this.f54485m) {
            canvas.drawCircle(this.f54473a.centerX(), this.f54473a.centerY(), Math.min(this.f54473a.width(), this.f54473a.height()) / 2.0f, this.f54488p);
        }
    }

    protected void d() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Deprecated
    public boolean g() {
        return this.f54492t == 1;
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f54473a;
    }

    public int getFreestyleCropMode() {
        return this.f54492t;
    }

    public d getOverlayViewChangeListener() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@NonNull TypedArray typedArray) {
        this.f54485m = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.f54486n = color;
        this.f54488p.setColor(color);
        this.f54488p.setStyle(Paint.Style.STROKE);
        this.f54488p.setStrokeWidth(1.0f);
        e(typedArray);
        this.f54483k = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        f(typedArray);
        this.f54484l = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void i() {
        int i4 = this.f54475c;
        float f4 = this.f54481i;
        int i5 = (int) (i4 / f4);
        int i6 = this.f54476d;
        if (i5 > i6) {
            int i7 = (int) (i6 * f4);
            int i8 = (i4 - i7) / 2;
            this.f54473a.set(getPaddingLeft() + i8, getPaddingTop(), getPaddingLeft() + i7 + i8, getPaddingTop() + this.f54476d);
        } else {
            int i9 = (i6 - i5) / 2;
            this.f54473a.set(getPaddingLeft(), getPaddingTop() + i9, getPaddingLeft() + this.f54475c, getPaddingTop() + i5 + i9);
        }
        d dVar = this.A;
        if (dVar != null) {
            dVar.a(this.f54473a);
        }
        k();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f54475c = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f54476d = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.f54481i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f54473a.isEmpty() && this.f54492t != 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int c4 = c(x3, y3);
                this.f54495w = c4;
                boolean z3 = c4 != -1;
                if (!z3) {
                    this.f54493u = -1.0f;
                    this.f54494v = -1.0f;
                } else if (this.f54493u < 0.0f) {
                    this.f54493u = x3;
                    this.f54494v = y3;
                }
                return z3;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f54495w != -1) {
                float min = Math.min(Math.max(x3, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y3, getPaddingTop()), getHeight() - getPaddingBottom());
                j(min, min2);
                this.f54493u = min;
                this.f54494v = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.f54493u = -1.0f;
                this.f54494v = -1.0f;
                this.f54495w = -1;
                d dVar = this.A;
                if (dVar != null) {
                    dVar.a(this.f54473a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z3) {
        this.f54485m = z3;
    }

    public void setCropFrameColor(@ColorInt int i4) {
        this.f54490r.setColor(i4);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i4) {
        this.f54490r.setStrokeWidth(i4);
    }

    public void setCropGridColor(@ColorInt int i4) {
        this.f54489q.setColor(i4);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i4) {
        this.f54480h = i4;
        this.f54482j = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i4) {
        this.f54479g = i4;
        this.f54482j = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i4) {
        this.f54489q.setStrokeWidth(i4);
    }

    public void setDimmedColor(@ColorInt int i4) {
        this.f54486n = i4;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z3) {
        this.f54492t = z3 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i4) {
        this.f54492t = i4;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.A = dVar;
    }

    public void setShowCropFrame(boolean z3) {
        this.f54483k = z3;
    }

    public void setShowCropGrid(boolean z3) {
        this.f54484l = z3;
    }

    public void setTargetAspectRatio(float f4) {
        this.f54481i = f4;
        if (this.f54475c > 0) {
            i();
            postInvalidate();
            return;
        }
        this.B = true;
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54473a = new RectF();
        this.f54474b = new RectF();
        this.f54482j = null;
        this.f54487o = new Path();
        this.f54488p = new Paint(1);
        this.f54489q = new Paint(1);
        this.f54490r = new Paint(1);
        this.f54491s = new Paint(1);
        this.f54492t = 0;
        this.f54493u = -1.0f;
        this.f54494v = -1.0f;
        this.f54495w = -1;
        this.f54496x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f54497y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.f54498z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        d();
    }
}
