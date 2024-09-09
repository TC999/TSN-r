package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    protected int f32466a = 3;

    /* renamed from: c  reason: collision with root package name */
    protected final String f32467c;
    protected RelativeLayout ev;

    /* renamed from: f  reason: collision with root package name */
    protected final boolean f32468f;
    protected FrameLayout gd;

    /* renamed from: k  reason: collision with root package name */
    protected RelativeLayout f32469k;

    /* renamed from: p  reason: collision with root package name */
    protected TextView f32470p;

    /* renamed from: r  reason: collision with root package name */
    protected ViewGroup f32471r;
    protected final int sr;
    protected final float ux;

    /* renamed from: w  reason: collision with root package name */
    protected final TTBaseVideoActivity f32472w;
    protected final me xv;

    public w(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        this.f32472w = tTBaseVideoActivity;
        this.xv = meVar;
        this.sr = meVar.fh();
        this.ux = meVar.yx();
        this.f32468f = z3;
        this.f32467c = z3 ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public FrameLayout a() {
        return this.gd;
    }

    public RelativeLayout bk() {
        return this.ev;
    }

    public void c() {
        ViewGroup viewGroup = (ViewGroup) this.f32472w.findViewById(2114387959);
        this.f32471r = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
    }

    public void c(DownloadListener downloadListener) {
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
    }

    public void f(int i4) {
        xk.c((View) this.ev, i4);
    }

    public void fp() {
        me meVar = this.xv;
        String ez = meVar != null ? meVar.ez() : null;
        if (this.f32470p == null || !TextUtils.isEmpty(ez)) {
            return;
        }
        this.f32470p.setBackground(i.xv(this.f32472w, "tt_ad_logo_backup"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (this.f32468f) {
            int bm = this.xv.bm();
            this.f32466a = bm;
            if (bm == -200) {
                com.bytedance.sdk.openadsdk.core.z.r w3 = ls.w();
                this.f32466a = w3.ys(wv.gd(this.xv) + "");
            }
            if (this.f32466a == -1) {
                xk.c((View) this.ev, 0);
            }
        }
    }

    public void p() {
    }

    public void sr(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return wv.ys(this.xv);
    }

    public void ux(int i4) {
        xk.c((View) this.f32470p, i4);
    }

    public void w(int i4) {
    }

    public void xv(int i4) {
    }

    public void xv(boolean z3) {
        this.f32472w.wv().getWidgetFrameContainer().setVisibility(z3 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String ys() {
        return wv.fp(this.xv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ImageView imageView) {
        List<gb> nc = this.xv.nc();
        if (nc == null || nc.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.w.c(nc.get(0)).c(imageView);
    }
}
