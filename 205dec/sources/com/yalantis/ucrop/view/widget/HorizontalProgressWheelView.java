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
import com.yalantis.ucrop.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HorizontalProgressWheelView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f54531a;

    /* renamed from: b  reason: collision with root package name */
    private a f54532b;

    /* renamed from: c  reason: collision with root package name */
    private float f54533c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f54534d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f54535e;

    /* renamed from: f  reason: collision with root package name */
    private int f54536f;

    /* renamed from: g  reason: collision with root package name */
    private int f54537g;

    /* renamed from: h  reason: collision with root package name */
    private int f54538h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f54539i;

    /* renamed from: j  reason: collision with root package name */
    private float f54540j;

    /* renamed from: k  reason: collision with root package name */
    private int f54541k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a();

        void b();

        void onScroll(float f4, float f5);
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f54541k = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.f54536f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f54537g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f54538h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f54534d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f54534d.setStrokeWidth(this.f54536f);
        this.f54534d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f54534d);
        this.f54535e = paint2;
        paint2.setColor(this.f54541k);
        this.f54535e.setStrokeCap(Paint.Cap.ROUND);
        this.f54535e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void b(MotionEvent motionEvent, float f4) {
        this.f54540j -= f4;
        postInvalidate();
        this.f54533c = motionEvent.getX();
        a aVar = this.f54532b;
        if (aVar != null) {
            aVar.onScroll(-f4, this.f54540j);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f54531a);
        int width = this.f54531a.width();
        int i4 = this.f54536f;
        int i5 = this.f54538h;
        int i6 = width / (i4 + i5);
        float f4 = this.f54540j % (i5 + i4);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i6 / 4;
            if (i7 < i8) {
                this.f54534d.setAlpha((int) ((i7 / i8) * 255.0f));
            } else if (i7 > (i6 * 3) / 4) {
                this.f54534d.setAlpha((int) (((i6 - i7) / i8) * 255.0f));
            } else {
                this.f54534d.setAlpha(255);
            }
            float f5 = -f4;
            Rect rect = this.f54531a;
            float f6 = rect.left + f5 + ((this.f54536f + this.f54538h) * i7);
            float centerY = rect.centerY() - (this.f54537g / 4.0f);
            Rect rect2 = this.f54531a;
            canvas.drawLine(f6, centerY, f5 + rect2.left + ((this.f54536f + this.f54538h) * i7), rect2.centerY() + (this.f54537g / 4.0f), this.f54534d);
        }
        canvas.drawLine(this.f54531a.centerX(), this.f54531a.centerY() - (this.f54537g / 2.0f), this.f54531a.centerX(), (this.f54537g / 2.0f) + this.f54531a.centerY(), this.f54535e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f54533c = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.f54532b;
            if (aVar != null) {
                this.f54539i = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x3 = motionEvent.getX() - this.f54533c;
            if (x3 != 0.0f) {
                if (!this.f54539i) {
                    this.f54539i = true;
                    a aVar2 = this.f54532b;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
                b(motionEvent, x3);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i4) {
        this.f54541k = i4;
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.f54532b = aVar;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f54531a = new Rect();
        a();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f54531a = new Rect();
    }
}
