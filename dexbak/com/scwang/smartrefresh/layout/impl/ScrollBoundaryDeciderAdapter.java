package com.scwang.smartrefresh.layout.impl;

import android.view.MotionEvent;
import android.view.View;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import p638r0.ScrollBoundaryDecider;

/* renamed from: com.scwang.smartrefresh.layout.impl.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {

    /* renamed from: a */
    protected MotionEvent f33706a;

    /* renamed from: b */
    protected ScrollBoundaryDecider f33707b;

    /* renamed from: c */
    protected boolean f33708c;

    @Override // p638r0.ScrollBoundaryDecider
    /* renamed from: a */
    public boolean mo2014a(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.f33707b;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.mo2014a(view);
        }
        return ScrollBoundaryUtil.m19762b(view, this.f33706a);
    }

    @Override // p638r0.ScrollBoundaryDecider
    /* renamed from: b */
    public boolean mo2013b(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.f33707b;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.mo2013b(view);
        }
        if (this.f33708c) {
            return !ScrollBoundaryUtil.m19760d(view, this.f33706a);
        }
        return ScrollBoundaryUtil.m19763a(view, this.f33706a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m19837c(MotionEvent motionEvent) {
        this.f33706a = motionEvent;
    }

    /* renamed from: d */
    public void m19836d(boolean z) {
        this.f33708c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m19835e(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.f33707b = scrollBoundaryDecider;
    }
}
