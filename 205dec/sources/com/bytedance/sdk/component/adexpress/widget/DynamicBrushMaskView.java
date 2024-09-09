package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicBrushMaskView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f29515c;
    private FrameLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f29516f;
    private volatile boolean gd;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f29517p;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f29518r;
    private Context sr;
    private ObjectAnimator ux;

    /* renamed from: w  reason: collision with root package name */
    private BrushMaskView f29519w;
    private TextView xv;

    public DynamicBrushMaskView(Context context) {
        super(context);
        this.f29517p = false;
        this.sr = context;
        addView(com.bytedance.sdk.component.adexpress.xv.c.ux(context));
        sr();
    }

    public void c() {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (z3) {
            try {
                ObjectAnimator objectAnimator = this.ux;
                if (objectAnimator == null || !(objectAnimator.isStarted() || this.ux.isRunning() || this.f29517p)) {
                    BrushMaskView brushMaskView = this.f29519w;
                    if (brushMaskView != null) {
                        brushMaskView.c();
                    }
                    RelativeLayout relativeLayout = this.f29515c;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    ux();
                }
            } catch (Exception e4) {
                a.f("DynamicBrushMaskView", e4.getMessage());
            }
        }
    }

    public void setBrushText(String str) {
        if (this.xv == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.xv.setText(str);
    }

    private void sr() {
        this.f29519w = (BrushMaskView) findViewById(2097610740);
        this.f29515c = (RelativeLayout) findViewById(2097610737);
        this.f29516f = (ImageView) findViewById(2097610739);
        this.ev = (FrameLayout) findViewById(2097610741);
        this.f29518r = (ImageView) findViewById(2097610736);
        this.ev.setClipChildren(false);
        this.xv = (TextView) findViewById(2097610738);
        BrushMaskView brushMaskView = this.f29519w;
        if (brushMaskView != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                brushMaskView.setWatermark(i.sr(this.sr, "tt_splash_brush_bg"));
            }
            this.f29519w.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBrushMaskView.this.ux == null || !DynamicBrushMaskView.this.ux.isStarted()) {
                            DynamicBrushMaskView.this.ux();
                        }
                    } catch (Exception e4) {
                        a.w("DynamicBrushMaskView", e4.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        if (this.f29519w != null) {
            this.gd = false;
            int c4 = f.c(this.sr);
            int i4 = (c4 * MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            int i5 = (i4 * 80) / MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME;
            this.ev.setLayoutParams(new RelativeLayout.LayoutParams(i4, i5));
            float f4 = i4;
            final float f5 = f4 - (f4 / 3.0f);
            this.f29519w.setEraserSize((this.f29519w.getHeight() * 3) / 5.0f);
            float c5 = f.c(getContext(), 15.0f);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f5, i5 / 2);
            int i6 = i5 / 4;
            layoutParams.topMargin = i6;
            float f6 = f4 / 6.0f;
            int i7 = (int) f6;
            layoutParams.leftMargin = i7;
            layoutParams.setMarginStart(i7);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            this.f29516f.setLayoutParams(layoutParams);
            int i8 = (c4 * 58) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            this.f29518r.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i8, (i8 * 76) / 58);
            layoutParams2.topMargin = (int) (i6 + c5);
            int i9 = (int) (f6 - (c5 * 1.5f));
            layoutParams2.leftMargin = i9;
            layoutParams2.setMarginStart(i9);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.f29515c.setLayoutParams(layoutParams2);
            this.f29519w.c(this.f29519w.getWidth() / 6.0f, this.f29519w.getHeight() / 2.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29515c, "translationX", 0.0f, f5);
            this.ux = ofFloat;
            ofFloat.setDuration(1000L);
            this.ux.setRepeatMode(1);
            this.ux.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    if (DynamicBrushMaskView.this.f29516f != null) {
                        layoutParams.width = (int) (f5 * animatedFraction);
                        DynamicBrushMaskView.this.f29516f.setLayoutParams(layoutParams);
                    }
                }
            });
            this.ux.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (DynamicBrushMaskView.this.f29519w != null) {
                        if (DynamicBrushMaskView.this.f29516f != null) {
                            layoutParams.width = 0;
                            DynamicBrushMaskView.this.f29516f.setLayoutParams(layoutParams);
                        }
                        if (DynamicBrushMaskView.this.gd) {
                            return;
                        }
                        DynamicBrushMaskView.this.f29517p = true;
                        DynamicBrushMaskView.this.f29519w.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DynamicBrushMaskView.this.f29517p = false;
                                if (DynamicBrushMaskView.this.gd) {
                                    return;
                                }
                                DynamicBrushMaskView.this.ux.start();
                            }
                        }, 100L);
                    }
                }
            });
            ObjectAnimator objectAnimator = this.ux;
            if (objectAnimator == null || objectAnimator.isStarted() || this.ux.isRunning() || this.f29517p) {
                return;
            }
            this.ux.start();
        }
    }

    public void w() {
        if (this.gd) {
            return;
        }
        this.gd = true;
        ObjectAnimator objectAnimator = this.ux;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            RelativeLayout relativeLayout = this.f29515c;
            if (relativeLayout != null) {
                relativeLayout.clearAnimation();
                this.f29515c.setVisibility(4);
            }
            this.f29519w.c();
        }
        BrushMaskView brushMaskView = this.f29519w;
        if (brushMaskView != null) {
            brushMaskView.setEraserSize(brushMaskView.getHeight());
            BrushMaskView brushMaskView2 = this.f29519w;
            brushMaskView2.c(0.0f, brushMaskView2.getHeight() / 2.0f);
            this.f29519w.w();
        }
    }

    public void xv() {
        clearAnimation();
    }
}
