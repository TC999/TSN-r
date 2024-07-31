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
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;
import p028c1.BitmapLoadCallback;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TransformImageView extends ImageView {

    /* renamed from: p */
    private static final String f39992p = "TransformImageView";

    /* renamed from: q */
    private static final int f39993q = 8;

    /* renamed from: r */
    private static final int f39994r = 2;

    /* renamed from: s */
    private static final int f39995s = 9;

    /* renamed from: a */
    protected final float[] f39996a;

    /* renamed from: b */
    protected final float[] f39997b;

    /* renamed from: c */
    private final float[] f39998c;

    /* renamed from: d */
    protected Matrix f39999d;

    /* renamed from: e */
    protected int f40000e;

    /* renamed from: f */
    protected int f40001f;

    /* renamed from: g */
    protected InterfaceC13539b f40002g;

    /* renamed from: h */
    private float[] f40003h;

    /* renamed from: i */
    private float[] f40004i;

    /* renamed from: j */
    protected boolean f40005j;

    /* renamed from: k */
    protected boolean f40006k;

    /* renamed from: l */
    private int f40007l;

    /* renamed from: m */
    private String f40008m;

    /* renamed from: n */
    private String f40009n;

    /* renamed from: o */
    private ExifInfo f40010o;

    /* renamed from: com.yalantis.ucrop.view.TransformImageView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C13538a implements BitmapLoadCallback {
        C13538a() {
        }

        @Override // p028c1.BitmapLoadCallback
        /* renamed from: a */
        public void mo12926a(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String str, @Nullable String str2) {
            TransformImageView.this.f40008m = str;
            TransformImageView.this.f40009n = str2;
            TransformImageView.this.f40010o = exifInfo;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.f40005j = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // p028c1.BitmapLoadCallback
        /* renamed from: b */
        public void mo12925b(@NonNull Exception exc) {
            Log.e(TransformImageView.f39992p, "onFailure: setImageUri", exc);
            InterfaceC13539b interfaceC13539b = TransformImageView.this.f40002g;
            if (interfaceC13539b != null) {
                interfaceC13539b.mo12923b(exc);
            }
        }
    }

    /* renamed from: com.yalantis.ucrop.view.TransformImageView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13539b {
        /* renamed from: a */
        void mo12924a();

        /* renamed from: b */
        void mo12923b(@NonNull Exception exc);

        /* renamed from: c */
        void mo12922c(float f);

        /* renamed from: d */
        void mo12921d(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    /* renamed from: n */
    private void m12927n() {
        this.f39999d.mapPoints(this.f39996a, this.f40003h);
        this.f39999d.mapPoints(this.f39997b, this.f40004i);
    }

    /* renamed from: d */
    public float m12937d(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2(m12935f(matrix, 1), m12935f(matrix, 0)) * 57.29577951308232d));
    }

    /* renamed from: e */
    public float m12936e(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow(m12935f(matrix, 0), 2.0d) + Math.pow(m12935f(matrix, 3), 2.0d));
    }

    /* renamed from: f */
    protected float m12935f(@NonNull Matrix matrix, @IntRange(from = 0, m60035to = 9) int i) {
        matrix.getValues(this.f39998c);
        return this.f39998c[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void mo12934g() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float getCurrentAngle() {
        return m12937d(this.f39999d);
    }

    public float getCurrentScale() {
        return m12936e(this.f39999d);
    }

    public ExifInfo getExifInfo() {
        return this.f40010o;
    }

    public String getImageInputPath() {
        return this.f40008m;
    }

    public String getImageOutputPath() {
        return this.f40009n;
    }

    public int getMaxBitmapSize() {
        if (this.f40007l <= 0) {
            this.f40007l = BitmapLoadUtils.m13018b(getContext());
        }
        return this.f40007l;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).m13005a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void mo12933h() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d(f39992p, String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f40003h = RectUtils.m12981b(rectF);
        this.f40004i = RectUtils.m12982a(rectF);
        this.f40006k = true;
        InterfaceC13539b interfaceC13539b = this.f40002g;
        if (interfaceC13539b != null) {
            interfaceC13539b.mo12924a();
        }
    }

    /* renamed from: i */
    public void m12932i(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f39999d.postRotate(f, f2, f3);
            setImageMatrix(this.f39999d);
            InterfaceC13539b interfaceC13539b = this.f40002g;
            if (interfaceC13539b != null) {
                interfaceC13539b.mo12921d(m12937d(this.f39999d));
            }
        }
    }

    /* renamed from: j */
    public void mo12931j(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f39999d.postScale(f, f, f2, f3);
            setImageMatrix(this.f39999d);
            InterfaceC13539b interfaceC13539b = this.f40002g;
            if (interfaceC13539b != null) {
                interfaceC13539b.mo12922c(m12936e(this.f39999d));
            }
        }
    }

    /* renamed from: k */
    public void m12930k(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.f39999d.postTranslate(f, f2);
        setImageMatrix(this.f39999d);
    }

    /* renamed from: l */
    protected void m12929l(@NonNull String str, @NonNull Matrix matrix) {
        float m12935f = m12935f(matrix, 2);
        float m12935f2 = m12935f(matrix, 5);
        float m12936e = m12936e(matrix);
        float m12937d = m12937d(matrix);
        Log.d(f39992p, str + ": matrix: { x: " + m12935f + ", y: " + m12935f2 + ", scale: " + m12936e + ", angle: " + m12937d + " }");
    }

    /* renamed from: m */
    public void m12928m(@NonNull Uri uri, @Nullable Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.m13016d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new C13538a());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.f40005j && !this.f40006k)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f40000e = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f40001f = (getHeight() - getPaddingBottom()) - paddingTop;
            mo12933h();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f39999d.set(matrix);
        m12927n();
    }

    public void setMaxBitmapSize(int i) {
        this.f40007l = i;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w(f39992p, "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(InterfaceC13539b interfaceC13539b) {
        this.f40002g = interfaceC13539b;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39996a = new float[8];
        this.f39997b = new float[2];
        this.f39998c = new float[9];
        this.f39999d = new Matrix();
        this.f40005j = false;
        this.f40006k = false;
        this.f40007l = 0;
        mo12934g();
    }
}
