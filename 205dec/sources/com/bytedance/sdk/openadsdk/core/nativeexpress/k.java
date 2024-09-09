package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class k extends BackupView {
    private static fp[] bk = {new fp(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new fp(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new fp(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new fp(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new fp(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new fp(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private NativeExpressView fp;
    private TextView fz;
    private com.bytedance.sdk.openadsdk.core.p.w.xv ia;

    /* renamed from: s  reason: collision with root package name */
    private TextView f34090s;

    /* renamed from: t  reason: collision with root package name */
    private int f34091t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f34092u;
    private View ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        super(context);
        this.f33986c = context;
    }

    private void a() {
        String str;
        StringBuilder sb;
        if (this.f33991w == null) {
            return;
        }
        View b4 = com.bytedance.sdk.openadsdk.res.ux.b(this.f33986c);
        this.ys = b4;
        addView(b4);
        FrameLayout frameLayout = (FrameLayout) this.ys.findViewById(2114387620);
        TextView textView = (TextView) this.ys.findViewById(2114387830);
        TextView textView2 = (TextView) this.ys.findViewById(2114387943);
        View view = (TextView) this.ys.findViewById(2114387864);
        RoundImageView roundImageView = (RoundImageView) this.ys.findViewById(2114387907);
        RelativeLayout relativeLayout = (RelativeLayout) this.ys.findViewById(2114387854);
        TextView textView3 = (TextView) this.ys.findViewById(2114387621);
        TextView textView4 = (TextView) this.ys.findViewById(2114387671);
        TextView textView5 = (TextView) this.ys.findViewById(2114387702);
        ImageView imageView = (ImageView) this.ys.findViewById(2114387884);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f33991w)) {
            String gd = ba.gd(this.f33991w);
            if (!TextUtils.isEmpty(gd) && roundImageView != null) {
                xk.c((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.r.w.c(gd).c(roundImageView);
            } else {
                xk.c((View) relativeLayout, 8);
            }
            if (textView2 != null) {
                textView2.setText(ba.xv(this.f33991w));
            }
            if (textView3 != null) {
                int sr = ba.sr(this.f33991w);
                if (sr < 0) {
                    textView3.setVisibility(4);
                    xk.c((View) imageView, 4);
                } else {
                    String c4 = com.bytedance.sdk.component.utils.i.c(this.f33986c, "tt_live_fans_text");
                    if (sr > 10000) {
                        sb = new StringBuilder();
                        sb.append(sr / 10000.0f);
                        sb.append("w");
                    } else {
                        sb = new StringBuilder();
                        sb.append(sr);
                        sb.append("");
                    }
                    textView3.setText(String.format(c4, sb.toString()));
                }
            }
            if (textView4 != null) {
                int ux = ba.ux(this.f33991w);
                if (ux < 0) {
                    textView4.setVisibility(4);
                    xk.c((View) imageView, 4);
                } else {
                    String c5 = com.bytedance.sdk.component.utils.i.c(this.f33986c, "tt_live_watch_text");
                    if (ux > 10000) {
                        str = (ux / 10000.0f) + "w";
                    } else {
                        str = ux + "";
                    }
                    textView4.setText(String.format(c5, str));
                }
            }
            if (textView != null) {
                textView.setText(ba.f(this.f33991w));
            }
            View c6 = c(this.fp);
            if (c6 != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(c6, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.w.c bk2 = bk();
            c(roundImageView, bk2, "click_live_avata");
            c(textView2, bk2, "click_live_author_nickname");
            c(textView3, bk2, "click_live_author_follower_count");
            c(textView4, bk2, "click_live_author_following_count");
            c(textView, bk2, "click_live_author_description");
            c(frameLayout, bk2, "click_live_feed");
            c(view, bk2, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.ux();
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.w.c bk() {
        Context context = this.f33986c;
        me meVar = this.f33991w;
        String str = this.ux;
        final com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(context, meVar, str, wv.c(str)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.8
            @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                if (view == null) {
                    super.c(view, gdVar);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                super.c(view, gdVar);
            }
        };
        xv xvVar = new xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xv
            public void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
                try {
                    uVar.c().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).ux());
                } catch (JSONException unused) {
                }
                k.this.c(view, i4, uVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.w.c.w.c cVar2 = (com.bytedance.sdk.openadsdk.core.w.c.w.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.w.c.class);
        if (cVar2 != null) {
            cVar2.c(xvVar);
            cVar2.c(2);
        }
        return cVar;
    }

    private void ev() {
        View au = com.bytedance.sdk.openadsdk.res.ux.au(this.f33986c);
        this.ys = au;
        addView(au);
        FrameLayout frameLayout = (FrameLayout) this.ys.findViewById(2114387735);
        TextView textView = (TextView) this.ys.findViewById(2114387925);
        TextView textView2 = (TextView) this.ys.findViewById(2114387946);
        TextView textView3 = (TextView) this.ys.findViewById(2114387632);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        xk.c((TextView) this.ys.findViewById(2114387657), this.f33991w);
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView3.setText(this.f33991w.dk());
        }
        View c4 = c(this.fp);
        NativeExpressView nativeExpressView = this.fp;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (c4 instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) c4;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (c4 != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(c4, new ViewGroup.LayoutParams(-1, -1));
        }
        c(textView2, false);
        c(textView, false);
        c(textView3, true);
    }

    private void f() {
        View bm = com.bytedance.sdk.openadsdk.res.ux.bm(this.f33986c);
        this.ys = bm;
        addView(bm);
        this.ys.findViewById(2114387735).setVisibility(8);
        this.ys.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.ys.findViewById(2114387942);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        TextView textView = (TextView) this.ys.findViewById(2114387632);
        xk.c((TextView) this.ys.findViewById(2114387657), this.f33991w);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.f33990r);
        c(imageView);
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView.setText(this.f33991w.dk());
        }
        c(this, false);
        c(textView, true);
    }

    private void gd() {
        View bm = com.bytedance.sdk.openadsdk.res.ux.bm(this.f33986c);
        this.ys = bm;
        addView(bm);
        FrameLayout frameLayout = (FrameLayout) this.ys.findViewById(2114387735);
        frameLayout.setVisibility(0);
        this.ys.findViewById(2114387955).setVisibility(8);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        TextView textView = (TextView) this.ys.findViewById(2114387632);
        xk.c((TextView) this.ys.findViewById(2114387657), this.f33991w);
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView.setText(this.f33991w.dk());
        }
        View c4 = c(this.fp);
        if (c4 != null) {
            frameLayout.removeAllViews();
            int i4 = this.f33987f;
            frameLayout.addView(c4, new ViewGroup.LayoutParams(i4, (i4 * 9) / 16));
        }
        c(this, false);
        c(textView, true);
    }

    private void k() {
        String str;
        StringBuilder sb;
        if (this.f33991w == null) {
            return;
        }
        View bj = com.bytedance.sdk.openadsdk.res.ux.bj(this.f33986c);
        this.ys = bj;
        addView(bj);
        FrameLayout frameLayout = (FrameLayout) this.ys.findViewById(2114387767);
        TextView textView = (TextView) this.ys.findViewById(2114387903);
        View view = (RelativeLayout) this.ys.findViewById(2114387649);
        RoundImageView roundImageView = (RoundImageView) this.ys.findViewById(2114387821);
        RelativeLayout relativeLayout = (RelativeLayout) this.ys.findViewById(2114387779);
        TextView textView2 = (TextView) this.ys.findViewById(2114387770);
        TextView textView3 = (TextView) this.ys.findViewById(2114387618);
        TextView textView4 = (TextView) this.ys.findViewById(2114387899);
        ImageView imageView = (ImageView) this.ys.findViewById(2114387884);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f33991w)) {
            String gd = ba.gd(this.f33991w);
            if (!TextUtils.isEmpty(gd) && roundImageView != null) {
                xk.c((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.r.w.c(gd).c(roundImageView);
            } else {
                xk.c((View) relativeLayout, 8);
            }
            if (textView != null) {
                textView.setText(ba.xv(this.f33991w));
            }
            if (textView2 != null) {
                int sr = ba.sr(this.f33991w);
                if (sr < 0) {
                    textView2.setVisibility(4);
                    xk.c((View) imageView, 4);
                } else {
                    String c4 = com.bytedance.sdk.component.utils.i.c(this.f33986c, "tt_live_fans_text");
                    if (sr > 10000) {
                        sb = new StringBuilder();
                        sb.append(sr / 10000.0f);
                        sb.append("w");
                    } else {
                        sb = new StringBuilder();
                        sb.append(sr);
                        sb.append("");
                    }
                    textView2.setText(String.format(c4, sb.toString()));
                }
            }
            if (textView3 != null) {
                int ux = ba.ux(this.f33991w);
                if (ux < 0) {
                    xk.c((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    String c5 = com.bytedance.sdk.component.utils.i.c(this.f33986c, "tt_live_watch_text");
                    if (ux > 10000) {
                        str = (ux / 10000.0f) + "w";
                    } else {
                        str = ux + "";
                    }
                    textView3.setText(String.format(c5, str));
                }
            }
            if (textView4 != null) {
                textView4.setText(ba.f(this.f33991w));
            }
            View c6 = c(this.fp);
            if (c6 != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(c6, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.w.c bk2 = bk();
            c(roundImageView, bk2, "click_live_avata");
            c(textView, bk2, "click_live_author_nickname");
            c(textView2, bk2, "click_live_author_follower_count");
            c(textView3, bk2, "click_live_author_following_count");
            c(textView4, bk2, "click_live_author_description");
            c(frameLayout, bk2, "click_live_feed");
            c(view, bk2, "click_live_button");
        }
    }

    private void p() {
        View xu = com.bytedance.sdk.openadsdk.res.ux.xu(this.f33986c);
        this.ys = xu;
        addView(xu);
        this.ys.findViewById(2114387735).setVisibility(8);
        this.ys.findViewById(2114387955).setVisibility(0);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        TextView textView = (TextView) this.ys.findViewById(2114387632);
        xk.c((TextView) this.ys.findViewById(2114387657), this.f33991w);
        c((ImageView) this.ys.findViewById(2114387942));
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView.setText(this.f33991w.dk());
        }
        c(this, false);
        c(textView, true);
    }

    private void r() {
        View xu = com.bytedance.sdk.openadsdk.res.ux.xu(this.f33986c);
        this.ys = xu;
        addView(xu);
        this.ys.findViewById(2114387735).setVisibility(0);
        this.ys.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.ys.findViewById(2114387965);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        TextView textView = (TextView) this.ys.findViewById(2114387858);
        TextView textView2 = (TextView) this.ys.findViewById(2114387859);
        TextView textView3 = (TextView) this.ys.findViewById(2114387632);
        TextView textView4 = (TextView) this.ys.findViewById(2114387913);
        TTRatingBar tTRatingBar = (TTRatingBar) this.ys.findViewById(2114387877);
        xk.c((TextView) this.ys.findViewById(2114387616), this.f33991w);
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.kr()).c((ImageView) this.ys.findViewById(2114387918));
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        int ux = this.f33991w.ix() != null ? this.f33991w.ix().ux() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(ux)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(ux);
        tTRatingBar.setStarImageWidth(xk.ux(this.f33986c, 15.0f));
        tTRatingBar.setStarImageHeight(xk.ux(this.f33986c, 14.0f));
        tTRatingBar.setStarImagePadding(xk.ux(this.f33986c, 4.0f));
        tTRatingBar.c();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView3.setText(this.f33991w.dk());
        }
        View c4 = c(this.fp);
        if (c4 != null) {
            int i4 = (this.f33987f * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(c4, new ViewGroup.LayoutParams(i4, (i4 * 16) / 9));
        }
        c(this, false);
        c(textView3, true);
    }

    private fp sr(int i4) {
        fp[] fpVarArr = bk;
        fp fpVar = fpVarArr[0];
        try {
            for (fp fpVar2 : fpVarArr) {
                if (fpVar2.f34058c == i4) {
                    return fpVar2;
                }
            }
            return fpVar;
        } catch (Throwable unused) {
            return fpVar;
        }
    }

    private void ux(int i4) {
        if (i4 == 1) {
            w();
            this.ys.setBackgroundColor(0);
            ImageView imageView = this.f34092u;
            if (imageView != null) {
                imageView.setImageDrawable(com.bytedance.sdk.component.utils.i.xv(getContext(), "tt_dislike_icon_night"));
                return;
            }
            return;
        }
        c();
        this.ys.setBackgroundColor(-1);
        ImageView imageView2 = this.f34092u;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.i.xv(getContext(), "tt_dislike_icon2"));
        }
    }

    private void xv(int i4) {
        fp sr = sr(this.f33991w.tz());
        this.f33987f = xk.ux(this.f33986c, this.fp.getExpectExpressWidth());
        this.f33990r = xk.ux(this.f33986c, this.fp.getExpectExpressHeight());
        if (this.f33987f <= 0) {
            this.f33987f = xk.sr(this.f33986c);
        }
        if (this.f33990r <= 0) {
            this.f33990r = Float.valueOf(this.f33987f / sr.xv).intValue();
        }
        int i5 = this.f33987f;
        if (i5 > 0 && i5 > xk.sr(this.f33986c)) {
            float sr2 = xk.sr(this.f33986c) / this.f33987f;
            this.f33987f = xk.sr(this.f33986c);
            this.f33990r = Float.valueOf(this.f33990r * sr2).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f33987f, this.f33990r);
        }
        layoutParams.width = this.f33987f;
        layoutParams.height = this.f33990r;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (i4 == 9) {
            this.ux = "draw_ad";
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f33991w)) {
                k();
                return;
            } else {
                ev();
                return;
            }
        }
        this.ux = "embeded_ad";
        int tz = this.f33991w.tz();
        if (tz == 2) {
            xv();
        } else if (tz == 3) {
            f();
        } else if (tz == 4) {
            sr();
        } else if (tz == 5) {
            gd();
        } else if (tz == 15) {
            r();
        } else if (tz == 16) {
            p();
        } else if (tz == 131) {
            p();
        } else if (tz != 166) {
            p();
        } else {
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.c
    public void b_(int i4) {
        super.b_(i4);
        ux(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(me meVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.p.w.xv xvVar) {
        com.bytedance.sdk.component.utils.a.w("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f33991w = meVar;
        this.fp = nativeExpressView;
        this.ia = xvVar;
        int gd = wv.gd(meVar);
        this.f34091t = gd;
        w(gd);
        int ev = wv.ev(this.f33991w);
        xv(ev);
        ux(com.bytedance.sdk.openadsdk.core.k.sr().me());
        int i4 = ev != 9 ? -2 : -1;
        this.fp.addView(this, new ViewGroup.LayoutParams(i4, i4));
    }

    public void w() {
        TextView textView = this.f34090s;
        if (textView == null || this.fz == null) {
            return;
        }
        textView.setTextColor(-1);
        this.fz.setTextColor(-1);
    }

    private void sr() {
        View wo = com.bytedance.sdk.openadsdk.res.ux.wo(this.f33986c);
        this.ys = wo;
        addView(wo);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        TextView textView = (TextView) this.ys.findViewById(2114387632);
        xk.c((TextView) this.ys.findViewById(2114387657), this.f33991w);
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.nc().get(0)).c((ImageView) this.ys.findViewById(2114387694));
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.nc().get(1)).c((ImageView) this.ys.findViewById(2114387691));
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.nc().get(2)).c((ImageView) this.ys.findViewById(2114387689));
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.kr()).c((ImageView) this.ys.findViewById(2114387937));
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView.setText(this.f33991w.dk());
        }
        c(this, false);
        c(textView, true);
    }

    private void c(ImageView imageView) {
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.nc().get(0)).c(imageView);
    }

    private void c(View view, TextView textView, me meVar) {
        if (view == null || textView == null) {
            return;
        }
        if (meVar == null) {
            view.setVisibility(0);
        } else if (TextUtils.isEmpty(meVar.ez())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            xk.c(view, meVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            xk.c(textView, meVar);
        }
    }

    private void c(View view, com.bytedance.sdk.openadsdk.core.w.w wVar, String str) {
        if (view == null || wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
        NativeExpressView nativeExpressView = this.fp;
        if (nativeExpressView != null) {
            if (i4 == 1 && nativeExpressView.getClickListener() != null) {
                this.fp.getClickListener().w(this.f34092u);
            }
            if (i4 == 2 && this.fp.getClickCreativeListener() != null) {
                this.fp.getClickCreativeListener().w(this.f34092u);
            }
            this.fp.c(view, i4, uVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected NativeVideoTsView c(Context context, me meVar, String str, boolean z3, boolean z4) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, meVar, str, z3, z4);
        }
        return new NativeVideoTsView(context, meVar, str, z3, z4);
    }

    private void xv() {
        View vc = com.bytedance.sdk.openadsdk.res.ux.vc(this.f33986c);
        this.ys = vc;
        addView(vc);
        this.f34092u = (ImageView) this.ys.findViewById(2114387857);
        this.fz = (TextView) this.ys.findViewById(2114387925);
        this.f34090s = (TextView) this.ys.findViewById(2114387946);
        c((LinearLayout) this.ys.findViewById(2114387659), (TextView) this.ys.findViewById(2114387657), this.f33991w);
        c((ImageView) this.ys.findViewById(2114387942));
        this.fz.setText(getDescription());
        this.f34090s.setText(getTitle());
        this.f34092u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.ux();
            }
        });
        c(this, true);
    }

    public void c() {
        if (this.f34090s == null || this.fz == null) {
            return;
        }
        int tz = this.f33991w.tz();
        if (tz != 2) {
            if (tz != 3) {
                if (tz == 4) {
                    this.f34090s.setTextColor(Color.parseColor("#FF3E3E3E"));
                    this.fz.setTextColor(Color.parseColor("#FF3E3E3E"));
                    return;
                } else if (tz != 5 && tz != 15 && tz != 16) {
                    return;
                }
            }
            this.f34090s.setTextColor(Color.parseColor("#FF222222"));
            this.fz.setTextColor(Color.parseColor("#FF505050"));
            return;
        }
        this.f34090s.setTextColor(Color.parseColor("#FFBCBCBC"));
        this.fz.setTextColor(Color.parseColor("#FF999999"));
    }
}
