package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends w {
    private RatioImageView bk;
    private TextView fp;
    private TextView fz;
    private TextView ia;

    /* renamed from: s  reason: collision with root package name */
    private TTRatingBar f32444s;

    /* renamed from: t  reason: collision with root package name */
    private TTRoundRectImageView f32445t;
    private TextView ys;

    public f(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
    }

    private void sr() {
        String str;
        if (this.ia == null) {
            return;
        }
        int f4 = this.xv.ix() != null ? this.xv.ix().f() : 6870;
        String c4 = i.c(this.f32472w, "tt_comment_num_backup");
        if (f4 > 10000) {
            str = (f4 / 10000) + "\u4e07";
        } else {
            str = f4 + "";
        }
        this.ia.setText(String.format(c4, str));
    }

    private void w() {
        gb kr;
        xk.c((TextView) this.f32472w.findViewById(2114387657), this.xv);
        if (this.bk != null) {
            int tz = this.xv.tz();
            if (tz == 3) {
                this.bk.setRatio(1.91f);
            } else if (tz != 33) {
                this.bk.setRatio(0.56f);
            } else {
                this.bk.setRatio(1.0f);
            }
            c(this.bk);
        }
        if (this.f32445t != null && (kr = this.xv.kr()) != null) {
            com.bytedance.sdk.openadsdk.r.w.c(kr).c(this.f32445t);
        }
        TextView textView = this.ys;
        if (textView != null) {
            textView.setText(t());
        }
        TextView textView2 = this.fp;
        if (textView2 != null) {
            textView2.setText(ys());
        }
        xv();
        sr();
    }

    private void xv() {
        TTRatingBar tTRatingBar = this.f32444s;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.f32444s.setStarFillNum(4);
        this.f32444s.setStarImageWidth(xk.ux(this.f32472w, 16.0f));
        this.f32444s.setStarImageHeight(xk.ux(this.f32472w, 16.0f));
        this.f32444s.setStarImagePadding(xk.ux(this.f32472w, 4.0f));
        this.f32444s.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.gd = (FrameLayout) this.f32471r.findViewById(2114387641);
        this.bk = (RatioImageView) this.f32471r.findViewById(2114387768);
        this.f32445t = (TTRoundRectImageView) this.f32471r.findViewById(2114387722);
        this.ys = (TextView) this.f32471r.findViewById(2114387701);
        this.fp = (TextView) this.f32471r.findViewById(2114387940);
        this.ia = (TextView) this.f32471r.findViewById(2114387791);
        this.fz = (TextView) this.f32471r.findViewById(2114387962);
        this.f32444s = (TTRatingBar) this.f32471r.findViewById(2114387789);
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        c(this.bk, wVar, wVar);
        c(this.f32445t, wVar, wVar);
        c(this.ys, wVar, wVar);
        c(this.fp, wVar, wVar);
        c(this.fz, wVar, wVar);
        c(this.ia, wVar, wVar);
        c(this.f32444s, wVar, wVar);
    }

    protected void c(View view, com.bytedance.sdk.openadsdk.core.w.w wVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.f32472w == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(wVar);
    }
}
