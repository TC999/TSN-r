package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.c.xv.sr;
import com.bytedance.sdk.component.widget.recycler.c.xv.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardJointBottomView extends FrameLayout implements xv {

    /* renamed from: c  reason: collision with root package name */
    private float f32649c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private int f32650f;
    private boolean gd;

    /* renamed from: p  reason: collision with root package name */
    private final SlideUpLoadMoreArrow f32651p;

    /* renamed from: r  reason: collision with root package name */
    private View.OnClickListener f32652r;
    private SSWebView sr;
    private sr ux;

    /* renamed from: w  reason: collision with root package name */
    private int[] f32653w;
    private int[] xv;

    public RewardJointBottomView(Context context) {
        super(context);
        this.f32653w = new int[2];
        this.xv = new int[2];
        this.f32650f = 0;
        this.ev = false;
        this.gd = false;
        SSWebView sSWebView = new SSWebView(context);
        this.sr = sSWebView;
        addView(sSWebView, new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 23) {
            this.sr.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i4, int i5, int i6, int i7) {
                    if (Math.abs((RewardJointBottomView.this.sr.getWebView().getHeight() + RewardJointBottomView.this.sr.getWebView().getScrollY()) - (RewardJointBottomView.this.sr.getWebView().getContentHeight() * RewardJointBottomView.this.sr.getWebView().getScale())) < 10.0f) {
                        if (RewardJointBottomView.this.ev) {
                            return;
                        }
                        RewardJointBottomView.this.ev = true;
                        return;
                    }
                    RewardJointBottomView.this.ev = false;
                }
            });
        }
        getScrollingChildHelper().c(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.f32651p = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.c();
    }

    private sr getScrollingChildHelper() {
        if (this.ux == null) {
            this.ux = new sr(this);
        }
        return this.ux;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        Log.d("lfz-debug", "dispatchNestedFling: Y : " + f5 + "; consumed: " + z3);
        return super.dispatchNestedFling(f4, f5, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        Log.d("lfz-debug", "dispatchNestedPreFling: Y : " + f5 + "; consumed: " + this.f32653w);
        return super.dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f32650f = 0;
            this.f32649c = motionEvent.getY();
            c(2, 0);
            this.gd = this.ev;
        } else if (action != 1) {
            if (action == 2) {
                float y3 = motionEvent.getY() - this.f32649c;
                if (y3 < 0.0f) {
                    c();
                    if (c(0, (int) y3, this.f32653w, this.xv, 0)) {
                        y3 -= this.f32653w[1];
                    }
                    this.f32650f += c((int) ((Math.floor((double) Math.abs(y3)) != 0.0d ? y3 : 0.0f) - this.f32650f));
                } else {
                    int i4 = (int) (y3 - this.f32650f);
                    int c4 = c(i4);
                    this.f32650f += c4;
                    c(0, i4 - c4, this.f32653w, this.xv, 0);
                }
            }
        } else if (this.gd && this.f32649c - motionEvent.getY() > 100.0f && (onClickListener = this.f32652r) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public SSWebView getWebView() {
        return this.sr;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f32652r = onClickListener;
    }

    public void w() {
        c();
    }

    public void c(String str) {
        this.sr.c(str);
    }

    public boolean c(int i4, int i5) {
        return getScrollingChildHelper().w(0);
    }

    public boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, i6);
    }

    public int c(int i4) {
        if (i4 < 0) {
            return (int) (-Math.abs(Math.min(this.sr.getWebView().getContentHeight() - (this.sr.getWebView().getHeight() + this.sr.getWebView().getScrollY()), -i4)));
        }
        if (i4 > 0) {
            return Math.min(this.sr.getWebView().getScrollY(), i4);
        }
        return 0;
    }

    public void c() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.f32651p;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.f32651p.w();
        }
    }
}
