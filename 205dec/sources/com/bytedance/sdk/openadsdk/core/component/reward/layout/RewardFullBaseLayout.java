package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardFullBaseLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    protected TTProgressBar f32411c;
    private FrameLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f32412f;

    /* renamed from: r  reason: collision with root package name */
    private FrameLayout f32413r;
    private FrameLayout sr;
    private FrameLayout ux;

    /* renamed from: w  reason: collision with root package name */
    protected TTProgressBar f32414w;
    private FrameLayout xv;

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    private FrameLayout sr() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout w() {
        FrameLayout sr = sr();
        this.ux = sr;
        return sr;
    }

    private FrameLayout xv() {
        FrameLayout sr = sr();
        this.f32412f = sr;
        return sr;
    }

    public void c(com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar) {
        FrameLayout sr = sr();
        sr.addView(c());
        sr.addView(w());
        sr.addView(xv());
        addView(sr);
        this.xv.addView(cVar.gd());
        this.ux.addView(cVar.p());
        this.f32412f.addView(cVar.k());
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.ux;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.sr;
    }

    public FrameLayout getSceneFrame() {
        return this.f32413r;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.ev;
    }

    public FrameLayout getTopFrameContainer() {
        return this.f32412f;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.xv;
    }

    private FrameLayout c() {
        this.ev = sr();
        FrameLayout sr = sr();
        this.f32413r = sr;
        this.ev.addView(sr);
        FrameLayout sr2 = sr();
        this.xv = sr2;
        sr2.setVisibility(8);
        this.f32413r.addView(this.xv);
        FrameLayout sr3 = sr();
        this.sr = sr3;
        sr3.setVisibility(8);
        this.f32413r.addView(this.sr);
        return this.ev;
    }

    public void c(int i4) {
        if (this.f32411c == null) {
            this.f32411c = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.f32411c.setLayoutParams(layoutParams);
            try {
                this.f32411c.setIndeterminateDrawable(i.xv(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.f32411c);
        }
        this.f32411c.setVisibility(i4);
    }

    public void c(int i4, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.f32414w;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.f32414w);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.f32414w = tTProgressBar;
        addView(tTProgressBar);
        this.f32414w.setVisibility(i4);
    }
}
