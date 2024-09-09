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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SportTrailView extends View {

    /* renamed from: l  reason: collision with root package name */
    public static final int f22749l = Color.rgb(124, (int) MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 0);

    /* renamed from: m  reason: collision with root package name */
    public static final int f22750m = 10;

    /* renamed from: a  reason: collision with root package name */
    private Paint f22751a;

    /* renamed from: b  reason: collision with root package name */
    private Point f22752b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f22753c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f22754d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f22755e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f22756f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f22757g;

    /* renamed from: h  reason: collision with root package name */
    private int f22758h;

    /* renamed from: i  reason: collision with root package name */
    private int f22759i;

    /* renamed from: j  reason: collision with root package name */
    private Path f22760j;

    /* renamed from: k  reason: collision with root package name */
    private float[] f22761k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PathMeasure f22762a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f22763b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f22764c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f22765d;

        a(final PathMeasure val$pathMeasure, final List val$mPositions, final float val$length, final b val$listener) {
            this.f22762a = val$pathMeasure;
            this.f22763b = val$mPositions;
            this.f22764c = val$length;
            this.f22765d = val$listener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            b bVar;
            float floatValue = ((Float) animation.getAnimatedValue()).floatValue();
            this.f22762a.getPosTan(floatValue, SportTrailView.this.f22761k, null);
            if (floatValue == 0.0f) {
                SportTrailView.this.f22760j.moveTo(((Point) this.f22763b.get(0)).x, ((Point) this.f22763b.get(0)).y);
            }
            this.f22762a.getSegment(0.0f, floatValue, SportTrailView.this.f22760j, true);
            SportTrailView.this.invalidate();
            if (floatValue != this.f22764c || (bVar = this.f22765d) == null) {
                return;
            }
            bVar.onFinish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface b {
        void onFinish();
    }

    public SportTrailView(Context context) {
        this(context, null);
    }

    private void e() {
        Paint paint = new Paint();
        this.f22754d = paint;
        paint.setColor(f22749l);
        this.f22754d.setStyle(Paint.Style.STROKE);
        this.f22754d.setStrokeWidth(10.0f);
        this.f22754d.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22755e = paint2;
        paint2.setAntiAlias(true);
        this.f22755e.setFilterBitmap(true);
        Paint paint3 = new Paint();
        this.f22751a = paint3;
        paint3.setAntiAlias(true);
        this.f22751a.setFilterBitmap(true);
        this.f22760j = new Path();
    }

    public void c() {
        this.f22760j = new Path();
        Bitmap bitmap = this.f22756f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22756f = null;
        }
        Bitmap bitmap2 = this.f22753c;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f22753c = null;
        }
        invalidate();
    }

    public void d(final List<Point> mPositions, @DrawableRes int startPointResId, @DrawableRes int lightBall, final b listener) {
        if (mPositions.size() <= 1) {
            listener.onFinish();
            return;
        }
        Path path = new Path();
        for (int i4 = 0; i4 < mPositions.size(); i4++) {
            if (i4 == 0) {
                path.moveTo(mPositions.get(i4).x, mPositions.get(i4).y);
            } else {
                path.lineTo(mPositions.get(i4).x, mPositions.get(i4).y);
            }
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        if (length < r.a(getContext(), 16.0f)) {
            listener.onFinish();
            return;
        }
        this.f22756f = BitmapFactory.decodeResource(getResources(), lightBall);
        this.f22752b = new Point(mPositions.get(0).x, mPositions.get(0).y);
        this.f22753c = BitmapDescriptorFactory.fromResource(startPointResId).getBitmap();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, length);
        ofFloat.setDuration(3000L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a(pathMeasure, mPositions, length, listener));
        ofFloat.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f22760j, this.f22754d);
        Bitmap bitmap = this.f22756f;
        if (bitmap != null && this.f22757g != null) {
            int width = bitmap.getWidth();
            int height = this.f22756f.getHeight();
            RectF rectF = new RectF();
            float[] fArr = this.f22761k;
            float f4 = width;
            rectF.left = fArr[0] - f4;
            rectF.right = fArr[0] + f4;
            float f5 = height;
            rectF.top = fArr[1] - f5;
            rectF.bottom = fArr[1] + f5;
            canvas.drawBitmap(this.f22756f, (Rect) null, rectF, this.f22755e);
        }
        Bitmap bitmap2 = this.f22753c;
        if (bitmap2 == null || this.f22752b == null) {
            return;
        }
        if (this.f22757g == null) {
            int width2 = bitmap2.getWidth() / 2;
            int height2 = this.f22753c.getHeight();
            Rect rect = new Rect();
            this.f22757g = rect;
            Point point = this.f22752b;
            int i4 = point.x;
            rect.left = i4 - width2;
            rect.right = i4 + width2;
            int i5 = point.y;
            rect.top = i5 - height2;
            rect.bottom = i5;
        }
        canvas.drawBitmap(this.f22753c, (Rect) null, this.f22757g, this.f22751a);
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f22761k = new float[2];
        e();
    }
}
