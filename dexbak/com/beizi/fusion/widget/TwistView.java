package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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
import com.beizi.fusion.C3025R;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.ShapeUtil;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TwistView extends RelativeLayout {
    public static final long DELAY_TIME_TWIST = 100;

    /* renamed from: A */
    private int f11683A;

    /* renamed from: B */
    private int f11684B;

    /* renamed from: C */
    private InterfaceC3232a f11685C;

    /* renamed from: D */
    private int f11686D;

    /* renamed from: E */
    private boolean f11687E;

    /* renamed from: F */
    private int f11688F;

    /* renamed from: G */
    private int f11689G;

    /* renamed from: H */
    private int f11690H;

    /* renamed from: I */
    private boolean f11691I;

    /* renamed from: J */
    private Handler f11692J;

    /* renamed from: a */
    private View f11693a;

    /* renamed from: b */
    private View f11694b;

    /* renamed from: c */
    private View f11695c;

    /* renamed from: d */
    private View f11696d;

    /* renamed from: e */
    private BackArrowView f11697e;

    /* renamed from: f */
    private BackArrowView f11698f;

    /* renamed from: g */
    private BackArrowView f11699g;

    /* renamed from: h */
    private ShakeView f11700h;

    /* renamed from: i */
    private TextView f11701i;

    /* renamed from: j */
    private TextView f11702j;

    /* renamed from: k */
    private int f11703k;

    /* renamed from: l */
    private ObjectAnimator f11704l;

    /* renamed from: m */
    private final int f11705m;

    /* renamed from: n */
    private final int f11706n;

    /* renamed from: o */
    private final long f11707o;

    /* renamed from: p */
    private final long f11708p;

    /* renamed from: q */
    private final long f11709q;

    /* renamed from: r */
    private String f11710r;

    /* renamed from: s */
    private String f11711s;

    /* renamed from: t */
    private String f11712t;

    /* renamed from: u */
    private long f11713u;

    /* renamed from: v */
    private Timer f11714v;

    /* renamed from: w */
    private TimerTask f11715w;

    /* renamed from: x */
    private Timer f11716x;

    /* renamed from: y */
    private TimerTask f11717y;

    /* renamed from: z */
    private int f11718z;

    /* renamed from: com.beizi.fusion.widget.TwistView$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3232a {
        /* renamed from: a */
        void mo48024a();
    }

    public TwistView(Context context) {
        super(context);
        this.f11705m = 1000;
        this.f11706n = 2000;
        this.f11707o = 500L;
        this.f11708p = 0L;
        this.f11709q = 0L;
        this.f11710r = "#FFFFFFFF";
        this.f11711s = "#99FFFFFF";
        this.f11712t = "#33FFFFFF";
        this.f11713u = 1000L;
        this.f11718z = 0;
        this.f11683A = 0;
        this.f11684B = 0;
        this.f11686D = 0;
        this.f11687E = true;
        this.f11688F = 3;
        this.f11689G = 1;
        this.f11690H = 95;
        this.f11691I = false;
        this.f11692J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i = message.what;
                    if (i == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.f11686D);
                    } else if (i == 1000) {
                        TwistView.this.m48042a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        m48036b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCountAnimation() {
        return (int) (this.f11713u / 100);
    }

    public void cancelArrowTimerTask() {
        try {
            Timer timer = this.f11716x;
            if (timer != null) {
                timer.cancel();
                this.f11716x = null;
            }
            TimerTask timerTask = this.f11717y;
            if (timerTask != null) {
                timerTask.cancel();
                this.f11717y = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelTwistTimerTask() {
        try {
            Timer timer = this.f11714v;
            if (timer != null) {
                timer.cancel();
                this.f11714v = null;
            }
            TimerTask timerTask = this.f11715w;
            if (timerTask != null) {
                timerTask.cancel();
                this.f11715w = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroyView() {
        try {
            ShakeView shakeView = this.f11700h;
            if (shakeView != null) {
                shakeView.stopShake();
            }
            cancelTwistTimerTask();
            cancelArrowTimerTask();
            removeHandlerMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void hideTargetView(View view, long j, int i) {
        try {
            float max = Math.max(view.getWidth(), view.getHeight());
            float countAnimation = max / getCountAnimation();
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, max - (i * countAnimation), max - (countAnimation * (i + 1)));
            createCircularReveal.setDuration(j);
            view.clearAnimation();
            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.8
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeHandlerMsg() {
        try {
            Handler handler = this.f11692J;
            if (handler != null) {
                handler.removeCallbacks(null);
                this.f11692J = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDescribeText(String str) {
        try {
            TextView textView = this.f11702j;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDurationAnimation(long j) {
        this.f11713u = j;
    }

    public void setJumpClickListener(View.OnClickListener onClickListener) {
        View view = this.f11696d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setJumpOnTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.f11696d;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitleText(String str) {
        try {
            TextView textView = this.f11701i;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotationEndCallback(InterfaceC3232a interfaceC3232a) {
        this.f11685C = interfaceC3232a;
    }

    public void setTwistTotalLayoutBg(String str) {
        View view = this.f11696d;
        if (view != null) {
            try {
                ShapeUtil.m48318a(view, str, 0, "", 100);
            } catch (Exception e) {
                C3116af.m48495b("TwistView", " e : " + e);
            }
        }
    }

    public void setTwistTotalLayoutWidthAndHeight(int i, int i2) {
        try {
            View view = this.f11696d;
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2 - C3138av.m48304a(getContext(), this.f11690H);
                this.f11696d.setPadding(C3138av.m48304a(getContext(), 0.0f), C3138av.m48304a(getContext(), this.f11688F), C3138av.m48304a(getContext(), 0.0f), C3138av.m48304a(getContext(), this.f11688F));
                this.f11696d.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void showTargetView(View view, long j, final int i) {
        try {
            float max = Math.max(view.getWidth(), view.getHeight()) / getCountAnimation();
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, (i * max) + 0.0f, max * (i + 1));
            createCircularReveal.setDuration(j);
            view.clearAnimation();
            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (TwistView.this.m48027f()) {
                        return;
                    }
                    TwistView.this.getCountAnimation();
                }
            });
            createCircularReveal.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTwistTimerTask() {
        try {
            if (this.f11714v == null) {
                this.f11714v = new Timer();
            }
            if (this.f11715w == null) {
                this.f11715w = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    @RequiresApi(api = 21)
                    public void run() {
                        try {
                            if (TwistView.this.f11691I || TwistView.this.f11692J == null) {
                                return;
                            }
                            Message obtainMessage = TwistView.this.f11692J.obtainMessage();
                            obtainMessage.what = 2000;
                            TwistView.this.f11692J.sendMessage(obtainMessage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.f11714v.scheduleAtFixedRate(this.f11715w, 0L, 100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRollStatus(int i) {
        this.f11686D = i;
    }

    @RequiresApi(api = 21)
    public void updateStatus(int i) {
        if (i == 0) {
            return;
        }
        try {
            int countAnimation = getCountAnimation();
            if (this.f11684B != i) {
                if (this.f11687E) {
                    this.f11683A = 0;
                } else {
                    this.f11683A = countAnimation - this.f11683A;
                }
                this.f11684B = i;
            }
            if (this.f11683A < 0) {
                this.f11683A = 0;
            }
            if (this.f11683A >= countAnimation) {
                if (this.f11687E) {
                    this.f11683A = 0;
                } else {
                    this.f11683A = countAnimation;
                }
            }
            int i2 = this.f11683A;
            if (i2 < 0 || i2 > countAnimation) {
                return;
            }
            m48039a(this.f11694b, this.f11693a, 100L, i, i2);
            this.f11683A++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m48036b() {
        try {
            RelativeLayout.inflate(getContext(), C3025R.C3029layout.beizi_twist_view, this);
            m48033c();
            m48031d();
            m48029e();
            startTwistTimerTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m48033c() {
        try {
            this.f11693a = findViewById(C3025R.C3028id.beizi_twist_go_imageview);
            this.f11696d = findViewById(C3025R.C3028id.beizi_twist_shake_total_layout);
            this.f11694b = findViewById(C3025R.C3028id.beizi_twist_total_layout);
            this.f11695c = findViewById(C3025R.C3028id.beizi_twist_right_total_layout);
            this.f11701i = (TextView) findViewById(C3025R.C3028id.beizi_twist_title_text);
            this.f11702j = (TextView) findViewById(C3025R.C3028id.beizi_twist_describe_text);
            this.f11697e = (BackArrowView) findViewById(C3025R.C3028id.beizi_twist_right_first_image);
            this.f11698f = (BackArrowView) findViewById(C3025R.C3028id.beizi_twist_right_second_image);
            this.f11699g = (BackArrowView) findViewById(C3025R.C3028id.beizi_twist_right_third_image);
            ShakeView shakeView = (ShakeView) findViewById(C3025R.C3028id.beizi_twist_top_view);
            this.f11700h = shakeView;
            shakeView.updateTwistRollAnim();
            setTwistTotalLayoutBg("#d9333333");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m48031d() {
        try {
            ShakeView shakeView = this.f11700h;
            if (shakeView != null) {
                shakeView.startShake();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m48029e() {
        try {
            if (this.f11716x == null) {
                this.f11716x = new Timer();
            }
            if (this.f11717y == null) {
                this.f11717y = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (TwistView.this.f11692J != null) {
                                TwistView.this.f11692J.sendEmptyMessage(1000);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.f11716x.schedule(this.f11717y, 0L, 500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m48027f() {
        return this.f11684B == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48042a() {
        try {
            int i = this.f11703k;
            if (i == 0) {
                BackArrowView backArrowView = this.f11697e;
                if (backArrowView != null) {
                    backArrowView.setViewColor(Color.parseColor(this.f11710r));
                }
                BackArrowView backArrowView2 = this.f11698f;
                if (backArrowView2 != null) {
                    backArrowView2.setViewColor(Color.parseColor(this.f11711s));
                }
                BackArrowView backArrowView3 = this.f11699g;
                if (backArrowView3 != null) {
                    backArrowView3.setViewColor(Color.parseColor(this.f11712t));
                }
            } else if (i == 1) {
                BackArrowView backArrowView4 = this.f11697e;
                if (backArrowView4 != null) {
                    backArrowView4.setViewColor(Color.parseColor(this.f11712t));
                }
                BackArrowView backArrowView5 = this.f11698f;
                if (backArrowView5 != null) {
                    backArrowView5.setViewColor(Color.parseColor(this.f11710r));
                }
                BackArrowView backArrowView6 = this.f11699g;
                if (backArrowView6 != null) {
                    backArrowView6.setViewColor(Color.parseColor(this.f11711s));
                }
            } else if (i == 2) {
                BackArrowView backArrowView7 = this.f11697e;
                if (backArrowView7 != null) {
                    backArrowView7.setViewColor(Color.parseColor(this.f11711s));
                }
                BackArrowView backArrowView8 = this.f11698f;
                if (backArrowView8 != null) {
                    backArrowView8.setViewColor(Color.parseColor(this.f11712t));
                }
                BackArrowView backArrowView9 = this.f11699g;
                if (backArrowView9 != null) {
                    backArrowView9.setViewColor(Color.parseColor(this.f11710r));
                }
            }
            int i2 = this.f11703k;
            if (i2 == 2) {
                this.f11703k = 0;
            } else {
                this.f11703k = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m48035b(View view, float f, long j, boolean z, final int i) {
        try {
            if (z) {
                float width = f - view.getWidth();
                float countAnimation = width / getCountAnimation();
                float f2 = i * countAnimation;
                float f3 = f2 + 0.0f;
                float f4 = countAnimation + f2;
                if (f3 > 0.0f || f4 > 0.0f) {
                    this.f11687E = false;
                }
                if ((f3 >= width || f4 >= width) && i >= getCountAnimation()) {
                    return;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f3, f4);
                this.f11704l = ofFloat;
                ofFloat.setDuration(j);
                this.f11704l.start();
                this.f11704l.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.TwistView.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (i + 1 < TwistView.this.getCountAnimation() || TwistView.this.f11685C == null) {
                                return;
                            }
                            TwistView.this.f11691I = true;
                            TwistView.this.f11685C.mo48024a();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
            float width2 = f - view.getWidth();
            float countAnimation2 = width2 / getCountAnimation();
            float f5 = width2 - (i * countAnimation2);
            float f6 = width2 - ((i + 1) * countAnimation2);
            if (f5 >= 0.0f && f6 >= 0.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", f5, f6);
                this.f11704l = ofFloat2;
                ofFloat2.setDuration(j);
                this.f11704l.start();
                return;
            }
            this.f11687E = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11705m = 1000;
        this.f11706n = 2000;
        this.f11707o = 500L;
        this.f11708p = 0L;
        this.f11709q = 0L;
        this.f11710r = "#FFFFFFFF";
        this.f11711s = "#99FFFFFF";
        this.f11712t = "#33FFFFFF";
        this.f11713u = 1000L;
        this.f11718z = 0;
        this.f11683A = 0;
        this.f11684B = 0;
        this.f11686D = 0;
        this.f11687E = true;
        this.f11688F = 3;
        this.f11689G = 1;
        this.f11690H = 95;
        this.f11691I = false;
        this.f11692J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i = message.what;
                    if (i == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.f11686D);
                    } else if (i == 1000) {
                        TwistView.this.m48042a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        m48036b();
    }

    @RequiresApi(api = 21)
    /* renamed from: a */
    private void m48039a(View view, View view2, long j, int i, int i2) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    if (i == 1) {
                        hideTargetView(view, j, i2);
                        m48041a(view2, view.getRight(), j, true, i2);
                    } else if (i == 2 && !this.f11687E) {
                        showTargetView(view, j, i2);
                        m48041a(view2, view.getRight(), j, false, i2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m48041a(View view, float f, long j, boolean z, int i) {
        try {
            m48035b(view, f, j, z, i);
            m48040a(view, j, z, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m48040a(View view, long j, boolean z, int i) {
        try {
            if (z) {
                float countAnimation = 360.0f / getCountAnimation();
                float f = (i * countAnimation) + 0.0f;
                float f2 = countAnimation * (i + 1);
                if (f <= 360.0f && f2 <= 360.0f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", f, f2);
                    ofFloat.setDuration(j);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        }
                    });
                    ofFloat.start();
                }
                return;
            }
            float countAnimation2 = (-360.0f) / getCountAnimation();
            float f3 = (i * countAnimation2) + 0.0f;
            float f4 = countAnimation2 * (i + 1);
            if (f3 >= -360.0f && f4 >= -360.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", f3, f4);
                ofFloat2.setDuration(j);
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    }
                });
                ofFloat2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11705m = 1000;
        this.f11706n = 2000;
        this.f11707o = 500L;
        this.f11708p = 0L;
        this.f11709q = 0L;
        this.f11710r = "#FFFFFFFF";
        this.f11711s = "#99FFFFFF";
        this.f11712t = "#33FFFFFF";
        this.f11713u = 1000L;
        this.f11718z = 0;
        this.f11683A = 0;
        this.f11684B = 0;
        this.f11686D = 0;
        this.f11687E = true;
        this.f11688F = 3;
        this.f11689G = 1;
        this.f11690H = 95;
        this.f11691I = false;
        this.f11692J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i2 = message.what;
                    if (i2 == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.f11686D);
                    } else if (i2 == 1000) {
                        TwistView.this.m48042a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        m48036b();
    }
}
