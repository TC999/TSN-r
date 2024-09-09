package com.bytedance.sdk.openadsdk.core.bannerexpress;

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
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.u;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BannerExpressBackupView extends BackupView {
    private static fp[] bk = {new fp(1, 6.4f, 640, 100), new fp(3, 1.2f, 600, 500)};
    private com.bytedance.sdk.openadsdk.core.p.w.xv fp;
    private TextView fz;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f31997i;
    private int ia;

    /* renamed from: s  reason: collision with root package name */
    private fp f31998s;

    /* renamed from: t  reason: collision with root package name */
    private View f31999t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f32000u;
    private NativeExpressView ys;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.ia = 1;
        this.f33986c = context;
    }

    private void sr() {
        int i4 = this.f31998s.f34058c;
        if (i4 != 2 && i4 != 3) {
            TextView textView = this.fz;
            if (textView != null) {
                textView.setTextColor(-1);
            }
        } else {
            TextView textView2 = this.fz;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
            TextView textView3 = this.f32000u;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        this.f31997i.setImageDrawable(i.xv(getContext(), "tt_dislike_icon_night"));
    }

    private void w() {
        float ux = (this.f33990r * 1.0f) / xk.ux(this.f33986c, 50.0f);
        int i4 = this.f33987f;
        if ((this.f33990r * 1.0f) / i4 > 0.21875f) {
            ux = (i4 * 1.0f) / xk.ux(this.f33986c, 320.0f);
        }
        View up = ux.up(this.f33986c);
        this.f31999t = up;
        addView(up);
        this.f31997i = (ImageView) this.f31999t.findViewById(2114387857);
        ImageView imageView = (ImageView) this.f31999t.findViewById(2114387937);
        this.fz = (TextView) this.f31999t.findViewById(2114387946);
        TextView textView = (TextView) this.f31999t.findViewById(2114387796);
        TTRatingBar tTRatingBar = (TTRatingBar) this.f31999t.findViewById(2114387895);
        TextView textView2 = (TextView) this.f31999t.findViewById(2114387632);
        TextView textView3 = this.fz;
        textView3.setTextSize(2, xk.w(this.f33986c, textView3.getTextSize()) * ux);
        textView.setTextSize(2, xk.w(this.f33986c, textView.getTextSize()) * ux);
        textView2.setTextSize(2, xk.w(this.f33986c, textView2.getTextSize()) * ux);
        this.f31997i.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.ux();
            }
        });
        xk.c((TextView) this.f31999t.findViewById(2114387657), this.f33991w, 27, 11);
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.kr()).c(imageView);
        this.fz.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (xk.ux(this.f33986c, 45.0f) * ux);
            layoutParams.height = (int) (xk.ux(this.f33986c, 45.0f) * ux);
        }
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView2.setText(this.f33991w.dk());
        }
        int ux2 = this.f33991w.ix() != null ? this.f33991w.ix().ux() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(ux2)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(ux2);
        tTRatingBar.setStarImageWidth(xk.ux(this.f33986c, 15.0f) * ux);
        tTRatingBar.setStarImageHeight(xk.ux(this.f33986c, 14.0f) * ux);
        tTRatingBar.setStarImagePadding(xk.ux(this.f33986c, 4.0f));
        tTRatingBar.c();
        c((View) this, true);
        c((View) textView2, true);
    }

    private void xv(int i4) {
        if (i4 == 1) {
            sr();
            this.f31999t.setBackgroundColor(0);
            return;
        }
        xv();
        this.f31999t.setBackgroundColor(-1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.c
    public void b_(int i4) {
        super.b_(i4);
        xv(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void c(View view, int i4, u uVar) {
        if (this.ys != null) {
            if (i4 == 1 || i4 == 2) {
                View findViewById = this.f31999t.findViewById(2114387857);
                if (i4 == 1) {
                    this.ys.getClickListener().w(findViewById);
                } else {
                    this.ys.getClickCreativeListener().w(findViewById);
                }
            }
            this.ys.c(view, i4, uVar);
        }
    }

    private void xv() {
        int i4 = this.f31998s.f34058c;
        if (i4 != 2 && i4 != 3) {
            TextView textView = this.fz;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FF333333"));
            }
            ImageView imageView = this.f31997i;
            if (imageView != null) {
                imageView.setImageDrawable(i.xv(getContext(), "tt_dislike_icon"));
                return;
            }
            return;
        }
        TextView textView2 = this.fz;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        }
        TextView textView3 = this.f32000u;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#3E3E3E"));
        }
        if (this.f31997i != null) {
            this.f31997i.setImageDrawable(ux.oo(this.f33986c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(me meVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.p.w.xv xvVar) {
        setBackgroundColor(-1);
        this.f33991w = meVar;
        this.ys = nativeExpressView;
        this.fp = xvVar;
        this.ux = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        int gd = wv.gd(this.f33991w);
        this.ev = gd;
        w(gd);
        c();
        xv(k.sr().me());
    }

    private void c() {
        this.f31998s = c(this.ys.getExpectExpressWidth(), this.ys.getExpectExpressHeight());
        if (this.ys.getExpectExpressWidth() > 0 && this.ys.getExpectExpressHeight() > 0) {
            this.f33987f = xk.ux(this.f33986c, this.ys.getExpectExpressWidth());
            this.f33990r = xk.ux(this.f33986c, this.ys.getExpectExpressHeight());
        } else {
            int sr = xk.sr(this.f33986c);
            this.f33987f = sr;
            this.f33990r = Float.valueOf(sr / this.f31998s.xv).intValue();
        }
        int i4 = this.f33987f;
        if (i4 > 0 && i4 > xk.sr(this.f33986c)) {
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
        fp fpVar = this.f31998s;
        int i5 = fpVar.f34058c;
        if (i5 == 1) {
            w();
        } else if (i5 == 3) {
            c(fpVar);
        } else {
            w();
        }
    }

    private void c(ImageView imageView) {
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.nc().get(0)).c(imageView);
    }

    private void c(fp fpVar) {
        float ux = (this.f33990r * 1.0f) / xk.ux(this.f33986c, 250.0f);
        View mt = ux.mt(this.f33986c);
        this.f31999t = mt;
        addView(mt);
        FrameLayout frameLayout = (FrameLayout) this.f31999t.findViewById(2114387774);
        this.f31997i = (ImageView) this.f31999t.findViewById(2114387857);
        ImageView imageView = (ImageView) this.f31999t.findViewById(2114387942);
        ImageView imageView2 = (ImageView) this.f31999t.findViewById(2114387937);
        this.fz = (TextView) this.f31999t.findViewById(2114387946);
        this.f32000u = (TextView) this.f31999t.findViewById(2114387925);
        TextView textView = (TextView) this.f31999t.findViewById(2114387933);
        TextView textView2 = (TextView) this.f31999t.findViewById(2114387632);
        xk.c((TextView) this.f31999t.findViewById(2114387657), this.f33991w);
        LinearLayout linearLayout = (LinearLayout) this.f31999t.findViewById(2114387874);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (xk.ux(this.f33986c, 45.0f) * ux);
            layoutParams.height = (int) (xk.ux(this.f33986c, 45.0f) * ux);
        }
        TextView textView3 = this.fz;
        textView3.setTextSize(2, xk.w(this.f33986c, textView3.getTextSize()) * ux);
        TextView textView4 = this.f32000u;
        textView4.setTextSize(2, xk.w(this.f33986c, textView4.getTextSize()) * ux);
        textView.setTextSize(2, xk.w(this.f33986c, textView.getTextSize()) * ux);
        textView2.setTextSize(2, xk.w(this.f33986c, textView2.getTextSize()) * ux);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f4 = ux - 1.0f;
            if (f4 > 0.0f) {
                layoutParams2.topMargin = xk.ux(this.f33986c, f4 * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (xk.ux(this.f33986c, 16.0f) * ux), 0, 0);
        } catch (Throwable unused) {
        }
        this.f31997i.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.ux();
            }
        });
        int xv = (int) xk.xv(this.f33986c, 15.0f);
        xk.c(this.f31997i, xv, xv, xv, xv);
        if (ng.bk(this.f33991w) != null) {
            View c4 = c(this.ys);
            if (c4 != null) {
                int i4 = (this.f33990r * MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME) / 400;
                int i5 = (this.f33987f * 406) / 600;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
                int i6 = fpVar.f34059w;
                if (i6 == 1) {
                    int i7 = (this.f33987f * 406) / 600;
                    layoutParams3 = new FrameLayout.LayoutParams(i7, (i7 * 9) / 16);
                } else if (i6 == 2) {
                    layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                } else if (i6 == 3) {
                    int i8 = (this.f33990r * 188) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                    layoutParams3 = new FrameLayout.LayoutParams((i8 * 16) / 9, i8);
                } else if (i6 == 4) {
                    int i9 = (this.f33987f * 480) / 690;
                    layoutParams3 = new FrameLayout.LayoutParams(i9, (i9 * 9) / 16);
                }
                layoutParams3.gravity = 17;
                frameLayout.addView(c4, 0, layoutParams3);
                xk.c((View) imageView, 8);
            } else {
                c(imageView);
                xk.c((View) imageView, 0);
            }
        } else {
            c(imageView);
            xk.c((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.r.w.c(this.f33991w.kr()).c(imageView2);
        textView.setText(getNameOrSource());
        this.fz.setText(String.format(Locale.getDefault(), "%s\u63d0\u4f9b\u7684\u5e7f\u544a", getNameOrSource()));
        this.f32000u.setText(getDescription());
        if (!TextUtils.isEmpty(this.f33991w.dk())) {
            textView2.setText(this.f33991w.dk());
        }
        c((View) this, true);
        c((View) textView2, true);
        c(frameLayout);
    }

    private fp c(int i4, int i5) {
        try {
            fp fpVar = bk[0];
            double d4 = i5;
            double d5 = i4;
            Double.isNaN(d5);
            return d4 >= Math.floor((d5 * 300.0d) / 600.0d) ? bk[1] : fpVar;
        } catch (Throwable unused) {
            return bk[0];
        }
    }
}
