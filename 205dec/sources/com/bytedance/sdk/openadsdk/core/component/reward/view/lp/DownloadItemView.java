package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.r.w;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void c(me meVar) {
        String dk;
        String str;
        if (meVar == null) {
            return;
        }
        Context context = getContext();
        addView(ux.yu(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387795);
        TextView textView = (TextView) findViewById(2114387878);
        TextView textView2 = (TextView) findViewById(2114387636);
        TextView textView3 = (TextView) findViewById(2114387833);
        TextView textView4 = (TextView) findViewById(2114387629);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387608);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(xk.ux(context, 12.0f));
            tTRatingBar.setStarImageHeight(xk.ux(context, 12.0f));
            tTRatingBar.setStarImagePadding(xk.ux(context, 4.0f));
            tTRatingBar.c();
        }
        if (textView4 != null) {
            int f4 = meVar.ix() != null ? meVar.ix().f() : 6870;
            String c4 = i.c(context, "tt_comment_num");
            if (f4 > 10000) {
                str = (f4 / 10000) + "\u4e07";
            } else {
                str = f4 + "";
            }
            textView4.setText(String.format(c4, str));
        }
        if (tTRoundRectImageView != null) {
            gb kr = meVar.kr();
            if (kr != null && !TextUtils.isEmpty(kr.c())) {
                w.c(kr).c(tTRoundRectImageView);
            } else {
                tTRoundRectImageView.setImageDrawable(i.xv(context, "tt_ad_logo_small"));
            }
        }
        if (textView != null) {
            textView.setText(wv.ys(meVar));
        }
        if (textView2 != null) {
            textView2.setText(wv.fp(meVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(meVar.dk())) {
                dk = meVar.v() != 4 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u4e0b\u8f7d";
            } else {
                dk = meVar.dk();
            }
            textView3.setText(dk);
        }
    }
}
