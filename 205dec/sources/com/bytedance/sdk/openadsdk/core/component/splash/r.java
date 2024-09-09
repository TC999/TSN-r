package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.splash.k;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.oo;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends sr {
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f32972f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.xv f32973r;
    private ImageView ux;

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar = this.f32973r;
        if (xvVar != null) {
            xvVar.p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public String c() {
        return "show_splash_icon";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("show_time", System.currentTimeMillis() - this.ev);
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, "splash_ad", "icon_splash_video_show_time", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void w() {
        super.w();
        xv();
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(context);
        this.f32972f = frameLayout;
        frameLayout.setId(2114387564);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 2114387582);
        this.f32972f.setLayoutParams(layoutParams);
        this.f32972f.setVisibility(8);
        relativeLayout.addView(this.f32972f);
        ImageView imageView = new ImageView(context);
        this.ux = imageView;
        imageView.setId(2114387582);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.bottomMargin = xk.ux(context, 5.0f);
        this.ux.setLayoutParams(layoutParams2);
        this.ux.setBackground(i.xv(this.f32977c, "tt_dislike_icon"));
        this.ux.setVisibility(0);
        relativeLayout.addView(this.ux);
        return relativeLayout;
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
        this.f32972f.setOnClickListener(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.sr
    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar, final k.c cVar) {
        super.c(wVar, xvVar, cVar);
        this.ev = System.currentTimeMillis();
        this.f32972f.setVisibility(0);
        c(xvVar);
        this.f32973r.c(new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.1
            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c(long j4, int i4) {
                r rVar = r.this;
                rVar.c(rVar.f32972f, r.this.f32977c);
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c(long j4, long j5) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void w(long j4, int i4) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c() {
                r rVar = r.this;
                if (rVar.sr != null) {
                    rVar.sr();
                    r.this.sr.w();
                    com.bytedance.sdk.openadsdk.core.a.xv.w(r.this.xv, "splash_ad", "close_splash_icon");
                }
            }
        });
        if (cVar != null) {
            this.ux.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    r.this.sr();
                    cVar.w();
                    com.bytedance.sdk.openadsdk.core.a.xv.w(r.this.xv, "splash_ad", "close_splash_icon");
                    r.this.xv();
                }
            });
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar) {
        boolean fz = xvVar != null ? xvVar.fz() : true;
        this.f32973r = new com.bytedance.sdk.openadsdk.core.video.nativevideo.xv(this.f32977c, this.f32972f, this.xv, "splash_ad", false, false, false);
        com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(3, this.xv);
        c4.w(this.xv.jr());
        c4.w(this.f32972f.getWidth());
        c4.xv(this.f32972f.getHeight());
        c4.xv(this.xv.cf());
        c4.w(fz);
        if (xvVar == null) {
            c4.c(0L);
        } else {
            c4.c(xvVar.k());
        }
        String c5 = p.c(this.xv.ou());
        if (this.xv.ps()) {
            c5 = com.bytedance.sdk.openadsdk.n.ev.c();
        }
        c4.c(c5);
        this.f32973r.c(c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ViewGroup viewGroup, Context context) {
        String bk = oo.bk(this.xv);
        int t3 = oo.t(this.xv);
        if (this.sr == null) {
            return;
        }
        if (!TextUtils.isEmpty(bk) && t3 > 0) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar = this.f32973r;
            if (xvVar != null) {
                xvVar.p();
            }
            viewGroup.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ImageView imageView = new ImageView(this.f32977c);
            imageView.setLayoutParams(layoutParams);
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.xv)).c(imageView);
            viewGroup.addView(imageView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setText(bk);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setLayoutParams(layoutParams2);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            viewGroup.addView(textView);
            this.sr.c(t3);
            return;
        }
        this.sr.c(0L);
    }
}
