package q.rorbin.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import q.rorbin.badgeview.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class QBadgeView extends View implements q.rorbin.badgeview.a {
    protected PointF A;
    protected PointF B;
    protected PointF C;
    protected PointF D;
    protected List<PointF> E;
    protected View F;
    protected int G;
    protected int H;
    protected TextPaint I;
    protected Paint J;
    protected Paint K;

    /* renamed from: L  reason: collision with root package name */
    protected b f61949L;
    protected a.InterfaceC1256a M;
    protected ViewGroup N;

    /* renamed from: a  reason: collision with root package name */
    protected int f61950a;

    /* renamed from: b  reason: collision with root package name */
    protected int f61951b;

    /* renamed from: c  reason: collision with root package name */
    protected int f61952c;

    /* renamed from: d  reason: collision with root package name */
    protected Drawable f61953d;

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap f61954e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f61955f;

    /* renamed from: g  reason: collision with root package name */
    protected float f61956g;

    /* renamed from: h  reason: collision with root package name */
    protected float f61957h;

    /* renamed from: i  reason: collision with root package name */
    protected float f61958i;

    /* renamed from: j  reason: collision with root package name */
    protected int f61959j;

    /* renamed from: k  reason: collision with root package name */
    protected String f61960k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f61961l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f61962m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f61963n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f61964o;

    /* renamed from: p  reason: collision with root package name */
    protected int f61965p;

    /* renamed from: q  reason: collision with root package name */
    protected float f61966q;

    /* renamed from: r  reason: collision with root package name */
    protected float f61967r;

    /* renamed from: s  reason: collision with root package name */
    protected float f61968s;

    /* renamed from: t  reason: collision with root package name */
    protected float f61969t;

    /* renamed from: u  reason: collision with root package name */
    protected int f61970u;

    /* renamed from: v  reason: collision with root package name */
    protected boolean f61971v;

    /* renamed from: w  reason: collision with root package name */
    protected RectF f61972w;

    /* renamed from: x  reason: collision with root package name */
    protected RectF f61973x;

    /* renamed from: y  reason: collision with root package name */
    protected Path f61974y;

    /* renamed from: z  reason: collision with root package name */
    protected Paint.FontMetrics f61975z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends ViewGroup {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i4, int i5) {
            View view = null;
            View view2 = null;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (childAt instanceof QBadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i4, i5);
                return;
            }
            view.measure(i4, i5);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f61960k != null && this.f61955f) {
            Bitmap bitmap = this.f61954e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f61954e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (!this.f61960k.isEmpty() && this.f61960k.length() != 1) {
                this.f61954e = Bitmap.createBitmap((int) (this.f61972w.width() + (this.f61958i * 2.0f)), (int) (this.f61972w.height() + this.f61958i), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.f61954e);
                if (Build.VERSION.SDK_INT >= 21) {
                    canvas.drawRoundRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), canvas.getHeight() / 2.0f, canvas.getHeight() / 2.0f, this.J);
                    return;
                } else {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), canvas.getHeight() / 2.0f, canvas.getHeight() / 2.0f, this.J);
                    return;
                }
            }
            int i4 = ((int) badgeCircleRadius) * 2;
            this.f61954e = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.f61954e);
            canvas2.drawCircle(canvas2.getWidth() / 2.0f, canvas2.getHeight() / 2.0f, canvas2.getWidth() / 2.0f, this.J);
        }
    }

    private void B(Canvas canvas, PointF pointF, float f4) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (!this.f61960k.isEmpty() && this.f61960k.length() != 1) {
            this.f61973x.left = pointF.x - ((this.f61972w.width() / 2.0f) + this.f61958i);
            this.f61973x.top = pointF.y - ((this.f61972w.height() / 2.0f) + (this.f61958i * 0.5f));
            this.f61973x.right = pointF.x + (this.f61972w.width() / 2.0f) + this.f61958i;
            this.f61973x.bottom = pointF.y + (this.f61972w.height() / 2.0f) + (this.f61958i * 0.5f);
            float height = this.f61973x.height() / 2.0f;
            if (this.f61953d != null) {
                C(canvas);
            } else {
                canvas.drawRoundRect(this.f61973x, height, height, this.J);
                if (this.f61951b != 0 && this.f61956g > 0.0f) {
                    canvas.drawRoundRect(this.f61973x, height, height, this.K);
                }
            }
        } else {
            RectF rectF = this.f61973x;
            float f5 = pointF.x;
            float f6 = (int) f4;
            rectF.left = f5 - f6;
            float f7 = pointF.y;
            rectF.top = f7 - f6;
            rectF.right = f5 + f6;
            rectF.bottom = f6 + f7;
            if (this.f61953d != null) {
                C(canvas);
            } else {
                canvas.drawCircle(f5, f7, f4, this.J);
                if (this.f61951b != 0 && this.f61956g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f4, this.K);
                }
            }
        }
        if (this.f61960k.isEmpty()) {
            return;
        }
        String str = this.f61960k;
        float f8 = pointF.x;
        RectF rectF2 = this.f61973x;
        float f9 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.f61975z;
        canvas.drawText(str, f8, ((f9 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.I);
    }

    private void C(Canvas canvas) {
        this.J.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        RectF rectF = this.f61973x;
        int i4 = (int) rectF.left;
        int i5 = (int) rectF.top;
        int i6 = (int) rectF.right;
        int i7 = (int) rectF.bottom;
        if (this.f61955f) {
            i6 = i4 + this.f61954e.getWidth();
            i7 = this.f61954e.getHeight() + i5;
            canvas.saveLayer(i4, i5, i6, i7, null, 31);
        }
        this.f61953d.setBounds(i4, i5, i6, i7);
        this.f61953d.draw(canvas);
        if (this.f61955f) {
            this.J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.f61954e, i4, i5, this.J);
            canvas.restore();
            this.J.setXfermode(null);
            if (!this.f61960k.isEmpty() && this.f61960k.length() != 1) {
                RectF rectF2 = this.f61973x;
                canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.f61973x.height() / 2.0f, this.K);
                return;
            }
            canvas.drawCircle(this.f61973x.centerX(), this.f61973x.centerY(), this.f61973x.width() / 2.0f, this.K);
            return;
        }
        canvas.drawRect(this.f61973x, this.K);
    }

    private void D(Canvas canvas, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        PointF pointF = this.B;
        float f9 = pointF.y;
        PointF pointF2 = this.C;
        float f10 = f9 - pointF2.y;
        float f11 = pointF.x - pointF2.x;
        this.E.clear();
        if (f11 != 0.0f) {
            double d4 = f10 / f11;
            Double.isNaN(d4);
            double d5 = (-1.0d) / d4;
            e.a(this.B, f5, Double.valueOf(d5), this.E);
            e.a(this.C, f4, Double.valueOf(d5), this.E);
        } else {
            e.a(this.B, f5, Double.valueOf(0.0d), this.E);
            e.a(this.C, f4, Double.valueOf(0.0d), this.E);
        }
        this.f61974y.reset();
        Path path = this.f61974y;
        PointF pointF3 = this.C;
        float f12 = pointF3.x;
        float f13 = pointF3.y;
        int i4 = this.f61970u;
        path.addCircle(f12, f13, f4, (i4 == 1 || i4 == 2) ? Path.Direction.CCW : Path.Direction.CW);
        PointF pointF4 = this.D;
        PointF pointF5 = this.C;
        float f14 = pointF5.x;
        PointF pointF6 = this.B;
        pointF4.x = (f14 + pointF6.x) / 2.0f;
        pointF4.y = (pointF5.y + pointF6.y) / 2.0f;
        this.f61974y.moveTo(this.E.get(2).x, this.E.get(2).y);
        Path path2 = this.f61974y;
        PointF pointF7 = this.D;
        path2.quadTo(pointF7.x, pointF7.y, this.E.get(0).x, this.E.get(0).y);
        this.f61974y.lineTo(this.E.get(1).x, this.E.get(1).y);
        Path path3 = this.f61974y;
        PointF pointF8 = this.D;
        path3.quadTo(pointF8.x, pointF8.y, this.E.get(3).x, this.E.get(3).y);
        this.f61974y.lineTo(this.E.get(2).x, this.E.get(2).y);
        this.f61974y.close();
        canvas.drawPath(this.f61974y, this.J);
        if (this.f61951b == 0 || this.f61956g <= 0.0f) {
            return;
        }
        this.f61974y.reset();
        this.f61974y.moveTo(this.E.get(2).x, this.E.get(2).y);
        Path path4 = this.f61974y;
        PointF pointF9 = this.D;
        path4.quadTo(pointF9.x, pointF9.y, this.E.get(0).x, this.E.get(0).y);
        this.f61974y.moveTo(this.E.get(1).x, this.E.get(1).y);
        Path path5 = this.f61974y;
        PointF pointF10 = this.D;
        path5.quadTo(pointF10.x, pointF10.y, this.E.get(3).x, this.E.get(3).y);
        int i5 = this.f61970u;
        if (i5 != 1 && i5 != 2) {
            float f15 = this.E.get(3).x;
            PointF pointF11 = this.C;
            f6 = f15 - pointF11.x;
            f7 = pointF11.y;
            f8 = this.E.get(3).y;
        } else {
            float f16 = this.E.get(2).x;
            PointF pointF12 = this.C;
            f6 = f16 - pointF12.x;
            f7 = pointF12.y;
            f8 = this.E.get(2).y;
        }
        double atan = Math.atan((f7 - f8) / f6);
        int i6 = this.f61970u;
        float e4 = 360.0f - ((float) e.e(e.d(atan, i6 + (-1) == 0 ? 4 : i6 - 1)));
        if (Build.VERSION.SDK_INT >= 21) {
            Path path6 = this.f61974y;
            PointF pointF13 = this.C;
            float f17 = pointF13.x;
            float f18 = pointF13.y;
            path6.addArc(f17 - f4, f18 - f4, f17 + f4, f18 + f4, e4, 180.0f);
        } else {
            Path path7 = this.f61974y;
            PointF pointF14 = this.C;
            float f19 = pointF14.x;
            float f20 = pointF14.y;
            path7.addArc(new RectF(f19 - f4, f20 - f4, f19 + f4, f20 + f4), e4, 180.0f);
        }
        canvas.drawPath(this.f61974y, this.K);
    }

    private void E(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            E((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.N = (ViewGroup) view;
        }
    }

    private void F() {
        float height = this.f61972w.height() > this.f61972w.width() ? this.f61972w.height() : this.f61972w.width();
        switch (this.f61965p) {
            case 17:
                PointF pointF = this.A;
                pointF.x = this.G / 2.0f;
                pointF.y = this.H / 2.0f;
                break;
            case 49:
                PointF pointF2 = this.A;
                pointF2.x = this.G / 2.0f;
                pointF2.y = this.f61967r + this.f61958i + (this.f61972w.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.A;
                pointF3.x = this.G / 2.0f;
                pointF3.y = this.H - ((this.f61967r + this.f61958i) + (this.f61972w.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.A;
                pointF4.x = this.f61966q + this.f61958i + (height / 2.0f);
                pointF4.y = this.H / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.A;
                pointF5.x = this.G - ((this.f61966q + this.f61958i) + (height / 2.0f));
                pointF5.y = this.H / 2.0f;
                break;
            case 8388659:
                PointF pointF6 = this.A;
                float f4 = this.f61966q;
                float f5 = this.f61958i;
                pointF6.x = f4 + f5 + (height / 2.0f);
                pointF6.y = this.f61967r + f5 + (this.f61972w.height() / 2.0f);
                break;
            case 8388661:
                PointF pointF7 = this.A;
                float f6 = this.f61966q;
                float f7 = this.f61958i;
                pointF7.x = this.G - ((f6 + f7) + (height / 2.0f));
                pointF7.y = this.f61967r + f7 + (this.f61972w.height() / 2.0f);
                break;
            case 8388691:
                PointF pointF8 = this.A;
                float f8 = this.f61966q;
                float f9 = this.f61958i;
                pointF8.x = f8 + f9 + (height / 2.0f);
                pointF8.y = this.H - ((this.f61967r + f9) + (this.f61972w.height() / 2.0f));
                break;
            case 8388693:
                PointF pointF9 = this.A;
                float f10 = this.f61966q;
                float f11 = this.f61958i;
                pointF9.x = this.G - ((f10 + f11) + (height / 2.0f));
                pointF9.y = this.H - ((this.f61967r + f11) + (this.f61972w.height() / 2.0f));
                break;
        }
        J();
    }

    private void G(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.N = viewGroup;
        if (viewGroup == null) {
            E(view);
        }
    }

    private void H() {
        setLayerType(1, null);
        this.f61972w = new RectF();
        this.f61973x = new RectF();
        this.f61974y = new Path();
        this.A = new PointF();
        this.B = new PointF();
        this.C = new PointF();
        this.D = new PointF();
        this.E = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.I = textPaint;
        textPaint.setAntiAlias(true);
        this.I.setSubpixelText(true);
        this.I.setFakeBoldText(true);
        this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        this.J.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.K = paint2;
        paint2.setAntiAlias(true);
        this.K.setStyle(Paint.Style.STROKE);
        this.f61950a = -1552832;
        this.f61952c = -1;
        this.f61957h = d.a(getContext(), 11.0f);
        this.f61958i = d.a(getContext(), 5.0f);
        this.f61959j = 0;
        this.f61965p = 8388661;
        this.f61966q = d.a(getContext(), 1.0f);
        this.f61967r = d.a(getContext(), 1.0f);
        this.f61969t = d.a(getContext(), 90.0f);
        this.f61964o = true;
        this.f61955f = false;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1000.0f);
        }
    }

    private void I() {
        O(this.f61964o);
        this.J.setColor(this.f61950a);
        this.K.setColor(this.f61951b);
        this.K.setStrokeWidth(this.f61956g);
        this.I.setColor(this.f61952c);
        this.I.setTextAlign(Paint.Align.CENTER);
    }

    private void J() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        PointF pointF = this.C;
        PointF pointF2 = this.A;
        pointF.x = pointF2.x + iArr[0];
        pointF.y = pointF2.y + iArr[1];
    }

    private void K() {
        RectF rectF = this.f61972w;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.f61960k)) {
            RectF rectF2 = this.f61972w;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.I.setTextSize(this.f61957h);
            this.f61972w.right = this.I.measureText(this.f61960k);
            Paint.FontMetrics fontMetrics = this.I.getFontMetrics();
            this.f61975z = fontMetrics;
            this.f61972w.bottom = fontMetrics.descent - fontMetrics.ascent;
        }
        A();
    }

    private void L() {
        if (this.f61971v) {
            y(this.B);
            P(5);
            return;
        }
        M();
        P(4);
    }

    private void O(boolean z3) {
        int a4 = d.a(getContext(), 1.0f);
        int a5 = d.a(getContext(), 1.5f);
        int i4 = this.f61970u;
        if (i4 == 1) {
            a4 = d.a(getContext(), 1.0f);
            a5 = d.a(getContext(), -1.5f);
        } else if (i4 == 2) {
            a4 = d.a(getContext(), -1.0f);
            a5 = d.a(getContext(), -1.5f);
        } else if (i4 == 3) {
            a4 = d.a(getContext(), -1.0f);
            a5 = d.a(getContext(), 1.5f);
        } else if (i4 == 4) {
            a4 = d.a(getContext(), 1.0f);
            a5 = d.a(getContext(), 1.5f);
        }
        this.J.setShadowLayer(z3 ? d.a(getContext(), 2.0f) : 0.0f, a4, a5, 855638016);
    }

    private void P(int i4) {
        a.InterfaceC1256a interfaceC1256a = this.M;
        if (interfaceC1256a != null) {
            interfaceC1256a.a(i4, this, this.F);
        }
    }

    private float getBadgeCircleRadius() {
        float width;
        float f4;
        if (this.f61960k.isEmpty()) {
            return this.f61958i;
        }
        if (this.f61960k.length() == 1) {
            if (this.f61972w.height() > this.f61972w.width()) {
                width = this.f61972w.height() / 2.0f;
                f4 = this.f61958i;
            } else {
                width = this.f61972w.width() / 2.0f;
                f4 = this.f61958i;
            }
            return width + (f4 * 0.5f);
        }
        return this.f61973x.height() / 2.0f;
    }

    public void M() {
        PointF pointF = this.B;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.f61970u = 4;
        N(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    protected void N(boolean z3) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z3) {
            this.N.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            c(this.F);
        }
    }

    @Override // q.rorbin.badgeview.a
    public float a(boolean z3) {
        return z3 ? d.b(getContext(), this.f61957h) : this.f61957h;
    }

    @Override // q.rorbin.badgeview.a
    public boolean b() {
        return this.f61964o;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a c(View view) {
        if (view != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                this.F = view;
                if (parent instanceof a) {
                    ((a) parent).addView(this);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    viewGroup.removeView(view);
                    a aVar = new a(getContext());
                    if (viewGroup instanceof RelativeLayout) {
                        aVar.setId(view.getId());
                    }
                    viewGroup.addView(aVar, indexOfChild, layoutParams);
                    aVar.addView(view);
                    aVar.addView(this);
                }
                return this;
            }
            throw new IllegalStateException("targetView must have a parent");
        }
        throw new IllegalStateException("targetView can not be null");
    }

    @Override // q.rorbin.badgeview.a
    public float d(boolean z3) {
        return z3 ? d.b(getContext(), this.f61966q) : this.f61966q;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a e(String str) {
        this.f61960k = str;
        this.f61959j = 1;
        K();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public float f(boolean z3) {
        return z3 ? d.b(getContext(), this.f61967r) : this.f61967r;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a g(int i4) {
        this.f61950a = i4;
        if (i4 == 0) {
            this.I.setXfermode(null);
        } else {
            this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public Drawable getBadgeBackground() {
        return this.f61953d;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeBackgroundColor() {
        return this.f61950a;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeGravity() {
        return this.f61965p;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeNumber() {
        return this.f61959j;
    }

    @Override // q.rorbin.badgeview.a
    public String getBadgeText() {
        return this.f61960k;
    }

    @Override // q.rorbin.badgeview.a
    public int getBadgeTextColor() {
        return this.f61952c;
    }

    @Override // q.rorbin.badgeview.a
    public PointF getDragCenter() {
        if (this.f61961l && this.f61962m) {
            return this.B;
        }
        return null;
    }

    @Override // q.rorbin.badgeview.a
    public View getTargetView() {
        return this.F;
    }

    @Override // q.rorbin.badgeview.a
    public void h(boolean z3) {
        if (z3 && this.N != null) {
            J();
            y(this.C);
            return;
        }
        r(0);
    }

    @Override // q.rorbin.badgeview.a
    public boolean i() {
        return this.f61961l;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a j(a.InterfaceC1256a interfaceC1256a) {
        this.f61961l = interfaceC1256a != null;
        this.M = interfaceC1256a;
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public float k(boolean z3) {
        return z3 ? d.b(getContext(), this.f61958i) : this.f61958i;
    }

    @Override // q.rorbin.badgeview.a
    public boolean l() {
        return this.f61963n;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a m(int i4) {
        this.f61952c = i4;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a n(float f4, boolean z3) {
        return s(f4, f4, z3);
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a o(int i4, float f4, boolean z3) {
        this.f61951b = i4;
        if (z3) {
            f4 = d.a(getContext(), f4);
        }
        this.f61956g = f4;
        invalidate();
        return this;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.N == null) {
            G(this.F);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b bVar = this.f61949L;
        if (bVar != null && bVar.isRunning()) {
            this.f61949L.b(canvas);
        } else if (this.f61960k != null) {
            I();
            float badgeCircleRadius = getBadgeCircleRadius();
            float b4 = this.f61968s * (1.0f - (e.b(this.C, this.B) / this.f61969t));
            if (this.f61961l && this.f61962m) {
                this.f61970u = e.c(this.B, this.C);
                O(this.f61964o);
                boolean z3 = b4 < ((float) d.a(getContext(), 1.5f));
                this.f61971v = z3;
                if (z3) {
                    P(3);
                    B(canvas, this.B, badgeCircleRadius);
                    return;
                }
                P(2);
                D(canvas, b4, badgeCircleRadius);
                B(canvas, this.B, badgeCircleRadius);
                return;
            }
            F();
            B(canvas, this.A, badgeCircleRadius);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.G = i4;
        this.H = i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r0 != 6) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L45
            if (r0 == r2) goto L31
            r3 = 2
            if (r0 == r3) goto L18
            r3 = 3
            if (r0 == r3) goto L31
            r3 = 5
            if (r0 == r3) goto L45
            r3 = 6
            if (r0 == r3) goto L31
            goto La8
        L18:
            boolean r0 = r6.f61962m
            if (r0 == 0) goto La8
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawY()
            r0.y = r3
            r6.invalidate()
            goto La8
        L31:
            int r0 = r7.getActionIndex()
            int r0 = r7.getPointerId(r0)
            if (r0 != 0) goto La8
            boolean r0 = r6.f61962m
            if (r0 == 0) goto La8
            r6.f61962m = r1
            r6.L()
            goto La8
        L45:
            float r0 = r7.getX()
            float r3 = r7.getY()
            boolean r4 = r6.f61961l
            if (r4 == 0) goto La8
            int r4 = r7.getActionIndex()
            int r4 = r7.getPointerId(r4)
            if (r4 != 0) goto La8
            android.graphics.RectF r4 = r6.f61973x
            float r5 = r4.left
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 <= 0) goto La8
            float r5 = r4.right
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto La8
            float r0 = r4.top
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto La8
            float r0 = r4.bottom
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto La8
            java.lang.String r0 = r6.f61960k
            if (r0 == 0) goto La8
            r6.J()
            r6.f61962m = r2
            r6.P(r2)
            android.content.Context r0 = r6.getContext()
            r3 = 1088421888(0x40e00000, float:7.0)
            int r0 = q.rorbin.badgeview.d.a(r0, r3)
            float r0 = (float) r0
            r6.f61968s = r0
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            r6.N(r2)
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.B
            float r3 = r7.getRawY()
            r0.y = r3
        La8:
            boolean r0 = r6.f61962m
            if (r0 != 0) goto Lb2
            boolean r7 = super.onTouchEvent(r7)
            if (r7 == 0) goto Lb3
        Lb2:
            r1 = 1
        Lb3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q.rorbin.badgeview.QBadgeView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a p(int i4) {
        if (i4 != 8388659 && i4 != 8388661 && i4 != 8388691 && i4 != 8388693 && i4 != 17 && i4 != 49 && i4 != 81 && i4 != 8388627 && i4 != 8388629) {
            throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
        }
        this.f61965p = i4;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a q(Drawable drawable) {
        return x(drawable, false);
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a r(int i4) {
        this.f61959j = i4;
        if (i4 < 0) {
            this.f61960k = "";
        } else if (i4 > 99) {
            this.f61960k = this.f61963n ? String.valueOf(i4) : "99+";
        } else if (i4 > 0 && i4 <= 99) {
            this.f61960k = String.valueOf(i4);
        } else if (i4 == 0) {
            this.f61960k = null;
        }
        K();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a s(float f4, float f5, boolean z3) {
        if (z3) {
            f4 = d.a(getContext(), f4);
        }
        this.f61966q = f4;
        if (z3) {
            f5 = d.a(getContext(), f5);
        }
        this.f61967r = f5;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a t(boolean z3) {
        this.f61964o = z3;
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a u(boolean z3) {
        this.f61963n = z3;
        int i4 = this.f61959j;
        if (i4 > 99) {
            r(i4);
        }
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a v(float f4, boolean z3) {
        if (z3) {
            f4 = d.a(getContext(), f4);
        }
        this.f61958i = f4;
        A();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a w(float f4, boolean z3) {
        if (z3) {
            f4 = d.a(getContext(), f4);
        }
        this.f61957h = f4;
        K();
        invalidate();
        return this;
    }

    @Override // q.rorbin.badgeview.a
    public q.rorbin.badgeview.a x(Drawable drawable, boolean z3) {
        this.f61955f = z3;
        this.f61953d = drawable;
        A();
        invalidate();
        return this;
    }

    protected void y(PointF pointF) {
        if (this.f61960k == null) {
            return;
        }
        b bVar = this.f61949L;
        if (bVar == null || !bVar.isRunning()) {
            N(true);
            b bVar2 = new b(z(), pointF, this);
            this.f61949L = bVar2;
            bVar2.start();
            r(0);
        }
    }

    protected Bitmap z() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.f61973x.width()) + d.a(getContext(), 3.0f), ((int) this.f61973x.height()) + d.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        B(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    private QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private QBadgeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        H();
    }
}
