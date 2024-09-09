package xyz.adscope.ad.control.interaction.view.custom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdTwistView extends RelativeLayout {
    public static final long DELAY_TIME_TWIST = 100;
    private static final String TAG = "TwistView";
    private static final int TWIST_STATUS_LEFT = 2;
    private static final int TWIST_STATUS_NORMAL = 0;
    private static final int TWIST_STATUS_RIGHT = 1;
    private final long DELAY_TIME_ARROW;
    private final int MSG_WHAT_ARROW;
    private final int MSG_WHAT_TWIST;
    private final long TIME_TASK_INIT_ARROW;
    private final long TIME_TASK_INIT_TWIST;
    private int TWIST_PADDING_LEFT_VALUE;
    private int TWIST_PADDING_VALUE;
    private int TWIST_SHAKE_HEIGHT_VALUE;
    private int Twist_Status;
    private TimerTask arrowTimeOutTask;
    private Timer arrowTimer;
    private AdBackArrowView backArrowViewFirst;
    private AdBackArrowView backArrowViewSecond;
    private AdBackArrowView backArrowViewThird;
    private int countAnimation;
    private int countNumber;
    private long durationAnimation;
    private String firstColorWhite;
    private boolean isLeft;
    private Handler mHandler;
    private ObjectAnimator objectAnimatorX;
    private int rollStatus;
    private RotationCallbackInterface rotationEndCallback;
    private String secondWhite;
    private AdCustomImageView shakeTopView;
    private int tempIndexFirst;
    private String thirdWhite;
    private View totalRightArrowLayout;
    private TextView twistDescribeView;
    private View twistGoView;
    private View twistShakeTotalLayout;
    private TimerTask twistTimeOutTask;
    private Timer twistTimer;
    private TextView twistTitleView;
    private View twistTotalLayout;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface RotationCallbackInterface {
        void rotationEndCallback();
    }

    public AdTwistView(Context context) {
        super(context);
        this.MSG_WHAT_ARROW = 1000;
        this.MSG_WHAT_TWIST = 2000;
        this.DELAY_TIME_ARROW = 500L;
        this.TIME_TASK_INIT_ARROW = 0L;
        this.TIME_TASK_INIT_TWIST = 0L;
        this.firstColorWhite = "#FFFFFFFF";
        this.secondWhite = "#99FFFFFF";
        this.thirdWhite = "#33FFFFFF";
        this.durationAnimation = 1000L;
        this.Twist_Status = 0;
        this.countAnimation = 0;
        this.tempIndexFirst = 0;
        this.rollStatus = 0;
        this.isLeft = true;
        this.TWIST_PADDING_VALUE = 3;
        this.TWIST_PADDING_LEFT_VALUE = 1;
        this.TWIST_SHAKE_HEIGHT_VALUE = 95;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i4 = message.what;
                    if (i4 != 1000) {
                        if (i4 == 2000) {
                            AdTwistView adTwistView = AdTwistView.this;
                            adTwistView.updateStatus(adTwistView.rollStatus);
                            return;
                        }
                        return;
                    }
                    if (AdTwistView.this.countNumber == 0) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 1) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 2) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                    }
                    if (AdTwistView.this.countNumber == 2) {
                        AdTwistView.this.countNumber = 0;
                    } else {
                        AdTwistView.access$008(AdTwistView.this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        initLayout();
    }

    public static /* synthetic */ int access$008(AdTwistView adTwistView) {
        int i4 = adTwistView.countNumber;
        adTwistView.countNumber = i4 + 1;
        return i4;
    }

    private void executeAnimation(View view, float f4, long j4, boolean z3, int i4) {
        startPopsAnimTrans(view, f4, j4, z3, i4);
        startRotationAnima(view, j4, z3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCountAnimation() {
        return (int) (this.durationAnimation / 100);
    }

    @RequiresApi(api = 21)
    private void hideOrShowTotalLayout(View view, View view2, long j4, int i4, int i5) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    if (i4 == 1) {
                        hideTargetView(view, j4, i5);
                        executeAnimation(view2, view.getRight(), j4, true, i5);
                    } else if (i4 == 2 && !this.isLeft) {
                        showTargetView(view, j4, i5);
                        executeAnimation(view2, view.getRight(), j4, false, i5);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void initLayout() {
        RelativeLayout.inflate(getContext(), R.layout.adscope_twist_view, this);
        initView();
        startArrowTimerTask();
        startTwistTimerTask();
    }

    private void initView() {
        this.twistGoView = findViewById(R.id.adscope_twist_go_imageview);
        this.twistShakeTotalLayout = findViewById(R.id.adscope_twist_shake_total_layout);
        this.twistTotalLayout = findViewById(R.id.adscope_twist_total_layout);
        this.totalRightArrowLayout = findViewById(R.id.adscope_twist_right_total_layout);
        this.twistTitleView = (TextView) findViewById(R.id.adscope_twist_title_text);
        this.twistDescribeView = (TextView) findViewById(R.id.adscope_twist_describe_text);
        this.backArrowViewFirst = (AdBackArrowView) findViewById(R.id.adscope_twist_right_first_image);
        this.backArrowViewSecond = (AdBackArrowView) findViewById(R.id.adscope_twist_right_second_image);
        this.backArrowViewThird = (AdBackArrowView) findViewById(R.id.adscope_twist_right_third_image);
        AdCustomImageView adCustomImageView = (AdCustomImageView) findViewById(R.id.adscope_twist_top_view);
        this.shakeTopView = adCustomImageView;
        adCustomImageView.setImageResource(R.drawable.adscope_anim_twist);
        ((AnimationDrawable) this.shakeTopView.getDrawable()).start();
        setTwistTotalLayoutBg("#d9333333");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRightFlag() {
        return this.tempIndexFirst == 1;
    }

    private void startArrowTimerTask() {
        if (this.arrowTimer == null) {
            this.arrowTimer = new Timer();
        }
        if (this.arrowTimeOutTask == null) {
            this.arrowTimeOutTask = new TimerTask() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.6
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AdTwistView.this.mHandler != null) {
                        AdTwistView.this.mHandler.sendEmptyMessage(1000);
                    }
                }
            };
        }
        this.arrowTimer.scheduleAtFixedRate(this.arrowTimeOutTask, 0L, 500L);
    }

    private void startPopsAnimTrans(View view, float f4, long j4, boolean z3, final int i4) {
        if (z3) {
            float width = f4 - view.getWidth();
            float countAnimation = width / getCountAnimation();
            float f5 = i4 * countAnimation;
            float f6 = f5 + 0.0f;
            float f7 = countAnimation + f5;
            if (f6 > 0.0f || f7 > 0.0f) {
                this.isLeft = false;
            }
            if ((f6 >= width || f7 >= width) && i4 >= getCountAnimation()) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f6, f7);
            this.objectAnimatorX = ofFloat;
            ofFloat.setDuration(j4);
            this.objectAnimatorX.start();
            this.objectAnimatorX.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (i4 + 1 < AdTwistView.this.getCountAnimation() || AdTwistView.this.rotationEndCallback == null) {
                        return;
                    }
                    AdTwistView.this.rotationEndCallback.rotationEndCallback();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            return;
        }
        float width2 = f4 - view.getWidth();
        float countAnimation2 = width2 / getCountAnimation();
        float f8 = width2 - (i4 * countAnimation2);
        float f9 = width2 - ((i4 + 1) * countAnimation2);
        if (f8 >= 0.0f && f9 >= 0.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", f8, f9);
            this.objectAnimatorX = ofFloat2;
            ofFloat2.setDuration(j4);
            this.objectAnimatorX.start();
            return;
        }
        this.isLeft = true;
    }

    private void startRotationAnima(View view, long j4, boolean z3, int i4) {
        if (z3) {
            float countAnimation = 360.0f / getCountAnimation();
            float f4 = (i4 * countAnimation) + 0.0f;
            float f5 = countAnimation * (i4 + 1);
            if (f4 > 360.0f || f5 > 360.0f) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", f4, f5);
            ofFloat.setDuration(j4);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            ofFloat.start();
            return;
        }
        float countAnimation2 = (-360.0f) / getCountAnimation();
        float f6 = (i4 * countAnimation2) + 0.0f;
        float f7 = countAnimation2 * (i4 + 1);
        if (f6 < -360.0f || f7 < -360.0f) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", f6, f7);
        ofFloat2.setDuration(j4);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat2.start();
    }

    public void cancelArrowTimerTask() {
        Timer timer = this.arrowTimer;
        if (timer != null) {
            timer.cancel();
            this.arrowTimer = null;
        }
        TimerTask timerTask = this.arrowTimeOutTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.arrowTimeOutTask = null;
        }
    }

    public void cancelTwistTimerTask() {
        Timer timer = this.twistTimer;
        if (timer != null) {
            timer.cancel();
            this.twistTimer = null;
        }
        TimerTask timerTask = this.twistTimeOutTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.twistTimeOutTask = null;
        }
    }

    public void destroyView() {
        cancelTwistTimerTask();
        cancelArrowTimerTask();
        removeHandlerMsg();
    }

    @RequiresApi(api = 21)
    public void hideTargetView(View view, long j4, int i4) {
        float max = Math.max(view.getWidth(), view.getHeight());
        float countAnimation = max / getCountAnimation();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, max - (i4 * countAnimation), max - (countAnimation * (i4 + 1)));
        createCircularReveal.setDuration(j4);
        view.clearAnimation();
        createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        });
        createCircularReveal.start();
    }

    public void removeHandlerMsg() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
    }

    public void setDescribeText(String str) {
        TextView textView = this.twistDescribeView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDurationAnimation(long j4) {
        this.durationAnimation = j4;
    }

    public void setJumpClickListener(View.OnClickListener onClickListener) {
        View view = this.twistShakeTotalLayout;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setJumpOnTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.twistShakeTotalLayout;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitleText(String str) {
        TextView textView = this.twistTitleView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setRotationEndCallback(RotationCallbackInterface rotationCallbackInterface) {
        this.rotationEndCallback = rotationCallbackInterface;
    }

    public void setTwistTotalLayoutBg(String str) {
        View view = this.twistShakeTotalLayout;
        if (view != null) {
            try {
                ShapeUtil.setViewBackGround(view, str, 0, "", 100);
            } catch (Exception e4) {
                LogUtil.i(TAG, " e : " + e4);
            }
        }
    }

    public void setTwistTotalLayoutWidthAndHeight(int i4, int i5) {
        View view = this.twistShakeTotalLayout;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5 - DeviceInfoUtil.dip2px(getContext(), this.TWIST_SHAKE_HEIGHT_VALUE);
            this.twistShakeTotalLayout.setPadding(DeviceInfoUtil.dip2px(getContext(), 0.0f), DeviceInfoUtil.dip2px(getContext(), this.TWIST_PADDING_VALUE), DeviceInfoUtil.dip2px(getContext(), 0.0f), DeviceInfoUtil.dip2px(getContext(), this.TWIST_PADDING_VALUE));
            this.twistShakeTotalLayout.setLayoutParams(layoutParams);
        }
    }

    @RequiresApi(api = 21)
    public void showTargetView(View view, long j4, final int i4) {
        float max = Math.max(view.getWidth(), view.getHeight()) / getCountAnimation();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, (i4 * max) + 0.0f, max * (i4 + 1));
        createCircularReveal.setDuration(j4);
        view.clearAnimation();
        createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (AdTwistView.this.isRightFlag()) {
                    return;
                }
                AdTwistView.this.getCountAnimation();
            }
        });
        createCircularReveal.start();
    }

    public void startTwistTimerTask() {
        if (this.twistTimer == null) {
            this.twistTimer = new Timer();
        }
        if (this.twistTimeOutTask == null) {
            this.twistTimeOutTask = new TimerTask() { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.2
                @Override // java.util.TimerTask, java.lang.Runnable
                @RequiresApi(api = 21)
                public void run() {
                    if (AdTwistView.this.mHandler != null) {
                        Message obtainMessage = AdTwistView.this.mHandler.obtainMessage();
                        obtainMessage.what = 2000;
                        AdTwistView.this.mHandler.sendMessage(obtainMessage);
                    }
                }
            };
        }
        this.twistTimer.scheduleAtFixedRate(this.twistTimeOutTask, 0L, 100L);
    }

    public void updateRollStatus(int i4) {
        this.rollStatus = i4;
    }

    @RequiresApi(api = 21)
    public void updateStatus(int i4) {
        if (i4 == 0) {
            return;
        }
        try {
            int countAnimation = getCountAnimation();
            if (this.tempIndexFirst != i4) {
                if (this.isLeft) {
                    this.countAnimation = 0;
                } else {
                    this.countAnimation = countAnimation - this.countAnimation;
                }
                this.tempIndexFirst = i4;
            }
            if (this.countAnimation < 0) {
                this.countAnimation = 0;
            }
            if (this.countAnimation >= countAnimation) {
                if (this.isLeft) {
                    this.countAnimation = 0;
                } else {
                    this.countAnimation = countAnimation;
                }
            }
            int i5 = this.countAnimation;
            if (i5 < 0 || i5 > countAnimation) {
                return;
            }
            hideOrShowTotalLayout(this.twistTotalLayout, this.twistGoView, 100L, i4, i5);
            this.countAnimation++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AdTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MSG_WHAT_ARROW = 1000;
        this.MSG_WHAT_TWIST = 2000;
        this.DELAY_TIME_ARROW = 500L;
        this.TIME_TASK_INIT_ARROW = 0L;
        this.TIME_TASK_INIT_TWIST = 0L;
        this.firstColorWhite = "#FFFFFFFF";
        this.secondWhite = "#99FFFFFF";
        this.thirdWhite = "#33FFFFFF";
        this.durationAnimation = 1000L;
        this.Twist_Status = 0;
        this.countAnimation = 0;
        this.tempIndexFirst = 0;
        this.rollStatus = 0;
        this.isLeft = true;
        this.TWIST_PADDING_VALUE = 3;
        this.TWIST_PADDING_LEFT_VALUE = 1;
        this.TWIST_SHAKE_HEIGHT_VALUE = 95;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i4 = message.what;
                    if (i4 != 1000) {
                        if (i4 == 2000) {
                            AdTwistView adTwistView = AdTwistView.this;
                            adTwistView.updateStatus(adTwistView.rollStatus);
                            return;
                        }
                        return;
                    }
                    if (AdTwistView.this.countNumber == 0) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 1) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 2) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                    }
                    if (AdTwistView.this.countNumber == 2) {
                        AdTwistView.this.countNumber = 0;
                    } else {
                        AdTwistView.access$008(AdTwistView.this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        initLayout();
    }

    public AdTwistView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.MSG_WHAT_ARROW = 1000;
        this.MSG_WHAT_TWIST = 2000;
        this.DELAY_TIME_ARROW = 500L;
        this.TIME_TASK_INIT_ARROW = 0L;
        this.TIME_TASK_INIT_TWIST = 0L;
        this.firstColorWhite = "#FFFFFFFF";
        this.secondWhite = "#99FFFFFF";
        this.thirdWhite = "#33FFFFFF";
        this.durationAnimation = 1000L;
        this.Twist_Status = 0;
        this.countAnimation = 0;
        this.tempIndexFirst = 0;
        this.rollStatus = 0;
        this.isLeft = true;
        this.TWIST_PADDING_VALUE = 3;
        this.TWIST_PADDING_LEFT_VALUE = 1;
        this.TWIST_SHAKE_HEIGHT_VALUE = 95;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.control.interaction.view.custom.AdTwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i42 = message.what;
                    if (i42 != 1000) {
                        if (i42 == 2000) {
                            AdTwistView adTwistView = AdTwistView.this;
                            adTwistView.updateStatus(adTwistView.rollStatus);
                            return;
                        }
                        return;
                    }
                    if (AdTwistView.this.countNumber == 0) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 1) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                    } else if (AdTwistView.this.countNumber == 2) {
                        if (AdTwistView.this.backArrowViewFirst != null) {
                            AdTwistView.this.backArrowViewFirst.setViewColor(Color.parseColor(AdTwistView.this.secondWhite));
                        }
                        if (AdTwistView.this.backArrowViewSecond != null) {
                            AdTwistView.this.backArrowViewSecond.setViewColor(Color.parseColor(AdTwistView.this.thirdWhite));
                        }
                        if (AdTwistView.this.backArrowViewThird != null) {
                            AdTwistView.this.backArrowViewThird.setViewColor(Color.parseColor(AdTwistView.this.firstColorWhite));
                        }
                    }
                    if (AdTwistView.this.countNumber == 2) {
                        AdTwistView.this.countNumber = 0;
                    } else {
                        AdTwistView.access$008(AdTwistView.this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        initLayout();
    }
}
