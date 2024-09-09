package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.k;
import pl.droidsonroids.gif.l;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class GifTextureView extends TextureView {

    /* renamed from: g  reason: collision with root package name */
    private static final ImageView.ScaleType[] f61799g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a  reason: collision with root package name */
    private ImageView.ScaleType f61800a;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f61801b;

    /* renamed from: c  reason: collision with root package name */
    private l f61802c;

    /* renamed from: d  reason: collision with root package name */
    private c f61803d;

    /* renamed from: e  reason: collision with root package name */
    private float f61804e;

    /* renamed from: f  reason: collision with root package name */
    private k.b f61805f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f61806a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f61806a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61806a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61806a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61806a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f61806a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f61806a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f61806a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f61806a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface b {
        void a(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class c extends Thread implements TextureView.SurfaceTextureListener {

        /* renamed from: a  reason: collision with root package name */
        final pl.droidsonroids.gif.c f61807a;

        /* renamed from: b  reason: collision with root package name */
        private GifInfoHandle f61808b;

        /* renamed from: c  reason: collision with root package name */
        private IOException f61809c;

        /* renamed from: d  reason: collision with root package name */
        long[] f61810d;

        /* renamed from: e  reason: collision with root package name */
        private final WeakReference<GifTextureView> f61811e;

        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ GifTextureView f61812a;

            a(GifTextureView gifTextureView) {
                this.f61812a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f61812a.i(c.this.f61808b);
            }
        }

        c(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.f61807a = new pl.droidsonroids.gif.c();
            this.f61808b = new GifInfoHandle();
            this.f61811e = new WeakReference<>(gifTextureView);
        }

        void c(@NonNull GifTextureView gifTextureView, @Nullable b bVar) {
            this.f61807a.b();
            gifTextureView.setSuperSurfaceTextureListener(bVar != null ? new p(bVar) : null);
            this.f61808b.z();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
            GifTextureView gifTextureView = this.f61811e.get();
            if (gifTextureView != null) {
                gifTextureView.i(this.f61808b);
            }
            this.f61807a.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f61807a.b();
            this.f61808b.z();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.f61811e.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle c4 = gifTextureView.f61802c.c();
                this.f61808b = c4;
                c4.K((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f61805f.f61862b >= 0) {
                    this.f61808b.J(gifTextureView.f61805f.f61862b);
                }
                GifTextureView gifTextureView2 = this.f61811e.get();
                if (gifTextureView2 == null) {
                    this.f61808b.A();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean isAvailable = gifTextureView2.isAvailable();
                this.f61807a.d(isAvailable);
                if (isAvailable) {
                    gifTextureView2.post(new a(gifTextureView2));
                }
                this.f61808b.L(gifTextureView2.f61804e);
                while (!isInterrupted()) {
                    try {
                        this.f61807a.a();
                        GifTextureView gifTextureView3 = this.f61811e.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.f61808b.a(surface, this.f61810d);
                            } finally {
                                surface.release();
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.f61808b.A();
                this.f61808b = new GifInfoHandle();
            } catch (IOException e4) {
                this.f61809c = e4;
            }
        }
    }

    public GifTextureView(Context context) {
        super(context);
        this.f61800a = ImageView.ScaleType.FIT_CENTER;
        this.f61801b = new Matrix();
        this.f61804e = 1.0f;
        g(null, 0, 0);
    }

    private static l f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
            if (typedValue.resourceId != 0) {
                String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
                if (k.f61858b.contains(resourceTypeName)) {
                    return new l.i(typedArray.getResources(), typedValue.resourceId);
                }
                if (!"string".equals(resourceTypeName)) {
                    throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
                }
            }
            return new l.c(typedArray.getResources().getAssets(), typedValue.string.toString());
        }
        return null;
    }

    private void g(AttributeSet attributeSet, int i4, int i5) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f61799g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f61800a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i4, i5);
            this.f61802c = f(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f61805f = new k.b(this, attributeSet, i4, i5);
        } else {
            super.setOpaque(false);
            this.f61805f = new k.b();
        }
        if (isInEditMode()) {
            return;
        }
        c cVar = new c(this);
        this.f61803d = cVar;
        if (this.f61802c != null) {
            cVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float q3 = gifInfoHandle.q() / width;
        float i4 = gifInfoHandle.i() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.q(), gifInfoHandle.i());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f4 = 1.0f;
        switch (a.f61806a[this.f61800a.ordinal()]) {
            case 1:
                matrix.setScale(q3, i4, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(q3, i4);
                matrix.setScale(q3 * min, min * i4, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.q() > width || gifInfoHandle.i() > height) {
                    f4 = Math.min(1.0f / q3, 1.0f / i4);
                }
                matrix.setScale(q3 * f4, f4 * i4, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(q3, i4);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(q3, i4);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(q3, i4);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f61801b);
                matrix.preScale(q3, i4);
                break;
        }
        super.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    @Nullable
    public IOException getIOException() {
        if (this.f61803d.f61809c != null) {
            return this.f61803d.f61809c;
        }
        return GifIOException.fromCode(this.f61803d.f61808b.l());
    }

    public ImageView.ScaleType getScaleType() {
        return this.f61800a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.f61801b);
        return matrix;
    }

    public synchronized void h(@Nullable l lVar, @Nullable b bVar) {
        this.f61803d.c(this, bVar);
        try {
            this.f61803d.join();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        this.f61802c = lVar;
        c cVar = new c(this);
        this.f61803d = cVar;
        if (lVar != null) {
            cVar.start();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f61803d.c(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f61803d.f61810d = gifViewSavedState.f61814a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = this.f61803d;
        cVar.f61810d = cVar.f61808b.o();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f61805f.f61861a ? this.f61803d.f61810d : null);
    }

    public void setFreezesAnimation(boolean z3) {
        this.f61805f.f61861a = z3;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable l lVar) {
        h(lVar, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z3) {
        if (z3 != isOpaque()) {
            super.setOpaque(z3);
            setInputSource(this.f61802c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f61800a = scaleType;
        i(this.f61803d.f61808b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.f61804e = f4;
        this.f61803d.f61808b.L(f4);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.f61801b.set(matrix);
        i(this.f61803d.f61808b);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61800a = ImageView.ScaleType.FIT_CENTER;
        this.f61801b = new Matrix();
        this.f61804e = 1.0f;
        g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f61800a = ImageView.ScaleType.FIT_CENTER;
        this.f61801b = new Matrix();
        this.f61804e = 1.0f;
        g(attributeSet, i4, 0);
    }

    @RequiresApi(21)
    public GifTextureView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f61800a = ImageView.ScaleType.FIT_CENTER;
        this.f61801b = new Matrix();
        this.f61804e = 1.0f;
        g(attributeSet, i4, i5);
    }
}
