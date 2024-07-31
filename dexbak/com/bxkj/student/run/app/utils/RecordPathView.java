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
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.utils.RecordPathAnimUtil;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RecordPathView extends View {

    /* renamed from: a */
    private Context f19492a;

    /* renamed from: b */
    private Paint f19493b;

    /* renamed from: c */
    private Paint f19494c;

    /* renamed from: d */
    private Path f19495d;

    /* renamed from: e */
    private Path f19496e;

    /* renamed from: f */
    private PathMeasure f19497f;

    /* renamed from: g */
    private PathMeasure f19498g;

    /* renamed from: h */
    private boolean f19499h;

    /* renamed from: i */
    private float f19500i;

    /* renamed from: j */
    private Bitmap f19501j;

    /* renamed from: k */
    private Bitmap f19502k;

    /* renamed from: l */
    private Bitmap f19503l;

    /* renamed from: m */
    private Canvas f19504m;

    /* renamed from: n */
    private float[] f19505n;

    /* renamed from: o */
    private float[] f19506o;

    /* renamed from: p */
    private float[] f19507p;

    /* renamed from: q */
    private float f19508q;

    /* renamed from: r */
    private long f19509r;

    /* renamed from: s */
    private ArrayList<RecordPathAnimUtil.C5404a> f19510s;

    /* renamed from: t */
    private InterfaceC5375d f19511t;

    /* renamed from: u */
    private int f19512u;

    /* renamed from: v */
    private int f19513v;

    /* renamed from: w */
    float f19514w;

    /* renamed from: x */
    float f19515x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.utils.RecordPathView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5372a implements ValueAnimator.AnimatorUpdateListener {
        C5372a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            RecordPathView.this.f19508q = ((Float) animation.getAnimatedValue()).floatValue();
            RecordPathView.this.m39703d();
            RecordPathView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.utils.RecordPathView$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5373b implements Animator.AnimatorListener {
        C5373b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (RecordPathView.this.f19511t != null) {
                RecordPathView.this.f19511t.mo38387a();
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
    /* renamed from: com.bxkj.student.run.app.utils.RecordPathView$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5374c implements TypeEvaluator {
        C5374c() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return Float.valueOf(fraction);
        }
    }

    /* renamed from: com.bxkj.student.run.app.utils.RecordPathView$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5375d {
        /* renamed from: a */
        void mo38387a();
    }

    public RecordPathView(Context context) {
        super(context);
        this.f19499h = false;
        this.f19505n = new float[2];
        this.f19506o = new float[2];
        this.f19507p = new float[2];
        this.f19508q = 0.0f;
        this.f19492a = context;
        m39701f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m39703d() {
        float f;
        float f2 = this.f19508q * this.f19500i;
        int size = this.f19510s.size();
        int i = 0;
        float f3 = 0.0f;
        while (true) {
            if (i >= size) {
                f = 0.0f;
                break;
            }
            f3 += this.f19510s.get(i).m39543e();
            if (f3 > f2) {
                this.f19512u = i;
                f = f3 - f2;
                break;
            }
            i++;
        }
        this.f19495d.reset();
        new PathMeasure(this.f19510s.get(this.f19512u).m39544d(), false).getSegment(0.0f, this.f19510s.get(this.f19512u).m39543e() - f, this.f19495d, true);
        PathMeasure pathMeasure = new PathMeasure(this.f19495d, false);
        this.f19498g = pathMeasure;
        pathMeasure.getPosTan(pathMeasure.getLength(), this.f19507p, null);
    }

    /* renamed from: f */
    private void m39701f() {
        Paint paint = new Paint();
        this.f19493b = paint;
        paint.setAntiAlias(true);
        this.f19493b.setStyle(Paint.Style.STROKE);
        this.f19493b.setStrokeWidth(10.0f);
        Paint paint2 = new Paint();
        this.f19494c = paint2;
        paint2.setAntiAlias(true);
        this.f19495d = new Path();
        this.f19501j = BitmapFactory.decodeResource(this.f19492a.getResources(), C4215R.mipmap.ic_marker_start);
        this.f19502k = BitmapFactory.decodeResource(this.f19492a.getResources(), C4215R.mipmap.speed_view_point);
    }

    /* renamed from: g */
    private void m39700g() {
        ValueAnimator ofObject = ValueAnimator.ofObject(new C5374c(), 0, Float.valueOf(this.f19497f.getLength()));
        ofObject.setDuration(this.f19509r);
        ofObject.setInterpolator(new AccelerateDecelerateInterpolator());
        ofObject.addUpdateListener(new C5372a());
        ofObject.addListener(new C5373b());
        ofObject.start();
    }

    /* renamed from: e */
    public void m39702e() {
        this.f19495d = new Path();
        Bitmap bitmap = this.f19501j;
        if (bitmap != null) {
            bitmap.recycle();
            this.f19501j = null;
        }
        Bitmap bitmap2 = this.f19502k;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f19502k = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<RecordPathAnimUtil.C5404a> arrayList = this.f19510s;
        if (arrayList == null || arrayList.size() == 0 || this.f19508q >= 1.0f) {
            return;
        }
        if (this.f19503l == null) {
            this.f19503l = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            this.f19504m = new Canvas(this.f19503l);
        }
        this.f19504m.save();
        int i = this.f19512u;
        int i2 = this.f19513v;
        if (i > i2 && i2 > 0) {
            for (int i3 = i2 - 1; i3 < this.f19512u; i3++) {
                RecordPathAnimUtil.C5404a c5404a = this.f19510s.get(i3);
                this.f19493b.setColor(c5404a.m39547a());
                this.f19493b.setShader(c5404a.m39542f());
                this.f19493b.setStrokeWidth(10.0f);
                this.f19493b.setStyle(Paint.Style.STROKE);
                this.f19504m.drawPath(c5404a.m39544d(), this.f19493b);
                this.f19493b.setShader(null);
                this.f19493b.setStrokeWidth(1.0f);
                this.f19493b.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f19504m.drawCircle(c5404a.m39546b().x, c5404a.m39546b().y, 5.0f, this.f19493b);
            }
        }
        this.f19504m.restore();
        canvas.drawBitmap(this.f19503l, 0.0f, 0.0f, this.f19494c);
        this.f19493b.setStyle(Paint.Style.STROKE);
        this.f19493b.setShader(this.f19510s.get(this.f19512u).m39542f());
        this.f19493b.setStrokeWidth(10.0f);
        canvas.drawPath(this.f19495d, this.f19493b);
        Bitmap bitmap = this.f19502k;
        canvas.drawBitmap(bitmap, this.f19507p[0] - (bitmap.getWidth() / 2), this.f19507p[1] - (this.f19502k.getHeight() / 2), this.f19494c);
        int i4 = this.f19513v;
        int i5 = this.f19512u;
        if (i4 != i5) {
            this.f19513v = i5;
        }
    }

    public void setOnAnimEnd(InterfaceC5375d onAnimEnd) {
        this.f19511t = onAnimEnd;
    }

    public void setPath(RecordPathAnimUtil recordPathAnimUtil) {
        if (recordPathAnimUtil == null || this.f19499h) {
            return;
        }
        this.f19500i = recordPathAnimUtil.m39551d();
        this.f19509r = recordPathAnimUtil.m39552c();
        this.f19510s = recordPathAnimUtil.m39550e();
        this.f19496e = recordPathAnimUtil.m39549f();
        PathMeasure pathMeasure = new PathMeasure(this.f19496e, false);
        this.f19497f = pathMeasure;
        pathMeasure.getPosTan(0.0f, this.f19505n, null);
        PathMeasure pathMeasure2 = this.f19497f;
        pathMeasure2.getPosTan(pathMeasure2.getLength(), this.f19506o, null);
        ArrayList<RecordPathAnimUtil.C5404a> arrayList = this.f19510s;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        m39700g();
        this.f19499h = true;
    }

    public RecordPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f19499h = false;
        this.f19505n = new float[2];
        this.f19506o = new float[2];
        this.f19507p = new float[2];
        this.f19508q = 0.0f;
        this.f19492a = context;
        m39701f();
    }

    public RecordPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f19499h = false;
        this.f19505n = new float[2];
        this.f19506o = new float[2];
        this.f19507p = new float[2];
        this.f19508q = 0.0f;
        this.f19492a = context;
        m39701f();
    }
}
