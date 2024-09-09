package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.util.d;
import com.yalantis.ucrop.util.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TransformImageView extends ImageView {

    /* renamed from: p  reason: collision with root package name */
    private static final String f54499p = "TransformImageView";

    /* renamed from: q  reason: collision with root package name */
    private static final int f54500q = 8;

    /* renamed from: r  reason: collision with root package name */
    private static final int f54501r = 2;

    /* renamed from: s  reason: collision with root package name */
    private static final int f54502s = 9;

    /* renamed from: a  reason: collision with root package name */
    protected final float[] f54503a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f54504b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f54505c;

    /* renamed from: d  reason: collision with root package name */
    protected Matrix f54506d;

    /* renamed from: e  reason: collision with root package name */
    protected int f54507e;

    /* renamed from: f  reason: collision with root package name */
    protected int f54508f;

    /* renamed from: g  reason: collision with root package name */
    protected b f54509g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f54510h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f54511i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f54512j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f54513k;

    /* renamed from: l  reason: collision with root package name */
    private int f54514l;

    /* renamed from: m  reason: collision with root package name */
    private String f54515m;

    /* renamed from: n  reason: collision with root package name */
    private String f54516n;

    /* renamed from: o  reason: collision with root package name */
    private com.yalantis.ucrop.model.b f54517o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements c1.b {
        a() {
        }

        @Override // c1.b
        public void a(@NonNull Bitmap bitmap, @NonNull com.yalantis.ucrop.model.b bVar, @NonNull String str, @Nullable String str2) {
            TransformImageView.this.f54515m = str;
            TransformImageView.this.f54516n = str2;
            TransformImageView.this.f54517o = bVar;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.f54512j = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // c1.b
        public void b(@NonNull Exception exc) {
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            b bVar = TransformImageView.this.f54509g;
            if (bVar != null) {
                bVar.b(exc);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface b {
        void a();

        void b(@NonNull Exception exc);

        void c(float f4);

        void d(float f4);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    private void n() {
        this.f54506d.mapPoints(this.f54503a, this.f54510h);
        this.f54506d.mapPoints(this.f54504b, this.f54511i);
    }

    public float d(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2(f(matrix, 1), f(matrix, 0)) * 57.29577951308232d));
    }

    public float e(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow(f(matrix, 0), 2.0d) + Math.pow(f(matrix, 3), 2.0d));
    }

    protected float f(@NonNull Matrix matrix, @IntRange(from = 0, to = 9) int i4) {
        matrix.getValues(this.f54505c);
        return this.f54505c[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float getCurrentAngle() {
        return d(this.f54506d);
    }

    public float getCurrentScale() {
        return e(this.f54506d);
    }

    public com.yalantis.ucrop.model.b getExifInfo() {
        return this.f54517o;
    }

    public String getImageInputPath() {
        return this.f54515m;
    }

    public String getImageOutputPath() {
        return this.f54516n;
    }

    public int getMaxBitmapSize() {
        if (this.f54514l <= 0) {
            this.f54514l = com.yalantis.ucrop.util.a.b(getContext());
        }
        return this.f54514l;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof d)) {
            return null;
        }
        return ((d) getDrawable()).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f54510h = g.b(rectF);
        this.f54511i = g.a(rectF);
        this.f54513k = true;
        b bVar = this.f54509g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void i(float f4, float f5, float f6) {
        if (f4 != 0.0f) {
            this.f54506d.postRotate(f4, f5, f6);
            setImageMatrix(this.f54506d);
            b bVar = this.f54509g;
            if (bVar != null) {
                bVar.d(d(this.f54506d));
            }
        }
    }

    public void j(float f4, float f5, float f6) {
        if (f4 != 0.0f) {
            this.f54506d.postScale(f4, f4, f5, f6);
            setImageMatrix(this.f54506d);
            b bVar = this.f54509g;
            if (bVar != null) {
                bVar.c(e(this.f54506d));
            }
        }
    }

    public void k(float f4, float f5) {
        if (f4 == 0.0f && f5 == 0.0f) {
            return;
        }
        this.f54506d.postTranslate(f4, f5);
        setImageMatrix(this.f54506d);
    }

    protected void l(@NonNull String str, @NonNull Matrix matrix) {
        float f4 = f(matrix, 2);
        float f5 = f(matrix, 5);
        float e4 = e(matrix);
        float d4 = d(matrix);
        Log.d("TransformImageView", str + ": matrix: { x: " + f4 + ", y: " + f5 + ", scale: " + e4 + ", angle: " + d4 + " }");
    }

    public void m(@NonNull Uri uri, @Nullable Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        com.yalantis.ucrop.util.a.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3 || (this.f54512j && !this.f54513k)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f54507e = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f54508f = (getHeight() - getPaddingBottom()) - paddingTop;
            h();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new d(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f54506d.set(matrix);
        n();
    }

    public void setMaxBitmapSize(int i4) {
        this.f54514l = i4;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(b bVar) {
        this.f54509g = bVar;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54503a = new float[8];
        this.f54504b = new float[2];
        this.f54505c = new float[9];
        this.f54506d = new Matrix();
        this.f54512j = false;
        this.f54513k = false;
        this.f54514l = 0;
        g();
    }
}
