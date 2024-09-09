package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.bk;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends w {
    protected int bk;
    private TextView fp;
    private TTRatingBar fz;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f32473i;
    private TextView ia;

    /* renamed from: s  reason: collision with root package name */
    private TextView f32474s;

    /* renamed from: t  reason: collision with root package name */
    protected final AtomicBoolean f32475t;

    /* renamed from: u  reason: collision with root package name */
    private FrameLayout f32476u;
    private TTRoundRectImageView ys;

    public xv(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
        this.bk = 0;
        this.f32475t = new AtomicBoolean(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:3)|4|5|6|(2:10|(7:12|13|14|15|(1:18)|19|(1:21)(4:23|(2:25|(1:(1:28)(1:(1:30))))(2:36|(2:38|(2:46|(1:(1:51)(1:(1:53))))(1:(1:43)(1:(1:45)))))|(1:34)|35)))|58|13|14|15|(1:18)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String ev() {
        /*
            r7 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r0 = r7.f32472w
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.eq.wv.ux(r0)
            if (r0 != 0) goto La
            java.lang.String r0 = ""
        La:
            r1 = 0
            r2 = 1
            java.util.Locale r3 = java.util.Locale.CHINESE     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3f
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3f
            if (r3 != 0) goto L33
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3f
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3f
            if (r3 != 0) goto L33
            java.util.Locale r3 = java.util.Locale.TRADITIONAL_CHINESE     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3f
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3f
            if (r3 == 0) goto L31
            goto L33
        L31:
            r3 = 0
            goto L34
        L33:
            r3 = 1
        L34:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = r4.getLanguage()     // Catch: java.lang.Throwable -> L40
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Throwable -> L40
            goto L41
        L3f:
            r3 = 1
        L40:
            r0 = 0
        L41:
            java.lang.String r4 = "\u4e0b\u8f7d"
            if (r3 == 0) goto L46
            goto L4a
        L46:
            if (r0 == 0) goto L4a
            java.lang.String r4 = "Install"
        L4a:
            com.bytedance.sdk.openadsdk.core.u.me r5 = r7.xv
            if (r5 != 0) goto L4f
            return r4
        L4f:
            java.lang.String r5 = r5.dk()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L6c
            com.bytedance.sdk.openadsdk.core.u.me r1 = r7.xv
            int r1 = r1.v()
            r2 = 4
            if (r1 == r2) goto La9
            if (r3 == 0) goto L67
            java.lang.String r4 = "\u67e5\u770b"
            goto La9
        L67:
            if (r0 == 0) goto La9
            java.lang.String r4 = "View"
            goto La9
        L6c:
            com.bytedance.sdk.openadsdk.core.u.me r4 = r7.xv
            java.lang.String r4 = r4.dk()
            if (r4 == 0) goto La9
            boolean r5 = com.bytedance.sdk.openadsdk.core.eq.wv.f(r4)
            if (r5 == 0) goto L8f
            int r5 = r4.length()
            r6 = 2
            if (r5 <= r6) goto L8f
            if (r3 == 0) goto L88
            java.lang.String r4 = r7.c(r2)
            goto La9
        L88:
            if (r0 == 0) goto La9
            java.lang.String r4 = r7.c(r1)
            goto La9
        L8f:
            boolean r5 = com.bytedance.sdk.openadsdk.core.eq.wv.f(r4)
            if (r5 != 0) goto La9
            int r5 = r4.length()
            r6 = 7
            if (r5 <= r6) goto La9
            if (r3 == 0) goto La3
            java.lang.String r4 = r7.c(r2)
            goto La9
        La3:
            if (r0 == 0) goto La9
            java.lang.String r4 = r7.c(r1)
        La9:
            if (r0 == 0) goto Lc8
            boolean r0 = com.bytedance.sdk.openadsdk.core.eq.wv.f(r4)
            if (r0 != 0) goto Lc8
            android.widget.TextView r0 = r7.f32474s
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r1 = r7.f32472w
            r2 = 1082130432(0x40800000, float:4.0)
            int r1 = com.bytedance.sdk.openadsdk.core.eq.xk.ux(r1, r2)
            r0.bottomMargin = r1
            android.widget.TextView r1 = r7.f32474s
            r1.setLayoutParams(r0)
        Lc8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.layout.xv.ev():java.lang.String");
    }

    private void f() {
        if (this.sr == 1) {
            TextView textView = this.fp;
            if (textView != null) {
                textView.setMaxWidth((int) xk.xv(this.f32472w, 153.0f));
            }
        } else {
            TextView textView2 = this.fp;
            if (textView2 != null) {
                textView2.setMaxWidth((int) xk.xv(this.f32472w, 404.0f));
            }
        }
        if (this.f32468f) {
            return;
        }
        xk.c((View) this.ev, 0);
    }

    private void r() {
        if (this.xv.up() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            bk.c((LinearLayout) this.f32472w.findViewById(2114387902), new bk.c().c(iArr[0]).w(Color.parseColor("#80000000")).c(iArr).xv(xk.ux(this.f32472w, 17.0f)).sr(0).ux(xk.ux(this.f32472w, 3.0f)));
        }
    }

    private void sr() {
        String str;
        if (this.ia == null) {
            return;
        }
        int f4 = this.xv.ix() != null ? this.xv.ix().f() : 6870;
        if (f4 > 10000) {
            str = (f4 / 10000) + "\u4e07";
        } else {
            str = f4 + "";
        }
        this.ia.setText(String.format("%1$s\u4e2a\u8bc4\u5206", str));
    }

    private void ux() {
        TextView textView = this.f32474s;
        if (textView != null) {
            textView.setText(this.xv.up() == 3 ? ev() : w());
        }
    }

    private void xv() {
        if (this.ys != null) {
            gb kr = this.xv.kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                com.bytedance.sdk.openadsdk.r.w.c(kr).c(this.ys);
            } else {
                this.ys.setImageDrawable(i.xv(this.f32472w, "tt_ad_logo_small"));
            }
        }
        if (this.fp != null) {
            if (this.sr == 1 && this.xv.ix() != null && !TextUtils.isEmpty(this.xv.ix().xv())) {
                this.fp.setText(this.xv.ix().xv());
            } else {
                this.fp.setText(this.xv.ny());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        FrameLayout frameLayout;
        super.c();
        this.ev = (RelativeLayout) this.f32472w.findViewById(2114387648);
        this.ys = (TTRoundRectImageView) this.f32472w.findViewById(2114387795);
        this.fp = (TextView) this.f32472w.findViewById(2114387878);
        this.ia = (TextView) this.f32472w.findViewById(2114387629);
        this.f32474s = (TextView) this.f32472w.findViewById(2114387833);
        TTRatingBar tTRatingBar = (TTRatingBar) this.f32472w.findViewById(2114387608);
        this.fz = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.fz.setStarFillNum(4);
            this.fz.setStarImageWidth(xk.ux(this.f32472w, 15.0f));
            this.fz.setStarImageHeight(xk.ux(this.f32472w, 14.0f));
            this.fz.setStarImagePadding(xk.ux(this.f32472w, 4.0f));
            this.fz.c();
        }
        this.f32470p = (TextView) this.f32472w.findViewById(2114387657);
        this.gd = (FrameLayout) this.f32472w.findViewById(2114387641);
        this.f32476u = (FrameLayout) this.f32472w.findViewById(2114387964);
        this.f32473i = (FrameLayout) this.f32472w.findViewById(2114387931);
        xk.c(this.f32470p, this.xv);
        try {
            if (this.sr == 2 && this.xv.up() == 1 && (this.f32474s.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32474s.getLayoutParams();
                layoutParams.height = (int) xk.xv(this.f32472w, 55.0f);
                layoutParams.topMargin = (int) xk.xv(this.f32472w, 20.0f);
                this.f32474s.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ev.getLayoutParams();
                layoutParams2.bottomMargin = (int) xk.xv(this.f32472w, 12.0f);
                this.ev.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.xv.up() == 1 && (frameLayout = this.gd) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gd.getLayoutParams();
            int sr = xk.sr((Context) this.f32472w);
            layoutParams3.width = sr;
            int i4 = (sr * 9) / 16;
            layoutParams3.height = i4;
            this.gd.setLayoutParams(layoutParams3);
            this.bk = (xk.ux((Context) this.f32472w) - i4) / 2;
        }
        xv();
        sr();
        ux();
        f();
        r();
        k();
    }

    protected String w() {
        me meVar = this.xv;
        if (meVar == null) {
            return "\u7acb\u5373\u4e0b\u8f7d";
        }
        if (TextUtils.isEmpty(meVar.dk())) {
            return this.xv.v() != 4 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u4e0b\u8f7d";
        }
        return this.xv.dk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void w(int i4) {
        int i5;
        if (this.ev == null || (i5 = this.f32466a) == -1 || i4 != i5 || this.f32475t.getAndSet(true)) {
            return;
        }
        xk.c((View) this.ev, 0);
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ev, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    private String c(boolean z3) {
        me meVar = this.xv;
        if (meVar == null) {
            return null;
        }
        return z3 ? meVar.v() == 4 ? "\u4e0b\u8f7d" : "\u67e5\u770b" : meVar.v() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        me meVar = this.xv;
        if (meVar != null && meVar.mt() != null) {
            if (this.xv.mt().ux) {
                xk.c((View) this.f32474s, (View.OnClickListener) wVar, (String) null);
                xk.c((View) this.f32474s, (View.OnTouchListener) wVar, (String) null);
            } else {
                xk.c((View) this.f32474s, (View.OnClickListener) wVar2, (String) null);
                xk.c((View) this.f32474s, (View.OnTouchListener) wVar2, (String) null);
            }
            if (this.xv.up() == 1) {
                if (this.xv.mt().f34813c) {
                    c((View.OnTouchListener) wVar);
                    c((View.OnClickListener) wVar);
                } else {
                    c((View.OnTouchListener) wVar2);
                    c((View.OnClickListener) wVar2);
                }
            } else if (this.xv.mt().xv) {
                xk.c((View) this.ev, (View.OnClickListener) wVar, "TTBaseVideoActivity#mRlDownloadBar");
                xk.c((View) this.ev, (View.OnTouchListener) wVar, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                xk.c((View) this.ev, (View.OnClickListener) wVar2, "TTBaseVideoActivity#mRlDownloadBar");
                xk.c((View) this.ev, (View.OnTouchListener) wVar2, (String) null);
            }
        }
        me meVar2 = this.xv;
        if (meVar2 != null && meVar2.mt() != null) {
            if (this.xv.mt().f34814f) {
                xk.c((View) this.gd, (View.OnClickListener) wVar, "TTBaseVideoActivity#mVideoNativeFrame");
                xk.c((View) this.gd, (View.OnTouchListener) wVar, "TTBaseVideoActivity#mVideoNativeFrame");
            } else {
                xk.c((View) this.gd, (View.OnClickListener) wVar2, "TTBaseVideoActivity#mVideoNativeFrame");
                xk.c((View) this.gd, (View.OnTouchListener) wVar2, "TTBaseVideoActivity#mVideoNativeFrame");
            }
        }
        me meVar3 = this.xv;
        if (meVar3 == null || meVar3.up() != 1) {
            return;
        }
        if (this.xv.mt() != null && (frameLayout2 = this.f32476u) != null) {
            xk.c((View) frameLayout2, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32476u.getLayoutParams();
            layoutParams.height = this.bk;
            this.f32476u.setLayoutParams(layoutParams);
            if (this.xv.mt().f34815w) {
                this.f32476u.setOnClickListener(wVar);
                this.f32476u.setOnTouchListener(wVar);
            } else {
                this.f32476u.setOnClickListener(wVar2);
                this.f32476u.setOnTouchListener(wVar2);
            }
        }
        if (this.xv.mt() == null || (frameLayout = this.f32473i) == null) {
            return;
        }
        xk.c((View) frameLayout, 0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f32473i.getLayoutParams();
        layoutParams2.height = this.bk;
        this.f32473i.setLayoutParams(layoutParams2);
        if (this.xv.mt().sr) {
            this.f32473i.setOnClickListener(wVar);
            this.f32473i.setOnTouchListener(wVar);
            return;
        }
        this.f32473i.setOnClickListener(wVar2);
        this.f32473i.setOnTouchListener(wVar2);
    }

    private void c(View.OnTouchListener onTouchListener) {
        xk.c(this.ev, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        xk.c(this.fp, onTouchListener, (String) null);
        xk.c(this.ys, onTouchListener, (String) null);
        xk.c(this.ia, onTouchListener, (String) null);
        xk.c(this.fz, onTouchListener, (String) null);
    }

    private void c(View.OnClickListener onClickListener) {
        xk.c(this.ev, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        xk.c(this.fp, onClickListener, (String) null);
        xk.c(this.ys, onClickListener, (String) null);
        xk.c(this.ia, onClickListener, (String) null);
        xk.c(this.fz, onClickListener, (String) null);
    }
}
