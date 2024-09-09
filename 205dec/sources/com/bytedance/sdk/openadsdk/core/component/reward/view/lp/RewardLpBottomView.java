package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardLpBottomView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private boolean f32662c;

    /* renamed from: w  reason: collision with root package name */
    private SlideUpLoadMoreArrow f32663w;
    private RewardLandingPageAppInfoView xv;

    public RewardLpBottomView(Context context) {
        super(context);
        this.f32662c = false;
    }

    private void sr() {
        if (this.xv == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.xv == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.xv.getMeasuredHeight();
                View findViewById = RewardLpBottomView.this.getRootView().findViewById(2114387657);
                if (findViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    findViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    private void xv() {
        this.f32663w = new SlideUpLoadMoreArrow(getContext(), this.f32662c ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.f32663w, layoutParams);
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.xv;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }

    public void w() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.f32663w) != null) {
            slideUpLoadMoreArrow.w();
            this.f32663w.setVisibility(8);
        }
    }

    public void c(me meVar, String str) {
        if (meVar == null) {
            return;
        }
        this.f32662c = c(meVar);
        xv();
        if (!fp.xv(meVar)) {
            w(meVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -2013265920}));
    }

    private void w(me meVar, String str) {
        if (this.f32662c) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.xv = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.c(meVar, str);
            addView(this.xv, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private boolean c(me meVar) {
        return meVar.v() == 4;
    }

    public void c() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.f32663w;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.c();
        }
        sr();
    }
}
