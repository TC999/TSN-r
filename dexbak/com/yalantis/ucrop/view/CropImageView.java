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
import com.yalantis.ucrop.C13495R;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p028c1.BitmapCropCallback;
import p028c1.CropBoundsChangeListener;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CropImageView extends TransformImageView {

    /* renamed from: F */
    public static final int f39909F = 0;

    /* renamed from: G */
    public static final int f39910G = 500;

    /* renamed from: H */
    public static final float f39911H = 10.0f;

    /* renamed from: I */
    public static final float f39912I = 0.0f;

    /* renamed from: J */
    public static final float f39913J = 0.0f;

    /* renamed from: A */
    private float f39914A;

    /* renamed from: B */
    private float f39915B;

    /* renamed from: C */
    private int f39916C;

    /* renamed from: D */
    private int f39917D;

    /* renamed from: E */
    private long f39918E;

    /* renamed from: t */
    private final RectF f39919t;

    /* renamed from: u */
    private final Matrix f39920u;

    /* renamed from: v */
    private float f39921v;

    /* renamed from: w */
    private float f39922w;

    /* renamed from: x */
    private CropBoundsChangeListener f39923x;

    /* renamed from: y */
    private Runnable f39924y;

    /* renamed from: z */
    private Runnable f39925z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.yalantis.ucrop.view.CropImageView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class RunnableC13532a implements Runnable {

        /* renamed from: a */
        private final WeakReference<CropImageView> f39926a;

        /* renamed from: b */
        private final long f39927b;

        /* renamed from: c */
        private final long f39928c = System.currentTimeMillis();

        /* renamed from: d */
        private final float f39929d;

        /* renamed from: e */
        private final float f39930e;

        /* renamed from: f */
        private final float f39931f;

        /* renamed from: g */
        private final float f39932g;

        /* renamed from: h */
        private final float f39933h;

        /* renamed from: i */
        private final float f39934i;

        /* renamed from: j */
        private final boolean f39935j;

        public RunnableC13532a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.f39926a = new WeakReference<>(cropImageView);
            this.f39927b = j;
            this.f39929d = f;
            this.f39930e = f2;
            this.f39931f = f3;
            this.f39932g = f4;
            this.f39933h = f5;
            this.f39934i = f6;
            this.f39935j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f39926a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f39927b, System.currentTimeMillis() - this.f39928c);
            float m13009c = CubicEasing.m13009c(min, 0.0f, this.f39931f, (float) this.f39927b);
            float m13009c2 = CubicEasing.m13009c(min, 0.0f, this.f39932g, (float) this.f39927b);
            float m13010b = CubicEasing.m13010b(min, 0.0f, this.f39934i, (float) this.f39927b);
            if (min < ((float) this.f39927b)) {
                float[] fArr = cropImageView.f39997b;
                cropImageView.m12930k(m13009c - (fArr[0] - this.f39929d), m13009c2 - (fArr[1] - this.f39930e));
                if (!this.f39935j) {
                    cropImageView.m12972C(this.f39933h + m13010b, cropImageView.f39919t.centerX(), cropImageView.f39919t.centerY());
                }
                if (cropImageView.m12963u()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* renamed from: com.yalantis.ucrop.view.CropImageView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class RunnableC13533b implements Runnable {

        /* renamed from: a */
        private final WeakReference<CropImageView> f39936a;

        /* renamed from: b */
        private final long f39937b;

        /* renamed from: c */
        private final long f39938c = System.currentTimeMillis();

        /* renamed from: d */
        private final float f39939d;

        /* renamed from: e */
        private final float f39940e;

        /* renamed from: f */
        private final float f39941f;

        /* renamed from: g */
        private final float f39942g;

        public RunnableC13533b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.f39936a = new WeakReference<>(cropImageView);
            this.f39937b = j;
            this.f39939d = f;
            this.f39940e = f2;
            this.f39941f = f3;
            this.f39942g = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f39936a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f39937b, System.currentTimeMillis() - this.f39938c);
            float m13010b = CubicEasing.m13010b(min, 0.0f, this.f39940e, (float) this.f39937b);
            if (min < ((float) this.f39937b)) {
                cropImageView.m12972C(this.f39939d + m13010b, this.f39941f, this.f39942g);
                cropImageView.post(this);
                return;
            }
            cropImageView.m12959y();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    /* renamed from: p */
    private float[] m12968p() {
        this.f39920u.reset();
        this.f39920u.setRotate(-getCurrentAngle());
        float[] fArr = this.f39996a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] m12981b = RectUtils.m12981b(this.f39919t);
        this.f39920u.mapPoints(copyOf);
        this.f39920u.mapPoints(m12981b);
        RectF m12979d = RectUtils.m12979d(copyOf);
        RectF m12979d2 = RectUtils.m12979d(m12981b);
        float f = m12979d.left - m12979d2.left;
        float f2 = m12979d.top - m12979d2.top;
        float f3 = m12979d.right - m12979d2.right;
        float f4 = m12979d.bottom - m12979d2.bottom;
        float[] fArr2 = new float[4];
        if (f <= 0.0f) {
            f = 0.0f;
        }
        fArr2[0] = f;
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        fArr2[1] = f2;
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        fArr2[2] = f3;
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        fArr2[3] = f4;
        this.f39920u.reset();
        this.f39920u.setRotate(getCurrentAngle());
        this.f39920u.mapPoints(fArr2);
        return fArr2;
    }

    /* renamed from: q */
    private void m12967q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        m12966r(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* renamed from: r */
    private void m12966r(float f, float f2) {
        float min = Math.min(Math.min(this.f39919t.width() / f, this.f39919t.width() / f2), Math.min(this.f39919t.height() / f2, this.f39919t.height() / f));
        this.f39915B = min;
        this.f39914A = min * this.f39922w;
    }

    /* renamed from: z */
    private void m12958z(float f, float f2) {
        float width = this.f39919t.width();
        float height = this.f39919t.height();
        float max = Math.max(this.f39919t.width() / f, this.f39919t.height() / f2);
        RectF rectF = this.f39919t;
        float f3 = ((height - (f2 * max)) / 2.0f) + rectF.top;
        this.f39999d.reset();
        this.f39999d.postScale(max, max);
        this.f39999d.postTranslate(((width - (f * max)) / 2.0f) + rectF.left, f3);
        setImageMatrix(this.f39999d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A */
    public void m12974A(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        RunnableC13533b runnableC13533b = new RunnableC13533b(this, j, currentScale, f - currentScale, f2, f3);
        this.f39925z = runnableC13533b;
        post(runnableC13533b);
    }

    /* renamed from: B */
    public void m12973B(float f) {
        m12972C(f, this.f39919t.centerX(), this.f39919t.centerY());
    }

    /* renamed from: C */
    public void m12972C(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            mo12931j(f / getCurrentScale(), f2, f3);
        }
    }

    /* renamed from: D */
    public void m12971D(float f) {
        m12970E(f, this.f39919t.centerX(), this.f39919t.centerY());
    }

    /* renamed from: E */
    public void m12970E(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            mo12931j(f / getCurrentScale(), f2, f3);
        }
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.f39923x;
    }

    public float getMaxScale() {
        return this.f39914A;
    }

    public float getMinScale() {
        return this.f39915B;
    }

    public float getTargetAspectRatio() {
        return this.f39921v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    /* renamed from: h */
    public void mo12933h() {
        int i;
        int i2;
        int i3;
        super.mo12933h();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f39921v == 0.0f) {
            this.f39921v = intrinsicWidth / intrinsicHeight;
        }
        int i4 = this.f40000e;
        float f = this.f39921v;
        int i5 = (int) (i4 / f);
        int i6 = this.f40001f;
        if (i5 > i6) {
            this.f39919t.set((i4 - ((int) (i6 * f))) / 2, 0.0f, i2 + i3, i6);
        } else {
            this.f39919t.set(0.0f, (i6 - i5) / 2, i4, i5 + i);
        }
        m12966r(intrinsicWidth, intrinsicHeight);
        m12958z(intrinsicWidth, intrinsicHeight);
        CropBoundsChangeListener cropBoundsChangeListener = this.f39923x;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.mo12916a(this.f39921v);
        }
        TransformImageView.InterfaceC13539b interfaceC13539b = this.f40002g;
        if (interfaceC13539b != null) {
            interfaceC13539b.mo12922c(getCurrentScale());
            this.f40002g.mo12921d(getCurrentAngle());
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    /* renamed from: j */
    public void mo12931j(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.mo12931j(f, f2, f3);
        } else if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
        } else {
            super.mo12931j(f, f2, f3);
        }
    }

    /* renamed from: s */
    public void m12965s() {
        removeCallbacks(this.f39924y);
        removeCallbacks(this.f39925z);
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.f39923x = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.f39921v = rectF.width() / rectF.height();
        this.f39919t.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        m12967q();
        m12959y();
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float max;
        float f2;
        if (!this.f40006k || m12963u()) {
            return;
        }
        float[] fArr = this.f39997b;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.f39919t.centerX() - f3;
        float centerY = this.f39919t.centerY() - f4;
        this.f39920u.reset();
        this.f39920u.setTranslate(centerX, centerY);
        float[] fArr2 = this.f39996a;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f39920u.mapPoints(copyOf);
        boolean m12962v = m12962v(copyOf);
        if (m12962v) {
            float[] m12968p = m12968p();
            f2 = -(m12968p[1] + m12968p[3]);
            f = -(m12968p[0] + m12968p[2]);
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.f39919t);
            this.f39920u.reset();
            this.f39920u.setRotate(getCurrentAngle());
            this.f39920u.mapRect(rectF);
            float[] m12980c = RectUtils.m12980c(this.f39996a);
            f = centerX;
            max = (Math.max(rectF.width() / m12980c[0], rectF.height() / m12980c[1]) * currentScale) - currentScale;
            f2 = centerY;
        }
        if (z) {
            RunnableC13532a runnableC13532a = new RunnableC13532a(this, this.f39918E, f3, f4, f, f2, currentScale, max, m12962v);
            this.f39924y = runnableC13532a;
            post(runnableC13532a);
            return;
        }
        m12930k(f, f2);
        if (m12962v) {
            return;
        }
        m12972C(currentScale + max, this.f39919t.centerX(), this.f39919t.centerY());
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j > 0) {
            this.f39918E = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.f39916C = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.f39917D = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.f39922w = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.f39921v = f;
            return;
        }
        if (f == 0.0f) {
            this.f39921v = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.f39921v = f;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.f39923x;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.mo12916a(this.f39921v);
        }
    }

    /* renamed from: t */
    public void m12964t(@NonNull Bitmap.CompressFormat compressFormat, int i, @Nullable BitmapCropCallback bitmapCropCallback) {
        m12965s();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.f39919t, RectUtils.m12979d(this.f39996a), getCurrentScale(), getCurrentAngle()), new CropParameters(this.f39916C, this.f39917D, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).execute(new Void[0]);
    }

    /* renamed from: u */
    protected boolean m12963u() {
        return m12962v(this.f39996a);
    }

    /* renamed from: v */
    protected boolean m12962v(float[] fArr) {
        this.f39920u.reset();
        this.f39920u.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.f39920u.mapPoints(copyOf);
        float[] m12981b = RectUtils.m12981b(this.f39919t);
        this.f39920u.mapPoints(m12981b);
        return RectUtils.m12979d(copyOf).contains(RectUtils.m12979d(m12981b));
    }

    /* renamed from: w */
    public void m12961w(float f) {
        m12932i(f, this.f39919t.centerX(), this.f39919t.centerY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public void m12960x(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(C13495R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(C13495R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs != 0.0f && abs2 != 0.0f) {
            this.f39921v = abs / abs2;
        } else {
            this.f39921v = 0.0f;
        }
    }

    /* renamed from: y */
    public void m12959y() {
        setImageToWrapCropBounds(true);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39919t = new RectF();
        this.f39920u = new Matrix();
        this.f39922w = 10.0f;
        this.f39925z = null;
        this.f39916C = 0;
        this.f39917D = 0;
        this.f39918E = 500L;
    }
}
