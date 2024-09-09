package com.bytedance.sdk.openadsdk.core.component.reward.c.w;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.bk;
import com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;
import com.bytedance.sdk.openadsdk.core.component.reward.k;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.yu;
import com.bytedance.sdk.openadsdk.core.widget.r;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements c {

    /* renamed from: c  reason: collision with root package name */
    private final c.InterfaceC0477c f32249c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private int f32250f;

    /* renamed from: w  reason: collision with root package name */
    private r f32255w;
    private final AtomicBoolean xv = new AtomicBoolean(false);
    private final AtomicBoolean sr = new AtomicBoolean(false);
    private final AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private int f32253r = 0;
    private boolean gd = true;

    /* renamed from: p  reason: collision with root package name */
    private String f32252p = "";

    /* renamed from: k  reason: collision with root package name */
    private String f32251k = "";

    /* renamed from: a  reason: collision with root package name */
    private String f32248a = "";
    private String bk = "";

    /* renamed from: t  reason: collision with root package name */
    private String f32254t = "";

    public w(c.InterfaceC0477c interfaceC0477c) {
        this.f32249c = interfaceC0477c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        try {
            this.xv.set(true);
            String sr = yu.sr(this.f32249c.c());
            if (TextUtils.isEmpty(sr)) {
                sr = String.valueOf(this.f32250f);
            }
            if (TextUtils.isEmpty(sr)) {
                sr = String.valueOf(wv.gd(this.f32249c.c()));
            }
            k.c(this.f32249c.getActivity()).c(k.c(this.f32249c.getActivity()).w(sr), yu.xv(this.f32249c.c()), this.f32253r, new com.bytedance.sdk.openadsdk.fz.c.w.c.r(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.3
                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
                public void onError(int i4, String str) {
                    f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.this.xv("\u5f53\u524d\u65e0\u65b0\u89c6\u9891\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
                            w.this.xv.set(false);
                            if (w.this.f32255w != null) {
                                w.this.f32255w.c();
                            }
                            w.this.f32249c.c(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
                public void onRewardVideoAdLoad(final fp fpVar) {
                    f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fp fpVar2 = fpVar;
                            if (fpVar2 instanceof bk) {
                                bk bkVar = (bk) fpVar2;
                                bkVar.xv(true);
                                bkVar.c(w.this.f32250f);
                                bkVar.w(w.this.f32253r + 1);
                                bkVar.xv(w.this.f32249c.w());
                                if (!TextUtils.isEmpty(w.this.f32252p) && !TextUtils.isEmpty(w.this.f32251k)) {
                                    bkVar.w(w.this.f32251k);
                                    bkVar.c(w.this.f32252p);
                                }
                                bkVar.sr(w.this.ev);
                                bkVar.c(w.this.f32249c.getActivity());
                                w.this.f32249c.ux();
                                w.this.sr.set(true);
                            } else {
                                w.this.xv("\u5f53\u524d\u65e0\u65b0\u89c6\u9891\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
                                w.this.xv.set(false);
                            }
                            if (w.this.f32255w != null) {
                                w.this.f32255w.c();
                            }
                            w.this.f32249c.c(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
                public void onRewardVideoCached() {
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.r
                public void onRewardVideoCached(fp fpVar) {
                }
            });
        } catch (Throwable unused) {
            this.xv.set(false);
            xv("\u5f53\u524d\u65e0\u65b0\u89c6\u9891\uff0c\u8bf7\u9000\u51fa\u540e\u91cd\u8bd5");
            r rVar = this.f32255w;
            if (rVar != null) {
                rVar.c();
            }
        }
    }

    private boolean gd() {
        if (yu.w(this.f32249c.c())) {
            if (this.xv.get()) {
                return true;
            }
            p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void c() {
                    if (w.this.xv.get()) {
                        return;
                    }
                    if (w.this.f32255w != null) {
                        r rVar = w.this.f32255w;
                        w wVar = w.this;
                        rVar.c(wVar.c(wVar.f32249c.getActivity()));
                    }
                    w.this.ev();
                    xv.c(w.this.f32249c.c(), "reward_endcard", "reward_again", "popup");
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void w() {
                    if (w.this.xv.get()) {
                        return;
                    }
                    xv.c(w.this.f32249c.c(), "reward_endcard", "popup_cancel", (String) null);
                    w.this.f32249c.xv();
                }
            };
            com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.w(this.f32249c.getActivity(), this.f32249c.c());
            wVar.sr(this.f32252p);
            wVar.xv(this.f32251k);
            wVar.c(this.f32254t);
            this.f32249c.sr();
            return wVar.c(pVar).xv();
        }
        return false;
    }

    private void p() {
        if (eq.f33190w < 4640) {
            return;
        }
        ev.w(new com.bytedance.sdk.component.gd.p("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(5)).w(yu.w(w.this.f32249c.w()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public String f() {
        return this.f32248a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public String r() {
        return this.bk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void sr() {
        c.InterfaceC0477c interfaceC0477c = this.f32249c;
        if (interfaceC0477c == null || interfaceC0477c.getActivity() == null || this.f32249c.c() == null || !yu.c(this.f32249c.c())) {
            return;
        }
        if (!this.ev) {
            boolean z3 = this.f32253r == 0;
            this.f32249c.c(z3, null, null);
            this.gd = z3;
            return;
        }
        this.gd = false;
        this.f32249c.c(false, this.f32252p, this.f32251k);
        final int i4 = this.f32253r + 1;
        if (eq.f33190w < 4640) {
            return;
        }
        ev.w(new com.bytedance.sdk.component.gd.p("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ia c4 = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(5));
                    Bundle bundle = new Bundle();
                    bundle.putInt("callback_extra_key_next_play_again_count", i4);
                    w.this.c(c4.w(yu.w(w.this.f32249c.w()), "getPlayAgainCondition", bundle));
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public boolean ux() {
        r rVar = this.f32255w;
        if (rVar == null) {
            return false;
        }
        return rVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void w(boolean z3) {
        this.ev = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public boolean xv(int i4) {
        c.InterfaceC0477c interfaceC0477c = this.f32249c;
        if (interfaceC0477c == null || interfaceC0477c.getActivity() == null || this.f32249c.c() == null || this.xv.get() || !this.gd) {
            return false;
        }
        if (i4 == 1) {
            c.InterfaceC0477c interfaceC0477c2 = this.f32249c;
            interfaceC0477c2.c(0, c(interfaceC0477c2.getActivity()));
            ev();
            xv.c(this.f32249c.c(), "reward_endcard", "reward_again", CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        } else if (i4 == 2) {
            return gd();
        } else {
            if (i4 == 3) {
                c.InterfaceC0477c interfaceC0477c3 = this.f32249c;
                interfaceC0477c3.c(0, c(interfaceC0477c3.getActivity()));
                ev();
                xv.c(this.f32249c.c(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void w(int i4) {
        this.f32250f = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public boolean w() {
        return this.sr.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void c(boolean z3) {
        this.ux.set(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void w(String str) {
        this.bk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void c(int i4) {
        this.f32253r = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public boolean c() {
        return this.ux.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void c(String str) {
        this.f32248a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        boolean z3 = bundle.getBoolean("play_again_allow");
        this.f32252p = bundle.getString("play_again_reward_name");
        this.f32251k = bundle.getString("play_again_reward_amount");
        this.f32254t = bundle.getString("extra_info");
        this.gd = z3;
        if (z3) {
            f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.this.f32249c.c(true, w.this.f32252p, w.this.f32251k);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c
    public void xv() {
        r rVar = this.f32255w;
        if (rVar != null) {
            rVar.dismiss();
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTProgressBar c(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(xk.ux(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int ux = xk.ux(context, 10.0f);
        tTProgressBar.setPadding(ux, ux, ux, ux);
        tTProgressBar.setIndeterminateDrawable(i.xv(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(final String str) {
        c.InterfaceC0477c interfaceC0477c = this.f32249c;
        if (interfaceC0477c == null || interfaceC0477c.getActivity() == null) {
            return;
        }
        f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.w.5
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(w.this.f32249c.getActivity(), str, 0).show();
            }
        });
    }
}
