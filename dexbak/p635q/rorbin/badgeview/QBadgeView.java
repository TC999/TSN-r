package p635q.rorbin.badgeview;

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
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.List;
import p635q.rorbin.badgeview.Badge;

/* renamed from: q.rorbin.badgeview.QBadgeView */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class QBadgeView extends View implements Badge {

    /* renamed from: A */
    protected PointF f44532A;

    /* renamed from: B */
    protected PointF f44533B;

    /* renamed from: C */
    protected PointF f44534C;

    /* renamed from: D */
    protected PointF f44535D;

    /* renamed from: E */
    protected List<PointF> f44536E;

    /* renamed from: F */
    protected View f44537F;

    /* renamed from: G */
    protected int f44538G;

    /* renamed from: H */
    protected int f44539H;

    /* renamed from: I */
    protected TextPaint f44540I;

    /* renamed from: J */
    protected Paint f44541J;

    /* renamed from: K */
    protected Paint f44542K;

    /* renamed from: L */
    protected BadgeAnimator f44543L;

    /* renamed from: M */
    protected Badge.InterfaceC15475a f44544M;

    /* renamed from: N */
    protected ViewGroup f44545N;

    /* renamed from: a */
    protected int f44546a;

    /* renamed from: b */
    protected int f44547b;

    /* renamed from: c */
    protected int f44548c;

    /* renamed from: d */
    protected Drawable f44549d;

    /* renamed from: e */
    protected Bitmap f44550e;

    /* renamed from: f */
    protected boolean f44551f;

    /* renamed from: g */
    protected float f44552g;

    /* renamed from: h */
    protected float f44553h;

    /* renamed from: i */
    protected float f44554i;

    /* renamed from: j */
    protected int f44555j;

    /* renamed from: k */
    protected String f44556k;

    /* renamed from: l */
    protected boolean f44557l;

    /* renamed from: m */
    protected boolean f44558m;

    /* renamed from: n */
    protected boolean f44559n;

    /* renamed from: o */
    protected boolean f44560o;

    /* renamed from: p */
    protected int f44561p;

    /* renamed from: q */
    protected float f44562q;

    /* renamed from: r */
    protected float f44563r;

    /* renamed from: s */
    protected float f44564s;

    /* renamed from: t */
    protected float f44565t;

    /* renamed from: u */
    protected int f44566u;

    /* renamed from: v */
    protected boolean f44567v;

    /* renamed from: w */
    protected RectF f44568w;

    /* renamed from: x */
    protected RectF f44569x;

    /* renamed from: y */
    protected Path f44570y;

    /* renamed from: z */
    protected Paint.FontMetrics f44571z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q.rorbin.badgeview.QBadgeView$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15472a extends ViewGroup {
        public C15472a(Context context) {
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
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof QBadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m2191A() {
        if (this.f44556k != null && this.f44551f) {
            Bitmap bitmap = this.f44550e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f44550e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (!this.f44556k.isEmpty() && this.f44556k.length() != 1) {
                this.f44550e = Bitmap.createBitmap((int) (this.f44568w.width() + (this.f44554i * 2.0f)), (int) (this.f44568w.height() + this.f44554i), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.f44550e);
                if (Build.VERSION.SDK_INT >= 21) {
                    canvas.drawRoundRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), canvas.getHeight() / 2.0f, canvas.getHeight() / 2.0f, this.f44541J);
                    return;
                } else {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), canvas.getHeight() / 2.0f, canvas.getHeight() / 2.0f, this.f44541J);
                    return;
                }
            }
            int i = ((int) badgeCircleRadius) * 2;
            this.f44550e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.f44550e);
            canvas2.drawCircle(canvas2.getWidth() / 2.0f, canvas2.getHeight() / 2.0f, canvas2.getWidth() / 2.0f, this.f44541J);
        }
    }

    /* renamed from: B */
    private void m2190B(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (!this.f44556k.isEmpty() && this.f44556k.length() != 1) {
            this.f44569x.left = pointF.x - ((this.f44568w.width() / 2.0f) + this.f44554i);
            this.f44569x.top = pointF.y - ((this.f44568w.height() / 2.0f) + (this.f44554i * 0.5f));
            this.f44569x.right = pointF.x + (this.f44568w.width() / 2.0f) + this.f44554i;
            this.f44569x.bottom = pointF.y + (this.f44568w.height() / 2.0f) + (this.f44554i * 0.5f);
            float height = this.f44569x.height() / 2.0f;
            if (this.f44549d != null) {
                m2189C(canvas);
            } else {
                canvas.drawRoundRect(this.f44569x, height, height, this.f44541J);
                if (this.f44547b != 0 && this.f44552g > 0.0f) {
                    canvas.drawRoundRect(this.f44569x, height, height, this.f44542K);
                }
            }
        } else {
            RectF rectF = this.f44569x;
            float f2 = pointF.x;
            float f3 = (int) f;
            rectF.left = f2 - f3;
            float f4 = pointF.y;
            rectF.top = f4 - f3;
            rectF.right = f2 + f3;
            rectF.bottom = f3 + f4;
            if (this.f44549d != null) {
                m2189C(canvas);
            } else {
                canvas.drawCircle(f2, f4, f, this.f44541J);
                if (this.f44547b != 0 && this.f44552g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f, this.f44542K);
                }
            }
        }
        if (this.f44556k.isEmpty()) {
            return;
        }
        String str = this.f44556k;
        float f5 = pointF.x;
        RectF rectF2 = this.f44569x;
        float f6 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.f44571z;
        canvas.drawText(str, f5, ((f6 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.f44540I);
    }

    /* renamed from: C */
    private void m2189C(Canvas canvas) {
        this.f44541J.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        RectF rectF = this.f44569x;
        int i = (int) rectF.left;
        int i2 = (int) rectF.top;
        int i3 = (int) rectF.right;
        int i4 = (int) rectF.bottom;
        if (this.f44551f) {
            i3 = i + this.f44550e.getWidth();
            i4 = this.f44550e.getHeight() + i2;
            canvas.saveLayer(i, i2, i3, i4, null, 31);
        }
        this.f44549d.setBounds(i, i2, i3, i4);
        this.f44549d.draw(canvas);
        if (this.f44551f) {
            this.f44541J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.f44550e, i, i2, this.f44541J);
            canvas.restore();
            this.f44541J.setXfermode(null);
            if (!this.f44556k.isEmpty() && this.f44556k.length() != 1) {
                RectF rectF2 = this.f44569x;
                canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.f44569x.height() / 2.0f, this.f44542K);
                return;
            }
            canvas.drawCircle(this.f44569x.centerX(), this.f44569x.centerY(), this.f44569x.width() / 2.0f, this.f44542K);
            return;
        }
        canvas.drawRect(this.f44569x, this.f44542K);
    }

    /* renamed from: D */
    private void m2188D(Canvas canvas, float f, float f2) {
        float f3;
        float f4;
        float f5;
        PointF pointF = this.f44533B;
        float f6 = pointF.y;
        PointF pointF2 = this.f44534C;
        float f7 = f6 - pointF2.y;
        float f8 = pointF.x - pointF2.x;
        this.f44536E.clear();
        if (f8 != 0.0f) {
            double d = f7 / f8;
            Double.isNaN(d);
            double d2 = (-1.0d) / d;
            MathUtil.m2142a(this.f44533B, f2, Double.valueOf(d2), this.f44536E);
            MathUtil.m2142a(this.f44534C, f, Double.valueOf(d2), this.f44536E);
        } else {
            MathUtil.m2142a(this.f44533B, f2, Double.valueOf((double) Utils.DOUBLE_EPSILON), this.f44536E);
            MathUtil.m2142a(this.f44534C, f, Double.valueOf((double) Utils.DOUBLE_EPSILON), this.f44536E);
        }
        this.f44570y.reset();
        Path path = this.f44570y;
        PointF pointF3 = this.f44534C;
        float f9 = pointF3.x;
        float f10 = pointF3.y;
        int i = this.f44566u;
        path.addCircle(f9, f10, f, (i == 1 || i == 2) ? Path.Direction.CCW : Path.Direction.CW);
        PointF pointF4 = this.f44535D;
        PointF pointF5 = this.f44534C;
        float f11 = pointF5.x;
        PointF pointF6 = this.f44533B;
        pointF4.x = (f11 + pointF6.x) / 2.0f;
        pointF4.y = (pointF5.y + pointF6.y) / 2.0f;
        this.f44570y.moveTo(this.f44536E.get(2).x, this.f44536E.get(2).y);
        Path path2 = this.f44570y;
        PointF pointF7 = this.f44535D;
        path2.quadTo(pointF7.x, pointF7.y, this.f44536E.get(0).x, this.f44536E.get(0).y);
        this.f44570y.lineTo(this.f44536E.get(1).x, this.f44536E.get(1).y);
        Path path3 = this.f44570y;
        PointF pointF8 = this.f44535D;
        path3.quadTo(pointF8.x, pointF8.y, this.f44536E.get(3).x, this.f44536E.get(3).y);
        this.f44570y.lineTo(this.f44536E.get(2).x, this.f44536E.get(2).y);
        this.f44570y.close();
        canvas.drawPath(this.f44570y, this.f44541J);
        if (this.f44547b == 0 || this.f44552g <= 0.0f) {
            return;
        }
        this.f44570y.reset();
        this.f44570y.moveTo(this.f44536E.get(2).x, this.f44536E.get(2).y);
        Path path4 = this.f44570y;
        PointF pointF9 = this.f44535D;
        path4.quadTo(pointF9.x, pointF9.y, this.f44536E.get(0).x, this.f44536E.get(0).y);
        this.f44570y.moveTo(this.f44536E.get(1).x, this.f44536E.get(1).y);
        Path path5 = this.f44570y;
        PointF pointF10 = this.f44535D;
        path5.quadTo(pointF10.x, pointF10.y, this.f44536E.get(3).x, this.f44536E.get(3).y);
        int i2 = this.f44566u;
        if (i2 != 1 && i2 != 2) {
            float f12 = this.f44536E.get(3).x;
            PointF pointF11 = this.f44534C;
            f3 = f12 - pointF11.x;
            f4 = pointF11.y;
            f5 = this.f44536E.get(3).y;
        } else {
            float f13 = this.f44536E.get(2).x;
            PointF pointF12 = this.f44534C;
            f3 = f13 - pointF12.x;
            f4 = pointF12.y;
            f5 = this.f44536E.get(2).y;
        }
        double atan = Math.atan((f4 - f5) / f3);
        int i3 = this.f44566u;
        float m2138e = 360.0f - ((float) MathUtil.m2138e(MathUtil.m2139d(atan, i3 + (-1) == 0 ? 4 : i3 - 1)));
        if (Build.VERSION.SDK_INT >= 21) {
            Path path6 = this.f44570y;
            PointF pointF13 = this.f44534C;
            float f14 = pointF13.x;
            float f15 = pointF13.y;
            path6.addArc(f14 - f, f15 - f, f14 + f, f15 + f, m2138e, 180.0f);
        } else {
            Path path7 = this.f44570y;
            PointF pointF14 = this.f44534C;
            float f16 = pointF14.x;
            float f17 = pointF14.y;
            path7.addArc(new RectF(f16 - f, f17 - f, f16 + f, f17 + f), m2138e, 180.0f);
        }
        canvas.drawPath(this.f44570y, this.f44542K);
    }

    /* renamed from: E */
    private void m2187E(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            m2187E((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.f44545N = (ViewGroup) view;
        }
    }

    /* renamed from: F */
    private void m2186F() {
        float height = this.f44568w.height() > this.f44568w.width() ? this.f44568w.height() : this.f44568w.width();
        switch (this.f44561p) {
            case 17:
                PointF pointF = this.f44532A;
                pointF.x = this.f44538G / 2.0f;
                pointF.y = this.f44539H / 2.0f;
                break;
            case 49:
                PointF pointF2 = this.f44532A;
                pointF2.x = this.f44538G / 2.0f;
                pointF2.y = this.f44563r + this.f44554i + (this.f44568w.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.f44532A;
                pointF3.x = this.f44538G / 2.0f;
                pointF3.y = this.f44539H - ((this.f44563r + this.f44554i) + (this.f44568w.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.f44532A;
                pointF4.x = this.f44562q + this.f44554i + (height / 2.0f);
                pointF4.y = this.f44539H / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.f44532A;
                pointF5.x = this.f44538G - ((this.f44562q + this.f44554i) + (height / 2.0f));
                pointF5.y = this.f44539H / 2.0f;
                break;
            case BadgeDrawable.TOP_START /* 8388659 */:
                PointF pointF6 = this.f44532A;
                float f = this.f44562q;
                float f2 = this.f44554i;
                pointF6.x = f + f2 + (height / 2.0f);
                pointF6.y = this.f44563r + f2 + (this.f44568w.height() / 2.0f);
                break;
            case BadgeDrawable.TOP_END /* 8388661 */:
                PointF pointF7 = this.f44532A;
                float f3 = this.f44562q;
                float f4 = this.f44554i;
                pointF7.x = this.f44538G - ((f3 + f4) + (height / 2.0f));
                pointF7.y = this.f44563r + f4 + (this.f44568w.height() / 2.0f);
                break;
            case BadgeDrawable.BOTTOM_START /* 8388691 */:
                PointF pointF8 = this.f44532A;
                float f5 = this.f44562q;
                float f6 = this.f44554i;
                pointF8.x = f5 + f6 + (height / 2.0f);
                pointF8.y = this.f44539H - ((this.f44563r + f6) + (this.f44568w.height() / 2.0f));
                break;
            case BadgeDrawable.BOTTOM_END /* 8388693 */:
                PointF pointF9 = this.f44532A;
                float f7 = this.f44562q;
                float f8 = this.f44554i;
                pointF9.x = this.f44538G - ((f7 + f8) + (height / 2.0f));
                pointF9.y = this.f44539H - ((this.f44563r + f8) + (this.f44568w.height() / 2.0f));
                break;
        }
        m2182J();
    }

    /* renamed from: G */
    private void m2185G(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.f44545N = viewGroup;
        if (viewGroup == null) {
            m2187E(view);
        }
    }

    /* renamed from: H */
    private void m2184H() {
        setLayerType(1, null);
        this.f44568w = new RectF();
        this.f44569x = new RectF();
        this.f44570y = new Path();
        this.f44532A = new PointF();
        this.f44533B = new PointF();
        this.f44534C = new PointF();
        this.f44535D = new PointF();
        this.f44536E = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.f44540I = textPaint;
        textPaint.setAntiAlias(true);
        this.f44540I.setSubpixelText(true);
        this.f44540I.setFakeBoldText(true);
        this.f44540I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.f44541J = paint;
        paint.setAntiAlias(true);
        this.f44541J.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f44542K = paint2;
        paint2.setAntiAlias(true);
        this.f44542K.setStyle(Paint.Style.STROKE);
        this.f44546a = -1552832;
        this.f44548c = -1;
        this.f44553h = C15480d.m2144a(getContext(), 11.0f);
        this.f44554i = C15480d.m2144a(getContext(), 5.0f);
        this.f44555j = 0;
        this.f44561p = BadgeDrawable.TOP_END;
        this.f44562q = C15480d.m2144a(getContext(), 1.0f);
        this.f44563r = C15480d.m2144a(getContext(), 1.0f);
        this.f44565t = C15480d.m2144a(getContext(), 90.0f);
        this.f44560o = true;
        this.f44551f = false;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1000.0f);
        }
    }

    /* renamed from: I */
    private void m2183I() {
        m2177O(this.f44560o);
        this.f44541J.setColor(this.f44546a);
        this.f44542K.setColor(this.f44547b);
        this.f44542K.setStrokeWidth(this.f44552g);
        this.f44540I.setColor(this.f44548c);
        this.f44540I.setTextAlign(Paint.Align.CENTER);
    }

    /* renamed from: J */
    private void m2182J() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        PointF pointF = this.f44534C;
        PointF pointF2 = this.f44532A;
        pointF.x = pointF2.x + iArr[0];
        pointF.y = pointF2.y + iArr[1];
    }

    /* renamed from: K */
    private void m2181K() {
        RectF rectF = this.f44568w;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.f44556k)) {
            RectF rectF2 = this.f44568w;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.f44540I.setTextSize(this.f44553h);
            this.f44568w.right = this.f44540I.measureText(this.f44556k);
            Paint.FontMetrics fontMetrics = this.f44540I.getFontMetrics();
            this.f44571z = fontMetrics;
            this.f44568w.bottom = fontMetrics.descent - fontMetrics.ascent;
        }
        m2191A();
    }

    /* renamed from: L */
    private void m2180L() {
        if (this.f44567v) {
            m2175y(this.f44533B);
            m2176P(5);
            return;
        }
        m2179M();
        m2176P(4);
    }

    /* renamed from: O */
    private void m2177O(boolean z) {
        int m2144a = C15480d.m2144a(getContext(), 1.0f);
        int m2144a2 = C15480d.m2144a(getContext(), 1.5f);
        int i = this.f44566u;
        if (i == 1) {
            m2144a = C15480d.m2144a(getContext(), 1.0f);
            m2144a2 = C15480d.m2144a(getContext(), -1.5f);
        } else if (i == 2) {
            m2144a = C15480d.m2144a(getContext(), -1.0f);
            m2144a2 = C15480d.m2144a(getContext(), -1.5f);
        } else if (i == 3) {
            m2144a = C15480d.m2144a(getContext(), -1.0f);
            m2144a2 = C15480d.m2144a(getContext(), 1.5f);
        } else if (i == 4) {
            m2144a = C15480d.m2144a(getContext(), 1.0f);
            m2144a2 = C15480d.m2144a(getContext(), 1.5f);
        }
        this.f44541J.setShadowLayer(z ? C15480d.m2144a(getContext(), 2.0f) : 0.0f, m2144a, m2144a2, 855638016);
    }

    /* renamed from: P */
    private void m2176P(int i) {
        Badge.InterfaceC15475a interfaceC15475a = this.f44544M;
        if (interfaceC15475a != null) {
            interfaceC15475a.m2149a(i, this, this.f44537F);
        }
    }

    private float getBadgeCircleRadius() {
        float width;
        float f;
        if (this.f44556k.isEmpty()) {
            return this.f44554i;
        }
        if (this.f44556k.length() == 1) {
            if (this.f44568w.height() > this.f44568w.width()) {
                width = this.f44568w.height() / 2.0f;
                f = this.f44554i;
            } else {
                width = this.f44568w.width() / 2.0f;
                f = this.f44554i;
            }
            return width + (f * 0.5f);
        }
        return this.f44569x.height() / 2.0f;
    }

    /* renamed from: M */
    public void m2179M() {
        PointF pointF = this.f44533B;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.f44566u = 4;
        m2178N(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    /* renamed from: N */
    protected void m2178N(boolean z) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z) {
            this.f44545N.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            mo2171c(this.f44537F);
        }
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: a */
    public float mo2173a(boolean z) {
        return z ? C15480d.m2143b(getContext(), this.f44553h) : this.f44553h;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: b */
    public boolean mo2172b() {
        return this.f44560o;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: c */
    public Badge mo2171c(View view) {
        if (view != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                this.f44537F = view;
                if (parent instanceof C15472a) {
                    ((C15472a) parent).addView(this);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    viewGroup.removeView(view);
                    C15472a c15472a = new C15472a(getContext());
                    if (viewGroup instanceof RelativeLayout) {
                        c15472a.setId(view.getId());
                    }
                    viewGroup.addView(c15472a, indexOfChild, layoutParams);
                    c15472a.addView(view);
                    c15472a.addView(this);
                }
                return this;
            }
            throw new IllegalStateException("targetView must have a parent");
        }
        throw new IllegalStateException("targetView can not be null");
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: d */
    public float mo2170d(boolean z) {
        return z ? C15480d.m2143b(getContext(), this.f44562q) : this.f44562q;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: e */
    public Badge mo2169e(String str) {
        this.f44556k = str;
        this.f44555j = 1;
        m2181K();
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: f */
    public float mo2168f(boolean z) {
        return z ? C15480d.m2143b(getContext(), this.f44563r) : this.f44563r;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: g */
    public Badge mo2167g(int i) {
        this.f44546a = i;
        if (i == 0) {
            this.f44540I.setXfermode(null);
        } else {
            this.f44540I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public Drawable getBadgeBackground() {
        return this.f44549d;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public int getBadgeBackgroundColor() {
        return this.f44546a;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public int getBadgeGravity() {
        return this.f44561p;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public int getBadgeNumber() {
        return this.f44555j;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public String getBadgeText() {
        return this.f44556k;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public int getBadgeTextColor() {
        return this.f44548c;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public PointF getDragCenter() {
        if (this.f44557l && this.f44558m) {
            return this.f44533B;
        }
        return null;
    }

    @Override // p635q.rorbin.badgeview.Badge
    public View getTargetView() {
        return this.f44537F;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: h */
    public void mo2166h(boolean z) {
        if (z && this.f44545N != null) {
            m2182J();
            m2175y(this.f44534C);
            return;
        }
        mo2156r(0);
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: i */
    public boolean mo2165i() {
        return this.f44557l;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: j */
    public Badge mo2164j(Badge.InterfaceC15475a interfaceC15475a) {
        this.f44557l = interfaceC15475a != null;
        this.f44544M = interfaceC15475a;
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: k */
    public float mo2163k(boolean z) {
        return z ? C15480d.m2143b(getContext(), this.f44554i) : this.f44554i;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: l */
    public boolean mo2162l() {
        return this.f44559n;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: m */
    public Badge mo2161m(int i) {
        this.f44548c = i;
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: n */
    public Badge mo2160n(float f, boolean z) {
        return mo2155s(f, f, z);
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: o */
    public Badge mo2159o(int i, float f, boolean z) {
        this.f44547b = i;
        if (z) {
            f = C15480d.m2144a(getContext(), f);
        }
        this.f44552g = f;
        invalidate();
        return this;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f44545N == null) {
            m2185G(this.f44537F);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        BadgeAnimator badgeAnimator = this.f44543L;
        if (badgeAnimator != null && badgeAnimator.isRunning()) {
            this.f44543L.m2147b(canvas);
        } else if (this.f44556k != null) {
            m2183I();
            float badgeCircleRadius = getBadgeCircleRadius();
            float m2141b = this.f44564s * (1.0f - (MathUtil.m2141b(this.f44534C, this.f44533B) / this.f44565t));
            if (this.f44557l && this.f44558m) {
                this.f44566u = MathUtil.m2140c(this.f44533B, this.f44534C);
                m2177O(this.f44560o);
                boolean z = m2141b < ((float) C15480d.m2144a(getContext(), 1.5f));
                this.f44567v = z;
                if (z) {
                    m2176P(3);
                    m2190B(canvas, this.f44533B, badgeCircleRadius);
                    return;
                }
                m2176P(2);
                m2188D(canvas, m2141b, badgeCircleRadius);
                m2190B(canvas, this.f44533B, badgeCircleRadius);
                return;
            }
            m2186F();
            m2190B(canvas, this.f44532A, badgeCircleRadius);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f44538G = i;
        this.f44539H = i2;
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
            boolean r0 = r6.f44558m
            if (r0 == 0) goto La8
            android.graphics.PointF r0 = r6.f44533B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.f44533B
            float r3 = r7.getRawY()
            r0.y = r3
            r6.invalidate()
            goto La8
        L31:
            int r0 = r7.getActionIndex()
            int r0 = r7.getPointerId(r0)
            if (r0 != 0) goto La8
            boolean r0 = r6.f44558m
            if (r0 == 0) goto La8
            r6.f44558m = r1
            r6.m2180L()
            goto La8
        L45:
            float r0 = r7.getX()
            float r3 = r7.getY()
            boolean r4 = r6.f44557l
            if (r4 == 0) goto La8
            int r4 = r7.getActionIndex()
            int r4 = r7.getPointerId(r4)
            if (r4 != 0) goto La8
            android.graphics.RectF r4 = r6.f44569x
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
            java.lang.String r0 = r6.f44556k
            if (r0 == 0) goto La8
            r6.m2182J()
            r6.f44558m = r2
            r6.m2176P(r2)
            android.content.Context r0 = r6.getContext()
            r3 = 1088421888(0x40e00000, float:7.0)
            int r0 = p635q.rorbin.badgeview.C15480d.m2144a(r0, r3)
            float r0 = (float) r0
            r6.f44564s = r0
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            r6.m2178N(r2)
            android.graphics.PointF r0 = r6.f44533B
            float r3 = r7.getRawX()
            r0.x = r3
            android.graphics.PointF r0 = r6.f44533B
            float r3 = r7.getRawY()
            r0.y = r3
        La8:
            boolean r0 = r6.f44558m
            if (r0 != 0) goto Lb2
            boolean r7 = super.onTouchEvent(r7)
            if (r7 == 0) goto Lb3
        Lb2:
            r1 = 1
        Lb3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p635q.rorbin.badgeview.QBadgeView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: p */
    public Badge mo2158p(int i) {
        if (i != 8388659 && i != 8388661 && i != 8388691 && i != 8388693 && i != 17 && i != 49 && i != 81 && i != 8388627 && i != 8388629) {
            throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
        }
        this.f44561p = i;
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: q */
    public Badge mo2157q(Drawable drawable) {
        return mo2150x(drawable, false);
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: r */
    public Badge mo2156r(int i) {
        this.f44555j = i;
        if (i < 0) {
            this.f44556k = "";
        } else if (i > 99) {
            this.f44556k = this.f44559n ? String.valueOf(i) : "99+";
        } else if (i > 0 && i <= 99) {
            this.f44556k = String.valueOf(i);
        } else if (i == 0) {
            this.f44556k = null;
        }
        m2181K();
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: s */
    public Badge mo2155s(float f, float f2, boolean z) {
        if (z) {
            f = C15480d.m2144a(getContext(), f);
        }
        this.f44562q = f;
        if (z) {
            f2 = C15480d.m2144a(getContext(), f2);
        }
        this.f44563r = f2;
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: t */
    public Badge mo2154t(boolean z) {
        this.f44560o = z;
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: u */
    public Badge mo2153u(boolean z) {
        this.f44559n = z;
        int i = this.f44555j;
        if (i > 99) {
            mo2156r(i);
        }
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: v */
    public Badge mo2152v(float f, boolean z) {
        if (z) {
            f = C15480d.m2144a(getContext(), f);
        }
        this.f44554i = f;
        m2191A();
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: w */
    public Badge mo2151w(float f, boolean z) {
        if (z) {
            f = C15480d.m2144a(getContext(), f);
        }
        this.f44553h = f;
        m2181K();
        invalidate();
        return this;
    }

    @Override // p635q.rorbin.badgeview.Badge
    /* renamed from: x */
    public Badge mo2150x(Drawable drawable, boolean z) {
        this.f44551f = z;
        this.f44549d = drawable;
        m2191A();
        invalidate();
        return this;
    }

    /* renamed from: y */
    protected void m2175y(PointF pointF) {
        if (this.f44556k == null) {
            return;
        }
        BadgeAnimator badgeAnimator = this.f44543L;
        if (badgeAnimator == null || !badgeAnimator.isRunning()) {
            m2178N(true);
            BadgeAnimator badgeAnimator2 = new BadgeAnimator(m2174z(), pointF, this);
            this.f44543L = badgeAnimator2;
            badgeAnimator2.start();
            mo2156r(0);
        }
    }

    /* renamed from: z */
    protected Bitmap m2174z() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.f44569x.width()) + C15480d.m2144a(getContext(), 3.0f), ((int) this.f44569x.height()) + C15480d.m2144a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        m2190B(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    private QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private QBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2184H();
    }
}
