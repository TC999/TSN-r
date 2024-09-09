package com.bytedance.adsdk.ugeno.component.image;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f26156a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f26157b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f26158c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f26159d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f26160e;

    /* renamed from: f  reason: collision with root package name */
    private final int f26161f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26162g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f26163h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f26164i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f26165j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f26166k;

    /* renamed from: l  reason: collision with root package name */
    private Shader.TileMode f26167l;

    /* renamed from: m  reason: collision with root package name */
    private Shader.TileMode f26168m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26169n;

    /* renamed from: o  reason: collision with root package name */
    private float f26170o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean[] f26171p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f26172q;

    /* renamed from: r  reason: collision with root package name */
    private float f26173r;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f26174s;

    /* renamed from: t  reason: collision with root package name */
    private ImageView.ScaleType f26175t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.ugeno.component.image.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class C0362a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26176a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f26176a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26176a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26176a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26176a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26176a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26176a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26176a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f26158c = rectF;
        this.f26163h = new RectF();
        this.f26165j = new Matrix();
        this.f26166k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f26167l = tileMode;
        this.f26168m = tileMode;
        this.f26169n = true;
        this.f26170o = 0.0f;
        this.f26171p = new boolean[]{true, true, true, true};
        this.f26172q = false;
        this.f26173r = 0.0f;
        this.f26174s = ColorStateList.valueOf(-16777216);
        this.f26175t = ImageView.ScaleType.FIT_CENTER;
        this.f26159d = bitmap;
        int width = bitmap.getWidth();
        this.f26161f = width;
        int height = bitmap.getHeight();
        this.f26162g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f26160e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f26164i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f26174s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f26173r);
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            Drawable.ConstantState constantState = drawable.mutate().getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i4 = 0; i4 < numberOfLayers; i4++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i4), a(layerDrawable.getDrawable(i4)));
            }
            return layerDrawable;
        }
        Bitmap l4 = l(drawable);
        return l4 != null ? new a(l4) : drawable;
    }

    public static a e(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    private void i() {
        float width;
        float height;
        int i4 = C0362a.f26176a[this.f26175t.ordinal()];
        if (i4 == 1) {
            this.f26163h.set(this.f26156a);
            RectF rectF = this.f26163h;
            float f4 = this.f26173r;
            rectF.inset(f4 / 2.0f, f4 / 2.0f);
            this.f26165j.reset();
            this.f26165j.setTranslate((int) (((this.f26163h.width() - this.f26161f) * 0.5f) + 0.5f), (int) (((this.f26163h.height() - this.f26162g) * 0.5f) + 0.5f));
        } else if (i4 == 2) {
            this.f26163h.set(this.f26156a);
            RectF rectF2 = this.f26163h;
            float f5 = this.f26173r;
            rectF2.inset(f5 / 2.0f, f5 / 2.0f);
            this.f26165j.reset();
            float f6 = 0.0f;
            if (this.f26161f * this.f26163h.height() > this.f26163h.width() * this.f26162g) {
                width = this.f26163h.height() / this.f26162g;
                f6 = (this.f26163h.width() - (this.f26161f * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f26163h.width() / this.f26161f;
                height = (this.f26163h.height() - (this.f26162g * width)) * 0.5f;
            }
            this.f26165j.setScale(width, width);
            Matrix matrix = this.f26165j;
            float f7 = this.f26173r;
            matrix.postTranslate(((int) (f6 + 0.5f)) + (f7 / 2.0f), ((int) (height + 0.5f)) + (f7 / 2.0f));
        } else if (i4 == 3) {
            this.f26165j.reset();
            float min = (((float) this.f26161f) > this.f26156a.width() || ((float) this.f26162g) > this.f26156a.height()) ? Math.min(this.f26156a.width() / this.f26161f, this.f26156a.height() / this.f26162g) : 1.0f;
            this.f26165j.setScale(min, min);
            this.f26165j.postTranslate((int) (((this.f26156a.width() - (this.f26161f * min)) * 0.5f) + 0.5f), (int) (((this.f26156a.height() - (this.f26162g * min)) * 0.5f) + 0.5f));
            this.f26163h.set(this.f26158c);
            this.f26165j.mapRect(this.f26163h);
            RectF rectF3 = this.f26163h;
            float f8 = this.f26173r;
            rectF3.inset(f8 / 2.0f, f8 / 2.0f);
            this.f26165j.setRectToRect(this.f26158c, this.f26163h, Matrix.ScaleToFit.FILL);
        } else if (i4 == 5) {
            this.f26163h.set(this.f26158c);
            this.f26165j.setRectToRect(this.f26158c, this.f26156a, Matrix.ScaleToFit.END);
            this.f26165j.mapRect(this.f26163h);
            RectF rectF4 = this.f26163h;
            float f9 = this.f26173r;
            rectF4.inset(f9 / 2.0f, f9 / 2.0f);
            this.f26165j.setRectToRect(this.f26158c, this.f26163h, Matrix.ScaleToFit.FILL);
        } else if (i4 == 6) {
            this.f26163h.set(this.f26158c);
            this.f26165j.setRectToRect(this.f26158c, this.f26156a, Matrix.ScaleToFit.START);
            this.f26165j.mapRect(this.f26163h);
            RectF rectF5 = this.f26163h;
            float f10 = this.f26173r;
            rectF5.inset(f10 / 2.0f, f10 / 2.0f);
            this.f26165j.setRectToRect(this.f26158c, this.f26163h, Matrix.ScaleToFit.FILL);
        } else if (i4 != 7) {
            this.f26163h.set(this.f26158c);
            this.f26165j.setRectToRect(this.f26158c, this.f26156a, Matrix.ScaleToFit.CENTER);
            this.f26165j.mapRect(this.f26163h);
            RectF rectF6 = this.f26163h;
            float f11 = this.f26173r;
            rectF6.inset(f11 / 2.0f, f11 / 2.0f);
            this.f26165j.setRectToRect(this.f26158c, this.f26163h, Matrix.ScaleToFit.FILL);
        } else {
            this.f26163h.set(this.f26156a);
            RectF rectF7 = this.f26163h;
            float f12 = this.f26173r;
            rectF7.inset(f12 / 2.0f, f12 / 2.0f);
            this.f26165j.reset();
            this.f26165j.setRectToRect(this.f26158c, this.f26163h, Matrix.ScaleToFit.FILL);
        }
        this.f26157b.set(this.f26163h);
        this.f26169n = true;
    }

    private void j(Canvas canvas) {
        if (o(this.f26171p) || this.f26170o == 0.0f) {
            return;
        }
        RectF rectF = this.f26157b;
        float f4 = rectF.left;
        float f5 = rectF.top;
        float width = rectF.width() + f4;
        float height = this.f26157b.height() + f5;
        float f6 = this.f26170o;
        if (!this.f26171p[0]) {
            this.f26166k.set(f4, f5, f4 + f6, f5 + f6);
            canvas.drawRect(this.f26166k, this.f26160e);
        }
        if (!this.f26171p[1]) {
            this.f26166k.set(width - f6, f5, width, f6);
            canvas.drawRect(this.f26166k, this.f26160e);
        }
        if (!this.f26171p[2]) {
            this.f26166k.set(width - f6, height - f6, width, height);
            canvas.drawRect(this.f26166k, this.f26160e);
        }
        if (this.f26171p[3]) {
            return;
        }
        this.f26166k.set(f4, height - f6, f6 + f4, height);
        canvas.drawRect(this.f26166k, this.f26160e);
    }

    private static boolean k(boolean[] zArr) {
        for (boolean z3 : zArr) {
            if (z3) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap l(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void n(Canvas canvas) {
        float f4;
        if (o(this.f26171p) || this.f26170o == 0.0f) {
            return;
        }
        RectF rectF = this.f26157b;
        float f5 = rectF.left;
        float f6 = rectF.top;
        float width = rectF.width() + f5;
        float height = f6 + this.f26157b.height();
        float f7 = this.f26170o;
        float f8 = this.f26173r / 2.0f;
        if (!this.f26171p[0]) {
            canvas.drawLine(f5 - f8, f6, f5 + f7, f6, this.f26164i);
            canvas.drawLine(f5, f6 - f8, f5, f6 + f7, this.f26164i);
        }
        if (!this.f26171p[1]) {
            canvas.drawLine((width - f7) - f8, f6, width, f6, this.f26164i);
            canvas.drawLine(width, f6 - f8, width, f6 + f7, this.f26164i);
        }
        if (this.f26171p[2]) {
            f4 = f7;
        } else {
            f4 = f7;
            canvas.drawLine((width - f7) - f8, height, width + f8, height, this.f26164i);
            canvas.drawLine(width, height - f4, width, height, this.f26164i);
        }
        if (this.f26171p[3]) {
            return;
        }
        canvas.drawLine(f5 - f8, height, f5 + f4, height, this.f26164i);
        canvas.drawLine(f5, height - f4, f5, height, this.f26164i);
    }

    private static boolean o(boolean[] zArr) {
        for (boolean z3 : zArr) {
            if (z3) {
                return false;
            }
        }
        return true;
    }

    public a b(float f4) {
        this.f26173r = f4;
        this.f26164i.setStrokeWidth(f4);
        return this;
    }

    public a c(float f4, float f5, float f6, float f7) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.add(Float.valueOf(f6));
        hashSet.add(Float.valueOf(f7));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.f26170o = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.f26170o = 0.0f;
            }
            boolean[] zArr = this.f26171p;
            zArr[0] = f4 > 0.0f;
            zArr[1] = f5 > 0.0f;
            zArr[2] = f6 > 0.0f;
            zArr[3] = f7 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public a d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f26174s = colorStateList;
        this.f26164i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f26169n) {
            BitmapShader bitmapShader = new BitmapShader(this.f26159d, this.f26167l, this.f26168m);
            Shader.TileMode tileMode = this.f26167l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f26168m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f26165j);
            }
            this.f26160e.setShader(bitmapShader);
            this.f26169n = false;
        }
        if (this.f26172q) {
            if (this.f26173r > 0.0f) {
                canvas.drawOval(this.f26157b, this.f26160e);
                canvas.drawOval(this.f26163h, this.f26164i);
                return;
            }
            canvas.drawOval(this.f26157b, this.f26160e);
        } else if (k(this.f26171p)) {
            float f4 = this.f26170o;
            if (this.f26173r > 0.0f) {
                canvas.drawRoundRect(this.f26157b, f4, f4, this.f26160e);
                canvas.drawRoundRect(this.f26163h, f4, f4, this.f26164i);
                j(canvas);
                n(canvas);
                return;
            }
            canvas.drawRoundRect(this.f26157b, f4, f4, this.f26160e);
            j(canvas);
        } else {
            canvas.drawRect(this.f26157b, this.f26160e);
            if (this.f26173r > 0.0f) {
                canvas.drawRect(this.f26163h, this.f26164i);
            }
        }
    }

    public a f(Shader.TileMode tileMode) {
        if (this.f26167l != tileMode) {
            this.f26167l = tileMode;
            this.f26169n = true;
            invalidateSelf();
        }
        return this;
    }

    public a g(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f26175t != scaleType) {
            this.f26175t = scaleType;
            i();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f26160e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f26160e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f26162g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f26161f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public a h(boolean z3) {
        this.f26172q = z3;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f26174s.isStateful();
    }

    public a m(Shader.TileMode tileMode) {
        if (this.f26168m != tileMode) {
            this.f26168m = tileMode;
            this.f26169n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f26156a.set(rect);
        i();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f26174s.getColorForState(iArr, 0);
        if (this.f26164i.getColor() != colorForState) {
            this.f26164i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f26160e.setAlpha(i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f26160e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z3) {
        this.f26160e.setDither(z3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f26160e.setFilterBitmap(z3);
        invalidateSelf();
    }
}
