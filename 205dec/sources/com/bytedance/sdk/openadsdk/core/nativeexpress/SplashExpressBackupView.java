package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SplashExpressBackupView extends BackupView implements xv.InterfaceC0335xv {
    private NativeExpressView bk;
    private TextView fp;
    private com.bytedance.sdk.openadsdk.core.q.c.w fz;

    /* renamed from: i  reason: collision with root package name */
    private xv.InterfaceC0335xv f34044i;
    private Button ia;

    /* renamed from: s  reason: collision with root package name */
    private FrameLayout f34045s;

    /* renamed from: t  reason: collision with root package name */
    private View f34046t;

    /* renamed from: u  reason: collision with root package name */
    private NativeVideoTsView f34047u;
    private GifView ys;

    public SplashExpressBackupView(Context context) {
        super(context);
        this.f33986c = context;
        this.ux = "splash_ad";
    }

    private void a() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) c(this.bk);
        this.f34047u = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.f34047u;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    private void bk() {
        GifView gifView = new GifView(this.f33986c);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        c(gifView, this.f33991w, this.fz);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private boolean ev() {
        me meVar = this.f33991w;
        return meVar != null && meVar.fh() == 2;
    }

    private void f() {
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
        com.bytedance.sdk.component.utils.a.w("SplashExpressBackupView", "image mode: " + this.f33991w.tz());
        c(this.f33991w.tz(), this.f33991w);
    }

    private void gd() {
        t();
        this.ys.setVisibility(0);
        this.f34045s.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.ys.getLayoutParams();
        layoutParams.height = xk.ux(this.f33986c, 291.0f);
        this.ys.setLayoutParams(layoutParams);
        c(this.ys, this.f33991w, this.fz);
        this.fp.setText(this.f33991w.ju());
        if (this.f33991w.gp() != null) {
            xk.c((View) this.ia, 8);
        } else {
            xk.c((View) this.ia, 0);
            this.ia.setText(this.f33991w.dk());
            c((View) this.ia, true);
        }
        setExpressBackupListener(this.f34046t);
    }

    private void k() {
        t();
        this.ys.setVisibility(8);
        this.f34045s.setVisibility(0);
        if (ng.bk(this.f33991w) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) c(this.bk);
            this.f34047u = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.f34047u == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f34045s.addView(this.f34047u, layoutParams);
        }
        this.fp.setText(this.f33991w.ju());
        if (this.f33991w.gp() != null) {
            xk.c((View) this.ia, 8);
        } else {
            xk.c((View) this.ia, 0);
            this.ia.setText(this.f33991w.dk());
            c((View) this.ia, true);
        }
        setExpressBackupListener(this.f34046t);
    }

    private void p() {
        t();
        this.ys.setVisibility(0);
        this.f34045s.setVisibility(8);
        c(this.ys, this.f33991w, this.fz);
        this.fp.setText(this.f33991w.ju());
        if (this.f33991w.gp() != null) {
            xk.c((View) this.ia, 8);
        } else {
            xk.c((View) this.ia, 0);
            this.ia.setText(this.f33991w.dk());
            c((View) this.ia, true);
        }
        setExpressBackupListener(this.f34046t);
    }

    private boolean r() {
        NativeExpressView nativeExpressView = this.bk;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z3 = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private void setExpressBackupListener(View view) {
        me meVar = this.f33991w;
        if (meVar == null || meVar.xu() != 1) {
            return;
        }
        c(view, true);
    }

    private void t() {
        View c4 = c(this.f33986c);
        if (c4 == null) {
            return;
        }
        addView(c4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void C_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void D_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void E_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void F_() {
        xv.InterfaceC0335xv interfaceC0335xv = this.f34044i;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.F_();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void c(long j4, long j5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
        NativeExpressView nativeExpressView = this.bk;
        if (nativeExpressView != null) {
            nativeExpressView.c(view, i4, uVar);
        }
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.f34047u;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    public void setVideoAdListener(xv.InterfaceC0335xv interfaceC0335xv) {
        this.f34044i = interfaceC0335xv;
    }

    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, me meVar, NativeExpressView nativeExpressView) {
        this.f33991w = meVar;
        this.bk = nativeExpressView;
        this.f33987f = xk.ux(this.f33986c, nativeExpressView.getExpectExpressWidth());
        this.f33990r = xk.ux(this.f33986c, this.bk.getExpectExpressWidth());
        this.fz = wVar;
        f();
        this.bk.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void c(int i4, me meVar) {
        if (!r()) {
            if (i4 != 5) {
                a();
                return;
            } else {
                k();
                return;
            }
        }
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        bk();
                        return;
                    }
                }
            }
            if (ev()) {
                bk();
                return;
            } else {
                p();
                return;
            }
        }
        gd();
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackground(com.bytedance.sdk.component.utils.i.xv(context, "tt_splash_ad_backup_bg"));
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = xk.ux(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.i.c(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.fp = textView2;
        textView2.setId(2114387470);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = xk.ux(context, 31.0f);
        layoutParams3.gravity = 1;
        this.fp.setLayoutParams(layoutParams3);
        this.fp.setGravity(1);
        this.fp.setTextSize(2, 15.0f);
        this.fp.setTextColor(Color.parseColor("#895434"));
        this.fp.setSingleLine(false);
        linearLayout.addView(this.fp);
        GifView gifView = new GifView(context);
        this.ys = gifView;
        gifView.setId(2114387469);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = xk.ux(context, 29.0f);
        layoutParams4.setMarginStart(xk.ux(context, 15.0f));
        layoutParams4.setMarginEnd(xk.ux(context, 15.0f));
        layoutParams4.gravity = 1;
        this.ys.setLayoutParams(layoutParams4);
        this.ys.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.ys);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f34045s = frameLayout;
        frameLayout.setId(2114387468);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(xk.ux(context, 15.0f));
        layoutParams5.setMarginEnd(xk.ux(context, 15.0f));
        this.f34045s.setLayoutParams(layoutParams5);
        this.f34045s.setVisibility(8);
        linearLayout.addView(this.f34045s);
        Button button = new Button(context);
        this.ia = button;
        button.setId(2114387467);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = xk.ux(context, 37.0f);
        layoutParams6.gravity = 1;
        this.ia.setLayoutParams(layoutParams6);
        this.ia.setText(com.bytedance.sdk.component.utils.i.c(context, "tt_splash_backup_ad_btn"));
        this.ia.setTextColor(Color.parseColor("#ffffff"));
        this.ia.setTypeface(Typeface.defaultFromStyle(1));
        this.ia.setBackground(com.bytedance.sdk.component.utils.i.xv(context, "tt_splash_ad_backup_btn_bg"));
        linearLayout.addView(this.ia);
        return linearLayout;
    }

    private void c(GifView gifView) {
        gb gbVar = this.f33991w.nc().get(0);
        if (gbVar != null) {
            com.bytedance.sdk.openadsdk.r.w.c(gbVar).c(gifView);
        }
    }

    void c(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.c(bArr, false);
    }

    void c(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    void c(GifView gifView, me meVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar) {
        Drawable c4;
        if (wVar == null) {
            c(gifView);
        } else if (wVar.ux()) {
            c(wVar.xv(), gifView);
        } else if (meVar.nc() == null || meVar.nc().get(0) == null) {
        } else {
            if (wVar.c() != null) {
                c4 = new BitmapDrawable(wVar.c());
            } else {
                c4 = com.bytedance.sdk.openadsdk.core.eq.fp.c(wVar.xv(), meVar.nc().get(0).w());
            }
            c(c4, gifView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void c(View view, boolean z3) {
        me meVar = this.f33991w;
        if (meVar == null || meVar.gp() == null || this.f33991w.gp().c() != 1) {
            return;
        }
        super.c(view, z3);
    }
}
