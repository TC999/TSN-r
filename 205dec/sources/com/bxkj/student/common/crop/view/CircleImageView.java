package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CircleImageView extends AppCompatImageView {
    private static final boolean A = false;

    /* renamed from: u  reason: collision with root package name */
    private static final ImageView.ScaleType f19506u = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: v  reason: collision with root package name */
    private static final Bitmap.Config f19507v = Bitmap.Config.ARGB_8888;

    /* renamed from: w  reason: collision with root package name */
    private static final int f19508w = 2;

    /* renamed from: x  reason: collision with root package name */
    private static final int f19509x = 0;

    /* renamed from: y  reason: collision with root package name */
    private static final int f19510y = -16777216;

    /* renamed from: z  reason: collision with root package name */
    private static final int f19511z = 0;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f19512a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f19513b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f19514c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f19515d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f19516e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f19517f;

    /* renamed from: g  reason: collision with root package name */
    private int f19518g;

    /* renamed from: h  reason: collision with root package name */
    private int f19519h;

    /* renamed from: i  reason: collision with root package name */
    private int f19520i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f19521j;

    /* renamed from: k  reason: collision with root package name */
    private BitmapShader f19522k;

    /* renamed from: l  reason: collision with root package name */
    private int f19523l;

    /* renamed from: m  reason: collision with root package name */
    private int f19524m;

    /* renamed from: n  reason: collision with root package name */
    private float f19525n;

    /* renamed from: o  reason: collision with root package name */
    private float f19526o;

    /* renamed from: p  reason: collision with root package name */
    private ColorFilter f19527p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19528q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f19529r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19530s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f19531t;

    public CircleImageView(Context context) {
        super(context);
        this.f19512a = new RectF();
        this.f19513b = new RectF();
        this.f19514c = new Matrix();
        this.f19515d = new Paint();
        this.f19516e = new Paint();
        this.f19517f = new Paint();
        this.f19518g = -16777216;
        this.f19519h = 0;
        this.f19520i = 0;
        d();
    }

    private void b() {
        Paint paint = this.f19515d;
        if (paint != null) {
            paint.setColorFilter(this.f19527p);
        }
    }

    private RectF c() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f4 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f4, f4 + paddingTop);
    }

    private void d() {
        super.setScaleType(f19506u);
        this.f19528q = true;
        if (this.f19529r) {
            setup();
            this.f19529r = false;
        }
    }

    private void e() {
        if (this.f19531t) {
            this.f19521j = null;
        } else {
            this.f19521j = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f19507v);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f19507v);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void setup() {
        int i4;
        if (!this.f19528q) {
            this.f19529r = true;
        } else if (getWidth() == 0 && getHeight() == 0) {
        } else {
            if (this.f19521j == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.f19521j;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f19522k = new BitmapShader(bitmap, tileMode, tileMode);
            this.f19515d.setAntiAlias(true);
            this.f19515d.setShader(this.f19522k);
            this.f19516e.setStyle(Paint.Style.STROKE);
            this.f19516e.setAntiAlias(true);
            this.f19516e.setColor(this.f19518g);
            this.f19516e.setStrokeWidth(this.f19519h);
            this.f19517f.setStyle(Paint.Style.FILL);
            this.f19517f.setAntiAlias(true);
            this.f19517f.setColor(this.f19520i);
            this.f19524m = this.f19521j.getHeight();
            this.f19523l = this.f19521j.getWidth();
            this.f19513b.set(c());
            this.f19526o = Math.min((this.f19513b.height() - this.f19519h) / 2.0f, (this.f19513b.width() - this.f19519h) / 2.0f);
            this.f19512a.set(this.f19513b);
            if (!this.f19530s && (i4 = this.f19519h) > 0) {
                this.f19512a.inset(i4 - 1.0f, i4 - 1.0f);
            }
            this.f19525n = Math.min(this.f19512a.height() / 2.0f, this.f19512a.width() / 2.0f);
            b();
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.f19514c.set(null);
        float f4 = 0.0f;
        if (this.f19523l * this.f19512a.height() > this.f19512a.width() * this.f19524m) {
            width = this.f19512a.height() / this.f19524m;
            f4 = (this.f19512a.width() - (this.f19523l * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f19512a.width() / this.f19523l;
            height = (this.f19512a.height() - (this.f19524m * width)) * 0.5f;
        }
        this.f19514c.setScale(width, width);
        Matrix matrix = this.f19514c;
        RectF rectF = this.f19512a;
        matrix.postTranslate(((int) (f4 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.f19522k.setLocalMatrix(this.f19514c);
    }

    public boolean f() {
        return this.f19530s;
    }

    public boolean g() {
        return this.f19531t;
    }

    public int getBorderColor() {
        return this.f19518g;
    }

    public int getBorderWidth() {
        return this.f19519h;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f19527p;
    }

    @Deprecated
    public int getFillColor() {
        return this.f19520i;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f19506u;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f19531t) {
            super.onDraw(canvas);
        } else if (this.f19521j == null) {
        } else {
            if (this.f19520i != 0) {
                canvas.drawCircle(this.f19512a.centerX(), this.f19512a.centerY(), this.f19525n, this.f19517f);
            }
            canvas.drawCircle(this.f19512a.centerX(), this.f19512a.centerY(), this.f19525n, this.f19515d);
            if (this.f19519h > 0) {
                canvas.drawCircle(this.f19513b.centerX(), this.f19513b.centerY(), this.f19526o, this.f19516e);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h4, int oldw, int oldh) {
        super.onSizeChanged(w3, h4, oldw, oldh);
        setup();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int borderColor) {
        if (borderColor == this.f19518g) {
            return;
        }
        this.f19518g = borderColor;
        this.f19516e.setColor(borderColor);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(@ColorRes int borderColorRes) {
        setBorderColor(getContext().getResources().getColor(borderColorRes));
    }

    public void setBorderOverlay(boolean borderOverlay) {
        if (borderOverlay == this.f19530s) {
            return;
        }
        this.f19530s = borderOverlay;
        setup();
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == this.f19519h) {
            return;
        }
        this.f19519h = borderWidth;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter cf) {
        if (cf == this.f19527p) {
            return;
        }
        this.f19527p = cf;
        b();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean disableCircularTransformation) {
        if (this.f19531t == disableCircularTransformation) {
            return;
        }
        this.f19531t = disableCircularTransformation;
        e();
    }

    @Deprecated
    public void setFillColor(@ColorInt int fillColor) {
        if (fillColor == this.f19520i) {
            return;
        }
        this.f19520i = fillColor;
        this.f19517f.setColor(fillColor);
        invalidate();
    }

    @Deprecated
    public void setFillColorResource(@ColorRes int fillColorRes) {
        setFillColor(getContext().getResources().getColor(fillColorRes));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        e();
    }

    @Override // android.view.View
    public void setPadding(int left, int top2, int right, int bottom) {
        super.setPadding(left, top2, right, bottom);
        setup();
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top2, int end, int bottom) {
        super.setPaddingRelative(start, top2, end, bottom);
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f19506u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f19512a = new RectF();
        this.f19513b = new RectF();
        this.f19514c = new Matrix();
        this.f19515d = new Paint();
        this.f19516e = new Paint();
        this.f19517f = new Paint();
        this.f19518g = -16777216;
        this.f19519h = 0;
        this.f19520i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView, defStyle, 0);
        this.f19519h = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f19518g = obtainStyledAttributes.getColor(2, -16777216);
        this.f19530s = obtainStyledAttributes.getBoolean(3, false);
        this.f19520i = obtainStyledAttributes.getColor(5, 0);
        obtainStyledAttributes.recycle();
        d();
    }
}
