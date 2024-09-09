package com.bytedance.sdk.openadsdk.core.component.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ux.sr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.ys.w.xv {

    /* renamed from: c  reason: collision with root package name */
    private boolean f32118c;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c ev;

    /* renamed from: f  reason: collision with root package name */
    private final Context f32119f;

    /* renamed from: r  reason: collision with root package name */
    private final me f32120r;
    private com.bytedance.sdk.openadsdk.u.c.w.c.c sr;
    private xv ux;

    /* renamed from: w  reason: collision with root package name */
    private Bitmap f32121w;
    private int xv;

    public w(Context context, me meVar, int i4, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(new xv(context, meVar, i4, wVar));
        this.ev = new com.bytedance.sdk.openadsdk.j.c.w.c.c(null) { // from class: com.bytedance.sdk.openadsdk.core.component.c.w.3
            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdClicked(View view, t tVar) {
                NativeVideoTsView n4 = w.this.ux.n();
                if (n4 != null) {
                    n4.gd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdCreativeClick(View view, t tVar) {
                NativeVideoTsView n4 = w.this.ux.n();
                if (n4 != null) {
                    n4.gd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdShow(t tVar) {
                NativeVideoTsView n4 = w.this.ux.n();
                if (n4 != null) {
                    n4.s();
                }
            }
        };
        xv xvVar = (xv) n();
        this.ux = xvVar;
        this.f32120r = meVar;
        this.f32119f = context;
        ((com.bytedance.sdk.openadsdk.core.i.c) xvVar.me()).c(this.ev);
    }

    private void ck() {
        int i4 = this.xv;
        if (i4 >= 200) {
            this.xv = 200;
        } else if (i4 <= 20) {
            this.xv = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public ux gb() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv, com.bytedance.sdk.openadsdk.ys.w.w.t
    public View i() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        if (this.f32120r != null && this.f32119f != null) {
            if (this.ux.y()) {
                try {
                    nativeDrawVideoTsView = new NativeDrawVideoTsView(this.f32119f, this.f32120r);
                    this.ux.c(nativeDrawVideoTsView);
                    nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.xv() { // from class: com.bytedance.sdk.openadsdk.core.component.c.w.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xv
                        public void c(boolean z3, long j4, long j5, long j6, boolean z4, boolean z5) {
                            w.this.ux.f32126c.f33977c = z3;
                            w.this.ux.f32126c.ux = j4;
                            w.this.ux.f32126c.f33978f = j5;
                            w.this.ux.f32126c.f33979r = j6;
                            w.this.ux.f32126c.sr = z4;
                            w.this.ux.f32126c.ev = z5;
                        }
                    });
                    nativeDrawVideoTsView.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.c.w.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.c
                        public void c(View view, int i4) {
                            j xv = ((com.bytedance.sdk.openadsdk.core.i.c) w.this.ux.me()).xv();
                            if (xv != null) {
                                xv.c(view, i4);
                            }
                        }
                    });
                    nativeDrawVideoTsView.setVideoAdLoadListener(this.ux);
                    nativeDrawVideoTsView.setVideoAdInteractionListener(this.ux);
                    int gd = wv.gd(this.f32120r);
                    nativeDrawVideoTsView.setIsAutoPlay(c(gd));
                    nativeDrawVideoTsView.setIsQuiet(ls.w().sr(gd));
                    nativeDrawVideoTsView.setCanInterruptVideoPlay(this.f32118c);
                    Bitmap bitmap = this.f32121w;
                    if (bitmap != null) {
                        nativeDrawVideoTsView.c(bitmap, this.xv);
                    }
                    nativeDrawVideoTsView.setDrawVideoListener(this.sr);
                } catch (Exception unused) {
                }
                sr.c().c(this.f32120r).c(this.ux.ck()).w(this.ux.z());
                if (!this.ux.y() && nativeDrawVideoTsView != null && nativeDrawVideoTsView.c(0L, true, false)) {
                    return nativeDrawVideoTsView;
                }
            }
            nativeDrawVideoTsView = null;
            sr.c().c(this.f32120r).c(this.ux.ck()).w(this.ux.z());
            if (!this.ux.y()) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv, com.bytedance.sdk.openadsdk.ys.w.w.t
    public void ls() {
        super.ls();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        View i4;
        try {
            c(viewGroup, (List<View>) null, list, list2, list3, (View) null, cVar);
            if (srVar != null) {
                View findViewById = viewGroup.findViewById(srVar.a());
                if (findViewById != null && f() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(f());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = xk.ux(viewGroup.getContext(), 38.0f);
                        layoutParams.height = xk.ux(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(f());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(srVar.r());
                if (frameLayout == null || (i4 = i()) == null) {
                    return;
                }
                xk.ev(i4);
                frameLayout.removeAllViews();
                frameLayout.addView(i4, -1, -1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(boolean z3) {
        this.f32118c = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(Bitmap bitmap, int i4) {
        this.f32121w = bitmap;
        this.xv = i4;
        ck();
    }

    private boolean c(int i4) {
        int r3 = ls.w().r(i4);
        if (3 == r3) {
            return false;
        }
        if (1 == r3 && ys.sr(this.f32119f)) {
            return true;
        }
        if (2 == r3) {
            if (ys.ux(this.f32119f) || ys.sr(this.f32119f)) {
                return true;
            }
            ys.f(this.f32119f);
            return true;
        } else if (5 != r3 || ys.sr(this.f32119f)) {
            return true;
        } else {
            ys.f(this.f32119f);
            return true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.p
    public void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
        this.sr = cVar;
    }
}
