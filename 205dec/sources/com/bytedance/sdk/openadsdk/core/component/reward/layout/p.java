package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends w {
    private float bk;

    /* renamed from: t  reason: collision with root package name */
    private float f32447t;
    private FullSwiperView ys;

    public p(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
    }

    public void c(float[] fArr) {
        this.bk = fArr[0];
        this.f32447t = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void p() {
        super.p();
        FullSwiperView fullSwiperView = this.ys;
        if (fullSwiperView != null) {
            fullSwiperView.ux();
        }
    }

    public void sr() {
        FullSwiperView fullSwiperView = this.ys;
        if (fullSwiperView != null) {
            fullSwiperView.sr();
        }
    }

    public int ux() {
        FullSwiperView fullSwiperView = this.ys;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void w() {
        FullSwiperView fullSwiperView = this.ys;
        if (fullSwiperView != null) {
            fullSwiperView.w();
        }
    }

    public void xv() {
        FullSwiperView fullSwiperView = this.ys;
        if (fullSwiperView != null) {
            fullSwiperView.xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.f32471r.setBackgroundColor(0);
        this.ys = new FullSwiperView(this.f32472w);
    }

    public void c(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ys.c(list).c(this.bk).w(this.f32447t).c(String.valueOf(wv.gd(this.xv))).c();
        this.f32471r.addView(this.ys, new FrameLayout.LayoutParams(-1, -1));
    }
}
