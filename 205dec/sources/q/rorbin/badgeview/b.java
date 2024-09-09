package q.rorbin.badgeview;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BadgeAnimator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private c[][] f61982a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<QBadgeView> f61983b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BadgeAnimator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QBadgeView qBadgeView = (QBadgeView) b.this.f61983b.get();
            if (qBadgeView != null && qBadgeView.isShown()) {
                qBadgeView.invalidate();
            } else {
                b.this.cancel();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BadgeAnimator.java */
    /* renamed from: q.rorbin.badgeview.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class C1257b extends AnimatorListenerAdapter {
        C1257b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QBadgeView qBadgeView = (QBadgeView) b.this.f61983b.get();
            if (qBadgeView != null) {
                qBadgeView.M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BadgeAnimator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        Random f61986a;

        /* renamed from: b  reason: collision with root package name */
        float f61987b;

        /* renamed from: c  reason: collision with root package name */
        float f61988c;

        /* renamed from: d  reason: collision with root package name */
        float f61989d;

        /* renamed from: e  reason: collision with root package name */
        int f61990e;

        /* renamed from: f  reason: collision with root package name */
        int f61991f;

        /* renamed from: g  reason: collision with root package name */
        Paint f61992g;

        public c() {
            Paint paint = new Paint();
            this.f61992g = paint;
            paint.setAntiAlias(true);
            this.f61992g.setStyle(Paint.Style.FILL);
            this.f61986a = new Random();
        }

        public void a(float f4, Canvas canvas) {
            this.f61992g.setColor(this.f61990e);
            this.f61987b += this.f61986a.nextInt(this.f61991f) * 0.1f * (this.f61986a.nextFloat() - 0.5f);
            float nextInt = this.f61988c + (this.f61986a.nextInt(this.f61991f) * 0.1f * (this.f61986a.nextFloat() - 0.5f));
            this.f61988c = nextInt;
            float f5 = this.f61987b;
            float f6 = this.f61989d;
            canvas.drawCircle(f5, nextInt, f6 - (f4 * f6), this.f61992g);
        }
    }

    public b(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        this.f61983b = new WeakReference<>(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f61982a = c(bitmap, pointF);
        addUpdateListener(new a());
        addListener(new C1257b());
    }

    private c[][] c(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        c[][] cVarArr = (c[][]) Array.newInstance(c.class, (int) (height / min), (int) (width / min));
        for (int i4 = 0; i4 < cVarArr.length; i4++) {
            for (int i5 = 0; i5 < cVarArr[i4].length; i5++) {
                c cVar = new c();
                float f4 = i5 * min;
                float f5 = i4 * min;
                cVar.f61990e = bitmap.getPixel((int) f4, (int) f5);
                cVar.f61987b = f4 + width2;
                cVar.f61988c = f5 + height2;
                cVar.f61989d = min;
                cVar.f61991f = Math.max(width, height);
                cVarArr[i4][i5] = cVar;
            }
        }
        bitmap.recycle();
        return cVarArr;
    }

    public void b(Canvas canvas) {
        for (int i4 = 0; i4 < this.f61982a.length; i4++) {
            int i5 = 0;
            while (true) {
                c[][] cVarArr = this.f61982a;
                if (i5 < cVarArr[i4].length) {
                    cVarArr[i4][i5].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i5++;
                }
            }
        }
    }
}
