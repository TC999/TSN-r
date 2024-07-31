package com.scwang.smartrefresh.layout.footer.ballpulse;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.scwang.smartrefresh.layout.util.C11925c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BallPulseView extends View {

    /* renamed from: i */
    public static final int f33614i = 50;

    /* renamed from: a */
    private Paint f33615a;

    /* renamed from: b */
    private int f33616b;

    /* renamed from: c */
    private int f33617c;

    /* renamed from: d */
    private float f33618d;

    /* renamed from: e */
    private float[] f33619e;

    /* renamed from: f */
    private boolean f33620f;

    /* renamed from: g */
    private ArrayList<ValueAnimator> f33621g;

    /* renamed from: h */
    private Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f33622h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11910a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int f33623a;

        C11910a(int i) {
            this.f33623a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseView.this.f33619e[this.f33623a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BallPulseView.this.postInvalidate();
        }
    }

    public BallPulseView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m19895b() {
        this.f33621g = new ArrayList<>();
        int[] iArr = {120, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 360};
        for (int i = 0; i < 3; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i]);
            this.f33622h.put(ofFloat, new C11910a(i));
            this.f33621g.add(ofFloat);
        }
    }

    /* renamed from: c */
    private boolean m19894c() {
        return this.f33620f;
    }

    /* renamed from: d */
    public void m19893d() {
        if (this.f33621g == null) {
            m19895b();
        }
        if (this.f33621g == null || m19894c()) {
            return;
        }
        for (int i = 0; i < this.f33621g.size(); i++) {
            ValueAnimator valueAnimator = this.f33621g.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f33622h.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f33620f = true;
        setIndicatorColor(this.f33617c);
    }

    /* renamed from: e */
    public void m19892e() {
        ArrayList<ValueAnimator> arrayList = this.f33621g;
        if (arrayList != null && this.f33620f) {
            this.f33620f = false;
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
            this.f33619e = new float[]{1.0f, 1.0f, 1.0f};
        }
        setIndicatorColor(this.f33616b);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f33621g != null) {
            for (int i = 0; i < this.f33621g.size(); i++) {
                this.f33621g.get(i).cancel();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float min = (Math.min(getWidth(), getHeight()) - (this.f33618d * 2.0f)) / 6.0f;
        float f = 2.0f * min;
        float width = (getWidth() / 2) - (this.f33618d + f);
        float height = getHeight() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + width + (this.f33618d * f2), height);
            float[] fArr = this.f33619e;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, this.f33615a);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int m19766b = C11925c.m19766b(50.0f);
        setMeasuredDimension(View.resolveSize(m19766b, i), View.resolveSize(m19766b, i2));
    }

    public void setAnimatingColor(@ColorInt int i) {
        this.f33617c = i;
    }

    public void setIndicatorColor(@ColorInt int i) {
        this.f33615a.setColor(i);
    }

    public void setNormalColor(@ColorInt int i) {
        this.f33616b = i;
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33616b = -1118482;
        this.f33617c = -1615546;
        this.f33619e = new float[]{1.0f, 1.0f, 1.0f};
        this.f33620f = false;
        this.f33622h = new HashMap();
        this.f33618d = C11925c.m19766b(4.0f);
        Paint paint = new Paint();
        this.f33615a = paint;
        paint.setColor(-1);
        this.f33615a.setStyle(Paint.Style.FILL);
        this.f33615a.setAntiAlias(true);
    }
}
