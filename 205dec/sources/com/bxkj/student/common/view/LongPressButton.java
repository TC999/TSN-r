package com.bxkj.student.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.utils.d;
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LongPressButton extends LinearLayout {
    private static final int TOUCH_SLOP = 20;
    private final int DURATION;
    private Paint backgroundCirclePaint;
    private Button bt_img;
    private LinearLayout buttonLayout;
    private boolean isMoved;
    private boolean isPress;
    private int mLastMotionX;
    private int mLastMotionY;
    private OnFinishListener onFinishListener;
    private OnPressListener onPressListener;
    private int progress;
    private Paint progressCirclePaint;
    int roundWidth;
    private ValueAnimator valueAnimator;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface OnPressListener {
        void onCancel();

        void onFinish();

        void onStart();
    }

    public LongPressButton(Context context) {
        super(context);
        this.DURATION = 1000;
        this.isMoved = false;
        this.progress = 0;
        init(null);
    }

    private void cancelAnimation() {
        this.isPress = false;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.progress = 0;
        OnPressListener onPressListener = this.onPressListener;
        if (onPressListener != null) {
            onPressListener.onCancel();
        }
    }

    private void init(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.LongPressButton);
        int resourceId = obtainStyledAttributes.getResourceId(0, 2131559170);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 2131034569);
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2131428102, (ViewGroup) this, true);
        this.buttonLayout = (LinearLayout) inflate.findViewById(2131231040);
        Button button = (Button) inflate.findViewById(2131230980);
        this.bt_img = button;
        button.setBackgroundResource(resourceId);
        this.roundWidth = d.a(getContext(), 5.0f);
        Paint paint = new Paint();
        this.backgroundCirclePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.backgroundCirclePaint.setColor(Color.parseColor("#565351"));
        this.backgroundCirclePaint.setAntiAlias(true);
        this.backgroundCirclePaint.setStrokeWidth(this.roundWidth);
        Paint paint2 = new Paint();
        this.progressCirclePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.progressCirclePaint.setColor(getResources().getColor(resourceId2));
        this.progressCirclePaint.setAntiAlias(true);
        this.progressCirclePaint.setStrokeWidth(this.roundWidth);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.valueAnimator = ofInt;
        ofInt.setDuration(1000L);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.common.view.LongPressButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LongPressButton.this.progress = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LongPressButton.this.postInvalidate();
                if (LongPressButton.this.progress == 100) {
                    LongPressButton.this.postDelayed(new Runnable() { // from class: com.bxkj.student.common.view.LongPressButton.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LongPressButton.this.isPress = false;
                            LongPressButton.this.postInvalidate();
                            if (LongPressButton.this.onPressListener != null) {
                                LongPressButton.this.onPressListener.onFinish();
                            }
                            if (LongPressButton.this.onFinishListener != null) {
                                LongPressButton.this.onFinishListener.onFinish();
                            }
                        }
                    }, 50L);
                }
            }
        });
        this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.bxkj.student.common.view.LongPressButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                LongPressButton.this.isPress = false;
                LongPressButton.this.postInvalidate();
            }
        });
    }

    private void startAnim() {
        Log.i("nieqi", "startAnimation");
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        OnPressListener onPressListener = this.onPressListener;
        if (onPressListener != null) {
            onPressListener.onStart();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.i("nieqi", "dispatchDraw , progress = " + this.progress);
        int width = getWidth() / 2;
        int i4 = width - (this.roundWidth / 2);
        canvas.save();
        float f4 = width - i4;
        float f5 = width + i4;
        RectF rectF = new RectF(f4, f4, f5, f5);
        if (this.isPress) {
            canvas.drawArc(rectF, 0.0f, 360.0f, false, this.backgroundCirclePaint);
            canvas.drawArc(rectF, -90.0f, (this.progress * 360) / 100, false, this.progressCirclePaint);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x3 = (int) ev.getX();
        int y3 = (int) ev.getY();
        int action = ev.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && !this.isMoved && (Math.abs(this.mLastMotionX - x3) > 20 || Math.abs(this.mLastMotionY - y3) > 20)) {
                    this.isMoved = true;
                    cancelAnimation();
                }
            } else {
                cancelAnimation();
            }
        } else if (x3 >= this.buttonLayout.getLeft() && x3 <= this.buttonLayout.getRight() && y3 >= this.buttonLayout.getTop() && y3 <= this.buttonLayout.getBottom()) {
            Log.i("nieqi", "press");
            this.mLastMotionX = x3;
            this.mLastMotionY = y3;
            this.isMoved = false;
            this.isPress = true;
            startAnim();
        }
        return true;
    }

    public LongPressButton setBt_img(@IdRes int imgId) {
        this.bt_img.setBackgroundResource(imgId);
        return this;
    }

    public LongPressButton setColor(int color) {
        this.progressCirclePaint.setColor(color);
        return this;
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setOnPressListener(OnPressListener onPressListener) {
        this.onPressListener = onPressListener;
    }

    public LongPressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.DURATION = 1000;
        this.isMoved = false;
        this.progress = 0;
        init(attrs);
    }

    public LongPressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.DURATION = 1000;
        this.isMoved = false;
        this.progress = 0;
        init(attrs);
    }
}
