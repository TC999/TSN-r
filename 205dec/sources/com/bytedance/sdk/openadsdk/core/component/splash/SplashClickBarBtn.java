package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.mt;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SplashClickBarBtn extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private AnimatorSet f32814a;
    private int ba;
    private Path bk;

    /* renamed from: c  reason: collision with root package name */
    private GradientDrawable f32815c;
    private JSONObject ck;
    private LinearLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f32816f;
    private final AnimatorSet fp;
    private LinearGradient fz;
    private float gb;
    private SplashClickBarArrow gd;

    /* renamed from: i  reason: collision with root package name */
    private boolean f32817i;
    private final ValueAnimator ia;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.c f32818j;

    /* renamed from: k  reason: collision with root package name */
    private RockView f32819k;
    private float ls;

    /* renamed from: n  reason: collision with root package name */
    private float f32820n;

    /* renamed from: p  reason: collision with root package name */
    private SlideUpView f32821p;

    /* renamed from: q  reason: collision with root package name */
    private q f32822q;

    /* renamed from: r  reason: collision with root package name */
    private RelativeLayout f32823r;

    /* renamed from: s  reason: collision with root package name */
    private final ValueAnimator f32824s;
    private TextView sr;

    /* renamed from: t  reason: collision with root package name */
    private Rect f32825t;

    /* renamed from: u  reason: collision with root package name */
    private int[] f32826u;
    private LottieAnimationView ux;

    /* renamed from: w  reason: collision with root package name */
    private mt f32827w;
    private TextView xv;

    /* renamed from: y  reason: collision with root package name */
    private me f32828y;
    private Paint ys;

    /* renamed from: z  reason: collision with root package name */
    private int f32829z;

    public SplashClickBarBtn(Context context, me meVar) {
        super(context);
        this.f32827w = new mt();
        this.fp = new AnimatorSet();
        this.ia = new ValueAnimator();
        this.f32824s = new ValueAnimator();
        this.f32826u = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.f32817i = false;
        this.ls = 13.0f;
        this.f32820n = 50.0f;
        this.f32828y = meVar;
        ux();
    }

    private void p() {
        mt mtVar = this.f32827w;
        if (mtVar == null || mtVar.gd() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.f32821p == null) {
                    return;
                }
                SplashClickBarBtn.this.f32821p.c();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.f32821p.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }, 500L);
    }

    public Animator getAnimator() {
        return this.fp;
    }

    public q getShakeUtils() {
        return this.f32822q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gd();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.c();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q qVar = this.f32822q;
        if (qVar != null) {
            qVar.w();
        }
        AnimatorSet animatorSet = this.f32814a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.fp;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.f32821p;
        if (slideUpView != null) {
            slideUpView.w();
        }
        LottieAnimationView lottieAnimationView = this.ux;
        if (lottieAnimationView != null) {
            lottieAnimationView.xv();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        f();
        super.onDraw(canvas);
        if (this.ia.isRunning()) {
            this.ys.setShader(this.fz);
            canvas.drawRoundRect(new RectF(this.f32825t), xk.ux(getContext(), 50.0f), xk.ux(getContext(), 50.0f), this.ys);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        q qVar = this.f32822q;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f32815c.setColor(i4);
        setBackgroundDrawable(this.f32815c);
    }

    public void setCalculationMethod(int i4) {
        this.f32829z = i4;
    }

    public void setCalculationTwistMethod(int i4) {
        this.ba = i4;
    }

    public void setDeepShakeValue(float f4) {
        this.gb = f4;
    }

    public void setShakeValue(float f4) {
        this.ls = f4;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.ck = jSONObject;
    }

    public void setWriggleValue(float f4) {
        this.f32820n = f4;
    }

    private void ev() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.bk.moveTo(point.x, point.y);
        this.bk.lineTo(point2.x, point2.y);
        this.bk.lineTo(point3.x, point3.y);
        this.bk.lineTo(point4.x, point4.y);
        this.bk.close();
        this.f32825t = getBackground().getBounds();
        final int ux = xk.ux(getContext(), 36.0f);
        final int ux2 = xk.ux(getContext(), 45.0f);
        this.ia.setIntValues(point.x - ux, point2.x + ux);
        this.ia.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.ia.setDuration(1600L);
        this.ia.setStartDelay(1300L);
        this.ia.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashClickBarBtn.this.fz = new LinearGradient(intValue, 0.0f, intValue + ux, ux2, SplashClickBarBtn.this.f32826u, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.fp.playTogether(this.ia);
    }

    private void f() {
        if (this.f32817i) {
            return;
        }
        this.f32817i = true;
        int gd = this.f32827w.gd();
        if (gd == 1 || gd == 2) {
            ev();
            r();
        }
    }

    private void gd() {
        if (this.f32827w != null && isShown()) {
            if (this.f32827w.gd() == 4 || this.f32827w.gd() == 7) {
                if (this.f32822q == null) {
                    if (this.f32827w.gd() == 4) {
                        this.f32822q = new q(ls.getContext(), 1);
                    } else if (this.f32827w.gd() == 7) {
                        this.f32822q = new q(ls.getContext(), 2);
                    }
                }
                this.f32822q.c(this.ls);
                this.f32822q.xv(this.gb);
                this.f32822q.w(this.f32820n);
                this.f32822q.c(this.ck);
                this.f32822q.c(this.f32829z);
                this.f32822q.w(this.ba);
                this.f32822q.c(new q.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.q.c
                    public void c(int i4) {
                        if (SplashClickBarBtn.this.f32818j == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.f32822q.ux() && SplashClickBarBtn.this.f32828y != null) {
                            com.bytedance.sdk.openadsdk.core.p.xv.xv.f.sr = true;
                        }
                        if (i4 != 1) {
                            if (i4 == 2 && SplashClickBarBtn.this.f32827w.gd() == 7) {
                                ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) SplashClickBarBtn.this.f32818j.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w();
                                SplashClickBarBtn.this.f32818j.onClick(SplashClickBarBtn.this);
                            }
                        } else if (SplashClickBarBtn.this.f32827w.gd() == 4) {
                            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) SplashClickBarBtn.this.f32818j.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c();
                            SplashClickBarBtn.this.f32818j.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                this.f32822q.c();
            }
        }
    }

    private void r() {
        int parseColor = Color.parseColor("#57000000");
        int parseColor2 = Color.parseColor(this.f32827w.p());
        this.f32815c.setColor(parseColor);
        if (Build.VERSION.SDK_INT < 21) {
            this.f32824s.setObjectValues(Integer.valueOf(parseColor), Integer.valueOf(parseColor2));
            this.f32824s.setEvaluator(new a());
        } else {
            this.f32824s.setIntValues(parseColor, parseColor2);
            this.f32824s.setEvaluator(new ArgbEvaluator());
        }
        this.f32824s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.f32815c.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.f32815c);
            }
        });
        this.f32824s.setDuration(300L);
        this.f32824s.setStartDelay(800L);
        this.f32824s.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.fp.playTogether(this.f32824s);
    }

    private void ux() {
        View c4 = c(getContext());
        if (c4 == null) {
            return;
        }
        addView(c4);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.gd = splashClickBarArrow;
        this.f32816f.addView(splashClickBarArrow);
        this.gd.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gd.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.f32823r.getId());
        this.f32815c = c(Color.parseColor("#57000000"));
        this.bk = new Path();
        Paint paint = new Paint();
        this.ys = paint;
        paint.isAntiAlias();
    }

    public void sr() {
        if (this.f32827w.gd() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.ux != null) {
                        SplashClickBarBtn.this.ux.c();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    public void w() {
        if (this.f32827w.gd() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void xv() {
        RockView rockView;
        if (this.f32827w.gd() == 4 && (rockView = this.f32819k) != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.f32819k != null) {
                        SplashClickBarBtn.this.f32819k.c();
                    }
                }
            }, 500L);
        }
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387576);
        relativeLayout.setLayoutParams(layoutParams);
        this.f32816f = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f32816f.setId(2114387575);
        this.f32816f.setClipChildren(false);
        layoutParams2.addRule(13);
        this.f32816f.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f32816f);
        this.f32819k = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.f32819k.setId(2114387574);
        layoutParams3.addRule(14);
        this.f32819k.setLayoutParams(layoutParams3);
        xk.c((View) this.f32819k, 8);
        this.f32816f.addView(this.f32819k);
        this.f32823r = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.f32823r.setId(2114387573);
        this.f32823r.setClipChildren(false);
        layoutParams4.addRule(13);
        this.f32823r.setGravity(17);
        this.f32823r.setLayoutParams(layoutParams4);
        this.f32816f.addView(this.f32823r);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387572);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.f32823r.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.ux = lottieAnimationView;
        lottieAnimationView.setId(2114387571);
        this.ux.setAnimation("lottie_json/twist_multi_angle.json");
        this.ux.setImageAssetsFolder("images/");
        this.ux.w(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = xk.ux(context, 4.0f);
        layoutParams6.gravity = 17;
        this.ux.setLayoutParams(layoutParams6);
        linearLayout.addView(this.ux);
        xk.c((View) this.ux, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.f32821p = slideUpView;
        slideUpView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = xk.ux(context, -140.0f);
        this.f32821p.setLayoutParams(layoutParams7);
        linearLayout.addView(this.f32821p);
        xk.c((View) this.f32821p, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.ev = linearLayout2;
        linearLayout2.setId(2114387572);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.ev.setGravity(17);
        this.ev.setOrientation(1);
        this.ev.setLayoutParams(layoutParams8);
        this.f32823r.addView(this.ev);
        TextView textView = new TextView(context);
        this.sr = textView;
        textView.setId(2114387567);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.sr.setSingleLine();
        this.sr.setText(i.c(context, "tt_splash_click_bar_text"));
        this.sr.setTextColor(-1);
        this.sr.setTextSize(20.0f);
        this.sr.setTypeface(Typeface.defaultFromStyle(1));
        this.sr.setLayoutParams(layoutParams9);
        this.ev.addView(this.sr);
        xk.c((View) this.sr, 8);
        TextView textView2 = new TextView(context);
        this.xv = textView2;
        textView2.setId(2114387566);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.xv.setShadowLayer(2.0f, 0.0f, 0.5f, i.r(context, "tt_splash_click_bar_text_shadow"));
        this.xv.setSingleLine();
        this.xv.setText(i.c(context, "tt_splash_click_bar_text"));
        this.xv.setTextColor(-1);
        this.xv.setTextSize(15.0f);
        this.xv.setTypeface(Typeface.defaultFromStyle(1));
        this.xv.setLayoutParams(layoutParams10);
        this.ev.addView(this.xv);
        xk.c((View) this.xv, 8);
        return relativeLayout;
    }

    private GradientDrawable c(int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i4);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(xk.xv(ls.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void c(mt mtVar) {
        if (mtVar == null) {
            return;
        }
        this.f32827w = mtVar;
        if (mtVar.gd() == 4) {
            this.f32819k.c(this.f32827w);
            return;
        }
        TextView textView = this.xv;
        if (textView != null) {
            textView.setVisibility(0);
            this.xv.setText(TextUtils.isEmpty(this.f32827w.w()) ? "\u70b9\u51fb\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528" : this.f32827w.w());
            if (this.f32827w.a() != null) {
                this.xv.setTextSize(2, this.f32827w.a().w());
            }
        }
        if (this.sr != null && this.f32827w.bk() != null) {
            this.sr.setTextSize(2, this.f32827w.bk().w());
        }
        this.f32815c.setColor(Color.parseColor("#57000000"));
        this.gd.c(this.f32827w.gd());
        int gd = this.f32827w.gd();
        if (gd == 1 || gd == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f32814a = animatorSet;
            animatorSet.playTogether(getAnimator(), this.gd.getAnimator());
        } else if (gd == 3) {
            TextView textView2 = this.sr;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.sr.setText(this.f32827w.k());
            }
            TextView textView3 = this.xv;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.f32815c = c(Color.parseColor(this.f32827w.p()));
        } else if (gd == 4) {
            return;
        } else {
            if (gd == 5) {
                SlideUpView slideUpView = this.f32821p;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.ev;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.ev.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.sr;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.sr.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.f32827w.k())) {
                        this.sr.setText("\u5411\u4e0a\u6ed1\u52a8");
                    } else {
                        this.sr.setText(this.f32827w.k());
                    }
                }
                TextView textView5 = this.xv;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.f32827w.w()) ? "\u6ed1\u52a8\u67e5\u770b\u8be6\u60c5" : this.f32827w.w());
                    this.xv.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            } else if (gd != 7) {
                this.f32815c.setStroke(0, -16777216);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f32814a = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.gd.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.f32827w.p()));
                } catch (Throwable unused) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
            } else {
                TextView textView6 = this.sr;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.sr.setText(this.f32827w.k());
                    this.sr.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.xv;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.xv.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.ux;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        setBackgroundDrawable(this.f32815c);
    }

    public void c() {
        AnimatorSet animatorSet = this.f32814a;
        if (animatorSet != null) {
            animatorSet.start();
        }
        w();
        xv();
        sr();
        p();
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this.f32818j = cVar;
        if (this.f32827w.gd() == 4 || this.f32827w.gd() == 7 || this.f32827w.gd() == 5 || cVar == null) {
            return;
        }
        cVar.c(this);
        setOnClickListener(cVar);
        setOnTouchListener(cVar);
        setId(2114387632);
    }
}
