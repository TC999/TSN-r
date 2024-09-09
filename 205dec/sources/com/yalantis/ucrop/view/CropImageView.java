package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c1.c;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.util.g;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CropImageView extends TransformImageView {
    public static final int F = 0;
    public static final int G = 500;
    public static final float H = 10.0f;
    public static final float I = 0.0f;
    public static final float J = 0.0f;
    private float A;
    private float B;
    private int C;
    private int D;
    private long E;

    /* renamed from: t  reason: collision with root package name */
    private final RectF f54445t;

    /* renamed from: u  reason: collision with root package name */
    private final Matrix f54446u;

    /* renamed from: v  reason: collision with root package name */
    private float f54447v;

    /* renamed from: w  reason: collision with root package name */
    private float f54448w;

    /* renamed from: x  reason: collision with root package name */
    private c f54449x;

    /* renamed from: y  reason: collision with root package name */
    private Runnable f54450y;

    /* renamed from: z  reason: collision with root package name */
    private Runnable f54451z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f54452a;

        /* renamed from: b  reason: collision with root package name */
        private final long f54453b;

        /* renamed from: c  reason: collision with root package name */
        private final long f54454c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f54455d;

        /* renamed from: e  reason: collision with root package name */
        private final float f54456e;

        /* renamed from: f  reason: collision with root package name */
        private final float f54457f;

        /* renamed from: g  reason: collision with root package name */
        private final float f54458g;

        /* renamed from: h  reason: collision with root package name */
        private final float f54459h;

        /* renamed from: i  reason: collision with root package name */
        private final float f54460i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f54461j;

        public a(CropImageView cropImageView, long j4, float f4, float f5, float f6, float f7, float f8, float f9, boolean z3) {
            this.f54452a = new WeakReference<>(cropImageView);
            this.f54453b = j4;
            this.f54455d = f4;
            this.f54456e = f5;
            this.f54457f = f6;
            this.f54458g = f7;
            this.f54459h = f8;
            this.f54460i = f9;
            this.f54461j = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f54452a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f54453b, System.currentTimeMillis() - this.f54454c);
            float c4 = com.yalantis.ucrop.util.b.c(min, 0.0f, this.f54457f, (float) this.f54453b);
            float c5 = com.yalantis.ucrop.util.b.c(min, 0.0f, this.f54458g, (float) this.f54453b);
            float b4 = com.yalantis.ucrop.util.b.b(min, 0.0f, this.f54460i, (float) this.f54453b);
            if (min < ((float) this.f54453b)) {
                float[] fArr = cropImageView.f54504b;
                cropImageView.k(c4 - (fArr[0] - this.f54455d), c5 - (fArr[1] - this.f54456e));
                if (!this.f54461j) {
                    cropImageView.C(this.f54459h + b4, cropImageView.f54445t.centerX(), cropImageView.f54445t.centerY());
                }
                if (cropImageView.u()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f54462a;

        /* renamed from: b  reason: collision with root package name */
        private final long f54463b;

        /* renamed from: c  reason: collision with root package name */
        private final long f54464c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f54465d;

        /* renamed from: e  reason: collision with root package name */
        private final float f54466e;

        /* renamed from: f  reason: collision with root package name */
        private final float f54467f;

        /* renamed from: g  reason: collision with root package name */
        private final float f54468g;

        public b(CropImageView cropImageView, long j4, float f4, float f5, float f6, float f7) {
            this.f54462a = new WeakReference<>(cropImageView);
            this.f54463b = j4;
            this.f54465d = f4;
            this.f54466e = f5;
            this.f54467f = f6;
            this.f54468g = f7;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f54462a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f54463b, System.currentTimeMillis() - this.f54464c);
            float b4 = com.yalantis.ucrop.util.b.b(min, 0.0f, this.f54466e, (float) this.f54463b);
            if (min < ((float) this.f54463b)) {
                cropImageView.C(this.f54465d + b4, this.f54467f, this.f54468g);
                cropImageView.post(this);
                return;
            }
            cropImageView.y();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private float[] p() {
        this.f54446u.reset();
        this.f54446u.setRotate(-getCurrentAngle());
        float[] fArr = this.f54503a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] b4 = g.b(this.f54445t);
        this.f54446u.mapPoints(copyOf);
        this.f54446u.mapPoints(b4);
        RectF d4 = g.d(copyOf);
        RectF d5 = g.d(b4);
        float f4 = d4.left - d5.left;
        float f5 = d4.top - d5.top;
        float f6 = d4.right - d5.right;
        float f7 = d4.bottom - d5.bottom;
        float[] fArr2 = new float[4];
        if (f4 <= 0.0f) {
            f4 = 0.0f;
        }
        fArr2[0] = f4;
        if (f5 <= 0.0f) {
            f5 = 0.0f;
        }
        fArr2[1] = f5;
        if (f6 >= 0.0f) {
            f6 = 0.0f;
        }
        fArr2[2] = f6;
        if (f7 >= 0.0f) {
            f7 = 0.0f;
        }
        fArr2[3] = f7;
        this.f54446u.reset();
        this.f54446u.setRotate(getCurrentAngle());
        this.f54446u.mapPoints(fArr2);
        return fArr2;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        r(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void r(float f4, float f5) {
        float min = Math.min(Math.min(this.f54445t.width() / f4, this.f54445t.width() / f5), Math.min(this.f54445t.height() / f5, this.f54445t.height() / f4));
        this.B = min;
        this.A = min * this.f54448w;
    }

    private void z(float f4, float f5) {
        float width = this.f54445t.width();
        float height = this.f54445t.height();
        float max = Math.max(this.f54445t.width() / f4, this.f54445t.height() / f5);
        RectF rectF = this.f54445t;
        float f6 = ((height - (f5 * max)) / 2.0f) + rectF.top;
        this.f54506d.reset();
        this.f54506d.postScale(max, max);
        this.f54506d.postTranslate(((width - (f4 * max)) / 2.0f) + rectF.left, f6);
        setImageMatrix(this.f54506d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(float f4, float f5, float f6, long j4) {
        if (f4 > getMaxScale()) {
            f4 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j4, currentScale, f4 - currentScale, f5, f6);
        this.f54451z = bVar;
        post(bVar);
    }

    public void B(float f4) {
        C(f4, this.f54445t.centerX(), this.f54445t.centerY());
    }

    public void C(float f4, float f5, float f6) {
        if (f4 <= getMaxScale()) {
            j(f4 / getCurrentScale(), f5, f6);
        }
    }

    public void D(float f4) {
        E(f4, this.f54445t.centerX(), this.f54445t.centerY());
    }

    public void E(float f4, float f5, float f6) {
        if (f4 >= getMinScale()) {
            j(f4 / getCurrentScale(), f5, f6);
        }
    }

    @Nullable
    public c getCropBoundsChangeListener() {
        return this.f54449x;
    }

    public float getMaxScale() {
        return this.A;
    }

    public float getMinScale() {
        return this.B;
    }

    public float getTargetAspectRatio() {
        return this.f54447v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void h() {
        int i4;
        int i5;
        int i6;
        super.h();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f54447v == 0.0f) {
            this.f54447v = intrinsicWidth / intrinsicHeight;
        }
        int i7 = this.f54507e;
        float f4 = this.f54447v;
        int i8 = (int) (i7 / f4);
        int i9 = this.f54508f;
        if (i8 > i9) {
            this.f54445t.set((i7 - ((int) (i9 * f4))) / 2, 0.0f, i5 + i6, i9);
        } else {
            this.f54445t.set(0.0f, (i9 - i8) / 2, i7, i8 + i4);
        }
        r(intrinsicWidth, intrinsicHeight);
        z(intrinsicWidth, intrinsicHeight);
        c cVar = this.f54449x;
        if (cVar != null) {
            cVar.a(this.f54447v);
        }
        TransformImageView.b bVar = this.f54509g;
        if (bVar != null) {
            bVar.c(getCurrentScale());
            this.f54509g.d(getCurrentAngle());
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void j(float f4, float f5, float f6) {
        if (f4 > 1.0f && getCurrentScale() * f4 <= getMaxScale()) {
            super.j(f4, f5, f6);
        } else if (f4 >= 1.0f || getCurrentScale() * f4 < getMinScale()) {
        } else {
            super.j(f4, f5, f6);
        }
    }

    public void s() {
        removeCallbacks(this.f54450y);
        removeCallbacks(this.f54451z);
    }

    public void setCropBoundsChangeListener(@Nullable c cVar) {
        this.f54449x = cVar;
    }

    public void setCropRect(RectF rectF) {
        this.f54447v = rectF.width() / rectF.height();
        this.f54445t.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        q();
        y();
    }

    public void setImageToWrapCropBounds(boolean z3) {
        float f4;
        float max;
        float f5;
        if (!this.f54513k || u()) {
            return;
        }
        float[] fArr = this.f54504b;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.f54445t.centerX() - f6;
        float centerY = this.f54445t.centerY() - f7;
        this.f54446u.reset();
        this.f54446u.setTranslate(centerX, centerY);
        float[] fArr2 = this.f54503a;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f54446u.mapPoints(copyOf);
        boolean v3 = v(copyOf);
        if (v3) {
            float[] p3 = p();
            f5 = -(p3[1] + p3[3]);
            f4 = -(p3[0] + p3[2]);
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.f54445t);
            this.f54446u.reset();
            this.f54446u.setRotate(getCurrentAngle());
            this.f54446u.mapRect(rectF);
            float[] c4 = g.c(this.f54503a);
            f4 = centerX;
            max = (Math.max(rectF.width() / c4[0], rectF.height() / c4[1]) * currentScale) - currentScale;
            f5 = centerY;
        }
        if (z3) {
            a aVar = new a(this, this.E, f6, f7, f4, f5, currentScale, max, v3);
            this.f54450y = aVar;
            post(aVar);
            return;
        }
        k(f4, f5);
        if (v3) {
            return;
        }
        C(currentScale + max, this.f54445t.centerX(), this.f54445t.centerY());
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j4) {
        if (j4 > 0) {
            this.E = j4;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i4) {
        this.C = i4;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i4) {
        this.D = i4;
    }

    public void setMaxScaleMultiplier(float f4) {
        this.f54448w = f4;
    }

    public void setTargetAspectRatio(float f4) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.f54447v = f4;
            return;
        }
        if (f4 == 0.0f) {
            this.f54447v = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.f54447v = f4;
        }
        c cVar = this.f54449x;
        if (cVar != null) {
            cVar.a(this.f54447v);
        }
    }

    public void t(@NonNull Bitmap.CompressFormat compressFormat, int i4, @Nullable c1.a aVar) {
        s();
        setImageToWrapCropBounds(false);
        new com.yalantis.ucrop.task.a(getContext(), getViewBitmap(), new com.yalantis.ucrop.model.c(this.f54445t, g.d(this.f54503a), getCurrentScale(), getCurrentAngle()), new com.yalantis.ucrop.model.a(this.C, this.D, compressFormat, i4, getImageInputPath(), getImageOutputPath(), getExifInfo()), aVar).execute(new Void[0]);
    }

    protected boolean u() {
        return v(this.f54503a);
    }

    protected boolean v(float[] fArr) {
        this.f54446u.reset();
        this.f54446u.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.f54446u.mapPoints(copyOf);
        float[] b4 = g.b(this.f54445t);
        this.f54446u.mapPoints(b4);
        return g.d(copyOf).contains(g.d(b4));
    }

    public void w(float f4) {
        i(f4, this.f54445t.centerX(), this.f54445t.centerY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs != 0.0f && abs2 != 0.0f) {
            this.f54447v = abs / abs2;
        } else {
            this.f54447v = 0.0f;
        }
    }

    public void y() {
        setImageToWrapCropBounds(true);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54445t = new RectF();
        this.f54446u = new Matrix();
        this.f54448w = 10.0f;
        this.f54451z = null;
        this.C = 0;
        this.D = 0;
        this.E = 500L;
    }
}
