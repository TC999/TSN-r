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
import pl.droidsonroids.gif.GifViewUtils;
import pl.droidsonroids.gif.InputSource;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifTextureView extends TextureView {

    /* renamed from: g */
    private static final ImageView.ScaleType[] f44386g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a */
    private ImageView.ScaleType f44387a;

    /* renamed from: b */
    private final Matrix f44388b;

    /* renamed from: c */
    private InputSource f44389c;

    /* renamed from: d */
    private TextureView$SurfaceTextureListenerC15435c f44390d;

    /* renamed from: e */
    private float f44391e;

    /* renamed from: f */
    private GifViewUtils.C15447b f44392f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: pl.droidsonroids.gif.GifTextureView$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static /* synthetic */ class C15433a {

        /* renamed from: a */
        static final /* synthetic */ int[] f44393a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f44393a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44393a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44393a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44393a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44393a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f44393a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f44393a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f44393a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: pl.droidsonroids.gif.GifTextureView$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15434b {
        /* renamed from: a */
        void m2483a(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pl.droidsonroids.gif.GifTextureView$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class TextureView$SurfaceTextureListenerC15435c extends Thread implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        final ConditionVariable f44394a;

        /* renamed from: b */
        private GifInfoHandle f44395b;

        /* renamed from: c */
        private IOException f44396c;

        /* renamed from: d */
        long[] f44397d;

        /* renamed from: e */
        private final WeakReference<GifTextureView> f44398e;

        /* renamed from: pl.droidsonroids.gif.GifTextureView$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class RunnableC15436a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ GifTextureView f44399a;

            RunnableC15436a(GifTextureView gifTextureView) {
                this.f44399a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f44399a.m2484i(TextureView$SurfaceTextureListenerC15435c.this.f44395b);
            }
        }

        TextureView$SurfaceTextureListenerC15435c(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.f44394a = new ConditionVariable();
            this.f44395b = new GifInfoHandle();
            this.f44398e = new WeakReference<>(gifTextureView);
        }

        /* renamed from: c */
        void m2480c(@NonNull GifTextureView gifTextureView, @Nullable InterfaceC15434b interfaceC15434b) {
            this.f44394a.m2474b();
            gifTextureView.setSuperSurfaceTextureListener(interfaceC15434b != null ? new PlaceholderDrawingSurfaceTextureListener(interfaceC15434b) : null);
            this.f44395b.m2497z();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = this.f44398e.get();
            if (gifTextureView != null) {
                gifTextureView.m2484i(this.f44395b);
            }
            this.f44394a.m2473c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f44394a.m2474b();
            this.f44395b.m2497z();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.f44398e.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle mo2368c = gifTextureView.f44389c.mo2368c();
                this.f44395b = mo2368c;
                mo2368c.m2527K((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f44392f.f44449b >= 0) {
                    this.f44395b.m2528J(gifTextureView.f44392f.f44449b);
                }
                GifTextureView gifTextureView2 = this.f44398e.get();
                if (gifTextureView2 == null) {
                    this.f44395b.m2537A();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean isAvailable = gifTextureView2.isAvailable();
                this.f44394a.m2472d(isAvailable);
                if (isAvailable) {
                    gifTextureView2.post(new RunnableC15436a(gifTextureView2));
                }
                this.f44395b.m2526L(gifTextureView2.f44391e);
                while (!isInterrupted()) {
                    try {
                        this.f44394a.m2475a();
                        GifTextureView gifTextureView3 = this.f44398e.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.f44395b.m2522a(surface, this.f44397d);
                            } finally {
                                surface.release();
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.f44395b.m2537A();
                this.f44395b = new GifInfoHandle();
            } catch (IOException e) {
                this.f44396c = e;
            }
        }
    }

    public GifTextureView(Context context) {
        super(context);
        this.f44387a = ImageView.ScaleType.FIT_CENTER;
        this.f44388b = new Matrix();
        this.f44391e = 1.0f;
        m2486g(null, 0, 0);
    }

    /* renamed from: f */
    private static InputSource m2487f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(C15438R.styleable.GifTextureView_gifSource, typedValue)) {
            if (typedValue.resourceId != 0) {
                String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
                if (GifViewUtils.f44445b.contains(resourceTypeName)) {
                    return new InputSource.C15456i(typedArray.getResources(), typedValue.resourceId);
                }
                if (!"string".equals(resourceTypeName)) {
                    throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
                }
            }
            return new InputSource.C15450c(typedArray.getResources().getAssets(), typedValue.string.toString());
        }
        return null;
    }

    /* renamed from: g */
    private void m2486g(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f44386g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f44387a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C15438R.styleable.GifTextureView, i, i2);
            this.f44389c = m2487f(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(C15438R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f44392f = new GifViewUtils.C15447b(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
            this.f44392f = new GifViewUtils.C15447b();
        }
        if (isInEditMode()) {
            return;
        }
        TextureView$SurfaceTextureListenerC15435c textureView$SurfaceTextureListenerC15435c = new TextureView$SurfaceTextureListenerC15435c(this);
        this.f44390d = textureView$SurfaceTextureListenerC15435c;
        if (this.f44389c != null) {
            textureView$SurfaceTextureListenerC15435c.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2484i(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float m2506q = gifInfoHandle.m2506q() / width;
        float m2514i = gifInfoHandle.m2514i() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.m2506q(), gifInfoHandle.m2514i());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f = 1.0f;
        switch (C15433a.f44393a[this.f44387a.ordinal()]) {
            case 1:
                matrix.setScale(m2506q, m2514i, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(m2506q, m2514i);
                matrix.setScale(m2506q * min, min * m2514i, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.m2506q() > width || gifInfoHandle.m2514i() > height) {
                    f = Math.min(1.0f / m2506q, 1.0f / m2514i);
                }
                matrix.setScale(m2506q * f, f * m2514i, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(m2506q, m2514i);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(m2506q, m2514i);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(m2506q, m2514i);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f44388b);
                matrix.preScale(m2506q, m2514i);
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
        if (this.f44390d.f44396c != null) {
            return this.f44390d.f44396c;
        }
        return GifIOException.fromCode(this.f44390d.f44395b.m2511l());
    }

    public ImageView.ScaleType getScaleType() {
        return this.f44387a;
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
        matrix.set(this.f44388b);
        return matrix;
    }

    /* renamed from: h */
    public synchronized void m2485h(@Nullable InputSource inputSource, @Nullable InterfaceC15434b interfaceC15434b) {
        this.f44390d.m2480c(this, interfaceC15434b);
        try {
            this.f44390d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f44389c = inputSource;
        TextureView$SurfaceTextureListenerC15435c textureView$SurfaceTextureListenerC15435c = new TextureView$SurfaceTextureListenerC15435c(this);
        this.f44390d = textureView$SurfaceTextureListenerC15435c;
        if (inputSource != null) {
            textureView$SurfaceTextureListenerC15435c.start();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f44390d.m2480c(this, null);
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
        this.f44390d.f44397d = gifViewSavedState.f44401a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        TextureView$SurfaceTextureListenerC15435c textureView$SurfaceTextureListenerC15435c = this.f44390d;
        textureView$SurfaceTextureListenerC15435c.f44397d = textureView$SurfaceTextureListenerC15435c.f44395b.m2508o();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f44392f.f44448a ? this.f44390d.f44397d : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.f44392f.f44448a = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable InputSource inputSource) {
        m2485h(inputSource, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.f44389c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f44387a = scaleType;
        m2484i(this.f44390d.f44395b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.f44391e = f;
        this.f44390d.f44395b.m2526L(f);
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
        this.f44388b.set(matrix);
        m2484i(this.f44390d.f44395b);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44387a = ImageView.ScaleType.FIT_CENTER;
        this.f44388b = new Matrix();
        this.f44391e = 1.0f;
        m2486g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44387a = ImageView.ScaleType.FIT_CENTER;
        this.f44388b = new Matrix();
        this.f44391e = 1.0f;
        m2486g(attributeSet, i, 0);
    }

    @RequiresApi(21)
    public GifTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f44387a = ImageView.ScaleType.FIT_CENTER;
        this.f44388b = new Matrix();
        this.f44391e = 1.0f;
        m2486g(attributeSet, i, i2);
    }
}
