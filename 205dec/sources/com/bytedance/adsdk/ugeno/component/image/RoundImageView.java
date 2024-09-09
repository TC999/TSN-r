package com.bytedance.adsdk.ugeno.component.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import j0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f26139a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f26140b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f26141c;

    /* renamed from: d  reason: collision with root package name */
    private float f26142d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f26143e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26144f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f26145g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26146h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26147i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26148j;

    /* renamed from: k  reason: collision with root package name */
    private int f26149k;

    /* renamed from: l  reason: collision with root package name */
    private int f26150l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView.ScaleType f26151m;

    /* renamed from: n  reason: collision with root package name */
    private Shader.TileMode f26152n;

    /* renamed from: o  reason: collision with root package name */
    private Shader.TileMode f26153o;

    /* renamed from: p  reason: collision with root package name */
    private d f26154p;

    /* renamed from: s  reason: collision with root package name */
    static final /* synthetic */ boolean f26138s = true;

    /* renamed from: q  reason: collision with root package name */
    public static final Shader.TileMode f26136q = Shader.TileMode.CLAMP;

    /* renamed from: r  reason: collision with root package name */
    private static final ImageView.ScaleType[] f26137r = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26155a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f26155a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26155a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26155a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26155a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26155a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26155a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26155a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.f26139a = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f26141c = ColorStateList.valueOf(-16777216);
        this.f26142d = 0.0f;
        this.f26143e = null;
        this.f26144f = false;
        this.f26146h = false;
        this.f26147i = false;
        this.f26148j = false;
        Shader.TileMode tileMode = f26136q;
        this.f26152n = tileMode;
        this.f26153o = tileMode;
    }

    private Drawable a() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i4 = this.f26149k;
        if (i4 != 0) {
            try {
                drawable = resources.getDrawable(i4);
            } catch (Exception e4) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f26149k, e4);
                this.f26149k = 0;
            }
        }
        return com.bytedance.adsdk.ugeno.component.image.a.a(drawable);
    }

    private void c(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof com.bytedance.adsdk.ugeno.component.image.a) {
            com.bytedance.adsdk.ugeno.component.image.a aVar = (com.bytedance.adsdk.ugeno.component.image.a) drawable;
            aVar.g(scaleType).b(this.f26142d).d(this.f26141c).h(this.f26147i).f(this.f26152n).m(this.f26153o);
            float[] fArr = this.f26139a;
            if (fArr != null) {
                aVar.c(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            f();
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i4 = 0; i4 < numberOfLayers; i4++) {
                c(layerDrawable.getDrawable(i4), scaleType);
            }
        }
    }

    private void e(boolean z3) {
        if (this.f26148j) {
            if (z3) {
                this.f26140b = com.bytedance.adsdk.ugeno.component.image.a.a(this.f26140b);
            }
            c(this.f26140b, ImageView.ScaleType.FIT_XY);
        }
    }

    private void f() {
        Drawable drawable = this.f26145g;
        if (drawable == null || !this.f26144f) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f26145g = mutate;
        if (this.f26146h) {
            mutate.setColorFilter(this.f26143e);
        }
    }

    private Drawable g() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i4 = this.f26150l;
        if (i4 != 0) {
            try {
                drawable = resources.getDrawable(i4);
            } catch (Exception e4) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f26150l, e4);
                this.f26150l = 0;
            }
        }
        return com.bytedance.adsdk.ugeno.component.image.a.a(drawable);
    }

    private void h() {
        c(this.f26145g, this.f26151m);
    }

    public void b(float f4, float f5, float f6, float f7) {
        float[] fArr = this.f26139a;
        if (fArr[0] == f4 && fArr[1] == f5 && fArr[2] == f7 && fArr[3] == f6) {
            return;
        }
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[3] = f6;
        fArr[2] = f7;
        h();
        e(false);
        invalidate();
    }

    public void d(d dVar) {
        this.f26154p = dVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f26141c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f26141c;
    }

    public float getBorderWidth() {
        return this.f26142d;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f4 = 0.0f;
        for (float f5 : this.f26139a) {
            f4 = Math.max(f5, f4);
        }
        return f4;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f26151m;
    }

    public Shader.TileMode getTileModeX() {
        return this.f26152n;
    }

    public Shader.TileMode getTileModeY() {
        return this.f26153o;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26154p;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26154p;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar = this.f26154p;
        if (dVar != null) {
            dVar.c(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        d dVar = this.f26154p;
        if (dVar != null) {
            dVar.c(i4, i5, i6, i7);
        }
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f26154p;
        if (dVar != null) {
            int[] c4 = dVar.c(i4, i5);
            super.onMeasure(c4[0], c4[1]);
            return;
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        ColorDrawable colorDrawable = new ColorDrawable(i4);
        this.f26140b = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f26140b = drawable;
        e(true);
        super.setBackgroundDrawable(this.f26140b);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        if (this.f26150l != i4) {
            this.f26150l = i4;
            Drawable g4 = g();
            this.f26140b = g4;
            setBackgroundDrawable(g4);
        }
    }

    public void setBorderColor(int i4) {
        setBorderColor(ColorStateList.valueOf(i4));
    }

    public void setBorderWidth(int i4) {
        setBorderWidth(getResources().getDimension(i4));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f26143e != colorFilter) {
            this.f26143e = colorFilter;
            this.f26146h = true;
            this.f26144f = true;
            f();
            invalidate();
        }
    }

    public void setCornerRadius(float f4) {
        b(f4, f4, f4, f4);
    }

    public void setCornerRadiusDimen(int i4) {
        float dimension = getResources().getDimension(i4);
        b(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f26149k = 0;
        this.f26145g = com.bytedance.adsdk.ugeno.component.image.a.e(bitmap);
        h();
        super.setImageDrawable(this.f26145g);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f26149k = 0;
        this.f26145g = com.bytedance.adsdk.ugeno.component.image.a.a(drawable);
        h();
        super.setImageDrawable(this.f26145g);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        if (this.f26149k != i4) {
            this.f26149k = i4;
            this.f26145g = a();
            h();
            super.setImageDrawable(this.f26145g);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z3) {
        this.f26147i = z3;
        h();
        e(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!f26138s && scaleType == null) {
            throw new AssertionError();
        }
        if (this.f26151m != scaleType) {
            this.f26151m = scaleType;
            switch (a.f26155a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            h();
            e(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f26152n == tileMode) {
            return;
        }
        this.f26152n = tileMode;
        h();
        e(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f26153o == tileMode) {
            return;
        }
        this.f26153o = tileMode;
        h();
        e(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f26141c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f26141c = colorStateList;
        h();
        e(false);
        if (this.f26142d > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f4) {
        if (this.f26142d == f4) {
            return;
        }
        this.f26142d = f4;
        h();
        e(false);
        invalidate();
    }
}
