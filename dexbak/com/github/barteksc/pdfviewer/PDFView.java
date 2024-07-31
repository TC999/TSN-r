package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.util.C6663b;
import com.github.barteksc.pdfviewer.util.C6668f;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p607j0.DefaultLinkHandler;
import p607j0.LinkHandler;
import p611k0.Callbacks;
import p611k0.OnDrawListener;
import p611k0.OnErrorListener;
import p611k0.OnLoadCompleteListener;
import p611k0.OnLongPressListener;
import p611k0.OnPageChangeListener;
import p611k0.OnPageErrorListener;
import p611k0.OnPageScrollListener;
import p611k0.OnRenderListener;
import p611k0.OnTapListener;
import p616l0.PagePart;
import p619m0.AssetSource;
import p619m0.C15294b;
import p619m0.FileSource;
import p619m0.InputStreamSource;
import p619m0.InterfaceC15295c;
import p619m0.UriSource;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PDFView extends RelativeLayout {

    /* renamed from: R */
    private static final String f23540R = PDFView.class.getSimpleName();

    /* renamed from: S */
    public static final float f23541S = 3.0f;

    /* renamed from: T */
    public static final float f23542T = 1.75f;

    /* renamed from: U */
    public static final float f23543U = 1.0f;

    /* renamed from: A */
    private boolean f23544A;

    /* renamed from: B */
    private boolean f23545B;

    /* renamed from: C */
    private boolean f23546C;

    /* renamed from: D */
    private PdfiumCore f23547D;

    /* renamed from: E */
    private ScrollHandle f23548E;

    /* renamed from: F */
    private boolean f23549F;

    /* renamed from: G */
    private boolean f23550G;

    /* renamed from: H */
    private boolean f23551H;

    /* renamed from: I */
    private boolean f23552I;

    /* renamed from: J */
    private boolean f23553J;

    /* renamed from: K */
    private PaintFlagsDrawFilter f23554K;

    /* renamed from: L */
    private int f23555L;

    /* renamed from: M */
    private boolean f23556M;

    /* renamed from: N */
    private boolean f23557N;

    /* renamed from: O */
    private List<Integer> f23558O;

    /* renamed from: P */
    private boolean f23559P;

    /* renamed from: Q */
    private C6640b f23560Q;

    /* renamed from: a */
    private float f23561a;

    /* renamed from: b */
    private float f23562b;

    /* renamed from: c */
    private float f23563c;

    /* renamed from: d */
    private EnumC6641c f23564d;

    /* renamed from: e */
    CacheManager f23565e;

    /* renamed from: f */
    private AnimationManager f23566f;

    /* renamed from: g */
    private DragPinchManager f23567g;

    /* renamed from: h */
    PdfFile f23568h;

    /* renamed from: i */
    private int f23569i;

    /* renamed from: j */
    private float f23570j;

    /* renamed from: k */
    private float f23571k;

    /* renamed from: l */
    private float f23572l;

    /* renamed from: m */
    private boolean f23573m;

    /* renamed from: n */
    private EnumC6642d f23574n;

    /* renamed from: o */
    private DecodingAsyncTask f23575o;

    /* renamed from: p */
    private HandlerThread f23576p;

    /* renamed from: q */
    RenderingHandler f23577q;

    /* renamed from: r */
    private PagesLoader f23578r;

    /* renamed from: s */
    Callbacks f23579s;

    /* renamed from: t */
    private Paint f23580t;

    /* renamed from: u */
    private Paint f23581u;

    /* renamed from: v */
    private FitPolicy f23582v;

    /* renamed from: w */
    private boolean f23583w;

    /* renamed from: x */
    private int f23584x;

    /* renamed from: y */
    private boolean f23585y;

    /* renamed from: z */
    private boolean f23586z;

    /* renamed from: com.github.barteksc.pdfviewer.PDFView$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6640b {

        /* renamed from: A */
        private boolean f23587A;

        /* renamed from: B */
        private boolean f23588B;

        /* renamed from: a */
        private final InterfaceC15295c f23590a;

        /* renamed from: b */
        private int[] f23591b;

        /* renamed from: c */
        private boolean f23592c;

        /* renamed from: d */
        private boolean f23593d;

        /* renamed from: e */
        private OnDrawListener f23594e;

        /* renamed from: f */
        private OnDrawListener f23595f;

        /* renamed from: g */
        private OnLoadCompleteListener f23596g;

        /* renamed from: h */
        private OnErrorListener f23597h;

        /* renamed from: i */
        private OnPageChangeListener f23598i;

        /* renamed from: j */
        private OnPageScrollListener f23599j;

        /* renamed from: k */
        private OnRenderListener f23600k;

        /* renamed from: l */
        private OnTapListener f23601l;

        /* renamed from: m */
        private OnLongPressListener f23602m;

        /* renamed from: n */
        private OnPageErrorListener f23603n;

        /* renamed from: o */
        private LinkHandler f23604o;

        /* renamed from: p */
        private int f23605p;

        /* renamed from: q */
        private boolean f23606q;

        /* renamed from: r */
        private boolean f23607r;

        /* renamed from: s */
        private String f23608s;

        /* renamed from: t */
        private ScrollHandle f23609t;

        /* renamed from: u */
        private boolean f23610u;

        /* renamed from: v */
        private int f23611v;

        /* renamed from: w */
        private boolean f23612w;

        /* renamed from: x */
        private FitPolicy f23613x;

        /* renamed from: y */
        private boolean f23614y;

        /* renamed from: z */
        private boolean f23615z;

        /* renamed from: A */
        public C6640b m35427A(ScrollHandle scrollHandle) {
            this.f23609t = scrollHandle;
            return this;
        }

        /* renamed from: B */
        public C6640b m35426B(int i) {
            this.f23611v = i;
            return this;
        }

        /* renamed from: C */
        public C6640b m35425C(boolean z) {
            this.f23606q = z;
            return this;
        }

        /* renamed from: a */
        public C6640b m35424a(boolean z) {
            this.f23612w = z;
            return this;
        }

        /* renamed from: b */
        public C6640b m35423b(int i) {
            this.f23605p = i;
            return this;
        }

        /* renamed from: c */
        public C6640b m35422c() {
            PDFView.this.f23567g.m35367d();
            return this;
        }

        /* renamed from: d */
        public C6640b m35421d(boolean z) {
            this.f23607r = z;
            return this;
        }

        /* renamed from: e */
        public C6640b m35420e(boolean z) {
            this.f23610u = z;
            return this;
        }

        /* renamed from: f */
        public C6640b m35419f(boolean z) {
            this.f23593d = z;
            return this;
        }

        /* renamed from: g */
        public C6640b m35418g(boolean z) {
            this.f23592c = z;
            return this;
        }

        /* renamed from: h */
        public C6640b m35417h(boolean z) {
            this.f23614y = z;
            return this;
        }

        /* renamed from: i */
        public C6640b m35416i(LinkHandler linkHandler) {
            this.f23604o = linkHandler;
            return this;
        }

        /* renamed from: j */
        public void m35415j() {
            if (!PDFView.this.f23559P) {
                PDFView.this.f23560Q = this;
                return;
            }
            PDFView.this.m35461h0();
            PDFView.this.f23579s.m12642p(this.f23596g);
            PDFView.this.f23579s.m12643o(this.f23597h);
            PDFView.this.f23579s.m12645m(this.f23594e);
            PDFView.this.f23579s.m12644n(this.f23595f);
            PDFView.this.f23579s.m12640r(this.f23598i);
            PDFView.this.f23579s.m12638t(this.f23599j);
            PDFView.this.f23579s.m12637u(this.f23600k);
            PDFView.this.f23579s.m12636v(this.f23601l);
            PDFView.this.f23579s.m12641q(this.f23602m);
            PDFView.this.f23579s.m12639s(this.f23603n);
            PDFView.this.f23579s.m12646l(this.f23604o);
            PDFView.this.setSwipeEnabled(this.f23592c);
            PDFView.this.setNightMode(this.f23588B);
            PDFView.this.m35440s(this.f23593d);
            PDFView.this.setDefaultPage(this.f23605p);
            PDFView.this.setSwipeVertical(!this.f23606q);
            PDFView.this.m35444q(this.f23607r);
            PDFView.this.setScrollHandle(this.f23609t);
            PDFView.this.m35442r(this.f23610u);
            PDFView.this.setSpacing(this.f23611v);
            PDFView.this.setAutoSpacing(this.f23612w);
            PDFView.this.setPageFitPolicy(this.f23613x);
            PDFView.this.setFitEachPage(this.f23614y);
            PDFView.this.setPageSnap(this.f23587A);
            PDFView.this.setPageFling(this.f23615z);
            int[] iArr = this.f23591b;
            if (iArr != null) {
                PDFView.this.m35481V(this.f23590a, this.f23608s, iArr);
            } else {
                PDFView.this.m35482U(this.f23590a, this.f23608s);
            }
        }

        /* renamed from: k */
        public C6640b m35414k(boolean z) {
            this.f23588B = z;
            return this;
        }

        /* renamed from: l */
        public C6640b m35413l(OnDrawListener onDrawListener) {
            this.f23594e = onDrawListener;
            return this;
        }

        /* renamed from: m */
        public C6640b m35412m(OnDrawListener onDrawListener) {
            this.f23595f = onDrawListener;
            return this;
        }

        /* renamed from: n */
        public C6640b m35411n(OnErrorListener onErrorListener) {
            this.f23597h = onErrorListener;
            return this;
        }

        /* renamed from: o */
        public C6640b m35410o(OnLoadCompleteListener onLoadCompleteListener) {
            this.f23596g = onLoadCompleteListener;
            return this;
        }

        /* renamed from: p */
        public C6640b m35409p(OnLongPressListener onLongPressListener) {
            this.f23602m = onLongPressListener;
            return this;
        }

        /* renamed from: q */
        public C6640b m35408q(OnPageChangeListener onPageChangeListener) {
            this.f23598i = onPageChangeListener;
            return this;
        }

        /* renamed from: r */
        public C6640b m35407r(OnPageErrorListener onPageErrorListener) {
            this.f23603n = onPageErrorListener;
            return this;
        }

        /* renamed from: s */
        public C6640b m35406s(OnPageScrollListener onPageScrollListener) {
            this.f23599j = onPageScrollListener;
            return this;
        }

        /* renamed from: t */
        public C6640b m35405t(OnRenderListener onRenderListener) {
            this.f23600k = onRenderListener;
            return this;
        }

        /* renamed from: u */
        public C6640b m35404u(OnTapListener onTapListener) {
            this.f23601l = onTapListener;
            return this;
        }

        /* renamed from: v */
        public C6640b m35403v(FitPolicy fitPolicy) {
            this.f23613x = fitPolicy;
            return this;
        }

        /* renamed from: w */
        public C6640b m35402w(boolean z) {
            this.f23615z = z;
            return this;
        }

        /* renamed from: x */
        public C6640b m35401x(boolean z) {
            this.f23587A = z;
            return this;
        }

        /* renamed from: y */
        public C6640b m35400y(int... iArr) {
            this.f23591b = iArr;
            return this;
        }

        /* renamed from: z */
        public C6640b m35399z(String str) {
            this.f23608s = str;
            return this;
        }

        private C6640b(InterfaceC15295c interfaceC15295c) {
            this.f23591b = null;
            this.f23592c = true;
            this.f23593d = true;
            this.f23604o = new DefaultLinkHandler(PDFView.this);
            this.f23605p = 0;
            this.f23606q = false;
            this.f23607r = false;
            this.f23608s = null;
            this.f23609t = null;
            this.f23610u = true;
            this.f23611v = 0;
            this.f23612w = false;
            this.f23613x = FitPolicy.WIDTH;
            this.f23614y = false;
            this.f23615z = false;
            this.f23587A = false;
            this.f23588B = false;
            this.f23590a = interfaceC15295c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.barteksc.pdfviewer.PDFView$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public enum EnumC6641c {
        NONE,
        START,
        END
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.github.barteksc.pdfviewer.PDFView$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public enum EnumC6642d {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23561a = 1.0f;
        this.f23562b = 1.75f;
        this.f23563c = 3.0f;
        this.f23564d = EnumC6641c.NONE;
        this.f23570j = 0.0f;
        this.f23571k = 0.0f;
        this.f23572l = 1.0f;
        this.f23573m = true;
        this.f23574n = EnumC6642d.DEFAULT;
        this.f23579s = new Callbacks();
        this.f23582v = FitPolicy.WIDTH;
        this.f23583w = false;
        this.f23584x = 0;
        this.f23585y = true;
        this.f23586z = true;
        this.f23544A = true;
        this.f23545B = false;
        this.f23546C = true;
        this.f23549F = false;
        this.f23550G = false;
        this.f23551H = false;
        this.f23552I = false;
        this.f23553J = true;
        this.f23554K = new PaintFlagsDrawFilter(0, 3);
        this.f23555L = 0;
        this.f23556M = false;
        this.f23557N = true;
        this.f23558O = new ArrayList(10);
        this.f23559P = false;
        this.f23576p = new HandlerThread("PDF renderer");
        if (isInEditMode()) {
            return;
        }
        this.f23565e = new CacheManager();
        AnimationManager animationManager = new AnimationManager(this);
        this.f23566f = animationManager;
        this.f23567g = new DragPinchManager(this, animationManager);
        this.f23578r = new PagesLoader(this);
        this.f23580t = new Paint();
        Paint paint = new Paint();
        this.f23581u = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f23547D = new PdfiumCore(context);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m35482U(InterfaceC15295c interfaceC15295c, String str) {
        m35481V(interfaceC15295c, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m35481V(InterfaceC15295c interfaceC15295c, String str, int[] iArr) {
        if (this.f23573m) {
            this.f23573m = false;
            DecodingAsyncTask decodingAsyncTask = new DecodingAsyncTask(interfaceC15295c, str, iArr, this, this.f23547D);
            this.f23575o = decodingAsyncTask;
            decodingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    /* renamed from: o */
    private void m35448o(Canvas canvas, PagePart pagePart) {
        float m35340m;
        float m35445p0;
        RectF m3467c = pagePart.m3467c();
        Bitmap m3466d = pagePart.m3466d();
        if (m3466d.isRecycled()) {
            return;
        }
        SizeF m35339n = this.f23568h.m35339n(pagePart.m3468b());
        if (this.f23585y) {
            m35445p0 = this.f23568h.m35340m(pagePart.m3468b(), this.f23572l);
            m35340m = m35445p0(this.f23568h.m35345h() - m35339n.m19711b()) / 2.0f;
        } else {
            m35340m = this.f23568h.m35340m(pagePart.m3468b(), this.f23572l);
            m35445p0 = m35445p0(this.f23568h.m35347f() - m35339n.m19712a()) / 2.0f;
        }
        canvas.translate(m35340m, m35445p0);
        Rect rect = new Rect(0, 0, m3466d.getWidth(), m3466d.getHeight());
        float m35445p02 = m35445p0(m3467c.left * m35339n.m19711b());
        float m35445p03 = m35445p0(m3467c.top * m35339n.m19712a());
        RectF rectF = new RectF((int) m35445p02, (int) m35445p03, (int) (m35445p02 + m35445p0(m3467c.width() * m35339n.m19711b())), (int) (m35445p03 + m35445p0(m3467c.height() * m35339n.m19712a())));
        float f = this.f23570j + m35340m;
        float f2 = this.f23571k + m35445p0;
        if (rectF.left + f < getWidth() && f + rectF.right > 0.0f && rectF.top + f2 < getHeight() && f2 + rectF.bottom > 0.0f) {
            canvas.drawBitmap(m3466d, rect, rectF, this.f23580t);
            if (C6663b.f23734a) {
                this.f23581u.setColor(pagePart.m3468b() % 2 == 0 ? SupportMenu.CATEGORY_MASK : -16776961);
                canvas.drawRect(rectF, this.f23581u);
            }
            canvas.translate(-m35340m, -m35445p0);
            return;
        }
        canvas.translate(-m35340m, -m35445p0);
    }

    /* renamed from: p */
    private void m35446p(Canvas canvas, int i, OnDrawListener onDrawListener) {
        float f;
        if (onDrawListener != null) {
            float f2 = 0.0f;
            if (this.f23585y) {
                f = this.f23568h.m35340m(i, this.f23572l);
            } else {
                f2 = this.f23568h.m35340m(i, this.f23572l);
                f = 0.0f;
            }
            canvas.translate(f2, f);
            SizeF m35339n = this.f23568h.m35339n(i);
            onDrawListener.m12635a(canvas, m35445p0(m35339n.m19711b()), m35445p0(m35339n.m19712a()), i);
            canvas.translate(-f2, -f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSpacing(boolean z) {
        this.f23556M = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i) {
        this.f23584x = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitEachPage(boolean z) {
        this.f23583w = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.f23582v = fitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(ScrollHandle scrollHandle) {
        this.f23548E = scrollHandle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i) {
        this.f23555L = C6668f.m35294a(getContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z) {
        this.f23585y = z;
    }

    /* renamed from: A */
    public C6640b m35502A(InterfaceC15295c interfaceC15295c) {
        return new C6640b(interfaceC15295c);
    }

    /* renamed from: B */
    public C6640b m35501B(InputStream inputStream) {
        return new C6640b(new InputStreamSource(inputStream));
    }

    /* renamed from: C */
    public C6640b m35500C(Uri uri) {
        return new C6640b(new UriSource(uri));
    }

    /* renamed from: D */
    public List<PdfDocument.Link> m35499D(int i) {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return Collections.emptyList();
        }
        return pdfFile.m35341l(i);
    }

    /* renamed from: E */
    public int m35498E(float f) {
        PdfFile pdfFile = this.f23568h;
        return pdfFile.m35343j(pdfFile.m35348e(this.f23572l) * f, this.f23572l);
    }

    /* renamed from: F */
    public SizeF m35497F(int i) {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return new SizeF(0.0f, 0.0f);
        }
        return pdfFile.m35339n(i);
    }

    /* renamed from: G */
    public boolean m35496G() {
        return this.f23551H;
    }

    /* renamed from: H */
    public boolean m35495H() {
        return this.f23553J;
    }

    /* renamed from: I */
    public boolean m35494I() {
        return this.f23556M;
    }

    /* renamed from: J */
    public boolean m35493J() {
        return this.f23550G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: K */
    public boolean m35492K() {
        return this.f23544A;
    }

    /* renamed from: L */
    public boolean m35491L() {
        return this.f23583w;
    }

    /* renamed from: M */
    public boolean m35490M() {
        return this.f23557N;
    }

    /* renamed from: N */
    public boolean m35489N() {
        return this.f23546C;
    }

    /* renamed from: O */
    public boolean m35488O() {
        return this.f23573m;
    }

    /* renamed from: P */
    public boolean m35487P() {
        return this.f23586z;
    }

    /* renamed from: Q */
    public boolean m35486Q() {
        return this.f23585y;
    }

    /* renamed from: R */
    public boolean m35485R() {
        return this.f23572l != this.f23561a;
    }

    /* renamed from: S */
    public void m35484S(int i) {
        m35483T(i, false);
    }

    /* renamed from: T */
    public void m35483T(int i, boolean z) {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return;
        }
        int m35352a = pdfFile.m35352a(i);
        float f = m35352a == 0 ? 0.0f : -this.f23568h.m35340m(m35352a, this.f23572l);
        if (this.f23585y) {
            if (z) {
                this.f23566f.m35389j(this.f23571k, f);
            } else {
                m35473b0(this.f23570j, f);
            }
        } else if (z) {
            this.f23566f.m35390i(this.f23570j, f);
        } else {
            m35473b0(f, this.f23571k);
        }
        m35451m0(m35352a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: W */
    public void m35480W(PdfFile pdfFile) {
        this.f23574n = EnumC6642d.LOADED;
        this.f23568h = pdfFile;
        if (!this.f23576p.isAlive()) {
            this.f23576p.start();
        }
        RenderingHandler renderingHandler = new RenderingHandler(this.f23576p.getLooper(), this);
        this.f23577q = renderingHandler;
        renderingHandler.m35322e();
        ScrollHandle scrollHandle = this.f23548E;
        if (scrollHandle != null) {
            scrollHandle.setupLayout(this);
            this.f23549F = true;
        }
        this.f23567g.m35366e();
        this.f23579s.m12656b(pdfFile.m35337p());
        m35483T(this.f23584x, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: X */
    public void m35479X(Throwable th) {
        this.f23574n = EnumC6642d.ERROR;
        OnErrorListener m12647k = this.f23579s.m12647k();
        m35461h0();
        invalidate();
        if (m12647k != null) {
            m12647k.onError(th);
        } else {
            Log.e("PDFView", "load pdf error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Y */
    public void m35478Y() {
        float f;
        int width;
        if (this.f23568h.m35337p() == 0) {
            return;
        }
        if (this.f23585y) {
            f = this.f23571k;
            width = getHeight();
        } else {
            f = this.f23570j;
            width = getWidth();
        }
        int m35343j = this.f23568h.m35343j(-(f - (width / 2.0f)), this.f23572l);
        if (m35343j >= 0 && m35343j <= this.f23568h.m35337p() - 1 && m35343j != getCurrentPage()) {
            m35451m0(m35343j);
        } else {
            m35477Z();
        }
    }

    /* renamed from: Z */
    public void m35477Z() {
        RenderingHandler renderingHandler;
        if (this.f23568h == null || (renderingHandler = this.f23577q) == null) {
            return;
        }
        renderingHandler.removeMessages(1);
        this.f23565e.m35377i();
        this.f23578r.m35356f();
        m35459i0();
    }

    /* renamed from: a0 */
    public void m35475a0(float f, float f2) {
        m35473b0(this.f23570j + f, this.f23571k + f2);
    }

    /* renamed from: b0 */
    public void m35473b0(float f, float f2) {
        m35471c0(f, f2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8  */
    /* renamed from: c0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m35471c0(float r6, float r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.m35471c0(float, float, boolean):void");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return true;
        }
        if (this.f23585y) {
            if (i >= 0 || this.f23570j >= 0.0f) {
                return i > 0 && this.f23570j + m35445p0(pdfFile.m35345h()) > ((float) getWidth());
            }
            return true;
        } else if (i >= 0 || this.f23570j >= 0.0f) {
            return i > 0 && this.f23570j + pdfFile.m35348e(this.f23572l) > ((float) getWidth());
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return true;
        }
        if (this.f23585y) {
            if (i >= 0 || this.f23571k >= 0.0f) {
                return i > 0 && this.f23571k + pdfFile.m35348e(this.f23572l) > ((float) getHeight());
            }
            return true;
        } else if (i >= 0 || this.f23571k >= 0.0f) {
            return i > 0 && this.f23571k + m35445p0(pdfFile.m35347f()) > ((float) getHeight());
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        this.f23566f.m35395d();
    }

    /* renamed from: d0 */
    public void m35469d0(PagePart pagePart) {
        if (this.f23574n == EnumC6642d.LOADED) {
            this.f23574n = EnumC6642d.SHOWN;
            this.f23579s.m12651g(this.f23568h.m35337p());
        }
        if (pagePart.m3465e()) {
            this.f23565e.m35383c(pagePart);
        } else {
            this.f23565e.m35384b(pagePart);
        }
        m35459i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e0 */
    public void m35467e0(PageRenderingException pageRenderingException) {
        if (this.f23579s.m12653e(pageRenderingException.getPage(), pageRenderingException.getCause())) {
            return;
        }
        String str = f23540R;
        Log.e(str, "Cannot open page " + pageRenderingException.getPage(), pageRenderingException.getCause());
    }

    /* renamed from: f0 */
    public boolean m35465f0() {
        float f = -this.f23568h.m35340m(this.f23569i, this.f23572l);
        float m35342k = f - this.f23568h.m35342k(this.f23569i, this.f23572l);
        if (m35486Q()) {
            float f2 = this.f23571k;
            return f > f2 && m35342k < f2 - ((float) getHeight());
        }
        float f3 = this.f23570j;
        return f > f3 && m35342k < f3 - ((float) getWidth());
    }

    /* renamed from: g0 */
    public void m35463g0() {
        PdfFile pdfFile;
        int m35436u;
        SnapEdge m35434v;
        if (!this.f23546C || (pdfFile = this.f23568h) == null || pdfFile.m35337p() == 0 || (m35434v = m35434v((m35436u = m35436u(this.f23570j, this.f23571k)))) == SnapEdge.NONE) {
            return;
        }
        float m35449n0 = m35449n0(m35436u, m35434v);
        if (this.f23585y) {
            this.f23566f.m35389j(this.f23571k, -m35449n0);
        } else {
            this.f23566f.m35390i(this.f23570j, -m35449n0);
        }
    }

    public int getCurrentPage() {
        return this.f23569i;
    }

    public float getCurrentXOffset() {
        return this.f23570j;
    }

    public float getCurrentYOffset() {
        return this.f23571k;
    }

    public PdfDocument.Meta getDocumentMeta() {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return null;
        }
        return pdfFile.m35344i();
    }

    public float getMaxZoom() {
        return this.f23563c;
    }

    public float getMidZoom() {
        return this.f23562b;
    }

    public float getMinZoom() {
        return this.f23561a;
    }

    public int getPageCount() {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return 0;
        }
        return pdfFile.m35337p();
    }

    public FitPolicy getPageFitPolicy() {
        return this.f23582v;
    }

    public float getPositionOffset() {
        float f;
        float m35348e;
        int width;
        if (this.f23585y) {
            f = -this.f23571k;
            m35348e = this.f23568h.m35348e(this.f23572l);
            width = getHeight();
        } else {
            f = -this.f23570j;
            m35348e = this.f23568h.m35348e(this.f23572l);
            width = getWidth();
        }
        return MathUtils.m35307c(f / (m35348e - width), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollHandle getScrollHandle() {
        return this.f23548E;
    }

    public int getSpacingPx() {
        return this.f23555L;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        PdfFile pdfFile = this.f23568h;
        if (pdfFile == null) {
            return Collections.emptyList();
        }
        return pdfFile.m35349d();
    }

    public float getZoom() {
        return this.f23572l;
    }

    /* renamed from: h0 */
    public void m35461h0() {
        this.f23560Q = null;
        this.f23566f.m35387l();
        this.f23567g.m35368c();
        RenderingHandler renderingHandler = this.f23577q;
        if (renderingHandler != null) {
            renderingHandler.m35321f();
            this.f23577q.removeMessages(1);
        }
        DecodingAsyncTask decodingAsyncTask = this.f23575o;
        if (decodingAsyncTask != null) {
            decodingAsyncTask.cancel(true);
        }
        this.f23565e.m35376j();
        ScrollHandle scrollHandle = this.f23548E;
        if (scrollHandle != null && this.f23549F) {
            scrollHandle.mo35316h();
        }
        PdfFile pdfFile = this.f23568h;
        if (pdfFile != null) {
            pdfFile.m35351b();
            this.f23568h = null;
        }
        this.f23577q = null;
        this.f23548E = null;
        this.f23549F = false;
        this.f23571k = 0.0f;
        this.f23570j = 0.0f;
        this.f23572l = 1.0f;
        this.f23573m = true;
        this.f23579s = new Callbacks();
        this.f23574n = EnumC6642d.DEFAULT;
    }

    /* renamed from: i0 */
    void m35459i0() {
        invalidate();
    }

    /* renamed from: j0 */
    public void m35457j0() {
        m35435u0(this.f23561a);
    }

    /* renamed from: k0 */
    public void m35455k0() {
        m35433v0(this.f23561a);
    }

    /* renamed from: l0 */
    public void m35453l0(float f, boolean z) {
        if (this.f23585y) {
            m35471c0(this.f23570j, ((-this.f23568h.m35348e(this.f23572l)) + getHeight()) * f, z);
        } else {
            m35471c0(((-this.f23568h.m35348e(this.f23572l)) + getWidth()) * f, this.f23571k, z);
        }
        m35478Y();
    }

    /* renamed from: m */
    public boolean m35452m() {
        return this.f23552I;
    }

    /* renamed from: m0 */
    void m35451m0(int i) {
        if (this.f23573m) {
            return;
        }
        this.f23569i = this.f23568h.m35352a(i);
        m35477Z();
        if (this.f23548E != null && !m35450n()) {
            this.f23548E.setPageNum(this.f23569i + 1);
        }
        this.f23579s.m12654d(this.f23569i, this.f23568h.m35337p());
    }

    /* renamed from: n */
    public boolean m35450n() {
        float m35348e = this.f23568h.m35348e(1.0f);
        return this.f23585y ? m35348e < ((float) getHeight()) : m35348e < ((float) getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n0 */
    public float m35449n0(int i, SnapEdge snapEdge) {
        float f;
        float m35340m = this.f23568h.m35340m(i, this.f23572l);
        float height = this.f23585y ? getHeight() : getWidth();
        float m35342k = this.f23568h.m35342k(i, this.f23572l);
        if (snapEdge == SnapEdge.CENTER) {
            f = m35340m - (height / 2.0f);
            m35342k /= 2.0f;
        } else if (snapEdge != SnapEdge.END) {
            return m35340m;
        } else {
            f = m35340m - height;
        }
        return f + m35342k;
    }

    /* renamed from: o0 */
    public void m35447o0() {
        this.f23566f.m35386m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        m35461h0();
        HandlerThread handlerThread = this.f23576p;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
            this.f23576p = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            return;
        }
        if (this.f23553J) {
            canvas.setDrawFilter(this.f23554K);
        }
        Drawable background = getBackground();
        if (background == null) {
            canvas.drawColor(this.f23545B ? ViewCompat.MEASURED_STATE_MASK : -1);
        } else {
            background.draw(canvas);
        }
        if (!this.f23573m && this.f23574n == EnumC6642d.SHOWN) {
            float f = this.f23570j;
            float f2 = this.f23571k;
            canvas.translate(f, f2);
            for (PagePart pagePart : this.f23565e.m35379g()) {
                m35448o(canvas, pagePart);
            }
            for (PagePart pagePart2 : this.f23565e.m35380f()) {
                m35448o(canvas, pagePart2);
                if (this.f23579s.m12648j() != null && !this.f23558O.contains(Integer.valueOf(pagePart2.m3468b()))) {
                    this.f23558O.add(Integer.valueOf(pagePart2.m3468b()));
                }
            }
            for (Integer num : this.f23558O) {
                m35446p(canvas, num.intValue(), this.f23579s.m12648j());
            }
            this.f23558O.clear();
            m35446p(canvas, this.f23569i, this.f23579s.m12649i());
            canvas.translate(-f, -f2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        float m35348e;
        float m35347f;
        this.f23559P = true;
        C6640b c6640b = this.f23560Q;
        if (c6640b != null) {
            c6640b.m35415j();
        }
        if (isInEditMode() || this.f23574n != EnumC6642d.SHOWN) {
            return;
        }
        float f = (-this.f23570j) + (i3 * 0.5f);
        float f2 = (-this.f23571k) + (i4 * 0.5f);
        if (this.f23585y) {
            m35348e = f / this.f23568h.m35345h();
            m35347f = this.f23568h.m35348e(this.f23572l);
        } else {
            m35348e = f / this.f23568h.m35348e(this.f23572l);
            m35347f = this.f23568h.m35347f();
        }
        float f3 = f2 / m35347f;
        this.f23566f.m35387l();
        this.f23568h.m35328y(new Size(i, i2));
        if (this.f23585y) {
            this.f23570j = ((-m35348e) * this.f23568h.m35345h()) + (i * 0.5f);
            this.f23571k = ((-f3) * this.f23568h.m35348e(this.f23572l)) + (i2 * 0.5f);
        } else {
            this.f23570j = ((-m35348e) * this.f23568h.m35348e(this.f23572l)) + (i * 0.5f);
            this.f23571k = ((-f3) * this.f23568h.m35347f()) + (i2 * 0.5f);
        }
        m35473b0(this.f23570j, this.f23571k);
        m35478Y();
    }

    /* renamed from: p0 */
    public float m35445p0(float f) {
        return f * this.f23572l;
    }

    /* renamed from: q */
    public void m35444q(boolean z) {
        this.f23551H = z;
    }

    /* renamed from: q0 */
    public float m35443q0(float f) {
        return f / this.f23572l;
    }

    /* renamed from: r */
    public void m35442r(boolean z) {
        this.f23553J = z;
    }

    /* renamed from: r0 */
    public void m35441r0(boolean z) {
        this.f23550G = z;
    }

    /* renamed from: s */
    void m35440s(boolean z) {
        this.f23544A = z;
    }

    /* renamed from: s0 */
    public void m35439s0(float f, PointF pointF) {
        m35437t0(this.f23572l * f, pointF);
    }

    public void setMaxZoom(float f) {
        this.f23563c = f;
    }

    public void setMidZoom(float f) {
        this.f23562b = f;
    }

    public void setMinZoom(float f) {
        this.f23561a = f;
    }

    public void setNightMode(boolean z) {
        this.f23545B = z;
        if (z) {
            this.f23580t.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
            return;
        }
        this.f23580t.setColorFilter(null);
    }

    public void setPageFling(boolean z) {
        this.f23557N = z;
    }

    public void setPageSnap(boolean z) {
        this.f23546C = z;
    }

    public void setPositionOffset(float f) {
        m35453l0(f, true);
    }

    public void setSwipeEnabled(boolean z) {
        this.f23586z = z;
    }

    /* renamed from: t */
    public void m35438t(boolean z) {
        this.f23552I = z;
    }

    /* renamed from: t0 */
    public void m35437t0(float f, PointF pointF) {
        float f2 = f / this.f23572l;
        m35435u0(f);
        float f3 = pointF.x;
        float f4 = pointF.y;
        m35473b0((this.f23570j * f2) + (f3 - (f3 * f2)), (this.f23571k * f2) + (f4 - (f2 * f4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public int m35436u(float f, float f2) {
        boolean z = this.f23585y;
        if (z) {
            f = f2;
        }
        float height = z ? getHeight() : getWidth();
        if (f > -1.0f) {
            return 0;
        }
        if (f < (-this.f23568h.m35348e(this.f23572l)) + height + 1.0f) {
            return this.f23568h.m35337p() - 1;
        }
        return this.f23568h.m35343j(-(f - (height / 2.0f)), this.f23572l);
    }

    /* renamed from: u0 */
    public void m35435u0(float f) {
        this.f23572l = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public SnapEdge m35434v(int i) {
        if (this.f23546C && i >= 0) {
            float f = this.f23585y ? this.f23571k : this.f23570j;
            float f2 = -this.f23568h.m35340m(i, this.f23572l);
            int height = this.f23585y ? getHeight() : getWidth();
            float m35342k = this.f23568h.m35342k(i, this.f23572l);
            float f3 = height;
            if (f3 >= m35342k) {
                return SnapEdge.CENTER;
            }
            if (f >= f2) {
                return SnapEdge.START;
            }
            if (f2 - m35342k > f - f3) {
                return SnapEdge.END;
            }
            return SnapEdge.NONE;
        }
        return SnapEdge.NONE;
    }

    /* renamed from: v0 */
    public void m35433v0(float f) {
        this.f23566f.m35388k(getWidth() / 2, getHeight() / 2, this.f23572l, f);
    }

    /* renamed from: w */
    public void m35432w(int i) {
        if (this.f23574n != EnumC6642d.SHOWN) {
            Log.e(f23540R, "Cannot fit, document not rendered yet");
            return;
        }
        m35435u0(getWidth() / this.f23568h.m35339n(i).m19711b());
        m35484S(i);
    }

    /* renamed from: w0 */
    public void m35431w0(float f, float f2, float f3) {
        this.f23566f.m35388k(f, f2, this.f23572l, f3);
    }

    /* renamed from: x */
    public C6640b m35430x(String str) {
        return new C6640b(new AssetSource(str));
    }

    /* renamed from: y */
    public C6640b m35429y(byte[] bArr) {
        return new C6640b(new C15294b(bArr));
    }

    /* renamed from: z */
    public C6640b m35428z(File file) {
        return new C6640b(new FileSource(file));
    }
}
