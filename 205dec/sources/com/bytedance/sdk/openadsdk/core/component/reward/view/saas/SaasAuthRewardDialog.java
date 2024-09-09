package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.y;
import com.bytedance.sdk.openadsdk.core.w.c;
import com.bytedance.sdk.openadsdk.core.w.c.w.f;
import com.bytedance.sdk.openadsdk.core.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private SaasAuthEnvelope f32672c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32673f;
    private int gd;

    /* renamed from: r  reason: collision with root package name */
    private me f32674r;
    private RotateAnimation sr;
    private ScaleAnimation ux;

    /* renamed from: w  reason: collision with root package name */
    private BaseSaasEnvelope f32675w;
    private ImageView xv;

    public SaasAuthRewardDialog(@NonNull Context context) {
        super(context);
        this.f32673f = false;
        c(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xk.w(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.ux = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.ux.setFillAfter(true);
            this.ux.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.sr = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.sr.setDuration(5000L);
                    SaasAuthRewardDialog.this.sr.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.sr.setFillAfter(true);
                    SaasAuthRewardDialog.this.sr.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.xv.startAnimation(SaasAuthRewardDialog.this.sr);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.xv.startAnimation(this.ux);
            xk.w(true);
            setVisibility(0);
            this.f32672c.c();
            ev.w().postDelayed(this, 2000L);
        } else if (!this.f32673f) {
            ev.w().postDelayed(this, 5000L);
            w();
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f32673f = true;
        y sk = this.f32674r.sk();
        if (sk.p() != null) {
            this.f32675w = new SaasAuthCouponEnvelope(getContext(), sk.p());
        } else if (sk.k() != null) {
            this.f32675w = new SaasAuthProductEnvelope(getContext(), sk.k());
        }
        View view = this.f32675w;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
            this.f32675w.c();
            c cVar = new c(getContext(), this.f32674r, this.ev, this.gd);
            setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
            ((f) cVar.c(f.class)).c(101);
            setOnClickListener(cVar);
            this.f32675w.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    SaasAuthRewardDialog.this.c();
                }
            });
            this.f32675w.setOnButtonClickListener(cVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.f32672c;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.w();
        }
        removeView(this.f32672c);
    }

    public void c(me meVar, String str, int i4) {
        if (meVar != null && TTLiveCommerceHelper.getInstance().getLiveSdkStatus() == 2) {
            y sk = meVar.sk();
            if (sk != null && ((sk.k() != null || sk.p() != null) && sk.gd())) {
                this.f32674r = meVar;
                this.ev = str;
                this.gd = i4;
                setBackgroundColor(Color.parseColor("#aa000000"));
                ev.w().postDelayed(this, 5000L);
                c(getContext());
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    private void c(Context context) {
        ImageView imageView = new ImageView(context);
        this.xv = imageView;
        try {
            imageView.setImageResource(i.sr(context, "tt_saas_light_shine"));
            this.xv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int sr = com.bytedance.sdk.openadsdk.core.eq.xk.sr(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sr, sr);
        layoutParams.addRule(13);
        addView(this.xv, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.f32672c = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387463);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.f32672c, layoutParams2);
        this.f32672c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.w();
                ev.w().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.f32672c.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.c();
            }
        });
    }

    public void c() {
        SaasAuthEnvelope saasAuthEnvelope = this.f32672c;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.w();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.f32675w;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.w();
        }
        RotateAnimation rotateAnimation = this.sr;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.sr = null;
        }
        ScaleAnimation scaleAnimation = this.ux;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.ux = null;
        }
        ev.w().removeCallbacks(this);
        setVisibility(8);
        xk.w(false);
    }
}
