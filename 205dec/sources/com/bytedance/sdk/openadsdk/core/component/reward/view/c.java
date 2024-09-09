package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f32642c;
    private final TTBaseVideoActivity ev;

    /* renamed from: f  reason: collision with root package name */
    TextView f32643f;
    private me gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f32644k;

    /* renamed from: p  reason: collision with root package name */
    private int f32645p;

    /* renamed from: r  reason: collision with root package name */
    TextView f32646r;
    TTRatingBar sr;
    TextView ux;

    /* renamed from: w  reason: collision with root package name */
    TTRoundRectImageView f32647w;
    TextView xv;

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.ev = tTBaseVideoActivity;
    }

    private void f() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.f32645p == 1 && (tTRoundRectImageView = this.f32647w) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) xk.xv(this.ev, 50.0f), 0, 0);
            this.f32647w.setLayoutParams(layoutParams);
        }
    }

    private void ux() {
        this.f32642c = (LinearLayout) this.ev.findViewById(2114387740);
        this.f32647w = (TTRoundRectImageView) this.ev.findViewById(2114387775);
        this.xv = (TextView) this.ev.findViewById(2114387644);
        this.sr = (TTRatingBar) this.ev.findViewById(2114387781);
        this.ux = (TextView) this.ev.findViewById(2114387784);
        this.f32643f = (TextView) this.ev.findViewById(2114387867);
        this.f32646r = (TextView) this.ev.findViewById(2114387708);
        TTRatingBar tTRatingBar = this.sr;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.sr.setStarFillNum(4);
            this.sr.setStarImageWidth(xk.ux(this.ev, 16.0f));
            this.sr.setStarImageHeight(xk.ux(this.ev, 16.0f));
            this.sr.setStarImagePadding(xk.ux(this.ev, 4.0f));
            this.sr.c();
        }
    }

    public void c(me meVar) {
        if (this.f32644k) {
            return;
        }
        this.f32644k = true;
        this.gd = meVar;
        this.f32645p = meVar.fh();
        ux();
        w();
        c(sr());
        f();
    }

    protected String sr() {
        me meVar = this.gd;
        if (meVar == null) {
            return "\u7acb\u5373\u4e0b\u8f7d";
        }
        if (TextUtils.isEmpty(meVar.dk())) {
            return this.gd.v() != 4 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u4e0b\u8f7d";
        }
        return this.gd.dk();
    }

    public void w() {
        String str;
        if (this.f32647w != null) {
            gb kr = this.gd.kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                com.bytedance.sdk.openadsdk.r.w.c(kr).c(this.f32647w);
            } else {
                this.f32647w.setImageDrawable(i.xv(this.ev, "tt_ad_logo_small"));
            }
        }
        if (this.xv != null) {
            if (this.gd.ix() != null && !TextUtils.isEmpty(this.gd.ix().xv())) {
                this.xv.setText(this.gd.ix().xv());
            } else {
                this.xv.setText(this.gd.ny());
            }
        }
        if (this.ux != null) {
            int f4 = this.gd.ix() != null ? this.gd.ix().f() : 6870;
            String c4 = i.c(this.ev, "tt_comment_num_backup");
            if (f4 > 10000) {
                str = (f4 / 10000) + "\u4e07";
            } else {
                str = f4 + "";
            }
            this.ux.setText(String.format(c4, str));
        }
        TextView textView = this.f32646r;
        if (textView != null) {
            xk.c(textView, this.gd);
        }
    }

    public void xv() {
        xk.c((View) this.f32642c, 8);
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        xk.c(this.f32642c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.f32643f;
        if (textView != null) {
            textView.setOnClickListener(wVar);
            this.f32643f.setOnTouchListener(wVar);
        }
    }

    public void c() {
        xk.c((View) this.f32642c, 0);
    }

    public void c(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.f32643f) == null) {
            return;
        }
        textView.setText(str);
    }
}
