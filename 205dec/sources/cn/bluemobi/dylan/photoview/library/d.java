package cn.bluemobi.dylan.photoview.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PhotoViewAttacher.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d implements cn.bluemobi.dylan.photoview.library.c, View.OnTouchListener, cn.bluemobi.dylan.photoview.library.gestures.e, ViewTreeObserver.OnGlobalLayoutListener {
    private static final String B = "PhotoViewAttacher";
    private static final boolean C = Log.isLoggable("PhotoViewAttacher", 3);
    static final Interpolator D = new AccelerateDecelerateInterpolator();
    static final int E = -1;
    static final int F = 0;
    static final int G = 1;
    static final int H = 2;
    private ImageView.ScaleType A;

    /* renamed from: a  reason: collision with root package name */
    int f1888a;

    /* renamed from: b  reason: collision with root package name */
    private float f1889b;

    /* renamed from: c  reason: collision with root package name */
    private float f1890c;

    /* renamed from: d  reason: collision with root package name */
    private float f1891d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1892e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1893f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<ImageView> f1894g;

    /* renamed from: h  reason: collision with root package name */
    private GestureDetector f1895h;

    /* renamed from: i  reason: collision with root package name */
    private cn.bluemobi.dylan.photoview.library.gestures.d f1896i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f1897j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f1898k;

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f1899l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f1900m;

    /* renamed from: n  reason: collision with root package name */
    private final float[] f1901n;

    /* renamed from: o  reason: collision with root package name */
    private e f1902o;

    /* renamed from: p  reason: collision with root package name */
    private f f1903p;

    /* renamed from: q  reason: collision with root package name */
    private h f1904q;

    /* renamed from: r  reason: collision with root package name */
    private View.OnLongClickListener f1905r;

    /* renamed from: s  reason: collision with root package name */
    private g f1906s;

    /* renamed from: t  reason: collision with root package name */
    private int f1907t;

    /* renamed from: u  reason: collision with root package name */
    private int f1908u;

    /* renamed from: v  reason: collision with root package name */
    private int f1909v;

    /* renamed from: w  reason: collision with root package name */
    private int f1910w;

    /* renamed from: x  reason: collision with root package name */
    private RunnableC0041d f1911x;

    /* renamed from: y  reason: collision with root package name */
    private int f1912y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1913z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.f1905r != null) {
                d.this.f1905r.onLongClick(d.this.u());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1915a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f1915a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1915a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1915a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1915a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1915a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final float f1916a;

        /* renamed from: b  reason: collision with root package name */
        private final float f1917b;

        /* renamed from: c  reason: collision with root package name */
        private final long f1918c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f1919d;

        /* renamed from: e  reason: collision with root package name */
        private final float f1920e;

        public c(float f4, float f5, float f6, float f7) {
            this.f1916a = f6;
            this.f1917b = f7;
            this.f1919d = f4;
            this.f1920e = f5;
        }

        private float a() {
            return d.D.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f1918c)) * 1.0f) / d.this.f1888a));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView u3 = d.this.u();
            if (u3 == null) {
                return;
            }
            float a4 = a();
            float f4 = this.f1919d;
            d.this.e((f4 + ((this.f1920e - f4) * a4)) / d.this.getScale(), this.f1916a, this.f1917b);
            if (a4 < 1.0f) {
                cn.bluemobi.dylan.photoview.library.a.d(u3, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class RunnableC0041d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final cn.bluemobi.dylan.photoview.library.scrollerproxy.d f1922a;

        /* renamed from: b  reason: collision with root package name */
        private int f1923b;

        /* renamed from: c  reason: collision with root package name */
        private int f1924c;

        public RunnableC0041d(Context context) {
            this.f1922a = cn.bluemobi.dylan.photoview.library.scrollerproxy.d.f(context);
        }

        public void a() {
            if (d.C) {
                c.a.a().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.f1922a.c(true);
        }

        public void b(int i4, int i5, int i6, int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            RectF displayRect = d.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f4 = i4;
            if (f4 < displayRect.width()) {
                i9 = Math.round(displayRect.width() - f4);
                i8 = 0;
            } else {
                i8 = round;
                i9 = i8;
            }
            int round2 = Math.round(-displayRect.top);
            float f5 = i5;
            if (f5 < displayRect.height()) {
                i11 = Math.round(displayRect.height() - f5);
                i10 = 0;
            } else {
                i10 = round2;
                i11 = i10;
            }
            this.f1923b = round;
            this.f1924c = round2;
            if (d.C) {
                c.a.a().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i9 + " MaxY:" + i11);
            }
            if (round == i9 && round2 == i11) {
                return;
            }
            this.f1922a.b(round, round2, i6, i7, i8, i9, i10, i11, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView u3;
            if (this.f1922a.g() || (u3 = d.this.u()) == null || !this.f1922a.a()) {
                return;
            }
            int d4 = this.f1922a.d();
            int e4 = this.f1922a.e();
            if (d.C) {
                c.b a4 = c.a.a();
                a4.d("PhotoViewAttacher", "fling run(). CurrentX:" + this.f1923b + " CurrentY:" + this.f1924c + " NewX:" + d4 + " NewY:" + e4);
            }
            d.this.f1899l.postTranslate(this.f1923b - d4, this.f1924c - e4);
            d dVar = d.this;
            dVar.B(dVar.t());
            this.f1923b = d4;
            this.f1924c = e4;
            cn.bluemobi.dylan.photoview.library.a.d(u3, this);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface e {
        void a(RectF rectF);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface f {
        void a(View view, float f4, float f5);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface g {
        void a(float f4, float f5, float f6);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface h {
        void a(View view, float f4, float f5);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    private void A() {
        this.f1899l.reset();
        B(t());
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Matrix matrix) {
        RectF s3;
        ImageView u3 = u();
        if (u3 != null) {
            o();
            u3.setImageMatrix(matrix);
            if (this.f1902o == null || (s3 = s(matrix)) == null) {
                return;
            }
            this.f1902o.a(s3);
        }
    }

    private static void C(ImageView imageView) {
        if (imageView == null || (imageView instanceof cn.bluemobi.dylan.photoview.library.c) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void D(Drawable drawable) {
        ImageView u3 = u();
        if (u3 == null || drawable == null) {
            return;
        }
        float w3 = w(u3);
        float v3 = v(u3);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f1897j.reset();
        float f4 = intrinsicWidth;
        float f5 = w3 / f4;
        float f6 = intrinsicHeight;
        float f7 = v3 / f6;
        ImageView.ScaleType scaleType = this.A;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f1897j.postTranslate((w3 - f4) / 2.0f, (v3 - f6) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f5, f7);
            this.f1897j.postScale(max, max);
            this.f1897j.postTranslate((w3 - (f4 * max)) / 2.0f, (v3 - (f6 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f5, f7));
            this.f1897j.postScale(min, min);
            this.f1897j.postTranslate((w3 - (f4 * min)) / 2.0f, (v3 - (f6 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f4, f6);
            RectF rectF2 = new RectF(0.0f, 0.0f, w3, v3);
            int i4 = b.f1915a[this.A.ordinal()];
            if (i4 == 2) {
                this.f1897j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i4 == 3) {
                this.f1897j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i4 == 4) {
                this.f1897j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i4 == 5) {
                this.f1897j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        A();
    }

    private void m() {
        RunnableC0041d runnableC0041d = this.f1911x;
        if (runnableC0041d != null) {
            runnableC0041d.a();
            this.f1911x = null;
        }
    }

    private void n() {
        if (p()) {
            B(t());
        }
    }

    private void o() {
        ImageView u3 = u();
        if (u3 != null && !(u3 instanceof cn.bluemobi.dylan.photoview.library.c) && !ImageView.ScaleType.MATRIX.equals(u3.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean p() {
        RectF s3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        ImageView u3 = u();
        if (u3 == null || (s3 = s(t())) == null) {
            return false;
        }
        float height = s3.height();
        float width = s3.width();
        float v3 = v(u3);
        float f10 = 0.0f;
        if (height <= v3) {
            int i4 = b.f1915a[this.A.ordinal()];
            if (i4 != 2) {
                if (i4 != 3) {
                    v3 = (v3 - height) / 2.0f;
                    f5 = s3.top;
                } else {
                    v3 -= height;
                    f5 = s3.top;
                }
                f6 = v3 - f5;
            } else {
                f4 = s3.top;
                f6 = -f4;
            }
        } else {
            f4 = s3.top;
            if (f4 <= 0.0f) {
                f5 = s3.bottom;
                if (f5 >= v3) {
                    f6 = 0.0f;
                }
                f6 = v3 - f5;
            }
            f6 = -f4;
        }
        float w3 = w(u3);
        if (width <= w3) {
            int i5 = b.f1915a[this.A.ordinal()];
            if (i5 != 2) {
                if (i5 != 3) {
                    f8 = (w3 - width) / 2.0f;
                    f9 = s3.left;
                } else {
                    f8 = w3 - width;
                    f9 = s3.left;
                }
                f7 = f8 - f9;
            } else {
                f7 = -s3.left;
            }
            f10 = f7;
            this.f1912y = 2;
        } else {
            float f11 = s3.left;
            if (f11 > 0.0f) {
                this.f1912y = 0;
                f10 = -f11;
            } else {
                float f12 = s3.right;
                if (f12 < w3) {
                    f10 = w3 - f12;
                    this.f1912y = 1;
                } else {
                    this.f1912y = -1;
                }
            }
        }
        this.f1899l.postTranslate(f10, f6);
        return true;
    }

    private static void q(float f4, float f5, float f6) {
        if (f4 >= f5) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f5 >= f6) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private RectF s(Matrix matrix) {
        Drawable drawable;
        ImageView u3 = u();
        if (u3 == null || (drawable = u3.getDrawable()) == null) {
            return null;
        }
        this.f1900m.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f1900m);
        return this.f1900m;
    }

    private int v(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int w(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float x(Matrix matrix, int i4) {
        matrix.getValues(this.f1901n);
        return this.f1901n[i4];
    }

    private static boolean y(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.f1915a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean a() {
        return this.f1913z;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void b(float f4, float f5, float f6, boolean z3) {
        ImageView u3 = u();
        if (u3 != null) {
            if (f4 < this.f1889b || f4 > this.f1891d) {
                c.a.a().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z3) {
                u3.post(new c(getScale(), f4, f5, f6));
            } else {
                this.f1899l.setScale(f4, f4, f5, f6);
                n();
            }
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void c(float f4, float f5) {
        if (this.f1896i.c()) {
            return;
        }
        if (C) {
            c.a.a().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f4), Float.valueOf(f5)));
        }
        ImageView u3 = u();
        this.f1899l.postTranslate(f4, f5);
        n();
        ViewParent parent = u3.getParent();
        if (!this.f1892e || this.f1896i.c() || this.f1893f) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i4 = this.f1912y;
        if ((i4 == 2 || ((i4 == 0 && f4 >= 1.0f) || (i4 == 1 && f4 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void d(float f4, boolean z3) {
        ImageView u3 = u();
        if (u3 != null) {
            b(f4, u3.getRight() / 2, u3.getBottom() / 2, z3);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void e(float f4, float f5, float f6) {
        if (C) {
            c.a.a().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)));
        }
        if (getScale() < this.f1891d || f4 < 1.0f) {
            g gVar = this.f1906s;
            if (gVar != null) {
                gVar.a(f4, f5, f6);
            }
            this.f1899l.postScale(f4, f4, f5, f6);
            n();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean f(Matrix matrix) {
        if (matrix != null) {
            ImageView u3 = u();
            if (u3 == null || u3.getDrawable() == null) {
                return false;
            }
            this.f1899l.set(matrix);
            B(t());
            p();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void g(float f4, float f5, float f6, float f7) {
        if (C) {
            c.b a4 = c.a.a();
            a4.d("PhotoViewAttacher", "onFling. sX: " + f4 + " sY: " + f5 + " Vx: " + f6 + " Vy: " + f7);
        }
        ImageView u3 = u();
        RunnableC0041d runnableC0041d = new RunnableC0041d(u3.getContext());
        this.f1911x = runnableC0041d;
        runnableC0041d.b(w(u3), v(u3), (int) f6, (int) f7);
        u3.post(this.f1911x);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Matrix getDisplayMatrix() {
        return new Matrix(t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public RectF getDisplayRect() {
        p();
        return s(t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public cn.bluemobi.dylan.photoview.library.c getIPhotoViewImplementation() {
        return this;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMaximumScale() {
        return this.f1891d;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMediumScale() {
        return this.f1890c;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMinimumScale() {
        return this.f1889b;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public f getOnPhotoTapListener() {
        return this.f1903p;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public h getOnViewTapListener() {
        return this.f1904q;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(x(this.f1899l, 0), 2.0d)) + ((float) Math.pow(x(this.f1899l, 3), 2.0d)));
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public ImageView.ScaleType getScaleType() {
        return this.A;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Bitmap getVisibleRectangleBitmap() {
        ImageView u3 = u();
        if (u3 == null) {
            return null;
        }
        return u3.getDrawingCache();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void h(float f4, float f5, float f6) {
        q(f4, f5, f6);
        this.f1889b = f4;
        this.f1890c = f5;
        this.f1891d = f6;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView u3 = u();
        if (u3 != null) {
            if (this.f1913z) {
                int top2 = u3.getTop();
                int right = u3.getRight();
                int bottom = u3.getBottom();
                int left = u3.getLeft();
                if (top2 == this.f1907t && bottom == this.f1909v && left == this.f1910w && right == this.f1908u) {
                    return;
                }
                D(u3.getDrawable());
                this.f1907t = top2;
                this.f1908u = right;
                this.f1909v = bottom;
                this.f1910w = left;
                return;
            }
            D(u3.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.f1913z
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = y(r0)
            if (r0 == 0) goto La1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L49
            if (r3 == r2) goto L1f
            r0 = 3
            if (r3 == r0) goto L1f
            goto L5d
        L1f:
            float r0 = r10.getScale()
            float r3 = r10.f1889b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L5d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L5d
            cn.bluemobi.dylan.photoview.library.d$c r9 = new cn.bluemobi.dylan.photoview.library.d$c
            float r5 = r10.getScale()
            float r6 = r10.f1889b
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = 1
            goto L5e
        L49:
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L5a
        L4f:
            c.b r11 = c.a.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L5a:
            r10.m()
        L5d:
            r11 = 0
        L5e:
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1896i
            if (r0 == 0) goto L95
            boolean r11 = r0.c()
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1896i
            boolean r0 = r0.b()
            cn.bluemobi.dylan.photoview.library.gestures.d r3 = r10.f1896i
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L7e
            cn.bluemobi.dylan.photoview.library.gestures.d r11 = r10.f1896i
            boolean r11 = r11.c()
            if (r11 != 0) goto L7e
            r11 = 1
            goto L7f
        L7e:
            r11 = 0
        L7f:
            if (r0 != 0) goto L8b
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1896i
            boolean r0 = r0.b()
            if (r0 != 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            if (r11 == 0) goto L91
            if (r0 == 0) goto L91
            r1 = 1
        L91:
            r10.f1893f = r1
            r1 = r3
            goto L96
        L95:
            r1 = r11
        L96:
            android.view.GestureDetector r11 = r10.f1895h
            if (r11 == 0) goto La1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto La1
            r1 = 1
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.photoview.library.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void r() {
        WeakReference<ImageView> weakReference = this.f1894g;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            m();
        }
        GestureDetector gestureDetector = this.f1895h;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f1902o = null;
        this.f1903p = null;
        this.f1904q = null;
        this.f1894g = null;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setAllowParentInterceptOnEdge(boolean z3) {
        this.f1892e = z3;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMaxScale(float f4) {
        setMaximumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMaximumScale(float f4) {
        q(this.f1889b, this.f1890c, f4);
        this.f1891d = f4;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMediumScale(float f4) {
        q(this.f1889b, f4, this.f1891d);
        this.f1890c = f4;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMidScale(float f4) {
        setMediumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMinScale(float f4) {
        setMinimumScale(f4);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMinimumScale(float f4) {
        q(f4, this.f1890c, this.f1891d);
        this.f1889b = f4;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f1895h.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f1895h.setOnDoubleTapListener(new cn.bluemobi.dylan.photoview.library.b(this));
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1905r = onLongClickListener;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnMatrixChangeListener(e eVar) {
        this.f1902o = eVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnPhotoTapListener(f fVar) {
        this.f1903p = fVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnScaleChangeListener(g gVar) {
        this.f1906s = gVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnViewTapListener(h hVar) {
        this.f1904q = hVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setPhotoViewRotation(float f4) {
        this.f1899l.setRotate(f4 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationBy(float f4) {
        this.f1899l.postRotate(f4 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationTo(float f4) {
        this.f1899l.setRotate(f4 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScale(float f4) {
        d(f4, false);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!z(scaleType) || scaleType == this.A) {
            return;
        }
        this.A = scaleType;
        update();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomTransitionDuration(int i4) {
        if (i4 < 0) {
            i4 = 200;
        }
        this.f1888a = i4;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomable(boolean z3) {
        this.f1913z = z3;
        update();
    }

    public Matrix t() {
        this.f1898k.set(this.f1897j);
        this.f1898k.postConcat(this.f1899l);
        return this.f1898k;
    }

    public ImageView u() {
        WeakReference<ImageView> weakReference = this.f1894g;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            r();
            c.a.a().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public void update() {
        ImageView u3 = u();
        if (u3 != null) {
            if (this.f1913z) {
                C(u3);
                D(u3.getDrawable());
                return;
            }
            A();
        }
    }

    public d(ImageView imageView, boolean z3) {
        this.f1888a = 200;
        this.f1889b = 1.0f;
        this.f1890c = 1.75f;
        this.f1891d = 3.0f;
        this.f1892e = true;
        this.f1893f = false;
        this.f1897j = new Matrix();
        this.f1898k = new Matrix();
        this.f1899l = new Matrix();
        this.f1900m = new RectF();
        this.f1901n = new float[9];
        this.f1912y = 2;
        this.A = ImageView.ScaleType.FIT_CENTER;
        this.f1894g = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        C(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f1896i = cn.bluemobi.dylan.photoview.library.gestures.f.a(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
        this.f1895h = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new cn.bluemobi.dylan.photoview.library.b(this));
        setZoomable(z3);
    }
}
