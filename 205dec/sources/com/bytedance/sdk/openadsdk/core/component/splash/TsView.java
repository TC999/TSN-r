package com.bytedance.sdk.openadsdk.core.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ia;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.u.bm;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.up;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32845a;
    private c bk;

    /* renamed from: c  reason: collision with root package name */
    private final Context f32846c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private SplashClickBar f32847f;
    private TextView gd;

    /* renamed from: k  reason: collision with root package name */
    private me f32848k;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f32849p;

    /* renamed from: r  reason: collision with root package name */
    private NativeExpressView f32850r;
    private FrameLayout sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32851t;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.w f32852w;
    private ImageView xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void k();

        void p();
    }

    public TsView(Context context, String str, me meVar) {
        super(context);
        this.f32845a = false;
        this.f32851t = false;
        this.f32846c = context;
        this.ev = str;
        this.f32848k = meVar;
        w();
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar = this.f32852w;
        if (wVar == null) {
            return null;
        }
        return wVar.getView();
    }

    private void setComplianceBarLayout(me meVar) {
        up wy;
        if (this.gd == null || !xv(meVar) || (wy = meVar.wy()) == null) {
            return;
        }
        int c4 = wy.c();
        int w3 = wy.w();
        int xv = wy.xv();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = xk.ux(ls.getContext(), 25.0f);
        layoutParams.rightMargin = xk.ux(ls.getContext(), 25.0f);
        this.gd.setPadding(20, 20, 20, 20);
        this.gd.setHighlightColor(0);
        if (c4 == 2) {
            layoutParams.gravity = 80;
            if (xv()) {
                layoutParams.bottomMargin = xk.ux(ls.getContext(), xv);
            } else {
                layoutParams.bottomMargin = xk.ux(ls.getContext(), w3);
            }
        } else {
            layoutParams.gravity = 48;
            if (xv()) {
                layoutParams.topMargin = xk.ux(ls.getContext(), xv);
            } else {
                layoutParams.topMargin = xk.ux(ls.getContext(), w3);
            }
        }
        this.f32849p.setLayoutParams(layoutParams);
    }

    private boolean sr() {
        me meVar = this.f32848k;
        return meVar != null && meVar.fh() == 2;
    }

    private boolean xv(me meVar) {
        up wy;
        return (meVar == null || meVar.v() != 4 || meVar.zg() == null || (wy = meVar.wy()) == null || wy.c() == 0) ? false : true;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.w getCountDownView() {
        return this.f32852w;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!sr() && !this.f32851t) {
            xk.c(this, getCountDownLayout());
            xk.c(this, this.xv);
        }
        c cVar = this.bk;
        if (cVar != null) {
            cVar.p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.bk;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (this.f32845a) {
            return;
        }
        SplashClickBar splashClickBar = this.f32847f;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!xv());
        }
        setComplianceBarLayout(this.f32848k);
        this.f32845a = true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
    }

    public void setAdlogoViewVisibility(int i4) {
        xk.c((View) this.ux, i4);
    }

    public void setAttachedToWindowListener(c cVar) {
        this.bk = cVar;
    }

    public void setComplianceBarVisibility(int i4) {
        if (i4 == 8) {
            xk.c((View) this.f32847f, i4);
        }
        xk.c((View) this.f32849p, i4);
    }

    public void setCountDownTime(int i4) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar = this.f32852w;
        if (wVar != null) {
            wVar.setCountDownTime(i4);
        }
    }

    public void setCountDownViewPosition(me meVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar = this.f32852w;
        if (wVar == null || wVar.getView() == null || meVar == null) {
            return;
        }
        View view = this.f32852w.getView();
        bm nk = meVar.nk();
        if (nk == null) {
            return;
        }
        int c4 = nk.c();
        int ux = xk.ux(this.f32846c, nk.w());
        int ux2 = xk.ux(this.f32846c, nk.xv());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (c4 == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = ux;
            layoutParams.topMargin = ux2;
        } else if (c4 == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = ux;
            layoutParams.bottomMargin = ux2;
        } else if (c4 != 4) {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = ux;
            layoutParams.topMargin = ux2;
        } else {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = ux;
            layoutParams.bottomMargin = ux2;
        }
        view.setLayoutParams(layoutParams);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.f32850r = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.f32850r.getParent()).removeView(this.f32850r);
        }
        this.sr.addView(this.f32850r);
        setExpressViewVisibility(0);
    }

    void setExpressViewVisibility(int i4) {
        xk.c((View) this.sr, i4);
    }

    public void setIsShowSuccess(boolean z3) {
        this.f32851t = z3;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        ia.c("\u4e0d\u5141\u8bb8\u5728Splash\u5e7f\u544a\u4e2d\u6ce8\u518cOnClickListener");
    }

    final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        ia.c("\u4e0d\u5141\u8bb8\u5728Splash\u5e7f\u544a\u4e2d\u6ce8\u518cOnTouchListener");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i4) {
        xk.c(getCountDownLayout(), i4);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar = this.f32852w;
        if (wVar == null || wVar.getView() == null) {
            return;
        }
        this.f32852w.getView().setOnClickListener(onClickListener);
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setVideoViewVisibility(int i4) {
        xk.c((View) this.xv, i4);
    }

    void setVideoVoiceVisibility(int i4) {
        xk.c((View) this.xv, i4);
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.xv;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.xv;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387581);
        this.sr = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.sr.setId(2114387580);
        this.sr.setLayoutParams(layoutParams);
        frameLayout.addView(this.sr);
        this.xv = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = xk.ux(this.f32846c, 16.0f);
        layoutParams2.leftMargin = xk.ux(this.f32846c, 16.0f);
        this.xv.setId(2114387579);
        this.xv.setLayoutParams(layoutParams2);
        this.xv.setImageDrawable(i.xv(this.f32846c, "tt_splash_mute"));
        xk.c((View) this.xv, 8);
        frameLayout.addView(this.xv);
        this.f32852w = c(frameLayout, context);
        this.ux = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.ux.setId(2114387577);
        this.ux.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = xk.ux(this.f32846c, 40.0f);
        layoutParams3.leftMargin = xk.ux(this.f32846c, 20.0f);
        this.ux.setBackground(i.xv(this.f32846c, "tt_ad_logo_new"));
        this.ux.setLayoutParams(layoutParams3);
        frameLayout.addView(this.ux);
        return frameLayout;
    }

    private void w() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View c4 = c(this.f32846c);
            if (c4 == null) {
                return;
            }
            addView(c4);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.f32848k);
            this.f32847f = splashClickBar;
            addView(splashClickBar);
            FrameLayout w3 = w(this.f32848k);
            this.f32849p = w3;
            if (w3 != null) {
                addView(w3);
            }
        } catch (Throwable unused) {
        }
    }

    public void xv(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(meVar, context, str);
    }

    private boolean xv() {
        return getHeight() < xk.w(ls.getContext())[1];
    }

    public FrameLayout w(final me meVar) {
        com.bytedance.sdk.openadsdk.core.u.ux zg;
        up wy;
        if (meVar == null || meVar.v() != 4 || (zg = meVar.zg()) == null || (wy = meVar.wy()) == null || wy.c() == 0) {
            return null;
        }
        String a4 = zg.a();
        if (TextUtils.isEmpty(a4)) {
            a4 = "\u6682\u65e0";
        }
        String ux = zg.ux();
        if (TextUtils.isEmpty(ux)) {
            ux = "\u8865\u5145\u4e2d\uff0c\u53ef\u4e8e\u5e94\u7528\u5b98\u7f51\u67e5\u770b";
        }
        String r3 = zg.r();
        String str = TextUtils.isEmpty(r3) ? "\u8865\u5145\u4e2d\uff0c\u53ef\u4e8e\u5e94\u7528\u5b98\u7f51\u67e5\u770b" : r3;
        StringBuilder sb = new StringBuilder();
        sb.append("\u5e94\u7528\u540d\uff1a");
        sb.append(a4);
        sb.append("\uff1b\u7248\u672c\u53f7\uff1a");
        sb.append(ux);
        sb.append("\uff1b\u5f00\u53d1\u8005\uff1a");
        sb.append(str);
        sb.append("\uff1b");
        sb.append("\u529f\u80fd");
        sb.append(" | ");
        sb.append("\u6743\u9650");
        sb.append(" | ");
        sb.append("\u9690\u79c1");
        sb.append("  ");
        SpannableString spannableString = new SpannableString(sb.toString());
        int indexOf = sb.indexOf("\u529f\u80fd");
        int indexOf2 = sb.indexOf("\u9690\u79c1");
        int indexOf3 = sb.indexOf("\u6743\u9650");
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.c(meVar, tsView.f32846c, TsView.this.ev);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf, indexOf + 2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.xv(meVar, tsView.f32846c, TsView.this.ev);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf2, indexOf2 + 2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.w(meVar, tsView.f32846c, TsView.this.ev);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf3, indexOf3 + 2, 34);
        this.gd = new TextView(this.f32846c);
        this.f32849p = new FrameLayout(this.f32846c);
        this.gd.setMovementMethod(LinkMovementMethod.getInstance());
        this.gd.setTextColor(-1);
        this.gd.setTextSize(11.0f);
        this.gd.setText(spannableString);
        this.f32849p.addView(this.gd);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(xk.ux(this.f32846c, 6.0f));
        this.f32849p.setBackground(gradientDrawable);
        return this.f32849p;
    }

    public void c(me meVar) {
        SplashClickBar splashClickBar = this.f32847f;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.c(meVar);
            xk.c(this.ux, meVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(int i4, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        SplashClickBar splashClickBar = this.f32847f;
        if (splashClickBar != null) {
            splashClickBar.c(cVar);
        }
        if (i4 == 1) {
            cVar.c(this);
            setOnClickListenerInternal(cVar);
            setOnTouchListenerInternal(cVar);
        }
    }

    public void c(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(context, meVar, str);
    }

    public void w(me meVar, Context context, String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.w(meVar, context, str);
    }

    public void c() {
        TextView textView = this.ux;
        if (textView != null) {
            textView.setBackground(i.xv(this.f32846c, "tt_ad_logo_backup"));
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.w c(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        me meVar = this.f32848k;
        bm nk = meVar == null ? null : meVar.nk();
        if ((nk == null ? 1 : nk.sr()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387578);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = xk.ux(this.f32846c, 16.0f);
            layoutParams.rightMargin = xk.ux(this.f32846c, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }
}
