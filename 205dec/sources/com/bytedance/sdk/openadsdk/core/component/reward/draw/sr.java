package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.f;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.video.w.c;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends RecyclerView.j implements n.c {
    private boolean ba;

    /* renamed from: c  reason: collision with root package name */
    public FullRewardExpressView f32274c;
    protected final AtomicBoolean ck;
    private boolean eq;
    public f gb;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f32275i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f32276j;
    public TTProgressBar ls;
    private int me;

    /* renamed from: n  reason: collision with root package name */
    protected final AtomicBoolean f32277n;
    private int pr;

    /* renamed from: q  reason: collision with root package name */
    public FrameLayout f32278q;

    /* renamed from: u  reason: collision with root package name */
    public FrameLayout f32279u;

    /* renamed from: w  reason: collision with root package name */
    public ViewGroup f32280w;
    private xv.c wv;
    private final AnimatorSet wx;
    private final n xk;
    public FrameLayout xv;

    /* renamed from: y  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.w f32281y;
    private LinearLayout yu;

    /* renamed from: z  reason: collision with root package name */
    private boolean f32282z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 <= 0.38f ? f4 * 2.631579f : (f4 * (-1.6129032f)) + 1.6129032f;
        }
    }

    public sr(View view) {
        super(view);
        this.xk = new n(Looper.getMainLooper(), this);
        this.wx = new AnimatorSet();
        this.f32277n = new AtomicBoolean(false);
        this.ck = new AtomicBoolean(false);
        this.pr = Integer.MAX_VALUE;
        this.f32280w = (ViewGroup) view.findViewById(2114387896);
        this.xv = (FrameLayout) view.findViewById(2114387780);
        this.f32279u = (FrameLayout) view.findViewById(2114387815);
        this.f32275i = (FrameLayout) view.findViewById(2114387669);
        this.f32278q = (FrameLayout) view.findViewById(2114387824);
        this.f32276j = (FrameLayout) view.findViewById(2114387678);
        this.ls = (TTProgressBar) view.findViewById(2114387769);
        c(view.getContext());
    }

    private void bw() {
        FullRewardExpressView fullRewardExpressView = this.f32274c;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.a();
        }
        this.pr = Integer.MAX_VALUE;
        this.ba = false;
        this.f32282z = false;
        this.eq = false;
        this.f32279u.removeAllViews();
        this.f32275i.removeAllViews();
        this.f32278q.removeAllViews();
        this.f32276j.removeAllViews();
        this.f32277n.set(false);
        this.ck.set(false);
        this.xv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        f fVar = this.gb;
        if (fVar != null) {
            fVar.p();
        }
    }

    public long eq() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = this.f32281y;
        if (wVar == null) {
            return -1L;
        }
        return wVar.a();
    }

    public void me() {
        f fVar = this.gb;
        if (fVar != null) {
            fVar.f();
        }
    }

    public boolean pr() {
        return this.ck.get();
    }

    public void wv() {
        f fVar = this.gb;
        if (fVar != null) {
            fVar.ev();
        }
    }

    public boolean wx() {
        f fVar = this.gb;
        if (fVar == null) {
            return false;
        }
        return fVar.n();
    }

    public void xk() {
        FullRewardExpressView fullRewardExpressView = this.f32274c;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.a();
        }
        f fVar = this.gb;
        if (fVar != null) {
            fVar.gd();
        }
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv yu() {
        return this.gb;
    }

    public void sr() {
        if (this.gb != null && this.f32282z && this.ba) {
            this.f32281y.p();
            this.f32274c.ys();
            if (this.eq && this.gb.gb()) {
                xv(this.f32281y.f());
                wv();
                return;
            }
            this.eq = true;
            this.xk.sendEmptyMessageDelayed(101, 5000L);
            this.f32281y.c(this.f32274c);
            this.gb.c(this.f32281y.k());
        }
    }

    public void xv() {
        if (this.wx.isStarted() && this.wx.isRunning()) {
            this.wx.cancel();
        }
    }

    public void c(final com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar, float f4, float f5) {
        this.f32281y = wVar;
        bw();
        this.ls.setVisibility(0);
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.f32280w.getContext(), wVar.c(), com.bytedance.sdk.openadsdk.core.eq.n.c(7, String.valueOf(wv.gd(wVar.c())), f4, f5), wVar.w(), false);
        this.f32274c = fullRewardExpressView;
        fullRewardExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f6, float f7) {
                if (sr.this.f32274c.fz()) {
                    sr.this.f32278q.setVisibility(8);
                    sr srVar = sr.this;
                    srVar.f32276j.addView(srVar.c(view.getContext(), wVar));
                    sr.this.f32276j.setVisibility(0);
                } else {
                    sr srVar2 = sr.this;
                    srVar2.f32274c.c((ViewGroup) srVar2.xv, false);
                }
                sr srVar3 = sr.this;
                srVar3.me = srVar3.f32274c.getDynamicShowType();
                sr.this.ba = true;
                sr.this.sr();
                sr.this.ls.setVisibility(8);
            }
        });
        this.f32274c.setExpressVideoListenerProxy(new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public int S_() {
                if (sr.this.f32277n.get()) {
                    return 4;
                }
                sr srVar = sr.this;
                if (srVar.gb == null || !srVar.eq) {
                    return 2;
                }
                if (sr.this.gb.ng()) {
                    return 5;
                }
                if (sr.this.gb.q()) {
                    return 1;
                }
                if (sr.this.gb.ok()) {
                    return 2;
                }
                sr.this.gb.gb();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public int T_() {
                f fVar = sr.this.gb;
                if (fVar == null) {
                    return 0;
                }
                return (int) (fVar.k() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void U_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void V_() {
                sr.this.ck.set(true);
                if (sr.this.f32282z) {
                    sr.this.wv.c();
                    sr.this.f32281y.w(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void W_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void X_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void Y_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void a_(boolean z3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(float f6) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(int i4) {
                sr srVar = sr.this;
                f fVar = srVar.gb;
                if (fVar == null) {
                    return;
                }
                if (i4 == 2) {
                    fVar.r(true);
                    if (sr.this.f32282z) {
                        sr.this.me();
                    }
                } else if (i4 != 3) {
                } else {
                    srVar.ck.set(false);
                    sr.this.gb.r(false);
                    if (sr.this.f32282z) {
                        sr.this.wv.w();
                        sr.this.wv();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(int i4, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void ev() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void f() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public long getActualPlayDuration() {
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void setPauseFromExpressView(boolean z3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void w(int i4) {
                sr.this.wv.c(i4);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public long xv() {
                return sr.this.gb.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(float f6, float f7, float f8, float f9, int i4) {
                sr.this.c(f6, f7, f8, f9, i4);
            }
        });
        this.f32274c.setOnVideoSizeChangeListener(new FullRewardExpressView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.c
            public void c(int i4) {
                sr.this.pr = i4;
            }
        });
        this.f32278q.addView(this.f32274c);
        f fVar = new f(this.f32280w.getContext(), this.f32279u, wVar.c());
        this.gb = fVar;
        this.f32274c.setVideoController(fVar);
        wVar.c(this.f32279u, this.f32275i, this.f32274c);
        this.gb.c(new w(wVar.ux(), pr.xv(this.f32281y.c()), new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.w.c
            public void c(boolean z3) {
                sr.this.sr(z3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.sr.w.c
            public void c() {
                sr.this.wv.sr();
            }
        }, this.xk));
        this.gb.w(this.f32281y.a());
        this.f32274c.fp();
        this.f32274c.ia();
    }

    public void w(boolean z3) {
        if (this.f32282z == z3) {
            return;
        }
        this.f32282z = z3;
        if (z3) {
            sr();
            return;
        }
        me();
        xk.c((View) this.yu, 8);
        this.wx.cancel();
    }

    public void xv(boolean z3) {
        f fVar = this.gb;
        if (fVar != null) {
            fVar.w(z3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class w implements c.InterfaceC0520c {

        /* renamed from: c  reason: collision with root package name */
        private final c.InterfaceC0520c f32288c;
        private final int sr;
        private final n ux;

        /* renamed from: w  reason: collision with root package name */
        private final c f32289w;
        private boolean xv = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface c {
            void c();

            void c(boolean z3);
        }

        w(c.InterfaceC0520c interfaceC0520c, int i4, c cVar, n nVar) {
            this.f32288c = interfaceC0520c;
            this.f32289w = cVar;
            this.sr = i4;
            this.ux = nVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c() {
            this.xv = false;
            c.InterfaceC0520c interfaceC0520c = this.f32288c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c();
            }
            c cVar = this.f32289w;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void w() {
            c(true);
            c.InterfaceC0520c interfaceC0520c = this.f32288c;
            if (interfaceC0520c != null) {
                interfaceC0520c.w();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void xv() {
            c.InterfaceC0520c interfaceC0520c = this.f32288c;
            if (interfaceC0520c != null) {
                interfaceC0520c.xv();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c(int i4, String str) {
            c(true);
            this.xv = false;
            c.InterfaceC0520c interfaceC0520c = this.f32288c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c(i4, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
        public void c(long j4, long j5) {
            this.ux.removeMessages(101);
            if (j5 > 20000 && ((float) j4) > ((float) Math.min(this.sr * 1000, j5)) * 0.75f) {
                c(false);
                this.xv = true;
            }
            c.InterfaceC0520c interfaceC0520c = this.f32288c;
            if (interfaceC0520c != null) {
                interfaceC0520c.c(j4, j5);
            }
        }

        private void c(boolean z3) {
            c cVar;
            if (this.xv || (cVar = this.f32289w) == null) {
                return;
            }
            cVar.c(z3);
        }
    }

    public void w() {
        if (this.wx.isStarted() && this.wx.isPaused()) {
            this.wx.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(boolean z3) {
        if (this.f32282z) {
            if (this.pr > xk.ux(this.sr.getContext()) * 0.7f) {
                xk.c((View) this.yu, 0);
                this.wx.start();
            }
            if (!z3 || this.f32277n.get()) {
                return;
            }
            xk.c(this.f32280w.getContext(), "\u89c6\u9891\u52a0\u8f7d\u9519\u8bef\uff0c\u8bf7\u4e0a\u6ed1\u6d4f\u89c8\u5176\u4ed6\u5185\u5bb9");
            this.f32277n.set(true);
        }
    }

    public View c(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar) {
        String dk;
        String str;
        View ys = ux.ys(context);
        RelativeLayout relativeLayout = (RelativeLayout) ys.findViewById(2114387648);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) ys.findViewById(2114387795);
        TextView textView = (TextView) ys.findViewById(2114387878);
        TextView textView2 = (TextView) ys.findViewById(2114387629);
        TextView textView3 = (TextView) ys.findViewById(2114387833);
        TTRatingBar tTRatingBar = (TTRatingBar) ys.findViewById(2114387608);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(xk.ux(context, 15.0f));
            tTRatingBar.setStarImageHeight(xk.ux(context, 14.0f));
            tTRatingBar.setStarImagePadding(xk.ux(context, 4.0f));
            tTRatingBar.c();
        }
        if (tTRoundRectImageView != null) {
            gb kr = wVar.c().kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                com.bytedance.sdk.openadsdk.r.w.c(kr).c(tTRoundRectImageView);
            } else {
                tTRoundRectImageView.setImageDrawable(i.xv(context, "tt_ad_logo_small"));
            }
        }
        if (textView != null) {
            if (wVar.c().ix() != null && !TextUtils.isEmpty(wVar.c().ix().xv())) {
                textView.setText(wVar.c().ix().xv());
            } else {
                textView.setText(wVar.c().ny());
            }
        }
        if (textView2 != null) {
            int f4 = wVar.c().ix() != null ? wVar.c().ix().f() : 6870;
            String c4 = i.c(context, "tt_comment_num");
            if (f4 > 10000) {
                str = (f4 / 10000) + "\u4e07";
            } else {
                str = f4 + "";
            }
            textView2.setText(String.format(c4, str));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(wVar.c().dk())) {
                dk = wVar.c().v() != 4 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u4e0b\u8f7d";
            } else {
                dk = wVar.c().dk();
            }
            textView3.setText(dk);
        }
        xk.c((View) relativeLayout, (View.OnClickListener) wVar.xv(), "reward_draw_listener");
        return ys;
    }

    public void c() {
        if (this.wx.isStarted() && this.wx.isRunning()) {
            this.wx.pause();
        }
    }

    private void c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.yu = linearLayout;
        linearLayout.setClipChildren(false);
        this.yu.setGravity(1);
        this.yu.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(i.xv(context, "ic_back_light"));
        this.yu.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(i.xv(context, "ic_back_light"));
        imageView2.setAlpha(0.7f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = xk.ux(context, -8.0f);
        this.yu.addView(imageView2, layoutParams);
        TextView textView = new TextView(context);
        textView.setGravity(1);
        textView.setTextColor(-1);
        textView.setText("\u4e0a\u6ed1\u6d4f\u89c8\u66f4\u591a\u5185\u5bb9");
        this.yu.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = xk.ux(context, 156.0f);
        this.f32280w.addView(this.yu, layoutParams2);
        this.f32280w.setClipChildren(false);
        this.yu.setVisibility(8);
        c(imageView, imageView2);
    }

    private void c(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new c());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, xk.ux(this.f32280w.getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new c());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", xk.ux(this.f32280w.getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.wx.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void c(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = this.f32281y;
        if (wVar == null || wVar.xv() == null) {
            return;
        }
        this.f32281y.xv().onClick(view);
    }

    public void c(float f4, float f5, float f6, float f7, int i4) {
        FullRewardExpressView fullRewardExpressView = this.f32274c;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.f32274c.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.f32274c.getVideoFrameLayout().getMeasuredHeight();
        if (this.gb.ox()) {
            this.f32274c.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f5))).setDuration(i4).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f4, 1.0f, f5, measuredWidth * f6, measuredHeight * f7);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i4);
        this.f32274c.getVideoFrameLayout().startAnimation(scaleAnimation);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 101) {
            return;
        }
        sr(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = this.f32281y;
        if (wVar != null) {
            wVar.ev();
        }
    }

    public void c(xv.c cVar) {
        f fVar;
        this.wv = cVar;
        if (cVar == null || (fVar = this.gb) == null) {
            return;
        }
        fVar.c(cVar.xv());
    }
}
