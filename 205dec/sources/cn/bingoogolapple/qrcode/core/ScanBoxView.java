package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ScanBoxView extends View {
    private int A;
    private boolean B;
    private int B0;
    private String C;
    private boolean C0;
    private String D;
    private boolean D0;
    private String E;
    private boolean E0;
    private int F;
    private QRCodeView F0;
    private int G;
    private boolean H;
    private int I;
    private boolean J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private boolean f1569L;
    private boolean M;
    private boolean N;
    private Drawable O;
    private Bitmap P;
    private float Q;
    private float R;
    private Bitmap S;
    private Bitmap T;
    private Bitmap U;
    private Bitmap V;
    private float W;

    /* renamed from: a  reason: collision with root package name */
    private int f1570a;

    /* renamed from: b  reason: collision with root package name */
    private int f1571b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f1572c;

    /* renamed from: d  reason: collision with root package name */
    private float f1573d;

    /* renamed from: e  reason: collision with root package name */
    private float f1574e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f1575f;

    /* renamed from: g  reason: collision with root package name */
    private TextPaint f1576g;

    /* renamed from: h  reason: collision with root package name */
    private int f1577h;

    /* renamed from: i  reason: collision with root package name */
    private int f1578i;

    /* renamed from: j  reason: collision with root package name */
    private int f1579j;

    /* renamed from: k  reason: collision with root package name */
    private int f1580k;

    /* renamed from: l  reason: collision with root package name */
    private int f1581l;

    /* renamed from: m  reason: collision with root package name */
    private int f1582m;

    /* renamed from: n  reason: collision with root package name */
    private int f1583n;

    /* renamed from: o  reason: collision with root package name */
    private int f1584o;

    /* renamed from: p  reason: collision with root package name */
    private int f1585p;

    /* renamed from: p0  reason: collision with root package name */
    private StaticLayout f1586p0;

    /* renamed from: q  reason: collision with root package name */
    private int f1587q;

    /* renamed from: r  reason: collision with root package name */
    private int f1588r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1589s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f1590t;

    /* renamed from: u  reason: collision with root package name */
    private Bitmap f1591u;

    /* renamed from: v  reason: collision with root package name */
    private int f1592v;

    /* renamed from: w  reason: collision with root package name */
    private int f1593w;

    /* renamed from: x  reason: collision with root package name */
    private int f1594x;

    /* renamed from: y  reason: collision with root package name */
    private float f1595y;

    /* renamed from: z  reason: collision with root package name */
    private int f1596z;

    public ScanBoxView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f1575f = paint;
        paint.setAntiAlias(true);
        this.f1577h = Color.parseColor("#33FFFFFF");
        this.f1578i = -1;
        this.f1579j = a.g(context, 20.0f);
        this.f1580k = a.g(context, 3.0f);
        this.f1585p = a.g(context, 1.0f);
        this.f1587q = -1;
        this.f1584o = a.g(context, 90.0f);
        this.f1581l = a.g(context, 200.0f);
        this.f1583n = a.g(context, 140.0f);
        this.f1588r = 0;
        this.f1589s = false;
        this.f1590t = null;
        this.f1591u = null;
        this.f1592v = a.g(context, 1.0f);
        this.f1593w = -1;
        this.f1594x = 1000;
        this.f1595y = -1.0f;
        this.f1596z = 1;
        this.A = 0;
        this.B = false;
        this.f1570a = a.g(context, 2.0f);
        this.E = null;
        this.F = a.q(context, 14.0f);
        this.G = -1;
        this.H = false;
        this.I = a.g(context, 20.0f);
        this.J = false;
        this.K = Color.parseColor("#22000000");
        this.f1569L = false;
        this.M = false;
        this.N = false;
        TextPaint textPaint = new TextPaint();
        this.f1576g = textPaint;
        textPaint.setAntiAlias(true);
        this.B0 = a.g(context, 4.0f);
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
    }

    private void a() {
        Drawable drawable = this.O;
        if (drawable != null) {
            this.U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.U == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_grid_scan_line);
            this.U = decodeResource;
            this.U = a.n(decodeResource, this.f1587q);
        }
        Bitmap a4 = a.a(this.U, 90);
        this.V = a4;
        Bitmap a5 = a.a(a4, 90);
        this.V = a5;
        this.V = a.a(a5, 90);
        Drawable drawable2 = this.f1590t;
        if (drawable2 != null) {
            this.S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.S == null) {
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_scan_line);
            this.S = decodeResource2;
            this.S = a.n(decodeResource2, this.f1587q);
        }
        this.T = a.a(this.S, 90);
        this.f1584o += this.A;
        this.W = (this.f1580k * 1.0f) / 2.0f;
        this.f1576g.setTextSize(this.F);
        this.f1576g.setColor(this.G);
        setIsBarcode(this.B);
    }

    private void b() {
        int width = (getWidth() - this.f1581l) / 2;
        int i4 = this.f1584o;
        Rect rect = new Rect(width, i4, this.f1581l + width, this.f1582m + i4);
        this.f1572c = rect;
        if (this.B) {
            float f4 = rect.left + this.W + 0.5f;
            this.f1574e = f4;
            this.R = f4;
        } else {
            float f5 = rect.top + this.W + 0.5f;
            this.f1573d = f5;
            this.Q = f5;
        }
        if (this.F0 == null || !l()) {
            return;
        }
        this.F0.r(new Rect(this.f1572c));
    }

    private void c(Canvas canvas) {
        if (this.f1592v > 0) {
            this.f1575f.setStyle(Paint.Style.STROKE);
            this.f1575f.setColor(this.f1593w);
            this.f1575f.setStrokeWidth(this.f1592v);
            canvas.drawRect(this.f1572c, this.f1575f);
        }
    }

    private void d(Canvas canvas) {
        if (this.W > 0.0f) {
            this.f1575f.setStyle(Paint.Style.STROKE);
            this.f1575f.setColor(this.f1578i);
            this.f1575f.setStrokeWidth(this.f1580k);
            int i4 = this.f1596z;
            if (i4 == 1) {
                Rect rect = this.f1572c;
                int i5 = rect.left;
                float f4 = this.W;
                int i6 = rect.top;
                canvas.drawLine(i5 - f4, i6, (i5 - f4) + this.f1579j, i6, this.f1575f);
                Rect rect2 = this.f1572c;
                int i7 = rect2.left;
                int i8 = rect2.top;
                float f5 = this.W;
                canvas.drawLine(i7, i8 - f5, i7, (i8 - f5) + this.f1579j, this.f1575f);
                Rect rect3 = this.f1572c;
                int i9 = rect3.right;
                float f6 = this.W;
                int i10 = rect3.top;
                canvas.drawLine(i9 + f6, i10, (i9 + f6) - this.f1579j, i10, this.f1575f);
                Rect rect4 = this.f1572c;
                int i11 = rect4.right;
                int i12 = rect4.top;
                float f7 = this.W;
                canvas.drawLine(i11, i12 - f7, i11, (i12 - f7) + this.f1579j, this.f1575f);
                Rect rect5 = this.f1572c;
                int i13 = rect5.left;
                float f8 = this.W;
                int i14 = rect5.bottom;
                canvas.drawLine(i13 - f8, i14, (i13 - f8) + this.f1579j, i14, this.f1575f);
                Rect rect6 = this.f1572c;
                int i15 = rect6.left;
                int i16 = rect6.bottom;
                float f9 = this.W;
                canvas.drawLine(i15, i16 + f9, i15, (i16 + f9) - this.f1579j, this.f1575f);
                Rect rect7 = this.f1572c;
                int i17 = rect7.right;
                float f10 = this.W;
                int i18 = rect7.bottom;
                canvas.drawLine(i17 + f10, i18, (i17 + f10) - this.f1579j, i18, this.f1575f);
                Rect rect8 = this.f1572c;
                int i19 = rect8.right;
                int i20 = rect8.bottom;
                float f11 = this.W;
                canvas.drawLine(i19, i20 + f11, i19, (i20 + f11) - this.f1579j, this.f1575f);
            } else if (i4 == 2) {
                Rect rect9 = this.f1572c;
                int i21 = rect9.left;
                int i22 = rect9.top;
                float f12 = this.W;
                canvas.drawLine(i21, i22 + f12, i21 + this.f1579j, i22 + f12, this.f1575f);
                Rect rect10 = this.f1572c;
                int i23 = rect10.left;
                float f13 = this.W;
                int i24 = rect10.top;
                canvas.drawLine(i23 + f13, i24, i23 + f13, i24 + this.f1579j, this.f1575f);
                Rect rect11 = this.f1572c;
                int i25 = rect11.right;
                int i26 = rect11.top;
                float f14 = this.W;
                canvas.drawLine(i25, i26 + f14, i25 - this.f1579j, i26 + f14, this.f1575f);
                Rect rect12 = this.f1572c;
                int i27 = rect12.right;
                float f15 = this.W;
                int i28 = rect12.top;
                canvas.drawLine(i27 - f15, i28, i27 - f15, i28 + this.f1579j, this.f1575f);
                Rect rect13 = this.f1572c;
                int i29 = rect13.left;
                int i30 = rect13.bottom;
                float f16 = this.W;
                canvas.drawLine(i29, i30 - f16, i29 + this.f1579j, i30 - f16, this.f1575f);
                Rect rect14 = this.f1572c;
                int i31 = rect14.left;
                float f17 = this.W;
                int i32 = rect14.bottom;
                canvas.drawLine(i31 + f17, i32, i31 + f17, i32 - this.f1579j, this.f1575f);
                Rect rect15 = this.f1572c;
                int i33 = rect15.right;
                int i34 = rect15.bottom;
                float f18 = this.W;
                canvas.drawLine(i33, i34 - f18, i33 - this.f1579j, i34 - f18, this.f1575f);
                Rect rect16 = this.f1572c;
                int i35 = rect16.right;
                float f19 = this.W;
                int i36 = rect16.bottom;
                canvas.drawLine(i35 - f19, i36, i35 - f19, i36 - this.f1579j, this.f1575f);
            }
        }
    }

    private void e(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f1577h != 0) {
            this.f1575f.setStyle(Paint.Style.FILL);
            this.f1575f.setColor(this.f1577h);
            float f4 = width;
            canvas.drawRect(0.0f, 0.0f, f4, this.f1572c.top, this.f1575f);
            Rect rect = this.f1572c;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f1575f);
            Rect rect2 = this.f1572c;
            canvas.drawRect(rect2.right + 1, rect2.top, f4, rect2.bottom + 1, this.f1575f);
            canvas.drawRect(0.0f, this.f1572c.bottom + 1, f4, height, this.f1575f);
        }
    }

    private void f(Canvas canvas) {
        if (this.B) {
            if (this.P != null) {
                Rect rect = this.f1572c;
                float f4 = this.W;
                int i4 = this.f1588r;
                RectF rectF = new RectF(rect.left + f4 + 0.5f, rect.top + f4 + i4, this.R, (rect.bottom - f4) - i4);
                Rect rect2 = new Rect((int) (this.P.getWidth() - rectF.width()), 0, this.P.getWidth(), this.P.getHeight());
                if (rect2.left < 0) {
                    rect2.left = 0;
                    rectF.left = rectF.right - rect2.width();
                }
                canvas.drawBitmap(this.P, rect2, rectF, this.f1575f);
            } else if (this.f1591u != null) {
                float f5 = this.f1574e;
                canvas.drawBitmap(this.f1591u, (Rect) null, new RectF(f5, this.f1572c.top + this.W + this.f1588r, this.f1591u.getWidth() + f5, (this.f1572c.bottom - this.W) - this.f1588r), this.f1575f);
            } else {
                this.f1575f.setStyle(Paint.Style.FILL);
                this.f1575f.setColor(this.f1587q);
                float f6 = this.f1574e;
                Rect rect3 = this.f1572c;
                float f7 = this.W;
                int i5 = this.f1588r;
                canvas.drawRect(f6, rect3.top + f7 + i5, this.f1585p + f6, (rect3.bottom - f7) - i5, this.f1575f);
            }
        } else if (this.P != null) {
            Rect rect4 = this.f1572c;
            float f8 = this.W;
            int i6 = this.f1588r;
            RectF rectF2 = new RectF(rect4.left + f8 + i6, rect4.top + f8 + 0.5f, (rect4.right - f8) - i6, this.Q);
            Rect rect5 = new Rect(0, (int) (this.P.getHeight() - rectF2.height()), this.P.getWidth(), this.P.getHeight());
            if (rect5.top < 0) {
                rect5.top = 0;
                rectF2.top = rectF2.bottom - rect5.height();
            }
            canvas.drawBitmap(this.P, rect5, rectF2, this.f1575f);
        } else if (this.f1591u != null) {
            Rect rect6 = this.f1572c;
            float f9 = this.W;
            int i7 = this.f1588r;
            float f10 = rect6.left + f9 + i7;
            float f11 = this.f1573d;
            canvas.drawBitmap(this.f1591u, (Rect) null, new RectF(f10, f11, (rect6.right - f9) - i7, this.f1591u.getHeight() + f11), this.f1575f);
        } else {
            this.f1575f.setStyle(Paint.Style.FILL);
            this.f1575f.setColor(this.f1587q);
            Rect rect7 = this.f1572c;
            float f12 = this.W;
            int i8 = this.f1588r;
            float f13 = this.f1573d;
            canvas.drawRect(rect7.left + f12 + i8, f13, (rect7.right - f12) - i8, f13 + this.f1585p, this.f1575f);
        }
    }

    private void g(Canvas canvas) {
        Rect rect;
        Rect rect2;
        if (TextUtils.isEmpty(this.E) || this.f1586p0 == null) {
            return;
        }
        if (this.H) {
            if (this.f1569L) {
                this.f1575f.setColor(this.K);
                this.f1575f.setStyle(Paint.Style.FILL);
                if (this.J) {
                    Rect rect3 = new Rect();
                    TextPaint textPaint = this.f1576g;
                    String str = this.E;
                    textPaint.getTextBounds(str, 0, str.length(), rect3);
                    float width = ((canvas.getWidth() - rect3.width()) / 2) - this.B0;
                    RectF rectF = new RectF(width, (this.f1572c.bottom + this.I) - this.B0, rect3.width() + width + (this.B0 * 2), this.f1572c.bottom + this.I + this.f1586p0.getHeight() + this.B0);
                    int i4 = this.B0;
                    canvas.drawRoundRect(rectF, i4, i4, this.f1575f);
                } else {
                    int i5 = this.f1572c.bottom;
                    int i6 = this.I;
                    RectF rectF2 = new RectF(rect2.left, (i5 + i6) - this.B0, rect2.right, i5 + i6 + this.f1586p0.getHeight() + this.B0);
                    int i7 = this.B0;
                    canvas.drawRoundRect(rectF2, i7, i7, this.f1575f);
                }
            }
            canvas.save();
            if (this.J) {
                canvas.translate(0.0f, this.f1572c.bottom + this.I);
            } else {
                Rect rect4 = this.f1572c;
                canvas.translate(rect4.left + this.B0, rect4.bottom + this.I);
            }
            this.f1586p0.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.f1569L) {
            this.f1575f.setColor(this.K);
            this.f1575f.setStyle(Paint.Style.FILL);
            if (this.J) {
                Rect rect5 = new Rect();
                TextPaint textPaint2 = this.f1576g;
                String str2 = this.E;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect5);
                float width2 = ((canvas.getWidth() - rect5.width()) / 2) - this.B0;
                int i8 = this.B0;
                RectF rectF3 = new RectF(width2, ((this.f1572c.top - this.I) - this.f1586p0.getHeight()) - this.B0, rect5.width() + width2 + (i8 * 2), (this.f1572c.top - this.I) + i8);
                int i9 = this.B0;
                canvas.drawRoundRect(rectF3, i9, i9, this.f1575f);
            } else {
                int height = (this.f1572c.top - this.I) - this.f1586p0.getHeight();
                int i10 = this.B0;
                Rect rect6 = this.f1572c;
                RectF rectF4 = new RectF(rect.left, height - i10, rect6.right, (rect6.top - this.I) + i10);
                int i11 = this.B0;
                canvas.drawRoundRect(rectF4, i11, i11, this.f1575f);
            }
        }
        canvas.save();
        if (this.J) {
            canvas.translate(0.0f, (this.f1572c.top - this.I) - this.f1586p0.getHeight());
        } else {
            Rect rect7 = this.f1572c;
            canvas.translate(rect7.left + this.B0, (rect7.top - this.I) - this.f1586p0.getHeight());
        }
        this.f1586p0.draw(canvas);
        canvas.restore();
    }

    private void j(int i4, TypedArray typedArray) {
        if (i4 == R.styleable.QRCodeView_qrcv_topOffset) {
            this.f1584o = typedArray.getDimensionPixelSize(i4, this.f1584o);
        } else if (i4 == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.f1580k = typedArray.getDimensionPixelSize(i4, this.f1580k);
        } else if (i4 == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.f1579j = typedArray.getDimensionPixelSize(i4, this.f1579j);
        } else if (i4 == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.f1585p = typedArray.getDimensionPixelSize(i4, this.f1585p);
        } else if (i4 == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.f1581l = typedArray.getDimensionPixelSize(i4, this.f1581l);
        } else if (i4 == R.styleable.QRCodeView_qrcv_maskColor) {
            this.f1577h = typedArray.getColor(i4, this.f1577h);
        } else if (i4 == R.styleable.QRCodeView_qrcv_cornerColor) {
            this.f1578i = typedArray.getColor(i4, this.f1578i);
        } else if (i4 == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.f1587q = typedArray.getColor(i4, this.f1587q);
        } else if (i4 == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.f1588r = typedArray.getDimensionPixelSize(i4, this.f1588r);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.f1589s = typedArray.getBoolean(i4, this.f1589s);
        } else if (i4 == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.f1590t = typedArray.getDrawable(i4);
        } else if (i4 == R.styleable.QRCodeView_qrcv_borderSize) {
            this.f1592v = typedArray.getDimensionPixelSize(i4, this.f1592v);
        } else if (i4 == R.styleable.QRCodeView_qrcv_borderColor) {
            this.f1593w = typedArray.getColor(i4, this.f1593w);
        } else if (i4 == R.styleable.QRCodeView_qrcv_animTime) {
            this.f1594x = typedArray.getInteger(i4, this.f1594x);
        } else if (i4 == R.styleable.QRCodeView_qrcv_verticalBias) {
            this.f1595y = typedArray.getFloat(i4, this.f1595y);
        } else if (i4 == R.styleable.QRCodeView_qrcv_cornerDisplayType) {
            this.f1596z = typedArray.getInteger(i4, this.f1596z);
        } else if (i4 == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.A = typedArray.getDimensionPixelSize(i4, this.A);
        } else if (i4 == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.f1583n = typedArray.getDimensionPixelSize(i4, this.f1583n);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.B = typedArray.getBoolean(i4, this.B);
        } else if (i4 == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.D = typedArray.getString(i4);
        } else if (i4 == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.C = typedArray.getString(i4);
        } else if (i4 == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.F = typedArray.getDimensionPixelSize(i4, this.F);
        } else if (i4 == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.G = typedArray.getColor(i4, this.G);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.H = typedArray.getBoolean(i4, this.H);
        } else if (i4 == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.I = typedArray.getDimensionPixelSize(i4, this.I);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.J = typedArray.getBoolean(i4, this.J);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.f1569L = typedArray.getBoolean(i4, this.f1569L);
        } else if (i4 == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.K = typedArray.getColor(i4, this.K);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.M = typedArray.getBoolean(i4, this.M);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.N = typedArray.getBoolean(i4, this.N);
        } else if (i4 == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.O = typedArray.getDrawable(i4);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.C0 = typedArray.getBoolean(i4, this.C0);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isShowLocationPoint) {
            this.D0 = typedArray.getBoolean(i4, this.D0);
        } else if (i4 == R.styleable.QRCodeView_qrcv_isAutoZoom) {
            this.E0 = typedArray.getBoolean(i4, this.E0);
        }
    }

    private void t() {
        if (this.B) {
            if (this.P == null) {
                this.f1574e += this.f1570a;
                int i4 = this.f1585p;
                Bitmap bitmap = this.f1591u;
                if (bitmap != null) {
                    i4 = bitmap.getWidth();
                }
                if (this.M) {
                    float f4 = this.f1574e;
                    Rect rect = this.f1572c;
                    float f5 = this.W;
                    if (i4 + f4 > rect.right - f5 || f4 < rect.left + f5) {
                        this.f1570a = -this.f1570a;
                    }
                } else {
                    float f6 = this.f1574e + i4;
                    Rect rect2 = this.f1572c;
                    float f7 = this.W;
                    if (f6 > rect2.right - f7) {
                        this.f1574e = rect2.left + f7 + 0.5f;
                    }
                }
            } else {
                float f8 = this.R + this.f1570a;
                this.R = f8;
                Rect rect3 = this.f1572c;
                float f9 = this.W;
                if (f8 > rect3.right - f9) {
                    this.R = rect3.left + f9 + 0.5f;
                }
            }
        } else if (this.P == null) {
            this.f1573d += this.f1570a;
            int i5 = this.f1585p;
            Bitmap bitmap2 = this.f1591u;
            if (bitmap2 != null) {
                i5 = bitmap2.getHeight();
            }
            if (this.M) {
                float f10 = this.f1573d;
                Rect rect4 = this.f1572c;
                float f11 = this.W;
                if (i5 + f10 > rect4.bottom - f11 || f10 < rect4.top + f11) {
                    this.f1570a = -this.f1570a;
                }
            } else {
                float f12 = this.f1573d + i5;
                Rect rect5 = this.f1572c;
                float f13 = this.W;
                if (f12 > rect5.bottom - f13) {
                    this.f1573d = rect5.top + f13 + 0.5f;
                }
            }
        } else {
            float f14 = this.Q + this.f1570a;
            this.Q = f14;
            Rect rect6 = this.f1572c;
            float f15 = this.W;
            if (f14 > rect6.bottom - f15) {
                this.Q = rect6.top + f15 + 0.5f;
            }
        }
        long j4 = this.f1571b;
        Rect rect7 = this.f1572c;
        postInvalidateDelayed(j4, rect7.left, rect7.top, rect7.right, rect7.bottom);
    }

    private void u() {
        if (this.O == null && !this.N) {
            if (this.f1590t != null || this.f1589s) {
                if (this.B) {
                    this.f1591u = this.T;
                } else {
                    this.f1591u = this.S;
                }
            }
        } else if (this.B) {
            this.P = this.V;
        } else {
            this.P = this.U;
        }
        if (this.B) {
            this.E = this.D;
            this.f1582m = this.f1583n;
            this.f1571b = (int) (((this.f1594x * 1.0f) * this.f1570a) / this.f1581l);
        } else {
            this.E = this.C;
            int i4 = this.f1581l;
            this.f1582m = i4;
            this.f1571b = (int) (((this.f1594x * 1.0f) * this.f1570a) / i4);
        }
        if (!TextUtils.isEmpty(this.E)) {
            if (this.J) {
                this.f1586p0 = new StaticLayout(this.E, this.f1576g, a.j(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.f1586p0 = new StaticLayout(this.E, this.f1576g, this.f1581l - (this.B0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.f1595y != -1.0f) {
            int k4 = a.j(getContext()).y - a.k(getContext());
            int i5 = this.A;
            if (i5 == 0) {
                this.f1584o = (int) ((k4 * this.f1595y) - (this.f1582m / 2));
            } else {
                this.f1584o = i5 + ((int) (((k4 - i5) * this.f1595y) - (this.f1582m / 2)));
            }
        }
        b();
        postInvalidate();
    }

    public int getAnimTime() {
        return this.f1594x;
    }

    public String getBarCodeTipText() {
        return this.D;
    }

    public int getBarcodeRectHeight() {
        return this.f1583n;
    }

    public int getBorderColor() {
        return this.f1593w;
    }

    public int getBorderSize() {
        return this.f1592v;
    }

    public int getCornerColor() {
        return this.f1578i;
    }

    public int getCornerLength() {
        return this.f1579j;
    }

    public int getCornerSize() {
        return this.f1580k;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f1590t;
    }

    public float getHalfCornerSize() {
        return this.W;
    }

    public boolean getIsBarcode() {
        return this.B;
    }

    public int getMaskColor() {
        return this.f1577h;
    }

    public String getQRCodeTipText() {
        return this.C;
    }

    public int getRectHeight() {
        return this.f1582m;
    }

    public int getRectWidth() {
        return this.f1581l;
    }

    public Bitmap getScanLineBitmap() {
        return this.f1591u;
    }

    public int getScanLineColor() {
        return this.f1587q;
    }

    public int getScanLineMargin() {
        return this.f1588r;
    }

    public int getScanLineSize() {
        return this.f1585p;
    }

    public int getTipBackgroundColor() {
        return this.K;
    }

    public int getTipBackgroundRadius() {
        return this.B0;
    }

    public String getTipText() {
        return this.E;
    }

    public int getTipTextColor() {
        return this.G;
    }

    public int getTipTextMargin() {
        return this.I;
    }

    public int getTipTextSize() {
        return this.F;
    }

    public StaticLayout getTipTextSl() {
        return this.f1586p0;
    }

    public int getToolbarHeight() {
        return this.A;
    }

    public int getTopOffset() {
        return this.f1584o;
    }

    public float getVerticalBias() {
        return this.f1595y;
    }

    public Rect h(int i4) {
        if (this.C0 && getVisibility() == 0) {
            Rect rect = new Rect(this.f1572c);
            float measuredHeight = (i4 * 1.0f) / getMeasuredHeight();
            float exactCenterX = rect.exactCenterX() * measuredHeight;
            float exactCenterY = rect.exactCenterY() * measuredHeight;
            float width = (rect.width() / 2.0f) * measuredHeight;
            float height = (rect.height() / 2.0f) * measuredHeight;
            rect.left = (int) (exactCenterX - width);
            rect.right = (int) (exactCenterX + width);
            rect.top = (int) (exactCenterY - height);
            rect.bottom = (int) (exactCenterY + height);
            return rect;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(QRCodeView qRCodeView, AttributeSet attributeSet) {
        this.F0 = qRCodeView;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            j(obtainStyledAttributes.getIndex(i4), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        a();
    }

    public boolean k() {
        return this.E0;
    }

    public boolean l() {
        return this.C0;
    }

    public boolean m() {
        return this.M;
    }

    public boolean n() {
        return this.N;
    }

    public boolean o() {
        return this.f1589s;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1572c == null) {
            return;
        }
        e(canvas);
        c(canvas);
        d(canvas);
        f(canvas);
        g(canvas);
        t();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        b();
    }

    public boolean p() {
        return this.D0;
    }

    public boolean q() {
        return this.f1569L;
    }

    public boolean r() {
        return this.J;
    }

    public boolean s() {
        return this.H;
    }

    public void setAnimTime(int i4) {
        this.f1594x = i4;
        u();
    }

    public void setAutoZoom(boolean z3) {
        this.E0 = z3;
    }

    public void setBarCodeTipText(String str) {
        this.D = str;
        u();
    }

    public void setBarcodeRectHeight(int i4) {
        this.f1583n = i4;
        u();
    }

    public void setBorderColor(int i4) {
        this.f1593w = i4;
        u();
    }

    public void setBorderSize(int i4) {
        this.f1592v = i4;
        u();
    }

    public void setCornerColor(int i4) {
        this.f1578i = i4;
        u();
    }

    public void setCornerLength(int i4) {
        this.f1579j = i4;
        u();
    }

    public void setCornerSize(int i4) {
        this.f1580k = i4;
        u();
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f1590t = drawable;
        u();
    }

    public void setHalfCornerSize(float f4) {
        this.W = f4;
        u();
    }

    public void setIsBarcode(boolean z3) {
        this.B = z3;
        u();
    }

    public void setMaskColor(int i4) {
        this.f1577h = i4;
        u();
    }

    public void setOnlyDecodeScanBoxArea(boolean z3) {
        this.C0 = z3;
        b();
    }

    public void setQRCodeTipText(String str) {
        this.C = str;
        u();
    }

    public void setRectHeight(int i4) {
        this.f1582m = i4;
        u();
    }

    public void setRectWidth(int i4) {
        this.f1581l = i4;
        u();
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f1591u = bitmap;
        u();
    }

    public void setScanLineColor(int i4) {
        this.f1587q = i4;
        u();
    }

    public void setScanLineMargin(int i4) {
        this.f1588r = i4;
        u();
    }

    public void setScanLineReverse(boolean z3) {
        this.M = z3;
        u();
    }

    public void setScanLineSize(int i4) {
        this.f1585p = i4;
        u();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z3) {
        this.N = z3;
        u();
    }

    public void setShowDefaultScanLineDrawable(boolean z3) {
        this.f1589s = z3;
        u();
    }

    public void setShowLocationPoint(boolean z3) {
        this.D0 = z3;
    }

    public void setShowTipBackground(boolean z3) {
        this.f1569L = z3;
        u();
    }

    public void setShowTipTextAsSingleLine(boolean z3) {
        this.J = z3;
        u();
    }

    public void setTipBackgroundColor(int i4) {
        this.K = i4;
        u();
    }

    public void setTipBackgroundRadius(int i4) {
        this.B0 = i4;
        u();
    }

    public void setTipText(String str) {
        if (this.B) {
            this.D = str;
        } else {
            this.C = str;
        }
        u();
    }

    public void setTipTextBelowRect(boolean z3) {
        this.H = z3;
        u();
    }

    public void setTipTextColor(int i4) {
        this.G = i4;
        this.f1576g.setColor(i4);
        u();
    }

    public void setTipTextMargin(int i4) {
        this.I = i4;
        u();
    }

    public void setTipTextSize(int i4) {
        this.F = i4;
        this.f1576g.setTextSize(i4);
        u();
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f1586p0 = staticLayout;
        u();
    }

    public void setToolbarHeight(int i4) {
        this.A = i4;
        u();
    }

    public void setTopOffset(int i4) {
        this.f1584o = i4;
        u();
    }

    public void setVerticalBias(float f4) {
        this.f1595y = f4;
        u();
    }
}
