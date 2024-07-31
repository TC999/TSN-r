package p635q.rorbin.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* renamed from: q.rorbin.badgeview.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class BadgeAnimator extends ValueAnimator {

    /* renamed from: a */
    private C15478c[][] f44578a;

    /* renamed from: b */
    private WeakReference<QBadgeView> f44579b;

    /* compiled from: BadgeAnimator.java */
    /* renamed from: q.rorbin.badgeview.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15476a implements ValueAnimator.AnimatorUpdateListener {
        C15476a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QBadgeView qBadgeView = (QBadgeView) BadgeAnimator.this.f44579b.get();
            if (qBadgeView != null && qBadgeView.isShown()) {
                qBadgeView.invalidate();
            } else {
                BadgeAnimator.this.cancel();
            }
        }
    }

    /* compiled from: BadgeAnimator.java */
    /* renamed from: q.rorbin.badgeview.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15477b extends AnimatorListenerAdapter {
        C15477b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QBadgeView qBadgeView = (QBadgeView) BadgeAnimator.this.f44579b.get();
            if (qBadgeView != null) {
                qBadgeView.m2179M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BadgeAnimator.java */
    /* renamed from: q.rorbin.badgeview.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15478c {

        /* renamed from: a */
        Random f44582a;

        /* renamed from: b */
        float f44583b;

        /* renamed from: c */
        float f44584c;

        /* renamed from: d */
        float f44585d;

        /* renamed from: e */
        int f44586e;

        /* renamed from: f */
        int f44587f;

        /* renamed from: g */
        Paint f44588g;

        public C15478c() {
            Paint paint = new Paint();
            this.f44588g = paint;
            paint.setAntiAlias(true);
            this.f44588g.setStyle(Paint.Style.FILL);
            this.f44582a = new Random();
        }

        /* renamed from: a */
        public void m2145a(float f, Canvas canvas) {
            this.f44588g.setColor(this.f44586e);
            this.f44583b += this.f44582a.nextInt(this.f44587f) * 0.1f * (this.f44582a.nextFloat() - 0.5f);
            float nextInt = this.f44584c + (this.f44582a.nextInt(this.f44587f) * 0.1f * (this.f44582a.nextFloat() - 0.5f));
            this.f44584c = nextInt;
            float f2 = this.f44583b;
            float f3 = this.f44585d;
            canvas.drawCircle(f2, nextInt, f3 - (f * f3), this.f44588g);
        }
    }

    public BadgeAnimator(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        this.f44579b = new WeakReference<>(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f44578a = m2146c(bitmap, pointF);
        addUpdateListener(new C15476a());
        addListener(new C15477b());
    }

    /* renamed from: c */
    private C15478c[][] m2146c(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        C15478c[][] c15478cArr = (C15478c[][]) Array.newInstance(C15478c.class, (int) (height / min), (int) (width / min));
        for (int i = 0; i < c15478cArr.length; i++) {
            for (int i2 = 0; i2 < c15478cArr[i].length; i2++) {
                C15478c c15478c = new C15478c();
                float f = i2 * min;
                float f2 = i * min;
                c15478c.f44586e = bitmap.getPixel((int) f, (int) f2);
                c15478c.f44583b = f + width2;
                c15478c.f44584c = f2 + height2;
                c15478c.f44585d = min;
                c15478c.f44587f = Math.max(width, height);
                c15478cArr[i][i2] = c15478c;
            }
        }
        bitmap.recycle();
        return c15478cArr;
    }

    /* renamed from: b */
    public void m2147b(Canvas canvas) {
        for (int i = 0; i < this.f44578a.length; i++) {
            int i2 = 0;
            while (true) {
                C15478c[][] c15478cArr = this.f44578a;
                if (i2 < c15478cArr[i].length) {
                    c15478cArr[i][i2].m2145a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i2++;
                }
            }
        }
    }
}
