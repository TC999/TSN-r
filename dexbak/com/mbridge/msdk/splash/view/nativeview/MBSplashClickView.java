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
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameTool;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBSplashClickView extends RelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* renamed from: a */
    private final String f32086a;

    /* renamed from: b */
    private final String f32087b;

    /* renamed from: c */
    private final String f32088c;

    /* renamed from: d */
    private final String f32089d;

    /* renamed from: e */
    private final String f32090e;

    /* renamed from: f */
    private final String f32091f;

    /* renamed from: g */
    private final String f32092g;

    /* renamed from: h */
    private final String f32093h;

    /* renamed from: i */
    private final String f32094i;

    /* renamed from: j */
    private final String f32095j;

    /* renamed from: k */
    private final String f32096k;

    /* renamed from: l */
    private String f32097l;

    /* renamed from: m */
    private int f32098m;

    /* renamed from: n */
    private ImageView f32099n;

    /* renamed from: o */
    private ImageView f32100o;

    /* renamed from: p */
    private final RectF f32101p;

    /* renamed from: q */
    private final Paint f32102q;

    /* renamed from: r */
    private final Paint f32103r;

    public MBSplashClickView(Context context) {
        super(context);
        this.f32086a = "浏览第三方应用";
        this.f32087b = "View";
        this.f32088c = "打开第三方应用";
        this.f32089d = "Open";
        this.f32090e = "下载第三方应用";
        this.f32091f = "Install";
        this.f32092g = "mbridge_splash_btn_arrow_right";
        this.f32093h = "mbridge_splash_btn_circle";
        this.f32094i = "mbridge_splash_btn_finger";
        this.f32095j = "mbridge_splash_btn_go";
        this.f32096k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f32101p = new RectF();
        this.f32102q = new Paint();
        this.f32103r = new Paint();
        m20946a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f32101p, this.f32103r, 31);
        canvas.drawRoundRect(this.f32101p, 200.0f, 200.0f, this.f32103r);
        canvas.saveLayer(this.f32101p, this.f32102q, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void initView(String str) {
        char c;
        boolean z;
        this.f32097l = str;
        str.hashCode();
        int i = 0;
        switch (str.hashCode()) {
            case -672744069:
                if (str.equals("Install")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2464362:
                if (str.equals("Open")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2666181:
                if (str.equals("View")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 855294846:
                if (str.equals("下载第三方应用")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1383132195:
                if (str.equals("打开第三方应用")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1681333335:
                if (str.equals("浏览第三方应用")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 3:
                this.f32098m = 3;
                z = true;
                break;
            case 1:
            case 4:
                this.f32098m = 1;
                z = true;
                break;
            case 2:
            case 5:
                this.f32098m = 2;
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            boolean contains = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
            if (TextUtils.isEmpty(this.f32097l)) {
                this.f32097l = contains ? "View" : "浏览第三方应用";
            }
            this.f32098m = 2;
        }
        int i2 = this.f32098m;
        int parseColor = Color.parseColor("#666666");
        int parseColor2 = Color.parseColor("#8FC31F");
        int parseColor3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i2 == 2) {
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
        textView.setText(this.f32097l);
        this.f32099n = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = null;
        int i3 = this.f32098m;
        if (i3 == 2) {
            i = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", MBSDKContext.m22865f().m22869d());
            layoutParams2 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 35.0f), SameTool.m22001b(getContext(), 35.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = SameTool.m22001b(getContext(), 10.0f);
        } else if (i3 == 1) {
            i = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", MBSDKContext.m22865f().m22869d());
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = 20;
            layoutParams2.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = SameTool.m22001b(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", MBSDKContext.m22865f().m22869d()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i3 == 3) {
            i = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", MBSDKContext.m22865f().m22869d());
            layoutParams2 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 25.0f), SameTool.m22001b(getContext(), 25.0f));
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = SameTool.m22001b(getContext(), 50.0f);
            layoutParams2.topMargin = SameTool.m22001b(getContext(), 18.0f);
            this.f32100o = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 30.0f), SameTool.m22001b(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = SameTool.m22001b(getContext(), 50.0f);
            layoutParams4.topMargin = SameTool.m22001b(getContext(), 5.0f);
            this.f32100o.setLayoutParams(layoutParams4);
            this.f32100o.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", MBSDKContext.m22865f().m22869d()));
            addView(this.f32100o);
        }
        this.f32099n.setLayoutParams(layoutParams2);
        this.f32099n.setImageResource(i);
        addView(textView);
        addView(this.f32099n);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.f32098m;
        if (i == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f32099n.startAnimation(scaleAnimation);
        } else if (i == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f32099n.setVisibility(4);
                    MBSplashClickView.this.f32099n.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f32099n.startAnimation(animation);
                        }
                    }, 2000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f32099n.setVisibility(0);
                }
            });
            this.f32099n.startAnimation(translateAnimation);
        } else if (i == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f32100o.setVisibility(4);
                    MBSplashClickView.this.f32100o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f32100o.startAnimation(scaleAnimation3);
                        }
                    }, 700L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f32100o.setVisibility(0);
                }
            });
            this.f32100o.setVisibility(4);
            this.f32099n.startAnimation(scaleAnimation2);
            this.f32100o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.f32100o.startAnimation(scaleAnimation3);
                }
            }, 500L);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f32101p.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    /* renamed from: a */
    private void m20946a() {
        this.f32102q.setAntiAlias(true);
        this.f32102q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f32103r.setAntiAlias(true);
        this.f32103r.setColor(-1);
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32086a = "浏览第三方应用";
        this.f32087b = "View";
        this.f32088c = "打开第三方应用";
        this.f32089d = "Open";
        this.f32090e = "下载第三方应用";
        this.f32091f = "Install";
        this.f32092g = "mbridge_splash_btn_arrow_right";
        this.f32093h = "mbridge_splash_btn_circle";
        this.f32094i = "mbridge_splash_btn_finger";
        this.f32095j = "mbridge_splash_btn_go";
        this.f32096k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f32101p = new RectF();
        this.f32102q = new Paint();
        this.f32103r = new Paint();
        m20946a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32086a = "浏览第三方应用";
        this.f32087b = "View";
        this.f32088c = "打开第三方应用";
        this.f32089d = "Open";
        this.f32090e = "下载第三方应用";
        this.f32091f = "Install";
        this.f32092g = "mbridge_splash_btn_arrow_right";
        this.f32093h = "mbridge_splash_btn_circle";
        this.f32094i = "mbridge_splash_btn_finger";
        this.f32095j = "mbridge_splash_btn_go";
        this.f32096k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f32101p = new RectF();
        this.f32102q = new Paint();
        this.f32103r = new Paint();
        m20946a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f32086a = "浏览第三方应用";
        this.f32087b = "View";
        this.f32088c = "打开第三方应用";
        this.f32089d = "Open";
        this.f32090e = "下载第三方应用";
        this.f32091f = "Install";
        this.f32092g = "mbridge_splash_btn_arrow_right";
        this.f32093h = "mbridge_splash_btn_circle";
        this.f32094i = "mbridge_splash_btn_finger";
        this.f32095j = "mbridge_splash_btn_go";
        this.f32096k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f32101p = new RectF();
        this.f32102q = new Paint();
        this.f32103r = new Paint();
    }
}
