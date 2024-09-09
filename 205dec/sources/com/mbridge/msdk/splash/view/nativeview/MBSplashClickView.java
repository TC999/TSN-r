package com.mbridge.msdk.splash.view.nativeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.ac;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBSplashClickView extends RelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* renamed from: a  reason: collision with root package name */
    private final String f40837a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40838b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40839c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40840d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40841e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40842f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40843g;

    /* renamed from: h  reason: collision with root package name */
    private final String f40844h;

    /* renamed from: i  reason: collision with root package name */
    private final String f40845i;

    /* renamed from: j  reason: collision with root package name */
    private final String f40846j;

    /* renamed from: k  reason: collision with root package name */
    private final String f40847k;

    /* renamed from: l  reason: collision with root package name */
    private String f40848l;

    /* renamed from: m  reason: collision with root package name */
    private int f40849m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f40850n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f40851o;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f40852p;

    /* renamed from: q  reason: collision with root package name */
    private final Paint f40853q;

    /* renamed from: r  reason: collision with root package name */
    private final Paint f40854r;

    public MBSplashClickView(Context context) {
        super(context);
        this.f40837a = "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40838b = "View";
        this.f40839c = "\u6253\u5f00\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40840d = "Open";
        this.f40841e = "\u4e0b\u8f7d\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40842f = "Install";
        this.f40843g = "mbridge_splash_btn_arrow_right";
        this.f40844h = "mbridge_splash_btn_circle";
        this.f40845i = "mbridge_splash_btn_finger";
        this.f40846j = "mbridge_splash_btn_go";
        this.f40847k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f40852p = new RectF();
        this.f40853q = new Paint();
        this.f40854r = new Paint();
        a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f40852p, this.f40854r, 31);
        canvas.drawRoundRect(this.f40852p, 200.0f, 200.0f, this.f40854r);
        canvas.saveLayer(this.f40852p, this.f40853q, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void initView(String str) {
        char c4;
        boolean z3;
        this.f40848l = str;
        str.hashCode();
        int i4 = 0;
        switch (str.hashCode()) {
            case -672744069:
                if (str.equals("Install")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 2464362:
                if (str.equals("Open")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 2666181:
                if (str.equals("View")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 855294846:
                if (str.equals("\u4e0b\u8f7d\u7b2c\u4e09\u65b9\u5e94\u7528")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1383132195:
                if (str.equals("\u6253\u5f00\u7b2c\u4e09\u65b9\u5e94\u7528")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1681333335:
                if (str.equals("\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        switch (c4) {
            case 0:
            case 3:
                this.f40849m = 3;
                z3 = true;
                break;
            case 1:
            case 4:
                this.f40849m = 1;
                z3 = true;
                break;
            case 2:
            case 5:
                this.f40849m = 2;
                z3 = true;
                break;
            default:
                z3 = false;
                break;
        }
        if (!z3) {
            boolean contains = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
            if (TextUtils.isEmpty(this.f40848l)) {
                this.f40848l = contains ? "View" : "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
            }
            this.f40849m = 2;
        }
        int i5 = this.f40849m;
        int parseColor = Color.parseColor("#666666");
        int parseColor2 = Color.parseColor("#8FC31F");
        int parseColor3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i5 == 2) {
            gradientDrawable.setColor(parseColor2);
        } else {
            gradientDrawable.setColor(parseColor3);
            gradientDrawable.setStroke(2, parseColor);
        }
        gradientDrawable.setCornerRadius(200);
        setBackground(gradientDrawable);
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(this.f40848l);
        this.f40850n = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = null;
        int i6 = this.f40849m;
        if (i6 == 2) {
            i4 = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", com.mbridge.msdk.foundation.controller.a.f().d());
            layoutParams2 = new RelativeLayout.LayoutParams(ac.b(getContext(), 35.0f), ac.b(getContext(), 35.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = ac.b(getContext(), 10.0f);
        } else if (i6 == 1) {
            i4 = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", com.mbridge.msdk.foundation.controller.a.f().d());
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = 20;
            layoutParams2.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = ac.b(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i6 == 3) {
            i4 = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", com.mbridge.msdk.foundation.controller.a.f().d());
            layoutParams2 = new RelativeLayout.LayoutParams(ac.b(getContext(), 25.0f), ac.b(getContext(), 25.0f));
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = ac.b(getContext(), 50.0f);
            layoutParams2.topMargin = ac.b(getContext(), 18.0f);
            this.f40851o = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ac.b(getContext(), 30.0f), ac.b(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = ac.b(getContext(), 50.0f);
            layoutParams4.topMargin = ac.b(getContext(), 5.0f);
            this.f40851o.setLayoutParams(layoutParams4);
            this.f40851o.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
            addView(this.f40851o);
        }
        this.f40850n.setLayoutParams(layoutParams2);
        this.f40850n.setImageResource(i4);
        addView(textView);
        addView(this.f40850n);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i4 = this.f40849m;
        if (i4 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f40850n.startAnimation(scaleAnimation);
        } else if (i4 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f40850n.setVisibility(4);
                    MBSplashClickView.this.f40850n.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f40850n.startAnimation(animation);
                        }
                    }, 2000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f40850n.setVisibility(0);
                }
            });
            this.f40850n.startAnimation(translateAnimation);
        } else if (i4 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f40851o.setVisibility(4);
                    MBSplashClickView.this.f40851o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f40851o.startAnimation(scaleAnimation3);
                        }
                    }, 700L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f40851o.setVisibility(0);
                }
            });
            this.f40851o.setVisibility(4);
            this.f40850n.startAnimation(scaleAnimation2);
            this.f40851o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.f40851o.startAnimation(scaleAnimation3);
                }
            }, 500L);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f40852p.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    private void a() {
        this.f40853q.setAntiAlias(true);
        this.f40853q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f40854r.setAntiAlias(true);
        this.f40854r.setColor(-1);
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40837a = "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40838b = "View";
        this.f40839c = "\u6253\u5f00\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40840d = "Open";
        this.f40841e = "\u4e0b\u8f7d\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40842f = "Install";
        this.f40843g = "mbridge_splash_btn_arrow_right";
        this.f40844h = "mbridge_splash_btn_circle";
        this.f40845i = "mbridge_splash_btn_finger";
        this.f40846j = "mbridge_splash_btn_go";
        this.f40847k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f40852p = new RectF();
        this.f40853q = new Paint();
        this.f40854r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f40837a = "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40838b = "View";
        this.f40839c = "\u6253\u5f00\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40840d = "Open";
        this.f40841e = "\u4e0b\u8f7d\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40842f = "Install";
        this.f40843g = "mbridge_splash_btn_arrow_right";
        this.f40844h = "mbridge_splash_btn_circle";
        this.f40845i = "mbridge_splash_btn_finger";
        this.f40846j = "mbridge_splash_btn_go";
        this.f40847k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f40852p = new RectF();
        this.f40853q = new Paint();
        this.f40854r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f40837a = "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40838b = "View";
        this.f40839c = "\u6253\u5f00\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40840d = "Open";
        this.f40841e = "\u4e0b\u8f7d\u7b2c\u4e09\u65b9\u5e94\u7528";
        this.f40842f = "Install";
        this.f40843g = "mbridge_splash_btn_arrow_right";
        this.f40844h = "mbridge_splash_btn_circle";
        this.f40845i = "mbridge_splash_btn_finger";
        this.f40846j = "mbridge_splash_btn_go";
        this.f40847k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f40852p = new RectF();
        this.f40853q = new Paint();
        this.f40854r = new Paint();
    }
}
