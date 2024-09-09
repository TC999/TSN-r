package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.splash.k;
import com.bytedance.sdk.openadsdk.core.eq.fp;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.oo;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends sr {

    /* renamed from: f  reason: collision with root package name */
    private ImageView f32947f;
    private GifView ux;

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        GifView gifView = new GifView(context);
        this.ux = gifView;
        gifView.setId(2114387583);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 2114387582);
        this.ux.setLayoutParams(layoutParams);
        this.ux.setVisibility(8);
        relativeLayout.addView(this.ux);
        ImageView imageView = new ImageView(context);
        this.f32947f = imageView;
        imageView.setId(2114387582);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.bottomMargin = xk.ux(context, 5.0f);
        this.f32947f.setLayoutParams(layoutParams2);
        this.f32947f.setBackground(i.xv(this.f32977c, "tt_dislike_icon"));
        this.f32947f.setVisibility(0);
        relativeLayout.addView(this.f32947f);
        return relativeLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public String c() {
        return "show_splash_icon";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(Context context, ViewGroup viewGroup, me meVar) {
        super.c(context, viewGroup, meVar);
        View c4 = c(this.f32977c);
        if (c4 == null) {
            return;
        }
        this.f32978w.addView(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        if (cVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_click_area", 1);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
        this.ux.setOnClickListener(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar, final k.c cVar) {
        Drawable c4;
        super.c(wVar, xvVar, cVar);
        if (wVar == null) {
            return;
        }
        this.ux.setVisibility(0);
        if (wVar.ux()) {
            this.ux.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ux.c(wVar.xv(), false);
        } else if (oo.k(this.xv)) {
            if (wVar.c() != null) {
                c4 = new BitmapDrawable(this.f32977c.getResources(), wVar.c());
            } else {
                c4 = fp.c(wVar.xv(), 0);
            }
            this.ux.setScaleType(ImageView.ScaleType.FIT_END);
            this.ux.setImageDrawable(c4);
        }
        int s3 = oo.s(this.xv);
        if (s3 >= 0) {
            cVar.c(s3);
        }
        if (cVar != null) {
            this.f32947f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cVar.w();
                    com.bytedance.sdk.openadsdk.core.a.xv.w(f.this.xv, "splash_ad", "close_splash_icon");
                }
            });
        }
    }
}
