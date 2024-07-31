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
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CircleImageView extends AppCompatImageView {

    /* renamed from: A */
    private static final boolean f16110A = false;

    /* renamed from: u */
    private static final ImageView.ScaleType f16111u = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: v */
    private static final Bitmap.Config f16112v = Bitmap.Config.ARGB_8888;

    /* renamed from: w */
    private static final int f16113w = 2;

    /* renamed from: x */
    private static final int f16114x = 0;

    /* renamed from: y */
    private static final int f16115y = -16777216;

    /* renamed from: z */
    private static final int f16116z = 0;

    /* renamed from: a */
    private final RectF f16117a;

    /* renamed from: b */
    private final RectF f16118b;

    /* renamed from: c */
    private final Matrix f16119c;

    /* renamed from: d */
    private final Paint f16120d;

    /* renamed from: e */
    private final Paint f16121e;

    /* renamed from: f */
    private final Paint f16122f;

    /* renamed from: g */
    private int f16123g;

    /* renamed from: h */
    private int f16124h;

    /* renamed from: i */
    private int f16125i;

    /* renamed from: j */
    private Bitmap f16126j;

    /* renamed from: k */
    private BitmapShader f16127k;

    /* renamed from: l */
    private int f16128l;

    /* renamed from: m */
    private int f16129m;

    /* renamed from: n */
    private float f16130n;

    /* renamed from: o */
    private float f16131o;

    /* renamed from: p */
    private ColorFilter f16132p;

    /* renamed from: q */
    private boolean f16133q;

    /* renamed from: r */
    private boolean f16134r;

    /* renamed from: s */
    private boolean f16135s;

    /* renamed from: t */
    private boolean f16136t;

    public CircleImageView(Context context) {
        super(context);
        this.f16117a = new RectF();
        this.f16118b = new RectF();
        this.f16119c = new Matrix();
        this.f16120d = new Paint();
        this.f16121e = new Paint();
        this.f16122f = new Paint();
        this.f16123g = -16777216;
        this.f16124h = 0;
        this.f16125i = 0;
        m42932d();
    }

    /* renamed from: b */
    private void m42934b() {
        Paint paint = this.f16120d;
        if (paint != null) {
            paint.setColorFilter(this.f16132p);
        }
    }

    /* renamed from: c */
    private RectF m42933c() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: d */
    private void m42932d() {
        super.setScaleType(f16111u);
        this.f16133q = true;
        if (this.f16134r) {
            setup();
            this.f16134r = false;
        }
    }

    /* renamed from: e */
    private void m42931e() {
        if (this.f16136t) {
            this.f16126j = null;
        } else {
            this.f16126j = getBitmapFromDrawable(getDrawable());
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
                createBitmap = Bitmap.createBitmap(2, 2, f16112v);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f16112v);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setup() {
        int i;
        if (!this.f16133q) {
            this.f16134r = true;
        } else if (getWidth() == 0 && getHeight() == 0) {
        } else {
            if (this.f16126j == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.f16126j;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f16127k = new BitmapShader(bitmap, tileMode, tileMode);
            this.f16120d.setAntiAlias(true);
            this.f16120d.setShader(this.f16127k);
            this.f16121e.setStyle(Paint.Style.STROKE);
            this.f16121e.setAntiAlias(true);
            this.f16121e.setColor(this.f16123g);
            this.f16121e.setStrokeWidth(this.f16124h);
            this.f16122f.setStyle(Paint.Style.FILL);
            this.f16122f.setAntiAlias(true);
            this.f16122f.setColor(this.f16125i);
            this.f16129m = this.f16126j.getHeight();
            this.f16128l = this.f16126j.getWidth();
            this.f16118b.set(m42933c());
            this.f16131o = Math.min((this.f16118b.height() - this.f16124h) / 2.0f, (this.f16118b.width() - this.f16124h) / 2.0f);
            this.f16117a.set(this.f16118b);
            if (!this.f16135s && (i = this.f16124h) > 0) {
                this.f16117a.inset(i - 1.0f, i - 1.0f);
            }
            this.f16130n = Math.min(this.f16117a.height() / 2.0f, this.f16117a.width() / 2.0f);
            m42934b();
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.f16119c.set(null);
        float f = 0.0f;
        if (this.f16128l * this.f16117a.height() > this.f16117a.width() * this.f16129m) {
            width = this.f16117a.height() / this.f16129m;
            f = (this.f16117a.width() - (this.f16128l * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f16117a.width() / this.f16128l;
            height = (this.f16117a.height() - (this.f16129m * width)) * 0.5f;
        }
        this.f16119c.setScale(width, width);
        Matrix matrix = this.f16119c;
        RectF rectF = this.f16117a;
        matrix.postTranslate(((int) (f + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.f16127k.setLocalMatrix(this.f16119c);
    }

    /* renamed from: f */
    public boolean m42930f() {
        return this.f16135s;
    }

    /* renamed from: g */
    public boolean m42929g() {
        return this.f16136t;
    }

    public int getBorderColor() {
        return this.f16123g;
    }

    public int getBorderWidth() {
        return this.f16124h;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f16132p;
    }

    @Deprecated
    public int getFillColor() {
        return this.f16125i;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f16111u;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f16136t) {
            super.onDraw(canvas);
        } else if (this.f16126j == null) {
        } else {
            if (this.f16125i != 0) {
                canvas.drawCircle(this.f16117a.centerX(), this.f16117a.centerY(), this.f16130n, this.f16122f);
            }
            canvas.drawCircle(this.f16117a.centerX(), this.f16117a.centerY(), this.f16130n, this.f16120d);
            if (this.f16124h > 0) {
                canvas.drawCircle(this.f16118b.centerX(), this.f16118b.centerY(), this.f16131o, this.f16121e);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setup();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int borderColor) {
        if (borderColor == this.f16123g) {
            return;
        }
        this.f16123g = borderColor;
        this.f16121e.setColor(borderColor);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(@ColorRes int borderColorRes) {
        setBorderColor(getContext().getResources().getColor(borderColorRes));
    }

    public void setBorderOverlay(boolean borderOverlay) {
        if (borderOverlay == this.f16135s) {
            return;
        }
        this.f16135s = borderOverlay;
        setup();
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == this.f16124h) {
            return;
        }
        this.f16124h = borderWidth;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter cf) {
        if (cf == this.f16132p) {
            return;
        }
        this.f16132p = cf;
        m42934b();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean disableCircularTransformation) {
        if (this.f16136t == disableCircularTransformation) {
            return;
        }
        this.f16136t = disableCircularTransformation;
        m42931e();
    }

    @Deprecated
    public void setFillColor(@ColorInt int fillColor) {
        if (fillColor == this.f16125i) {
            return;
        }
        this.f16125i = fillColor;
        this.f16122f.setColor(fillColor);
        invalidate();
    }

    @Deprecated
    public void setFillColorResource(@ColorRes int fillColorRes) {
        setFillColor(getContext().getResources().getColor(fillColorRes));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        m42931e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m42931e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        m42931e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m42931e();
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
        if (scaleType != f16111u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f16117a = new RectF();
        this.f16118b = new RectF();
        this.f16119c = new Matrix();
        this.f16120d = new Paint();
        this.f16121e = new Paint();
        this.f16122f = new Paint();
        this.f16123g = -16777216;
        this.f16124h = 0;
        this.f16125i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, C4215R.styleable.CircleImageView, defStyle, 0);
        this.f16124h = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f16123g = obtainStyledAttributes.getColor(2, -16777216);
        this.f16135s = obtainStyledAttributes.getBoolean(3, false);
        this.f16125i = obtainStyledAttributes.getColor(5, 0);
        obtainStyledAttributes.recycle();
        m42932d();
    }
}
