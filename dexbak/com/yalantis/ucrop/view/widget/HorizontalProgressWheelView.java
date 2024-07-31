package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.C13495R;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HorizontalProgressWheelView extends View {

    /* renamed from: a */
    private final Rect f40024a;

    /* renamed from: b */
    private InterfaceC13542a f40025b;

    /* renamed from: c */
    private float f40026c;

    /* renamed from: d */
    private Paint f40027d;

    /* renamed from: e */
    private Paint f40028e;

    /* renamed from: f */
    private int f40029f;

    /* renamed from: g */
    private int f40030g;

    /* renamed from: h */
    private int f40031h;

    /* renamed from: i */
    private boolean f40032i;

    /* renamed from: j */
    private float f40033j;

    /* renamed from: k */
    private int f40034k;

    /* renamed from: com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13542a {
        /* renamed from: a */
        void mo12907a();

        /* renamed from: b */
        void mo12906b();

        void onScroll(float f, float f2);
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m12909a() {
        this.f40034k = ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_widget_rotate_mid_line);
        this.f40029f = getContext().getResources().getDimensionPixelSize(C13495R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f40030g = getContext().getResources().getDimensionPixelSize(C13495R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f40031h = getContext().getResources().getDimensionPixelSize(C13495R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f40027d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f40027d.setStrokeWidth(this.f40029f);
        this.f40027d.setColor(getResources().getColor(C13495R.C13497color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f40027d);
        this.f40028e = paint2;
        paint2.setColor(this.f40034k);
        this.f40028e.setStrokeCap(Paint.Cap.ROUND);
        this.f40028e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(C13495R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    /* renamed from: b */
    private void m12908b(MotionEvent motionEvent, float f) {
        this.f40033j -= f;
        postInvalidate();
        this.f40026c = motionEvent.getX();
        InterfaceC13542a interfaceC13542a = this.f40025b;
        if (interfaceC13542a != null) {
            interfaceC13542a.onScroll(-f, this.f40033j);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f40024a);
        int width = this.f40024a.width();
        int i = this.f40029f;
        int i2 = this.f40031h;
        int i3 = width / (i + i2);
        float f = this.f40033j % (i2 + i);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i3 / 4;
            if (i4 < i5) {
                this.f40027d.setAlpha((int) ((i4 / i5) * 255.0f));
            } else if (i4 > (i3 * 3) / 4) {
                this.f40027d.setAlpha((int) (((i3 - i4) / i5) * 255.0f));
            } else {
                this.f40027d.setAlpha(255);
            }
            float f2 = -f;
            Rect rect = this.f40024a;
            float f3 = rect.left + f2 + ((this.f40029f + this.f40031h) * i4);
            float centerY = rect.centerY() - (this.f40030g / 4.0f);
            Rect rect2 = this.f40024a;
            canvas.drawLine(f3, centerY, f2 + rect2.left + ((this.f40029f + this.f40031h) * i4), rect2.centerY() + (this.f40030g / 4.0f), this.f40027d);
        }
        canvas.drawLine(this.f40024a.centerX(), this.f40024a.centerY() - (this.f40030g / 2.0f), this.f40024a.centerX(), (this.f40030g / 2.0f) + this.f40024a.centerY(), this.f40028e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40026c = motionEvent.getX();
        } else if (action == 1) {
            InterfaceC13542a interfaceC13542a = this.f40025b;
            if (interfaceC13542a != null) {
                this.f40032i = false;
                interfaceC13542a.mo12907a();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.f40026c;
            if (x != 0.0f) {
                if (!this.f40032i) {
                    this.f40032i = true;
                    InterfaceC13542a interfaceC13542a2 = this.f40025b;
                    if (interfaceC13542a2 != null) {
                        interfaceC13542a2.mo12906b();
                    }
                }
                m12908b(motionEvent, x);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i) {
        this.f40034k = i;
        invalidate();
    }

    public void setScrollingListener(InterfaceC13542a interfaceC13542a) {
        this.f40025b = interfaceC13542a;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40024a = new Rect();
        m12909a();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f40024a = new Rect();
    }
}
