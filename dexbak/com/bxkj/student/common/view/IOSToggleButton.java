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
import com.bxkj.student.C4215R;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.github.mikephil.charting.utils.Utils;
import com.orhanobut.logger.C11792j;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        MyGestureDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent event) {
            IOSToggleButton iOSToggleButton = IOSToggleButton.this;
            iOSToggleButton.handlerHolded = iOSToggleButton.handlerLayer.contains(event.getX(), event.getY());
            if (IOSToggleButton.this.handlerHolded) {
                IOSToggleButton.this.springHandlerTouch.m35574x(1.0d);
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

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
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
                double m35592f = spring.m35592f();
                IOSToggleButton.this.handlerScaleEffect(m35592f);
                IOSToggleButton.this.animLayerScale(1.0d - m35592f);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.m35592f());
            }
        };
        init(null, 0);
    }

    private void animButtonScaling(float value) {
        RectF rectF = this.handlerLayer;
        float f = rectF.left;
        float f2 = this.handlerRadius;
        rectF.right = f + (2.0f * f2) + (f2 * 0.5f * value);
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animLayerScale(double value) {
        double m35551b = SpringUtil.m35551b(value, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, (this.handlerMoveDistance / 2.0f) + this.handlerRadius);
        float m35551b2 = (float) SpringUtil.m35551b(value, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, this.handlerRadius);
        this.toggleAnimRadius = m35551b2;
        float f = (float) m35551b;
        this.toggleAnimLayer.left = (getWidth() / 2.0f) - f;
        this.toggleAnimLayer.top = (getHeight() / 2.0f) - m35551b2;
        this.toggleAnimLayer.right = (getWidth() / 2.0f) + f;
        this.toggleAnimLayer.bottom = (getHeight() / 2.0f) + m35551b2;
    }

    private void animLayerScaleOut(double value) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerMoveEffect(double value) {
        RectF rectF = this.handlerLayer;
        RectF rectF2 = this.basicLayer;
        float f = rectF2.left;
        float f2 = this.borderWidth;
        float f3 = this.handlerMoveDistance;
        float f4 = (float) value;
        rectF.left = f + f2 + (f3 * f4);
        rectF.right = rectF2.left + (this.handlerRadius * 2.0f) + f2 + (f3 * f4);
        this.openBgPaint.setAlpha((int) SpringUtil.m35551b(SpringUtil.m35552a(value, Utils.DOUBLE_EPSILON, 1.0d), Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, 255.0d));
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerScaleEffect(double value) {
        if (this.toggleOn) {
            RectF rectF = this.handlerLayer;
            float f = rectF.right;
            float f2 = this.handlerRadius;
            rectF.left = (f - (2.0f * f2)) - ((f2 * 0.5f) * ((float) SpringUtil.m35552a(value, Utils.DOUBLE_EPSILON, 1.0d)));
        } else {
            RectF rectF2 = this.handlerLayer;
            float f3 = rectF2.left;
            float f4 = this.handlerRadius;
            rectF2.right = f3 + (2.0f * f4) + (f4 * 0.5f * ((float) SpringUtil.m35552a(value, Utils.DOUBLE_EPSILON, 1.0d)));
        }
        postInvalidate();
    }

    private void init(AttributeSet attrs, int defStyle) {
        setLayerType(1, null);
        SpringSystem m35555m = SpringSystem.m35555m();
        this.springSystem = m35555m;
        Spring m35638d = m35555m.m35638d();
        this.springHandlerTouch = m35638d;
        m35638d.m35601B(SpringConfig.m35562b(50.0d, 7.0d));
        Spring m35638d2 = this.springSystem.m35638d();
        this.springHandlerMove = m35638d2;
        m35638d2.m35601B(SpringConfig.m35562b(50.0d, 7.0d));
        this.detector = new GestureDetector(getContext(), new MyGestureDetector());
        setOnTouchListener(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C4215R.styleable.IOSToggleButton, defStyle, 0);
        int color = getContext().getResources().getColor(C4215R.C4217color.defaultDisabledColor);
        int color2 = getContext().getResources().getColor(C4215R.C4217color.defaultEnabledColor);
        int color3 = getContext().getResources().getColor(C4215R.C4217color.defaultBackgroundColor);
        this.disabledColor = obtainStyledAttributes.getColor(3, color);
        int color4 = obtainStyledAttributes.getColor(4, color2);
        this.enabledColor = color4;
        this.openBg = color4;
        this.transparent = getContext().getResources().getColor(2131034508);
        this.animLayerColor = getContext().getResources().getColor(C4215R.C4217color.toggleHandlerColor);
        int color5 = obtainStyledAttributes.getColor(0, color3);
        this.borderWidth = obtainStyledAttributes.getDimension(1, 0.0f);
        int i = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
        this.toggleOn = i == 1;
        this.springHandlerMove.m35576v(i);
        this.springHandlerTouch.m35597a(this.springListenerHandlerTouch);
        this.springHandlerMove.m35597a(this.springListenerHandlerMove);
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
        this.handlerPaint.setColor(getResources().getColor(C4215R.C4217color.toggleHandlerColor));
        this.handlerPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = this.handlerPaint;
        float f = this.borderWidth;
        paint5.setShadowLayer(2.0f * f, 0.0f, f, getResources().getColor(C4215R.C4217color.handlerShadowColor));
        invalidate();
    }

    private void toggle() {
        if (this.toggleOn) {
            this.springHandlerMove.m35574x(Utils.DOUBLE_EPSILON);
            this.toggleOn = false;
        } else {
            this.springHandlerMove.m35574x(1.0d);
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
        this.springHandlerTouch.m35578t(this.springListenerHandlerTouch);
        this.springHandlerMove.m35578t(this.springListenerHandlerMove);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C11792j.m20470c("onDraw");
        init();
        RectF rectF = this.basicLayer;
        float f = this.basicRadius;
        canvas.drawRoundRect(rectF, f, f, this.basicPaint);
        RectF rectF2 = this.toggleAnimLayer;
        float f2 = this.toggleAnimRadius;
        canvas.drawRoundRect(rectF2, f2, f2, this.toggleAnimPaint);
        RectF rectF3 = this.openBgLayer;
        float f3 = this.openBgRadius;
        canvas.drawRoundRect(rectF3, f3, f3, this.openBgPaint);
        RectF rectF4 = this.handlerLayer;
        float f4 = this.handlerRadius;
        canvas.drawRoundRect(rectF4, f4, f4, this.handlerPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            boolean contains = this.handlerLayer.contains(event.getX(), event.getY());
            this.handlerHolded = contains;
            if (contains) {
                this.springHandlerTouch.m35574x(1.0d);
            }
        } else if (action == 1) {
            if (this.handlerHolded) {
                this.springHandlerTouch.m35574x(Utils.DOUBLE_EPSILON);
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
            this.springHandlerMove.m35574x(1.0d);
            this.toggleOn = true;
            return;
        }
        this.springHandlerMove.m35574x(Utils.DOUBLE_EPSILON);
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
                double m35592f = spring.m35592f();
                IOSToggleButton.this.handlerScaleEffect(m35592f);
                IOSToggleButton.this.animLayerScale(1.0d - m35592f);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.m35592f());
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
                double m35592f = spring.m35592f();
                IOSToggleButton.this.handlerScaleEffect(m35592f);
                IOSToggleButton.this.animLayerScale(1.0d - m35592f);
            }
        };
        this.springListenerHandlerMove = new SimpleSpringListener() { // from class: com.bxkj.student.common.view.IOSToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                IOSToggleButton.this.handlerMoveEffect(spring.m35592f());
            }
        };
        init(attrs, defStyle);
    }

    private void init() {
        int i;
        if (this.isInitial) {
            int paddingLeft = getPaddingLeft() + (((int) this.borderWidth) * 2);
            int paddingTop = getPaddingTop() + (((int) this.borderWidth) * 2);
            int paddingRight = getPaddingRight() + (((int) this.borderWidth) * 2);
            int paddingBottom = getPaddingBottom() + (((int) this.borderWidth) * 2);
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            int i2 = paddingTop + height;
            float f = height / 2;
            this.basicRadius = f;
            float f2 = this.borderWidth;
            this.toggleAnimRadius = f - f2;
            this.openBgRadius = f;
            float f3 = f - f2;
            this.handlerRadius = f3;
            this.handlerMoveDistance = (width - (f2 * 2.0f)) - (f3 * 2.0f);
            float f4 = paddingLeft;
            float f5 = paddingTop;
            float f6 = paddingLeft + width;
            float f7 = i2;
            this.basicLayer = new RectF(f4, f5, f6, f7);
            float f8 = this.borderWidth;
            this.toggleAnimLayer = new RectF(f4 + f8, f5 + f8, f6 - f8, f7 - f8);
            this.openBgLayer = new RectF(f4, f5, f6, f7);
            if (this.toggleOn) {
                float f9 = this.borderWidth;
                this.handlerLayer = new RectF((i - height) + f9, f5 + f9, f6 - f9, f7 - f9);
            } else {
                float f10 = this.borderWidth;
                this.handlerLayer = new RectF(f4 + f10, f5 + f10, (paddingLeft + height) - f10, f7 - f10);
            }
            this.isInitial = false;
        }
    }
}
