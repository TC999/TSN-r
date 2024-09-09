package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends w {
    private RoundImageView bk;
    private TextView fp;
    private TextView fz;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f32436i;
    private ImageView ia;

    /* renamed from: q  reason: collision with root package name */
    private boolean f32437q;

    /* renamed from: s  reason: collision with root package name */
    private TextView f32438s;

    /* renamed from: t  reason: collision with root package name */
    private RelativeLayout f32439t;

    /* renamed from: u  reason: collision with root package name */
    private RelativeLayout f32440u;
    private TextView ys;

    public ev(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        String str;
        StringBuilder sb;
        super.c();
        this.ev = (RelativeLayout) this.f32472w.findViewById(2114387661);
        this.gd = (FrameLayout) this.f32472w.findViewById(2114387756);
        this.f32470p = (TextView) this.f32472w.findViewById(2114387657);
        this.bk = (RoundImageView) this.f32472w.findViewById(2114387885);
        this.f32439t = (RelativeLayout) this.f32472w.findViewById(2114387916);
        this.ys = (TextView) this.f32472w.findViewById(2114387926);
        this.fp = (TextView) this.f32472w.findViewById(2114387853);
        this.ia = (ImageView) this.f32472w.findViewById(2114387884);
        this.f32438s = (TextView) this.f32472w.findViewById(2114387783);
        this.fz = (TextView) this.f32472w.findViewById(2114387639);
        this.f32440u = (RelativeLayout) this.f32472w.findViewById(2114387662);
        this.f32436i = (RelativeLayout) this.f32472w.findViewById(2114387838);
        this.f32469k = (RelativeLayout) this.f32472w.findViewById(2114387716);
        xk.c(this.f32470p, this.xv);
        k();
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.xv)) {
            String gd = ba.gd(this.xv);
            if (!TextUtils.isEmpty(gd) && this.bk != null) {
                xk.c((View) this.f32439t, 0);
                com.bytedance.sdk.openadsdk.r.w.c(gd).c(this.bk);
            } else {
                xk.c((View) this.f32439t, 8);
            }
            if (this.ys != null) {
                this.ys.setText(ba.xv(this.xv));
            }
            if (this.fp != null) {
                int sr = ba.sr(this.xv);
                if (sr < 0) {
                    this.fp.setVisibility(4);
                    xk.c((View) this.ia, 4);
                } else {
                    String c4 = i.c(this.f32472w, "tt_live_fans_text");
                    if (sr > 10000) {
                        sb = new StringBuilder();
                        sb.append(sr / 10000.0f);
                        sb.append("w");
                    } else {
                        sb = new StringBuilder();
                        sb.append(sr);
                        sb.append("");
                    }
                    this.fp.setText(String.format(c4, sb.toString()));
                }
            }
            if (this.f32438s != null) {
                int ux = ba.ux(this.xv);
                if (ux < 0) {
                    this.f32438s.setVisibility(4);
                    xk.c((View) this.ia, 4);
                } else {
                    String c5 = i.c(this.f32472w, "tt_live_watch_text");
                    if (ux > 10000) {
                        str = (ux / 10000.0f) + "w";
                    } else {
                        str = ux + "";
                    }
                    this.f32438s.setText(String.format(c5, str));
                }
            }
            if (this.fz != null) {
                this.fz.setText(ba.f(this.xv));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void sr(int i4) {
        if (this.f32437q) {
            return;
        }
        xk.c((View) this.f32469k, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void xv(int i4) {
        xk.c((View) this.f32440u, i4);
        xk.c((View) this.f32436i, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        c(wVar);
        c((View.OnTouchListener) wVar);
    }

    private void c(View.OnTouchListener onTouchListener) {
        xk.c(this.ev, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        xk.c(this.gd, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        xk.c(this.fz, onTouchListener, (String) null);
        xk.c(this.fp, onTouchListener, (String) null);
        xk.c(this.f32438s, onTouchListener, (String) null);
        xk.c(this.ys, onTouchListener, (String) null);
        xk.c(this.bk, onTouchListener, (String) null);
        xk.c(this.f32469k, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        c(this.gd, wVar, "click_live_feed");
        c(this.fz, wVar, "click_live_author_description");
        c(this.fp, wVar, "click_live_author_follower_count");
        c(this.f32438s, wVar, "click_live_author_following_count");
        c(this.ys, wVar, "click_live_author_nickname");
        c(this.bk, wVar, "click_live_avata");
        c(this.ev, wVar, "click_live_button");
        c(this.f32469k, wVar, "click_live_btn_layout");
    }

    private void c(View view, final com.bytedance.sdk.openadsdk.core.w.w wVar, final String str) {
        if (view == null || wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.f32472w;
        me meVar = this.xv;
        boolean z3 = this.f32468f;
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.w.w(tTBaseVideoActivity, meVar, z3 ? "rewarded_video" : "fullscreen_interstitial_ad", z3 ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ev.1
            @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view2, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                wVar.c(view2, gdVar);
            }
        });
    }

    public void c(int i4, int i5) {
        TextView textView;
        if (i4 != 0) {
            this.f32437q = true;
            xk.c((View) this.f32469k, 8);
            return;
        }
        xk.c((View) this.f32469k, 0);
        if (i5 >= 0 && TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.xv) && bw.c(this.xv) && bw.ux(this.xv) == 3 && (textView = (TextView) this.f32472w.findViewById(2114387715)) != null) {
            String c4 = i.c(this.f32472w, "tt_reward_auto_jump_live");
            textView.setText(String.format(c4, i5 + "s"));
        }
    }
}
