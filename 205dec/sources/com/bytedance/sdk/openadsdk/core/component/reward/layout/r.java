package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w {
    private ImageView bk;
    private TextView fp;
    private TextView ia;

    /* renamed from: t  reason: collision with root package name */
    private TTRoundRectImageView f32448t;
    private TextView ys;

    public r(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
    }

    private float f() {
        return xk.sr(this.f32472w, xk.p((Context) this.f32472w));
    }

    private void sr() {
        this.f32469k = (RelativeLayout) this.f32472w.findViewById(2114387847);
        if (ba.c(this.xv)) {
            String ev = ba.ev(this.xv);
            if (TextUtils.isEmpty(ev)) {
                return;
            }
            com.bytedance.sdk.openadsdk.r.w.c(ev).c(Bitmap.Config.ARGB_4444).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.r.2
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(k<Bitmap> kVar) {
                    Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(r.this.f32472w, kVar.xv(), 25);
                    if (c4 == null) {
                        return;
                    }
                    r.this.f32471r.setBackground(new BitmapDrawable(r.this.f32472w.getResources(), c4));
                }
            });
        }
    }

    private float ux() {
        return xk.sr(this.f32472w, xk.gd((Context) this.f32472w));
    }

    private void w() {
        int i4 = (int) (this.ux * 1000.0f);
        if (i4 == 666 || i4 == 1500 || i4 == 1777 || i4 == 562 || i4 == 1000) {
            return;
        }
        c(this.sr == 1 ? 0.562f : 1.777f);
    }

    private void xv() {
        TextView textView;
        this.bk = (ImageView) this.f32472w.findViewById(2114387711);
        this.f32448t = (TTRoundRectImageView) this.f32472w.findViewById(2114387722);
        this.ys = (TextView) this.f32472w.findViewById(2114387701);
        this.fp = (TextView) this.f32472w.findViewById(2114387962);
        this.ia = (TextView) this.f32472w.findViewById(2114387718);
        if (!TextUtils.isEmpty(this.xv.dk()) && (textView = this.fp) != null) {
            textView.setText(this.xv.dk());
        }
        if (ng.bk(this.xv) != null && me.w(this.xv)) {
            xk.c((View) this.bk, 8);
            xk.c((View) this.gd, 0);
        } else {
            c(this.bk);
            xk.c((View) this.bk, 0);
            xk.c((View) this.gd, 8);
        }
        gb kr = this.xv.kr();
        if (kr != null) {
            com.bytedance.sdk.openadsdk.r.w.c(kr).c(this.f32448t);
        }
        TextView textView2 = this.ys;
        if (textView2 != null) {
            textView2.setText(t());
        }
        TextView textView3 = this.ia;
        if (textView3 != null) {
            textView3.setText(ys());
        }
        xk.c((TextView) this.f32472w.findViewById(2114387657), this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.gd = (FrameLayout) this.f32472w.findViewById(2114387920);
        c(this.f32471r);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.xv)) {
            sr();
            return;
        }
        xv();
        w();
    }

    private void c(View view) {
        me meVar = this.xv;
        if (meVar == null || view == null) {
            return;
        }
        final float rw = meVar.rw();
        if (rw <= 0.0f) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.r.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), xk.xv(ls.getContext(), rw));
                }
            });
            view.setClipToOutline(true);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(xk.xv(ls.getContext(), rw));
        view.setBackground(gradientDrawable);
    }

    private void c(float f4) {
        float min;
        float max;
        int max2;
        float ux = ux();
        float f5 = f();
        if (this.sr == 2) {
            min = Math.max(ux, f5);
            max = Math.min(ux, f5);
        } else {
            min = Math.min(ux, f5);
            max = Math.max(ux, f5);
        }
        int min2 = (int) (Math.min(min, max) * this.xv.ee());
        if (this.sr != 2) {
            TTBaseVideoActivity tTBaseVideoActivity = this.f32472w;
            max -= xk.sr(tTBaseVideoActivity, xk.k(tTBaseVideoActivity));
        }
        if (this.sr != 2) {
            float f6 = min2;
            min2 = (int) Math.max((max - (((min - f6) - f6) / f4)) / 2.0f, 0.0f);
            max2 = min2;
        } else {
            float f7 = min2;
            max2 = (int) Math.max((min - (((max - f7) - f7) * f4)) / 2.0f, 0.0f);
        }
        float f8 = min2;
        float f9 = max2;
        try {
            this.f32472w.getWindow().getDecorView().setPadding(xk.ux(this.f32472w, f9), xk.ux(this.f32472w, f8), xk.ux(this.f32472w, f9), xk.ux(this.f32472w, f8));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.xv)) {
            TTBaseVideoActivity tTBaseVideoActivity = this.f32472w;
            me meVar = this.xv;
            String str = this.f32467c;
            final com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(tTBaseVideoActivity, meVar, str, wv.c(str));
            FrameLayout frameLayout = this.gd;
            if (frameLayout != null) {
                TTBaseVideoActivity tTBaseVideoActivity2 = this.f32472w;
                me meVar2 = this.xv;
                String str2 = this.f32467c;
                frameLayout.setOnClickListener(new com.bytedance.sdk.openadsdk.core.w.w(tTBaseVideoActivity2, meVar2, str2, wv.c(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.r.3
                    @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
                    public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("click_live_element", "click_live_feed");
                        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                        cVar.c(view, gdVar);
                    }
                });
            }
        } else {
            c(this.gd, wVar, wVar);
        }
        c(this.bk, wVar, wVar);
        c(this.f32448t, wVar, wVar);
        c(this.ys, wVar, wVar);
        c(this.fp, wVar, wVar);
        c(this.ia, wVar, wVar);
        c(this.f32471r, wVar, wVar);
    }

    private void c(View view, com.bytedance.sdk.openadsdk.core.w.w wVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(wVar);
    }
}
