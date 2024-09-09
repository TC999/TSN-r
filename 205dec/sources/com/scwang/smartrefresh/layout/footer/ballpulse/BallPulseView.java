package com.scwang.smartrefresh.layout.footer.ballpulse;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BallPulseView extends View {

    /* renamed from: i  reason: collision with root package name */
    public static final int f47948i = 50;

    /* renamed from: a  reason: collision with root package name */
    private Paint f47949a;

    /* renamed from: b  reason: collision with root package name */
    private int f47950b;

    /* renamed from: c  reason: collision with root package name */
    private int f47951c;

    /* renamed from: d  reason: collision with root package name */
    private float f47952d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f47953e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f47954f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ValueAnimator> f47955g;

    /* renamed from: h  reason: collision with root package name */
    private Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f47956h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f47957a;

        a(int i4) {
            this.f47957a = i4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseView.this.f47953e[this.f47957a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BallPulseView.this.postInvalidate();
        }
    }

    public BallPulseView(Context context) {
        this(context, null);
    }

    private void b() {
        this.f47955g = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i4 = 0; i4 < 3; i4++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i4]);
            this.f47956h.put(ofFloat, new a(i4));
            this.f47955g.add(ofFloat);
        }
    }

    private boolean c() {
        return this.f47954f;
    }

    public void d() {
        if (this.f47955g == null) {
            b();
        }
        if (this.f47955g == null || c()) {
            return;
        }
        for (int i4 = 0; i4 < this.f47955g.size(); i4++) {
            ValueAnimator valueAnimator = this.f47955g.get(i4);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f47956h.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f47954f = true;
        setIndicatorColor(this.f47951c);
    }

    public void e() {
        ArrayList<ValueAnimator> arrayList = this.f47955g;
        if (arrayList != null && this.f47954f) {
            this.f47954f = false;
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
            this.f47953e = new float[]{1.0f, 1.0f, 1.0f};
        }
        setIndicatorColor(this.f47950b);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f47955g != null) {
            for (int i4 = 0; i4 < this.f47955g.size(); i4++) {
                this.f47955g.get(i4).cancel();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float min = (Math.min(getWidth(), getHeight()) - (this.f47952d * 2.0f)) / 6.0f;
        float f4 = 2.0f * min;
        float width = (getWidth() / 2) - (this.f47952d + f4);
        float height = getHeight() / 2;
        for (int i4 = 0; i4 < 3; i4++) {
            canvas.save();
            float f5 = i4;
            canvas.translate((f4 * f5) + width + (this.f47952d * f5), height);
            float[] fArr = this.f47953e;
            canvas.scale(fArr[i4], fArr[i4]);
            canvas.drawCircle(0.0f, 0.0f, min, this.f47949a);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int b4 = c.b(50.0f);
        setMeasuredDimension(View.resolveSize(b4, i4), View.resolveSize(b4, i5));
    }

    public void setAnimatingColor(@ColorInt int i4) {
        this.f47951c = i4;
    }

    public void setIndicatorColor(@ColorInt int i4) {
        this.f47949a.setColor(i4);
    }

    public void setNormalColor(@ColorInt int i4) {
        this.f47950b = i4;
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47950b = -1118482;
        this.f47951c = -1615546;
        this.f47953e = new float[]{1.0f, 1.0f, 1.0f};
        this.f47954f = false;
        this.f47956h = new HashMap();
        this.f47952d = c.b(4.0f);
        Paint paint = new Paint();
        this.f47949a = paint;
        paint.setColor(-1);
        this.f47949a.setStyle(Paint.Style.FILL);
        this.f47949a.setAntiAlias(true);
    }
}
