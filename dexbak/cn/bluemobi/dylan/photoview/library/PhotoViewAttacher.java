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
import cn.bluemobi.dylan.photoview.library.gestures.OnGestureListener;
import cn.bluemobi.dylan.photoview.library.gestures.VersionedGestureDetector;
import cn.bluemobi.dylan.photoview.library.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;
import p584e.InterfaceC13574b;
import p584e.LogManager;

/* renamed from: cn.bluemobi.dylan.photoview.library.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PhotoViewAttacher implements IPhotoView, View.OnTouchListener, OnGestureListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: B */
    private static final String f1903B = "PhotoViewAttacher";

    /* renamed from: C */
    private static final boolean f1904C = Log.isLoggable(f1903B, 3);

    /* renamed from: D */
    static final Interpolator f1905D = new AccelerateDecelerateInterpolator();

    /* renamed from: E */
    static final int f1906E = -1;

    /* renamed from: F */
    static final int f1907F = 0;

    /* renamed from: G */
    static final int f1908G = 1;

    /* renamed from: H */
    static final int f1909H = 2;

    /* renamed from: A */
    private ImageView.ScaleType f1910A;

    /* renamed from: a */
    int f1911a;

    /* renamed from: b */
    private float f1912b;

    /* renamed from: c */
    private float f1913c;

    /* renamed from: d */
    private float f1914d;

    /* renamed from: e */
    private boolean f1915e;

    /* renamed from: f */
    private boolean f1916f;

    /* renamed from: g */
    private WeakReference<ImageView> f1917g;

    /* renamed from: h */
    private GestureDetector f1918h;

    /* renamed from: i */
    private cn.bluemobi.dylan.photoview.library.gestures.GestureDetector f1919i;

    /* renamed from: j */
    private final Matrix f1920j;

    /* renamed from: k */
    private final Matrix f1921k;

    /* renamed from: l */
    private final Matrix f1922l;

    /* renamed from: m */
    private final RectF f1923m;

    /* renamed from: n */
    private final float[] f1924n;

    /* renamed from: o */
    private InterfaceC1209e f1925o;

    /* renamed from: p */
    private InterfaceC1210f f1926p;

    /* renamed from: q */
    private InterfaceC1212h f1927q;

    /* renamed from: r */
    private View.OnLongClickListener f1928r;

    /* renamed from: s */
    private InterfaceC1211g f1929s;

    /* renamed from: t */
    private int f1930t;

    /* renamed from: u */
    private int f1931u;

    /* renamed from: v */
    private int f1932v;

    /* renamed from: w */
    private int f1933w;

    /* renamed from: x */
    private RunnableC1208d f1934x;

    /* renamed from: y */
    private int f1935y;

    /* renamed from: z */
    private boolean f1936z;

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1205a extends GestureDetector.SimpleOnGestureListener {
        C1205a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttacher.this.f1928r != null) {
                PhotoViewAttacher.this.f1928r.onLongClick(PhotoViewAttacher.this.m57531u());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static /* synthetic */ class C1206b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1938a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f1938a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1938a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1938a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1938a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1938a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC1207c implements Runnable {

        /* renamed from: a */
        private final float f1939a;

        /* renamed from: b */
        private final float f1940b;

        /* renamed from: c */
        private final long f1941c = System.currentTimeMillis();

        /* renamed from: d */
        private final float f1942d;

        /* renamed from: e */
        private final float f1943e;

        public RunnableC1207c(float f, float f2, float f3, float f4) {
            this.f1939a = f3;
            this.f1940b = f4;
            this.f1942d = f;
            this.f1943e = f2;
        }

        /* renamed from: a */
        private float m57525a() {
            return PhotoViewAttacher.f1905D.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f1941c)) * 1.0f) / PhotoViewAttacher.this.f1911a));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView m57531u = PhotoViewAttacher.this.m57531u();
            if (m57531u == null) {
                return;
            }
            float m57525a = m57525a();
            float f = this.f1942d;
            PhotoViewAttacher.this.mo57512e((f + ((this.f1943e - f) * m57525a)) / PhotoViewAttacher.this.getScale(), this.f1939a, this.f1940b);
            if (m57525a < 1.0f) {
                Compat.m57555d(m57531u, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC1208d implements Runnable {

        /* renamed from: a */
        private final ScrollerProxy f1945a;

        /* renamed from: b */
        private int f1946b;

        /* renamed from: c */
        private int f1947c;

        public RunnableC1208d(Context context) {
            this.f1945a = ScrollerProxy.m57504f(context);
        }

        /* renamed from: a */
        public void m57524a() {
            if (PhotoViewAttacher.f1904C) {
                LogManager.m12836a().mo12831d(PhotoViewAttacher.f1903B, "Cancel Fling");
            }
            this.f1945a.mo57507c(true);
        }

        /* renamed from: b */
        public void m57523b(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f = i;
            if (f < displayRect.width()) {
                i6 = Math.round(displayRect.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-displayRect.top);
            float f2 = i2;
            if (f2 < displayRect.height()) {
                i8 = Math.round(displayRect.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.f1946b = round;
            this.f1947c = round2;
            if (PhotoViewAttacher.f1904C) {
                LogManager.m12836a().mo12831d(PhotoViewAttacher.f1903B, "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i6 + " MaxY:" + i8);
            }
            if (round == i6 && round2 == i8) {
                return;
            }
            this.f1945a.mo57508b(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView m57531u;
            if (this.f1945a.mo57503g() || (m57531u = PhotoViewAttacher.this.m57531u()) == null || !this.f1945a.mo57509a()) {
                return;
            }
            int mo57506d = this.f1945a.mo57506d();
            int mo57505e = this.f1945a.mo57505e();
            if (PhotoViewAttacher.f1904C) {
                InterfaceC13574b m12836a = LogManager.m12836a();
                m12836a.mo12831d(PhotoViewAttacher.f1903B, "fling run(). CurrentX:" + this.f1946b + " CurrentY:" + this.f1947c + " NewX:" + mo57506d + " NewY:" + mo57505e);
            }
            PhotoViewAttacher.this.f1922l.postTranslate(this.f1946b - mo57506d, this.f1947c - mo57505e);
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.m57551B(photoViewAttacher.m57532t());
            this.f1946b = mo57506d;
            this.f1947c = mo57505e;
            Compat.m57555d(m57531u, this);
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1209e {
        /* renamed from: a */
        void m57522a(RectF rectF);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1210f {
        /* renamed from: a */
        void mo57521a(View view, float f, float f2);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$g */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1211g {
        /* renamed from: a */
        void m57520a(float f, float f2, float f3);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$h */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1212h {
        /* renamed from: a */
        void m57519a(View view, float f, float f2);
    }

    public PhotoViewAttacher(ImageView imageView) {
        this(imageView, true);
    }

    /* renamed from: A */
    private void m57552A() {
        this.f1922l.reset();
        m57551B(m57532t());
        m57536p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m57551B(Matrix matrix) {
        RectF m57533s;
        ImageView m57531u = m57531u();
        if (m57531u != null) {
            m57537o();
            m57531u.setImageMatrix(matrix);
            if (this.f1925o == null || (m57533s = m57533s(matrix)) == null) {
                return;
            }
            this.f1925o.m57522a(m57533s);
        }
    }

    /* renamed from: C */
    private static void m57550C(ImageView imageView) {
        if (imageView == null || (imageView instanceof IPhotoView) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: D */
    private void m57549D(Drawable drawable) {
        ImageView m57531u = m57531u();
        if (m57531u == null || drawable == null) {
            return;
        }
        float m57529w = m57529w(m57531u);
        float m57530v = m57530v(m57531u);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f1920j.reset();
        float f = intrinsicWidth;
        float f2 = m57529w / f;
        float f3 = intrinsicHeight;
        float f4 = m57530v / f3;
        ImageView.ScaleType scaleType = this.f1910A;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f1920j.postTranslate((m57529w - f) / 2.0f, (m57530v - f3) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            this.f1920j.postScale(max, max);
            this.f1920j.postTranslate((m57529w - (f * max)) / 2.0f, (m57530v - (f3 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            this.f1920j.postScale(min, min);
            this.f1920j.postTranslate((m57529w - (f * min)) / 2.0f, (m57530v - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, m57529w, m57530v);
            int i = C1206b.f1938a[this.f1910A.ordinal()];
            if (i == 2) {
                this.f1920j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.f1920j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.f1920j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 5) {
                this.f1920j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        m57552A();
    }

    /* renamed from: m */
    private void m57539m() {
        RunnableC1208d runnableC1208d = this.f1934x;
        if (runnableC1208d != null) {
            runnableC1208d.m57524a();
            this.f1934x = null;
        }
    }

    /* renamed from: n */
    private void m57538n() {
        if (m57536p()) {
            m57551B(m57532t());
        }
    }

    /* renamed from: o */
    private void m57537o() {
        ImageView m57531u = m57531u();
        if (m57531u != null && !(m57531u instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(m57531u.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /* renamed from: p */
    private boolean m57536p() {
        RectF m57533s;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        ImageView m57531u = m57531u();
        if (m57531u == null || (m57533s = m57533s(m57532t())) == null) {
            return false;
        }
        float height = m57533s.height();
        float width = m57533s.width();
        float m57530v = m57530v(m57531u);
        float f7 = 0.0f;
        if (height <= m57530v) {
            int i = C1206b.f1938a[this.f1910A.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    m57530v = (m57530v - height) / 2.0f;
                    f2 = m57533s.top;
                } else {
                    m57530v -= height;
                    f2 = m57533s.top;
                }
                f3 = m57530v - f2;
            } else {
                f = m57533s.top;
                f3 = -f;
            }
        } else {
            f = m57533s.top;
            if (f <= 0.0f) {
                f2 = m57533s.bottom;
                if (f2 >= m57530v) {
                    f3 = 0.0f;
                }
                f3 = m57530v - f2;
            }
            f3 = -f;
        }
        float m57529w = m57529w(m57531u);
        if (width <= m57529w) {
            int i2 = C1206b.f1938a[this.f1910A.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (m57529w - width) / 2.0f;
                    f6 = m57533s.left;
                } else {
                    f5 = m57529w - width;
                    f6 = m57533s.left;
                }
                f4 = f5 - f6;
            } else {
                f4 = -m57533s.left;
            }
            f7 = f4;
            this.f1935y = 2;
        } else {
            float f8 = m57533s.left;
            if (f8 > 0.0f) {
                this.f1935y = 0;
                f7 = -f8;
            } else {
                float f9 = m57533s.right;
                if (f9 < m57529w) {
                    f7 = m57529w - f9;
                    this.f1935y = 1;
                } else {
                    this.f1935y = -1;
                }
            }
        }
        this.f1922l.postTranslate(f7, f3);
        return true;
    }

    /* renamed from: q */
    private static void m57535q(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f2 >= f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    /* renamed from: s */
    private RectF m57533s(Matrix matrix) {
        Drawable drawable;
        ImageView m57531u = m57531u();
        if (m57531u == null || (drawable = m57531u.getDrawable()) == null) {
            return null;
        }
        this.f1923m.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f1923m);
        return this.f1923m;
    }

    /* renamed from: v */
    private int m57530v(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* renamed from: w */
    private int m57529w(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* renamed from: x */
    private float m57528x(Matrix matrix, int i) {
        matrix.getValues(this.f1924n);
        return this.f1924n[i];
    }

    /* renamed from: y */
    private static boolean m57527y(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    /* renamed from: z */
    private static boolean m57526z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (C1206b.f1938a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: a */
    public boolean mo57548a() {
        return this.f1936z;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: b */
    public void mo57547b(float f, float f2, float f3, boolean z) {
        ImageView m57531u = m57531u();
        if (m57531u != null) {
            if (f < this.f1912b || f > this.f1914d) {
                LogManager.m12836a().mo12828i(f1903B, "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                m57531u.post(new RunnableC1207c(getScale(), f, f2, f3));
            } else {
                this.f1922l.setScale(f, f, f2, f3);
                m57538n();
            }
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.OnGestureListener
    /* renamed from: c */
    public void mo57513c(float f, float f2) {
        if (this.f1919i.mo57514c()) {
            return;
        }
        if (f1904C) {
            LogManager.m12836a().mo12831d(f1903B, String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f), Float.valueOf(f2)));
        }
        ImageView m57531u = m57531u();
        this.f1922l.postTranslate(f, f2);
        m57538n();
        ViewParent parent = m57531u.getParent();
        if (!this.f1915e || this.f1919i.mo57514c() || this.f1916f) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i = this.f1935y;
        if ((i == 2 || ((i == 0 && f >= 1.0f) || (i == 1 && f <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: d */
    public void mo57546d(float f, boolean z) {
        ImageView m57531u = m57531u();
        if (m57531u != null) {
            mo57547b(f, m57531u.getRight() / 2, m57531u.getBottom() / 2, z);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.OnGestureListener
    /* renamed from: e */
    public void mo57512e(float f, float f2, float f3) {
        if (f1904C) {
            LogManager.m12836a().mo12831d(f1903B, String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)));
        }
        if (getScale() < this.f1914d || f < 1.0f) {
            InterfaceC1211g interfaceC1211g = this.f1929s;
            if (interfaceC1211g != null) {
                interfaceC1211g.m57520a(f, f2, f3);
            }
            this.f1922l.postScale(f, f, f2, f3);
            m57538n();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: f */
    public boolean mo57545f(Matrix matrix) {
        if (matrix != null) {
            ImageView m57531u = m57531u();
            if (m57531u == null || m57531u.getDrawable() == null) {
                return false;
            }
            this.f1922l.set(matrix);
            m57551B(m57532t());
            m57536p();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.OnGestureListener
    /* renamed from: g */
    public void mo57511g(float f, float f2, float f3, float f4) {
        if (f1904C) {
            InterfaceC13574b m12836a = LogManager.m12836a();
            m12836a.mo12831d(f1903B, "onFling. sX: " + f + " sY: " + f2 + " Vx: " + f3 + " Vy: " + f4);
        }
        ImageView m57531u = m57531u();
        RunnableC1208d runnableC1208d = new RunnableC1208d(m57531u.getContext());
        this.f1934x = runnableC1208d;
        runnableC1208d.m57523b(m57529w(m57531u), m57530v(m57531u), (int) f3, (int) f4);
        m57531u.post(this.f1934x);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public Matrix getDisplayMatrix() {
        return new Matrix(m57532t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public RectF getDisplayRect() {
        m57536p();
        return m57533s(m57532t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public IPhotoView getIPhotoViewImplementation() {
        return this;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMaximumScale() {
        return this.f1914d;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMediumScale() {
        return this.f1913c;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getMinimumScale() {
        return this.f1912b;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public InterfaceC1210f getOnPhotoTapListener() {
        return this.f1926p;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public InterfaceC1212h getOnViewTapListener() {
        return this.f1927q;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(m57528x(this.f1922l, 0), 2.0d)) + ((float) Math.pow(m57528x(this.f1922l, 3), 2.0d)));
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.f1910A;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public Bitmap getVisibleRectangleBitmap() {
        ImageView m57531u = m57531u();
        if (m57531u == null) {
            return null;
        }
        return m57531u.getDrawingCache();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    /* renamed from: h */
    public void mo57544h(float f, float f2, float f3) {
        m57535q(f, f2, f3);
        this.f1912b = f;
        this.f1913c = f2;
        this.f1914d = f3;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView m57531u = m57531u();
        if (m57531u != null) {
            if (this.f1936z) {
                int top2 = m57531u.getTop();
                int right = m57531u.getRight();
                int bottom = m57531u.getBottom();
                int left = m57531u.getLeft();
                if (top2 == this.f1930t && bottom == this.f1932v && left == this.f1933w && right == this.f1931u) {
                    return;
                }
                m57549D(m57531u.getDrawable());
                this.f1930t = top2;
                this.f1931u = right;
                this.f1932v = bottom;
                this.f1933w = left;
                return;
            }
            m57549D(m57531u.getDrawable());
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
            boolean r0 = r10.f1936z
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = m57527y(r0)
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
            float r3 = r10.f1912b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L5d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L5d
            cn.bluemobi.dylan.photoview.library.d$c r9 = new cn.bluemobi.dylan.photoview.library.d$c
            float r5 = r10.getScale()
            float r6 = r10.f1912b
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
            e.b r11 = p584e.LogManager.m12836a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.mo12828i(r0, r3)
        L5a:
            r10.m57539m()
        L5d:
            r11 = 0
        L5e:
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1919i
            if (r0 == 0) goto L95
            boolean r11 = r0.mo57514c()
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1919i
            boolean r0 = r0.mo57515b()
            cn.bluemobi.dylan.photoview.library.gestures.d r3 = r10.f1919i
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L7e
            cn.bluemobi.dylan.photoview.library.gestures.d r11 = r10.f1919i
            boolean r11 = r11.mo57514c()
            if (r11 != 0) goto L7e
            r11 = 1
            goto L7f
        L7e:
            r11 = 0
        L7f:
            if (r0 != 0) goto L8b
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r10.f1919i
            boolean r0 = r0.mo57515b()
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
            r10.f1916f = r1
            r1 = r3
            goto L96
        L95:
            r1 = r11
        L96:
            android.view.GestureDetector r11 = r10.f1918h
            if (r11 == 0) goto La1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto La1
            r1 = 1
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.photoview.library.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: r */
    public void m57534r() {
        WeakReference<ImageView> weakReference = this.f1917g;
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
            m57539m();
        }
        GestureDetector gestureDetector = this.f1918h;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f1925o = null;
        this.f1926p = null;
        this.f1927q = null;
        this.f1917g = null;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f1915e = z;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMaximumScale(float f) {
        m57535q(this.f1912b, this.f1913c, f);
        this.f1914d = f;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMediumScale(float f) {
        m57535q(this.f1912b, f, this.f1914d);
        this.f1913c = f;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setMinimumScale(float f) {
        m57535q(f, this.f1913c, this.f1914d);
        this.f1912b = f;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f1918h.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f1918h.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1928r = onLongClickListener;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnMatrixChangeListener(InterfaceC1209e interfaceC1209e) {
        this.f1925o = interfaceC1209e;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnPhotoTapListener(InterfaceC1210f interfaceC1210f) {
        this.f1926p = interfaceC1210f;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnScaleChangeListener(InterfaceC1211g interfaceC1211g) {
        this.f1929s = interfaceC1211g;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setOnViewTapListener(InterfaceC1212h interfaceC1212h) {
        this.f1927q = interfaceC1212h;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setPhotoViewRotation(float f) {
        this.f1922l.setRotate(f % 360.0f);
        m57538n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setRotationBy(float f) {
        this.f1922l.postRotate(f % 360.0f);
        m57538n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setRotationTo(float f) {
        this.f1922l.setRotate(f % 360.0f);
        m57538n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setScale(float f) {
        mo57546d(f, false);
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!m57526z(scaleType) || scaleType == this.f1910A) {
            return;
        }
        this.f1910A = scaleType;
        update();
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.f1911a = i;
    }

    @Override // cn.bluemobi.dylan.photoview.library.IPhotoView
    public void setZoomable(boolean z) {
        this.f1936z = z;
        update();
    }

    /* renamed from: t */
    public Matrix m57532t() {
        this.f1921k.set(this.f1920j);
        this.f1921k.postConcat(this.f1922l);
        return this.f1921k;
    }

    /* renamed from: u */
    public ImageView m57531u() {
        WeakReference<ImageView> weakReference = this.f1917g;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            m57534r();
            LogManager.m12836a().mo12828i(f1903B, "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public void update() {
        ImageView m57531u = m57531u();
        if (m57531u != null) {
            if (this.f1936z) {
                m57550C(m57531u);
                m57549D(m57531u.getDrawable());
                return;
            }
            m57552A();
        }
    }

    public PhotoViewAttacher(ImageView imageView, boolean z) {
        this.f1911a = 200;
        this.f1912b = 1.0f;
        this.f1913c = 1.75f;
        this.f1914d = 3.0f;
        this.f1915e = true;
        this.f1916f = false;
        this.f1920j = new Matrix();
        this.f1921k = new Matrix();
        this.f1922l = new Matrix();
        this.f1923m = new RectF();
        this.f1924n = new float[9];
        this.f1935y = 2;
        this.f1910A = ImageView.ScaleType.FIT_CENTER;
        this.f1917g = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        m57550C(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f1919i = VersionedGestureDetector.m57510a(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new C1205a());
        this.f1918h = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        setZoomable(z);
    }
}
