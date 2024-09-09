package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.w;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.PlayableLoadingView;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private RewardLpBottomView f32333f;
    private SSWebView sr;
    private FrameLayout ux;
    private SSWebView xv;

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void c() {
        setId(2114387541);
        SSWebView sSWebView = new SSWebView(this.f32331c);
        sSWebView.setId(2114387696);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.xv = sSWebView;
        addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f32331c);
        linearLayout.setId(2114387540);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.f32331c);
        playableEndcardFrameLayout.setId(2114387674);
        SSWebView sSWebView2 = new SSWebView(this.f32331c);
        sSWebView2.setId(2114387862);
        sSWebView2.setLayerType(2, null);
        sSWebView2.setVisibility(4);
        this.sr = sSWebView2;
        playableEndcardFrameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.f32331c);
        frameLayout.setId(2114387924);
        frameLayout.setVisibility(8);
        playableEndcardFrameLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout w3 = ux.w(this.f32331c);
        w3.setBackgroundColor(-1);
        playableEndcardFrameLayout.addView(w3, new FrameLayout.LayoutParams(-1, -1));
        PlayableLoadingView playableLoadingView = new PlayableLoadingView(this.f32331c);
        playableLoadingView.setId(2114387927);
        playableLoadingView.setClickable(true);
        playableLoadingView.setFocusable(true);
        playableEndcardFrameLayout.addView(playableLoadingView, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.f32331c);
        rewardLpBottomView.setId(2114387827);
        rewardLpBottomView.setVisibility(8);
        this.f32333f = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        playableEndcardFrameLayout.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(playableEndcardFrameLayout, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.f32331c);
        linearLayout2.setId(2114387721);
        linearLayout2.setBackgroundColor(Color.parseColor("#161823"));
        linearLayout2.setGravity(1);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(xk.ux(this.f32331c, 16.0f), xk.ux(this.f32331c, 8.0f), xk.ux(this.f32331c, 16.0f), xk.ux(this.f32331c, 8.0f));
        linearLayout2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 80;
        linearLayout.addView(linearLayout2, layoutParams3);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.f32331c);
        frameLayout2.setId(2114387800);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.ux = frameLayout2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void w() {
        super.w();
        RewardLpBottomView rewardLpBottomView = this.f32333f;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.w();
        }
    }
}
