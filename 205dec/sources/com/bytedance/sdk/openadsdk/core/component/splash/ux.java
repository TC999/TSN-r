package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.splash.k;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.oo;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends sr implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f32979a;
    private TextView bk;
    private View ev;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f32980f;
    private View fp;
    private TextView fz;
    private FrameLayout gd;

    /* renamed from: i  reason: collision with root package name */
    private TextView f32981i;
    private RelativeLayout ia;

    /* renamed from: j  reason: collision with root package name */
    private View.OnClickListener f32982j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f32983k;

    /* renamed from: p  reason: collision with root package name */
    private RelativeLayout f32984p;

    /* renamed from: q  reason: collision with root package name */
    private q f32985q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f32986r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f32987s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f32988t;

    /* renamed from: u  reason: collision with root package name */
    private RelativeLayout f32989u;
    protected com.bytedance.sdk.openadsdk.ys.w.w.ev ux;
    private TextView ys;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public String c() {
        return "splash_card_show";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i4;
        if (view.getId() == 2114387552) {
            i4 = 0;
        } else if (view.getId() == 2114387560) {
            i4 = 1;
        } else if (view.getId() == 2114387555) {
            i4 = 2;
        } else if (view.getId() == 2114387554) {
            i4 = 3;
        } else {
            i4 = view.getId() == 2114387553 ? 4 : 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i4);
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        View.OnClickListener onClickListener = this.f32982j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f32980f = relativeLayout2;
        relativeLayout2.setId(2114387561);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.f32980f.setClipChildren(false);
        this.f32980f.setVisibility(4);
        this.f32980f.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f32980f);
        ImageView imageView = new ImageView(context);
        this.ev = imageView;
        imageView.setId(2114387560);
        this.ev.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.f32980f.addView(this.ev);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387559);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.f32980f.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.f32988t = textView;
        textView.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = xk.ux(context, 8.0f);
        layoutParams3.bottomMargin = xk.ux(context, 10.0f);
        layoutParams3.rightMargin = xk.ux(context, 4.0f);
        this.f32988t.setLayoutParams(layoutParams3);
        this.f32988t.setBackground(i.xv(this.f32977c, "tt_splash_card_feedback_bg"));
        this.f32988t.setGravity(17);
        this.f32988t.setText(i.c(this.f32977c, "tt_feedback"));
        this.f32988t.setTextColor(Color.parseColor("#99FFFFFF"));
        this.f32988t.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.f32988t);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.f32984p = relativeLayout4;
        relativeLayout4.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387559);
        this.f32984p.setLayoutParams(layoutParams4);
        this.f32984p.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.f32980f.addView(this.f32984p);
        FrameLayout frameLayout = new FrameLayout(context);
        this.gd = frameLayout;
        frameLayout.setId(2114387556);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = xk.ux(context, -42.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            this.gd.setElevation(xk.xv(context, 3.0f));
        }
        this.gd.setLayoutParams(layoutParams5);
        this.f32984p.addView(this.gd);
        ImageView imageView2 = new ImageView(context);
        this.f32983k = imageView2;
        imageView2.setId(2114387555);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(xk.ux(context, 2.0f), xk.ux(context, 2.0f), xk.ux(context, 2.0f), xk.ux(context, 2.0f));
        this.f32983k.setLayoutParams(layoutParams6);
        this.gd.addView(this.f32983k);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int ux = xk.ux(context, 6.0f);
        gradientDrawable.setCornerRadius(ux);
        gradientDrawable.setStroke(ux / 3, -1);
        view.setBackground(gradientDrawable);
        this.gd.addView(view);
        TextView textView2 = new TextView(context);
        this.f32979a = textView2;
        textView2.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387556);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = xk.ux(context, 16.0f);
        this.f32979a.setLayoutParams(layoutParams7);
        this.f32979a.setEllipsize(TextUtils.TruncateAt.END);
        this.f32979a.setMaxLines(1);
        this.f32979a.setTextColor(Color.parseColor("#161823"));
        this.f32979a.setTextSize(2, 20.0f);
        this.f32984p.addView(this.f32979a);
        TextView textView3 = new TextView(context);
        this.bk = textView3;
        textView3.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387554);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(xk.ux(context, 42.0f));
        layoutParams8.setMarginEnd(xk.ux(context, 42.0f));
        layoutParams8.topMargin = xk.ux(context, 8.0f);
        this.bk.setLayoutParams(layoutParams8);
        this.bk.setEllipsize(TextUtils.TruncateAt.END);
        this.bk.setGravity(1);
        this.bk.setMaxLines(2);
        this.bk.setTextColor(Color.parseColor("#90161823"));
        this.bk.setTextSize(2, 14.0f);
        this.f32984p.addView(this.bk);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.ia = relativeLayout5;
        relativeLayout5.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387553);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = xk.ux(context, 36.0f);
        this.ia.setLayoutParams(layoutParams9);
        this.ia.setBackground(i.xv(this.f32977c, "tt_splash_card_btn_bg"));
        this.ia.setGravity(17);
        this.f32984p.addView(this.ia);
        TextView textView4 = new TextView(context);
        this.f32987s = textView4;
        textView4.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.f32987s.setLayoutParams(layoutParams10);
        this.f32987s.setEllipsize(TextUtils.TruncateAt.END);
        this.f32987s.setMaxLines(1);
        this.f32987s.setTextColor(Color.parseColor("#FFFFFF"));
        this.f32987s.setTextSize(2, 14.0f);
        this.f32987s.setTypeface(Typeface.defaultFromStyle(1));
        this.ia.addView(this.f32987s);
        TextView textView5 = new TextView(context);
        this.fz = textView5;
        textView5.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387551);
        layoutParams11.addRule(14);
        this.fz.setLayoutParams(layoutParams11);
        this.fz.setEllipsize(TextUtils.TruncateAt.END);
        this.fz.setMaxLines(1);
        this.fz.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.fz.setTextSize(2, 11.0f);
        this.ia.addView(this.fz);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.f32989u = relativeLayout6;
        relativeLayout6.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387553);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = xk.ux(context, 36.0f);
        this.f32989u.setLayoutParams(layoutParams12);
        this.f32989u.setBackground(i.xv(this.f32977c, "tt_splash_card_btn_bg"));
        this.f32989u.setVisibility(8);
        this.f32984p.addView(this.f32989u);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.f32989u.addView(relativeLayout7);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        imageView3.setBackground(i.xv(this.f32977c, "tt_splash_card_shake"));
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.f32981i = textView6;
        textView6.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = xk.ux(context, 8.0f);
        layoutParams15.addRule(1, 2114387548);
        layoutParams15.addRule(15);
        this.f32981i.setLayoutParams(layoutParams15);
        this.f32981i.setEllipsize(TextUtils.TruncateAt.END);
        this.f32981i.setTypeface(Typeface.defaultFromStyle(1));
        this.f32981i.setMaxLines(1);
        this.f32981i.setTextColor(Color.parseColor("#FFFFFF"));
        this.f32981i.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.f32981i);
        TextView textView7 = new TextView(context);
        this.ys = textView7;
        textView7.setId(2114387545);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()));
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(xk.ux(context, 8.0f));
        layoutParams16.bottomMargin = xk.ux(context, 8.0f);
        this.ys.setLayoutParams(layoutParams16);
        this.ys.setBackground(i.xv(this.f32977c, "tt_ad_logo_new"));
        this.f32984p.addView(this.ys);
        ImageView imageView4 = new ImageView(context);
        this.fp = imageView4;
        imageView4.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387561);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = xk.ux(context, 48.0f);
        this.fp.setLayoutParams(layoutParams17);
        this.fp.setBackground(i.xv(this.f32977c, "tt_splash_card_close"));
        relativeLayout.addView(this.fp);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.f32986r = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387544);
        this.f32986r.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f32986r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.f32986r);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable f() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.8
            @Override // java.lang.Runnable
            public void run() {
                if (ux.this.f32986r.getWidth() == 0 || ux.this.f32986r.getHeight() == 0) {
                    return;
                }
                float width = ux.this.f32980f.getWidth() / ux.this.f32986r.getWidth();
                float height = ux.this.f32980f.getHeight() / ux.this.f32986r.getHeight();
                if (Build.VERSION.SDK_INT >= 19) {
                    ux.this.f32986r.animate().scaleX(width).scaleY(height).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.8.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            ux.this.f32986r.setVisibility(8);
                            ux.this.f32980f.setVisibility(0);
                            ux.this.gd.setScaleX(0.0f);
                            ux.this.gd.setScaleY(0.0f);
                            ux.this.gd.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                            ux.this.f32979a.setScaleX(0.0f);
                            ux.this.f32979a.setScaleY(0.0f);
                            ux.this.f32979a.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                            ux.this.bk.setScaleX(0.0f);
                            ux.this.bk.setScaleY(0.0f);
                            ux.this.bk.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                            ux.this.ia.setScaleX(0.0f);
                            ux.this.ia.setScaleY(0.0f);
                            ux.this.ia.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                            ux uxVar = ux.this;
                            k.c cVar = uxVar.sr;
                            if (cVar != null) {
                                cVar.c(oo.ev(uxVar.xv));
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    });
                }
            }
        };
    }

    protected String sr() {
        me meVar = this.xv;
        return (meVar == null || TextUtils.isEmpty(meVar.ny())) ? "" : this.xv.ny();
    }

    public void ux() {
        k.c cVar = this.sr;
        if (cVar == null) {
            return;
        }
        if (this.ux == null) {
            this.ux = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(cVar.getActivity(), this.xv.ve(), "splash_ad", true);
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.sr.getActivity(), (com.bytedance.sdk.openadsdk.core.dislike.ui.c) this.ux, this.xv);
        }
        this.ux.c("splash_card");
        this.ux.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void w() {
        if (oo.p(this.xv)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, "splash_ad", "splash_card_close", jSONObject);
                k.c cVar = this.sr;
                if (cVar != null) {
                    cVar.w();
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    protected String xv() {
        me meVar = this.xv;
        if (meVar == null) {
            return "";
        }
        if (TextUtils.isEmpty(meVar.yh())) {
            return (this.xv.ix() == null || TextUtils.isEmpty(this.xv.ix().xv())) ? "" : this.xv.ix().xv();
        }
        return this.xv.yh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(Context context, ViewGroup viewGroup, me meVar) {
        super.c(context, viewGroup, meVar);
        View c4 = c(this.f32977c);
        if (c4 == null) {
            return;
        }
        this.f32978w.addView(c4);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f32980f.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), xk.xv(ls.getContext(), 18.0f));
                }
            });
            this.f32980f.setClipToOutline(true);
            this.f32986r.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), xk.xv(ls.getContext(), 28.0f));
                }
            });
            this.f32986r.setClipToOutline(true);
            xk.c(this.ys, this.xv);
        }
        List<gb> nc = this.xv.nc();
        if (nc != null && nc.size() > 0) {
            com.bytedance.sdk.openadsdk.r.w.c(nc.get(0)).xv(2).c(Bitmap.Config.ARGB_8888).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.3
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(com.bytedance.sdk.component.ux.k<Bitmap> kVar) {
                    Bitmap xv = kVar.xv();
                    if (xv == null) {
                        return;
                    }
                    try {
                        if (xv.getConfig() == Bitmap.Config.RGB_565) {
                            xv = xv.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap c5 = com.bytedance.sdk.component.adexpress.sr.c.c(ux.this.f32977c, xv, 10);
                    if (c5 == null) {
                        return;
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ux.this.f32977c.getResources(), c5);
                    ux.this.ev.setBackground(bitmapDrawable);
                    ux.this.f32986r.setBackground(bitmapDrawable);
                }
            });
        }
        com.bytedance.sdk.openadsdk.r.w.c(this.xv.kr()).c(this.f32983k);
        this.f32979a.setText(xv());
        this.bk.setText(sr());
        this.f32988t.setVisibility(this.xv.bx() ? 0 : 8);
        this.f32988t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ux.this.ux();
            }
        });
        this.f32987s.setText(oo.f(this.xv));
        this.fz.setText(oo.ux(this.xv));
        c(this.xv);
    }

    private void c(me meVar) {
        if (meVar == null || this.f32980f == null || oo.r(meVar) != 1) {
            return;
        }
        xk.c((View) this.f32989u, 0);
        xk.c((View) this.ia, 8);
        TextView textView = this.f32981i;
        if (textView != null) {
            textView.setText(oo.f(meVar));
        }
        if (this.f32985q == null) {
            this.f32985q = new q(ls.getContext(), 1);
        }
        this.f32985q.c(meVar.mc());
        this.f32985q.c(meVar.g());
        this.f32985q.c(new q.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.5
            @Override // com.bytedance.sdk.component.utils.q.c
            public void c(int i4) {
                if (ux.this.f32982j == null || !ux.this.f32980f.isShown() || i4 != 1 || ux.this.f32982j == null) {
                    return;
                }
                if (ux.this.f32982j instanceof com.bytedance.sdk.openadsdk.core.w.c) {
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) ((com.bytedance.sdk.openadsdk.core.w.c) ux.this.f32982j).c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c();
                }
                ux.this.f32982j.onClick(ux.this.f32980f);
            }
        });
        this.f32985q.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f32982j = cVar;
        if (oo.gd(this.xv)) {
            this.f32980f.setOnClickListener(this);
            this.ev.setOnClickListener(this);
            this.f32983k.setOnClickListener(this);
            this.f32979a.setOnClickListener(this);
            this.bk.setOnClickListener(this);
            this.f32984p.setOnClickListener(this);
        }
        this.ia.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar, k.c cVar) {
        super.c(wVar, xvVar, cVar);
        this.f32978w.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.6
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT < 19 || ux.this.f32980f.isAttachedToWindow()) {
                    ux.this.f().run();
                    return;
                }
                ux uxVar = ux.this;
                uxVar.f32978w.postDelayed(uxVar.f(), 20L);
            }
        });
        if (this.sr != null) {
            this.fp.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ux.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(ux.this.xv, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    ux.this.sr.w();
                }
            });
        }
        oo.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(boolean z3) {
        super.c(z3);
        k.c cVar = this.sr;
        if (cVar == null) {
            return;
        }
        if (z3) {
            cVar.c(-1L);
        } else {
            cVar.c();
        }
        q qVar = this.f32985q;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }
}
