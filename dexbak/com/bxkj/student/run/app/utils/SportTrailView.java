package com.bxkj.student.run.app.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SportTrailView extends View {

    /* renamed from: l */
    public static final int f19519l = Color.rgb(124, 252, 0);

    /* renamed from: m */
    public static final int f19520m = 10;

    /* renamed from: a */
    private Paint f19521a;

    /* renamed from: b */
    private Point f19522b;

    /* renamed from: c */
    private Bitmap f19523c;

    /* renamed from: d */
    private Paint f19524d;

    /* renamed from: e */
    private Paint f19525e;

    /* renamed from: f */
    private Bitmap f19526f;

    /* renamed from: g */
    private Rect f19527g;

    /* renamed from: h */
    private int f19528h;

    /* renamed from: i */
    private int f19529i;

    /* renamed from: j */
    private Path f19530j;

    /* renamed from: k */
    private float[] f19531k;

    /* renamed from: com.bxkj.student.run.app.utils.SportTrailView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5376a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ PathMeasure f19532a;

        /* renamed from: b */
        final /* synthetic */ List f19533b;

        /* renamed from: c */
        final /* synthetic */ float f19534c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC5377b f19535d;

        C5376a(final PathMeasure val$pathMeasure, final List val$mPositions, final float val$length, final InterfaceC5377b val$listener) {
            this.f19532a = val$pathMeasure;
            this.f19533b = val$mPositions;
            this.f19534c = val$length;
            this.f19535d = val$listener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            InterfaceC5377b interfaceC5377b;
            float floatValue = ((Float) animation.getAnimatedValue()).floatValue();
            this.f19532a.getPosTan(floatValue, SportTrailView.this.f19531k, null);
            if (floatValue == 0.0f) {
                SportTrailView.this.f19530j.moveTo(((Point) this.f19533b.get(0)).x, ((Point) this.f19533b.get(0)).y);
            }
            this.f19532a.getSegment(0.0f, floatValue, SportTrailView.this.f19530j, true);
            SportTrailView.this.invalidate();
            if (floatValue != this.f19534c || (interfaceC5377b = this.f19535d) == null) {
                return;
            }
            interfaceC5377b.onFinish();
        }
    }

    /* renamed from: com.bxkj.student.run.app.utils.SportTrailView$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5377b {
        void onFinish();
    }

    public SportTrailView(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    private void m39695e() {
        Paint paint = new Paint();
        this.f19524d = paint;
        paint.setColor(f19519l);
        this.f19524d.setStyle(Paint.Style.STROKE);
        this.f19524d.setStrokeWidth(10.0f);
        this.f19524d.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f19525e = paint2;
        paint2.setAntiAlias(true);
        this.f19525e.setFilterBitmap(true);
        Paint paint3 = new Paint();
        this.f19521a = paint3;
        paint3.setAntiAlias(true);
        this.f19521a.setFilterBitmap(true);
        this.f19530j = new Path();
    }

    /* renamed from: c */
    public void m39697c() {
        this.f19530j = new Path();
        Bitmap bitmap = this.f19526f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f19526f = null;
        }
        Bitmap bitmap2 = this.f19523c;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f19523c = null;
        }
        invalidate();
    }

    /* renamed from: d */
    public void m39696d(final List<Point> mPositions, @DrawableRes int startPointResId, @DrawableRes int lightBall, final InterfaceC5377b listener) {
        if (mPositions.size() <= 1) {
            listener.onFinish();
            return;
        }
        Path path = new Path();
        for (int i = 0; i < mPositions.size(); i++) {
            if (i == 0) {
                path.moveTo(mPositions.get(i).x, mPositions.get(i).y);
            } else {
                path.lineTo(mPositions.get(i).x, mPositions.get(i).y);
            }
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        if (length < ScreenUtil.m39538a(getContext(), 16.0f)) {
            listener.onFinish();
            return;
        }
        this.f19526f = BitmapFactory.decodeResource(getResources(), lightBall);
        this.f19522b = new Point(mPositions.get(0).x, mPositions.get(0).y);
        this.f19523c = BitmapDescriptorFactory.fromResource(startPointResId).getBitmap();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, length);
        ofFloat.setDuration(3000L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new C5376a(pathMeasure, mPositions, length, listener));
        ofFloat.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f19530j, this.f19524d);
        Bitmap bitmap = this.f19526f;
        if (bitmap != null && this.f19527g != null) {
            int width = bitmap.getWidth();
            int height = this.f19526f.getHeight();
            RectF rectF = new RectF();
            float[] fArr = this.f19531k;
            float f = width;
            rectF.left = fArr[0] - f;
            rectF.right = fArr[0] + f;
            float f2 = height;
            rectF.top = fArr[1] - f2;
            rectF.bottom = fArr[1] + f2;
            canvas.drawBitmap(this.f19526f, (Rect) null, rectF, this.f19525e);
        }
        Bitmap bitmap2 = this.f19523c;
        if (bitmap2 == null || this.f19522b == null) {
            return;
        }
        if (this.f19527g == null) {
            int width2 = bitmap2.getWidth() / 2;
            int height2 = this.f19523c.getHeight();
            Rect rect = new Rect();
            this.f19527g = rect;
            Point point = this.f19522b;
            int i = point.x;
            rect.left = i - width2;
            rect.right = i + width2;
            int i2 = point.y;
            rect.top = i2 - height2;
            rect.bottom = i2;
        }
        canvas.drawBitmap(this.f19523c, (Rect) null, this.f19527g, this.f19521a);
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f19531k = new float[2];
        m39695e();
    }
}
