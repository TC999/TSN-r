package com.bxkj.student.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bxkj.student.R;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.orhanobut.logger.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class IOSToggleButton extends View implements View.OnTouchListener {
    private final String DEBUG_TAG;
    private int animLayerColor;
    private RectF basicLayer;
    private Paint basicPaint;
    private float basicRadius;
    private float borderWidth;
    private Point center;
    private GestureDetector detector;
    private int disabledColor;
    private int enabledColor;
    private boolean handlerHolded;
    private RectF handlerLayer;
    private float handlerMoveDistance;
    private Paint handlerPaint;
    private float handlerRadius;
    private boolean isInitial;
    private float offsetX;
    private OnToggleChanged onToggleChanged;
    private int openBg;
    private RectF openBgLayer;
    private Paint openBgPaint;
    private float openBgRadius;
    private Spring springHandlerMove;
    private Spring springHandlerTouch;
    SimpleSpringListener springListenerHandlerMove;
    SimpleSpringListener springListenerHandlerTouch;
    private SpringSystem springSystem;
    private RectF toggleAnimLayer;
    private Paint toggleAnimPaint;
    private float toggleAnimRadius;
    private boolean toggleOn;
    private int transparent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        MyGestureDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent event) {
            IOSToggleButton iOSToggleButton = IOSToggleButton.this;
            iOSToggleButton.handlerHolded = iOSToggleButton.handlerLayer.contains(event.getX(), event.getY());
            if (IOSToggleButton.this.handlerHolded) {
                IOSToggleButton.this.springHandlerTouch.x(1.0d);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent event) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnToggleChanged {
        void onToggle(boolean on);
    }

    public IOSToggleButton(Context context) {
        super(context);
        this.DEBUG_TAG = "ToggleButton";
        this.handlerHolded = false;
        this.offsetX = 0.0f;
        this.isInitial = true;
        this.toggleOn = false;
        this.springListenerHandlerTouch = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.1
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                double f4 = spring.f();
                IOSToggleButton.this.handlerScaleEffect(f4);
                IOSToggleButton.this.animLayerScale(1.0d - f4);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.f());
            }
        };
        init(null, 0);
    }

    private void animButtonScaling(float value) {
        RectF rectF = this.handlerLayer;
        float f4 = rectF.left;
        float f5 = this.handlerRadius;
        rectF.right = f4 + (2.0f * f5) + (f5 * 0.5f * value);
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animLayerScale(double value) {
        double b4 = SpringUtil.b(value, 0.0d, 1.0d, 0.0d, (this.handlerMoveDistance / 2.0f) + this.handlerRadius);
        float b5 = (float) SpringUtil.b(value, 0.0d, 1.0d, 0.0d, this.handlerRadius);
        this.toggleAnimRadius = b5;
        float f4 = (float) b4;
        this.toggleAnimLayer.left = (getWidth() / 2.0f) - f4;
        this.toggleAnimLayer.top = (getHeight() / 2.0f) - b5;
        this.toggleAnimLayer.right = (getWidth() / 2.0f) + f4;
        this.toggleAnimLayer.bottom = (getHeight() / 2.0f) + b5;
    }

    private void animLayerScaleOut(double value) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerMoveEffect(double value) {
        RectF rectF = this.handlerLayer;
        RectF rectF2 = this.basicLayer;
        float f4 = rectF2.left;
        float f5 = this.borderWidth;
        float f6 = this.handlerMoveDistance;
        float f7 = (float) value;
        rectF.left = f4 + f5 + (f6 * f7);
        rectF.right = rectF2.left + (this.handlerRadius * 2.0f) + f5 + (f6 * f7);
        this.openBgPaint.setAlpha((int) SpringUtil.b(SpringUtil.a(value, 0.0d, 1.0d), 0.0d, 1.0d, 0.0d, 255.0d));
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerScaleEffect(double value) {
        if (this.toggleOn) {
            RectF rectF = this.handlerLayer;
            float f4 = rectF.right;
            float f5 = this.handlerRadius;
            rectF.left = (f4 - (2.0f * f5)) - ((f5 * 0.5f) * ((float) SpringUtil.a(value, 0.0d, 1.0d)));
        } else {
            RectF rectF2 = this.handlerLayer;
            float f6 = rectF2.left;
            float f7 = this.handlerRadius;
            rectF2.right = f6 + (2.0f * f7) + (f7 * 0.5f * ((float) SpringUtil.a(value, 0.0d, 1.0d)));
        }
        postInvalidate();
    }

    private void init(AttributeSet attrs, int defStyle) {
        setLayerType(1, null);
        SpringSystem m4 = SpringSystem.m();
        this.springSystem = m4;
        Spring d4 = m4.d();
        this.springHandlerTouch = d4;
        d4.B(SpringConfig.b(50.0d, 7.0d));
        Spring d5 = this.springSystem.d();
        this.springHandlerMove = d5;
        d5.B(SpringConfig.b(50.0d, 7.0d));
        this.detector = new GestureDetector(getContext(), new MyGestureDetector());
        setOnTouchListener(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.IOSToggleButton, defStyle, 0);
        int color = getContext().getResources().getColor(2131034205);
        int color2 = getContext().getResources().getColor(2131034206);
        int color3 = getContext().getResources().getColor(2131034204);
        this.disabledColor = obtainStyledAttributes.getColor(3, color);
        int color4 = obtainStyledAttributes.getColor(4, color2);
        this.enabledColor = color4;
        this.openBg = color4;
        this.transparent = getContext().getResources().getColor(2131034508);
        this.animLayerColor = getContext().getResources().getColor(2131034494);
        int color5 = obtainStyledAttributes.getColor(0, color3);
        this.borderWidth = obtainStyledAttributes.getDimension(1, 0.0f);
        int i4 = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
        this.toggleOn = i4 == 1;
        this.springHandlerMove.v(i4);
        this.springHandlerTouch.a(this.springListenerHandlerTouch);
        this.springHandlerMove.a(this.springListenerHandlerMove);
        Paint paint = new Paint();
        this.basicPaint = paint;
        paint.setAntiAlias(true);
        this.basicPaint.setColor(color5);
        Paint paint2 = new Paint();
        this.openBgPaint = paint2;
        paint2.setAntiAlias(true);
        this.openBgPaint.setColor(this.openBg);
        if (!this.toggleOn) {
            this.openBgPaint.setAlpha(0);
        }
        Paint paint3 = new Paint();
        this.toggleAnimPaint = paint3;
        paint3.setAntiAlias(true);
        this.toggleAnimPaint.setColor(this.animLayerColor);
        Paint paint4 = new Paint();
        this.handlerPaint = paint4;
        paint4.setAntiAlias(true);
        this.handlerPaint.setColor(getResources().getColor(2131034494));
        this.handlerPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = this.handlerPaint;
        float f4 = this.borderWidth;
        paint5.setShadowLayer(2.0f * f4, 0.0f, f4, getResources().getColor(2131034266));
        invalidate();
    }

    private void toggle() {
        if (this.toggleOn) {
            this.springHandlerMove.x(0.0d);
            this.toggleOn = false;
        } else {
            this.springHandlerMove.x(1.0d);
            this.toggleOn = true;
        }
        OnToggleChanged onToggleChanged = this.onToggleChanged;
        if (onToggleChanged != null) {
            onToggleChanged.onToggle(this.toggleOn);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.springHandlerTouch.t(this.springListenerHandlerTouch);
        this.springHandlerMove.t(this.springListenerHandlerMove);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j.c("onDraw");
        init();
        RectF rectF = this.basicLayer;
        float f4 = this.basicRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.basicPaint);
        RectF rectF2 = this.toggleAnimLayer;
        float f5 = this.toggleAnimRadius;
        canvas.drawRoundRect(rectF2, f5, f5, this.toggleAnimPaint);
        RectF rectF3 = this.openBgLayer;
        float f6 = this.openBgRadius;
        canvas.drawRoundRect(rectF3, f6, f6, this.openBgPaint);
        RectF rectF4 = this.handlerLayer;
        float f7 = this.handlerRadius;
        canvas.drawRoundRect(rectF4, f7, f7, this.handlerPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            boolean contains = this.handlerLayer.contains(event.getX(), event.getY());
            this.handlerHolded = contains;
            if (contains) {
                this.springHandlerTouch.x(1.0d);
            }
        } else if (action == 1) {
            if (this.handlerHolded) {
                this.springHandlerTouch.x(0.0d);
            }
            if (this.handlerLayer.contains(event.getX(), event.getY())) {
                toggle();
            }
        }
        return true;
    }

    public void setOnToggleChanged(OnToggleChanged onToggleChanged) {
        this.onToggleChanged = onToggleChanged;
    }

    public void toggle(boolean on) {
        if (on) {
            this.springHandlerMove.x(1.0d);
            this.toggleOn = true;
            return;
        }
        this.springHandlerMove.x(0.0d);
        this.toggleOn = false;
    }

    public IOSToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.DEBUG_TAG = "ToggleButton";
        this.handlerHolded = false;
        this.offsetX = 0.0f;
        this.isInitial = true;
        this.toggleOn = false;
        this.springListenerHandlerTouch = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.1
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                double f4 = spring.f();
                IOSToggleButton.this.handlerScaleEffect(f4);
                IOSToggleButton.this.animLayerScale(1.0d - f4);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.f());
            }
        };
        init(attrs, 0);
    }

    public IOSToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.DEBUG_TAG = "ToggleButton";
        this.handlerHolded = false;
        this.offsetX = 0.0f;
        this.isInitial = true;
        this.toggleOn = false;
        this.springListenerHandlerTouch = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.1
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                double f4 = spring.f();
                IOSToggleButton.this.handlerScaleEffect(f4);
                IOSToggleButton.this.animLayerScale(1.0d - f4);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.f());
            }
        };
        init(attrs, defStyle);
    }

    private void init() {
        int i4;
        if (this.isInitial) {
            int paddingLeft = getPaddingLeft() + (((int) this.borderWidth) * 2);
            int paddingTop = getPaddingTop() + (((int) this.borderWidth) * 2);
            int paddingRight = getPaddingRight() + (((int) this.borderWidth) * 2);
            int paddingBottom = getPaddingBottom() + (((int) this.borderWidth) * 2);
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            int i5 = paddingTop + height;
            float f4 = height / 2;
            this.basicRadius = f4;
            float f5 = this.borderWidth;
            this.toggleAnimRadius = f4 - f5;
            this.openBgRadius = f4;
            float f6 = f4 - f5;
            this.handlerRadius = f6;
            this.handlerMoveDistance = (width - (f5 * 2.0f)) - (f6 * 2.0f);
            float f7 = paddingLeft;
            float f8 = paddingTop;
            float f9 = paddingLeft + width;
            float f10 = i5;
            this.basicLayer = new RectF(f7, f8, f9, f10);
            float f11 = this.borderWidth;
            this.toggleAnimLayer = new RectF(f7 + f11, f8 + f11, f9 - f11, f10 - f11);
            this.openBgLayer = new RectF(f7, f8, f9, f10);
            if (this.toggleOn) {
                float f12 = this.borderWidth;
                this.handlerLayer = new RectF((i4 - height) + f12, f8 + f12, f9 - f12, f10 - f12);
            } else {
                float f13 = this.borderWidth;
                this.handlerLayer = new RectF(f7 + f13, f8 + f13, (paddingLeft + height) - f13, f10 - f13);
            }
            this.isInitial = false;
        }
    }
}
