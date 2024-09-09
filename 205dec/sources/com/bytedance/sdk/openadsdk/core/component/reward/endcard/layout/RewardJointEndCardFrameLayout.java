package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr.c;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.c.xv.f;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.r.w;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements f {

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f32334f;
    private View sr;
    private RewardJointBottomView ux;
    private FrameLayout xv;

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
    }

    private boolean sr() {
        if (this.f32332w.tz() == 15) {
            return true;
        }
        if (this.f32332w.tz() == 5) {
            return false;
        }
        if (this.f32332w.nc() == null || this.f32332w.nc().isEmpty()) {
            return true;
        }
        gb gbVar = this.f32332w.nc().get(0);
        return gbVar.xv() > gbVar.w();
    }

    private void xv() {
        if (!me.w(this.f32332w)) {
            w.c(this.f32332w.nc().get(0)).c(Bitmap.Config.ARGB_4444).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k<Bitmap> kVar) {
                    Bitmap c4 = c.c(RewardJointEndCardFrameLayout.this.getContext(), kVar.xv(), 25);
                    if (c4 == null) {
                        return;
                    }
                    RewardJointEndCardFrameLayout.this.xv.setBackground(new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), c4));
                }
            });
        } else {
            w.c(ng.w(this.f32332w)).c(Bitmap.Config.ARGB_4444).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k<Bitmap> kVar) {
                    Bitmap c4 = c.c(RewardJointEndCardFrameLayout.this.getContext(), kVar.xv(), 25);
                    if (c4 == null) {
                        return;
                    }
                    RewardJointEndCardFrameLayout.this.f32334f.setBackground(new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), c4));
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xv.f
    public void c(View view, int i4) {
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xv.f
    public void c(View view, int i4, int i5, int i6, int i7, int i8) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.ux.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.f32334f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.c.xv.ux
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return super.onNestedPreFling(view, f4, f5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        xk.c(this.sr, (View.OnClickListener) wVar, "bar_view");
        this.ux.setClickListener(wVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xv.f
    public void w(View view, View view2, int i4, int i5) {
    }

    private void w(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(xk.ux(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(xk.ux(getContext(), 40.0f), xk.ux(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(xk.ux(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, xk.ux(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(xk.ux(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(xk.ux(getContext(), 70.0f), xk.ux(getContext(), 24.0f));
        layoutParams2.setMarginEnd(xk.ux(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, xk.ux(getContext(), 60.0f)));
        this.sr = linearLayout;
        gb kr = this.f32332w.kr();
        if (kr != null && !TextUtils.isEmpty(kr.c())) {
            w.c(kr).c(tTRoundRectImageView);
        } else {
            tTRoundRectImageView.setImageDrawable(i.xv(getContext(), "tt_ad_logo_small"));
        }
        if (this.f32332w.ix() != null && !TextUtils.isEmpty(this.f32332w.ix().xv())) {
            textView.setText(this.f32332w.ix().xv());
        } else {
            textView.setText(this.f32332w.yh());
        }
        textView2.setText(this.f32332w.ny());
        textView3.setText(this.f32332w.dk());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        c(linearLayout);
        w(linearLayout);
        xv(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private void xv(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext());
        this.ux = rewardJointBottomView;
        if (sr()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, xk.ux(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.c(u.c(this.f32332w));
    }

    private void c(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.xv = frameLayout;
        if (sr()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, xk.ux(getContext(), 200.0f)));
        }
        xv();
        if (!me.w(this.f32332w)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            w.c(this.f32332w.nc().get(0)).c(Bitmap.Config.ARGB_4444).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k<Bitmap> kVar) {
                    imageView.setImageBitmap(kVar.xv());
                }
            });
            return;
        }
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.f32334f = frameLayout2;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xv.f
    public boolean c(View view, View view2, int i4, int i5) {
        return sr();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.c.xv.f
    public void c(View view, int i4, int i5, int[] iArr, int i6) {
        int c4 = c(i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ux.getLayoutParams();
        layoutParams.height -= c4;
        this.ux.setLayoutParams(layoutParams);
        if (c4 != 0) {
            this.f32331c.bj().oo();
        }
        iArr[1] = iArr[1] + c4;
    }

    private int c(int i4) {
        if (i4 > 0) {
            int height = this.ux.getHeight() - xk.ux(getContext(), 200.0f);
            if (height > 0) {
                if (height < Math.abs(i4)) {
                    i4 = height;
                }
            }
            i4 = 0;
        } else {
            int height2 = this.xv.getHeight() - xk.ux(getContext(), 160.0f);
            if (height2 > 0) {
                if (height2 < Math.abs(i4)) {
                    i4 = -height2;
                }
            }
            i4 = 0;
        }
        if (Math.abs(i4) > 400) {
            return 0;
        }
        return i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void w() {
        super.w();
        RewardJointBottomView rewardJointBottomView = this.ux;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.w();
        }
    }
}
