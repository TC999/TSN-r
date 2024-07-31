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

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ScanBoxView extends View {

    /* renamed from: A */
    private int f1555A;

    /* renamed from: A0 */
    private int f1556A0;

    /* renamed from: B */
    private boolean f1557B;

    /* renamed from: B0 */
    private boolean f1558B0;

    /* renamed from: C */
    private String f1559C;

    /* renamed from: C0 */
    private boolean f1560C0;

    /* renamed from: D */
    private String f1561D;

    /* renamed from: D0 */
    private boolean f1562D0;

    /* renamed from: E */
    private String f1563E;

    /* renamed from: E0 */
    private QRCodeView f1564E0;

    /* renamed from: F */
    private int f1565F;

    /* renamed from: G */
    private int f1566G;

    /* renamed from: H */
    private boolean f1567H;

    /* renamed from: I */
    private int f1568I;

    /* renamed from: J */
    private boolean f1569J;

    /* renamed from: K */
    private int f1570K;

    /* renamed from: L */
    private boolean f1571L;

    /* renamed from: M */
    private boolean f1572M;

    /* renamed from: N */
    private boolean f1573N;

    /* renamed from: O */
    private Drawable f1574O;

    /* renamed from: P */
    private Bitmap f1575P;

    /* renamed from: Q */
    private float f1576Q;

    /* renamed from: R */
    private float f1577R;

    /* renamed from: S */
    private Bitmap f1578S;

    /* renamed from: T */
    private Bitmap f1579T;

    /* renamed from: U */
    private Bitmap f1580U;

    /* renamed from: V */
    private Bitmap f1581V;

    /* renamed from: W */
    private float f1582W;

    /* renamed from: a */
    private int f1583a;

    /* renamed from: b */
    private int f1584b;

    /* renamed from: c */
    private Rect f1585c;

    /* renamed from: d */
    private float f1586d;

    /* renamed from: e */
    private float f1587e;

    /* renamed from: f */
    private Paint f1588f;

    /* renamed from: g */
    private TextPaint f1589g;

    /* renamed from: h */
    private int f1590h;

    /* renamed from: i */
    private int f1591i;

    /* renamed from: j */
    private int f1592j;

    /* renamed from: k */
    private int f1593k;

    /* renamed from: l */
    private int f1594l;

    /* renamed from: m */
    private int f1595m;

    /* renamed from: n */
    private int f1596n;

    /* renamed from: o */
    private int f1597o;

    /* renamed from: p */
    private int f1598p;

    /* renamed from: p0 */
    private StaticLayout f1599p0;

    /* renamed from: q */
    private int f1600q;

    /* renamed from: r */
    private int f1601r;

    /* renamed from: s */
    private boolean f1602s;

    /* renamed from: t */
    private Drawable f1603t;

    /* renamed from: u */
    private Bitmap f1604u;

    /* renamed from: v */
    private int f1605v;

    /* renamed from: w */
    private int f1606w;

    /* renamed from: x */
    private int f1607x;

    /* renamed from: y */
    private float f1608y;

    /* renamed from: z */
    private int f1609z;

    public ScanBoxView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f1588f = paint;
        paint.setAntiAlias(true);
        this.f1590h = Color.parseColor("#33FFFFFF");
        this.f1591i = -1;
        this.f1592j = BGAQRCodeUtil.m57970g(context, 20.0f);
        this.f1593k = BGAQRCodeUtil.m57970g(context, 3.0f);
        this.f1598p = BGAQRCodeUtil.m57970g(context, 1.0f);
        this.f1600q = -1;
        this.f1597o = BGAQRCodeUtil.m57970g(context, 90.0f);
        this.f1594l = BGAQRCodeUtil.m57970g(context, 200.0f);
        this.f1596n = BGAQRCodeUtil.m57970g(context, 140.0f);
        this.f1601r = 0;
        this.f1602s = false;
        this.f1603t = null;
        this.f1604u = null;
        this.f1605v = BGAQRCodeUtil.m57970g(context, 1.0f);
        this.f1606w = -1;
        this.f1607x = 1000;
        this.f1608y = -1.0f;
        this.f1609z = 1;
        this.f1555A = 0;
        this.f1557B = false;
        this.f1583a = BGAQRCodeUtil.m57970g(context, 2.0f);
        this.f1563E = null;
        this.f1565F = BGAQRCodeUtil.m57960q(context, 14.0f);
        this.f1566G = -1;
        this.f1567H = false;
        this.f1568I = BGAQRCodeUtil.m57970g(context, 20.0f);
        this.f1569J = false;
        this.f1570K = Color.parseColor("#22000000");
        this.f1571L = false;
        this.f1572M = false;
        this.f1573N = false;
        TextPaint textPaint = new TextPaint();
        this.f1589g = textPaint;
        textPaint.setAntiAlias(true);
        this.f1556A0 = BGAQRCodeUtil.m57970g(context, 4.0f);
        this.f1558B0 = false;
        this.f1560C0 = false;
        this.f1562D0 = false;
    }

    /* renamed from: a */
    private void m57997a() {
        Drawable drawable = this.f1574O;
        if (drawable != null) {
            this.f1580U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.f1580U == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C1100R.mipmap.qrcode_default_grid_scan_line);
            this.f1580U = decodeResource;
            this.f1580U = BGAQRCodeUtil.m57963n(decodeResource, this.f1600q);
        }
        Bitmap m57976a = BGAQRCodeUtil.m57976a(this.f1580U, 90);
        this.f1581V = m57976a;
        Bitmap m57976a2 = BGAQRCodeUtil.m57976a(m57976a, 90);
        this.f1581V = m57976a2;
        this.f1581V = BGAQRCodeUtil.m57976a(m57976a2, 90);
        Drawable drawable2 = this.f1603t;
        if (drawable2 != null) {
            this.f1578S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.f1578S == null) {
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), C1100R.mipmap.qrcode_default_scan_line);
            this.f1578S = decodeResource2;
            this.f1578S = BGAQRCodeUtil.m57963n(decodeResource2, this.f1600q);
        }
        this.f1579T = BGAQRCodeUtil.m57976a(this.f1578S, 90);
        this.f1597o += this.f1555A;
        this.f1582W = (this.f1593k * 1.0f) / 2.0f;
        this.f1589g.setTextSize(this.f1565F);
        this.f1589g.setColor(this.f1566G);
        setIsBarcode(this.f1557B);
    }

    /* renamed from: b */
    private void m57996b() {
        int width = (getWidth() - this.f1594l) / 2;
        int i = this.f1597o;
        Rect rect = new Rect(width, i, this.f1594l + width, this.f1595m + i);
        this.f1585c = rect;
        if (this.f1557B) {
            float f = rect.left + this.f1582W + 0.5f;
            this.f1587e = f;
            this.f1577R = f;
        } else {
            float f2 = rect.top + this.f1582W + 0.5f;
            this.f1586d = f2;
            this.f1576Q = f2;
        }
        if (this.f1564E0 == null || !m57986l()) {
            return;
        }
        this.f1564E0.m58004r(new Rect(this.f1585c));
    }

    /* renamed from: c */
    private void m57995c(Canvas canvas) {
        if (this.f1605v > 0) {
            this.f1588f.setStyle(Paint.Style.STROKE);
            this.f1588f.setColor(this.f1606w);
            this.f1588f.setStrokeWidth(this.f1605v);
            canvas.drawRect(this.f1585c, this.f1588f);
        }
    }

    /* renamed from: d */
    private void m57994d(Canvas canvas) {
        if (this.f1582W > 0.0f) {
            this.f1588f.setStyle(Paint.Style.STROKE);
            this.f1588f.setColor(this.f1591i);
            this.f1588f.setStrokeWidth(this.f1593k);
            int i = this.f1609z;
            if (i == 1) {
                Rect rect = this.f1585c;
                int i2 = rect.left;
                float f = this.f1582W;
                int i3 = rect.top;
                canvas.drawLine(i2 - f, i3, (i2 - f) + this.f1592j, i3, this.f1588f);
                Rect rect2 = this.f1585c;
                int i4 = rect2.left;
                int i5 = rect2.top;
                float f2 = this.f1582W;
                canvas.drawLine(i4, i5 - f2, i4, (i5 - f2) + this.f1592j, this.f1588f);
                Rect rect3 = this.f1585c;
                int i6 = rect3.right;
                float f3 = this.f1582W;
                int i7 = rect3.top;
                canvas.drawLine(i6 + f3, i7, (i6 + f3) - this.f1592j, i7, this.f1588f);
                Rect rect4 = this.f1585c;
                int i8 = rect4.right;
                int i9 = rect4.top;
                float f4 = this.f1582W;
                canvas.drawLine(i8, i9 - f4, i8, (i9 - f4) + this.f1592j, this.f1588f);
                Rect rect5 = this.f1585c;
                int i10 = rect5.left;
                float f5 = this.f1582W;
                int i11 = rect5.bottom;
                canvas.drawLine(i10 - f5, i11, (i10 - f5) + this.f1592j, i11, this.f1588f);
                Rect rect6 = this.f1585c;
                int i12 = rect6.left;
                int i13 = rect6.bottom;
                float f6 = this.f1582W;
                canvas.drawLine(i12, i13 + f6, i12, (i13 + f6) - this.f1592j, this.f1588f);
                Rect rect7 = this.f1585c;
                int i14 = rect7.right;
                float f7 = this.f1582W;
                int i15 = rect7.bottom;
                canvas.drawLine(i14 + f7, i15, (i14 + f7) - this.f1592j, i15, this.f1588f);
                Rect rect8 = this.f1585c;
                int i16 = rect8.right;
                int i17 = rect8.bottom;
                float f8 = this.f1582W;
                canvas.drawLine(i16, i17 + f8, i16, (i17 + f8) - this.f1592j, this.f1588f);
            } else if (i == 2) {
                Rect rect9 = this.f1585c;
                int i18 = rect9.left;
                int i19 = rect9.top;
                float f9 = this.f1582W;
                canvas.drawLine(i18, i19 + f9, i18 + this.f1592j, i19 + f9, this.f1588f);
                Rect rect10 = this.f1585c;
                int i20 = rect10.left;
                float f10 = this.f1582W;
                int i21 = rect10.top;
                canvas.drawLine(i20 + f10, i21, i20 + f10, i21 + this.f1592j, this.f1588f);
                Rect rect11 = this.f1585c;
                int i22 = rect11.right;
                int i23 = rect11.top;
                float f11 = this.f1582W;
                canvas.drawLine(i22, i23 + f11, i22 - this.f1592j, i23 + f11, this.f1588f);
                Rect rect12 = this.f1585c;
                int i24 = rect12.right;
                float f12 = this.f1582W;
                int i25 = rect12.top;
                canvas.drawLine(i24 - f12, i25, i24 - f12, i25 + this.f1592j, this.f1588f);
                Rect rect13 = this.f1585c;
                int i26 = rect13.left;
                int i27 = rect13.bottom;
                float f13 = this.f1582W;
                canvas.drawLine(i26, i27 - f13, i26 + this.f1592j, i27 - f13, this.f1588f);
                Rect rect14 = this.f1585c;
                int i28 = rect14.left;
                float f14 = this.f1582W;
                int i29 = rect14.bottom;
                canvas.drawLine(i28 + f14, i29, i28 + f14, i29 - this.f1592j, this.f1588f);
                Rect rect15 = this.f1585c;
                int i30 = rect15.right;
                int i31 = rect15.bottom;
                float f15 = this.f1582W;
                canvas.drawLine(i30, i31 - f15, i30 - this.f1592j, i31 - f15, this.f1588f);
                Rect rect16 = this.f1585c;
                int i32 = rect16.right;
                float f16 = this.f1582W;
                int i33 = rect16.bottom;
                canvas.drawLine(i32 - f16, i33, i32 - f16, i33 - this.f1592j, this.f1588f);
            }
        }
    }

    /* renamed from: e */
    private void m57993e(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f1590h != 0) {
            this.f1588f.setStyle(Paint.Style.FILL);
            this.f1588f.setColor(this.f1590h);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, this.f1585c.top, this.f1588f);
            Rect rect = this.f1585c;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f1588f);
            Rect rect2 = this.f1585c;
            canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.f1588f);
            canvas.drawRect(0.0f, this.f1585c.bottom + 1, f, height, this.f1588f);
        }
    }

    /* renamed from: f */
    private void m57992f(Canvas canvas) {
        if (this.f1557B) {
            if (this.f1575P != null) {
                Rect rect = this.f1585c;
                float f = this.f1582W;
                int i = this.f1601r;
                RectF rectF = new RectF(rect.left + f + 0.5f, rect.top + f + i, this.f1577R, (rect.bottom - f) - i);
                Rect rect2 = new Rect((int) (this.f1575P.getWidth() - rectF.width()), 0, this.f1575P.getWidth(), this.f1575P.getHeight());
                if (rect2.left < 0) {
                    rect2.left = 0;
                    rectF.left = rectF.right - rect2.width();
                }
                canvas.drawBitmap(this.f1575P, rect2, rectF, this.f1588f);
            } else if (this.f1604u != null) {
                float f2 = this.f1587e;
                canvas.drawBitmap(this.f1604u, (Rect) null, new RectF(f2, this.f1585c.top + this.f1582W + this.f1601r, this.f1604u.getWidth() + f2, (this.f1585c.bottom - this.f1582W) - this.f1601r), this.f1588f);
            } else {
                this.f1588f.setStyle(Paint.Style.FILL);
                this.f1588f.setColor(this.f1600q);
                float f3 = this.f1587e;
                Rect rect3 = this.f1585c;
                float f4 = this.f1582W;
                int i2 = this.f1601r;
                canvas.drawRect(f3, rect3.top + f4 + i2, this.f1598p + f3, (rect3.bottom - f4) - i2, this.f1588f);
            }
        } else if (this.f1575P != null) {
            Rect rect4 = this.f1585c;
            float f5 = this.f1582W;
            int i3 = this.f1601r;
            RectF rectF2 = new RectF(rect4.left + f5 + i3, rect4.top + f5 + 0.5f, (rect4.right - f5) - i3, this.f1576Q);
            Rect rect5 = new Rect(0, (int) (this.f1575P.getHeight() - rectF2.height()), this.f1575P.getWidth(), this.f1575P.getHeight());
            if (rect5.top < 0) {
                rect5.top = 0;
                rectF2.top = rectF2.bottom - rect5.height();
            }
            canvas.drawBitmap(this.f1575P, rect5, rectF2, this.f1588f);
        } else if (this.f1604u != null) {
            Rect rect6 = this.f1585c;
            float f6 = this.f1582W;
            int i4 = this.f1601r;
            float f7 = rect6.left + f6 + i4;
            float f8 = this.f1586d;
            canvas.drawBitmap(this.f1604u, (Rect) null, new RectF(f7, f8, (rect6.right - f6) - i4, this.f1604u.getHeight() + f8), this.f1588f);
        } else {
            this.f1588f.setStyle(Paint.Style.FILL);
            this.f1588f.setColor(this.f1600q);
            Rect rect7 = this.f1585c;
            float f9 = this.f1582W;
            int i5 = this.f1601r;
            float f10 = this.f1586d;
            canvas.drawRect(rect7.left + f9 + i5, f10, (rect7.right - f9) - i5, f10 + this.f1598p, this.f1588f);
        }
    }

    /* renamed from: g */
    private void m57991g(Canvas canvas) {
        Rect rect;
        Rect rect2;
        if (TextUtils.isEmpty(this.f1563E) || this.f1599p0 == null) {
            return;
        }
        if (this.f1567H) {
            if (this.f1571L) {
                this.f1588f.setColor(this.f1570K);
                this.f1588f.setStyle(Paint.Style.FILL);
                if (this.f1569J) {
                    Rect rect3 = new Rect();
                    TextPaint textPaint = this.f1589g;
                    String str = this.f1563E;
                    textPaint.getTextBounds(str, 0, str.length(), rect3);
                    float width = ((canvas.getWidth() - rect3.width()) / 2) - this.f1556A0;
                    RectF rectF = new RectF(width, (this.f1585c.bottom + this.f1568I) - this.f1556A0, rect3.width() + width + (this.f1556A0 * 2), this.f1585c.bottom + this.f1568I + this.f1599p0.getHeight() + this.f1556A0);
                    int i = this.f1556A0;
                    canvas.drawRoundRect(rectF, i, i, this.f1588f);
                } else {
                    int i2 = this.f1585c.bottom;
                    int i3 = this.f1568I;
                    RectF rectF2 = new RectF(rect2.left, (i2 + i3) - this.f1556A0, rect2.right, i2 + i3 + this.f1599p0.getHeight() + this.f1556A0);
                    int i4 = this.f1556A0;
                    canvas.drawRoundRect(rectF2, i4, i4, this.f1588f);
                }
            }
            canvas.save();
            if (this.f1569J) {
                canvas.translate(0.0f, this.f1585c.bottom + this.f1568I);
            } else {
                Rect rect4 = this.f1585c;
                canvas.translate(rect4.left + this.f1556A0, rect4.bottom + this.f1568I);
            }
            this.f1599p0.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.f1571L) {
            this.f1588f.setColor(this.f1570K);
            this.f1588f.setStyle(Paint.Style.FILL);
            if (this.f1569J) {
                Rect rect5 = new Rect();
                TextPaint textPaint2 = this.f1589g;
                String str2 = this.f1563E;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect5);
                float width2 = ((canvas.getWidth() - rect5.width()) / 2) - this.f1556A0;
                int i5 = this.f1556A0;
                RectF rectF3 = new RectF(width2, ((this.f1585c.top - this.f1568I) - this.f1599p0.getHeight()) - this.f1556A0, rect5.width() + width2 + (i5 * 2), (this.f1585c.top - this.f1568I) + i5);
                int i6 = this.f1556A0;
                canvas.drawRoundRect(rectF3, i6, i6, this.f1588f);
            } else {
                int height = (this.f1585c.top - this.f1568I) - this.f1599p0.getHeight();
                int i7 = this.f1556A0;
                Rect rect6 = this.f1585c;
                RectF rectF4 = new RectF(rect.left, height - i7, rect6.right, (rect6.top - this.f1568I) + i7);
                int i8 = this.f1556A0;
                canvas.drawRoundRect(rectF4, i8, i8, this.f1588f);
            }
        }
        canvas.save();
        if (this.f1569J) {
            canvas.translate(0.0f, (this.f1585c.top - this.f1568I) - this.f1599p0.getHeight());
        } else {
            Rect rect7 = this.f1585c;
            canvas.translate(rect7.left + this.f1556A0, (rect7.top - this.f1568I) - this.f1599p0.getHeight());
        }
        this.f1599p0.draw(canvas);
        canvas.restore();
    }

    /* renamed from: j */
    private void m57988j(int i, TypedArray typedArray) {
        if (i == C1100R.styleable.QRCodeView_qrcv_topOffset) {
            this.f1597o = typedArray.getDimensionPixelSize(i, this.f1597o);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_cornerSize) {
            this.f1593k = typedArray.getDimensionPixelSize(i, this.f1593k);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_cornerLength) {
            this.f1592j = typedArray.getDimensionPixelSize(i, this.f1592j);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.f1598p = typedArray.getDimensionPixelSize(i, this.f1598p);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_rectWidth) {
            this.f1594l = typedArray.getDimensionPixelSize(i, this.f1594l);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_maskColor) {
            this.f1590h = typedArray.getColor(i, this.f1590h);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_cornerColor) {
            this.f1591i = typedArray.getColor(i, this.f1591i);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.f1600q = typedArray.getColor(i, this.f1600q);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.f1601r = typedArray.getDimensionPixelSize(i, this.f1601r);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.f1602s = typedArray.getBoolean(i, this.f1602s);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.f1603t = typedArray.getDrawable(i);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_borderSize) {
            this.f1605v = typedArray.getDimensionPixelSize(i, this.f1605v);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_borderColor) {
            this.f1606w = typedArray.getColor(i, this.f1606w);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_animTime) {
            this.f1607x = typedArray.getInteger(i, this.f1607x);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_verticalBias) {
            this.f1608y = typedArray.getFloat(i, this.f1608y);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_cornerDisplayType) {
            this.f1609z = typedArray.getInteger(i, this.f1609z);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.f1555A = typedArray.getDimensionPixelSize(i, this.f1555A);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.f1596n = typedArray.getDimensionPixelSize(i, this.f1596n);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isBarcode) {
            this.f1557B = typedArray.getBoolean(i, this.f1557B);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.f1561D = typedArray.getString(i);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.f1559C = typedArray.getString(i);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.f1565F = typedArray.getDimensionPixelSize(i, this.f1565F);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.f1566G = typedArray.getColor(i, this.f1566G);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.f1567H = typedArray.getBoolean(i, this.f1567H);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.f1568I = typedArray.getDimensionPixelSize(i, this.f1568I);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.f1569J = typedArray.getBoolean(i, this.f1569J);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.f1571L = typedArray.getBoolean(i, this.f1571L);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.f1570K = typedArray.getColor(i, this.f1570K);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.f1572M = typedArray.getBoolean(i, this.f1572M);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.f1573N = typedArray.getBoolean(i, this.f1573N);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.f1574O = typedArray.getDrawable(i);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.f1558B0 = typedArray.getBoolean(i, this.f1558B0);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isShowLocationPoint) {
            this.f1560C0 = typedArray.getBoolean(i, this.f1560C0);
        } else if (i == C1100R.styleable.QRCodeView_qrcv_isAutoZoom) {
            this.f1562D0 = typedArray.getBoolean(i, this.f1562D0);
        }
    }

    /* renamed from: t */
    private void m57978t() {
        if (this.f1557B) {
            if (this.f1575P == null) {
                this.f1587e += this.f1583a;
                int i = this.f1598p;
                Bitmap bitmap = this.f1604u;
                if (bitmap != null) {
                    i = bitmap.getWidth();
                }
                if (this.f1572M) {
                    float f = this.f1587e;
                    Rect rect = this.f1585c;
                    float f2 = this.f1582W;
                    if (i + f > rect.right - f2 || f < rect.left + f2) {
                        this.f1583a = -this.f1583a;
                    }
                } else {
                    float f3 = this.f1587e + i;
                    Rect rect2 = this.f1585c;
                    float f4 = this.f1582W;
                    if (f3 > rect2.right - f4) {
                        this.f1587e = rect2.left + f4 + 0.5f;
                    }
                }
            } else {
                float f5 = this.f1577R + this.f1583a;
                this.f1577R = f5;
                Rect rect3 = this.f1585c;
                float f6 = this.f1582W;
                if (f5 > rect3.right - f6) {
                    this.f1577R = rect3.left + f6 + 0.5f;
                }
            }
        } else if (this.f1575P == null) {
            this.f1586d += this.f1583a;
            int i2 = this.f1598p;
            Bitmap bitmap2 = this.f1604u;
            if (bitmap2 != null) {
                i2 = bitmap2.getHeight();
            }
            if (this.f1572M) {
                float f7 = this.f1586d;
                Rect rect4 = this.f1585c;
                float f8 = this.f1582W;
                if (i2 + f7 > rect4.bottom - f8 || f7 < rect4.top + f8) {
                    this.f1583a = -this.f1583a;
                }
            } else {
                float f9 = this.f1586d + i2;
                Rect rect5 = this.f1585c;
                float f10 = this.f1582W;
                if (f9 > rect5.bottom - f10) {
                    this.f1586d = rect5.top + f10 + 0.5f;
                }
            }
        } else {
            float f11 = this.f1576Q + this.f1583a;
            this.f1576Q = f11;
            Rect rect6 = this.f1585c;
            float f12 = this.f1582W;
            if (f11 > rect6.bottom - f12) {
                this.f1576Q = rect6.top + f12 + 0.5f;
            }
        }
        long j = this.f1584b;
        Rect rect7 = this.f1585c;
        postInvalidateDelayed(j, rect7.left, rect7.top, rect7.right, rect7.bottom);
    }

    /* renamed from: u */
    private void m57977u() {
        if (this.f1574O == null && !this.f1573N) {
            if (this.f1603t != null || this.f1602s) {
                if (this.f1557B) {
                    this.f1604u = this.f1579T;
                } else {
                    this.f1604u = this.f1578S;
                }
            }
        } else if (this.f1557B) {
            this.f1575P = this.f1581V;
        } else {
            this.f1575P = this.f1580U;
        }
        if (this.f1557B) {
            this.f1563E = this.f1561D;
            this.f1595m = this.f1596n;
            this.f1584b = (int) (((this.f1607x * 1.0f) * this.f1583a) / this.f1594l);
        } else {
            this.f1563E = this.f1559C;
            int i = this.f1594l;
            this.f1595m = i;
            this.f1584b = (int) (((this.f1607x * 1.0f) * this.f1583a) / i);
        }
        if (!TextUtils.isEmpty(this.f1563E)) {
            if (this.f1569J) {
                this.f1599p0 = new StaticLayout(this.f1563E, this.f1589g, BGAQRCodeUtil.m57967j(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.f1599p0 = new StaticLayout(this.f1563E, this.f1589g, this.f1594l - (this.f1556A0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.f1608y != -1.0f) {
            int m57966k = BGAQRCodeUtil.m57967j(getContext()).y - BGAQRCodeUtil.m57966k(getContext());
            int i2 = this.f1555A;
            if (i2 == 0) {
                this.f1597o = (int) ((m57966k * this.f1608y) - (this.f1595m / 2));
            } else {
                this.f1597o = i2 + ((int) (((m57966k - i2) * this.f1608y) - (this.f1595m / 2)));
            }
        }
        m57996b();
        postInvalidate();
    }

    public int getAnimTime() {
        return this.f1607x;
    }

    public String getBarCodeTipText() {
        return this.f1561D;
    }

    public int getBarcodeRectHeight() {
        return this.f1596n;
    }

    public int getBorderColor() {
        return this.f1606w;
    }

    public int getBorderSize() {
        return this.f1605v;
    }

    public int getCornerColor() {
        return this.f1591i;
    }

    public int getCornerLength() {
        return this.f1592j;
    }

    public int getCornerSize() {
        return this.f1593k;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f1603t;
    }

    public float getHalfCornerSize() {
        return this.f1582W;
    }

    public boolean getIsBarcode() {
        return this.f1557B;
    }

    public int getMaskColor() {
        return this.f1590h;
    }

    public String getQRCodeTipText() {
        return this.f1559C;
    }

    public int getRectHeight() {
        return this.f1595m;
    }

    public int getRectWidth() {
        return this.f1594l;
    }

    public Bitmap getScanLineBitmap() {
        return this.f1604u;
    }

    public int getScanLineColor() {
        return this.f1600q;
    }

    public int getScanLineMargin() {
        return this.f1601r;
    }

    public int getScanLineSize() {
        return this.f1598p;
    }

    public int getTipBackgroundColor() {
        return this.f1570K;
    }

    public int getTipBackgroundRadius() {
        return this.f1556A0;
    }

    public String getTipText() {
        return this.f1563E;
    }

    public int getTipTextColor() {
        return this.f1566G;
    }

    public int getTipTextMargin() {
        return this.f1568I;
    }

    public int getTipTextSize() {
        return this.f1565F;
    }

    public StaticLayout getTipTextSl() {
        return this.f1599p0;
    }

    public int getToolbarHeight() {
        return this.f1555A;
    }

    public int getTopOffset() {
        return this.f1597o;
    }

    public float getVerticalBias() {
        return this.f1608y;
    }

    /* renamed from: h */
    public Rect m57990h(int i) {
        if (this.f1558B0 && getVisibility() == 0) {
            Rect rect = new Rect(this.f1585c);
            float measuredHeight = (i * 1.0f) / getMeasuredHeight();
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
    /* renamed from: i */
    public void m57989i(QRCodeView qRCodeView, AttributeSet attributeSet) {
        this.f1564E0 = qRCodeView;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1100R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            m57988j(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        m57997a();
    }

    /* renamed from: k */
    public boolean m57987k() {
        return this.f1562D0;
    }

    /* renamed from: l */
    public boolean m57986l() {
        return this.f1558B0;
    }

    /* renamed from: m */
    public boolean m57985m() {
        return this.f1572M;
    }

    /* renamed from: n */
    public boolean m57984n() {
        return this.f1573N;
    }

    /* renamed from: o */
    public boolean m57983o() {
        return this.f1602s;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1585c == null) {
            return;
        }
        m57993e(canvas);
        m57995c(canvas);
        m57994d(canvas);
        m57992f(canvas);
        m57991g(canvas);
        m57978t();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m57996b();
    }

    /* renamed from: p */
    public boolean m57982p() {
        return this.f1560C0;
    }

    /* renamed from: q */
    public boolean m57981q() {
        return this.f1571L;
    }

    /* renamed from: r */
    public boolean m57980r() {
        return this.f1569J;
    }

    /* renamed from: s */
    public boolean m57979s() {
        return this.f1567H;
    }

    public void setAnimTime(int i) {
        this.f1607x = i;
        m57977u();
    }

    public void setAutoZoom(boolean z) {
        this.f1562D0 = z;
    }

    public void setBarCodeTipText(String str) {
        this.f1561D = str;
        m57977u();
    }

    public void setBarcodeRectHeight(int i) {
        this.f1596n = i;
        m57977u();
    }

    public void setBorderColor(int i) {
        this.f1606w = i;
        m57977u();
    }

    public void setBorderSize(int i) {
        this.f1605v = i;
        m57977u();
    }

    public void setCornerColor(int i) {
        this.f1591i = i;
        m57977u();
    }

    public void setCornerLength(int i) {
        this.f1592j = i;
        m57977u();
    }

    public void setCornerSize(int i) {
        this.f1593k = i;
        m57977u();
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f1603t = drawable;
        m57977u();
    }

    public void setHalfCornerSize(float f) {
        this.f1582W = f;
        m57977u();
    }

    public void setIsBarcode(boolean z) {
        this.f1557B = z;
        m57977u();
    }

    public void setMaskColor(int i) {
        this.f1590h = i;
        m57977u();
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.f1558B0 = z;
        m57996b();
    }

    public void setQRCodeTipText(String str) {
        this.f1559C = str;
        m57977u();
    }

    public void setRectHeight(int i) {
        this.f1595m = i;
        m57977u();
    }

    public void setRectWidth(int i) {
        this.f1594l = i;
        m57977u();
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f1604u = bitmap;
        m57977u();
    }

    public void setScanLineColor(int i) {
        this.f1600q = i;
        m57977u();
    }

    public void setScanLineMargin(int i) {
        this.f1601r = i;
        m57977u();
    }

    public void setScanLineReverse(boolean z) {
        this.f1572M = z;
        m57977u();
    }

    public void setScanLineSize(int i) {
        this.f1598p = i;
        m57977u();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.f1573N = z;
        m57977u();
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.f1602s = z;
        m57977u();
    }

    public void setShowLocationPoint(boolean z) {
        this.f1560C0 = z;
    }

    public void setShowTipBackground(boolean z) {
        this.f1571L = z;
        m57977u();
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.f1569J = z;
        m57977u();
    }

    public void setTipBackgroundColor(int i) {
        this.f1570K = i;
        m57977u();
    }

    public void setTipBackgroundRadius(int i) {
        this.f1556A0 = i;
        m57977u();
    }

    public void setTipText(String str) {
        if (this.f1557B) {
            this.f1561D = str;
        } else {
            this.f1559C = str;
        }
        m57977u();
    }

    public void setTipTextBelowRect(boolean z) {
        this.f1567H = z;
        m57977u();
    }

    public void setTipTextColor(int i) {
        this.f1566G = i;
        this.f1589g.setColor(i);
        m57977u();
    }

    public void setTipTextMargin(int i) {
        this.f1568I = i;
        m57977u();
    }

    public void setTipTextSize(int i) {
        this.f1565F = i;
        this.f1589g.setTextSize(i);
        m57977u();
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f1599p0 = staticLayout;
        m57977u();
    }

    public void setToolbarHeight(int i) {
        this.f1555A = i;
        m57977u();
    }

    public void setTopOffset(int i) {
        this.f1597o = i;
        m57977u();
    }

    public void setVerticalBias(float f) {
        this.f1608y = f;
        m57977u();
    }
}
