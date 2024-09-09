package com.bxkj.student.run.app.utils;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bxkj.student.run.app.utils.q;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RecordPathView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Context f22722a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f22723b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f22724c;

    /* renamed from: d  reason: collision with root package name */
    private Path f22725d;

    /* renamed from: e  reason: collision with root package name */
    private Path f22726e;

    /* renamed from: f  reason: collision with root package name */
    private PathMeasure f22727f;

    /* renamed from: g  reason: collision with root package name */
    private PathMeasure f22728g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22729h;

    /* renamed from: i  reason: collision with root package name */
    private float f22730i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f22731j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f22732k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f22733l;

    /* renamed from: m  reason: collision with root package name */
    private Canvas f22734m;

    /* renamed from: n  reason: collision with root package name */
    private float[] f22735n;

    /* renamed from: o  reason: collision with root package name */
    private float[] f22736o;

    /* renamed from: p  reason: collision with root package name */
    private float[] f22737p;

    /* renamed from: q  reason: collision with root package name */
    private float f22738q;

    /* renamed from: r  reason: collision with root package name */
    private long f22739r;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<q.a> f22740s;

    /* renamed from: t  reason: collision with root package name */
    private d f22741t;

    /* renamed from: u  reason: collision with root package name */
    private int f22742u;

    /* renamed from: v  reason: collision with root package name */
    private int f22743v;

    /* renamed from: w  reason: collision with root package name */
    float f22744w;

    /* renamed from: x  reason: collision with root package name */
    float f22745x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            RecordPathView.this.f22738q = ((Float) animation.getAnimatedValue()).floatValue();
            RecordPathView.this.d();
            RecordPathView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (RecordPathView.this.f22741t != null) {
                RecordPathView.this.f22741t.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements TypeEvaluator {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return Float.valueOf(fraction);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface d {
        void a();
    }

    public RecordPathView(Context context) {
        super(context);
        this.f22729h = false;
        this.f22735n = new float[2];
        this.f22736o = new float[2];
        this.f22737p = new float[2];
        this.f22738q = 0.0f;
        this.f22722a = context;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        float f4;
        float f5 = this.f22738q * this.f22730i;
        int size = this.f22740s.size();
        int i4 = 0;
        float f6 = 0.0f;
        while (true) {
            if (i4 >= size) {
                f4 = 0.0f;
                break;
            }
            f6 += this.f22740s.get(i4).e();
            if (f6 > f5) {
                this.f22742u = i4;
                f4 = f6 - f5;
                break;
            }
            i4++;
        }
        this.f22725d.reset();
        new PathMeasure(this.f22740s.get(this.f22742u).d(), false).getSegment(0.0f, this.f22740s.get(this.f22742u).e() - f4, this.f22725d, true);
        PathMeasure pathMeasure = new PathMeasure(this.f22725d, false);
        this.f22728g = pathMeasure;
        pathMeasure.getPosTan(pathMeasure.getLength(), this.f22737p, null);
    }

    private void f() {
        Paint paint = new Paint();
        this.f22723b = paint;
        paint.setAntiAlias(true);
        this.f22723b.setStyle(Paint.Style.STROKE);
        this.f22723b.setStrokeWidth(10.0f);
        Paint paint2 = new Paint();
        this.f22724c = paint2;
        paint2.setAntiAlias(true);
        this.f22725d = new Path();
        this.f22731j = BitmapFactory.decodeResource(this.f22722a.getResources(), 2131558610);
        this.f22732k = BitmapFactory.decodeResource(this.f22722a.getResources(), 2131558990);
    }

    private void g() {
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), 0, Float.valueOf(this.f22727f.getLength()));
        ofObject.setDuration(this.f22739r);
        ofObject.setInterpolator(new AccelerateDecelerateInterpolator());
        ofObject.addUpdateListener(new a());
        ofObject.addListener(new b());
        ofObject.start();
    }

    public void e() {
        this.f22725d = new Path();
        Bitmap bitmap = this.f22731j;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22731j = null;
        }
        Bitmap bitmap2 = this.f22732k;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f22732k = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<q.a> arrayList = this.f22740s;
        if (arrayList == null || arrayList.size() == 0 || this.f22738q >= 1.0f) {
            return;
        }
        if (this.f22733l == null) {
            this.f22733l = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            this.f22734m = new Canvas(this.f22733l);
        }
        this.f22734m.save();
        int i4 = this.f22742u;
        int i5 = this.f22743v;
        if (i4 > i5 && i5 > 0) {
            for (int i6 = i5 - 1; i6 < this.f22742u; i6++) {
                q.a aVar = this.f22740s.get(i6);
                this.f22723b.setColor(aVar.a());
                this.f22723b.setShader(aVar.f());
                this.f22723b.setStrokeWidth(10.0f);
                this.f22723b.setStyle(Paint.Style.STROKE);
                this.f22734m.drawPath(aVar.d(), this.f22723b);
                this.f22723b.setShader(null);
                this.f22723b.setStrokeWidth(1.0f);
                this.f22723b.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f22734m.drawCircle(aVar.b().x, aVar.b().y, 5.0f, this.f22723b);
            }
        }
        this.f22734m.restore();
        canvas.drawBitmap(this.f22733l, 0.0f, 0.0f, this.f22724c);
        this.f22723b.setStyle(Paint.Style.STROKE);
        this.f22723b.setShader(this.f22740s.get(this.f22742u).f());
        this.f22723b.setStrokeWidth(10.0f);
        canvas.drawPath(this.f22725d, this.f22723b);
        Bitmap bitmap = this.f22732k;
        canvas.drawBitmap(bitmap, this.f22737p[0] - (bitmap.getWidth() / 2), this.f22737p[1] - (this.f22732k.getHeight() / 2), this.f22724c);
        int i7 = this.f22743v;
        int i8 = this.f22742u;
        if (i7 != i8) {
            this.f22743v = i8;
        }
    }

    public void setOnAnimEnd(d onAnimEnd) {
        this.f22741t = onAnimEnd;
    }

    public void setPath(q recordPathAnimUtil) {
        if (recordPathAnimUtil == null || this.f22729h) {
            return;
        }
        this.f22730i = recordPathAnimUtil.d();
        this.f22739r = recordPathAnimUtil.c();
        this.f22740s = recordPathAnimUtil.e();
        this.f22726e = recordPathAnimUtil.f();
        PathMeasure pathMeasure = new PathMeasure(this.f22726e, false);
        this.f22727f = pathMeasure;
        pathMeasure.getPosTan(0.0f, this.f22735n, null);
        PathMeasure pathMeasure2 = this.f22727f;
        pathMeasure2.getPosTan(pathMeasure2.getLength(), this.f22736o, null);
        ArrayList<q.a> arrayList = this.f22740s;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        g();
        this.f22729h = true;
    }

    public RecordPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f22729h = false;
        this.f22735n = new float[2];
        this.f22736o = new float[2];
        this.f22737p = new float[2];
        this.f22738q = 0.0f;
        this.f22722a = context;
        f();
    }

    public RecordPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f22729h = false;
        this.f22735n = new float[2];
        this.f22736o = new float[2];
        this.f22737p = new float[2];
        this.f22738q = 0.0f;
        this.f22722a = context;
        f();
    }
}
